package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseException;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.grpc.internal.GrpcUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseInstallationServiceClient {
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String API_KEY_HEADER = "x-goog-api-key";
    private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
    private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String FIS_TAG = "Firebase-Installations";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final String USER_AGENT_HEADER = "x-firebase-client";
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final HeartBeatInfo heartbeatInfo;
    private final UserAgentPublisher userAgentPublisher;

    public FirebaseInstallationServiceClient(Context context2, UserAgentPublisher publisher, HeartBeatInfo heartbeatInfo2) {
        this.context = context2;
        this.userAgentPublisher = publisher;
        this.heartbeatInfo = heartbeatInfo2;
    }

    public InstallationResponse createFirebaseInstallation(String apiKey, String fid, String projectID, String appId, String iidToken) throws IOException {
        int retryCount = 0;
        URL url = new URL(String.format("https://%s/%s/%s", new Object[]{FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(CREATE_REQUEST_RESOURCE_NAME_FORMAT, new Object[]{projectID})}));
        while (retryCount <= 1) {
            HttpURLConnection httpURLConnection = openHttpURLConnection(url, apiKey);
            try {
                httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                httpURLConnection.setDoOutput(true);
                if (iidToken != null) {
                    httpURLConnection.addRequestProperty(X_ANDROID_IID_MIGRATION_KEY, iidToken);
                }
                writeFIDCreateRequestBodyToOutputStream(httpURLConnection, fid, appId);
                int httpResponseCode = httpURLConnection.getResponseCode();
                if (httpResponseCode == 200) {
                    InstallationResponse readCreateResponse = readCreateResponse(httpURLConnection);
                    httpURLConnection.disconnect();
                    return readCreateResponse;
                }
                logFisCommunicationError(httpURLConnection, appId, apiKey, projectID);
                if (httpResponseCode != 429) {
                    if (httpResponseCode < 500 || httpResponseCode >= 600) {
                        logBadConfigError();
                        InstallationResponse build = InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                        httpURLConnection.disconnect();
                        return build;
                    }
                }
                retryCount++;
            } finally {
                httpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String fid, String appId) throws IOException {
        writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildCreateFirebaseInstallationRequestBody(fid, appId)));
    }

    private static byte[] getJsonBytes(JSONObject jsonObject) throws IOException {
        return jsonObject.toString().getBytes(Key.STRING_CHARSET_NAME);
    }

    private static void writeRequestBodyToOutputStream(URLConnection urlConnection, byte[] jsonBytes) throws IOException {
        OutputStream outputStream = urlConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
            try {
                gzipOutputStream.write(jsonBytes);
            } finally {
                try {
                    gzipOutputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String fid, String appId) {
        try {
            JSONObject firebaseInstallationData = new JSONObject();
            firebaseInstallationData.put("fid", fid);
            firebaseInstallationData.put("appId", appId);
            firebaseInstallationData.put("authVersion", FIREBASE_INSTALLATION_AUTH_VERSION);
            firebaseInstallationData.put("sdkVersion", "a:16.3.2");
            return firebaseInstallationData;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() {
        try {
            JSONObject sdkVersionData = new JSONObject();
            sdkVersionData.put("sdkVersion", "a:16.3.2");
            JSONObject firebaseInstallationData = new JSONObject();
            firebaseInstallationData.put("installation", sdkVersionData);
            return firebaseInstallationData;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public void deleteFirebaseInstallation(String apiKey, String fid, String projectID, String refreshToken) throws FirebaseException, IOException {
        URL url = new URL(String.format("https://%s/%s/%s", new Object[]{FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(DELETE_REQUEST_RESOURCE_NAME_FORMAT, new Object[]{projectID, fid})}));
        int retryCount = 0;
        while (retryCount <= 1) {
            HttpURLConnection httpURLConnection = openHttpURLConnection(url, apiKey);
            try {
                httpURLConnection.setRequestMethod("DELETE");
                httpURLConnection.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + refreshToken);
                int httpResponseCode = httpURLConnection.getResponseCode();
                if (!(httpResponseCode == 200 || httpResponseCode == 401)) {
                    if (httpResponseCode != 404) {
                        logFisCommunicationError(httpURLConnection, (String) null, apiKey, projectID);
                        if (httpResponseCode != 429) {
                            if (httpResponseCode < 500 || httpResponseCode >= 600) {
                                logBadConfigError();
                                throw new FirebaseInstallationsException("Bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
                            }
                        }
                        retryCount++;
                    }
                }
                httpURLConnection.disconnect();
                return;
            } finally {
                httpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }

    public TokenResult generateAuthToken(String apiKey, String fid, String projectID, String refreshToken) throws IOException {
        int retryCount = 0;
        URL url = new URL(String.format("https://%s/%s/%s", new Object[]{FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, String.format(GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT, new Object[]{projectID, fid})}));
        while (retryCount <= 1) {
            HttpURLConnection httpURLConnection = openHttpURLConnection(url, apiKey);
            try {
                httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                httpURLConnection.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + refreshToken);
                writeGenerateAuthTokenRequestBodyToOutputStream(httpURLConnection);
                int httpResponseCode = httpURLConnection.getResponseCode();
                if (httpResponseCode == 200) {
                    TokenResult readGenerateAuthTokenResponse = readGenerateAuthTokenResponse(httpURLConnection);
                    httpURLConnection.disconnect();
                    return readGenerateAuthTokenResponse;
                }
                logFisCommunicationError(httpURLConnection, (String) null, apiKey, projectID);
                if (httpResponseCode != 401) {
                    if (httpResponseCode != 404) {
                        if (httpResponseCode != 429) {
                            if (httpResponseCode < 500 || httpResponseCode >= 600) {
                                logBadConfigError();
                                TokenResult build = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.BAD_CONFIG).build();
                                httpURLConnection.disconnect();
                                return build;
                            }
                        }
                        retryCount++;
                    }
                }
                TokenResult build2 = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
                httpURLConnection.disconnect();
                return build2;
            } finally {
                httpURLConnection.disconnect();
            }
        }
        throw new IOException();
    }

    private static void logBadConfigError() {
        Log.e(FIS_TAG, "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private HttpURLConnection openHttpURLConnection(URL url, String apiKey) throws IOException {
        HeartBeatInfo.HeartBeat heartbeat;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(NETWORK_TIMEOUT_MILLIS);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setReadTimeout(NETWORK_TIMEOUT_MILLIS);
        httpURLConnection.addRequestProperty("Content-Type", JSON_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Accept", JSON_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", GZIP_CONTENT_ENCODING);
        httpURLConnection.addRequestProperty("Cache-Control", CACHE_CONTROL_DIRECTIVE);
        httpURLConnection.addRequestProperty(X_ANDROID_PACKAGE_HEADER_KEY, this.context.getPackageName());
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo;
        if (!(heartBeatInfo == null || this.userAgentPublisher == null || (heartbeat = heartBeatInfo.getHeartBeatCode(FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG)) == HeartBeatInfo.HeartBeat.NONE)) {
            httpURLConnection.addRequestProperty(USER_AGENT_HEADER, this.userAgentPublisher.getUserAgent());
            httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, Integer.toString(heartbeat.getCode()));
        }
        httpURLConnection.addRequestProperty(X_ANDROID_CERT_HEADER_KEY, getFingerprintHashForPackage());
        httpURLConnection.addRequestProperty(API_KEY_HEADER, apiKey);
        return httpURLConnection;
    }

    private InstallationResponse readCreateResponse(HttpURLConnection conn) throws IOException {
        InputStream inputStream = conn.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        TokenResult.Builder tokenResult = TokenResult.builder();
        InstallationResponse.Builder builder = InstallationResponse.builder();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                builder.setUri(reader.nextString());
            } else if (name.equals("fid")) {
                builder.setFid(reader.nextString());
            } else if (name.equals("refreshToken")) {
                builder.setRefreshToken(reader.nextString());
            } else if (name.equals("authToken")) {
                reader.beginObject();
                while (reader.hasNext()) {
                    String key = reader.nextName();
                    if (key.equals("token")) {
                        tokenResult.setToken(reader.nextString());
                    } else if (key.equals("expiresIn")) {
                        tokenResult.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(reader.nextString()));
                    } else {
                        reader.skipValue();
                    }
                }
                builder.setAuthToken(tokenResult.build());
                reader.endObject();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        reader.close();
        inputStream.close();
        return builder.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    private TokenResult readGenerateAuthTokenResponse(HttpURLConnection conn) throws IOException {
        InputStream inputStream = conn.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("token")) {
                builder.setToken(reader.nextString());
            } else if (name.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(reader.nextString()));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        reader.close();
        inputStream.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    private String getFingerprintHashForPackage() {
        try {
            byte[] hash = AndroidUtilsLight.getPackageCertificateHashBytes(this.context, this.context.getPackageName());
            if (hash != null) {
                return Hex.bytesToStringUppercase(hash, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.context.getPackageName(), e);
            return null;
        }
    }

    static long parseTokenExpirationTimestamp(String expiresIn) {
        Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(expiresIn).matches(), PARSING_EXPIRATION_TIME_ERROR_MESSAGE);
        if (expiresIn == null || expiresIn.length() == 0) {
            return 0;
        }
        return Long.parseLong(expiresIn.substring(0, expiresIn.length() - 1));
    }

    private static void logFisCommunicationError(HttpURLConnection conn, String appId, String apiKey, String projectId) {
        String logString = readErrorResponse(conn);
        if (!TextUtils.isEmpty(logString)) {
            Log.w(FIS_TAG, logString);
            Log.w(FIS_TAG, availableFirebaseOptions(appId, apiKey, projectId));
        }
    }

    private static String availableFirebaseOptions(String appId, String apiKey, String projectId) {
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = apiKey;
        objArr[1] = projectId;
        if (TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = ", " + appId;
        }
        objArr[2] = str;
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr);
    }

    private static String readErrorResponse(HttpURLConnection conn) {
        InputStream errorStream = conn.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
        try {
            StringBuilder response = new StringBuilder();
            for (String input = reader.readLine(); input != null; input = reader.readLine()) {
                response.append(input);
                response.append(10);
            }
            String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", new Object[]{Integer.valueOf(conn.getResponseCode()), conn.getResponseMessage(), response});
            try {
                reader.close();
            } catch (IOException e) {
            }
            return format;
        } catch (IOException e2) {
            try {
                reader.close();
            } catch (IOException e3) {
            }
            return null;
        } catch (Throwable th) {
            try {
                reader.close();
            } catch (IOException e4) {
            }
            throw th;
        }
    }
}

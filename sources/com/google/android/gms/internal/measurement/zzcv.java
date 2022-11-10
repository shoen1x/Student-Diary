package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzcv {
    public static zzdr<zzcs> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzdr.zzc();
        }
        if (zzcg.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzdr<File> zzb = zzb(context);
        if (zzb.zza()) {
            return zzdr.zza(zza(zzb.zzb()));
        }
        return zzdr.zzc();
    }

    private static zzdr<File> zzb(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? zzdr.zza(file) : zzdr.zzc();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return zzdr.zzc();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzcs zza(File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            HashMap hashMap = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        String valueOf = String.valueOf(readLine);
                        Log.e("HermeticFileOverrides", valueOf.length() != 0 ? "Invalid: ".concat(valueOf) : new String("Invalid: "));
                    } else {
                        String str = split[0];
                        String decode = Uri.decode(split[1]);
                        String decode2 = Uri.decode(split[2]);
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new HashMap());
                        }
                        ((Map) hashMap.get(str)).put(decode, decode2);
                    }
                } else {
                    String valueOf2 = String.valueOf(file);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 7);
                    sb.append("Parsed ");
                    sb.append(valueOf2);
                    Log.i("HermeticFileOverrides", sb.toString());
                    zzcs zzcs = new zzcs(hashMap);
                    bufferedReader.close();
                    return zzcs;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            zzgd.zza(th, th);
        }
        throw th;
    }
}

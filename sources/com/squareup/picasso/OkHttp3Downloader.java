package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class OkHttp3Downloader implements Downloader {
    private final Cache cache;
    final Call.Factory client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttp3Downloader(File cacheDir) {
        this(cacheDir, Utils.calculateDiskCacheSize(cacheDir));
    }

    public OkHttp3Downloader(Context context, long maxSize) {
        this(Utils.createDefaultCacheDir(context), maxSize);
    }

    public OkHttp3Downloader(File cacheDir, long maxSize) {
        this(new OkHttpClient.Builder().cache(new Cache(cacheDir, maxSize)).build());
        this.sharedClient = false;
    }

    public OkHttp3Downloader(OkHttpClient client2) {
        this.sharedClient = true;
        this.client = client2;
        this.cache = client2.cache();
    }

    public OkHttp3Downloader(Call.Factory client2) {
        this.sharedClient = true;
        this.client = client2;
        this.cache = null;
    }

    public Response load(Request request) throws IOException {
        return this.client.newCall(request).execute();
    }

    public void shutdown() {
        Cache cache2;
        if (!this.sharedClient && (cache2 = this.cache) != null) {
            try {
                cache2.close();
            } catch (IOException e) {
            }
        }
    }
}

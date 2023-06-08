package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzcr implements zzcm {
    private static zzcr zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    static zzcr zza(Context context) {
        zzcr zzcr;
        synchronized (zzcr.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcr(context) : new zzcr();
            }
            zzcr = zza;
        }
        return zzcr;
    }

    private zzcr(Context context) {
        this.zzb = context;
        this.zzc = new zzct(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzcf.zza, true, this.zzc);
    }

    private zzcr() {
        this.zzb = null;
        this.zzc = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcp.zza(new zzcq(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zza() {
        synchronized (zzcr.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzb(String str) {
        return zzcf.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}

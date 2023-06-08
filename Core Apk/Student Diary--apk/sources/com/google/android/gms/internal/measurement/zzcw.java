package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public abstract class zzcw<T> {
    private static final Object zza = new Object();
    @Nullable
    private static volatile zzde zzb = null;
    private static volatile boolean zzc = false;
    private static final AtomicReference<Collection<zzcw<?>>> zzd = new AtomicReference<>();
    private static zzdj zze = new zzdj(zzcy.zza);
    private static final AtomicInteger zzi = new AtomicInteger();
    private final zzdf zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;

    @Deprecated
    public static void zza(Context context) {
        synchronized (zza) {
            zzde zzde = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzde == null || zzde.zza() != context) {
                zzci.zzc();
                zzdh.zza();
                zzcr.zza();
                zzb = new zzcj(context, zzdu.zza(new zzcz(context)));
                zzi.incrementAndGet();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zza() {
        zzi.incrementAndGet();
    }

    private zzcw(zzdf zzdf, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzdf.zzb != null) {
            this.zzf = zzdf;
            this.zzg = str;
            this.zzh = t;
            this.zzl = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzg);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r7 = this;
            boolean r0 = r7.zzl
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.measurement.zzdj r0 = zze
            java.lang.String r1 = r7.zzg
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.android.gms.internal.measurement.zzdq.zzb((boolean) r0, (java.lang.Object) r1)
        L_0x0012:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r7.zzj
            if (r1 >= r0) goto L_0x012b
            monitor-enter(r7)
            int r1 = r7.zzj     // Catch:{ all -> 0x0128 }
            if (r1 >= r0) goto L_0x0126
            com.google.android.gms.internal.measurement.zzde r1 = zzb     // Catch:{ all -> 0x0128 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002a
            r4 = r2
            goto L_0x002b
        L_0x002a:
            r4 = r3
        L_0x002b:
            java.lang.String r5 = "Must call PhenotypeFlag.init() first"
            com.google.android.gms.internal.measurement.zzdq.zzb((boolean) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x0128 }
            android.content.Context r4 = r1.zza()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzcr r4 = com.google.android.gms.internal.measurement.zzcr.zza((android.content.Context) r4)     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x0055
            java.util.regex.Pattern r5 = com.google.android.gms.internal.measurement.zzcf.zzb     // Catch:{ all -> 0x0128 }
            java.util.regex.Matcher r4 = r5.matcher(r4)     // Catch:{ all -> 0x0128 }
            boolean r4 = r4.matches()     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r2 = r3
        L_0x0056:
            r3 = 0
            if (r2 != 0) goto L_0x009f
            com.google.android.gms.internal.measurement.zzdf r2 = r7.zzf     // Catch:{ all -> 0x0128 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x0084
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdf r4 = r7.zzf     // Catch:{ all -> 0x0128 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0128 }
            boolean r2 = com.google.android.gms.internal.measurement.zzcu.zza(r2, r4)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x0082
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0128 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdf r4 = r7.zzf     // Catch:{ all -> 0x0128 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzci r2 = com.google.android.gms.internal.measurement.zzci.zza(r2, r4)     // Catch:{ all -> 0x0128 }
            goto L_0x008d
        L_0x0082:
            r2 = r3
            goto L_0x008d
        L_0x0084:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdh r2 = com.google.android.gms.internal.measurement.zzdh.zza((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0128 }
        L_0x008d:
            if (r2 == 0) goto L_0x009e
            java.lang.String r4 = r7.zzb()     // Catch:{ all -> 0x0128 }
            java.lang.Object r2 = r2.zza(r4)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x009e
            java.lang.Object r2 = r7.zza((java.lang.Object) r2)     // Catch:{ all -> 0x0128 }
            goto L_0x00c9
        L_0x009e:
            goto L_0x00c8
        L_0x009f:
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x00c8
            java.lang.String r2 = "PhenotypeFlag"
            java.lang.String r4 = "Bypass reading Phenotype values for flag: "
            java.lang.String r5 = r7.zzb()     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0128 }
            int r6 = r5.length()     // Catch:{ all -> 0x0128 }
            if (r6 == 0) goto L_0x00bf
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0128 }
            goto L_0x00c5
        L_0x00bf:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0128 }
            r5.<init>(r4)     // Catch:{ all -> 0x0128 }
            r4 = r5
        L_0x00c5:
            android.util.Log.d(r2, r4)     // Catch:{ all -> 0x0128 }
        L_0x00c8:
            r2 = r3
        L_0x00c9:
            if (r2 == 0) goto L_0x00cd
            goto L_0x00f1
        L_0x00cd:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzcr r2 = com.google.android.gms.internal.measurement.zzcr.zza((android.content.Context) r2)     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdf r4 = r7.zzf     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x0128 }
            java.lang.Object r2 = r2.zza(r4)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x00ea
            java.lang.Object r2 = r7.zza((java.lang.Object) r2)     // Catch:{ all -> 0x0128 }
            goto L_0x00eb
        L_0x00ea:
            r2 = r3
        L_0x00eb:
            if (r2 == 0) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            T r2 = r7.zzh     // Catch:{ all -> 0x0128 }
        L_0x00f1:
            com.google.android.gms.internal.measurement.zzdv r1 = r1.zzb()     // Catch:{ all -> 0x0128 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdr r1 = (com.google.android.gms.internal.measurement.zzdr) r1     // Catch:{ all -> 0x0128 }
            boolean r4 = r1.zza()     // Catch:{ all -> 0x0128 }
            if (r4 == 0) goto L_0x0121
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzcs r1 = (com.google.android.gms.internal.measurement.zzcs) r1     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdf r2 = r7.zzf     // Catch:{ all -> 0x0128 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzdf r4 = r7.zzf     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = r4.zzd     // Catch:{ all -> 0x0128 }
            java.lang.String r5 = r7.zzg     // Catch:{ all -> 0x0128 }
            java.lang.String r1 = r1.zza(r2, r3, r4, r5)     // Catch:{ all -> 0x0128 }
            if (r1 != 0) goto L_0x011c
            T r2 = r7.zzh     // Catch:{ all -> 0x0128 }
            goto L_0x0122
        L_0x011c:
            java.lang.Object r2 = r7.zza((java.lang.Object) r1)     // Catch:{ all -> 0x0128 }
            goto L_0x0122
        L_0x0121:
        L_0x0122:
            r7.zzk = r2     // Catch:{ all -> 0x0128 }
            r7.zzj = r0     // Catch:{ all -> 0x0128 }
        L_0x0126:
            monitor-exit(r7)     // Catch:{ all -> 0x0128 }
            goto L_0x012b
        L_0x0128:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0128 }
            throw r0
        L_0x012b:
            T r0 = r7.zzk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcw.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzcw<Long> zzb(zzdf zzdf, String str, long j, boolean z) {
        return new zzdb(zzdf, str, Long.valueOf(j), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<Boolean> zzb(zzdf zzdf, String str, boolean z, boolean z2) {
        return new zzda(zzdf, str, Boolean.valueOf(z), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<Double> zzb(zzdf zzdf, String str, double d, boolean z) {
        return new zzdd(zzdf, str, Double.valueOf(d), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<String> zzb(zzdf zzdf, String str, String str2, boolean z) {
        return new zzdc(zzdf, str, str2, true);
    }

    static final /* synthetic */ zzdr zzb(Context context) {
        new zzcv();
        return zzcv.zza(context);
    }

    static final /* synthetic */ boolean zzd() {
        return true;
    }

    /* synthetic */ zzcw(zzdf zzdf, String str, Object obj, boolean z, zzdb zzdb) {
        this(zzdf, str, obj, z);
    }
}

package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.4 */
final class zzaj extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzag zzag, String str, String str2, Context context, Bundle bundle) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063 A[Catch:{ Exception -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a3 }
            r3.<init>()     // Catch:{ Exception -> 0x00a3 }
            java.util.List unused = r2.zzf = r3     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = r14.zzc     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r4 = r14.zzd     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = com.google.android.gms.internal.measurement.zzag.zzc(r3, r4)     // Catch:{ Exception -> 0x00a3 }
            r3 = 0
            if (r2 == 0) goto L_0x002a
            java.lang.String r3 = r14.zzd     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = r14.zzc     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag r4 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r4 = r4.zzc     // Catch:{ Exception -> 0x00a3 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002d
        L_0x002a:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002d:
            android.content.Context r2 = r14.zze     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag.zzh(r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzag.zzh     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x00a3 }
            if (r2 != 0) goto L_0x0041
            if (r10 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r2 = r0
            goto L_0x0042
        L_0x0041:
            r2 = r1
        L_0x0042:
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag r4 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            android.content.Context r5 = r14.zze     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzv r4 = r4.zza((android.content.Context) r5, (boolean) r2)     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzv unused = r3.zzm = r4     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzv r3 = r3.zzm     // Catch:{ Exception -> 0x00a3 }
            if (r3 != 0) goto L_0x0063
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = r2.zzc     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x00a3 }
            return
        L_0x0063:
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x00a3 }
            int r3 = com.google.android.gms.internal.measurement.zzag.zzg(r3)     // Catch:{ Exception -> 0x00a3 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x00a3 }
            int r4 = com.google.android.gms.internal.measurement.zzag.zzf(r4)     // Catch:{ Exception -> 0x00a3 }
            if (r2 == 0) goto L_0x007c
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x00a3 }
            if (r4 >= r3) goto L_0x0079
            r3 = r1
            goto L_0x007a
        L_0x0079:
            r3 = r0
        L_0x007a:
            r8 = r3
            goto L_0x0086
        L_0x007c:
            if (r3 <= 0) goto L_0x007f
            r4 = r3
        L_0x007f:
            if (r3 <= 0) goto L_0x0083
            r2 = r1
            goto L_0x0084
        L_0x0083:
            r2 = r0
        L_0x0084:
            r8 = r2
            r2 = r4
        L_0x0086:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ Exception -> 0x00a3 }
            r4 = 31000(0x7918, double:1.5316E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x00a3 }
            android.os.Bundle r12 = r14.zzf     // Catch:{ Exception -> 0x00a3 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzv r2 = r2.zzm     // Catch:{ Exception -> 0x00a3 }
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x00a3 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ Exception -> 0x00a3 }
            long r4 = r14.zza     // Catch:{ Exception -> 0x00a3 }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x00a3 }
            return
        L_0x00a3:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg
            r3.zza((java.lang.Exception) r2, (boolean) r1, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaj.zza():void");
    }
}

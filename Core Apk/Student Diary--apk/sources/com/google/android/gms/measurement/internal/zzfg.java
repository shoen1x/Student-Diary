package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzfg implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfe zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfc zzf;

    public zzfg(zzfc zzfc, String str, URL url, byte[] bArr, Map<String, String> map, zzfe zzfe) {
        this.zzf = zzfc;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfe);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfe;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[SYNTHETIC, Splitter:B:45:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0111 A[SYNTHETIC, Splitter:B:58:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzfc r1 = r13.zzf
            r1.zzc()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfc r3 = r13.zzf     // Catch:{ IOException -> 0x010a, all -> 0x00cf }
            java.net.URL r4 = r13.zza     // Catch:{ IOException -> 0x010a, all -> 0x00cf }
            java.net.HttpURLConnection r3 = r3.zza((java.net.URL) r4)     // Catch:{ IOException -> 0x010a, all -> 0x00cf }
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.zze     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            if (r4 == 0) goto L_0x003f
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.zze     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
        L_0x0023:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r3.addRequestProperty(r6, r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            goto L_0x0023
        L_0x003f:
            byte[] r4 = r13.zzb     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            if (r4 == 0) goto L_0x008e
            com.google.android.gms.measurement.internal.zzfc r4 = r13.zzf     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            com.google.android.gms.measurement.internal.zzks r4 = r4.zzg()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            byte[] r5 = r13.zzb     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            byte[] r4 = r4.zzc(r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            com.google.android.gms.measurement.internal.zzfc r5 = r13.zzf     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzx()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r6 = "Uploading data. size"
            int r7 = r4.length     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r5.zza(r6, r7)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r5 = 1
            r3.setDoOutput(r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            int r5 = r4.length     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r3.setFixedLengthStreamingMode(r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r3.connect()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r5.write(r4)     // Catch:{ IOException -> 0x0087, all -> 0x0080 }
            r5.close()     // Catch:{ IOException -> 0x0087, all -> 0x0080 }
            goto L_0x008e
        L_0x0080:
            r4 = move-exception
            r10 = r1
            r7 = r2
            r2 = r4
            r1 = r5
            goto L_0x00d4
        L_0x0087:
            r4 = move-exception
            r10 = r1
            r7 = r2
            r8 = r4
            r1 = r5
            goto L_0x010f
        L_0x008e:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00c5, all -> 0x00c0 }
            com.google.android.gms.measurement.internal.zzfc r2 = r13.zzf     // Catch:{ IOException -> 0x00bc, all -> 0x00b7 }
            byte[] r10 = com.google.android.gms.measurement.internal.zzfc.zza((java.net.HttpURLConnection) r3)     // Catch:{ IOException -> 0x00bc, all -> 0x00b7 }
            if (r3 == 0) goto L_0x00a1
            r3.disconnect()
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfc r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfh r1 = new com.google.android.gms.measurement.internal.zzfh
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzfe r7 = r13.zzc
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zza((java.lang.Runnable) r1)
            return
        L_0x00b7:
            r4 = move-exception
            r2 = r4
            r7 = r8
            r10 = r11
            goto L_0x00d4
        L_0x00bc:
            r4 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x010e
        L_0x00c0:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r7 = r8
            goto L_0x00d4
        L_0x00c5:
            r4 = move-exception
            r10 = r1
            r7 = r8
            goto L_0x010e
        L_0x00c9:
            r4 = move-exception
            r10 = r1
            goto L_0x00d2
        L_0x00cc:
            r4 = move-exception
            r10 = r1
            goto L_0x010d
        L_0x00cf:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x00d2:
            r7 = r2
            r2 = r4
        L_0x00d4:
            if (r1 == 0) goto L_0x00ee
            r1.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00ee
        L_0x00da:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfc r4 = r13.zzf
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()
            java.lang.String r5 = r13.zzd
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)
            r4.zza(r0, r5, r1)
        L_0x00ee:
            if (r3 == 0) goto L_0x00f3
            r3.disconnect()
        L_0x00f3:
            com.google.android.gms.measurement.internal.zzfc r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfh r1 = new com.google.android.gms.measurement.internal.zzfh
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzfe r6 = r13.zzc
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza((java.lang.Runnable) r1)
            throw r2
        L_0x010a:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x010d:
            r7 = r2
        L_0x010e:
            r8 = r4
        L_0x010f:
            if (r1 == 0) goto L_0x0129
            r1.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0129
        L_0x0115:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfc r2 = r13.zzf
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r4 = r13.zzd
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r4)
            r2.zza(r0, r4, r1)
        L_0x0129:
            if (r3 == 0) goto L_0x012e
            r3.disconnect()
        L_0x012e:
            com.google.android.gms.measurement.internal.zzfc r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfh r1 = new com.google.android.gms.measurement.internal.zzfh
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzfe r6 = r13.zzc
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zza((java.lang.Runnable) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.run():void");
    }
}

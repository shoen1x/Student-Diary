package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcc;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzt {
    private zzcc.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzo zzd;

    private zzt(zzo zzo) {
        this.zzd = zzo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzcc.zzc zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzcc.zzc r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            java.lang.String r9 = r19.zzc()
            java.util.List r10 = r19.zza()
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzks r2 = r2.zzg()
            java.lang.String r3 = "_eid"
            java.lang.Object r2 = r2.zzb(r8, r3)
            r4 = r2
            java.lang.Long r4 = (java.lang.Long) r4
            r2 = 1
            r5 = 0
            if (r4 == 0) goto L_0x0023
            r6 = r2
            goto L_0x0024
        L_0x0023:
            r6 = r5
        L_0x0024:
            if (r6 == 0) goto L_0x0030
            java.lang.String r7 = "_ep"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0031
        L_0x0030:
            r7 = r5
        L_0x0031:
            r11 = 0
            if (r7 == 0) goto L_0x0149
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzks r6 = r6.zzg()
            java.lang.String r7 = "_en"
            java.lang.Object r6 = r6.zzb(r8, r7)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            r7 = 0
            if (r6 == 0) goto L_0x005b
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzg()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zza(r2, r4)
            return r7
        L_0x005b:
            com.google.android.gms.internal.measurement.zzcc$zzc r6 = r1.zza
            if (r6 == 0) goto L_0x0071
            java.lang.Long r6 = r1.zzb
            if (r6 == 0) goto L_0x0071
            long r13 = r4.longValue()
            java.lang.Long r6 = r1.zzb
            long r15 = r6.longValue()
            int r6 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x00a3
        L_0x0071:
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzad r6 = r6.zzi()
            android.util.Pair r6 = r6.zza((java.lang.String) r0, (java.lang.Long) r4)
            if (r6 == 0) goto L_0x0139
            java.lang.Object r13 = r6.first
            if (r13 != 0) goto L_0x0083
            goto L_0x0139
        L_0x0083:
            java.lang.Object r7 = r6.first
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = (com.google.android.gms.internal.measurement.zzcc.zzc) r7
            r1.zza = r7
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r1.zzc = r6
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzks r6 = r6.zzg()
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = r1.zza
            java.lang.Object r3 = r6.zzb(r7, r3)
            java.lang.Long r3 = (java.lang.Long) r3
            r1.zzb = r3
        L_0x00a3:
            long r6 = r1.zzc
            r13 = 1
            long r6 = r6 - r13
            r1.zzc = r6
            int r3 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzo r3 = r1.zzd
            com.google.android.gms.measurement.internal.zzad r3 = r3.zzi()
            r3.zzd()
            com.google.android.gms.measurement.internal.zzez r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzx()
            java.lang.String r6 = "Clearing complex main event info. appId"
            r4.zza(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r3.c_()     // Catch:{ SQLiteException -> 0x00d2 }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00d2 }
            r2[r5] = r0     // Catch:{ SQLiteException -> 0x00d2 }
            r4.execSQL(r6, r2)     // Catch:{ SQLiteException -> 0x00d2 }
            goto L_0x00f0
        L_0x00d2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x00f0
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzad r2 = r2.zzi()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = r1.zza
            r3 = r18
            r2.zza(r3, r4, r5, r7)
        L_0x00f0:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = r1.zza
            java.util.List r2 = r2.zza()
            java.util.Iterator r2 = r2.iterator()
        L_0x00ff:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x011e
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3
            com.google.android.gms.measurement.internal.zzo r4 = r1.zzd
            r4.zzg()
            java.lang.String r4 = r3.zzb()
            com.google.android.gms.internal.measurement.zzcc$zze r4 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x011d
            r0.add(r3)
        L_0x011d:
            goto L_0x00ff
        L_0x011e:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0129
            r0.addAll(r10)
            r10 = r0
            goto L_0x018e
        L_0x0129:
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzg()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zza(r2, r9)
        L_0x0138:
            goto L_0x018e
        L_0x0139:
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzg()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zza(r2, r9, r4)
            return r7
        L_0x0149:
            if (r6 == 0) goto L_0x0138
            r1.zzb = r4
            r1.zza = r8
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzks r2 = r2.zzg()
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            java.lang.String r5 = "_epc"
            java.lang.Object r2 = r2.zzb(r8, r5)
            if (r2 != 0) goto L_0x0162
            goto L_0x0163
        L_0x0162:
            r3 = r2
        L_0x0163:
            java.lang.Long r3 = (java.lang.Long) r3
            long r2 = r3.longValue()
            r1.zzc = r2
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x017f
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzg()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r0.zza(r2, r9)
            goto L_0x018e
        L_0x017f:
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzad r2 = r2.zzi()
            long r5 = r1.zzc
            r3 = r18
            r7 = r19
            r2.zza(r3, r4, r5, r7)
        L_0x018e:
            com.google.android.gms.internal.measurement.zzib$zza r0 = r19.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r0 = (com.google.android.gms.internal.measurement.zzib.zza) r0
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r0 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r0
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r0 = r0.zza((java.lang.String) r9)
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r0 = r0.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r0 = r0.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcc.zze>) r10)
            com.google.android.gms.internal.measurement.zzjj r0 = r0.zzv()
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0
            com.google.android.gms.internal.measurement.zzcc$zzc r0 = (com.google.android.gms.internal.measurement.zzcc.zzc) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.lang.String, com.google.android.gms.internal.measurement.zzcc$zzc):com.google.android.gms.internal.measurement.zzcc$zzc");
    }

    /* synthetic */ zzt(zzo zzo, zzr zzr) {
        this(zzo);
    }
}

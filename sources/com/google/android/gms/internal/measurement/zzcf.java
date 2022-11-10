package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public class zzcf {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    /* access modifiers changed from: private */
    public static final AtomicBoolean zze = new AtomicBoolean();
    private static HashMap<String, String> zzf;
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static Object zzk;
    private static boolean zzl;
    private static String[] zzm = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r10 = r10.query(zza, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        if (r10 != null) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        if (r10 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c4, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (r10.moveToFirst() != false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        zza(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d8, code lost:
        if (r12 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.equals((java.lang.Object) null) == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        zza(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e4, code lost:
        if (r12 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e6, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e7, code lost:
        if (r10 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e9, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ec, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ed, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ee, code lost:
        if (r10 != null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f0, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f3, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzcf> r12 = com.google.android.gms.internal.measurement.zzcf.class
            monitor-enter(r12)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzf     // Catch:{ all -> 0x00f4 }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002b
            java.util.concurrent.atomic.AtomicBoolean r0 = zze     // Catch:{ all -> 0x00f4 }
            r0.set(r2)     // Catch:{ all -> 0x00f4 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            zzf = r0     // Catch:{ all -> 0x00f4 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            zzk = r0     // Catch:{ all -> 0x00f4 }
            zzl = r2     // Catch:{ all -> 0x00f4 }
            android.net.Uri r0 = zza     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzch r4 = new com.google.android.gms.internal.measurement.zzch     // Catch:{ all -> 0x00f4 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f4 }
            r10.registerContentObserver(r0, r1, r4)     // Catch:{ all -> 0x00f4 }
            goto L_0x0055
        L_0x002b:
            java.util.concurrent.atomic.AtomicBoolean r0 = zze     // Catch:{ all -> 0x00f4 }
            boolean r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x0055
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzf     // Catch:{ all -> 0x00f4 }
            r0.clear()     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = zzg     // Catch:{ all -> 0x00f4 }
            r0.clear()     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = zzh     // Catch:{ all -> 0x00f4 }
            r0.clear()     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.Long> r0 = zzi     // Catch:{ all -> 0x00f4 }
            r0.clear()     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.Float> r0 = zzj     // Catch:{ all -> 0x00f4 }
            r0.clear()     // Catch:{ all -> 0x00f4 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            zzk = r0     // Catch:{ all -> 0x00f4 }
            zzl = r2     // Catch:{ all -> 0x00f4 }
        L_0x0055:
            java.lang.Object r0 = zzk     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = zzf     // Catch:{ all -> 0x00f4 }
            boolean r4 = r4.containsKey(r11)     // Catch:{ all -> 0x00f4 }
            if (r4 == 0) goto L_0x006c
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzf     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x006a
            r3 = r10
        L_0x006a:
            monitor-exit(r12)     // Catch:{ all -> 0x00f4 }
            return r3
        L_0x006c:
            java.lang.String[] r4 = zzm     // Catch:{ all -> 0x00f4 }
            int r5 = r4.length     // Catch:{ all -> 0x00f4 }
            r6 = r2
        L_0x0070:
            if (r6 >= r5) goto L_0x00ad
            r7 = r4[r6]     // Catch:{ all -> 0x00f4 }
            boolean r7 = r11.startsWith(r7)     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x00aa
            boolean r0 = zzl     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x0086
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzf     // Catch:{ all -> 0x00f4 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00a8
        L_0x0086:
            java.lang.String[] r0 = zzm     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = zzf     // Catch:{ all -> 0x00f4 }
            java.util.Map r10 = zza(r10, r0)     // Catch:{ all -> 0x00f4 }
            r2.putAll(r10)     // Catch:{ all -> 0x00f4 }
            zzl = r1     // Catch:{ all -> 0x00f4 }
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzf     // Catch:{ all -> 0x00f4 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x00a8
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzf     // Catch:{ all -> 0x00f4 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x00a6
            r3 = r10
        L_0x00a6:
            monitor-exit(r12)     // Catch:{ all -> 0x00f4 }
            return r3
        L_0x00a8:
            monitor-exit(r12)     // Catch:{ all -> 0x00f4 }
            return r3
        L_0x00aa:
            int r6 = r6 + 1
            goto L_0x0070
        L_0x00ad:
            monitor-exit(r12)     // Catch:{ all -> 0x00f4 }
            android.net.Uri r5 = zza
            r6 = 0
            r7 = 0
            java.lang.String[] r8 = new java.lang.String[r1]
            r8[r2] = r11
            r9 = 0
            r4 = r10
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)
            if (r10 != 0) goto L_0x00c5
            if (r10 == 0) goto L_0x00c4
            r10.close()
        L_0x00c4:
            return r3
        L_0x00c5:
            boolean r12 = r10.moveToFirst()     // Catch:{ all -> 0x00ed }
            if (r12 != 0) goto L_0x00d4
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r3)     // Catch:{ all -> 0x00ed }
            if (r10 == 0) goto L_0x00d3
            r10.close()
        L_0x00d3:
            return r3
        L_0x00d4:
            java.lang.String r12 = r10.getString(r1)     // Catch:{ all -> 0x00ed }
            if (r12 == 0) goto L_0x00e1
            boolean r1 = r12.equals(r3)     // Catch:{ all -> 0x00ed }
            if (r1 == 0) goto L_0x00e1
            r12 = r3
        L_0x00e1:
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x00ed }
            if (r12 == 0) goto L_0x00e7
            r3 = r12
        L_0x00e7:
            if (r10 == 0) goto L_0x00ec
            r10.close()
        L_0x00ec:
            return r3
        L_0x00ed:
            r11 = move-exception
            if (r10 == 0) goto L_0x00f3
            r10.close()
        L_0x00f3:
            throw r11
        L_0x00f4:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00f4 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcf.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzcf.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzd, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}

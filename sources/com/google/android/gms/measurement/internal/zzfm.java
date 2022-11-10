package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzfm {
    private final String zza;
    private final Bundle zzb = new Bundle();
    private boolean zzc;
    private Bundle zzd;
    private final /* synthetic */ zzfl zze;

    public zzfm(zzfl zzfl, String str, Bundle bundle) {
        this.zze = zzfl;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[Catch:{ NumberFormatException | JSONException -> 0x00a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r12 = this;
            boolean r0 = r12.zzc
            if (r0 != 0) goto L_0x00d2
            r0 = 1
            r12.zzc = r0
            com.google.android.gms.measurement.internal.zzfl r1 = r12.zze
            android.content.SharedPreferences r1 = r1.zzg()
            java.lang.String r2 = r12.zza
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto L_0x00ca
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x00ba }
            r2.<init>()     // Catch:{ JSONException -> 0x00ba }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ba }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00ba }
            r1 = 0
            r4 = r1
        L_0x0023:
            int r5 = r3.length()     // Catch:{ JSONException -> 0x00ba }
            if (r4 >= r5) goto L_0x00b7
            org.json.JSONObject r5 = r3.getJSONObject(r4)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            java.lang.String r6 = "n"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            java.lang.String r7 = "t"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            r8 = -1
            int r9 = r7.hashCode()     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            r10 = 100
            r11 = 2
            if (r9 == r10) goto L_0x0060
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0056
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x004c
        L_0x004b:
            goto L_0x0069
        L_0x004c:
            java.lang.String r9 = "s"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            if (r9 == 0) goto L_0x004b
            r8 = r1
            goto L_0x0069
        L_0x0056:
            java.lang.String r9 = "l"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            if (r9 == 0) goto L_0x004b
            r8 = r11
            goto L_0x0069
        L_0x0060:
            java.lang.String r9 = "d"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            if (r9 == 0) goto L_0x004b
            r8 = r0
        L_0x0069:
            java.lang.String r9 = "v"
            if (r8 == 0) goto L_0x0099
            if (r8 == r0) goto L_0x008d
            if (r8 == r11) goto L_0x0081
            com.google.android.gms.measurement.internal.zzfl r5 = r12.zze     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            java.lang.String r6 = "Unrecognized persisted bundle type. Type"
            r5.zza(r6, r7)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            goto L_0x00b3
        L_0x0081:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            long r7 = java.lang.Long.parseLong(r5)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            r2.putLong(r6, r7)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            goto L_0x00b3
        L_0x008d:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            double r7 = java.lang.Double.parseDouble(r5)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            r2.putDouble(r6, r7)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            goto L_0x00b3
        L_0x0099:
            java.lang.String r5 = r5.getString(r9)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            r2.putString(r6, r5)     // Catch:{ JSONException -> 0x00a3, NumberFormatException -> 0x00a1 }
            goto L_0x00b3
        L_0x00a1:
            r5 = move-exception
            goto L_0x00a4
        L_0x00a3:
            r5 = move-exception
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzfl r5 = r12.zze     // Catch:{ JSONException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ JSONException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r6 = "Error reading value from SharedPreferences. Value dropped"
            r5.zza(r6)     // Catch:{ JSONException -> 0x00ba }
        L_0x00b3:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x00b7:
            r12.zzd = r2     // Catch:{ JSONException -> 0x00ba }
            goto L_0x00ca
        L_0x00ba:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfl r0 = r12.zze
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        L_0x00ca:
            android.os.Bundle r0 = r12.zzd
            if (r0 != 0) goto L_0x00d2
            android.os.Bundle r0 = r12.zzb
            r12.zzd = r0
        L_0x00d2:
            android.os.Bundle r0 = r12.zzd
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfm.zza():android.os.Bundle");
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle));
        }
        edit.apply();
        this.zzd = bundle;
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.zze.zzr().zzf().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.zze.zzr().zzf().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzjt {
    private static final zzjr zza = zzc();
    private static final zzjr zzb = new zzju();

    static zzjr zza() {
        return zza;
    }

    static zzjr zzb() {
        return zzb;
    }

    private static zzjr zzc() {
        try {
            return (zzjr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}

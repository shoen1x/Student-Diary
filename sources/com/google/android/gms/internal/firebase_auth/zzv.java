package com.google.android.gms.internal.firebase_auth;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
public enum zzv implements zzil {
    USER_ATTRIBUTE_NAME_UNSPECIFIED(0),
    EMAIL(1),
    DISPLAY_NAME(2),
    PROVIDER(3),
    PHOTO_URL(4),
    PASSWORD(5),
    RAW_USER_INFO(6);
    
    private static final zzik<zzv> zzh = null;
    private final int zzi;

    public final int zza() {
        return this.zzi;
    }

    public static zzv zza(int i) {
        switch (i) {
            case 0:
                return USER_ATTRIBUTE_NAME_UNSPECIFIED;
            case 1:
                return EMAIL;
            case 2:
                return DISPLAY_NAME;
            case 3:
                return PROVIDER;
            case 4:
                return PHOTO_URL;
            case 5:
                return PASSWORD;
            case 6:
                return RAW_USER_INFO;
            default:
                return null;
        }
    }

    public static zzin zzb() {
        return zzw.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
    }

    private zzv(int i) {
        this.zzi = i;
    }

    static {
        zzh = new zzx();
    }
}

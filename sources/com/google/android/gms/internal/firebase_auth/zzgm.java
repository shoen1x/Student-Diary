package com.google.android.gms.internal.firebase_auth;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
public enum zzgm implements zzil {
    OOB_REQ_TYPE_UNSPECIFIED(0),
    PASSWORD_RESET(1),
    OLD_EMAIL_AGREE(2),
    NEW_EMAIL_ACCEPT(3),
    VERIFY_EMAIL(4),
    RECOVER_EMAIL(5),
    EMAIL_SIGNIN(6),
    VERIFY_AND_CHANGE_EMAIL(7),
    REVERT_SECOND_FACTOR_ADDITION(8);
    
    private static final zzik<zzgm> zzj = null;
    private final int zzk;

    public final int zza() {
        return this.zzk;
    }

    public static zzgm zza(int i) {
        switch (i) {
            case 0:
                return OOB_REQ_TYPE_UNSPECIFIED;
            case 1:
                return PASSWORD_RESET;
            case 2:
                return OLD_EMAIL_AGREE;
            case 3:
                return NEW_EMAIL_ACCEPT;
            case 4:
                return VERIFY_EMAIL;
            case 5:
                return RECOVER_EMAIL;
            case 6:
                return EMAIL_SIGNIN;
            case 7:
                return VERIFY_AND_CHANGE_EMAIL;
            case 8:
                return REVERT_SECOND_FACTOR_ADDITION;
            default:
                return null;
        }
    }

    public static zzin zzb() {
        return zzgo.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
    }

    private zzgm(int i) {
        this.zzk = i;
    }

    static {
        zzj = new zzgl();
    }
}

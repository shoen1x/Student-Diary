package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzig;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
public final class zzlc {
    private static final zzlc zza = new zzlc(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzlc zza() {
        return zza;
    }

    static zzlc zzb() {
        return new zzlc();
    }

    static zzlc zza(zzlc zzlc, zzlc zzlc2) {
        int i = zzlc.zzb + zzlc2.zzb;
        int[] copyOf = Arrays.copyOf(zzlc.zzc, i);
        System.arraycopy(zzlc2.zzc, 0, copyOf, zzlc.zzb, zzlc2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzlc.zzd, i);
        System.arraycopy(zzlc2.zzd, 0, copyOf2, zzlc.zzb, zzlc2.zzb);
        return new zzlc(i, copyOf, copyOf2, true);
    }

    private zzlc() {
        this(0, new int[8], new Object[8], true);
    }

    private zzlc(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzc() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzlw zzlw) throws IOException {
        if (zzlw.zza() == zzig.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzlw.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzlw.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzlw zzlw) throws IOException {
        if (this.zzb != 0) {
            if (zzlw.zza() == zzig.zze.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzlw);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzlw);
            }
        }
    }

    private static void zza(int i, Object obj, zzlw zzlw) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzlw.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzlw.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzlw.zza(i2, (zzgv) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzlw.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzir.zzf());
        } else if (zzlw.zza() == zzig.zze.zzj) {
            zzlw.zza(i2);
            ((zzlc) obj).zzb(zzlw);
            zzlw.zzb(i2);
        } else {
            zzlw.zzb(i2);
            ((zzlc) obj).zzb(zzlw);
            zzlw.zza(i2);
        }
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzhq.zzd(this.zzc[i3] >>> 3, (zzgv) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zze() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzhq.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzhq.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzhq.zzc(i6, (zzgv) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzhq.zze(i6) << 1) + ((zzlc) this.zzd[i4]).zze();
            } else if (i7 == 5) {
                i = zzhq.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzir.zzf());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzlc)) {
            return false;
        }
        zzlc zzlc = (zzlc) obj;
        int i = this.zzb;
        if (i == zzlc.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzlc.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzlc.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjs.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            if (i2 == this.zzc.length) {
                int i3 = this.zzb + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(this.zzc, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr = this.zzc;
            int i4 = this.zzb;
            iArr[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}

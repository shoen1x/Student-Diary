package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
class zzhf extends zzhg {
    protected final byte[] zzb;

    zzhf(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    public int zza() {
        return this.zzb.length;
    }

    public final zzgv zza(int i, int i2) {
        int zzb2 = zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzgv.zza;
        }
        return new zzhc(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgw zzgw) throws IOException {
        zzgw.zza(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    public final boolean zzc() {
        int zze = zze();
        return zzli.zza(this.zzb, zze, zza() + zze);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgv) || zza() != ((zzgv) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzhf)) {
            return obj.equals(this);
        }
        zzhf zzhf = (zzhf) obj;
        int zzd = zzd();
        int zzd2 = zzhf.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzhf, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzgv zzgv, int i, int i2) {
        if (i2 > zzgv.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgv.zza()) {
            int zza2 = zzgv.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzgv instanceof zzhf)) {
            return zzgv.zza(0, i2).equals(zza(0, i2));
        } else {
            zzhf zzhf = (zzhf) zzgv;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzhf.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzhf.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzii.zza(i, this.zzb, zze(), i3);
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }
}

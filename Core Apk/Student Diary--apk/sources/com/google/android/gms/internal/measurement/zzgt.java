package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public abstract class zzgt implements Serializable, Iterable<Byte> {
    public static final zzgt zza = new zzhd(zzie.zzb);
    private static final zzgz zzb = (zzgm.zza() ? new zzhc((zzgs) null) : new zzgx((zzgs) null));
    private static final Comparator<zzgt> zzd = new zzgv();
    private int zzc = 0;

    zzgt() {
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract int zza();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzgt zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzgq zzgq) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract boolean zzc();

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public static zzgt zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzhd(zzb.zza(bArr, i, i2));
    }

    static zzgt zza(byte[] bArr) {
        return new zzhd(bArr);
    }

    public static zzgt zza(String str) {
        return new zzhd(str.getBytes(zzie.zza));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzie.zza);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    static zzhb zzc(int i) {
        return new zzhb(i, (zzgs) null);
    }

    /* access modifiers changed from: protected */
    public final int zzd() {
        return this.zzc;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? zzkq.zza(this) : String.valueOf(zzkq.zza(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public /* synthetic */ Iterator iterator() {
        return new zzgs(this);
    }
}

package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzef<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    @NullableDecl
    transient int[] zza;
    @NullableDecl
    transient Object[] zzb;
    @NullableDecl
    transient Object[] zzc;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf = zzgb.zza(3, 1, 1073741823);
    private transient int zzg;
    @NullableDecl
    private transient Set<K> zzh;
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;
    @NullableDecl
    private transient Collection<V> zzj;

    zzef() {
        zzdq.zza(true, (Object) "Expected size must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zze == null;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final Map<K, V> zzb() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private final void zzb(int i) {
        this.zzf = zzem.zza(this.zzf, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* access modifiers changed from: private */
    public final int zzi() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzf += 32;
    }

    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int min;
        int i;
        K k2 = k;
        V v2 = v;
        if (zza()) {
            zzdq.zzb(zza(), (Object) "Arrays already allocated");
            int i2 = this.zzf;
            int max = Math.max(i2 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max <= ((int) (((double) highestOneBit) * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) {
                i = highestOneBit;
            } else {
                i = 1073741824;
            }
            int max2 = Math.max(4, i);
            this.zze = zzem.zza(max2);
            zzb(max2 - 1);
            this.zza = new int[i2];
            this.zzb = new Object[i2];
            this.zzc = new Object[i2];
        }
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.put(k2, v2);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        V[] vArr = this.zzc;
        int i3 = this.zzg;
        int i4 = i3 + 1;
        int zza2 = zzeo.zza((Object) k);
        int zzi2 = zzi();
        int i5 = zza2 & zzi2;
        int zza3 = zzem.zza(this.zze, i5);
        if (zza3 != 0) {
            int i6 = ~zzi2;
            int i7 = zza2 & i6;
            int i8 = 0;
            while (true) {
                int i9 = zza3 - 1;
                int i10 = iArr[i9];
                if ((i10 & i6) != i7 || !zzdo.zza(k2, objArr[i9])) {
                    int i11 = i10 & zzi2;
                    Object[] objArr2 = objArr;
                    int i12 = i8 + 1;
                    if (i11 != 0) {
                        i8 = i12;
                        zza3 = i11;
                        objArr = objArr2;
                    } else if (i12 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzi() + 1, 1.0f);
                        for (int zzd2 = zzd(); zzd2 >= 0; zzd2 = zza(zzd2)) {
                            linkedHashMap.put(this.zzb[zzd2], this.zzc[zzd2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzc();
                        return linkedHashMap.put(k2, v2);
                    } else if (i4 > zzi2) {
                        zzi2 = zza(zzi2, zzem.zzb(zzi2), zza2, i3);
                    } else {
                        iArr[i9] = zzem.zza(i10, i4, zzi2);
                    }
                } else {
                    V v3 = vArr[i9];
                    vArr[i9] = v2;
                    return v3;
                }
            }
        } else if (i4 > zzi2) {
            zzi2 = zza(zzi2, zzem.zzb(zzi2), zza2, i3);
        } else {
            zzem.zza(this.zze, i5, i4);
        }
        int length = this.zza.length;
        if (i4 > length && (min = Math.min(1073741823, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i3] = zzem.zza(zza2, 0, zzi2);
        this.zzb[i3] = k2;
        this.zzc[i3] = v2;
        this.zzg = i4;
        zzc();
        return null;
    }

    private final int zza(int i, int i2, int i3, int i4) {
        Object zza2 = zzem.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzem.zza(zza2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int zza3 = zzem.zza(obj, i6);
            while (zza3 != 0) {
                int i7 = zza3 - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zza4 = zzem.zza(zza2, i10);
                zzem.zza(zza2, i10, zza3);
                iArr[i7] = zzem.zza(i9, zza4, i5);
                zza3 = i8 & i;
            }
        }
        this.zze = zza2;
        zzb(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final int zza(@NullableDecl Object obj) {
        if (zza()) {
            return -1;
        }
        int zza2 = zzeo.zza(obj);
        int zzi2 = zzi();
        int zza3 = zzem.zza(this.zze, zza2 & zzi2);
        if (zza3 == 0) {
            return -1;
        }
        int i = ~zzi2;
        int i2 = zza2 & i;
        do {
            int i3 = zza3 - 1;
            int i4 = this.zza[i3];
            if ((i4 & i) == i2 && zzdo.zza(obj, this.zzb[i3])) {
                return i3;
            }
            zza3 = i4 & zzi2;
        } while (zza3 != 0);
        return -1;
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsKey(obj);
        }
        return zza(obj) != -1;
    }

    public final V get(@NullableDecl Object obj) {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.get(obj);
        }
        int zza2 = zza(obj);
        if (zza2 == -1) {
            return null;
        }
        return this.zzc[zza2];
    }

    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.remove(obj);
        }
        V zzb3 = zzb(obj);
        if (zzb3 == zzd) {
            return null;
        }
        return zzb3;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public final Object zzb(@NullableDecl Object obj) {
        if (zza()) {
            return zzd;
        }
        int zzi2 = zzi();
        int zza2 = zzem.zza(obj, (Object) null, zzi2, this.zze, this.zza, this.zzb, (Object[]) null);
        if (zza2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[zza2];
        zza(zza2, zzi2);
        this.zzg--;
        zzc();
        return obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int zza2 = zzeo.zza(obj) & i2;
            int zza3 = zzem.zza(this.zze, zza2);
            int i3 = size + 1;
            if (zza3 == i3) {
                zzem.zza(this.zze, zza2, i + 1);
                return;
            }
            while (true) {
                int i4 = zza3 - 1;
                int[] iArr2 = this.zza;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == i3) {
                    iArr2[i4] = zzem.zza(i5, i + 1, i2);
                    return;
                }
                zza3 = i6;
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    static int zzb(int i, int i2) {
        return i - 1;
    }

    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzel zzel = new zzel(this);
        this.zzh = zzel;
        return zzel;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<K> zze() {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.keySet().iterator();
        }
        return new zzee(this);
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzej zzej = new zzej(this);
        this.zzi = zzej;
        return zzej;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<K, V>> zzf() {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.entrySet().iterator();
        }
        return new zzeh(this);
    }

    public final int size() {
        Map zzb2 = zzb();
        return zzb2 != null ? zzb2.size() : this.zzg;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzdo.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzen zzen = new zzen(this);
        this.zzj = zzen;
        return zzen;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> zzg() {
        Map zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.values().iterator();
        }
        return new zzeg(this);
    }

    public final void clear() {
        if (!zza()) {
            zzc();
            Map zzb2 = zzb();
            if (zzb2 != null) {
                this.zzf = zzgb.zza(size(), 3, 1073741823);
                zzb2.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
            Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zza, 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    static /* synthetic */ int zzd(zzef zzef) {
        int i = zzef.zzg;
        zzef.zzg = i - 1;
        return i;
    }
}

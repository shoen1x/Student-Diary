package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzib;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
public final class zzca {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
    public static final class zza extends zzib<zza, C0007zza> implements zzjl {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzjw<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzca$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
        public static final class C0007zza extends zzib.zza<zza, C0007zza> implements zzjl {
            private C0007zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0007zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0007zza(zzbz zzbz) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbz.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0007zza((zzbz) null);
                case 3:
                    return zza((zzjj) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjw<zza> zzjw = zzi;
                    if (zzjw == null) {
                        synchronized (zza.class) {
                            zzjw = zzi;
                            if (zzjw == null) {
                                zzjw = new zzib.zzc<>(zzh);
                                zzi = zzjw;
                            }
                        }
                    }
                    return zzjw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzib.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
    public static final class zzb extends zzib<zzb, zza> implements zzjl {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzjw<zzb> zzm;
        private int zzc;
        private long zzd;
        private String zze = "";
        private int zzf;
        private zzik<zzc> zzg = zzbp();
        private zzik<zza> zzh = zzbp();
        private zzik<zzbu.zza> zzi = zzbp();
        private String zzj = "";
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
        public static final class zza extends zzib.zza<zzb, zza> implements zzjl {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0007zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzib) zza.zzv()));
                return this;
            }

            public final List<zzbu.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzbz zzbz) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return (zza) this.zzh.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zza zza2) {
            zza2.getClass();
            zzik<zza> zzik = this.zzh;
            if (!zzik.zza()) {
                this.zzh = zzib.zza(zzik);
            }
            this.zzh.set(i, zza2);
        }

        public final List<zzbu.zza> zzg() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzbp();
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public static zza zzi() {
            return (zza) zzl.zzbk();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbz.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbz) null);
                case 3:
                    return zza((zzjj) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbu.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjw<zzb> zzjw = zzm;
                    if (zzjw == null) {
                        synchronized (zzb.class) {
                            zzjw = zzm;
                            if (zzjw == null) {
                                zzjw = new zzib.zzc<>(zzl);
                                zzm = zzjw;
                            }
                        }
                    }
                    return zzjw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzb zzj() {
            return zzl;
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzib.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
    public static final class zzc extends zzib<zzc, zza> implements zzjl {
        /* access modifiers changed from: private */
        public static final zzc zzf;
        private static volatile zzjw<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
        public static final class zza extends zzib.zza<zzc, zza> implements zzjl {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbz zzbz) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbz.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbz) null);
                case 3:
                    return zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjw<zzc> zzjw = zzg;
                    if (zzjw == null) {
                        synchronized (zzc.class) {
                            zzjw = zzg;
                            if (zzjw == null) {
                                zzjw = new zzib.zzc<>(zzf);
                                zzg = zzjw;
                            }
                        }
                    }
                    return zzjw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzib.zza(zzc.class, zzc2);
        }
    }
}

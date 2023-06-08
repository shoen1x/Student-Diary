package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zziz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzis zzc;

    zziz(zzis zzis, AtomicReference atomicReference, zzn zzn) {
        this.zzc = zzis;
        this.zza = atomicReference;
        this.zzb = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzer zzd = this.zzc.zzb;
                if (zzd == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd.zzc(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzak();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}

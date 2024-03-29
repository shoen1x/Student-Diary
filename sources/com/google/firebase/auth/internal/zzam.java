package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.internal.zzej;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@19.3.2 */
final class zzam extends BroadcastReceiver {
    private final WeakReference<Activity> zza;
    private final TaskCompletionSource<AuthResult> zzb;
    private final FirebaseAuth zzc;
    private final FirebaseUser zzd;
    private final /* synthetic */ zzah zze;

    zzam(zzah zzah, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zze = zzah;
        this.zza = new WeakReference<>(activity);
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = firebaseUser;
    }

    public final void onReceive(Context context, Intent intent) {
        Activity activity = (Activity) this.zza.get();
        if (activity == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzb.setException(zzej.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzah.zzb();
            return;
        }
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(this);
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra)) {
                this.zze.zza(intent, this.zzb, this.zzc);
            } else if ("com.google.firebase.auth.internal.LINK".equals(stringExtra)) {
                this.zze.zza(intent, this.zzb, this.zzd);
            } else if ("com.google.firebase.auth.internal.REAUTHENTICATE".equals(stringExtra)) {
                this.zze.zzb(intent, this.zzb, this.zzd);
            } else {
                TaskCompletionSource<AuthResult> taskCompletionSource = this.zzb;
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 50);
                sb.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
                sb.append(stringExtra);
                sb.append(")");
                taskCompletionSource.setException(zzej.zza(zzy.zza(sb.toString())));
            }
        } else if (zzbb.zza(intent)) {
            this.zzb.setException(zzej.zza(zzbb.zzb(intent)));
            zzah.zzb();
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzb.setException(zzej.zza(zzy.zza("WEB_CONTEXT_CANCELED")));
            zzah.zzb();
        }
    }
}

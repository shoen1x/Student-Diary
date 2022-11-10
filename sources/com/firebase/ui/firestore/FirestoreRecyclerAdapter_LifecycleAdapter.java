package com.firebase.ui.firestore;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class FirestoreRecyclerAdapter_LifecycleAdapter implements GeneratedAdapter {
    final FirestoreRecyclerAdapter mReceiver;

    FirestoreRecyclerAdapter_LifecycleAdapter(FirestoreRecyclerAdapter receiver) {
        this.mReceiver = receiver;
    }

    public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny, MethodCallsLogger logger) {
        boolean hasLogger = logger != null;
        if (!onAny) {
            if (event == Lifecycle.Event.ON_START) {
                if (!hasLogger || logger.approveCall("startListening", 1)) {
                    this.mReceiver.startListening();
                }
            } else if (event == Lifecycle.Event.ON_STOP) {
                if (!hasLogger || logger.approveCall("stopListening", 1)) {
                    this.mReceiver.stopListening();
                }
            } else if (event != Lifecycle.Event.ON_DESTROY) {
            } else {
                if (!hasLogger || logger.approveCall("cleanup", 2)) {
                    this.mReceiver.cleanup(owner);
                }
            }
        }
    }
}

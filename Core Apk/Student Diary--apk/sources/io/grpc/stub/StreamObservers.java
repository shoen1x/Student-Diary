package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> source, final CallStreamObserver<V> target) {
        Preconditions.checkNotNull(source, FirebaseAnalytics.Param.SOURCE);
        Preconditions.checkNotNull(target, "target");
        target.setOnReadyHandler(new Runnable() {
            private boolean completed;

            public void run() {
                if (!this.completed) {
                    while (CallStreamObserver.this.isReady() && source.hasNext()) {
                        CallStreamObserver.this.onNext(source.next());
                    }
                    if (!source.hasNext()) {
                        this.completed = true;
                        CallStreamObserver.this.onCompleted();
                    }
                }
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> source, CallStreamObserver<V> target) {
        Preconditions.checkNotNull(source, FirebaseAnalytics.Param.SOURCE);
        copyWithFlowControl(source.iterator(), target);
    }
}

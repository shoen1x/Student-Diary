package io.grpc.internal;

import java.util.HashSet;

public abstract class InUseStateAggregator<T> {
    private final HashSet<T> inUseObjects = new HashSet<>();

    /* access modifiers changed from: protected */
    public abstract void handleInUse();

    /* access modifiers changed from: protected */
    public abstract void handleNotInUse();

    public final void updateObjectInUse(T object, boolean inUse) {
        int origSize = this.inUseObjects.size();
        if (inUse) {
            this.inUseObjects.add(object);
            if (origSize == 0) {
                handleInUse();
            }
        } else if (this.inUseObjects.remove(object) && origSize == 1) {
            handleNotInUse();
        }
    }

    public final boolean isInUse() {
        return !this.inUseObjects.isEmpty();
    }
}

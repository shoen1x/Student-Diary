package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IIdentifyable;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/utils/DefaultIdDistributorImpl;", "Identifiable", "Lcom/mikepenz/fastadapter/IIdentifyable;", "Lcom/mikepenz/fastadapter/utils/DefaultIdDistributor;", "()V", "idDistributor", "Ljava/util/concurrent/atomic/AtomicLong;", "nextId", "", "identifiable", "(Lcom/mikepenz/fastadapter/IIdentifyable;)J", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultIdDistributorImpl.kt */
public final class DefaultIdDistributorImpl<Identifiable extends IIdentifyable> extends DefaultIdDistributor<Identifiable> {
    private final AtomicLong idDistributor = new AtomicLong(-2);

    public long nextId(Identifiable identifiable) {
        Intrinsics.checkParameterIsNotNull(identifiable, "identifiable");
        return this.idDistributor.decrementAndGet();
    }
}

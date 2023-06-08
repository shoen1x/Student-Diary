package com.mikepenz.fastadapter.utils;

import com.mikepenz.fastadapter.IIdDistributor;
import com.mikepenz.fastadapter.IIdentifyable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¨\u0006\r"}, d2 = {"Lcom/mikepenz/fastadapter/utils/DefaultIdDistributor;", "Identifiable", "Lcom/mikepenz/fastadapter/IIdentifyable;", "Lcom/mikepenz/fastadapter/IIdDistributor;", "()V", "checkId", "identifiable", "(Lcom/mikepenz/fastadapter/IIdentifyable;)Lcom/mikepenz/fastadapter/IIdentifyable;", "checkIds", "", "identifiables", "([Lcom/mikepenz/fastadapter/IIdentifyable;)[Lcom/mikepenz/fastadapter/IIdentifyable;", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultIdDistributor.kt */
public abstract class DefaultIdDistributor<Identifiable extends IIdentifyable> implements IIdDistributor<Identifiable> {
    public List<Identifiable> checkIds(List<? extends Identifiable> identifiables) {
        Intrinsics.checkParameterIsNotNull(identifiables, "identifiables");
        int size = identifiables.size();
        for (int i = 0; i < size; i++) {
            checkId((IIdentifyable) identifiables.get(i));
        }
        return identifiables;
    }

    public Identifiable[] checkIds(Identifiable... identifiables) {
        Intrinsics.checkParameterIsNotNull(identifiables, "identifiables");
        for (IIdentifyable identifiable : identifiables) {
            checkId(identifiable);
        }
        return identifiables;
    }

    public Identifiable checkId(Identifiable identifiable) {
        Intrinsics.checkParameterIsNotNull(identifiable, "identifiable");
        if (identifiable.getIdentifier() == -1) {
            identifiable.setIdentifier(nextId(identifiable));
        }
        return identifiable;
    }
}

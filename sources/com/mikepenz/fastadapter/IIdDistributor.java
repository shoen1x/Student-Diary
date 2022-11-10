package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.utils.DefaultIdDistributorImpl;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000fJ\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000e\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/fastadapter/IIdDistributor;", "Identifiable", "Lcom/mikepenz/fastadapter/IIdentifyable;", "", "checkId", "identifiable", "(Lcom/mikepenz/fastadapter/IIdentifyable;)Lcom/mikepenz/fastadapter/IIdentifyable;", "checkIds", "", "identifiables", "([Lcom/mikepenz/fastadapter/IIdentifyable;)[Lcom/mikepenz/fastadapter/IIdentifyable;", "", "nextId", "", "(Lcom/mikepenz/fastadapter/IIdentifyable;)J", "Companion", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IIdDistributor.kt */
public interface IIdDistributor<Identifiable extends IIdentifyable> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final IIdDistributor<? extends IIdentifyable> DEFAULT = new DefaultIdDistributorImpl();

    Identifiable checkId(Identifiable identifiable);

    List<Identifiable> checkIds(List<? extends Identifiable> list);

    Identifiable[] checkIds(Identifiable... identifiableArr);

    long nextId(Identifiable identifiable);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/fastadapter/IIdDistributor$Companion;", "", "()V", "DEFAULT", "Lcom/mikepenz/fastadapter/IIdDistributor;", "Lcom/mikepenz/fastadapter/IIdentifyable;", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: IIdDistributor.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

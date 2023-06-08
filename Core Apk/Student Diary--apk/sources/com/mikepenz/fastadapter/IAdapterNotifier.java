package com.mikepenz.fastadapter;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ,\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/IAdapterNotifier;", "", "notify", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "newItemsCount", "", "previousItemsCount", "itemsBeforeThisAdapter", "Companion", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IAdapterNotifier.kt */
public interface IAdapterNotifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final IAdapterNotifier DEFAULT = new IAdapterNotifier$Companion$DEFAULT$1();
    public static final IAdapterNotifier LEGACY_DEFAULT = new IAdapterNotifier$Companion$LEGACY_DEFAULT$1();

    boolean notify(FastAdapter<?> fastAdapter, int i, int i2, int i3);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/fastadapter/IAdapterNotifier$Companion;", "", "()V", "DEFAULT", "Lcom/mikepenz/fastadapter/IAdapterNotifier;", "LEGACY_DEFAULT", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: IAdapterNotifier.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

package com.mikepenz.fastadapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/mikepenz/fastadapter/IAdapterNotifier$Companion$DEFAULT$1", "Lcom/mikepenz/fastadapter/IAdapterNotifier;", "notify", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "newItemsCount", "", "previousItemsCount", "itemsBeforeThisAdapter", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IAdapterNotifier.kt */
public final class IAdapterNotifier$Companion$DEFAULT$1 implements IAdapterNotifier {
    IAdapterNotifier$Companion$DEFAULT$1() {
    }

    public boolean notify(FastAdapter<?> fastAdapter, int newItemsCount, int previousItemsCount, int itemsBeforeThisAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        if (newItemsCount > previousItemsCount) {
            if (previousItemsCount > 0) {
                FastAdapter.notifyAdapterItemRangeChanged$default(fastAdapter, itemsBeforeThisAdapter, previousItemsCount, (Object) null, 4, (Object) null);
            }
            fastAdapter.notifyAdapterItemRangeInserted(itemsBeforeThisAdapter + previousItemsCount, newItemsCount - previousItemsCount);
            return false;
        } else if (newItemsCount > 0) {
            FastAdapter.notifyAdapterItemRangeChanged$default(fastAdapter, itemsBeforeThisAdapter, newItemsCount, (Object) null, 4, (Object) null);
            if (newItemsCount >= previousItemsCount) {
                return false;
            }
            fastAdapter.notifyAdapterItemRangeRemoved(itemsBeforeThisAdapter + newItemsCount, previousItemsCount - newItemsCount);
            return false;
        } else if (newItemsCount == 0) {
            fastAdapter.notifyAdapterItemRangeRemoved(itemsBeforeThisAdapter, previousItemsCount);
            return false;
        } else {
            fastAdapter.notifyAdapterDataSetChanged();
            return false;
        }
    }
}

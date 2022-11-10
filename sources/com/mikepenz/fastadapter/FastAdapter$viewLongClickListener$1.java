package com.mikepenz.fastadapter;

import android.view.View;
import com.mikepenz.fastadapter.listeners.LongClickEventHook;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/mikepenz/fastadapter/FastAdapter$viewLongClickListener$1", "Lcom/mikepenz/fastadapter/listeners/LongClickEventHook;", "onLongClick", "", "v", "Landroid/view/View;", "position", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: FastAdapter.kt */
public final class FastAdapter$viewLongClickListener$1 extends LongClickEventHook<Item> {
    FastAdapter$viewLongClickListener$1() {
    }

    public boolean onLongClick(View v, int position, FastAdapter<Item> fastAdapter, Item item) {
        IAdapter adapter;
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!item.isEnabled() || (adapter = fastAdapter.getAdapter(position)) == null) {
            return false;
        }
        Function4<View, IAdapter<Item>, Item, Integer, Boolean> onPreLongClickListener = fastAdapter.getOnPreLongClickListener();
        if (onPreLongClickListener != null && onPreLongClickListener.invoke(v, adapter, item, Integer.valueOf(position)).booleanValue()) {
            return true;
        }
        for (IAdapterExtension ext : fastAdapter.extensionsCache.values()) {
            if (ext.onLongClick(v, position, fastAdapter, item)) {
                return true;
            }
        }
        Function4<View, IAdapter<Item>, Item, Integer, Boolean> onLongClickListener = fastAdapter.getOnLongClickListener();
        if (onLongClickListener == null || !onLongClickListener.invoke(v, adapter, item, Integer.valueOf(position)).booleanValue()) {
            return false;
        }
        return true;
    }
}

package com.mikepenz.fastadapter;

import android.view.View;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/mikepenz/fastadapter/FastAdapter$viewClickListener$1", "Lcom/mikepenz/fastadapter/listeners/ClickEventHook;", "onClick", "", "v", "Landroid/view/View;", "position", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: FastAdapter.kt */
public final class FastAdapter$viewClickListener$1 extends ClickEventHook<Item> {
    FastAdapter$viewClickListener$1() {
    }

    public void onClick(View v, int position, FastAdapter<Item> fastAdapter, Item item) {
        IAdapter adapter;
        Function4<View, IAdapter<Item>, Item, Integer, Boolean> onClickListener;
        Function4 onItemClickListener;
        Function4 onPreItemClickListener;
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (item.isEnabled() && (adapter = fastAdapter.getAdapter(position)) != null) {
            Item item2 = null;
            IClickable iClickable = (IClickable) (!(item instanceof IClickable) ? null : item);
            if (iClickable == null || (onPreItemClickListener = iClickable.getOnPreItemClickListener()) == null || !((Boolean) onPreItemClickListener.invoke(v, adapter, item, Integer.valueOf(position))).booleanValue()) {
                Function4<View, IAdapter<Item>, Item, Integer, Boolean> onPreClickListener = fastAdapter.getOnPreClickListener();
                if (onPreClickListener == null || !onPreClickListener.invoke(v, adapter, item, Integer.valueOf(position)).booleanValue()) {
                    for (IAdapterExtension ext : fastAdapter.extensionsCache.values()) {
                        if (ext.onClick(v, position, fastAdapter, item)) {
                            return;
                        }
                    }
                    if (item instanceof IClickable) {
                        item2 = item;
                    }
                    IClickable iClickable2 = (IClickable) item2;
                    if ((iClickable2 != null && (onItemClickListener = iClickable2.getOnItemClickListener()) != null && ((Boolean) onItemClickListener.invoke(v, adapter, item, Integer.valueOf(position))).booleanValue()) || (onClickListener = fastAdapter.getOnClickListener()) == null || !onClickListener.invoke(v, adapter, item, Integer.valueOf(position)).booleanValue()) {
                    }
                }
            }
        }
    }
}

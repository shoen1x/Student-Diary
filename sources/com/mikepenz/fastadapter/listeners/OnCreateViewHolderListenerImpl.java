package com.mikepenz.fastadapter.listeners;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IHookable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.utils.EventHookUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ3\u0010\r\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListenerImpl;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListener;", "()V", "onPostCreateViewHolder", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "viewHolder", "typeInstance", "(Lcom/mikepenz/fastadapter/FastAdapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Lcom/mikepenz/fastadapter/IItem;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onPreCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Lcom/mikepenz/fastadapter/FastAdapter;Landroid/view/ViewGroup;ILcom/mikepenz/fastadapter/IItem;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnCreateViewHolderListenerImpl.kt */
public class OnCreateViewHolderListenerImpl<Item extends IItem<? extends RecyclerView.ViewHolder>> implements OnCreateViewHolderListener<Item> {
    public RecyclerView.ViewHolder onPreCreateViewHolder(FastAdapter<Item> fastAdapter, ViewGroup parent, int viewType, Item typeInstance) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Intrinsics.checkParameterIsNotNull(typeInstance, "typeInstance");
        return typeInstance.getViewHolder(parent);
    }

    public RecyclerView.ViewHolder onPostCreateViewHolder(FastAdapter<Item> fastAdapter, RecyclerView.ViewHolder viewHolder, Item typeInstance) {
        List eventHooks;
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Intrinsics.checkParameterIsNotNull(typeInstance, "typeInstance");
        EventHookUtilKt.bind(fastAdapter.getEventHooks(), viewHolder);
        IHookable iHookable = (IHookable) (!(typeInstance instanceof IHookable) ? null : typeInstance);
        if (!(iHookable == null || (eventHooks = iHookable.getEventHooks()) == null)) {
            EventHookUtilKt.bind(eventHooks, viewHolder);
        }
        return viewHolder;
    }
}

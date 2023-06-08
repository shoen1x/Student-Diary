package com.mikepenz.fastadapter.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.EventHook;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/ClickEventHook;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/listeners/EventHook;", "()V", "onClick", "", "v", "Landroid/view/View;", "position", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ClickEventHook.kt */
public abstract class ClickEventHook<Item extends IItem<? extends RecyclerView.ViewHolder>> implements EventHook<Item> {
    public abstract void onClick(View view, int i, FastAdapter<Item> fastAdapter, Item item);

    public View onBind(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return EventHook.DefaultImpls.onBind(this, viewHolder);
    }

    public List<View> onBindMany(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return EventHook.DefaultImpls.onBindMany(this, viewHolder);
    }
}

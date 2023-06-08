package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.EventHook;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005R \u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/IHookable;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "eventHooks", "", "Lcom/mikepenz/fastadapter/listeners/EventHook;", "getEventHooks", "()Ljava/util/List;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IHookable.kt */
public interface IHookable<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    List<EventHook<Item>> getEventHooks();
}

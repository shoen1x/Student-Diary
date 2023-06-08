package com.mikepenz.fastadapter.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/EventHook;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "onBind", "Landroid/view/View;", "viewHolder", "onBindMany", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: EventHook.kt */
public interface EventHook<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    View onBind(RecyclerView.ViewHolder viewHolder);

    List<View> onBindMany(RecyclerView.ViewHolder viewHolder);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: EventHook.kt */
    public static final class DefaultImpls {
        public static <Item extends IItem<? extends RecyclerView.ViewHolder>> View onBind(EventHook<Item> $this, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
            return null;
        }

        public static <Item extends IItem<? extends RecyclerView.ViewHolder>> List<View> onBindMany(EventHook<Item> $this, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
            return null;
        }
    }
}

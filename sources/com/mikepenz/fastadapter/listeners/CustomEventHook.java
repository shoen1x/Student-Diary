package com.mikepenz.fastadapter.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.EventHook;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007J\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/CustomEventHook;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/listeners/EventHook;", "()V", "attachEvent", "", "view", "Landroid/view/View;", "viewHolder", "getFastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "getItem", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lcom/mikepenz/fastadapter/IItem;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: CustomEventHook.kt */
public abstract class CustomEventHook<Item extends IItem<? extends RecyclerView.ViewHolder>> implements EventHook<Item> {
    public abstract void attachEvent(View view, RecyclerView.ViewHolder viewHolder);

    public View onBind(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return EventHook.DefaultImpls.onBind(this, viewHolder);
    }

    public List<View> onBindMany(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return EventHook.DefaultImpls.onBindMany(this, viewHolder);
    }

    @Deprecated(message = "Replaced with the new helper inside the FastAdapter class", replaceWith = @ReplaceWith(expression = "FastAdapter.getFromHolderTag(viewHolder)", imports = {"com.mikepenz.fastadapter.FastAdapter"}))
    public final FastAdapter<Item> getFastAdapter(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return FastAdapter.Companion.getFromHolderTag(viewHolder);
    }

    @Deprecated(message = "Replaced with the new helper inside the FastAdapter class", replaceWith = @ReplaceWith(expression = "FastAdapter.getHolderAdapterItem(viewHolder)", imports = {"com.mikepenz.fastadapter.FastAdapter"}))
    public final Item getItem(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        return FastAdapter.Companion.getHolderAdapterItem(viewHolder);
    }
}

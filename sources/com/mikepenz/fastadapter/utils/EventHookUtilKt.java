package com.mikepenz.fastadapter.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.CustomEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.LongClickEventHook;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000\u001a.\u0010\n\u001a\u00020\u0001*\u001c\u0012\u0018\u0012\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00050\u00060\u000b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¨\u0006\f"}, d2 = {"attachToView", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/listeners/EventHook;", "viewHolder", "view", "Landroid/view/View;", "bind", "", "fastadapter"}, k = 2, mv = {1, 1, 16})
/* compiled from: EventHookUtil.kt */
public final class EventHookUtilKt {
    public static final void bind(List<? extends EventHook<? extends IItem<? extends RecyclerView.ViewHolder>>> $this$bind, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull($this$bind, "$this$bind");
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        for (EventHook event : $this$bind) {
            View view = event.onBind(viewHolder);
            if (view != null) {
                attachToView(event, viewHolder, view);
            }
            List<View> views = event.onBindMany(viewHolder);
            if (views != null) {
                for (View v : views) {
                    attachToView(event, viewHolder, v);
                }
            }
        }
    }

    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> void attachToView(EventHook<Item> $this$attachToView, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkParameterIsNotNull($this$attachToView, "$this$attachToView");
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Intrinsics.checkParameterIsNotNull(view, "view");
        if ($this$attachToView instanceof ClickEventHook) {
            view.setOnClickListener(new EventHookUtilKt$attachToView$1($this$attachToView, viewHolder));
        } else if ($this$attachToView instanceof LongClickEventHook) {
            view.setOnLongClickListener(new EventHookUtilKt$attachToView$2($this$attachToView, viewHolder));
        } else if ($this$attachToView instanceof TouchEventHook) {
            view.setOnTouchListener(new EventHookUtilKt$attachToView$3($this$attachToView, viewHolder));
        } else if ($this$attachToView instanceof CustomEventHook) {
            ((CustomEventHook) $this$attachToView).attachEvent(view, viewHolder);
        }
    }
}

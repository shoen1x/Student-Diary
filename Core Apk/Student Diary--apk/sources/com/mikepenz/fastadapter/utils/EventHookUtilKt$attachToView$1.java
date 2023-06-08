package com.mikepenz.fastadapter.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.R;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: EventHookUtil.kt */
final class EventHookUtilKt$attachToView$1 implements View.OnClickListener {
    final /* synthetic */ EventHook $this_attachToView;
    final /* synthetic */ RecyclerView.ViewHolder $viewHolder;

    EventHookUtilKt$attachToView$1(EventHook eventHook, RecyclerView.ViewHolder viewHolder) {
        this.$this_attachToView = eventHook;
        this.$viewHolder = viewHolder;
    }

    public final void onClick(View v) {
        int pos;
        IItem item;
        Object tagAdapter = this.$viewHolder.itemView.getTag(R.id.fastadapter_item_adapter);
        FastAdapter adapter = (FastAdapter) (!(tagAdapter instanceof FastAdapter) ? null : tagAdapter);
        if (adapter != null && (pos = adapter.getHolderAdapterPosition(this.$viewHolder)) != -1 && (item = FastAdapter.Companion.getHolderAdapterItemTag(this.$viewHolder)) != null) {
            EventHook eventHook = this.$this_attachToView;
            if (eventHook != null) {
                Intrinsics.checkExpressionValueIsNotNull(v, "v");
                ((ClickEventHook) eventHook).onClick(v, pos, adapter, item);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.listeners.ClickEventHook<Item>");
        }
    }
}

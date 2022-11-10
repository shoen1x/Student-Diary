package com.mikepenz.fastadapter.utils;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.R;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 1, 16})
/* compiled from: EventHookUtil.kt */
final class EventHookUtilKt$attachToView$3 implements View.OnTouchListener {
    final /* synthetic */ EventHook $this_attachToView;
    final /* synthetic */ RecyclerView.ViewHolder $viewHolder;

    EventHookUtilKt$attachToView$3(EventHook eventHook, RecyclerView.ViewHolder viewHolder) {
        this.$this_attachToView = eventHook;
        this.$viewHolder = viewHolder;
    }

    public final boolean onTouch(View v, MotionEvent e) {
        int pos;
        IItem item;
        Object tagAdapter = this.$viewHolder.itemView.getTag(R.id.fastadapter_item_adapter);
        FastAdapter adapter = (FastAdapter) (!(tagAdapter instanceof FastAdapter) ? null : tagAdapter);
        if (adapter == null || (pos = adapter.getHolderAdapterPosition(this.$viewHolder)) == -1 || (item = FastAdapter.Companion.getHolderAdapterItemTag(this.$viewHolder)) == null) {
            return false;
        }
        EventHook eventHook = this.$this_attachToView;
        if (eventHook != null) {
            Intrinsics.checkExpressionValueIsNotNull(v, "v");
            Intrinsics.checkExpressionValueIsNotNull(e, "e");
            return ((TouchEventHook) eventHook).onTouch(v, e, pos, adapter, item);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.listeners.TouchEventHook<Item>");
    }
}

package com.mikepenz.fastadapter.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J3\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"com/mikepenz/fastadapter/listeners/LongClickEventHookKt$addLongClickListener$2", "Lcom/mikepenz/fastadapter/listeners/LongClickEventHook;", "onBind", "Landroid/view/View;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBindMany", "", "onLongClick", "", "v", "position", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: LongClickEventHook.kt */
public final class LongClickEventHookKt$addLongClickListener$2 extends LongClickEventHook<Item> {
    final /* synthetic */ Function4 $onLongClick;
    final /* synthetic */ Function1 $resolveView;
    final /* synthetic */ Function1 $resolveViews;

    public LongClickEventHookKt$addLongClickListener$2(Function1 $captured_local_variable$0, Function1 $captured_local_variable$1, Function4 $captured_local_variable$2) {
        this.$resolveView = $captured_local_variable$0;
        this.$resolveViews = $captured_local_variable$1;
        this.$onLongClick = $captured_local_variable$2;
    }

    public View onBind(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Intrinsics.reifiedOperationMarker(3, "VH");
        if (viewHolder instanceof RecyclerView.ViewHolder) {
            return (View) this.$resolveView.invoke(viewHolder);
        }
        return null;
    }

    public List<View> onBindMany(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Intrinsics.reifiedOperationMarker(3, "VH");
        return viewHolder instanceof RecyclerView.ViewHolder ? (List) this.$resolveViews.invoke(viewHolder) : super.onBindMany(viewHolder);
    }

    public boolean onLongClick(View v, int position, FastAdapter<Item> fastAdapter, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        return ((Boolean) this.$onLongClick.invoke(v, Integer.valueOf(position), fastAdapter, item)).booleanValue();
    }
}

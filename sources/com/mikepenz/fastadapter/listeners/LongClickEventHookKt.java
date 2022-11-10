package com.mikepenz.fastadapter.listeners;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a×\u0001\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0016\b\u0001\u0010\u0004\u0018\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005j\u0002`\u0006*\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0016\b\u0004\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u001c\b\u0006\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f0\t2h\b\u0004\u0010\r\u001ab\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00040\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000eH\b¨\u0006\u0017"}, d2 = {"addLongClickListener", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/FastAdapter;", "resolveView", "Lkotlin/Function1;", "Landroid/view/View;", "resolveViews", "", "onLongClick", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "v", "", "position", "fastAdapter", "item", "", "fastadapter"}, k = 2, mv = {1, 1, 16})
/* compiled from: LongClickEventHook.kt */
public final class LongClickEventHookKt {
    public static /* synthetic */ void addLongClickListener$default(FastAdapter $this$addLongClickListener, Function1 resolveView, Function1 resolveViews, Function4 onLongClick, int i, Object obj) {
        if ((i & 2) != 0) {
            resolveViews = LongClickEventHookKt$addLongClickListener$1.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull($this$addLongClickListener, "$this$addLongClickListener");
        Intrinsics.checkParameterIsNotNull(resolveView, "resolveView");
        Intrinsics.checkParameterIsNotNull(resolveViews, "resolveViews");
        Intrinsics.checkParameterIsNotNull(onLongClick, "onLongClick");
        Intrinsics.needClassReification();
        $this$addLongClickListener.addEventHook(new LongClickEventHookKt$addLongClickListener$2(resolveView, resolveViews, onLongClick));
    }

    public static final /* synthetic */ <VH extends RecyclerView.ViewHolder, Item extends IItem<? extends RecyclerView.ViewHolder>> void addLongClickListener(FastAdapter<Item> $this$addLongClickListener, Function1<? super VH, ? extends View> resolveView, Function1<? super VH, ? extends List<? extends View>> resolveViews, Function4<? super View, ? super Integer, ? super FastAdapter<Item>, ? super Item, Boolean> onLongClick) {
        Intrinsics.checkParameterIsNotNull($this$addLongClickListener, "$this$addLongClickListener");
        Intrinsics.checkParameterIsNotNull(resolveView, "resolveView");
        Intrinsics.checkParameterIsNotNull(resolveViews, "resolveViews");
        Intrinsics.checkParameterIsNotNull(onLongClick, "onLongClick");
        Intrinsics.needClassReification();
        $this$addLongClickListener.addEventHook(new LongClickEventHookKt$addLongClickListener$2(resolveView, resolveViews, onLongClick));
    }
}

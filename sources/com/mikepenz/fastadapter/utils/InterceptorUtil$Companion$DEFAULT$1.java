package com.mikepenz.fastadapter.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001j\u0002`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001j\u0002`\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "it", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: InterceptorUtil.kt */
final class InterceptorUtil$Companion$DEFAULT$1 extends Lambda implements Function1<IItem<? extends RecyclerView.ViewHolder>, IItem<? extends RecyclerView.ViewHolder>> {
    public static final InterceptorUtil$Companion$DEFAULT$1 INSTANCE = new InterceptorUtil$Companion$DEFAULT$1();

    InterceptorUtil$Companion$DEFAULT$1() {
        super(1);
    }

    public final IItem<? extends RecyclerView.ViewHolder> invoke(IItem<? extends RecyclerView.ViewHolder> it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return it;
    }
}

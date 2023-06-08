package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "it", "invoke", "(Lcom/mikepenz/fastadapter/IItem;)Z"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$saveInstanceState$expandedItems$2 extends Lambda implements Function1<Item, Boolean> {
    public static final ExpandableExtension$saveInstanceState$expandedItems$2 INSTANCE = new ExpandableExtension$saveInstanceState$expandedItems$2();

    ExpandableExtension$saveInstanceState$expandedItems$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((IItem) obj));
    }

    public final boolean invoke(Item it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        return ExpandableExtensionKt.isExpanded(it);
    }
}

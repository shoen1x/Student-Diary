package com.mikepenz.fastadapter.expandable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "it", "", "invoke", "(I)Lcom/mikepenz/fastadapter/IItem;"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$saveInstanceState$expandedItems$1 extends Lambda implements Function1<Integer, Item> {
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$saveInstanceState$expandedItems$1(ExpandableExtension expandableExtension) {
        super(1);
        this.this$0 = expandableExtension;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Item invoke(int it) {
        return this.this$0.fastAdapter.getItem(it);
    }
}

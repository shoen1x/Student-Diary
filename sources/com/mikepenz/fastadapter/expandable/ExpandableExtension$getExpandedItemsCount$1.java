package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/mikepenz/fastadapter/IExpandable;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$getExpandedItemsCount$1 extends Lambda implements Function1<Integer, IExpandable<?>> {
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$getExpandedItemsCount$1(ExpandableExtension expandableExtension) {
        super(1);
        this.this$0 = expandableExtension;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final IExpandable<?> invoke(int it) {
        IItem item = this.this$0.fastAdapter.getItem(it);
        if (!(item instanceof IExpandable)) {
            item = null;
        }
        return (IExpandable) item;
    }
}

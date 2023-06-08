package com.mikepenz.fastadapter.expandable;

import android.util.SparseIntArray;
import com.mikepenz.fastadapter.IExpandable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "expandableItem", "Lcom/mikepenz/fastadapter/IExpandable;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$expanded$1 extends Lambda implements Function1<IExpandable<?>, Unit> {
    final /* synthetic */ SparseIntArray $expandedItems;
    final /* synthetic */ Ref.IntRef $i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$expanded$1(SparseIntArray sparseIntArray, Ref.IntRef intRef) {
        super(1);
        this.$expandedItems = sparseIntArray;
        this.$i = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IExpandable<?>) (IExpandable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IExpandable<?> expandableItem) {
        Intrinsics.checkParameterIsNotNull(expandableItem, "expandableItem");
        if (expandableItem.isExpanded()) {
            this.$expandedItems.put(this.$i.element, expandableItem.getSubItems().size());
        }
    }
}

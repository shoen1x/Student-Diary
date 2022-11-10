package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IParentItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "<anonymous parameter 0>", "Lcom/mikepenz/fastadapter/IExpandable;", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$getExpandedItemsRootLevel$1 extends Lambda implements Function2<IExpandable<?>, IParentItem<?>, Unit> {
    final /* synthetic */ List $expandedItemsList;
    final /* synthetic */ Ref.IntRef $i;
    final /* synthetic */ IItem $item;
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$getExpandedItemsRootLevel$1(ExpandableExtension expandableExtension, Ref.IntRef intRef, IItem iItem, List list) {
        super(2);
        this.this$0 = expandableExtension;
        this.$i = intRef;
        this.$item = iItem;
        this.$expandedItemsList = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IExpandable<?>) (IExpandable) obj, (IParentItem<?>) (IParentItem) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(IExpandable<?> $noName_0, IParentItem<?> parent) {
        Intrinsics.checkParameterIsNotNull($noName_0, "<anonymous parameter 0>");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        if (ExpandableExtensionKt.isExpanded(parent)) {
            this.$i.element += parent.getSubItems().size();
            if (parent != this.$item) {
                if ((!(parent instanceof IItem) ? null : parent) != null) {
                    this.$expandedItemsList.add(Integer.valueOf(this.this$0.fastAdapter.getPosition(parent)));
                }
            }
        }
    }
}

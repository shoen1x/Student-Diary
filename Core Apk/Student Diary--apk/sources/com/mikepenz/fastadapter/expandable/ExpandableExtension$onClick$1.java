package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IExpandable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "expandableItem", "Lcom/mikepenz/fastadapter/IExpandable;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$onClick$1 extends Lambda implements Function1<IExpandable<?>, Unit> {
    final /* synthetic */ int $pos;
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$onClick$1(ExpandableExtension expandableExtension, int i) {
        super(1);
        this.this$0 = expandableExtension;
        this.$pos = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IExpandable<?>) (IExpandable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IExpandable<?> expandableItem) {
        Intrinsics.checkParameterIsNotNull(expandableItem, "expandableItem");
        if (expandableItem.isAutoExpanding()) {
            ExpandableExtension.toggleExpandable$default(this.this$0, this.$pos, false, 2, (Object) null);
        }
        if (this.this$0.isOnlyOneExpandedItem() && (!expandableItem.getSubItems().isEmpty())) {
            List<Integer> expandedItemsSameLevel = this.this$0.getExpandedItemsSameLevel(this.$pos);
            int i = expandedItemsSameLevel.size();
            while (true) {
                i--;
                if (i < 0) {
                    return;
                }
                if (expandedItemsSameLevel.get(i).intValue() != this.$pos) {
                    this.this$0.collapse(expandedItemsSameLevel.get(i).intValue(), true);
                }
            }
        }
    }
}

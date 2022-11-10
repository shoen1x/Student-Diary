package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItemAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "expandable", "Lcom/mikepenz/fastadapter/IExpandable;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$notifyAdapterSubItemsChanged$1 extends Lambda implements Function1<IExpandable<?>, Integer> {
    final /* synthetic */ int $position;
    final /* synthetic */ int $previousCount;
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$notifyAdapterSubItemsChanged$1(ExpandableExtension expandableExtension, int i, int i2) {
        super(1);
        this.this$0 = expandableExtension;
        this.$position = i;
        this.$previousCount = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke((IExpandable<?>) (IExpandable) obj));
    }

    public final int invoke(IExpandable<?> expandable) {
        Intrinsics.checkParameterIsNotNull(expandable, "expandable");
        IAdapter adapter = this.this$0.fastAdapter.getAdapter(this.$position);
        if (adapter != null && (adapter instanceof IItemAdapter)) {
            IItemAdapter iItemAdapter = null;
            IItemAdapter iItemAdapter2 = (IItemAdapter) (!(adapter instanceof IItemAdapter) ? null : adapter);
            if (iItemAdapter2 != null) {
                iItemAdapter2.removeRange(this.$position + 1, this.$previousCount);
            }
            List subItems = expandable.getSubItems();
            if (adapter instanceof IItemAdapter) {
                iItemAdapter = adapter;
            }
            IItemAdapter iItemAdapter3 = iItemAdapter;
            if (iItemAdapter3 != null) {
                iItemAdapter3.add(this.$position + 1, subItems);
            }
        }
        return expandable.getSubItems().size();
    }
}

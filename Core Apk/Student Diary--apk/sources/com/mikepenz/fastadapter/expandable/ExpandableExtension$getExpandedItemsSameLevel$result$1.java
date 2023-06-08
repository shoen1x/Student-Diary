package com.mikepenz.fastadapter.expandable;

import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0014\b\u0000\u0010\u0003*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004j\u0002`\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "child", "Lcom/mikepenz/fastadapter/IExpandable;", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
final class ExpandableExtension$getExpandedItemsSameLevel$result$1 extends Lambda implements Function2<IExpandable<?>, IParentItem<?>, List<? extends Integer>> {
    final /* synthetic */ ExpandableExtension this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableExtension$getExpandedItemsSameLevel$result$1(ExpandableExtension expandableExtension) {
        super(2);
        this.this$0 = expandableExtension;
    }

    public final List<Integer> invoke(final IExpandable<?> child, IParentItem<?> parent) {
        Intrinsics.checkParameterIsNotNull(child, "child");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(parent.getSubItems()), new Function1<ISubItem<?>, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((ISubItem<?>) (ISubItem) obj));
            }

            public final boolean invoke(ISubItem<?> it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return ExpandableExtensionKt.isExpanded(it) && it != child;
            }
        }), AnonymousClass2.INSTANCE), new Function1<Item, Integer>(this) {
            final /* synthetic */ ExpandableExtension$getExpandedItemsSameLevel$result$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke((IItem) obj));
            }

            public final int invoke(Item it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return this.this$0.this$0.fastAdapter.getPosition(it);
            }
        }));
    }
}

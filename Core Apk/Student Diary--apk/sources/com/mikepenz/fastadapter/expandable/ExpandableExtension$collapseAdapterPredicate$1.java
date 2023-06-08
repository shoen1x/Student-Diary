package com.mikepenz.fastadapter.expandable;

import androidx.collection.ArraySet;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J3\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011R\u0018\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/mikepenz/fastadapter/expandable/ExpandableExtension$collapseAdapterPredicate$1", "Lcom/mikepenz/fastadapter/utils/AdapterPredicate;", "allowedParents", "Landroidx/collection/ArraySet;", "Lcom/mikepenz/fastadapter/IItem;", "expandedItemsCount", "", "apply", "", "lastParentAdapter", "Lcom/mikepenz/fastadapter/IAdapter;", "lastParentPosition", "item", "position", "(Lcom/mikepenz/fastadapter/IAdapter;ILcom/mikepenz/fastadapter/IItem;I)Z", "collapse", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
public final class ExpandableExtension$collapseAdapterPredicate$1 implements AdapterPredicate<Item> {
    /* access modifiers changed from: private */
    public ArraySet<IItem<?>> allowedParents = new ArraySet<>();
    /* access modifiers changed from: private */
    public int expandedItemsCount;

    ExpandableExtension$collapseAdapterPredicate$1() {
    }

    public boolean apply(IAdapter<Item> lastParentAdapter, int lastParentPosition, Item item, int position) {
        Intrinsics.checkParameterIsNotNull(lastParentAdapter, "lastParentAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (position == -1) {
            return false;
        }
        if (this.allowedParents.size() > 0) {
            IParentItem iParentItem = null;
            ISubItem iSubItem = (ISubItem) (!(item instanceof ISubItem) ? null : item);
            if (iSubItem != null) {
                iParentItem = iSubItem.getParent();
            }
            IParentItem parent = iParentItem;
            if (parent == null || !this.allowedParents.contains(parent)) {
                return true;
            }
        }
        ExpandableExtensionKt.ifExpandable(item, new ExpandableExtension$collapseAdapterPredicate$1$apply$1(this, item));
        return false;
    }

    public final int collapse(int position, FastAdapter<Item> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        this.expandedItemsCount = 0;
        this.allowedParents.clear();
        fastAdapter.recursive(this, position, true);
        return this.expandedItemsCount;
    }
}

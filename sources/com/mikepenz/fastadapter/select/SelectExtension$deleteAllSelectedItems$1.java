package com.mikepenz.fastadapter.select;

import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J3\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/mikepenz/fastadapter/select/SelectExtension$deleteAllSelectedItems$1", "Lcom/mikepenz/fastadapter/utils/AdapterPredicate;", "apply", "", "lastParentAdapter", "Lcom/mikepenz/fastadapter/IAdapter;", "lastParentPosition", "", "item", "position", "(Lcom/mikepenz/fastadapter/IAdapter;ILcom/mikepenz/fastadapter/IItem;I)Z", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: SelectExtension.kt */
public final class SelectExtension$deleteAllSelectedItems$1 implements AdapterPredicate<Item> {
    final /* synthetic */ ArrayList $positions;

    SelectExtension$deleteAllSelectedItems$1(ArrayList $captured_local_variable$0) {
        this.$positions = $captured_local_variable$0;
    }

    public boolean apply(IAdapter<Item> lastParentAdapter, int lastParentPosition, Item item, int position) {
        IParentItem<?> parent;
        List<ISubItem<?>> subItems;
        Intrinsics.checkParameterIsNotNull(lastParentAdapter, "lastParentAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!item.isSelected()) {
            return false;
        }
        IExpandable expandable = (IExpandable) (!(item instanceof IExpandable) ? null : item);
        if (!(expandable == null || (parent = expandable.getParent()) == null || (subItems = parent.getSubItems()) == null)) {
            subItems.remove(item);
        }
        if (position == -1) {
            return false;
        }
        this.$positions.add(Integer.valueOf(position));
        return false;
    }
}

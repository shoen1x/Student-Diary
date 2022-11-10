package com.mikepenz.fastadapter.expandable.items;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.MutableSubItemList;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R8\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00172\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/mikepenz/fastadapter/expandable/items/AbstractExpandableItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/items/AbstractItem;", "Lcom/mikepenz/fastadapter/IItem;", "Lcom/mikepenz/fastadapter/IExpandable;", "()V", "isAutoExpanding", "", "()Z", "isExpanded", "setExpanded", "(Z)V", "<anonymous parameter 0>", "isSelectable", "setSelectable", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "getParent", "()Lcom/mikepenz/fastadapter/IParentItem;", "setParent", "(Lcom/mikepenz/fastadapter/IParentItem;)V", "value", "", "Lcom/mikepenz/fastadapter/ISubItem;", "subItems", "getSubItems", "()Ljava/util/List;", "setSubItems", "(Ljava/util/List;)V", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractExpandableItem.kt */
public abstract class AbstractExpandableItem<VH extends RecyclerView.ViewHolder> extends AbstractItem<VH> implements IItem<VH>, IExpandable<VH> {
    private final boolean isAutoExpanding = true;
    private boolean isExpanded;
    private IParentItem<?> parent;
    private List<ISubItem<?>> subItems = new MutableSubItemList(this, (List) null, 2, (DefaultConstructorMarker) null);

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public IParentItem<?> getParent() {
        return this.parent;
    }

    public void setParent(IParentItem<?> iParentItem) {
        this.parent = iParentItem;
    }

    public List<ISubItem<?>> getSubItems() {
        return this.subItems;
    }

    public void setSubItems(List<ISubItem<?>> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.subItems = value;
        for (ISubItem<?> item : value) {
            item.setParent(this);
        }
    }

    public boolean isAutoExpanding() {
        return this.isAutoExpanding;
    }

    public boolean isSelectable() {
        Collection subItems2 = getSubItems();
        return subItems2 == null || subItems2.isEmpty();
    }

    public void setSelectable(boolean $noName_0) {
    }
}

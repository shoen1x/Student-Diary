package com.mikepenz.fastadapter.expandable.items;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.MutableSubItemList;
import com.mikepenz.fastadapter.items.ModelAbstractItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u0003*\b\b\u0003\u0010\u0004*\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u00072\b\u0012\u0004\u0012\u0002H\u00040\u0003B\r\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tR\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR8\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/mikepenz/fastadapter/expandable/items/ModelAbstractExpandableItem;", "Model", "Parent", "Lcom/mikepenz/fastadapter/IExpandable;", "VH", "SubItem", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/items/ModelAbstractItem;", "model", "(Ljava/lang/Object;)V", "_subItems", "", "Lcom/mikepenz/fastadapter/ISubItem;", "isAutoExpanding", "", "()Z", "isExpanded", "setExpanded", "(Z)V", "<anonymous parameter 0>", "isSelectable", "setSelectable", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "getParent", "()Lcom/mikepenz/fastadapter/IParentItem;", "setParent", "(Lcom/mikepenz/fastadapter/IParentItem;)V", "value", "subItems", "getSubItems", "()Ljava/util/List;", "setSubItems", "(Ljava/util/List;)V", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: ModelAbstractExpandableItem.kt */
public abstract class ModelAbstractExpandableItem<Model, Parent extends IExpandable<VH>, SubItem extends IExpandable<VH>, VH extends RecyclerView.ViewHolder> extends ModelAbstractItem<Model, VH> implements IExpandable<VH> {
    private List<ISubItem<?>> _subItems = new MutableSubItemList(this, (List) null, 2, (DefaultConstructorMarker) null);
    private final boolean isAutoExpanding = true;
    private boolean isExpanded;
    private IParentItem<?> parent;

    public ModelAbstractExpandableItem(Model model) {
        super(model);
    }

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

    public void setSubItems(List<ISubItem<?>> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._subItems = value;
        for (ISubItem<?> item : this._subItems) {
            item.setParent(this);
        }
    }

    public List<ISubItem<?>> getSubItems() {
        return this._subItems;
    }

    public boolean isAutoExpanding() {
        return this.isAutoExpanding;
    }

    public boolean isSelectable() {
        return !this._subItems.isEmpty();
    }

    public void setSelectable(boolean $noName_0) {
    }
}

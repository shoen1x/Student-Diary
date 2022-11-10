package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u001e\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/mikepenz/fastadapter/ISubItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IItem;", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "getParent", "()Lcom/mikepenz/fastadapter/IParentItem;", "setParent", "(Lcom/mikepenz/fastadapter/IParentItem;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ISubItem.kt */
public interface ISubItem<VH extends RecyclerView.ViewHolder> extends IItem<VH> {
    IParentItem<?> getParent();

    void setParent(IParentItem<?> iParentItem);
}

package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/IExpandable;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IParentItem;", "Lcom/mikepenz/fastadapter/ISubItem;", "isAutoExpanding", "", "()Z", "isExpanded", "setExpanded", "(Z)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IExpandable.kt */
public interface IExpandable<VH extends RecyclerView.ViewHolder> extends IParentItem<VH>, ISubItem<VH> {
    boolean isAutoExpanding();

    boolean isExpanded();

    void setExpanded(boolean z);
}

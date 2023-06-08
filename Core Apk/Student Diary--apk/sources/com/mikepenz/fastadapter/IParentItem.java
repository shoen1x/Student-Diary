package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\"\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/IParentItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IItem;", "subItems", "", "Lcom/mikepenz/fastadapter/ISubItem;", "getSubItems", "()Ljava/util/List;", "setSubItems", "(Ljava/util/List;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IParentItem.kt */
public interface IParentItem<VH extends RecyclerView.ViewHolder> extends IItem<VH> {
    List<ISubItem<?>> getSubItems();

    void setSubItems(List<ISubItem<?>> list);
}

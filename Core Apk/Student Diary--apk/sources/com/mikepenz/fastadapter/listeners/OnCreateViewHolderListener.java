package com.mikepenz.fastadapter.listeners;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J+\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ3\u0010\f\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListener;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "onPostCreateViewHolder", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "viewHolder", "typeInstance", "(Lcom/mikepenz/fastadapter/FastAdapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Lcom/mikepenz/fastadapter/IItem;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onPreCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Lcom/mikepenz/fastadapter/FastAdapter;Landroid/view/ViewGroup;ILcom/mikepenz/fastadapter/IItem;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnCreateViewHolderListener.kt */
public interface OnCreateViewHolderListener<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    RecyclerView.ViewHolder onPostCreateViewHolder(FastAdapter<Item> fastAdapter, RecyclerView.ViewHolder viewHolder, Item item);

    RecyclerView.ViewHolder onPreCreateViewHolder(FastAdapter<Item> fastAdapter, ViewGroup viewGroup, int i, Item item);
}

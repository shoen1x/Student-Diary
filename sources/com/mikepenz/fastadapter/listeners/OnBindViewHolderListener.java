package com.mikepenz.fastadapter.listeners;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListener;", "", "onBindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "payloads", "", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "unBindViewHolder", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnBindViewHolderListener.kt */
public interface OnBindViewHolderListener {
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list);

    boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder, int i);

    void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, int i);

    void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder, int i);

    void unBindViewHolder(RecyclerView.ViewHolder viewHolder, int i);
}

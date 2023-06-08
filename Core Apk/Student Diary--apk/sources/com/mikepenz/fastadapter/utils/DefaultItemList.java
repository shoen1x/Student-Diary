package com.mikepenz.fastadapter.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/mikepenz/fastadapter/utils/DefaultItemList;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IItemList;", "()V", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "setFastAdapter", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultItemList.kt */
public abstract class DefaultItemList<Item extends IItem<? extends RecyclerView.ViewHolder>> implements IItemList<Item> {
    private FastAdapter<Item> fastAdapter;

    public final FastAdapter<Item> getFastAdapter() {
        return this.fastAdapter;
    }

    public final void setFastAdapter(FastAdapter<Item> fastAdapter2) {
        this.fastAdapter = fastAdapter2;
    }
}

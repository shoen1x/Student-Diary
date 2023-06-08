package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/mikepenz/fastadapter/AbstractAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IAdapter;", "()V", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "setFastAdapter", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "order", "", "getOrder", "()I", "setOrder", "(I)V", "mapPossibleTypes", "", "items", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractAdapter.kt */
public abstract class AbstractAdapter<Item extends IItem<? extends RecyclerView.ViewHolder>> implements IAdapter<Item> {
    private FastAdapter<Item> fastAdapter;
    private int order = -1;

    public FastAdapter<Item> getFastAdapter() {
        return this.fastAdapter;
    }

    public void setFastAdapter(FastAdapter<Item> fastAdapter2) {
        this.fastAdapter = fastAdapter2;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void mapPossibleTypes(Iterable<? extends Item> items) {
        FastAdapter fastAdapter2 = getFastAdapter();
        if (fastAdapter2 != null && items != null) {
            Iterator<? extends Item> it = items.iterator();
            while (it.hasNext()) {
                fastAdapter2.registerTypeInstance((IItem) it.next());
            }
        }
    }
}

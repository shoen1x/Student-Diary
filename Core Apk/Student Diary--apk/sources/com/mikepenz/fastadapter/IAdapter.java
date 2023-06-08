package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J\u0015\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0018\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/mikepenz/fastadapter/IAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "adapterItemCount", "", "getAdapterItemCount", "()I", "adapterItems", "", "getAdapterItems", "()Ljava/util/List;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "setFastAdapter", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "order", "getOrder", "setOrder", "(I)V", "getAdapterItem", "position", "(I)Lcom/mikepenz/fastadapter/IItem;", "getAdapterPosition", "item", "(Lcom/mikepenz/fastadapter/IItem;)I", "identifier", "", "getGlobalPosition", "mapPossibleTypes", "", "items", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IAdapter.kt */
public interface IAdapter<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    Item getAdapterItem(int i);

    int getAdapterItemCount();

    List<Item> getAdapterItems();

    int getAdapterPosition(long j);

    int getAdapterPosition(Item item);

    FastAdapter<Item> getFastAdapter();

    int getGlobalPosition(int i);

    int getOrder();

    void mapPossibleTypes(Iterable<? extends Item> iterable);

    void setFastAdapter(FastAdapter<Item> fastAdapter);

    void setOrder(int i);
}

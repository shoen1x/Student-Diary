package com.mikepenz.fastadapter.listeners;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/ItemFilterListener;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "itemsFiltered", "", "constraint", "", "results", "", "onReset", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ItemFilterListener.kt */
public interface ItemFilterListener<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    void itemsFiltered(CharSequence charSequence, List<? extends Item> list);

    void onReset();
}

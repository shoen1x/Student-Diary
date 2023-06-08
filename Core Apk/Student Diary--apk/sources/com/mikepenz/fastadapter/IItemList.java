package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00020\u0010H&J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H&J\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0010H¦\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J&\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0010H¦\u0002¢\u0006\u0002\u0010!J)\u0010\u001f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H¦\u0002J\u001e\u0010$\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010%\u001a\u00020\u0007H&J\b\u0010&\u001a\u00020\u0010H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006'"}, d2 = {"Lcom/mikepenz/fastadapter/IItemList;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "isEmpty", "", "()Z", "items", "", "getItems", "()Ljava/util/List;", "addAll", "", "position", "", "", "preItemCount", "clear", "get", "(I)Lcom/mikepenz/fastadapter/IItem;", "getAdapterPosition", "identifier", "", "move", "fromPosition", "toPosition", "remove", "removeRange", "itemCount", "set", "item", "(ILcom/mikepenz/fastadapter/IItem;I)V", "adapterNotifier", "Lcom/mikepenz/fastadapter/IAdapterNotifier;", "setNewList", "notify", "size", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IItemList.kt */
public interface IItemList<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    void addAll(int i, List<? extends Item> list, int i2);

    void addAll(List<? extends Item> list, int i);

    void clear(int i);

    Item get(int i);

    int getAdapterPosition(long j);

    List<Item> getItems();

    boolean isEmpty();

    void move(int i, int i2, int i3);

    void remove(int i, int i2);

    void removeRange(int i, int i2, int i3);

    void set(int i, Item item, int i2);

    void set(List<? extends Item> list, int i, IAdapterNotifier iAdapterNotifier);

    void setNewList(List<? extends Item> list, boolean z);

    int size();
}

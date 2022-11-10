package com.mikepenz.fastadapter.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0017\b\u0007\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u001e\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J \u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J&\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010%J)\u0010#\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001e\u0010(\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\b¨\u0006+"}, d2 = {"Lcom/mikepenz/fastadapter/utils/DefaultItemListImpl;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/utils/DefaultItemList;", "mItems", "", "(Ljava/util/List;)V", "isEmpty", "", "()Z", "items", "getItems", "()Ljava/util/List;", "getMItems", "setMItems", "addAll", "", "position", "", "", "preItemCount", "clear", "get", "(I)Lcom/mikepenz/fastadapter/IItem;", "getAdapterPosition", "identifier", "", "move", "fromPosition", "toPosition", "remove", "removeRange", "itemCount", "set", "item", "(ILcom/mikepenz/fastadapter/IItem;I)V", "adapterNotifier", "Lcom/mikepenz/fastadapter/IAdapterNotifier;", "setNewList", "notify", "size", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultItemListImpl.kt */
public class DefaultItemListImpl<Item extends IItem<? extends RecyclerView.ViewHolder>> extends DefaultItemList<Item> {
    private List<Item> mItems;

    public DefaultItemListImpl() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public DefaultItemListImpl(List<Item> mItems2) {
        Intrinsics.checkParameterIsNotNull(mItems2, "mItems");
        this.mItems = mItems2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultItemListImpl(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* access modifiers changed from: protected */
    public final List<Item> getMItems() {
        return this.mItems;
    }

    /* access modifiers changed from: protected */
    public final void setMItems(List<Item> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.mItems = list;
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public boolean isEmpty() {
        return this.mItems.isEmpty();
    }

    public Item get(int position) {
        return (IItem) this.mItems.get(position);
    }

    public int getAdapterPosition(long identifier) {
        int index$iv = 0;
        for (IItem it : this.mItems) {
            if (it.getIdentifier() == identifier) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    public void remove(int position, int preItemCount) {
        this.mItems.remove(position - preItemCount);
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemRemoved(position);
        }
    }

    public void removeRange(int position, int itemCount, int preItemCount) {
        int saveItemCount = Math.min(itemCount, (this.mItems.size() - position) + preItemCount);
        for (int i = 0; i < saveItemCount; i++) {
            this.mItems.remove(position - preItemCount);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemRangeRemoved(position, saveItemCount);
        }
    }

    public void move(int fromPosition, int toPosition, int preItemCount) {
        this.mItems.remove(fromPosition - preItemCount);
        this.mItems.add(toPosition - preItemCount, (IItem) this.mItems.get(fromPosition - preItemCount));
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemMoved(fromPosition, toPosition);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public void clear(int preItemCount) {
        int size = this.mItems.size();
        this.mItems.clear();
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemRangeRemoved(preItemCount, size);
        }
    }

    public void set(int position, Item item, int preItemCount) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        this.mItems.set(position - preItemCount, item);
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            FastAdapter.notifyAdapterItemChanged$default(fastAdapter, position, (Object) null, 2, (Object) null);
        }
    }

    public void addAll(List<? extends Item> items, int preItemCount) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        int countBefore = this.mItems.size();
        this.mItems.addAll(items);
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemRangeInserted(preItemCount + countBefore, items.size());
        }
    }

    public void addAll(int position, List<? extends Item> items, int preItemCount) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        this.mItems.addAll(position - preItemCount, items);
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterItemRangeInserted(position, items.size());
        }
    }

    public void set(List<? extends Item> items, int preItemCount, IAdapterNotifier adapterNotifier) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        int newItemsCount = items.size();
        int previousItemsCount = this.mItems.size();
        List<Item> list = this.mItems;
        if (items != list) {
            if (!list.isEmpty()) {
                this.mItems.clear();
            }
            this.mItems.addAll(items);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            (adapterNotifier != null ? adapterNotifier : IAdapterNotifier.DEFAULT).notify(fastAdapter, newItemsCount, previousItemsCount, preItemCount);
        }
    }

    public void setNewList(List<? extends Item> items, boolean notify) {
        FastAdapter fastAdapter;
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        this.mItems = new ArrayList(items);
        if (notify && (fastAdapter = getFastAdapter()) != null) {
            fastAdapter.notifyAdapterDataSetChanged();
        }
    }
}

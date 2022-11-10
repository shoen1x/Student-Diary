package com.mikepenz.fastadapter.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0017\b\u0016\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bB%\b\u0016\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001e\u0010\u0018\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001aH\u0007R.\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/mikepenz/fastadapter/utils/ComparableItemListImpl;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/utils/DefaultItemListImpl;", "comparator", "Ljava/util/Comparator;", "(Ljava/util/Comparator;)V", "items", "", "(Ljava/util/Comparator;Ljava/util/List;)V", "<set-?>", "getComparator", "()Ljava/util/Comparator;", "addAll", "", "position", "", "", "preItemCount", "move", "fromPosition", "toPosition", "setNewList", "notify", "", "withComparator", "sortNow", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ComparableItemListImpl.kt */
public final class ComparableItemListImpl<Item extends IItem<? extends RecyclerView.ViewHolder>> extends DefaultItemListImpl<Item> {
    private Comparator<Item> comparator;

    public final ComparableItemListImpl<Item> withComparator(Comparator<Item> comparator2) {
        return withComparator$default(this, comparator2, false, 2, (Object) null);
    }

    public final Comparator<Item> getComparator() {
        return this.comparator;
    }

    public ComparableItemListImpl(Comparator<Item> comparator2) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        setMItems(new ArrayList());
        this.comparator = comparator2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComparableItemListImpl(Comparator<Item> comparator2, List<Item> items) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        setMItems(items);
        this.comparator = comparator2;
    }

    public static /* synthetic */ ComparableItemListImpl withComparator$default(ComparableItemListImpl comparableItemListImpl, Comparator comparator2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return comparableItemListImpl.withComparator(comparator2, z);
    }

    public final ComparableItemListImpl<Item> withComparator(Comparator<Item> comparator2, boolean sortNow) {
        this.comparator = comparator2;
        if (comparator2 != null && sortNow) {
            Collections.sort(getMItems(), this.comparator);
            FastAdapter fastAdapter = getFastAdapter();
            if (fastAdapter != null) {
                fastAdapter.notifyAdapterDataSetChanged();
            }
        }
        return this;
    }

    public void move(int fromPosition, int toPosition, int preItemCount) {
        getMItems().remove(fromPosition - preItemCount);
        getMItems().add(toPosition - preItemCount, (IItem) getMItems().get(fromPosition - preItemCount));
        if (this.comparator != null) {
            Collections.sort(getMItems(), this.comparator);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterDataSetChanged();
        }
    }

    public void addAll(List<? extends Item> items, int preItemCount) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        getMItems().addAll(items);
        if (this.comparator != null) {
            Collections.sort(getMItems(), this.comparator);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterDataSetChanged();
        }
    }

    public void addAll(int position, List<? extends Item> items, int preItemCount) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        getMItems().addAll(position - preItemCount, items);
        if (this.comparator != null) {
            Collections.sort(getMItems(), this.comparator);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.notifyAdapterDataSetChanged();
        }
    }

    public void setNewList(List<? extends Item> items, boolean notify) {
        FastAdapter fastAdapter;
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        setMItems(new ArrayList(items));
        if (this.comparator != null) {
            Collections.sort(getMItems(), this.comparator);
        }
        if (notify && (fastAdapter = getFastAdapter()) != null) {
            fastAdapter.notifyAdapterDataSetChanged();
        }
    }
}

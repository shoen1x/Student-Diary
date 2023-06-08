package com.mikepenz.fastadapter.adapters;

import android.widget.Filter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.listeners.ItemFilterListener;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\u00020\u0006B\u0019\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\tJ+\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010*\"\u00028\u0001H\u0007¢\u0006\u0002\u0010+J3\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010,\u001a\u00020&2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010*\"\u00028\u0001H\u0007¢\u0006\u0002\u0010-J&\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010,\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010.J\u001e\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010.J\u0010\u0010/\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\bJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000bJ\u0013\u00103\u001a\u00020&2\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00104J\u000e\u00103\u001a\u00020&2\u0006\u00105\u001a\u000206J \u00107\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020&J\u0012\u0010:\u001a\u00020;2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010<\u001a\u0002012\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010=\u001a\u00020;H\u0014J\u0018\u0010>\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010,\u001a\u00020&J \u0010?\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010,\u001a\u00020&2\u0006\u0010@\u001a\u00020&J\u0006\u0010A\u001a\u000201J(\u0010B\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0013\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010CR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eRN\u0010\u000f\u001a6\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\"8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$¨\u0006D"}, d2 = {"Lcom/mikepenz/fastadapter/adapters/ItemFilter;", "Model", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Landroid/widget/Filter;", "mItemAdapter", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "(Lcom/mikepenz/fastadapter/adapters/ModelAdapter;)V", "<set-?>", "", "constraint", "getConstraint", "()Ljava/lang/CharSequence;", "filterPredicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "getFilterPredicate", "()Lkotlin/jvm/functions/Function2;", "setFilterPredicate", "(Lkotlin/jvm/functions/Function2;)V", "itemFilterListener", "Lcom/mikepenz/fastadapter/listeners/ItemFilterListener;", "getItemFilterListener", "()Lcom/mikepenz/fastadapter/listeners/ItemFilterListener;", "setItemFilterListener", "(Lcom/mikepenz/fastadapter/listeners/ItemFilterListener;)V", "originalItems", "", "selectedItems", "", "getSelectedItems", "()Ljava/util/Set;", "selections", "", "getSelections", "add", "items", "", "([Lcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "position", "(I[Lcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "", "clear", "filterItems", "", "filter", "getAdapterPosition", "(Lcom/mikepenz/fastadapter/IItem;)I", "identifier", "", "move", "fromPosition", "toPosition", "performFiltering", "Landroid/widget/Filter$FilterResults;", "publishResults", "results", "remove", "removeRange", "itemCount", "resetFilter", "set", "(ILcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ItemFilter.kt */
public class ItemFilter<Model, Item extends IItem<? extends RecyclerView.ViewHolder>> extends Filter {
    private CharSequence constraint;
    private Function2<? super Item, ? super CharSequence, Boolean> filterPredicate;
    private ItemFilterListener<Item> itemFilterListener;
    private final ModelAdapter<Model, Item> mItemAdapter;
    private List<Item> originalItems;

    public ItemFilter(ModelAdapter<Model, Item> mItemAdapter2) {
        Intrinsics.checkParameterIsNotNull(mItemAdapter2, "mItemAdapter");
        this.mItemAdapter = mItemAdapter2;
    }

    public final CharSequence getConstraint() {
        return this.constraint;
    }

    public final ItemFilterListener<Item> getItemFilterListener() {
        return this.itemFilterListener;
    }

    public final void setItemFilterListener(ItemFilterListener<Item> itemFilterListener2) {
        this.itemFilterListener = itemFilterListener2;
    }

    public final Function2<Item, CharSequence, Boolean> getFilterPredicate() {
        return this.filterPredicate;
    }

    public final void setFilterPredicate(Function2<? super Item, ? super CharSequence, Boolean> function2) {
        this.filterPredicate = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.util.HashSet} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<java.lang.Integer> getSelections() {
        /*
            r19 = this;
            r0 = r19
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r1 = r0.mItemAdapter
            com.mikepenz.fastadapter.FastAdapter r1 = r1.getFastAdapter()
            if (r1 == 0) goto L_0x007f
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r2 = r0.mItemAdapter
            int r2 = r2.getOrder()
            int r2 = r1.getPreItemCountByOrder(r2)
            java.util.List<Item> r3 = r0.originalItems
            r4 = 0
            if (r3 == 0) goto L_0x0069
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = 0
            r7 = r3
            r8 = 0
            r9 = 0
            java.util.Iterator r10 = r7.iterator()
        L_0x002a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0060
            java.lang.Object r11 = r10.next()
            int r12 = r9 + 1
            if (r9 >= 0) goto L_0x003b
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003b:
            r13 = r11
            r14 = 0
            r15 = r13
            com.mikepenz.fastadapter.IItem r15 = (com.mikepenz.fastadapter.IItem) r15
            r16 = r9
            r17 = 0
            boolean r18 = r15.isSelected()
            if (r18 == 0) goto L_0x0051
            int r18 = r16 + r2
            java.lang.Integer r18 = java.lang.Integer.valueOf(r18)
            goto L_0x0053
        L_0x0051:
            r18 = r4
        L_0x0053:
            if (r18 == 0) goto L_0x005d
            r15 = r18
            r16 = 0
            r5.add(r15)
            goto L_0x005e
        L_0x005d:
        L_0x005e:
            r9 = r12
            goto L_0x002a
        L_0x0060:
            r3 = r5
            java.util.HashSet r3 = (java.util.HashSet) r3
            r4 = r3
            java.util.Set r4 = (java.util.Set) r4
            goto L_0x0077
        L_0x0069:
            java.lang.Class<com.mikepenz.fastadapter.select.SelectExtension> r3 = com.mikepenz.fastadapter.select.SelectExtension.class
            com.mikepenz.fastadapter.IAdapterExtension r3 = r1.getExtension(r3)
            com.mikepenz.fastadapter.select.SelectExtension r3 = (com.mikepenz.fastadapter.select.SelectExtension) r3
            if (r3 == 0) goto L_0x0077
            java.util.Set r4 = r3.getSelections()
        L_0x0077:
            if (r4 == 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            java.util.Set r4 = kotlin.collections.SetsKt.emptySet()
        L_0x007e:
            return r4
        L_0x007f:
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.adapters.ItemFilter.getSelections():java.util.Set");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.util.HashSet} */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r0 = (com.mikepenz.fastadapter.select.SelectExtension) r0.getExtension(com.mikepenz.fastadapter.select.SelectExtension.class);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<Item> getSelectedItems() {
        /*
            r7 = this;
            java.util.List<Item> r0 = r7.originalItems
            if (r0 == 0) goto L_0x0031
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L_0x0012:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.mikepenz.fastadapter.IItem r5 = (com.mikepenz.fastadapter.IItem) r5
            r6 = 0
            boolean r5 = r5.isSelected()
            if (r5 == 0) goto L_0x0012
            r1.add(r4)
            goto L_0x0012
        L_0x002a:
            r0 = r1
            java.util.HashSet r0 = (java.util.HashSet) r0
            java.util.Set r0 = (java.util.Set) r0
            goto L_0x0049
        L_0x0031:
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r0 = r7.mItemAdapter
            com.mikepenz.fastadapter.FastAdapter r0 = r0.getFastAdapter()
            if (r0 == 0) goto L_0x0048
            java.lang.Class<com.mikepenz.fastadapter.select.SelectExtension> r1 = com.mikepenz.fastadapter.select.SelectExtension.class
            com.mikepenz.fastadapter.IAdapterExtension r0 = r0.getExtension(r1)
            com.mikepenz.fastadapter.select.SelectExtension r0 = (com.mikepenz.fastadapter.select.SelectExtension) r0
            if (r0 == 0) goto L_0x0048
            java.util.Set r0 = r0.getSelectedItems()
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            if (r0 == 0) goto L_0x004c
            goto L_0x0050
        L_0x004c:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.adapters.ItemFilter.getSelectedItems():java.util.Set");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.List<Item>} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r15) {
        /*
            r14 = this;
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            java.util.List<Item> r1 = r14.originalItems
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x001a
            if (r15 == 0) goto L_0x0016
            int r1 = r15.length()
            if (r1 != 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r1 = r2
            goto L_0x0017
        L_0x0016:
            r1 = r3
        L_0x0017:
            if (r1 == 0) goto L_0x001a
            return r0
        L_0x001a:
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r1 = r14.mItemAdapter
            com.mikepenz.fastadapter.FastAdapter r1 = r1.getFastAdapter()
            if (r1 == 0) goto L_0x0042
            java.util.Collection r1 = r1.getExtensions()
            if (r1 == 0) goto L_0x0042
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r4 = 0
            java.util.Iterator r5 = r1.iterator()
        L_0x002f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0042
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.mikepenz.fastadapter.IAdapterExtension r7 = (com.mikepenz.fastadapter.IAdapterExtension) r7
            r8 = 0
            r7.performFiltering(r15)
            goto L_0x002f
        L_0x0042:
            r14.constraint = r15
            java.util.List<Item> r1 = r14.originalItems
            if (r1 == 0) goto L_0x004a
            goto L_0x0061
        L_0x004a:
            java.util.ArrayList r1 = new java.util.ArrayList
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r4 = r14.mItemAdapter
            java.util.List r4 = r4.getAdapterItems()
            java.util.Collection r4 = (java.util.Collection) r4
            r1.<init>(r4)
            r4 = r1
            r5 = 0
            r6 = r4
            java.util.List r6 = (java.util.List) r6
            r14.originalItems = r6
            java.util.List r1 = (java.util.List) r1
        L_0x0061:
            if (r15 == 0) goto L_0x0069
            int r4 = r15.length()
            if (r4 != 0) goto L_0x006a
        L_0x0069:
            r2 = r3
        L_0x006a:
            if (r2 == 0) goto L_0x0081
            r0.values = r1
            int r2 = r1.size()
            r0.count = r2
            r2 = 0
            java.util.List r2 = (java.util.List) r2
            r14.originalItems = r2
            com.mikepenz.fastadapter.listeners.ItemFilterListener<Item> r2 = r14.itemFilterListener
            if (r2 == 0) goto L_0x00ca
            r2.onReset()
            goto L_0x00ca
        L_0x0081:
            kotlin.jvm.functions.Function2<? super Item, ? super java.lang.CharSequence, java.lang.Boolean> r2 = r14.filterPredicate
            if (r2 == 0) goto L_0x00bb
            r3 = 0
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            r7 = r4
            r8 = 0
            java.util.Iterator r9 = r7.iterator()
        L_0x0097:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00b5
            java.lang.Object r10 = r9.next()
            r11 = r10
            com.mikepenz.fastadapter.IItem r11 = (com.mikepenz.fastadapter.IItem) r11
            r12 = 0
            java.lang.Object r13 = r2.invoke(r11, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r11 = r13.booleanValue()
            if (r11 == 0) goto L_0x0097
            r6.add(r10)
            goto L_0x0097
        L_0x00b5:
            r4 = r6
            java.util.List r4 = (java.util.List) r4
            goto L_0x00c1
        L_0x00bb:
            com.mikepenz.fastadapter.adapters.ModelAdapter<Model, Item> r2 = r14.mItemAdapter
            java.util.List r4 = r2.getAdapterItems()
        L_0x00c1:
            r2 = r4
            r0.values = r2
            int r3 = r2.size()
            r0.count = r3
        L_0x00ca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.adapters.ItemFilter.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence constraint2, Filter.FilterResults results) {
        ItemFilterListener<Item> itemFilterListener2;
        Intrinsics.checkParameterIsNotNull(results, "results");
        if (results.values != null) {
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            Object obj = results.values;
            if (obj != null) {
                modelAdapter.setInternal((List) obj, false, (IAdapterNotifier) null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<Item>");
            }
        }
        if (this.originalItems != null && (itemFilterListener2 = this.itemFilterListener) != null) {
            Object obj2 = results.values;
            if (obj2 != null) {
                itemFilterListener2.itemsFiltered(constraint2, (List) obj2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<Item>");
        }
    }

    public final void resetFilter() {
        performFiltering((CharSequence) null);
    }

    public final void filterItems(CharSequence filter) {
        Intrinsics.checkParameterIsNotNull(filter, "filter");
        publishResults(filter, performFiltering(filter));
    }

    public final int getAdapterPosition(Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        return getAdapterPosition(item.getIdentifier());
    }

    public final int getAdapterPosition(long identifier) {
        List<IItem> $this$indexOfFirst$iv = this.originalItems;
        if ($this$indexOfFirst$iv == null) {
            return -1;
        }
        int index$iv = 0;
        for (IItem it : $this$indexOfFirst$iv) {
            if (it.getIdentifier() == identifier) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    @SafeVarargs
    public final ModelAdapter<?, Item> add(Item... items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        List asList = Arrays.asList((IItem[]) Arrays.copyOf(items, items.length));
        Intrinsics.checkExpressionValueIsNotNull(asList, "asList(*items)");
        return add(asList);
    }

    public final ModelAdapter<?, Item> add(List<? extends Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if (items.isEmpty()) {
            return this.mItemAdapter;
        }
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            if (this.mItemAdapter.isUseIdDistributor()) {
                this.mItemAdapter.getIdDistributor().checkIds(items);
            }
            originalItems2.addAll(items);
            CharSequence charSequence = this.constraint;
            publishResults(charSequence, performFiltering(charSequence));
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.addInternal((List) items);
    }

    @SafeVarargs
    public final ModelAdapter<?, Item> add(int position, Item... items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        List asList = Arrays.asList((IItem[]) Arrays.copyOf(items, items.length));
        Intrinsics.checkExpressionValueIsNotNull(asList, "asList(*items)");
        return add(position, asList);
    }

    public final ModelAdapter<?, Item> add(int position, List<? extends Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if (items.isEmpty()) {
            return this.mItemAdapter;
        }
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            if (this.mItemAdapter.isUseIdDistributor()) {
                this.mItemAdapter.getIdDistributor().checkIds(items);
            }
            FastAdapter fastAdapter = this.mItemAdapter.getFastAdapter();
            if (fastAdapter != null) {
                originalItems2.addAll(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(position)) - fastAdapter.getPreItemCount(position), items);
            }
            CharSequence charSequence = this.constraint;
            publishResults(charSequence, performFiltering(charSequence));
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.addInternal(position, (List) items);
    }

    public final ModelAdapter<?, Item> set(int position, Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            if (this.mItemAdapter.isUseIdDistributor()) {
                this.mItemAdapter.getIdDistributor().checkId((IIdentifyable) item);
            }
            FastAdapter fastAdapter = this.mItemAdapter.getFastAdapter();
            if (fastAdapter != null) {
                originalItems2.set(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(position)) - fastAdapter.getPreItemCount(position), item);
            }
            CharSequence charSequence = this.constraint;
            publishResults(charSequence, performFiltering(charSequence));
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.setInternal(position, (IItem) item);
    }

    public final ModelAdapter<?, Item> move(int fromPosition, int toPosition) {
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            FastAdapter<Item> fastAdapter = this.mItemAdapter.getFastAdapter();
            if (fastAdapter != null) {
                int preItemCount = fastAdapter.getPreItemCount(fromPosition);
                int adjustedFrom = getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(fromPosition));
                int adjustedTo = getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(toPosition));
                originalItems2.remove(adjustedFrom - preItemCount);
                originalItems2.add(adjustedTo - preItemCount, (IItem) originalItems2.get(adjustedFrom - preItemCount));
                performFiltering(this.constraint);
            }
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.move(fromPosition, toPosition);
    }

    public final ModelAdapter<?, Item> remove(int position) {
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            FastAdapter fastAdapter = this.mItemAdapter.getFastAdapter();
            if (fastAdapter != null) {
                IItem iItem = (IItem) originalItems2.remove(getAdapterPosition((IItem) this.mItemAdapter.getAdapterItems().get(position)) - fastAdapter.getPreItemCount(position));
            }
            CharSequence charSequence = this.constraint;
            publishResults(charSequence, performFiltering(charSequence));
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.remove(position);
    }

    public final ModelAdapter<?, Item> removeRange(int position, int itemCount) {
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            int length = originalItems2.size();
            FastAdapter<Item> fastAdapter = this.mItemAdapter.getFastAdapter();
            if (fastAdapter != null) {
                int preItemCount = fastAdapter.getPreItemCount(position);
                int saveItemCount = Math.min(itemCount, (length - position) + preItemCount);
                for (int i = 0; i < saveItemCount; i++) {
                    originalItems2.remove(position - preItemCount);
                }
                CharSequence charSequence = this.constraint;
                publishResults(charSequence, performFiltering(charSequence));
            }
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.removeRange(position, itemCount);
    }

    public final ModelAdapter<?, Item> clear() {
        List originalItems2 = this.originalItems;
        if (originalItems2 != null) {
            originalItems2.clear();
            CharSequence charSequence = this.constraint;
            publishResults(charSequence, performFiltering(charSequence));
            ModelAdapter<Model, Item> modelAdapter = this.mItemAdapter;
            if (modelAdapter != null) {
                return modelAdapter;
            }
        }
        return this.mItemAdapter.clear();
    }
}

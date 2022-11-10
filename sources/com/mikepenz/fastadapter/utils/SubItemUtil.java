package com.mikepenz.fastadapter.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.fastadapter.expandable.ExpandableExtension;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.fastadapter.select.SelectExtensionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bJ>\u0010\u0003\u001a\u00020\u00042\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bH\u0002J5\u0010\u000f\u001a\u00020\u0004\"\u0014\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\t*\u0006\u0012\u0002\b\u00030\u00112\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001a\u0002H\u0010¢\u0006\u0002\u0010\u0014J;\u0010\u000f\u001a\u00020\u0004\"\u0014\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\t*\u0006\u0012\u0002\b\u00030\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00162\u0006\u0010\u0013\u001a\u0002H\u0010¢\u0006\u0002\u0010\u0017JN\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00122\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJJ\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00122\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bJ2\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bJ(\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bJ<\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bJJ\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\r2\u0012\u0010\f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bH\u0002J3\u0010%\u001a\u0004\u0018\u0001H\u0010\"\u0014\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u0011*\u0006\u0012\u0002\b\u00030\t2\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0002¢\u0006\u0002\u0010'Je\u0010(\u001a\u00020)\"\u0014\b\u0000\u0010**\u0006\u0012\u0002\b\u00030\t*\u0006\u0012\u0002\b\u00030\u00112\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00122\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0013\u001a\u0002H*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0002\u0010.JT\u0010(\u001a\u00020)\"\u0014\b\u0000\u0010**\u0006\u0012\u0002\b\u00030\t*\u0006\u0012\u0002\b\u00030\u00112\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00122\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\b\b\u0002\u0010-\u001a\u00020\u000bH\u0007JI\u0010/\u001a\u00020)\"\u0014\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\t*\u0006\u0012\u0002\b\u00030\u0011\"\u000e\b\u0001\u00100*\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0005\u001a\u0002H02\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u00101\u001a\u00020\u000b¢\u0006\u0002\u00102JS\u0010/\u001a\u00020)\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\t\"\u000e\b\u0001\u00100*\b\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0005\u001a\u0002H02\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u00104¨\u00066"}, d2 = {"Lcom/mikepenz/fastadapter/utils/SubItemUtil;", "", "()V", "countItems", "", "adapter", "Lcom/mikepenz/fastadapter/IItemAdapter;", "predicate", "Lcom/mikepenz/fastadapter/utils/SubItemUtil$IPredicate;", "Lcom/mikepenz/fastadapter/IItem;", "countHeaders", "", "items", "", "subItemsOnly", "countSelectedSubItems", "T", "Lcom/mikepenz/fastadapter/IExpandable;", "Lcom/mikepenz/fastadapter/FastAdapter;", "header", "(Lcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)I", "selections", "", "(Ljava/util/Set;Lcom/mikepenz/fastadapter/IItem;)I", "delete", "fastAdapter", "expandableExtension", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "identifiersToDelete", "", "", "notifyParent", "deleteEmptyHeaders", "deleteSelected", "selectExtension", "Lcom/mikepenz/fastadapter/select/SelectExtension;", "getAllItems", "getParent", "item", "(Lcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/IExpandable;", "notifyItemsChanged", "", "Item", "identifiers", "checkSubItems", "restoreExpandedState", "(Lcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;Lcom/mikepenz/fastadapter/IItem;Ljava/util/Set;ZZ)V", "selectAllSubItems", "Adapter", "select", "(Lcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;Z)V", "payload", "(Lcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;ZZLjava/lang/Object;)V", "IPredicate", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: SubItemUtil.kt */
public final class SubItemUtil {
    public static final SubItemUtil INSTANCE = new SubItemUtil();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/fastadapter/utils/SubItemUtil$IPredicate;", "T", "", "apply", "", "data", "(Ljava/lang/Object;)Z", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SubItemUtil.kt */
    public interface IPredicate<T> {
        boolean apply(T t);
    }

    public final <Item extends IItem<?> & IExpandable<?>> void notifyItemsChanged(FastAdapter<IItem<?>> fastAdapter, ExpandableExtension<?> expandableExtension, Set<Long> set) {
        notifyItemsChanged$default(this, fastAdapter, expandableExtension, set, false, 8, (Object) null);
    }

    private SubItemUtil() {
    }

    public final int countItems(IItemAdapter<?, ?> adapter, IPredicate<IItem<?>> predicate) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return countItems(adapter.getAdapterItems(), true, false, predicate);
    }

    public final int countItems(IItemAdapter<?, ?> adapter, boolean countHeaders) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        return countItems(adapter.getAdapterItems(), countHeaders, false, (IPredicate<IItem<?>>) null);
    }

    private final int countItems(List<? extends IItem<?>> items, boolean countHeaders, boolean subItemsOnly, IPredicate<IItem<?>> predicate) {
        return getAllItems(items, countHeaders, subItemsOnly, predicate).size();
    }

    public final List<IItem<?>> getAllItems(IItemAdapter<?, ?> adapter, IPredicate<IItem<?>> predicate) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return getAllItems(adapter.getAdapterItems(), true, false, predicate);
    }

    public final List<IItem<?>> getAllItems(IItemAdapter<?, ?> adapter, boolean countHeaders) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        return getAllItems(adapter.getAdapterItems(), countHeaders, false, (IPredicate<IItem<?>>) null);
    }

    public final List<IItem<?>> getAllItems(List<? extends IItem<?>> items, boolean countHeaders, IPredicate<IItem<?>> predicate) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return getAllItems(items, countHeaders, false, predicate);
    }

    private final List<IItem<?>> getAllItems(List<? extends IItem<?>> items, boolean countHeaders, boolean subItemsOnly, IPredicate<IItem<?>> predicate) {
        ArrayList res = new ArrayList();
        if (items == null || items.isEmpty()) {
            return res;
        }
        int itemCount = items.size();
        for (int i = 0; i < itemCount; i++) {
            IItem item = (IItem) items.get(i);
            if (item instanceof IExpandable) {
                List<ISubItem<?>> subItems = ((IExpandable) item).getSubItems();
                if (predicate == null) {
                    if (countHeaders) {
                        res.add(item);
                    }
                    if (!subItems.isEmpty()) {
                        res.addAll(subItems);
                    }
                    res.addAll(getAllItems(subItems, countHeaders, true, predicate));
                } else {
                    if (countHeaders && predicate.apply(item)) {
                        res.add(item);
                    }
                    int temp = subItems.size();
                    for (int j = 0; j < temp; j++) {
                        ISubItem it = subItems.get(j);
                        if (predicate.apply(it)) {
                            res.add(it);
                        }
                    }
                }
            } else if (!subItemsOnly && getParent(item) == null && (predicate == null || predicate.apply(item))) {
                res.add(item);
            }
        }
        return res;
    }

    public final <T extends IItem<?> & IExpandable<?>> int countSelectedSubItems(FastAdapter<?> adapter, T header) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(header, "header");
        SelectExtension extension = (SelectExtension) adapter.getExtension(SelectExtension.class);
        if (extension != null) {
            return countSelectedSubItems((Set<? extends IItem<?>>) extension.getSelectedItems(), header);
        }
        return 0;
    }

    public final <T extends IItem<?> & IExpandable<?>> int countSelectedSubItems(Set<? extends IItem<?>> selections, T header) {
        Intrinsics.checkParameterIsNotNull(selections, "selections");
        Intrinsics.checkParameterIsNotNull(header, "header");
        int count = 0;
        List subItems = ((IExpandable) header).getSubItems();
        int items = subItems.size();
        for (int i = 0; i < items; i++) {
            if (selections.contains(subItems.get(i))) {
                count++;
            }
            if (subItems.get(i) instanceof IExpandable) {
                ISubItem<?> iSubItem = subItems.get(i);
                if (iSubItem != null) {
                    count += countSelectedSubItems(selections, iSubItem);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type T");
                }
            }
        }
        return count;
    }

    public final <T extends IItem<?> & IExpandable<?>, Adapter extends FastAdapter<T>> void selectAllSubItems(Adapter adapter, T header, boolean select) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(header, "header");
        selectAllSubItems(adapter, header, select, false, (Object) null);
    }

    public final <T extends IItem<?>, Adapter extends FastAdapter<T>> void selectAllSubItems(Adapter adapter, T header, boolean select, boolean notifyParent, Object payload) {
        SelectExtension extension;
        Adapter adapter2 = adapter;
        T t = header;
        boolean z = select;
        Intrinsics.checkParameterIsNotNull(adapter2, "adapter");
        Intrinsics.checkParameterIsNotNull(t, "header");
        if (t instanceof IExpandable) {
            List subItems = ((IExpandable) t).getSubItems();
            int subItemsCount = subItems.size();
            int position = adapter.getPosition(header);
            int i = 0;
            if (((IExpandable) t).isExpanded()) {
                while (i < subItemsCount) {
                    int i2 = i;
                    ISubItem<?> iSubItem = subItems.get(i2);
                    if (iSubItem != null) {
                        if (iSubItem.isSelectable() && (extension = SelectExtensionKt.getSelectExtension(adapter)) != null) {
                            if (z) {
                                SelectExtension.select$default(extension, position + i2 + 1, false, false, 6, (Object) null);
                            } else {
                                SelectExtension.deselect$default(extension, position + i2 + 1, (Iterator) null, 2, (Object) null);
                            }
                        }
                        if (subItems.get(i2) instanceof IExpandable) {
                            selectAllSubItems(adapter, header, select, notifyParent, payload);
                        }
                        i = i2 + 1;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.IItem<*>");
                    }
                }
            } else {
                while (i < subItemsCount) {
                    int i3 = i;
                    ISubItem<?> iSubItem2 = subItems.get(i3);
                    if (iSubItem2 != null) {
                        if (iSubItem2.isSelectable()) {
                            ISubItem<?> iSubItem3 = subItems.get(i3);
                            if (iSubItem3 != null) {
                                iSubItem3.setSelected(z);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.IItem<*>");
                            }
                        }
                        if (subItems.get(i3) instanceof IExpandable) {
                            selectAllSubItems(adapter, header, select, notifyParent, payload);
                        }
                        i = i3 + 1;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.IItem<*>");
                    }
                }
            }
            if (!notifyParent || position < 0) {
                Object obj = payload;
            } else {
                adapter2.notifyItemChanged(position, payload);
            }
        } else {
            Object obj2 = payload;
        }
    }

    private final <T extends IExpandable<?> & IItem<?>> T getParent(IItem<?> item) {
        if (item instanceof IExpandable) {
            return (IExpandable) ((IExpandable) item).getParent();
        }
        return null;
    }

    public final List<IItem<?>> deleteSelected(FastAdapter<IItem<?>> fastAdapter, SelectExtension<?> selectExtension, ExpandableExtension<?> expandableExtension, boolean notifyParent, boolean deleteEmptyHeaders) {
        FastAdapter<IItem<?>> fastAdapter2 = fastAdapter;
        ExpandableExtension<?> expandableExtension2 = expandableExtension;
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(selectExtension, "selectExtension");
        Intrinsics.checkParameterIsNotNull(expandableExtension2, "expandableExtension");
        ArrayList deleted = new ArrayList();
        ListIterator it = new LinkedList(selectExtension.getSelectedItems()).listIterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "selectedItems.listIterator()");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "it.next()");
            IItem item = (IItem) next;
            int pos = fastAdapter2.getPosition(item);
            IItem parent = getParent(item);
            if (parent != null) {
                int parentPos = fastAdapter2.getPosition(parent);
                List<ISubItem<?>> subItems = ((IExpandable) parent).getSubItems();
                Collection collection = subItems;
                if (collection != null) {
                    TypeIntrinsics.asMutableCollection(collection).remove(item);
                    if (parentPos != -1 && ((IExpandable) parent).isExpanded()) {
                        expandableExtension2.notifyAdapterSubItemsChanged(parentPos, subItems.size() + 1);
                    }
                    if (parentPos != -1 && notifyParent) {
                        boolean expanded = ((IExpandable) parent).isExpanded();
                        FastAdapter.notifyAdapterItemChanged$default(fastAdapter2, parentPos, (Object) null, 2, (Object) null);
                        if (expanded) {
                            ExpandableExtension.expand$default(expandableExtension2, parentPos, false, 2, (Object) null);
                        }
                    }
                    deleted.add(item);
                    if (deleteEmptyHeaders && subItems.size() == 0) {
                        it.add(parent);
                        it.previous();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
            } else if (pos != -1) {
                IAdapter<IItem<?>> adapter = fastAdapter2.getAdapter(pos);
                if (adapter instanceof IItemAdapter) {
                    ((IItemAdapter) adapter).remove(pos);
                }
                deleted.add(item);
            }
        }
        return deleted;
    }

    public final List<IItem<?>> delete(FastAdapter<IItem<?>> fastAdapter, ExpandableExtension<?> expandableExtension, Collection<Long> identifiersToDelete, boolean notifyParent, boolean deleteEmptyHeaders) {
        LinkedList identifiers;
        FastAdapter<IItem<?>> fastAdapter2 = fastAdapter;
        ExpandableExtension<?> expandableExtension2 = expandableExtension;
        Collection<Long> collection = identifiersToDelete;
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(expandableExtension2, "expandableExtension");
        ArrayList deleted = new ArrayList();
        if (collection != null) {
            if (!identifiersToDelete.isEmpty()) {
                LinkedList identifiers2 = new LinkedList(collection);
                ListIterator it = identifiers2.listIterator();
                Intrinsics.checkExpressionValueIsNotNull(it, "identifiers.listIterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkExpressionValueIsNotNull(next, "it.next()");
                    int pos = fastAdapter2.getPosition(((Number) next).longValue());
                    IItem item = fastAdapter2.getItem(pos);
                    if (item != null) {
                        IItem item2 = item;
                        IItem parent = getParent(item2);
                        if (parent != null) {
                            int parentPos = fastAdapter2.getPosition(parent);
                            List subItems = ((IExpandable) parent).getSubItems();
                            if (parentPos != -1 && ((IExpandable) parent).isExpanded()) {
                                expandableExtension2.notifyAdapterSubItemsChanged(parentPos, subItems.size() + 1);
                            }
                            if (parentPos == -1 || !notifyParent) {
                                identifiers = identifiers2;
                            } else {
                                boolean expanded = ((IExpandable) parent).isExpanded();
                                FastAdapter.notifyAdapterItemChanged$default(fastAdapter2, parentPos, (Object) null, 2, (Object) null);
                                if (expanded) {
                                    identifiers = identifiers2;
                                    ExpandableExtension.expand$default(expandableExtension2, parentPos, false, 2, (Object) null);
                                } else {
                                    identifiers = identifiers2;
                                }
                            }
                            deleted.add(item2);
                            if (deleteEmptyHeaders && subItems.isEmpty()) {
                                it.add(Long.valueOf(parent.getIdentifier()));
                                it.previous();
                            }
                        } else {
                            identifiers = identifiers2;
                            if (pos != -1) {
                                if (fastAdapter2.getAdapter(pos) instanceof IItemAdapter) {
                                    fastAdapter2.notifyAdapterItemRemoved(pos);
                                }
                                deleted.add(item2);
                            }
                        }
                        Collection<Long> collection2 = identifiersToDelete;
                        identifiers2 = identifiers;
                    } else {
                        LinkedList linkedList = identifiers2;
                        Collection<Long> collection3 = identifiersToDelete;
                    }
                }
                return deleted;
            }
        }
        return deleted;
    }

    public static /* synthetic */ void notifyItemsChanged$default(SubItemUtil subItemUtil, FastAdapter fastAdapter, ExpandableExtension expandableExtension, Set set, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        subItemUtil.notifyItemsChanged(fastAdapter, expandableExtension, set, z);
    }

    public final <Item extends IItem<?> & IExpandable<?>> void notifyItemsChanged(FastAdapter<IItem<?>> adapter, ExpandableExtension<?> expandableExtension, Set<Long> identifiers, boolean restoreExpandedState) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(expandableExtension, "expandableExtension");
        Intrinsics.checkParameterIsNotNull(identifiers, "identifiers");
        for (int i = 0; i < adapter.getItemCount(); i++) {
            IItem item = adapter.getItem(i);
            if (item instanceof IExpandable) {
                notifyItemsChanged(adapter, expandableExtension, item, identifiers, true, restoreExpandedState);
            } else {
                if (CollectionsKt.contains(identifiers, item != null ? Long.valueOf(item.getIdentifier()) : null)) {
                    FastAdapter.notifyAdapterItemChanged$default(adapter, i, (Object) null, 2, (Object) null);
                }
            }
        }
    }

    public final <Item extends IItem<?> & IExpandable<?>> void notifyItemsChanged(FastAdapter<IItem<?>> adapter, ExpandableExtension<?> expandableExtension, Item header, Set<Long> identifiers, boolean checkSubItems, boolean restoreExpandedState) {
        Object obj;
        int i;
        IItem item;
        Object obj2;
        FastAdapter<IItem<?>> fastAdapter = adapter;
        ExpandableExtension<?> expandableExtension2 = expandableExtension;
        Item item2 = header;
        Set<Long> set = identifiers;
        Intrinsics.checkParameterIsNotNull(fastAdapter, "adapter");
        Intrinsics.checkParameterIsNotNull(expandableExtension2, "expandableExtension");
        Intrinsics.checkParameterIsNotNull(item2, "header");
        Intrinsics.checkParameterIsNotNull(set, "identifiers");
        List subItems = ((IExpandable) item2).getSubItems();
        int subItemsCount = subItems.size();
        int position = fastAdapter.getPosition(item2);
        boolean expanded = ((IExpandable) item2).isExpanded();
        int i2 = 2;
        Object obj3 = null;
        if (set.contains(Long.valueOf(((IExpandable) item2).getIdentifier()))) {
            FastAdapter.notifyAdapterItemChanged$default(fastAdapter, position, (Object) null, 2, (Object) null);
        }
        boolean z = false;
        if (((IExpandable) item2).isExpanded()) {
            int i3 = 0;
            while (i3 < subItemsCount) {
                int i4 = i3;
                IItem item3 = subItems.get(i4);
                if (set.contains(Long.valueOf(item3.getIdentifier()))) {
                    FastAdapter.notifyAdapterItemChanged$default(fastAdapter, position + i4 + 1, obj3, i2, obj3);
                }
                if (!checkSubItems || !(item3 instanceof IExpandable)) {
                    item = item3;
                    i = i4;
                    obj2 = obj3;
                } else {
                    item = item3;
                    i = i4;
                    boolean z2 = z;
                    obj2 = obj3;
                    notifyItemsChanged(adapter, expandableExtension, item3, identifiers, true, restoreExpandedState);
                }
                i3 = i + 1;
                obj3 = obj2;
                IItem iItem = item;
                z = false;
                i2 = 2;
            }
            obj = obj3;
        } else {
            obj = null;
        }
        if (restoreExpandedState && expanded) {
            ExpandableExtension.expand$default(expandableExtension2, position, false, 2, obj);
        }
    }
}

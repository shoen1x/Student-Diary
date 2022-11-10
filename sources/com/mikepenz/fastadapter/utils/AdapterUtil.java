package com.mikepenz.fastadapter.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ISubItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u00020\u0004\"\u001c\b\u0000\u0010\u0005*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006j\u0002`\b*\u0006\u0012\u0002\b\u00030\t2\b\u0010\n\u001a\u0004\u0018\u0001H\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\f¢\u0006\u0002\u0010\rJ?\u0010\u000e\u001a\u00020\u0004\"\u001c\b\u0000\u0010\u0005*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006j\u0002`\b*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u0002H\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\u0010\rJ8\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0012\"\u001c\b\u0000\u0010\u0005*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006j\u0002`\b*\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0014JA\u0010\u0015\u001a\u00020\u0004\"\u001c\b\u0000\u0010\u0005*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006j\u0002`\b*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u0002H\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012¢\u0006\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/mikepenz/fastadapter/utils/AdapterUtil;", "", "()V", "addAllSubItems", "", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IExpandable;", "item", "items", "", "(Lcom/mikepenz/fastadapter/IItem;Ljava/util/List;)V", "findSubItemSelections", "selections", "", "getAllItems", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "restoreSubItemSelectionStatesForAlternativeStateManagement", "selectedItems", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: AdapterUtil.kt */
public final class AdapterUtil {
    public static final AdapterUtil INSTANCE = new AdapterUtil();

    private AdapterUtil() {
    }

    public final <Item extends IItem<? extends RecyclerView.ViewHolder> & IExpandable<?>> void restoreSubItemSelectionStatesForAlternativeStateManagement(Item item, List<String> selectedItems) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!((IExpandable) item).isExpanded()) {
            List subItems = ((IExpandable) item).getSubItems();
            int i = 0;
            int size = subItems.size();
            while (i < size) {
                ISubItem<?> iSubItem = subItems.get(i);
                if (iSubItem != null) {
                    IItem subItem = iSubItem;
                    String id = String.valueOf(((IExpandable) subItem).getIdentifier());
                    if (selectedItems != null && selectedItems.contains(id)) {
                        ((IExpandable) subItem).setSelected(true);
                    }
                    restoreSubItemSelectionStatesForAlternativeStateManagement(subItem, selectedItems);
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type Item");
                }
            }
        }
    }

    public final <Item extends IItem<? extends RecyclerView.ViewHolder> & IExpandable<?>> void findSubItemSelections(Item item, List<String> selections) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        Intrinsics.checkParameterIsNotNull(selections, "selections");
        if (!((IExpandable) item).isExpanded()) {
            List subItems = ((IExpandable) item).getSubItems();
            int i = 0;
            int size = subItems.size();
            while (i < size) {
                ISubItem<?> iSubItem = subItems.get(i);
                if (iSubItem != null) {
                    IItem subItem = iSubItem;
                    String id = String.valueOf(((IExpandable) subItem).getIdentifier());
                    if (((IExpandable) subItem).isSelected()) {
                        selections.add(id);
                    }
                    findSubItemSelections(subItem, selections);
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type Item");
                }
            }
        }
    }

    public final <Item extends IItem<? extends RecyclerView.ViewHolder> & IExpandable<?>> List<Item> getAllItems(FastAdapter<Item> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        int size = fastAdapter.getItemCount();
        ArrayList items = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            IItem it = fastAdapter.getItem(i);
            if (it != null) {
                items.add(it);
                INSTANCE.addAllSubItems(it, items);
            }
        }
        return items;
    }

    public final <Item extends IItem<? extends RecyclerView.ViewHolder> & IExpandable<?>> void addAllSubItems(Item item, List<Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if ((item instanceof IExpandable) && !((IExpandable) item).isExpanded()) {
            List subItems = ((IExpandable) item).getSubItems();
            int i = 0;
            int size = subItems.size();
            while (i < size) {
                ISubItem<?> subItem = subItems.get(i);
                if (subItem != null) {
                    IItem subItem2 = subItem;
                    items.add(subItem2);
                    addAllSubItems(subItem2, items);
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type Item");
                }
            }
        }
    }
}

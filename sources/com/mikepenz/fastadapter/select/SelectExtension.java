package com.mikepenz.fastadapter.select;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.dsl.FastAdapterDsl;
import com.mikepenz.fastadapter.extensions.ExtensionsFactories;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@FastAdapterDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u001d\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\b\b\u0007\u0018\u0000 g*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001gB\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\u0006\u0010*\u001a\u00020+J1\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00028\u00002\b\b\u0002\u0010-\u001a\u00020&2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010/H\u0007¢\u0006\u0002\u00100J\"\u0010*\u001a\u00020+2\u0006\u0010-\u001a\u00020&2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010/H\u0007J\u0014\u0010*\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&02J\u000e\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205J\u0014\u00106\u001a\u00020+2\f\u00107\u001a\b\u0012\u0004\u0012\u0002050%J\u0014\u00108\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000%J'\u0010:\u001a\u00020+2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020&H\u0002¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020+H\u0016J\u0018\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&H\u0016J\"\u0010B\u001a\u00020+2\u0006\u0010-\u001a\u00020&2\u0006\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010F\u001a\u00020+2\u0006\u0010-\u001a\u00020&2\u0006\u0010C\u001a\u00020&H\u0016J\u0018\u0010G\u001a\u00020+2\u0006\u0010-\u001a\u00020&2\u0006\u0010C\u001a\u00020&H\u0016J3\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010KJ3\u0010L\u001a\u00020\n2\u0006\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010KJ;\u0010M\u001a\u00020\n2\u0006\u0010I\u001a\u00020<2\u0006\u0010N\u001a\u00020O2\u0006\u0010-\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010PJ\u0012\u0010Q\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u001a\u0010T\u001a\u00020+2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u001b\u0010Y\u001a\u00020+2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010Z\u001a\u00020\n¢\u0006\u0002\u0010[J9\u0010Y\u001a\u00020+2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000]2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020&2\u0006\u0010^\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n¢\u0006\u0002\u0010_J\u0012\u0010Y\u001a\u00020+2\b\b\u0002\u0010Z\u001a\u00020\nH\u0007J$\u0010Y\u001a\u00020+2\u0006\u0010-\u001a\u00020&2\b\b\u0002\u0010^\u001a\u00020\n2\b\b\u0002\u0010Z\u001a\u00020\nH\u0007J\u0014\u0010Y\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020&0`J\u001e\u0010a\u001a\u00020+2\u0006\u00104\u001a\u0002052\u0006\u0010^\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nJ$\u0010b\u001a\u00020+2\f\u00107\u001a\b\u0012\u0004\u0012\u0002050%2\u0006\u0010^\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nJ\u001f\u0010c\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010d\u001a\u00020\nH\u0002J\u000e\u0010e\u001a\u00020+2\u0006\u0010-\u001a\u00020&J\u001a\u0010f\u001a\u00020+2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8F¢\u0006\u0006\u001a\u0004\b'\u0010\u001d¨\u0006h"}, d2 = {"Lcom/mikepenz/fastadapter/select/SelectExtension;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "allowDeselection", "", "getAllowDeselection", "()Z", "setAllowDeselection", "(Z)V", "isSelectable", "setSelectable", "multiSelect", "getMultiSelect", "setMultiSelect", "selectOnLongClick", "getSelectOnLongClick", "setSelectOnLongClick", "selectWithItemUpdate", "getSelectWithItemUpdate", "setSelectWithItemUpdate", "selectedItems", "", "getSelectedItems", "()Ljava/util/Set;", "selectionListener", "Lcom/mikepenz/fastadapter/ISelectionListener;", "getSelectionListener", "()Lcom/mikepenz/fastadapter/ISelectionListener;", "setSelectionListener", "(Lcom/mikepenz/fastadapter/ISelectionListener;)V", "selections", "", "", "getSelections", "deleteAllSelectedItems", "", "deselect", "", "item", "position", "entries", "", "(Lcom/mikepenz/fastadapter/IItem;ILjava/util/Iterator;)V", "positions", "", "deselectByIdentifier", "identifier", "", "deselectByIdentifiers", "identifiers", "deselectByItems", "items", "handleSelection", "view", "Landroid/view/View;", "(Landroid/view/View;Lcom/mikepenz/fastadapter/IItem;I)V", "notifyAdapterDataSetChanged", "notifyAdapterItemMoved", "fromPosition", "toPosition", "notifyAdapterItemRangeChanged", "itemCount", "payload", "", "notifyAdapterItemRangeInserted", "notifyAdapterItemRangeRemoved", "onClick", "v", "pos", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "onLongClick", "onTouch", "event", "Landroid/view/MotionEvent;", "(Landroid/view/View;Landroid/view/MotionEvent;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "performFiltering", "constraint", "", "saveInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "prefix", "", "select", "considerSelectableFlag", "(Lcom/mikepenz/fastadapter/IItem;Z)V", "adapter", "Lcom/mikepenz/fastadapter/IAdapter;", "fireEvent", "(Lcom/mikepenz/fastadapter/IAdapter;Lcom/mikepenz/fastadapter/IItem;IZZ)V", "", "selectByIdentifier", "selectByIdentifiers", "set", "resetFilter", "toggleSelection", "withSavedInstanceState", "Companion", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: SelectExtension.kt */
public final class SelectExtension<Item extends IItem<? extends RecyclerView.ViewHolder>> implements IAdapterExtension<Item> {
    private static final String BUNDLE_SELECTIONS = "bundle_selections";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean allowDeselection = true;
    private final FastAdapter<Item> fastAdapter;
    private boolean isSelectable;
    private boolean multiSelect;
    private boolean selectOnLongClick;
    private boolean selectWithItemUpdate;
    private ISelectionListener<Item> selectionListener;

    public final void deselect(int i) {
        deselect$default(this, i, (Iterator) null, 2, (Object) null);
    }

    public final void deselect(Item item) {
        deselect$default(this, item, 0, (Iterator) null, 6, (Object) null);
    }

    public final void deselect(Item item, int i) {
        deselect$default(this, item, i, (Iterator) null, 4, (Object) null);
    }

    public final void select() {
        select$default(this, false, 1, (Object) null);
    }

    public final void select(int i) {
        select$default(this, i, false, false, 6, (Object) null);
    }

    public final void select(int i, boolean z) {
        select$default(this, i, z, false, 4, (Object) null);
    }

    public SelectExtension(FastAdapter<Item> fastAdapter2) {
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        this.fastAdapter = fastAdapter2;
    }

    public final boolean getSelectWithItemUpdate() {
        return this.selectWithItemUpdate;
    }

    public final void setSelectWithItemUpdate(boolean z) {
        this.selectWithItemUpdate = z;
    }

    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final void setMultiSelect(boolean z) {
        this.multiSelect = z;
    }

    public final boolean getSelectOnLongClick() {
        return this.selectOnLongClick;
    }

    public final void setSelectOnLongClick(boolean z) {
        this.selectOnLongClick = z;
    }

    public final boolean getAllowDeselection() {
        return this.allowDeselection;
    }

    public final void setAllowDeselection(boolean z) {
        this.allowDeselection = z;
    }

    public final boolean isSelectable() {
        return this.isSelectable;
    }

    public final void setSelectable(boolean z) {
        this.isSelectable = z;
    }

    public final ISelectionListener<Item> getSelectionListener() {
        return this.selectionListener;
    }

    public final void setSelectionListener(ISelectionListener<Item> iSelectionListener) {
        this.selectionListener = iSelectionListener;
    }

    public final Set<Integer> getSelections() {
        SelectExtension selectExtension = this;
        Collection destination$iv = new ArraySet();
        Iterator it = RangesKt.until(0, selectExtension.fastAdapter.getItemCount()).iterator();
        while (it.hasNext()) {
            int i = ((IntIterator) it).nextInt();
            Object it$iv = Integer.valueOf(i);
            int intValue = ((Number) it$iv).intValue();
            Item item = selectExtension.fastAdapter.getItem(i);
            boolean z = true;
            if (item == null || !item.isSelected()) {
                z = false;
            }
            if (!z) {
                it$iv = null;
            }
            if (it$iv != null) {
                destination$iv.add(it$iv);
            }
            selectExtension = this;
        }
        return (Set) destination$iv;
    }

    public final Set<Item> getSelectedItems() {
        ArraySet items = new ArraySet();
        this.fastAdapter.recursive(new SelectExtension$selectedItems$1(items), false);
        return items;
    }

    public void withSavedInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (savedInstanceState != null) {
            long[] selectedItems = savedInstanceState.getLongArray(BUNDLE_SELECTIONS + prefix);
            if (selectedItems != null) {
                Intrinsics.checkExpressionValueIsNotNull(selectedItems, "savedInstanceState?.getL…TIONS + prefix) ?: return");
                for (long id : selectedItems) {
                    selectByIdentifier(id, false, true);
                }
            }
        }
    }

    public void saveInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (savedInstanceState != null) {
            Set<IItem> selections = getSelectedItems();
            long[] selectionsArray = new long[selections.size()];
            int i = 0;
            for (IItem item : selections) {
                selectionsArray[i] = item.getIdentifier();
                i++;
            }
            savedInstanceState.putLongArray(BUNDLE_SELECTIONS + prefix, selectionsArray);
        }
    }

    public boolean onClick(View v, int pos, FastAdapter<Item> fastAdapter2, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (this.selectOnLongClick || !this.isSelectable) {
            return false;
        }
        handleSelection(v, item, pos);
        return false;
    }

    public boolean onLongClick(View v, int pos, FastAdapter<Item> fastAdapter2, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!this.selectOnLongClick || !this.isSelectable) {
            return false;
        }
        handleSelection(v, item, pos);
        return false;
    }

    public boolean onTouch(View v, MotionEvent event, int position, FastAdapter<Item> fastAdapter2, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        return false;
    }

    public void notifyAdapterDataSetChanged() {
    }

    public void notifyAdapterItemRangeInserted(int position, int itemCount) {
    }

    public void notifyAdapterItemRangeRemoved(int position, int itemCount) {
    }

    public void notifyAdapterItemMoved(int fromPosition, int toPosition) {
    }

    public void notifyAdapterItemRangeChanged(int position, int itemCount, Object payload) {
    }

    public void set(List<? extends Item> items, boolean resetFilter) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
    }

    public void performFiltering(CharSequence constraint) {
    }

    public final void toggleSelection(int position) {
        Item item = this.fastAdapter.getItem(position);
        if (item == null || !item.isSelected()) {
            select$default(this, position, false, false, 6, (Object) null);
        } else {
            deselect$default(this, position, (Iterator) null, 2, (Object) null);
        }
    }

    private final void handleSelection(View view, Item item, int position) {
        if (item.isSelectable()) {
            if (!item.isSelected() || this.allowDeselection) {
                boolean selected = item.isSelected();
                if (this.selectWithItemUpdate || view == null) {
                    if (!this.multiSelect) {
                        deselect();
                    }
                    if (selected) {
                        deselect$default(this, position, (Iterator) null, 2, (Object) null);
                    } else {
                        select$default(this, position, false, false, 6, (Object) null);
                    }
                } else {
                    if (!this.multiSelect) {
                        Set selections = getSelectedItems();
                        selections.remove(item);
                        deselectByItems(selections);
                    }
                    item.setSelected(!selected);
                    view.setSelected(!selected);
                    ISelectionListener<Item> iSelectionListener = this.selectionListener;
                    if (iSelectionListener != null) {
                        iSelectionListener.onSelectionChanged(item, !selected);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void select$default(SelectExtension selectExtension, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        selectExtension.select(z);
    }

    public final void select(boolean considerSelectableFlag) {
        this.fastAdapter.recursive(new SelectExtension$select$1(this, considerSelectableFlag), false);
        this.fastAdapter.notifyDataSetChanged();
    }

    public final void select(Item item, boolean considerSelectableFlag) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!considerSelectableFlag || item.isSelectable()) {
            item.setSelected(true);
            ISelectionListener<Item> iSelectionListener = this.selectionListener;
            if (iSelectionListener != null) {
                iSelectionListener.onSelectionChanged(item, true);
            }
        }
    }

    public final void select(Iterable<Integer> positions) {
        Intrinsics.checkParameterIsNotNull(positions, "positions");
        for (Integer intValue : positions) {
            select$default(this, intValue.intValue(), false, false, 6, (Object) null);
        }
    }

    public static /* synthetic */ void select$default(SelectExtension selectExtension, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        selectExtension.select(i, z, z2);
    }

    public final void select(int position, boolean fireEvent, boolean considerSelectableFlag) {
        IAdapter adapter;
        FastAdapter.RelativeInfo relativeInfo = this.fastAdapter.getRelativeInfo(position);
        IItem item = relativeInfo.getItem();
        if (item != null && (adapter = relativeInfo.getAdapter()) != null) {
            select(adapter, item, position, fireEvent, considerSelectableFlag);
        }
    }

    public final void select(IAdapter<Item> adapter, Item item, int position, boolean fireEvent, boolean considerSelectableFlag) {
        Function4<View, IAdapter<Item>, Item, Integer, Boolean> onClickListener;
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (!considerSelectableFlag || item.isSelectable()) {
            item.setSelected(true);
            this.fastAdapter.notifyItemChanged(position);
            ISelectionListener<Item> iSelectionListener = this.selectionListener;
            if (iSelectionListener != null) {
                iSelectionListener.onSelectionChanged(item, true);
            }
            if (fireEvent && (onClickListener = this.fastAdapter.getOnClickListener()) != null) {
                Boolean invoke = onClickListener.invoke(null, adapter, item, Integer.valueOf(position));
            }
        }
    }

    public final void selectByIdentifier(long identifier, boolean fireEvent, boolean considerSelectableFlag) {
        this.fastAdapter.recursive(new SelectExtension$selectByIdentifier$1(this, identifier, fireEvent, considerSelectableFlag), true);
    }

    public final void selectByIdentifiers(Set<Long> identifiers, boolean fireEvent, boolean considerSelectableFlag) {
        Intrinsics.checkParameterIsNotNull(identifiers, "identifiers");
        this.fastAdapter.recursive(new SelectExtension$selectByIdentifiers$1(this, identifiers, fireEvent, considerSelectableFlag), false);
    }

    public final void deselect() {
        this.fastAdapter.recursive(new SelectExtension$deselect$1(this), false);
        this.fastAdapter.notifyDataSetChanged();
    }

    public final void deselect(Iterable<Integer> positions) {
        Intrinsics.checkParameterIsNotNull(positions, "positions");
        Iterator entries = positions.iterator();
        while (entries.hasNext()) {
            deselect(entries.next().intValue(), (Iterator<Integer>) entries);
        }
    }

    public static /* synthetic */ void deselect$default(SelectExtension selectExtension, int i, Iterator it, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            it = null;
        }
        selectExtension.deselect(i, (Iterator<Integer>) it);
    }

    public final void deselect(int position, Iterator<Integer> entries) {
        IItem item = this.fastAdapter.getItem(position);
        if (item != null) {
            deselect(item, position, entries);
        }
    }

    public static /* synthetic */ void deselect$default(SelectExtension selectExtension, IItem iItem, int i, Iterator it, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            it = null;
        }
        selectExtension.deselect(iItem, i, it);
    }

    public final void deselect(Item item, int position, Iterator<Integer> entries) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        item.setSelected(false);
        if (entries != null) {
            entries.remove();
        }
        if (position >= 0) {
            this.fastAdapter.notifyItemChanged(position);
        }
        ISelectionListener<Item> iSelectionListener = this.selectionListener;
        if (iSelectionListener != null) {
            iSelectionListener.onSelectionChanged(item, false);
        }
    }

    public final void deselectByIdentifier(long identifier) {
        this.fastAdapter.recursive(new SelectExtension$deselectByIdentifier$1(this, identifier), true);
    }

    public final void deselectByIdentifiers(Set<Long> identifiers) {
        Intrinsics.checkParameterIsNotNull(identifiers, "identifiers");
        this.fastAdapter.recursive(new SelectExtension$deselectByIdentifiers$1(this, identifiers), false);
    }

    public final void deselectByItems(Set<? extends Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        this.fastAdapter.recursive(new SelectExtension$deselectByItems$1(this, items), false);
    }

    public final List<Item> deleteAllSelectedItems() {
        ArrayList deletedItems = new ArrayList();
        ArrayList positions = new ArrayList();
        this.fastAdapter.recursive(new SelectExtension$deleteAllSelectedItems$1(positions), false);
        int i = positions.size();
        while (true) {
            i--;
            if (i < 0) {
                return deletedItems;
            }
            FastAdapter<Item> fastAdapter2 = this.fastAdapter;
            Object obj = positions.get(i);
            Intrinsics.checkExpressionValueIsNotNull(obj, "positions[i]");
            FastAdapter.RelativeInfo ri = fastAdapter2.getRelativeInfo(((Number) obj).intValue());
            if (ri.getItem() != null) {
                Item item = ri.getItem();
                if (item == null) {
                    Intrinsics.throwNpe();
                }
                if (item.isSelected()) {
                    IAdapter<Item> adapter = ri.getAdapter();
                    if (!(adapter instanceof IItemAdapter)) {
                        adapter = null;
                    }
                    IItemAdapter iItemAdapter = (IItemAdapter) adapter;
                    if (iItemAdapter != null) {
                        Object obj2 = positions.get(i);
                        Intrinsics.checkExpressionValueIsNotNull(obj2, "positions[i]");
                        iItemAdapter.remove(((Number) obj2).intValue());
                    }
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mikepenz/fastadapter/select/SelectExtension$Companion;", "", "()V", "BUNDLE_SELECTIONS", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SelectExtension.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    static {
        ExtensionsFactories.INSTANCE.register(new SelectExtensionFactory());
    }
}

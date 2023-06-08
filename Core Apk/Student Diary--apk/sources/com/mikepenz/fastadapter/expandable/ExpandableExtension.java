package com.mikepenz.fastadapter.expandable;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.dsl.FastAdapterDsl;
import com.mikepenz.fastadapter.extensions.ExtensionsFactories;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

@FastAdapterDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\n\b\u0007\u0018\u0000 L*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001LB\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u0012\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\"2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\"2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010(\u001a\u00020\u001aH\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dH\u0016J\"\u0010,\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001dH\u0016J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001dH\u0016J\u0016\u00102\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dJ3\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001d2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00109J3\u0010:\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001d2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00109J;\u0010;\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020FH\u0016J\u001f\u0010G\u001a\u00020\u001a2\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010I\u001a\u00020\u0015H\u0002J\u001a\u0010J\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0007J\u001a\u0010K\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020FH\u0016R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006M"}, d2 = {"Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "collapseAdapterPredicate", "com/mikepenz/fastadapter/expandable/ExpandableExtension$collapseAdapterPredicate$1", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension$collapseAdapterPredicate$1;", "expanded", "Landroid/util/SparseIntArray;", "getExpanded", "()Landroid/util/SparseIntArray;", "expandedItems", "", "getExpandedItems", "()[I", "isOnlyOneExpandedItem", "", "()Z", "setOnlyOneExpandedItem", "(Z)V", "collapse", "", "notifyItemChanged", "position", "", "collapseIncludeParents", "expand", "expandIncludeParents", "getExpandableParents", "", "Lcom/mikepenz/fastadapter/IExpandable;", "getExpandedItemsCount", "from", "getExpandedItemsRootLevel", "getExpandedItemsSameLevel", "notifyAdapterDataSetChanged", "notifyAdapterItemMoved", "fromPosition", "toPosition", "notifyAdapterItemRangeChanged", "itemCount", "payload", "", "notifyAdapterItemRangeInserted", "notifyAdapterItemRangeRemoved", "notifyAdapterSubItemsChanged", "previousCount", "onClick", "v", "Landroid/view/View;", "pos", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "onLongClick", "onTouch", "event", "Landroid/view/MotionEvent;", "(Landroid/view/View;Landroid/view/MotionEvent;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "performFiltering", "constraint", "", "saveInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "prefix", "", "set", "items", "resetFilter", "toggleExpandable", "withSavedInstanceState", "Companion", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
public final class ExpandableExtension<Item extends IItem<? extends RecyclerView.ViewHolder>> implements IAdapterExtension<Item> {
    private static final String BUNDLE_EXPANDED = "bundle_expanded";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ExpandableExtension$collapseAdapterPredicate$1 collapseAdapterPredicate = new ExpandableExtension$collapseAdapterPredicate$1();
    /* access modifiers changed from: private */
    public final FastAdapter<Item> fastAdapter;
    private boolean isOnlyOneExpandedItem;

    public final void collapse() {
        collapse$default(this, false, 1, (Object) null);
    }

    public final void collapse(int i) {
        collapse$default(this, i, false, 2, (Object) null);
    }

    public final void collapseIncludeParents(int i) {
        collapseIncludeParents$default(this, i, false, 2, (Object) null);
    }

    public final void expand() {
        expand$default(this, false, 1, (Object) null);
    }

    public final void expand(int i) {
        expand$default(this, i, false, 2, (Object) null);
    }

    public final void expandIncludeParents(int i) {
        expandIncludeParents$default(this, i, false, 2, (Object) null);
    }

    public final void toggleExpandable(int i) {
        toggleExpandable$default(this, i, false, 2, (Object) null);
    }

    public ExpandableExtension(FastAdapter<Item> fastAdapter2) {
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        this.fastAdapter = fastAdapter2;
    }

    public final boolean isOnlyOneExpandedItem() {
        return this.isOnlyOneExpandedItem;
    }

    public final void setOnlyOneExpandedItem(boolean z) {
        this.isOnlyOneExpandedItem = z;
    }

    public final SparseIntArray getExpanded() {
        SparseIntArray expandedItems = new SparseIntArray();
        Ref.IntRef i = new Ref.IntRef();
        i.element = 0;
        int size = this.fastAdapter.getItemCount();
        while (i.element < size) {
            ExpandableExtensionKt.ifExpandable(this.fastAdapter.getItem(i.element), new ExpandableExtension$expanded$1(expandedItems, i));
            i.element++;
        }
        return expandedItems;
    }

    public final int[] getExpandedItems() {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : RangesKt.until(0, this.fastAdapter.getItemCount())) {
            if (ExpandableExtensionKt.isExpanded(this.fastAdapter.getItem(((Number) element$iv$iv).intValue())) != 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.toIntArray((Collection) ((List) destination$iv$iv));
    }

    public void withSavedInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (savedInstanceState != null) {
            long[] expandedItems = savedInstanceState.getLongArray(BUNDLE_EXPANDED + prefix);
            if (expandedItems != null) {
                Intrinsics.checkExpressionValueIsNotNull(expandedItems, "savedInstanceState?.getL…ANDED + prefix) ?: return");
                int size = this.fastAdapter.getItemCount();
                for (int i = 0; i < size; i++) {
                    Item item = this.fastAdapter.getItem(i);
                    Long id = item != null ? Long.valueOf(item.getIdentifier()) : null;
                    if (id != null && ArraysKt.contains(expandedItems, id.longValue())) {
                        expand$default(this, i, false, 2, (Object) null);
                        size = this.fastAdapter.getItemCount();
                    }
                }
            }
        }
    }

    public void saveInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (savedInstanceState != null) {
            List expandedItems = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(RangesKt.until(0, this.fastAdapter.getItemCount())), new ExpandableExtension$saveInstanceState$expandedItems$1(this)), ExpandableExtension$saveInstanceState$expandedItems$2.INSTANCE), ExpandableExtension$saveInstanceState$expandedItems$3.INSTANCE));
            savedInstanceState.putLongArray(BUNDLE_EXPANDED + prefix, CollectionsKt.toLongArray(expandedItems));
        }
    }

    public boolean onClick(View v, int pos, FastAdapter<Item> fastAdapter2, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        ExpandableExtensionKt.ifExpandable(item, new ExpandableExtension$onClick$1(this, pos));
        return false;
    }

    public boolean onLongClick(View v, int pos, FastAdapter<Item> fastAdapter2, Item item) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(fastAdapter2, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
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
        collapse$default(this, fromPosition, false, 2, (Object) null);
        collapse$default(this, toPosition, false, 2, (Object) null);
    }

    public void notifyAdapterItemRangeChanged(int position, int itemCount, Object payload) {
        int i = position + itemCount;
        for (int i2 = position; i2 < i; i2++) {
            if (ExpandableExtensionKt.isExpanded(this.fastAdapter.getItem(position))) {
                collapse$default(this, position, false, 2, (Object) null);
            }
        }
    }

    public void set(List<? extends Item> items, boolean resetFilter) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        collapse(false);
    }

    public void performFiltering(CharSequence constraint) {
        collapse(false);
    }

    public final int notifyAdapterSubItemsChanged(int position, int previousCount) {
        Integer num = (Integer) ExpandableExtensionKt.ifExpandable(this.fastAdapter.getItem(position), new ExpandableExtension$notifyAdapterSubItemsChanged$1(this, position, previousCount));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final List<Integer> getExpandedItemsSameLevel(int position) {
        List result = (List) ExpandableExtensionKt.ifExpandableParent(this.fastAdapter.getItem(position), new ExpandableExtension$getExpandedItemsSameLevel$result$1(this));
        return result != null ? result : getExpandedItemsRootLevel(position);
    }

    public final List<Integer> getExpandedItemsRootLevel(int position) {
        List expandedItemsList = new ArrayList();
        IItem item = this.fastAdapter.getItem(position);
        Ref.IntRef i = new Ref.IntRef();
        i.element = 0;
        int size = this.fastAdapter.getItemCount();
        while (i.element < size) {
            ExpandableExtensionKt.ifExpandableParent(this.fastAdapter.getItem(i.element), new ExpandableExtension$getExpandedItemsRootLevel$1(this, i, item, expandedItemsList));
            i.element++;
        }
        return expandedItemsList;
    }

    public static /* synthetic */ void toggleExpandable$default(ExpandableExtension expandableExtension, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        expandableExtension.toggleExpandable(i, z);
    }

    public final void toggleExpandable(int position, boolean notifyItemChanged) {
        Item item = this.fastAdapter.getItem(position);
        if (!(item instanceof IExpandable)) {
            item = null;
        }
        IExpandable item2 = (IExpandable) item;
        if (item2 == null) {
            return;
        }
        if (item2.isExpanded()) {
            collapse(position, notifyItemChanged);
        } else {
            expand(position, notifyItemChanged);
        }
    }

    public static /* synthetic */ void collapse$default(ExpandableExtension expandableExtension, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        expandableExtension.collapse(z);
    }

    public final void collapse(boolean notifyItemChanged) {
        int[] expandedItems = getExpandedItems();
        int i = expandedItems.length;
        while (true) {
            i--;
            if (i >= 0) {
                collapse(expandedItems[i], notifyItemChanged);
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void collapse$default(ExpandableExtension expandableExtension, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        expandableExtension.collapse(i, z);
    }

    public final void collapse(int position, boolean notifyItemChanged) {
        IAdapter adapter = this.fastAdapter.getAdapter(position);
        IItemAdapter iItemAdapter = (IItemAdapter) (!(adapter instanceof IItemAdapter) ? null : adapter);
        if (iItemAdapter != null) {
            iItemAdapter.removeRange(position + 1, this.collapseAdapterPredicate.collapse(position, this.fastAdapter));
        }
        if (notifyItemChanged) {
            this.fastAdapter.notifyItemChanged(position);
        }
    }

    public static /* synthetic */ void collapseIncludeParents$default(ExpandableExtension expandableExtension, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        expandableExtension.collapseIncludeParents(i, z);
    }

    public final void collapseIncludeParents(int position, boolean notifyItemChanged) {
        for (IExpandable it : getExpandableParents(position)) {
            collapse$default(this, this.fastAdapter.getPosition(it.getIdentifier()), false, 2, (Object) null);
        }
        if (notifyItemChanged) {
            this.fastAdapter.notifyItemChanged(position);
        }
    }

    public static /* synthetic */ void expand$default(ExpandableExtension expandableExtension, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        expandableExtension.expand(z);
    }

    public final void expand(boolean notifyItemChanged) {
        for (int i = this.fastAdapter.getItemCount() - 1; i >= 0; i--) {
            expand(i, notifyItemChanged);
        }
    }

    public static /* synthetic */ void expand$default(ExpandableExtension expandableExtension, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        expandableExtension.expand(i, z);
    }

    public final void expand(int position, boolean notifyItemChanged) {
        Item item = this.fastAdapter.getItem(position);
        List subItems = null;
        if (!(item instanceof IExpandable)) {
            item = null;
        }
        IExpandable expandable = (IExpandable) item;
        if (expandable != null && !expandable.isExpanded() && (!expandable.getSubItems().isEmpty())) {
            IAdapter adapter = this.fastAdapter.getAdapter(position);
            if (adapter != null && (adapter instanceof IItemAdapter)) {
                List subItems2 = expandable.getSubItems();
                if (subItems2 instanceof List) {
                    subItems = subItems2;
                }
                if (subItems != null) {
                    ((IItemAdapter) adapter).addInternal(position + 1, subItems);
                }
            }
            expandable.setExpanded(true);
            if (notifyItemChanged) {
                this.fastAdapter.notifyItemChanged(position);
            }
        }
    }

    public static /* synthetic */ void expandIncludeParents$default(ExpandableExtension expandableExtension, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        expandableExtension.expandIncludeParents(i, z);
    }

    public final void expandIncludeParents(int position, boolean notifyItemChanged) {
        for (IExpandable it : getExpandableParents(position)) {
            expand$default(this, this.fastAdapter.getPosition(it.getIdentifier()), false, 2, (Object) null);
        }
        if (notifyItemChanged) {
            this.fastAdapter.notifyItemChanged(position);
        }
    }

    public final int getExpandedItemsCount(int from, int position) {
        return SequencesKt.sumOfInt(SequencesKt.map(SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(RangesKt.until(from, position)), new ExpandableExtension$getExpandedItemsCount$1(this)), ExpandableExtension$getExpandedItemsCount$2.INSTANCE), ExpandableExtension$getExpandedItemsCount$3.INSTANCE));
    }

    private final List<IExpandable<?>> getExpandableParents(int position) {
        Item item = this.fastAdapter.getItem(position);
        if (!(item instanceof IExpandable)) {
            item = null;
        }
        IExpandable expandable = (IExpandable) item;
        if (expandable == null) {
            return CollectionsKt.emptyList();
        }
        List parents = new ArrayList();
        IExpandable element = expandable;
        while (element != null) {
            parents.add(element);
            IIdentifyable parent = element.getParent();
            if (!(parent instanceof IExpandable)) {
                parent = null;
            }
            element = (IExpandable) parent;
        }
        return CollectionsKt.reversed(parents);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mikepenz/fastadapter/expandable/ExpandableExtension$Companion;", "", "()V", "BUNDLE_EXPANDED", "", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ExpandableExtension.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    static {
        ExtensionsFactories.INSTANCE.register(new ExpandableExtensionFactory());
    }
}

package com.mikepenz.fastadapter.expandable;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IParentItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0005\u001a\u00020\u0006\"\u0014\b\u0000\u0010\u0007*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rH\b\u001a,\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\f\"\u0014\b\u0000\u0010\u0007*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\b*\b\u0012\u0004\u0012\u0002H\u00070\t\u001a;\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00022\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u0002H\u00100\u000bH\u0000¢\u0006\u0002\u0010\u0012\u001aE\u0010\u0013\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00022 \u0010\n\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u0002H\u00100\u0014H\u0000¢\u0006\u0002\u0010\u0016\"\"\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u0017"}, d2 = {"isExpanded", "", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/mikepenz/fastadapter/IItem;)Z", "expandableExtension", "", "Item", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/FastAdapter;", "block", "Lkotlin/Function1;", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "Lkotlin/ExtensionFunctionType;", "getExpandableExtension", "ifExpandable", "R", "Lcom/mikepenz/fastadapter/IExpandable;", "(Lcom/mikepenz/fastadapter/IItem;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ifExpandableParent", "Lkotlin/Function2;", "Lcom/mikepenz/fastadapter/IParentItem;", "(Lcom/mikepenz/fastadapter/IItem;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastadapter-extensions-expandable"}, k = 2, mv = {1, 1, 16})
/* compiled from: ExpandableExtension.kt */
public final class ExpandableExtensionKt {
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> ExpandableExtension<Item> getExpandableExtension(FastAdapter<Item> $this$getExpandableExtension) {
        Intrinsics.checkParameterIsNotNull($this$getExpandableExtension, "$this$getExpandableExtension");
        ExpandableExtension.Companion.toString();
        IAdapterExtension orCreateExtension = $this$getExpandableExtension.getOrCreateExtension(ExpandableExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        return (ExpandableExtension) orCreateExtension;
    }

    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> void expandableExtension(FastAdapter<Item> $this$expandableExtension, Function1<? super ExpandableExtension<Item>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$expandableExtension, "$this$expandableExtension");
        Intrinsics.checkParameterIsNotNull(block, "block");
        block.invoke(getExpandableExtension($this$expandableExtension));
    }

    public static final boolean isExpanded(IItem<? extends RecyclerView.ViewHolder> $this$isExpanded) {
        IExpandable iExpandable = (IExpandable) (!($this$isExpanded instanceof IExpandable) ? null : $this$isExpanded);
        return iExpandable != null && iExpandable.isExpanded();
    }

    public static final <R> R ifExpandable(IItem<? extends RecyclerView.ViewHolder> $this$ifExpandable, Function1<? super IExpandable<?>, ? extends R> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        IExpandable iExpandable = (IExpandable) (!($this$ifExpandable instanceof IExpandable) ? null : $this$ifExpandable);
        if (iExpandable != null) {
            return block.invoke(iExpandable);
        }
        return null;
    }

    public static final <R> R ifExpandableParent(IItem<? extends RecyclerView.ViewHolder> $this$ifExpandableParent, Function2<? super IExpandable<?>, ? super IParentItem<?>, ? extends R> block) {
        IParentItem it;
        Intrinsics.checkParameterIsNotNull(block, "block");
        IExpandable iExpandable = (IExpandable) (!($this$ifExpandableParent instanceof IExpandable) ? null : $this$ifExpandableParent);
        if (iExpandable == null || (it = iExpandable.getParent()) == null) {
            return null;
        }
        return block.invoke($this$ifExpandableParent, it);
    }
}

package com.mikepenz.fastadapter.select;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001aH\u0010\u0007\u001a\u00020\b\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000bH\b¨\u0006\f"}, d2 = {"getSelectExtension", "Lcom/mikepenz/fastadapter/select/SelectExtension;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/FastAdapter;", "selectExtension", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "fastadapter"}, k = 2, mv = {1, 1, 16})
/* compiled from: SelectExtension.kt */
public final class SelectExtensionKt {
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> SelectExtension<Item> getSelectExtension(FastAdapter<Item> $this$getSelectExtension) {
        Intrinsics.checkParameterIsNotNull($this$getSelectExtension, "$this$getSelectExtension");
        SelectExtension.Companion.toString();
        IAdapterExtension orCreateExtension = $this$getSelectExtension.getOrCreateExtension(SelectExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        return (SelectExtension) orCreateExtension;
    }

    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> void selectExtension(FastAdapter<Item> $this$selectExtension, Function1<? super SelectExtension<Item>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$selectExtension, "$this$selectExtension");
        Intrinsics.checkParameterIsNotNull(block, "block");
        block.invoke(getSelectExtension($this$selectExtension));
    }
}

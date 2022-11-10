package com.mikepenz.fastadapter.dsl;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemList;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aN\u0010\u0000\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001j\u0002`\u00052-\u0010\u0006\u001a)\u0012\u001a\u0012\u0018\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\b\u001aH\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0014\b\u0000\u0010\u000b*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u0004*\u00020\f2\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\n\u001aR\u0010\r\u001a\u00020\b\"\u0014\b\u0000\u0010\u000e*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u0004\"\b\b\u0001\u0010\u000f*\u0002H\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00012\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0010\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\b\u001a\u0001\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u0012\"\u0014\b\u0001\u0010\u000e*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u0004\"\b\b\u0002\u0010\u000f*\u0002H\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00012#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u00072#\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000f0\u0017\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t\u001a\u0001\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u0012\"\u0014\b\u0001\u0010\u000e*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u0004\"\b\b\u0002\u0010\u000f*\u0002H\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00192#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u00072#\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000f0\u0017\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¨\u0006\u001a"}, d2 = {"genericFastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/GenericFastAdapter;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "invoke", "Item", "Lcom/mikepenz/fastadapter/FastAdapter$Companion;", "itemAdapter", "ParentItem", "ChildItem", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "modelAdapter", "Model", "interceptor", "Lkotlin/ParameterName;", "name", "element", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "itemList", "Lcom/mikepenz/fastadapter/IItemList;", "fastadapter"}, k = 2, mv = {1, 1, 16})
/* compiled from: FastAdapterDsl.kt */
public final class FastAdapterDslKt {
    @ExperimentalFADSL
    @FastAdapterDsl
    public static final FastAdapter<IItem<? extends RecyclerView.ViewHolder>> genericFastAdapter(Function1<? super FastAdapter<IItem<? extends RecyclerView.ViewHolder>>, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        FastAdapter<IItem<? extends RecyclerView.ViewHolder>> fastAdapter = new FastAdapter<>();
        block.invoke(fastAdapter);
        return fastAdapter;
    }

    @ExperimentalFADSL
    @FastAdapterDsl
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> FastAdapter<Item> invoke(FastAdapter.Companion $this$invoke, Function1<? super FastAdapter<Item>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$invoke, "$this$invoke");
        Intrinsics.checkParameterIsNotNull(block, "block");
        FastAdapter<Item> fastAdapter = new FastAdapter<>();
        block.invoke(fastAdapter);
        return fastAdapter;
    }

    public static final <ParentItem extends IItem<? extends RecyclerView.ViewHolder>, ChildItem extends ParentItem> void itemAdapter(FastAdapter<ParentItem> $this$itemAdapter, Function1<? super ItemAdapter<ChildItem>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$itemAdapter, "$this$itemAdapter");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ItemAdapter itemAdapter = new ItemAdapter();
        block.invoke(itemAdapter);
        $this$itemAdapter.addAdapters(CollectionsKt.listOf(itemAdapter));
    }

    public static final <Model, ParentItem extends IItem<? extends RecyclerView.ViewHolder>, ChildItem extends ParentItem> void modelAdapter(FastAdapter<ParentItem> $this$modelAdapter, Function1<? super Model, ? extends ChildItem> interceptor, Function1<? super ModelAdapter<Model, ChildItem>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$modelAdapter, "$this$modelAdapter");
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ModelAdapter modelAdapter = new ModelAdapter(interceptor);
        block.invoke(modelAdapter);
        $this$modelAdapter.addAdapters(CollectionsKt.listOf(modelAdapter));
    }

    public static final <Model, ParentItem extends IItem<? extends RecyclerView.ViewHolder>, ChildItem extends ParentItem> void modelAdapter(FastAdapter<ParentItem> $this$modelAdapter, IItemList<ChildItem> itemList, Function1<? super Model, ? extends ChildItem> interceptor, Function1<? super ModelAdapter<Model, ChildItem>, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$modelAdapter, "$this$modelAdapter");
        Intrinsics.checkParameterIsNotNull(itemList, "itemList");
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ModelAdapter modelAdapter = new ModelAdapter(itemList, interceptor);
        block.invoke(modelAdapter);
        $this$modelAdapter.addAdapters(CollectionsKt.listOf(modelAdapter));
    }
}

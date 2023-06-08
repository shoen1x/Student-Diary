package com.mikepenz.fastadapter.adapters;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.dsl.FastAdapterDsl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@FastAdapterDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \n*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001\nB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "()V", "itemList", "Lcom/mikepenz/fastadapter/IItemList;", "(Lcom/mikepenz/fastadapter/IItemList;)V", "Companion", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ItemAdapter.kt */
public class ItemAdapter<Item extends IItem<? extends RecyclerView.ViewHolder>> extends ModelAdapter<Item, Item> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> ItemAdapter<Item> items() {
        return Companion.items();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ItemAdapter() {
        /*
            r2 = this;
            kotlin.jvm.functions.Function1<com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>, com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>> r0 = com.mikepenz.fastadapter.utils.InterceptorUtil.DEFAULT
            if (r0 == 0) goto L_0x000f
            r1 = 1
            java.lang.Object r0 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, r1)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2.<init>(r0)
            return
        L_0x000f:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type (element: Item) -> Item?"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.adapters.ItemAdapter.<init>():void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ItemAdapter(com.mikepenz.fastadapter.IItemList<Item> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "itemList"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            kotlin.jvm.functions.Function1<com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>, com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView$ViewHolder>> r0 = com.mikepenz.fastadapter.utils.InterceptorUtil.DEFAULT
            if (r0 == 0) goto L_0x0014
            r1 = 1
            java.lang.Object r0 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, r1)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2.<init>(r3, r0)
            return
        L_0x0014:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type (element: Item) -> Item?"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.adapters.ItemAdapter.<init>(com.mikepenz.fastadapter.IItemList):void");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0014\b\u0001\u0010\u0005*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006j\u0002`\bH\u0007¨\u0006\t"}, d2 = {"Lcom/mikepenz/fastadapter/adapters/ItemAdapter$Companion;", "", "()V", "items", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ItemAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>> ItemAdapter<Item> items() {
            return new ItemAdapter<>();
        }
    }
}

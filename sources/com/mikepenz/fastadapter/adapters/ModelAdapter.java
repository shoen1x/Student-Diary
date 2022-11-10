package com.mikepenz.fastadapter.adapters;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.AbstractAdapter;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IAdapterNotifier;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IIdDistributor;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.IItemList;
import com.mikepenz.fastadapter.IModelItem;
import com.mikepenz.fastadapter.dsl.FastAdapterDsl;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import com.mikepenz.fastadapter.utils.DefaultItemList;
import com.mikepenz.fastadapter.utils.DefaultItemListImpl;
import com.mikepenz.fastadapter.utils.Triple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@FastAdapterDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 i*\u0004\b\u0000\u0010\u0001*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\b\u0012\u0004\u0012\u0002H\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007:\u0001iB,\b\u0016\u0012#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\t¢\u0006\u0002\u0010\rB8\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\t¢\u0006\u0002\u0010\u0010J-\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000=\"\u00028\u0000H\u0017¢\u0006\u0002\u0010>J5\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000=\"\u00028\u0000H\u0017¢\u0006\u0002\u0010@J*\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0016J\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0016J*\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000106H\u0016J\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000106H\u0016J\u0014\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0016J\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0015\u0010G\u001a\u00028\u00012\u0006\u0010?\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010KJ\u0010\u0010I\u001a\u00020\u00122\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0017\u0010O\u001a\u0004\u0018\u00018\u00012\u0006\u0010P\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010QJ\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00028\u0001062\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0016J$\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020\u0012H\u0016J0\u0010U\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00010X2\u0006\u0010Y\u001a\u00020)H\u0016J\b\u0010Z\u001a\u00020DH\u0016J\u001c\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u0012H\u0016J\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010L\u001a\u00020MH\u0016J$\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u0012H\u0016J*\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\u0006\u0010J\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010`J\"\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0016J+\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010a\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u0010b\u001a\u00020)H\u0002J5\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010a\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u0010b\u001a\u00020)2\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J)\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010?\u001a\u00020\u00122\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010fJ4\u0010e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u0001062\u0006\u0010b\u001a\u00020)2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J*\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u0010h\u001a\u00020)H\u0016R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R4\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\rR\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R&\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0018R9\u00108\u001a!\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010\r¨\u0006j"}, d2 = {"Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "Model", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/AbstractAdapter;", "Lcom/mikepenz/fastadapter/IItemAdapter;", "interceptor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/jvm/functions/Function1;)V", "itemList", "Lcom/mikepenz/fastadapter/IItemList;", "(Lcom/mikepenz/fastadapter/IItemList;Lkotlin/jvm/functions/Function1;)V", "adapterItemCount", "", "getAdapterItemCount", "()I", "adapterItems", "", "getAdapterItems", "()Ljava/util/List;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "setFastAdapter", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "idDistributor", "Lcom/mikepenz/fastadapter/IIdDistributor;", "getIdDistributor", "()Lcom/mikepenz/fastadapter/IIdDistributor;", "setIdDistributor", "(Lcom/mikepenz/fastadapter/IIdDistributor;)V", "getInterceptor", "()Lkotlin/jvm/functions/Function1;", "setInterceptor", "isUseIdDistributor", "", "()Z", "setUseIdDistributor", "(Z)V", "itemFilter", "Lcom/mikepenz/fastadapter/adapters/ItemFilter;", "getItemFilter", "()Lcom/mikepenz/fastadapter/adapters/ItemFilter;", "setItemFilter", "(Lcom/mikepenz/fastadapter/adapters/ItemFilter;)V", "getItemList", "()Lcom/mikepenz/fastadapter/IItemList;", "models", "", "getModels", "reverseInterceptor", "getReverseInterceptor", "setReverseInterceptor", "add", "items", "", "([Ljava/lang/Object;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "position", "(I[Ljava/lang/Object;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "addInternal", "clear", "filter", "", "constraint", "", "getAdapterItem", "(I)Lcom/mikepenz/fastadapter/IItem;", "getAdapterPosition", "item", "(Lcom/mikepenz/fastadapter/IItem;)I", "identifier", "", "getGlobalPosition", "intercept", "model", "(Ljava/lang/Object;)Lcom/mikepenz/fastadapter/IItem;", "move", "fromPosition", "toPosition", "recursive", "Lcom/mikepenz/fastadapter/utils/Triple;", "predicate", "Lcom/mikepenz/fastadapter/utils/AdapterPredicate;", "stopOnMatch", "remapMappedTypes", "remove", "removeByIdentifier", "removeRange", "itemCount", "set", "(ILjava/lang/Object;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "list", "resetFilter", "adapterNotifier", "Lcom/mikepenz/fastadapter/IAdapterNotifier;", "setInternal", "(ILcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "setNewList", "retainFilter", "Companion", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ModelAdapter.kt */
public class ModelAdapter<Model, Item extends IItem<? extends RecyclerView.ViewHolder>> extends AbstractAdapter<Item> implements IItemAdapter<Model, Item> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private IIdDistributor<Item> idDistributor;
    private Function1<? super Model, ? extends Item> interceptor;
    private boolean isUseIdDistributor;
    private ItemFilter<Model, Item> itemFilter;
    private final IItemList<Item> itemList;
    private Function1<? super Item, ? extends Model> reverseInterceptor;

    @JvmStatic
    public static final <Model, Item extends IItem<? extends RecyclerView.ViewHolder>> ModelAdapter<Model, Item> models(Function1<? super Model, ? extends Item> function1) {
        return Companion.models(function1);
    }

    public ModelAdapter(IItemList<Item> itemList2, Function1<? super Model, ? extends Item> interceptor2) {
        Intrinsics.checkParameterIsNotNull(itemList2, "itemList");
        Intrinsics.checkParameterIsNotNull(interceptor2, "interceptor");
        this.itemList = itemList2;
        this.interceptor = interceptor2;
        IIdDistributor<? extends IIdentifyable> iIdDistributor = IIdDistributor.DEFAULT;
        if (iIdDistributor != null) {
            this.idDistributor = iIdDistributor;
            this.isUseIdDistributor = true;
            this.itemFilter = new ItemFilter<>(this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.IIdDistributor<Item>");
    }

    public final IItemList<Item> getItemList() {
        return this.itemList;
    }

    public final Function1<Model, Item> getInterceptor() {
        return this.interceptor;
    }

    public final void setInterceptor(Function1<? super Model, ? extends Item> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.interceptor = function1;
    }

    public FastAdapter<Item> getFastAdapter() {
        return super.getFastAdapter();
    }

    public void setFastAdapter(FastAdapter<Item> fastAdapter) {
        IItemList<Item> iItemList = this.itemList;
        if (iItemList instanceof DefaultItemList) {
            if (iItemList != null) {
                ((DefaultItemList) iItemList).setFastAdapter(fastAdapter);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.utils.DefaultItemList<Item>");
            }
        }
        super.setFastAdapter(fastAdapter);
    }

    public Function1<Item, Model> getReverseInterceptor() {
        return this.reverseInterceptor;
    }

    public void setReverseInterceptor(Function1<? super Item, ? extends Model> function1) {
        this.reverseInterceptor = function1;
    }

    public IIdDistributor<Item> getIdDistributor() {
        return this.idDistributor;
    }

    public void setIdDistributor(IIdDistributor<Item> iIdDistributor) {
        Intrinsics.checkParameterIsNotNull(iIdDistributor, "<set-?>");
        this.idDistributor = iIdDistributor;
    }

    public final boolean isUseIdDistributor() {
        return this.isUseIdDistributor;
    }

    public final void setUseIdDistributor(boolean z) {
        this.isUseIdDistributor = z;
    }

    public ItemFilter<Model, Item> getItemFilter() {
        return this.itemFilter;
    }

    public void setItemFilter(ItemFilter<Model, Item> itemFilter2) {
        Intrinsics.checkParameterIsNotNull(itemFilter2, "<set-?>");
        this.itemFilter = itemFilter2;
    }

    public List<Model> getModels() {
        Object interceptedItem;
        ArrayList list = new ArrayList(this.itemList.size());
        for (Item item : this.itemList.getItems()) {
            if (item instanceof IModelItem) {
                Object model = ((IModelItem) item).getModel();
                if (!(model instanceof Object)) {
                    model = null;
                }
                if (model != null) {
                    list.add(model);
                }
            } else if (getReverseInterceptor() != null) {
                Function1 reverseInterceptor2 = getReverseInterceptor();
                if (!(reverseInterceptor2 == null || (interceptedItem = reverseInterceptor2.invoke(item)) == null)) {
                    list.add(interceptedItem);
                }
            } else {
                throw new RuntimeException("to get the list of models, the item either needs to implement `IModelItem` or you have to provide a `reverseInterceptor`");
            }
        }
        return list;
    }

    public int getAdapterItemCount() {
        return this.itemList.size();
    }

    public List<Item> getAdapterItems() {
        return this.itemList.getItems();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ModelAdapter(Function1<? super Model, ? extends Item> interceptor2) {
        this(new DefaultItemListImpl((List) null, 1, (DefaultConstructorMarker) null), interceptor2);
        Intrinsics.checkParameterIsNotNull(interceptor2, "interceptor");
    }

    public Item intercept(Model model) {
        return (IItem) this.interceptor.invoke(model);
    }

    public List<Item> intercept(List<? extends Model> models) {
        Intrinsics.checkParameterIsNotNull(models, "models");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : models) {
            Object it$iv$iv = intercept(element$iv$iv$iv);
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public void filter(CharSequence constraint) {
        getItemFilter().filter(constraint);
    }

    public int getAdapterPosition(Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        return getAdapterPosition(item.getIdentifier());
    }

    public int getAdapterPosition(long identifier) {
        return this.itemList.getAdapterPosition(identifier);
    }

    public int getGlobalPosition(int position) {
        FastAdapter fastAdapter = getFastAdapter();
        return (fastAdapter != null ? fastAdapter.getPreItemCountByOrder(getOrder()) : 0) + position;
    }

    public Item getAdapterItem(int position) {
        Item item = this.itemList.get(position);
        if (item != null) {
            return item;
        }
        throw new RuntimeException("A normal ModelAdapter does not allow null items.");
    }

    public ModelAdapter<Model, Item> set(List<? extends Model> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        return set(items, true);
    }

    /* access modifiers changed from: protected */
    public final ModelAdapter<Model, Item> set(List<? extends Model> list, boolean resetFilter) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        return setInternal(intercept(list), resetFilter, (IAdapterNotifier) null);
    }

    public ModelAdapter<Model, Item> set(List<? extends Model> list, boolean resetFilter, IAdapterNotifier adapterNotifier) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        return setInternal(intercept(list), resetFilter, adapterNotifier);
    }

    public ModelAdapter<Model, Item> setInternal(List<? extends Item> items, boolean resetFilter, IAdapterNotifier adapterNotifier) {
        Collection<IAdapterExtension> $this$forEach$iv;
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if (this.isUseIdDistributor) {
            getIdDistributor().checkIds(items);
        }
        if (resetFilter && getItemFilter().getConstraint() != null) {
            getItemFilter().resetFilter();
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (!(fastAdapter == null || ($this$forEach$iv = fastAdapter.getExtensions()) == null)) {
            for (IAdapterExtension extension : $this$forEach$iv) {
                extension.set(items, resetFilter);
            }
        }
        mapPossibleTypes(items);
        FastAdapter fastAdapter2 = getFastAdapter();
        this.itemList.set(items, fastAdapter2 != null ? fastAdapter2.getPreItemCountByOrder(getOrder()) : 0, adapterNotifier);
        return this;
    }

    public ModelAdapter<Model, Item> setNewList(List<? extends Model> items, boolean retainFilter) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        List<Item> intercept = intercept(items);
        if (this.isUseIdDistributor) {
            getIdDistributor().checkIds(intercept);
        }
        CharSequence filter = null;
        if (getItemFilter().getConstraint() != null) {
            filter = getItemFilter().getConstraint();
            getItemFilter().resetFilter();
        }
        mapPossibleTypes(intercept);
        boolean z = true;
        boolean publishResults = filter != null && retainFilter;
        if (retainFilter && filter != null) {
            getItemFilter().filterItems(filter);
        }
        IItemList<Item> iItemList = this.itemList;
        if (publishResults) {
            z = false;
        }
        iItemList.setNewList(intercept, z);
        return this;
    }

    public void remapMappedTypes() {
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            fastAdapter.clearTypeInstance();
        }
        mapPossibleTypes(this.itemList.getItems());
    }

    @SafeVarargs
    public ModelAdapter<Model, Item> add(Model... items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        List asList = Arrays.asList(Arrays.copyOf(items, items.length));
        Intrinsics.checkExpressionValueIsNotNull(asList, "asList(*items)");
        return add(asList);
    }

    public ModelAdapter<Model, Item> add(List<? extends Model> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        return addInternal((List) intercept(items));
    }

    public ModelAdapter<Model, Item> addInternal(List<? extends Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if (this.isUseIdDistributor) {
            getIdDistributor().checkIds(items);
        }
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            this.itemList.addAll(items, fastAdapter.getPreItemCountByOrder(getOrder()));
        } else {
            this.itemList.addAll(items, 0);
        }
        mapPossibleTypes(items);
        return this;
    }

    @SafeVarargs
    public ModelAdapter<Model, Item> add(int position, Model... items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        List asList = Arrays.asList(Arrays.copyOf(items, items.length));
        Intrinsics.checkExpressionValueIsNotNull(asList, "asList(*items)");
        return add(position, asList);
    }

    public ModelAdapter<Model, Item> add(int position, List<? extends Model> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        return addInternal(position, intercept(items));
    }

    public ModelAdapter<Model, Item> addInternal(int position, List<? extends Item> items) {
        Intrinsics.checkParameterIsNotNull(items, FirebaseAnalytics.Param.ITEMS);
        if (this.isUseIdDistributor) {
            getIdDistributor().checkIds(items);
        }
        if (!items.isEmpty()) {
            IItemList<Item> iItemList = this.itemList;
            FastAdapter fastAdapter = getFastAdapter();
            iItemList.addAll(position, items, fastAdapter != null ? fastAdapter.getPreItemCountByOrder(getOrder()) : 0);
            mapPossibleTypes(items);
        }
        return this;
    }

    public ModelAdapter<Model, Item> set(int position, Model item) {
        IItem interceptedItem = intercept(item);
        if (interceptedItem != null) {
            return setInternal(position, interceptedItem);
        }
        return this;
    }

    public ModelAdapter<Model, Item> setInternal(int position, Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (this.isUseIdDistributor) {
            getIdDistributor().checkId((IIdentifyable) item);
        }
        IItemList<Item> iItemList = this.itemList;
        FastAdapter fastAdapter = getFastAdapter();
        iItemList.set(position, item, fastAdapter != null ? fastAdapter.getPreItemCount(position) : 0);
        FastAdapter fastAdapter2 = getFastAdapter();
        if (fastAdapter2 != null) {
            fastAdapter2.registerTypeInstance(item);
        }
        return this;
    }

    public ModelAdapter<Model, Item> move(int fromPosition, int toPosition) {
        IItemList<Item> iItemList = this.itemList;
        FastAdapter fastAdapter = getFastAdapter();
        iItemList.move(fromPosition, toPosition, fastAdapter != null ? fastAdapter.getPreItemCount(fromPosition) : 0);
        return this;
    }

    public ModelAdapter<Model, Item> remove(int position) {
        IItemList<Item> iItemList = this.itemList;
        FastAdapter fastAdapter = getFastAdapter();
        iItemList.remove(position, fastAdapter != null ? fastAdapter.getPreItemCount(position) : 0);
        return this;
    }

    public ModelAdapter<Model, Item> removeRange(int position, int itemCount) {
        IItemList<Item> iItemList = this.itemList;
        FastAdapter fastAdapter = getFastAdapter();
        iItemList.removeRange(position, itemCount, fastAdapter != null ? fastAdapter.getPreItemCount(position) : 0);
        return this;
    }

    public ModelAdapter<Model, Item> clear() {
        IItemList<Item> iItemList = this.itemList;
        FastAdapter fastAdapter = getFastAdapter();
        iItemList.clear(fastAdapter != null ? fastAdapter.getPreItemCountByOrder(getOrder()) : 0);
        return this;
    }

    public ModelAdapter<Model, Item> removeByIdentifier(long identifier) {
        recursive(new ModelAdapter$removeByIdentifier$1(this, identifier), false);
        return this;
    }

    public Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> predicate, boolean stopOnMatch) {
        AdapterPredicate<Item> adapterPredicate = predicate;
        Intrinsics.checkParameterIsNotNull(adapterPredicate, "predicate");
        FastAdapter fastAdapter = getFastAdapter();
        if (fastAdapter != null) {
            FastAdapter fastAdapter2 = fastAdapter;
            int preItemCount = fastAdapter2.getPreItemCountByOrder(getOrder());
            int adapterItemCount = getAdapterItemCount();
            int i = 0;
            while (i < adapterItemCount) {
                int i2 = i;
                int globalPosition = i2 + preItemCount;
                FastAdapter.RelativeInfo relativeInfo = fastAdapter2.getRelativeInfo(globalPosition);
                IItem item = relativeInfo.getItem();
                if (item != null) {
                    IAdapter adapter = relativeInfo.getAdapter();
                    if (adapter != null && adapterPredicate.apply(adapter, globalPosition, item, globalPosition) && stopOnMatch) {
                        return new Triple<>(true, item, Integer.valueOf(globalPosition));
                    }
                    IExpandable expandableItem = (IExpandable) (!(item instanceof IExpandable) ? null : item);
                    if (expandableItem != null) {
                        IAdapter adapter2 = relativeInfo.getAdapter();
                        if (adapter2 != null) {
                            IItem iItem = item;
                            Triple res = FastAdapter.Companion.recursiveSub(adapter2, globalPosition, expandableItem, predicate, stopOnMatch);
                            if (res.getFirst().booleanValue() && stopOnMatch) {
                                return res;
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        return new Triple<>(false, null, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0002\u0010\u0005\"\u0014\b\u0003\u0010\u0006*\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t2#\u0010\n\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/fastadapter/adapters/ModelAdapter$Companion;", "", "()V", "models", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "Model", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "interceptor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ModelAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final <Model, Item extends IItem<? extends RecyclerView.ViewHolder>> ModelAdapter<Model, Item> models(Function1<? super Model, ? extends Item> interceptor) {
            Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
            return new ModelAdapter<>(interceptor);
        }
    }
}

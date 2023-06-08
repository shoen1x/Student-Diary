package com.mikepenz.materialdrawer;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.MiniDrawerItem;
import com.mikepenz.materialdrawer.model.MiniProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialize.util.UIUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\b\u0016\u0018\u0000 e2\u00020\u0001:\u0002efB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u001a\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u0014\u0010L\u001a\u0002032\n\u0010K\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u0012\u0010M\u001a\u00020$2\n\u0010N\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010O\u001a\u00020IJ\u000e\u0010P\u001a\u00020I2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020I2\u0006\u0010Q\u001a\u00020RJ\u0010\u0010T\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020$J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020$J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020$J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020$J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010`\u001a\u00020$J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020*Jx\u0010c\u001a\u00020\u00002p\u0010<\u001al\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,Jz\u0010d\u001a\u00020\u00002r\u0010?\u001an\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R8\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b@DX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR8\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001b2\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001b@DX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000Rx\u0010+\u001al\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000Rz\u00105\u001an\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t07X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R{\u0010<\u001al\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b=\u0010>R}\u0010?\u001an\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\n\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020$\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b@\u0010>R\u001e\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020A@BX.¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006g"}, d2 = {"Lcom/mikepenz/materialdrawer/MiniDrawer;", "", "()V", "<set-?>", "Lcom/mikepenz/materialdrawer/AccountHeader;", "accountHeader", "getAccountHeader", "()Lcom/mikepenz/materialdrawer/AccountHeader;", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "adapter", "getAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "setAdapter", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "Lcom/mikepenz/materialdrawer/interfaces/ICrossfader;", "crossFader", "getCrossFader", "()Lcom/mikepenz/materialdrawer/interfaces/ICrossfader;", "Lcom/mikepenz/materialdrawer/Drawer;", "drawer", "getDrawer", "()Lcom/mikepenz/materialdrawer/Drawer;", "drawerItems", "", "getDrawerItems", "()Ljava/util/List;", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "itemAdapter", "getItemAdapter", "()Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "setItemAdapter", "(Lcom/mikepenz/fastadapter/adapters/ItemAdapter;)V", "mContainer", "Landroid/widget/LinearLayout;", "mEnableProfileClick", "", "mEnableSelectedMiniDrawerItemBackground", "mInRTL", "mIncludeSecondaryDrawerItems", "mInnerShadow", "mOnMiniDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/MiniDrawer$OnMiniDrawerItemClickListener;", "mOnMiniDrawerItemLongClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "Lcom/mikepenz/fastadapter/IAdapter;", "item", "", "position", "mOnMiniDrawerItemOnClickListener", "mSelectExtension", "Lcom/mikepenz/fastadapter/select/SelectExtension;", "getMSelectExtension", "()Lcom/mikepenz/fastadapter/select/SelectExtension;", "setMSelectExtension", "(Lcom/mikepenz/fastadapter/select/SelectExtension;)V", "onMiniDrawerItemLongClickListener", "getOnMiniDrawerItemLongClickListener", "()Lkotlin/jvm/functions/Function4;", "onMiniDrawerItemOnClickListener", "getOnMiniDrawerItemOnClickListener", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "build", "ctx", "Landroid/content/Context;", "createItems", "", "generateMiniDrawerItem", "drawerItem", "getMiniDrawerType", "onItemClick", "selectedDrawerItem", "onProfileClick", "setSelection", "identifier", "", "updateItem", "withAccountHeader", "withCrossFader", "withDrawer", "withEnableProfileClick", "enableProfileClick", "withEnableSelectedMiniDrawerItemBackground", "enableSelectedMiniDrawerItemBackground", "withInRTL", "inRTL", "withIncludeSecondaryDrawerItems", "includeSecondaryDrawerItems", "withInnerShadow", "innerShadow", "withOnMiniDrawerItemClickListener", "onMiniDrawerItemClickListener", "withOnMiniDrawerItemLongClickListener", "withOnMiniDrawerItemOnClickListener", "Companion", "OnMiniDrawerItemClickListener", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: MiniDrawer.kt */
public class MiniDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int ITEM = 2;
    /* access modifiers changed from: private */
    public static final int PROFILE = 1;
    /* access modifiers changed from: private */
    public AccountHeader accountHeader;
    protected FastAdapter<IDrawerItem<?>> adapter;
    /* access modifiers changed from: private */
    public ICrossfader crossFader;
    /* access modifiers changed from: private */
    public Drawer drawer;
    protected ItemAdapter<IDrawerItem<?>> itemAdapter;
    private LinearLayout mContainer;
    private boolean mEnableProfileClick = true;
    private boolean mEnableSelectedMiniDrawerItemBackground;
    private boolean mInRTL;
    private boolean mIncludeSecondaryDrawerItems;
    private boolean mInnerShadow;
    /* access modifiers changed from: private */
    public OnMiniDrawerItemClickListener mOnMiniDrawerItemClickListener;
    private Function4<? super View, ? super IAdapter<IDrawerItem<?>>, ? super IDrawerItem<?>, ? super Integer, Boolean> mOnMiniDrawerItemLongClickListener;
    private Function4<? super View, ? super IAdapter<IDrawerItem<?>>, ? super IDrawerItem<?>, ? super Integer, Boolean> mOnMiniDrawerItemOnClickListener;
    public SelectExtension<IDrawerItem<?>> mSelectExtension;
    private RecyclerView recyclerView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/materialdrawer/MiniDrawer$OnMiniDrawerItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "type", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MiniDrawer.kt */
    public interface OnMiniDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem<?> iDrawerItem, int i2);
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView2;
    }

    public final FastAdapter<IDrawerItem<?>> getAdapter() {
        FastAdapter<IDrawerItem<?>> fastAdapter = this.adapter;
        if (fastAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return fastAdapter;
    }

    /* access modifiers changed from: protected */
    public final void setAdapter(FastAdapter<IDrawerItem<?>> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "<set-?>");
        this.adapter = fastAdapter;
    }

    public final ItemAdapter<IDrawerItem<?>> getItemAdapter() {
        ItemAdapter<IDrawerItem<?>> itemAdapter2 = this.itemAdapter;
        if (itemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        }
        return itemAdapter2;
    }

    /* access modifiers changed from: protected */
    public final void setItemAdapter(ItemAdapter<IDrawerItem<?>> itemAdapter2) {
        Intrinsics.checkParameterIsNotNull(itemAdapter2, "<set-?>");
        this.itemAdapter = itemAdapter2;
    }

    public final SelectExtension<IDrawerItem<?>> getMSelectExtension() {
        SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
        if (selectExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
        }
        return selectExtension;
    }

    public final void setMSelectExtension(SelectExtension<IDrawerItem<?>> selectExtension) {
        Intrinsics.checkParameterIsNotNull(selectExtension, "<set-?>");
        this.mSelectExtension = selectExtension;
    }

    public final Drawer getDrawer() {
        return this.drawer;
    }

    public final AccountHeader getAccountHeader() {
        return this.accountHeader;
    }

    public final ICrossfader getCrossFader() {
        return this.crossFader;
    }

    public final Function4<View, IAdapter<IDrawerItem<?>>, IDrawerItem<?>, Integer, Boolean> getOnMiniDrawerItemOnClickListener() {
        return this.mOnMiniDrawerItemOnClickListener;
    }

    public final Function4<View, IAdapter<IDrawerItem<?>>, IDrawerItem<?>, Integer, Boolean> getOnMiniDrawerItemLongClickListener() {
        return this.mOnMiniDrawerItemLongClickListener;
    }

    /* access modifiers changed from: private */
    public final List<IDrawerItem<?>> getDrawerItems() {
        List<IDrawerItem<?>> list;
        Drawer drawer2 = this.drawer;
        if (drawer2 == null || (list = drawer2.getOriginalDrawerItems()) == null) {
            Drawer drawer3 = this.drawer;
            list = drawer3 != null ? drawer3.getDrawerItems() : null;
        }
        return list != null ? list : new ArrayList<>();
    }

    public final MiniDrawer withDrawer(Drawer drawer2) {
        Intrinsics.checkParameterIsNotNull(drawer2, "drawer");
        this.drawer = drawer2;
        return this;
    }

    public final MiniDrawer withAccountHeader(AccountHeader accountHeader2) {
        this.accountHeader = accountHeader2;
        return this;
    }

    public final MiniDrawer withCrossFader(ICrossfader crossFader2) {
        Intrinsics.checkParameterIsNotNull(crossFader2, "crossFader");
        this.crossFader = crossFader2;
        return this;
    }

    public final MiniDrawer withInnerShadow(boolean innerShadow) {
        this.mInnerShadow = innerShadow;
        return this;
    }

    public final MiniDrawer withInRTL(boolean inRTL) {
        this.mInRTL = inRTL;
        return this;
    }

    public final MiniDrawer withIncludeSecondaryDrawerItems(boolean includeSecondaryDrawerItems) {
        this.mIncludeSecondaryDrawerItems = includeSecondaryDrawerItems;
        return this;
    }

    public final MiniDrawer withEnableSelectedMiniDrawerItemBackground(boolean enableSelectedMiniDrawerItemBackground) {
        this.mEnableSelectedMiniDrawerItemBackground = enableSelectedMiniDrawerItemBackground;
        return this;
    }

    public final MiniDrawer withEnableProfileClick(boolean enableProfileClick) {
        this.mEnableProfileClick = enableProfileClick;
        return this;
    }

    public final MiniDrawer withOnMiniDrawerItemClickListener(OnMiniDrawerItemClickListener onMiniDrawerItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onMiniDrawerItemClickListener, "onMiniDrawerItemClickListener");
        this.mOnMiniDrawerItemClickListener = onMiniDrawerItemClickListener;
        return this;
    }

    public final MiniDrawer withOnMiniDrawerItemOnClickListener(Function4<? super View, ? super IAdapter<IDrawerItem<?>>, ? super IDrawerItem<?>, ? super Integer, Boolean> onMiniDrawerItemOnClickListener) {
        this.mOnMiniDrawerItemOnClickListener = onMiniDrawerItemOnClickListener;
        return this;
    }

    public final MiniDrawer withOnMiniDrawerItemLongClickListener(Function4<? super View, ? super IAdapter<IDrawerItem<?>>, ? super IDrawerItem<?>, ? super Integer, Boolean> onMiniDrawerItemLongClickListener) {
        this.mOnMiniDrawerItemLongClickListener = onMiniDrawerItemLongClickListener;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.mikepenz.materialdrawer.model.MiniDrawerItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?> generateMiniDrawerItem(com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "drawerItem"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r0 = r5 instanceof com.mikepenz.materialdrawer.model.SecondaryDrawerItem
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0028
            boolean r0 = r4.mIncludeSecondaryDrawerItems
            if (r0 == 0) goto L_0x0025
            com.mikepenz.materialdrawer.model.MiniDrawerItem r0 = new com.mikepenz.materialdrawer.model.MiniDrawerItem
            r1 = r5
            com.mikepenz.materialdrawer.model.SecondaryDrawerItem r1 = (com.mikepenz.materialdrawer.model.SecondaryDrawerItem) r1
            r0.<init>((com.mikepenz.materialdrawer.model.SecondaryDrawerItem) r1)
            boolean r1 = r4.mEnableSelectedMiniDrawerItemBackground
            com.mikepenz.materialdrawer.model.MiniDrawerItem r0 = r0.withEnableSelectedBackground(r1)
            java.lang.Object r0 = r0.withSelectedBackgroundAnimated(r2)
            r1 = r0
            com.mikepenz.materialdrawer.model.MiniDrawerItem r1 = (com.mikepenz.materialdrawer.model.MiniDrawerItem) r1
        L_0x0025:
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r1 = (com.mikepenz.materialdrawer.model.interfaces.IDrawerItem) r1
            goto L_0x005a
        L_0x0028:
            boolean r0 = r5 instanceof com.mikepenz.materialdrawer.model.PrimaryDrawerItem
            if (r0 == 0) goto L_0x0042
            com.mikepenz.materialdrawer.model.MiniDrawerItem r0 = new com.mikepenz.materialdrawer.model.MiniDrawerItem
            r1 = r5
            com.mikepenz.materialdrawer.model.PrimaryDrawerItem r1 = (com.mikepenz.materialdrawer.model.PrimaryDrawerItem) r1
            r0.<init>((com.mikepenz.materialdrawer.model.PrimaryDrawerItem) r1)
            boolean r1 = r4.mEnableSelectedMiniDrawerItemBackground
            com.mikepenz.materialdrawer.model.MiniDrawerItem r0 = r0.withEnableSelectedBackground(r1)
            java.lang.Object r0 = r0.withSelectedBackgroundAnimated(r2)
            r1 = r0
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r1 = (com.mikepenz.materialdrawer.model.interfaces.IDrawerItem) r1
            goto L_0x005a
        L_0x0042:
            boolean r0 = r5 instanceof com.mikepenz.materialdrawer.model.ProfileDrawerItem
            if (r0 == 0) goto L_0x0059
            com.mikepenz.materialdrawer.model.MiniProfileDrawerItem r0 = new com.mikepenz.materialdrawer.model.MiniProfileDrawerItem
            r1 = r5
            com.mikepenz.materialdrawer.model.ProfileDrawerItem r1 = (com.mikepenz.materialdrawer.model.ProfileDrawerItem) r1
            r0.<init>(r1)
            r1 = r0
            r2 = 0
            boolean r3 = r4.mEnableProfileClick
            r1.withEnabled(r3)
            r1 = r0
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r1 = (com.mikepenz.materialdrawer.model.interfaces.IDrawerItem) r1
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.MiniDrawer.generateMiniDrawerItem(com.mikepenz.materialdrawer.model.interfaces.IDrawerItem):com.mikepenz.materialdrawer.model.interfaces.IDrawerItem");
    }

    public int getMiniDrawerType(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (drawerItem instanceof MiniProfileDrawerItem) {
            return PROFILE;
        }
        if (drawerItem instanceof MiniDrawerItem) {
            return ITEM;
        }
        return -1;
    }

    public View build(Context ctx) {
        DrawerBuilder builder;
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        LinearLayout linearLayout = new LinearLayout(ctx);
        this.mContainer = linearLayout;
        if (this.mInnerShadow) {
            if (!this.mInRTL) {
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                }
                linearLayout.setBackgroundResource(R.drawable.material_drawer_shadow_left);
            } else {
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                }
                linearLayout.setBackgroundResource(R.drawable.material_drawer_shadow_right);
            }
        }
        this.recyclerView = new RecyclerView(ctx);
        LinearLayout linearLayout2 = this.mContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        linearLayout2.addView(recyclerView2, -1, -1);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView4.setFadingEdgeLength(0);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView5.setClipToPadding(false);
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView6.setLayoutManager(new LinearLayoutManager(ctx));
        this.itemAdapter = new ItemAdapter<>();
        FastAdapter.Companion companion = FastAdapter.Companion;
        ItemAdapter<IDrawerItem<?>> itemAdapter2 = this.itemAdapter;
        if (itemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        }
        FastAdapter<IDrawerItem<?>> with = companion.with(itemAdapter2);
        this.adapter = with;
        if (with == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        IAdapterExtension orCreateExtension = with.getOrCreateExtension(SelectExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        SelectExtension<IDrawerItem<?>> selectExtension = (SelectExtension) orCreateExtension;
        this.mSelectExtension = selectExtension;
        if (selectExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
        }
        selectExtension.setSelectable(true);
        SelectExtension<IDrawerItem<?>> selectExtension2 = this.mSelectExtension;
        if (selectExtension2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
        }
        selectExtension2.setAllowDeselection(false);
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        FastAdapter<IDrawerItem<?>> fastAdapter = this.adapter;
        if (fastAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView7.setAdapter(fastAdapter);
        Drawer drawer2 = this.drawer;
        if (!(drawer2 == null || (builder = drawer2.getDrawerBuilder$materialdrawer()) == null)) {
            if (builder.getMFullscreen$materialdrawer() || builder.getMTranslucentStatusBar$materialdrawer()) {
                RecyclerView recyclerView8 = this.recyclerView;
                if (recyclerView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                RecyclerView recyclerView9 = this.recyclerView;
                if (recyclerView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                int paddingLeft = recyclerView9.getPaddingLeft();
                int statusBarHeight = UIUtils.getStatusBarHeight(ctx);
                RecyclerView recyclerView10 = this.recyclerView;
                if (recyclerView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                int paddingRight = recyclerView10.getPaddingRight();
                RecyclerView recyclerView11 = this.recyclerView;
                if (recyclerView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                recyclerView8.setPadding(paddingLeft, statusBarHeight, paddingRight, recyclerView11.getPaddingBottom());
            }
            if (builder.getMFullscreen$materialdrawer() || builder.getMTranslucentNavigationBar$materialdrawer()) {
                Resources resources = ctx.getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "ctx.resources");
                if (resources.getConfiguration().orientation == 1) {
                    RecyclerView recyclerView12 = this.recyclerView;
                    if (recyclerView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    RecyclerView recyclerView13 = this.recyclerView;
                    if (recyclerView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    int paddingLeft2 = recyclerView13.getPaddingLeft();
                    RecyclerView recyclerView14 = this.recyclerView;
                    if (recyclerView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    int paddingTop = recyclerView14.getPaddingTop();
                    RecyclerView recyclerView15 = this.recyclerView;
                    if (recyclerView15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    recyclerView12.setPadding(paddingLeft2, paddingTop, recyclerView15.getPaddingRight(), UIUtils.getNavigationBarHeight(ctx));
                }
            }
        }
        createItems();
        LinearLayout linearLayout3 = this.mContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        }
        return linearLayout3;
    }

    public final void onProfileClick() {
        IDrawerItem item;
        ICrossfader it = this.crossFader;
        if (it != null && it.isCrossfaded()) {
            it.crossfade();
        }
        AccountHeader it2 = this.accountHeader;
        if (it2 != null) {
            IProfile<?> activeProfile = it2.getActiveProfile();
            if ((activeProfile instanceof IDrawerItem) && (item = generateMiniDrawerItem((IDrawerItem) activeProfile)) != null) {
                ItemAdapter<IDrawerItem<?>> itemAdapter2 = this.itemAdapter;
                if (itemAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                }
                itemAdapter2.set(0, (Object) item);
            }
        }
    }

    public final boolean onItemClick(IDrawerItem<?> selectedDrawerItem) {
        Intrinsics.checkParameterIsNotNull(selectedDrawerItem, "selectedDrawerItem");
        if (!selectedDrawerItem.isSelectable()) {
            return true;
        }
        ICrossfader it = this.crossFader;
        if (it != null && it.isCrossfaded()) {
            it.crossfade();
        }
        setSelection(selectedDrawerItem.getIdentifier());
        return false;
    }

    public final void setSelection(long identifier) {
        if (identifier == -1) {
            SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
            if (selectExtension == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension.deselect();
        }
        FastAdapter<IDrawerItem<?>> fastAdapter = this.adapter;
        if (fastAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        int count = fastAdapter.getItemCount();
        for (int i = 0; i < count; i++) {
            FastAdapter<IDrawerItem<?>> fastAdapter2 = this.adapter;
            if (fastAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            IDrawerItem item = fastAdapter2.getItem(i);
            if (item != null && item.getIdentifier() == identifier && !item.isSelected()) {
                SelectExtension<IDrawerItem<?>> selectExtension2 = this.mSelectExtension;
                if (selectExtension2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                selectExtension2.deselect();
                SelectExtension<IDrawerItem<?>> selectExtension3 = this.mSelectExtension;
                if (selectExtension3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                SelectExtension.select$default(selectExtension3, i, false, false, 6, (Object) null);
            }
        }
    }

    public final void updateItem(long identifier) {
        IDrawerItem drawerItem;
        IDrawerItem miniDrawerItem;
        if (this.drawer != null && identifier != -1 && (drawerItem = DrawerUtils.INSTANCE.getDrawerItem((List<? extends IDrawerItem<?>>) getDrawerItems(), identifier)) != null) {
            ItemAdapter<IDrawerItem<?>> itemAdapter2 = this.itemAdapter;
            if (itemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            }
            int size = itemAdapter2.getAdapterItems().size();
            for (int i = 0; i < size; i++) {
                ItemAdapter<IDrawerItem<?>> itemAdapter3 = this.itemAdapter;
                if (itemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                }
                if (itemAdapter3.getAdapterItems().get(i).getIdentifier() == drawerItem.getIdentifier() && (miniDrawerItem = generateMiniDrawerItem(drawerItem)) != null) {
                    ItemAdapter<IDrawerItem<?>> itemAdapter4 = this.itemAdapter;
                    if (itemAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                    }
                    itemAdapter4.set(i, (Object) miniDrawerItem);
                }
            }
        }
    }

    public void createItems() {
        ItemAdapter<IDrawerItem<?>> itemAdapter2 = this.itemAdapter;
        if (itemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        }
        itemAdapter2.clear();
        int profileOffset = 0;
        AccountHeader accountHeader2 = this.accountHeader;
        if (accountHeader2 != null) {
            IProfile<?> activeProfile = accountHeader2.getActiveProfile();
            if (activeProfile instanceof IDrawerItem) {
                IDrawerItem it = generateMiniDrawerItem((IDrawerItem) activeProfile);
                if (it != null) {
                    ItemAdapter<IDrawerItem<?>> itemAdapter3 = this.itemAdapter;
                    if (itemAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                    }
                    itemAdapter3.add((Object[]) new IDrawerItem[]{it});
                }
                profileOffset = 1;
            }
        }
        int select = -1;
        if (this.drawer != null) {
            int length = getDrawerItems().size();
            int position = 0;
            for (int i = 0; i < length; i++) {
                IDrawerItem miniDrawerItem = generateMiniDrawerItem(getDrawerItems().get(i));
                if (miniDrawerItem != null) {
                    if (miniDrawerItem.isSelected()) {
                        select = position;
                    }
                    ItemAdapter<IDrawerItem<?>> itemAdapter4 = this.itemAdapter;
                    if (itemAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                    }
                    itemAdapter4.add((Object[]) new IDrawerItem[]{miniDrawerItem});
                    position++;
                }
            }
            if (select >= 0) {
                SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
                if (selectExtension == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                SelectExtension.select$default(selectExtension, select + profileOffset, false, false, 6, (Object) null);
            }
        }
        if (this.mOnMiniDrawerItemOnClickListener != null) {
            FastAdapter<IDrawerItem<?>> fastAdapter = this.adapter;
            if (fastAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            fastAdapter.setOnClickListener(this.mOnMiniDrawerItemOnClickListener);
        } else {
            FastAdapter<IDrawerItem<?>> fastAdapter2 = this.adapter;
            if (fastAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            fastAdapter2.setOnClickListener(new MiniDrawer$createItems$2(this));
        }
        FastAdapter<IDrawerItem<?>> fastAdapter3 = this.adapter;
        if (fastAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        fastAdapter3.setOnLongClickListener(this.mOnMiniDrawerItemLongClickListener);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.scrollToPosition(0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/MiniDrawer$Companion;", "", "()V", "ITEM", "", "getITEM", "()I", "PROFILE", "getPROFILE", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MiniDrawer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final int getPROFILE() {
            return MiniDrawer.PROFILE;
        }

        public final int getITEM() {
            return MiniDrawer.ITEM;
        }
    }
}

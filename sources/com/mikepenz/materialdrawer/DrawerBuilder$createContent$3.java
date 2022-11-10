package com.mikepenz.materialdrawer;

import android.os.Handler;
import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "<anonymous parameter 1>", "Lcom/mikepenz/fastadapter/IAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "item", "position", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$createContent$3 extends Lambda implements Function4<View, IAdapter<IDrawerItem<?>>, IDrawerItem<?>, Integer, Boolean> {
    final /* synthetic */ DrawerBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerBuilder$createContent$3(DrawerBuilder drawerBuilder) {
        super(4);
        this.this$0 = drawerBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(invoke((View) obj, (IAdapter<IDrawerItem<?>>) (IAdapter) obj2, (IDrawerItem<?>) (IDrawerItem) obj3, ((Number) obj4).intValue()));
    }

    public final boolean invoke(View v, IAdapter<IDrawerItem<?>> $noName_1, IDrawerItem<?> item, int position) {
        boolean z;
        View view = v;
        IDrawerItem<?> iDrawerItem = item;
        int i = position;
        Intrinsics.checkParameterIsNotNull($noName_1, "<anonymous parameter 1>");
        Intrinsics.checkParameterIsNotNull(iDrawerItem, "item");
        if (!(iDrawerItem instanceof Selectable) || item.isSelectable()) {
            this.this$0.resetStickyFooterSelection$materialdrawer();
            this.this$0.setMCurrentStickyFooterSelection$materialdrawer(-1);
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Ref.BooleanRef consumed = booleanRef;
        if (iDrawerItem instanceof AbstractDrawerItem) {
            Drawer.OnDrawerItemClickListener onDrawerItemClickListener = ((AbstractDrawerItem) iDrawerItem).getOnDrawerItemClickListener();
            if (onDrawerItemClickListener != null) {
                z = onDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
            } else {
                z = false;
            }
            consumed.element = z;
        }
        Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener$materialdrawer = this.this$0.getMOnDrawerItemClickListener$materialdrawer();
        if (mOnDrawerItemClickListener$materialdrawer != null) {
            Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener = mOnDrawerItemClickListener$materialdrawer;
            if (this.this$0.getMDelayDrawerClickEvent$materialdrawer() > 0) {
                new Handler().postDelayed(new DrawerBuilder$createContent$3$$special$$inlined$let$lambda$1(mOnDrawerItemClickListener, this, v, position, item, consumed), (long) this.this$0.getMDelayDrawerClickEvent$materialdrawer());
            } else {
                consumed.element = mOnDrawerItemClickListener.onItemClick(view, i, iDrawerItem);
            }
        }
        if (!consumed.element) {
            MiniDrawer mMiniDrawer$materialdrawer = this.this$0.getMMiniDrawer$materialdrawer();
            consumed.element = mMiniDrawer$materialdrawer != null ? mMiniDrawer$materialdrawer.onItemClick(iDrawerItem) : false;
        }
        if (!item.getSubItems().isEmpty()) {
            return true;
        }
        if (!consumed.element) {
            this.this$0.closeDrawerDelayed$materialdrawer();
        }
        return consumed.element;
    }
}

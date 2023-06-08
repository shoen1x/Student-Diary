package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "<anonymous parameter 1>", "Lcom/mikepenz/fastadapter/IAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "item", "position", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$createContent$4 extends Lambda implements Function4<View, IAdapter<IDrawerItem<?>>, IDrawerItem<?>, Integer, Boolean> {
    final /* synthetic */ DrawerBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerBuilder$createContent$4(DrawerBuilder drawerBuilder) {
        super(4);
        this.this$0 = drawerBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(invoke((View) obj, (IAdapter<IDrawerItem<?>>) (IAdapter) obj2, (IDrawerItem<?>) (IDrawerItem) obj3, ((Number) obj4).intValue()));
    }

    public final boolean invoke(View v, IAdapter<IDrawerItem<?>> $noName_1, IDrawerItem<?> item, int position) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull($noName_1, "<anonymous parameter 1>");
        Intrinsics.checkParameterIsNotNull(item, "item");
        Drawer.OnDrawerItemLongClickListener mOnDrawerItemLongClickListener$materialdrawer = this.this$0.getMOnDrawerItemLongClickListener$materialdrawer();
        if (mOnDrawerItemLongClickListener$materialdrawer != null) {
            return mOnDrawerItemLongClickListener$materialdrawer.onItemLongClick(v, position, item);
        }
        return false;
    }
}

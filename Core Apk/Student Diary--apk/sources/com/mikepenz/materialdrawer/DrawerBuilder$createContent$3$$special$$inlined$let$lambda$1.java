package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/mikepenz/materialdrawer/DrawerBuilder$createContent$3$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$createContent$3$$special$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ Ref.BooleanRef $consumed$inlined;
    final /* synthetic */ IDrawerItem $item$inlined;
    final /* synthetic */ Drawer.OnDrawerItemClickListener $mOnDrawerItemClickListener;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ View $v$inlined;
    final /* synthetic */ DrawerBuilder$createContent$3 this$0;

    DrawerBuilder$createContent$3$$special$$inlined$let$lambda$1(Drawer.OnDrawerItemClickListener onDrawerItemClickListener, DrawerBuilder$createContent$3 drawerBuilder$createContent$3, View view, int i, IDrawerItem iDrawerItem, Ref.BooleanRef booleanRef) {
        this.$mOnDrawerItemClickListener = onDrawerItemClickListener;
        this.this$0 = drawerBuilder$createContent$3;
        this.$v$inlined = view;
        this.$position$inlined = i;
        this.$item$inlined = iDrawerItem;
        this.$consumed$inlined = booleanRef;
    }

    public final void run() {
        this.$mOnDrawerItemClickListener.onItemClick(this.$v$inlined, this.$position$inlined, this.$item$inlined);
    }
}

package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$createContent$2 implements View.OnClickListener {
    final /* synthetic */ DrawerBuilder this$0;

    DrawerBuilder$createContent$2(DrawerBuilder drawerBuilder) {
        this.this$0 = drawerBuilder;
    }

    public final void onClick(View v) {
        Object tag = v.getTag(R.id.material_drawer_item);
        if (tag != null) {
            DrawerUtils drawerUtils = DrawerUtils.INSTANCE;
            DrawerBuilder drawerBuilder = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(v, "v");
            drawerUtils.onFooterDrawerItemClick(drawerBuilder, (IDrawerItem) tag, v, true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<*>");
    }
}

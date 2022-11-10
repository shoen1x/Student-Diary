package com.mikepenz.materialdrawer.util;

import android.view.View;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.DrawerItemViewHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerItemViewHelper.kt */
final class DrawerItemViewHelper$build$1 implements View.OnClickListener {
    final /* synthetic */ DrawerItemViewHelper this$0;

    DrawerItemViewHelper$build$1(DrawerItemViewHelper drawerItemViewHelper) {
        this.this$0 = drawerItemViewHelper;
    }

    public final void onClick(View v) {
        DrawerItemViewHelper.OnDrawerItemClickListener access$getMOnDrawerItemClickListener$p = this.this$0.mOnDrawerItemClickListener;
        if (access$getMOnDrawerItemClickListener$p != null) {
            Intrinsics.checkExpressionValueIsNotNull(v, "v");
            Object tag = v.getTag(R.id.material_drawer_item);
            if (tag != null) {
                access$getMOnDrawerItemClickListener$p.onItemClick(v, (IDrawerItem) tag);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<*>");
        }
    }
}

package com.mikepenz.materialdrawer;

import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.mikepenz.materialdrawer.Drawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$handleDrawerNavigation$toolbarNavigationListener$1 implements View.OnClickListener {
    final /* synthetic */ DrawerBuilder this$0;

    DrawerBuilder$handleDrawerNavigation$toolbarNavigationListener$1(DrawerBuilder drawerBuilder) {
        this.this$0 = drawerBuilder;
    }

    public final void onClick(View v) {
        boolean z;
        boolean handled = false;
        ActionBarDrawerToggle mActionBarDrawerToggle$materialdrawer = this.this$0.getMActionBarDrawerToggle$materialdrawer();
        if (mActionBarDrawerToggle$materialdrawer != null && !mActionBarDrawerToggle$materialdrawer.isDrawerIndicatorEnabled()) {
            Drawer.OnDrawerNavigationListener mOnDrawerNavigationListener$materialdrawer = this.this$0.getMOnDrawerNavigationListener$materialdrawer();
            if (mOnDrawerNavigationListener$materialdrawer != null) {
                Intrinsics.checkExpressionValueIsNotNull(v, "v");
                z = mOnDrawerNavigationListener$materialdrawer.onNavigationClickListener(v);
            } else {
                z = false;
            }
            handled = z;
        }
        if (handled) {
            return;
        }
        if (this.this$0.getMDrawerLayout$materialdrawer().isDrawerOpen(this.this$0.getMDrawerGravity$materialdrawer())) {
            this.this$0.getMDrawerLayout$materialdrawer().closeDrawer(this.this$0.getMDrawerGravity$materialdrawer());
        } else {
            this.this$0.getMDrawerLayout$materialdrawer().openDrawer(this.this$0.getMDrawerGravity$materialdrawer());
        }
    }
}

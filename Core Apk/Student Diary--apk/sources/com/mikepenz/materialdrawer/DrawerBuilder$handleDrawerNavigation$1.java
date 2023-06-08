package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.mikepenz.materialdrawer.Drawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/mikepenz/materialdrawer/DrawerBuilder$handleDrawerNavigation$1", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
public final class DrawerBuilder$handleDrawerNavigation$1 extends ActionBarDrawerToggle {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ DrawerBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerBuilder$handleDrawerNavigation$1(DrawerBuilder $outer, Activity $captured_local_variable$1, Activity $super_call_param$2, DrawerLayout $super_call_param$3, Toolbar $super_call_param$4, int $super_call_param$5, int $super_call_param$6) {
        super($super_call_param$2, $super_call_param$3, $super_call_param$4, $super_call_param$5, $super_call_param$6);
        this.this$0 = $outer;
        this.$activity = $captured_local_variable$1;
    }

    public void onDrawerOpened(View drawerView) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.this$0.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerOpened(drawerView);
        }
        super.onDrawerOpened(drawerView);
    }

    public void onDrawerClosed(View drawerView) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.this$0.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerClosed(drawerView);
        }
        super.onDrawerClosed(drawerView);
    }

    public void onDrawerSlide(View drawerView, float slideOffset) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.this$0.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerSlide(drawerView, slideOffset);
        }
        if (!this.this$0.getMAnimateActionBarDrawerToggle$materialdrawer()) {
            super.onDrawerSlide(drawerView, 0.0f);
        } else {
            super.onDrawerSlide(drawerView, slideOffset);
        }
    }
}

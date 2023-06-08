package com.mikepenz.materialdrawer;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.mikepenz.materialdrawer.Drawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/mikepenz/materialdrawer/DrawerBuilder$handleDrawerNavigation$3$1", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
public final class DrawerBuilder$handleDrawerNavigation$3$1 implements DrawerLayout.DrawerListener {
    final /* synthetic */ DrawerBuilder $this_run;

    DrawerBuilder$handleDrawerNavigation$3$1(DrawerBuilder $receiver) {
        this.$this_run = $receiver;
    }

    public void onDrawerSlide(View drawerView, float slideOffset) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.$this_run.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerSlide(drawerView, slideOffset);
        }
    }

    public void onDrawerOpened(View drawerView) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.$this_run.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerOpened(drawerView);
        }
    }

    public void onDrawerClosed(View drawerView) {
        Intrinsics.checkParameterIsNotNull(drawerView, "drawerView");
        Drawer.OnDrawerListener mOnDrawerListener$materialdrawer = this.$this_run.getMOnDrawerListener$materialdrawer();
        if (mOnDrawerListener$materialdrawer != null) {
            mOnDrawerListener$materialdrawer.onDrawerClosed(drawerView);
        }
    }

    public void onDrawerStateChanged(int newState) {
    }
}

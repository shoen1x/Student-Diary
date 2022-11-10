package com.mikepenz.materialdrawer;

import android.content.SharedPreferences;
import androidx.drawerlayout.widget.DrawerLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f¸\u0006\u0000"}, d2 = {"com/mikepenz/materialdrawer/DrawerBuilder$handleShowOnLaunch$1$1", "Landroidx/drawerlayout/widget/DrawerLayout$SimpleDrawerListener;", "hasBeenDragged", "", "getHasBeenDragged", "()Z", "setHasBeenDragged", "(Z)V", "onDrawerStateChanged", "", "newState", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
public final class DrawerBuilder$handleShowOnLaunch$$inlined$let$lambda$1 extends DrawerLayout.SimpleDrawerListener {
    final /* synthetic */ SharedPreferences $preferences;
    private boolean hasBeenDragged;
    final /* synthetic */ DrawerBuilder this$0;

    DrawerBuilder$handleShowOnLaunch$$inlined$let$lambda$1(SharedPreferences $captured_local_variable$1, DrawerBuilder drawerBuilder) {
        this.$preferences = $captured_local_variable$1;
        this.this$0 = drawerBuilder;
    }

    public final boolean getHasBeenDragged() {
        return this.hasBeenDragged;
    }

    public final void setHasBeenDragged(boolean z) {
        this.hasBeenDragged = z;
    }

    public void onDrawerStateChanged(int newState) {
        if (newState == 1) {
            this.hasBeenDragged = true;
        } else if (newState != 0) {
        } else {
            if (!this.hasBeenDragged || !this.this$0.getMDrawerLayout$materialdrawer().isDrawerOpen(this.this$0.getMDrawerGravity$materialdrawer())) {
                this.hasBeenDragged = false;
                return;
            }
            SharedPreferences.Editor editor = this.$preferences.edit();
            editor.putBoolean(Drawer.PREF_USER_OPENED_DRAWER_BY_DRAGGING, true);
            editor.apply();
        }
    }
}

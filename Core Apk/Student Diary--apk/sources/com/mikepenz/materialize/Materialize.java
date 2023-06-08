package com.mikepenz.materialize;

import android.app.Activity;
import android.view.ViewGroup;
import com.mikepenz.materialize.util.KeyboardUtil;
import com.mikepenz.materialize.view.IScrimInsetsLayout;

public class Materialize {
    private final MaterializeBuilder mBuilder;
    private KeyboardUtil mKeyboardUtil = null;

    protected Materialize(MaterializeBuilder materializeBuilder) {
        this.mBuilder = materializeBuilder;
    }

    public void setFullscreen(boolean fullscreen) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintStatusBar(!fullscreen);
            this.mBuilder.mScrimInsetsLayout.setTintNavigationBar(!fullscreen);
        }
    }

    public void setTintStatusBar(boolean tintStatusBar) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintStatusBar(tintStatusBar);
        }
    }

    public void setTintNavigationBar(boolean tintNavigationBar) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setTintNavigationBar(tintNavigationBar);
        }
    }

    public void setStatusBarColor(int statusBarColor) {
        if (this.mBuilder.mScrimInsetsLayout != null) {
            this.mBuilder.mScrimInsetsLayout.setInsetForeground(statusBarColor);
            this.mBuilder.mScrimInsetsLayout.getView().invalidate();
        }
    }

    public IScrimInsetsLayout getScrimInsetsFrameLayout() {
        return this.mBuilder.mScrimInsetsLayout;
    }

    public ViewGroup getContent() {
        return this.mBuilder.mContentRoot;
    }

    public void keyboardSupportEnabled(Activity activity, boolean enable) {
        if (getContent() != null && getContent().getChildCount() > 0) {
            if (this.mKeyboardUtil == null) {
                KeyboardUtil keyboardUtil = new KeyboardUtil(activity, getContent().getChildAt(0));
                this.mKeyboardUtil = keyboardUtil;
                keyboardUtil.disable();
            }
            if (enable) {
                this.mKeyboardUtil.enable();
            } else {
                this.mKeyboardUtil.disable();
            }
        }
    }
}

package com.mikepenz.materialize;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.materialize.view.IScrimInsetsLayout;
import com.mikepenz.materialize.view.ScrimInsetsFrameLayout;

public class MaterializeBuilder {
    protected Activity mActivity;
    protected ViewGroup mContainer = null;
    protected ViewGroup.LayoutParams mContainerLayoutParams = null;
    protected ViewGroup mContentRoot;
    protected boolean mFullscreen = false;
    protected boolean mNavigationBarPadding = false;
    protected ViewGroup mRootView;
    protected IScrimInsetsLayout mScrimInsetsLayout;
    protected int mStatusBarColor = 0;
    protected int mStatusBarColorRes = -1;
    protected boolean mStatusBarPadding = false;
    protected boolean mSystemUIHidden = false;
    protected boolean mTintNavigationBar = false;
    protected boolean mTintStatusBar = true;
    protected boolean mTranslucentNavigationBarProgrammatically = false;
    protected boolean mTranslucentStatusBarProgrammatically = false;
    protected boolean mTransparentNavigationBar = false;
    protected boolean mTransparentStatusBar = false;
    protected boolean mUseScrimInsetsLayout = true;

    public MaterializeBuilder() {
    }

    public MaterializeBuilder(Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
    }

    public MaterializeBuilder withActivity(Activity activity) {
        this.mRootView = (ViewGroup) activity.findViewById(16908290);
        this.mActivity = activity;
        return this;
    }

    public MaterializeBuilder withRootView(ViewGroup rootView) {
        this.mRootView = rootView;
        return this;
    }

    public MaterializeBuilder withRootView(int rootViewRes) {
        Activity activity = this.mActivity;
        if (activity != null) {
            return withRootView((ViewGroup) activity.findViewById(rootViewRes));
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public MaterializeBuilder withUseScrimInsetsLayout(boolean useScrimInsetsLayout) {
        this.mUseScrimInsetsLayout = useScrimInsetsLayout;
        return this;
    }

    public MaterializeBuilder withStatusBarColor(int statusBarColor) {
        this.mStatusBarColor = statusBarColor;
        return this;
    }

    public MaterializeBuilder withStatusBarColorRes(int statusBarColorRes) {
        this.mStatusBarColorRes = statusBarColorRes;
        return this;
    }

    public MaterializeBuilder withTransparentStatusBar(boolean transparentStatusBar) {
        this.mTransparentStatusBar = transparentStatusBar;
        return this;
    }

    public MaterializeBuilder withTranslucentStatusBarProgrammatically(boolean translucentStatusBarProgrammatically) {
        this.mTranslucentStatusBarProgrammatically = translucentStatusBarProgrammatically;
        return this;
    }

    public MaterializeBuilder withStatusBarPadding(boolean statusBarPadding) {
        this.mStatusBarPadding = statusBarPadding;
        return this;
    }

    public MaterializeBuilder withTintedStatusBar(boolean tintedStatusBar) {
        this.mTintStatusBar = tintedStatusBar;
        return this;
    }

    public MaterializeBuilder withTranslucentNavigationBarProgrammatically(boolean translucentNavigationBarProgrammatically) {
        this.mTranslucentNavigationBarProgrammatically = translucentNavigationBarProgrammatically;
        return this;
    }

    public MaterializeBuilder withTransparentNavigationBar(boolean navigationBar) {
        this.mTransparentNavigationBar = navigationBar;
        return this;
    }

    public MaterializeBuilder withNavigationBarPadding(boolean navigationBarPadding) {
        this.mNavigationBarPadding = navigationBarPadding;
        return this;
    }

    public MaterializeBuilder withTintedNavigationBar(boolean tintedNavigationBar) {
        this.mTintNavigationBar = tintedNavigationBar;
        if (tintedNavigationBar) {
            withTranslucentNavigationBarProgrammatically(true);
        }
        return this;
    }

    public MaterializeBuilder withFullscreen(boolean fullscreen) {
        this.mFullscreen = fullscreen;
        if (fullscreen) {
            withTranslucentNavigationBarProgrammatically(true);
            withTintedStatusBar(false);
            withTintedNavigationBar(false);
        }
        return this;
    }

    public MaterializeBuilder withSystemUIHidden(boolean systemUIHidden) {
        this.mSystemUIHidden = systemUIHidden;
        if (systemUIHidden) {
            withFullscreen(systemUIHidden);
        }
        return this;
    }

    public MaterializeBuilder withContainer(ViewGroup container) {
        this.mContainer = container;
        return this;
    }

    public MaterializeBuilder withContainerLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.mContainerLayoutParams = layoutParams;
        return this;
    }

    public MaterializeBuilder withContainer(ViewGroup container, ViewGroup.LayoutParams layoutParams) {
        this.mContainer = container;
        this.mContainerLayoutParams = layoutParams;
        return this;
    }

    public Materialize build() {
        int i;
        Activity activity = this.mActivity;
        if (activity != null) {
            if (this.mUseScrimInsetsLayout) {
                this.mScrimInsetsLayout = (ScrimInsetsFrameLayout) activity.getLayoutInflater().inflate(R.layout.materialize, this.mRootView, false);
                ViewGroup viewGroup = this.mRootView;
                if (viewGroup == null || viewGroup.getChildCount() == 0) {
                    throw new RuntimeException("You have to set your layout for this activity with setContentView() first. Or you build the drawer on your own with .buildView()");
                }
                View originalContentView = this.mRootView.getChildAt(0);
                boolean alreadyInflated = originalContentView.getId() == R.id.materialize_root;
                if (this.mStatusBarColor == 0 && (i = this.mStatusBarColorRes) != -1) {
                    this.mStatusBarColor = ContextCompat.getColor(this.mActivity, i);
                } else if (this.mStatusBarColor == 0) {
                    this.mStatusBarColor = UIUtils.getThemeColorFromAttrOrRes(this.mActivity, R.attr.colorPrimaryDark, R.color.materialize_primary_dark);
                }
                this.mScrimInsetsLayout.setInsetForeground(this.mStatusBarColor);
                this.mScrimInsetsLayout.setTintStatusBar(this.mTintStatusBar);
                this.mScrimInsetsLayout.setTintNavigationBar(this.mTintNavigationBar);
                this.mScrimInsetsLayout.setSystemUIVisible(!this.mFullscreen && !this.mSystemUIHidden);
                if (!alreadyInflated) {
                    this.mRootView.removeView(originalContentView);
                } else {
                    this.mRootView.removeAllViews();
                }
                this.mScrimInsetsLayout.getView().addView(originalContentView, new FrameLayout.LayoutParams(-1, -1));
                this.mContentRoot = this.mScrimInsetsLayout.getView();
                ViewGroup viewGroup2 = this.mContainer;
                if (viewGroup2 != null) {
                    this.mContentRoot = viewGroup2;
                    viewGroup2.addView(this.mScrimInsetsLayout.getView(), new ViewGroup.LayoutParams(-1, -1));
                }
                this.mContentRoot.setId(R.id.materialize_root);
                if (this.mContainerLayoutParams == null) {
                    this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
                }
                this.mRootView.addView(this.mContentRoot, this.mContainerLayoutParams);
            } else if (this.mContainer != null) {
                View originalContentView2 = this.mRootView.getChildAt(0);
                this.mRootView.removeView(originalContentView2);
                this.mContainer.addView(originalContentView2, new FrameLayout.LayoutParams(-1, -1));
                if (this.mContainerLayoutParams == null) {
                    this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
                }
                this.mRootView.addView(this.mContainer, this.mContainerLayoutParams);
            } else {
                throw new RuntimeException("please pass a container");
            }
            if (this.mSystemUIHidden && Build.VERSION.SDK_INT >= 16) {
                this.mActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
            }
            if (this.mTranslucentStatusBarProgrammatically && Build.VERSION.SDK_INT >= 21) {
                UIUtils.setTranslucentStatusFlag(this.mActivity, false);
            }
            if (this.mTranslucentNavigationBarProgrammatically && Build.VERSION.SDK_INT >= 21) {
                UIUtils.setTranslucentNavigationFlag(this.mActivity, true);
            }
            if ((this.mTransparentStatusBar || this.mTransparentNavigationBar) && Build.VERSION.SDK_INT >= 21) {
                this.mActivity.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.mTransparentStatusBar && Build.VERSION.SDK_INT >= 21) {
                UIUtils.setTranslucentStatusFlag(this.mActivity, false);
                this.mActivity.getWindow().setStatusBarColor(0);
            }
            if (this.mTransparentNavigationBar && Build.VERSION.SDK_INT >= 21) {
                UIUtils.setTranslucentNavigationFlag(this.mActivity, true);
                this.mActivity.getWindow().setNavigationBarColor(0);
            }
            int paddingTop = 0;
            if (this.mStatusBarPadding && Build.VERSION.SDK_INT >= 21) {
                paddingTop = UIUtils.getStatusBarHeight(this.mActivity);
            }
            int paddingBottom = 0;
            if (this.mNavigationBarPadding && Build.VERSION.SDK_INT >= 21) {
                paddingBottom = UIUtils.getNavigationBarHeight(this.mActivity);
            }
            if (this.mStatusBarPadding || (this.mNavigationBarPadding && Build.VERSION.SDK_INT >= 21)) {
                this.mScrimInsetsLayout.getView().setPadding(0, paddingTop, 0, paddingBottom);
            }
            this.mActivity = null;
            return new Materialize(this);
        }
        throw new RuntimeException("please pass an activity");
    }
}

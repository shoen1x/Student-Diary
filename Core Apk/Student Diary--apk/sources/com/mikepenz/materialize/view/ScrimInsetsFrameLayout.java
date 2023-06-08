package com.mikepenz.materialize.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.mikepenz.materialize.R;

public class ScrimInsetsFrameLayout extends FrameLayout implements IScrimInsetsLayout {
    /* access modifiers changed from: private */
    public Drawable mInsetForeground;
    /* access modifiers changed from: private */
    public Rect mInsets;
    /* access modifiers changed from: private */
    public OnInsetsCallback mOnInsetsCallback;
    private boolean mSystemUIVisible = true;
    private Rect mTempRect = new Rect();
    private boolean mTintNavigationBar = true;
    private boolean mTintStatusBar = true;

    public ScrimInsetsFrameLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScrimInsetsView, defStyle, R.style.Widget_Materialize_ScrimInsetsRelativeLayout);
        this.mInsetForeground = a.getDrawable(R.styleable.ScrimInsetsView_siv_insetForeground);
        a.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                if (ScrimInsetsFrameLayout.this.mInsets == null) {
                    Rect unused = ScrimInsetsFrameLayout.this.mInsets = new Rect();
                }
                ScrimInsetsFrameLayout.this.mInsets.set(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                scrimInsetsFrameLayout.setWillNotDraw(scrimInsetsFrameLayout.mInsetForeground == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                if (ScrimInsetsFrameLayout.this.mOnInsetsCallback != null) {
                    ScrimInsetsFrameLayout.this.mOnInsetsCallback.onInsetsChanged(insets);
                }
                return insets.consumeSystemWindowInsets();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mInsets != null && this.mInsetForeground != null) {
            int sc = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (!this.mSystemUIVisible) {
                this.mInsets.top = 0;
                this.mInsets.right = 0;
                this.mInsets.bottom = 0;
                this.mInsets.left = 0;
            }
            if (this.mTintStatusBar) {
                this.mTempRect.set(0, 0, width, this.mInsets.top);
                this.mInsetForeground.setBounds(this.mTempRect);
                this.mInsetForeground.draw(canvas);
            }
            if (this.mTintNavigationBar) {
                this.mTempRect.set(0, height - this.mInsets.bottom, width, height);
                this.mInsetForeground.setBounds(this.mTempRect);
                this.mInsetForeground.draw(canvas);
            }
            this.mTempRect.set(0, this.mInsets.top, this.mInsets.left, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            this.mTempRect.set(width - this.mInsets.right, this.mInsets.top, width, height - this.mInsets.bottom);
            this.mInsetForeground.setBounds(this.mTempRect);
            this.mInsetForeground.draw(canvas);
            canvas.restoreToCount(sc);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.mInsetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.mInsetForeground;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public ViewGroup getView() {
        return this;
    }

    public Drawable getInsetForeground() {
        return this.mInsetForeground;
    }

    public void setInsetForeground(Drawable mInsetForeground2) {
        this.mInsetForeground = mInsetForeground2;
    }

    public void setInsetForeground(int mInsetForegroundColor) {
        this.mInsetForeground = new ColorDrawable(mInsetForegroundColor);
    }

    public boolean isTintStatusBar() {
        return this.mTintStatusBar;
    }

    public void setTintStatusBar(boolean mTintStatusBar2) {
        this.mTintStatusBar = mTintStatusBar2;
    }

    public boolean isTintNavigationBar() {
        return this.mTintNavigationBar;
    }

    public void setTintNavigationBar(boolean mTintNavigationBar2) {
        this.mTintNavigationBar = mTintNavigationBar2;
    }

    public boolean isSystemUIVisible() {
        return this.mSystemUIVisible;
    }

    public void setSystemUIVisible(boolean systemUIVisible) {
        this.mSystemUIVisible = systemUIVisible;
    }

    public void setOnInsetsCallback(OnInsetsCallback onInsetsCallback) {
        this.mOnInsetsCallback = onInsetsCallback;
    }

    public OnInsetsCallback getOnInsetsCallback() {
        return this.mOnInsetsCallback;
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class MotionHelper extends ConstraintHelper implements Animatable {
    private float mProgress;
    private boolean mUseOnHide = false;
    private boolean mUseOnShow = false;
    protected View[] views;

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MotionHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attrs) {
        super.init(attrs);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MotionHelper);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.MotionHelper_onShow) {
                    this.mUseOnShow = a.getBoolean(attr, this.mUseOnShow);
                } else if (attr == R.styleable.MotionHelper_onHide) {
                    this.mUseOnHide = a.getBoolean(attr, this.mUseOnHide);
                }
            }
        }
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            for (int i = 0; i < this.mCount; i++) {
                setProgress(this.views[i], progress);
            }
            return;
        }
        ViewGroup group = (ViewGroup) getParent();
        int count = group.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view = group.getChildAt(i2);
            if (!(view instanceof MotionHelper)) {
                setProgress(view, progress);
            }
        }
    }

    public void setProgress(View view, float progress) {
    }
}

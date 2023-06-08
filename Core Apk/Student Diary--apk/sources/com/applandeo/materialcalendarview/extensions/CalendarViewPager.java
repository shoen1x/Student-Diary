package com.applandeo.materialcalendarview.extensions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CalendarViewPager extends ViewPager {
    private boolean mSwipeEnabled = true;

    public CalendarViewPager(Context context) {
        super(context);
    }

    public CalendarViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            int h = child.getMeasuredHeight();
            if (h > height) {
                height = h;
            }
        }
        if (height != 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.mSwipeEnabled = swipeEnabled;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return this.mSwipeEnabled && super.onTouchEvent(event);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.mSwipeEnabled && super.onInterceptTouchEvent(event);
    }
}

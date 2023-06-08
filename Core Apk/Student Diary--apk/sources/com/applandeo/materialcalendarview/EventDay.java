package com.applandeo.materialcalendarview;

import android.graphics.drawable.Drawable;
import com.applandeo.materialcalendarview.utils.DateUtils;
import java.util.Calendar;

public class EventDay {
    private Calendar mDay;
    private Object mDrawable;
    private boolean mIsDisabled;
    private int mLabelColor;

    public EventDay(Calendar day) {
        this.mDay = day;
    }

    public EventDay(Calendar day, int drawable) {
        DateUtils.setMidnight(day);
        this.mDay = day;
        this.mDrawable = Integer.valueOf(drawable);
    }

    public EventDay(Calendar day, Drawable drawable) {
        DateUtils.setMidnight(day);
        this.mDay = day;
        this.mDrawable = drawable;
    }

    public EventDay(Calendar day, int drawable, int labelColor) {
        DateUtils.setMidnight(day);
        this.mDay = day;
        this.mDrawable = Integer.valueOf(drawable);
        this.mLabelColor = labelColor;
    }

    public EventDay(Calendar day, Drawable drawable, int labelColor) {
        DateUtils.setMidnight(day);
        this.mDay = day;
        this.mDrawable = drawable;
        this.mLabelColor = labelColor;
    }

    public Object getImageDrawable() {
        return this.mDrawable;
    }

    public int getLabelColor() {
        return this.mLabelColor;
    }

    public Calendar getCalendar() {
        return this.mDay;
    }

    public boolean isEnabled() {
        return !this.mIsDisabled;
    }

    public void setEnabled(boolean enabled) {
        this.mIsDisabled = enabled;
    }
}

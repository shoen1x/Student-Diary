package com.applandeo.materialcalendarview.utils;

import android.view.View;
import java.util.Calendar;

public class SelectedDay {
    private Calendar mCalendar;
    private View mView;

    public SelectedDay(Calendar calendar) {
        this.mCalendar = calendar;
    }

    public SelectedDay(View view, Calendar calendar) {
        this.mView = view;
        this.mCalendar = calendar;
    }

    public View getView() {
        return this.mView;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public Calendar getCalendar() {
        return this.mCalendar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SelectedDay) {
            return getCalendar().equals(((SelectedDay) obj).getCalendar());
        }
        if (obj instanceof Calendar) {
            return getCalendar().equals(obj);
        }
        return super.equals(obj);
    }
}

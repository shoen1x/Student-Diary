package com.applandeo.materialcalendarview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.applandeo.materialcalendarview.R;
import com.applandeo.materialcalendarview.extensions.CalendarGridView;
import com.applandeo.materialcalendarview.listeners.DayRowClickListener;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.applandeo.materialcalendarview.utils.SelectedDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarPageAdapter extends PagerAdapter {
    private CalendarGridView mCalendarGridView;
    private CalendarProperties mCalendarProperties;
    private Context mContext;
    private int mPageMonth;

    public CalendarPageAdapter(Context context, CalendarProperties calendarProperties) {
        this.mContext = context;
        this.mCalendarProperties = calendarProperties;
        informDatePicker();
    }

    public int getCount() {
        return CalendarProperties.CALENDAR_SIZE;
    }

    public int getItemPosition(Object object) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        this.mCalendarGridView = (CalendarGridView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.calendar_view_grid, (ViewGroup) null);
        loadMonth(position);
        this.mCalendarGridView.setOnItemClickListener(new DayRowClickListener(this, this.mCalendarProperties, this.mPageMonth));
        container.addView(this.mCalendarGridView);
        return this.mCalendarGridView;
    }

    public void addSelectedDay(SelectedDay selectedDay) {
        if (!this.mCalendarProperties.getSelectedDays().contains(selectedDay)) {
            this.mCalendarProperties.getSelectedDays().add(selectedDay);
            informDatePicker();
            return;
        }
        this.mCalendarProperties.getSelectedDays().remove(selectedDay);
        informDatePicker();
    }

    public List<SelectedDay> getSelectedDays() {
        return this.mCalendarProperties.getSelectedDays();
    }

    public SelectedDay getSelectedDay() {
        return this.mCalendarProperties.getSelectedDays().get(0);
    }

    public void setSelectedDay(SelectedDay selectedDay) {
        this.mCalendarProperties.setSelectedDay(selectedDay);
        informDatePicker();
    }

    private void informDatePicker() {
        if (this.mCalendarProperties.getOnSelectionAbilityListener() != null) {
            this.mCalendarProperties.getOnSelectionAbilityListener().onChange(this.mCalendarProperties.getSelectedDays().size() > 0);
        }
    }

    private void loadMonth(int position) {
        ArrayList<Date> days = new ArrayList<>();
        Calendar calendar = (Calendar) this.mCalendarProperties.getFirstPageCalendarDate().clone();
        calendar.add(2, position);
        calendar.set(5, 1);
        int i = 7;
        int dayOfWeek = calendar.get(7);
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        if (dayOfWeek >= firstDayOfWeek) {
            i = 0;
        }
        calendar.add(5, -((i + dayOfWeek) - firstDayOfWeek));
        while (days.size() < 42) {
            days.add(calendar.getTime());
            calendar.add(5, 1);
        }
        this.mPageMonth = calendar.get(2) - 1;
        this.mCalendarGridView.setAdapter(new CalendarDayAdapter(this, this.mContext, this.mCalendarProperties, days, this.mPageMonth));
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

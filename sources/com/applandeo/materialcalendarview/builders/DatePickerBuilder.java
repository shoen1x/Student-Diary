package com.applandeo.materialcalendarview.builders;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import java.util.Calendar;
import java.util.List;

public class DatePickerBuilder {
    private CalendarProperties mCalendarProperties;
    private Context mContext;

    public DatePickerBuilder(Context context, OnSelectDateListener onSelectDateListener) {
        this.mContext = context;
        CalendarProperties calendarProperties = new CalendarProperties(context);
        this.mCalendarProperties = calendarProperties;
        calendarProperties.setCalendarType(1);
        this.mCalendarProperties.setOnSelectDateListener(onSelectDateListener);
    }

    public DatePicker build() {
        return new DatePicker(this.mContext, this.mCalendarProperties);
    }

    @Deprecated
    public DatePickerBuilder pickerType(int calendarType) {
        return setPickerType(calendarType);
    }

    public DatePickerBuilder setPickerType(int calendarType) {
        this.mCalendarProperties.setCalendarType(calendarType);
        return this;
    }

    @Deprecated
    public DatePickerBuilder date(Calendar calendar) {
        return setDate(calendar);
    }

    public DatePickerBuilder setDate(Calendar calendar) {
        this.mCalendarProperties.setCalendar(calendar);
        return this;
    }

    @Deprecated
    public DatePickerBuilder headerColor(int color) {
        return setHeaderColor(color);
    }

    public DatePickerBuilder setHeaderColor(int color) {
        this.mCalendarProperties.setHeaderColor(color);
        return this;
    }

    @Deprecated
    public DatePickerBuilder headerVisibility(int visibility) {
        return setHeaderVisibility(visibility);
    }

    public DatePickerBuilder setHeaderVisibility(int visibility) {
        this.mCalendarProperties.setHeaderVisibility(visibility);
        return this;
    }

    public DatePickerBuilder abbreviationsBarVisibility(int visibility) {
        this.mCalendarProperties.setAbbreviationsBarVisibility(visibility);
        return this;
    }

    @Deprecated
    public DatePickerBuilder headerLabelColor(int color) {
        return setHeaderLabelColor(color);
    }

    public DatePickerBuilder setHeaderLabelColor(int color) {
        this.mCalendarProperties.setHeaderLabelColor(color);
        return this;
    }

    @Deprecated
    public DatePickerBuilder previousButtonSrc(int drawable) {
        return setPreviousButtonSrc(drawable);
    }

    public DatePickerBuilder setPreviousButtonSrc(int drawable) {
        this.mCalendarProperties.setPreviousButtonSrc(ContextCompat.getDrawable(this.mContext, drawable));
        return this;
    }

    @Deprecated
    public DatePickerBuilder forwardButtonSrc(int drawable) {
        return setForwardButtonSrc(drawable);
    }

    public DatePickerBuilder setForwardButtonSrc(int drawable) {
        this.mCalendarProperties.setForwardButtonSrc(ContextCompat.getDrawable(this.mContext, drawable));
        return this;
    }

    @Deprecated
    public DatePickerBuilder selectionColor(int color) {
        return setSelectionColor(color);
    }

    public DatePickerBuilder setSelectionColor(int color) {
        this.mCalendarProperties.setSelectionColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder todayLabelColor(int color) {
        return setTodayLabelColor(color);
    }

    public DatePickerBuilder setTodayLabelColor(int color) {
        this.mCalendarProperties.setTodayLabelColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    public DatePickerBuilder highlightedDaysLabelsColor(int color) {
        this.mCalendarProperties.setHighlightedDaysLabelsColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder dialogButtonsColor(int color) {
        return setDialogButtonsColor(color);
    }

    public DatePickerBuilder setDialogButtonsColor(int color) {
        this.mCalendarProperties.setDialogButtonsColor(color);
        return this;
    }

    @Deprecated
    public DatePickerBuilder minimumDate(Calendar calendar) {
        return setMinimumDate(calendar);
    }

    public DatePickerBuilder setMinimumDate(Calendar calendar) {
        this.mCalendarProperties.setMinimumDate(calendar);
        return this;
    }

    @Deprecated
    public DatePickerBuilder maximumDate(Calendar calendar) {
        return setMaximumDate(calendar);
    }

    public DatePickerBuilder setMaximumDate(Calendar calendar) {
        this.mCalendarProperties.setMaximumDate(calendar);
        return this;
    }

    @Deprecated
    public DatePickerBuilder disabledDays(List<Calendar> disabledDays) {
        return setDisabledDays(disabledDays);
    }

    public DatePickerBuilder setDisabledDays(List<Calendar> disabledDays) {
        this.mCalendarProperties.setDisabledDays(disabledDays);
        return this;
    }

    public DatePickerBuilder highlightedDays(List<Calendar> highlightedDays) {
        this.mCalendarProperties.setHighlightedDays(highlightedDays);
        return this;
    }

    @Deprecated
    public DatePickerBuilder previousPageChangeListener(OnCalendarPageChangeListener listener) {
        return setPreviousPageChangeListener(listener);
    }

    public DatePickerBuilder setPreviousPageChangeListener(OnCalendarPageChangeListener listener) {
        this.mCalendarProperties.setOnPreviousPageChangeListener(listener);
        return this;
    }

    @Deprecated
    public DatePickerBuilder forwardPageChangeListener(OnCalendarPageChangeListener listener) {
        return setForwardPageChangeListener(listener);
    }

    public DatePickerBuilder setForwardPageChangeListener(OnCalendarPageChangeListener listener) {
        this.mCalendarProperties.setOnForwardPageChangeListener(listener);
        return this;
    }

    @Deprecated
    public DatePickerBuilder disabledDaysLabelsColor(int color) {
        return setDisabledDaysLabelsColor(color);
    }

    public DatePickerBuilder setDisabledDaysLabelsColor(int color) {
        this.mCalendarProperties.setDisabledDaysLabelsColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder abbreviationsBarColor(int color) {
        return setAbbreviationsBarColor(color);
    }

    public DatePickerBuilder setAbbreviationsBarColor(int color) {
        this.mCalendarProperties.setAbbreviationsBarColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder pagesColor(int color) {
        return setPagesColor(color);
    }

    public DatePickerBuilder setPagesColor(int color) {
        this.mCalendarProperties.setPagesColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder abbreviationsLabelsColor(int color) {
        return setAbbreviationsLabelsColor(color);
    }

    public DatePickerBuilder setAbbreviationsLabelsColor(int color) {
        this.mCalendarProperties.setAbbreviationsLabelsColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder daysLabelsColor(int color) {
        return setDaysLabelsColor(color);
    }

    public DatePickerBuilder setDaysLabelsColor(int color) {
        this.mCalendarProperties.setDaysLabelsColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder selectionLabelColor(int color) {
        return setSelectionLabelColor(color);
    }

    public DatePickerBuilder setSelectionLabelColor(int color) {
        this.mCalendarProperties.setSelectionLabelColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder anotherMonthsDaysLabelsColor(int color) {
        return setAnotherMonthsDaysLabelsColor(color);
    }

    public DatePickerBuilder setAnotherMonthsDaysLabelsColor(int color) {
        this.mCalendarProperties.setAnotherMonthsDaysLabelsColor(ContextCompat.getColor(this.mContext, color));
        return this;
    }

    @Deprecated
    public DatePickerBuilder selectedDays(List<Calendar> selectedDays) {
        return setSelectedDays(selectedDays);
    }

    public DatePickerBuilder setSelectedDays(List<Calendar> selectedDays) {
        this.mCalendarProperties.setSelectedDays(selectedDays);
        return this;
    }

    public DatePickerBuilder setMaximumDaysRange(int maximumDaysRange) {
        this.mCalendarProperties.setMaximumDaysRange(maximumDaysRange);
        return this;
    }

    public DatePickerBuilder setTodayColor(int todayColor) {
        this.mCalendarProperties.setTodayColor(todayColor);
        return this;
    }

    public DatePickerBuilder setNavigationVisibility(int visibility) {
        this.mCalendarProperties.setNavigationVisibility(visibility);
        return this;
    }

    public DatePickerBuilder setEvents(List<EventDay> eventDays) {
        if (eventDays != null) {
            this.mCalendarProperties.setEventsEnabled(true);
            this.mCalendarProperties.setEventDays(eventDays);
        }
        return this;
    }
}

package com.applandeo.materialcalendarview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Predicate;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.R;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.applandeo.materialcalendarview.utils.DayColorsUtils;
import com.applandeo.materialcalendarview.utils.EventDayUtils;
import com.applandeo.materialcalendarview.utils.ImageUtils;
import com.applandeo.materialcalendarview.utils.SelectedDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class CalendarDayAdapter extends ArrayAdapter<Date> {
    private CalendarPageAdapter mCalendarPageAdapter;
    private CalendarProperties mCalendarProperties;
    private LayoutInflater mLayoutInflater;
    private int mPageMonth;
    private Calendar mToday = DateUtils.getCalendar();

    CalendarDayAdapter(CalendarPageAdapter calendarPageAdapter, Context context, CalendarProperties calendarProperties, ArrayList<Date> dates, int pageMonth) {
        super(context, calendarProperties.getItemLayoutResource(), dates);
        this.mCalendarPageAdapter = calendarPageAdapter;
        this.mCalendarProperties = calendarProperties;
        this.mPageMonth = pageMonth < 0 ? 11 : pageMonth;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = this.mLayoutInflater.inflate(this.mCalendarProperties.getItemLayoutResource(), parent, false);
        }
        TextView dayLabel = (TextView) view.findViewById(R.id.dayLabel);
        ImageView dayIcon = (ImageView) view.findViewById(R.id.dayIcon);
        Calendar day = new GregorianCalendar();
        day.setTime((Date) getItem(position));
        if (dayIcon != null) {
            loadIcon(dayIcon, day);
        }
        setLabelColors(dayLabel, day);
        dayLabel.setText(String.valueOf(day.get(5)));
        return view;
    }

    private void setLabelColors(TextView dayLabel, Calendar day) {
        if (!isCurrentMonthDay(day)) {
            DayColorsUtils.setDayColors(dayLabel, this.mCalendarProperties.getAnotherMonthsDaysLabelsColor(), 0, R.drawable.background_transparent);
        } else if (isSelectedDay(day)) {
            Stream.of(this.mCalendarPageAdapter.getSelectedDays()).filter(new Predicate(day) {
                private final /* synthetic */ Calendar f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return ((SelectedDay) obj).getCalendar().equals(this.f$0);
                }
            }).findFirst().ifPresent(new Consumer(dayLabel) {
                private final /* synthetic */ TextView f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    ((SelectedDay) obj).setView(this.f$0);
                }
            });
            DayColorsUtils.setSelectedDayColors(dayLabel, this.mCalendarProperties);
        } else if (!isActiveDay(day)) {
            DayColorsUtils.setDayColors(dayLabel, this.mCalendarProperties.getDisabledDaysLabelsColor(), 0, R.drawable.background_transparent);
        } else if (isEventDayWithLabelColor(day)) {
            DayColorsUtils.setCurrentMonthDayColors(day, this.mToday, dayLabel, this.mCalendarProperties);
        } else {
            DayColorsUtils.setCurrentMonthDayColors(day, this.mToday, dayLabel, this.mCalendarProperties);
        }
    }

    private boolean isSelectedDay(Calendar day) {
        return this.mCalendarProperties.getCalendarType() != 0 && day.get(2) == this.mPageMonth && this.mCalendarPageAdapter.getSelectedDays().contains(new SelectedDay(day));
    }

    private boolean isEventDayWithLabelColor(Calendar day) {
        return EventDayUtils.isEventDayWithLabelColor(day, this.mCalendarProperties);
    }

    private boolean isCurrentMonthDay(Calendar day) {
        return day.get(2) == this.mPageMonth && (this.mCalendarProperties.getMinimumDate() == null || !day.before(this.mCalendarProperties.getMinimumDate())) && (this.mCalendarProperties.getMaximumDate() == null || !day.after(this.mCalendarProperties.getMaximumDate()));
    }

    private boolean isActiveDay(Calendar day) {
        return !this.mCalendarProperties.getDisabledDays().contains(day);
    }

    private void loadIcon(ImageView dayIcon, Calendar day) {
        if (this.mCalendarProperties.getEventDays() == null || !this.mCalendarProperties.getEventsEnabled()) {
            dayIcon.setVisibility(8);
        } else {
            Stream.of(this.mCalendarProperties.getEventDays()).filter(new Predicate(day) {
                private final /* synthetic */ Calendar f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return ((EventDay) obj).getCalendar().equals(this.f$0);
                }
            }).findFirst().executeIfPresent(new Consumer(dayIcon, day) {
                private final /* synthetic */ ImageView f$1;
                private final /* synthetic */ Calendar f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void accept(Object obj) {
                    CalendarDayAdapter.this.lambda$loadIcon$3$CalendarDayAdapter(this.f$1, this.f$2, (EventDay) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$loadIcon$3$CalendarDayAdapter(ImageView dayIcon, Calendar day, EventDay eventDay) {
        ImageUtils.loadImage(dayIcon, eventDay.getImageDrawable());
        if (!isCurrentMonthDay(day) || !isActiveDay(day)) {
            dayIcon.setAlpha(0.12f);
        }
    }
}

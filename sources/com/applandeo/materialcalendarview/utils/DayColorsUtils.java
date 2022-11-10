package com.applandeo.materialcalendarview.utils;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.widget.TextView;
import com.annimon.stream.function.Consumer;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.R;
import java.util.Calendar;

public class DayColorsUtils {
    public static void setDayColors(TextView textView, int textColor, int typeface, int background) {
        if (textView != null) {
            textView.setTypeface((Typeface) null, typeface);
            textView.setTextColor(textColor);
            textView.setBackgroundResource(background);
        }
    }

    public static void setSelectedDayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getSelectionLabelColor(), 0, R.drawable.background_color_circle_selector);
        setDayBackgroundColor(dayLabel, calendarProperties.getSelectionColor());
    }

    public static void setCurrentMonthDayColors(Calendar day, Calendar today, TextView dayLabel, CalendarProperties calendarProperties) {
        if (today.equals(day)) {
            setTodayColors(dayLabel, calendarProperties);
        } else if (EventDayUtils.isEventDayWithLabelColor(day, calendarProperties)) {
            setEventDayColors(day, dayLabel, calendarProperties);
        } else if (calendarProperties.getHighlightedDays().contains(day)) {
            setHighlightedDayColors(dayLabel, calendarProperties);
        } else {
            setNormalDayColors(dayLabel, calendarProperties);
        }
    }

    private static void setTodayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getTodayLabelColor(), 1, R.drawable.background_transparent);
        if (calendarProperties.getTodayColor() != 0) {
            setDayColors(dayLabel, calendarProperties.getSelectionLabelColor(), 0, R.drawable.background_color_circle_selector);
            setDayBackgroundColor(dayLabel, calendarProperties.getTodayColor());
        }
    }

    private static void setEventDayColors(Calendar day, TextView dayLabel, CalendarProperties calendarProperties) {
        EventDayUtils.getEventDayWithLabelColor(day, calendarProperties).executeIfPresent(new Consumer(dayLabel) {
            private final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                DayColorsUtils.setDayColors(this.f$0, ((EventDay) obj).getLabelColor(), 0, R.drawable.background_transparent);
            }
        });
    }

    private static void setHighlightedDayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getHighlightedDaysLabelsColor(), 0, R.drawable.background_transparent);
    }

    private static void setNormalDayColors(TextView dayLabel, CalendarProperties calendarProperties) {
        setDayColors(dayLabel, calendarProperties.getDaysLabelsColor(), 0, R.drawable.background_transparent);
    }

    private static void setDayBackgroundColor(TextView dayLabel, int color) {
        dayLabel.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }
}

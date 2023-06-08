package com.applandeo.materialcalendarview.utils;

import android.content.Context;
import com.annimon.stream.Stream;
import com.applandeo.materialcalendarview.R;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        setMidnight(calendar);
        return calendar;
    }

    public static void setMidnight(Calendar calendar) {
        if (calendar != null) {
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
        }
    }

    public static boolean isMonthBefore(Calendar firstCalendar, Calendar secondCalendar) {
        if (firstCalendar == null) {
            return false;
        }
        Calendar firstDay = (Calendar) firstCalendar.clone();
        setMidnight(firstDay);
        firstDay.set(5, 1);
        Calendar secondDay = (Calendar) secondCalendar.clone();
        setMidnight(secondDay);
        secondDay.set(5, 1);
        return secondDay.before(firstDay);
    }

    public static boolean isMonthAfter(Calendar firstCalendar, Calendar secondCalendar) {
        if (firstCalendar == null) {
            return false;
        }
        Calendar firstDay = (Calendar) firstCalendar.clone();
        setMidnight(firstDay);
        firstDay.set(5, 1);
        Calendar secondDay = (Calendar) secondCalendar.clone();
        setMidnight(secondDay);
        secondDay.set(5, 1);
        return secondDay.after(firstDay);
    }

    public static String getMonthAndYearDate(Context context, Calendar calendar) {
        return String.format("%s  %s", new Object[]{context.getResources().getStringArray(R.array.material_calendar_months_array)[calendar.get(2)], Integer.valueOf(calendar.get(1))});
    }

    public static int getMonthsBetweenDates(Calendar startCalendar, Calendar endCalendar) {
        return (((endCalendar.get(1) - startCalendar.get(1)) * 12) + endCalendar.get(2)) - startCalendar.get(2);
    }

    private static long getDaysBetweenDates(Calendar startCalendar, Calendar endCalendar) {
        return TimeUnit.MILLISECONDS.toDays(endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis());
    }

    public static boolean isFullDatesRange(List<Calendar> days) {
        int listSize = days.size();
        if (days.isEmpty() || listSize == 1) {
            return true;
        }
        List<T> list = Stream.of(days).sortBy($$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg.INSTANCE).toList();
        if (((long) listSize) == getDaysBetweenDates((Calendar) list.get(0), (Calendar) list.get(listSize - 1)) + 1) {
            return true;
        }
        return false;
    }
}

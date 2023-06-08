package com.applandeo.materialcalendarview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CalendarUtils {
    public static Drawable getDrawableText(Context context, String text, Typeface typeface, int color, int size) {
        Resources resources = context.getResources();
        Bitmap bitmap = Bitmap.createBitmap(48, 48, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setTypeface(typeface != null ? typeface : Typeface.create(Typeface.DEFAULT, 1));
        paint.setColor(ContextCompat.getColor(context, color));
        paint.setTextSize((float) ((int) (((float) size) * resources.getDisplayMetrics().density)));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        canvas.drawText(text, (float) ((bitmap.getWidth() - bounds.width()) / 2), (float) ((bitmap.getHeight() + bounds.height()) / 2), paint);
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static ArrayList<Calendar> getDatesRange(Calendar firstDay, Calendar lastDay) {
        if (lastDay.before(firstDay)) {
            return getCalendarsBetweenDates(lastDay.getTime(), firstDay.getTime());
        }
        return getCalendarsBetweenDates(firstDay.getTime(), lastDay.getTime());
    }

    private static ArrayList<Calendar> getCalendarsBetweenDates(Date dateFrom, Date dateTo) {
        ArrayList<Calendar> calendars = new ArrayList<>();
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(dateFrom);
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(dateTo);
        long daysBetweenDates = TimeUnit.MILLISECONDS.toDays(calendarTo.getTimeInMillis() - calendarFrom.getTimeInMillis());
        for (int i = 1; ((long) i) < daysBetweenDates; i++) {
            Calendar calendar = (Calendar) calendarFrom.clone();
            calendars.add(calendar);
            calendar.add(5, i);
        }
        return calendars;
    }

    private CalendarUtils() {
    }
}

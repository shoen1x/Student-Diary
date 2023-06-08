package com.applandeo.materialcalendarview.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.applandeo.materialcalendarview.R;
import java.util.ArrayList;
import java.util.List;

public final class AppearanceUtils {
    public static void setAbbreviationsLabels(View view, int color, int firstDayOfWeek) {
        List<TextView> labels = new ArrayList<>();
        labels.add((TextView) view.findViewById(R.id.mondayLabel));
        labels.add((TextView) view.findViewById(R.id.tuesdayLabel));
        labels.add((TextView) view.findViewById(R.id.wednesdayLabel));
        labels.add((TextView) view.findViewById(R.id.thursdayLabel));
        labels.add((TextView) view.findViewById(R.id.fridayLabel));
        labels.add((TextView) view.findViewById(R.id.saturdayLabel));
        labels.add((TextView) view.findViewById(R.id.sundayLabel));
        String[] abbreviations = view.getContext().getResources().getStringArray(R.array.material_calendar_day_abbreviations_array);
        for (int i = 0; i < 7; i++) {
            TextView label = labels.get(i);
            label.setText(abbreviations[((i + firstDayOfWeek) - 1) % 7]);
            if (color != 0) {
                label.setTextColor(color);
            }
        }
    }

    public static void setHeaderColor(View view, int color) {
        if (color != 0) {
            ((ConstraintLayout) view.findViewById(R.id.calendarHeader)).setBackgroundColor(color);
        }
    }

    public static void setHeaderLabelColor(View view, int color) {
        if (color != 0) {
            ((TextView) view.findViewById(R.id.currentDateLabel)).setTextColor(color);
        }
    }

    public static void setAbbreviationsBarColor(View view, int color) {
        if (color != 0) {
            view.findViewById(R.id.abbreviationsBar).setBackgroundColor(color);
        }
    }

    public static void setPagesColor(View view, int color) {
        if (color != 0) {
            view.findViewById(R.id.calendarViewPager).setBackgroundColor(color);
        }
    }

    private AppearanceUtils() {
    }

    public static void setPreviousButtonImage(View view, Drawable drawable) {
        if (drawable != null) {
            ((ImageButton) view.findViewById(R.id.previousButton)).setImageDrawable(drawable);
        }
    }

    public static void setForwardButtonImage(View view, Drawable drawable) {
        if (drawable != null) {
            ((ImageButton) view.findViewById(R.id.forwardButton)).setImageDrawable(drawable);
        }
    }

    public static void setHeaderVisibility(View view, int visibility) {
        ((ConstraintLayout) view.findViewById(R.id.calendarHeader)).setVisibility(visibility);
    }

    public static void setNavigationVisibility(View view, int visibility) {
        view.findViewById(R.id.previousButton).setVisibility(visibility);
        view.findViewById(R.id.forwardButton).setVisibility(visibility);
    }

    public static void setAbbreviationsBarVisibility(View view, int visibility) {
        ((LinearLayout) view.findViewById(R.id.abbreviationsBar)).setVisibility(visibility);
    }
}

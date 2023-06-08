package com.applandeo.materialcalendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Consumer;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.listeners.OnSelectionAbilityListener;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.applandeo.materialcalendarview.utils.DateUtils;
import java.util.Calendar;

public class DatePicker {
    private CalendarProperties mCalendarProperties;
    private AppCompatButton mCancelButton;
    private final Context mContext;
    private AppCompatButton mOkButton;
    private AppCompatButton mTodayButton;

    public DatePicker(Context context, CalendarProperties calendarProperties) {
        this.mContext = context;
        this.mCalendarProperties = calendarProperties;
    }

    public DatePicker show() {
        View view = LayoutInflater.from(this.mContext).inflate(R.layout.date_picker_dialog, (ViewGroup) null);
        if (this.mCalendarProperties.getPagesColor() != 0) {
            view.setBackgroundColor(this.mCalendarProperties.getPagesColor());
        }
        this.mCancelButton = (AppCompatButton) view.findViewById(R.id.negative_button);
        this.mOkButton = (AppCompatButton) view.findViewById(R.id.positive_button);
        this.mTodayButton = (AppCompatButton) view.findViewById(R.id.today_button);
        setTodayButtonVisibility();
        setDialogButtonsColors();
        boolean z = true;
        if (this.mCalendarProperties.getCalendarType() != 1) {
            z = false;
        }
        setOkButtonState(z);
        this.mCalendarProperties.setOnSelectionAbilityListener(new OnSelectionAbilityListener() {
            public final void onChange(boolean z) {
                DatePicker.this.setOkButtonState(z);
            }
        });
        CalendarView calendarView = new CalendarView(this.mContext, this.mCalendarProperties);
        ((FrameLayout) view.findViewById(R.id.calendarContainer)).addView(calendarView);
        Optional.ofNullable(this.mCalendarProperties.getCalendar()).ifPresent(new Consumer() {
            public final void accept(Object obj) {
                DatePicker.lambda$show$0(CalendarView.this, (Calendar) obj);
            }
        });
        AlertDialog alertdialog = new AlertDialog.Builder(this.mContext).create();
        alertdialog.setView(view);
        this.mCancelButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AlertDialog.this.cancel();
            }
        });
        this.mOkButton.setOnClickListener(new View.OnClickListener(alertdialog, calendarView) {
            private final /* synthetic */ AlertDialog f$1;
            private final /* synthetic */ CalendarView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DatePicker.this.lambda$show$2$DatePicker(this.f$1, this.f$2, view);
            }
        });
        this.mTodayButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CalendarView.this.showCurrentMonthPage();
            }
        });
        alertdialog.show();
        return this;
    }

    static /* synthetic */ void lambda$show$0(CalendarView calendarView, Calendar calendar) {
        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException exception) {
            exception.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$show$2$DatePicker(AlertDialog alertdialog, CalendarView calendarView, View v) {
        alertdialog.cancel();
        this.mCalendarProperties.getOnSelectDateListener().onSelect(calendarView.getSelectedDates());
    }

    private void setDialogButtonsColors() {
        if (this.mCalendarProperties.getDialogButtonsColor() != 0) {
            this.mCancelButton.setTextColor(ContextCompat.getColor(this.mContext, this.mCalendarProperties.getDialogButtonsColor()));
            this.mTodayButton.setTextColor(ContextCompat.getColor(this.mContext, this.mCalendarProperties.getDialogButtonsColor()));
        }
    }

    /* access modifiers changed from: private */
    public void setOkButtonState(boolean enabled) {
        this.mOkButton.setEnabled(enabled);
        if (this.mCalendarProperties.getDialogButtonsColor() != 0) {
            this.mOkButton.setTextColor(ContextCompat.getColor(this.mContext, enabled ? this.mCalendarProperties.getDialogButtonsColor() : R.color.disabledDialogButtonColor));
        }
    }

    private void setTodayButtonVisibility() {
        if (DateUtils.isMonthAfter(this.mCalendarProperties.getMaximumDate(), DateUtils.getCalendar()) || DateUtils.isMonthBefore(this.mCalendarProperties.getMinimumDate(), DateUtils.getCalendar())) {
            this.mTodayButton.setVisibility(8);
        }
    }
}

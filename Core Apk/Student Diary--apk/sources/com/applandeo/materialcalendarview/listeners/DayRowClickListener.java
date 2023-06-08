package com.applandeo.materialcalendarview.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Predicate;
import com.applandeo.materialcalendarview.CalendarUtils;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.R;
import com.applandeo.materialcalendarview.adapters.CalendarPageAdapter;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.applandeo.materialcalendarview.utils.DayColorsUtils;
import com.applandeo.materialcalendarview.utils.SelectedDay;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DayRowClickListener implements AdapterView.OnItemClickListener {
    private CalendarPageAdapter mCalendarPageAdapter;
    private CalendarProperties mCalendarProperties;
    private int mPageMonth;

    public DayRowClickListener(CalendarPageAdapter calendarPageAdapter, CalendarProperties calendarProperties, int pageMonth) {
        this.mCalendarPageAdapter = calendarPageAdapter;
        this.mCalendarProperties = calendarProperties;
        this.mPageMonth = pageMonth < 0 ? 11 : pageMonth;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Calendar day = new GregorianCalendar();
        day.setTime((Date) adapterView.getItemAtPosition(position));
        if (this.mCalendarProperties.getOnDayClickListener() != null) {
            onClick(day);
        }
        int calendarType = this.mCalendarProperties.getCalendarType();
        if (calendarType == 0) {
            this.mCalendarPageAdapter.setSelectedDay(new SelectedDay(view, day));
        } else if (calendarType == 1) {
            selectOneDay(view, day);
        } else if (calendarType == 2) {
            selectManyDays(view, day);
        } else if (calendarType == 3) {
            selectRange(view, day);
        }
    }

    private void selectOneDay(View view, Calendar day) {
        SelectedDay previousSelectedDay = this.mCalendarPageAdapter.getSelectedDay();
        TextView dayLabel = (TextView) view.findViewById(R.id.dayLabel);
        if (isAnotherDaySelected(previousSelectedDay, day)) {
            selectDay(dayLabel, day);
            reverseUnselectedColor(previousSelectedDay);
        }
    }

    private void selectManyDays(View view, Calendar day) {
        TextView dayLabel = (TextView) view.findViewById(R.id.dayLabel);
        if (isCurrentMonthDay(day) && isActiveDay(day)) {
            SelectedDay selectedDay = new SelectedDay(dayLabel, day);
            if (!this.mCalendarPageAdapter.getSelectedDays().contains(selectedDay)) {
                DayColorsUtils.setSelectedDayColors(dayLabel, this.mCalendarProperties);
            } else {
                reverseUnselectedColor(selectedDay);
            }
            this.mCalendarPageAdapter.addSelectedDay(selectedDay);
        }
    }

    private void selectRange(View view, Calendar day) {
        TextView dayLabel = (TextView) view.findViewById(R.id.dayLabel);
        if (isCurrentMonthDay(day) && isActiveDay(day)) {
            List<SelectedDay> selectedDays = this.mCalendarPageAdapter.getSelectedDays();
            if (selectedDays.size() > 1) {
                clearAndSelectOne(dayLabel, day);
            }
            if (selectedDays.size() == 1) {
                selectOneAndRange(dayLabel, day);
            }
            if (selectedDays.isEmpty()) {
                selectDay(dayLabel, day);
            }
        }
    }

    private void clearAndSelectOne(TextView dayLabel, Calendar day) {
        Stream.of(this.mCalendarPageAdapter.getSelectedDays()).forEach(new Consumer() {
            public final void accept(Object obj) {
                DayRowClickListener.this.reverseUnselectedColor((SelectedDay) obj);
            }
        });
        selectDay(dayLabel, day);
    }

    private void selectOneAndRange(TextView dayLabel, Calendar day) {
        SelectedDay previousSelectedDay = this.mCalendarPageAdapter.getSelectedDay();
        Stream.of(CalendarUtils.getDatesRange(previousSelectedDay.getCalendar(), day)).filter(new Predicate() {
            public final boolean test(Object obj) {
                return DayRowClickListener.this.lambda$selectOneAndRange$0$DayRowClickListener((Calendar) obj);
            }
        }).forEach(new Consumer() {
            public final void accept(Object obj) {
                DayRowClickListener.this.lambda$selectOneAndRange$1$DayRowClickListener((Calendar) obj);
            }
        });
        if (!isOutOfMaxRange(previousSelectedDay.getCalendar(), day)) {
            DayColorsUtils.setSelectedDayColors(dayLabel, this.mCalendarProperties);
            this.mCalendarPageAdapter.addSelectedDay(new SelectedDay(dayLabel, day));
            this.mCalendarPageAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ boolean lambda$selectOneAndRange$0$DayRowClickListener(Calendar calendar) {
        return !this.mCalendarProperties.getDisabledDays().contains(calendar);
    }

    public /* synthetic */ void lambda$selectOneAndRange$1$DayRowClickListener(Calendar calendar) {
        this.mCalendarPageAdapter.addSelectedDay(new SelectedDay(calendar));
    }

    private void selectDay(TextView dayLabel, Calendar day) {
        DayColorsUtils.setSelectedDayColors(dayLabel, this.mCalendarProperties);
        this.mCalendarPageAdapter.setSelectedDay(new SelectedDay(dayLabel, day));
    }

    /* access modifiers changed from: private */
    public void reverseUnselectedColor(SelectedDay selectedDay) {
        DayColorsUtils.setCurrentMonthDayColors(selectedDay.getCalendar(), DateUtils.getCalendar(), (TextView) selectedDay.getView(), this.mCalendarProperties);
    }

    private boolean isCurrentMonthDay(Calendar day) {
        return day.get(2) == this.mPageMonth && isBetweenMinAndMax(day);
    }

    private boolean isActiveDay(Calendar day) {
        return !this.mCalendarProperties.getDisabledDays().contains(day);
    }

    private boolean isBetweenMinAndMax(Calendar day) {
        return (this.mCalendarProperties.getMinimumDate() == null || !day.before(this.mCalendarProperties.getMinimumDate())) && (this.mCalendarProperties.getMaximumDate() == null || !day.after(this.mCalendarProperties.getMaximumDate()));
    }

    private boolean isOutOfMaxRange(Calendar firstDay, Calendar lastDay) {
        int numberOfSelectedDays = CalendarUtils.getDatesRange(firstDay, lastDay).size() + 1;
        int daysMaxRange = this.mCalendarProperties.getMaximumDaysRange();
        if (daysMaxRange == 0 || numberOfSelectedDays < daysMaxRange) {
            return false;
        }
        return true;
    }

    private boolean isAnotherDaySelected(SelectedDay selectedDay, Calendar day) {
        return selectedDay != null && !day.equals(selectedDay.getCalendar()) && isCurrentMonthDay(day) && isActiveDay(day);
    }

    private void onClick(Calendar day) {
        if (this.mCalendarProperties.getEventDays() == null) {
            lambda$onClick$3$DayRowClickListener(day);
        } else {
            Stream.of(this.mCalendarProperties.getEventDays()).filter(new Predicate(day) {
                private final /* synthetic */ Calendar f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return ((EventDay) obj).getCalendar().equals(this.f$0);
                }
            }).findFirst().ifPresentOrElse(new Consumer() {
                public final void accept(Object obj) {
                    DayRowClickListener.this.callOnClickListener((EventDay) obj);
                }
            }, new Runnable(day) {
                private final /* synthetic */ Calendar f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DayRowClickListener.this.lambda$onClick$3$DayRowClickListener(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createEmptyEventDay */
    public void lambda$onClick$3$DayRowClickListener(Calendar day) {
        callOnClickListener(new EventDay(day));
    }

    /* access modifiers changed from: private */
    public void callOnClickListener(EventDay eventDay) {
        eventDay.setEnabled(this.mCalendarProperties.getDisabledDays().contains(eventDay.getCalendar()) || !isBetweenMinAndMax(eventDay.getCalendar()));
        this.mCalendarProperties.getOnDayClickListener().onDayClick(eventDay);
    }
}

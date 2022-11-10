package com.applandeo.materialcalendarview.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.R;
import com.applandeo.materialcalendarview.exceptions.ErrorsMessages;
import com.applandeo.materialcalendarview.exceptions.UnsupportedMethodsException;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.applandeo.materialcalendarview.listeners.OnSelectionAbilityListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarProperties {
    public static final int CALENDAR_SIZE = 2401;
    public static final int FIRST_VISIBLE_PAGE = 1200;
    private int mAbbreviationsBarColor;
    private int mAbbreviationsBarVisibility;
    private int mAbbreviationsLabelsColor;
    private int mAnotherMonthsDaysLabelsColor;
    private Calendar mCalendar;
    private int mCalendarType;
    private Context mContext;
    private int mDaysLabelsColor;
    private int mDialogButtonsColor;
    private List<Calendar> mDisabledDays = new ArrayList();
    private int mDisabledDaysLabelsColor;
    private List<EventDay> mEventDays = new ArrayList();
    private boolean mEventsEnabled;
    private Calendar mFirstPageCalendarDate = DateUtils.getCalendar();
    private Drawable mForwardButtonSrc;
    private int mHeaderColor;
    private int mHeaderLabelColor;
    private int mHeaderVisibility;
    private List<Calendar> mHighlightedDays = new ArrayList();
    private int mHighlightedDaysLabelsColor;
    private int mItemLayoutResource;
    private Calendar mMaximumDate;
    private int mMaximumDaysRange;
    private Calendar mMinimumDate;
    private int mNavigationVisibility;
    private OnDayClickListener mOnDayClickListener;
    private OnCalendarPageChangeListener mOnForwardPageChangeListener;
    private OnCalendarPageChangeListener mOnPreviousPageChangeListener;
    private OnSelectDateListener mOnSelectDateListener;
    private OnSelectionAbilityListener mOnSelectionAbilityListener;
    private int mPagesColor;
    private Drawable mPreviousButtonSrc;
    private List<SelectedDay> mSelectedDays = new ArrayList();
    private int mSelectionColor;
    private int mSelectionLabelColor;
    private boolean mSwipeEnabled;
    private int mTodayColor;
    private int mTodayLabelColor;

    public CalendarProperties(Context context) {
        this.mContext = context;
    }

    public int getCalendarType() {
        return this.mCalendarType;
    }

    public void setCalendarType(int calendarType) {
        this.mCalendarType = calendarType;
    }

    public boolean getEventsEnabled() {
        return this.mEventsEnabled;
    }

    public void setEventsEnabled(boolean eventsEnabled) {
        this.mEventsEnabled = eventsEnabled;
    }

    public boolean getSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.mSwipeEnabled = swipeEnabled;
    }

    public Calendar getCalendar() {
        return this.mCalendar;
    }

    public void setCalendar(Calendar calendar) {
        this.mCalendar = calendar;
    }

    public OnSelectDateListener getOnSelectDateListener() {
        return this.mOnSelectDateListener;
    }

    public void setOnSelectDateListener(OnSelectDateListener onSelectDateListener) {
        this.mOnSelectDateListener = onSelectDateListener;
    }

    public int getHeaderColor() {
        int i = this.mHeaderColor;
        if (i <= 0) {
            return i;
        }
        return ContextCompat.getColor(this.mContext, i);
    }

    public void setHeaderColor(int headerColor) {
        this.mHeaderColor = headerColor;
    }

    public int getHeaderLabelColor() {
        int i = this.mHeaderLabelColor;
        if (i <= 0) {
            return i;
        }
        return ContextCompat.getColor(this.mContext, i);
    }

    public void setHeaderLabelColor(int headerLabelColor) {
        this.mHeaderLabelColor = headerLabelColor;
    }

    public Drawable getPreviousButtonSrc() {
        return this.mPreviousButtonSrc;
    }

    public void setPreviousButtonSrc(Drawable previousButtonSrc) {
        this.mPreviousButtonSrc = previousButtonSrc;
    }

    public Drawable getForwardButtonSrc() {
        return this.mForwardButtonSrc;
    }

    public void setForwardButtonSrc(Drawable forwardButtonSrc) {
        this.mForwardButtonSrc = forwardButtonSrc;
    }

    public int getSelectionColor() {
        int i = this.mSelectionColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.defaultColor);
        }
        return i;
    }

    public void setSelectionColor(int selectionColor) {
        this.mSelectionColor = selectionColor;
    }

    public int getTodayLabelColor() {
        int i = this.mTodayLabelColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.defaultColor);
        }
        return i;
    }

    public void setTodayLabelColor(int todayLabelColor) {
        this.mTodayLabelColor = todayLabelColor;
    }

    public int getDialogButtonsColor() {
        return this.mDialogButtonsColor;
    }

    public void setDialogButtonsColor(int dialogButtonsColor) {
        this.mDialogButtonsColor = dialogButtonsColor;
    }

    public Calendar getMinimumDate() {
        return this.mMinimumDate;
    }

    public void setMinimumDate(Calendar minimumDate) {
        this.mMinimumDate = minimumDate;
    }

    public Calendar getMaximumDate() {
        return this.mMaximumDate;
    }

    public void setMaximumDate(Calendar maximumDate) {
        this.mMaximumDate = maximumDate;
    }

    public OnSelectionAbilityListener getOnSelectionAbilityListener() {
        return this.mOnSelectionAbilityListener;
    }

    public void setOnSelectionAbilityListener(OnSelectionAbilityListener onSelectionAbilityListener) {
        this.mOnSelectionAbilityListener = onSelectionAbilityListener;
    }

    public int getItemLayoutResource() {
        return this.mItemLayoutResource;
    }

    public void setItemLayoutResource(int itemLayoutResource) {
        this.mItemLayoutResource = itemLayoutResource;
    }

    public OnCalendarPageChangeListener getOnPreviousPageChangeListener() {
        return this.mOnPreviousPageChangeListener;
    }

    public void setOnPreviousPageChangeListener(OnCalendarPageChangeListener onPreviousButtonClickListener) {
        this.mOnPreviousPageChangeListener = onPreviousButtonClickListener;
    }

    public OnCalendarPageChangeListener getOnForwardPageChangeListener() {
        return this.mOnForwardPageChangeListener;
    }

    public void setOnForwardPageChangeListener(OnCalendarPageChangeListener onForwardButtonClickListener) {
        this.mOnForwardPageChangeListener = onForwardButtonClickListener;
    }

    public Calendar getFirstPageCalendarDate() {
        return this.mFirstPageCalendarDate;
    }

    public OnDayClickListener getOnDayClickListener() {
        return this.mOnDayClickListener;
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mOnDayClickListener = onDayClickListener;
    }

    public List<EventDay> getEventDays() {
        return this.mEventDays;
    }

    public void setEventDays(List<EventDay> eventDays) {
        this.mEventDays = eventDays;
    }

    public List<Calendar> getDisabledDays() {
        return this.mDisabledDays;
    }

    public void setDisabledDays(List<Calendar> disabledDays) {
        this.mSelectedDays.removeAll(disabledDays);
        this.mDisabledDays = Stream.of(disabledDays).map($$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVug.INSTANCE).toList();
    }

    public List<Calendar> getHighlightedDays() {
        return this.mHighlightedDays;
    }

    public void setHighlightedDays(List<Calendar> highlightedDays) {
        this.mHighlightedDays = Stream.of(highlightedDays).map($$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk.INSTANCE).toList();
    }

    public List<SelectedDay> getSelectedDays() {
        return this.mSelectedDays;
    }

    public void setSelectedDay(Calendar calendar) {
        setSelectedDay(new SelectedDay(calendar));
    }

    public void setSelectedDay(SelectedDay selectedDay) {
        this.mSelectedDays.clear();
        this.mSelectedDays.add(selectedDay);
    }

    public void setSelectedDays(List<Calendar> selectedDays) {
        int i = this.mCalendarType;
        if (i == 1) {
            throw new UnsupportedMethodsException(ErrorsMessages.ONE_DAY_PICKER_MULTIPLE_SELECTION);
        } else if (i != 3 || DateUtils.isFullDatesRange(selectedDays)) {
            this.mSelectedDays = Stream.of(selectedDays).map($$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo.INSTANCE).filterNot(new Predicate() {
                public final boolean test(Object obj) {
                    return CalendarProperties.this.lambda$setSelectedDays$3$CalendarProperties((SelectedDay) obj);
                }
            }).toList();
        } else {
            throw new UnsupportedMethodsException(ErrorsMessages.RANGE_PICKER_NOT_RANGE);
        }
    }

    public /* synthetic */ boolean lambda$setSelectedDays$3$CalendarProperties(SelectedDay value) {
        return this.mDisabledDays.contains(value.getCalendar());
    }

    public int getDisabledDaysLabelsColor() {
        int i = this.mDisabledDaysLabelsColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.nextMonthDayColor);
        }
        return i;
    }

    public void setDisabledDaysLabelsColor(int disabledDaysLabelsColor) {
        this.mDisabledDaysLabelsColor = disabledDaysLabelsColor;
    }

    public int getHighlightedDaysLabelsColor() {
        int i = this.mHighlightedDaysLabelsColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.nextMonthDayColor);
        }
        return i;
    }

    public void setHighlightedDaysLabelsColor(int highlightedDaysLabelsColor) {
        this.mHighlightedDaysLabelsColor = highlightedDaysLabelsColor;
    }

    public int getPagesColor() {
        return this.mPagesColor;
    }

    public void setPagesColor(int pagesColor) {
        this.mPagesColor = pagesColor;
    }

    public int getAbbreviationsBarColor() {
        return this.mAbbreviationsBarColor;
    }

    public void setAbbreviationsBarColor(int abbreviationsBarColor) {
        this.mAbbreviationsBarColor = abbreviationsBarColor;
    }

    public int getAbbreviationsLabelsColor() {
        return this.mAbbreviationsLabelsColor;
    }

    public void setAbbreviationsLabelsColor(int abbreviationsLabelsColor) {
        this.mAbbreviationsLabelsColor = abbreviationsLabelsColor;
    }

    public int getDaysLabelsColor() {
        int i = this.mDaysLabelsColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.currentMonthDayColor);
        }
        return i;
    }

    public void setDaysLabelsColor(int daysLabelsColor) {
        this.mDaysLabelsColor = daysLabelsColor;
    }

    public int getSelectionLabelColor() {
        int i = this.mSelectionLabelColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, 17170443);
        }
        return i;
    }

    public void setSelectionLabelColor(int selectionLabelColor) {
        this.mSelectionLabelColor = selectionLabelColor;
    }

    public int getAnotherMonthsDaysLabelsColor() {
        int i = this.mAnotherMonthsDaysLabelsColor;
        if (i == 0) {
            return ContextCompat.getColor(this.mContext, R.color.nextMonthDayColor);
        }
        return i;
    }

    public void setAnotherMonthsDaysLabelsColor(int anotherMonthsDaysLabelsColor) {
        this.mAnotherMonthsDaysLabelsColor = anotherMonthsDaysLabelsColor;
    }

    public int getHeaderVisibility() {
        return this.mHeaderVisibility;
    }

    public void setHeaderVisibility(int headerVisibility) {
        this.mHeaderVisibility = headerVisibility;
    }

    public int getNavigationVisibility() {
        return this.mNavigationVisibility;
    }

    public void setNavigationVisibility(int navigationVisibility) {
        this.mNavigationVisibility = navigationVisibility;
    }

    public int getAbbreviationsBarVisibility() {
        return this.mAbbreviationsBarVisibility;
    }

    public void setAbbreviationsBarVisibility(int abbreviationsBarVisbility) {
        this.mAbbreviationsBarVisibility = abbreviationsBarVisbility;
    }

    public int getMaximumDaysRange() {
        return this.mMaximumDaysRange;
    }

    public void setMaximumDaysRange(int maximumDaysRange) {
        this.mMaximumDaysRange = maximumDaysRange;
    }

    public int getTodayColor() {
        return this.mTodayColor;
    }

    public void setTodayColor(int todayColor) {
        this.mTodayColor = todayColor;
    }
}

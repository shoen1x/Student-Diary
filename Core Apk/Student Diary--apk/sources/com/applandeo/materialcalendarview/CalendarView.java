package com.applandeo.materialcalendarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.annimon.stream.Stream;
import com.applandeo.materialcalendarview.adapters.CalendarPageAdapter;
import com.applandeo.materialcalendarview.exceptions.ErrorsMessages;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.extensions.CalendarViewPager;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.utils.AppearanceUtils;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.applandeo.materialcalendarview.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarView extends LinearLayout {
    public static final int CLASSIC = 0;
    public static final int MANY_DAYS_PICKER = 2;
    public static final int ONE_DAY_PICKER = 1;
    public static final int RANGE_PICKER = 3;
    private CalendarPageAdapter mCalendarPageAdapter;
    /* access modifiers changed from: private */
    public CalendarProperties mCalendarProperties;
    private Context mContext;
    private TextView mCurrentMonthLabel;
    private int mCurrentPage;
    private ImageButton mForwardButton;
    private ImageButton mPreviousButton;
    private CalendarViewPager mViewPager;
    private final View.OnClickListener onNextClickListener = new View.OnClickListener() {
        public final void onClick(View view) {
            CalendarView.this.lambda$new$0$CalendarView(view);
        }
    };
    private final ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            Calendar calendar = (Calendar) CalendarView.this.mCalendarProperties.getFirstPageCalendarDate().clone();
            calendar.add(2, position);
            if (!CalendarView.this.isScrollingLimited(calendar, position)) {
                CalendarView.this.setHeaderName(calendar, position);
            }
        }

        public void onPageScrollStateChanged(int state) {
        }
    };
    private final View.OnClickListener onPreviousClickListener = new View.OnClickListener() {
        public final void onClick(View view) {
            CalendarView.this.lambda$new$1$CalendarView(view);
        }
    };

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
        initCalendar();
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
        initCalendar();
    }

    protected CalendarView(Context context, CalendarProperties calendarProperties) {
        super(context);
        this.mContext = context;
        this.mCalendarProperties = calendarProperties;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.calendar_view, this);
        initUiElements();
        initAttributes();
        initCalendar();
    }

    private void initControl(Context context, AttributeSet attrs) {
        this.mContext = context;
        this.mCalendarProperties = new CalendarProperties(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.calendar_view, this);
        initUiElements();
        setAttributes(attrs);
    }

    private void setAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CalendarView);
        try {
            initCalendarProperties(typedArray);
            initAttributes();
        } finally {
            typedArray.recycle();
        }
    }

    private void initCalendarProperties(TypedArray typedArray) {
        TypedArray typedArray2 = typedArray;
        int headerColor = typedArray2.getColor(R.styleable.CalendarView_headerColor, 0);
        this.mCalendarProperties.setHeaderColor(headerColor);
        this.mCalendarProperties.setHeaderLabelColor(typedArray2.getColor(R.styleable.CalendarView_headerLabelColor, 0));
        this.mCalendarProperties.setAbbreviationsBarColor(typedArray2.getColor(R.styleable.CalendarView_abbreviationsBarColor, 0));
        this.mCalendarProperties.setAbbreviationsLabelsColor(typedArray2.getColor(R.styleable.CalendarView_abbreviationsLabelsColor, 0));
        this.mCalendarProperties.setPagesColor(typedArray2.getColor(R.styleable.CalendarView_pagesColor, 0));
        this.mCalendarProperties.setDaysLabelsColor(typedArray2.getColor(R.styleable.CalendarView_daysLabelsColor, 0));
        this.mCalendarProperties.setAnotherMonthsDaysLabelsColor(typedArray2.getColor(R.styleable.CalendarView_anotherMonthsDaysLabelsColor, 0));
        this.mCalendarProperties.setTodayLabelColor(typedArray2.getColor(R.styleable.CalendarView_todayLabelColor, 0));
        this.mCalendarProperties.setSelectionColor(typedArray2.getColor(R.styleable.CalendarView_selectionColor, 0));
        this.mCalendarProperties.setSelectionLabelColor(typedArray2.getColor(R.styleable.CalendarView_selectionLabelColor, 0));
        this.mCalendarProperties.setDisabledDaysLabelsColor(typedArray2.getColor(R.styleable.CalendarView_disabledDaysLabelsColor, 0));
        this.mCalendarProperties.setHighlightedDaysLabelsColor(typedArray2.getColor(R.styleable.CalendarView_highlightedDaysLabelsColor, 0));
        this.mCalendarProperties.setCalendarType(typedArray2.getInt(R.styleable.CalendarView_type, 0));
        int i = headerColor;
        int maximumDaysRange = typedArray2.getInt(R.styleable.CalendarView_maximumDaysRange, 0);
        this.mCalendarProperties.setMaximumDaysRange(maximumDaysRange);
        int i2 = maximumDaysRange;
        if (typedArray2.getBoolean(R.styleable.CalendarView_datePicker, false)) {
            this.mCalendarProperties.setCalendarType(1);
        }
        boolean eventsEnabled = typedArray2.getBoolean(R.styleable.CalendarView_eventsEnabled, this.mCalendarProperties.getCalendarType() == 0);
        this.mCalendarProperties.setEventsEnabled(eventsEnabled);
        boolean z = eventsEnabled;
        boolean swipeEnabled = typedArray2.getBoolean(R.styleable.CalendarView_swipeEnabled, true);
        this.mCalendarProperties.setSwipeEnabled(swipeEnabled);
        boolean z2 = swipeEnabled;
        this.mCalendarProperties.setPreviousButtonSrc(typedArray2.getDrawable(R.styleable.CalendarView_previousButtonSrc));
        this.mCalendarProperties.setForwardButtonSrc(typedArray2.getDrawable(R.styleable.CalendarView_forwardButtonSrc));
    }

    private void initAttributes() {
        AppearanceUtils.setHeaderColor(getRootView(), this.mCalendarProperties.getHeaderColor());
        AppearanceUtils.setHeaderVisibility(getRootView(), this.mCalendarProperties.getHeaderVisibility());
        AppearanceUtils.setAbbreviationsBarVisibility(getRootView(), this.mCalendarProperties.getAbbreviationsBarVisibility());
        AppearanceUtils.setNavigationVisibility(getRootView(), this.mCalendarProperties.getNavigationVisibility());
        AppearanceUtils.setHeaderLabelColor(getRootView(), this.mCalendarProperties.getHeaderLabelColor());
        AppearanceUtils.setAbbreviationsBarColor(getRootView(), this.mCalendarProperties.getAbbreviationsBarColor());
        AppearanceUtils.setAbbreviationsLabels(getRootView(), this.mCalendarProperties.getAbbreviationsLabelsColor(), this.mCalendarProperties.getFirstPageCalendarDate().getFirstDayOfWeek());
        AppearanceUtils.setPagesColor(getRootView(), this.mCalendarProperties.getPagesColor());
        AppearanceUtils.setPreviousButtonImage(getRootView(), this.mCalendarProperties.getPreviousButtonSrc());
        AppearanceUtils.setForwardButtonImage(getRootView(), this.mCalendarProperties.getForwardButtonSrc());
        this.mViewPager.setSwipeEnabled(this.mCalendarProperties.getSwipeEnabled());
        setCalendarRowLayout();
    }

    public void setHeaderColor(int color) {
        this.mCalendarProperties.setHeaderColor(color);
        AppearanceUtils.setHeaderColor(getRootView(), this.mCalendarProperties.getHeaderColor());
    }

    public void setHeaderVisibility(int visibility) {
        this.mCalendarProperties.setHeaderVisibility(visibility);
        AppearanceUtils.setHeaderVisibility(getRootView(), this.mCalendarProperties.getHeaderVisibility());
    }

    public void setAbbreviationsBarVisibility(int visibility) {
        this.mCalendarProperties.setAbbreviationsBarVisibility(visibility);
        AppearanceUtils.setAbbreviationsBarVisibility(getRootView(), this.mCalendarProperties.getAbbreviationsBarVisibility());
    }

    public void setHeaderLabelColor(int color) {
        this.mCalendarProperties.setHeaderLabelColor(color);
        AppearanceUtils.setHeaderLabelColor(getRootView(), this.mCalendarProperties.getHeaderLabelColor());
    }

    public void setPreviousButtonImage(Drawable drawable) {
        this.mCalendarProperties.setPreviousButtonSrc(drawable);
        AppearanceUtils.setPreviousButtonImage(getRootView(), this.mCalendarProperties.getPreviousButtonSrc());
    }

    public void setForwardButtonImage(Drawable drawable) {
        this.mCalendarProperties.setForwardButtonSrc(drawable);
        AppearanceUtils.setForwardButtonImage(getRootView(), this.mCalendarProperties.getForwardButtonSrc());
    }

    private void setCalendarRowLayout() {
        if (this.mCalendarProperties.getEventsEnabled()) {
            this.mCalendarProperties.setItemLayoutResource(R.layout.calendar_view_day);
        } else {
            this.mCalendarProperties.setItemLayoutResource(R.layout.calendar_view_picker_day);
        }
    }

    private void initUiElements() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.forwardButton);
        this.mForwardButton = imageButton;
        imageButton.setOnClickListener(this.onNextClickListener);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.previousButton);
        this.mPreviousButton = imageButton2;
        imageButton2.setOnClickListener(this.onPreviousClickListener);
        this.mCurrentMonthLabel = (TextView) findViewById(R.id.currentDateLabel);
        this.mViewPager = (CalendarViewPager) findViewById(R.id.calendarViewPager);
    }

    private void initCalendar() {
        CalendarPageAdapter calendarPageAdapter = new CalendarPageAdapter(this.mContext, this.mCalendarProperties);
        this.mCalendarPageAdapter = calendarPageAdapter;
        this.mViewPager.setAdapter(calendarPageAdapter);
        this.mViewPager.addOnPageChangeListener(this.onPageChangeListener);
        setUpCalendarPosition(Calendar.getInstance());
    }

    private void setUpCalendarPosition(Calendar calendar) {
        DateUtils.setMidnight(calendar);
        if (this.mCalendarProperties.getCalendarType() == 1) {
            this.mCalendarProperties.setSelectedDay(calendar);
        }
        this.mCalendarProperties.getFirstPageCalendarDate().setTime(calendar.getTime());
        this.mCalendarProperties.getFirstPageCalendarDate().add(2, -1200);
        this.mViewPager.setCurrentItem(CalendarProperties.FIRST_VISIBLE_PAGE);
    }

    public void setOnPreviousPageChangeListener(OnCalendarPageChangeListener listener) {
        this.mCalendarProperties.setOnPreviousPageChangeListener(listener);
    }

    public void setOnForwardPageChangeListener(OnCalendarPageChangeListener listener) {
        this.mCalendarProperties.setOnForwardPageChangeListener(listener);
    }

    public /* synthetic */ void lambda$new$0$CalendarView(View v) {
        CalendarViewPager calendarViewPager = this.mViewPager;
        calendarViewPager.setCurrentItem(calendarViewPager.getCurrentItem() + 1);
    }

    public /* synthetic */ void lambda$new$1$CalendarView(View v) {
        CalendarViewPager calendarViewPager = this.mViewPager;
        calendarViewPager.setCurrentItem(calendarViewPager.getCurrentItem() - 1);
    }

    /* access modifiers changed from: private */
    public boolean isScrollingLimited(Calendar calendar, int position) {
        if (DateUtils.isMonthBefore(this.mCalendarProperties.getMinimumDate(), calendar)) {
            this.mViewPager.setCurrentItem(position + 1);
            return true;
        } else if (!DateUtils.isMonthAfter(this.mCalendarProperties.getMaximumDate(), calendar)) {
            return false;
        } else {
            this.mViewPager.setCurrentItem(position - 1);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void setHeaderName(Calendar calendar, int position) {
        this.mCurrentMonthLabel.setText(DateUtils.getMonthAndYearDate(this.mContext, calendar));
        callOnPageChangeListeners(position);
    }

    private void callOnPageChangeListeners(int position) {
        if (position > this.mCurrentPage && this.mCalendarProperties.getOnForwardPageChangeListener() != null) {
            this.mCalendarProperties.getOnForwardPageChangeListener().onChange();
        }
        if (position < this.mCurrentPage && this.mCalendarProperties.getOnPreviousPageChangeListener() != null) {
            this.mCalendarProperties.getOnPreviousPageChangeListener().onChange();
        }
        this.mCurrentPage = position;
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.mCalendarProperties.setOnDayClickListener(onDayClickListener);
    }

    public void setDate(Calendar date) throws OutOfDateRangeException {
        if (this.mCalendarProperties.getMinimumDate() != null && date.before(this.mCalendarProperties.getMinimumDate())) {
            throw new OutOfDateRangeException(ErrorsMessages.OUT_OF_RANGE_MIN);
        } else if (this.mCalendarProperties.getMaximumDate() == null || !date.after(this.mCalendarProperties.getMaximumDate())) {
            setUpCalendarPosition(date);
            this.mCurrentMonthLabel.setText(DateUtils.getMonthAndYearDate(this.mContext, date));
            this.mCalendarPageAdapter.notifyDataSetChanged();
        } else {
            throw new OutOfDateRangeException(ErrorsMessages.OUT_OF_RANGE_MAX);
        }
    }

    public void setDate(Date currentDate) throws OutOfDateRangeException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        setDate(calendar);
    }

    public void setEvents(List<EventDay> eventDays) {
        if (this.mCalendarProperties.getEventsEnabled()) {
            this.mCalendarProperties.setEventDays(eventDays);
            this.mCalendarPageAdapter.notifyDataSetChanged();
        }
    }

    public List<Calendar> getSelectedDates() {
        return Stream.of(this.mCalendarPageAdapter.getSelectedDays()).map($$Lambda$9SFztE8QPsDOp6DXEHc7RaVO4Xg.INSTANCE).sortBy($$Lambda$CalendarView$Iw1n5CQCR15KNBdnAB0TSX7rCY.INSTANCE).toList();
    }

    static /* synthetic */ Calendar lambda$getSelectedDates$2(Calendar calendar) {
        return calendar;
    }

    public void setSelectedDates(List<Calendar> selectedDates) {
        this.mCalendarProperties.setSelectedDays(selectedDates);
        this.mCalendarPageAdapter.notifyDataSetChanged();
    }

    @Deprecated
    public Calendar getSelectedDate() {
        return getFirstSelectedDate();
    }

    public Calendar getFirstSelectedDate() {
        return (Calendar) Stream.of(this.mCalendarPageAdapter.getSelectedDays()).map($$Lambda$9SFztE8QPsDOp6DXEHc7RaVO4Xg.INSTANCE).findFirst().get();
    }

    public Calendar getCurrentPageDate() {
        Calendar calendar = (Calendar) this.mCalendarProperties.getFirstPageCalendarDate().clone();
        calendar.set(5, 1);
        calendar.add(2, this.mViewPager.getCurrentItem());
        return calendar;
    }

    public void setMinimumDate(Calendar calendar) {
        this.mCalendarProperties.setMinimumDate(calendar);
    }

    public void setMaximumDate(Calendar calendar) {
        this.mCalendarProperties.setMaximumDate(calendar);
    }

    public void showCurrentMonthPage() {
        CalendarViewPager calendarViewPager = this.mViewPager;
        calendarViewPager.setCurrentItem(calendarViewPager.getCurrentItem() - DateUtils.getMonthsBetweenDates(DateUtils.getCalendar(), getCurrentPageDate()), true);
    }

    public void setDisabledDays(List<Calendar> disabledDays) {
        this.mCalendarProperties.setDisabledDays(disabledDays);
    }

    public void setHighlightedDays(List<Calendar> highlightedDays) {
        this.mCalendarProperties.setHighlightedDays(highlightedDays);
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.mCalendarProperties.setSwipeEnabled(swipeEnabled);
        this.mViewPager.setSwipeEnabled(this.mCalendarProperties.getSwipeEnabled());
    }
}

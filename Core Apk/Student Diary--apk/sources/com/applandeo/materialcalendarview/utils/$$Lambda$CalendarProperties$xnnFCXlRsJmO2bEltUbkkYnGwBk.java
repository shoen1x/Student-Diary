package com.applandeo.materialcalendarview.utils;

import com.annimon.stream.function.Function;
import java.util.Calendar;

/* renamed from: com.applandeo.materialcalendarview.utils.-$$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk implements Function {
    public static final /* synthetic */ $$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk INSTANCE = new $$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk();

    private /* synthetic */ $$Lambda$CalendarProperties$xnnFCXlRsJmO2bEltUbkkYnGwBk() {
    }

    public final Object apply(Object obj) {
        return DateUtils.setMidnight((Calendar) obj);
    }
}

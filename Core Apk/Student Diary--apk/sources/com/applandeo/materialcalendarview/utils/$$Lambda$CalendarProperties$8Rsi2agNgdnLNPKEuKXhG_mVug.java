package com.applandeo.materialcalendarview.utils;

import com.annimon.stream.function.Function;
import java.util.Calendar;

/* renamed from: com.applandeo.materialcalendarview.utils.-$$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVu-g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVug implements Function {
    public static final /* synthetic */ $$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVug INSTANCE = new $$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVug();

    private /* synthetic */ $$Lambda$CalendarProperties$8Rsi2agNgdnLNPKEuKXhG_mVug() {
    }

    public final Object apply(Object obj) {
        return DateUtils.setMidnight((Calendar) obj);
    }
}

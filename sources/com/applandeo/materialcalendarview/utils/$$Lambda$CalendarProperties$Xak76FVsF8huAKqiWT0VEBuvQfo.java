package com.applandeo.materialcalendarview.utils;

import com.annimon.stream.function.Function;
import java.util.Calendar;

/* renamed from: com.applandeo.materialcalendarview.utils.-$$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo implements Function {
    public static final /* synthetic */ $$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo INSTANCE = new $$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo();

    private /* synthetic */ $$Lambda$CalendarProperties$Xak76FVsF8huAKqiWT0VEBuvQfo() {
    }

    public final Object apply(Object obj) {
        return DateUtils.setMidnight((Calendar) obj);
    }
}

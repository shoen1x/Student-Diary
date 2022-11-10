package com.applandeo.materialcalendarview.utils;

import com.annimon.stream.function.Function;
import java.util.Calendar;

/* renamed from: com.applandeo.materialcalendarview.utils.-$$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg implements Function {
    public static final /* synthetic */ $$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg INSTANCE = new $$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg();

    private /* synthetic */ $$Lambda$DateUtils$zWCC6rmxIwAT_L0mQb1G44w4ofg() {
    }

    public final Object apply(Object obj) {
        return Long.valueOf(((Calendar) obj).getTimeInMillis());
    }
}

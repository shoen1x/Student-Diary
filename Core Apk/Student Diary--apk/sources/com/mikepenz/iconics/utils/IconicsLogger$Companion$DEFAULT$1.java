package com.mikepenz.iconics.utils;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/mikepenz/iconics/utils/IconicsLogger$Companion$DEFAULT$1", "Lcom/mikepenz/iconics/utils/IconicsLogger;", "log", "", "priority", "", "tag", "", "msg", "t", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsLogger.kt */
public final class IconicsLogger$Companion$DEFAULT$1 implements IconicsLogger {
    IconicsLogger$Companion$DEFAULT$1() {
    }

    public void log(int priority, String tag, String msg, Throwable t) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, NotificationCompat.CATEGORY_MESSAGE);
        Log.println(priority, tag, msg);
        if (t != null) {
            Log.println(priority, tag, Log.getStackTraceString(t));
        }
    }
}

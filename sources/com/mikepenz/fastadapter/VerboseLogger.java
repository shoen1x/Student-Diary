package com.mikepenz.fastadapter;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/mikepenz/fastadapter/VerboseLogger;", "", "tag", "", "(Ljava/lang/String;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "log", "", "message", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: VerboseLogger.kt */
public final class VerboseLogger {
    private boolean isEnabled;
    private final String tag;

    public VerboseLogger(String tag2) {
        Intrinsics.checkParameterIsNotNull(tag2, "tag");
        this.tag = tag2;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void log(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.isEnabled) {
            Log.v(this.tag, message);
        }
    }
}

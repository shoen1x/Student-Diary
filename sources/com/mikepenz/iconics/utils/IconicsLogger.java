package com.mikepenz.iconics.utils;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&\u0002\u0007\n\u0005\bF0\u0001¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsLogger;", "", "log", "", "priority", "", "tag", "", "msg", "t", "", "Companion", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsLogger.kt */
public interface IconicsLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final IconicsLogger DEFAULT = new IconicsLogger$Companion$DEFAULT$1();

    void log(int i, String str, String str2, Throwable th);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* compiled from: IconicsLogger.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void log$default(IconicsLogger iconicsLogger, int i, String str, String str2, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    th = null;
                }
                iconicsLogger.log(i, str, str2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0005"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsLogger$Companion;", "", "()V", "DEFAULT", "Lcom/mikepenz/iconics/utils/IconicsLogger;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsLogger.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

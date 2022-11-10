package com.mikepenz.iconics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\n\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/iconics/IconicsSize;", "Lcom/mikepenz/iconics/IconicsExtractor;", "()V", "extract", "", "context", "Landroid/content/Context;", "extract$iconics_core", "extractFloat", "", "extractFloat$iconics_core", "Companion", "Lcom/mikepenz/iconics/IconicsSizeDp;", "Lcom/mikepenz/iconics/IconicsSizePx;", "Lcom/mikepenz/iconics/IconicsSizeRes;", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsSize.kt */
public abstract class IconicsSize implements IconicsExtractor {
    public static final Companion Companion;
    public static final IconicsSize TOOLBAR_ICON_PADDING = Companion.dp(Float.valueOf(1.0f));
    public static final IconicsSize TOOLBAR_ICON_SIZE;

    @JvmStatic
    public static final IconicsSize dp(Number number) {
        return Companion.dp(number);
    }

    @JvmStatic
    public static final IconicsSize px(Number number) {
        return Companion.px(number);
    }

    @JvmStatic
    public static final IconicsSize res(int i) {
        return Companion.res(i);
    }

    public abstract int extract$iconics_core(Context context);

    public abstract float extractFloat$iconics_core(Context context);

    private IconicsSize() {
    }

    public /* synthetic */ IconicsSize(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/iconics/IconicsSize$Companion;", "", "()V", "TOOLBAR_ICON_PADDING", "Lcom/mikepenz/iconics/IconicsSize;", "TOOLBAR_ICON_SIZE", "dp", "", "px", "res", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final IconicsSize dp(Number dp) {
            Intrinsics.checkParameterIsNotNull(dp, "dp");
            return new IconicsSizeDp(dp);
        }

        @JvmStatic
        public final IconicsSize px(Number px) {
            Intrinsics.checkParameterIsNotNull(px, "px");
            return new IconicsSizePx(px);
        }

        @JvmStatic
        public final IconicsSize res(int res) {
            return new IconicsSizeRes(res);
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        TOOLBAR_ICON_SIZE = companion.dp(Float.valueOf(24.0f));
    }
}

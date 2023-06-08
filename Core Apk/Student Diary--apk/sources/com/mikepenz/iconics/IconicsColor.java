package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\n\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/iconics/IconicsColor;", "", "()V", "extract", "", "context", "Landroid/content/Context;", "extract$iconics_core", "extractList", "Landroid/content/res/ColorStateList;", "extractList$iconics_core", "Companion", "Lcom/mikepenz/iconics/IconicsColorInt;", "Lcom/mikepenz/iconics/IconicsColorRes;", "Lcom/mikepenz/iconics/IconicsColorList;", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsColor.kt */
public abstract class IconicsColor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final IconicsColor colorInt(int i) {
        return Companion.colorInt(i);
    }

    @JvmStatic
    public static final IconicsColor colorList(ColorStateList colorStateList) {
        return Companion.colorList(colorStateList);
    }

    @JvmStatic
    public static final IconicsColor colorRes(int i) {
        return Companion.colorRes(i);
    }

    @JvmStatic
    public static final IconicsColor parse(String str) {
        return Companion.parse(str);
    }

    public abstract int extract$iconics_core(Context context);

    public abstract ColorStateList extractList$iconics_core(Context context);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/IconicsColor$Companion;", "", "()V", "colorInt", "Lcom/mikepenz/iconics/IconicsColor;", "", "colorList", "Landroid/content/res/ColorStateList;", "colorRes", "parse", "colorString", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsColor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final IconicsColor colorInt(int colorInt) {
            return new IconicsColorInt(colorInt);
        }

        @JvmStatic
        public final IconicsColor colorRes(int colorRes) {
            return new IconicsColorRes(colorRes);
        }

        @JvmStatic
        public final IconicsColor colorList(ColorStateList colorList) {
            Intrinsics.checkParameterIsNotNull(colorList, "colorList");
            return new IconicsColorList(colorList);
        }

        @JvmStatic
        public final IconicsColor parse(String colorString) {
            Intrinsics.checkParameterIsNotNull(colorString, "colorString");
            return colorInt(Color.parseColor(colorString));
        }
    }

    private IconicsColor() {
    }

    public /* synthetic */ IconicsColor(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

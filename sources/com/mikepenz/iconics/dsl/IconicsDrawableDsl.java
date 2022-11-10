package com.mikepenz.iconics.dsl;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\\\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020]J\u000e\u0010^\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020PJ\u0010\u0010_\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020]J\u000e\u0010`\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020aJ\u000e\u0010b\u001a\u00020\u00122\u0006\u0010A\u001a\u00020cJ\u000e\u0010d\u001a\u00020\u00122\u0006\u0010A\u001a\u00020cJ\u0010\u0010e\u001a\u00020\u00122\b\b\u0001\u0010A\u001a\u00020]R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001b8G@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR$\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R$\u0010/\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R$\u00102\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R$\u00105\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@FX\u000e¢\u0006\f\u001a\u0004\b6\u0010\t\"\u0004\b7\u0010\u000bR$\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R$\u0010;\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R$\u0010>\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R$\u0010A\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R$\u0010D\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010\u0017R$\u0010G\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017R$\u0010K\u001a\u00020J2\u0006\u0010\u0005\u001a\u00020J8G@FX\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\u0005\u001a\u0004\u0018\u00010P8G@FX\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\u0005\u001a\u0004\u0018\u00010V8G@FX\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006f"}, d2 = {"Lcom/mikepenz/iconics/dsl/IconicsDrawableDsl;", "", "drawable", "Lcom/mikepenz/iconics/IconicsDrawable;", "(Lcom/mikepenz/iconics/IconicsDrawable;)V", "value", "", "actionBarSize", "getActionBarSize", "()Z", "setActionBarSize", "(Z)V", "Lcom/mikepenz/iconics/IconicsColor;", "backgroundColor", "getBackgroundColor", "()Lcom/mikepenz/iconics/IconicsColor;", "setBackgroundColor", "(Lcom/mikepenz/iconics/IconicsColor;)V", "Lcom/mikepenz/iconics/IconicsSize;", "backgroundContourWidth", "getBackgroundContourWidth", "()Lcom/mikepenz/iconics/IconicsSize;", "setBackgroundContourWidth", "(Lcom/mikepenz/iconics/IconicsSize;)V", "color", "getColor", "setColor", "Landroid/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroid/graphics/ColorFilter;", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "contourWidth", "getContourWidth", "setContourWidth", "drawBackgroundContour", "getDrawBackgroundContour", "setDrawBackgroundContour", "drawContour", "getDrawContour", "setDrawContour", "getDrawable$iconics_core", "()Lcom/mikepenz/iconics/IconicsDrawable;", "iconOffsetX", "getIconOffsetX", "setIconOffsetX", "iconOffsetY", "getIconOffsetY", "setIconOffsetY", "padding", "getPadding", "setPadding", "respectFontBounds", "getRespectFontBounds", "setRespectFontBounds", "roundedCornerRy", "getRoundedCornerRy", "setRoundedCornerRy", "roundedCorners", "getRoundedCorners", "setRoundedCorners", "roundedCornersRx", "getRoundedCornersRx", "setRoundedCornersRx", "size", "getSize", "setSize", "sizeX", "getSizeX", "setSizeX", "sizeY", "getSizeY", "setSizeY", "Landroid/graphics/Paint$Style;", "style", "getStyle", "()Landroid/graphics/Paint$Style;", "setStyle", "(Landroid/graphics/Paint$Style;)V", "Landroid/content/res/ColorStateList;", "tintList", "getTintList", "()Landroid/content/res/ColorStateList;", "setTintList", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "getTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "colorInt", "", "colorList", "colorRes", "colorString", "", "sizeDp", "", "sizePx", "sizeRes", "iconics-core"}, k = 1, mv = {1, 1, 15})
@ExperimentalIconicsDSL
/* compiled from: IconicsDrawableDsl.kt */
public class IconicsDrawableDsl {
    private final IconicsDrawable drawable;

    public IconicsDrawableDsl(IconicsDrawable drawable2) {
        Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
        this.drawable = drawable2;
    }

    public final IconicsDrawable getDrawable$iconics_core() {
        return this.drawable;
    }

    public final IconicsSize sizePx(Number size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        return IconicsSize.Companion.px(size);
    }

    public final IconicsSize sizeDp(Number size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        return IconicsSize.Companion.dp(size);
    }

    public final IconicsSize sizeRes(int size) {
        return IconicsSize.Companion.res(size);
    }

    public final IconicsColor colorString(String color) {
        Intrinsics.checkParameterIsNotNull(color, "color");
        return IconicsColor.Companion.parse(color);
    }

    public final IconicsColor colorRes(int color) {
        return IconicsColor.Companion.colorRes(color);
    }

    public final IconicsColor colorInt(int color) {
        return IconicsColor.Companion.colorInt(color);
    }

    public final IconicsColor colorList(ColorStateList color) {
        Intrinsics.checkParameterIsNotNull(color, "color");
        return IconicsColor.Companion.colorList(color);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getSizeX() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setSizeX(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.sizeX(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getSizeY() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setSizeY(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.sizeY(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getSize() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setSize(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.size(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getIconOffsetX() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setIconOffsetX(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.iconOffsetX(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getIconOffsetY() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setIconOffsetY(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.iconOffsetY(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getPadding() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setPadding(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.padding(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsColor getColor() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setColor(IconicsColor value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.color(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getRoundedCornersRx() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setRoundedCornersRx(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.roundedCornersRx(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getRoundedCornerRy() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setRoundedCornerRy(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.roundedCornersRy(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getRoundedCorners() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setRoundedCorners(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.roundedCorners(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsColor getBackgroundColor() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setBackgroundColor(IconicsColor value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.backgroundColor(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getContourWidth() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setContourWidth(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.contourWidth(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final IconicsSize getBackgroundContourWidth() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setBackgroundContourWidth(IconicsSize value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.backgroundContourWidth(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final boolean getDrawContour() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setDrawContour(boolean value) {
        this.drawable.drawContour(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final boolean getDrawBackgroundContour() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setDrawBackgroundContour(boolean value) {
        this.drawable.drawBackgroundContour(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final ColorFilter getColorFilter() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setColorFilter(ColorFilter value) {
        this.drawable.colorFilter(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final ColorStateList getTintList() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setTintList(ColorStateList value) {
        this.drawable.setTintList(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final PorterDuff.Mode getTintMode() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setTintMode(PorterDuff.Mode value) {
        this.drawable.setTintMode(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final Paint.Style getStyle() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setStyle(Paint.Style value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.drawable.style(value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final boolean getActionBarSize() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setActionBarSize(boolean value) {
        if (value) {
            this.drawable.actionBar();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
    public final boolean getRespectFontBounds() {
        IconicsDrawableDslKt.nonReadable();
        throw null;
    }

    public final void setRespectFontBounds(boolean value) {
        this.drawable.respectFontBounds(value);
    }
}

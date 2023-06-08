package com.mikepenz.iconics.utils;

import android.content.res.ColorStateList;
import androidx.core.graphics.drawable.IconCompat;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0017\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0017\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0017\u0010\r\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\b\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0010\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\b\u001a\u0017\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0003H\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\bH\b\u001a\r\u0010 \u001a\u00020\u001e*\u00020\u0003H\b\u001a\r\u0010!\u001a\u00020\"*\u00020#H\b\u001a\r\u0010$\u001a\u00020\"*\u00020#H\b\u001a\r\u0010%\u001a\u00020\"*\u00020\u0003H\b¨\u0006&"}, d2 = {"backgroundColorInt", "Lcom/mikepenz/iconics/IconicsDrawable;", "colorInt", "", "backgroundColorRes", "colorRes", "backgroundColorString", "colorString", "", "backgroundContourColorInt", "backgroundContourColorRes", "backgroundContourColorString", "contourColorInt", "contourColorRes", "contourColorString", "contourWidthDp", "sizeDp", "contourWidthPx", "sizePx", "contourWidthRes", "sizeRes", "paddingDp", "paddingPx", "paddingRes", "roundedCornersDp", "roundedCornersPx", "roundedCornersRes", "toAndroidIconCompat", "Landroidx/core/graphics/drawable/IconCompat;", "toIconicsColor", "Lcom/mikepenz/iconics/IconicsColor;", "Landroid/content/res/ColorStateList;", "toIconicsColorRes", "toIconicsSizeDp", "Lcom/mikepenz/iconics/IconicsSize;", "", "toIconicsSizePx", "toIconicsSizeRes", "iconics-core"}, k = 2, mv = {1, 1, 15})
/* compiled from: IconicsConverters.kt */
public final class IconicsConvertersKt {
    public static final IconicsDrawable colorString(IconicsDrawable $this$colorString, String colorString) {
        Intrinsics.checkParameterIsNotNull($this$colorString, "$this$colorString");
        Intrinsics.checkParameterIsNotNull(colorString, "colorString");
        return $this$colorString.color(IconicsColor.Companion.parse(colorString));
    }

    public static final IconicsDrawable colorRes(IconicsDrawable $this$colorRes, int colorRes) {
        Intrinsics.checkParameterIsNotNull($this$colorRes, "$this$colorRes");
        return $this$colorRes.color(IconicsColor.Companion.colorRes(colorRes));
    }

    public static final IconicsDrawable colorInt(IconicsDrawable $this$colorInt, int colorInt) {
        Intrinsics.checkParameterIsNotNull($this$colorInt, "$this$colorInt");
        return $this$colorInt.color(IconicsColor.Companion.colorInt(colorInt));
    }

    public static final IconicsDrawable contourColorString(IconicsDrawable $this$contourColorString, String colorString) {
        Intrinsics.checkParameterIsNotNull($this$contourColorString, "$this$contourColorString");
        Intrinsics.checkParameterIsNotNull(colorString, "colorString");
        return $this$contourColorString.contourColor(IconicsColor.Companion.parse(colorString));
    }

    public static final IconicsDrawable contourColorRes(IconicsDrawable $this$contourColorRes, int colorRes) {
        Intrinsics.checkParameterIsNotNull($this$contourColorRes, "$this$contourColorRes");
        return $this$contourColorRes.contourColor(IconicsColor.Companion.colorRes(colorRes));
    }

    public static final IconicsDrawable contourColorInt(IconicsDrawable $this$contourColorInt, int colorInt) {
        Intrinsics.checkParameterIsNotNull($this$contourColorInt, "$this$contourColorInt");
        return $this$contourColorInt.contourColor(IconicsColor.Companion.colorInt(colorInt));
    }

    public static final IconicsDrawable backgroundColorString(IconicsDrawable $this$backgroundColorString, String colorString) {
        Intrinsics.checkParameterIsNotNull($this$backgroundColorString, "$this$backgroundColorString");
        Intrinsics.checkParameterIsNotNull(colorString, "colorString");
        return $this$backgroundColorString.backgroundColor(IconicsColor.Companion.parse(colorString));
    }

    public static final IconicsDrawable backgroundColorRes(IconicsDrawable $this$backgroundColorRes, int colorRes) {
        Intrinsics.checkParameterIsNotNull($this$backgroundColorRes, "$this$backgroundColorRes");
        return $this$backgroundColorRes.backgroundColor(IconicsColor.Companion.colorRes(colorRes));
    }

    public static final IconicsDrawable backgroundColorInt(IconicsDrawable $this$backgroundColorInt, int colorInt) {
        Intrinsics.checkParameterIsNotNull($this$backgroundColorInt, "$this$backgroundColorInt");
        return $this$backgroundColorInt.backgroundColor(IconicsColor.Companion.colorInt(colorInt));
    }

    public static final IconicsDrawable backgroundContourColorString(IconicsDrawable $this$backgroundContourColorString, String colorString) {
        Intrinsics.checkParameterIsNotNull($this$backgroundContourColorString, "$this$backgroundContourColorString");
        Intrinsics.checkParameterIsNotNull(colorString, "colorString");
        return $this$backgroundContourColorString.backgroundContourColor(IconicsColor.Companion.parse(colorString));
    }

    public static final IconicsDrawable backgroundContourColorRes(IconicsDrawable $this$backgroundContourColorRes, int colorRes) {
        Intrinsics.checkParameterIsNotNull($this$backgroundContourColorRes, "$this$backgroundContourColorRes");
        return $this$backgroundContourColorRes.backgroundContourColor(IconicsColor.Companion.colorRes(colorRes));
    }

    public static final IconicsDrawable backgroundContourColorInt(IconicsDrawable $this$backgroundContourColorInt, int colorInt) {
        Intrinsics.checkParameterIsNotNull($this$backgroundContourColorInt, "$this$backgroundContourColorInt");
        return $this$backgroundContourColorInt.backgroundContourColor(IconicsColor.Companion.colorInt(colorInt));
    }

    public static final IconicsDrawable sizeDp(IconicsDrawable $this$sizeDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$sizeDp, "$this$sizeDp");
        return $this$sizeDp.size(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    public static final IconicsDrawable sizePx(IconicsDrawable $this$sizePx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$sizePx, "$this$sizePx");
        return $this$sizePx.size(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    public static final IconicsDrawable sizeRes(IconicsDrawable $this$sizeRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$sizeRes, "$this$sizeRes");
        return $this$sizeRes.size(IconicsSize.Companion.res(sizeRes));
    }

    public static final IconicsDrawable paddingDp(IconicsDrawable $this$paddingDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$paddingDp, "$this$paddingDp");
        return $this$paddingDp.padding(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    public static final IconicsDrawable paddingPx(IconicsDrawable $this$paddingPx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$paddingPx, "$this$paddingPx");
        return $this$paddingPx.padding(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    public static final IconicsDrawable paddingRes(IconicsDrawable $this$paddingRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$paddingRes, "$this$paddingRes");
        return $this$paddingRes.padding(IconicsSize.Companion.res(sizeRes));
    }

    public static final IconicsDrawable roundedCornersDp(IconicsDrawable $this$roundedCornersDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$roundedCornersDp, "$this$roundedCornersDp");
        return $this$roundedCornersDp.roundedCorners(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    public static final IconicsDrawable roundedCornersPx(IconicsDrawable $this$roundedCornersPx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$roundedCornersPx, "$this$roundedCornersPx");
        return $this$roundedCornersPx.roundedCorners(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    public static final IconicsDrawable roundedCornersRes(IconicsDrawable $this$roundedCornersRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$roundedCornersRes, "$this$roundedCornersRes");
        return $this$roundedCornersRes.roundedCorners(IconicsSize.Companion.res(sizeRes));
    }

    public static final IconicsDrawable contourWidthDp(IconicsDrawable $this$contourWidthDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$contourWidthDp, "$this$contourWidthDp");
        return $this$contourWidthDp.contourWidth(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    public static final IconicsDrawable contourWidthPx(IconicsDrawable $this$contourWidthPx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$contourWidthPx, "$this$contourWidthPx");
        return $this$contourWidthPx.contourWidth(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    public static final IconicsDrawable contourWidthRes(IconicsDrawable $this$contourWidthRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$contourWidthRes, "$this$contourWidthRes");
        return $this$contourWidthRes.contourWidth(IconicsSize.Companion.res(sizeRes));
    }

    public static final IconCompat toAndroidIconCompat(IconicsDrawable $this$toAndroidIconCompat) {
        Intrinsics.checkParameterIsNotNull($this$toAndroidIconCompat, "$this$toAndroidIconCompat");
        IconCompat createWithBitmap = IconCompat.createWithBitmap($this$toAndroidIconCompat.toBitmap());
        Intrinsics.checkExpressionValueIsNotNull(createWithBitmap, "IconCompat.createWithBitmap(toBitmap())");
        return createWithBitmap;
    }

    @Deprecated(message = "Use IconicsSize.dp() instead", replaceWith = @ReplaceWith(expression = "IconicsSize.dp(x)", imports = {"com.mikepenz.iconics.IconicsSize"}))
    public static final IconicsSize toIconicsSizeDp(Number $this$toIconicsSizeDp) {
        Intrinsics.checkParameterIsNotNull($this$toIconicsSizeDp, "$this$toIconicsSizeDp");
        return IconicsSize.Companion.dp($this$toIconicsSizeDp);
    }

    @Deprecated(message = "Use IconicsSize.px() instead", replaceWith = @ReplaceWith(expression = "IconicsSize.px(x)", imports = {"com.mikepenz.iconics.IconicsSize"}))
    public static final IconicsSize toIconicsSizePx(Number $this$toIconicsSizePx) {
        Intrinsics.checkParameterIsNotNull($this$toIconicsSizePx, "$this$toIconicsSizePx");
        return IconicsSize.Companion.px($this$toIconicsSizePx);
    }

    @Deprecated(message = "Use IconicsSize.res() instead", replaceWith = @ReplaceWith(expression = "IconicsSize.res(x)", imports = {"com.mikepenz.iconics.IconicsSize"}))
    public static final IconicsSize toIconicsSizeRes(int $this$toIconicsSizeRes) {
        return IconicsSize.Companion.res($this$toIconicsSizeRes);
    }

    @Deprecated(message = "Use IconicsColor.colorInt() instead", replaceWith = @ReplaceWith(expression = "IconicsColor.colorInt(x)", imports = {"com.mikepenz.iconics.IconicsColor"}))
    public static final IconicsColor toIconicsColor(int $this$toIconicsColor) {
        return IconicsColor.Companion.colorInt($this$toIconicsColor);
    }

    @Deprecated(message = "Use IconicsColor.parse() instead", replaceWith = @ReplaceWith(expression = "IconicsColor.parse(x)", imports = {"com.mikepenz.iconics.IconicsColor"}))
    public static final IconicsColor toIconicsColor(String $this$toIconicsColor) {
        Intrinsics.checkParameterIsNotNull($this$toIconicsColor, "$this$toIconicsColor");
        return IconicsColor.Companion.parse($this$toIconicsColor);
    }

    @Deprecated(message = "Use IconicsColor.colorList() instead", replaceWith = @ReplaceWith(expression = "IconicsColor.colorList(x)", imports = {"com.mikepenz.iconics.IconicsColor"}))
    public static final IconicsColor toIconicsColor(ColorStateList $this$toIconicsColor) {
        Intrinsics.checkParameterIsNotNull($this$toIconicsColor, "$this$toIconicsColor");
        return IconicsColor.Companion.colorList($this$toIconicsColor);
    }

    @Deprecated(message = "Use IconicsColor.colorRes() instead", replaceWith = @ReplaceWith(expression = "IconicsColor.colorRes(x)", imports = {"com.mikepenz.iconics.IconicsColor"}))
    public static final IconicsColor toIconicsColorRes(int $this$toIconicsColorRes) {
        return IconicsColor.Companion.colorRes($this$toIconicsColorRes);
    }
}

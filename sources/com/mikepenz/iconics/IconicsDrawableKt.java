package com.mikepenz.iconics;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0000\u001a\u00020\u0002H\b\u001a\u0017\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a\u0017\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0007\u001a\u00020\u0002H\b\u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\u0002H\b\u001a\u0017\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\u0002H\b\u001a\u0017\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0007\u001a\u00020\u0002H\b\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\u0002H\b\u001a\u0017\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\u0002H\b¨\u0006\f"}, d2 = {"colorInt", "Lcom/mikepenz/iconics/IconicsDrawable;", "", "colorRes", "colorString", "", "paddingDp", "sizeDp", "paddingPx", "sizePx", "paddingRes", "sizeRes", "iconics-core"}, k = 2, mv = {1, 1, 15})
/* compiled from: IconicsDrawable.kt */
public final class IconicsDrawableKt {
    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "colorString", imports = {"com.mikepenz.iconics.utils.colorString"}))
    public static final IconicsDrawable colorString(IconicsDrawable $this$colorString, String colorString) {
        Intrinsics.checkParameterIsNotNull($this$colorString, "$this$colorString");
        Intrinsics.checkParameterIsNotNull(colorString, "colorString");
        return $this$colorString.color(IconicsColor.Companion.parse(colorString));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "colorRes", imports = {"com.mikepenz.iconics.utils.colorRes"}))
    public static final IconicsDrawable colorRes(IconicsDrawable $this$colorRes, int colorRes) {
        Intrinsics.checkParameterIsNotNull($this$colorRes, "$this$colorRes");
        return $this$colorRes.color(IconicsColor.Companion.colorRes(colorRes));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "colorInt", imports = {"com.mikepenz.iconics.utils.colorInt"}))
    public static final IconicsDrawable colorInt(IconicsDrawable $this$colorInt, int colorInt) {
        Intrinsics.checkParameterIsNotNull($this$colorInt, "$this$colorInt");
        return $this$colorInt.color(IconicsColor.Companion.colorInt(colorInt));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "sizeDp", imports = {"com.mikepenz.iconics.utils.sizeDp"}))
    public static final IconicsDrawable sizeDp(IconicsDrawable $this$sizeDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$sizeDp, "$this$sizeDp");
        return $this$sizeDp.size(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "sizePx", imports = {"com.mikepenz.iconics.utils.sizePx"}))
    public static final IconicsDrawable sizePx(IconicsDrawable $this$sizePx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$sizePx, "$this$sizePx");
        return $this$sizePx.size(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "sizeRes", imports = {"com.mikepenz.iconics.utils.sizeRes"}))
    public static final IconicsDrawable sizeRes(IconicsDrawable $this$sizeRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$sizeRes, "$this$sizeRes");
        return $this$sizeRes.size(IconicsSize.Companion.res(sizeRes));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "paddingDp", imports = {"com.mikepenz.iconics.utils.paddingDp"}))
    public static final IconicsDrawable paddingDp(IconicsDrawable $this$paddingDp, int sizeDp) {
        Intrinsics.checkParameterIsNotNull($this$paddingDp, "$this$paddingDp");
        return $this$paddingDp.padding(IconicsSize.Companion.dp(Integer.valueOf(sizeDp)));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "paddingPx", imports = {"com.mikepenz.iconics.utils.paddingPx"}))
    public static final IconicsDrawable paddingPx(IconicsDrawable $this$paddingPx, int sizePx) {
        Intrinsics.checkParameterIsNotNull($this$paddingPx, "$this$paddingPx");
        return $this$paddingPx.padding(IconicsSize.Companion.px(Integer.valueOf(sizePx)));
    }

    @Deprecated(message = "Moved to new class", replaceWith = @ReplaceWith(expression = "paddingRes", imports = {"com.mikepenz.iconics.utils.paddingRes"}))
    public static final IconicsDrawable paddingRes(IconicsDrawable $this$paddingRes, int sizeRes) {
        Intrinsics.checkParameterIsNotNull($this$paddingRes, "$this$paddingRes");
        return $this$paddingRes.padding(IconicsSize.Companion.res(sizeRes));
    }
}

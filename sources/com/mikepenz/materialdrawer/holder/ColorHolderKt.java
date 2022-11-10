package com.mikepenz.materialdrawer.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.mikepenz.materialize.holder.ColorHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u001e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u000b\u001a\u001e\u0010\f\u001a\u00020\b*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"applyColor", "", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "ctx", "Landroid/content/Context;", "colorStyle", "colorDefault", "applyToOrDefault", "", "textView", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "applyToOrTransparent", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "materialdrawer"}, k = 2, mv = {1, 1, 16})
/* compiled from: ColorHolder.kt */
public final class ColorHolderKt {
    public static final int applyColor(ColorHolder $this$applyColor, Context ctx, int colorStyle, int colorDefault) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return ColorHolder.color($this$applyColor, ctx, colorStyle, colorDefault);
    }

    public static final int applyColor(ColorHolder $this$applyColor, Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return ColorHolder.color($this$applyColor, ctx);
    }

    public static final void applyToOrDefault(ColorHolder $this$applyToOrDefault, TextView textView, ColorStateList colorDefault) {
        Intrinsics.checkParameterIsNotNull(colorDefault, "colorDefault");
        ColorHolder.applyToOr($this$applyToOrDefault, textView, colorDefault);
    }

    public static final void applyToOrTransparent(ColorHolder $this$applyToOrTransparent, Context ctx, GradientDrawable gradientDrawable) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        ColorHolder.applyToOrTransparent($this$applyToOrTransparent, ctx, gradientDrawable);
    }
}

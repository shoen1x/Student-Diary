package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsAttrsApplier;", "", "()V", "getIconicsDrawable", "Lcom/mikepenz/iconics/IconicsDrawable;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAttrsApplier.kt */
public final class IconicsAttrsApplier {
    public static final IconicsAttrsApplier INSTANCE = new IconicsAttrsApplier();

    private IconicsAttrsApplier() {
    }

    @JvmStatic
    public static final IconicsDrawable getIconicsDrawable(Context ctx, AttributeSet attrs) {
        Context context = ctx;
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Iconics);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "ctx.obtainStyledAttribut…trs, R.styleable.Iconics)");
        TypedArray $receiver$iv = obtainStyledAttributes;
        IconicsDrawable extractWithOffsets = new IconicsAttrsExtractor(ctx, $receiver$iv, R.styleable.Iconics_ico_icon, R.styleable.Iconics_ico_size, R.styleable.Iconics_ico_color, R.styleable.Iconics_ico_padding, R.styleable.Iconics_ico_offset_x, R.styleable.Iconics_ico_offset_y, R.styleable.Iconics_ico_contour_color, R.styleable.Iconics_ico_contour_width, R.styleable.Iconics_ico_background_color, R.styleable.Iconics_ico_corner_radius, R.styleable.Iconics_ico_background_contour_color, R.styleable.Iconics_ico_background_contour_width, R.styleable.Iconics_ico_shadow_radius, R.styleable.Iconics_ico_shadow_dx, R.styleable.Iconics_ico_shadow_dy, R.styleable.Iconics_ico_shadow_color, R.styleable.Iconics_ico_animations, 0, 524288, (DefaultConstructorMarker) null).extractWithOffsets();
        IconicsDrawable iconicsDrawable = extractWithOffsets;
        $receiver$iv.recycle();
        return extractWithOffsets;
    }
}

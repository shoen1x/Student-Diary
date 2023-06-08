package com.mikepenz.materialdrawer.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.model.utils.BadgeDrawableBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B/\b\u0016\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u001c\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"H\u0017J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004J\u0010\u00105\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u00108\u001a\u00020\u00002\b\b\u0001\u00109\u001a\u00020\u0004J\u0010\u0010:\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0004J\u0010\u0010;\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010#\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0018J\u0010\u0010=\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\u0004J\u0010\u0010?\u001a\u00020\u00002\b\b\u0001\u0010&\u001a\u00020\u0004J\u0010\u0010@\u001a\u00020\u00002\b\b\u0001\u0010&\u001a\u00020\u0004J\u0010\u0010A\u001a\u00020\u00002\b\b\u0001\u0010&\u001a\u00020\u0004J\u0010\u0010B\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0004J\u0010\u0010C\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0004J\u0010\u0010D\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0004J\u0010\u0010E\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0004J\u0010\u0010F\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014¨\u0006I"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "", "()V", "color", "", "colorPressed", "(II)V", "gradientDrawable", "textColor", "(IIII)V", "badgeBackground", "Landroid/graphics/drawable/Drawable;", "getBadgeBackground", "()Landroid/graphics/drawable/Drawable;", "setBadgeBackground", "(Landroid/graphics/drawable/Drawable;)V", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "getColorPressed", "setColorPressed", "corners", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getCorners", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setCorners", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "getGradientDrawable", "()I", "setGradientDrawable", "(I)V", "mTextColorStateList", "Landroid/content/res/ColorStateList;", "minWidth", "getMinWidth", "setMinWidth", "paddingLeftRight", "getPaddingLeftRight", "setPaddingLeftRight", "paddingTopBottom", "getPaddingTopBottom", "setPaddingTopBottom", "getTextColor", "setTextColor", "style", "", "badgeTextView", "Landroid/widget/TextView;", "colorStateList", "withBadgeBackground", "withColor", "withColorPressed", "withColorPressedRes", "withColorRes", "withCorners", "cornersPx", "withCornersDp", "withGradientDrawable", "withMinWidth", "withPadding", "padding", "withPaddingLeftRightDp", "withPaddingLeftRightPx", "withPaddingLeftRightRes", "withPaddingTopBottomDp", "withPaddingTopBottomPx", "withPaddingTopBottomRes", "withTextColor", "withTextColorRes", "withTextColorStateList", "textColorStateList", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BadgeStyle.kt */
public class BadgeStyle {
    private Drawable badgeBackground;
    private ColorHolder color;
    private ColorHolder colorPressed;
    private DimenHolder corners;
    private int gradientDrawable = R.drawable.material_drawer_badge;
    private ColorStateList mTextColorStateList;
    private DimenHolder minWidth = DimenHolder.Companion.fromDp(20);
    private DimenHolder paddingLeftRight = DimenHolder.Companion.fromDp(3);
    private DimenHolder paddingTopBottom = DimenHolder.Companion.fromDp(2);
    private ColorHolder textColor;

    public void style(TextView textView) {
        style$default(this, textView, (ColorStateList) null, 2, (Object) null);
    }

    public final int getGradientDrawable() {
        return this.gradientDrawable;
    }

    public final void setGradientDrawable(int i) {
        this.gradientDrawable = i;
    }

    public final Drawable getBadgeBackground() {
        return this.badgeBackground;
    }

    public final void setBadgeBackground(Drawable drawable) {
        this.badgeBackground = drawable;
    }

    public final ColorHolder getColor() {
        return this.color;
    }

    public final void setColor(ColorHolder colorHolder) {
        this.color = colorHolder;
    }

    public final ColorHolder getColorPressed() {
        return this.colorPressed;
    }

    public final void setColorPressed(ColorHolder colorHolder) {
        this.colorPressed = colorHolder;
    }

    public final ColorHolder getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(ColorHolder colorHolder) {
        this.textColor = colorHolder;
    }

    public final DimenHolder getCorners() {
        return this.corners;
    }

    public final void setCorners(DimenHolder dimenHolder) {
        this.corners = dimenHolder;
    }

    public final DimenHolder getPaddingTopBottom() {
        return this.paddingTopBottom;
    }

    public final void setPaddingTopBottom(DimenHolder dimenHolder) {
        Intrinsics.checkParameterIsNotNull(dimenHolder, "<set-?>");
        this.paddingTopBottom = dimenHolder;
    }

    public final DimenHolder getPaddingLeftRight() {
        return this.paddingLeftRight;
    }

    public final void setPaddingLeftRight(DimenHolder dimenHolder) {
        Intrinsics.checkParameterIsNotNull(dimenHolder, "<set-?>");
        this.paddingLeftRight = dimenHolder;
    }

    public final DimenHolder getMinWidth() {
        return this.minWidth;
    }

    public final void setMinWidth(DimenHolder dimenHolder) {
        Intrinsics.checkParameterIsNotNull(dimenHolder, "<set-?>");
        this.minWidth = dimenHolder;
    }

    public final BadgeStyle withGradientDrawable(int gradientDrawable2) {
        this.gradientDrawable = gradientDrawable2;
        this.badgeBackground = null;
        return this;
    }

    public final BadgeStyle withBadgeBackground(Drawable badgeBackground2) {
        Intrinsics.checkParameterIsNotNull(badgeBackground2, "badgeBackground");
        this.badgeBackground = badgeBackground2;
        this.gradientDrawable = -1;
        return this;
    }

    public final BadgeStyle withColor(int color2) {
        this.color = ColorHolder.Companion.fromColor(color2);
        return this;
    }

    public final BadgeStyle withColorRes(int color2) {
        this.color = ColorHolder.Companion.fromColorRes(color2);
        return this;
    }

    public final BadgeStyle withColorPressed(int colorPressed2) {
        this.colorPressed = ColorHolder.Companion.fromColor(colorPressed2);
        return this;
    }

    public final BadgeStyle withColorPressedRes(int colorPressed2) {
        this.colorPressed = ColorHolder.Companion.fromColorRes(colorPressed2);
        return this;
    }

    public final BadgeStyle withTextColor(int textColor2) {
        this.textColor = ColorHolder.Companion.fromColor(textColor2);
        return this;
    }

    public final BadgeStyle withTextColorRes(int textColor2) {
        this.textColor = ColorHolder.Companion.fromColorRes(textColor2);
        return this;
    }

    public final BadgeStyle withTextColorStateList(ColorStateList textColorStateList) {
        Intrinsics.checkParameterIsNotNull(textColorStateList, "textColorStateList");
        this.textColor = null;
        this.mTextColorStateList = textColorStateList;
        return this;
    }

    public final BadgeStyle withCorners(int cornersPx) {
        this.corners = DimenHolder.Companion.fromPixel(cornersPx);
        return this;
    }

    public final BadgeStyle withCornersDp(int corners2) {
        this.corners = DimenHolder.Companion.fromDp(corners2);
        return this;
    }

    public final BadgeStyle withCorners(DimenHolder corners2) {
        Intrinsics.checkParameterIsNotNull(corners2, "corners");
        this.corners = corners2;
        return this;
    }

    public final BadgeStyle withPaddingLeftRightPx(int paddingLeftRight2) {
        this.paddingLeftRight = DimenHolder.Companion.fromPixel(paddingLeftRight2);
        return this;
    }

    public final BadgeStyle withPaddingLeftRightDp(int paddingLeftRight2) {
        this.paddingLeftRight = DimenHolder.Companion.fromDp(paddingLeftRight2);
        return this;
    }

    public final BadgeStyle withPaddingLeftRightRes(int paddingLeftRight2) {
        this.paddingLeftRight = DimenHolder.Companion.fromResource(paddingLeftRight2);
        return this;
    }

    public final BadgeStyle withPaddingTopBottomPx(int paddingTopBottom2) {
        this.paddingTopBottom = DimenHolder.Companion.fromPixel(paddingTopBottom2);
        return this;
    }

    public final BadgeStyle withPaddingTopBottomDp(int paddingTopBottom2) {
        this.paddingTopBottom = DimenHolder.Companion.fromDp(paddingTopBottom2);
        return this;
    }

    public final BadgeStyle withPaddingTopBottomRes(int paddingTopBottom2) {
        this.paddingTopBottom = DimenHolder.Companion.fromResource(paddingTopBottom2);
        return this;
    }

    public final BadgeStyle withPadding(int padding) {
        this.paddingLeftRight = DimenHolder.Companion.fromPixel(padding);
        this.paddingTopBottom = DimenHolder.Companion.fromPixel(padding);
        return this;
    }

    public final BadgeStyle withPadding(DimenHolder padding) {
        Intrinsics.checkParameterIsNotNull(padding, "padding");
        this.paddingLeftRight = padding;
        this.paddingTopBottom = padding;
        return this;
    }

    public final BadgeStyle withMinWidth(int minWidth2) {
        this.minWidth = DimenHolder.Companion.fromPixel(minWidth2);
        return this;
    }

    public final BadgeStyle withMinWidth(DimenHolder minWidth2) {
        Intrinsics.checkParameterIsNotNull(minWidth2, "minWidth");
        this.minWidth = minWidth2;
        return this;
    }

    public BadgeStyle() {
    }

    public BadgeStyle(int color2, int colorPressed2) {
        this.color = ColorHolder.Companion.fromColor(color2);
        this.colorPressed = ColorHolder.Companion.fromColor(colorPressed2);
    }

    public BadgeStyle(int gradientDrawable2, int color2, int colorPressed2, int textColor2) {
        this.gradientDrawable = gradientDrawable2;
        this.color = ColorHolder.Companion.fromColor(color2);
        this.colorPressed = ColorHolder.Companion.fromColor(colorPressed2);
        this.textColor = ColorHolder.Companion.fromColor(textColor2);
    }

    public static /* synthetic */ void style$default(BadgeStyle badgeStyle, TextView textView, ColorStateList colorStateList, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                colorStateList = null;
            }
            badgeStyle.style(textView, colorStateList);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: style");
    }

    public void style(TextView badgeTextView, ColorStateList colorStateList) {
        Intrinsics.checkParameterIsNotNull(badgeTextView, "badgeTextView");
        Context ctx = badgeTextView.getContext();
        Drawable drawable = this.badgeBackground;
        if (drawable == null) {
            BadgeDrawableBuilder badgeDrawableBuilder = new BadgeDrawableBuilder(this);
            Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
            ViewCompat.setBackground(badgeTextView, badgeDrawableBuilder.build(ctx));
        } else {
            ViewCompat.setBackground(badgeTextView, drawable);
        }
        ColorHolder colorHolder = this.textColor;
        if (colorHolder == null) {
            ColorStateList colorStateList2 = this.mTextColorStateList;
            if (colorStateList2 != null) {
                badgeTextView.setTextColor(colorStateList2);
            } else if (colorStateList != null) {
                badgeTextView.setTextColor(colorStateList);
            }
        } else if (colorHolder != null) {
            colorHolder.applyToOr(badgeTextView, (ColorStateList) null);
        }
        int paddingLeftRight2 = this.paddingLeftRight.asPixel(ctx);
        int paddingTopBottom2 = this.paddingTopBottom.asPixel(ctx);
        badgeTextView.setPadding(paddingLeftRight2, paddingTopBottom2, paddingLeftRight2, paddingTopBottom2);
        badgeTextView.setMinWidth(this.minWidth.asPixel(ctx));
    }
}

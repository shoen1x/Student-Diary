package com.mikepenz.iconics;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R&\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/mikepenz/iconics/IconicsBrush;", "T", "Landroid/graphics/Paint;", "", "paint", "(Landroid/graphics/Paint;)V", "alpha", "", "getAlpha", "()I", "setAlpha", "(I)V", "colorForCurrentState", "getColorForCurrentState", "colorsList", "Landroid/content/res/ColorStateList;", "getColorsList", "()Landroid/content/res/ColorStateList;", "setColorsList", "(Landroid/content/res/ColorStateList;)V", "isStateful", "", "()Z", "getPaint", "()Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "state", "", "applyState", "defaultColor", "toString", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsBrush.kt */
public final class IconicsBrush<T extends Paint> {
    private ColorStateList colorsList;
    private final T paint;
    private int[] state;

    public IconicsBrush(T paint2) {
        Intrinsics.checkParameterIsNotNull(paint2, "paint");
        this.paint = paint2;
        paint2.setAlpha(255);
    }

    public final T getPaint() {
        return this.paint;
    }

    public final ColorStateList getColorsList() {
        return this.colorsList;
    }

    public final void setColorsList(ColorStateList colorStateList) {
        this.colorsList = colorStateList;
    }

    public final int getAlpha() {
        return this.paint.getAlpha();
    }

    public final void setAlpha(int alpha) {
        if (this.paint.getAlpha() != alpha) {
            this.paint.setAlpha(alpha);
        }
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.colorsList;
        return colorStateList != null && colorStateList.isStateful();
    }

    public final int getColorForCurrentState() {
        ColorStateList colorStateList = this.colorsList;
        return getColorForCurrentState(colorStateList != null ? colorStateList.getDefaultColor() : 0);
    }

    private final int getColorForCurrentState(int defaultColor) {
        ColorStateList colorStateList = this.colorsList;
        return colorStateList != null ? colorStateList.getColorForState(this.state, defaultColor) : defaultColor;
    }

    public final boolean applyState(int[] state2) {
        this.state = state2;
        int colorForState = getColorForCurrentState();
        int oldColor = this.paint.getColor();
        this.paint.setColor(colorForState);
        return this.paint.getColor() != oldColor;
    }

    public String toString() {
        return "color=#" + Integer.toHexString(this.paint.getColor()) + ", state=" + this.state + ", colorList=" + this.colorsList;
    }
}

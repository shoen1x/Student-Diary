package com.mikepenz.materialdrawer.model.utils;

import com.mikepenz.materialdrawer.holder.BadgeStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/model/utils/BadgeDrawableBuilder;", "", "mStyle", "Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "(Lcom/mikepenz/materialdrawer/holder/BadgeStyle;)V", "build", "Landroid/graphics/drawable/StateListDrawable;", "ctx", "Landroid/content/Context;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BadgeDrawableBuilder.kt */
public final class BadgeDrawableBuilder {
    private final BadgeStyle mStyle;

    public BadgeDrawableBuilder(BadgeStyle mStyle2) {
        Intrinsics.checkParameterIsNotNull(mStyle2, "mStyle");
        this.mStyle = mStyle2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r2 = (r2 = r1.getConstantState()).newDrawable();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.StateListDrawable build(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            android.graphics.drawable.StateListDrawable r0 = new android.graphics.drawable.StateListDrawable
            r0.<init>()
            com.mikepenz.materialdrawer.holder.BadgeStyle r1 = r6.mStyle
            int r1 = r1.getGradientDrawable()
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r7, r1)
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            if (r1 == 0) goto L_0x0029
            android.graphics.drawable.Drawable$ConstantState r2 = r1.getConstantState()
            if (r2 == 0) goto L_0x0029
            android.graphics.drawable.Drawable r2 = r2.newDrawable()
            if (r2 == 0) goto L_0x0029
            android.graphics.drawable.Drawable r2 = r2.mutate()
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
            com.mikepenz.materialdrawer.holder.BadgeStyle r3 = r6.mStyle
            com.mikepenz.materialdrawer.holder.ColorHolder r3 = r3.getColor()
            com.mikepenz.materialize.holder.ColorHolder r3 = (com.mikepenz.materialize.holder.ColorHolder) r3
            com.mikepenz.materialize.holder.ColorHolder.applyToOrTransparent(r3, r7, r1)
            com.mikepenz.materialdrawer.holder.BadgeStyle r3 = r6.mStyle
            com.mikepenz.materialdrawer.holder.ColorHolder r3 = r3.getColorPressed()
            if (r3 != 0) goto L_0x004b
            com.mikepenz.materialdrawer.holder.BadgeStyle r3 = r6.mStyle
            com.mikepenz.materialdrawer.holder.ColorHolder r3 = r3.getColor()
            com.mikepenz.materialize.holder.ColorHolder r3 = (com.mikepenz.materialize.holder.ColorHolder) r3
            com.mikepenz.materialize.holder.ColorHolder.applyToOrTransparent(r3, r7, r2)
            goto L_0x0056
        L_0x004b:
            com.mikepenz.materialdrawer.holder.BadgeStyle r3 = r6.mStyle
            com.mikepenz.materialdrawer.holder.ColorHolder r3 = r3.getColorPressed()
            com.mikepenz.materialize.holder.ColorHolder r3 = (com.mikepenz.materialize.holder.ColorHolder) r3
            com.mikepenz.materialize.holder.ColorHolder.applyToOrTransparent(r3, r7, r2)
        L_0x0056:
            com.mikepenz.materialdrawer.holder.BadgeStyle r3 = r6.mStyle
            com.mikepenz.materialdrawer.holder.DimenHolder r3 = r3.getCorners()
            if (r3 == 0) goto L_0x0076
            r4 = 0
            if (r1 == 0) goto L_0x006a
            int r5 = r3.asPixel(r7)
            float r5 = (float) r5
            r1.setCornerRadius(r5)
        L_0x006a:
            if (r2 == 0) goto L_0x0074
            int r5 = r3.asPixel(r7)
            float r5 = (float) r5
            r2.setCornerRadius(r5)
        L_0x0074:
        L_0x0076:
            r3 = 1
            int[] r3 = new int[r3]
            r4 = 0
            r5 = 16842919(0x10100a7, float:2.3694026E-38)
            r3[r4] = r5
            r4 = r2
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r0.addState(r3, r4)
            int[] r3 = android.util.StateSet.WILD_CARD
            r4 = r1
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r0.addState(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.model.utils.BadgeDrawableBuilder.build(android.content.Context):android.graphics.drawable.StateListDrawable");
    }
}

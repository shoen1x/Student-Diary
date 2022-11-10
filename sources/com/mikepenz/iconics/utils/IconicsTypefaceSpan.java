package com.mikepenz.iconics.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "family", "", "newType", "Landroid/graphics/Typeface;", "(Ljava/lang/String;Landroid/graphics/Typeface;)V", "applyCustomTypeFace", "", "paint", "Landroid/graphics/Paint;", "tf", "updateDrawState", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsTypefaceSpan.kt */
public final class IconicsTypefaceSpan extends TypefaceSpan {
    private final Typeface newType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsTypefaceSpan(String family, Typeface newType2) {
        super(family);
        Intrinsics.checkParameterIsNotNull(family, "family");
        Intrinsics.checkParameterIsNotNull(newType2, "newType");
        this.newType = newType2;
    }

    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkParameterIsNotNull(ds, "ds");
        applyCustomTypeFace(ds, this.newType);
    }

    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        applyCustomTypeFace(paint, this.newType);
    }

    private final void applyCustomTypeFace(Paint paint, Typeface tf) {
        Typeface old = paint.getTypeface();
        int fake = (~tf.getStyle()) & (old != null ? old.getStyle() : 0);
        if ((fake & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(tf);
    }
}

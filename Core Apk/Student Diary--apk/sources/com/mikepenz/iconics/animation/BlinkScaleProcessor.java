package com.mikepenz.iconics.animation;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import com.mikepenz.iconics.IconicsBrush;
import com.mikepenz.iconics.animation.IconicsAnimationProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 92\u00020\u0001:\u00019BK\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016JH\u00101\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\f\u00105\u001a\b\u0012\u0004\u0012\u000206032\f\u00107\u001a\b\u0012\u0004\u0012\u000206032\f\u00108\u001a\b\u0012\u0004\u0012\u00020603H\u0016R\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/mikepenz/iconics/animation/BlinkScaleProcessor;", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "minimumScale", "", "maximumScale", "interpolator", "Landroid/animation/TimeInterpolator;", "duration", "", "repeatCount", "", "repeatMode", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "isStartImmediately", "", "(FFLandroid/animation/TimeInterpolator;JILcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;Z)V", "animationTag", "", "getAnimationTag", "()Ljava/lang/String;", "getDuration", "()J", "setDuration", "(J)V", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "setInterpolator", "(Landroid/animation/TimeInterpolator;)V", "()Z", "setStartImmediately", "(Z)V", "getMaximumScale", "()F", "setMaximumScale", "(F)V", "getMinimumScale", "setMinimumScale", "getRepeatCount", "()I", "setRepeatCount", "(I)V", "getRepeatMode", "()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "setRepeatMode", "(Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;)V", "processPostDraw", "", "canvas", "Landroid/graphics/Canvas;", "processPreDraw", "iconBrush", "Lcom/mikepenz/iconics/IconicsBrush;", "Landroid/text/TextPaint;", "iconContourBrush", "Landroid/graphics/Paint;", "backgroundBrush", "backgroundContourBrush", "Companion", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: BlinkScaleProcessor.kt */
public class BlinkScaleProcessor extends IconicsAnimationProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static long DEFAULT_DURATION = 500;
    private final String animationTag;
    private long duration;
    private TimeInterpolator interpolator;
    private boolean isStartImmediately;
    private float maximumScale;
    private float minimumScale;
    private int repeatCount;
    private IconicsAnimationProcessor.RepeatMode repeatMode;

    public BlinkScaleProcessor() {
        this(0.0f, 0.0f, (TimeInterpolator) null, 0, 0, (IconicsAnimationProcessor.RepeatMode) null, false, 127, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlinkScaleProcessor(float minimumScale2, float maximumScale2, TimeInterpolator interpolator2, long duration2, int repeatCount2, IconicsAnimationProcessor.RepeatMode repeatMode2, boolean isStartImmediately2) {
        super(interpolator2, duration2, repeatCount2, repeatMode2, isStartImmediately2);
        Intrinsics.checkParameterIsNotNull(interpolator2, "interpolator");
        Intrinsics.checkParameterIsNotNull(repeatMode2, "repeatMode");
        this.minimumScale = minimumScale2;
        this.maximumScale = maximumScale2;
        this.interpolator = interpolator2;
        this.duration = duration2;
        this.repeatCount = repeatCount2;
        this.repeatMode = repeatMode2;
        this.isStartImmediately = isStartImmediately2;
        this.animationTag = "blink_scale";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BlinkScaleProcessor(float r9, float r10, android.animation.TimeInterpolator r11, long r12, int r14, com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode r15, boolean r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r9
        L_0x0007:
            r1 = r17 & 2
            if (r1 == 0) goto L_0x000e
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x000f
        L_0x000e:
            r1 = r10
        L_0x000f:
            r2 = r17 & 4
            if (r2 == 0) goto L_0x0018
            android.view.animation.LinearInterpolator r2 = com.mikepenz.iconics.animation.IconicsAnimationProcessor.DEFAULT_INTERPOLATOR
            android.animation.TimeInterpolator r2 = (android.animation.TimeInterpolator) r2
            goto L_0x0019
        L_0x0018:
            r2 = r11
        L_0x0019:
            r3 = r17 & 8
            if (r3 == 0) goto L_0x0020
            long r3 = DEFAULT_DURATION
            goto L_0x0021
        L_0x0020:
            r3 = r12
        L_0x0021:
            r5 = r17 & 16
            if (r5 == 0) goto L_0x0027
            r5 = -1
            goto L_0x0028
        L_0x0027:
            r5 = r14
        L_0x0028:
            r6 = r17 & 32
            if (r6 == 0) goto L_0x002f
            com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode r6 = com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode.REVERSE
            goto L_0x0030
        L_0x002f:
            r6 = r15
        L_0x0030:
            r7 = r17 & 64
            if (r7 == 0) goto L_0x0036
            r7 = 1
            goto L_0x0038
        L_0x0036:
            r7 = r16
        L_0x0038:
            r9 = r8
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r9.<init>(r10, r11, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.animation.BlinkScaleProcessor.<init>(float, float, android.animation.TimeInterpolator, long, int, com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public float getMinimumScale() {
        return this.minimumScale;
    }

    public void setMinimumScale(float f) {
        this.minimumScale = f;
    }

    public float getMaximumScale() {
        return this.maximumScale;
    }

    public void setMaximumScale(float f) {
        this.maximumScale = f;
    }

    public TimeInterpolator getInterpolator() {
        return this.interpolator;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        Intrinsics.checkParameterIsNotNull(timeInterpolator, "<set-?>");
        this.interpolator = timeInterpolator;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(int i) {
        this.repeatCount = i;
    }

    public IconicsAnimationProcessor.RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public void setRepeatMode(IconicsAnimationProcessor.RepeatMode repeatMode2) {
        Intrinsics.checkParameterIsNotNull(repeatMode2, "<set-?>");
        this.repeatMode = repeatMode2;
    }

    public boolean isStartImmediately() {
        return this.isStartImmediately;
    }

    public void setStartImmediately(boolean z) {
        this.isStartImmediately = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mikepenz/iconics/animation/BlinkScaleProcessor$Companion;", "", "()V", "DEFAULT_DURATION", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: BlinkScaleProcessor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public String getAnimationTag() {
        return this.animationTag;
    }

    public void processPreDraw(Canvas canvas, IconicsBrush<TextPaint> iconBrush, IconicsBrush<Paint> iconContourBrush, IconicsBrush<Paint> backgroundBrush, IconicsBrush<Paint> backgroundContourBrush) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(iconBrush, "iconBrush");
        Intrinsics.checkParameterIsNotNull(iconContourBrush, "iconContourBrush");
        Intrinsics.checkParameterIsNotNull(backgroundBrush, "backgroundBrush");
        Intrinsics.checkParameterIsNotNull(backgroundContourBrush, "backgroundContourBrush");
        float scale = getAnimatedPercent() * ((getMaximumScale() - getMinimumScale()) / ((float) 100));
        Rect bounds = getDrawableBounds();
        if (bounds != null) {
            Rect it = bounds;
            canvas.save();
            canvas.scale(scale, scale, (float) (it.width() / 2), (float) (it.height() / 2));
        }
    }

    public void processPostDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.restore();
    }
}

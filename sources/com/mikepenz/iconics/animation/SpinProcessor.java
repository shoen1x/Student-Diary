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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 82\u00020\u0001:\u000289BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0016JH\u00100\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\f\u00104\u001a\b\u0012\u0004\u0012\u000205022\f\u00106\u001a\b\u0012\u0004\u0012\u000205022\f\u00107\u001a\b\u0012\u0004\u0012\u00020502H\u0016R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006:"}, d2 = {"Lcom/mikepenz/iconics/animation/SpinProcessor;", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "direction", "Lcom/mikepenz/iconics/animation/SpinProcessor$Direction;", "interpolator", "Landroid/animation/TimeInterpolator;", "duration", "", "repeatCount", "", "repeatMode", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "isStartImmediately", "", "(Lcom/mikepenz/iconics/animation/SpinProcessor$Direction;Landroid/animation/TimeInterpolator;JILcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;Z)V", "animationTag", "", "getAnimationTag", "()Ljava/lang/String;", "getDirection", "()Lcom/mikepenz/iconics/animation/SpinProcessor$Direction;", "setDirection", "(Lcom/mikepenz/iconics/animation/SpinProcessor$Direction;)V", "getDuration", "()J", "setDuration", "(J)V", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "setInterpolator", "(Landroid/animation/TimeInterpolator;)V", "isDrawableShadowCleared", "()Z", "setStartImmediately", "(Z)V", "getRepeatCount", "()I", "setRepeatCount", "(I)V", "getRepeatMode", "()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "setRepeatMode", "(Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;)V", "onDrawableDetached", "", "processPostDraw", "canvas", "Landroid/graphics/Canvas;", "processPreDraw", "iconBrush", "Lcom/mikepenz/iconics/IconicsBrush;", "Landroid/text/TextPaint;", "iconContourBrush", "Landroid/graphics/Paint;", "backgroundBrush", "backgroundContourBrush", "Companion", "Direction", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: SpinProcessor.kt */
public class SpinProcessor extends IconicsAnimationProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static long DEFAULT_DURATION = 2000;
    private final String animationTag;
    private Direction direction;
    private long duration;
    private TimeInterpolator interpolator;
    private boolean isDrawableShadowCleared;
    private boolean isStartImmediately;
    private int repeatCount;
    private IconicsAnimationProcessor.RepeatMode repeatMode;

    public SpinProcessor() {
        this((Direction) null, (TimeInterpolator) null, 0, 0, (IconicsAnimationProcessor.RepeatMode) null, false, 63, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpinProcessor(Direction direction2, TimeInterpolator interpolator2, long duration2, int repeatCount2, IconicsAnimationProcessor.RepeatMode repeatMode2, boolean isStartImmediately2) {
        super(interpolator2, duration2, repeatCount2, repeatMode2, isStartImmediately2);
        Intrinsics.checkParameterIsNotNull(direction2, "direction");
        Intrinsics.checkParameterIsNotNull(interpolator2, "interpolator");
        Intrinsics.checkParameterIsNotNull(repeatMode2, "repeatMode");
        this.direction = direction2;
        this.interpolator = interpolator2;
        this.duration = duration2;
        this.repeatCount = repeatCount2;
        this.repeatMode = repeatMode2;
        this.isStartImmediately = isStartImmediately2;
        this.animationTag = "spin";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpinProcessor(com.mikepenz.iconics.animation.SpinProcessor.Direction r6, android.animation.TimeInterpolator r7, long r8, int r10, com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0006
            com.mikepenz.iconics.animation.SpinProcessor$Direction r6 = com.mikepenz.iconics.animation.SpinProcessor.Direction.CLOCKWISE
        L_0x0006:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0010
            android.view.animation.LinearInterpolator r7 = com.mikepenz.iconics.animation.IconicsAnimationProcessor.DEFAULT_INTERPOLATOR
            android.animation.TimeInterpolator r7 = (android.animation.TimeInterpolator) r7
            r14 = r7
            goto L_0x0011
        L_0x0010:
            r14 = r7
        L_0x0011:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0019
            long r8 = DEFAULT_DURATION
            r0 = r8
            goto L_0x001a
        L_0x0019:
            r0 = r8
        L_0x001a:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0021
            r10 = -1
            r2 = r10
            goto L_0x0022
        L_0x0021:
            r2 = r10
        L_0x0022:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x002a
            com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode r11 = com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode.RESTART
            r3 = r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0032
            r12 = 1
            r4 = r12
            goto L_0x0033
        L_0x0032:
            r4 = r12
        L_0x0033:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.animation.SpinProcessor.<init>(com.mikepenz.iconics.animation.SpinProcessor$Direction, android.animation.TimeInterpolator, long, int, com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction2) {
        Intrinsics.checkParameterIsNotNull(direction2, "<set-?>");
        this.direction = direction2;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mikepenz/iconics/animation/SpinProcessor$Companion;", "", "()V", "DEFAULT_DURATION", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: SpinProcessor.kt */
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
        if (!this.isDrawableShadowCleared) {
            iconBrush.getPaint().clearShadowLayer();
            this.isDrawableShadowCleared = true;
        }
        canvas.save();
        Rect bounds = getDrawableBounds();
        float degrees = getAnimatedPercent() * 3.6f * ((float) getDirection().getSign$iconics_core());
        if (bounds != null) {
            Rect it = bounds;
            canvas.rotate(degrees, (float) (it.width() / 2), (float) (it.height() / 2));
        }
    }

    public void processPostDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDrawableDetached() {
        this.isDrawableShadowCleared = false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/mikepenz/iconics/animation/SpinProcessor$Direction;", "", "sign", "", "(Ljava/lang/String;II)V", "getSign$iconics_core", "()I", "CLOCKWISE", "COUNTER_CLOCKWISE", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: SpinProcessor.kt */
    public enum Direction {
        CLOCKWISE(1),
        COUNTER_CLOCKWISE(-1);
        
        private final int sign;

        private Direction(int sign2) {
            this.sign = sign2;
        }

        public final int getSign$iconics_core() {
            return this.sign;
        }
    }
}

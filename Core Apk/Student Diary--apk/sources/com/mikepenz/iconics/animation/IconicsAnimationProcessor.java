package com.mikepenz.iconics.animation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mikepenz.iconics.IconicsBrush;
import com.mikepenz.iconics.animation.IconicsAnimationProcessor$proxyPauseListener$2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r*\u000269\b&\u0018\u0000 b2\u00020\u0001:\u0002bcB7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u000202J\u0010\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u000204H\u0007J\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020JJ\b\u0010L\u001a\u00020JH\u0004J\b\u0010M\u001a\u00020JH\u0014J\b\u0010N\u001a\u00020JH\u0007J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0016JH\u0010R\u001a\u00020J2\u0006\u0010P\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020W0T2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020W0T2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0TH\u0016J\u0006\u0010Z\u001a\u00020JJ\u000e\u0010[\u001a\u00020J2\u0006\u0010G\u001a\u000202J\u0010\u0010\\\u001a\u00020J2\u0006\u0010G\u001a\u000204H\u0007J\b\u0010]\u001a\u00020JH\u0007J\u0006\u0010^\u001a\u00020JJ\u0017\u0010_\u001a\u00020J2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b`J\u0006\u0010a\u001a\u00020\u0000R\u0014\u0010\r\u001a\u00020\u000e8EX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b+\u0010*R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010*\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u000206X\u0004¢\u0006\u0004\n\u0002\u00107R\u001b\u00108\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006d"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "", "interpolator", "Landroid/animation/TimeInterpolator;", "duration", "", "repeatCount", "", "repeatMode", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "isStartImmediately", "", "(Landroid/animation/TimeInterpolator;JILcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;Z)V", "animatedPercent", "", "getAnimatedPercent", "()F", "animationTag", "", "getAnimationTag", "()Ljava/lang/String;", "animator", "Landroid/animation/ValueAnimator;", "drawable", "Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable;", "drawableBounds", "Landroid/graphics/Rect;", "getDrawableBounds", "()Landroid/graphics/Rect;", "drawableState", "", "getDrawableState", "()[I", "getDuration", "()J", "setDuration", "(J)V", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "setInterpolator", "(Landroid/animation/TimeInterpolator;)V", "isPaused", "()Z", "isRunning", "setStartImmediately", "(Z)V", "isStartRequested", "isStarted", "listeners", "", "Lcom/mikepenz/iconics/animation/IconicsAnimationListener;", "pauseListeners", "Lcom/mikepenz/iconics/animation/IconicsAnimationPauseListener;", "proxyListener", "com/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyListener$1", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyListener$1;", "proxyPauseListener", "com/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyPauseListener$2$1", "getProxyPauseListener", "()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyPauseListener$2$1;", "proxyPauseListener$delegate", "Lkotlin/Lazy;", "getRepeatCount", "()I", "setRepeatCount", "(I)V", "getRepeatMode", "()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "setRepeatMode", "(Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;)V", "addListener", "listener", "addPauseListener", "cancel", "", "end", "onDrawableAttached", "onDrawableDetached", "pause", "processPostDraw", "canvas", "Landroid/graphics/Canvas;", "processPreDraw", "iconBrush", "Lcom/mikepenz/iconics/IconicsBrush;", "Landroid/text/TextPaint;", "iconContourBrush", "Landroid/graphics/Paint;", "backgroundBrush", "backgroundContourBrush", "removeAllListeners", "removeListener", "removePauseListener", "resume", "reverse", "setDrawable", "setDrawable$iconics_core", "start", "Companion", "RepeatMode", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimationProcessor.kt */
public abstract class IconicsAnimationProcessor {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IconicsAnimationProcessor.class), "proxyPauseListener", "getProxyPauseListener()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyPauseListener$2$1;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final LinearInterpolator DEFAULT_INTERPOLATOR = new LinearInterpolator();
    public static final int INFINITE = -1;
    private final ValueAnimator animator;
    private IconicsAnimatedDrawable drawable;
    private long duration;
    private TimeInterpolator interpolator;
    private boolean isStartImmediately;
    private boolean isStartRequested;
    /* access modifiers changed from: private */
    public List<IconicsAnimationListener> listeners;
    /* access modifiers changed from: private */
    public List<IconicsAnimationPauseListener> pauseListeners;
    private final IconicsAnimationProcessor$proxyListener$1 proxyListener;
    private final Lazy proxyPauseListener$delegate;
    private int repeatCount;
    private RepeatMode repeatMode;

    public IconicsAnimationProcessor() {
        this((TimeInterpolator) null, 0, 0, (RepeatMode) null, false, 31, (DefaultConstructorMarker) null);
    }

    private final IconicsAnimationProcessor$proxyPauseListener$2.AnonymousClass1 getProxyPauseListener() {
        Lazy lazy = this.proxyPauseListener$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (IconicsAnimationProcessor$proxyPauseListener$2.AnonymousClass1) lazy.getValue();
    }

    public abstract String getAnimationTag();

    public IconicsAnimationProcessor(TimeInterpolator interpolator2, long duration2, int repeatCount2, RepeatMode repeatMode2, boolean isStartImmediately2) {
        Intrinsics.checkParameterIsNotNull(interpolator2, "interpolator");
        Intrinsics.checkParameterIsNotNull(repeatMode2, "repeatMode");
        this.interpolator = interpolator2;
        this.duration = duration2;
        this.repeatCount = repeatCount2;
        this.repeatMode = repeatMode2;
        this.isStartImmediately = isStartImmediately2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ValueAnimator.ofFloat(0f, 100f)");
        this.animator = ofFloat;
        this.proxyListener = new IconicsAnimationProcessor$proxyListener$1(this);
        this.proxyPauseListener$delegate = LazyKt.lazy(new IconicsAnimationProcessor$proxyPauseListener$2(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IconicsAnimationProcessor(android.animation.TimeInterpolator r5, long r6, int r8, com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0008
            android.view.animation.LinearInterpolator r5 = DEFAULT_INTERPOLATOR
            android.animation.TimeInterpolator r5 = (android.animation.TimeInterpolator) r5
        L_0x0008:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0010
            r6 = 300(0x12c, double:1.48E-321)
            r0 = r6
            goto L_0x0011
        L_0x0010:
            r0 = r6
        L_0x0011:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0018
            r8 = -1
            r12 = r8
            goto L_0x0019
        L_0x0018:
            r12 = r8
        L_0x0019:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0021
            com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode r9 = com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode.RESTART
            r2 = r9
            goto L_0x0022
        L_0x0021:
            r2 = r9
        L_0x0022:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0029
            r10 = 1
            r3 = r10
            goto L_0x002a
        L_0x0029:
            r3 = r10
        L_0x002a:
            r6 = r4
            r7 = r5
            r8 = r0
            r10 = r12
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.animation.IconicsAnimationProcessor.<init>(android.animation.TimeInterpolator, long, int, com.mikepenz.iconics.animation.IconicsAnimationProcessor$RepeatMode, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public void setRepeatMode(RepeatMode repeatMode2) {
        Intrinsics.checkParameterIsNotNull(repeatMode2, "<set-?>");
        this.repeatMode = repeatMode2;
    }

    public boolean isStartImmediately() {
        return this.isStartImmediately;
    }

    public void setStartImmediately(boolean z) {
        this.isStartImmediately = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$Companion;", "", "()V", "DEFAULT_INTERPOLATOR", "Landroid/view/animation/LinearInterpolator;", "INFINITE", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsAnimationProcessor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final boolean isStarted() {
        return this.animator.isStarted();
    }

    public final boolean isRunning() {
        return this.animator.isRunning();
    }

    public final boolean isPaused() {
        return this.animator.isPaused();
    }

    /* access modifiers changed from: protected */
    public final int[] getDrawableState() {
        IconicsAnimatedDrawable iconicsAnimatedDrawable = this.drawable;
        if (iconicsAnimatedDrawable != null) {
            return iconicsAnimatedDrawable.getState();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final Rect getDrawableBounds() {
        IconicsAnimatedDrawable iconicsAnimatedDrawable = this.drawable;
        if (iconicsAnimatedDrawable != null) {
            return iconicsAnimatedDrawable.getBounds();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final float getAnimatedPercent() {
        Object animatedValue = this.animator.getAnimatedValue();
        if (animatedValue != null) {
            return ((Float) animatedValue).floatValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }

    public final IconicsAnimationProcessor start() {
        this.animator.setInterpolator(getInterpolator());
        this.animator.setDuration(getDuration());
        this.animator.setRepeatCount(getRepeatCount());
        this.animator.setRepeatMode(getRepeatMode().getValueAnimatorConst$iconics_core());
        if (this.drawable != null) {
            this.isStartRequested = false;
            this.animator.start();
        } else {
            this.isStartRequested = true;
        }
        return this;
    }

    public final IconicsAnimationProcessor addListener(IconicsAnimationListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.listeners == null) {
            this.listeners = new ArrayList();
            this.animator.addListener(this.proxyListener);
        }
        List<IconicsAnimationListener> list = this.listeners;
        if (list != null) {
            list.add(listener);
        }
        return this;
    }

    public final void removeListener(IconicsAnimationListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List<IconicsAnimationListener> list = this.listeners;
        if (list != null) {
            list.remove(listener);
        }
        List<IconicsAnimationListener> list2 = this.listeners;
        if (list2 != null && list2.size() == 0) {
            this.listeners = null;
            this.animator.removeListener(this.proxyListener);
        }
    }

    public final IconicsAnimationProcessor addPauseListener(IconicsAnimationPauseListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.pauseListeners == null) {
            this.pauseListeners = new ArrayList();
            this.animator.addPauseListener(getProxyPauseListener());
        }
        List<IconicsAnimationPauseListener> list = this.pauseListeners;
        if (list != null) {
            list.add(listener);
        }
        return this;
    }

    public final void removePauseListener(IconicsAnimationPauseListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List<IconicsAnimationPauseListener> list = this.pauseListeners;
        if (list != null) {
            list.remove(listener);
        }
        List<IconicsAnimationPauseListener> list2 = this.pauseListeners;
        if (list2 != null && list2.size() == 0) {
            this.pauseListeners = null;
            this.animator.removePauseListener(getProxyPauseListener());
        }
    }

    public final void removeAllListeners() {
        List<IconicsAnimationPauseListener> list;
        List<IconicsAnimationListener> list2 = this.listeners;
        if (list2 != null) {
            if (list2 != null) {
                list2.clear();
            }
            this.listeners = null;
            this.animator.removeListener(this.proxyListener);
        }
        if (Build.VERSION.SDK_INT >= 19 && (list = this.pauseListeners) != null) {
            if (list != null) {
                list.clear();
            }
            this.pauseListeners = null;
            this.animator.removePauseListener(getProxyPauseListener());
        }
    }

    public final void cancel() {
        this.animator.cancel();
    }

    public final void end() {
        this.animator.end();
    }

    public final void reverse() {
        this.animator.reverse();
    }

    public final void pause() {
        this.animator.pause();
    }

    public final void resume() {
        this.animator.resume();
    }

    public void processPreDraw(Canvas canvas, IconicsBrush<TextPaint> iconBrush, IconicsBrush<Paint> iconContourBrush, IconicsBrush<Paint> backgroundBrush, IconicsBrush<Paint> backgroundContourBrush) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(iconBrush, "iconBrush");
        Intrinsics.checkParameterIsNotNull(iconContourBrush, "iconContourBrush");
        Intrinsics.checkParameterIsNotNull(backgroundBrush, "backgroundBrush");
        Intrinsics.checkParameterIsNotNull(backgroundContourBrush, "backgroundContourBrush");
    }

    public void processPostDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
    }

    /* access modifiers changed from: protected */
    public final void onDrawableAttached() {
    }

    /* access modifiers changed from: protected */
    public void onDrawableDetached() {
    }

    public final void setDrawable$iconics_core(IconicsAnimatedDrawable drawable2) {
        if (this.drawable != null) {
            this.drawable = null;
            onDrawableDetached();
        }
        this.drawable = drawable2;
        if (drawable2 != null) {
            onDrawableAttached();
            if (isStartImmediately() || this.isStartRequested) {
                start();
                return;
            }
            return;
        }
        this.animator.cancel();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$RepeatMode;", "", "valueAnimatorConst", "", "(Ljava/lang/String;II)V", "getValueAnimatorConst$iconics_core", "()I", "RESTART", "REVERSE", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsAnimationProcessor.kt */
    public enum RepeatMode {
        RESTART(1),
        REVERSE(2);
        
        private final int valueAnimatorConst;

        private RepeatMode(int valueAnimatorConst2) {
            this.valueAnimatorConst = valueAnimatorConst2;
        }

        public final int getValueAnimatorConst$iconics_core() {
            return this.valueAnimatorConst;
        }
    }
}

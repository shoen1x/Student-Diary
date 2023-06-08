package com.mikepenz.iconics.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0011J\u001f\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u001b\"\u00020\u0011¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable;", "Lcom/mikepenz/iconics/IconicsDrawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "icon", "", "(Landroid/content/Context;C)V", "", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Landroid/content/Context;Lcom/mikepenz/iconics/typeface/IIcon;)V", "typeface", "Lcom/mikepenz/iconics/typeface/ITypeface;", "(Landroid/content/Context;Lcom/mikepenz/iconics/typeface/ITypeface;Lcom/mikepenz/iconics/typeface/IIcon;)V", "processors", "Ljava/util/ArrayList;", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "animateIn", "Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner;", "view", "Landroid/view/View;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "processor", "", "([Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;)Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable;", "Runner", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimatedDrawable.kt */
public class IconicsAnimatedDrawable extends IconicsDrawable {
    private final ArrayList<IconicsAnimationProcessor> processors = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsAnimatedDrawable(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsAnimatedDrawable(Context context, char icon) {
        super(context, icon);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsAnimatedDrawable(Context context, String icon) {
        super(context, icon);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(icon, "icon");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsAnimatedDrawable(Context context, IIcon icon) {
        super(context, icon);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(icon, "icon");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected IconicsAnimatedDrawable(Context context, ITypeface typeface, IIcon icon) {
        super(context, typeface, icon);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        Intrinsics.checkParameterIsNotNull(icon, "icon");
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        for (IconicsAnimationProcessor processPreDraw : this.processors) {
            processPreDraw.processPreDraw(canvas, getIconBrush(), getContourBrush(), getBackgroundBrush(), getBackgroundContourBrush());
        }
        super.draw(canvas);
        for (IconicsAnimationProcessor it : CollectionsKt.reversed(this.processors)) {
            it.processPostDraw(canvas);
        }
    }

    public final IconicsAnimatedDrawable processor(IconicsAnimationProcessor processor) {
        Intrinsics.checkParameterIsNotNull(processor, "processor");
        processor.setDrawable$iconics_core(this);
        this.processors.add(processor);
        return this;
    }

    public final IconicsAnimatedDrawable processors(IconicsAnimationProcessor... processors2) {
        Intrinsics.checkParameterIsNotNull(processors2, "processors");
        if (processors2.length == 0) {
            return this;
        }
        for (IconicsAnimationProcessor it : processors2) {
            processor(it);
        }
        return this;
    }

    public final Runner animateIn(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Runner it = new Runner();
        it.setFor(view, this);
        return it;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\b\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner;", "", "()V", "drawable", "Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable;", "isAttached", "", "listener", "com/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner$listener$1", "Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner$listener$1;", "view", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "setFor", "", "unset", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsAnimatedDrawable.kt */
    public static final class Runner {
        /* access modifiers changed from: private */
        public IconicsAnimatedDrawable drawable;
        /* access modifiers changed from: private */
        public boolean isAttached;
        private final IconicsAnimatedDrawable$Runner$listener$1 listener = new IconicsAnimatedDrawable$Runner$listener$1(this);
        /* access modifiers changed from: private */
        public WeakReference<View> view;

        public final void setFor(View view2, IconicsAnimatedDrawable drawable2) {
            Intrinsics.checkParameterIsNotNull(view2, "view");
            Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
            unset();
            this.view = new WeakReference<>(view2);
            this.drawable = drawable2;
            if (ViewCompat.isAttachedToWindow(view2)) {
                this.listener.onViewAttachedToWindow(view2);
            }
            view2.addOnAttachStateChangeListener(this.listener);
        }

        public final void unset() {
            this.drawable = null;
            WeakReference it = this.view;
            if (it != null) {
                View view2 = (View) it.get();
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this.listener);
                }
                it.clear();
            }
            this.view = null;
            this.isAttached = false;
        }
    }
}

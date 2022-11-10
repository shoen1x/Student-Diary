package com.mikepenz.iconics.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimationListener;", "", "onAnimationCancel", "", "processor", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "onAnimationEnd", "isReverse", "", "onAnimationRepeat", "onAnimationStart", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimationListener.kt */
public interface IconicsAnimationListener {
    void onAnimationCancel(IconicsAnimationProcessor iconicsAnimationProcessor);

    void onAnimationEnd(IconicsAnimationProcessor iconicsAnimationProcessor);

    void onAnimationEnd(IconicsAnimationProcessor iconicsAnimationProcessor, boolean z);

    void onAnimationRepeat(IconicsAnimationProcessor iconicsAnimationProcessor);

    void onAnimationStart(IconicsAnimationProcessor iconicsAnimationProcessor);

    void onAnimationStart(IconicsAnimationProcessor iconicsAnimationProcessor, boolean z);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* compiled from: IconicsAnimationListener.kt */
    public static final class DefaultImpls {
        public static void onAnimationStart(IconicsAnimationListener $this, IconicsAnimationProcessor processor, boolean isReverse) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
            $this.onAnimationStart(processor);
        }

        public static void onAnimationEnd(IconicsAnimationListener $this, IconicsAnimationProcessor processor, boolean isReverse) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
            $this.onAnimationEnd(processor);
        }

        public static void onAnimationStart(IconicsAnimationListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }

        public static void onAnimationEnd(IconicsAnimationListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }

        public static void onAnimationCancel(IconicsAnimationListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }

        public static void onAnimationRepeat(IconicsAnimationListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }
    }
}

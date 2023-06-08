package com.mikepenz.iconics.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/iconics/animation/IconicsAnimationPauseListener;", "", "onAnimationPause", "", "processor", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "onAnimationResume", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimationPauseListener.kt */
public interface IconicsAnimationPauseListener {
    void onAnimationPause(IconicsAnimationProcessor iconicsAnimationProcessor);

    void onAnimationResume(IconicsAnimationProcessor iconicsAnimationProcessor);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* compiled from: IconicsAnimationPauseListener.kt */
    public static final class DefaultImpls {
        public static void onAnimationPause(IconicsAnimationPauseListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }

        public static void onAnimationResume(IconicsAnimationPauseListener $this, IconicsAnimationProcessor processor) {
            Intrinsics.checkParameterIsNotNull(processor, "processor");
        }
    }
}

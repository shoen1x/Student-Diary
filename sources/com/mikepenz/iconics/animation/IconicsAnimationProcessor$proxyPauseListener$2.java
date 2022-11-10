package com.mikepenz.iconics.animation;

import android.animation.Animator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyPauseListener$2$1", "invoke", "()Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyPauseListener$2$1;"}, k = 3, mv = {1, 1, 15})
/* compiled from: IconicsAnimationProcessor.kt */
final class IconicsAnimationProcessor$proxyPauseListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ IconicsAnimationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconicsAnimationProcessor$proxyPauseListener$2(IconicsAnimationProcessor iconicsAnimationProcessor) {
        super(0);
        this.this$0 = iconicsAnimationProcessor;
    }

    public final AnonymousClass1 invoke() {
        return new Animator.AnimatorPauseListener(this) {
            final /* synthetic */ IconicsAnimationProcessor$proxyPauseListener$2 this$0;

            {
                this.this$0 = $outer;
            }

            public void onAnimationPause(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                List<IconicsAnimationPauseListener> $this$forEach$iv = this.this$0.this$0.pauseListeners;
                if ($this$forEach$iv != null) {
                    for (IconicsAnimationPauseListener it : $this$forEach$iv) {
                        it.onAnimationPause(this.this$0.this$0);
                    }
                }
            }

            public void onAnimationResume(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                List<IconicsAnimationPauseListener> $this$forEach$iv = this.this$0.this$0.pauseListeners;
                if ($this$forEach$iv != null) {
                    for (IconicsAnimationPauseListener it : $this$forEach$iv) {
                        it.onAnimationResume(this.this$0.this$0);
                    }
                }
            }
        };
    }
}

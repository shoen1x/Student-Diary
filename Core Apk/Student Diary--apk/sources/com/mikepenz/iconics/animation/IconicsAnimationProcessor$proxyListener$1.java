package com.mikepenz.iconics.animation;

import android.animation.Animator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/mikepenz/iconics/animation/IconicsAnimationProcessor$proxyListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "isReverse", "", "onAnimationRepeat", "onAnimationStart", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimationProcessor.kt */
public final class IconicsAnimationProcessor$proxyListener$1 implements Animator.AnimatorListener {
    final /* synthetic */ IconicsAnimationProcessor this$0;

    IconicsAnimationProcessor$proxyListener$1(IconicsAnimationProcessor $outer) {
        this.this$0 = $outer;
    }

    public void onAnimationStart(Animator animation, boolean isReverse) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationStart(this.this$0, isReverse);
            }
        }
    }

    public void onAnimationEnd(Animator animation, boolean isReverse) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationEnd(this.this$0, isReverse);
            }
        }
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationStart(this.this$0);
            }
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationEnd(this.this$0);
            }
        }
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationCancel(this.this$0);
            }
        }
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        List<IconicsAnimationListener> $this$forEach$iv = this.this$0.listeners;
        if ($this$forEach$iv != null) {
            for (IconicsAnimationListener it : $this$forEach$iv) {
                it.onAnimationRepeat(this.this$0);
            }
        }
    }
}

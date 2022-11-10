package com.mikepenz.iconics.animation;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimatedDrawable.kt */
public final class IconicsAnimatedDrawable$Runner$listener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ IconicsAnimatedDrawable.Runner this$0;

    IconicsAnimatedDrawable$Runner$listener$1(IconicsAnimatedDrawable.Runner $outer) {
        this.this$0 = $outer;
    }

    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        this.this$0.isAttached = true;
        ViewCompat.postOnAnimation(v, new IconicsAnimatedDrawable$Runner$listener$1$onViewAttachedToWindow$1(this, v));
    }

    public void onViewDetachedFromWindow(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        this.this$0.isAttached = false;
    }
}

package com.mikepenz.iconics.animation;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/mikepenz/iconics/animation/IconicsAnimatedDrawable$Runner$listener$1$onViewAttachedToWindow$1", "Ljava/lang/Runnable;", "run", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAnimatedDrawable.kt */
public final class IconicsAnimatedDrawable$Runner$listener$1$onViewAttachedToWindow$1 implements Runnable {
    final /* synthetic */ View $v;
    final /* synthetic */ IconicsAnimatedDrawable$Runner$listener$1 this$0;

    IconicsAnimatedDrawable$Runner$listener$1$onViewAttachedToWindow$1(IconicsAnimatedDrawable$Runner$listener$1 $outer, View $captured_local_variable$1) {
        this.this$0 = $outer;
        this.$v = $captured_local_variable$1;
    }

    public void run() {
        IconicsAnimatedDrawable it;
        if (this.this$0.this$0.isAttached) {
            WeakReference access$getView$p = this.this$0.this$0.view;
            if ((access$getView$p != null ? (View) access$getView$p.get() : null) != null && (it = this.this$0.this$0.drawable) != null) {
                this.$v.invalidateDrawable(it);
                ViewCompat.postOnAnimation(this.$v, this);
            }
        }
    }
}

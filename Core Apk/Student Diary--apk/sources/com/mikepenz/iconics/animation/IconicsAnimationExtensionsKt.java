package com.mikepenz.iconics.animation;

import android.view.View;
import com.mikepenz.iconics.IconicsDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u001a'\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"tryToEnableIconicsAnimation", "Lcom/mikepenz/iconics/IconicsDrawable;", "Landroid/view/View;", "drawable", "", "drawables", "", "(Landroid/view/View;[Lcom/mikepenz/iconics/IconicsDrawable;)V", "iconics-core"}, k = 2, mv = {1, 1, 15})
/* compiled from: IconicsAnimationExtensions.kt */
public final class IconicsAnimationExtensionsKt {
    public static final IconicsDrawable tryToEnableIconicsAnimation(View $this$tryToEnableIconicsAnimation, IconicsDrawable drawable) {
        Intrinsics.checkParameterIsNotNull($this$tryToEnableIconicsAnimation, "$this$tryToEnableIconicsAnimation");
        if (((IconicsAnimatedDrawable) (!(drawable instanceof IconicsAnimatedDrawable) ? null : drawable)) != null) {
            ((IconicsAnimatedDrawable) drawable).animateIn($this$tryToEnableIconicsAnimation);
        }
        return drawable;
    }

    public static final void tryToEnableIconicsAnimation(View $this$tryToEnableIconicsAnimation, IconicsDrawable... drawables) {
        View view = $this$tryToEnableIconicsAnimation;
        Intrinsics.checkParameterIsNotNull(view, "$this$tryToEnableIconicsAnimation");
        Intrinsics.checkParameterIsNotNull(drawables, "drawables");
        Object[] $this$mapNotNull$iv = drawables;
        Collection destination$iv$iv = new ArrayList();
        Object[] $this$forEach$iv$iv$iv = $this$mapNotNull$iv;
        int length = $this$forEach$iv$iv$iv.length;
        int i = 0;
        while (i < length) {
            Object it = $this$forEach$iv$iv$iv[i];
            Object[] $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Object it$iv$iv = (IconicsAnimatedDrawable) (!(it instanceof IconicsAnimatedDrawable) ? null : it);
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
            i++;
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        for (IconicsAnimatedDrawable it2 : (List) destination$iv$iv) {
            it2.animateIn(view);
        }
    }
}

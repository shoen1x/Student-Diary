package com.mikepenz.iconics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/mikepenz/iconics/IconicsColor;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: IconicsDrawable.kt */
final class IconicsDrawable$shadow$4 extends Lambda implements Function0<IconicsColor> {
    final /* synthetic */ IconicsDrawable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconicsDrawable$shadow$4(IconicsDrawable iconicsDrawable) {
        super(0);
        this.this$0 = iconicsDrawable;
    }

    public final IconicsColor invoke() {
        return IconicsColor.Companion.colorInt(this.this$0.shadowColor);
    }
}

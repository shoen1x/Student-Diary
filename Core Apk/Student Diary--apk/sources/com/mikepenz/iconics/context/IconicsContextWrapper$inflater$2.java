package com.mikepenz.iconics.context;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/mikepenz/iconics/context/InternalLayoutInflater;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: IconicsContextWrapper.kt */
final class IconicsContextWrapper$inflater$2 extends Lambda implements Function0<InternalLayoutInflater> {
    final /* synthetic */ IconicsContextWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconicsContextWrapper$inflater$2(IconicsContextWrapper iconicsContextWrapper) {
        super(0);
        this.this$0 = iconicsContextWrapper;
    }

    public final InternalLayoutInflater invoke() {
        LayoutInflater from = LayoutInflater.from(this.this$0.getBaseContext());
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(baseContext)");
        return new InternalLayoutInflater(from, this.this$0, false);
    }
}

package com.mikepenz.iconics.utils;

import com.mikepenz.iconics.Iconics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mikepenz/iconics/Iconics$Builder;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: IconicsExtensions.kt */
final class IconicsExtensionsKt$buildIconics$6 extends Lambda implements Function1<Iconics.Builder, Unit> {
    public static final IconicsExtensionsKt$buildIconics$6 INSTANCE = new IconicsExtensionsKt$buildIconics$6();

    IconicsExtensionsKt$buildIconics$6() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Iconics.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Iconics.Builder $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
    }
}

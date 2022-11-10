package com.mikepenz.materialdrawer.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\f¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\f¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\f¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"ifNotNull", "", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "ifNull", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "otherwise", "materialdrawer"}, k = 2, mv = {1, 1, 16})
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final <T> Unit ifNotNull(T $this$ifNotNull, Function1<? super T, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if ($this$ifNotNull != null) {
            return block.invoke($this$ifNotNull);
        }
        return null;
    }

    public static final <T> void otherwise(T $this$otherwise, Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if ($this$otherwise == null) {
            block.invoke();
        }
    }

    public static final <T> void ifNull(T $this$ifNull, Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        if ($this$ifNull == null) {
            block.invoke();
        }
    }
}

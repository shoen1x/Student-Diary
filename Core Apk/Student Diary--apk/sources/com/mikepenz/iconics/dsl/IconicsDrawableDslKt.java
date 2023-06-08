package com.mikepenz.iconics.dsl;

import android.content.Context;
import android.graphics.Typeface;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a-\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0007\u001a9\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"NON_READABLE", "", "nonReadable", "", "iconicsDrawable", "Lcom/mikepenz/iconics/IconicsDrawable;", "Landroid/content/Context;", "icon", "Lcom/mikepenz/iconics/typeface/IIcon;", "block", "Lkotlin/Function1;", "Lcom/mikepenz/iconics/dsl/IconicsDrawableDsl;", "", "Lkotlin/ExtensionFunctionType;", "typeface", "Landroid/graphics/Typeface;", "iconics-core"}, k = 2, mv = {1, 1, 15})
/* compiled from: IconicsDrawableDsl.kt */
public final class IconicsDrawableDslKt {
    public static final String NON_READABLE = "Non readable property.";

    @ExperimentalIconicsDSL
    public static final IconicsDrawable iconicsDrawable(Context $this$iconicsDrawable, IIcon icon, Function1<? super IconicsDrawableDsl, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$iconicsDrawable, "$this$iconicsDrawable");
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        Intrinsics.checkParameterIsNotNull(block, "block");
        IconicsDrawable iconicsDrawable = new IconicsDrawable($this$iconicsDrawable);
        IconicsDrawable $this$apply = iconicsDrawable;
        $this$apply.icon(icon);
        block.invoke(new IconicsDrawableDsl($this$apply));
        return iconicsDrawable;
    }

    public static /* synthetic */ IconicsDrawable iconicsDrawable$default(Context context, String str, Typeface typeface, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            typeface = null;
        }
        return iconicsDrawable(context, str, typeface, function1);
    }

    @ExperimentalIconicsDSL
    public static final IconicsDrawable iconicsDrawable(Context $this$iconicsDrawable, String icon, Typeface typeface, Function1<? super IconicsDrawableDsl, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$iconicsDrawable, "$this$iconicsDrawable");
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        Intrinsics.checkParameterIsNotNull(block, "block");
        IconicsDrawable iconicsDrawable = new IconicsDrawable($this$iconicsDrawable);
        IconicsDrawable $this$apply = iconicsDrawable;
        $this$apply.iconText(icon, typeface);
        block.invoke(new IconicsDrawableDsl($this$apply));
        return iconicsDrawable;
    }

    public static final Void nonReadable() {
        throw new NonReadablePropertyException();
    }
}

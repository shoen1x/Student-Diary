package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/IconicsColorList;", "Lcom/mikepenz/iconics/IconicsColor;", "colorList", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "extract", "", "context", "Landroid/content/Context;", "extract$iconics_core", "extractList", "extractList$iconics_core", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsColor.kt */
public final class IconicsColorList extends IconicsColor {
    private final ColorStateList colorList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsColorList(ColorStateList colorList2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(colorList2, "colorList");
        this.colorList = colorList2;
    }

    public ColorStateList extractList$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return this.colorList;
    }

    public int extract$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return this.colorList.getDefaultColor();
    }
}

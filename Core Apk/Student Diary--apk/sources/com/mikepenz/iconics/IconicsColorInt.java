package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/IconicsColorInt;", "Lcom/mikepenz/iconics/IconicsColor;", "color", "", "(I)V", "extract", "context", "Landroid/content/Context;", "extract$iconics_core", "extractList", "Landroid/content/res/ColorStateList;", "extractList$iconics_core", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsColor.kt */
public final class IconicsColorInt extends IconicsColor {
    private final int color;

    public IconicsColorInt(int color2) {
        super((DefaultConstructorMarker) null);
        this.color = color2;
    }

    public ColorStateList extractList$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ColorStateList.valueOf(this.color);
    }

    public int extract$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return this.color;
    }
}

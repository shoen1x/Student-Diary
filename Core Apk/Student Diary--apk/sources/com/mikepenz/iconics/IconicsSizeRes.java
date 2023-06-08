package com.mikepenz.iconics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/IconicsSizeRes;", "Lcom/mikepenz/iconics/IconicsSize;", "res", "", "(I)V", "extract", "context", "Landroid/content/Context;", "extract$iconics_core", "extractFloat", "", "extractFloat$iconics_core", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsSize.kt */
public final class IconicsSizeRes extends IconicsSize {
    private final int res;

    public IconicsSizeRes(int res2) {
        super((DefaultConstructorMarker) null);
        this.res = res2;
    }

    public float extractFloat$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return (float) extract$iconics_core(context);
    }

    public int extract$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getResources().getDimensionPixelSize(this.res);
    }
}

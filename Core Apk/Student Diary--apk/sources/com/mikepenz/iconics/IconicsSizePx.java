package com.mikepenz.iconics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/mikepenz/iconics/IconicsSizePx;", "Lcom/mikepenz/iconics/IconicsSize;", "px", "", "(Ljava/lang/Number;)V", "extract", "", "context", "Landroid/content/Context;", "extract$iconics_core", "extractFloat", "", "extractFloat$iconics_core", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsSize.kt */
public final class IconicsSizePx extends IconicsSize {
    private final Number px;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsSizePx(Number px2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(px2, "px");
        this.px = px2;
    }

    public float extractFloat$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return this.px.floatValue();
    }

    public int extract$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return this.px.intValue();
    }
}

package com.mikepenz.iconics;

import android.content.Context;
import com.mikepenz.iconics.utils.IconicsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/mikepenz/iconics/IconicsSizeDp;", "Lcom/mikepenz/iconics/IconicsSize;", "dp", "", "(Ljava/lang/Number;)V", "pxCache", "", "getPxCache", "()Ljava/lang/Integer;", "setPxCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "extract", "context", "Landroid/content/Context;", "extract$iconics_core", "extractFloat", "", "extractFloat$iconics_core", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsSize.kt */
public final class IconicsSizeDp extends IconicsSize {
    private final Number dp;
    private Integer pxCache;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconicsSizeDp(Number dp2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(dp2, "dp");
        this.dp = dp2;
    }

    public final Integer getPxCache() {
        return this.pxCache;
    }

    public final void setPxCache(Integer num) {
        this.pxCache = num;
    }

    public float extractFloat$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return (float) extract$iconics_core(context);
    }

    public int extract$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Integer num = this.pxCache;
        int pxCache2 = num != null ? num.intValue() : IconicsUtils.convertDpToPx(context, this.dp);
        this.pxCache = Integer.valueOf(pxCache2);
        return pxCache2;
    }
}

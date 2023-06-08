package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsUtils;", "", "()V", "convertDpToPx", "", "context", "Landroid/content/Context;", "dp", "", "enableShadowSupport", "", "view", "Landroid/view/View;", "getCheckableIconStateList", "Landroid/graphics/drawable/StateListDrawable;", "ctx", "icon", "Landroid/graphics/drawable/Drawable;", "checkedIcon", "animate", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsUtils.kt */
public final class IconicsUtils {
    public static final IconicsUtils INSTANCE = new IconicsUtils();

    @JvmStatic
    public static final StateListDrawable getCheckableIconStateList(Context context, Drawable drawable, Drawable drawable2) {
        return getCheckableIconStateList$default(context, drawable, drawable2, false, 8, (Object) null);
    }

    private IconicsUtils() {
    }

    @JvmStatic
    public static final void enableShadowSupport(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.setLayerType(1, (Paint) null);
    }

    @JvmStatic
    public static final int convertDpToPx(Context context, Number dp) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dp, "dp");
        float floatValue = dp.floatValue();
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) TypedValue.applyDimension(1, floatValue, resources.getDisplayMetrics());
    }

    public static /* synthetic */ StateListDrawable getCheckableIconStateList$default(Context context, Drawable drawable, Drawable drawable2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return getCheckableIconStateList(context, drawable, drawable2, z);
    }

    @JvmStatic
    public static final StateListDrawable getCheckableIconStateList(Context ctx, Drawable icon, Drawable checkedIcon, boolean animate) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        StateListDrawable stateListDrawable = new StateListDrawable();
        StateListDrawable $this$apply = stateListDrawable;
        $this$apply.addState(new int[]{16842912}, checkedIcon);
        $this$apply.addState(new int[]{-16842912}, icon);
        if (animate) {
            int duration = ctx.getResources().getInteger(17694720);
            $this$apply.setEnterFadeDuration(duration);
            $this$apply.setExitFadeDuration(duration);
        }
        return stateListDrawable;
    }
}

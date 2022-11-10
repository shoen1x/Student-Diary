package com.mikepenz.materialize.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.mikepenz.materialize.R;

public class UIUtils {
    public static int getThemeColor(Context ctx, int attr) {
        TypedValue tv = new TypedValue();
        if (ctx.getTheme().resolveAttribute(attr, tv, true)) {
            return tv.resourceId != 0 ? ContextCompat.getColor(ctx, tv.resourceId) : tv.data;
        }
        return 0;
    }

    public static int getThemeColorFromAttrOrRes(Context ctx, int attr, int res) {
        int color = getThemeColor(ctx, attr);
        if (color == 0) {
            return ResourcesCompat.getColor(ctx.getResources(), res, ctx.getTheme());
        }
        return color;
    }

    @Deprecated
    public static void setBackground(View v, Drawable d) {
        ViewCompat.setBackground(v, d);
    }

    public static void setBackground(View v, int drawableRes) {
        ViewCompat.setBackground(v, ContextCompat.getDrawable(v.getContext(), drawableRes));
    }

    public static int getThemeAttributeDimensionSize(Context context, int attr) {
        TypedArray a = null;
        try {
            a = context.getTheme().obtainStyledAttributes(new int[]{attr});
            return a.getDimensionPixelSize(0, 0);
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int id = resources.getIdentifier(context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", SystemMediaRouteProvider.PACKAGE_NAME);
        if (id > 0) {
            return resources.getDimensionPixelSize(id);
        }
        return 0;
    }

    public static int getActionBarHeight(Context context) {
        int actionBarHeight = getThemeAttributeDimensionSize(context, R.attr.actionBarSize);
        if (actionBarHeight == 0) {
            return context.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
        }
        return actionBarHeight;
    }

    public static int getStatusBarHeight(Context context) {
        return getStatusBarHeight(context, false);
    }

    public static int getStatusBarHeight(Context context, boolean force) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", SystemMediaRouteProvider.PACKAGE_NAME);
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        int dimenResult = context.getResources().getDimensionPixelSize(R.dimen.tool_bar_top_padding);
        if (dimenResult != 0 || force) {
            return result == 0 ? dimenResult : result;
        }
        return 0;
    }

    public static float convertDpToPixel(float dp, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * dp;
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static void setTranslucentStatusFlag(Activity activity, boolean on) {
        if (Build.VERSION.SDK_INT >= 19) {
            setFlag(activity, 67108864, on);
        }
    }

    public static void setTranslucentNavigationFlag(Activity activity, boolean on) {
        if (Build.VERSION.SDK_INT >= 19) {
            setFlag(activity, 134217728, on);
        }
    }

    public static void setFlag(Activity activity, int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public static StateListDrawable getIconStateList(Drawable icon, Drawable selectedIcon) {
        StateListDrawable iconStateListDrawable = new StateListDrawable();
        iconStateListDrawable.addState(new int[]{16842913}, selectedIcon);
        iconStateListDrawable.addState(new int[0], icon);
        return iconStateListDrawable;
    }

    public static StateListDrawable getSelectableBackground(Context ctx, int selected_color, boolean animate) {
        StateListDrawable states = new StateListDrawable();
        int[] iArr = {16842913};
        states.addState(iArr, new ColorDrawable(selected_color));
        states.addState(new int[0], getSelectableBackground(ctx));
        if (animate) {
            int duration = ctx.getResources().getInteger(17694720);
            states.setEnterFadeDuration(duration);
            states.setExitFadeDuration(duration);
        }
        return states;
    }

    public static StateListDrawable getSelectablePressedBackground(Context ctx, int selected_color, int pressed_alpha, boolean animate) {
        StateListDrawable states = getSelectableBackground(ctx, selected_color, animate);
        int[] iArr = {16842919};
        states.addState(iArr, new ColorDrawable(adjustAlpha(selected_color, pressed_alpha)));
        return states;
    }

    public static int adjustAlpha(int color, int alpha) {
        return (alpha << 24) | (16777215 & color);
    }

    public static int getSelectableBackgroundRes(Context ctx) {
        TypedValue outValue = new TypedValue();
        ctx.getTheme().resolveAttribute(R.attr.selectableItemBackground, outValue, true);
        return outValue.resourceId;
    }

    public static Drawable getSelectableBackground(Context ctx) {
        return ContextCompat.getDrawable(ctx, getSelectableBackgroundRes(ctx));
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}

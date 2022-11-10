package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialize.util.UIUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ.\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"¨\u0006#"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerUIUtils;", "", "()V", "getBooleanStyleable", "", "ctx", "Landroid/content/Context;", "styleable", "", "def", "getDrawerItemBackground", "Landroid/graphics/drawable/StateListDrawable;", "selected_color", "getIconStateList", "icon", "Landroid/graphics/drawable/Drawable;", "selectedIcon", "getOptimalDrawerWidth", "context", "getPlaceHolder", "getTextColorStateList", "Landroid/content/res/ColorStateList;", "text_color", "selected_text_color", "isSystemBarOnBottom", "setDrawerVerticalPadding", "", "v", "Landroid/view/View;", "level", "themeDrawerItem", "view", "animate", "shapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerUIUtils.kt */
public final class DrawerUIUtils {
    public static final DrawerUIUtils INSTANCE = new DrawerUIUtils();

    private DrawerUIUtils() {
    }

    public final boolean getBooleanStyleable(Context ctx, int styleable, boolean def) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return ctx.getTheme().obtainStyledAttributes(R.styleable.MaterialDrawer).getBoolean(styleable, def);
    }

    public final void themeDrawerItem(Context ctx, View view, int selected_color, boolean animate, ShapeAppearanceModel shapeAppearanceModel) {
        Drawable unselected;
        Drawable selected;
        Context context = ctx;
        View view2 = view;
        ShapeAppearanceModel shapeAppearanceModel2 = shapeAppearanceModel;
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(view2, "view");
        Intrinsics.checkParameterIsNotNull(shapeAppearanceModel2, "shapeAppearanceModel");
        if (getBooleanStyleable(context, R.styleable.MaterialDrawer_material_drawer_legacy_style, false)) {
            selected = new ColorDrawable(selected_color);
            Drawable selectableBackground = UIUtils.getSelectableBackground(ctx);
            Intrinsics.checkExpressionValueIsNotNull(selectableBackground, "UIUtils.getSelectableBackground(ctx)");
            unselected = selectableBackground;
        } else {
            int i = selected_color;
            int paddingTopBottom = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_item_background_padding_top_bottom);
            int paddingStartEnd = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_item_background_padding_start_end);
            MaterialShapeDrawable gradientDrawable = new MaterialShapeDrawable(shapeAppearanceModel2);
            gradientDrawable.setFillColor(ColorStateList.valueOf(selected_color));
            MaterialShapeDrawable materialShapeDrawable = gradientDrawable;
            selected = new InsetDrawable(gradientDrawable, paddingStartEnd, paddingTopBottom, paddingStartEnd, paddingTopBottom);
            if (Build.VERSION.SDK_INT >= 21) {
                MaterialShapeDrawable gradientMask = new MaterialShapeDrawable(shapeAppearanceModel2);
                gradientMask.setFillColor(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
                MaterialShapeDrawable materialShapeDrawable2 = gradientMask;
                unselected = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{UIUtils.getThemeColor(context, R.attr.colorControlHighlight)}), (Drawable) null, new InsetDrawable(gradientMask, paddingStartEnd, paddingTopBottom, paddingStartEnd, paddingTopBottom));
            } else {
                MaterialShapeDrawable touchDrawable = new MaterialShapeDrawable(shapeAppearanceModel2);
                touchDrawable.setFillColor(ColorStateList.valueOf(UIUtils.getThemeColor(context, R.attr.colorControlHighlight)));
                InsetDrawable insetDrawable = new InsetDrawable(touchDrawable, paddingStartEnd, paddingTopBottom, paddingStartEnd, paddingTopBottom);
                StateListDrawable unselectedStates = new StateListDrawable();
                if (animate) {
                    int duration = ctx.getResources().getInteger(17694720);
                    unselectedStates.setEnterFadeDuration(duration);
                    unselectedStates.setExitFadeDuration(duration);
                }
                unselectedStates.addState(new int[]{16842919}, insetDrawable);
                unselectedStates.addState(new int[0], new ColorDrawable(0));
                unselected = unselectedStates;
            }
        }
        StateListDrawable states = new StateListDrawable();
        if (animate) {
            int duration2 = ctx.getResources().getInteger(17694720);
            states.setEnterFadeDuration(duration2);
            states.setExitFadeDuration(duration2);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            states.addState(new int[]{16842913}, selected);
            states.addState(new int[0], new ColorDrawable(0));
            ViewCompat.setBackground(view2, states);
            view2.setForeground(unselected);
            return;
        }
        states.addState(new int[]{16842913}, selected);
        states.addState(new int[0], unselected);
        ViewCompat.setBackground(view2, states);
    }

    public final ColorStateList getTextColorStateList(int text_color, int selected_text_color) {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{selected_text_color, text_color});
    }

    public final StateListDrawable getIconStateList(Drawable icon, Drawable selectedIcon) {
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        Intrinsics.checkParameterIsNotNull(selectedIcon, "selectedIcon");
        StateListDrawable iconStateListDrawable = new StateListDrawable();
        iconStateListDrawable.addState(new int[]{16842913}, selectedIcon);
        iconStateListDrawable.addState(new int[0], icon);
        return iconStateListDrawable;
    }

    public final StateListDrawable getDrawerItemBackground(int selected_color) {
        ColorDrawable clrActive = new ColorDrawable(selected_color);
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{16842913}, clrActive);
        return states;
    }

    public final int getOptimalDrawerWidth(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return Math.min(UIUtils.getScreenWidth(context) - UIUtils.getActionBarHeight(context), context.getResources().getDimensionPixelSize(R.dimen.material_drawer_width));
    }

    public final Drawable getPlaceHolder(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return new IconicsDrawable(ctx, (IIcon) MaterialDrawerFont.Icon.mdf_person).color(IconicsColor.Companion.colorRes(R.color.accent)).backgroundColor(IconicsColor.Companion.colorRes(R.color.primary)).size(IconicsSize.Companion.dp((Number) 56)).padding(IconicsSize.Companion.dp((Number) 16));
    }

    public final void setDrawerVerticalPadding(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Context context = v.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "v.context");
        int verticalPadding = context.getResources().getDimensionPixelSize(R.dimen.material_drawer_vertical_padding);
        v.setPadding(verticalPadding, 0, verticalPadding, 0);
    }

    public final void setDrawerVerticalPadding(View v, int level) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        Context context = v.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "v.context");
        int verticalPadding = context.getResources().getDimensionPixelSize(R.dimen.material_drawer_vertical_padding);
        if (Build.VERSION.SDK_INT >= 17) {
            v.setPaddingRelative(verticalPadding * level, 0, verticalPadding, 0);
        } else {
            v.setPadding(verticalPadding * level, 0, verticalPadding, 0);
        }
    }

    public final boolean isSystemBarOnBottom(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Object systemService = ctx.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(metrics);
            Resources resources = ctx.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "ctx.resources");
            if (!(metrics.widthPixels != metrics.heightPixels && resources.getConfiguration().smallestScreenWidthDp < 600) || metrics.widthPixels < metrics.heightPixels) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
}

package com.mikepenz.materialize.holder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.mikepenz.materialize.util.UIUtils;

public class ColorHolder {
    private int mColorInt = 0;
    private int mColorRes = -1;

    public int getColorInt() {
        return this.mColorInt;
    }

    public void setColorInt(int mColorInt2) {
        this.mColorInt = mColorInt2;
    }

    public int getColorRes() {
        return this.mColorRes;
    }

    public void setColorRes(int mColorRes2) {
        this.mColorRes = mColorRes2;
    }

    public static ColorHolder fromColorRes(int colorRes) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorRes = colorRes;
        return colorHolder;
    }

    public static ColorHolder fromColor(int colorInt) {
        ColorHolder colorHolder = new ColorHolder();
        colorHolder.mColorInt = colorInt;
        return colorHolder;
    }

    public void applyTo(Context ctx, GradientDrawable drawable) {
        int i = this.mColorInt;
        if (i != 0) {
            drawable.setColor(i);
            return;
        }
        int i2 = this.mColorRes;
        if (i2 != -1) {
            drawable.setColor(ContextCompat.getColor(ctx, i2));
        }
    }

    public void applyToBackground(View view) {
        int i = this.mColorInt;
        if (i != 0) {
            view.setBackgroundColor(i);
            return;
        }
        int i2 = this.mColorRes;
        if (i2 != -1) {
            view.setBackgroundResource(i2);
        }
    }

    public void applyToOr(TextView textView, ColorStateList colorDefault) {
        int i = this.mColorInt;
        if (i != 0) {
            textView.setTextColor(i);
        } else if (this.mColorRes != -1) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), this.mColorRes));
        } else if (colorDefault != null) {
            textView.setTextColor(colorDefault);
        }
    }

    public int color(Context ctx, int colorStyle, int colorDefaultRes) {
        int color = color(ctx);
        if (color == 0) {
            return UIUtils.getThemeColorFromAttrOrRes(ctx, colorStyle, colorDefaultRes);
        }
        return color;
    }

    public int color(Context ctx) {
        int i;
        if (this.mColorInt == 0 && (i = this.mColorRes) != -1) {
            this.mColorInt = ContextCompat.getColor(ctx, i);
        }
        return this.mColorInt;
    }

    public static int color(ColorHolder colorHolder, Context ctx, int colorStyle, int colorDefault) {
        if (colorHolder == null) {
            return UIUtils.getThemeColorFromAttrOrRes(ctx, colorStyle, colorDefault);
        }
        return colorHolder.color(ctx, colorStyle, colorDefault);
    }

    public static int color(ColorHolder colorHolder, Context ctx) {
        if (colorHolder == null) {
            return 0;
        }
        return colorHolder.color(ctx);
    }

    public static void applyToOr(ColorHolder colorHolder, TextView textView, ColorStateList colorDefault) {
        if (colorHolder != null && textView != null) {
            colorHolder.applyToOr(textView, colorDefault);
        } else if (textView != null) {
            textView.setTextColor(colorDefault);
        }
    }

    public static void applyToOrTransparent(ColorHolder colorHolder, Context ctx, GradientDrawable gradientDrawable) {
        if (colorHolder != null && gradientDrawable != null) {
            colorHolder.applyTo(ctx, gradientDrawable);
        } else if (gradientDrawable != null) {
            gradientDrawable.setColor(0);
        }
    }
}

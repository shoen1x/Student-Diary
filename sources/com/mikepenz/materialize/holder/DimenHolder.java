package com.mikepenz.materialize.holder;

import android.content.Context;
import com.mikepenz.materialize.util.UIUtils;

public class DimenHolder {
    private int mDp = Integer.MIN_VALUE;
    private int mPixel = Integer.MIN_VALUE;
    private int mResource = Integer.MIN_VALUE;

    public int getPixel() {
        return this.mPixel;
    }

    public void setPixel(int mPixel2) {
        this.mPixel = mPixel2;
    }

    public int getDp() {
        return this.mDp;
    }

    public void setDp(int mDp2) {
        this.mDp = mDp2;
    }

    public int getResource() {
        return this.mResource;
    }

    public void setResource(int mResource2) {
        this.mResource = mResource2;
    }

    public static DimenHolder fromPixel(int pixel) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mPixel = pixel;
        return dimenHolder;
    }

    public static DimenHolder fromDp(int dp) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mDp = dp;
        return dimenHolder;
    }

    public static DimenHolder fromResource(int resource) {
        DimenHolder dimenHolder = new DimenHolder();
        dimenHolder.mResource = resource;
        return dimenHolder;
    }

    public int asPixel(Context ctx) {
        int i = this.mPixel;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        int i2 = this.mDp;
        if (i2 != Integer.MIN_VALUE) {
            return (int) UIUtils.convertDpToPixel((float) i2, ctx);
        }
        if (this.mResource != Integer.MIN_VALUE) {
            return ctx.getResources().getDimensionPixelSize(this.mResource);
        }
        return 0;
    }
}

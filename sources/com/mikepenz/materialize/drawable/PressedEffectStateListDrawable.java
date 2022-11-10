package com.mikepenz.materialize.drawable;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class PressedEffectStateListDrawable extends StateListDrawable {
    private int color;
    private int selectionColor;

    public PressedEffectStateListDrawable(Drawable drawable, int color2, int selectionColor2) {
        Drawable drawable2 = drawable.mutate();
        addState(new int[]{16842913}, drawable2);
        addState(new int[0], drawable2);
        this.color = color2;
        this.selectionColor = selectionColor2;
    }

    public PressedEffectStateListDrawable(Drawable drawable, Drawable selectedDrawable, int color2, int selectionColor2) {
        Drawable drawable2 = drawable.mutate();
        int[] iArr = {16842913};
        addState(iArr, selectedDrawable.mutate());
        addState(new int[0], drawable2);
        this.color = color2;
        this.selectionColor = selectionColor2;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] states) {
        boolean isStatePressedInArray = false;
        for (int state : states) {
            if (state == 16842913) {
                isStatePressedInArray = true;
            }
        }
        if (isStatePressedInArray) {
            super.setColorFilter(this.selectionColor, PorterDuff.Mode.SRC_IN);
        } else {
            super.setColorFilter(this.color, PorterDuff.Mode.SRC_IN);
        }
        return super.onStateChange(states);
    }

    public boolean isStateful() {
        return true;
    }
}

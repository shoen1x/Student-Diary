package com.applandeo.materialcalendarview.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;

public class ImageUtils {
    public static void loadImage(ImageView imageView, Object image) {
        if (image != null) {
            Drawable drawable = null;
            if (image instanceof Drawable) {
                drawable = (Drawable) image;
            } else if (image instanceof Integer) {
                drawable = ContextCompat.getDrawable(imageView.getContext(), ((Integer) image).intValue());
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    private ImageUtils() {
    }
}

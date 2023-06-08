package jp.wasabeef.picasso.transformations;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

public class CropSquareTransformation implements Transformation {
    private int mHeight;
    private int mWidth;

    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        this.mWidth = (source.getWidth() - size) / 2;
        int height = (source.getHeight() - size) / 2;
        this.mHeight = height;
        Bitmap bitmap = Bitmap.createBitmap(source, this.mWidth, height, size, size);
        if (bitmap != source) {
            source.recycle();
        }
        return bitmap;
    }

    public String key() {
        return "CropSquareTransformation(width=" + this.mWidth + ", height=" + this.mHeight + ")";
    }
}

package jp.wasabeef.picasso.transformations;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.squareup.picasso.Transformation;

public class ColorFilterTransformation implements Transformation {
    private int mColor;

    public ColorFilterTransformation(int color) {
        this.mColor = color;
    }

    public Bitmap transform(Bitmap source) {
        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.mColor, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        source.recycle();
        return bitmap;
    }

    public String key() {
        return "ColorFilterTransformation(color=" + this.mColor + ")";
    }
}

package jp.wasabeef.picasso.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import com.squareup.picasso.Transformation;
import jp.wasabeef.picasso.transformations.internal.FastBlur;
import jp.wasabeef.picasso.transformations.internal.RSBlur;

public class BlurTransformation implements Transformation {
    private static int DEFAULT_DOWN_SAMPLING = 1;
    private static int MAX_RADIUS = 25;
    private Context mContext;
    private int mRadius;
    private int mSampling;

    public BlurTransformation(Context context) {
        this(context, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(Context context, int radius) {
        this(context, radius, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(Context context, int radius, int sampling) {
        this.mContext = context.getApplicationContext();
        this.mRadius = radius;
        this.mSampling = sampling;
    }

    public Bitmap transform(Bitmap source) {
        Bitmap bitmap;
        Bitmap bitmap2 = Bitmap.createBitmap(source.getWidth() / this.mSampling, source.getHeight() / this.mSampling, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i = this.mSampling;
        canvas.scale(1.0f / ((float) i), 1.0f / ((float) i));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bitmap = RSBlur.blur(this.mContext, bitmap2, this.mRadius);
            } catch (RSRuntimeException e) {
                bitmap = FastBlur.blur(bitmap2, this.mRadius, true);
            }
        } else {
            bitmap = FastBlur.blur(bitmap2, this.mRadius, true);
        }
        source.recycle();
        return bitmap;
    }

    public String key() {
        return "BlurTransformation(radius=" + this.mRadius + ", sampling=" + this.mSampling + ")";
    }
}

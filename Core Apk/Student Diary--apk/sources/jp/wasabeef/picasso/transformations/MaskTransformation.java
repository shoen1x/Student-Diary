package jp.wasabeef.picasso.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Transformation;
import jp.wasabeef.picasso.transformations.internal.Utils;

public class MaskTransformation implements Transformation {
    private static Paint mMaskingPaint;
    private Context mContext;
    private int mMaskId;

    static {
        Paint paint = new Paint();
        mMaskingPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public MaskTransformation(Context context, int maskId) {
        this.mContext = context.getApplicationContext();
        this.mMaskId = maskId;
    }

    public Bitmap transform(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Drawable mask = Utils.getMaskDrawable(this.mContext, this.mMaskId);
        Canvas canvas = new Canvas(result);
        mask.setBounds(0, 0, width, height);
        mask.draw(canvas);
        canvas.drawBitmap(source, 0.0f, 0.0f, mMaskingPaint);
        source.recycle();
        return result;
    }

    public String key() {
        return "MaskTransformation(maskId=" + this.mContext.getResources().getResourceEntryName(this.mMaskId) + ")";
    }
}

package jp.wasabeef.picasso.transformations;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.squareup.picasso.Transformation;

public class CropTransformation implements Transformation {
    private static final String TAG = "PicassoTransformation";
    private float mAspectRatio;
    private GravityHorizontal mGravityHorizontal;
    private GravityVertical mGravityVertical;
    private int mHeight;
    private float mHeightRatio;
    private int mLeft;
    private int mTop;
    private int mWidth;
    private float mWidthRatio;

    public enum GravityHorizontal {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum GravityVertical {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int left, int top, int width, int height) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mLeft = left;
        this.mTop = top;
        this.mWidth = width;
        this.mHeight = height;
        this.mGravityHorizontal = null;
        this.mGravityVertical = null;
    }

    public CropTransformation(int width, int height, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidth = width;
        this.mHeight = height;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(int width, int height) {
        this(width, height, GravityHorizontal.CENTER, GravityVertical.CENTER);
    }

    public CropTransformation(float widthRatio, float heightRatio, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidthRatio = widthRatio;
        this.mHeightRatio = heightRatio;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float widthRatio, float heightRatio) {
        this(widthRatio, heightRatio, GravityHorizontal.CENTER, GravityVertical.CENTER);
    }

    public CropTransformation(int width, int height, float aspectRatio, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidth = width;
        this.mHeight = height;
        this.mAspectRatio = aspectRatio;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float widthRatio, float heightRatio, float aspectRatio, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mWidthRatio = widthRatio;
        this.mHeightRatio = heightRatio;
        this.mAspectRatio = aspectRatio;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public CropTransformation(float aspectRatio, GravityHorizontal gravityHorizontal, GravityVertical gravityVertical) {
        this.mGravityHorizontal = GravityHorizontal.CENTER;
        this.mGravityVertical = GravityVertical.CENTER;
        this.mAspectRatio = aspectRatio;
        this.mGravityHorizontal = gravityHorizontal;
        this.mGravityVertical = gravityVertical;
    }

    public Bitmap transform(Bitmap source) {
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): called, " + key());
        }
        if (this.mWidth == 0 && this.mWidthRatio != 0.0f) {
            this.mWidth = (int) (((float) source.getWidth()) * this.mWidthRatio);
        }
        if (this.mHeight == 0 && this.mHeightRatio != 0.0f) {
            this.mHeight = (int) (((float) source.getHeight()) * this.mHeightRatio);
        }
        if (this.mAspectRatio != 0.0f) {
            if (this.mWidth == 0 && this.mHeight == 0) {
                float sourceRatio = ((float) source.getWidth()) / ((float) source.getHeight());
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "transform(): mAspectRatio: " + this.mAspectRatio + ", sourceRatio: " + sourceRatio);
                }
                if (sourceRatio > this.mAspectRatio) {
                    this.mHeight = source.getHeight();
                } else {
                    this.mWidth = source.getWidth();
                }
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "transform(): before setting other of h/w: mAspectRatio: " + this.mAspectRatio + ", set one of width: " + this.mWidth + ", height: " + this.mHeight);
            }
            int i = this.mWidth;
            if (i != 0) {
                this.mHeight = (int) (((float) i) / this.mAspectRatio);
            } else {
                int i2 = this.mHeight;
                if (i2 != 0) {
                    this.mWidth = (int) (((float) i2) * this.mAspectRatio);
                }
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "transform(): mAspectRatio: " + this.mAspectRatio + ", set width: " + this.mWidth + ", height: " + this.mHeight);
            }
        }
        if (this.mWidth == 0) {
            this.mWidth = source.getWidth();
        }
        if (this.mHeight == 0) {
            this.mHeight = source.getHeight();
        }
        if (this.mGravityHorizontal != null) {
            this.mLeft = getLeft(source);
        }
        if (this.mGravityVertical != null) {
            this.mTop = getTop(source);
        }
        int i3 = this.mLeft;
        int i4 = this.mTop;
        Rect sourceRect = new Rect(i3, i4, this.mWidth + i3, this.mHeight + i4);
        Rect targetRect = new Rect(0, 0, this.mWidth, this.mHeight);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): created sourceRect with mLeft: " + this.mLeft + ", mTop: " + this.mTop + ", right: " + (this.mLeft + this.mWidth) + ", bottom: " + (this.mTop + this.mHeight));
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): created targetRect with width: " + this.mWidth + ", height: " + this.mHeight);
        }
        Bitmap bitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): copying from source with width: " + source.getWidth() + ", height: " + source.getHeight());
        }
        canvas.drawBitmap(source, sourceRect, targetRect, (Paint) null);
        source.recycle();
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "transform(): returning bitmap with width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
        }
        return bitmap;
    }

    public String key() {
        return "CropTransformation(width=" + this.mWidth + ", height=" + this.mHeight + ", mWidthRatio=" + this.mWidthRatio + ", mHeightRatio=" + this.mHeightRatio + ", mAspectRatio=" + this.mAspectRatio + ", gravityHorizontal=" + this.mGravityHorizontal + ", mGravityVertical=" + this.mGravityVertical + ")";
    }

    private int getTop(Bitmap source) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical[this.mGravityVertical.ordinal()];
        if (i == 2) {
            return (source.getHeight() - this.mHeight) / 2;
        }
        if (i != 3) {
            return 0;
        }
        return source.getHeight() - this.mHeight;
    }

    /* renamed from: jp.wasabeef.picasso.transformations.CropTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal;
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical;

        static {
            int[] iArr = new int[GravityHorizontal.values().length];
            $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal = iArr;
            try {
                iArr[GravityHorizontal.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal[GravityHorizontal.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal[GravityHorizontal.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[GravityVertical.values().length];
            $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical = iArr2;
            try {
                iArr2[GravityVertical.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical[GravityVertical.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityVertical[GravityVertical.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private int getLeft(Bitmap source) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$CropTransformation$GravityHorizontal[this.mGravityHorizontal.ordinal()];
        if (i == 2) {
            return (source.getWidth() - this.mWidth) / 2;
        }
        if (i != 3) {
            return 0;
        }
        return source.getWidth() - this.mWidth;
    }
}

package jp.wasabeef.picasso.transformations;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.squareup.picasso.Transformation;

public class RoundedCornersTransformation implements Transformation {
    private CornerType mCornerType;
    private int mDiameter;
    private int mMargin;
    private int mRadius;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int radius, int margin) {
        this(radius, margin, CornerType.ALL);
    }

    public RoundedCornersTransformation(int radius, int margin, CornerType cornerType) {
        this.mRadius = radius;
        this.mDiameter = radius * 2;
        this.mMargin = margin;
        this.mCornerType = cornerType;
    }

    public Bitmap transform(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, (float) width, (float) height);
        source.recycle();
        return bitmap;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float width, float height) {
        int i = this.mMargin;
        float right = width - ((float) i);
        float bottom = height - ((float) i);
        switch (AnonymousClass1.$SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[this.mCornerType.ordinal()]) {
            case 1:
                int i2 = this.mMargin;
                RectF rectF = new RectF((float) i2, (float) i2, right, bottom);
                int i3 = this.mRadius;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case 2:
                drawTopLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 3:
                drawTopRightRoundRect(canvas, paint, right, bottom);
                return;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 5:
                drawBottomRightRoundRect(canvas, paint, right, bottom);
                return;
            case 6:
                drawTopRoundRect(canvas, paint, right, bottom);
                return;
            case 7:
                drawBottomRoundRect(canvas, paint, right, bottom);
                return;
            case 8:
                drawLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 9:
                drawRightRoundRect(canvas, paint, right, bottom);
                return;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, right, bottom);
                return;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, right, bottom);
                return;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, right, bottom);
                return;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, right, bottom);
                return;
            default:
                int i4 = this.mMargin;
                RectF rectF2 = new RectF((float) i4, (float) i4, right, bottom);
                int i5 = this.mRadius;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    /* renamed from: jp.wasabeef.picasso.transformations.RoundedCornersTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$jp$wasabeef$picasso$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        int i2 = this.mDiameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), (float) (i4 + i5), bottom), paint);
        int i6 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i6), (float) i6, right, bottom), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mDiameter;
        int i2 = this.mMargin;
        RectF rectF = new RectF(right - ((float) i), (float) i2, right, (float) (i2 + i));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        canvas.drawRect(new RectF((float) i4, (float) i4, right - ((float) this.mRadius), bottom), paint);
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(right - ((float) i5), (float) (this.mMargin + i5), right, bottom), paint);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        int i2 = this.mDiameter;
        RectF rectF = new RectF((float) i, bottom - ((float) i2), (float) (i + i2), bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.mDiameter), bottom - ((float) this.mRadius)), paint);
        int i5 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i5), (float) i5, right, bottom), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mDiameter;
        RectF rectF = new RectF(right - ((float) i), bottom - ((float) i), right, bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) i3, (float) i3, right - ((float) this.mRadius), bottom), paint);
        int i4 = this.mRadius;
        canvas.drawRect(new RectF(right - ((float) i4), (float) this.mMargin, right, bottom - ((float) i4)), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.mRadius), right, bottom), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.mMargin;
        canvas.drawRect(new RectF((float) i2, (float) i2, right, bottom - ((float) this.mRadius)), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.mDiameter), bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i3), (float) i3, right, bottom), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.mMargin;
        canvas.drawRect(new RectF((float) i2, (float) i2, right - ((float) this.mRadius), bottom), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.mMargin;
        int i4 = this.mRadius;
        canvas.drawRect(new RectF((float) i3, (float) i3, right - ((float) i4), bottom - ((float) i4)), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.mDiameter), bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, right, bottom - ((float) i5)), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), right - ((float) i5), bottom), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.mMargin;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.mDiameter), bottom);
        int i4 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.mMargin;
        int i6 = this.mRadius;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), right, bottom), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mMargin;
        int i2 = this.mDiameter;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.mDiameter;
        RectF rectF2 = new RectF(right - ((float) i4), bottom - ((float) i4), right, bottom);
        int i5 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.mMargin;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.mRadius), right - ((float) this.mDiameter), bottom), paint);
        int i7 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mDiameter + i7), (float) i7, right, bottom - ((float) this.mRadius)), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.mDiameter;
        int i2 = this.mMargin;
        RectF rectF = new RectF(right - ((float) i), (float) i2, right, (float) (i2 + i));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.mMargin;
        int i5 = this.mDiameter;
        RectF rectF2 = new RectF((float) i4, bottom - ((float) i5), (float) (i4 + i5), bottom);
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.mMargin;
        int i8 = this.mRadius;
        canvas.drawRect(new RectF((float) i7, (float) i7, right - ((float) i8), bottom - ((float) i8)), paint);
        int i9 = this.mMargin;
        int i10 = this.mRadius;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), right, bottom), paint);
    }

    public String key() {
        return "RoundedTransformation(radius=" + this.mRadius + ", margin=" + this.mMargin + ", diameter=" + this.mDiameter + ", cornerType=" + this.mCornerType.name() + ")";
    }
}

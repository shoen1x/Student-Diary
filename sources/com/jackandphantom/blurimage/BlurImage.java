package com.jackandphantom.blurimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;
import java.lang.ref.WeakReference;

public class BlurImage {
    private static final float BLUR_RADIUS = 7.0f;
    private float BITMAP_SCALE = 0.3f;
    private float MAX_RADIUS = 25.0f;
    private float MAX_SCALE = 0.9f;
    private float MIN_SCALE = 0.2f;
    private boolean async = false;
    private Context context;
    private Bitmap image;
    private float intensity = 8.0f;

    private BlurImage(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap blur() {
        Bitmap bitmap = this.image;
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap input = Bitmap.createScaledBitmap(this.image, Math.round(((float) bitmap.getWidth()) * this.BITMAP_SCALE), Math.round(((float) this.image.getHeight()) * this.BITMAP_SCALE), false);
        Bitmap output = Bitmap.createBitmap(input);
        RenderScript rs = RenderScript.create(this.context);
        ScriptIntrinsicBlur intrinsicBlur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation inputallocation = Allocation.createFromBitmap(rs, input);
        Allocation outputallocation = Allocation.createFromBitmap(rs, output);
        intrinsicBlur.setRadius(this.intensity);
        intrinsicBlur.setInput(inputallocation);
        intrinsicBlur.forEach(outputallocation);
        outputallocation.copyTo(output);
        return output;
    }

    public static BlurImage with(Context context2) {
        return new BlurImage(context2);
    }

    public BlurImage load(Bitmap bitmap) {
        this.image = bitmap;
        return this;
    }

    public BlurImage load(int res) {
        this.image = BitmapFactory.decodeResource(this.context.getResources(), res);
        return this;
    }

    public BlurImage intensity(float intensity2) {
        if (intensity2 >= this.MAX_RADIUS || intensity2 <= 0.0f) {
            this.intensity = this.MAX_RADIUS;
        } else {
            this.intensity = intensity2;
        }
        return this;
    }

    public BlurImage Async(boolean async2) {
        this.async = async2;
        return this;
    }

    public void into(ImageView imageView) {
        if (this.async) {
            new AsyncBlurImage(imageView).execute(new Void[0]);
            return;
        }
        try {
            imageView.setImageBitmap(blur());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public BlurImage scale(float scale) {
        if (scale > 1.0f) {
            try {
                this.BITMAP_SCALE = this.MAX_SCALE;
            } catch (OutOfMemoryError error) {
                error.printStackTrace();
            }
        } else if (scale <= 0.0f) {
            this.BITMAP_SCALE = this.MIN_SCALE;
        } else {
            this.BITMAP_SCALE = scale;
        }
        return this;
    }

    public float getBitmapScale() {
        return this.BITMAP_SCALE;
    }

    public Bitmap getImageBlur() {
        return blur();
    }

    private class AsyncBlurImage extends AsyncTask<Void, Void, Bitmap> {
        private WeakReference<ImageView> weakReference;

        public AsyncBlurImage(ImageView image) {
            this.weakReference = new WeakReference<>(image);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voids) {
            return BlurImage.this.blur();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            ImageView imageView = (ImageView) this.weakReference.get();
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}

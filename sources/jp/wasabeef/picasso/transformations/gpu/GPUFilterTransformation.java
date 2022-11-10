package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageFilter;

public class GPUFilterTransformation implements Transformation {
    private Context mContext;
    private GPUImageFilter mFilter;

    public GPUFilterTransformation(Context context, GPUImageFilter filter) {
        this.mContext = context.getApplicationContext();
        this.mFilter = filter;
    }

    public Bitmap transform(Bitmap source) {
        GPUImage gpuImage = new GPUImage(this.mContext);
        gpuImage.setImage(source);
        gpuImage.setFilter(this.mFilter);
        Bitmap bitmap = gpuImage.getBitmapWithFilterApplied();
        source.recycle();
        return bitmap;
    }

    public String key() {
        return getClass().getSimpleName();
    }

    public <T> T getFilter() {
        return this.mFilter;
    }
}

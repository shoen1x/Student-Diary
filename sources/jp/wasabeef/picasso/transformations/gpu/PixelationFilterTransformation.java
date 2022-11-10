package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImagePixelationFilter;

public class PixelationFilterTransformation extends GPUFilterTransformation {
    private float mPixel;

    public PixelationFilterTransformation(Context context) {
        this(context, 10.0f);
    }

    public PixelationFilterTransformation(Context context, float pixel) {
        super(context, new GPUImagePixelationFilter());
        this.mPixel = pixel;
        ((GPUImagePixelationFilter) getFilter()).setPixel(this.mPixel);
    }

    public String key() {
        return "PixelationFilterTransformation(pixel=" + this.mPixel + ")";
    }
}

package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageSepiaFilter;

public class SepiaFilterTransformation extends GPUFilterTransformation {
    private float mIntensity;

    public SepiaFilterTransformation(Context context) {
        this(context, 1.0f);
    }

    public SepiaFilterTransformation(Context context, float intensity) {
        super(context, new GPUImageSepiaFilter());
        this.mIntensity = intensity;
        ((GPUImageSepiaFilter) getFilter()).setIntensity(this.mIntensity);
    }

    public String key() {
        return "SepiaFilterTransformation(intensity=" + this.mIntensity + ")";
    }
}

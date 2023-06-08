package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageBrightnessFilter;

public class BrightnessFilterTransformation extends GPUFilterTransformation {
    private float mBrightness;

    public BrightnessFilterTransformation(Context context) {
        this(context, 0.0f);
    }

    public BrightnessFilterTransformation(Context context, float brightness) {
        super(context, new GPUImageBrightnessFilter());
        this.mBrightness = brightness;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(this.mBrightness);
    }

    public String key() {
        return "BrightnessFilterTransformation(brightness=" + this.mBrightness + ")";
    }
}

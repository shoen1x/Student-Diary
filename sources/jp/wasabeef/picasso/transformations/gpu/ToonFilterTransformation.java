package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageToonFilter;

public class ToonFilterTransformation extends GPUFilterTransformation {
    private float mQuantizationLevels;
    private float mThreshold;

    public ToonFilterTransformation(Context context) {
        this(context, 0.2f, 10.0f);
    }

    public ToonFilterTransformation(Context context, float threshold, float quantizationLevels) {
        super(context, new GPUImageToonFilter());
        this.mThreshold = threshold;
        this.mQuantizationLevels = quantizationLevels;
        GPUImageToonFilter filter = (GPUImageToonFilter) getFilter();
        filter.setThreshold(this.mThreshold);
        filter.setQuantizationLevels(this.mQuantizationLevels);
    }

    public String key() {
        return "ToonFilterTransformation(threshold=" + this.mThreshold + ",quantizationLevels=" + this.mQuantizationLevels + ")";
    }
}

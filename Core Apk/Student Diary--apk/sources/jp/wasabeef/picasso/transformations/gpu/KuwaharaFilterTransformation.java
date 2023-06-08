package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageKuwaharaFilter;

public class KuwaharaFilterTransformation extends GPUFilterTransformation {
    private int mRadius;

    public KuwaharaFilterTransformation(Context context) {
        this(context, 25);
    }

    public KuwaharaFilterTransformation(Context context, int radius) {
        super(context, new GPUImageKuwaharaFilter());
        this.mRadius = radius;
        ((GPUImageKuwaharaFilter) getFilter()).setRadius(this.mRadius);
    }

    public String key() {
        return "KuwaharaFilterTransformation(radius=" + this.mRadius + ")";
    }
}

package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageContrastFilter;

public class ContrastFilterTransformation extends GPUFilterTransformation {
    private float mContrast;

    public ContrastFilterTransformation(Context context) {
        this(context, 1.0f);
    }

    public ContrastFilterTransformation(Context context, float contrast) {
        super(context, new GPUImageContrastFilter());
        this.mContrast = contrast;
        ((GPUImageContrastFilter) getFilter()).setContrast(this.mContrast);
    }

    public String key() {
        return "ContrastFilterTransformation(contrast=" + this.mContrast + ")";
    }
}

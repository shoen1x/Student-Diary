package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageColorInvertFilter;

public class InvertFilterTransformation extends GPUFilterTransformation {
    public InvertFilterTransformation(Context context) {
        super(context, new GPUImageColorInvertFilter());
    }

    public String key() {
        return "InvertFilterTransformation()";
    }
}

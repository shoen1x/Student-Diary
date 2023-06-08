package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.GPUImageSketchFilter;

public class SketchFilterTransformation extends GPUFilterTransformation {
    public SketchFilterTransformation(Context context) {
        super(context, new GPUImageSketchFilter());
    }

    public String key() {
        return "SketchFilterTransformation()";
    }
}

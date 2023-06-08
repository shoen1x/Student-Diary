package jp.wasabeef.picasso.transformations.gpu;

import android.content.Context;
import android.graphics.PointF;
import jp.co.cyberagent.android.gpuimage.GPUImageSwirlFilter;

public class SwirlFilterTransformation extends GPUFilterTransformation {
    private float mAngle;
    private PointF mCenter;
    private float mRadius;

    public SwirlFilterTransformation(Context context) {
        this(context, 0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public SwirlFilterTransformation(Context context, float radius, float angle, PointF center) {
        super(context, new GPUImageSwirlFilter());
        this.mRadius = radius;
        this.mAngle = angle;
        this.mCenter = center;
        GPUImageSwirlFilter filter = (GPUImageSwirlFilter) getFilter();
        filter.setRadius(this.mRadius);
        filter.setAngle(this.mAngle);
        filter.setCenter(this.mCenter);
    }

    public String key() {
        return "SwirlFilterTransformation(radius=" + this.mRadius + ",angle=" + this.mAngle + ",center=" + this.mCenter.toString() + ")";
    }
}

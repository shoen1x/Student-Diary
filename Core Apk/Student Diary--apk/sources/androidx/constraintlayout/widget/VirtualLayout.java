package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

public abstract class VirtualLayout extends ConstraintHelper {
    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VirtualLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout layout, int widthMeasureSpec, int heightMeasureSpec) {
    }
}

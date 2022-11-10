package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int orientation) {
        if (orientation == 0) {
            return this.horizontalRun;
        }
        if (orientation == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean inVirtualLayout) {
        this.mInVirtuaLayout = inVirtualLayout;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxDimension[0] = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxDimension[1] = maxHeight;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean hasBaseline2) {
        this.hasBaseline = hasBaseline2;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean inPlaceholder2) {
        this.inPlaceholder = inPlaceholder2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0};
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int x, int y, int width, int height) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0};
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = x;
        this.mY = y;
        this.mWidth = width;
        this.mHeight = height;
        addAnchors();
    }

    public ConstraintWidget(int width, int height) {
        this(0, 0, width, height);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget widget) {
        this.mParent = widget;
    }

    public void setWidthWrapContent(boolean widthWrapContent) {
        this.mIsWidthWrapContent = widthWrapContent;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean heightWrapContent) {
        this.mIsHeightWrapContent = heightWrapContent;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget target, float angle, int radius) {
        immediateConnect(ConstraintAnchor.Type.CENTER, target, ConstraintAnchor.Type.CENTER, radius, 0);
        this.mCircleConstraintAngle = angle;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String name) {
        this.mDebugName = name;
    }

    public void setDebugSolverName(LinearSystem system, String name) {
        this.mDebugName = name;
        SolverVariable left = system.createObjectVariable(this.mLeft);
        SolverVariable top = system.createObjectVariable(this.mTop);
        SolverVariable right = system.createObjectVariable(this.mRight);
        SolverVariable bottom = system.createObjectVariable(this.mBottom);
        left.setName(name + ".left");
        top.setName(name + ".top");
        right.setName(name + ".right");
        bottom.setName(name + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable baseline = system.createObjectVariable(this.mBaseline);
            baseline.setName(name + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem system) {
        SolverVariable createObjectVariable = system.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = system.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = system.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = system.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            system.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int w;
        int w2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return w2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            w = Math.max(this.mMatchConstraintMinWidth, w2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            w = this.mMatchConstraintMinWidth;
            this.mWidth = w;
        } else {
            w = 0;
        }
        int i = this.mMatchConstraintMaxWidth;
        if (i <= 0 || i >= w) {
            return w;
        }
        return this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int h;
        int h2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return h2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            h = Math.max(this.mMatchConstraintMinHeight, h2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            h = this.mMatchConstraintMinHeight;
            this.mHeight = h;
        } else {
            h = 0;
        }
        int i = this.mMatchConstraintMaxHeight;
        if (i <= 0 || i >= h) {
            return h;
        }
        return this.mMatchConstraintMaxHeight;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int orientation) {
        if (orientation == 0) {
            return getWidth();
        }
        if (orientation == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        int margin = 0;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            margin = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return margin + constraintAnchor2.mMargin;
        }
        return margin;
    }

    public int getVerticalMargin() {
        int margin = 0;
        if (this.mLeft != null) {
            margin = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return margin + this.mBottom.mMargin;
        }
        return margin;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int orientation) {
        if (orientation == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (orientation == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public void setY(int y) {
        this.mY = y;
    }

    public void setOrigin(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public void setOffset(int x, int y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int goneMargin) {
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i == 1) {
            this.mLeft.mGoneMargin = goneMargin;
        } else if (i == 2) {
            this.mTop.mGoneMargin = goneMargin;
        } else if (i == 3) {
            this.mRight.mGoneMargin = goneMargin;
        } else if (i == 4) {
            this.mBottom.mGoneMargin = goneMargin;
        }
    }

    public void setWidth(int w) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
    }

    public void setHeight(int h) {
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
    }

    public void setLength(int length, int orientation) {
        if (orientation == 0) {
            setWidth(length);
        } else if (orientation == 1) {
            setHeight(length);
        }
    }

    public void setHorizontalMatchStyle(int horizontalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultWidth = horizontalMatchStyle;
        this.mMatchConstraintMinWidth = min;
        this.mMatchConstraintMaxWidth = max;
        this.mMatchConstraintPercentWidth = percent;
        if (percent < 1.0f && horizontalMatchStyle == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int verticalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultHeight = verticalMatchStyle;
        this.mMatchConstraintMinHeight = min;
        this.mMatchConstraintMaxHeight = max;
        this.mMatchConstraintPercentHeight = percent;
        if (percent < 1.0f && verticalMatchStyle == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
            commaIndex = 0;
        } else {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex < 0 || colonIndex >= len - 1) {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.mDimensionRatio = dimensionRatio;
            this.mDimensionRatioSide = dimensionRatioSide;
        }
    }

    public void setDimensionRatio(float ratio, int dimensionRatioSide) {
        this.mDimensionRatio = ratio;
        this.mDimensionRatioSide = dimensionRatioSide;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float horizontalBiasPercent) {
        this.mHorizontalBiasPercent = horizontalBiasPercent;
    }

    public void setVerticalBiasPercent(float verticalBiasPercent) {
        this.mVerticalBiasPercent = verticalBiasPercent;
    }

    public void setMinWidth(int w) {
        if (w < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = w;
        }
    }

    public void setMinHeight(int h) {
        if (h < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = h;
        }
    }

    public void setDimension(int w, int h) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
        this.mHeight = h;
        int i2 = this.mMinHeight;
        if (h < i2) {
            this.mHeight = i2;
        }
    }

    public void setFrame(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.mX = left;
        this.mY = top;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
            w = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h < this.mHeight) {
            h = this.mHeight;
        }
        this.mWidth = w;
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
        int i2 = this.mWidth;
        int i3 = this.mMinWidth;
        if (i2 < i3) {
            this.mWidth = i3;
        }
    }

    public void setFrame(int start, int end, int orientation) {
        if (orientation == 0) {
            setHorizontalDimension(start, end);
        } else if (orientation == 1) {
            setVerticalDimension(start, end);
        }
    }

    public void setHorizontalDimension(int left, int right) {
        this.mX = left;
        int i = right - left;
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setVerticalDimension(int top, int bottom) {
        this.mY = top;
        int i = bottom - top;
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int orientation) {
        if (orientation == 0) {
            return this.mRelX;
        }
        if (orientation == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int offset, int orientation) {
        if (orientation == 0) {
            this.mRelX = offset;
        } else if (orientation == 1) {
            this.mRelY = offset;
        }
    }

    public void setBaselineDistance(int baseline) {
        this.mBaselineDistance = baseline;
    }

    public void setCompanionWidget(Object companion) {
        this.mCompanionWidget = companion;
    }

    public void setContainerItemSkip(int skip) {
        if (skip >= 0) {
            this.mContainerItemSkip = skip;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float horizontalWeight) {
        this.mWeight[0] = horizontalWeight;
    }

    public void setVerticalWeight(float verticalWeight) {
        this.mWeight[1] = verticalWeight;
    }

    public void setHorizontalChainStyle(int horizontalChainStyle) {
        this.mHorizontalChainStyle = horizontalChainStyle;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int verticalChainStyle) {
        this.mVerticalChainStyle = verticalChainStyle;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type startType, ConstraintWidget target, ConstraintAnchor.Type endType, int margin, int goneMargin) {
        getAnchor(startType).connect(target.getAnchor(endType), margin, goneMargin, true);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin) {
        if (from.getOwner() == this) {
            connect(from.getType(), to.getOwner(), to.getType(), margin);
        }
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo) {
        connect(constraintFrom, target, constraintTo, 0);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin) {
        if (constraintFrom == ConstraintAnchor.Type.CENTER) {
            if (constraintTo == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean centerX = false;
                boolean centerY = false;
                if ((left == null || !left.isConnected()) && (right == null || !right.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, target, ConstraintAnchor.Type.LEFT, 0);
                    connect(ConstraintAnchor.Type.RIGHT, target, ConstraintAnchor.Type.RIGHT, 0);
                    centerX = true;
                }
                if ((top == null || !top.isConnected()) && (bottom == null || !bottom.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, target, ConstraintAnchor.Type.TOP, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, target, ConstraintAnchor.Type.BOTTOM, 0);
                    centerY = true;
                }
                if (centerX && centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                } else if (centerX) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, target, constraintTo, 0);
                connect(ConstraintAnchor.Type.RIGHT, target, constraintTo, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
            } else if (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, target, constraintTo, 0);
                connect(ConstraintAnchor.Type.BOTTOM, target, constraintTo, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
            }
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_X && (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor left2 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = target.getAnchor(constraintTo);
            ConstraintAnchor right2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            left2.connect(targetAnchor, 0);
            right2.connect(targetAnchor, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(targetAnchor, 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor targetAnchor2 = target.getAnchor(constraintTo);
            getAnchor(ConstraintAnchor.Type.TOP).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(targetAnchor2, 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_X && constraintTo == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(constraintTo), 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && constraintTo == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(constraintTo), 0);
        } else {
            ConstraintAnchor fromAnchor = getAnchor(constraintFrom);
            ConstraintAnchor toAnchor = target.getAnchor(constraintTo);
            if (fromAnchor.isValidConnection(toAnchor)) {
                if (constraintFrom == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor top2 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor bottom2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (top2 != null) {
                        top2.reset();
                    }
                    if (bottom2 != null) {
                        bottom2.reset();
                    }
                    margin = 0;
                } else if (constraintFrom == ConstraintAnchor.Type.TOP || constraintFrom == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor baseline = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (baseline != null) {
                        baseline.reset();
                    }
                    ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (center.getTarget() != toAnchor) {
                        center.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(constraintFrom).getOpposite();
                    ConstraintAnchor centerY2 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (centerY2.isConnected()) {
                        opposite.reset();
                        centerY2.reset();
                    }
                } else if (constraintFrom == ConstraintAnchor.Type.LEFT || constraintFrom == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor center2 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (center2.getTarget() != toAnchor) {
                        center2.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(constraintFrom).getOpposite();
                    ConstraintAnchor centerX2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (centerX2.isConnected()) {
                        opposite2.reset();
                        centerX2.reset();
                    }
                }
                fromAnchor.connect(toAnchor, margin);
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor anchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor centerX = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor centerY = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (anchor == center) {
                if (left.isConnected() && right.isConnected() && left.getTarget() == right.getTarget()) {
                    left.reset();
                    right.reset();
                }
                if (top.isConnected() && bottom.isConnected() && top.getTarget() == bottom.getTarget()) {
                    top.reset();
                    bottom.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == centerX) {
                if (left.isConnected() && right.isConnected() && left.getTarget().getOwner() == right.getTarget().getOwner()) {
                    left.reset();
                    right.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (anchor == centerY) {
                if (top.isConnected() && bottom.isConnected() && top.getTarget().getOwner() == bottom.getTarget().getOwner()) {
                    top.reset();
                    bottom.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == left || anchor == right) {
                if (left.isConnected() && left.getTarget() == right.getTarget()) {
                    center.reset();
                }
            } else if ((anchor == top || anchor == bottom) && top.isConnected() && top.getTarget() == bottom.getTarget()) {
                center.reset();
            }
            anchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int mAnchorsSize = this.mAnchors.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type anchorType) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[anchorType.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int orientation) {
        if (orientation == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (orientation == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[0] = behaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[1] = behaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) {
            return true;
        }
        if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != this.mRight) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getPreviousChainMember(int orientation) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (orientation == 0) {
            if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != (constraintAnchor2 = this.mLeft)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (orientation == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == (constraintAnchor = this.mTop)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getNextChainMember(int orientation) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (orientation == 0) {
            if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != (constraintAnchor2 = this.mRight)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (orientation == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == (constraintAnchor = this.mBottom)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) {
            return true;
        }
        if (this.mBottom.mTarget == null || this.mBottom.mTarget.mTarget != this.mBottom) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    private boolean isChainHead(int orientation) {
        int offset = orientation * 2;
        if (this.mListAnchors[offset].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[offset].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            return (constraintAnchor == constraintAnchorArr[offset] || constraintAnchorArr[offset + 1].mTarget == null || this.mListAnchors[offset + 1].mTarget.mTarget != this.mListAnchors[offset + 1]) ? false : true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0292, code lost:
        if (r3 == -1) goto L_0x0296;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0490  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0499  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x04a8  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r57) {
        /*
            r56 = this;
            r11 = r56
            r2 = r57
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mLeft
            androidx.constraintlayout.solver.SolverVariable r1 = r2.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r11.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r2.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r11.mTop
            androidx.constraintlayout.solver.SolverVariable r14 = r2.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r11.mBottom
            androidx.constraintlayout.solver.SolverVariable r13 = r2.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r11.mBaseline
            androidx.constraintlayout.solver.SolverVariable r12 = r2.createObjectVariable(r3)
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r4 = 1
            if (r3 == 0) goto L_0x002f
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r6 = r3.widgets
            long r6 = r6 + r4
            r3.widgets = r6
        L_0x002f:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            boolean r3 = r3.resolved
            r10 = 6
            r9 = 1
            r8 = 0
            if (r3 == 0) goto L_0x00dd
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            boolean r3 = r3.resolved
            if (r3 == 0) goto L_0x00dd
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r3 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            boolean r3 = r3.resolved
            if (r3 == 0) goto L_0x00dd
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r3 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            boolean r3 = r3.resolved
            if (r3 == 0) goto L_0x00dd
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x005d
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r6 = r3.graphSolved
            long r6 = r6 + r4
            r3.graphSolved = r6
        L_0x005d:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            int r3 = r3.value
            r2.addEquality(r1, r3)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            int r3 = r3.value
            r2.addEquality(r0, r3)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r3 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            int r3 = r3.value
            r2.addEquality(r14, r3)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r3 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            int r3 = r3.value
            r2.addEquality(r13, r3)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r3 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.baseline
            int r3 = r3.value
            r2.addEquality(r12, r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r11.mParent
            if (r3 == 0) goto L_0x00dc
            if (r3 == 0) goto L_0x009a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r3.mListDimensionBehaviors
            r3 = r3[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r4) goto L_0x009a
            r3 = r9
            goto L_0x009b
        L_0x009a:
            r3 = r8
        L_0x009b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r11.mParent
            if (r4 == 0) goto L_0x00a9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.mListDimensionBehaviors
            r4 = r4[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r5) goto L_0x00a9
            r4 = r9
            goto L_0x00aa
        L_0x00a9:
            r4 = r8
        L_0x00aa:
            if (r3 == 0) goto L_0x00c3
            boolean[] r5 = r11.isTerminalWidget
            boolean r5 = r5[r8]
            if (r5 == 0) goto L_0x00c3
            boolean r5 = r56.isInHorizontalChain()
            if (r5 != 0) goto L_0x00c3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mRight
            androidx.constraintlayout.solver.SolverVariable r5 = r2.createObjectVariable(r5)
            r2.addGreaterThan(r5, r0, r8, r10)
        L_0x00c3:
            if (r4 == 0) goto L_0x00dc
            boolean[] r5 = r11.isTerminalWidget
            boolean r5 = r5[r9]
            if (r5 == 0) goto L_0x00dc
            boolean r5 = r56.isInVerticalChain()
            if (r5 != 0) goto L_0x00dc
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mBottom
            androidx.constraintlayout.solver.SolverVariable r5 = r2.createObjectVariable(r5)
            r2.addGreaterThan(r5, r13, r8, r10)
        L_0x00dc:
            return
        L_0x00dd:
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x00e8
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r6 = r3.linearSolved
            long r6 = r6 + r4
            r3.linearSolved = r6
        L_0x00e8:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            r15 = 8
            if (r7 == 0) goto L_0x017e
            if (r7 == 0) goto L_0x00fe
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r7.mListDimensionBehaviors
            r7 = r7[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r10) goto L_0x00fe
            r7 = r9
            goto L_0x00ff
        L_0x00fe:
            r7 = r8
        L_0x00ff:
            r5 = r7
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            if (r7 == 0) goto L_0x010e
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r7.mListDimensionBehaviors
            r7 = r7[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r10) goto L_0x010e
            r7 = r9
            goto L_0x010f
        L_0x010e:
            r7 = r8
        L_0x010f:
            r6 = r7
            boolean r7 = r11.isChainHead(r8)
            if (r7 == 0) goto L_0x011f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r7
            r7.addChain(r11, r8)
            r3 = 1
            goto L_0x0123
        L_0x011f:
            boolean r3 = r56.isInHorizontalChain()
        L_0x0123:
            boolean r7 = r11.isChainHead(r9)
            if (r7 == 0) goto L_0x0132
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r7
            r7.addChain(r11, r9)
            r4 = 1
            goto L_0x0136
        L_0x0132:
            boolean r4 = r56.isInVerticalChain()
        L_0x0136:
            if (r3 != 0) goto L_0x0155
            if (r5 == 0) goto L_0x0155
            int r7 = r11.mVisibility
            if (r7 == r15) goto L_0x0155
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r11.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x0155
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r11.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x0155
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mRight
            androidx.constraintlayout.solver.SolverVariable r7 = r2.createObjectVariable(r7)
            r2.addGreaterThan(r7, r0, r8, r9)
        L_0x0155:
            if (r4 != 0) goto L_0x0178
            if (r6 == 0) goto L_0x0178
            int r7 = r11.mVisibility
            if (r7 == r15) goto L_0x0178
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r11.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x0178
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r11.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x0178
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r11.mBaseline
            if (r7 != 0) goto L_0x0178
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mBottom
            androidx.constraintlayout.solver.SolverVariable r7 = r2.createObjectVariable(r7)
            r2.addGreaterThan(r7, r13, r8, r9)
        L_0x0178:
            r40 = r3
            r41 = r4
            r10 = r5
            goto L_0x0183
        L_0x017e:
            r40 = r3
            r41 = r4
            r10 = r5
        L_0x0183:
            int r3 = r11.mWidth
            int r4 = r11.mMinWidth
            if (r3 >= r4) goto L_0x018b
            int r3 = r11.mMinWidth
        L_0x018b:
            int r4 = r11.mHeight
            int r5 = r11.mMinHeight
            if (r4 >= r5) goto L_0x0193
            int r4 = r11.mMinHeight
        L_0x0193:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r11.mListDimensionBehaviors
            r5 = r5[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 == r7) goto L_0x019d
            r5 = r9
            goto L_0x019e
        L_0x019d:
            r5 = r8
        L_0x019e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r11.mListDimensionBehaviors
            r7 = r7[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 == r9) goto L_0x01a8
            r7 = 1
            goto L_0x01a9
        L_0x01a8:
            r7 = r8
        L_0x01a9:
            r9 = r7
            r7 = 0
            int r8 = r11.mDimensionRatioSide
            r11.mResolvedDimensionRatioSide = r8
            float r8 = r11.mDimensionRatio
            r11.mResolvedDimensionRatio = r8
            int r15 = r11.mMatchConstraintDefaultWidth
            r20 = r3
            int r3 = r11.mMatchConstraintDefaultHeight
            r21 = 0
            int r8 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            r21 = r14
            if (r8 <= 0) goto L_0x0277
            int r8 = r11.mVisibility
            r14 = 8
            if (r8 == r14) goto L_0x0277
            r7 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r18 = 0
            r8 = r8[r18]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r14) goto L_0x01d5
            if (r15 != 0) goto L_0x01d5
            r15 = 3
        L_0x01d5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 1
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r14) goto L_0x01e1
            if (r3 != 0) goto L_0x01e1
            r3 = 3
        L_0x01e1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 0
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r23 = r4
            r4 = 3
            if (r8 != r14) goto L_0x01ff
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 1
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r14) goto L_0x01ff
            if (r15 != r4) goto L_0x01ff
            if (r3 != r4) goto L_0x01ff
            r11.setupDimensionRatio(r10, r6, r5, r9)
            goto L_0x0279
        L_0x01ff:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 0
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r14) goto L_0x0235
            if (r15 != r4) goto L_0x0235
            r4 = 0
            r11.mResolvedDimensionRatioSide = r4
            float r4 = r11.mResolvedDimensionRatio
            int r8 = r11.mHeight
            float r8 = (float) r8
            float r4 = r4 * r8
            int r4 = (int) r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 1
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 == r14) goto L_0x022a
            r15 = 4
            r7 = 0
            r42 = r3
            r43 = r4
            r45 = r7
            r46 = r15
            r44 = r23
            goto L_0x0283
        L_0x022a:
            r42 = r3
            r43 = r4
            r45 = r7
            r46 = r15
            r44 = r23
            goto L_0x0283
        L_0x0235:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 1
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r14) goto L_0x0279
            if (r3 != r4) goto L_0x0279
            r4 = 1
            r11.mResolvedDimensionRatioSide = r4
            int r4 = r11.mDimensionRatioSide
            r8 = -1
            if (r4 != r8) goto L_0x024f
            r4 = 1065353216(0x3f800000, float:1.0)
            float r8 = r11.mResolvedDimensionRatio
            float r4 = r4 / r8
            r11.mResolvedDimensionRatio = r4
        L_0x024f:
            float r4 = r11.mResolvedDimensionRatio
            int r8 = r11.mWidth
            float r8 = (float) r8
            float r4 = r4 * r8
            int r4 = (int) r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r14 = 0
            r8 = r8[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 == r14) goto L_0x026c
            r3 = 4
            r7 = 0
            r42 = r3
            r44 = r4
            r45 = r7
            r46 = r15
            r43 = r20
            goto L_0x0283
        L_0x026c:
            r42 = r3
            r44 = r4
            r45 = r7
            r46 = r15
            r43 = r20
            goto L_0x0283
        L_0x0277:
            r23 = r4
        L_0x0279:
            r42 = r3
            r45 = r7
            r46 = r15
            r43 = r20
            r44 = r23
        L_0x0283:
            int[] r3 = r11.mResolvedMatchConstraintDefault
            r4 = 0
            r3[r4] = r46
            r14 = 1
            r3[r14] = r42
            if (r45 == 0) goto L_0x0298
            int r3 = r11.mResolvedDimensionRatioSide
            if (r3 == 0) goto L_0x0295
            r8 = -1
            if (r3 != r8) goto L_0x0299
            goto L_0x0296
        L_0x0295:
            r8 = -1
        L_0x0296:
            r15 = r14
            goto L_0x029a
        L_0x0298:
            r8 = -1
        L_0x0299:
            r15 = 0
        L_0x029a:
            r3 = 8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r11.mListDimensionBehaviors
            r7 = 0
            r4 = r4[r7]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r7) goto L_0x02ab
            boolean r4 = r11 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r4 == 0) goto L_0x02ab
            r7 = r14
            goto L_0x02ac
        L_0x02ab:
            r7 = 0
        L_0x02ac:
            r4 = 1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r11.mCenter
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02b9
            r4 = 0
            r24 = r4
            goto L_0x02bb
        L_0x02b9:
            r24 = r4
        L_0x02bb:
            int r3 = r11.mHorizontalResolution
            r4 = 2
            r25 = 0
            if (r3 == r4) goto L_0x03bc
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            boolean r3 = r3.resolved
            if (r3 == 0) goto L_0x0344
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            boolean r3 = r3.resolved
            if (r3 != 0) goto L_0x02d5
            r14 = 6
            goto L_0x0345
        L_0x02d5:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            int r3 = r3.value
            r2.addEquality(r1, r3)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r3 = r11.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.end
            int r3 = r3.value
            r2.addEquality(r0, r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r11.mParent
            if (r3 == 0) goto L_0x032f
            if (r10 == 0) goto L_0x031a
            boolean[] r3 = r11.isTerminalWidget
            r4 = 0
            boolean r3 = r3[r4]
            if (r3 == 0) goto L_0x031a
            boolean r3 = r56.isInHorizontalChain()
            if (r3 != 0) goto L_0x031a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r11.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r2.createObjectVariable(r3)
            r14 = 6
            r2.addGreaterThan(r3, r0, r4, r14)
            r54 = r0
            r55 = r1
            r47 = r5
            r48 = r6
            r49 = r9
            r50 = r10
            r51 = r12
            r52 = r13
            r53 = r21
            goto L_0x03ce
        L_0x031a:
            r14 = 6
            r54 = r0
            r55 = r1
            r47 = r5
            r48 = r6
            r49 = r9
            r50 = r10
            r51 = r12
            r52 = r13
            r53 = r21
            goto L_0x03ce
        L_0x032f:
            r14 = 6
            r54 = r0
            r55 = r1
            r47 = r5
            r48 = r6
            r49 = r9
            r50 = r10
            r51 = r12
            r52 = r13
            r53 = r21
            goto L_0x03ce
        L_0x0344:
            r14 = 6
        L_0x0345:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r11.mParent
            if (r3 == 0) goto L_0x0350
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r2.createObjectVariable(r3)
            goto L_0x0352
        L_0x0350:
            r3 = r25
        L_0x0352:
            r47 = r5
            r5 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r11.mParent
            if (r3 == 0) goto L_0x0361
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mLeft
            androidx.constraintlayout.solver.SolverVariable r3 = r2.createObjectVariable(r3)
            r4 = r3
            goto L_0x0363
        L_0x0361:
            r4 = r25
        L_0x0363:
            r3 = 2
            boolean[] r3 = r11.isTerminalWidget
            r16 = 0
            boolean r3 = r3[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r11.mListDimensionBehaviors
            r8 = r8[r16]
            r48 = r6
            r6 = r8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r11.mLeft
            r26 = r3
            r3 = r16
            r16 = -1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r11.mRight
            r49 = r9
            r9 = r14
            int r14 = r11.mX
            r50 = r10
            r10 = r14
            int r14 = r11.mMinWidth
            r51 = r12
            r12 = r14
            int[] r14 = r11.mMaxDimension
            r14 = r14[r3]
            r52 = r13
            r13 = r14
            float r14 = r11.mHorizontalBiasPercent
            r53 = r21
            int r3 = r11.mMatchConstraintMinWidth
            r20 = r3
            int r3 = r11.mMatchConstraintMaxWidth
            r21 = r3
            float r3 = r11.mMatchConstraintPercentWidth
            r22 = r3
            r54 = r0
            r0 = r56
            r55 = r1
            r1 = r57
            r3 = r2
            r2 = r50
            r11 = r43
            r16 = r40
            r17 = r41
            r18 = r46
            r19 = r42
            r23 = r24
            r3 = r26
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            goto L_0x03ce
        L_0x03bc:
            r54 = r0
            r55 = r1
            r47 = r5
            r48 = r6
            r49 = r9
            r50 = r10
            r51 = r12
            r52 = r13
            r53 = r21
        L_0x03ce:
            r0 = 1
            r8 = r56
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r8.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x042a
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r8.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x042a
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r8.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.start
            int r1 = r1.value
            r9 = r57
            r10 = r53
            r9.addEquality(r10, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r8.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.value
            r11 = r52
            r9.addEquality(r11, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r8.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.baseline
            int r1 = r1.value
            r12 = r51
            r9.addEquality(r12, r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.mParent
            if (r1 == 0) goto L_0x0425
            if (r41 != 0) goto L_0x0421
            if (r48 == 0) goto L_0x0421
            boolean[] r2 = r8.isTerminalWidget
            r3 = 1
            boolean r2 = r2[r3]
            if (r2 == 0) goto L_0x041f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r2 = 6
            r4 = 0
            r9.addGreaterThan(r1, r11, r4, r2)
            goto L_0x0428
        L_0x041f:
            r2 = 6
            goto L_0x0423
        L_0x0421:
            r2 = 6
            r3 = 1
        L_0x0423:
            r4 = 0
            goto L_0x0428
        L_0x0425:
            r2 = 6
            r3 = 1
            r4 = 0
        L_0x0428:
            r0 = 0
            goto L_0x0435
        L_0x042a:
            r9 = r57
            r12 = r51
            r11 = r52
            r10 = r53
            r2 = 6
            r3 = 1
            r4 = 0
        L_0x0435:
            int r1 = r8.mVerticalResolution
            r5 = 2
            if (r1 != r5) goto L_0x043d
            r0 = 0
            r13 = r0
            goto L_0x043e
        L_0x043d:
            r13 = r0
        L_0x043e:
            if (r13 == 0) goto L_0x04ef
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r8.mListDimensionBehaviors
            r0 = r0[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x044f
            boolean r0 = r8 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x044f
            r23 = r3
            goto L_0x0451
        L_0x044f:
            r23 = r4
        L_0x0451:
            if (r45 == 0) goto L_0x045d
            int r0 = r8.mResolvedDimensionRatioSide
            if (r0 == r3) goto L_0x045a
            r1 = -1
            if (r0 != r1) goto L_0x045d
        L_0x045a:
            r31 = r3
            goto L_0x045f
        L_0x045d:
            r31 = r4
        L_0x045f:
            int r0 = r8.mBaselineDistance
            if (r0 <= 0) goto L_0x0481
            int r0 = r56.getBaselineDistance()
            r9.addEquality(r12, r10, r0, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x048a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r1 = 0
            r9.addEquality(r12, r0, r1, r2)
            r24 = 0
            r0 = r24
            goto L_0x048c
        L_0x0481:
            int r0 = r8.mVisibility
            r1 = 8
            if (r0 != r1) goto L_0x048a
            r9.addEquality(r12, r10, r4, r2)
        L_0x048a:
            r0 = r24
        L_0x048c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.mParent
            if (r1 == 0) goto L_0x0499
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r21 = r1
            goto L_0x049b
        L_0x0499:
            r21 = r25
        L_0x049b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.mParent
            if (r1 == 0) goto L_0x04a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTop
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r20 = r1
            goto L_0x04aa
        L_0x04a8:
            r20 = r25
        L_0x04aa:
            boolean[] r1 = r8.isTerminalWidget
            boolean r19 = r1[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r8.mListDimensionBehaviors
            r22 = r1[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r8.mTop
            r24 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r8.mBottom
            r25 = r1
            int r1 = r8.mY
            r26 = r1
            int r1 = r8.mMinHeight
            r28 = r1
            int[] r1 = r8.mMaxDimension
            r29 = r1[r3]
            float r1 = r8.mVerticalBiasPercent
            r30 = r1
            int r1 = r8.mMatchConstraintMinHeight
            r36 = r1
            int r1 = r8.mMatchConstraintMaxHeight
            r37 = r1
            float r1 = r8.mMatchConstraintPercentHeight
            r38 = r1
            r16 = r56
            r17 = r57
            r18 = r48
            r27 = r44
            r32 = r41
            r33 = r40
            r34 = r42
            r35 = r46
            r39 = r0
            r16.applyConstraints(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            r24 = r0
            r7 = r23
        L_0x04ef:
            if (r45 == 0) goto L_0x0513
            r14 = 6
            int r0 = r8.mResolvedDimensionRatioSide
            if (r0 != r3) goto L_0x0505
            float r5 = r8.mResolvedDimensionRatio
            r0 = r57
            r1 = r11
            r2 = r10
            r3 = r54
            r4 = r55
            r6 = r14
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0513
        L_0x0505:
            float r5 = r8.mResolvedDimensionRatio
            r0 = r57
            r1 = r54
            r2 = r55
            r3 = r11
            r4 = r10
            r6 = r14
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x0513:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0539
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r8.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r8.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r8.mCenter
            int r2 = r2.getMargin()
            r9.addCenterPoint(r8, r0, r1, r2)
        L_0x0539:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public void setupDimensionRatio(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide != -1) {
            return;
        }
        if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
            this.mResolvedDimensionRatioSide = 0;
        } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r36, boolean r37, boolean r38, androidx.constraintlayout.solver.SolverVariable r39, androidx.constraintlayout.solver.SolverVariable r40, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r41, boolean r42, androidx.constraintlayout.solver.widgets.ConstraintAnchor r43, androidx.constraintlayout.solver.widgets.ConstraintAnchor r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r35 = this;
            r0 = r35
            r10 = r36
            r11 = r39
            r12 = r40
            r13 = r43
            r14 = r44
            r15 = r47
            r9 = r48
            r8 = r54
            androidx.constraintlayout.solver.SolverVariable r7 = r10.createObjectVariable(r13)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r43.getTarget()
            androidx.constraintlayout.solver.SolverVariable r5 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r44.getTarget()
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.Metrics r1 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r1 == 0) goto L_0x003c
            androidx.constraintlayout.solver.Metrics r1 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r2 = r1.nonresolvedWidgets
            r16 = 1
            long r2 = r2 + r16
            r1.nonresolvedWidgets = r2
        L_0x003c:
            boolean r16 = r43.isConnected()
            boolean r17 = r44.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mCenter
            boolean r18 = r1.isConnected()
            r1 = 0
            r2 = 0
            if (r16 == 0) goto L_0x0050
            int r2 = r2 + 1
        L_0x0050:
            if (r17 == 0) goto L_0x0054
            int r2 = r2 + 1
        L_0x0054:
            if (r18 == 0) goto L_0x005a
            int r2 = r2 + 1
            r3 = r2
            goto L_0x005b
        L_0x005a:
            r3 = r2
        L_0x005b:
            if (r50 == 0) goto L_0x005f
            r2 = 3
            goto L_0x0061
        L_0x005f:
            r2 = r53
        L_0x0061:
            int[] r19 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
            int r20 = r41.ordinal()
            r21 = r1
            r1 = r19[r20]
            r12 = 2
            r14 = 1
            if (r1 == r14) goto L_0x0083
            if (r1 == r12) goto L_0x0081
            r12 = 3
            if (r1 == r12) goto L_0x007f
            r12 = 4
            if (r1 == r12) goto L_0x007a
            r1 = r21
            goto L_0x0085
        L_0x007a:
            r1 = 1
            if (r2 != r12) goto L_0x0085
            r1 = 0
            goto L_0x0085
        L_0x007f:
            r1 = 0
            goto L_0x0085
        L_0x0081:
            r1 = 0
            goto L_0x0085
        L_0x0083:
            r1 = 0
        L_0x0085:
            int r12 = r0.mVisibility
            r14 = 8
            if (r12 != r14) goto L_0x008f
            r12 = 0
            r1 = 0
            r14 = r1
            goto L_0x0092
        L_0x008f:
            r12 = r46
            r14 = r1
        L_0x0092:
            if (r58 == 0) goto L_0x00b6
            if (r16 != 0) goto L_0x00a2
            if (r17 != 0) goto L_0x00a2
            if (r18 != 0) goto L_0x00a2
            r1 = r45
            r10.addEquality(r7, r1)
            r22 = r3
            goto L_0x00b8
        L_0x00a2:
            r1 = r45
            if (r16 == 0) goto L_0x00b3
            if (r17 != 0) goto L_0x00b3
            int r1 = r43.getMargin()
            r22 = r3
            r3 = 6
            r10.addEquality(r7, r5, r1, r3)
            goto L_0x00b8
        L_0x00b3:
            r22 = r3
            goto L_0x00b8
        L_0x00b6:
            r22 = r3
        L_0x00b8:
            r1 = 0
            if (r14 != 0) goto L_0x00ea
            if (r42 == 0) goto L_0x00d2
            r3 = 3
            r10.addEquality(r6, r7, r1, r3)
            if (r15 <= 0) goto L_0x00c8
            r3 = 6
            r10.addGreaterThan(r6, r7, r15, r3)
            goto L_0x00c9
        L_0x00c8:
            r3 = 6
        L_0x00c9:
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r9 >= r1) goto L_0x00d6
            r10.addLowerThan(r6, r7, r9, r3)
            goto L_0x00d6
        L_0x00d2:
            r3 = 6
            r10.addEquality(r6, r7, r12, r3)
        L_0x00d6:
            r19 = r55
            r24 = r56
            r26 = r2
            r0 = r4
            r28 = r5
            r25 = r12
            r27 = r14
            r13 = r22
            r12 = r38
            r14 = r6
            goto L_0x020c
        L_0x00ea:
            r1 = -2
            r3 = r55
            if (r3 != r1) goto L_0x00f0
            r3 = r12
        L_0x00f0:
            r24 = r4
            r4 = r56
            if (r4 != r1) goto L_0x00f8
            r1 = r12
            r4 = r1
        L_0x00f8:
            if (r3 <= 0) goto L_0x0119
            r1 = 1
            if (r37 == 0) goto L_0x0104
            r55 = r1
            r1 = 1
            if (r2 != r1) goto L_0x0106
            r1 = 0
            goto L_0x0108
        L_0x0104:
            r55 = r1
        L_0x0106:
            r1 = r55
        L_0x0108:
            if (r1 == 0) goto L_0x0111
            r25 = r5
            r5 = 5
            r10.addGreaterThan(r6, r7, r3, r5)
            goto L_0x0114
        L_0x0111:
            r25 = r5
            r5 = 5
        L_0x0114:
            int r12 = java.lang.Math.max(r12, r3)
            goto L_0x011c
        L_0x0119:
            r25 = r5
            r5 = 5
        L_0x011c:
            if (r4 <= 0) goto L_0x0130
            r1 = 1
            if (r37 == 0) goto L_0x0125
            r5 = 1
            if (r2 != r5) goto L_0x0125
            r1 = 0
        L_0x0125:
            if (r1 == 0) goto L_0x012b
            r5 = 6
            r10.addLowerThan(r6, r7, r4, r5)
        L_0x012b:
            int r5 = java.lang.Math.min(r12, r4)
            r12 = r5
        L_0x0130:
            r1 = 1
            if (r2 != r1) goto L_0x0156
            if (r37 == 0) goto L_0x013a
            r1 = 6
            r10.addEquality(r6, r7, r12, r1)
            goto L_0x0146
        L_0x013a:
            r1 = 6
            if (r51 == 0) goto L_0x0142
            r5 = 4
            r10.addEquality(r6, r7, r12, r5)
            goto L_0x0146
        L_0x0142:
            r5 = 4
            r10.addEquality(r6, r7, r12, r5)
        L_0x0146:
            r1 = r38
            r26 = r2
            r9 = r3
            r8 = r4
            r2 = r14
            r13 = r22
            r0 = r24
            r28 = r25
            r14 = r6
            goto L_0x01e3
        L_0x0156:
            r1 = 6
            r5 = 2
            if (r2 != r5) goto L_0x01d3
            r5 = 0
            r19 = 0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r43.getType()
            r26 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r1 == r2) goto L_0x018d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r43.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r1 != r2) goto L_0x0170
            goto L_0x018d
        L_0x0170:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.getAnchor(r5)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.createObjectVariable(r2)
            r19 = r1
            r27 = r2
            goto L_0x01a9
        L_0x018d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.getAnchor(r5)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.createObjectVariable(r2)
            r19 = r1
            r27 = r2
        L_0x01a9:
            androidx.constraintlayout.solver.ArrayRow r1 = r36.createRow()
            r2 = 6
            r5 = 0
            r9 = r2
            r46 = r14
            r14 = r26
            r2 = r6
            r9 = r3
            r13 = r22
            r0 = 5
            r3 = r7
            r8 = r4
            r0 = r24
            r4 = r27
            r28 = r25
            r14 = r5
            r5 = r19
            r14 = r6
            r6 = r57
            androidx.constraintlayout.solver.ArrayRow r1 = r1.createRowDimensionRatio(r2, r3, r4, r5, r6)
            r10.addConstraint(r1)
            r1 = 0
            r2 = r1
            r1 = r38
            goto L_0x01e3
        L_0x01d3:
            r26 = r2
            r9 = r3
            r8 = r4
            r46 = r14
            r13 = r22
            r0 = r24
            r28 = r25
            r14 = r6
            r1 = 1
            r2 = r46
        L_0x01e3:
            if (r2 == 0) goto L_0x0203
            r3 = 2
            if (r13 == r3) goto L_0x0203
            if (r50 != 0) goto L_0x0203
            r2 = 0
            int r3 = java.lang.Math.max(r9, r12)
            if (r8 <= 0) goto L_0x01f5
            int r3 = java.lang.Math.min(r8, r3)
        L_0x01f5:
            r4 = 6
            r10.addEquality(r14, r7, r3, r4)
            r27 = r2
            r24 = r8
            r19 = r9
            r25 = r12
            r12 = r1
            goto L_0x020c
        L_0x0203:
            r27 = r2
            r24 = r8
            r19 = r9
            r25 = r12
            r12 = r1
        L_0x020c:
            if (r58 == 0) goto L_0x0470
            if (r51 == 0) goto L_0x0222
            r2 = r40
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
            goto L_0x0480
        L_0x0222:
            if (r16 != 0) goto L_0x0238
            if (r17 != 0) goto L_0x0238
            if (r18 != 0) goto L_0x0238
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
            goto L_0x0459
        L_0x0238:
            if (r16 == 0) goto L_0x024c
            if (r17 != 0) goto L_0x024c
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
            goto L_0x0459
        L_0x024c:
            if (r16 != 0) goto L_0x0280
            if (r17 == 0) goto L_0x0280
            int r1 = r44.getMargin()
            int r1 = -r1
            r2 = 6
            r10.addEquality(r14, r0, r1, r2)
            if (r37 == 0) goto L_0x0270
            r1 = 5
            r2 = 0
            r10.addGreaterThan(r7, r11, r2, r1)
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
            goto L_0x0459
        L_0x0270:
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
            goto L_0x0459
        L_0x0280:
            if (r16 == 0) goto L_0x044b
            if (r17 == 0) goto L_0x044b
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 5
            r29 = r37
            r30 = r37
            if (r27 == 0) goto L_0x03a2
            if (r37 == 0) goto L_0x0297
            if (r15 != 0) goto L_0x0297
            r5 = 0
            r6 = 6
            r10.addGreaterThan(r14, r7, r5, r6)
        L_0x0297:
            if (r26 != 0) goto L_0x02ca
            r5 = 6
            if (r24 > 0) goto L_0x029e
            if (r19 <= 0) goto L_0x02a0
        L_0x029e:
            r5 = 5
            r1 = 1
        L_0x02a0:
            int r6 = r43.getMargin()
            r9 = r28
            r10.addEquality(r7, r9, r6, r5)
            int r6 = r44.getMargin()
            int r6 = -r6
            r10.addEquality(r14, r0, r6, r5)
            if (r24 > 0) goto L_0x02b5
            if (r19 <= 0) goto L_0x02b6
        L_0x02b5:
            r2 = 1
        L_0x02b6:
            r15 = r44
            r6 = r54
            r20 = r1
            r21 = r2
            r23 = r3
            r22 = r13
            r8 = r26
            r13 = r43
            r26 = r4
            goto L_0x03bb
        L_0x02ca:
            r9 = r28
            r8 = r26
            r5 = 1
            if (r8 != r5) goto L_0x02e6
            r2 = 1
            r1 = 1
            r4 = 5
            r15 = r44
            r6 = r54
            r20 = r1
            r21 = r2
            r23 = r3
            r26 = r4
            r22 = r13
            r13 = r43
            goto L_0x03bb
        L_0x02e6:
            r5 = 3
            if (r8 != r5) goto L_0x038d
            r2 = 1
            r6 = r54
            r5 = 2
            if (r6 == r5) goto L_0x02f5
            r5 = 1
            if (r6 != r5) goto L_0x02f3
            goto L_0x02f6
        L_0x02f3:
            r5 = 0
            goto L_0x02f6
        L_0x02f5:
            r5 = 1
        L_0x02f6:
            r38 = r1
            r46 = r2
            r1 = 5
            r2 = 0
            r10.addGreaterThan(r14, r7, r2, r1)
            if (r5 != 0) goto L_0x037a
            r2 = 1
            r20 = 4
            if (r50 != 0) goto L_0x0328
            if (r52 != 0) goto L_0x0328
            r1 = r35
            r22 = r13
            int r13 = r1.mResolvedDimensionRatioSide
            r1 = -1
            if (r13 == r1) goto L_0x031f
            if (r24 > 0) goto L_0x031f
            r20 = 6
            r3 = 1
            r13 = r43
            r15 = r44
            r38 = r2
            r1 = r20
            goto L_0x0368
        L_0x031f:
            r13 = r43
            r15 = r44
            r38 = r2
            r1 = r20
            goto L_0x0368
        L_0x0328:
            r22 = r13
            r13 = r43
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            r15 = r44
            r38 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            r53 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r35.getParent()
            if (r1 == r3) goto L_0x0342
            if (r2 != r3) goto L_0x0344
        L_0x0342:
            r20 = 5
        L_0x0344:
            r55 = r3
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r3 != 0) goto L_0x034e
            boolean r3 = r2 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r3 == 0) goto L_0x0350
        L_0x034e:
            r20 = 5
        L_0x0350:
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0358
            boolean r3 = r2 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 == 0) goto L_0x035b
        L_0x0358:
            r3 = 5
            r20 = r3
        L_0x035b:
            if (r52 == 0) goto L_0x0364
            r20 = 4
            r3 = r53
            r1 = r20
            goto L_0x0368
        L_0x0364:
            r3 = r53
            r1 = r20
        L_0x0368:
            int r2 = r43.getMargin()
            r10.addEquality(r7, r9, r2, r1)
            int r2 = r44.getMargin()
            int r2 = -r2
            r10.addEquality(r14, r0, r2, r1)
            r1 = r38
            goto L_0x0384
        L_0x037a:
            r15 = r44
            r53 = r3
            r22 = r13
            r13 = r43
            r1 = r38
        L_0x0384:
            r21 = r46
            r20 = r1
            r23 = r3
            r26 = r4
            goto L_0x03bb
        L_0x038d:
            r15 = r44
            r6 = r54
            r38 = r1
            r53 = r3
            r22 = r13
            r13 = r43
            r20 = r38
            r23 = r53
            r21 = r2
            r26 = r4
            goto L_0x03bb
        L_0x03a2:
            r15 = r44
            r6 = r54
            r38 = r1
            r53 = r3
            r22 = r13
            r8 = r26
            r9 = r28
            r13 = r43
            r2 = 1
            r20 = r38
            r23 = r53
            r21 = r2
            r26 = r4
        L_0x03bb:
            r28 = 5
            r31 = 5
            if (r21 == 0) goto L_0x0400
            int r4 = r43.getMargin()
            int r32 = r44.getMargin()
            r5 = r22
            r1 = r36
            r2 = r7
            r3 = r9
            r33 = r5
            r5 = r49
            r6 = r0
            r38 = r12
            r12 = r7
            r7 = r14
            r34 = r8
            r8 = r32
            r11 = r9
            r9 = r26
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            boolean r1 = r1 instanceof androidx.constraintlayout.solver.widgets.Barrier
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            boolean r2 = r2 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r1 == 0) goto L_0x03f7
            if (r2 != 0) goto L_0x03f7
            r31 = 5
            r30 = 1
            goto L_0x0408
        L_0x03f7:
            if (r1 != 0) goto L_0x0408
            if (r2 == 0) goto L_0x0408
            r28 = 5
            r29 = 1
            goto L_0x0408
        L_0x0400:
            r34 = r8
            r11 = r9
            r38 = r12
            r33 = r22
            r12 = r7
        L_0x0408:
            if (r20 == 0) goto L_0x0417
            if (r23 != 0) goto L_0x040e
            if (r52 == 0) goto L_0x0417
        L_0x040e:
            r28 = 6
            r31 = 6
            r1 = r28
            r2 = r31
            goto L_0x041b
        L_0x0417:
            r1 = r28
            r2 = r31
        L_0x041b:
            if (r27 != 0) goto L_0x041f
            if (r29 != 0) goto L_0x0421
        L_0x041f:
            if (r20 == 0) goto L_0x0428
        L_0x0421:
            int r3 = r43.getMargin()
            r10.addGreaterThan(r12, r11, r3, r1)
        L_0x0428:
            if (r27 != 0) goto L_0x042c
            if (r30 != 0) goto L_0x042e
        L_0x042c:
            if (r20 == 0) goto L_0x0436
        L_0x042e:
            int r3 = r44.getMargin()
            int r3 = -r3
            r10.addLowerThan(r14, r0, r3, r2)
        L_0x0436:
            if (r37 == 0) goto L_0x0447
            r3 = 0
            r4 = r39
            r5 = r11
            if (r4 != r5) goto L_0x0442
            int r3 = r43.getMargin()
        L_0x0442:
            r6 = 5
            r10.addGreaterThan(r12, r4, r3, r6)
            goto L_0x0459
        L_0x0447:
            r4 = r39
            r5 = r11
            goto L_0x0459
        L_0x044b:
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
        L_0x0459:
            if (r37 == 0) goto L_0x046d
            if (r38 == 0) goto L_0x046d
            r1 = 0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.mTarget
            if (r2 == 0) goto L_0x0466
            int r1 = r44.getMargin()
        L_0x0466:
            r2 = r40
            r3 = 5
            r10.addGreaterThan(r2, r14, r1, r3)
            goto L_0x046f
        L_0x046d:
            r2 = r40
        L_0x046f:
            return
        L_0x0470:
            r2 = r40
            r15 = r44
            r4 = r11
            r38 = r12
            r33 = r13
            r34 = r26
            r5 = r28
            r13 = r43
            r12 = r7
        L_0x0480:
            r1 = r33
            r3 = 2
            if (r1 >= r3) goto L_0x0491
            if (r37 == 0) goto L_0x0491
            if (r38 == 0) goto L_0x0491
            r3 = 0
            r6 = 6
            r10.addGreaterThan(r12, r4, r3, r6)
            r10.addGreaterThan(r2, r14, r3, r6)
        L_0x0491:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public void updateFromSolver(LinearSystem system) {
        int left = system.getObjectVariableValue(this.mLeft);
        int top = system.getObjectVariableValue(this.mTop);
        int right = system.getObjectVariableValue(this.mRight);
        int bottom = system.getObjectVariableValue(this.mBottom);
        if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved) {
            left = this.horizontalRun.start.value;
            right = this.horizontalRun.end.value;
        }
        if (this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            top = this.verticalRun.start.value;
            bottom = this.verticalRun.end.value;
        }
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        setFrame(left, top, right, bottom);
    }

    public void copy(ConstraintWidget src, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = src.mHorizontalResolution;
        this.mVerticalResolution = src.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = src.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = src.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = src.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = src.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = src.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = src.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = src.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = src.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = src.mIsWidthWrapContent;
        this.mIsHeightWrapContent = src.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = src.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = src.mResolvedDimensionRatio;
        int[] iArr3 = src.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = src.mCircleConstraintAngle;
        this.hasBaseline = src.hasBaseline;
        this.inPlaceholder = src.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget = null;
        this.mParent = this.mParent == null ? null : map.get(src.mParent);
        this.mWidth = src.mWidth;
        this.mHeight = src.mHeight;
        this.mDimensionRatio = src.mDimensionRatio;
        this.mDimensionRatioSide = src.mDimensionRatioSide;
        this.mX = src.mX;
        this.mY = src.mY;
        this.mRelX = src.mRelX;
        this.mRelY = src.mRelY;
        this.mOffsetX = src.mOffsetX;
        this.mOffsetY = src.mOffsetY;
        this.mBaselineDistance = src.mBaselineDistance;
        this.mMinWidth = src.mMinWidth;
        this.mMinHeight = src.mMinHeight;
        this.mHorizontalBiasPercent = src.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = src.mVerticalBiasPercent;
        this.mCompanionWidget = src.mCompanionWidget;
        this.mContainerItemSkip = src.mContainerItemSkip;
        this.mVisibility = src.mVisibility;
        this.mDebugName = src.mDebugName;
        this.mType = src.mType;
        this.mDistToTop = src.mDistToTop;
        this.mDistToLeft = src.mDistToLeft;
        this.mDistToRight = src.mDistToRight;
        this.mDistToBottom = src.mDistToBottom;
        this.mLeftHasCentered = src.mLeftHasCentered;
        this.mRightHasCentered = src.mRightHasCentered;
        this.mTopHasCentered = src.mTopHasCentered;
        this.mBottomHasCentered = src.mBottomHasCentered;
        this.mHorizontalWrapVisited = src.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = src.mVerticalWrapVisited;
        this.mOptimizerMeasurable = src.mOptimizerMeasurable;
        this.mGroupsToSolver = src.mGroupsToSolver;
        this.mHorizontalChainStyle = src.mHorizontalChainStyle;
        this.mVerticalChainStyle = src.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = src.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = src.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = src.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = src.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = src.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = src.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = src.mVerticalNextWidget;
        if (constraintWidget3 != null) {
            constraintWidget = map.get(constraintWidget3);
        }
        this.mVerticalNextWidget = constraintWidget;
    }

    public void updateFromRuns(boolean updateHorizontal, boolean updateVertical) {
        boolean updateHorizontal2 = updateHorizontal & this.horizontalRun.isResolved();
        boolean updateVertical2 = updateVertical & this.verticalRun.isResolved();
        int left = this.horizontalRun.start.value;
        int top = this.verticalRun.start.value;
        int right = this.horizontalRun.end.value;
        int bottom = this.verticalRun.end.value;
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        int w = right - left;
        int h2 = bottom - top;
        if (updateHorizontal2) {
            this.mX = left;
        }
        if (updateVertical2) {
            this.mY = top;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (updateHorizontal2) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
                w = this.mWidth;
            }
            this.mWidth = w;
            int i = this.mMinWidth;
            if (w < i) {
                this.mWidth = i;
            }
        }
        if (updateVertical2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h2 < this.mHeight) {
                h2 = this.mHeight;
            }
            this.mHeight = h2;
            int i2 = this.mMinHeight;
            if (h2 < i2) {
                this.mHeight = i2;
            }
        }
    }
}

package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public float mFirstHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mFirstVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstVerticalStyle = -1;
    /* access modifiers changed from: private */
    public int mHorizontalAlign = 2;
    /* access modifiers changed from: private */
    public float mHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mHorizontalGap = 0;
    /* access modifiers changed from: private */
    public int mHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    /* access modifiers changed from: private */
    public int mVerticalAlign = 2;
    /* access modifiers changed from: private */
    public float mVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mVerticalGap = 0;
    /* access modifiers changed from: private */
    public int mVerticalStyle = -1;
    private int mWrapMode = 0;

    public void copy(ConstraintWidget src, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(src, map);
        Flow srcFLow = (Flow) src;
        this.mHorizontalStyle = srcFLow.mHorizontalStyle;
        this.mVerticalStyle = srcFLow.mVerticalStyle;
        this.mFirstHorizontalStyle = srcFLow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = srcFLow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = srcFLow.mLastHorizontalStyle;
        this.mLastVerticalStyle = srcFLow.mLastVerticalStyle;
        this.mHorizontalBias = srcFLow.mHorizontalBias;
        this.mVerticalBias = srcFLow.mVerticalBias;
        this.mFirstHorizontalBias = srcFLow.mFirstHorizontalBias;
        this.mFirstVerticalBias = srcFLow.mFirstVerticalBias;
        this.mLastHorizontalBias = srcFLow.mLastHorizontalBias;
        this.mLastVerticalBias = srcFLow.mLastVerticalBias;
        this.mHorizontalGap = srcFLow.mHorizontalGap;
        this.mVerticalGap = srcFLow.mVerticalGap;
        this.mHorizontalAlign = srcFLow.mHorizontalAlign;
        this.mVerticalAlign = srcFLow.mVerticalAlign;
        this.mWrapMode = srcFLow.mWrapMode;
        this.mMaxElementsWrap = srcFLow.mMaxElementsWrap;
        this.mOrientation = srcFLow.mOrientation;
    }

    public void setOrientation(int value) {
        this.mOrientation = value;
    }

    public void setFirstHorizontalStyle(int value) {
        this.mFirstHorizontalStyle = value;
    }

    public void setFirstVerticalStyle(int value) {
        this.mFirstVerticalStyle = value;
    }

    public void setLastHorizontalStyle(int value) {
        this.mLastHorizontalStyle = value;
    }

    public void setLastVerticalStyle(int value) {
        this.mLastVerticalStyle = value;
    }

    public void setHorizontalStyle(int value) {
        this.mHorizontalStyle = value;
    }

    public void setVerticalStyle(int value) {
        this.mVerticalStyle = value;
    }

    public void setHorizontalBias(float value) {
        this.mHorizontalBias = value;
    }

    public void setVerticalBias(float value) {
        this.mVerticalBias = value;
    }

    public void setFirstHorizontalBias(float value) {
        this.mFirstHorizontalBias = value;
    }

    public void setFirstVerticalBias(float value) {
        this.mFirstVerticalBias = value;
    }

    public void setLastHorizontalBias(float value) {
        this.mLastHorizontalBias = value;
    }

    public void setLastVerticalBias(float value) {
        this.mLastVerticalBias = value;
    }

    public void setHorizontalAlign(int value) {
        this.mHorizontalAlign = value;
    }

    public void setVerticalAlign(int value) {
        this.mVerticalAlign = value;
    }

    public void setWrapMode(int value) {
        this.mWrapMode = value;
    }

    public void setHorizontalGap(int value) {
        this.mHorizontalGap = value;
    }

    public void setVerticalGap(int value) {
        this.mVerticalGap = value;
    }

    public void setMaxElementsWrap(int value) {
        this.mMaxElementsWrap = value;
    }

    /* access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget widget) {
        if (widget == null) {
            return 0;
        }
        if (widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widget.mMatchConstraintDefaultWidth == 0) {
            return 0;
        }
        return widget.getWidth();
    }

    /* access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget widget) {
        if (widget == null) {
            return 0;
        }
        if (widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widget.mMatchConstraintDefaultHeight == 0) {
            return 0;
        }
        return widget.getHeight();
    }

    public void measure(int widthMode, int widthSize, int heightMode, int heightSize) {
        int measuredHeight;
        int i = widthMode;
        int i2 = widthSize;
        int i3 = heightMode;
        int i4 = heightSize;
        if (this.mWidgetsCount <= 0 || measureChildren()) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int[] measured = new int[2];
            int max = (i2 - paddingLeft) - paddingRight;
            if (this.mOrientation == 1) {
                max = (i4 - paddingTop) - paddingBottom;
            }
            if (this.mOrientation == 0) {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            } else {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            }
            int i5 = this.mWrapMode;
            if (i5 == 0) {
                measureNoWrap(this.mWidgets, this.mOrientation, max, measured);
            } else if (i5 == 1) {
                measureChainWrap(this.mWidgets, this.mOrientation, max, measured);
            } else if (i5 == 2) {
                measureAligned(this.mWidgets, this.mOrientation, max, measured);
            }
            int width = measured[0] + paddingLeft + paddingRight;
            int height = measured[1] + paddingTop + paddingBottom;
            int measuredWidth = 0;
            if (i == 1073741824) {
                measuredWidth = widthSize;
            } else if (i == Integer.MIN_VALUE) {
                measuredWidth = Math.min(width, i2);
            } else if (i == 0) {
                measuredWidth = width;
            }
            if (i3 == 1073741824) {
                measuredHeight = heightSize;
            } else if (i3 == Integer.MIN_VALUE) {
                measuredHeight = Math.min(height, i4);
            } else if (i3 == 0) {
                measuredHeight = height;
            } else {
                measuredHeight = 0;
            }
            setMeasure(measuredWidth, measuredHeight);
            needsCallbackFromSolver(this.mWidgetsCount > 0);
            return;
        }
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    private class WidgetsList {
        /* access modifiers changed from: private */
        public ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private ConstraintAnchor mBottom;
        private int mCount = 0;
        private int mHeight = 0;
        private ConstraintAnchor mLeft;
        private int mOrientation = 0;
        private int mPaddingBottom = 0;
        private int mPaddingLeft = 0;
        private int mPaddingRight = 0;
        private int mPaddingTop = 0;
        private ConstraintAnchor mRight;
        private int mStartIndex = 0;
        private ConstraintAnchor mTop;
        private int mWidth = 0;

        public WidgetsList(int orientation, ConstraintAnchor left, ConstraintAnchor top, ConstraintAnchor right, ConstraintAnchor bottom) {
            this.mOrientation = orientation;
            this.mLeft = left;
            this.mTop = top;
            this.mRight = right;
            this.mBottom = bottom;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
        }

        public void setup(int orientation, ConstraintAnchor left, ConstraintAnchor top, ConstraintAnchor right, ConstraintAnchor bottom, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
            this.mOrientation = orientation;
            this.mLeft = left;
            this.mTop = top;
            this.mRight = right;
            this.mBottom = bottom;
            this.mPaddingLeft = paddingLeft;
            this.mPaddingTop = paddingTop;
            this.mPaddingRight = paddingRight;
            this.mPaddingBottom = paddingBottom;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
        }

        public void setStartIndex(int value) {
            this.mStartIndex = value;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public void add(ConstraintWidget widget) {
            if (this.mOrientation == 0) {
                int width = Flow.this.getWidgetWidth(widget);
                int gap = Flow.this.mHorizontalGap;
                if (widget.getVisibility() == 8) {
                    gap = 0;
                }
                this.mWidth += width + gap;
                int height = Flow.this.getWidgetHeight(widget);
                if (this.biggest == null || this.biggestDimension < height) {
                    this.biggest = widget;
                    this.biggestDimension = height;
                    this.mHeight = height;
                }
            } else {
                int width2 = Flow.this.getWidgetWidth(widget);
                int height2 = Flow.this.getWidgetHeight(widget);
                int gap2 = Flow.this.mVerticalGap;
                if (widget.getVisibility() == 8) {
                    gap2 = 0;
                }
                this.mHeight += height2 + gap2;
                if (this.biggest == null || this.biggestDimension < width2) {
                    this.biggest = widget;
                    this.biggestDimension = width2;
                    this.mWidth = width2;
                }
            }
            this.mCount++;
        }

        public void createConstraints(boolean isInRtl, int chainIndex, boolean isLastChain) {
            int count = this.mCount;
            for (int i = 0; i < count; i++) {
                Flow.this.mWidgets[this.mStartIndex + i].resetAnchors();
            }
            if (count != 0 && this.biggest != null) {
                boolean singleChain = isLastChain && chainIndex == 0;
                int firstVisible = -1;
                int lastVisible = -1;
                for (int i2 = 0; i2 < count; i2++) {
                    int index = i2;
                    if (isInRtl) {
                        index = (count - 1) - i2;
                    }
                    if (Flow.this.mWidgets[this.mStartIndex + index].getVisibility() == 0) {
                        if (firstVisible == -1) {
                            firstVisible = i2;
                        }
                        lastVisible = i2;
                    }
                }
                ConstraintWidget previous = null;
                if (this.mOrientation == 0) {
                    ConstraintWidget verticalWidget = this.biggest;
                    verticalWidget.setVerticalChainStyle(Flow.this.mVerticalStyle);
                    int padding = this.mPaddingTop;
                    if (chainIndex > 0) {
                        padding += Flow.this.mVerticalGap;
                    }
                    verticalWidget.mTop.connect(this.mTop, padding);
                    if (isLastChain) {
                        verticalWidget.mBottom.connect(this.mBottom, this.mPaddingBottom);
                    }
                    if (chainIndex > 0) {
                        this.mTop.mOwner.mBottom.connect(verticalWidget.mTop, 0);
                    }
                    ConstraintWidget baselineVerticalWidget = verticalWidget;
                    if (Flow.this.mVerticalAlign == 3 && !verticalWidget.hasBaseline()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= count) {
                                break;
                            }
                            int index2 = i3;
                            if (isInRtl) {
                                index2 = (count - 1) - i3;
                            }
                            ConstraintWidget widget = Flow.this.mWidgets[this.mStartIndex + index2];
                            if (widget.hasBaseline()) {
                                baselineVerticalWidget = widget;
                                break;
                            }
                            i3++;
                        }
                    }
                    for (int i4 = 0; i4 < count; i4++) {
                        int index3 = i4;
                        if (isInRtl) {
                            index3 = (count - 1) - i4;
                        }
                        ConstraintWidget widget2 = Flow.this.mWidgets[this.mStartIndex + index3];
                        if (i4 == 0) {
                            widget2.connect(widget2.mLeft, this.mLeft, this.mPaddingLeft);
                        }
                        if (index3 == 0) {
                            int style = Flow.this.mHorizontalStyle;
                            float bias = Flow.this.mHorizontalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                                style = Flow.this.mFirstHorizontalStyle;
                                bias = Flow.this.mFirstHorizontalBias;
                            } else if (isLastChain && Flow.this.mLastHorizontalStyle != -1) {
                                style = Flow.this.mLastHorizontalStyle;
                                bias = Flow.this.mLastHorizontalBias;
                            }
                            widget2.setHorizontalChainStyle(style);
                            widget2.setHorizontalBiasPercent(bias);
                        }
                        if (i4 == count - 1) {
                            widget2.connect(widget2.mRight, this.mRight, this.mPaddingRight);
                        }
                        if (previous != null) {
                            widget2.mLeft.connect(previous.mRight, Flow.this.mHorizontalGap);
                            if (i4 == firstVisible) {
                                widget2.mLeft.setGoneMargin(this.mPaddingLeft);
                            }
                            previous.mRight.connect(widget2.mLeft, 0);
                            if (i4 == lastVisible + 1) {
                                previous.mRight.setGoneMargin(this.mPaddingRight);
                            }
                        }
                        if (widget2 != verticalWidget) {
                            if (Flow.this.mVerticalAlign != 3 || !baselineVerticalWidget.hasBaseline() || widget2 == baselineVerticalWidget || !widget2.hasBaseline()) {
                                int access$500 = Flow.this.mVerticalAlign;
                                if (access$500 == 0) {
                                    widget2.mTop.connect(verticalWidget.mTop, 0);
                                } else if (access$500 == 1) {
                                    widget2.mBottom.connect(verticalWidget.mBottom, 0);
                                } else if (singleChain) {
                                    widget2.mTop.connect(this.mTop, this.mPaddingTop);
                                    widget2.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                } else {
                                    widget2.mTop.connect(verticalWidget.mTop, 0);
                                    widget2.mBottom.connect(verticalWidget.mBottom, 0);
                                }
                            } else {
                                widget2.mBaseline.connect(baselineVerticalWidget.mBaseline, 0);
                            }
                        }
                        previous = widget2;
                    }
                    return;
                }
                ConstraintWidget horizontalWidget = this.biggest;
                horizontalWidget.setHorizontalChainStyle(Flow.this.mVerticalStyle);
                int padding2 = this.mPaddingLeft;
                if (chainIndex > 0) {
                    padding2 += Flow.this.mHorizontalGap;
                }
                if (isInRtl) {
                    horizontalWidget.mRight.connect(this.mRight, padding2);
                    if (isLastChain) {
                        horizontalWidget.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (chainIndex > 0) {
                        this.mRight.mOwner.mLeft.connect(horizontalWidget.mRight, 0);
                    }
                } else {
                    horizontalWidget.mLeft.connect(this.mLeft, padding2);
                    if (isLastChain) {
                        horizontalWidget.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (chainIndex > 0) {
                        this.mLeft.mOwner.mRight.connect(horizontalWidget.mLeft, 0);
                    }
                }
                for (int i5 = 0; i5 < count; i5++) {
                    ConstraintWidget widget3 = Flow.this.mWidgets[this.mStartIndex + i5];
                    if (i5 == 0) {
                        widget3.connect(widget3.mTop, this.mTop, this.mPaddingTop);
                        int style2 = Flow.this.mVerticalStyle;
                        float bias2 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            style2 = Flow.this.mFirstVerticalStyle;
                            bias2 = Flow.this.mFirstVerticalBias;
                        } else if (isLastChain && Flow.this.mLastVerticalStyle != -1) {
                            style2 = Flow.this.mLastVerticalStyle;
                            bias2 = Flow.this.mLastVerticalBias;
                        }
                        widget3.setVerticalChainStyle(style2);
                        widget3.setVerticalBiasPercent(bias2);
                    }
                    if (i5 == count - 1) {
                        widget3.connect(widget3.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (previous != null) {
                        widget3.mTop.connect(previous.mBottom, Flow.this.mVerticalGap);
                        if (i5 == firstVisible) {
                            widget3.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        previous.mBottom.connect(widget3.mTop, 0);
                        if (i5 == lastVisible + 1) {
                            previous.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (widget3 != horizontalWidget) {
                        if (isInRtl) {
                            int access$1700 = Flow.this.mHorizontalAlign;
                            if (access$1700 == 0) {
                                widget3.mRight.connect(horizontalWidget.mRight, 0);
                            } else if (access$1700 == 1) {
                                widget3.mLeft.connect(horizontalWidget.mLeft, 0);
                            } else if (access$1700 == 2) {
                                widget3.mLeft.connect(horizontalWidget.mLeft, 0);
                                widget3.mRight.connect(horizontalWidget.mRight, 0);
                            }
                        } else {
                            int access$17002 = Flow.this.mHorizontalAlign;
                            if (access$17002 == 0) {
                                widget3.mLeft.connect(horizontalWidget.mLeft, 0);
                            } else if (access$17002 == 1) {
                                widget3.mRight.connect(horizontalWidget.mRight, 0);
                            } else if (access$17002 == 2) {
                                if (singleChain) {
                                    widget3.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    widget3.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    widget3.mLeft.connect(horizontalWidget.mLeft, 0);
                                    widget3.mRight.connect(horizontalWidget.mRight, 0);
                                }
                            }
                        }
                    }
                    previous = widget3;
                }
            }
        }
    }

    private void measureChainWrap(ConstraintWidget[] widgets, int orientation, int max, int[] measured) {
        WidgetsList list;
        int count;
        WidgetsList list2;
        int i;
        ConstraintAnchor right;
        boolean doWrap;
        int i2;
        boolean doWrap2;
        int i3;
        int i4 = max;
        int count2 = this.mWidgetsCount;
        if (count2 != 0) {
            this.mChainList.clear();
            WidgetsList list3 = new WidgetsList(orientation, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mChainList.add(list3);
            if (orientation == 0) {
                int width = this.mHorizontalGap * 2;
                WidgetsList list4 = list3;
                for (int i5 = 0; i5 < count2; i5++) {
                    ConstraintWidget widget = widgets[i5];
                    int w = getWidgetWidth(widget);
                    boolean doWrap3 = (width + w) + this.mHorizontalGap > i4 && list4.biggest != null;
                    if (doWrap3 || i5 <= 0 || (i3 = this.mMaxElementsWrap) <= 0 || i5 % i3 != 0) {
                        doWrap2 = doWrap3;
                    } else {
                        doWrap2 = true;
                    }
                    if (doWrap2) {
                        int width2 = this.mHorizontalGap * 2;
                        WidgetsList list5 = new WidgetsList(orientation, this.mLeft, this.mTop, this.mRight, this.mBottom);
                        list5.setStartIndex(i5);
                        this.mChainList.add(list5);
                        list4 = list5;
                        width = width2;
                    }
                    width += this.mHorizontalGap + w;
                    list4.add(widget);
                }
                list = list4;
            } else {
                int height = this.mVerticalGap * 2;
                WidgetsList list6 = list3;
                for (int i6 = 0; i6 < count2; i6++) {
                    ConstraintWidget widget2 = widgets[i6];
                    int h = getWidgetHeight(widget2);
                    boolean doWrap4 = (height + h) + this.mVerticalGap > i4 && list6.biggest != null;
                    if (doWrap4 || i6 <= 0 || (i2 = this.mMaxElementsWrap) <= 0 || i6 % i2 != 0) {
                        doWrap = doWrap4;
                    } else {
                        doWrap = true;
                    }
                    if (doWrap) {
                        int height2 = this.mVerticalGap * 2;
                        WidgetsList list7 = new WidgetsList(orientation, this.mLeft, this.mTop, this.mRight, this.mBottom);
                        list7.setStartIndex(i6);
                        this.mChainList.add(list7);
                        list6 = list7;
                        height = height2;
                    }
                    height += h;
                    list6.add(widget2);
                }
                list = list6;
            }
            int listCount = this.mChainList.size();
            ConstraintAnchor left = this.mLeft;
            ConstraintAnchor top = this.mTop;
            ConstraintAnchor right2 = this.mRight;
            ConstraintAnchor bottom = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int maxHeight = 0;
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int maxWidth = 0;
            int maxWidth2 = 0;
            while (maxWidth2 < listCount) {
                WidgetsList current = this.mChainList.get(maxWidth2);
                if (orientation == 0) {
                    if (maxWidth2 < listCount - 1) {
                        bottom = this.mChainList.get(maxWidth2 + 1).biggest.mTop;
                        paddingBottom = 0;
                    } else {
                        bottom = this.mBottom;
                        paddingBottom = getPaddingBottom();
                    }
                    list2 = list;
                    i = maxWidth2;
                    ConstraintAnchor constraintAnchor = top;
                    ConstraintAnchor right3 = right2;
                    count = count2;
                    current.setup(orientation, left, top, right2, bottom, paddingLeft, paddingTop, paddingRight, paddingBottom);
                    ConstraintAnchor top2 = current.biggest.mBottom;
                    int maxWidth3 = Math.max(maxWidth, current.getWidth());
                    maxHeight += current.getHeight();
                    if (i > 0) {
                        maxHeight += this.mVerticalGap;
                    }
                    maxWidth = maxWidth3;
                    top = top2;
                    paddingTop = 0;
                    right2 = right3;
                } else {
                    list2 = list;
                    ConstraintAnchor top3 = top;
                    ConstraintAnchor constraintAnchor2 = right2;
                    i = maxWidth2;
                    int maxHeight2 = maxHeight;
                    int maxWidth4 = maxWidth;
                    count = count2;
                    if (i < listCount - 1) {
                        paddingRight = 0;
                        right = this.mChainList.get(i + 1).biggest.mLeft;
                    } else {
                        ConstraintAnchor right4 = this.mRight;
                        paddingRight = getPaddingRight();
                        right = right4;
                    }
                    current.setup(orientation, left, top3, right, bottom, paddingLeft, paddingTop, paddingRight, paddingBottom);
                    left = current.biggest.mRight;
                    paddingLeft = 0;
                    maxWidth = maxWidth4 + current.getWidth();
                    int maxHeight3 = Math.max(maxHeight2, current.getHeight());
                    if (i > 0) {
                        maxWidth += this.mHorizontalGap;
                        maxHeight = maxHeight3;
                        right2 = right;
                        top = top3;
                    } else {
                        maxHeight = maxHeight3;
                        right2 = right;
                        top = top3;
                    }
                }
                maxWidth2 = i + 1;
                int i7 = max;
                list = list2;
                count2 = count;
            }
            ConstraintAnchor constraintAnchor3 = top;
            ConstraintAnchor constraintAnchor4 = right2;
            measured[0] = maxWidth;
            measured[1] = maxHeight;
        }
    }

    private void measureNoWrap(ConstraintWidget[] widgets, int orientation, int max, int[] measured) {
        WidgetsList list;
        int count = this.mWidgetsCount;
        if (count != 0) {
            if (this.mChainList.size() == 0) {
                list = new WidgetsList(orientation, this.mLeft, this.mTop, this.mRight, this.mBottom);
                this.mChainList.add(list);
            } else {
                list = this.mChainList.get(0);
                list.clear();
                ConstraintAnchor constraintAnchor = this.mLeft;
                ConstraintAnchor constraintAnchor2 = this.mTop;
                ConstraintAnchor constraintAnchor3 = this.mRight;
                list.setup(orientation, constraintAnchor, constraintAnchor2, constraintAnchor3, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            for (int i = 0; i < count; i++) {
                list.add(widgets[i]);
            }
            measured[0] = list.getWidth();
            measured[1] = list.getHeight();
        }
    }

    private void measureAligned(ConstraintWidget[] widgets, int orientation, int max, int[] measured) {
        ConstraintWidget widget;
        ConstraintWidget[] constraintWidgetArr = widgets;
        int i = orientation;
        int i2 = max;
        boolean done = false;
        int rows = 0;
        int cols = 0;
        if (i == 0) {
            cols = this.mMaxElementsWrap;
            if (cols <= 0) {
                int w = 0;
                cols = 0;
                for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
                    if (i3 > 0) {
                        w += this.mHorizontalGap;
                    }
                    ConstraintWidget widget2 = constraintWidgetArr[i3];
                    if (widget2 != null) {
                        w += getWidgetWidth(widget2);
                        if (w > i2) {
                            break;
                        }
                        cols++;
                    }
                }
            }
        } else {
            rows = this.mMaxElementsWrap;
            if (rows <= 0) {
                int h = 0;
                rows = 0;
                for (int i4 = 0; i4 < this.mWidgetsCount; i4++) {
                    if (i4 > 0) {
                        h += this.mVerticalGap;
                    }
                    ConstraintWidget widget3 = constraintWidgetArr[i4];
                    if (widget3 != null) {
                        h += getWidgetHeight(widget3);
                        if (h > i2) {
                            break;
                        }
                        rows++;
                    }
                }
            }
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        if ((rows == 0 && i == 1) || (cols == 0 && i == 0)) {
            done = true;
        }
        while (!done) {
            if (i == 0) {
                rows = (int) Math.ceil((double) (((float) this.mWidgetsCount) / ((float) cols)));
            } else {
                cols = (int) Math.ceil((double) (((float) this.mWidgetsCount) / ((float) rows)));
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
            if (constraintWidgetArr2 == null || constraintWidgetArr2.length < cols) {
                this.mAlignedBiggestElementsInCols = new ConstraintWidget[cols];
            } else {
                Arrays.fill(constraintWidgetArr2, (Object) null);
            }
            ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
            if (constraintWidgetArr3 == null || constraintWidgetArr3.length < rows) {
                this.mAlignedBiggestElementsInRows = new ConstraintWidget[rows];
            } else {
                Arrays.fill(constraintWidgetArr3, (Object) null);
            }
            for (int i5 = 0; i5 < cols; i5++) {
                for (int j = 0; j < rows; j++) {
                    int index = (j * cols) + i5;
                    if (i == 1) {
                        index = (i5 * rows) + j;
                    }
                    if (index < constraintWidgetArr.length && (widget = constraintWidgetArr[index]) != null) {
                        int w2 = getWidgetWidth(widget);
                        ConstraintWidget[] constraintWidgetArr4 = this.mAlignedBiggestElementsInCols;
                        if (constraintWidgetArr4[i5] == null || constraintWidgetArr4[i5].getWidth() < w2) {
                            this.mAlignedBiggestElementsInCols[i5] = widget;
                        }
                        int h2 = getWidgetHeight(widget);
                        ConstraintWidget[] constraintWidgetArr5 = this.mAlignedBiggestElementsInRows;
                        if (constraintWidgetArr5[j] == null || constraintWidgetArr5[j].getHeight() < h2) {
                            this.mAlignedBiggestElementsInRows[j] = widget;
                        }
                    }
                }
            }
            int w3 = 0;
            for (int i6 = 0; i6 < cols; i6++) {
                ConstraintWidget widget4 = this.mAlignedBiggestElementsInCols[i6];
                if (widget4 != null) {
                    if (i6 > 0) {
                        w3 += this.mHorizontalGap;
                    }
                    w3 += getWidgetWidth(widget4);
                }
            }
            int h3 = 0;
            for (int j2 = 0; j2 < rows; j2++) {
                ConstraintWidget widget5 = this.mAlignedBiggestElementsInRows[j2];
                if (widget5 != null) {
                    if (j2 > 0) {
                        h3 += this.mVerticalGap;
                    }
                    h3 += getWidgetHeight(widget5);
                }
            }
            measured[0] = w3;
            measured[1] = h3;
            if (i == 0) {
                if (w3 <= i2) {
                    done = true;
                } else if (cols > 1) {
                    cols--;
                } else {
                    done = true;
                }
            } else if (h3 <= i2) {
                done = true;
            } else if (rows > 1) {
                rows--;
            } else {
                done = true;
            }
        }
        int[] iArr = this.mAlignedDimensions;
        iArr[0] = cols;
        iArr[1] = rows;
    }

    private void createAlignedConstraints(boolean isInRtl) {
        ConstraintWidget widget;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i = 0; i < this.mWidgetsCount; i++) {
                this.mWidgets[i].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int cols = iArr[0];
            int rows = iArr[1];
            ConstraintWidget previous = null;
            for (int i2 = 0; i2 < cols; i2++) {
                int index = i2;
                if (isInRtl) {
                    index = (cols - i2) - 1;
                }
                ConstraintWidget widget2 = this.mAlignedBiggestElementsInCols[index];
                if (widget2 != null) {
                    if (i2 == 0) {
                        widget2.connect(widget2.mLeft, this.mLeft, getPaddingLeft());
                        widget2.setHorizontalChainStyle(this.mHorizontalStyle);
                        widget2.setHorizontalBiasPercent(this.mHorizontalBias);
                    }
                    if (i2 == cols - 1) {
                        widget2.connect(widget2.mRight, this.mRight, getPaddingRight());
                    }
                    if (i2 > 0) {
                        widget2.connect(widget2.mLeft, previous.mRight, this.mHorizontalGap);
                        previous.connect(previous.mRight, widget2.mLeft, 0);
                    }
                    previous = widget2;
                }
            }
            for (int j = 0; j < rows; j++) {
                ConstraintWidget widget3 = this.mAlignedBiggestElementsInRows[j];
                if (widget3 != null) {
                    if (j == 0) {
                        widget3.connect(widget3.mTop, this.mTop, getPaddingTop());
                        widget3.setVerticalChainStyle(this.mVerticalStyle);
                        widget3.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (j == rows - 1) {
                        widget3.connect(widget3.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (j > 0) {
                        widget3.connect(widget3.mTop, previous.mBottom, this.mVerticalGap);
                        previous.connect(previous.mBottom, widget3.mTop, 0);
                    }
                    previous = widget3;
                }
            }
            for (int i3 = 0; i3 < cols; i3++) {
                for (int j2 = 0; j2 < rows; j2++) {
                    int index2 = (j2 * cols) + i3;
                    if (this.mOrientation == 1) {
                        index2 = (i3 * rows) + j2;
                    }
                    if (index2 < this.mWidgets.length && (widget = this.mWidgets[index2]) != null) {
                        ConstraintWidget biggestInCol = this.mAlignedBiggestElementsInCols[i3];
                        ConstraintWidget biggestInRow = this.mAlignedBiggestElementsInRows[j2];
                        if (widget != biggestInCol) {
                            widget.connect(widget.mLeft, biggestInCol.mLeft, 0);
                            widget.connect(widget.mRight, biggestInCol.mRight, 0);
                        }
                        if (widget != biggestInRow) {
                            widget.connect(widget.mTop, biggestInRow.mTop, 0);
                            widget.connect(widget.mBottom, biggestInRow.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    public void addToSolver(LinearSystem system) {
        super.addToSolver(system);
        boolean isInRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int count = this.mChainList.size();
                int i2 = 0;
                while (i2 < count) {
                    this.mChainList.get(i2).createConstraints(isInRtl, i2, i2 == count + -1);
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(isInRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isInRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }
}

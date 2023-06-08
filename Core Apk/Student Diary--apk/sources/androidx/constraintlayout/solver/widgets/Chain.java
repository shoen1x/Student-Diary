package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        ChainHead[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:309:0x066d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x067f  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0684  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0690  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0693  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x06a7  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06ab  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x06b7  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x06ba A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r44, androidx.constraintlayout.solver.LinearSystem r45, int r46, int r47, androidx.constraintlayout.solver.widgets.ChainHead r48) {
        /*
            r0 = r44
            r10 = r45
            r11 = r48
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r11.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r11.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r11.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r11.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r11.mHead
            r1 = r12
            r2 = 0
            r3 = 0
            float r4 = r11.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r11.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r46]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r16 = r1
            if (r5 != r6) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            r18 = r5
            r5 = 0
            r6 = 0
            r19 = 0
            if (r46 != 0) goto L_0x0052
            int r1 = r9.mHorizontalChainStyle
            if (r1 != 0) goto L_0x0034
            r1 = 1
            goto L_0x0035
        L_0x0034:
            r1 = 0
        L_0x0035:
            int r5 = r9.mHorizontalChainStyle
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            int r5 = r9.mHorizontalChainStyle
            r6 = 2
            if (r5 != r6) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            r19 = r2
            r21 = r3
            r23 = r5
            r6 = r16
            r16 = r1
            goto L_0x0075
        L_0x0052:
            int r1 = r9.mVerticalChainStyle
            if (r1 != 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0058:
            r1 = 0
        L_0x0059:
            int r5 = r9.mVerticalChainStyle
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x0062
            r1 = 1
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            int r5 = r9.mVerticalChainStyle
            r6 = 2
            if (r5 != r6) goto L_0x006a
            r5 = 1
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            r19 = r2
            r21 = r3
            r23 = r5
            r6 = r16
            r16 = r1
        L_0x0075:
            if (r21 != 0) goto L_0x0171
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r47]
            r24 = 4
            if (r18 != 0) goto L_0x0081
            if (r23 == 0) goto L_0x0083
        L_0x0081:
            r24 = 1
        L_0x0083:
            int r25 = r3.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r6.mListDimensionBehaviors
            r5 = r5[r46]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r2) goto L_0x0097
            int[] r2 = r6.mResolvedMatchConstraintDefault
            r2 = r2[r46]
            if (r2 != 0) goto L_0x0097
            r2 = 1
            goto L_0x0098
        L_0x0097:
            r2 = 0
        L_0x0098:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.mTarget
            if (r5 == 0) goto L_0x00a9
            if (r6 == r12) goto L_0x00a9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.mTarget
            int r5 = r5.getMargin()
            int r25 = r25 + r5
            r5 = r25
            goto L_0x00ab
        L_0x00a9:
            r5 = r25
        L_0x00ab:
            if (r23 == 0) goto L_0x00b4
            if (r6 == r12) goto L_0x00b4
            if (r6 == r14) goto L_0x00b4
            r24 = 6
            goto L_0x00ba
        L_0x00b4:
            if (r22 == 0) goto L_0x00ba
            if (r18 == 0) goto L_0x00ba
            r24 = 4
        L_0x00ba:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r3.mTarget
            if (r1 == 0) goto L_0x00f7
            if (r6 != r14) goto L_0x00cf
            androidx.constraintlayout.solver.SolverVariable r1 = r3.mSolverVariable
            r28 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r29 = r7
            r7 = 5
            r10.addGreaterThan(r1, r4, r5, r7)
            goto L_0x00dd
        L_0x00cf:
            r28 = r4
            r29 = r7
            androidx.constraintlayout.solver.SolverVariable r1 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r7 = 6
            r10.addGreaterThan(r1, r4, r5, r7)
        L_0x00dd:
            if (r2 == 0) goto L_0x00e9
            if (r23 != 0) goto L_0x00e9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            if (r1 != r0) goto L_0x00e9
            r1 = 5
            goto L_0x00eb
        L_0x00e9:
            r1 = r24
        L_0x00eb:
            androidx.constraintlayout.solver.SolverVariable r4 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r10.addEquality(r4, r7, r5, r1)
            r24 = r1
            goto L_0x00fb
        L_0x00f7:
            r28 = r4
            r29 = r7
        L_0x00fb:
            if (r18 == 0) goto L_0x0137
            int r1 = r6.getVisibility()
            r4 = 8
            if (r1 == r4) goto L_0x0123
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r6.mListDimensionBehaviors
            r1 = r1[r46]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r4) goto L_0x0123
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            int r4 = r47 + 1
            r1 = r1[r4]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r6.mListAnchors
            r4 = r4[r47]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r25 = r2
            r2 = 0
            r7 = 5
            r10.addGreaterThan(r1, r4, r2, r7)
            goto L_0x0125
        L_0x0123:
            r25 = r2
        L_0x0125:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r47]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r4 = 6
            r7 = 0
            r10.addGreaterThan(r1, r2, r7, r4)
            goto L_0x0139
        L_0x0137:
            r25 = r2
        L_0x0139:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x015f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x015b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.mOwner
            if (r4 == r6) goto L_0x0158
            goto L_0x015b
        L_0x0158:
            r19 = r2
            goto L_0x0162
        L_0x015b:
            r2 = 0
            r19 = r2
            goto L_0x0162
        L_0x015f:
            r2 = 0
            r19 = r2
        L_0x0162:
            if (r19 == 0) goto L_0x0168
            r2 = r19
            r6 = r2
            goto L_0x016b
        L_0x0168:
            r2 = 1
            r21 = r2
        L_0x016b:
            r4 = r28
            r7 = r29
            goto L_0x0075
        L_0x0171:
            r28 = r4
            r29 = r7
            if (r15 == 0) goto L_0x01de
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x01de
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r15.mListDimensionBehaviors
            r2 = r2[r46]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0197
            int[] r2 = r15.mResolvedMatchConstraintDefault
            r2 = r2[r46]
            if (r2 != 0) goto L_0x0197
            r2 = 1
            goto L_0x0198
        L_0x0197:
            r2 = 0
        L_0x0198:
            if (r2 == 0) goto L_0x01b2
            if (r23 != 0) goto L_0x01b2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 != r0) goto L_0x01b2
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r1.getMargin()
            int r5 = -r5
            r7 = 5
            r10.addEquality(r3, r4, r5, r7)
            goto L_0x01c9
        L_0x01b2:
            if (r23 == 0) goto L_0x01c9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 != r0) goto L_0x01c9
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r1.getMargin()
            int r5 = -r5
            r7 = 4
            r10.addEquality(r3, r4, r5, r7)
        L_0x01c9:
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            int r5 = r47 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r1.getMargin()
            int r5 = -r5
            r7 = 5
            r10.addLowerThan(r3, r4, r5, r7)
        L_0x01de:
            if (r18 == 0) goto L_0x01fe
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r47 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            r4 = 6
            r10.addGreaterThan(r1, r2, r3, r4)
        L_0x01fe:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r11.mWeightedMatchConstraintsWidgets
            if (r7 == 0) goto L_0x02e7
            int r1 = r7.size()
            r2 = 1
            if (r1 <= r2) goto L_0x02de
            r3 = 0
            r4 = 0
            boolean r5 = r11.mHasUndefinedWeights
            if (r5 == 0) goto L_0x0218
            boolean r5 = r11.mHasComplexMatchWeights
            if (r5 != 0) goto L_0x0218
            int r5 = r11.mWidgetsMatchCount
            float r5 = (float) r5
            r28 = r5
        L_0x0218:
            r5 = 0
        L_0x0219:
            if (r5 >= r1) goto L_0x02d3
            java.lang.Object r20 = r7.get(r5)
            r2 = r20
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r2
            float[] r0 = r2.mWeight
            r0 = r0[r46]
            r20 = 0
            int r30 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r30 >= 0) goto L_0x025c
            r30 = r0
            boolean r0 = r11.mHasComplexMatchWeights
            if (r0 == 0) goto L_0x0252
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r2.mListAnchors
            int r20 = r47 + 1
            r0 = r0[r20]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r38 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r2.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r24 = r6
            r39 = r7
            r6 = 0
            r7 = 4
            r10.addEquality(r0, r1, r6, r7)
            r17 = r8
            r7 = 6
            r8 = 0
            goto L_0x02c4
        L_0x0252:
            r38 = r1
            r24 = r6
            r39 = r7
            r7 = 4
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0265
        L_0x025c:
            r30 = r0
            r38 = r1
            r24 = r6
            r39 = r7
            r7 = 4
        L_0x0265:
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 != 0) goto L_0x027f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r2.mListAnchors
            int r6 = r47 + 1
            r1 = r1[r6]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r47]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r17 = r8
            r7 = 6
            r8 = 0
            r10.addEquality(r1, r6, r8, r7)
            goto L_0x02c4
        L_0x027f:
            r17 = r8
            r7 = 6
            r8 = 0
            if (r3 == 0) goto L_0x02be
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r3.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r3.mListAnchors
            int r27 = r47 + 1
            r6 = r6[r27]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r2.mListAnchors
            r7 = r7[r47]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            int r30 = r47 + 1
            r8 = r8[r30]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r41 = r3
            androidx.constraintlayout.solver.ArrayRow r3 = r45.createRow()
            r30 = r3
            r31 = r4
            r32 = r28
            r33 = r0
            r34 = r1
            r35 = r6
            r36 = r7
            r37 = r8
            r30.createRowEqualMatchDimensions(r31, r32, r33, r34, r35, r36, r37)
            r10.addConstraint(r3)
            goto L_0x02c0
        L_0x02be:
            r41 = r3
        L_0x02c0:
            r1 = r2
            r3 = r0
            r4 = r3
            r3 = r1
        L_0x02c4:
            int r5 = r5 + 1
            r0 = r44
            r8 = r17
            r6 = r24
            r1 = r38
            r7 = r39
            r2 = 1
            goto L_0x0219
        L_0x02d3:
            r38 = r1
            r41 = r3
            r24 = r6
            r39 = r7
            r17 = r8
            goto L_0x02ed
        L_0x02de:
            r38 = r1
            r24 = r6
            r39 = r7
            r17 = r8
            goto L_0x02ed
        L_0x02e7:
            r24 = r6
            r39 = r7
            r17 = r8
        L_0x02ed:
            if (r14 == 0) goto L_0x0388
            if (r14 == r15) goto L_0x02fa
            if (r23 == 0) goto L_0x02f4
            goto L_0x02fa
        L_0x02f4:
            r35 = r9
            r33 = r39
            goto L_0x038c
        L_0x02fa:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            r3 = r3[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0315
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            r3 = r3[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0316
        L_0x0315:
            r3 = 0
        L_0x0316:
            r20 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r47 + 1
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x032d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r47 + 1
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x032e
        L_0x032d:
            r3 = 0
        L_0x032e:
            r25 = r3
            if (r14 != r15) goto L_0x033f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            r1 = r3[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r47 + 1
            r2 = r3[r4]
            r8 = r1
            r7 = r2
            goto L_0x0341
        L_0x033f:
            r8 = r1
            r7 = r2
        L_0x0341:
            if (r20 == 0) goto L_0x037e
            if (r25 == 0) goto L_0x037e
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r46 != 0) goto L_0x034e
            float r1 = r9.mHorizontalBiasPercent
            r26 = r1
            goto L_0x0352
        L_0x034e:
            float r1 = r9.mVerticalBiasPercent
            r26 = r1
        L_0x0352:
            int r27 = r8.getMargin()
            int r30 = r7.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r7.mSolverVariable
            r31 = 5
            r1 = r45
            r3 = r20
            r4 = r27
            r5 = r26
            r32 = r6
            r6 = r25
            r34 = r7
            r33 = r39
            r7 = r32
            r32 = r8
            r8 = r30
            r35 = r9
            r9 = r31
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0386
        L_0x037e:
            r34 = r7
            r32 = r8
            r35 = r9
            r33 = r39
        L_0x0386:
            goto L_0x0669
        L_0x0388:
            r35 = r9
            r33 = r39
        L_0x038c:
            if (r22 == 0) goto L_0x04da
            if (r14 == 0) goto L_0x04da
            r1 = r14
            r2 = r14
            int r3 = r11.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x039f
            int r3 = r11.mWidgetsCount
            int r4 = r11.mWidgetsMatchCount
            if (r3 != r4) goto L_0x039f
            r40 = 1
            goto L_0x03a1
        L_0x039f:
            r40 = 0
        L_0x03a1:
            r20 = r40
            r8 = r1
            r9 = r2
        L_0x03a5:
            if (r8 == 0) goto L_0x04d2
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r8.mNextChainWidget
            r1 = r1[r46]
            r7 = r1
        L_0x03ac:
            if (r7 == 0) goto L_0x03bb
            int r1 = r7.getVisibility()
            r5 = 8
            if (r1 != r5) goto L_0x03bd
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r7.mNextChainWidget
            r7 = r1[r46]
            goto L_0x03ac
        L_0x03bb:
            r5 = 8
        L_0x03bd:
            if (r7 != 0) goto L_0x03cb
            if (r8 != r15) goto L_0x03c2
            goto L_0x03cb
        L_0x03c2:
            r0 = r5
            r39 = r7
            r40 = r8
            r41 = r9
            goto L_0x04c0
        L_0x03cb:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r6 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r4 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x03da
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x03db
        L_0x03da:
            r1 = 0
        L_0x03db:
            if (r9 == r8) goto L_0x03e8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r1 = r2.mSolverVariable
            r19 = r1
            goto L_0x0404
        L_0x03e8:
            if (r8 != r14) goto L_0x0402
            if (r9 != r8) goto L_0x0402
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x03fd
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x03fe
        L_0x03fd:
            r2 = 0
        L_0x03fe:
            r1 = r2
            r19 = r1
            goto L_0x0404
        L_0x0402:
            r19 = r1
        L_0x0404:
            r1 = 0
            r2 = 0
            r3 = 0
            int r24 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            int r25 = r47 + 1
            r0 = r0[r25]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x042c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r1 = r5[r47]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            int r27 = r47 + 1
            r5 = r5[r27]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r27 = r1
            r30 = r2
            r31 = r3
            goto L_0x0446
        L_0x042c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            int r27 = r47 + 1
            r5 = r5[r27]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r5.mTarget
            if (r1 == 0) goto L_0x0438
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x0438:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            int r27 = r47 + 1
            r5 = r5[r27]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r27 = r1
            r30 = r2
            r31 = r3
        L_0x0446:
            if (r27 == 0) goto L_0x044d
            int r1 = r27.getMargin()
            int r0 = r0 + r1
        L_0x044d:
            if (r9 == 0) goto L_0x045b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r24 = r24 + r1
        L_0x045b:
            if (r4 == 0) goto L_0x04b2
            if (r19 == 0) goto L_0x04b2
            if (r30 == 0) goto L_0x04b2
            if (r31 == 0) goto L_0x04b2
            r1 = r24
            if (r8 != r14) goto L_0x0472
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r47]
            int r1 = r2.getMargin()
            r32 = r1
            goto L_0x0474
        L_0x0472:
            r32 = r1
        L_0x0474:
            r1 = r0
            if (r8 != r15) goto L_0x0484
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            int r1 = r2.getMargin()
            r34 = r1
            goto L_0x0486
        L_0x0484:
            r34 = r1
        L_0x0486:
            r1 = 4
            if (r20 == 0) goto L_0x048d
            r1 = 6
            r36 = r1
            goto L_0x048f
        L_0x048d:
            r36 = r1
        L_0x048f:
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r45
            r2 = r4
            r3 = r19
            r37 = r4
            r4 = r32
            r38 = r0
            r0 = 8
            r25 = r6
            r6 = r30
            r39 = r7
            r7 = r31
            r40 = r8
            r8 = r34
            r41 = r9
            r9 = r36
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x04c0
        L_0x04b2:
            r38 = r0
            r37 = r4
            r25 = r6
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
        L_0x04c0:
            int r1 = r40.getVisibility()
            if (r1 == r0) goto L_0x04ca
            r1 = r40
            r9 = r1
            goto L_0x04cc
        L_0x04ca:
            r9 = r41
        L_0x04cc:
            r8 = r39
            r19 = r39
            goto L_0x03a5
        L_0x04d2:
            r40 = r8
            r41 = r9
            r38 = r40
            goto L_0x066b
        L_0x04da:
            r0 = 8
            if (r16 == 0) goto L_0x0669
            if (r14 == 0) goto L_0x0669
            r1 = r14
            r2 = r14
            int r3 = r11.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x04ef
            int r3 = r11.mWidgetsCount
            int r4 = r11.mWidgetsMatchCount
            if (r3 != r4) goto L_0x04ef
            r40 = 1
            goto L_0x04f1
        L_0x04ef:
            r40 = 0
        L_0x04f1:
            r24 = r40
            r8 = r1
            r9 = r2
        L_0x04f5:
            if (r8 == 0) goto L_0x05e1
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r8.mNextChainWidget
            r1 = r1[r46]
        L_0x04fb:
            if (r1 == 0) goto L_0x0508
            int r2 = r1.getVisibility()
            if (r2 != r0) goto L_0x0508
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r1.mNextChainWidget
            r1 = r2[r46]
            goto L_0x04fb
        L_0x0508:
            if (r8 == r14) goto L_0x05c8
            if (r8 == r15) goto L_0x05c8
            if (r1 == 0) goto L_0x05c8
            if (r1 != r15) goto L_0x0513
            r1 = 0
            r7 = r1
            goto L_0x0514
        L_0x0513:
            r7 = r1
        L_0x0514:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r6 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r5 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x0523
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x0524
        L_0x0523:
            r1 = 0
        L_0x0524:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r4 = r2.mSolverVariable
            r1 = 0
            r2 = 0
            r3 = 0
            int r19 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            int r27 = r47 + 1
            r0 = r0[r27]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x055a
            r27 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r7.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            r27 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x0552
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0553
        L_0x0552:
            r2 = 0
        L_0x0553:
            r30 = r2
            r31 = r27
            r27 = r1
            goto L_0x0572
        L_0x055a:
            r27 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            r1 = r1[r47]
            if (r1 == 0) goto L_0x0564
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x0564:
            r27 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r30 = r47 + 1
            r1 = r1[r30]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r30 = r1
            r31 = r2
        L_0x0572:
            if (r27 == 0) goto L_0x0579
            int r1 = r27.getMargin()
            int r0 = r0 + r1
        L_0x0579:
            if (r9 == 0) goto L_0x0587
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r19 = r19 + r1
        L_0x0587:
            r1 = 4
            if (r24 == 0) goto L_0x058e
            r1 = 6
            r32 = r1
            goto L_0x0590
        L_0x058e:
            r32 = r1
        L_0x0590:
            if (r5 == 0) goto L_0x05b9
            if (r4 == 0) goto L_0x05b9
            if (r31 == 0) goto L_0x05b9
            if (r30 == 0) goto L_0x05b9
            r34 = 1056964608(0x3f000000, float:0.5)
            r1 = r45
            r2 = r5
            r3 = r4
            r36 = r4
            r4 = r19
            r37 = r5
            r5 = r34
            r34 = r6
            r6 = r31
            r20 = r7
            r7 = r30
            r38 = r8
            r8 = r0
            r39 = r9
            r9 = r32
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x05c5
        L_0x05b9:
            r36 = r4
            r37 = r5
            r34 = r6
            r20 = r7
            r38 = r8
            r39 = r9
        L_0x05c5:
            r19 = r20
            goto L_0x05ce
        L_0x05c8:
            r38 = r8
            r39 = r9
            r19 = r1
        L_0x05ce:
            int r0 = r38.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x05da
            r0 = r38
            r9 = r0
            goto L_0x05dc
        L_0x05da:
            r9 = r39
        L_0x05dc:
            r8 = r19
            r0 = r1
            goto L_0x04f5
        L_0x05e1:
            r38 = r8
            r39 = r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r47 + 1
            r8 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r1.mTarget
            if (r9 == 0) goto L_0x064a
            if (r14 == r15) goto L_0x0614
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r9.mSolverVariable
            int r3 = r0.getMargin()
            r6 = 4
            r10.addEquality(r1, r2, r3, r6)
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x0650
        L_0x0614:
            r6 = 4
            if (r7 == 0) goto L_0x0643
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r9.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r5 = r7.mSolverVariable
            int r25 = r8.getMargin()
            r27 = 4
            r30 = r1
            r1 = r45
            r20 = r5
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = r30
            r42 = r7
            r7 = r20
            r43 = r8
            r8 = r25
            r20 = r9
            r9 = r27
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0650
        L_0x0643:
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x0650
        L_0x064a:
            r42 = r7
            r43 = r8
            r20 = r9
        L_0x0650:
            r1 = r42
            if (r1 == 0) goto L_0x0666
            if (r14 == r15) goto L_0x0666
            r2 = r43
            androidx.constraintlayout.solver.SolverVariable r3 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r1.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r6 = 4
            r10.addEquality(r3, r4, r5, r6)
            goto L_0x066b
        L_0x0666:
            r2 = r43
            goto L_0x066b
        L_0x0669:
            r38 = r24
        L_0x066b:
            if (r22 != 0) goto L_0x066f
            if (r16 == 0) goto L_0x06ec
        L_0x066f:
            if (r14 == 0) goto L_0x06ec
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x0684
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0685
        L_0x0684:
            r2 = 0
        L_0x0685:
            r20 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x0690
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0691
        L_0x0690:
            r2 = 0
        L_0x0691:
            if (r13 == r15) goto L_0x06a7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r47 + 1
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            if (r4 == 0) goto L_0x06a2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x06a3
        L_0x06a2:
            r4 = 0
        L_0x06a3:
            r2 = r4
            r24 = r2
            goto L_0x06a9
        L_0x06a7:
            r24 = r2
        L_0x06a9:
            if (r14 != r15) goto L_0x06b7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r0 = r2[r47]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r47 + 1
            r1 = r2[r3]
            r9 = r1
            goto L_0x06b8
        L_0x06b7:
            r9 = r1
        L_0x06b8:
            if (r20 == 0) goto L_0x06ea
            if (r24 == 0) goto L_0x06ea
            r25 = 1056964608(0x3f000000, float:0.5)
            int r26 = r0.getMargin()
            if (r15 != 0) goto L_0x06c6
            r1 = r13
            r15 = r1
        L_0x06c6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            int r27 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r9.mSolverVariable
            r30 = 5
            r1 = r45
            r3 = r20
            r4 = r26
            r5 = r25
            r6 = r24
            r8 = r27
            r31 = r9
            r9 = r30
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x06ec
        L_0x06ea:
            r31 = r9
        L_0x06ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}

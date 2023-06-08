package com.annimon.stream.operator;

import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntScanIdentity extends PrimitiveExtIterator.OfInt {
    private final IntBinaryOperator accumulator;
    private final int identity;
    private final PrimitiveIterator.OfInt iterator;

    public IntScanIdentity(PrimitiveIterator.OfInt iterator2, int identity2, IntBinaryOperator accumulator2) {
        this.iterator = iterator2;
        this.identity = identity2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            this.hasNext = true;
            this.next = this.identity;
            return;
        }
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.accumulator.applyAsInt(this.next, this.iterator.next().intValue());
        }
    }
}

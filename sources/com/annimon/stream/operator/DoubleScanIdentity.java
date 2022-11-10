package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleScanIdentity extends PrimitiveExtIterator.OfDouble {
    private final DoubleBinaryOperator accumulator;
    private final double identity;
    private final PrimitiveIterator.OfDouble iterator;

    public DoubleScanIdentity(PrimitiveIterator.OfDouble iterator2, double identity2, DoubleBinaryOperator accumulator2) {
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
            this.next = this.accumulator.applyAsDouble(this.next, this.iterator.next().doubleValue());
        }
    }
}

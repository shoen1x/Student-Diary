package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleScan extends PrimitiveExtIterator.OfDouble {
    private final DoubleBinaryOperator accumulator;
    private final PrimitiveIterator.OfDouble iterator;

    public DoubleScan(PrimitiveIterator.OfDouble iterator2, DoubleBinaryOperator accumulator2) {
        this.iterator = iterator2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            double current = this.iterator.nextDouble();
            if (this.isInit) {
                this.next = this.accumulator.applyAsDouble(this.next, current);
            } else {
                this.next = current;
            }
        }
    }
}

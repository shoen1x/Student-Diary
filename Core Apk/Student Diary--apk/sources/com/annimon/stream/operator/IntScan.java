package com.annimon.stream.operator;

import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntScan extends PrimitiveExtIterator.OfInt {
    private final IntBinaryOperator accumulator;
    private final PrimitiveIterator.OfInt iterator;

    public IntScan(PrimitiveIterator.OfInt iterator2, IntBinaryOperator accumulator2) {
        this.iterator = iterator2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            int current = this.iterator.next().intValue();
            if (this.isInit) {
                this.next = this.accumulator.applyAsInt(this.next, current);
            } else {
                this.next = current;
            }
        }
    }
}

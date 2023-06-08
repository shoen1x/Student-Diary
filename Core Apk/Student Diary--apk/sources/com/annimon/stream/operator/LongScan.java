package com.annimon.stream.operator;

import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongScan extends PrimitiveExtIterator.OfLong {
    private final LongBinaryOperator accumulator;
    private final PrimitiveIterator.OfLong iterator;

    public LongScan(PrimitiveIterator.OfLong iterator2, LongBinaryOperator accumulator2) {
        this.iterator = iterator2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            long current = this.iterator.nextLong();
            if (this.isInit) {
                this.next = this.accumulator.applyAsLong(this.next, current);
            } else {
                this.next = current;
            }
        }
    }
}

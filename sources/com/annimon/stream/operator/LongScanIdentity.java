package com.annimon.stream.operator;

import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongScanIdentity extends PrimitiveExtIterator.OfLong {
    private final LongBinaryOperator accumulator;
    private final long identity;
    private final PrimitiveIterator.OfLong iterator;

    public LongScanIdentity(PrimitiveIterator.OfLong iterator2, long identity2, LongBinaryOperator accumulator2) {
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
            this.next = this.accumulator.applyAsLong(this.next, this.iterator.next().longValue());
        }
    }
}

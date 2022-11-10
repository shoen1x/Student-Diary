package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntTakeUntil extends PrimitiveExtIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate stopPredicate;

    public IntTakeUntil(PrimitiveIterator.OfInt iterator2, IntPredicate stopPredicate2) {
        this.iterator = iterator2;
        this.stopPredicate = stopPredicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.next));
        if (this.hasNext) {
            this.next = this.iterator.next().intValue();
        }
    }
}

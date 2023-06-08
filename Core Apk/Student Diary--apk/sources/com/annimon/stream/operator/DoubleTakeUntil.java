package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleTakeUntil extends PrimitiveExtIterator.OfDouble {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate stopPredicate;

    public DoubleTakeUntil(PrimitiveIterator.OfDouble iterator2, DoublePredicate stopPredicate2) {
        this.iterator = iterator2;
        this.stopPredicate = stopPredicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.next));
        if (this.hasNext) {
            this.next = this.iterator.next().doubleValue();
        }
    }
}

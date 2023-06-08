package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleDropWhile extends PrimitiveExtIterator.OfDouble {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate predicate;

    public DoubleDropWhile(PrimitiveIterator.OfDouble iterator2, DoublePredicate predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            do {
                boolean hasNext = this.iterator.hasNext();
                this.hasNext = hasNext;
                if (hasNext) {
                    this.next = this.iterator.next().doubleValue();
                }
            } while (this.predicate.test(this.next));
            return;
        }
        this.hasNext = this.hasNext && this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.iterator.next().doubleValue();
        }
    }
}

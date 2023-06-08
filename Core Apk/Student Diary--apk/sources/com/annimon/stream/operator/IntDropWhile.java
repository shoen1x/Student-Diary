package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntDropWhile extends PrimitiveExtIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;

    public IntDropWhile(PrimitiveIterator.OfInt iterator2, IntPredicate predicate2) {
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
                    this.next = this.iterator.next().intValue();
                }
            } while (this.predicate.test(this.next));
            return;
        }
        this.hasNext = this.hasNext && this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.iterator.next().intValue();
        }
    }
}

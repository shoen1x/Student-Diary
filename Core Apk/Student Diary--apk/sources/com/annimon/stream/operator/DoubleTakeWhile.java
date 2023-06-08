package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleTakeWhile extends PrimitiveExtIterator.OfDouble {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate predicate;

    public DoubleTakeWhile(PrimitiveIterator.OfDouble iterator2, DoublePredicate predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        boolean z;
        if (this.iterator.hasNext()) {
            DoublePredicate doublePredicate = this.predicate;
            double doubleValue = this.iterator.next().doubleValue();
            this.next = doubleValue;
            if (doublePredicate.test(doubleValue)) {
                z = true;
                this.hasNext = z;
            }
        }
        z = false;
        this.hasNext = z;
    }
}

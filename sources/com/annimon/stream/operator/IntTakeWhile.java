package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntTakeWhile extends PrimitiveExtIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;

    public IntTakeWhile(PrimitiveIterator.OfInt iterator2, IntPredicate predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        boolean z;
        if (this.iterator.hasNext()) {
            IntPredicate intPredicate = this.predicate;
            int intValue = this.iterator.next().intValue();
            this.next = intValue;
            if (intPredicate.test(intValue)) {
                z = true;
                this.hasNext = z;
            }
        }
        z = false;
        this.hasNext = z;
    }
}

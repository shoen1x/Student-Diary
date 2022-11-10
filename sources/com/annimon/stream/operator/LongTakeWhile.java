package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongTakeWhile extends PrimitiveExtIterator.OfLong {
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate predicate;

    public LongTakeWhile(PrimitiveIterator.OfLong iterator2, LongPredicate predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        boolean z;
        if (this.iterator.hasNext()) {
            LongPredicate longPredicate = this.predicate;
            long longValue = this.iterator.next().longValue();
            this.next = longValue;
            if (longPredicate.test(longValue)) {
                z = true;
                this.hasNext = z;
            }
        }
        z = false;
        this.hasNext = z;
    }
}

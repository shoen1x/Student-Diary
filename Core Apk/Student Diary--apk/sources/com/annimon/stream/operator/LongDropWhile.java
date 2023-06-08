package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongDropWhile extends PrimitiveExtIterator.OfLong {
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate predicate;

    public LongDropWhile(PrimitiveIterator.OfLong iterator2, LongPredicate predicate2) {
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
                    this.next = this.iterator.next().longValue();
                }
            } while (this.predicate.test(this.next));
            return;
        }
        this.hasNext = this.hasNext && this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.iterator.next().longValue();
        }
    }
}

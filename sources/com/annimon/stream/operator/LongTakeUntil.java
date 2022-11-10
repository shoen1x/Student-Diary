package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongTakeUntil extends PrimitiveExtIterator.OfLong {
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate stopPredicate;

    public LongTakeUntil(PrimitiveIterator.OfLong iterator2, LongPredicate stopPredicate2) {
        this.iterator = iterator2;
        this.stopPredicate = stopPredicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.next));
        if (this.hasNext) {
            this.next = this.iterator.next().longValue();
        }
    }
}

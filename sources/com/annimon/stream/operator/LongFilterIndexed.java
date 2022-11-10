package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedLongPredicate;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class LongFilterIndexed extends PrimitiveIterator.OfLong {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final PrimitiveIndexedIterator.OfLong iterator;
    private long next;
    private final IndexedLongPredicate predicate;

    public LongFilterIndexed(PrimitiveIndexedIterator.OfLong iterator2, IndexedLongPredicate predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    public boolean hasNext() {
        if (!this.hasNextEvaluated) {
            nextIteration();
            this.hasNextEvaluated = true;
        }
        return this.hasNext;
    }

    public long nextLong() {
        if (!this.hasNextEvaluated) {
            this.hasNext = hasNext();
        }
        if (this.hasNext) {
            this.hasNextEvaluated = false;
            return this.next;
        }
        throw new NoSuchElementException();
    }

    private void nextIteration() {
        while (this.iterator.hasNext()) {
            int index = this.iterator.getIndex();
            long longValue = this.iterator.next().longValue();
            this.next = longValue;
            if (this.predicate.test(index, longValue)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}

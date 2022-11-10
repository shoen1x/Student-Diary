package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedDoublePredicate;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class DoubleFilterIndexed extends PrimitiveIterator.OfDouble {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final PrimitiveIndexedIterator.OfDouble iterator;
    private double next;
    private final IndexedDoublePredicate predicate;

    public DoubleFilterIndexed(PrimitiveIndexedIterator.OfDouble iterator2, IndexedDoublePredicate predicate2) {
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

    public double nextDouble() {
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
            double doubleValue = this.iterator.next().doubleValue();
            this.next = doubleValue;
            if (this.predicate.test(index, doubleValue)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}

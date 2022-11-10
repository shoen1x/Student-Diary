package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedIntPredicate;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class IntFilterIndexed extends PrimitiveIterator.OfInt {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final PrimitiveIndexedIterator.OfInt iterator;
    private int next;
    private final IndexedIntPredicate predicate;

    public IntFilterIndexed(PrimitiveIndexedIterator.OfInt iterator2, IndexedIntPredicate predicate2) {
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

    public int nextInt() {
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
            int intValue = this.iterator.next().intValue();
            this.next = intValue;
            if (this.predicate.test(index, intValue)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}

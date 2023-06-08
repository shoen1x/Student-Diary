package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class DoubleFilter extends PrimitiveIterator.OfDouble {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final PrimitiveIterator.OfDouble iterator;
    private double next;
    private final DoublePredicate predicate;

    public DoubleFilter(PrimitiveIterator.OfDouble iterator2, DoublePredicate predicate2) {
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
            double nextDouble = this.iterator.nextDouble();
            this.next = nextDouble;
            if (this.predicate.test(nextDouble)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}

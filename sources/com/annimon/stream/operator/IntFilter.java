package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class IntFilter extends PrimitiveIterator.OfInt {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final PrimitiveIterator.OfInt iterator;
    private int next;
    private final IntPredicate predicate;

    public IntFilter(PrimitiveIterator.OfInt iterator2, IntPredicate predicate2) {
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
            int nextInt = this.iterator.nextInt();
            this.next = nextInt;
            if (this.predicate.test(nextInt)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}

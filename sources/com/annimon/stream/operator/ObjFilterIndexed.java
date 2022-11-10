package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjFilterIndexed<T> implements Iterator<T> {
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final IndexedIterator<? extends T> iterator;
    private T next;
    private final IndexedPredicate<? super T> predicate;

    public ObjFilterIndexed(IndexedIterator<? extends T> iterator2, IndexedPredicate<? super T> predicate2) {
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

    public T next() {
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
            T next2 = this.iterator.next();
            this.next = next2;
            if (this.predicate.test(index, next2)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}

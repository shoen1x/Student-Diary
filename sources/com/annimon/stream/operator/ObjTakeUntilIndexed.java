package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjTakeUntilIndexed<T> extends LsaExtIterator<T> {
    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> stopPredicate;

    public ObjTakeUntilIndexed(IndexedIterator<? extends T> iterator2, IndexedPredicate<? super T> predicate) {
        this.iterator = iterator2;
        this.stopPredicate = predicate;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.iterator.getIndex(), this.next));
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}

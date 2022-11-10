package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjDropWhileIndexed<T> extends LsaExtIterator<T> {
    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> predicate;

    public ObjDropWhileIndexed(IndexedIterator<? extends T> iterator2, IndexedPredicate<? super T> predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        int index;
        if (!this.isInit) {
            do {
                boolean hasNext = this.iterator.hasNext();
                this.hasNext = hasNext;
                if (hasNext) {
                    index = this.iterator.getIndex();
                    this.next = this.iterator.next();
                }
            } while (this.predicate.test(index, this.next));
            return;
        }
        this.hasNext = this.hasNext && this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}

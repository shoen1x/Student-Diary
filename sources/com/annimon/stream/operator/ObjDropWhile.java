package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjDropWhile<T> extends LsaExtIterator<T> {
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;

    public ObjDropWhile(Iterator<? extends T> iterator2, Predicate<? super T> predicate2) {
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
                    this.next = this.iterator.next();
                }
            } while (this.predicate.test(this.next));
            return;
        }
        this.hasNext = this.hasNext && this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}

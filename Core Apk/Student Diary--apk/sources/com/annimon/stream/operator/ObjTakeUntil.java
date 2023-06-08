package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjTakeUntil<T> extends LsaExtIterator<T> {
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> stopPredicate;

    public ObjTakeUntil(Iterator<? extends T> iterator2, Predicate<? super T> predicate) {
        this.iterator = iterator2;
        this.stopPredicate = predicate;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.next));
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}

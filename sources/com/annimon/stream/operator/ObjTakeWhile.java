package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjTakeWhile<T> extends LsaExtIterator<T> {
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;

    public ObjTakeWhile(Iterator<? extends T> iterator2, Predicate<? super T> predicate2) {
        this.iterator = iterator2;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        boolean z;
        if (this.iterator.hasNext()) {
            Predicate<? super T> predicate2 = this.predicate;
            Object next = this.iterator.next();
            this.next = next;
            if (predicate2.test(next)) {
                z = true;
                this.hasNext = z;
            }
        }
        z = false;
        this.hasNext = z;
    }
}

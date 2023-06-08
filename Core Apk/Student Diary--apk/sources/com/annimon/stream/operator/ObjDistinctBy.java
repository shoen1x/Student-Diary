package com.annimon.stream.operator;

import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ObjDistinctBy<T, K> extends LsaExtIterator<T> {
    private final Function<? super T, ? extends K> classifier;
    private final Iterator<? extends T> iterator;
    private final Set<K> set = new HashSet();

    public ObjDistinctBy(Iterator<? extends T> iterator2, Function<? super T, ? extends K> classifier2) {
        this.iterator = iterator2;
        this.classifier = classifier2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        do {
            boolean hasNext = this.iterator.hasNext();
            this.hasNext = hasNext;
            if (hasNext) {
                this.next = this.iterator.next();
            } else {
                return;
            }
        } while (!this.set.add(this.classifier.apply(this.next)));
    }
}

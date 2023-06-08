package com.annimon.stream.operator;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ObjSorted<T> extends LsaExtIterator<T> {
    private final Comparator<? super T> comparator;
    private final Iterator<? extends T> iterator;
    private Iterator<T> sortedIterator;

    public ObjSorted(Iterator<? extends T> iterator2, Comparator<? super T> comparator2) {
        this.iterator = iterator2;
        this.comparator = comparator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            List<T> list = Operators.toList(this.iterator);
            Collections.sort(list, this.comparator);
            this.sortedIterator = list.iterator();
        }
        this.hasNext = this.sortedIterator.hasNext();
        if (this.hasNext) {
            this.next = this.sortedIterator.next();
        }
    }
}

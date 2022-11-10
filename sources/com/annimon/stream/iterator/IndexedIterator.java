package com.annimon.stream.iterator;

import java.util.Iterator;

public class IndexedIterator<T> implements Iterator<T> {
    private int index;
    private final Iterator<? extends T> iterator;
    private final int step;

    public IndexedIterator(Iterator<? extends T> iterator2) {
        this(0, 1, iterator2);
    }

    public IndexedIterator(int start, int step2, Iterator<? extends T> iterator2) {
        this.iterator = iterator2;
        this.step = step2;
        this.index = start;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        T result = this.iterator.next();
        this.index += this.step;
        return result;
    }

    public void remove() {
        this.iterator.remove();
    }
}

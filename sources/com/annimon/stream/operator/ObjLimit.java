package com.annimon.stream.operator;

import com.annimon.stream.iterator.LsaIterator;
import java.util.Iterator;

public class ObjLimit<T> extends LsaIterator<T> {
    private long index = 0;
    private final Iterator<? extends T> iterator;
    private final long maxSize;

    public ObjLimit(Iterator<? extends T> iterator2, long maxSize2) {
        this.iterator = iterator2;
        this.maxSize = maxSize2;
    }

    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }

    public T nextIteration() {
        this.index++;
        return this.iterator.next();
    }
}

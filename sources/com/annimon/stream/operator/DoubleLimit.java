package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleLimit extends PrimitiveIterator.OfDouble {
    private long index = 0;
    private final PrimitiveIterator.OfDouble iterator;
    private final long maxSize;

    public DoubleLimit(PrimitiveIterator.OfDouble iterator2, long maxSize2) {
        this.iterator = iterator2;
        this.maxSize = maxSize2;
    }

    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }

    public double nextDouble() {
        this.index++;
        return this.iterator.nextDouble();
    }
}

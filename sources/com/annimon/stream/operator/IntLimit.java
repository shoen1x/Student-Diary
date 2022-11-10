package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntLimit extends PrimitiveIterator.OfInt {
    private long index = 0;
    private final PrimitiveIterator.OfInt iterator;
    private final long maxSize;

    public IntLimit(PrimitiveIterator.OfInt iterator2, long maxSize2) {
        this.iterator = iterator2;
        this.maxSize = maxSize2;
    }

    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }

    public int nextInt() {
        this.index++;
        return this.iterator.nextInt();
    }
}

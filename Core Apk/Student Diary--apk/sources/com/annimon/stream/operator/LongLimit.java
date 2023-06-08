package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongLimit extends PrimitiveIterator.OfLong {
    private long index = 0;
    private final PrimitiveIterator.OfLong iterator;
    private final long maxSize;

    public LongLimit(PrimitiveIterator.OfLong iterator2, long maxSize2) {
        this.iterator = iterator2;
        this.maxSize = maxSize2;
    }

    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }

    public long nextLong() {
        this.index++;
        return this.iterator.nextLong();
    }
}

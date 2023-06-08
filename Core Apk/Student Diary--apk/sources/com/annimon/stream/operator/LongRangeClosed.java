package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongRangeClosed extends PrimitiveIterator.OfLong {
    private long current;
    private final long endInclusive;
    private boolean hasNext;

    public LongRangeClosed(long startInclusive, long endInclusive2) {
        this.endInclusive = endInclusive2;
        this.current = startInclusive;
        this.hasNext = startInclusive <= endInclusive2;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public long nextLong() {
        long j = this.current;
        long j2 = this.endInclusive;
        if (j >= j2) {
            this.hasNext = false;
            return j2;
        }
        this.current = 1 + j;
        return j;
    }
}

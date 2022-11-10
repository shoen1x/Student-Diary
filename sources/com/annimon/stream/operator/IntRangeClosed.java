package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntRangeClosed extends PrimitiveIterator.OfInt {
    private int current;
    private final int endInclusive;
    private boolean hasNext;

    public IntRangeClosed(int startInclusive, int endInclusive2) {
        this.endInclusive = endInclusive2;
        this.current = startInclusive;
        this.hasNext = startInclusive <= endInclusive2;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public int nextInt() {
        int i = this.current;
        int i2 = this.endInclusive;
        if (i >= i2) {
            this.hasNext = false;
            return i2;
        }
        this.current = i + 1;
        return i;
    }
}

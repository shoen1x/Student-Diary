package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongArray extends PrimitiveIterator.OfLong {
    private int index = 0;
    private final long[] values;

    public LongArray(long[] values2) {
        this.values = values2;
    }

    public long nextLong() {
        long[] jArr = this.values;
        int i = this.index;
        this.index = i + 1;
        return jArr[i];
    }

    public boolean hasNext() {
        return this.index < this.values.length;
    }
}

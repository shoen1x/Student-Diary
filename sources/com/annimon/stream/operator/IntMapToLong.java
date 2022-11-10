package com.annimon.stream.operator;

import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapToLong extends PrimitiveIterator.OfLong {
    private final PrimitiveIterator.OfInt iterator;
    private final IntToLongFunction mapper;

    public IntMapToLong(PrimitiveIterator.OfInt iterator2, IntToLongFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.nextInt());
    }
}

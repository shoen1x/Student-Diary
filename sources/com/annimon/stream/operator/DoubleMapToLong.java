package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapToLong extends PrimitiveIterator.OfLong {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleToLongFunction mapper;

    public DoubleMapToLong(PrimitiveIterator.OfDouble iterator2, DoubleToLongFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.nextDouble());
    }
}

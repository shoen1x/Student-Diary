package com.annimon.stream.operator;

import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapToDouble extends PrimitiveIterator.OfDouble {
    private final PrimitiveIterator.OfInt iterator;
    private final IntToDoubleFunction mapper;

    public IntMapToDouble(PrimitiveIterator.OfInt iterator2, IntToDoubleFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.nextInt());
    }
}

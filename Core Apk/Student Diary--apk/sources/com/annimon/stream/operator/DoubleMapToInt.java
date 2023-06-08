package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapToInt extends PrimitiveIterator.OfInt {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleToIntFunction mapper;

    public DoubleMapToInt(PrimitiveIterator.OfDouble iterator2, DoubleToIntFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextDouble());
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMap extends PrimitiveIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final IntUnaryOperator mapper;

    public IntMap(PrimitiveIterator.OfInt iterator2, IntUnaryOperator mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextInt());
    }
}

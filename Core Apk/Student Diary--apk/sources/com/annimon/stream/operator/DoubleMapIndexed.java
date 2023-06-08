package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedDoubleUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapIndexed extends PrimitiveIterator.OfDouble {
    private final PrimitiveIndexedIterator.OfDouble iterator;
    private final IndexedDoubleUnaryOperator mapper;

    public DoubleMapIndexed(PrimitiveIndexedIterator.OfDouble iterator2, IndexedDoubleUnaryOperator mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.getIndex(), this.iterator.next().doubleValue());
    }
}

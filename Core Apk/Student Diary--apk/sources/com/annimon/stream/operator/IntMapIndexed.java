package com.annimon.stream.operator;

import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapIndexed extends PrimitiveIterator.OfInt {
    private final PrimitiveIndexedIterator.OfInt iterator;
    private final IntBinaryOperator mapper;

    public IntMapIndexed(PrimitiveIndexedIterator.OfInt iterator2, IntBinaryOperator mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.getIndex(), this.iterator.next().intValue());
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.iterator.LsaIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapToObj<R> extends LsaIterator<R> {
    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleFunction<? extends R> mapper;

    public DoubleMapToObj(PrimitiveIterator.OfDouble iterator2, DoubleFunction<? extends R> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public R nextIteration() {
        return this.mapper.apply(this.iterator.nextDouble());
    }
}

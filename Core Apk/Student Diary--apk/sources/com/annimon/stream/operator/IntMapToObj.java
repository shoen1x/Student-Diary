package com.annimon.stream.operator;

import com.annimon.stream.function.IntFunction;
import com.annimon.stream.iterator.LsaIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapToObj<R> extends LsaIterator<R> {
    private final PrimitiveIterator.OfInt iterator;
    private final IntFunction<? extends R> mapper;

    public IntMapToObj(PrimitiveIterator.OfInt iterator2, IntFunction<? extends R> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public R nextIteration() {
        return this.mapper.apply(this.iterator.nextInt());
    }
}

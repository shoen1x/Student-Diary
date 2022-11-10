package com.annimon.stream.operator;

import com.annimon.stream.function.LongFunction;
import com.annimon.stream.iterator.LsaIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapToObj<R> extends LsaIterator<R> {
    private final PrimitiveIterator.OfLong iterator;
    private final LongFunction<? extends R> mapper;

    public LongMapToObj(PrimitiveIterator.OfLong iterator2, LongFunction<? extends R> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public R nextIteration() {
        return this.mapper.apply(this.iterator.nextLong());
    }
}

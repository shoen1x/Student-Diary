package com.annimon.stream.operator;

import com.annimon.stream.function.LongToDoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapToDouble extends PrimitiveIterator.OfDouble {
    private final PrimitiveIterator.OfLong iterator;
    private final LongToDoubleFunction mapper;

    public LongMapToDouble(PrimitiveIterator.OfLong iterator2, LongToDoubleFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.nextLong());
    }
}

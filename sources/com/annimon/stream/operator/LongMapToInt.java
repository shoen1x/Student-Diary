package com.annimon.stream.operator;

import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapToInt extends PrimitiveIterator.OfInt {
    private final PrimitiveIterator.OfLong iterator;
    private final LongToIntFunction mapper;

    public LongMapToInt(PrimitiveIterator.OfLong iterator2, LongToIntFunction mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextLong());
    }
}

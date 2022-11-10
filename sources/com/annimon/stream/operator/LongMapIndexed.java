package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedLongUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapIndexed extends PrimitiveIterator.OfLong {
    private final PrimitiveIndexedIterator.OfLong iterator;
    private final IndexedLongUnaryOperator mapper;

    public LongMapIndexed(PrimitiveIndexedIterator.OfLong iterator2, IndexedLongUnaryOperator mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.getIndex(), this.iterator.next().longValue());
    }
}

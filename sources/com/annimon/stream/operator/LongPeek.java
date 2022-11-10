package com.annimon.stream.operator;

import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongPeek extends PrimitiveIterator.OfLong {
    private final LongConsumer action;
    private final PrimitiveIterator.OfLong iterator;

    public LongPeek(PrimitiveIterator.OfLong iterator2, LongConsumer action2) {
        this.iterator = iterator2;
        this.action = action2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public long nextLong() {
        long value = this.iterator.nextLong();
        this.action.accept(value);
        return value;
    }
}

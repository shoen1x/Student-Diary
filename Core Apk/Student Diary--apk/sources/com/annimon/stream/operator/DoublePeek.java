package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoublePeek extends PrimitiveIterator.OfDouble {
    private final DoubleConsumer action;
    private final PrimitiveIterator.OfDouble iterator;

    public DoublePeek(PrimitiveIterator.OfDouble iterator2, DoubleConsumer action2) {
        this.iterator = iterator2;
        this.action = action2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        double value = this.iterator.nextDouble();
        this.action.accept(value);
        return value;
    }
}

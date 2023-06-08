package com.annimon.stream.operator;

import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntPeek extends PrimitiveIterator.OfInt {
    private final IntConsumer action;
    private final PrimitiveIterator.OfInt iterator;

    public IntPeek(PrimitiveIterator.OfInt iterator2, IntConsumer action2) {
        this.iterator = iterator2;
        this.action = action2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        int value = this.iterator.nextInt();
        this.action.accept(value);
        return value;
    }
}

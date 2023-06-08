package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntSample extends PrimitiveIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final int stepWidth;

    public IntSample(PrimitiveIterator.OfInt iterator2, int stepWidth2) {
        this.iterator = iterator2;
        this.stepWidth = stepWidth2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        int result = this.iterator.nextInt();
        for (int skip = 1; skip < this.stepWidth && this.iterator.hasNext(); skip++) {
            this.iterator.nextInt();
        }
        return result;
    }
}

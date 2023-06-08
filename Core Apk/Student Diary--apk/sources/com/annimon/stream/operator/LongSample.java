package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongSample extends PrimitiveIterator.OfLong {
    private final PrimitiveIterator.OfLong iterator;
    private final int stepWidth;

    public LongSample(PrimitiveIterator.OfLong iterator2, int stepWidth2) {
        this.iterator = iterator2;
        this.stepWidth = stepWidth2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public long nextLong() {
        long result = this.iterator.nextLong();
        for (int skip = 1; skip < this.stepWidth && this.iterator.hasNext(); skip++) {
            this.iterator.nextLong();
        }
        return result;
    }
}

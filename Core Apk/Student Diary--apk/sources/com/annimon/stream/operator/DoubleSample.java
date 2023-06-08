package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleSample extends PrimitiveIterator.OfDouble {
    private final PrimitiveIterator.OfDouble iterator;
    private final int stepWidth;

    public DoubleSample(PrimitiveIterator.OfDouble iterator2, int stepWidth2) {
        this.iterator = iterator2;
        this.stepWidth = stepWidth2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        double result = this.iterator.nextDouble();
        for (int skip = 1; skip < this.stepWidth && this.iterator.hasNext(); skip++) {
            this.iterator.nextDouble();
        }
        return result;
    }
}

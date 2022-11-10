package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleSkip extends PrimitiveIterator.OfDouble {
    private final PrimitiveIterator.OfDouble iterator;
    private final long n;
    private long skipped = 0;

    public DoubleSkip(PrimitiveIterator.OfDouble iterator2, long n2) {
        this.iterator = iterator2;
        this.n = n2;
    }

    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextDouble();
            this.skipped++;
        }
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        return this.iterator.nextDouble();
    }
}

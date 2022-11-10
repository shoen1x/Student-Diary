package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntSkip extends PrimitiveIterator.OfInt {
    private final PrimitiveIterator.OfInt iterator;
    private final long n;
    private long skipped = 0;

    public IntSkip(PrimitiveIterator.OfInt iterator2, long n2) {
        this.iterator = iterator2;
        this.n = n2;
    }

    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextInt();
            this.skipped++;
        }
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.iterator.nextInt();
    }
}

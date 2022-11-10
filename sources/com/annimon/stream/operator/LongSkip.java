package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongSkip extends PrimitiveIterator.OfLong {
    private final PrimitiveIterator.OfLong iterator;
    private final long n;
    private long skipped = 0;

    public LongSkip(PrimitiveIterator.OfLong iterator2, long n2) {
        this.iterator = iterator2;
        this.n = n2;
    }

    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextLong();
            this.skipped++;
        }
        return this.iterator.hasNext();
    }

    public long nextLong() {
        return this.iterator.nextLong();
    }
}

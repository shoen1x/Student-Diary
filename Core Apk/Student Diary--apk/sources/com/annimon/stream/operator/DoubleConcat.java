package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleConcat extends PrimitiveIterator.OfDouble {
    private boolean firstStreamIsCurrent = true;
    private final PrimitiveIterator.OfDouble iterator1;
    private final PrimitiveIterator.OfDouble iterator2;

    public DoubleConcat(PrimitiveIterator.OfDouble iterator12, PrimitiveIterator.OfDouble iterator22) {
        this.iterator1 = iterator12;
        this.iterator2 = iterator22;
    }

    public boolean hasNext() {
        if (this.firstStreamIsCurrent) {
            if (this.iterator1.hasNext()) {
                return true;
            }
            this.firstStreamIsCurrent = false;
        }
        return this.iterator2.hasNext();
    }

    public double nextDouble() {
        return (this.firstStreamIsCurrent ? this.iterator1 : this.iterator2).nextDouble();
    }
}

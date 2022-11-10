package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntConcat extends PrimitiveIterator.OfInt {
    private boolean firstStreamIsCurrent = true;
    private final PrimitiveIterator.OfInt iterator1;
    private final PrimitiveIterator.OfInt iterator2;

    public IntConcat(PrimitiveIterator.OfInt iterator12, PrimitiveIterator.OfInt iterator22) {
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

    public int nextInt() {
        return (this.firstStreamIsCurrent ? this.iterator1 : this.iterator2).nextInt();
    }
}

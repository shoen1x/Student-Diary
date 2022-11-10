package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongConcat extends PrimitiveIterator.OfLong {
    private boolean firstStreamIsCurrent = true;
    private final PrimitiveIterator.OfLong iterator1;
    private final PrimitiveIterator.OfLong iterator2;

    public LongConcat(PrimitiveIterator.OfLong iterator12, PrimitiveIterator.OfLong iterator22) {
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

    public long nextLong() {
        return (this.firstStreamIsCurrent ? this.iterator1 : this.iterator2).nextLong();
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongGenerate extends PrimitiveIterator.OfLong {
    private final LongSupplier supplier;

    public LongGenerate(LongSupplier supplier2) {
        this.supplier = supplier2;
    }

    public boolean hasNext() {
        return true;
    }

    public long nextLong() {
        return this.supplier.getAsLong();
    }
}

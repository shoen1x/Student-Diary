package com.annimon.stream.operator;

import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntGenerate extends PrimitiveIterator.OfInt {
    private final IntSupplier supplier;

    public IntGenerate(IntSupplier supplier2) {
        this.supplier = supplier2;
    }

    public boolean hasNext() {
        return true;
    }

    public int nextInt() {
        return this.supplier.getAsInt();
    }
}

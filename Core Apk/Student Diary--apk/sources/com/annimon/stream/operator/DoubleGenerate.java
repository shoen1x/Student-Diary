package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleGenerate extends PrimitiveIterator.OfDouble {
    private final DoubleSupplier supplier;

    public DoubleGenerate(DoubleSupplier supplier2) {
        this.supplier = supplier2;
    }

    public boolean hasNext() {
        return true;
    }

    public double nextDouble() {
        return this.supplier.getAsDouble();
    }
}

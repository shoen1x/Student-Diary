package com.annimon.stream.operator;

import com.annimon.stream.function.Supplier;
import com.annimon.stream.iterator.LsaIterator;

public class ObjGenerate<T> extends LsaIterator<T> {
    private final Supplier<T> supplier;

    public ObjGenerate(Supplier<T> supplier2) {
        this.supplier = supplier2;
    }

    public boolean hasNext() {
        return true;
    }

    public T nextIteration() {
        return this.supplier.get();
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntIterate extends PrimitiveIterator.OfInt {
    private int current;
    private final IntUnaryOperator op;

    public IntIterate(int seed, IntUnaryOperator f) {
        this.op = f;
        this.current = seed;
    }

    public boolean hasNext() {
        return true;
    }

    public int nextInt() {
        int old = this.current;
        this.current = this.op.applyAsInt(this.current);
        return old;
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleIterate extends PrimitiveIterator.OfDouble {
    private double current;
    private final DoubleUnaryOperator op;

    public DoubleIterate(double seed, DoubleUnaryOperator f) {
        this.op = f;
        this.current = seed;
    }

    public boolean hasNext() {
        return true;
    }

    public double nextDouble() {
        double old = this.current;
        this.current = this.op.applyAsDouble(this.current);
        return old;
    }
}

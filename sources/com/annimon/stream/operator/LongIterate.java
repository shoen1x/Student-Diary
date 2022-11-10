package com.annimon.stream.operator;

import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongIterate extends PrimitiveIterator.OfLong {
    private long current;
    private final LongUnaryOperator op;

    public LongIterate(long seed, LongUnaryOperator f) {
        this.op = f;
        this.current = seed;
    }

    public boolean hasNext() {
        return true;
    }

    public long nextLong() {
        long old = this.current;
        this.current = this.op.applyAsLong(this.current);
        return old;
    }
}

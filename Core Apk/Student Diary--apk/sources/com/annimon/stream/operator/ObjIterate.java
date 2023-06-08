package com.annimon.stream.operator;

import com.annimon.stream.function.UnaryOperator;
import com.annimon.stream.iterator.LsaIterator;

public class ObjIterate<T> extends LsaIterator<T> {
    private T current;
    private final UnaryOperator<T> op;

    public ObjIterate(T seed, UnaryOperator<T> op2) {
        this.op = op2;
        this.current = seed;
    }

    public boolean hasNext() {
        return true;
    }

    public T nextIteration() {
        T old = this.current;
        this.current = this.op.apply(this.current);
        return old;
    }
}

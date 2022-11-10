package com.annimon.stream.operator;

import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjScan<T> extends LsaExtIterator<T> {
    private final BiFunction<T, T, T> accumulator;
    private final Iterator<? extends T> iterator;

    public ObjScan(Iterator<? extends T> iterator2, BiFunction<T, T, T> accumulator2) {
        this.iterator = iterator2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            T value = this.iterator.next();
            if (this.isInit) {
                this.next = this.accumulator.apply(this.next, value);
            } else {
                this.next = value;
            }
        }
    }
}

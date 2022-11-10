package com.annimon.stream.operator;

import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjScanIdentity<T, R> extends LsaExtIterator<R> {
    private final BiFunction<? super R, ? super T, ? extends R> accumulator;
    private final R identity;
    private final Iterator<? extends T> iterator;

    public ObjScanIdentity(Iterator<? extends T> iterator2, R identity2, BiFunction<? super R, ? super T, ? extends R> accumulator2) {
        this.iterator = iterator2;
        this.identity = identity2;
        this.accumulator = accumulator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            this.hasNext = true;
            this.next = this.identity;
            return;
        }
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            this.next = this.accumulator.apply(this.next, this.iterator.next());
        }
    }
}

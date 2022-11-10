package com.annimon.stream.operator;

import com.annimon.stream.iterator.LsaIterator;
import java.util.Iterator;

public class ObjSkip<T> extends LsaIterator<T> {
    private final Iterator<? extends T> iterator;
    private final long n;
    private long skipped = 0;

    public ObjSkip(Iterator<? extends T> iterator2, long n2) {
        this.iterator = iterator2;
        this.n = n2;
    }

    public boolean hasNext() {
        while (this.skipped < this.n) {
            if (!this.iterator.hasNext()) {
                return false;
            }
            this.iterator.next();
            this.skipped++;
        }
        return this.iterator.hasNext();
    }

    public T nextIteration() {
        return this.iterator.next();
    }
}

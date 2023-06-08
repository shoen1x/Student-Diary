package com.annimon.stream.operator;

import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.LsaIterator;
import java.util.Iterator;

public class ObjMap<T, R> extends LsaIterator<R> {
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends R> mapper;

    public ObjMap(Iterator<? extends T> iterator2, Function<? super T, ? extends R> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public R nextIteration() {
        return this.mapper.apply(this.iterator.next());
    }
}

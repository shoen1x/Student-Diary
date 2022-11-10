package com.annimon.stream.operator;

import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Iterator;

public class ObjMapToDouble<T> extends PrimitiveIterator.OfDouble {
    private final Iterator<? extends T> iterator;
    private final ToDoubleFunction<? super T> mapper;

    public ObjMapToDouble(Iterator<? extends T> iterator2, ToDoubleFunction<? super T> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.next());
    }
}

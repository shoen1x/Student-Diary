package com.annimon.stream.operator;

import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Iterator;

public class ObjMapToInt<T> extends PrimitiveIterator.OfInt {
    private final Iterator<? extends T> iterator;
    private final ToIntFunction<? super T> mapper;

    public ObjMapToInt(Iterator<? extends T> iterator2, ToIntFunction<? super T> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.next());
    }
}

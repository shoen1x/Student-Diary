package com.annimon.stream.operator;

import com.annimon.stream.function.Consumer;
import com.annimon.stream.iterator.LsaIterator;
import java.util.Iterator;

public class ObjPeek<T> extends LsaIterator<T> {
    private final Consumer<? super T> action;
    private final Iterator<? extends T> iterator;

    public ObjPeek(Iterator<? extends T> iterator2, Consumer<? super T> action2) {
        this.iterator = iterator2;
        this.action = action2;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T nextIteration() {
        T value = this.iterator.next();
        this.action.accept(value);
        return value;
    }
}

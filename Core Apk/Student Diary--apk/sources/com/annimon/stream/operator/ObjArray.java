package com.annimon.stream.operator;

import com.annimon.stream.iterator.LsaIterator;

public class ObjArray<T> extends LsaIterator<T> {
    private final T[] elements;
    private int index = 0;

    public ObjArray(T[] elements2) {
        this.elements = elements2;
    }

    public boolean hasNext() {
        return this.index < this.elements.length;
    }

    public T nextIteration() {
        T[] tArr = this.elements;
        int i = this.index;
        this.index = i + 1;
        return tArr[i];
    }
}

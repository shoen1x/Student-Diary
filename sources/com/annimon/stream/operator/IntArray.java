package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntArray extends PrimitiveIterator.OfInt {
    private int index = 0;
    private final int[] values;

    public IntArray(int[] values2) {
        this.values = values2;
    }

    public boolean hasNext() {
        return this.index < this.values.length;
    }

    public int nextInt() {
        int[] iArr = this.values;
        int i = this.index;
        this.index = i + 1;
        return iArr[i];
    }
}

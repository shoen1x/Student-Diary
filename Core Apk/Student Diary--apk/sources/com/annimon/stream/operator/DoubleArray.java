package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleArray extends PrimitiveIterator.OfDouble {
    private int index = 0;
    private final double[] values;

    public DoubleArray(double[] values2) {
        this.values = values2;
    }

    public double nextDouble() {
        double[] dArr = this.values;
        int i = this.index;
        this.index = i + 1;
        return dArr[i];
    }

    public boolean hasNext() {
        return this.index < this.values.length;
    }
}

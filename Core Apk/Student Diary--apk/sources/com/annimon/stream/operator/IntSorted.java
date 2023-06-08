package com.annimon.stream.operator;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Arrays;

public class IntSorted extends PrimitiveExtIterator.OfInt {
    private int[] array;
    private int index = 0;
    private final PrimitiveIterator.OfInt iterator;

    public IntSorted(PrimitiveIterator.OfInt iterator2) {
        this.iterator = iterator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            int[] intArray = Operators.toIntArray(this.iterator);
            this.array = intArray;
            Arrays.sort(intArray);
        }
        this.hasNext = this.index < this.array.length;
        if (this.hasNext) {
            int[] iArr = this.array;
            int i = this.index;
            this.index = i + 1;
            this.next = iArr[i];
        }
    }
}

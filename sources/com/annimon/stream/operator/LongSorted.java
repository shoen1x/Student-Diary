package com.annimon.stream.operator;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Arrays;

public class LongSorted extends PrimitiveExtIterator.OfLong {
    private long[] array;
    private int index = 0;
    private final PrimitiveIterator.OfLong iterator;

    public LongSorted(PrimitiveIterator.OfLong iterator2) {
        this.iterator = iterator2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        if (!this.isInit) {
            long[] longArray = Operators.toLongArray(this.iterator);
            this.array = longArray;
            Arrays.sort(longArray);
        }
        this.hasNext = this.index < this.array.length;
        if (this.hasNext) {
            long[] jArr = this.array;
            int i = this.index;
            this.index = i + 1;
            this.next = jArr[i];
        }
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.IntStream;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class IntFlatMap extends PrimitiveIterator.OfInt {
    private PrimitiveIterator.OfInt inner;
    private IntStream innerStream;
    private final PrimitiveIterator.OfInt iterator;
    private final IntFunction<? extends IntStream> mapper;

    public IntFlatMap(PrimitiveIterator.OfInt iterator2, IntFunction<? extends IntStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        PrimitiveIterator.OfInt ofInt = this.inner;
        if (ofInt != null && ofInt.hasNext()) {
            return true;
        }
        while (this.iterator.hasNext()) {
            IntStream intStream = this.innerStream;
            if (intStream != null) {
                intStream.close();
                this.innerStream = null;
            }
            IntStream result = (IntStream) this.mapper.apply(this.iterator.nextInt());
            if (result != null) {
                this.innerStream = result;
                if (result.iterator().hasNext()) {
                    this.inner = result.iterator();
                    return true;
                }
            }
        }
        IntStream intStream2 = this.innerStream;
        if (intStream2 == null) {
            return false;
        }
        intStream2.close();
        this.innerStream = null;
        return false;
    }

    public int nextInt() {
        PrimitiveIterator.OfInt ofInt = this.inner;
        if (ofInt != null) {
            return ofInt.nextInt();
        }
        throw new NoSuchElementException();
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.DoubleStream;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class DoubleFlatMap extends PrimitiveIterator.OfDouble {
    private PrimitiveIterator.OfDouble inner;
    private DoubleStream innerStream;
    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleFunction<? extends DoubleStream> mapper;

    public DoubleFlatMap(PrimitiveIterator.OfDouble iterator2, DoubleFunction<? extends DoubleStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        PrimitiveIterator.OfDouble ofDouble = this.inner;
        if (ofDouble != null && ofDouble.hasNext()) {
            return true;
        }
        while (this.iterator.hasNext()) {
            DoubleStream doubleStream = this.innerStream;
            if (doubleStream != null) {
                doubleStream.close();
                this.innerStream = null;
            }
            DoubleStream result = (DoubleStream) this.mapper.apply(this.iterator.nextDouble());
            if (result != null) {
                this.innerStream = result;
                if (result.iterator().hasNext()) {
                    this.inner = result.iterator();
                    return true;
                }
            }
        }
        DoubleStream doubleStream2 = this.innerStream;
        if (doubleStream2 == null) {
            return false;
        }
        doubleStream2.close();
        this.innerStream = null;
        return false;
    }

    public double nextDouble() {
        PrimitiveIterator.OfDouble ofDouble = this.inner;
        if (ofDouble != null) {
            return ofDouble.nextDouble();
        }
        throw new NoSuchElementException();
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.DoubleStream;
import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Iterator;

public class ObjFlatMapToDouble<T> extends PrimitiveExtIterator.OfDouble {
    private PrimitiveIterator.OfDouble inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends DoubleStream> mapper;

    public ObjFlatMapToDouble(Iterator<? extends T> iterator2, Function<? super T, ? extends DoubleStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        PrimitiveIterator.OfDouble ofDouble = this.inner;
        if (ofDouble == null || !ofDouble.hasNext()) {
            while (this.iterator.hasNext()) {
                PrimitiveIterator.OfDouble ofDouble2 = this.inner;
                if (ofDouble2 == null || !ofDouble2.hasNext()) {
                    DoubleStream result = (DoubleStream) this.mapper.apply(this.iterator.next());
                    if (result != null) {
                        this.inner = result.iterator();
                    }
                }
                T arg = this.inner;
                if (arg != null && arg.hasNext()) {
                    this.next = this.inner.next().doubleValue();
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
            return;
        }
        this.next = this.inner.next().doubleValue();
        this.hasNext = true;
    }
}

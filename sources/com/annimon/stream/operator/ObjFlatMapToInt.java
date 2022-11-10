package com.annimon.stream.operator;

import com.annimon.stream.IntStream;
import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Iterator;

public class ObjFlatMapToInt<T> extends PrimitiveExtIterator.OfInt {
    private PrimitiveIterator.OfInt inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends IntStream> mapper;

    public ObjFlatMapToInt(Iterator<? extends T> iterator2, Function<? super T, ? extends IntStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        PrimitiveIterator.OfInt ofInt = this.inner;
        if (ofInt == null || !ofInt.hasNext()) {
            while (this.iterator.hasNext()) {
                PrimitiveIterator.OfInt ofInt2 = this.inner;
                if (ofInt2 == null || !ofInt2.hasNext()) {
                    IntStream result = (IntStream) this.mapper.apply(this.iterator.next());
                    if (result != null) {
                        this.inner = result.iterator();
                    }
                }
                T arg = this.inner;
                if (arg != null && arg.hasNext()) {
                    this.next = this.inner.next().intValue();
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
            return;
        }
        this.next = this.inner.next().intValue();
        this.hasNext = true;
    }
}

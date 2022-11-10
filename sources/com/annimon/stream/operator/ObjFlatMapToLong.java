package com.annimon.stream.operator;

import com.annimon.stream.LongStream;
import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.PrimitiveExtIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Iterator;

public class ObjFlatMapToLong<T> extends PrimitiveExtIterator.OfLong {
    private PrimitiveIterator.OfLong inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends LongStream> mapper;

    public ObjFlatMapToLong(Iterator<? extends T> iterator2, Function<? super T, ? extends LongStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        PrimitiveIterator.OfLong ofLong = this.inner;
        if (ofLong == null || !ofLong.hasNext()) {
            while (this.iterator.hasNext()) {
                PrimitiveIterator.OfLong ofLong2 = this.inner;
                if (ofLong2 == null || !ofLong2.hasNext()) {
                    LongStream result = (LongStream) this.mapper.apply(this.iterator.next());
                    if (result != null) {
                        this.inner = result.iterator();
                    }
                }
                T arg = this.inner;
                if (arg != null && arg.hasNext()) {
                    this.next = this.inner.next().longValue();
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
            return;
        }
        this.next = this.inner.next().longValue();
        this.hasNext = true;
    }
}

package com.annimon.stream.operator;

import com.annimon.stream.LongStream;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class LongFlatMap extends PrimitiveIterator.OfLong {
    private PrimitiveIterator.OfLong inner;
    private LongStream innerStream;
    private final PrimitiveIterator.OfLong iterator;
    private final LongFunction<? extends LongStream> mapper;

    public LongFlatMap(PrimitiveIterator.OfLong iterator2, LongFunction<? extends LongStream> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    public boolean hasNext() {
        PrimitiveIterator.OfLong ofLong = this.inner;
        if (ofLong != null && ofLong.hasNext()) {
            return true;
        }
        while (this.iterator.hasNext()) {
            LongStream longStream = this.innerStream;
            if (longStream != null) {
                longStream.close();
                this.innerStream = null;
            }
            LongStream result = (LongStream) this.mapper.apply(this.iterator.nextLong());
            if (result != null) {
                this.innerStream = result;
                if (result.iterator().hasNext()) {
                    this.inner = result.iterator();
                    return true;
                }
            }
        }
        LongStream longStream2 = this.innerStream;
        if (longStream2 == null) {
            return false;
        }
        longStream2.close();
        this.innerStream = null;
        return false;
    }

    public long nextLong() {
        PrimitiveIterator.OfLong ofLong = this.inner;
        if (ofLong != null) {
            return ofLong.nextLong();
        }
        throw new NoSuchElementException();
    }
}

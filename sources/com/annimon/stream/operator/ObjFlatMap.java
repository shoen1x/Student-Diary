package com.annimon.stream.operator;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.LsaExtIterator;
import java.util.Iterator;

public class ObjFlatMap<T, R> extends LsaExtIterator<R> {
    private Iterator<? extends R> inner;
    private Stream<? extends R> innerStream;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends Stream<? extends R>> mapper;

    public ObjFlatMap(Iterator<? extends T> iterator2, Function<? super T, ? extends Stream<? extends R>> mapper2) {
        this.iterator = iterator2;
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    public void nextIteration() {
        Iterator<? extends R> it = this.inner;
        if (it == null || !it.hasNext()) {
            while (this.iterator.hasNext()) {
                Iterator<? extends R> it2 = this.inner;
                if (it2 == null || !it2.hasNext()) {
                    Stream<? extends R> stream = this.innerStream;
                    if (stream != null) {
                        stream.close();
                        this.innerStream = null;
                    }
                    Stream<? extends R> result = (Stream) this.mapper.apply(this.iterator.next());
                    if (result != null) {
                        this.inner = result.iterator();
                        this.innerStream = result;
                    }
                }
                T arg = this.inner;
                if (arg != null && arg.hasNext()) {
                    this.next = this.inner.next();
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
            Stream<? extends R> stream2 = this.innerStream;
            if (stream2 != null) {
                stream2.close();
                this.innerStream = null;
                return;
            }
            return;
        }
        this.next = this.inner.next();
        this.hasNext = true;
    }
}

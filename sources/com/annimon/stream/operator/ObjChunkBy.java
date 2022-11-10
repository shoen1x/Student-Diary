package com.annimon.stream.operator;

import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.LsaIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjChunkBy<T, K> extends LsaIterator<List<T>> {
    private final Function<? super T, ? extends K> classifier;
    private final Iterator<? extends T> iterator;
    private T next;
    private boolean peekedNext;

    public ObjChunkBy(Iterator<? extends T> iterator2, Function<? super T, ? extends K> classifier2) {
        this.iterator = iterator2;
        this.classifier = classifier2;
    }

    public boolean hasNext() {
        return this.peekedNext || this.iterator.hasNext();
    }

    public List<T> nextIteration() {
        K key = this.classifier.apply(peek());
        List<T> list = new ArrayList<>();
        do {
            list.add(takeNext());
            if (!this.iterator.hasNext() || !key.equals(this.classifier.apply(peek()))) {
                return list;
            }
            list.add(takeNext());
            break;
        } while (!key.equals(this.classifier.apply(peek())));
        return list;
    }

    private T takeNext() {
        T element = peek();
        this.peekedNext = false;
        return element;
    }

    private T peek() {
        if (!this.peekedNext) {
            this.next = this.iterator.next();
            this.peekedNext = true;
        }
        return this.next;
    }
}

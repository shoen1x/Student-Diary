package com.annimon.stream.operator;

import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaIterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ObjMerge<T> extends LsaIterator<T> {
    private final Queue<T> buffer1 = new LinkedList();
    private final Queue<T> buffer2 = new LinkedList();
    private final Iterator<? extends T> iterator1;
    private final Iterator<? extends T> iterator2;
    private final BiFunction<? super T, ? super T, MergeResult> selector;

    public enum MergeResult {
        TAKE_FIRST,
        TAKE_SECOND
    }

    public ObjMerge(Iterator<? extends T> iterator12, Iterator<? extends T> iterator22, BiFunction<? super T, ? super T, MergeResult> selector2) {
        this.iterator1 = iterator12;
        this.iterator2 = iterator22;
        this.selector = selector2;
    }

    public boolean hasNext() {
        return !this.buffer1.isEmpty() || !this.buffer2.isEmpty() || this.iterator1.hasNext() || this.iterator2.hasNext();
    }

    public T nextIteration() {
        if (!this.buffer1.isEmpty()) {
            T v1 = this.buffer1.poll();
            if (this.iterator2.hasNext()) {
                return select(v1, this.iterator2.next());
            }
            return v1;
        } else if (!this.buffer2.isEmpty()) {
            T v2 = this.buffer2.poll();
            if (this.iterator1.hasNext()) {
                return select(this.iterator1.next(), v2);
            }
            return v2;
        } else if (!this.iterator1.hasNext()) {
            return this.iterator2.next();
        } else {
            if (!this.iterator2.hasNext()) {
                return this.iterator1.next();
            }
            return select(this.iterator1.next(), this.iterator2.next());
        }
    }

    /* renamed from: com.annimon.stream.operator.ObjMerge$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$annimon$stream$operator$ObjMerge$MergeResult;

        static {
            int[] iArr = new int[MergeResult.values().length];
            $SwitchMap$com$annimon$stream$operator$ObjMerge$MergeResult = iArr;
            try {
                iArr[MergeResult.TAKE_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$annimon$stream$operator$ObjMerge$MergeResult[MergeResult.TAKE_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private T select(T v1, T v2) {
        if (AnonymousClass1.$SwitchMap$com$annimon$stream$operator$ObjMerge$MergeResult[this.selector.apply(v1, v2).ordinal()] != 1) {
            this.buffer1.add(v1);
            return v2;
        }
        this.buffer2.add(v2);
        return v1;
    }
}

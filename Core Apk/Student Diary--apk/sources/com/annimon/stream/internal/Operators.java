package com.annimon.stream.internal;

import com.annimon.stream.function.IntFunction;
import com.annimon.stream.internal.SpinedBuffer;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Operators {
    private Operators() {
    }

    public static <T> List<T> toList(Iterator<? extends T> iterator) {
        List<T> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    public static <T, R> R[] toArray(Iterator<? extends T> iterator, IntFunction<R[]> generator) {
        List<T> container = toList(iterator);
        int size = container.size();
        Compat.checkMaxArraySize((long) size);
        T[] source = container.toArray(Compat.newArray(size, new Object[0]));
        R[] boxed = (Object[]) generator.apply(size);
        System.arraycopy(source, 0, boxed, 0, size);
        return boxed;
    }

    public static int[] toIntArray(PrimitiveIterator.OfInt iterator) {
        SpinedBuffer.OfInt b = new SpinedBuffer.OfInt();
        while (iterator.hasNext()) {
            b.accept(iterator.nextInt());
        }
        return (int[]) b.asPrimitiveArray();
    }

    public static long[] toLongArray(PrimitiveIterator.OfLong iterator) {
        SpinedBuffer.OfLong b = new SpinedBuffer.OfLong();
        while (iterator.hasNext()) {
            b.accept(iterator.nextLong());
        }
        return (long[]) b.asPrimitiveArray();
    }

    public static double[] toDoubleArray(PrimitiveIterator.OfDouble iterator) {
        SpinedBuffer.OfDouble b = new SpinedBuffer.OfDouble();
        while (iterator.hasNext()) {
            b.accept(iterator.nextDouble());
        }
        return (double[]) b.asPrimitiveArray();
    }
}

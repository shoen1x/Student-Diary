package com.annimon.stream.internal;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public final class Compat {
    private static final String BAD_SIZE = "Stream size exceeds max array size";
    static final long MAX_ARRAY_SIZE = 2147483639;

    public static <T> Queue<T> queue() {
        try {
            return new ArrayDeque();
        } catch (NoClassDefFoundError e) {
            return new LinkedList();
        }
    }

    @SafeVarargs
    public static <E> E[] newArray(int length, E... array) {
        try {
            return Arrays.copyOf(array, length);
        } catch (NoSuchMethodError e) {
            return newArrayCompat(array, length);
        }
    }

    public static <E> E[] newArrayCompat(E[] array, int length) {
        E[] res = (Object[]) Array.newInstance(array.getClass().getComponentType(), length);
        System.arraycopy(array, 0, res, 0, Math.min(length, array.length));
        return res;
    }

    static void checkMaxArraySize(long size) {
        if (size >= MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
    }
}

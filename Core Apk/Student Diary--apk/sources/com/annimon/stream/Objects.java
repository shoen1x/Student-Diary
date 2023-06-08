package com.annimon.stream;

import com.annimon.stream.function.Supplier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public final class Objects {
    private Objects() {
    }

    public static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static boolean deepEquals(Object a, Object b) {
        if (a != b) {
            if (a == null || b == null) {
                return false;
            }
            if (!Arrays.deepEquals(new Object[]{a}, new Object[]{b})) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(Object o) {
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    public static int hash(Object... values) {
        if (values == null) {
            return 0;
        }
        int result = 1;
        for (Object element : values) {
            result = (result * 31) + hashCode(element);
        }
        return result;
    }

    public static String toString(Object o, String nullDefault) {
        return o != null ? o.toString() : nullDefault;
    }

    public static <T> int compare(T a, T b, Comparator<? super T> c) {
        if (a == b) {
            return 0;
        }
        return c.compare(a, b);
    }

    public static int compareInt(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }

    public static int compareLong(long x, long y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }

    public static <T> T requireNonNull(T obj) {
        if (obj != null) {
            return obj;
        }
        throw null;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(message);
    }

    public static <T> T requireNonNull(T obj, Supplier<String> messageSupplier) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(messageSupplier.get());
    }

    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return obj != null ? obj : requireNonNull(defaultObj, "defaultObj");
    }

    public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
        if (obj != null) {
            return obj;
        }
        return requireNonNull(((Supplier) requireNonNull(supplier, "supplier")).get(), "supplier.get()");
    }

    public static <T> Collection<T> requireNonNullElements(Collection<T> collection) {
        requireNonNull(collection);
        for (T t : collection) {
            requireNonNull(t);
        }
        return collection;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }
}

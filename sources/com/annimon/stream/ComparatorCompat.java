package com.annimon.stream;

import com.annimon.stream.function.Function;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

public final class ComparatorCompat<T> implements Comparator<T> {
    private static final ComparatorCompat<Comparable<Object>> NATURAL_ORDER = new ComparatorCompat<>(new Comparator<Comparable<Object>>() {
        public int compare(Comparable<Object> o1, Comparable<Object> o2) {
            return o1.compareTo(o2);
        }
    });
    private static final ComparatorCompat<Comparable<Object>> REVERSE_ORDER = new ComparatorCompat<>(Collections.reverseOrder());
    /* access modifiers changed from: private */
    public final Comparator<? super T> comparator;

    public static <T extends Comparable<? super T>> ComparatorCompat<T> naturalOrder() {
        return NATURAL_ORDER;
    }

    public static <T extends Comparable<? super T>> ComparatorCompat<T> reverseOrder() {
        return REVERSE_ORDER;
    }

    public static <T> Comparator<T> reversed(Comparator<T> comparator2) {
        return Collections.reverseOrder(comparator2);
    }

    public static <T> Comparator<T> thenComparing(final Comparator<? super T> c1, final Comparator<? super T> c2) {
        Objects.requireNonNull(c1);
        Objects.requireNonNull(c2);
        return new Comparator<T>() {
            public int compare(T t1, T t2) {
                int result = c1.compare(t1, t2);
                return result != 0 ? result : c2.compare(t1, t2);
            }
        };
    }

    public static <T, U> ComparatorCompat<T> comparing(final Function<? super T, ? extends U> keyExtractor, final Comparator<? super U> keyComparator) {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                return keyComparator.compare(keyExtractor.apply(t1), keyExtractor.apply(t2));
            }
        });
    }

    public static <T, U extends Comparable<? super U>> ComparatorCompat<T> comparing(final Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                return ((Comparable) keyExtractor.apply(t1)).compareTo((Comparable) keyExtractor.apply(t2));
            }
        });
    }

    public static <T> ComparatorCompat<T> comparingInt(final ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                return Objects.compareInt(keyExtractor.applyAsInt(t1), keyExtractor.applyAsInt(t2));
            }
        });
    }

    public static <T> ComparatorCompat<T> comparingLong(final ToLongFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                return Objects.compareLong(keyExtractor.applyAsLong(t1), keyExtractor.applyAsLong(t2));
            }
        });
    }

    public static <T> ComparatorCompat<T> comparingDouble(final ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                return Double.compare(keyExtractor.applyAsDouble(t1), keyExtractor.applyAsDouble(t2));
            }
        });
    }

    public static <T> ComparatorCompat<T> nullsFirst() {
        return nullsComparator(true, (Comparator) null);
    }

    public static <T> ComparatorCompat<T> nullsFirst(Comparator<? super T> comparator2) {
        return nullsComparator(true, comparator2);
    }

    public static <T> ComparatorCompat<T> nullsLast() {
        return nullsComparator(false, (Comparator) null);
    }

    public static <T> ComparatorCompat<T> nullsLast(Comparator<? super T> comparator2) {
        return nullsComparator(false, comparator2);
    }

    private static <T> ComparatorCompat<T> nullsComparator(final boolean nullFirst, final Comparator<? super T> comparator2) {
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                if (t1 == null) {
                    if (t2 == null) {
                        return 0;
                    }
                    if (nullFirst) {
                        return -1;
                    }
                    return 1;
                } else if (t2 != null) {
                    Comparator comparator = comparator2;
                    if (comparator == null) {
                        return 0;
                    }
                    return comparator.compare(t1, t2);
                } else if (nullFirst) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public static <T> ComparatorCompat<T> chain(Comparator<T> comparator2) {
        return new ComparatorCompat<>(comparator2);
    }

    public ComparatorCompat(Comparator<? super T> comparator2) {
        this.comparator = comparator2;
    }

    public ComparatorCompat<T> reversed() {
        return new ComparatorCompat<>(Collections.reverseOrder(this.comparator));
    }

    public ComparatorCompat<T> thenComparing(final Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return new ComparatorCompat<>(new Comparator<T>() {
            public int compare(T t1, T t2) {
                int result = ComparatorCompat.this.comparator.compare(t1, t2);
                return result != 0 ? result : other.compare(t1, t2);
            }
        });
    }

    public <U> ComparatorCompat<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    public <U extends Comparable<? super U>> ComparatorCompat<T> thenComparing(Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }

    public ComparatorCompat<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    public ComparatorCompat<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    public ComparatorCompat<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    public Comparator<T> comparator() {
        return this.comparator;
    }

    public int compare(T o1, T o2) {
        return this.comparator.compare(o1, o2);
    }
}

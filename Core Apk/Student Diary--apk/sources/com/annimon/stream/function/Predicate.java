package com.annimon.stream.function;

import com.annimon.stream.Objects;
import java.util.Arrays;

public interface Predicate<T> {
    boolean test(T t);

    public static class Util {
        private Util() {
        }

        public static <T> Predicate<T> and(final Predicate<? super T> p1, final Predicate<? super T> p2) {
            return new Predicate<T>() {
                public boolean test(T value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        public static <T> Predicate<T> and(final Predicate<? super T> p1, final Predicate<? super T> p2, final Predicate<? super T>... rest) {
            Objects.requireNonNull(p1);
            Objects.requireNonNull(p2);
            Objects.requireNonNull(rest);
            Objects.requireNonNullElements(Arrays.asList(rest));
            return new Predicate<T>() {
                public boolean test(T value) {
                    if (!(p1.test(value) && p2.test(value))) {
                        return false;
                    }
                    for (Predicate<? super T> p : rest) {
                        if (!p.test(value)) {
                            return false;
                        }
                    }
                    return true;
                }
            };
        }

        public static <T> Predicate<T> or(final Predicate<? super T> p1, final Predicate<? super T> p2) {
            return new Predicate<T>() {
                public boolean test(T value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        public static <T> Predicate<T> or(final Predicate<? super T> p1, final Predicate<? super T> p2, final Predicate<? super T>... rest) {
            Objects.requireNonNull(p1);
            Objects.requireNonNull(p2);
            Objects.requireNonNull(rest);
            Objects.requireNonNullElements(Arrays.asList(rest));
            return new Predicate<T>() {
                public boolean test(T value) {
                    if (p1.test(value) || p2.test(value)) {
                        return true;
                    }
                    for (Predicate<? super T> p : rest) {
                        if (p.test(value)) {
                            return true;
                        }
                    }
                    return false;
                }
            };
        }

        public static <T> Predicate<T> xor(final Predicate<? super T> p1, final Predicate<? super T> p2) {
            return new Predicate<T>() {
                public boolean test(T value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        public static <T> Predicate<T> negate(final Predicate<? super T> p1) {
            return new Predicate<T>() {
                public boolean test(T value) {
                    return !p1.test(value);
                }
            };
        }

        public static <T> Predicate<T> notNull() {
            return new Predicate<T>() {
                public boolean test(T value) {
                    return value != null;
                }
            };
        }

        public static <T> Predicate<T> safe(ThrowablePredicate<? super T, Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }

        public static <T> Predicate<T> safe(final ThrowablePredicate<? super T, Throwable> throwablePredicate, final boolean resultIfFailed) {
            return new Predicate<T>() {
                public boolean test(T value) {
                    try {
                        return throwablePredicate.test(value);
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

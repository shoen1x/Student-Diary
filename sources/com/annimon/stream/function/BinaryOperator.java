package com.annimon.stream.function;

import com.annimon.stream.Objects;
import java.util.Comparator;

public interface BinaryOperator<T> extends BiFunction<T, T, T> {

    public static class Util {
        private Util() {
        }

        public static <T> BinaryOperator<T> minBy(final Comparator<? super T> comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator<T>() {
                public T apply(T a, T b) {
                    return comparator.compare(a, b) <= 0 ? a : b;
                }
            };
        }

        public static <T> BinaryOperator<T> maxBy(final Comparator<? super T> comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator<T>() {
                public T apply(T a, T b) {
                    return comparator.compare(a, b) >= 0 ? a : b;
                }
            };
        }
    }
}

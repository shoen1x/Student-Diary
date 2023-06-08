package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedPredicate<T> {
    boolean test(int i, T t);

    public static class Util {
        private Util() {
        }

        public static <T> IndexedPredicate<T> wrap(final Predicate<? super T> predicate) {
            Objects.requireNonNull(predicate);
            return new IndexedPredicate<T>() {
                public boolean test(int index, T value) {
                    return predicate.test(value);
                }
            };
        }
    }
}

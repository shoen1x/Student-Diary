package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedBiFunction<T, U, R> {
    R apply(int i, T t, U u);

    public static class Util {
        private Util() {
        }

        public static <T, U, R> IndexedBiFunction<T, U, R> wrap(final BiFunction<? super T, ? super U, ? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedBiFunction<T, U, R>() {
                public R apply(int index, T t, U u) {
                    return function.apply(t, u);
                }
            };
        }
    }
}

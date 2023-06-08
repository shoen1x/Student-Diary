package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedFunction<T, R> {
    R apply(int i, T t);

    public static class Util {
        private Util() {
        }

        public static <T, R> IndexedFunction<T, R> wrap(final Function<? super T, ? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedFunction<T, R>() {
                public R apply(int index, T t) {
                    return function.apply(t);
                }
            };
        }
    }
}

package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedIntFunction<R> {
    R apply(int i, int i2);

    public static class Util {
        private Util() {
        }

        public static <R> IndexedIntFunction<R> wrap(final IntFunction<? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedIntFunction<R>() {
                public R apply(int index, int value) {
                    return function.apply(value);
                }
            };
        }
    }
}

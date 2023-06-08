package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedDoubleFunction<R> {
    R apply(int i, double d);

    public static class Util {
        private Util() {
        }

        public static <R> IndexedDoubleFunction<R> wrap(final DoubleFunction<? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedDoubleFunction<R>() {
                public R apply(int index, double value) {
                    return function.apply(value);
                }
            };
        }
    }
}

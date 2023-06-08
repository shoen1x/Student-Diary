package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedLongFunction<R> {
    R apply(int i, long j);

    public static class Util {
        private Util() {
        }

        public static <R> IndexedLongFunction<R> wrap(final LongFunction<? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedLongFunction<R>() {
                public R apply(int index, long value) {
                    return function.apply(value);
                }
            };
        }
    }
}

package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedLongUnaryOperator {
    long applyAsLong(int i, long j);

    public static class Util {
        private Util() {
        }

        public static IndexedLongUnaryOperator wrap(final LongUnaryOperator function) {
            Objects.requireNonNull(function);
            return new IndexedLongUnaryOperator() {
                public long applyAsLong(int index, long value) {
                    return function.applyAsLong(value);
                }
            };
        }
    }
}

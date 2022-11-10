package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedDoubleUnaryOperator {
    double applyAsDouble(int i, double d);

    public static class Util {
        private Util() {
        }

        public static IndexedDoubleUnaryOperator wrap(final DoubleUnaryOperator function) {
            Objects.requireNonNull(function);
            return new IndexedDoubleUnaryOperator() {
                public double applyAsDouble(int index, double value) {
                    return function.applyAsDouble(value);
                }
            };
        }
    }
}

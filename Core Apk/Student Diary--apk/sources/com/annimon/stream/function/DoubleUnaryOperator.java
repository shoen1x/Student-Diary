package com.annimon.stream.function;

public interface DoubleUnaryOperator {
    double applyAsDouble(double d);

    public static class Util {
        private Util() {
        }

        public static DoubleUnaryOperator identity() {
            return new DoubleUnaryOperator() {
                public double applyAsDouble(double operand) {
                    return operand;
                }
            };
        }
    }
}

package com.annimon.stream.function;

public interface IntUnaryOperator {
    int applyAsInt(int i);

    public static class Util {
        private Util() {
        }

        public static IntUnaryOperator identity() {
            return new IntUnaryOperator() {
                public int applyAsInt(int operand) {
                    return operand;
                }
            };
        }
    }
}

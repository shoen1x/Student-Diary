package com.annimon.stream.function;

public interface LongUnaryOperator {
    long applyAsLong(long j);

    public static class Util {
        private Util() {
        }

        public static LongUnaryOperator identity() {
            return new LongUnaryOperator() {
                public long applyAsLong(long operand) {
                    return operand;
                }
            };
        }
    }
}

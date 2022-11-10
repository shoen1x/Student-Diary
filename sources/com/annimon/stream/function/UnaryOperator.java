package com.annimon.stream.function;

public interface UnaryOperator<T> extends Function<T, T> {

    public static class Util {
        private Util() {
        }

        public static <T> UnaryOperator<T> identity() {
            return new UnaryOperator<T>() {
                public T apply(T t) {
                    return t;
                }
            };
        }
    }
}

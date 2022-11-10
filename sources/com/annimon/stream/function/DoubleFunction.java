package com.annimon.stream.function;

public interface DoubleFunction<R> {
    R apply(double d);

    public static class Util {
        private Util() {
        }

        public static <R> DoubleFunction<R> safe(ThrowableDoubleFunction<? extends R, Throwable> throwableFunction) {
            return safe(throwableFunction, (Object) null);
        }

        public static <R> DoubleFunction<R> safe(final ThrowableDoubleFunction<? extends R, Throwable> throwableFunction, final R resultIfFailed) {
            return new DoubleFunction<R>() {
                public R apply(double value) {
                    try {
                        return throwableFunction.apply(value);
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

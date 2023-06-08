package com.annimon.stream.function;

public interface IntFunction<R> {
    R apply(int i);

    public static class Util {
        private Util() {
        }

        public static <R> IntFunction<R> safe(ThrowableIntFunction<? extends R, Throwable> throwableFunction) {
            return safe(throwableFunction, (Object) null);
        }

        public static <R> IntFunction<R> safe(final ThrowableIntFunction<? extends R, Throwable> throwableFunction, final R resultIfFailed) {
            return new IntFunction<R>() {
                public R apply(int value) {
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

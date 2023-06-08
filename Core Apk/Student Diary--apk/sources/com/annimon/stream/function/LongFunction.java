package com.annimon.stream.function;

public interface LongFunction<R> {
    R apply(long j);

    public static class Util {
        private Util() {
        }

        public static <R> LongFunction<R> safe(ThrowableLongFunction<? extends R, Throwable> throwableFunction) {
            return safe(throwableFunction, (Object) null);
        }

        public static <R> LongFunction<R> safe(final ThrowableLongFunction<? extends R, Throwable> throwableFunction, final R resultIfFailed) {
            return new LongFunction<R>() {
                public R apply(long value) {
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

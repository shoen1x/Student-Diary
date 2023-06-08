package com.annimon.stream.function;

public interface Function<T, R> {
    R apply(T t);

    public static class Util {
        private Util() {
        }

        public static <V, T, R> Function<V, R> compose(Function<? super T, ? extends R> f1, Function<? super V, ? extends T> f2) {
            return andThen(f2, f1);
        }

        public static <T, R, V> Function<T, V> andThen(final Function<? super T, ? extends R> f1, final Function<? super R, ? extends V> f2) {
            return new Function<T, V>() {
                public V apply(T t) {
                    return f2.apply(f1.apply(t));
                }
            };
        }

        public static <T, R> Function<T, R> safe(ThrowableFunction<? super T, ? extends R, Throwable> throwableFunction) {
            return safe(throwableFunction, (Object) null);
        }

        public static <T, R> Function<T, R> safe(final ThrowableFunction<? super T, ? extends R, Throwable> throwableFunction, final R resultIfFailed) {
            return new Function<T, R>() {
                public R apply(T value) {
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

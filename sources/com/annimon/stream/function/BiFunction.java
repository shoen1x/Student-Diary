package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface BiFunction<T, U, R> {
    R apply(T t, U u);

    public static class Util {
        private Util() {
        }

        public static <T, U, R, V> BiFunction<T, U, V> andThen(final BiFunction<? super T, ? super U, ? extends R> f1, final Function<? super R, ? extends V> f2) {
            return new BiFunction<T, U, V>() {
                public V apply(T t, U u) {
                    return f2.apply(f1.apply(t, u));
                }
            };
        }

        public static <T, U, R> BiFunction<U, T, R> reverse(final BiFunction<? super T, ? super U, ? extends R> function) {
            Objects.requireNonNull(function);
            return new BiFunction<U, T, R>() {
                public R apply(U u, T t) {
                    return function.apply(t, u);
                }
            };
        }
    }
}

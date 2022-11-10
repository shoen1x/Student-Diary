package com.annimon.stream.function;

public interface Supplier<T> {
    T get();

    public static class Util {
        private Util() {
        }

        public static <T> Supplier<T> safe(ThrowableSupplier<? extends T, Throwable> throwableSupplier) {
            return safe(throwableSupplier, (Object) null);
        }

        public static <T> Supplier<T> safe(final ThrowableSupplier<? extends T, Throwable> throwableSupplier, final T resultIfFailed) {
            return new Supplier<T>() {
                public T get() {
                    try {
                        return throwableSupplier.get();
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

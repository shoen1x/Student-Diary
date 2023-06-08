package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface Consumer<T> {
    void accept(T t);

    public static class Util {
        private Util() {
        }

        public static <T> Consumer<T> andThen(final Consumer<? super T> c1, final Consumer<? super T> c2) {
            return new Consumer<T>() {
                public void accept(T value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        public static <T> Consumer<T> safe(ThrowableConsumer<? super T, Throwable> throwableConsumer) {
            return safe(throwableConsumer, (Consumer) null);
        }

        public static <T> Consumer<T> safe(final ThrowableConsumer<? super T, Throwable> throwableConsumer, final Consumer<? super T> onFailedConsumer) {
            return new Consumer<T>() {
                public void accept(T value) {
                    Objects.requireNonNull(throwableConsumer);
                    try {
                        throwableConsumer.accept(value);
                    } catch (Throwable th) {
                        Consumer consumer = onFailedConsumer;
                        if (consumer != null) {
                            consumer.accept(value);
                        }
                    }
                }
            };
        }
    }
}

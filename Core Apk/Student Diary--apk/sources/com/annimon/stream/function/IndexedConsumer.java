package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedConsumer<T> {
    void accept(int i, T t);

    public static class Util {
        private Util() {
        }

        public static <T> IndexedConsumer<T> wrap(final Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            return new IndexedConsumer<T>() {
                public void accept(int index, T t) {
                    consumer.accept(t);
                }
            };
        }

        public static <T> IndexedConsumer<T> accept(final IntConsumer c1, final Consumer<? super T> c2) {
            return new IndexedConsumer<T>() {
                public void accept(int index, T value) {
                    IntConsumer intConsumer = c1;
                    if (intConsumer != null) {
                        intConsumer.accept(index);
                    }
                    Consumer consumer = c2;
                    if (consumer != null) {
                        consumer.accept(value);
                    }
                }
            };
        }
    }
}

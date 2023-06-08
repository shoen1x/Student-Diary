package com.annimon.stream.function;

public interface IndexedIntConsumer {
    void accept(int i, int i2);

    public static class Util {
        private Util() {
        }

        public static IndexedIntConsumer andThen(final IndexedIntConsumer c1, final IndexedIntConsumer c2) {
            return new IndexedIntConsumer() {
                public void accept(int index, int value) {
                    c1.accept(index, value);
                    c2.accept(index, value);
                }
            };
        }

        public static IndexedIntConsumer accept(final IntConsumer c1, final IntConsumer c2) {
            return new IndexedIntConsumer() {
                public void accept(int index, int value) {
                    IntConsumer intConsumer = c1;
                    if (intConsumer != null) {
                        intConsumer.accept(index);
                    }
                    IntConsumer intConsumer2 = c2;
                    if (intConsumer2 != null) {
                        intConsumer2.accept(value);
                    }
                }
            };
        }
    }
}

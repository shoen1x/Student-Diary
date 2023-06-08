package com.annimon.stream.function;

public interface IndexedDoubleConsumer {
    void accept(int i, double d);

    public static class Util {
        private Util() {
        }

        public static IndexedDoubleConsumer andThen(final IndexedDoubleConsumer c1, final IndexedDoubleConsumer c2) {
            return new IndexedDoubleConsumer() {
                public void accept(int index, double value) {
                    c1.accept(index, value);
                    c2.accept(index, value);
                }
            };
        }

        public static IndexedDoubleConsumer accept(final IntConsumer c1, final DoubleConsumer c2) {
            return new IndexedDoubleConsumer() {
                public void accept(int index, double value) {
                    IntConsumer intConsumer = c1;
                    if (intConsumer != null) {
                        intConsumer.accept(index);
                    }
                    DoubleConsumer doubleConsumer = c2;
                    if (doubleConsumer != null) {
                        doubleConsumer.accept(value);
                    }
                }
            };
        }
    }
}

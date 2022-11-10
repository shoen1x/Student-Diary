package com.annimon.stream.function;

public interface IndexedLongConsumer {
    void accept(int i, long j);

    public static class Util {
        private Util() {
        }

        public static IndexedLongConsumer andThen(final IndexedLongConsumer c1, final IndexedLongConsumer c2) {
            return new IndexedLongConsumer() {
                public void accept(int index, long value) {
                    c1.accept(index, value);
                    c2.accept(index, value);
                }
            };
        }

        public static IndexedLongConsumer accept(final IntConsumer c1, final LongConsumer c2) {
            return new IndexedLongConsumer() {
                public void accept(int index, long value) {
                    IntConsumer intConsumer = c1;
                    if (intConsumer != null) {
                        intConsumer.accept(index);
                    }
                    LongConsumer longConsumer = c2;
                    if (longConsumer != null) {
                        longConsumer.accept(value);
                    }
                }
            };
        }
    }
}

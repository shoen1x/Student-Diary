package com.annimon.stream.function;

public interface LongConsumer {
    void accept(long j);

    public static class Util {
        private Util() {
        }

        public static LongConsumer andThen(final LongConsumer c1, final LongConsumer c2) {
            return new LongConsumer() {
                public void accept(long value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        public static LongConsumer safe(ThrowableLongConsumer<Throwable> throwableConsumer) {
            return safe(throwableConsumer, (LongConsumer) null);
        }

        public static LongConsumer safe(final ThrowableLongConsumer<Throwable> throwableConsumer, final LongConsumer onFailedConsumer) {
            return new LongConsumer() {
                public void accept(long value) {
                    try {
                        throwableConsumer.accept(value);
                    } catch (Throwable th) {
                        LongConsumer longConsumer = onFailedConsumer;
                        if (longConsumer != null) {
                            longConsumer.accept(value);
                        }
                    }
                }
            };
        }
    }
}

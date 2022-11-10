package com.annimon.stream.function;

public interface IntConsumer {
    void accept(int i);

    public static class Util {
        private Util() {
        }

        public static IntConsumer andThen(final IntConsumer c1, final IntConsumer c2) {
            return new IntConsumer() {
                public void accept(int value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        public static IntConsumer safe(ThrowableIntConsumer<Throwable> throwableConsumer) {
            return safe(throwableConsumer, (IntConsumer) null);
        }

        public static IntConsumer safe(final ThrowableIntConsumer<Throwable> throwableConsumer, final IntConsumer onFailedConsumer) {
            return new IntConsumer() {
                public void accept(int value) {
                    try {
                        throwableConsumer.accept(value);
                    } catch (Throwable th) {
                        IntConsumer intConsumer = onFailedConsumer;
                        if (intConsumer != null) {
                            intConsumer.accept(value);
                        }
                    }
                }
            };
        }
    }
}

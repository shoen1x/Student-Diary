package com.annimon.stream.function;

public interface DoubleConsumer {
    void accept(double d);

    public static class Util {
        private Util() {
        }

        public static DoubleConsumer andThen(final DoubleConsumer c1, final DoubleConsumer c2) {
            return new DoubleConsumer() {
                public void accept(double value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        public static DoubleConsumer safe(ThrowableDoubleConsumer<Throwable> throwableConsumer) {
            return safe(throwableConsumer, (DoubleConsumer) null);
        }

        public static DoubleConsumer safe(final ThrowableDoubleConsumer<Throwable> throwableConsumer, final DoubleConsumer onFailedConsumer) {
            return new DoubleConsumer() {
                public void accept(double value) {
                    try {
                        throwableConsumer.accept(value);
                    } catch (Throwable th) {
                        DoubleConsumer doubleConsumer = onFailedConsumer;
                        if (doubleConsumer != null) {
                            doubleConsumer.accept(value);
                        }
                    }
                }
            };
        }
    }
}

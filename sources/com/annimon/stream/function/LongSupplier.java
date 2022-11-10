package com.annimon.stream.function;

public interface LongSupplier {
    long getAsLong();

    public static class Util {
        private Util() {
        }

        public static LongSupplier safe(ThrowableLongSupplier<Throwable> throwableSupplier) {
            return safe(throwableSupplier, 0);
        }

        public static LongSupplier safe(final ThrowableLongSupplier<Throwable> throwableSupplier, final long resultIfFailed) {
            return new LongSupplier() {
                public long getAsLong() {
                    try {
                        return throwableSupplier.getAsLong();
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

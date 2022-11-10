package com.annimon.stream.function;

public interface IntSupplier {
    int getAsInt();

    public static class Util {
        private Util() {
        }

        public static IntSupplier safe(ThrowableIntSupplier<Throwable> throwableSupplier) {
            return safe(throwableSupplier, 0);
        }

        public static IntSupplier safe(final ThrowableIntSupplier<Throwable> throwableSupplier, final int resultIfFailed) {
            return new IntSupplier() {
                public int getAsInt() {
                    try {
                        return throwableSupplier.getAsInt();
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

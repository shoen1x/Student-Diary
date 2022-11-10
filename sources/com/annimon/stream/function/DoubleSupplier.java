package com.annimon.stream.function;

public interface DoubleSupplier {
    double getAsDouble();

    public static class Util {
        private Util() {
        }

        public static DoubleSupplier safe(ThrowableDoubleSupplier<Throwable> throwableSupplier) {
            return safe(throwableSupplier, 0.0d);
        }

        public static DoubleSupplier safe(final ThrowableDoubleSupplier<Throwable> throwableSupplier, final double resultIfFailed) {
            return new DoubleSupplier() {
                public double getAsDouble() {
                    try {
                        return throwableSupplier.getAsDouble();
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

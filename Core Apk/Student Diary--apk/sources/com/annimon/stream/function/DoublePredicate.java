package com.annimon.stream.function;

public interface DoublePredicate {
    boolean test(double d);

    public static class Util {
        private Util() {
        }

        public static DoublePredicate and(final DoublePredicate p1, final DoublePredicate p2) {
            return new DoublePredicate() {
                public boolean test(double value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        public static DoublePredicate or(final DoublePredicate p1, final DoublePredicate p2) {
            return new DoublePredicate() {
                public boolean test(double value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        public static DoublePredicate xor(final DoublePredicate p1, final DoublePredicate p2) {
            return new DoublePredicate() {
                public boolean test(double value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        public static DoublePredicate negate(final DoublePredicate p1) {
            return new DoublePredicate() {
                public boolean test(double value) {
                    return !p1.test(value);
                }
            };
        }

        public static DoublePredicate safe(ThrowableDoublePredicate<Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }

        public static DoublePredicate safe(final ThrowableDoublePredicate<Throwable> throwablePredicate, final boolean resultIfFailed) {
            return new DoublePredicate() {
                public boolean test(double value) {
                    try {
                        return throwablePredicate.test(value);
                    } catch (Throwable th) {
                        return resultIfFailed;
                    }
                }
            };
        }
    }
}

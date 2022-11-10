package com.annimon.stream.function;

public interface IntPredicate {
    boolean test(int i);

    public static class Util {
        private Util() {
        }

        public static IntPredicate and(final IntPredicate p1, final IntPredicate p2) {
            return new IntPredicate() {
                public boolean test(int value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        public static IntPredicate or(final IntPredicate p1, final IntPredicate p2) {
            return new IntPredicate() {
                public boolean test(int value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        public static IntPredicate xor(final IntPredicate p1, final IntPredicate p2) {
            return new IntPredicate() {
                public boolean test(int value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        public static IntPredicate negate(final IntPredicate p1) {
            return new IntPredicate() {
                public boolean test(int value) {
                    return !p1.test(value);
                }
            };
        }

        public static IntPredicate safe(ThrowableIntPredicate<Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }

        public static IntPredicate safe(final ThrowableIntPredicate<Throwable> throwablePredicate, final boolean resultIfFailed) {
            return new IntPredicate() {
                public boolean test(int value) {
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

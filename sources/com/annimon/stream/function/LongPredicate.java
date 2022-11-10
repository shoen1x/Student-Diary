package com.annimon.stream.function;

public interface LongPredicate {
    boolean test(long j);

    public static class Util {
        private Util() {
        }

        public static LongPredicate and(final LongPredicate p1, final LongPredicate p2) {
            return new LongPredicate() {
                public boolean test(long value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        public static LongPredicate or(final LongPredicate p1, final LongPredicate p2) {
            return new LongPredicate() {
                public boolean test(long value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        public static LongPredicate xor(final LongPredicate p1, final LongPredicate p2) {
            return new LongPredicate() {
                public boolean test(long value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        public static LongPredicate negate(final LongPredicate p1) {
            return new LongPredicate() {
                public boolean test(long value) {
                    return !p1.test(value);
                }
            };
        }

        public static LongPredicate safe(ThrowableLongPredicate<Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }

        public static LongPredicate safe(final ThrowableLongPredicate<Throwable> throwablePredicate, final boolean resultIfFailed) {
            return new LongPredicate() {
                public boolean test(long value) {
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

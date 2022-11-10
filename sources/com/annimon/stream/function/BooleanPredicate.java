package com.annimon.stream.function;

public interface BooleanPredicate {
    boolean test(boolean z);

    public static class Util {
        private Util() {
        }

        public static BooleanPredicate identity() {
            return new BooleanPredicate() {
                public boolean test(boolean operand) {
                    return operand;
                }
            };
        }

        public static BooleanPredicate and(final BooleanPredicate p1, final BooleanPredicate p2) {
            return new BooleanPredicate() {
                public boolean test(boolean value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        public static BooleanPredicate or(final BooleanPredicate p1, final BooleanPredicate p2) {
            return new BooleanPredicate() {
                public boolean test(boolean value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        public static BooleanPredicate xor(final BooleanPredicate p1, final BooleanPredicate p2) {
            return new BooleanPredicate() {
                public boolean test(boolean value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        public static BooleanPredicate negate(final BooleanPredicate p1) {
            return new BooleanPredicate() {
                public boolean test(boolean value) {
                    return !p1.test(value);
                }
            };
        }
    }
}

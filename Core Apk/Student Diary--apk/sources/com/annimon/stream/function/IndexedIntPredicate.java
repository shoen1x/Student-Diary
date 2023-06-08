package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedIntPredicate {
    boolean test(int i, int i2);

    public static class Util {
        private Util() {
        }

        public static IndexedIntPredicate wrap(final IntPredicate predicate) {
            Objects.requireNonNull(predicate);
            return new IndexedIntPredicate() {
                public boolean test(int index, int value) {
                    return predicate.test(value);
                }
            };
        }
    }
}

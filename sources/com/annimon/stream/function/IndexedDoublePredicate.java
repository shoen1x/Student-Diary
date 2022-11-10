package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedDoublePredicate {
    boolean test(int i, double d);

    public static class Util {
        private Util() {
        }

        public static IndexedDoublePredicate wrap(final DoublePredicate predicate) {
            Objects.requireNonNull(predicate);
            return new IndexedDoublePredicate() {
                public boolean test(int index, double value) {
                    return predicate.test(value);
                }
            };
        }
    }
}

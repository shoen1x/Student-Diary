package com.annimon.stream.function;

import com.annimon.stream.Objects;

public interface IndexedLongPredicate {
    boolean test(int i, long j);

    public static class Util {
        private Util() {
        }

        public static IndexedLongPredicate wrap(final LongPredicate predicate) {
            Objects.requireNonNull(predicate);
            return new IndexedLongPredicate() {
                public boolean test(int index, long value) {
                    return predicate.test(value);
                }
            };
        }
    }
}

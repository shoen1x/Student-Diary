package com.annimon.stream.iterator;

import com.annimon.stream.iterator.PrimitiveIterator;

public final class PrimitiveIndexedIterator {
    private PrimitiveIndexedIterator() {
    }

    public static class OfInt extends PrimitiveIterator.OfInt {
        private int index;
        private final PrimitiveIterator.OfInt iterator;
        private final int step;

        public OfInt(PrimitiveIterator.OfInt iterator2) {
            this(0, 1, iterator2);
        }

        public OfInt(int start, int step2, PrimitiveIterator.OfInt iterator2) {
            this.iterator = iterator2;
            this.step = step2;
            this.index = start;
        }

        public int getIndex() {
            return this.index;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public int nextInt() {
            int result = this.iterator.next().intValue();
            this.index += this.step;
            return result;
        }
    }

    public static class OfLong extends PrimitiveIterator.OfLong {
        private int index;
        private final PrimitiveIterator.OfLong iterator;
        private final int step;

        public OfLong(PrimitiveIterator.OfLong iterator2) {
            this(0, 1, iterator2);
        }

        public OfLong(int start, int step2, PrimitiveIterator.OfLong iterator2) {
            this.iterator = iterator2;
            this.step = step2;
            this.index = start;
        }

        public int getIndex() {
            return this.index;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public long nextLong() {
            long result = this.iterator.next().longValue();
            this.index += this.step;
            return result;
        }
    }

    public static class OfDouble extends PrimitiveIterator.OfDouble {
        private int index;
        private final PrimitiveIterator.OfDouble iterator;
        private final int step;

        public OfDouble(PrimitiveIterator.OfDouble iterator2) {
            this(0, 1, iterator2);
        }

        public OfDouble(int start, int step2, PrimitiveIterator.OfDouble iterator2) {
            this.iterator = iterator2;
            this.step = step2;
            this.index = start;
        }

        public int getIndex() {
            return this.index;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public double nextDouble() {
            double result = this.iterator.next().doubleValue();
            this.index += this.step;
            return result;
        }
    }
}

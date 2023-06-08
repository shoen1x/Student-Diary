package com.annimon.stream.iterator;

import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public final class PrimitiveExtIterator {
    private PrimitiveExtIterator() {
    }

    public static abstract class OfInt extends PrimitiveIterator.OfInt {
        protected boolean hasNext;
        protected boolean isInit;
        protected int next;

        /* access modifiers changed from: protected */
        public abstract void nextIteration();

        public boolean hasNext() {
            if (!this.isInit) {
                nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }

        public int nextInt() {
            if (!this.isInit) {
                hasNext();
            }
            if (this.hasNext) {
                int result = this.next;
                nextIteration();
                return result;
            }
            throw new NoSuchElementException();
        }
    }

    public static abstract class OfLong extends PrimitiveIterator.OfLong {
        protected boolean hasNext;
        protected boolean isInit;
        protected long next;

        /* access modifiers changed from: protected */
        public abstract void nextIteration();

        public boolean hasNext() {
            if (!this.isInit) {
                nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }

        public long nextLong() {
            if (!this.isInit) {
                hasNext();
            }
            if (this.hasNext) {
                long result = this.next;
                nextIteration();
                return result;
            }
            throw new NoSuchElementException();
        }
    }

    public static abstract class OfDouble extends PrimitiveIterator.OfDouble {
        protected boolean hasNext;
        protected boolean isInit;
        protected double next;

        /* access modifiers changed from: protected */
        public abstract void nextIteration();

        public boolean hasNext() {
            if (!this.isInit) {
                nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }

        public double nextDouble() {
            if (!this.isInit) {
                hasNext();
            }
            if (this.hasNext) {
                double result = this.next;
                nextIteration();
                return result;
            }
            throw new NoSuchElementException();
        }
    }
}

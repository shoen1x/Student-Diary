package com.annimon.stream.internal;

import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.Arrays;
import java.util.Iterator;

final class SpinedBuffer {
    private static final int MAX_CHUNK_POWER = 30;
    static final int MIN_CHUNK_POWER = 4;
    static final int MIN_CHUNK_SIZE = 16;
    static final int MIN_SPINE_SIZE = 8;

    private SpinedBuffer() {
    }

    static abstract class OfPrimitive<E, T_ARR, T_CONS> implements Iterable<E> {
        T_ARR curChunk;
        int elementIndex;
        final int initialChunkPower;
        long[] priorElementCount;
        T_ARR[] spine;
        int spineIndex;

        /* access modifiers changed from: protected */
        public abstract int arrayLength(T_ARR t_arr);

        public abstract Iterator<E> iterator();

        /* access modifiers changed from: protected */
        public abstract T_ARR newArray(int i);

        /* access modifiers changed from: protected */
        public abstract T_ARR[] newArrayArray(int i);

        OfPrimitive(int initialCapacity) {
            if (initialCapacity >= 0) {
                int max = Math.max(4, 32 - Integer.numberOfLeadingZeros(initialCapacity - 1));
                this.initialChunkPower = max;
                this.curChunk = newArray(1 << max);
                return;
            }
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        OfPrimitive() {
            this.initialChunkPower = 4;
            this.curChunk = newArray(1 << 4);
        }

        public boolean isEmpty() {
            return this.spineIndex == 0 && this.elementIndex == 0;
        }

        public long count() {
            int i = this.spineIndex;
            return i == 0 ? (long) this.elementIndex : this.priorElementCount[i] + ((long) this.elementIndex);
        }

        /* access modifiers changed from: package-private */
        public int chunkSize(int n) {
            int power;
            if (n == 0 || n == 1) {
                power = this.initialChunkPower;
            } else {
                power = Math.min((this.initialChunkPower + n) - 1, 30);
            }
            return 1 << power;
        }

        /* access modifiers changed from: package-private */
        public long capacity() {
            int i = this.spineIndex;
            if (i == 0) {
                return (long) arrayLength(this.curChunk);
            }
            return ((long) arrayLength(this.spine[i])) + this.priorElementCount[i];
        }

        private void inflateSpine() {
            if (this.spine == null) {
                T_ARR[] newArrayArray = newArrayArray(8);
                this.spine = newArrayArray;
                this.priorElementCount = new long[8];
                newArrayArray[0] = this.curChunk;
            }
        }

        /* access modifiers changed from: package-private */
        public final void ensureCapacity(long targetSize) {
            long capacity = capacity();
            if (targetSize > capacity) {
                inflateSpine();
                int i = this.spineIndex;
                while (true) {
                    i++;
                    if (targetSize > capacity) {
                        T_ARR[] t_arrArr = this.spine;
                        if (i >= t_arrArr.length) {
                            int newSpineSize = t_arrArr.length * 2;
                            this.spine = Arrays.copyOf(t_arrArr, newSpineSize);
                            this.priorElementCount = Arrays.copyOf(this.priorElementCount, newSpineSize);
                        }
                        int nextChunkSize = chunkSize(i);
                        this.spine[i] = newArray(nextChunkSize);
                        long[] jArr = this.priorElementCount;
                        jArr[i] = jArr[i - 1] + ((long) arrayLength(this.spine[i - 1]));
                        capacity += (long) nextChunkSize;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void increaseCapacity() {
            ensureCapacity(capacity() + 1);
        }

        /* access modifiers changed from: package-private */
        public int chunkFor(long index) {
            if (this.spineIndex == 0) {
                if (index < ((long) this.elementIndex)) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(index));
            } else if (index < count()) {
                for (int j = 0; j <= this.spineIndex; j++) {
                    if (index < this.priorElementCount[j] + ((long) arrayLength(this.spine[j]))) {
                        return j;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(index));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(index));
            }
        }

        /* access modifiers changed from: package-private */
        public void copyInto(T_ARR array, int offset) {
            long finalOffset = ((long) offset) + count();
            if (finalOffset > ((long) arrayLength(array)) || finalOffset < ((long) offset)) {
                throw new IndexOutOfBoundsException("does not fit");
            } else if (this.spineIndex == 0) {
                System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
            } else {
                for (int i = 0; i < this.spineIndex; i++) {
                    T_ARR[] t_arrArr = this.spine;
                    System.arraycopy(t_arrArr[i], 0, array, offset, arrayLength(t_arrArr[i]));
                    offset += arrayLength(this.spine[i]);
                }
                int i2 = this.elementIndex;
                if (i2 > 0) {
                    System.arraycopy(this.curChunk, 0, array, offset, i2);
                }
            }
        }

        public T_ARR asPrimitiveArray() {
            long size = count();
            Compat.checkMaxArraySize(size);
            T_ARR result = newArray((int) size);
            copyInto(result, 0);
            return result;
        }

        /* access modifiers changed from: package-private */
        public void preAccept() {
            if (this.elementIndex == arrayLength(this.curChunk)) {
                inflateSpine();
                int i = this.spineIndex;
                int i2 = i + 1;
                T_ARR[] t_arrArr = this.spine;
                if (i2 >= t_arrArr.length || t_arrArr[i + 1] == null) {
                    increaseCapacity();
                }
                this.elementIndex = 0;
                int i3 = this.spineIndex + 1;
                this.spineIndex = i3;
                this.curChunk = this.spine[i3];
            }
        }

        public void clear() {
            T_ARR[] t_arrArr = this.spine;
            if (t_arrArr != null) {
                this.curChunk = t_arrArr[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }
    }

    static class OfInt extends OfPrimitive<Integer, int[], IntConsumer> implements IntConsumer {
        OfInt() {
        }

        OfInt(int initialCapacity) {
            super(initialCapacity);
        }

        /* access modifiers changed from: protected */
        public int[][] newArrayArray(int size) {
            return new int[size][];
        }

        public int[] newArray(int size) {
            return new int[size];
        }

        /* access modifiers changed from: protected */
        public int arrayLength(int[] array) {
            return array.length;
        }

        public void accept(int i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((int[]) this.curChunk)[i2] = i;
        }

        public int get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((int[]) this.curChunk)[(int) index];
            }
            return ((int[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        public PrimitiveIterator.OfInt iterator() {
            return new PrimitiveIterator.OfInt() {
                long index = 0;

                public int nextInt() {
                    OfInt ofInt = OfInt.this;
                    long j = this.index;
                    this.index = 1 + j;
                    return ofInt.get(j);
                }

                public boolean hasNext() {
                    return this.index < OfInt.this.count();
                }
            };
        }
    }

    static class OfLong extends OfPrimitive<Long, long[], LongConsumer> implements LongConsumer {
        OfLong() {
        }

        OfLong(int initialCapacity) {
            super(initialCapacity);
        }

        /* access modifiers changed from: protected */
        public long[][] newArrayArray(int size) {
            return new long[size][];
        }

        public long[] newArray(int size) {
            return new long[size];
        }

        /* access modifiers changed from: protected */
        public int arrayLength(long[] array) {
            return array.length;
        }

        public void accept(long i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((long[]) this.curChunk)[i2] = i;
        }

        public long get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((long[]) this.curChunk)[(int) index];
            }
            return ((long[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        public PrimitiveIterator.OfLong iterator() {
            return new PrimitiveIterator.OfLong() {
                long index = 0;

                public long nextLong() {
                    OfLong ofLong = OfLong.this;
                    long j = this.index;
                    this.index = 1 + j;
                    return ofLong.get(j);
                }

                public boolean hasNext() {
                    return this.index < OfLong.this.count();
                }
            };
        }
    }

    static class OfDouble extends OfPrimitive<Double, double[], DoubleConsumer> implements DoubleConsumer {
        OfDouble() {
        }

        OfDouble(int initialCapacity) {
            super(initialCapacity);
        }

        /* access modifiers changed from: protected */
        public double[][] newArrayArray(int size) {
            return new double[size][];
        }

        public double[] newArray(int size) {
            return new double[size];
        }

        /* access modifiers changed from: protected */
        public int arrayLength(double[] array) {
            return array.length;
        }

        public void accept(double i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((double[]) this.curChunk)[i2] = i;
        }

        public double get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((double[]) this.curChunk)[(int) index];
            }
            return ((double[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        public PrimitiveIterator.OfDouble iterator() {
            return new PrimitiveIterator.OfDouble() {
                long index = 0;

                public double nextDouble() {
                    OfDouble ofDouble = OfDouble.this;
                    long j = this.index;
                    this.index = 1 + j;
                    return ofDouble.get(j);
                }

                public boolean hasNext() {
                    return this.index < OfDouble.this.count();
                }
            };
        }
    }
}

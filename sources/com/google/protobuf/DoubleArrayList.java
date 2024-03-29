package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        EMPTY_LIST = doubleArrayList;
        doubleArrayList.makeImmutable();
    }

    public static DoubleArrayList emptyList() {
        return EMPTY_LIST;
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    private DoubleArrayList(double[] other, int size2) {
        this.array = other;
        this.size = size2;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex >= fromIndex) {
            double[] dArr = this.array;
            System.arraycopy(dArr, toIndex, dArr, fromIndex, this.size - toIndex);
            this.size -= toIndex - fromIndex;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleArrayList)) {
            return super.equals(o);
        }
        DoubleArrayList other = (DoubleArrayList) o;
        if (this.size != other.size) {
            return false;
        }
        double[] arr = other.array;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.array[i]) != Double.doubleToLongBits(arr[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = 1;
        for (int i = 0; i < this.size; i++) {
            result = (result * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i]));
        }
        return result;
    }

    public Internal.DoubleList mutableCopyWithCapacity(int capacity) {
        if (capacity >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, capacity), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Double get(int index) {
        return Double.valueOf(getDouble(index));
    }

    public double getDouble(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    public int size() {
        return this.size;
    }

    public Double set(int index, Double element) {
        return Double.valueOf(setDouble(index, element.doubleValue()));
    }

    public double setDouble(int index, double element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        double[] dArr = this.array;
        double previousValue = dArr[index];
        dArr[index] = element;
        return previousValue;
    }

    public boolean add(Double element) {
        addDouble(element.doubleValue());
        return true;
    }

    public void add(int index, Double element) {
        addDouble(index, element.doubleValue());
    }

    public void addDouble(double element) {
        ensureIsMutable();
        int i = this.size;
        double[] dArr = this.array;
        if (i == dArr.length) {
            double[] newArray = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, newArray, 0, i);
            this.array = newArray;
        }
        double[] dArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr2[i2] = element;
    }

    private void addDouble(int index, double element) {
        int i;
        ensureIsMutable();
        if (index < 0 || index > (i = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
        double[] dArr = this.array;
        if (i < dArr.length) {
            System.arraycopy(dArr, index, dArr, index + 1, i - index);
        } else {
            double[] newArray = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, newArray, 0, index);
            System.arraycopy(this.array, index, newArray, index + 1, this.size - index);
            this.array = newArray;
        }
        this.array[index] = element;
        this.size++;
        this.modCount++;
    }

    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList list = (DoubleArrayList) collection;
        int i = list.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int newSize = i2 + i;
            double[] dArr = this.array;
            if (newSize > dArr.length) {
                this.array = Arrays.copyOf(dArr, newSize);
            }
            System.arraycopy(list.array, 0, this.array, this.size, list.size);
            this.size = newSize;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean remove(Object o) {
        ensureIsMutable();
        for (int i = 0; i < this.size; i++) {
            if (o.equals(Double.valueOf(this.array[i]))) {
                double[] dArr = this.array;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public Double remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        double[] dArr = this.array;
        double value = dArr[index];
        int i = this.size;
        if (index < i - 1) {
            System.arraycopy(dArr, index + 1, dArr, index, (i - index) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(value);
    }

    private void ensureIndexInRange(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int index) {
        return "Index:" + index + ", Size:" + this.size;
    }
}

package com.annimon.stream;

public final class IntPair<T> {
    private final int first;
    private final T second;

    public IntPair(int first2, T second2) {
        this.first = first2;
        this.second = second2;
    }

    public int getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public int hashCode() {
        int hash = ((7 * 97) + this.first) * 97;
        T t = this.second;
        return hash + (t != null ? t.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntPair<?> other = (IntPair) obj;
        if (this.first != other.first) {
            return false;
        }
        T t = this.second;
        T t2 = other.second;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "IntPair[" + this.first + ", " + this.second + ']';
    }
}

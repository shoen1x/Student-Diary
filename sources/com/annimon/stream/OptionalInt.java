package com.annimon.stream;

import com.annimon.stream.function.Function;
import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.function.Supplier;
import java.util.NoSuchElementException;

public final class OptionalInt {
    private static final OptionalInt EMPTY = new OptionalInt();
    private final boolean isPresent;
    private final int value;

    private OptionalInt() {
        this.isPresent = false;
        this.value = 0;
    }

    public static OptionalInt empty() {
        return EMPTY;
    }

    private OptionalInt(int value2) {
        this.isPresent = true;
        this.value = value2;
    }

    public static OptionalInt of(int value2) {
        return new OptionalInt(value2);
    }

    public static OptionalInt ofNullable(Integer value2) {
        return value2 == null ? EMPTY : new OptionalInt(value2.intValue());
    }

    public int getAsInt() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(IntConsumer consumer) {
        if (this.isPresent) {
            consumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(IntConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            consumer.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public OptionalInt executeIfPresent(IntConsumer consumer) {
        ifPresent(consumer);
        return this;
    }

    public OptionalInt executeIfAbsent(Runnable action) {
        if (!isPresent()) {
            action.run();
        }
        return this;
    }

    public <R> R custom(Function<OptionalInt, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public OptionalInt filter(IntPredicate predicate) {
        if (!isPresent()) {
            return this;
        }
        return predicate.test(this.value) ? this : empty();
    }

    public OptionalInt filterNot(IntPredicate predicate) {
        return filter(IntPredicate.Util.negate(predicate));
    }

    public OptionalInt map(IntUnaryOperator mapper) {
        if (!isPresent()) {
            return empty();
        }
        return of(mapper.applyAsInt(this.value));
    }

    public <U> Optional<U> mapToObj(IntFunction<U> mapper) {
        if (!isPresent()) {
            return Optional.empty();
        }
        return Optional.ofNullable(mapper.apply(this.value));
    }

    public OptionalLong mapToLong(IntToLongFunction mapper) {
        if (!isPresent()) {
            return OptionalLong.empty();
        }
        return OptionalLong.of(mapper.applyAsLong(this.value));
    }

    public OptionalDouble mapToDouble(IntToDoubleFunction mapper) {
        if (!isPresent()) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(mapper.applyAsDouble(this.value));
    }

    public IntStream stream() {
        if (!isPresent()) {
            return IntStream.empty();
        }
        return IntStream.of(this.value);
    }

    public OptionalInt or(Supplier<OptionalInt> supplier) {
        if (isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (OptionalInt) Objects.requireNonNull(supplier.get());
    }

    public int orElse(int other) {
        return this.isPresent ? this.value : other;
    }

    public int orElseGet(IntSupplier other) {
        return this.isPresent ? this.value : other.getAsInt();
    }

    public int orElseThrow() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> int orElseThrow(Supplier<X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw ((Throwable) exceptionSupplier.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalInt)) {
            return false;
        }
        OptionalInt other = (OptionalInt) obj;
        if (!this.isPresent || !other.isPresent) {
            if (this.isPresent == other.isPresent) {
                return true;
            }
        } else if (this.value == other.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return this.value;
        }
        return 0;
    }

    public String toString() {
        if (!this.isPresent) {
            return "OptionalInt.empty";
        }
        return String.format("OptionalInt[%s]", new Object[]{Integer.valueOf(this.value)});
    }
}

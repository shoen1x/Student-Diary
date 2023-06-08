package com.annimon.stream;

import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Supplier;
import java.util.NoSuchElementException;

public final class OptionalDouble {
    private static final OptionalDouble EMPTY = new OptionalDouble();
    private final boolean isPresent;
    private final double value;

    public static OptionalDouble empty() {
        return EMPTY;
    }

    public static OptionalDouble of(double value2) {
        return new OptionalDouble(value2);
    }

    public static OptionalDouble ofNullable(Double value2) {
        return value2 == null ? EMPTY : new OptionalDouble(value2.doubleValue());
    }

    private OptionalDouble() {
        this.isPresent = false;
        this.value = 0.0d;
    }

    private OptionalDouble(double value2) {
        this.isPresent = true;
        this.value = value2;
    }

    public double getAsDouble() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(DoubleConsumer consumer) {
        if (this.isPresent) {
            consumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(DoubleConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            consumer.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public OptionalDouble executeIfPresent(DoubleConsumer consumer) {
        ifPresent(consumer);
        return this;
    }

    public OptionalDouble executeIfAbsent(Runnable action) {
        if (!isPresent()) {
            action.run();
        }
        return this;
    }

    public <R> R custom(Function<OptionalDouble, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public OptionalDouble filter(DoublePredicate predicate) {
        if (!isPresent()) {
            return this;
        }
        return predicate.test(this.value) ? this : empty();
    }

    public OptionalDouble filterNot(DoublePredicate predicate) {
        return filter(DoublePredicate.Util.negate(predicate));
    }

    public OptionalDouble map(DoubleUnaryOperator mapper) {
        if (!isPresent()) {
            return empty();
        }
        Objects.requireNonNull(mapper);
        return of(mapper.applyAsDouble(this.value));
    }

    public <U> Optional<U> mapToObj(DoubleFunction<U> mapper) {
        if (!isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(mapper);
        return Optional.ofNullable(mapper.apply(this.value));
    }

    public OptionalInt mapToInt(DoubleToIntFunction mapper) {
        if (!isPresent()) {
            return OptionalInt.empty();
        }
        Objects.requireNonNull(mapper);
        return OptionalInt.of(mapper.applyAsInt(this.value));
    }

    public OptionalLong mapToLong(DoubleToLongFunction mapper) {
        if (!isPresent()) {
            return OptionalLong.empty();
        }
        Objects.requireNonNull(mapper);
        return OptionalLong.of(mapper.applyAsLong(this.value));
    }

    public DoubleStream stream() {
        if (!isPresent()) {
            return DoubleStream.empty();
        }
        return DoubleStream.of(this.value);
    }

    public OptionalDouble or(Supplier<OptionalDouble> supplier) {
        if (isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (OptionalDouble) Objects.requireNonNull(supplier.get());
    }

    public double orElse(double other) {
        return this.isPresent ? this.value : other;
    }

    public double orElseGet(DoubleSupplier other) {
        return this.isPresent ? this.value : other.getAsDouble();
    }

    public double orElseThrow() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> double orElseThrow(Supplier<X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw ((Throwable) exceptionSupplier.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalDouble)) {
            return false;
        }
        OptionalDouble other = (OptionalDouble) obj;
        if (!this.isPresent || !other.isPresent) {
            if (this.isPresent == other.isPresent) {
                return true;
            }
        } else if (Double.compare(this.value, other.value) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return Objects.hashCode(Double.valueOf(this.value));
        }
        return 0;
    }

    public String toString() {
        if (!this.isPresent) {
            return "OptionalDouble.empty";
        }
        return String.format("OptionalDouble[%s]", new Object[]{Double.valueOf(this.value)});
    }
}

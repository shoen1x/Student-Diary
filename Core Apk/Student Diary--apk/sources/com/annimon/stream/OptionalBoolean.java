package com.annimon.stream;

import com.annimon.stream.function.BooleanConsumer;
import com.annimon.stream.function.BooleanFunction;
import com.annimon.stream.function.BooleanPredicate;
import com.annimon.stream.function.BooleanSupplier;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Supplier;
import java.util.NoSuchElementException;

public final class OptionalBoolean {
    private static final OptionalBoolean EMPTY = new OptionalBoolean();
    private static final OptionalBoolean FALSE = new OptionalBoolean(false);
    private static final OptionalBoolean TRUE = new OptionalBoolean(true);
    private final boolean isPresent;
    private final boolean value;

    public static OptionalBoolean empty() {
        return EMPTY;
    }

    public static OptionalBoolean of(boolean value2) {
        return value2 ? TRUE : FALSE;
    }

    public static OptionalBoolean ofNullable(Boolean value2) {
        return value2 == null ? EMPTY : of(value2.booleanValue());
    }

    private OptionalBoolean() {
        this.isPresent = false;
        this.value = false;
    }

    private OptionalBoolean(boolean value2) {
        this.isPresent = true;
        this.value = value2;
    }

    public boolean getAsBoolean() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(BooleanConsumer consumer) {
        if (this.isPresent) {
            consumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(BooleanConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            consumer.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public OptionalBoolean executeIfPresent(BooleanConsumer consumer) {
        ifPresent(consumer);
        return this;
    }

    public OptionalBoolean executeIfAbsent(Runnable action) {
        if (!isPresent()) {
            action.run();
        }
        return this;
    }

    public <R> R custom(Function<OptionalBoolean, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public OptionalBoolean filter(BooleanPredicate predicate) {
        if (!isPresent()) {
            return this;
        }
        return predicate.test(this.value) ? this : empty();
    }

    public OptionalBoolean filterNot(BooleanPredicate predicate) {
        return filter(BooleanPredicate.Util.negate(predicate));
    }

    public OptionalBoolean map(BooleanPredicate mapper) {
        if (!isPresent()) {
            return empty();
        }
        Objects.requireNonNull(mapper);
        return of(mapper.test(this.value));
    }

    public <U> Optional<U> mapToObj(BooleanFunction<U> mapper) {
        if (!isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(mapper);
        return Optional.ofNullable(mapper.apply(this.value));
    }

    public OptionalBoolean or(Supplier<OptionalBoolean> supplier) {
        if (isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (OptionalBoolean) Objects.requireNonNull(supplier.get());
    }

    public boolean orElse(boolean other) {
        return this.isPresent ? this.value : other;
    }

    public boolean orElseGet(BooleanSupplier other) {
        return this.isPresent ? this.value : other.getAsBoolean();
    }

    public boolean orElseThrow() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> boolean orElseThrow(Supplier<X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw ((Throwable) exceptionSupplier.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalBoolean)) {
            return false;
        }
        OptionalBoolean other = (OptionalBoolean) obj;
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
            return this.value ? 1231 : 1237;
        }
        return 0;
    }

    public String toString() {
        if (this.isPresent) {
            return this.value ? "OptionalBoolean[true]" : "OptionalBoolean[false]";
        }
        return "OptionalBoolean.empty";
    }
}

package com.annimon.stream;

import com.annimon.stream.function.Function;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.function.Supplier;
import java.util.NoSuchElementException;

public final class OptionalLong {
    private static final OptionalLong EMPTY = new OptionalLong();
    private final boolean isPresent;
    private final long value;

    public static OptionalLong empty() {
        return EMPTY;
    }

    public static OptionalLong of(long value2) {
        return new OptionalLong(value2);
    }

    public static OptionalLong ofNullable(Long value2) {
        return value2 == null ? EMPTY : new OptionalLong(value2.longValue());
    }

    private OptionalLong() {
        this.isPresent = false;
        this.value = 0;
    }

    private OptionalLong(long value2) {
        this.isPresent = true;
        this.value = value2;
    }

    public long getAsLong() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(LongConsumer consumer) {
        if (this.isPresent) {
            consumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(LongConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            consumer.accept(this.value);
        } else {
            emptyAction.run();
        }
    }

    public OptionalLong executeIfPresent(LongConsumer consumer) {
        ifPresent(consumer);
        return this;
    }

    public OptionalLong executeIfAbsent(Runnable action) {
        if (!isPresent()) {
            action.run();
        }
        return this;
    }

    public <R> R custom(Function<OptionalLong, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public OptionalLong filter(LongPredicate predicate) {
        if (!isPresent()) {
            return this;
        }
        return predicate.test(this.value) ? this : empty();
    }

    public OptionalLong filterNot(LongPredicate predicate) {
        return filter(LongPredicate.Util.negate(predicate));
    }

    public OptionalLong map(LongUnaryOperator mapper) {
        if (!isPresent()) {
            return empty();
        }
        Objects.requireNonNull(mapper);
        return of(mapper.applyAsLong(this.value));
    }

    public <U> Optional<U> mapToObj(LongFunction<U> mapper) {
        if (!isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(mapper);
        return Optional.ofNullable(mapper.apply(this.value));
    }

    public OptionalInt mapToInt(LongToIntFunction mapper) {
        if (!isPresent()) {
            return OptionalInt.empty();
        }
        Objects.requireNonNull(mapper);
        return OptionalInt.of(mapper.applyAsInt(this.value));
    }

    public LongStream stream() {
        if (!isPresent()) {
            return LongStream.empty();
        }
        return LongStream.of(this.value);
    }

    public OptionalLong or(Supplier<OptionalLong> supplier) {
        if (isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (OptionalLong) Objects.requireNonNull(supplier.get());
    }

    public long orElse(long other) {
        return this.isPresent ? this.value : other;
    }

    public long orElseGet(LongSupplier other) {
        return this.isPresent ? this.value : other.getAsLong();
    }

    public long orElseThrow() {
        if (this.isPresent) {
            return this.value;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> long orElseThrow(Supplier<X> exceptionSupplier) throws Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw ((Throwable) exceptionSupplier.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionalLong)) {
            return false;
        }
        OptionalLong other = (OptionalLong) obj;
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
            return Objects.hashCode(Long.valueOf(this.value));
        }
        return 0;
    }

    public String toString() {
        if (!this.isPresent) {
            return "OptionalLong.empty";
        }
        return String.format("OptionalLong[%s]", new Object[]{Long.valueOf(this.value)});
    }
}

package com.annimon.stream;

import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToBooleanFunction;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToLongFunction;
import java.util.NoSuchElementException;

public class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    public static <T> Optional<T> of(T value2) {
        return new Optional<>(value2);
    }

    public static <T> Optional<T> ofNullable(T value2) {
        return value2 == null ? empty() : of(value2);
    }

    public static <T> Optional<T> empty() {
        return EMPTY;
    }

    private Optional() {
        this.value = null;
    }

    private Optional(T value2) {
        this.value = Objects.requireNonNull(value2);
    }

    public T get() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable emptyAction) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        } else {
            emptyAction.run();
        }
    }

    public Optional<T> executeIfPresent(Consumer<? super T> consumer) {
        ifPresent(consumer);
        return this;
    }

    public Optional<T> executeIfAbsent(Runnable action) {
        if (this.value == null) {
            action.run();
        }
        return this;
    }

    public <R> R custom(Function<Optional<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        if (!isPresent()) {
            return this;
        }
        return predicate.test(this.value) ? this : empty();
    }

    public Optional<T> filterNot(Predicate<? super T> predicate) {
        return filter(Predicate.Util.negate(predicate));
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(mapper.apply(this.value));
    }

    public OptionalInt mapToInt(ToIntFunction<? super T> mapper) {
        if (!isPresent()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(mapper.applyAsInt(this.value));
    }

    public OptionalLong mapToLong(ToLongFunction<? super T> mapper) {
        if (!isPresent()) {
            return OptionalLong.empty();
        }
        return OptionalLong.of(mapper.applyAsLong(this.value));
    }

    public OptionalDouble mapToDouble(ToDoubleFunction<? super T> mapper) {
        if (!isPresent()) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(mapper.applyAsDouble(this.value));
    }

    public OptionalBoolean mapToBoolean(ToBooleanFunction<? super T> mapper) {
        if (!isPresent()) {
            return OptionalBoolean.empty();
        }
        return OptionalBoolean.of(mapper.applyAsBoolean(this.value));
    }

    public <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        if (!isPresent()) {
            return empty();
        }
        return (Optional) Objects.requireNonNull(mapper.apply(this.value));
    }

    public Stream<T> stream() {
        if (!isPresent()) {
            return Stream.empty();
        }
        return Stream.of((T[]) new Object[]{this.value});
    }

    public <R> Optional<R> select(Class<R> clazz) {
        Objects.requireNonNull(clazz);
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(clazz.isInstance(this.value) ? this.value : null);
    }

    public Optional<T> or(Supplier<Optional<T>> supplier) {
        if (isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (Optional) Objects.requireNonNull(supplier.get());
    }

    public T orElse(T other) {
        T t = this.value;
        return t != null ? t : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        T t = this.value;
        return t != null ? t : other.get();
    }

    public T orElseThrow() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exc) throws Throwable {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw ((Throwable) exc.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        return Objects.equals(this.value, ((Optional) obj).value);
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public String toString() {
        T t = this.value;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}

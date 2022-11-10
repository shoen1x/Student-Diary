package com.annimon.stream;

import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ThrowableFunction;
import com.annimon.stream.function.ThrowableSupplier;

public class Exceptional<T> {
    private final Throwable throwable;
    private final T value;

    public static <T> Exceptional<T> of(ThrowableSupplier<T, Throwable> supplier) {
        try {
            return new Exceptional<>(supplier.get(), (Throwable) null);
        } catch (Throwable throwable2) {
            return of(throwable2);
        }
    }

    public static <T> Exceptional<T> of(Throwable throwable2) {
        return new Exceptional<>((Object) null, throwable2);
    }

    private Exceptional(T value2, Throwable throwable2) {
        this.value = value2;
        this.throwable = throwable2;
    }

    public T get() {
        return this.value;
    }

    public boolean isPresent() {
        return this.throwable == null;
    }

    public T getOrElse(T other) {
        return this.throwable == null ? this.value : other;
    }

    public T getOrElse(Supplier<? extends T> other) {
        return this.throwable == null ? this.value : other.get();
    }

    public Optional<T> getOptional() {
        return Optional.ofNullable(this.value);
    }

    public Throwable getException() {
        return this.throwable;
    }

    public T getOrThrow() throws Throwable {
        Throwable th = this.throwable;
        if (th == null) {
            return this.value;
        }
        throw th;
    }

    public T getOrThrowRuntimeException() throws RuntimeException {
        if (this.throwable == null) {
            return this.value;
        }
        throw new RuntimeException(this.throwable);
    }

    public <E extends Throwable> T getOrThrow(E exception) throws Throwable {
        Throwable th = this.throwable;
        if (th == null) {
            return this.value;
        }
        exception.initCause(th);
        throw exception;
    }

    public Exceptional<T> or(Supplier<Exceptional<T>> supplier) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return (Exceptional) Objects.requireNonNull(supplier.get());
    }

    public <R> R custom(Function<Exceptional<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public <U> Exceptional<U> map(ThrowableFunction<? super T, ? extends U, Throwable> mapper) {
        Throwable th = this.throwable;
        if (th != null) {
            return of(th);
        }
        Objects.requireNonNull(mapper);
        try {
            return new Exceptional<>(mapper.apply(this.value), (Throwable) null);
        } catch (Throwable t) {
            return of(t);
        }
    }

    public Exceptional<T> ifPresent(Consumer<? super T> consumer) {
        if (this.throwable == null) {
            consumer.accept(this.value);
        }
        return this;
    }

    public Exceptional<T> ifException(Consumer<Throwable> consumer) {
        Throwable th = this.throwable;
        if (th != null) {
            consumer.accept(th);
        }
        return this;
    }

    public <E extends Throwable> Exceptional<T> ifExceptionIs(Class<E> throwableClass, Consumer<? super E> consumer) {
        Throwable th = this.throwable;
        if (th != null && throwableClass.isAssignableFrom(th.getClass())) {
            consumer.accept(this.throwable);
        }
        return this;
    }

    public Exceptional<T> recover(ThrowableFunction<Throwable, ? extends T, Throwable> function) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(function);
        try {
            return new Exceptional<>(function.apply(this.throwable), (Throwable) null);
        } catch (Throwable throwable2) {
            return of(throwable2);
        }
    }

    public Exceptional<T> recoverWith(Function<Throwable, ? extends Exceptional<T>> function) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(function);
        return (Exceptional) Objects.requireNonNull(function.apply(this.throwable));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Exceptional)) {
            return false;
        }
        Exceptional<?> other = (Exceptional) obj;
        if (!Objects.equals(this.value, other.value) || !Objects.equals(this.throwable, other.throwable)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.value, this.throwable);
    }

    public String toString() {
        Throwable th = this.throwable;
        if (th == null) {
            return String.format("Exceptional value %s", new Object[]{this.value});
        }
        return String.format("Exceptional throwable %s", new Object[]{th});
    }
}

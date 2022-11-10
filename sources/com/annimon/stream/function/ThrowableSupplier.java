package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableSupplier<T, E extends Throwable> {
    T get() throws Throwable;
}

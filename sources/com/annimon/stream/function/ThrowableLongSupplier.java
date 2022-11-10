package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableLongSupplier<E extends Throwable> {
    long getAsLong() throws Throwable;
}

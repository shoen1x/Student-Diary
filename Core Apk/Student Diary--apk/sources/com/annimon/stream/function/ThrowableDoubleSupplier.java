package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableDoubleSupplier<E extends Throwable> {
    double getAsDouble() throws Throwable;
}

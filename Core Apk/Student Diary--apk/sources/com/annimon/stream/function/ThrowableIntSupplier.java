package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableIntSupplier<E extends Throwable> {
    int getAsInt() throws Throwable;
}

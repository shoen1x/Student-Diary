package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableDoubleConsumer<E extends Throwable> {
    void accept(double d) throws Throwable;
}

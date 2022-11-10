package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableFunction<I, R, E extends Throwable> {
    R apply(I i) throws Throwable;
}

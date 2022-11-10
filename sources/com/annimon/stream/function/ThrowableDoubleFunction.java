package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableDoubleFunction<R, E extends Throwable> {
    R apply(double d) throws Throwable;
}

package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableIntFunction<R, E extends Throwable> {
    R apply(int i) throws Throwable;
}

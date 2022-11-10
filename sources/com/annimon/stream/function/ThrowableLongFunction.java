package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableLongFunction<R, E extends Throwable> {
    R apply(long j) throws Throwable;
}

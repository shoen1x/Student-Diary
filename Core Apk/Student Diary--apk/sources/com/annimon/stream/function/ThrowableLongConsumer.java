package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableLongConsumer<E extends Throwable> {
    void accept(long j) throws Throwable;
}

package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableIntConsumer<E extends Throwable> {
    void accept(int i) throws Throwable;
}

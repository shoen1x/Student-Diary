package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowablePredicate<T, E extends Throwable> {
    boolean test(T t) throws Throwable;
}

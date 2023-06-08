package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableLongPredicate<E extends Throwable> {
    boolean test(long j) throws Throwable;
}

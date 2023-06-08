package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableIntPredicate<E extends Throwable> {
    boolean test(int i) throws Throwable;
}

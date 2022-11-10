package com.annimon.stream.function;

import java.lang.Throwable;

public interface ThrowableDoublePredicate<E extends Throwable> {
    boolean test(double d) throws Throwable;
}

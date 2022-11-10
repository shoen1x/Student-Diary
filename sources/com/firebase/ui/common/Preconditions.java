package com.firebase.ui.common;

public final class Preconditions {
    public static <T> T checkNotNull(T o) {
        if (o != null) {
            return o;
        }
        throw new IllegalArgumentException("Argument cannot be null.");
    }

    public static void assertNull(Object object, String message) {
        if (object != null) {
            throw new RuntimeException(message);
        }
    }

    public static void assertNonNull(Object object, String message) {
        if (object == null) {
            throw new RuntimeException(message);
        }
    }
}

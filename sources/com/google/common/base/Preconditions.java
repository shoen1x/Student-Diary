package com.google.common.base;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean expression, @NullableDecl Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean expression, @NullableDecl String errorMessageTemplate, @NullableDecl Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, char p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, long p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, char p1, char p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, char p1, int p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, char p1, long p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, char p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), p2));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, int p1, char p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, int p1, int p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, int p1, long p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, int p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), p2));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, long p1, char p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, long p1, int p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, long p1, long p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, long p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), p2));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, char p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, Character.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, int p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, Integer.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, long p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, Long.valueOf(p2)));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, p2));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3));
        }
    }

    public static void checkArgument(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3, @NullableDecl Object p4) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3, p4));
        }
    }

    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean expression, @NullableDecl Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void checkState(boolean expression, @NullableDecl String errorMessageTemplate, @NullableDecl Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, char p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, long p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, char p1, char p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, char p1, int p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, char p1, long p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, char p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), p2));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, int p1, char p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, int p1, int p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, int p1, long p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, int p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), p2));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, long p1, char p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Character.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, long p1, int p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Integer.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, long p1, long p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Long.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, long p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), p2));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, char p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, Character.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, int p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, Integer.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, long p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, Long.valueOf(p2)));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, p2));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3));
        }
    }

    public static void checkState(boolean b, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3, @NullableDecl Object p4) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3, p4));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T reference) {
        if (reference != null) {
            return reference;
        }
        throw null;
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T reference, @NullableDecl Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T reference, @NullableDecl String errorMessageTemplate, @NullableDecl Object... errorMessageArgs) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, errorMessageArgs));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, char p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, int p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, long p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, char p1, char p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Character.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, char p1, int p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Integer.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, char p1, long p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), Long.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, char p1, @NullableDecl Object p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Character.valueOf(p1), p2));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, int p1, char p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Character.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, int p1, int p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Integer.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, int p1, long p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), Long.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, int p1, @NullableDecl Object p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1), p2));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, long p1, char p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Character.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, long p1, int p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Integer.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, long p1, long p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), Long.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, long p1, @NullableDecl Object p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), p2));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, char p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, Character.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, int p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, Integer.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, long p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, Long.valueOf(p2)));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, p2));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3));
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T obj, @NullableDecl String errorMessageTemplate, @NullableDecl Object p1, @NullableDecl Object p2, @NullableDecl Object p3, @NullableDecl Object p4) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1, p2, p3, p4));
    }

    public static int checkElementIndex(int index, int size) {
        return checkElementIndex(index, size, FirebaseAnalytics.Param.INDEX);
    }

    public static int checkElementIndex(int index, int size, @NullableDecl String desc) {
        if (index >= 0 && index < size) {
            return index;
        }
        throw new IndexOutOfBoundsException(badElementIndex(index, size, desc));
    }

    private static String badElementIndex(int index, int size, @NullableDecl String desc) {
        if (index < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        } else {
            throw new IllegalArgumentException("negative size: " + size);
        }
    }

    public static int checkPositionIndex(int index, int size) {
        return checkPositionIndex(index, size, FirebaseAnalytics.Param.INDEX);
    }

    public static int checkPositionIndex(int index, int size, @NullableDecl String desc) {
        if (index >= 0 && index <= size) {
            return index;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(index, size, desc));
    }

    private static String badPositionIndex(int index, int size, @NullableDecl String desc) {
        if (index < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        } else {
            throw new IllegalArgumentException("negative size: " + size);
        }
    }

    public static void checkPositionIndexes(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(badPositionIndexes(start, end, size));
        }
    }

    private static String badPositionIndexes(int start, int end, int size) {
        if (start < 0 || start > size) {
            return badPositionIndex(start, size, "start index");
        }
        if (end < 0 || end > size) {
            return badPositionIndex(end, size, "end index");
        }
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(end), Integer.valueOf(start));
    }
}

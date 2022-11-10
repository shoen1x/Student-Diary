package androidx.room.util;

public class SneakyThrow {
    public static void reThrow(Exception e) {
        sneakyThrow(e);
    }

    private static <E extends Throwable> void sneakyThrow(Throwable e) throws Throwable {
        throw e;
    }

    private SneakyThrow() {
    }
}

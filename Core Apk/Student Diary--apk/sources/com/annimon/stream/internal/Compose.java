package com.annimon.stream.internal;

import java.io.Closeable;

public final class Compose {
    private Compose() {
    }

    public static Runnable runnables(final Runnable a, final Runnable b) {
        return new Runnable() {
            public void run() {
                try {
                    a.run();
                    b.run();
                    return;
                } catch (Throwable th) {
                }
                if (th instanceof RuntimeException) {
                    throw th;
                }
                throw th;
            }
        };
    }

    public static Runnable closeables(final Closeable a, final Closeable b) {
        return new Runnable() {
            public void run() {
                try {
                    a.close();
                    try {
                        b.close();
                        return;
                    } catch (Throwable th) {
                        if (th instanceof RuntimeException) {
                            throw th;
                        } else if (th instanceof Error) {
                            throw th;
                        } else {
                            throw new RuntimeException(th);
                        }
                    }
                } catch (Throwable th2) {
                }
                if (th instanceof RuntimeException) {
                    throw th;
                }
                throw th;
            }
        };
    }
}

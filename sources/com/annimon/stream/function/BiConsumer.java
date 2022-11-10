package com.annimon.stream.function;

public interface BiConsumer<T, U> {
    void accept(T t, U u);

    public static class Util {
        private Util() {
        }

        public static <T, U> BiConsumer<T, U> andThen(final BiConsumer<? super T, ? super U> c1, final BiConsumer<? super T, ? super U> c2) {
            return new BiConsumer<T, U>() {
                public void accept(T t, U u) {
                    c1.accept(t, u);
                    c2.accept(t, u);
                }
            };
        }
    }
}

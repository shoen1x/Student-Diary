package com.annimon.stream.function;

public interface BooleanConsumer {
    void accept(boolean z);

    public static class Util {
        private Util() {
        }

        public static BooleanConsumer andThen(final BooleanConsumer c1, final BooleanConsumer c2) {
            return new BooleanConsumer() {
                public void accept(boolean value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }
    }
}

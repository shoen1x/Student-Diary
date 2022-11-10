package com.annimon.stream;

import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.LongSupplier;
import java.util.Random;

public final class RandomCompat {
    /* access modifiers changed from: private */
    public final Random random;

    public RandomCompat() {
        this.random = new Random();
    }

    public RandomCompat(long seed) {
        this.random = new Random(seed);
    }

    public RandomCompat(Random random2) {
        this.random = random2;
    }

    public Random getRandom() {
        return this.random;
    }

    public IntStream ints(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return IntStream.empty();
        } else {
            return ints().limit(streamSize);
        }
    }

    public LongStream longs(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return LongStream.empty();
        } else {
            return longs().limit(streamSize);
        }
    }

    public DoubleStream doubles(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return DoubleStream.empty();
        } else {
            return doubles().limit(streamSize);
        }
    }

    public IntStream ints() {
        return IntStream.generate(new IntSupplier() {
            public int getAsInt() {
                return RandomCompat.this.random.nextInt();
            }
        });
    }

    public LongStream longs() {
        return LongStream.generate(new LongSupplier() {
            public long getAsLong() {
                return RandomCompat.this.random.nextLong();
            }
        });
    }

    public DoubleStream doubles() {
        return DoubleStream.generate(new DoubleSupplier() {
            public double getAsDouble() {
                return RandomCompat.this.random.nextDouble();
            }
        });
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return IntStream.empty();
        } else {
            return ints(randomNumberOrigin, randomNumberBound).limit(streamSize);
        }
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return LongStream.empty();
        } else {
            return longs(randomNumberOrigin, randomNumberBound).limit(streamSize);
        }
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException();
        } else if (streamSize == 0) {
            return DoubleStream.empty();
        } else {
            return doubles(randomNumberOrigin, randomNumberBound).limit(streamSize);
        }
    }

    public IntStream ints(final int randomNumberOrigin, final int randomNumberBound) {
        if (randomNumberOrigin < randomNumberBound) {
            return IntStream.generate(new IntSupplier() {
                private final int bound = (randomNumberBound - randomNumberOrigin);

                public int getAsInt() {
                    if (this.bound >= 0) {
                        return randomNumberOrigin + RandomCompat.this.random.nextInt(this.bound);
                    }
                    while (true) {
                        int result = RandomCompat.this.random.nextInt();
                        if (randomNumberOrigin < result && result < randomNumberBound) {
                            return result;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException();
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin < randomNumberBound) {
            final long j = randomNumberBound;
            final long j2 = randomNumberOrigin;
            return LongStream.generate(new LongSupplier() {
                private final long bound;
                private final long boundMinus1;

                {
                    long j = j - j2;
                    this.bound = j;
                    this.boundMinus1 = j - 1;
                }

                public long getAsLong() {
                    long result = RandomCompat.this.random.nextLong();
                    long result2 = this.bound;
                    long j = this.boundMinus1;
                    if ((result2 & j) == 0) {
                        return (result & j) + j2;
                    }
                    if (result2 > 0) {
                        long u = result >>> 1;
                        while (true) {
                            long j2 = u % this.bound;
                            long result3 = j2;
                            if ((this.boundMinus1 + u) - j2 >= 0) {
                                return result3 + j2;
                            }
                            u = RandomCompat.this.random.nextLong() >>> 1;
                        }
                    } else {
                        while (true) {
                            if (j2 < result && result < j) {
                                return result;
                            }
                            result = RandomCompat.this.random.nextLong();
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException();
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        if (randomNumberOrigin < randomNumberBound) {
            final double d = randomNumberBound;
            final double d2 = randomNumberOrigin;
            return DoubleStream.generate(new DoubleSupplier() {
                private final double bound = (d - d2);

                public double getAsDouble() {
                    double result = (RandomCompat.this.random.nextDouble() * this.bound) + d2;
                    double d = d;
                    if (result >= d) {
                        return Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
                    }
                    return result;
                }
            });
        }
        throw new IllegalArgumentException();
    }
}

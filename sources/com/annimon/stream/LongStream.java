package com.annimon.stream;

import com.annimon.stream.function.Function;
import com.annimon.stream.function.IndexedLongConsumer;
import com.annimon.stream.function.IndexedLongPredicate;
import com.annimon.stream.function.IndexedLongUnaryOperator;
import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.function.LongToDoubleFunction;
import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.function.ObjLongConsumer;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.operator.LongArray;
import com.annimon.stream.operator.LongConcat;
import com.annimon.stream.operator.LongDropWhile;
import com.annimon.stream.operator.LongFilter;
import com.annimon.stream.operator.LongFilterIndexed;
import com.annimon.stream.operator.LongFlatMap;
import com.annimon.stream.operator.LongGenerate;
import com.annimon.stream.operator.LongIterate;
import com.annimon.stream.operator.LongLimit;
import com.annimon.stream.operator.LongMap;
import com.annimon.stream.operator.LongMapIndexed;
import com.annimon.stream.operator.LongMapToDouble;
import com.annimon.stream.operator.LongMapToInt;
import com.annimon.stream.operator.LongMapToObj;
import com.annimon.stream.operator.LongPeek;
import com.annimon.stream.operator.LongRangeClosed;
import com.annimon.stream.operator.LongSample;
import com.annimon.stream.operator.LongScan;
import com.annimon.stream.operator.LongScanIdentity;
import com.annimon.stream.operator.LongSkip;
import com.annimon.stream.operator.LongSorted;
import com.annimon.stream.operator.LongTakeUntil;
import com.annimon.stream.operator.LongTakeWhile;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

public final class LongStream implements Closeable {
    private static final LongStream EMPTY = new LongStream(new PrimitiveIterator.OfLong() {
        public boolean hasNext() {
            return false;
        }

        public long nextLong() {
            return 0;
        }
    });
    private static final ToLongFunction<Long> UNBOX_FUNCTION = new ToLongFunction<Long>() {
        public long applyAsLong(Long t) {
            return t.longValue();
        }
    };
    private final PrimitiveIterator.OfLong iterator;
    private final Params params;

    public static LongStream empty() {
        return EMPTY;
    }

    public static LongStream of(PrimitiveIterator.OfLong iterator2) {
        Objects.requireNonNull(iterator2);
        return new LongStream(iterator2);
    }

    public static LongStream of(long... values) {
        Objects.requireNonNull(values);
        if (values.length == 0) {
            return empty();
        }
        return new LongStream(new LongArray(values));
    }

    public static LongStream of(long t) {
        return new LongStream(new LongArray(new long[]{t}));
    }

    public static LongStream range(long startInclusive, long endExclusive) {
        if (startInclusive >= endExclusive) {
            return empty();
        }
        return rangeClosed(startInclusive, endExclusive - 1);
    }

    public static LongStream rangeClosed(long startInclusive, long endInclusive) {
        if (startInclusive > endInclusive) {
            return empty();
        }
        if (startInclusive == endInclusive) {
            return of(startInclusive);
        }
        return new LongStream(new LongRangeClosed(startInclusive, endInclusive));
    }

    public static LongStream generate(LongSupplier s) {
        Objects.requireNonNull(s);
        return new LongStream(new LongGenerate(s));
    }

    public static LongStream iterate(long seed, LongUnaryOperator f) {
        Objects.requireNonNull(f);
        return new LongStream(new LongIterate(seed, f));
    }

    public static LongStream iterate(long seed, LongPredicate predicate, LongUnaryOperator op) {
        Objects.requireNonNull(predicate);
        return iterate(seed, op).takeWhile(predicate);
    }

    public static LongStream concat(LongStream a, LongStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return new LongStream(new LongConcat(a.iterator, b.iterator)).onClose(Compose.closeables(a, b));
    }

    private LongStream(PrimitiveIterator.OfLong iterator2) {
        this((Params) null, iterator2);
    }

    LongStream(Params params2, PrimitiveIterator.OfLong iterator2) {
        this.params = params2;
        this.iterator = iterator2;
    }

    public PrimitiveIterator.OfLong iterator() {
        return this.iterator;
    }

    public <R> R custom(Function<LongStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public Stream<Long> boxed() {
        return new Stream<>(this.params, this.iterator);
    }

    public LongStream filter(LongPredicate predicate) {
        return new LongStream(this.params, new LongFilter(this.iterator, predicate));
    }

    public LongStream filterIndexed(IndexedLongPredicate predicate) {
        return filterIndexed(0, 1, predicate);
    }

    public LongStream filterIndexed(int from, int step, IndexedLongPredicate predicate) {
        return new LongStream(this.params, new LongFilterIndexed(new PrimitiveIndexedIterator.OfLong(from, step, this.iterator), predicate));
    }

    public LongStream filterNot(LongPredicate predicate) {
        return filter(LongPredicate.Util.negate(predicate));
    }

    public LongStream map(LongUnaryOperator mapper) {
        return new LongStream(this.params, new LongMap(this.iterator, mapper));
    }

    public LongStream mapIndexed(IndexedLongUnaryOperator mapper) {
        return mapIndexed(0, 1, mapper);
    }

    public LongStream mapIndexed(int from, int step, IndexedLongUnaryOperator mapper) {
        return new LongStream(this.params, new LongMapIndexed(new PrimitiveIndexedIterator.OfLong(from, step, this.iterator), mapper));
    }

    public <R> Stream<R> mapToObj(LongFunction<? extends R> mapper) {
        return new Stream<>(this.params, new LongMapToObj(this.iterator, mapper));
    }

    public IntStream mapToInt(LongToIntFunction mapper) {
        return new IntStream(this.params, new LongMapToInt(this.iterator, mapper));
    }

    public DoubleStream mapToDouble(LongToDoubleFunction mapper) {
        return new DoubleStream(this.params, new LongMapToDouble(this.iterator, mapper));
    }

    public LongStream flatMap(LongFunction<? extends LongStream> mapper) {
        return new LongStream(this.params, new LongFlatMap(this.iterator, mapper));
    }

    public LongStream distinct() {
        return boxed().distinct().mapToLong(UNBOX_FUNCTION);
    }

    public LongStream sorted() {
        return new LongStream(this.params, new LongSorted(this.iterator));
    }

    public LongStream sorted(Comparator<Long> comparator) {
        return boxed().sorted(comparator).mapToLong(UNBOX_FUNCTION);
    }

    public LongStream sample(int stepWidth) {
        if (stepWidth <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        } else if (stepWidth == 1) {
            return this;
        } else {
            return new LongStream(this.params, new LongSample(this.iterator, stepWidth));
        }
    }

    public LongStream peek(LongConsumer action) {
        return new LongStream(this.params, new LongPeek(this.iterator, action));
    }

    public LongStream scan(LongBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new LongStream(this.params, new LongScan(this.iterator, accumulator));
    }

    public LongStream scan(long identity, LongBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new LongStream(this.params, new LongScanIdentity(this.iterator, identity, accumulator));
    }

    public LongStream takeWhile(LongPredicate predicate) {
        return new LongStream(this.params, new LongTakeWhile(this.iterator, predicate));
    }

    public LongStream takeUntil(LongPredicate stopPredicate) {
        return new LongStream(this.params, new LongTakeUntil(this.iterator, stopPredicate));
    }

    public LongStream dropWhile(LongPredicate predicate) {
        return new LongStream(this.params, new LongDropWhile(this.iterator, predicate));
    }

    public LongStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (maxSize == 0) {
            return empty();
        } else {
            return new LongStream(this.params, new LongLimit(this.iterator, maxSize));
        }
    }

    public LongStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        } else if (n == 0) {
            return this;
        } else {
            return new LongStream(this.params, new LongSkip(this.iterator, n));
        }
    }

    public void forEach(LongConsumer action) {
        while (this.iterator.hasNext()) {
            action.accept(this.iterator.nextLong());
        }
    }

    public void forEachIndexed(IndexedLongConsumer action) {
        forEachIndexed(0, 1, action);
    }

    public void forEachIndexed(int from, int step, IndexedLongConsumer action) {
        int index = from;
        while (this.iterator.hasNext()) {
            action.accept(index, this.iterator.nextLong());
            index += step;
        }
    }

    public long reduce(long identity, LongBinaryOperator accumulator) {
        long result = identity;
        while (this.iterator.hasNext()) {
            result = accumulator.applyAsLong(result, this.iterator.nextLong());
        }
        return result;
    }

    public OptionalLong reduce(LongBinaryOperator accumulator) {
        boolean foundAny = false;
        long result = 0;
        while (this.iterator.hasNext()) {
            long value = this.iterator.nextLong();
            if (!foundAny) {
                foundAny = true;
                result = value;
            } else {
                result = accumulator.applyAsLong(result, value);
            }
        }
        return foundAny ? OptionalLong.of(result) : OptionalLong.empty();
    }

    public long[] toArray() {
        return Operators.toLongArray(this.iterator);
    }

    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator) {
        R result = supplier.get();
        while (this.iterator.hasNext()) {
            accumulator.accept(result, this.iterator.nextLong());
        }
        return result;
    }

    public long sum() {
        long sum = 0;
        while (this.iterator.hasNext()) {
            sum += this.iterator.nextLong();
        }
        return sum;
    }

    public OptionalLong min() {
        return reduce(new LongBinaryOperator() {
            public long applyAsLong(long left, long right) {
                return Math.min(left, right);
            }
        });
    }

    public OptionalLong max() {
        return reduce(new LongBinaryOperator() {
            public long applyAsLong(long left, long right) {
                return Math.max(left, right);
            }
        });
    }

    public long count() {
        long count = 0;
        while (this.iterator.hasNext()) {
            this.iterator.nextLong();
            count++;
        }
        return count;
    }

    public boolean anyMatch(LongPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextLong())) {
                return true;
            }
        }
        return false;
    }

    public boolean allMatch(LongPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (!predicate.test(this.iterator.nextLong())) {
                return false;
            }
        }
        return true;
    }

    public boolean noneMatch(LongPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextLong())) {
                return false;
            }
        }
        return true;
    }

    public OptionalLong findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalLong.of(this.iterator.nextLong());
        }
        return OptionalLong.empty();
    }

    public OptionalLong findLast() {
        return reduce(new LongBinaryOperator() {
            public long applyAsLong(long left, long right) {
                return right;
            }
        });
    }

    public long single() {
        if (this.iterator.hasNext()) {
            long singleCandidate = this.iterator.nextLong();
            if (!this.iterator.hasNext()) {
                return singleCandidate;
            }
            throw new IllegalStateException("LongStream contains more than one element");
        }
        throw new NoSuchElementException("LongStream contains no element");
    }

    public OptionalLong findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalLong.empty();
        }
        long singleCandidate = this.iterator.nextLong();
        if (!this.iterator.hasNext()) {
            return OptionalLong.of(singleCandidate);
        }
        throw new IllegalStateException("LongStream contains more than one element");
    }

    public LongStream onClose(Runnable closeHandler) {
        Params newParams;
        Objects.requireNonNull(closeHandler);
        if (this.params == null) {
            newParams = new Params();
            newParams.closeHandler = closeHandler;
        } else {
            newParams = this.params;
            newParams.closeHandler = Compose.runnables(newParams.closeHandler, closeHandler);
        }
        return new LongStream(newParams, this.iterator);
    }

    public void close() {
        Params params2 = this.params;
        if (params2 != null && params2.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
}

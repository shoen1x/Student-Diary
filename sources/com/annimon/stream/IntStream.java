package com.annimon.stream;

import com.annimon.stream.function.Function;
import com.annimon.stream.function.IndexedIntConsumer;
import com.annimon.stream.function.IndexedIntPredicate;
import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.function.ObjIntConsumer;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.operator.IntArray;
import com.annimon.stream.operator.IntCodePoints;
import com.annimon.stream.operator.IntConcat;
import com.annimon.stream.operator.IntDropWhile;
import com.annimon.stream.operator.IntFilter;
import com.annimon.stream.operator.IntFilterIndexed;
import com.annimon.stream.operator.IntFlatMap;
import com.annimon.stream.operator.IntGenerate;
import com.annimon.stream.operator.IntIterate;
import com.annimon.stream.operator.IntLimit;
import com.annimon.stream.operator.IntMap;
import com.annimon.stream.operator.IntMapIndexed;
import com.annimon.stream.operator.IntMapToDouble;
import com.annimon.stream.operator.IntMapToLong;
import com.annimon.stream.operator.IntMapToObj;
import com.annimon.stream.operator.IntPeek;
import com.annimon.stream.operator.IntRangeClosed;
import com.annimon.stream.operator.IntSample;
import com.annimon.stream.operator.IntScan;
import com.annimon.stream.operator.IntScanIdentity;
import com.annimon.stream.operator.IntSkip;
import com.annimon.stream.operator.IntSorted;
import com.annimon.stream.operator.IntTakeUntil;
import com.annimon.stream.operator.IntTakeWhile;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

public final class IntStream implements Closeable {
    private static final IntStream EMPTY = new IntStream(new PrimitiveIterator.OfInt() {
        public int nextInt() {
            return 0;
        }

        public boolean hasNext() {
            return false;
        }
    });
    private static final ToIntFunction<Integer> UNBOX_FUNCTION = new ToIntFunction<Integer>() {
        public int applyAsInt(Integer t) {
            return t.intValue();
        }
    };
    private final PrimitiveIterator.OfInt iterator;
    private final Params params;

    public static IntStream empty() {
        return EMPTY;
    }

    public static IntStream of(PrimitiveIterator.OfInt iterator2) {
        Objects.requireNonNull(iterator2);
        return new IntStream(iterator2);
    }

    public static IntStream of(int... values) {
        Objects.requireNonNull(values);
        if (values.length == 0) {
            return empty();
        }
        return new IntStream(new IntArray(values));
    }

    public static IntStream of(int t) {
        return new IntStream(new IntArray(new int[]{t}));
    }

    public static IntStream ofCodePoints(CharSequence charSequence) {
        return new IntStream(new IntCodePoints(charSequence));
    }

    public static IntStream range(int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            return empty();
        }
        return rangeClosed(startInclusive, endExclusive - 1);
    }

    public static IntStream rangeClosed(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            return empty();
        }
        if (startInclusive == endInclusive) {
            return of(startInclusive);
        }
        return new IntStream(new IntRangeClosed(startInclusive, endInclusive));
    }

    public static IntStream generate(IntSupplier s) {
        Objects.requireNonNull(s);
        return new IntStream(new IntGenerate(s));
    }

    public static IntStream iterate(int seed, IntUnaryOperator f) {
        Objects.requireNonNull(f);
        return new IntStream(new IntIterate(seed, f));
    }

    public static IntStream iterate(int seed, IntPredicate predicate, IntUnaryOperator op) {
        Objects.requireNonNull(predicate);
        return iterate(seed, op).takeWhile(predicate);
    }

    public static IntStream concat(IntStream a, IntStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return new IntStream(new IntConcat(a.iterator, b.iterator)).onClose(Compose.closeables(a, b));
    }

    private IntStream(PrimitiveIterator.OfInt iterator2) {
        this((Params) null, iterator2);
    }

    IntStream(Params params2, PrimitiveIterator.OfInt iterator2) {
        this.params = params2;
        this.iterator = iterator2;
    }

    public PrimitiveIterator.OfInt iterator() {
        return this.iterator;
    }

    public <R> R custom(Function<IntStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public Stream<Integer> boxed() {
        return new Stream<>(this.params, this.iterator);
    }

    public IntStream filter(IntPredicate predicate) {
        return new IntStream(this.params, new IntFilter(this.iterator, predicate));
    }

    public IntStream filterIndexed(IndexedIntPredicate predicate) {
        return filterIndexed(0, 1, predicate);
    }

    public IntStream filterIndexed(int from, int step, IndexedIntPredicate predicate) {
        return new IntStream(this.params, new IntFilterIndexed(new PrimitiveIndexedIterator.OfInt(from, step, this.iterator), predicate));
    }

    public IntStream filterNot(IntPredicate predicate) {
        return filter(IntPredicate.Util.negate(predicate));
    }

    public IntStream map(IntUnaryOperator mapper) {
        return new IntStream(this.params, new IntMap(this.iterator, mapper));
    }

    public IntStream mapIndexed(IntBinaryOperator mapper) {
        return mapIndexed(0, 1, mapper);
    }

    public IntStream mapIndexed(int from, int step, IntBinaryOperator mapper) {
        return new IntStream(this.params, new IntMapIndexed(new PrimitiveIndexedIterator.OfInt(from, step, this.iterator), mapper));
    }

    public <R> Stream<R> mapToObj(IntFunction<? extends R> mapper) {
        return new Stream<>(this.params, new IntMapToObj(this.iterator, mapper));
    }

    public LongStream mapToLong(IntToLongFunction mapper) {
        return new LongStream(this.params, new IntMapToLong(this.iterator, mapper));
    }

    public DoubleStream mapToDouble(IntToDoubleFunction mapper) {
        return new DoubleStream(this.params, new IntMapToDouble(this.iterator, mapper));
    }

    public IntStream flatMap(IntFunction<? extends IntStream> mapper) {
        return new IntStream(this.params, new IntFlatMap(this.iterator, mapper));
    }

    public IntStream distinct() {
        return boxed().distinct().mapToInt(UNBOX_FUNCTION);
    }

    public IntStream sorted() {
        return new IntStream(this.params, new IntSorted(this.iterator));
    }

    public IntStream sorted(Comparator<Integer> comparator) {
        return boxed().sorted(comparator).mapToInt(UNBOX_FUNCTION);
    }

    public IntStream sample(int stepWidth) {
        if (stepWidth <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        } else if (stepWidth == 1) {
            return this;
        } else {
            return new IntStream(this.params, new IntSample(this.iterator, stepWidth));
        }
    }

    public IntStream peek(IntConsumer action) {
        return new IntStream(this.params, new IntPeek(this.iterator, action));
    }

    public IntStream scan(IntBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new IntStream(this.params, new IntScan(this.iterator, accumulator));
    }

    public IntStream scan(int identity, IntBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new IntStream(this.params, new IntScanIdentity(this.iterator, identity, accumulator));
    }

    public IntStream takeWhile(IntPredicate predicate) {
        return new IntStream(this.params, new IntTakeWhile(this.iterator, predicate));
    }

    public IntStream takeUntil(IntPredicate stopPredicate) {
        return new IntStream(this.params, new IntTakeUntil(this.iterator, stopPredicate));
    }

    public IntStream dropWhile(IntPredicate predicate) {
        return new IntStream(this.params, new IntDropWhile(this.iterator, predicate));
    }

    public IntStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (maxSize == 0) {
            return empty();
        } else {
            return new IntStream(this.params, new IntLimit(this.iterator, maxSize));
        }
    }

    public IntStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        } else if (n == 0) {
            return this;
        } else {
            return new IntStream(this.params, new IntSkip(this.iterator, n));
        }
    }

    public void forEach(IntConsumer action) {
        while (this.iterator.hasNext()) {
            action.accept(this.iterator.nextInt());
        }
    }

    public void forEachIndexed(IndexedIntConsumer action) {
        forEachIndexed(0, 1, action);
    }

    public void forEachIndexed(int from, int step, IndexedIntConsumer action) {
        int index = from;
        while (this.iterator.hasNext()) {
            action.accept(index, this.iterator.nextInt());
            index += step;
        }
    }

    public int reduce(int identity, IntBinaryOperator op) {
        int result = identity;
        while (this.iterator.hasNext()) {
            result = op.applyAsInt(result, this.iterator.nextInt());
        }
        return result;
    }

    public OptionalInt reduce(IntBinaryOperator op) {
        boolean foundAny = false;
        int result = 0;
        while (this.iterator.hasNext()) {
            int value = this.iterator.nextInt();
            if (!foundAny) {
                foundAny = true;
                result = value;
            } else {
                result = op.applyAsInt(result, value);
            }
        }
        return foundAny ? OptionalInt.of(result) : OptionalInt.empty();
    }

    public int[] toArray() {
        return Operators.toIntArray(this.iterator);
    }

    public <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator) {
        R result = supplier.get();
        while (this.iterator.hasNext()) {
            accumulator.accept(result, this.iterator.nextInt());
        }
        return result;
    }

    public int sum() {
        int sum = 0;
        while (this.iterator.hasNext()) {
            sum += this.iterator.nextInt();
        }
        return sum;
    }

    public OptionalInt min() {
        return reduce(new IntBinaryOperator() {
            public int applyAsInt(int left, int right) {
                return left < right ? left : right;
            }
        });
    }

    public OptionalInt max() {
        return reduce(new IntBinaryOperator() {
            public int applyAsInt(int left, int right) {
                return left > right ? left : right;
            }
        });
    }

    public long count() {
        long count = 0;
        while (this.iterator.hasNext()) {
            this.iterator.nextInt();
            count++;
        }
        return count;
    }

    public boolean anyMatch(IntPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextInt())) {
                return true;
            }
        }
        return false;
    }

    public boolean allMatch(IntPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (!predicate.test(this.iterator.nextInt())) {
                return false;
            }
        }
        return true;
    }

    public boolean noneMatch(IntPredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextInt())) {
                return false;
            }
        }
        return true;
    }

    public OptionalInt findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalInt.of(this.iterator.nextInt());
        }
        return OptionalInt.empty();
    }

    public OptionalInt findLast() {
        return reduce(new IntBinaryOperator() {
            public int applyAsInt(int left, int right) {
                return right;
            }
        });
    }

    public int single() {
        if (this.iterator.hasNext()) {
            int singleCandidate = this.iterator.nextInt();
            if (!this.iterator.hasNext()) {
                return singleCandidate;
            }
            throw new IllegalStateException("IntStream contains more than one element");
        }
        throw new NoSuchElementException("IntStream contains no element");
    }

    public OptionalInt findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalInt.empty();
        }
        int singleCandidate = this.iterator.nextInt();
        if (!this.iterator.hasNext()) {
            return OptionalInt.of(singleCandidate);
        }
        throw new IllegalStateException("IntStream contains more than one element");
    }

    public IntStream onClose(Runnable closeHandler) {
        Params newParams;
        Objects.requireNonNull(closeHandler);
        if (this.params == null) {
            newParams = new Params();
            newParams.closeHandler = closeHandler;
        } else {
            newParams = this.params;
            newParams.closeHandler = Compose.runnables(newParams.closeHandler, closeHandler);
        }
        return new IntStream(newParams, this.iterator);
    }

    public void close() {
        Params params2 = this.params;
        if (params2 != null && params2.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
}

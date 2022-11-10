package com.annimon.stream;

import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.IndexedDoubleConsumer;
import com.annimon.stream.function.IndexedDoublePredicate;
import com.annimon.stream.function.IndexedDoubleUnaryOperator;
import com.annimon.stream.function.ObjDoubleConsumer;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIndexedIterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.operator.DoubleArray;
import com.annimon.stream.operator.DoubleConcat;
import com.annimon.stream.operator.DoubleDropWhile;
import com.annimon.stream.operator.DoubleFilter;
import com.annimon.stream.operator.DoubleFilterIndexed;
import com.annimon.stream.operator.DoubleFlatMap;
import com.annimon.stream.operator.DoubleGenerate;
import com.annimon.stream.operator.DoubleIterate;
import com.annimon.stream.operator.DoubleLimit;
import com.annimon.stream.operator.DoubleMap;
import com.annimon.stream.operator.DoubleMapIndexed;
import com.annimon.stream.operator.DoubleMapToInt;
import com.annimon.stream.operator.DoubleMapToLong;
import com.annimon.stream.operator.DoubleMapToObj;
import com.annimon.stream.operator.DoublePeek;
import com.annimon.stream.operator.DoubleSample;
import com.annimon.stream.operator.DoubleScan;
import com.annimon.stream.operator.DoubleScanIdentity;
import com.annimon.stream.operator.DoubleSkip;
import com.annimon.stream.operator.DoubleSorted;
import com.annimon.stream.operator.DoubleTakeUntil;
import com.annimon.stream.operator.DoubleTakeWhile;
import java.io.Closeable;
import java.util.Comparator;
import java.util.NoSuchElementException;

public final class DoubleStream implements Closeable {
    private static final DoubleStream EMPTY = new DoubleStream(new PrimitiveIterator.OfDouble() {
        public boolean hasNext() {
            return false;
        }

        public double nextDouble() {
            return 0.0d;
        }
    });
    private static final ToDoubleFunction<Double> UNBOX_FUNCTION = new ToDoubleFunction<Double>() {
        public double applyAsDouble(Double t) {
            return t.doubleValue();
        }
    };
    private final PrimitiveIterator.OfDouble iterator;
    private final Params params;

    public static DoubleStream empty() {
        return EMPTY;
    }

    public static DoubleStream of(PrimitiveIterator.OfDouble iterator2) {
        Objects.requireNonNull(iterator2);
        return new DoubleStream(iterator2);
    }

    public static DoubleStream of(double... values) {
        Objects.requireNonNull(values);
        if (values.length == 0) {
            return empty();
        }
        return new DoubleStream(new DoubleArray(values));
    }

    public static DoubleStream of(double t) {
        return new DoubleStream(new DoubleArray(new double[]{t}));
    }

    public static DoubleStream generate(DoubleSupplier s) {
        Objects.requireNonNull(s);
        return new DoubleStream(new DoubleGenerate(s));
    }

    public static DoubleStream iterate(double seed, DoubleUnaryOperator f) {
        Objects.requireNonNull(f);
        return new DoubleStream(new DoubleIterate(seed, f));
    }

    public static DoubleStream iterate(double seed, DoublePredicate predicate, DoubleUnaryOperator op) {
        Objects.requireNonNull(predicate);
        return iterate(seed, op).takeWhile(predicate);
    }

    public static DoubleStream concat(DoubleStream a, DoubleStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return new DoubleStream(new DoubleConcat(a.iterator, b.iterator)).onClose(Compose.closeables(a, b));
    }

    private DoubleStream(PrimitiveIterator.OfDouble iterator2) {
        this((Params) null, iterator2);
    }

    DoubleStream(Params params2, PrimitiveIterator.OfDouble iterator2) {
        this.params = params2;
        this.iterator = iterator2;
    }

    public PrimitiveIterator.OfDouble iterator() {
        return this.iterator;
    }

    public <R> R custom(Function<DoubleStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public Stream<Double> boxed() {
        return new Stream<>(this.params, this.iterator);
    }

    public DoubleStream filter(DoublePredicate predicate) {
        return new DoubleStream(this.params, new DoubleFilter(this.iterator, predicate));
    }

    public DoubleStream filterIndexed(IndexedDoublePredicate predicate) {
        return filterIndexed(0, 1, predicate);
    }

    public DoubleStream filterIndexed(int from, int step, IndexedDoublePredicate predicate) {
        return new DoubleStream(this.params, new DoubleFilterIndexed(new PrimitiveIndexedIterator.OfDouble(from, step, this.iterator), predicate));
    }

    public DoubleStream filterNot(DoublePredicate predicate) {
        return filter(DoublePredicate.Util.negate(predicate));
    }

    public DoubleStream map(DoubleUnaryOperator mapper) {
        return new DoubleStream(this.params, new DoubleMap(this.iterator, mapper));
    }

    public DoubleStream mapIndexed(IndexedDoubleUnaryOperator mapper) {
        return mapIndexed(0, 1, mapper);
    }

    public DoubleStream mapIndexed(int from, int step, IndexedDoubleUnaryOperator mapper) {
        return new DoubleStream(this.params, new DoubleMapIndexed(new PrimitiveIndexedIterator.OfDouble(from, step, this.iterator), mapper));
    }

    public <R> Stream<R> mapToObj(DoubleFunction<? extends R> mapper) {
        return new Stream<>(this.params, new DoubleMapToObj(this.iterator, mapper));
    }

    public IntStream mapToInt(DoubleToIntFunction mapper) {
        return new IntStream(this.params, new DoubleMapToInt(this.iterator, mapper));
    }

    public LongStream mapToLong(DoubleToLongFunction mapper) {
        return new LongStream(this.params, new DoubleMapToLong(this.iterator, mapper));
    }

    public DoubleStream flatMap(DoubleFunction<? extends DoubleStream> mapper) {
        return new DoubleStream(this.params, new DoubleFlatMap(this.iterator, mapper));
    }

    public DoubleStream distinct() {
        return boxed().distinct().mapToDouble(UNBOX_FUNCTION);
    }

    public DoubleStream sorted() {
        return new DoubleStream(this.params, new DoubleSorted(this.iterator));
    }

    public DoubleStream sorted(Comparator<Double> comparator) {
        return boxed().sorted(comparator).mapToDouble(UNBOX_FUNCTION);
    }

    public DoubleStream sample(int stepWidth) {
        if (stepWidth <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        } else if (stepWidth == 1) {
            return this;
        } else {
            return new DoubleStream(this.params, new DoubleSample(this.iterator, stepWidth));
        }
    }

    public DoubleStream peek(DoubleConsumer action) {
        return new DoubleStream(this.params, new DoublePeek(this.iterator, action));
    }

    public DoubleStream scan(DoubleBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new DoubleStream(this.params, new DoubleScan(this.iterator, accumulator));
    }

    public DoubleStream scan(double identity, DoubleBinaryOperator accumulator) {
        Objects.requireNonNull(accumulator);
        return new DoubleStream(this.params, new DoubleScanIdentity(this.iterator, identity, accumulator));
    }

    public DoubleStream takeWhile(DoublePredicate predicate) {
        return new DoubleStream(this.params, new DoubleTakeWhile(this.iterator, predicate));
    }

    public DoubleStream takeUntil(DoublePredicate stopPredicate) {
        return new DoubleStream(this.params, new DoubleTakeUntil(this.iterator, stopPredicate));
    }

    public DoubleStream dropWhile(DoublePredicate predicate) {
        return new DoubleStream(this.params, new DoubleDropWhile(this.iterator, predicate));
    }

    public DoubleStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (maxSize == 0) {
            return empty();
        } else {
            return new DoubleStream(this.params, new DoubleLimit(this.iterator, maxSize));
        }
    }

    public DoubleStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        } else if (n == 0) {
            return this;
        } else {
            return new DoubleStream(this.params, new DoubleSkip(this.iterator, n));
        }
    }

    public void forEach(DoubleConsumer action) {
        while (this.iterator.hasNext()) {
            action.accept(this.iterator.nextDouble());
        }
    }

    public void forEachIndexed(IndexedDoubleConsumer action) {
        forEachIndexed(0, 1, action);
    }

    public void forEachIndexed(int from, int step, IndexedDoubleConsumer action) {
        int index = from;
        while (this.iterator.hasNext()) {
            action.accept(index, this.iterator.nextDouble());
            index += step;
        }
    }

    public double reduce(double identity, DoubleBinaryOperator accumulator) {
        double result = identity;
        while (this.iterator.hasNext()) {
            result = accumulator.applyAsDouble(result, this.iterator.nextDouble());
        }
        return result;
    }

    public OptionalDouble reduce(DoubleBinaryOperator accumulator) {
        boolean foundAny = false;
        double result = 0.0d;
        while (this.iterator.hasNext()) {
            double value = this.iterator.nextDouble();
            if (!foundAny) {
                foundAny = true;
                result = value;
            } else {
                result = accumulator.applyAsDouble(result, value);
            }
        }
        return foundAny ? OptionalDouble.of(result) : OptionalDouble.empty();
    }

    public double[] toArray() {
        return Operators.toDoubleArray(this.iterator);
    }

    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator) {
        R result = supplier.get();
        while (this.iterator.hasNext()) {
            accumulator.accept(result, this.iterator.nextDouble());
        }
        return result;
    }

    public double sum() {
        double sum = 0.0d;
        while (this.iterator.hasNext()) {
            sum += this.iterator.nextDouble();
        }
        return sum;
    }

    public OptionalDouble min() {
        return reduce(new DoubleBinaryOperator() {
            public double applyAsDouble(double left, double right) {
                return Math.min(left, right);
            }
        });
    }

    public OptionalDouble max() {
        return reduce(new DoubleBinaryOperator() {
            public double applyAsDouble(double left, double right) {
                return Math.max(left, right);
            }
        });
    }

    public long count() {
        long count = 0;
        while (this.iterator.hasNext()) {
            this.iterator.nextDouble();
            count++;
        }
        return count;
    }

    public OptionalDouble average() {
        long count = 0;
        double sum = 0.0d;
        while (this.iterator.hasNext()) {
            sum += this.iterator.nextDouble();
            count++;
        }
        if (count == 0) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(sum / ((double) count));
    }

    public boolean anyMatch(DoublePredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextDouble())) {
                return true;
            }
        }
        return false;
    }

    public boolean allMatch(DoublePredicate predicate) {
        while (this.iterator.hasNext()) {
            if (!predicate.test(this.iterator.nextDouble())) {
                return false;
            }
        }
        return true;
    }

    public boolean noneMatch(DoublePredicate predicate) {
        while (this.iterator.hasNext()) {
            if (predicate.test(this.iterator.nextDouble())) {
                return false;
            }
        }
        return true;
    }

    public OptionalDouble findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalDouble.of(this.iterator.nextDouble());
        }
        return OptionalDouble.empty();
    }

    public OptionalDouble findLast() {
        return reduce(new DoubleBinaryOperator() {
            public double applyAsDouble(double left, double right) {
                return right;
            }
        });
    }

    public double single() {
        if (this.iterator.hasNext()) {
            double singleCandidate = this.iterator.nextDouble();
            if (!this.iterator.hasNext()) {
                return singleCandidate;
            }
            throw new IllegalStateException("DoubleStream contains more than one element");
        }
        throw new NoSuchElementException("DoubleStream contains no element");
    }

    public OptionalDouble findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalDouble.empty();
        }
        double singleCandidate = this.iterator.nextDouble();
        if (!this.iterator.hasNext()) {
            return OptionalDouble.of(singleCandidate);
        }
        throw new IllegalStateException("DoubleStream contains more than one element");
    }

    public DoubleStream onClose(Runnable closeHandler) {
        Params newParams;
        Objects.requireNonNull(closeHandler);
        if (this.params == null) {
            newParams = new Params();
            newParams.closeHandler = closeHandler;
        } else {
            newParams = this.params;
            newParams.closeHandler = Compose.runnables(newParams.closeHandler, closeHandler);
        }
        return new DoubleStream(newParams, this.iterator);
    }

    public void close() {
        Params params2 = this.params;
        if (params2 != null && params2.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
}

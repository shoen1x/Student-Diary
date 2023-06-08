package com.annimon.stream;

import com.annimon.stream.function.BiConsumer;
import com.annimon.stream.function.BiFunction;
import com.annimon.stream.function.BinaryOperator;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.IndexedBiFunction;
import com.annimon.stream.function.IndexedConsumer;
import com.annimon.stream.function.IndexedFunction;
import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.function.UnaryOperator;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LazyIterator;
import com.annimon.stream.operator.ObjArray;
import com.annimon.stream.operator.ObjChunkBy;
import com.annimon.stream.operator.ObjConcat;
import com.annimon.stream.operator.ObjDistinct;
import com.annimon.stream.operator.ObjDistinctBy;
import com.annimon.stream.operator.ObjDropWhile;
import com.annimon.stream.operator.ObjDropWhileIndexed;
import com.annimon.stream.operator.ObjFilter;
import com.annimon.stream.operator.ObjFilterIndexed;
import com.annimon.stream.operator.ObjFlatMap;
import com.annimon.stream.operator.ObjFlatMapToDouble;
import com.annimon.stream.operator.ObjFlatMapToInt;
import com.annimon.stream.operator.ObjFlatMapToLong;
import com.annimon.stream.operator.ObjGenerate;
import com.annimon.stream.operator.ObjIterate;
import com.annimon.stream.operator.ObjLimit;
import com.annimon.stream.operator.ObjMap;
import com.annimon.stream.operator.ObjMapIndexed;
import com.annimon.stream.operator.ObjMapToDouble;
import com.annimon.stream.operator.ObjMapToInt;
import com.annimon.stream.operator.ObjMapToLong;
import com.annimon.stream.operator.ObjMerge;
import com.annimon.stream.operator.ObjPeek;
import com.annimon.stream.operator.ObjScan;
import com.annimon.stream.operator.ObjScanIdentity;
import com.annimon.stream.operator.ObjSkip;
import com.annimon.stream.operator.ObjSlidingWindow;
import com.annimon.stream.operator.ObjSorted;
import com.annimon.stream.operator.ObjTakeUntil;
import com.annimon.stream.operator.ObjTakeUntilIndexed;
import com.annimon.stream.operator.ObjTakeWhile;
import com.annimon.stream.operator.ObjTakeWhileIndexed;
import com.annimon.stream.operator.ObjZip;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Stream<T> implements Closeable {
    private static final int MATCH_ALL = 1;
    private static final int MATCH_ANY = 0;
    private static final int MATCH_NONE = 2;
    private final Iterator<? extends T> iterator;
    private final Params params;

    public static <T> Stream<T> empty() {
        return of(Collections.emptyList());
    }

    public static <K, V> Stream<Map.Entry<K, V>> of(Map<K, V> map) {
        Objects.requireNonNull(map);
        return new Stream<>(map.entrySet());
    }

    public static <T> Stream<T> of(Iterator<? extends T> iterator2) {
        Objects.requireNonNull(iterator2);
        return new Stream<>(iterator2);
    }

    public static <T> Stream<T> of(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable);
        return new Stream<>(iterable);
    }

    public static <T> Stream<T> of(T... elements) {
        Objects.requireNonNull(elements);
        if (elements.length == 0) {
            return empty();
        }
        return new Stream<>(new ObjArray(elements));
    }

    public static <T> Stream<T> ofNullable(T element) {
        if (element == null) {
            return empty();
        }
        return of((T[]) new Object[]{element});
    }

    public static <T> Stream<T> ofNullable(T[] array) {
        return array == null ? empty() : of(array);
    }

    public static <K, V> Stream<Map.Entry<K, V>> ofNullable(Map<K, V> map) {
        return map == null ? empty() : of(map);
    }

    public static <T> Stream<T> ofNullable(Iterator<? extends T> iterator2) {
        return iterator2 == null ? empty() : of(iterator2);
    }

    public static <T> Stream<T> ofNullable(Iterable<? extends T> iterable) {
        return iterable == null ? empty() : of(iterable);
    }

    public static Stream<Integer> range(int from, int to) {
        return IntStream.range(from, to).boxed();
    }

    public static Stream<Long> range(long from, long to) {
        return LongStream.range(from, to).boxed();
    }

    public static Stream<Integer> rangeClosed(int from, int to) {
        return IntStream.rangeClosed(from, to).boxed();
    }

    public static Stream<Long> rangeClosed(long from, long to) {
        return LongStream.rangeClosed(from, to).boxed();
    }

    public static <T> Stream<T> generate(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return new Stream<>(new ObjGenerate(supplier));
    }

    public static <T> Stream<T> iterate(T seed, UnaryOperator<T> op) {
        Objects.requireNonNull(op);
        return new Stream<>(new ObjIterate(seed, op));
    }

    public static <T> Stream<T> iterate(T seed, Predicate<? super T> predicate, UnaryOperator<T> op) {
        Objects.requireNonNull(predicate);
        return iterate(seed, op).takeWhile(predicate);
    }

    public static <T> Stream<T> concat(Stream<? extends T> stream1, Stream<? extends T> stream2) {
        Objects.requireNonNull(stream1);
        Objects.requireNonNull(stream2);
        return new Stream<>(new ObjConcat(stream1.iterator, stream2.iterator)).onClose(Compose.closeables(stream1, stream2));
    }

    public static <T> Stream<T> concat(Iterator<? extends T> iterator1, Iterator<? extends T> iterator2) {
        Objects.requireNonNull(iterator1);
        Objects.requireNonNull(iterator2);
        return new Stream<>(new ObjConcat(iterator1, iterator2));
    }

    public static <F, S, R> Stream<R> zip(Stream<? extends F> stream1, Stream<? extends S> stream2, BiFunction<? super F, ? super S, ? extends R> combiner) {
        Objects.requireNonNull(stream1);
        Objects.requireNonNull(stream2);
        return zip(stream1.iterator, stream2.iterator, combiner);
    }

    public static <F, S, R> Stream<R> zip(Iterator<? extends F> iterator1, Iterator<? extends S> iterator2, BiFunction<? super F, ? super S, ? extends R> combiner) {
        Objects.requireNonNull(iterator1);
        Objects.requireNonNull(iterator2);
        return new Stream<>(new ObjZip(iterator1, iterator2, combiner));
    }

    public static <T> Stream<T> merge(Stream<? extends T> stream1, Stream<? extends T> stream2, BiFunction<? super T, ? super T, ObjMerge.MergeResult> selector) {
        Objects.requireNonNull(stream1);
        Objects.requireNonNull(stream2);
        return merge(stream1.iterator, stream2.iterator, selector);
    }

    public static <T> Stream<T> merge(Iterator<? extends T> iterator1, Iterator<? extends T> iterator2, BiFunction<? super T, ? super T, ObjMerge.MergeResult> selector) {
        Objects.requireNonNull(iterator1);
        Objects.requireNonNull(iterator2);
        return new Stream<>(new ObjMerge(iterator1, iterator2, selector));
    }

    private Stream(Iterator<? extends T> iterator2) {
        this((Params) null, iterator2);
    }

    private Stream(Iterable<? extends T> iterable) {
        this((Params) null, new LazyIterator(iterable));
    }

    private Stream(Params params2, Iterable<? extends T> iterable) {
        this(params2, new LazyIterator(iterable));
    }

    Stream(Params params2, Iterator<? extends T> iterator2) {
        this.params = params2;
        this.iterator = iterator2;
    }

    public Iterator<? extends T> iterator() {
        return this.iterator;
    }

    public <R> R custom(Function<Stream<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjFilter(this.iterator, predicate));
    }

    public Stream<T> filterIndexed(IndexedPredicate<? super T> predicate) {
        return filterIndexed(0, 1, predicate);
    }

    public Stream<T> filterIndexed(int from, int step, IndexedPredicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjFilterIndexed(new IndexedIterator(from, step, this.iterator), predicate));
    }

    public Stream<T> filterNot(Predicate<? super T> predicate) {
        return filter(Predicate.Util.negate(predicate));
    }

    public <TT> Stream<TT> select(final Class<TT> clazz) {
        return filter(new Predicate<T>() {
            public boolean test(T value) {
                return clazz.isInstance(value);
            }
        });
    }

    public Stream<T> withoutNulls() {
        return filter(Predicate.Util.notNull());
    }

    public Stream<T> nullsOnly() {
        return filterNot(Predicate.Util.notNull());
    }

    public Stream<T> equalsOnly(final T object) {
        return filter(new Predicate<T>() {
            public boolean test(T value) {
                return Objects.equals(value, object);
            }
        });
    }

    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return new Stream<>(this.params, new ObjMap(this.iterator, mapper));
    }

    public <R> Stream<R> mapIndexed(IndexedFunction<? super T, ? extends R> mapper) {
        return mapIndexed(0, 1, mapper);
    }

    public <R> Stream<R> mapIndexed(int from, int step, IndexedFunction<? super T, ? extends R> mapper) {
        return new Stream<>(this.params, new ObjMapIndexed(new IndexedIterator(from, step, this.iterator), mapper));
    }

    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return new IntStream(this.params, new ObjMapToInt(this.iterator, mapper));
    }

    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return new LongStream(this.params, new ObjMapToLong(this.iterator, mapper));
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return new DoubleStream(this.params, new ObjMapToDouble(this.iterator, mapper));
    }

    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new Stream<>(this.params, new ObjFlatMap(this.iterator, mapper));
    }

    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return new IntStream(this.params, new ObjFlatMapToInt(this.iterator, mapper));
    }

    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return new LongStream(this.params, new ObjFlatMapToLong(this.iterator, mapper));
    }

    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return new DoubleStream(this.params, new ObjFlatMapToDouble(this.iterator, mapper));
    }

    public Stream<IntPair<T>> indexed() {
        return indexed(0, 1);
    }

    public Stream<IntPair<T>> indexed(int from, int step) {
        return mapIndexed(from, step, new IndexedFunction<T, IntPair<T>>() {
            public IntPair<T> apply(int index, T t) {
                return new IntPair<>(index, t);
            }
        });
    }

    public Stream<T> distinct() {
        return new Stream<>(this.params, new ObjDistinct(this.iterator));
    }

    public <K> Stream<T> distinctBy(Function<? super T, ? extends K> classifier) {
        return new Stream<>(this.params, new ObjDistinctBy(this.iterator, classifier));
    }

    public Stream<T> sorted() {
        return sorted(new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((Comparable) o1).compareTo((Comparable) o2);
            }
        });
    }

    public Stream<T> sorted(Comparator<? super T> comparator) {
        return new Stream<>(this.params, new ObjSorted(this.iterator, comparator));
    }

    public <R extends Comparable<? super R>> Stream<T> sortBy(Function<? super T, ? extends R> f) {
        return sorted(ComparatorCompat.comparing(f));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.annimon.stream.function.Function<? super T, ? extends K>, com.annimon.stream.function.Function] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <K> com.annimon.stream.Stream<java.util.Map.Entry<K, java.util.List<T>>> groupBy(com.annimon.stream.function.Function<? super T, ? extends K> r5) {
        /*
            r4 = this;
            com.annimon.stream.Collector r0 = com.annimon.stream.Collectors.groupingBy(r5)
            java.lang.Object r0 = r4.collect(r0)
            java.util.Map r0 = (java.util.Map) r0
            com.annimon.stream.Stream r1 = new com.annimon.stream.Stream
            com.annimon.stream.internal.Params r2 = r4.params
            java.util.Set r3 = r0.entrySet()
            r1.<init>((com.annimon.stream.internal.Params) r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.annimon.stream.Stream.groupBy(com.annimon.stream.function.Function):com.annimon.stream.Stream");
    }

    public <K> Stream<List<T>> chunkBy(Function<? super T, ? extends K> classifier) {
        return new Stream<>(this.params, new ObjChunkBy(this.iterator, classifier));
    }

    public Stream<T> sample(int stepWidth) {
        if (stepWidth <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        } else if (stepWidth == 1) {
            return this;
        } else {
            return slidingWindow(1, stepWidth).map(new Function<List<T>, T>() {
                public T apply(List<T> list) {
                    return list.get(0);
                }
            });
        }
    }

    public Stream<List<T>> slidingWindow(int windowSize) {
        return slidingWindow(windowSize, 1);
    }

    public Stream<List<T>> slidingWindow(int windowSize, int stepWidth) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("windowSize cannot be zero or negative");
        } else if (stepWidth > 0) {
            return new Stream<>(this.params, new ObjSlidingWindow(this.iterator, windowSize, stepWidth));
        } else {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        }
    }

    public Stream<T> peek(Consumer<? super T> action) {
        return new Stream<>(this.params, new ObjPeek(this.iterator, action));
    }

    public Stream<T> scan(BiFunction<T, T, T> accumulator) {
        Objects.requireNonNull(accumulator);
        return new Stream<>(this.params, new ObjScan(this.iterator, accumulator));
    }

    public <R> Stream<R> scan(R identity, BiFunction<? super R, ? super T, ? extends R> accumulator) {
        Objects.requireNonNull(accumulator);
        return new Stream<>(this.params, new ObjScanIdentity(this.iterator, identity, accumulator));
    }

    public Stream<T> takeWhile(Predicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjTakeWhile(this.iterator, predicate));
    }

    public Stream<T> takeWhileIndexed(IndexedPredicate<? super T> predicate) {
        return takeWhileIndexed(0, 1, predicate);
    }

    public Stream<T> takeWhileIndexed(int from, int step, IndexedPredicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjTakeWhileIndexed(new IndexedIterator(from, step, this.iterator), predicate));
    }

    public Stream<T> takeUntil(Predicate<? super T> stopPredicate) {
        return new Stream<>(this.params, new ObjTakeUntil(this.iterator, stopPredicate));
    }

    public Stream<T> takeUntilIndexed(IndexedPredicate<? super T> stopPredicate) {
        return takeUntilIndexed(0, 1, stopPredicate);
    }

    public Stream<T> takeUntilIndexed(int from, int step, IndexedPredicate<? super T> stopPredicate) {
        return new Stream<>(this.params, new ObjTakeUntilIndexed(new IndexedIterator(from, step, this.iterator), stopPredicate));
    }

    public Stream<T> dropWhile(Predicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjDropWhile(this.iterator, predicate));
    }

    public Stream<T> dropWhileIndexed(IndexedPredicate<? super T> predicate) {
        return dropWhileIndexed(0, 1, predicate);
    }

    public Stream<T> dropWhileIndexed(int from, int step, IndexedPredicate<? super T> predicate) {
        return new Stream<>(this.params, new ObjDropWhileIndexed(new IndexedIterator(from, step, this.iterator), predicate));
    }

    public Stream<T> limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        } else if (maxSize == 0) {
            return empty();
        } else {
            return new Stream<>(this.params, new ObjLimit(this.iterator, maxSize));
        }
    }

    public Stream<T> skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        } else if (n == 0) {
            return this;
        } else {
            return new Stream<>(this.params, new ObjSkip(this.iterator, n));
        }
    }

    public void forEach(Consumer<? super T> action) {
        while (this.iterator.hasNext()) {
            action.accept(this.iterator.next());
        }
    }

    public void forEachIndexed(IndexedConsumer<? super T> action) {
        forEachIndexed(0, 1, action);
    }

    public void forEachIndexed(int from, int step, IndexedConsumer<? super T> action) {
        int index = from;
        while (this.iterator.hasNext()) {
            action.accept(index, this.iterator.next());
            index += step;
        }
    }

    public <R> R reduce(R identity, BiFunction<? super R, ? super T, ? extends R> accumulator) {
        R result = identity;
        while (this.iterator.hasNext()) {
            result = accumulator.apply(result, this.iterator.next());
        }
        return result;
    }

    public <R> R reduceIndexed(R identity, IndexedBiFunction<? super R, ? super T, ? extends R> accumulator) {
        return reduceIndexed(0, 1, identity, accumulator);
    }

    public <R> R reduceIndexed(int from, int step, R identity, IndexedBiFunction<? super R, ? super T, ? extends R> accumulator) {
        R result = identity;
        int index = from;
        while (this.iterator.hasNext()) {
            result = accumulator.apply(index, result, this.iterator.next());
            index += step;
        }
        return result;
    }

    public Optional<T> reduce(BiFunction<T, T, T> accumulator) {
        boolean foundAny = false;
        T result = null;
        while (this.iterator.hasNext()) {
            T value = this.iterator.next();
            if (!foundAny) {
                foundAny = true;
                result = value;
            } else {
                result = accumulator.apply(result, value);
            }
        }
        return foundAny ? Optional.of(result) : Optional.empty();
    }

    public Object[] toArray() {
        return toArray(new IntFunction<Object[]>() {
            public Object[] apply(int value) {
                return new Object[value];
            }
        });
    }

    public <R> R[] toArray(IntFunction<R[]> generator) {
        return Operators.toArray(this.iterator, generator);
    }

    public List<T> toList() {
        List<T> result = new ArrayList<>();
        while (this.iterator.hasNext()) {
            result.add(this.iterator.next());
        }
        return result;
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator) {
        R result = supplier.get();
        while (this.iterator.hasNext()) {
            accumulator.accept(result, this.iterator.next());
        }
        return result;
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        A container = collector.supplier().get();
        while (this.iterator.hasNext()) {
            collector.accumulator().accept(container, this.iterator.next());
        }
        if (collector.finisher() != null) {
            return collector.finisher().apply(container);
        }
        return Collectors.castIdentity().apply(container);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return reduce(BinaryOperator.Util.minBy(comparator));
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return reduce(BinaryOperator.Util.maxBy(comparator));
    }

    public long count() {
        long count = 0;
        while (this.iterator.hasNext()) {
            this.iterator.next();
            count++;
        }
        return count;
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return match(predicate, 0);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return match(predicate, 1);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return match(predicate, 2);
    }

    public Optional<IntPair<T>> findIndexed(IndexedPredicate<? super T> predicate) {
        return findIndexed(0, 1, predicate);
    }

    public Optional<IntPair<T>> findIndexed(int from, int step, IndexedPredicate<? super T> predicate) {
        int index = from;
        while (this.iterator.hasNext()) {
            T value = this.iterator.next();
            if (predicate.test(index, value)) {
                return Optional.of(new IntPair(index, value));
            }
            index += step;
        }
        return Optional.empty();
    }

    public Optional<T> findFirst() {
        if (this.iterator.hasNext()) {
            return Optional.of(this.iterator.next());
        }
        return Optional.empty();
    }

    public Optional<T> findLast() {
        return reduce(new BinaryOperator<T>() {
            public T apply(T t, T right) {
                return right;
            }
        });
    }

    public T single() {
        if (this.iterator.hasNext()) {
            T singleCandidate = this.iterator.next();
            if (!this.iterator.hasNext()) {
                return singleCandidate;
            }
            throw new IllegalStateException("Stream contains more than one element");
        }
        throw new NoSuchElementException("Stream contains no element");
    }

    public Optional<T> findSingle() {
        if (!this.iterator.hasNext()) {
            return Optional.empty();
        }
        T singleCandidate = this.iterator.next();
        if (!this.iterator.hasNext()) {
            return Optional.of(singleCandidate);
        }
        throw new IllegalStateException("Stream contains more than one element");
    }

    public Stream<T> onClose(Runnable closeHandler) {
        Params newParams;
        Objects.requireNonNull(closeHandler);
        if (this.params == null) {
            newParams = new Params();
            newParams.closeHandler = closeHandler;
        } else {
            newParams = this.params;
            newParams.closeHandler = Compose.runnables(newParams.closeHandler, closeHandler);
        }
        return new Stream<>(newParams, this.iterator);
    }

    public void close() {
        Params params2 = this.params;
        if (params2 != null && params2.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }

    private boolean match(Predicate<? super T> predicate, int matchKind) {
        boolean kindAny = matchKind == 0;
        boolean kindAll = matchKind == 1;
        while (this.iterator.hasNext()) {
            boolean match = predicate.test(this.iterator.next());
            if (match ^ kindAll) {
                if (!kindAny || !match) {
                    return false;
                }
                return true;
            }
        }
        if (!kindAny) {
            return true;
        }
        return false;
    }
}

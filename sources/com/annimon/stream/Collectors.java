package com.annimon.stream;

import com.annimon.stream.function.BiConsumer;
import com.annimon.stream.function.BinaryOperator;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.function.UnaryOperator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Collectors {
    private static final Supplier<double[]> DOUBLE_2ELEMENTS_ARRAY_SUPPLIER = new Supplier<double[]>() {
        public double[] get() {
            return new double[]{0.0d, 0.0d};
        }
    };
    private static final Supplier<long[]> LONG_2ELEMENTS_ARRAY_SUPPLIER = new Supplier<long[]>() {
        public long[] get() {
            return new long[]{0, 0};
        }
    };

    private Collectors() {
    }

    public static <T, R extends Collection<T>> Collector<T, ?, R> toCollection(Supplier<R> collectionSupplier) {
        return new CollectorsImpl(collectionSupplier, new BiConsumer<R, T>() {
            public void accept(R t, T u) {
                t.add(u);
            }
        });
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorsImpl(new Supplier<List<T>>() {
            public List<T> get() {
                return new ArrayList();
            }
        }, new BiConsumer<List<T>, T>() {
            public void accept(List<T> t, T u) {
                t.add(u);
            }
        });
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return collectingAndThen(toList(), new UnaryOperator<List<T>>() {
            public List<T> apply(List<T> list) {
                Objects.requireNonNullElements(list);
                return Collections.unmodifiableList(list);
            }
        });
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new CollectorsImpl(new Supplier<Set<T>>() {
            public Set<T> get() {
                return new HashSet();
            }
        }, new BiConsumer<Set<T>, T>() {
            public void accept(Set<T> set, T t) {
                set.add(t);
            }
        });
    }

    public static <T> Collector<T, ?, Set<T>> toUnmodifiableSet() {
        return collectingAndThen(toSet(), new UnaryOperator<Set<T>>() {
            public Set<T> apply(Set<T> set) {
                Objects.requireNonNullElements(set);
                return Collections.unmodifiableSet(set);
            }
        });
    }

    public static <T, K> Collector<T, ?, Map<K, T>> toMap(Function<? super T, ? extends K> keyMapper) {
        return toMap(keyMapper, UnaryOperator.Util.identity());
    }

    public static <T, K, V> Collector<T, ?, Map<K, V>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return toMap(keyMapper, valueMapper, hashMapSupplier());
    }

    public static <T, K, V, M extends Map<K, V>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends V> valueMapper, Supplier<M> mapFactory) {
        return new CollectorsImpl(mapFactory, new BiConsumer<M, T>() {
            public void accept(M map, T t) {
                K key = keyMapper.apply(t);
                V value = Objects.requireNonNull(valueMapper.apply(t));
                V oldValue = map.put(key, value);
                if (oldValue != null) {
                    map.put(key, oldValue);
                    throw Collectors.duplicateKeyException(key, oldValue, value);
                }
            }
        });
    }

    public static <T, K, V> Collector<T, ?, Map<K, V>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return collectingAndThen(toMap(keyMapper, valueMapper), toUnmodifiableMapConverter());
    }

    public static <T, K, V> Collector<T, ?, Map<K, V>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper, BinaryOperator<V> mergeFunction) {
        return toMap(keyMapper, valueMapper, mergeFunction, hashMapSupplier());
    }

    public static <T, K, V, M extends Map<K, V>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends V> valueMapper, final BinaryOperator<V> mergeFunction, Supplier<M> mapFactory) {
        return new CollectorsImpl(mapFactory, new BiConsumer<M, T>() {
            public void accept(M map, T t) {
                Collectors.mapMerge(map, keyMapper.apply(t), valueMapper.apply(t), mergeFunction);
            }
        });
    }

    public static <T, K, V> Collector<T, ?, Map<K, V>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper, BinaryOperator<V> mergeFunction) {
        return collectingAndThen(toMap(keyMapper, valueMapper, mergeFunction, hashMapSupplier()), toUnmodifiableMapConverter());
    }

    public static Collector<CharSequence, ?, String> joining() {
        return joining("");
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter) {
        return joining(delimiter, "", "");
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        return joining(delimiter, prefix, suffix, prefix.toString() + suffix.toString());
    }

    public static Collector<CharSequence, ?, String> joining(final CharSequence delimiter, final CharSequence prefix, final CharSequence suffix, final String emptyValue) {
        return new CollectorsImpl(new Supplier<StringBuilder>() {
            public StringBuilder get() {
                return new StringBuilder();
            }
        }, new BiConsumer<StringBuilder, CharSequence>() {
            public void accept(StringBuilder t, CharSequence u) {
                if (t.length() > 0) {
                    t.append(delimiter);
                } else {
                    t.append(prefix);
                }
                t.append(u);
            }
        }, new Function<StringBuilder, String>() {
            public String apply(StringBuilder value) {
                if (value.length() == 0) {
                    return emptyValue;
                }
                value.append(suffix);
                return value.toString();
            }
        });
    }

    @Deprecated
    public static <T> Collector<T, ?, Double> averaging(final Function<? super T, Double> mapper) {
        return averagingDouble(new ToDoubleFunction<T>() {
            public double applyAsDouble(T t) {
                return ((Double) mapper.apply(t)).doubleValue();
            }
        });
    }

    public static <T> Collector<T, ?, Double> averagingInt(final ToIntFunction<? super T> mapper) {
        return averagingHelper(new BiConsumer<long[], T>() {
            public void accept(long[] t, T u) {
                t[0] = t[0] + 1;
                t[1] = t[1] + ((long) mapper.applyAsInt(u));
            }
        });
    }

    public static <T> Collector<T, ?, Double> averagingLong(final ToLongFunction<? super T> mapper) {
        return averagingHelper(new BiConsumer<long[], T>() {
            public void accept(long[] t, T u) {
                t[0] = t[0] + 1;
                t[1] = t[1] + mapper.applyAsLong(u);
            }
        });
    }

    private static <T> Collector<T, ?, Double> averagingHelper(BiConsumer<long[], T> accumulator) {
        return new CollectorsImpl(LONG_2ELEMENTS_ARRAY_SUPPLIER, accumulator, new Function<long[], Double>() {
            public Double apply(long[] t) {
                if (t[0] == 0) {
                    return Double.valueOf(0.0d);
                }
                return Double.valueOf(((double) t[1]) / ((double) t[0]));
            }
        });
    }

    public static <T> Collector<T, ?, Double> averagingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorsImpl(DOUBLE_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<double[], T>() {
            public void accept(double[] t, T u) {
                t[0] = t[0] + 1.0d;
                t[1] = t[1] + mapper.applyAsDouble(u);
            }
        }, new Function<double[], Double>() {
            public Double apply(double[] t) {
                if (t[0] == 0.0d) {
                    return Double.valueOf(0.0d);
                }
                return Double.valueOf(t[1] / t[0]);
            }
        });
    }

    public static <T> Collector<T, ?, Integer> summingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorsImpl(new Supplier<int[]>() {
            public int[] get() {
                return new int[]{0};
            }
        }, new BiConsumer<int[], T>() {
            public void accept(int[] t, T u) {
                t[0] = t[0] + mapper.applyAsInt(u);
            }
        }, new Function<int[], Integer>() {
            public Integer apply(int[] value) {
                return Integer.valueOf(value[0]);
            }
        });
    }

    public static <T> Collector<T, ?, Long> summingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorsImpl(LONG_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<long[], T>() {
            public void accept(long[] t, T u) {
                t[0] = t[0] + mapper.applyAsLong(u);
            }
        }, new Function<long[], Long>() {
            public Long apply(long[] value) {
                return Long.valueOf(value[0]);
            }
        });
    }

    public static <T> Collector<T, ?, Double> summingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorsImpl(DOUBLE_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<double[], T>() {
            public void accept(double[] t, T u) {
                t[0] = t[0] + mapper.applyAsDouble(u);
            }
        }, new Function<double[], Double>() {
            public Double apply(double[] value) {
                return Double.valueOf(value[0]);
            }
        });
    }

    public static <T> Collector<T, ?, Long> counting() {
        return summingLong(new ToLongFunction<T>() {
            public long applyAsLong(T t) {
                return 1;
            }
        });
    }

    public static <T> Collector<T, ?, T> reducing(final T identity, final BinaryOperator<T> op) {
        return new CollectorsImpl(new Supplier<Tuple1<T>>() {
            public Tuple1<T> get() {
                return new Tuple1<>(identity);
            }
        }, new BiConsumer<Tuple1<T>, T>() {
            public void accept(Tuple1<T> tuple, T value) {
                tuple.a = op.apply(tuple.a, value);
            }
        }, new Function<Tuple1<T>, T>() {
            public T apply(Tuple1<T> tuple) {
                return tuple.a;
            }
        });
    }

    public static <T, R> Collector<T, ?, R> reducing(final R identity, final Function<? super T, ? extends R> mapper, final BinaryOperator<R> op) {
        return new CollectorsImpl(new Supplier<Tuple1<R>>() {
            public Tuple1<R> get() {
                return new Tuple1<>(identity);
            }
        }, new BiConsumer<Tuple1<R>, T>() {
            public void accept(Tuple1<R> tuple, T value) {
                tuple.a = op.apply(tuple.a, mapper.apply(value));
            }
        }, new Function<Tuple1<R>, R>() {
            public R apply(Tuple1<R> tuple) {
                return tuple.a;
            }
        });
    }

    public static <T, A, R> Collector<T, ?, R> filtering(final Predicate<? super T> predicate, Collector<? super T, A, R> downstream) {
        final BiConsumer<A, ? super T> accumulator = downstream.accumulator();
        return new CollectorsImpl(downstream.supplier(), new BiConsumer<A, T>() {
            public void accept(A a, T t) {
                if (predicate.test(t)) {
                    accumulator.accept(a, t);
                }
            }
        }, downstream.finisher());
    }

    public static <T, U, A, R> Collector<T, ?, R> mapping(final Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream) {
        final BiConsumer<A, ? super U> accumulator = downstream.accumulator();
        return new CollectorsImpl(downstream.supplier(), new BiConsumer<A, T>() {
            public void accept(A a, T t) {
                accumulator.accept(a, mapper.apply(t));
            }
        }, downstream.finisher());
    }

    public static <T, U, A, R> Collector<T, ?, R> flatMapping(final Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream) {
        final BiConsumer<A, ? super U> accumulator = downstream.accumulator();
        return new CollectorsImpl(downstream.supplier(), new BiConsumer<A, T>() {
            public void accept(final A a, T t) {
                Stream<? extends U> stream = (Stream) mapper.apply(t);
                if (stream != null) {
                    stream.forEach(new Consumer<U>() {
                        public void accept(U u) {
                            accumulator.accept(a, u);
                        }
                    });
                }
            }
        }, downstream.finisher());
    }

    public static <T, A, IR, OR> Collector<T, A, OR> collectingAndThen(Collector<T, A, IR> c, Function<IR, OR> finisher) {
        Function<A, IR> downstreamFinisher = c.finisher();
        if (downstreamFinisher == null) {
            downstreamFinisher = castIdentity();
        }
        return new CollectorsImpl(c.supplier(), c.accumulator(), Function.Util.andThen(downstreamFinisher, finisher));
    }

    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier) {
        return groupingBy(classifier, toList());
    }

    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream) {
        return groupingBy(classifier, hashMapSupplier(), downstream);
    }

    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(final Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, final Collector<? super T, A, D> downstream) {
        final Function<A, D> finisher = downstream.finisher();
        Function<Map<K, A>, M> finisher2 = null;
        if (finisher != null) {
            finisher2 = new Function<Map<K, A>, M>() {
                public M apply(Map<K, A> map) {
                    for (Map.Entry<K, A> entry : map.entrySet()) {
                        entry.setValue(finisher.apply(entry.getValue()));
                    }
                    return map;
                }
            };
        }
        return new CollectorsImpl(mapFactory, new BiConsumer<Map<K, A>, T>() {
            public void accept(Map<K, A> map, T t) {
                K key = Objects.requireNonNull(classifier.apply(t), "element cannot be mapped to a null key");
                A container = map.get(key);
                if (container == null) {
                    container = downstream.supplier().get();
                    map.put(key, container);
                }
                downstream.accumulator().accept(container, t);
            }
        }, finisher2);
    }

    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
        return partitioningBy(predicate, toList());
    }

    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(final Predicate<? super T> predicate, final Collector<? super T, A, D> downstream) {
        final BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        return new CollectorsImpl(new Supplier<Tuple2<A>>() {
            public Tuple2<A> get() {
                return new Tuple2<>(downstream.supplier().get(), downstream.supplier().get());
            }
        }, new BiConsumer<Tuple2<A>, T>() {
            public void accept(Tuple2<A> container, T t) {
                downstreamAccumulator.accept(predicate.test(t) ? container.a : container.b, t);
            }
        }, new Function<Tuple2<A>, Map<Boolean, D>>() {
            public Map<Boolean, D> apply(Tuple2<A> container) {
                Function<A, D> downstreamFinisher = downstream.finisher();
                Function<A, D> finisher = downstreamFinisher == null ? Collectors.castIdentity() : downstreamFinisher;
                Map<Boolean, D> result = new HashMap<>(2);
                result.put(Boolean.TRUE, finisher.apply(container.a));
                result.put(Boolean.FALSE, finisher.apply(container.b));
                return result;
            }
        });
    }

    private static <K, V> Supplier<Map<K, V>> hashMapSupplier() {
        return new Supplier<Map<K, V>>() {
            public Map<K, V> get() {
                return new HashMap();
            }
        };
    }

    /* access modifiers changed from: private */
    public static IllegalStateException duplicateKeyException(Object key, Object old, Object value) {
        return new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{key, old, value}));
    }

    /* access modifiers changed from: private */
    public static <K, V> void mapMerge(Map<K, V> map, K key, V value, BinaryOperator<V> merger) {
        V newValue;
        V oldValue = map.get(key);
        if (oldValue == null) {
            newValue = value;
        } else {
            newValue = merger.apply(oldValue, value);
        }
        if (newValue == null) {
            map.remove(key);
        } else {
            map.put(key, newValue);
        }
    }

    private static <K, V> UnaryOperator<Map<K, V>> toUnmodifiableMapConverter() {
        return new UnaryOperator<Map<K, V>>() {
            public Map<K, V> apply(Map<K, V> map) {
                Objects.requireNonNullElements(map.keySet());
                Objects.requireNonNullElements(map.values());
                return Collections.unmodifiableMap(map);
            }
        };
    }

    static <A, R> Function<A, R> castIdentity() {
        return new Function<A, R>() {
            /* JADX WARNING: type inference failed for: r1v0, types: [A, R] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public R apply(A r1) {
                /*
                    r0 = this;
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.annimon.stream.Collectors.AnonymousClass45.apply(java.lang.Object):java.lang.Object");
            }
        };
    }

    private static final class Tuple1<A> {
        A a;

        Tuple1(A a2) {
            this.a = a2;
        }
    }

    private static final class Tuple2<A> {
        final A a;
        final A b;

        Tuple2(A a2, A b2) {
            this.a = a2;
            this.b = b2;
        }
    }

    private static final class CollectorsImpl<T, A, R> implements Collector<T, A, R> {
        private final BiConsumer<A, T> accumulator;
        private final Function<A, R> finisher;
        private final Supplier<A> supplier;

        public CollectorsImpl(Supplier<A> supplier2, BiConsumer<A, T> accumulator2) {
            this(supplier2, accumulator2, (Function) null);
        }

        public CollectorsImpl(Supplier<A> supplier2, BiConsumer<A, T> accumulator2, Function<A, R> finisher2) {
            this.supplier = supplier2;
            this.accumulator = accumulator2;
            this.finisher = finisher2;
        }

        public Supplier<A> supplier() {
            return this.supplier;
        }

        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        public Function<A, R> finisher() {
            return this.finisher;
        }
    }
}

package androidx.paging;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PagedList<T> extends AbstractList<T> {
    final Executor mBackgroundThreadExecutor;
    final BoundaryCallback<T> mBoundaryCallback;
    boolean mBoundaryCallbackBeginDeferred = false;
    boolean mBoundaryCallbackEndDeferred = false;
    private final ArrayList<WeakReference<Callback>> mCallbacks = new ArrayList<>();
    final Config mConfig;
    private final AtomicBoolean mDetached = new AtomicBoolean(false);
    private int mHighestIndexAccessed = Integer.MIN_VALUE;
    T mLastItem = null;
    int mLastLoad = 0;
    private int mLowestIndexAccessed = Integer.MAX_VALUE;
    final Executor mMainThreadExecutor;
    final int mRequiredRemainder;
    final PagedStorage<T> mStorage;

    public static abstract class Callback {
        public abstract void onChanged(int i, int i2);

        public abstract void onInserted(int i, int i2);

        public abstract void onRemoved(int i, int i2);
    }

    /* access modifiers changed from: package-private */
    public abstract void dispatchUpdatesSinceSnapshot(PagedList<T> pagedList, Callback callback);

    public abstract DataSource<?, T> getDataSource();

    public abstract Object getLastKey();

    /* access modifiers changed from: package-private */
    public abstract boolean isContiguous();

    /* access modifiers changed from: package-private */
    public abstract void loadAroundInternal(int i);

    PagedList(PagedStorage<T> storage, Executor mainThreadExecutor, Executor backgroundThreadExecutor, BoundaryCallback<T> boundaryCallback, Config config) {
        this.mStorage = storage;
        this.mMainThreadExecutor = mainThreadExecutor;
        this.mBackgroundThreadExecutor = backgroundThreadExecutor;
        this.mBoundaryCallback = boundaryCallback;
        this.mConfig = config;
        this.mRequiredRemainder = (config.prefetchDistance * 2) + this.mConfig.pageSize;
    }

    static <K, T> PagedList<T> create(DataSource<K, T> dataSource, Executor notifyExecutor, Executor fetchExecutor, BoundaryCallback<T> boundaryCallback, Config config, K key) {
        int lastLoad;
        DataSource<K, T> dataSource2;
        int i;
        if (dataSource.isContiguous()) {
            Config config2 = config;
        } else if (config.enablePlaceholders) {
            PositionalDataSource positionalDataSource = (PositionalDataSource) dataSource;
            if (key != null) {
                i = ((Integer) key).intValue();
            } else {
                i = 0;
            }
            return new TiledPagedList(positionalDataSource, notifyExecutor, fetchExecutor, boundaryCallback, config, i);
        }
        if (!dataSource.isContiguous()) {
            DataSource<K, T> wrapAsContiguousWithoutPlaceholders = ((PositionalDataSource) dataSource).wrapAsContiguousWithoutPlaceholders();
            if (key != null) {
                lastLoad = ((Integer) key).intValue();
                dataSource2 = wrapAsContiguousWithoutPlaceholders;
            } else {
                lastLoad = -1;
                dataSource2 = wrapAsContiguousWithoutPlaceholders;
            }
        } else {
            dataSource2 = dataSource;
            lastLoad = -1;
        }
        return new ContiguousPagedList((ContiguousDataSource) dataSource2, notifyExecutor, fetchExecutor, boundaryCallback, config, key, lastLoad);
    }

    public static final class Builder<Key, Value> {
        private BoundaryCallback mBoundaryCallback;
        private final Config mConfig;
        private final DataSource<Key, Value> mDataSource;
        private Executor mFetchExecutor;
        private Key mInitialKey;
        private Executor mNotifyExecutor;

        public Builder(DataSource<Key, Value> dataSource, Config config) {
            if (dataSource == null) {
                throw new IllegalArgumentException("DataSource may not be null");
            } else if (config != null) {
                this.mDataSource = dataSource;
                this.mConfig = config;
            } else {
                throw new IllegalArgumentException("Config may not be null");
            }
        }

        public Builder(DataSource<Key, Value> dataSource, int pageSize) {
            this(dataSource, new Config.Builder().setPageSize(pageSize).build());
        }

        public Builder<Key, Value> setNotifyExecutor(Executor notifyExecutor) {
            this.mNotifyExecutor = notifyExecutor;
            return this;
        }

        public Builder<Key, Value> setFetchExecutor(Executor fetchExecutor) {
            this.mFetchExecutor = fetchExecutor;
            return this;
        }

        public Builder<Key, Value> setBoundaryCallback(BoundaryCallback boundaryCallback) {
            this.mBoundaryCallback = boundaryCallback;
            return this;
        }

        public Builder<Key, Value> setInitialKey(Key initialKey) {
            this.mInitialKey = initialKey;
            return this;
        }

        public PagedList<Value> build() {
            Executor executor = this.mNotifyExecutor;
            if (executor != null) {
                Executor executor2 = this.mFetchExecutor;
                if (executor2 != null) {
                    return PagedList.create(this.mDataSource, executor, executor2, this.mBoundaryCallback, this.mConfig, this.mInitialKey);
                }
                throw new IllegalArgumentException("BackgroundThreadExecutor required");
            }
            throw new IllegalArgumentException("MainThreadExecutor required");
        }
    }

    public T get(int index) {
        T item = this.mStorage.get(index);
        if (item != null) {
            this.mLastItem = item;
        }
        return item;
    }

    public void loadAround(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        this.mLastLoad = getPositionOffset() + index;
        loadAroundInternal(index);
        this.mLowestIndexAccessed = Math.min(this.mLowestIndexAccessed, index);
        this.mHighestIndexAccessed = Math.max(this.mHighestIndexAccessed, index);
        tryDispatchBoundaryCallbacks(true);
    }

    /* access modifiers changed from: package-private */
    public void deferBoundaryCallbacks(final boolean deferEmpty, final boolean deferBegin, final boolean deferEnd) {
        if (this.mBoundaryCallback != null) {
            if (this.mLowestIndexAccessed == Integer.MAX_VALUE) {
                this.mLowestIndexAccessed = this.mStorage.size();
            }
            if (this.mHighestIndexAccessed == Integer.MIN_VALUE) {
                this.mHighestIndexAccessed = 0;
            }
            if (deferEmpty || deferBegin || deferEnd) {
                this.mMainThreadExecutor.execute(new Runnable() {
                    public void run() {
                        if (deferEmpty) {
                            PagedList.this.mBoundaryCallback.onZeroItemsLoaded();
                        }
                        if (deferBegin) {
                            PagedList.this.mBoundaryCallbackBeginDeferred = true;
                        }
                        if (deferEnd) {
                            PagedList.this.mBoundaryCallbackEndDeferred = true;
                        }
                        PagedList.this.tryDispatchBoundaryCallbacks(false);
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
    }

    /* access modifiers changed from: package-private */
    public void tryDispatchBoundaryCallbacks(boolean post) {
        final boolean dispatchEnd = true;
        final boolean dispatchBegin = this.mBoundaryCallbackBeginDeferred && this.mLowestIndexAccessed <= this.mConfig.prefetchDistance;
        if (!this.mBoundaryCallbackEndDeferred || this.mHighestIndexAccessed < (size() - 1) - this.mConfig.prefetchDistance) {
            dispatchEnd = false;
        }
        if (dispatchBegin || dispatchEnd) {
            if (dispatchBegin) {
                this.mBoundaryCallbackBeginDeferred = false;
            }
            if (dispatchEnd) {
                this.mBoundaryCallbackEndDeferred = false;
            }
            if (post) {
                this.mMainThreadExecutor.execute(new Runnable() {
                    public void run() {
                        PagedList.this.dispatchBoundaryCallbacks(dispatchBegin, dispatchEnd);
                    }
                });
            } else {
                dispatchBoundaryCallbacks(dispatchBegin, dispatchEnd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchBoundaryCallbacks(boolean begin, boolean end) {
        if (begin) {
            this.mBoundaryCallback.onItemAtFrontLoaded(this.mStorage.getFirstLoadedItem());
        }
        if (end) {
            this.mBoundaryCallback.onItemAtEndLoaded(this.mStorage.getLastLoadedItem());
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetAccessIndices(int offset) {
        this.mLastLoad += offset;
        this.mLowestIndexAccessed += offset;
        this.mHighestIndexAccessed += offset;
    }

    public int size() {
        return this.mStorage.size();
    }

    public int getLoadedCount() {
        return this.mStorage.getLoadedCount();
    }

    public boolean isImmutable() {
        return isDetached();
    }

    public List<T> snapshot() {
        if (isImmutable()) {
            return this;
        }
        return new SnapshotPagedList(this);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public boolean isDetached() {
        return this.mDetached.get();
    }

    public void detach() {
        this.mDetached.set(true);
    }

    public int getPositionOffset() {
        return this.mStorage.getPositionOffset();
    }

    public void addWeakCallback(List<T> previousSnapshot, Callback callback) {
        if (!(previousSnapshot == null || previousSnapshot == this)) {
            if (!previousSnapshot.isEmpty()) {
                dispatchUpdatesSinceSnapshot((PagedList) previousSnapshot, callback);
            } else if (!this.mStorage.isEmpty()) {
                callback.onInserted(0, this.mStorage.size());
            }
        }
        for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
            if (((Callback) this.mCallbacks.get(i).get()) == null) {
                this.mCallbacks.remove(i);
            }
        }
        this.mCallbacks.add(new WeakReference(callback));
    }

    public void removeWeakCallback(Callback callback) {
        for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
            Callback currentCallback = (Callback) this.mCallbacks.get(i).get();
            if (currentCallback == null || currentCallback == callback) {
                this.mCallbacks.remove(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyInserted(int position, int count) {
        if (count != 0) {
            for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
                Callback callback = (Callback) this.mCallbacks.get(i).get();
                if (callback != null) {
                    callback.onInserted(position, count);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyChanged(int position, int count) {
        if (count != 0) {
            for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
                Callback callback = (Callback) this.mCallbacks.get(i).get();
                if (callback != null) {
                    callback.onChanged(position, count);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyRemoved(int position, int count) {
        if (count != 0) {
            for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
                Callback callback = (Callback) this.mCallbacks.get(i).get();
                if (callback != null) {
                    callback.onRemoved(position, count);
                }
            }
        }
    }

    public static class Config {
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int maxSize;
        public final int pageSize;
        public final int prefetchDistance;

        Config(int pageSize2, int prefetchDistance2, boolean enablePlaceholders2, int initialLoadSizeHint2, int maxSize2) {
            this.pageSize = pageSize2;
            this.prefetchDistance = prefetchDistance2;
            this.enablePlaceholders = enablePlaceholders2;
            this.initialLoadSizeHint = initialLoadSizeHint2;
            this.maxSize = maxSize2;
        }

        public static final class Builder {
            static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private boolean mEnablePlaceholders = true;
            private int mInitialLoadSizeHint = -1;
            private int mMaxSize = Integer.MAX_VALUE;
            private int mPageSize = -1;
            private int mPrefetchDistance = -1;

            public Builder setPageSize(int pageSize) {
                if (pageSize >= 1) {
                    this.mPageSize = pageSize;
                    return this;
                }
                throw new IllegalArgumentException("Page size must be a positive number");
            }

            public Builder setPrefetchDistance(int prefetchDistance) {
                this.mPrefetchDistance = prefetchDistance;
                return this;
            }

            public Builder setEnablePlaceholders(boolean enablePlaceholders) {
                this.mEnablePlaceholders = enablePlaceholders;
                return this;
            }

            public Builder setInitialLoadSizeHint(int initialLoadSizeHint) {
                this.mInitialLoadSizeHint = initialLoadSizeHint;
                return this;
            }

            public Builder setMaxSize(int maxSize) {
                this.mMaxSize = maxSize;
                return this;
            }

            public Config build() {
                if (this.mPrefetchDistance < 0) {
                    this.mPrefetchDistance = this.mPageSize;
                }
                if (this.mInitialLoadSizeHint < 0) {
                    this.mInitialLoadSizeHint = this.mPageSize * 3;
                }
                if (this.mEnablePlaceholders || this.mPrefetchDistance != 0) {
                    int i = this.mMaxSize;
                    if (i == Integer.MAX_VALUE || i >= this.mPageSize + (this.mPrefetchDistance * 2)) {
                        return new Config(this.mPageSize, this.mPrefetchDistance, this.mEnablePlaceholders, this.mInitialLoadSizeHint, this.mMaxSize);
                    }
                    throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.mPageSize + ", prefetchDist=" + this.mPrefetchDistance + ", maxSize=" + this.mMaxSize);
                }
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }
        }
    }

    public static abstract class BoundaryCallback<T> {
        public void onZeroItemsLoaded() {
        }

        public void onItemAtFrontLoaded(T t) {
        }

        public void onItemAtEndLoaded(T t) {
        }
    }
}

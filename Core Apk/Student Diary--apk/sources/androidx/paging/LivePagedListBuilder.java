package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import java.util.concurrent.Executor;

public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback mBoundaryCallback;
    private PagedList.Config mConfig;
    private DataSource.Factory<Key, Value> mDataSourceFactory;
    private Executor mFetchExecutor;
    private Key mInitialLoadKey;

    public LivePagedListBuilder(DataSource.Factory<Key, Value> dataSourceFactory, PagedList.Config config) {
        this.mFetchExecutor = ArchTaskExecutor.getIOThreadExecutor();
        if (config == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        } else if (dataSourceFactory != null) {
            this.mDataSourceFactory = dataSourceFactory;
            this.mConfig = config;
        } else {
            throw new IllegalArgumentException("DataSource.Factory must be provided");
        }
    }

    public LivePagedListBuilder(DataSource.Factory<Key, Value> dataSourceFactory, int pageSize) {
        this(dataSourceFactory, new PagedList.Config.Builder().setPageSize(pageSize).build());
    }

    public LivePagedListBuilder<Key, Value> setInitialLoadKey(Key key) {
        this.mInitialLoadKey = key;
        return this;
    }

    public LivePagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.mBoundaryCallback = boundaryCallback;
        return this;
    }

    public LivePagedListBuilder<Key, Value> setFetchExecutor(Executor fetchExecutor) {
        this.mFetchExecutor = fetchExecutor;
        return this;
    }

    public LiveData<PagedList<Value>> build() {
        return create(this.mInitialLoadKey, this.mConfig, this.mBoundaryCallback, this.mDataSourceFactory, ArchTaskExecutor.getMainThreadExecutor(), this.mFetchExecutor);
    }

    private static <Key, Value> LiveData<PagedList<Value>> create(Key initialLoadKey, PagedList.Config config, PagedList.BoundaryCallback boundaryCallback, DataSource.Factory<Key, Value> dataSourceFactory, Executor notifyExecutor, Executor fetchExecutor) {
        final Key key = initialLoadKey;
        final DataSource.Factory<Key, Value> factory = dataSourceFactory;
        final PagedList.Config config2 = config;
        final Executor executor = notifyExecutor;
        final Executor executor2 = fetchExecutor;
        final PagedList.BoundaryCallback boundaryCallback2 = boundaryCallback;
        return new ComputableLiveData<PagedList<Value>>(fetchExecutor) {
            private final DataSource.InvalidatedCallback mCallback = new DataSource.InvalidatedCallback() {
                public void onInvalidated() {
                    AnonymousClass1.this.invalidate();
                }
            };
            private DataSource<Key, Value> mDataSource;
            private PagedList<Value> mList;

            /* access modifiers changed from: protected */
            public PagedList<Value> compute() {
                PagedList<Value> build;
                Key initializeKey = key;
                PagedList<Value> pagedList = this.mList;
                if (pagedList != null) {
                    initializeKey = pagedList.getLastKey();
                }
                do {
                    DataSource<Key, Value> dataSource = this.mDataSource;
                    if (dataSource != null) {
                        dataSource.removeInvalidatedCallback(this.mCallback);
                    }
                    DataSource<Key, Value> create = factory.create();
                    this.mDataSource = create;
                    create.addInvalidatedCallback(this.mCallback);
                    build = new PagedList.Builder(this.mDataSource, config2).setNotifyExecutor(executor).setFetchExecutor(executor2).setBoundaryCallback(boundaryCallback2).setInitialKey(initializeKey).build();
                    this.mList = build;
                } while (build.isDetached());
                return this.mList;
            }
        }.getLiveData();
    }
}

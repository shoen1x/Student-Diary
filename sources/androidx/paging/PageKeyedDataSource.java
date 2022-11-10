package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageResult;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class PageKeyedDataSource<Key, Value> extends ContiguousDataSource<Key, Value> {
    private final Object mKeyLock = new Object();
    private Key mNextKey = null;
    private Key mPreviousKey = null;

    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(List<Value> list, Key key);
    }

    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(List<Value> list, int i, int i2, Key key, Key key2);

        public abstract void onResult(List<Value> list, Key key, Key key2);
    }

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Key, Value> loadInitialCallback);

    /* access modifiers changed from: package-private */
    public void initKeys(Key previousKey, Key nextKey) {
        synchronized (this.mKeyLock) {
            this.mPreviousKey = previousKey;
            this.mNextKey = nextKey;
        }
    }

    /* access modifiers changed from: package-private */
    public void setPreviousKey(Key previousKey) {
        synchronized (this.mKeyLock) {
            this.mPreviousKey = previousKey;
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextKey(Key nextKey) {
        synchronized (this.mKeyLock) {
            this.mNextKey = nextKey;
        }
    }

    private Key getPreviousKey() {
        Key key;
        synchronized (this.mKeyLock) {
            key = this.mPreviousKey;
        }
        return key;
    }

    private Key getNextKey() {
        Key key;
        synchronized (this.mKeyLock) {
            key = this.mNextKey;
        }
        return key;
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int requestedLoadSize2, boolean placeholdersEnabled2) {
            this.requestedLoadSize = requestedLoadSize2;
            this.placeholdersEnabled = placeholdersEnabled2;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key2, int requestedLoadSize2) {
            this.key = key2;
            this.requestedLoadSize = requestedLoadSize2;
        }
    }

    static class LoadInitialCallbackImpl<Key, Value> extends LoadInitialCallback<Key, Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final boolean mCountingEnabled;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        LoadInitialCallbackImpl(PageKeyedDataSource<Key, Value> dataSource, boolean countingEnabled, PageResult.Receiver<Value> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, 0, (Executor) null, receiver);
            this.mDataSource = dataSource;
            this.mCountingEnabled = countingEnabled;
        }

        public void onResult(List<Value> data, int position, int totalCount, Key previousPageKey, Key nextPageKey) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                DataSource.LoadCallbackHelper.validateInitialLoadParams(data, position, totalCount);
                this.mDataSource.initKeys(previousPageKey, nextPageKey);
                int trailingUnloadedCount = (totalCount - position) - data.size();
                if (this.mCountingEnabled) {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position, trailingUnloadedCount, 0));
                } else {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position));
                }
            }
        }

        public void onResult(List<Value> data, Key previousPageKey, Key nextPageKey) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                this.mDataSource.initKeys(previousPageKey, nextPageKey);
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, 0, 0, 0));
            }
        }
    }

    static class LoadCallbackImpl<Key, Value> extends LoadCallback<Key, Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        LoadCallbackImpl(PageKeyedDataSource<Key, Value> dataSource, int type, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, type, mainThreadExecutor, receiver);
            this.mDataSource = dataSource;
        }

        public void onResult(List<Value> data, Key adjacentPageKey) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                if (this.mCallbackHelper.mResultType == 1) {
                    this.mDataSource.setNextKey(adjacentPageKey);
                } else {
                    this.mDataSource.setPreviousKey(adjacentPageKey);
                }
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, 0, 0, 0));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Key getKey(int position, Value value) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsPageDropping() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadInitial(Key key, int initialLoadSize, int pageSize, boolean enablePlaceholders, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        LoadInitialCallbackImpl<Key, Value> callback = new LoadInitialCallbackImpl<>(this, enablePlaceholders, receiver);
        loadInitial(new LoadInitialParams(initialLoadSize, enablePlaceholders), callback);
        callback.mCallbackHelper.setPostExecutor(mainThreadExecutor);
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadAfter(int currentEndIndex, Value value, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        Key key = getNextKey();
        if (key != null) {
            loadAfter(new LoadParams(key, pageSize), new LoadCallbackImpl(this, 1, mainThreadExecutor, receiver));
        } else {
            receiver.onPageResult(1, PageResult.getEmptyResult());
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadBefore(int currentBeginIndex, Value value, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        Key key = getPreviousKey();
        if (key != null) {
            loadBefore(new LoadParams(key, pageSize), new LoadCallbackImpl(this, 2, mainThreadExecutor, receiver));
        } else {
            receiver.onPageResult(2, PageResult.getEmptyResult());
        }
    }

    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        return new WrapperPageKeyedDataSource(this, function);
    }

    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(Function<Value, ToValue> function) {
        return mapByPage((Function) createListFunction(function));
    }
}

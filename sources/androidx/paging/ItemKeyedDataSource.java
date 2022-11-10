package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageResult;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class ItemKeyedDataSource<Key, Value> extends ContiguousDataSource<Key, Value> {

    public static abstract class LoadCallback<Value> {
        public abstract void onResult(List<Value> list);
    }

    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(List<Value> list, int i, int i2);
    }

    public abstract Key getKey(Value value);

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Value> loadInitialCallback);

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(Key requestedInitialKey2, int requestedLoadSize2, boolean placeholdersEnabled2) {
            this.requestedInitialKey = requestedInitialKey2;
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

    static class LoadInitialCallbackImpl<Value> extends LoadInitialCallback<Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;
        private final boolean mCountingEnabled;

        LoadInitialCallbackImpl(ItemKeyedDataSource dataSource, boolean countingEnabled, PageResult.Receiver<Value> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, 0, (Executor) null, receiver);
            this.mCountingEnabled = countingEnabled;
        }

        public void onResult(List<Value> data, int position, int totalCount) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                DataSource.LoadCallbackHelper.validateInitialLoadParams(data, position, totalCount);
                int trailingUnloadedCount = (totalCount - position) - data.size();
                if (this.mCountingEnabled) {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position, trailingUnloadedCount, 0));
                } else {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position));
                }
            }
        }

        public void onResult(List<Value> data) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, 0, 0, 0));
            }
        }
    }

    static class LoadCallbackImpl<Value> extends LoadCallback<Value> {
        final DataSource.LoadCallbackHelper<Value> mCallbackHelper;

        LoadCallbackImpl(ItemKeyedDataSource dataSource, int type, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, type, mainThreadExecutor, receiver);
        }

        public void onResult(List<Value> data) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, 0, 0, 0));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Key getKey(int position, Value item) {
        if (item == null) {
            return null;
        }
        return getKey(item);
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadInitial(Key key, int initialLoadSize, int pageSize, boolean enablePlaceholders, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        LoadInitialCallbackImpl<Value> callback = new LoadInitialCallbackImpl<>(this, enablePlaceholders, receiver);
        loadInitial(new LoadInitialParams(key, initialLoadSize, enablePlaceholders), callback);
        callback.mCallbackHelper.setPostExecutor(mainThreadExecutor);
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadAfter(int currentEndIndex, Value currentEndItem, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        loadAfter(new LoadParams(getKey(currentEndItem), pageSize), new LoadCallbackImpl(this, 1, mainThreadExecutor, receiver));
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadBefore(int currentBeginIndex, Value currentBeginItem, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
        loadBefore(new LoadParams(getKey(currentBeginItem), pageSize), new LoadCallbackImpl(this, 2, mainThreadExecutor, receiver));
    }

    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        return new WrapperItemKeyedDataSource(this, function);
    }

    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(Function<Value, ToValue> function) {
        return mapByPage((Function) createListFunction(function));
    }
}

package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageResult;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(List<T> list, int i);

        public abstract void onResult(List<T> list, int i, int i2);
    }

    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(List<T> list);
    }

    public abstract void loadInitial(LoadInitialParams loadInitialParams, LoadInitialCallback<T> loadInitialCallback);

    public abstract void loadRange(LoadRangeParams loadRangeParams, LoadRangeCallback<T> loadRangeCallback);

    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int requestedStartPosition2, int requestedLoadSize2, int pageSize2, boolean placeholdersEnabled2) {
            this.requestedStartPosition = requestedStartPosition2;
            this.requestedLoadSize = requestedLoadSize2;
            this.pageSize = pageSize2;
            this.placeholdersEnabled = placeholdersEnabled2;
        }
    }

    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int startPosition2, int loadSize2) {
            this.startPosition = startPosition2;
            this.loadSize = loadSize2;
        }
    }

    static class LoadInitialCallbackImpl<T> extends LoadInitialCallback<T> {
        final DataSource.LoadCallbackHelper<T> mCallbackHelper;
        private final boolean mCountingEnabled;
        private final int mPageSize;

        LoadInitialCallbackImpl(PositionalDataSource dataSource, boolean countingEnabled, int pageSize, PageResult.Receiver<T> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, 0, (Executor) null, receiver);
            this.mCountingEnabled = countingEnabled;
            this.mPageSize = pageSize;
            if (pageSize < 1) {
                throw new IllegalArgumentException("Page size must be non-negative");
            }
        }

        public void onResult(List<T> data, int position, int totalCount) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                DataSource.LoadCallbackHelper.validateInitialLoadParams(data, position, totalCount);
                if (data.size() + position != totalCount && data.size() % this.mPageSize != 0) {
                    throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + data.size() + ", position " + position + ", totalCount " + totalCount + ", pageSize " + this.mPageSize);
                } else if (this.mCountingEnabled) {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position, (totalCount - position) - data.size(), 0));
                } else {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position));
                }
            }
        }

        public void onResult(List<T> data, int position) {
            if (this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                return;
            }
            if (position < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (data.isEmpty() && position != 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            } else if (!this.mCountingEnabled) {
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, position));
            } else {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
        }
    }

    static class LoadRangeCallbackImpl<T> extends LoadRangeCallback<T> {
        private DataSource.LoadCallbackHelper<T> mCallbackHelper;
        private final int mPositionOffset;

        LoadRangeCallbackImpl(PositionalDataSource dataSource, int resultType, int positionOffset, Executor mainThreadExecutor, PageResult.Receiver<T> receiver) {
            this.mCallbackHelper = new DataSource.LoadCallbackHelper<>(dataSource, resultType, mainThreadExecutor, receiver);
            this.mPositionOffset = positionOffset;
        }

        public void onResult(List<T> data) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(data, 0, 0, this.mPositionOffset));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadInitial(boolean acceptCount, int requestedStartPosition, int requestedLoadSize, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<T> receiver) {
        LoadInitialCallbackImpl<T> callback = new LoadInitialCallbackImpl<>(this, acceptCount, pageSize, receiver);
        loadInitial(new LoadInitialParams(requestedStartPosition, requestedLoadSize, pageSize, acceptCount), callback);
        callback.mCallbackHelper.setPostExecutor(mainThreadExecutor);
    }

    /* access modifiers changed from: package-private */
    public final void dispatchLoadRange(int resultType, int startPosition, int count, Executor mainThreadExecutor, PageResult.Receiver<T> receiver) {
        LoadRangeCallback<T> callback = new LoadRangeCallbackImpl<>(this, resultType, startPosition, mainThreadExecutor, receiver);
        if (count == 0) {
            callback.onResult(Collections.emptyList());
        } else {
            loadRange(new LoadRangeParams(startPosition, count), callback);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public ContiguousDataSource<Integer, T> wrapAsContiguousWithoutPlaceholders() {
        return new ContiguousWithoutPlaceholdersWrapper(this);
    }

    public static int computeInitialLoadPosition(LoadInitialParams params, int totalCount) {
        int position = params.requestedStartPosition;
        int initialLoadSize = params.requestedLoadSize;
        int pageSize = params.pageSize;
        return Math.max(0, Math.min(((((totalCount - initialLoadSize) + pageSize) - 1) / pageSize) * pageSize, (position / pageSize) * pageSize));
    }

    public static int computeInitialLoadSize(LoadInitialParams params, int initialLoadPosition, int totalCount) {
        return Math.min(totalCount - initialLoadPosition, params.requestedLoadSize);
    }

    static class ContiguousWithoutPlaceholdersWrapper<Value> extends ContiguousDataSource<Integer, Value> {
        final PositionalDataSource<Value> mSource;

        ContiguousWithoutPlaceholdersWrapper(PositionalDataSource<Value> source) {
            this.mSource = source;
        }

        public void addInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
            this.mSource.addInvalidatedCallback(onInvalidatedCallback);
        }

        public void removeInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
            this.mSource.removeInvalidatedCallback(onInvalidatedCallback);
        }

        public void invalidate() {
            this.mSource.invalidate();
        }

        public boolean isInvalid() {
            return this.mSource.isInvalid();
        }

        public <ToValue> DataSource<Integer, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        public <ToValue> DataSource<Integer, ToValue> map(Function<Value, ToValue> function) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        /* access modifiers changed from: package-private */
        public void dispatchLoadInitial(Integer position, int initialLoadSize, int pageSize, boolean enablePlaceholders, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
            Integer position2;
            if (position == null) {
                position2 = 0;
            } else {
                initialLoadSize = Math.max(initialLoadSize / pageSize, 2) * pageSize;
                position2 = Integer.valueOf(Math.max(0, ((position.intValue() - (initialLoadSize / 2)) / pageSize) * pageSize));
            }
            this.mSource.dispatchLoadInitial(false, position2.intValue(), initialLoadSize, pageSize, mainThreadExecutor, receiver);
        }

        /* access modifiers changed from: package-private */
        public void dispatchLoadAfter(int currentEndIndex, Value value, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
            this.mSource.dispatchLoadRange(1, currentEndIndex + 1, pageSize, mainThreadExecutor, receiver);
        }

        /* access modifiers changed from: package-private */
        public void dispatchLoadBefore(int currentBeginIndex, Value value, int pageSize, Executor mainThreadExecutor, PageResult.Receiver<Value> receiver) {
            int startIndex = currentBeginIndex - 1;
            if (startIndex < 0) {
                this.mSource.dispatchLoadRange(2, startIndex, 0, mainThreadExecutor, receiver);
                int i = pageSize;
                return;
            }
            int loadSize = Math.min(pageSize, startIndex + 1);
            this.mSource.dispatchLoadRange(2, (startIndex - loadSize) + 1, loadSize, mainThreadExecutor, receiver);
        }

        /* access modifiers changed from: package-private */
        public Integer getKey(int position, Value value) {
            return Integer.valueOf(position);
        }
    }

    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> function) {
        return new WrapperPositionalDataSource(this, function);
    }

    public final <V> PositionalDataSource<V> map(Function<T, V> function) {
        return mapByPage((Function) createListFunction(function));
    }
}

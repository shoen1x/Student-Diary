package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import java.util.List;

class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {
    final Function<List<A>, List<B>> mListFunction;
    private final PageKeyedDataSource<K, A> mSource;

    WrapperPageKeyedDataSource(PageKeyedDataSource<K, A> source, Function<List<A>, List<B>> listFunction) {
        this.mSource = source;
        this.mListFunction = listFunction;
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

    public void loadInitial(PageKeyedDataSource.LoadInitialParams<K> params, final PageKeyedDataSource.LoadInitialCallback<K, B> callback) {
        this.mSource.loadInitial(params, new PageKeyedDataSource.LoadInitialCallback<K, A>() {
            public void onResult(List<A> data, int position, int totalCount, K previousPageKey, K nextPageKey) {
                callback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, data), position, totalCount, previousPageKey, nextPageKey);
            }

            public void onResult(List<A> data, K previousPageKey, K nextPageKey) {
                callback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, data), previousPageKey, nextPageKey);
            }
        });
    }

    public void loadBefore(PageKeyedDataSource.LoadParams<K> params, final PageKeyedDataSource.LoadCallback<K, B> callback) {
        this.mSource.loadBefore(params, new PageKeyedDataSource.LoadCallback<K, A>() {
            public void onResult(List<A> data, K adjacentPageKey) {
                callback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, data), adjacentPageKey);
            }
        });
    }

    public void loadAfter(PageKeyedDataSource.LoadParams<K> params, final PageKeyedDataSource.LoadCallback<K, B> callback) {
        this.mSource.loadAfter(params, new PageKeyedDataSource.LoadCallback<K, A>() {
            public void onResult(List<A> data, K adjacentPageKey) {
                callback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, data), adjacentPageKey);
            }
        });
    }
}

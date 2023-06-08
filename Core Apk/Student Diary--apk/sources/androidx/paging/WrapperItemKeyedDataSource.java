package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import java.util.IdentityHashMap;
import java.util.List;

class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    private final IdentityHashMap<B, K> mKeyMap = new IdentityHashMap<>();
    final Function<List<A>, List<B>> mListFunction;
    private final ItemKeyedDataSource<K, A> mSource;

    WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> source, Function<List<A>, List<B>> listFunction) {
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

    /* access modifiers changed from: package-private */
    public List<B> convertWithStashedKeys(List<A> source) {
        List<B> dest = convert(this.mListFunction, source);
        synchronized (this.mKeyMap) {
            for (int i = 0; i < dest.size(); i++) {
                this.mKeyMap.put(dest.get(i), this.mSource.getKey(source.get(i)));
            }
        }
        return dest;
    }

    public void loadInitial(ItemKeyedDataSource.LoadInitialParams<K> params, final ItemKeyedDataSource.LoadInitialCallback<B> callback) {
        this.mSource.loadInitial(params, new ItemKeyedDataSource.LoadInitialCallback<A>() {
            public void onResult(List<A> data, int position, int totalCount) {
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data), position, totalCount);
            }

            public void onResult(List<A> data) {
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    public void loadAfter(ItemKeyedDataSource.LoadParams<K> params, final ItemKeyedDataSource.LoadCallback<B> callback) {
        this.mSource.loadAfter(params, new ItemKeyedDataSource.LoadCallback<A>() {
            public void onResult(List<A> data) {
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    public void loadBefore(ItemKeyedDataSource.LoadParams<K> params, final ItemKeyedDataSource.LoadCallback<B> callback) {
        this.mSource.loadBefore(params, new ItemKeyedDataSource.LoadCallback<A>() {
            public void onResult(List<A> data) {
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    public K getKey(B item) {
        K k;
        synchronized (this.mKeyMap) {
            k = this.mKeyMap.get(item);
        }
        return k;
    }
}

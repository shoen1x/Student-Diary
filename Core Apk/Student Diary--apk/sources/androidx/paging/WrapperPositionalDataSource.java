package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;

class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    final Function<List<A>, List<B>> mListFunction;
    private final PositionalDataSource<A> mSource;

    WrapperPositionalDataSource(PositionalDataSource<A> source, Function<List<A>, List<B>> listFunction) {
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

    public void loadInitial(PositionalDataSource.LoadInitialParams params, final PositionalDataSource.LoadInitialCallback<B> callback) {
        this.mSource.loadInitial(params, new PositionalDataSource.LoadInitialCallback<A>() {
            public void onResult(List<A> data, int position, int totalCount) {
                callback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, data), position, totalCount);
            }

            public void onResult(List<A> data, int position) {
                callback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, data), position);
            }
        });
    }

    public void loadRange(PositionalDataSource.LoadRangeParams params, final PositionalDataSource.LoadRangeCallback<B> callback) {
        this.mSource.loadRange(params, new PositionalDataSource.LoadRangeCallback<A>() {
            public void onResult(List<A> data) {
                callback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, data));
            }
        });
    }
}

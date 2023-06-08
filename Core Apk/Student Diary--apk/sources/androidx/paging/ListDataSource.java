package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.ArrayList;
import java.util.List;

class ListDataSource<T> extends PositionalDataSource<T> {
    private final List<T> mList;

    public ListDataSource(List<T> list) {
        this.mList = new ArrayList(list);
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams params, PositionalDataSource.LoadInitialCallback<T> callback) {
        int totalCount = this.mList.size();
        int position = computeInitialLoadPosition(params, totalCount);
        callback.onResult(this.mList.subList(position, position + computeInitialLoadSize(params, position, totalCount)), position, totalCount);
    }

    public void loadRange(PositionalDataSource.LoadRangeParams params, PositionalDataSource.LoadRangeCallback<T> callback) {
        callback.onResult(this.mList.subList(params.startPosition, params.startPosition + params.loadSize));
    }
}

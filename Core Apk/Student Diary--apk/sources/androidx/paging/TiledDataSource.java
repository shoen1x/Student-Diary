package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.Collections;
import java.util.List;

@Deprecated
public abstract class TiledDataSource<T> extends PositionalDataSource<T> {
    public abstract int countItems();

    public abstract List<T> loadRange(int i, int i2);

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return false;
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams params, PositionalDataSource.LoadInitialCallback<T> callback) {
        int totalCount = countItems();
        if (totalCount == 0) {
            callback.onResult(Collections.emptyList(), 0, 0);
            return;
        }
        int firstLoadPosition = computeInitialLoadPosition(params, totalCount);
        int firstLoadSize = computeInitialLoadSize(params, firstLoadPosition, totalCount);
        List<T> list = loadRange(firstLoadPosition, firstLoadSize);
        if (list == null || list.size() != firstLoadSize) {
            invalidate();
        } else {
            callback.onResult(list, firstLoadPosition, totalCount);
        }
    }

    public void loadRange(PositionalDataSource.LoadRangeParams params, PositionalDataSource.LoadRangeCallback<T> callback) {
        List<T> list = loadRange(params.startPosition, params.loadSize);
        if (list != null) {
            callback.onResult(list);
        } else {
            invalidate();
        }
    }
}

package androidx.paging;

import androidx.paging.PageResult;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import java.util.List;
import java.util.concurrent.Executor;

class TiledPagedList<T> extends PagedList<T> implements PagedStorage.Callback {
    final PositionalDataSource<T> mDataSource;
    PageResult.Receiver<T> mReceiver = new PageResult.Receiver<T>() {
        public void onPageResult(int type, PageResult<T> pageResult) {
            if (pageResult.isInvalid()) {
                TiledPagedList.this.detach();
            } else if (!TiledPagedList.this.isDetached()) {
                if (type == 0 || type == 3) {
                    List<T> page = pageResult.page;
                    if (TiledPagedList.this.mStorage.getPageCount() == 0) {
                        TiledPagedList.this.mStorage.initAndSplit(pageResult.leadingNulls, page, pageResult.trailingNulls, pageResult.positionOffset, TiledPagedList.this.mConfig.pageSize, TiledPagedList.this);
                    } else {
                        TiledPagedList.this.mStorage.tryInsertPageAndTrim(pageResult.positionOffset, page, TiledPagedList.this.mLastLoad, TiledPagedList.this.mConfig.maxSize, TiledPagedList.this.mRequiredRemainder, TiledPagedList.this);
                    }
                    if (TiledPagedList.this.mBoundaryCallback != null) {
                        boolean deferEnd = true;
                        boolean deferEmpty = TiledPagedList.this.mStorage.size() == 0;
                        boolean deferBegin = !deferEmpty && pageResult.leadingNulls == 0 && pageResult.positionOffset == 0;
                        int size = TiledPagedList.this.size();
                        if (deferEmpty || (!(type == 0 && pageResult.trailingNulls == 0) && (type != 3 || pageResult.positionOffset + TiledPagedList.this.mConfig.pageSize < size))) {
                            deferEnd = false;
                        }
                        TiledPagedList.this.deferBoundaryCallbacks(deferEmpty, deferBegin, deferEnd);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("unexpected resultType" + type);
            }
        }
    };

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TiledPagedList(PositionalDataSource<T> dataSource, Executor mainThreadExecutor, Executor backgroundThreadExecutor, PagedList.BoundaryCallback<T> boundaryCallback, PagedList.Config config, int position) {
        super(new PagedStorage(), mainThreadExecutor, backgroundThreadExecutor, boundaryCallback, config);
        int i = position;
        this.mDataSource = dataSource;
        int pageSize = this.mConfig.pageSize;
        this.mLastLoad = i;
        if (this.mDataSource.isInvalid()) {
            detach();
            return;
        }
        int firstLoadSize = Math.max(this.mConfig.initialLoadSizeHint / pageSize, 2) * pageSize;
        this.mDataSource.dispatchLoadInitial(true, Math.max(0, ((i - (firstLoadSize / 2)) / pageSize) * pageSize), firstLoadSize, pageSize, this.mMainThreadExecutor, this.mReceiver);
    }

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return false;
    }

    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return Integer.valueOf(this.mLastLoad);
    }

    /* access modifiers changed from: protected */
    public void dispatchUpdatesSinceSnapshot(PagedList<T> pagedListSnapshot, PagedList.Callback callback) {
        PagedStorage<T> snapshot = pagedListSnapshot.mStorage;
        if (snapshot.isEmpty() || this.mStorage.size() != snapshot.size()) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        int pageSize = this.mConfig.pageSize;
        int leadingNullPages = this.mStorage.getLeadingNullCount() / pageSize;
        int pageCount = this.mStorage.getPageCount();
        int i = 0;
        while (i < pageCount) {
            int pageIndex = i + leadingNullPages;
            int updatedPages = 0;
            while (updatedPages < this.mStorage.getPageCount() && this.mStorage.hasPage(pageSize, pageIndex + updatedPages) && !snapshot.hasPage(pageSize, pageIndex + updatedPages)) {
                updatedPages++;
            }
            if (updatedPages > 0) {
                callback.onChanged(pageIndex * pageSize, pageSize * updatedPages);
                i += updatedPages - 1;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public void loadAroundInternal(int index) {
        this.mStorage.allocatePlaceholders(index, this.mConfig.prefetchDistance, this.mConfig.pageSize, this);
    }

    public void onInitialized(int count) {
        notifyInserted(0, count);
    }

    public void onPagePrepended(int leadingNulls, int changed, int added) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPageAppended(int endPosition, int changed, int added) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onEmptyPrepend() {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onEmptyAppend() {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPagePlaceholderInserted(final int pageIndex) {
        this.mBackgroundThreadExecutor.execute(new Runnable() {
            public void run() {
                if (!TiledPagedList.this.isDetached()) {
                    int pageSize = TiledPagedList.this.mConfig.pageSize;
                    if (TiledPagedList.this.mDataSource.isInvalid()) {
                        TiledPagedList.this.detach();
                        return;
                    }
                    int startPosition = pageIndex * pageSize;
                    int count = Math.min(pageSize, TiledPagedList.this.mStorage.size() - startPosition);
                    TiledPagedList.this.mDataSource.dispatchLoadRange(3, startPosition, count, TiledPagedList.this.mMainThreadExecutor, TiledPagedList.this.mReceiver);
                }
            }
        });
    }

    public void onPageInserted(int start, int count) {
        notifyChanged(start, count);
    }

    public void onPagesRemoved(int startOfDrops, int count) {
        notifyRemoved(startOfDrops, count);
    }

    public void onPagesSwappedToPlaceholder(int startOfDrops, int count) {
        notifyChanged(startOfDrops, count);
    }
}

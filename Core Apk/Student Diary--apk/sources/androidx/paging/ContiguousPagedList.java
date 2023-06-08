package androidx.paging;

import androidx.paging.PageResult;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.concurrent.Executor;

class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback {
    private static final int DONE_FETCHING = 2;
    private static final int FETCHING = 1;
    static final int LAST_LOAD_UNSPECIFIED = -1;
    private static final int READY_TO_FETCH = 0;
    int mAppendItemsRequested = 0;
    int mAppendWorkerState = 0;
    final ContiguousDataSource<K, V> mDataSource;
    int mPrependItemsRequested = 0;
    int mPrependWorkerState = 0;
    PageResult.Receiver<V> mReceiver = new PageResult.Receiver<V>() {
        public void onPageResult(int resultType, PageResult<V> pageResult) {
            if (pageResult.isInvalid()) {
                ContiguousPagedList.this.detach();
            } else if (!ContiguousPagedList.this.isDetached()) {
                List<T> list = pageResult.page;
                boolean deferEnd = true;
                if (resultType == 0) {
                    ContiguousPagedList.this.mStorage.init(pageResult.leadingNulls, list, pageResult.trailingNulls, pageResult.positionOffset, ContiguousPagedList.this);
                    if (ContiguousPagedList.this.mLastLoad == -1) {
                        ContiguousPagedList.this.mLastLoad = pageResult.leadingNulls + pageResult.positionOffset + (list.size() / 2);
                    }
                } else {
                    boolean trimFromFront = ContiguousPagedList.this.mLastLoad > ContiguousPagedList.this.mStorage.getMiddleOfLoadedRange();
                    boolean skipNewPage = ContiguousPagedList.this.mShouldTrim && ContiguousPagedList.this.mStorage.shouldPreTrimNewPage(ContiguousPagedList.this.mConfig.maxSize, ContiguousPagedList.this.mRequiredRemainder, list.size());
                    if (resultType == 1) {
                        if (!skipNewPage || trimFromFront) {
                            ContiguousPagedList.this.mStorage.appendPage(list, ContiguousPagedList.this);
                        } else {
                            ContiguousPagedList.this.mAppendItemsRequested = 0;
                            ContiguousPagedList.this.mAppendWorkerState = 0;
                        }
                    } else if (resultType != 2) {
                        throw new IllegalArgumentException("unexpected resultType " + resultType);
                    } else if (!skipNewPage || !trimFromFront) {
                        ContiguousPagedList.this.mStorage.prependPage(list, ContiguousPagedList.this);
                    } else {
                        ContiguousPagedList.this.mPrependItemsRequested = 0;
                        ContiguousPagedList.this.mPrependWorkerState = 0;
                    }
                    if (ContiguousPagedList.this.mShouldTrim) {
                        if (trimFromFront) {
                            if (ContiguousPagedList.this.mPrependWorkerState != 1 && ContiguousPagedList.this.mStorage.trimFromFront(ContiguousPagedList.this.mReplacePagesWithNulls, ContiguousPagedList.this.mConfig.maxSize, ContiguousPagedList.this.mRequiredRemainder, ContiguousPagedList.this)) {
                                ContiguousPagedList.this.mPrependWorkerState = 0;
                            }
                        } else if (ContiguousPagedList.this.mAppendWorkerState != 1 && ContiguousPagedList.this.mStorage.trimFromEnd(ContiguousPagedList.this.mReplacePagesWithNulls, ContiguousPagedList.this.mConfig.maxSize, ContiguousPagedList.this.mRequiredRemainder, ContiguousPagedList.this)) {
                            ContiguousPagedList.this.mAppendWorkerState = 0;
                        }
                    }
                }
                if (ContiguousPagedList.this.mBoundaryCallback != null) {
                    boolean deferEmpty = ContiguousPagedList.this.mStorage.size() == 0;
                    boolean deferBegin = !deferEmpty && resultType == 2 && pageResult.page.size() == 0;
                    if (!(!deferEmpty && resultType == 1 && pageResult.page.size() == 0)) {
                        deferEnd = false;
                    }
                    ContiguousPagedList.this.deferBoundaryCallbacks(deferEmpty, deferBegin, deferEnd);
                }
            }
        }
    };
    boolean mReplacePagesWithNulls = false;
    final boolean mShouldTrim;

    @Retention(RetentionPolicy.SOURCE)
    @interface FetchState {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContiguousPagedList(ContiguousDataSource<K, V> dataSource, Executor mainThreadExecutor, Executor backgroundThreadExecutor, PagedList.BoundaryCallback<V> boundaryCallback, PagedList.Config config, K key, int lastLoad) {
        super(new PagedStorage(), mainThreadExecutor, backgroundThreadExecutor, boundaryCallback, config);
        boolean z = false;
        this.mDataSource = dataSource;
        this.mLastLoad = lastLoad;
        if (this.mDataSource.isInvalid()) {
            detach();
        } else {
            this.mDataSource.dispatchLoadInitial(key, this.mConfig.initialLoadSizeHint, this.mConfig.pageSize, this.mConfig.enablePlaceholders, this.mMainThreadExecutor, this.mReceiver);
        }
        if (this.mDataSource.supportsPageDropping() && this.mConfig.maxSize != Integer.MAX_VALUE) {
            z = true;
        }
        this.mShouldTrim = z;
    }

    /* access modifiers changed from: package-private */
    public void dispatchUpdatesSinceSnapshot(PagedList<V> pagedListSnapshot, PagedList.Callback callback) {
        PagedStorage<T> pagedStorage = pagedListSnapshot.mStorage;
        int newlyAppended = this.mStorage.getNumberAppended() - pagedStorage.getNumberAppended();
        int newlyPrepended = this.mStorage.getNumberPrepended() - pagedStorage.getNumberPrepended();
        int previousTrailing = pagedStorage.getTrailingNullCount();
        int previousLeading = pagedStorage.getLeadingNullCount();
        if (pagedStorage.isEmpty() || newlyAppended < 0 || newlyPrepended < 0 || this.mStorage.getTrailingNullCount() != Math.max(previousTrailing - newlyAppended, 0) || this.mStorage.getLeadingNullCount() != Math.max(previousLeading - newlyPrepended, 0) || this.mStorage.getStorageCount() != pagedStorage.getStorageCount() + newlyAppended + newlyPrepended) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (newlyAppended != 0) {
            int changedCount = Math.min(previousTrailing, newlyAppended);
            int addedCount = newlyAppended - changedCount;
            int endPosition = pagedStorage.getLeadingNullCount() + pagedStorage.getStorageCount();
            if (changedCount != 0) {
                callback.onChanged(endPosition, changedCount);
            }
            if (addedCount != 0) {
                callback.onInserted(endPosition + changedCount, addedCount);
            }
        }
        if (newlyPrepended != 0) {
            int changedCount2 = Math.min(previousLeading, newlyPrepended);
            int addedCount2 = newlyPrepended - changedCount2;
            if (changedCount2 != 0) {
                callback.onChanged(previousLeading, changedCount2);
            }
            if (addedCount2 != 0) {
                callback.onInserted(0, addedCount2);
            }
        }
    }

    static int getPrependItemsRequested(int prefetchDistance, int index, int leadingNulls) {
        return prefetchDistance - (index - leadingNulls);
    }

    static int getAppendItemsRequested(int prefetchDistance, int index, int itemsBeforeTrailingNulls) {
        return ((index + prefetchDistance) + 1) - itemsBeforeTrailingNulls;
    }

    /* access modifiers changed from: protected */
    public void loadAroundInternal(int index) {
        int prependItems = getPrependItemsRequested(this.mConfig.prefetchDistance, index, this.mStorage.getLeadingNullCount());
        int appendItems = getAppendItemsRequested(this.mConfig.prefetchDistance, index, this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount());
        int max = Math.max(prependItems, this.mPrependItemsRequested);
        this.mPrependItemsRequested = max;
        if (max > 0) {
            schedulePrepend();
        }
        int max2 = Math.max(appendItems, this.mAppendItemsRequested);
        this.mAppendItemsRequested = max2;
        if (max2 > 0) {
            scheduleAppend();
        }
    }

    private void schedulePrepend() {
        if (this.mPrependWorkerState == 0) {
            this.mPrependWorkerState = 1;
            final int position = this.mStorage.getLeadingNullCount() + this.mStorage.getPositionOffset();
            final V item = this.mStorage.getFirstLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousPagedList.this.mDataSource.dispatchLoadBefore(position, item, ContiguousPagedList.this.mConfig.pageSize, ContiguousPagedList.this.mMainThreadExecutor, ContiguousPagedList.this.mReceiver);
                        }
                    }
                }
            });
        }
    }

    private void scheduleAppend() {
        if (this.mAppendWorkerState == 0) {
            this.mAppendWorkerState = 1;
            final int position = ((this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount()) - 1) + this.mStorage.getPositionOffset();
            final V item = this.mStorage.getLastLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousPagedList.this.mDataSource.dispatchLoadAfter(position, item, ContiguousPagedList.this.mConfig.pageSize, ContiguousPagedList.this.mMainThreadExecutor, ContiguousPagedList.this.mReceiver);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return true;
    }

    public DataSource<?, V> getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return this.mDataSource.getKey(this.mLastLoad, this.mLastItem);
    }

    public void onInitialized(int count) {
        boolean z = false;
        notifyInserted(0, count);
        if (this.mStorage.getLeadingNullCount() > 0 || this.mStorage.getTrailingNullCount() > 0) {
            z = true;
        }
        this.mReplacePagesWithNulls = z;
    }

    public void onPagePrepended(int leadingNulls, int changedCount, int addedCount) {
        int i = (this.mPrependItemsRequested - changedCount) - addedCount;
        this.mPrependItemsRequested = i;
        this.mPrependWorkerState = 0;
        if (i > 0) {
            schedulePrepend();
        }
        notifyChanged(leadingNulls, changedCount);
        notifyInserted(0, addedCount);
        offsetAccessIndices(addedCount);
    }

    public void onEmptyPrepend() {
        this.mPrependWorkerState = 2;
    }

    public void onPageAppended(int endPosition, int changedCount, int addedCount) {
        int i = (this.mAppendItemsRequested - changedCount) - addedCount;
        this.mAppendItemsRequested = i;
        this.mAppendWorkerState = 0;
        if (i > 0) {
            scheduleAppend();
        }
        notifyChanged(endPosition, changedCount);
        notifyInserted(endPosition + changedCount, addedCount);
    }

    public void onEmptyAppend() {
        this.mAppendWorkerState = 2;
    }

    public void onPagePlaceholderInserted(int pageIndex) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    public void onPageInserted(int start, int count) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    public void onPagesRemoved(int startOfDrops, int count) {
        notifyRemoved(startOfDrops, count);
    }

    public void onPagesSwappedToPlaceholder(int startOfDrops, int count) {
        notifyChanged(startOfDrops, count);
    }
}

package androidx.paging;

import androidx.paging.PagedList;

class SnapshotPagedList<T> extends PagedList<T> {
    private final boolean mContiguous;
    private final DataSource<?, T> mDataSource;
    private final Object mLastKey;

    SnapshotPagedList(PagedList<T> pagedList) {
        super(pagedList.mStorage.snapshot(), pagedList.mMainThreadExecutor, pagedList.mBackgroundThreadExecutor, (PagedList.BoundaryCallback) null, pagedList.mConfig);
        this.mDataSource = pagedList.getDataSource();
        this.mContiguous = pagedList.isContiguous();
        this.mLastLoad = pagedList.mLastLoad;
        this.mLastKey = pagedList.getLastKey();
    }

    public boolean isImmutable() {
        return true;
    }

    public boolean isDetached() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return this.mContiguous;
    }

    public Object getLastKey() {
        return this.mLastKey;
    }

    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    /* access modifiers changed from: package-private */
    public void dispatchUpdatesSinceSnapshot(PagedList<T> pagedList, PagedList.Callback callback) {
    }

    /* access modifiers changed from: package-private */
    public void loadAroundInternal(int index) {
    }
}

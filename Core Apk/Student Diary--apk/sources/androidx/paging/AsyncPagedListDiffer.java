package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncPagedListDiffer<T> {
    final AsyncDifferConfig<T> mConfig;
    private boolean mIsContiguous;
    private final List<PagedListListener<T>> mListeners = new CopyOnWriteArrayList();
    Executor mMainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
    int mMaxScheduledGeneration;
    private PagedList<T> mPagedList;
    private PagedList.Callback mPagedListCallback = new PagedList.Callback() {
        public void onInserted(int position, int count) {
            AsyncPagedListDiffer.this.mUpdateCallback.onInserted(position, count);
        }

        public void onRemoved(int position, int count) {
            AsyncPagedListDiffer.this.mUpdateCallback.onRemoved(position, count);
        }

        public void onChanged(int position, int count) {
            AsyncPagedListDiffer.this.mUpdateCallback.onChanged(position, count, (Object) null);
        }
    };
    private PagedList<T> mSnapshot;
    final ListUpdateCallback mUpdateCallback;

    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2);
    }

    public AsyncPagedListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> diffCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new AsyncDifferConfig.Builder(diffCallback).build();
    }

    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> config) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = config;
    }

    public T getItem(int index) {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList == null) {
            PagedList<T> pagedList2 = this.mSnapshot;
            if (pagedList2 != null) {
                return pagedList2.get(index);
            }
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList.loadAround(index);
        return this.mPagedList.get(index);
    }

    public int getItemCount() {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList != null) {
            return pagedList.size();
        }
        PagedList<T> pagedList2 = this.mSnapshot;
        if (pagedList2 == null) {
            return 0;
        }
        return pagedList2.size();
    }

    public void submitList(PagedList<T> pagedList) {
        submitList(pagedList, (Runnable) null);
    }

    public void submitList(PagedList<T> pagedList, Runnable commitCallback) {
        if (pagedList != null) {
            if (this.mPagedList == null && this.mSnapshot == null) {
                this.mIsContiguous = pagedList.isContiguous();
            } else if (pagedList.isContiguous() != this.mIsContiguous) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        final int runGeneration = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = runGeneration;
        PagedList<T> previous = this.mPagedList;
        if (pagedList != previous) {
            PagedList<T> pagedList2 = this.mSnapshot;
            if (pagedList2 != null) {
                previous = pagedList2;
            }
            if (pagedList == null) {
                int removedCount = getItemCount();
                PagedList<T> pagedList3 = this.mPagedList;
                if (pagedList3 != null) {
                    pagedList3.removeWeakCallback(this.mPagedListCallback);
                    this.mPagedList = null;
                } else if (this.mSnapshot != null) {
                    this.mSnapshot = null;
                }
                this.mUpdateCallback.onRemoved(0, removedCount);
                onCurrentListChanged(previous, (PagedList<T>) null, commitCallback);
            } else if (this.mPagedList == null && this.mSnapshot == null) {
                this.mPagedList = pagedList;
                pagedList.addWeakCallback((List<T>) null, this.mPagedListCallback);
                this.mUpdateCallback.onInserted(0, pagedList.size());
                onCurrentListChanged((PagedList) null, pagedList, commitCallback);
            } else {
                PagedList<T> pagedList4 = this.mPagedList;
                if (pagedList4 != null) {
                    pagedList4.removeWeakCallback(this.mPagedListCallback);
                    this.mSnapshot = (PagedList) this.mPagedList.snapshot();
                    this.mPagedList = null;
                }
                if (this.mSnapshot == null || this.mPagedList != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                final PagedList<T> pagedList5 = this.mSnapshot;
                final PagedList<T> pagedList6 = (PagedList) pagedList.snapshot();
                final PagedList<T> pagedList7 = pagedList;
                final Runnable runnable = commitCallback;
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult result = PagedStorageDiffHelper.computeDiff(pagedList5.mStorage, pagedList6.mStorage, AsyncPagedListDiffer.this.mConfig.getDiffCallback());
                        AsyncPagedListDiffer.this.mMainThreadExecutor.execute(new Runnable() {
                            public void run() {
                                if (AsyncPagedListDiffer.this.mMaxScheduledGeneration == runGeneration) {
                                    AsyncPagedListDiffer.this.latchPagedList(pagedList7, pagedList6, result, pagedList5.mLastLoad, runnable);
                                }
                            }
                        });
                    }
                });
            }
        } else if (commitCallback != null) {
            commitCallback.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void latchPagedList(PagedList<T> newList, PagedList<T> diffSnapshot, DiffUtil.DiffResult diffResult, int lastAccessIndex, Runnable commitCallback) {
        if (this.mSnapshot == null || this.mPagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        PagedList<T> previousSnapshot = this.mSnapshot;
        this.mPagedList = newList;
        this.mSnapshot = null;
        PagedStorageDiffHelper.dispatchDiff(this.mUpdateCallback, previousSnapshot.mStorage, newList.mStorage, diffResult);
        newList.addWeakCallback(diffSnapshot, this.mPagedListCallback);
        if (!this.mPagedList.isEmpty()) {
            int newPosition = PagedStorageDiffHelper.transformAnchorIndex(diffResult, previousSnapshot.mStorage, diffSnapshot.mStorage, lastAccessIndex);
            PagedList<T> pagedList = this.mPagedList;
            pagedList.loadAround(Math.max(0, Math.min(pagedList.size() - 1, newPosition)));
        }
        onCurrentListChanged(previousSnapshot, this.mPagedList, commitCallback);
    }

    private void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList, Runnable commitCallback) {
        for (PagedListListener<T> listener : this.mListeners) {
            listener.onCurrentListChanged(previousList, currentList);
        }
        if (commitCallback != null) {
            commitCallback.run();
        }
    }

    public void addPagedListListener(PagedListListener<T> listener) {
        this.mListeners.add(listener);
    }

    public void removePagedListListener(PagedListListener<T> listener) {
        this.mListeners.remove(listener);
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.mSnapshot;
        if (pagedList != null) {
            return pagedList;
        }
        return this.mPagedList;
    }
}

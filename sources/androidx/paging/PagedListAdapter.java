package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncPagedListDiffer<T> mDiffer;
    private final AsyncPagedListDiffer.PagedListListener<T> mListener = new AsyncPagedListDiffer.PagedListListener<T>() {
        public void onCurrentListChanged(PagedList<T> previousList, PagedList<T> currentList) {
            PagedListAdapter.this.onCurrentListChanged(currentList);
            PagedListAdapter.this.onCurrentListChanged(previousList, currentList);
        }
    };

    protected PagedListAdapter(DiffUtil.ItemCallback<T> diffCallback) {
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>((RecyclerView.Adapter) this, diffCallback);
        this.mDiffer = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(this.mListener);
    }

    protected PagedListAdapter(AsyncDifferConfig<T> config) {
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), config);
        this.mDiffer = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(this.mListener);
    }

    public void submitList(PagedList<T> pagedList) {
        this.mDiffer.submitList(pagedList);
    }

    public void submitList(PagedList<T> pagedList, Runnable commitCallback) {
        this.mDiffer.submitList(pagedList, commitCallback);
    }

    /* access modifiers changed from: protected */
    public T getItem(int position) {
        return this.mDiffer.getItem(position);
    }

    public int getItemCount() {
        return this.mDiffer.getItemCount();
    }

    public PagedList<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    @Deprecated
    public void onCurrentListChanged(PagedList<T> pagedList) {
    }

    public void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2) {
    }
}

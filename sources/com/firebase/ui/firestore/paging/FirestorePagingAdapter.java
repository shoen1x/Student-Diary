package com.firebase.ui.firestore.paging;

import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.firebase.firestore.DocumentSnapshot;

public abstract class FirestorePagingAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<DocumentSnapshot, VH> implements LifecycleObserver {
    private static final String TAG = "FirestorePagingAdapter";
    private final Observer<PagedList<DocumentSnapshot>> mDataObserver = new Observer<PagedList<DocumentSnapshot>>() {
        public void onChanged(PagedList<DocumentSnapshot> snapshots) {
            if (snapshots != null) {
                FirestorePagingAdapter.this.submitList(snapshots);
            }
        }
    };
    private final LiveData<FirestoreDataSource> mDataSource;
    private final LiveData<LoadingState> mLoadingState;
    private final SnapshotParser<T> mParser;
    private final LiveData<PagedList<DocumentSnapshot>> mSnapshots;
    private final Observer<LoadingState> mStateObserver = new Observer<LoadingState>() {
        public void onChanged(LoadingState state) {
            if (state != null) {
                FirestorePagingAdapter.this.onLoadingStateChanged(state);
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract void onBindViewHolder(VH vh, int i, T t);

    public FirestorePagingAdapter(FirestorePagingOptions<T> options) {
        super(options.getDiffCallback());
        LiveData<PagedList<DocumentSnapshot>> data = options.getData();
        this.mSnapshots = data;
        this.mLoadingState = Transformations.switchMap(data, new Function<PagedList<DocumentSnapshot>, LiveData<LoadingState>>() {
            public LiveData<LoadingState> apply(PagedList<DocumentSnapshot> input) {
                return ((FirestoreDataSource) input.getDataSource()).getLoadingState();
            }
        });
        this.mDataSource = Transformations.map(this.mSnapshots, new Function<PagedList<DocumentSnapshot>, FirestoreDataSource>() {
            public FirestoreDataSource apply(PagedList<DocumentSnapshot> input) {
                return (FirestoreDataSource) input.getDataSource();
            }
        });
        this.mParser = options.getParser();
        if (options.getOwner() != null) {
            options.getOwner().getLifecycle().addObserver(this);
        }
    }

    public void retry() {
        FirestoreDataSource source = this.mDataSource.getValue();
        if (source == null) {
            Log.w(TAG, "Called retry() when FirestoreDataSource is null!");
        } else {
            source.retry();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void startListening() {
        this.mSnapshots.observeForever(this.mDataObserver);
        this.mLoadingState.observeForever(this.mStateObserver);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stopListening() {
        this.mSnapshots.removeObserver(this.mDataObserver);
        this.mLoadingState.removeObserver(this.mStateObserver);
    }

    public void onBindViewHolder(VH holder, int position) {
        onBindViewHolder(holder, position, this.mParser.parseSnapshot((DocumentSnapshot) getItem(position)));
    }

    /* access modifiers changed from: protected */
    public void onLoadingStateChanged(LoadingState state) {
    }
}

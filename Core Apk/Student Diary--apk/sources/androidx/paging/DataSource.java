package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.PageResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class DataSource<Key, Value> {
    private AtomicBoolean mInvalid = new AtomicBoolean(false);
    private CopyOnWriteArrayList<InvalidatedCallback> mOnInvalidatedCallbacks = new CopyOnWriteArrayList<>();

    public interface InvalidatedCallback {
        void onInvalidated();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isContiguous();

    public abstract <ToValue> DataSource<Key, ToValue> map(Function<Value, ToValue> function);

    public abstract <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function);

    public static abstract class Factory<Key, Value> {
        public abstract DataSource<Key, Value> create();

        public <ToValue> Factory<Key, ToValue> map(Function<Value, ToValue> function) {
            return mapByPage(DataSource.createListFunction(function));
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(final Function<List<Value>, List<ToValue>> function) {
            return new Factory<Key, ToValue>() {
                public DataSource<Key, ToValue> create() {
                    return Factory.this.create().mapByPage(function);
                }
            };
        }
    }

    static <X, Y> Function<List<X>, List<Y>> createListFunction(final Function<X, Y> innerFunc) {
        return new Function<List<X>, List<Y>>() {
            public List<Y> apply(List<X> source) {
                List<Y> out = new ArrayList<>(source.size());
                for (int i = 0; i < source.size(); i++) {
                    out.add(innerFunc.apply(source.get(i)));
                }
                return out;
            }
        };
    }

    static <A, B> List<B> convert(Function<List<A>, List<B>> function, List<A> source) {
        List<B> dest = function.apply(source);
        if (dest.size() == source.size()) {
            return dest;
        }
        throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
    }

    DataSource() {
    }

    static class LoadCallbackHelper<T> {
        private final DataSource mDataSource;
        private boolean mHasSignalled = false;
        private Executor mPostExecutor = null;
        final PageResult.Receiver<T> mReceiver;
        final int mResultType;
        private final Object mSignalLock = new Object();

        static void validateInitialLoadParams(List<?> data, int position, int totalCount) {
            if (position < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (data.size() + position > totalCount) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            } else if (data.size() == 0 && totalCount > 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
        }

        LoadCallbackHelper(DataSource dataSource, int resultType, Executor mainThreadExecutor, PageResult.Receiver<T> receiver) {
            this.mDataSource = dataSource;
            this.mResultType = resultType;
            this.mPostExecutor = mainThreadExecutor;
            this.mReceiver = receiver;
        }

        /* access modifiers changed from: package-private */
        public void setPostExecutor(Executor postExecutor) {
            synchronized (this.mSignalLock) {
                this.mPostExecutor = postExecutor;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean dispatchInvalidResultIfInvalid() {
            if (!this.mDataSource.isInvalid()) {
                return false;
            }
            dispatchResultToReceiver(PageResult.getInvalidResult());
            return true;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
            r1.execute(new androidx.paging.DataSource.LoadCallbackHelper.AnonymousClass1(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r4.mReceiver.onPageResult(r4.mResultType, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
            if (r1 == null) goto L_0x0019;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatchResultToReceiver(final androidx.paging.PageResult<T> r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.mSignalLock
                monitor-enter(r0)
                r1 = 0
                boolean r2 = r4.mHasSignalled     // Catch:{ all -> 0x0029 }
                if (r2 != 0) goto L_0x0021
                r2 = 1
                r4.mHasSignalled = r2     // Catch:{ all -> 0x0029 }
                java.util.concurrent.Executor r1 = r4.mPostExecutor     // Catch:{ all -> 0x0029 }
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                if (r1 == 0) goto L_0x0019
                androidx.paging.DataSource$LoadCallbackHelper$1 r0 = new androidx.paging.DataSource$LoadCallbackHelper$1
                r0.<init>(r5)
                r1.execute(r0)
                goto L_0x0020
            L_0x0019:
                androidx.paging.PageResult$Receiver<T> r0 = r4.mReceiver
                int r2 = r4.mResultType
                r0.onPageResult(r2, r5)
            L_0x0020:
                return
            L_0x0021:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0029 }
                java.lang.String r3 = "callback.onResult already called, cannot call again."
                r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                throw r2     // Catch:{ all -> 0x0029 }
            L_0x0029:
                r2 = move-exception
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002c:
                r2 = move-exception
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.DataSource.LoadCallbackHelper.dispatchResultToReceiver(androidx.paging.PageResult):void");
        }
    }

    public void addInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        this.mOnInvalidatedCallbacks.add(onInvalidatedCallback);
    }

    public void removeInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        this.mOnInvalidatedCallbacks.remove(onInvalidatedCallback);
    }

    public void invalidate() {
        if (this.mInvalid.compareAndSet(false, true)) {
            Iterator<InvalidatedCallback> it = this.mOnInvalidatedCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onInvalidated();
            }
        }
    }

    public boolean isInvalid() {
        return this.mInvalid.get();
    }
}

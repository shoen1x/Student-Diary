package androidx.paging;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class PagedStorage<T> extends AbstractList<T> {
    private static final List PLACEHOLDER_LIST = new ArrayList();
    private int mLeadingNullCount;
    private int mLoadedCount;
    private int mNumberAppended;
    private int mNumberPrepended;
    private int mPageSize;
    private final ArrayList<List<T>> mPages;
    private int mPositionOffset;
    private int mStorageCount;
    private int mTrailingNullCount;

    interface Callback {
        void onEmptyAppend();

        void onEmptyPrepend();

        void onInitialized(int i);

        void onPageAppended(int i, int i2, int i3);

        void onPageInserted(int i, int i2);

        void onPagePlaceholderInserted(int i);

        void onPagePrepended(int i, int i2, int i3);

        void onPagesRemoved(int i, int i2);

        void onPagesSwappedToPlaceholder(int i, int i2);
    }

    PagedStorage() {
        this.mLeadingNullCount = 0;
        this.mPages = new ArrayList<>();
        this.mTrailingNullCount = 0;
        this.mPositionOffset = 0;
        this.mLoadedCount = 0;
        this.mStorageCount = 0;
        this.mPageSize = 1;
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    PagedStorage(int leadingNulls, List<T> page, int trailingNulls) {
        this();
        init(leadingNulls, page, trailingNulls, 0);
    }

    private PagedStorage(PagedStorage<T> other) {
        this.mLeadingNullCount = other.mLeadingNullCount;
        this.mPages = new ArrayList<>(other.mPages);
        this.mTrailingNullCount = other.mTrailingNullCount;
        this.mPositionOffset = other.mPositionOffset;
        this.mLoadedCount = other.mLoadedCount;
        this.mStorageCount = other.mStorageCount;
        this.mPageSize = other.mPageSize;
        this.mNumberPrepended = other.mNumberPrepended;
        this.mNumberAppended = other.mNumberAppended;
    }

    /* access modifiers changed from: package-private */
    public PagedStorage<T> snapshot() {
        return new PagedStorage<>(this);
    }

    private void init(int leadingNulls, List<T> page, int trailingNulls, int positionOffset) {
        this.mLeadingNullCount = leadingNulls;
        this.mPages.clear();
        this.mPages.add(page);
        this.mTrailingNullCount = trailingNulls;
        this.mPositionOffset = positionOffset;
        int size = page.size();
        this.mLoadedCount = size;
        this.mStorageCount = size;
        this.mPageSize = page.size();
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    /* access modifiers changed from: package-private */
    public void init(int leadingNulls, List<T> page, int trailingNulls, int positionOffset, Callback callback) {
        init(leadingNulls, page, trailingNulls, positionOffset);
        callback.onInitialized(size());
    }

    public T get(int i) {
        int localPageIndex;
        int pageInternalIndex;
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
        }
        int localIndex = i - this.mLeadingNullCount;
        if (localIndex < 0 || localIndex >= this.mStorageCount) {
            return null;
        }
        if (isTiled()) {
            int i2 = this.mPageSize;
            localPageIndex = localIndex / i2;
            pageInternalIndex = localIndex % i2;
        } else {
            pageInternalIndex = localIndex;
            int localPageCount = this.mPages.size();
            int localPageIndex2 = 0;
            while (localPageIndex2 < localPageCount) {
                int pageSize = this.mPages.get(localPageIndex2).size();
                if (pageSize > pageInternalIndex) {
                    break;
                }
                pageInternalIndex -= pageSize;
                localPageIndex2++;
            }
            localPageIndex = localPageIndex2;
        }
        List<T> page = this.mPages.get(localPageIndex);
        if (page == null || page.size() == 0) {
            return null;
        }
        return page.get(pageInternalIndex);
    }

    /* access modifiers changed from: package-private */
    public boolean isTiled() {
        return this.mPageSize > 0;
    }

    /* access modifiers changed from: package-private */
    public int getLeadingNullCount() {
        return this.mLeadingNullCount;
    }

    /* access modifiers changed from: package-private */
    public int getTrailingNullCount() {
        return this.mTrailingNullCount;
    }

    /* access modifiers changed from: package-private */
    public int getStorageCount() {
        return this.mStorageCount;
    }

    /* access modifiers changed from: package-private */
    public int getNumberAppended() {
        return this.mNumberAppended;
    }

    /* access modifiers changed from: package-private */
    public int getNumberPrepended() {
        return this.mNumberPrepended;
    }

    /* access modifiers changed from: package-private */
    public int getPageCount() {
        return this.mPages.size();
    }

    /* access modifiers changed from: package-private */
    public int getLoadedCount() {
        return this.mLoadedCount;
    }

    /* access modifiers changed from: package-private */
    public int getPositionOffset() {
        return this.mPositionOffset;
    }

    /* access modifiers changed from: package-private */
    public int getMiddleOfLoadedRange() {
        return this.mLeadingNullCount + this.mPositionOffset + (this.mStorageCount / 2);
    }

    public int size() {
        return this.mLeadingNullCount + this.mStorageCount + this.mTrailingNullCount;
    }

    /* access modifiers changed from: package-private */
    public int computeLeadingNulls() {
        int total = this.mLeadingNullCount;
        int pageCount = this.mPages.size();
        for (int i = 0; i < pageCount; i++) {
            List page = this.mPages.get(i);
            if (page != null && page != PLACEHOLDER_LIST) {
                break;
            }
            total += this.mPageSize;
        }
        return total;
    }

    /* access modifiers changed from: package-private */
    public int computeTrailingNulls() {
        int total = this.mTrailingNullCount;
        for (int i = this.mPages.size() - 1; i >= 0; i--) {
            List page = this.mPages.get(i);
            if (page != null && page != PLACEHOLDER_LIST) {
                break;
            }
            total += this.mPageSize;
        }
        return total;
    }

    private boolean needsTrim(int maxSize, int requiredRemaining, int localPageIndex) {
        List<T> page = this.mPages.get(localPageIndex);
        return page == null || (this.mLoadedCount > maxSize && this.mPages.size() > 2 && page != PLACEHOLDER_LIST && this.mLoadedCount - page.size() >= requiredRemaining);
    }

    /* access modifiers changed from: package-private */
    public boolean needsTrimFromFront(int maxSize, int requiredRemaining) {
        return needsTrim(maxSize, requiredRemaining, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean needsTrimFromEnd(int maxSize, int requiredRemaining) {
        return needsTrim(maxSize, requiredRemaining, this.mPages.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldPreTrimNewPage(int maxSize, int requiredRemaining, int countToBeAdded) {
        if (this.mLoadedCount + countToBeAdded <= maxSize || this.mPages.size() <= 1 || this.mLoadedCount < requiredRemaining) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean trimFromFront(boolean insertNulls, int maxSize, int requiredRemaining, Callback callback) {
        int totalRemoved = 0;
        while (true) {
            int i = 0;
            if (!needsTrimFromFront(maxSize, requiredRemaining)) {
                break;
            }
            List page = this.mPages.remove(0);
            int removed = page == null ? this.mPageSize : page.size();
            totalRemoved += removed;
            this.mStorageCount -= removed;
            int i2 = this.mLoadedCount;
            if (page != null) {
                i = page.size();
            }
            this.mLoadedCount = i2 - i;
        }
        if (totalRemoved > 0) {
            if (insertNulls) {
                int previousLeadingNulls = this.mLeadingNullCount;
                this.mLeadingNullCount += totalRemoved;
                callback.onPagesSwappedToPlaceholder(previousLeadingNulls, totalRemoved);
            } else {
                this.mPositionOffset += totalRemoved;
                callback.onPagesRemoved(this.mLeadingNullCount, totalRemoved);
            }
        }
        if (totalRemoved > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean trimFromEnd(boolean insertNulls, int maxSize, int requiredRemaining, Callback callback) {
        int totalRemoved = 0;
        while (true) {
            int i = 0;
            if (!needsTrimFromEnd(maxSize, requiredRemaining)) {
                break;
            }
            ArrayList<List<T>> arrayList = this.mPages;
            List page = arrayList.remove(arrayList.size() - 1);
            int removed = page == null ? this.mPageSize : page.size();
            totalRemoved += removed;
            this.mStorageCount -= removed;
            int i2 = this.mLoadedCount;
            if (page != null) {
                i = page.size();
            }
            this.mLoadedCount = i2 - i;
        }
        if (totalRemoved > 0) {
            int newEndPosition = this.mLeadingNullCount + this.mStorageCount;
            if (insertNulls) {
                this.mTrailingNullCount += totalRemoved;
                callback.onPagesSwappedToPlaceholder(newEndPosition, totalRemoved);
            } else {
                callback.onPagesRemoved(newEndPosition, totalRemoved);
            }
        }
        if (totalRemoved > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public T getFirstLoadedItem() {
        return this.mPages.get(0).get(0);
    }

    /* access modifiers changed from: package-private */
    public T getLastLoadedItem() {
        ArrayList<List<T>> arrayList = this.mPages;
        List<T> page = arrayList.get(arrayList.size() - 1);
        return page.get(page.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void prependPage(List<T> page, Callback callback) {
        int count = page.size();
        if (count == 0) {
            callback.onEmptyPrepend();
            return;
        }
        int i = this.mPageSize;
        if (i > 0 && count != i) {
            if (this.mPages.size() != 1 || count <= this.mPageSize) {
                this.mPageSize = -1;
            } else {
                this.mPageSize = count;
            }
        }
        this.mPages.add(0, page);
        this.mLoadedCount += count;
        this.mStorageCount += count;
        int changedCount = Math.min(this.mLeadingNullCount, count);
        int addedCount = count - changedCount;
        if (changedCount != 0) {
            this.mLeadingNullCount -= changedCount;
        }
        this.mPositionOffset -= addedCount;
        this.mNumberPrepended += count;
        callback.onPagePrepended(this.mLeadingNullCount, changedCount, addedCount);
    }

    /* access modifiers changed from: package-private */
    public void appendPage(List<T> page, Callback callback) {
        int count = page.size();
        if (count == 0) {
            callback.onEmptyAppend();
            return;
        }
        if (this.mPageSize > 0) {
            ArrayList<List<T>> arrayList = this.mPages;
            int size = arrayList.get(arrayList.size() - 1).size();
            int i = this.mPageSize;
            if (size != i || count > i) {
                this.mPageSize = -1;
            }
        }
        this.mPages.add(page);
        this.mLoadedCount += count;
        this.mStorageCount += count;
        int changedCount = Math.min(this.mTrailingNullCount, count);
        int addedCount = count - changedCount;
        if (changedCount != 0) {
            this.mTrailingNullCount -= changedCount;
        }
        this.mNumberAppended += count;
        callback.onPageAppended((this.mLeadingNullCount + this.mStorageCount) - count, changedCount, addedCount);
    }

    /* access modifiers changed from: package-private */
    public boolean pageWouldBeBoundary(int positionOfPage, boolean trimFromFront) {
        if (this.mPageSize < 1 || this.mPages.size() < 2) {
            throw new IllegalStateException("Trimming attempt before sufficient load");
        }
        int i = this.mLeadingNullCount;
        if (positionOfPage < i) {
            return trimFromFront;
        }
        if (positionOfPage >= this.mStorageCount + i) {
            return !trimFromFront;
        }
        int localPageIndex = (positionOfPage - i) / this.mPageSize;
        if (trimFromFront) {
            for (int i2 = 0; i2 < localPageIndex; i2++) {
                if (this.mPages.get(i2) != null) {
                    return false;
                }
            }
        } else {
            for (int i3 = this.mPages.size() - 1; i3 > localPageIndex; i3--) {
                if (this.mPages.get(i3) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void initAndSplit(int leadingNulls, List<T> multiPageList, int trailingNulls, int positionOffset, int pageSize, Callback callback) {
        int pageCount = (multiPageList.size() + (pageSize - 1)) / pageSize;
        for (int i = 0; i < pageCount; i++) {
            int beginInclusive = i * pageSize;
            List<T> sublist = multiPageList.subList(beginInclusive, Math.min(multiPageList.size(), (i + 1) * pageSize));
            if (i == 0) {
                init(leadingNulls, sublist, (multiPageList.size() + trailingNulls) - sublist.size(), positionOffset);
            } else {
                insertPage(leadingNulls + beginInclusive, sublist, (Callback) null);
            }
        }
        callback.onInitialized(size());
    }

    /* access modifiers changed from: package-private */
    public void tryInsertPageAndTrim(int position, List<T> page, int lastLoad, int maxSize, int requiredRemaining, Callback callback) {
        boolean trim = maxSize != Integer.MAX_VALUE;
        boolean trimFromFront = lastLoad > getMiddleOfLoadedRange();
        if (!trim || !shouldPreTrimNewPage(maxSize, requiredRemaining, page.size()) || !pageWouldBeBoundary(position, trimFromFront)) {
            insertPage(position, page, callback);
        } else {
            this.mPages.set((position - this.mLeadingNullCount) / this.mPageSize, (Object) null);
            this.mStorageCount -= page.size();
            if (trimFromFront) {
                this.mPages.remove(0);
                this.mLeadingNullCount += page.size();
            } else {
                ArrayList<List<T>> arrayList = this.mPages;
                arrayList.remove(arrayList.size() - 1);
                this.mTrailingNullCount += page.size();
            }
        }
        if (!trim) {
            return;
        }
        if (trimFromFront) {
            trimFromFront(true, maxSize, requiredRemaining, callback);
        } else {
            trimFromEnd(true, maxSize, requiredRemaining, callback);
        }
    }

    public void insertPage(int position, List<T> page, Callback callback) {
        int newPageSize = page.size();
        if (newPageSize != this.mPageSize) {
            int size = size();
            int i = this.mPageSize;
            boolean z = false;
            boolean addingLastPage = position == size - (size % i) && newPageSize < i;
            if (this.mTrailingNullCount == 0 && this.mPages.size() == 1 && newPageSize > this.mPageSize) {
                z = true;
            }
            boolean onlyEndPagePresent = z;
            if (!onlyEndPagePresent && !addingLastPage) {
                throw new IllegalArgumentException("page introduces incorrect tiling");
            } else if (onlyEndPagePresent) {
                this.mPageSize = newPageSize;
            }
        }
        int pageIndex = position / this.mPageSize;
        allocatePageRange(pageIndex, pageIndex);
        int localPageIndex = pageIndex - (this.mLeadingNullCount / this.mPageSize);
        List<T> oldPage = this.mPages.get(localPageIndex);
        if (oldPage == null || oldPage == PLACEHOLDER_LIST) {
            this.mPages.set(localPageIndex, page);
            this.mLoadedCount += newPageSize;
            if (callback != null) {
                callback.onPageInserted(position, newPageSize);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid position " + position + ": data already loaded");
    }

    /* access modifiers changed from: package-private */
    public void allocatePageRange(int minimumPage, int maximumPage) {
        int leadingNullPages = this.mLeadingNullCount / this.mPageSize;
        if (minimumPage < leadingNullPages) {
            for (int i = 0; i < leadingNullPages - minimumPage; i++) {
                this.mPages.add(0, (Object) null);
            }
            int newStorageAllocated = (leadingNullPages - minimumPage) * this.mPageSize;
            this.mStorageCount += newStorageAllocated;
            this.mLeadingNullCount -= newStorageAllocated;
            leadingNullPages = minimumPage;
        }
        if (maximumPage >= this.mPages.size() + leadingNullPages) {
            int newStorageAllocated2 = Math.min(this.mTrailingNullCount, ((maximumPage + 1) - (this.mPages.size() + leadingNullPages)) * this.mPageSize);
            for (int i2 = this.mPages.size(); i2 <= maximumPage - leadingNullPages; i2++) {
                ArrayList<List<T>> arrayList = this.mPages;
                arrayList.add(arrayList.size(), (Object) null);
            }
            this.mStorageCount += newStorageAllocated2;
            this.mTrailingNullCount -= newStorageAllocated2;
        }
    }

    public void allocatePlaceholders(int index, int prefetchDistance, int pageSize, Callback callback) {
        int i = this.mPageSize;
        if (pageSize != i) {
            if (pageSize < i) {
                throw new IllegalArgumentException("Page size cannot be reduced");
            } else if (this.mPages.size() == 1 && this.mTrailingNullCount == 0) {
                this.mPageSize = pageSize;
            } else {
                throw new IllegalArgumentException("Page size can change only if last page is only one present");
            }
        }
        int size = size();
        int i2 = this.mPageSize;
        int minimumPage = Math.max((index - prefetchDistance) / i2, 0);
        int maximumPage = Math.min((index + prefetchDistance) / this.mPageSize, (((size + i2) - 1) / i2) - 1);
        allocatePageRange(minimumPage, maximumPage);
        int leadingNullPages = this.mLeadingNullCount / this.mPageSize;
        for (int pageIndex = minimumPage; pageIndex <= maximumPage; pageIndex++) {
            int localPageIndex = pageIndex - leadingNullPages;
            if (this.mPages.get(localPageIndex) == null) {
                this.mPages.set(localPageIndex, PLACEHOLDER_LIST);
                callback.onPagePlaceholderInserted(pageIndex);
            }
        }
    }

    public boolean hasPage(int pageSize, int index) {
        List<T> page;
        int leadingNullPages = this.mLeadingNullCount / pageSize;
        if (index < leadingNullPages || index >= this.mPages.size() + leadingNullPages || (page = this.mPages.get(index - leadingNullPages)) == null || page == PLACEHOLDER_LIST) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("leading " + this.mLeadingNullCount + ", storage " + this.mStorageCount + ", trailing " + getTrailingNullCount());
        for (int i = 0; i < this.mPages.size(); i++) {
            ret.append(" ");
            ret.append(this.mPages.get(i));
        }
        return ret.toString();
    }
}

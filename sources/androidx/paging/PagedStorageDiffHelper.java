package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

class PagedStorageDiffHelper {
    private PagedStorageDiffHelper() {
    }

    static <T> DiffUtil.DiffResult computeDiff(PagedStorage<T> oldList, PagedStorage<T> newList, DiffUtil.ItemCallback<T> diffCallback) {
        int oldOffset = oldList.computeLeadingNulls();
        int newOffset = newList.computeLeadingNulls();
        int oldSize = (oldList.size() - oldOffset) - oldList.computeTrailingNulls();
        final PagedStorage<T> pagedStorage = oldList;
        final int i = oldOffset;
        final PagedStorage<T> pagedStorage2 = newList;
        final DiffUtil.ItemCallback<T> itemCallback = diffCallback;
        final int i2 = oldSize;
        final int size = (newList.size() - newOffset) - newList.computeTrailingNulls();
        return DiffUtil.calculateDiff(new DiffUtil.Callback() {
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                T oldItem = pagedStorage.get(i + oldItemPosition);
                PagedStorage pagedStorage = pagedStorage2;
                T newItem = pagedStorage.get(pagedStorage.getLeadingNullCount() + newItemPosition);
                if (oldItem == null || newItem == null) {
                    return null;
                }
                return itemCallback.getChangePayload(oldItem, newItem);
            }

            public int getOldListSize() {
                return i2;
            }

            public int getNewListSize() {
                return size;
            }

            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                T oldItem = pagedStorage.get(i + oldItemPosition);
                PagedStorage pagedStorage = pagedStorage2;
                T newItem = pagedStorage.get(pagedStorage.getLeadingNullCount() + newItemPosition);
                if (oldItem == newItem) {
                    return true;
                }
                if (oldItem == null || newItem == null) {
                    return false;
                }
                return itemCallback.areItemsTheSame(oldItem, newItem);
            }

            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                T oldItem = pagedStorage.get(i + oldItemPosition);
                PagedStorage pagedStorage = pagedStorage2;
                T newItem = pagedStorage.get(pagedStorage.getLeadingNullCount() + newItemPosition);
                if (oldItem == newItem) {
                    return true;
                }
                if (oldItem == null || newItem == null) {
                    return false;
                }
                return itemCallback.areContentsTheSame(oldItem, newItem);
            }
        }, true);
    }

    private static class OffsettingListUpdateCallback implements ListUpdateCallback {
        private final ListUpdateCallback mCallback;
        private final int mOffset;

        OffsettingListUpdateCallback(int offset, ListUpdateCallback callback) {
            this.mOffset = offset;
            this.mCallback = callback;
        }

        public void onInserted(int position, int count) {
            this.mCallback.onInserted(this.mOffset + position, count);
        }

        public void onRemoved(int position, int count) {
            this.mCallback.onRemoved(this.mOffset + position, count);
        }

        public void onMoved(int fromPosition, int toPosition) {
            ListUpdateCallback listUpdateCallback = this.mCallback;
            int i = this.mOffset;
            listUpdateCallback.onMoved(fromPosition + i, i + toPosition);
        }

        public void onChanged(int position, int count, Object payload) {
            this.mCallback.onChanged(this.mOffset + position, count, payload);
        }
    }

    static <T> void dispatchDiff(ListUpdateCallback callback, PagedStorage<T> oldList, PagedStorage<T> newList, DiffUtil.DiffResult diffResult) {
        int trailingOld = oldList.computeTrailingNulls();
        int trailingNew = newList.computeTrailingNulls();
        int leadingOld = oldList.computeLeadingNulls();
        int leadingNew = newList.computeLeadingNulls();
        if (trailingOld == 0 && trailingNew == 0 && leadingOld == 0 && leadingNew == 0) {
            diffResult.dispatchUpdatesTo(callback);
            return;
        }
        if (trailingOld > trailingNew) {
            int count = trailingOld - trailingNew;
            callback.onRemoved(oldList.size() - count, count);
        } else if (trailingOld < trailingNew) {
            callback.onInserted(oldList.size(), trailingNew - trailingOld);
        }
        if (leadingOld > leadingNew) {
            callback.onRemoved(0, leadingOld - leadingNew);
        } else if (leadingOld < leadingNew) {
            callback.onInserted(0, leadingNew - leadingOld);
        }
        if (leadingNew != 0) {
            diffResult.dispatchUpdatesTo((ListUpdateCallback) new OffsettingListUpdateCallback(leadingNew, callback));
        } else {
            diffResult.dispatchUpdatesTo(callback);
        }
    }

    static int transformAnchorIndex(DiffUtil.DiffResult diffResult, PagedStorage oldList, PagedStorage newList, int oldPosition) {
        int oldOffset = oldList.computeLeadingNulls();
        int diffIndex = oldPosition - oldOffset;
        int oldSize = (oldList.size() - oldOffset) - oldList.computeTrailingNulls();
        if (diffIndex >= 0 && diffIndex < oldSize) {
            for (int i = 0; i < 30; i++) {
                int positionToTry = ((i / 2) * (i % 2 == 1 ? -1 : 1)) + diffIndex;
                if (positionToTry >= 0 && positionToTry < oldList.getStorageCount()) {
                    try {
                        int result = diffResult.convertOldPositionToNew(positionToTry);
                        if (result != -1) {
                            return newList.getLeadingNullCount() + result;
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return Math.max(0, Math.min(oldPosition, newList.size() - 1));
    }
}

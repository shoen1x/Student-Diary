package com.firebase.ui.firestore.paging;

import androidx.recyclerview.widget.DiffUtil;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.firebase.firestore.DocumentSnapshot;

public class DefaultSnapshotDiffCallback<T> extends DiffUtil.ItemCallback<DocumentSnapshot> {
    private final SnapshotParser<T> mParser;

    public DefaultSnapshotDiffCallback(SnapshotParser<T> parser) {
        this.mParser = parser;
    }

    public boolean areItemsTheSame(DocumentSnapshot oldItem, DocumentSnapshot newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    public boolean areContentsTheSame(DocumentSnapshot oldItem, DocumentSnapshot newItem) {
        return this.mParser.parseSnapshot(oldItem).equals(this.mParser.parseSnapshot(newItem));
    }
}

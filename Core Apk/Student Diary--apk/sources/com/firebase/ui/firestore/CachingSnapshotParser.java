package com.firebase.ui.firestore;

import com.firebase.ui.common.BaseCachingSnapshotParser;
import com.firebase.ui.common.BaseSnapshotParser;
import com.google.firebase.firestore.DocumentSnapshot;

public class CachingSnapshotParser<T> extends BaseCachingSnapshotParser<DocumentSnapshot, T> implements SnapshotParser<T> {
    public CachingSnapshotParser(BaseSnapshotParser<DocumentSnapshot, T> parser) {
        super(parser);
    }

    public String getId(DocumentSnapshot snapshot) {
        return snapshot.getId();
    }
}

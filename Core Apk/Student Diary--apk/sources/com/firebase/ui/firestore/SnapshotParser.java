package com.firebase.ui.firestore;

import com.firebase.ui.common.BaseSnapshotParser;
import com.google.firebase.firestore.DocumentSnapshot;

public interface SnapshotParser<T> extends BaseSnapshotParser<DocumentSnapshot, T> {
}

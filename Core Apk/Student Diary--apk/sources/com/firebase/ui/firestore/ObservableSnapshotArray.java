package com.firebase.ui.firestore;

import com.firebase.ui.common.BaseObservableSnapshotArray;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;

public abstract class ObservableSnapshotArray<T> extends BaseObservableSnapshotArray<DocumentSnapshot, FirebaseFirestoreException, ChangeEventListener, T> {
    public ObservableSnapshotArray(SnapshotParser<T> parser) {
        super(new CachingSnapshotParser(parser));
    }
}

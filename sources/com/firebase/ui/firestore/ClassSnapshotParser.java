package com.firebase.ui.firestore;

import com.firebase.ui.common.Preconditions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ClassSnapshotParser<T> implements SnapshotParser<T> {
    private final Class<T> mModelClass;

    public ClassSnapshotParser(Class<T> modelClass) {
        this.mModelClass = (Class) Preconditions.checkNotNull(modelClass);
    }

    public T parseSnapshot(DocumentSnapshot snapshot) {
        return snapshot.toObject(this.mModelClass);
    }
}

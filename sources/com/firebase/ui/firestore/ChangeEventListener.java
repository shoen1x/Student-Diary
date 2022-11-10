package com.firebase.ui.firestore;

import com.firebase.ui.common.BaseChangeEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;

public interface ChangeEventListener extends BaseChangeEventListener<DocumentSnapshot, FirebaseFirestoreException> {
}

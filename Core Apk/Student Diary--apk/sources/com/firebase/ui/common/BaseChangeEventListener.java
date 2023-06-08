package com.firebase.ui.common;

public interface BaseChangeEventListener<S, E> {
    void onChildChanged(ChangeEventType changeEventType, S s, int i, int i2);

    void onDataChanged();

    void onError(E e);
}

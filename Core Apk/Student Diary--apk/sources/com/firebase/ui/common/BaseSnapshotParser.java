package com.firebase.ui.common;

public interface BaseSnapshotParser<S, T> {
    T parseSnapshot(S s);
}

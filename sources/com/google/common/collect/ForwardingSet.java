package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    /* access modifiers changed from: protected */
    public abstract Set<E> delegate();

    protected ForwardingSet() {
    }

    public boolean equals(@NullableDecl Object object) {
        return object == this || delegate().equals(object);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.removeAllImpl((Set<?>) this, (Collection<?>) (Collection) Preconditions.checkNotNull(collection));
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object object) {
        return Sets.equalsImpl(this, object);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }
}

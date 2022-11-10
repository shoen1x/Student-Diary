package com.mikepenz.fastadapter;

import com.mikepenz.fastadapter.ISubItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0014H\u0001J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0001J\u0016\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0011H\u0001J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0003J\u0016\u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010 J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0001J\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u0015\u001a\u00020\rH\u0001J\u0015\u0010'\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010(\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0015\u0010)\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u001eJ\u0017\u0010*\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0001J\u001e\u0010+\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u00060"}, d2 = {"Lcom/mikepenz/fastadapter/MutableSubItemList;", "E", "Lcom/mikepenz/fastadapter/ISubItem;", "", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "list", "(Lcom/mikepenz/fastadapter/IParentItem;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getParent", "()Lcom/mikepenz/fastadapter/IParentItem;", "size", "", "getSize", "()I", "add", "", "element", "(Lcom/mikepenz/fastadapter/ISubItem;)Z", "", "index", "(ILcom/mikepenz/fastadapter/ISubItem;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Lcom/mikepenz/fastadapter/ISubItem;", "indexOf", "(Lcom/mikepenz/fastadapter/ISubItem;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILcom/mikepenz/fastadapter/ISubItem;)Lcom/mikepenz/fastadapter/ISubItem;", "subList", "fromIndex", "toIndex", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: MutableSubItemList.kt */
public final class MutableSubItemList<E extends ISubItem<?>> implements List<E>, KMutableList {
    private final List<E> list;
    private final IParentItem<?> parent;

    public void clear() {
        this.list.clear();
    }

    public boolean contains(E e) {
        Intrinsics.checkParameterIsNotNull(e, "element");
        return this.list.contains(e);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "elements");
        return this.list.containsAll(collection);
    }

    public E get(int i) {
        E e = this.list.get(i);
        Intrinsics.checkExpressionValueIsNotNull(e, "get(...)");
        return (ISubItem) e;
    }

    public int getSize() {
        return this.list.size();
    }

    public int indexOf(E e) {
        Intrinsics.checkParameterIsNotNull(e, "element");
        return this.list.indexOf(e);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(E e) {
        Intrinsics.checkParameterIsNotNull(e, "element");
        return this.list.lastIndexOf(e);
    }

    public ListIterator<E> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "elements");
        return this.list.retainAll(collection);
    }

    public List<E> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public MutableSubItemList(IParentItem<?> parent2, List<E> list2) {
        Intrinsics.checkParameterIsNotNull(parent2, "parent");
        Intrinsics.checkParameterIsNotNull(list2, "list");
        this.parent = parent2;
        this.list = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableSubItemList(IParentItem iParentItem, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iParentItem, (i & 2) != 0 ? new ArrayList() : list2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ISubItem) {
            return contains((ISubItem) obj);
        }
        return false;
    }

    public final List<E> getList() {
        return this.list;
    }

    public final IParentItem<?> getParent() {
        return this.parent;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ISubItem) {
            return indexOf((ISubItem) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ISubItem) {
            return lastIndexOf((ISubItem) obj);
        }
        return -1;
    }

    public final /* bridge */ E remove(int i) {
        return remove(i);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof ISubItem) {
            return remove((ISubItem) obj);
        }
        return false;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public boolean remove(E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        boolean removed = this.list.remove(element);
        if (removed) {
            element.setParent((IParentItem<?>) null);
        }
        return removed;
    }

    /* renamed from: removeAt */
    public E remove(int index) {
        E remove = this.list.remove(index);
        ((ISubItem) remove).setParent((IParentItem<?>) null);
        return (ISubItem) remove;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : elements) {
            if (this.list.contains((ISubItem) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        for (ISubItem it : (List) destination$iv$iv) {
            it.setParent((IParentItem<?>) null);
        }
        return this.list.removeAll(elements);
    }

    public boolean add(E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        element.setParent(this.parent);
        return this.list.add(element);
    }

    public void add(int index, E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        element.setParent(this.parent);
        this.list.add(index, element);
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            ((ISubItem) it.next()).setParent(this.parent);
        }
        return this.list.addAll(index, elements);
    }

    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            ((ISubItem) it.next()).setParent(this.parent);
        }
        return this.list.addAll(elements);
    }

    public E set(int index, E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        element.setParent(this.parent);
        E e = this.list.set(index, element);
        ((ISubItem) e).setParent((IParentItem<?>) null);
        return (ISubItem) e;
    }
}

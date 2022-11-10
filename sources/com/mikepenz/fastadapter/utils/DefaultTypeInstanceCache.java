package com.mikepenz.fastadapter.utils;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.ITypeInstanceCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mikepenz/fastadapter/utils/DefaultTypeInstanceCache;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/ITypeInstanceCache;", "()V", "mTypeInstances", "Landroid/util/SparseArray;", "clear", "", "get", "type", "", "(I)Lcom/mikepenz/fastadapter/IItem;", "register", "", "item", "(Lcom/mikepenz/fastadapter/IItem;)Z", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultTypeInstanceCache.kt */
public final class DefaultTypeInstanceCache<Item extends IItem<? extends RecyclerView.ViewHolder>> implements ITypeInstanceCache<Item> {
    private final SparseArray<Item> mTypeInstances = new SparseArray<>();

    public boolean register(Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (this.mTypeInstances.indexOfKey(item.getType()) >= 0) {
            return false;
        }
        this.mTypeInstances.put(item.getType(), item);
        return true;
    }

    public Item get(int type) {
        Item item = this.mTypeInstances.get(type);
        Intrinsics.checkExpressionValueIsNotNull(item, "mTypeInstances.get(type)");
        return (IItem) item;
    }

    public void clear() {
        this.mTypeInstances.clear();
    }
}

package com.mikepenz.fastadapter.expandable;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.extensions.ExtensionFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\f0\u000bj\u0002`\r0\nH\u0016R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/mikepenz/fastadapter/expandable/ExpandableExtensionFactory;", "Lcom/mikepenz/fastadapter/extensions/ExtensionFactory;", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "()V", "clazz", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "create", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "fastadapter-extensions-expandable"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableExtensionFactory.kt */
public final class ExpandableExtensionFactory implements ExtensionFactory<ExpandableExtension<?>> {
    private final Class<ExpandableExtension<?>> clazz = ExpandableExtension.class;

    public Class<ExpandableExtension<?>> getClazz() {
        return this.clazz;
    }

    public ExpandableExtension<?> create(FastAdapter<? extends IItem<? extends RecyclerView.ViewHolder>> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        return new ExpandableExtension<>(fastAdapter);
    }
}

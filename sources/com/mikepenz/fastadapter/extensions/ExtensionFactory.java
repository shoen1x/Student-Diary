package com.mikepenz.fastadapter.extensions;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u001c\b\u0000\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00050\u00022\u00020\u0006J+\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u001a\u0010\f\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00050\rH&¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/fastadapter/extensions/ExtensionFactory;", "T", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "clazz", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "create", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "(Lcom/mikepenz/fastadapter/FastAdapter;)Lcom/mikepenz/fastadapter/IAdapterExtension;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExtensionFactory.kt */
public interface ExtensionFactory<T extends IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>>> {
    T create(FastAdapter<? extends IItem<? extends RecyclerView.ViewHolder>> fastAdapter);

    Class<T> getClazz();
}

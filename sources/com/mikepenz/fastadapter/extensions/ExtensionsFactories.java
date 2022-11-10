package com.mikepenz.fastadapter.extensions;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IItem;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\f\u001a\u0018\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\u0006\"\u001e\b\u0000\u0010\r\u0018\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u00062\u001a\u0010\u000e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u000fH\bJ\\\u0010\f\u001a\u0018\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\u00062\u001a\u0010\u000e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u000f2\"\u0010\u0010\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u00060\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\nRj\u0010\u0003\u001a^\u0012 \u0012\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u00060\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0004j.\u0012 \u0012\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\u0002`\t0\u00060\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mikepenz/fastadapter/extensions/ExtensionsFactories;", "", "()V", "factories", "Ljava/util/LinkedHashMap;", "Ljava/lang/Class;", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/extensions/ExtensionFactory;", "Lkotlin/collections/LinkedHashMap;", "create", "T", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "clazz", "register", "", "factory", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExtensionsFactories.kt */
public final class ExtensionsFactories {
    public static final ExtensionsFactories INSTANCE = new ExtensionsFactories();
    private static final LinkedHashMap<Class<? extends IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>>>, ExtensionFactory<?>> factories = new LinkedHashMap<>();

    private ExtensionsFactories() {
    }

    public final void register(ExtensionFactory<?> factory) {
        Intrinsics.checkParameterIsNotNull(factory, "factory");
        factories.put(factory.getClazz(), factory);
    }

    public final IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>> create(FastAdapter<? extends IItem<? extends RecyclerView.ViewHolder>> fastAdapter, Class<? extends IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>>> clazz) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        ExtensionFactory extensionFactory = factories.get(clazz);
        if (extensionFactory != null) {
            return extensionFactory.create(fastAdapter);
        }
        return null;
    }

    public final /* synthetic */ <T extends IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>>> IAdapterExtension<? extends IItem<? extends RecyclerView.ViewHolder>> create(FastAdapter<? extends IItem<? extends RecyclerView.ViewHolder>> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return create(fastAdapter, IAdapterExtension.class);
    }
}

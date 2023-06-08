package com.mikepenz.fastadapter;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"com/mikepenz/fastadapter/FastAdapter$viewTouchListener$1", "Lcom/mikepenz/fastadapter/listeners/TouchEventHook;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "position", "", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;Landroid/view/MotionEvent;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: FastAdapter.kt */
public final class FastAdapter$viewTouchListener$1 extends TouchEventHook<Item> {
    FastAdapter$viewTouchListener$1() {
    }

    public boolean onTouch(View v, MotionEvent event, int position, FastAdapter<Item> fastAdapter, Item item) {
        IAdapter adapter;
        Function5<View, MotionEvent, IAdapter<Item>, Item, Integer, Boolean> onTouchListener;
        Intrinsics.checkParameterIsNotNull(v, "v");
        Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkParameterIsNotNull(fastAdapter, "fastAdapter");
        Intrinsics.checkParameterIsNotNull(item, "item");
        for (IAdapterExtension ext : fastAdapter.extensionsCache.values()) {
            if (ext.onTouch(v, event, position, fastAdapter, item)) {
                return true;
            }
        }
        if (fastAdapter.getOnTouchListener() == null || (adapter = fastAdapter.getAdapter(position)) == null || (onTouchListener = fastAdapter.getOnTouchListener()) == null) {
            return false;
        }
        if (onTouchListener.invoke(v, event, adapter, item, Integer.valueOf(position)).booleanValue()) {
            return true;
        }
        return false;
    }
}

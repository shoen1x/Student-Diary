package com.mikepenz.fastadapter.listeners;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListenerImpl;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListener;", "()V", "onBindViewHolder", "", "viewHolder", "position", "", "payloads", "", "", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "unBindViewHolder", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnBindViewHolderListenerImpl.kt */
public class OnBindViewHolderListenerImpl<Item extends IItem<? extends RecyclerView.ViewHolder>> implements OnBindViewHolderListener {
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, List<Object> payloads) {
        IItem item;
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        FastAdapter adapter = FastAdapter.Companion.getFromHolderTag(viewHolder);
        if (adapter != null && (item = adapter.getItem(position)) != null) {
            FastAdapter.ViewHolder viewHolder2 = null;
            IItem iItem = !(item instanceof IItem) ? null : item;
            if (iItem != null) {
                iItem.bindView(viewHolder, payloads);
            }
            if (viewHolder instanceof FastAdapter.ViewHolder) {
                viewHolder2 = viewHolder;
            }
            FastAdapter.ViewHolder viewHolder3 = viewHolder2;
            if (viewHolder3 != null) {
                viewHolder3.bindView(item, payloads);
            }
            viewHolder.itemView.setTag(R.id.fastadapter_item, item);
        }
    }

    public void unBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        IItem item = FastAdapter.Companion.getHolderAdapterItemTag(viewHolder);
        if (item != null) {
            item.unbindView(viewHolder);
            FastAdapter.ViewHolder viewHolder2 = (FastAdapter.ViewHolder) (!(viewHolder instanceof FastAdapter.ViewHolder) ? null : viewHolder);
            if (viewHolder2 != null) {
                viewHolder2.unbindView(item);
            }
            viewHolder.itemView.setTag(R.id.fastadapter_item, (Object) null);
            viewHolder.itemView.setTag(R.id.fastadapter_item_adapter, (Object) null);
            return;
        }
        Log.e("FastAdapter", "The bindView method of this item should set the `Tag` on its itemView (https://github.com/mikepenz/FastAdapter/blob/develop/library-core/src/main/java/com/mikepenz/fastadapter/items/AbstractItem.java#L189)");
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        IItem item = FastAdapter.Companion.getHolderAdapterItem(viewHolder, position);
        if (item != null) {
            try {
                item.attachToWindow(viewHolder);
                FastAdapter.ViewHolder viewHolder2 = (FastAdapter.ViewHolder) (!(viewHolder instanceof FastAdapter.ViewHolder) ? null : viewHolder);
                if (viewHolder2 != null) {
                    viewHolder2.attachToWindow(item);
                }
            } catch (AbstractMethodError e) {
                Log.e("FastAdapter", e.toString());
            }
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        IItem item = FastAdapter.Companion.getHolderAdapterItemTag(viewHolder);
        if (item != null) {
            item.detachFromWindow(viewHolder);
            FastAdapter.ViewHolder viewHolder2 = (FastAdapter.ViewHolder) (!(viewHolder instanceof FastAdapter.ViewHolder) ? null : viewHolder);
            if (viewHolder2 == null) {
                return;
            }
            if (item != null) {
                viewHolder2.detachFromWindow(item);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type Item");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r3.failedToRecycle(r0) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFailedToRecycleView(androidx.recyclerview.widget.RecyclerView.ViewHolder r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "viewHolder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            com.mikepenz.fastadapter.FastAdapter$Companion r0 = com.mikepenz.fastadapter.FastAdapter.Companion
            com.mikepenz.fastadapter.IItem r0 = r0.getHolderAdapterItemTag(r5)
            r1 = 0
            if (r0 == 0) goto L_0x002f
            boolean r2 = r0.failedToRecycle(r5)
            boolean r3 = r5 instanceof com.mikepenz.fastadapter.FastAdapter.ViewHolder
            if (r3 == 0) goto L_0x002e
            if (r2 != 0) goto L_0x002c
            r3 = r5
            com.mikepenz.fastadapter.FastAdapter$ViewHolder r3 = (com.mikepenz.fastadapter.FastAdapter.ViewHolder) r3
            if (r0 == 0) goto L_0x0024
            boolean r3 = r3.failedToRecycle(r0)
            if (r3 == 0) goto L_0x002d
            goto L_0x002c
        L_0x0024:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r3 = "null cannot be cast to non-null type Item"
            r1.<init>(r3)
            throw r1
        L_0x002c:
            r1 = 1
        L_0x002d:
            r2 = r1
        L_0x002e:
            return r2
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.listeners.OnBindViewHolderListenerImpl.onFailedToRecycleView(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):boolean");
    }
}

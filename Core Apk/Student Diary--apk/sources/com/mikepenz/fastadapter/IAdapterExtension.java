package com.mikepenz.fastadapter;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH&J3\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0019\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0019\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001aJ;\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0019\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u001a\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H&J\u001f\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010+\u001a\u00020\u0013H¦\u0002J\u001a\u0010,\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H&¨\u0006-"}, d2 = {"Lcom/mikepenz/fastadapter/IAdapterExtension;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "notifyAdapterDataSetChanged", "", "notifyAdapterItemMoved", "fromPosition", "", "toPosition", "notifyAdapterItemRangeChanged", "position", "itemCount", "payload", "notifyAdapterItemRangeInserted", "notifyAdapterItemRangeRemoved", "onClick", "", "v", "Landroid/view/View;", "pos", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "item", "(Landroid/view/View;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "onLongClick", "onTouch", "event", "Landroid/view/MotionEvent;", "(Landroid/view/View;Landroid/view/MotionEvent;ILcom/mikepenz/fastadapter/FastAdapter;Lcom/mikepenz/fastadapter/IItem;)Z", "performFiltering", "constraint", "", "saveInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "prefix", "", "set", "items", "", "resetFilter", "withSavedInstanceState", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IAdapterExtension.kt */
public interface IAdapterExtension<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    void notifyAdapterDataSetChanged();

    void notifyAdapterItemMoved(int i, int i2);

    void notifyAdapterItemRangeChanged(int i, int i2, Object obj);

    void notifyAdapterItemRangeInserted(int i, int i2);

    void notifyAdapterItemRangeRemoved(int i, int i2);

    boolean onClick(View view, int i, FastAdapter<Item> fastAdapter, Item item);

    boolean onLongClick(View view, int i, FastAdapter<Item> fastAdapter, Item item);

    boolean onTouch(View view, MotionEvent motionEvent, int i, FastAdapter<Item> fastAdapter, Item item);

    void performFiltering(CharSequence charSequence);

    void saveInstanceState(Bundle bundle, String str);

    void set(List<? extends Item> list, boolean z);

    void withSavedInstanceState(Bundle bundle, String str);
}

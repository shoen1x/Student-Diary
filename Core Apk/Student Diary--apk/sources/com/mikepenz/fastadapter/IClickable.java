package com.mikepenz.fastadapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005R\u0001\u0010\u0006\u001ar\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0001\u0010\u0017\u001ar\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/mikepenz/fastadapter/IClickable;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "onItemClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "Lcom/mikepenz/fastadapter/IAdapter;", "adapter", "item", "", "position", "", "Lcom/mikepenz/fastadapter/ClickListener;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function4;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function4;)V", "onPreItemClickListener", "getOnPreItemClickListener", "setOnPreItemClickListener", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IClickable.kt */
public interface IClickable<Item extends IItem<? extends RecyclerView.ViewHolder>> {
    Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnItemClickListener();

    Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnPreItemClickListener();

    void setOnItemClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4);

    void setOnPreItemClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4);
}

package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004R\u0018\u0010\u0005\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/mikepenz/fastadapter/IModelItem;", "Model", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IItem;", "model", "getModel", "()Ljava/lang/Object;", "setModel", "(Ljava/lang/Object;)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IModelItem.kt */
public interface IModelItem<Model, VH extends RecyclerView.ViewHolder> extends IItem<VH> {
    Model getModel();

    void setModel(Model model);
}

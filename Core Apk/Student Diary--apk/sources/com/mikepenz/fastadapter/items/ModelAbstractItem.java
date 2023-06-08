package com.mikepenz.fastadapter.items;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IModelItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0006\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/mikepenz/fastadapter/items/ModelAbstractItem;", "Model", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/items/AbstractItem;", "Lcom/mikepenz/fastadapter/IModelItem;", "model", "(Ljava/lang/Object;)V", "getModel", "()Ljava/lang/Object;", "setModel", "Ljava/lang/Object;", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: ModelAbstractItem.kt */
public abstract class ModelAbstractItem<Model, VH extends RecyclerView.ViewHolder> extends AbstractItem<VH> implements IModelItem<Model, VH> {
    private Model model;

    public ModelAbstractItem(Model model2) {
        this.model = model2;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model2) {
        this.model = model2;
    }
}

package com.mikepenz.fastadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\u0002`\u00052\b\u0012\u0004\u0012\u0002H\u00020\u0006J-\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\"\u00028\u0000H&¢\u0006\u0002\u0010\u0010J5\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\"\u00028\u0000H&¢\u0006\u0002\u0010\u0013J*\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&J*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H&J\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H&J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H&J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H&J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u0012H&J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H&J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010#J\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&J)\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00028\u0001H&¢\u0006\u0002\u0010%J,\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010'\u001a\u00020(H&R\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Lcom/mikepenz/fastadapter/IItemAdapter;", "Model", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Lcom/mikepenz/fastadapter/IAdapter;", "idDistributor", "Lcom/mikepenz/fastadapter/IIdDistributor;", "getIdDistributor", "()Lcom/mikepenz/fastadapter/IIdDistributor;", "setIdDistributor", "(Lcom/mikepenz/fastadapter/IIdDistributor;)V", "add", "items", "", "([Ljava/lang/Object;)Lcom/mikepenz/fastadapter/IItemAdapter;", "position", "", "(I[Ljava/lang/Object;)Lcom/mikepenz/fastadapter/IItemAdapter;", "", "addInternal", "clear", "filter", "", "constraint", "", "move", "fromPosition", "toPosition", "remove", "removeRange", "itemCount", "set", "item", "(ILjava/lang/Object;)Lcom/mikepenz/fastadapter/IItemAdapter;", "setInternal", "(ILcom/mikepenz/fastadapter/IItem;)Lcom/mikepenz/fastadapter/IItemAdapter;", "setNewList", "retainFilter", "", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IItemAdapter.kt */
public interface IItemAdapter<Model, Item extends IItem<? extends RecyclerView.ViewHolder>> extends IAdapter<Item> {
    IItemAdapter<Model, Item> add(int i, List<? extends Model> list);

    IItemAdapter<Model, Item> add(int i, Model... modelArr);

    IItemAdapter<Model, Item> add(List<? extends Model> list);

    IItemAdapter<Model, Item> add(Model... modelArr);

    IItemAdapter<Model, Item> addInternal(int i, List<? extends Item> list);

    IItemAdapter<Model, Item> addInternal(List<? extends Item> list);

    IItemAdapter<Model, Item> clear();

    void filter(CharSequence charSequence);

    IIdDistributor<Item> getIdDistributor();

    IItemAdapter<Model, Item> move(int i, int i2);

    IItemAdapter<Model, Item> remove(int i);

    IItemAdapter<Model, Item> removeRange(int i, int i2);

    IItemAdapter<Model, Item> set(int i, Model model);

    IItemAdapter<Model, Item> set(List<? extends Model> list);

    void setIdDistributor(IIdDistributor<Item> iIdDistributor);

    IItemAdapter<Model, Item> setInternal(int i, Item item);

    IItemAdapter<Model, Item> setNewList(List<? extends Model> list, boolean z);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: IItemAdapter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ IItemAdapter setNewList$default(IItemAdapter iItemAdapter, List list, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return iItemAdapter.setNewList(list, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNewList");
        }
    }
}

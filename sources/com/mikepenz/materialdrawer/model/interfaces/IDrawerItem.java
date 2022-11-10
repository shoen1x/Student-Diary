package com.mikepenz.materialdrawer.model.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.IItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004J#\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0'H&¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0006H&J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H&J\u0015\u00101\u001a\u00028\u00002\u0006\u0010/\u001a\u000200H&¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H&¢\u0006\u0002\u00104R\u0018\u0010\u0005\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0018\u0010\u000e\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0015\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u0010R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001a¨\u00065"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IItem;", "Lcom/mikepenz/fastadapter/IExpandable;", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "isAutoExpanding", "", "()Z", "isEnabled", "setEnabled", "(Z)V", "isExpanded", "setExpanded", "isSelectable", "setSelectable", "isSelected", "setSelected", "layoutRes", "", "getLayoutRes", "()I", "tag", "", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "type", "getType", "bindView", "", "holder", "payloads", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "equals", "id", "generateView", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "getViewHolder", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "unbindView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: IDrawerItem.kt */
public interface IDrawerItem<VH extends RecyclerView.ViewHolder> extends IItem<VH>, IExpandable<VH> {
    void bindView(VH vh, List<Object> list);

    boolean equals(long j);

    View generateView(Context context);

    View generateView(Context context, ViewGroup viewGroup);

    long getIdentifier();

    int getLayoutRes();

    Object getTag();

    int getType();

    VH getViewHolder(ViewGroup viewGroup);

    boolean isAutoExpanding();

    boolean isEnabled();

    boolean isExpanded();

    boolean isSelectable();

    boolean isSelected();

    void setEnabled(boolean z);

    void setExpanded(boolean z);

    void setIdentifier(long j);

    void setSelectable(boolean z);

    void setSelected(boolean z);

    void setTag(Object obj);

    void unbindView(VH vh);
}

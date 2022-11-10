package com.mikepenz.fastadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH&¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001cJ\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000eH&J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+H&¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u0018\u0010\u000b\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010¨\u0006/"}, d2 = {"Lcom/mikepenz/fastadapter/IItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IIdentifyable;", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isSelectable", "setSelectable", "isSelected", "setSelected", "layoutRes", "", "getLayoutRes", "()I", "tag", "", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "type", "getType", "attachToWindow", "", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "bindView", "payloads", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "detachFromWindow", "equals", "id", "failedToRecycle", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "generateView", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "getViewHolder", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "unbindView", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: IItem.kt */
public interface IItem<VH extends RecyclerView.ViewHolder> extends IIdentifyable {
    void attachToWindow(VH vh);

    void bindView(VH vh, List<Object> list);

    void detachFromWindow(VH vh);

    boolean equals(int i);

    boolean failedToRecycle(VH vh);

    View generateView(Context context);

    View generateView(Context context, ViewGroup viewGroup);

    int getLayoutRes();

    Object getTag();

    int getType();

    VH getViewHolder(ViewGroup viewGroup);

    boolean isEnabled();

    boolean isSelectable();

    boolean isSelected();

    void setEnabled(boolean z);

    void setSelectable(boolean z);

    void setSelected(boolean z);

    void setTag(Object obj);

    void unbindView(VH vh);
}

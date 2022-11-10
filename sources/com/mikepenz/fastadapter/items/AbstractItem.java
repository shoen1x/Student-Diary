package com.mikepenz.fastadapter.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.mikepenz.fastadapter.IItem;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ#\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0017¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0015\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\u0015\u0010-\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0015\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020#H&¢\u0006\u0002\u00102J\u0015\u00100\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u00103J\b\u00104\u001a\u00020,H\u0016J\u0015\u00105\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"Lcom/mikepenz/fastadapter/items/AbstractItem;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/IItem;", "()V", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isSelectable", "setSelectable", "isSelected", "setSelected", "tag", "", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "attachToWindow", "", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "bindView", "payloads", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "createView", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "detachFromWindow", "equals", "other", "id", "", "failedToRecycle", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "generateView", "getViewHolder", "v", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hashCode", "unbindView", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractItem.kt */
public abstract class AbstractItem<VH extends RecyclerView.ViewHolder> implements IItem<VH> {
    private long identifier = -1;
    private boolean isEnabled = true;
    private boolean isSelectable = true;
    private boolean isSelected;
    private Object tag;

    public abstract VH getViewHolder(View view);

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long j) {
        this.identifier = j;
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public void setSelectable(boolean z) {
        this.isSelectable = z;
    }

    public void bindView(VH holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setSelected(isSelected());
    }

    public void unbindView(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
    }

    public void attachToWindow(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
    }

    public void detachFromWindow(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
    }

    public boolean failedToRecycle(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        return false;
    }

    public View createView(Context ctx, ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        View inflate = LayoutInflater.from(ctx).inflate(getLayoutRes(), parent, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(ctx)…layoutRes, parent, false)");
        return inflate;
    }

    public View generateView(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        RecyclerView.ViewHolder viewHolder = getViewHolder(createView(ctx, (ViewGroup) null));
        List emptyList = Collections.emptyList();
        Intrinsics.checkExpressionValueIsNotNull(emptyList, "Collections.emptyList()");
        bindView(viewHolder, emptyList);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "viewHolder.itemView");
        return view;
    }

    public View generateView(Context ctx, ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        RecyclerView.ViewHolder viewHolder = getViewHolder(createView(ctx, parent));
        List emptyList = Collections.emptyList();
        Intrinsics.checkExpressionValueIsNotNull(emptyList, "Collections.emptyList()");
        bindView(viewHolder, emptyList);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "viewHolder.itemView");
        return view;
    }

    public VH getViewHolder(ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "parent.context");
        return getViewHolder(createView(context, parent));
    }

    public boolean equals(int id) {
        return ((long) id) == getIdentifier();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || (!Intrinsics.areEqual((Object) getClass(), (Object) other.getClass()))) {
            return false;
        }
        AbstractItem that = (AbstractItem) (!(other instanceof AbstractItem) ? null : other);
        long identifier2 = getIdentifier();
        if (that == null || identifier2 != that.getIdentifier()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Long.valueOf(getIdentifier()).hashCode();
    }
}

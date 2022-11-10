package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0017H\u0016J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118WX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$ViewHolder;", "()V", "divider", "", "getDivider", "()Z", "setDivider", "(Z)V", "height", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getHeight", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setHeight", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "layoutRes", "", "getLayoutRes", "()I", "type", "getType", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewPosition", "Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$Position;", "getViewPosition", "()Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$Position;", "setViewPosition", "(Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$Position;)V", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "withDivider", "_divider", "withHeight", "withView", "withViewPosition", "position", "Position", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ContainerDrawerItem.kt */
public class ContainerDrawerItem extends AbstractDrawerItem<ContainerDrawerItem, ViewHolder> {
    private boolean divider = true;
    private DimenHolder height;
    private View view;
    private Position viewPosition = Position.TOP;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$Position;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "NONE", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ContainerDrawerItem.kt */
    public enum Position {
        TOP,
        BOTTOM,
        NONE
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Position.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Position.TOP.ordinal()] = 1;
            $EnumSwitchMapping$0[Position.BOTTOM.ordinal()] = 2;
        }
    }

    public final DimenHolder getHeight() {
        return this.height;
    }

    public final void setHeight(DimenHolder dimenHolder) {
        this.height = dimenHolder;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView(View view2) {
        this.view = view2;
    }

    public final Position getViewPosition() {
        return this.viewPosition;
    }

    public final void setViewPosition(Position position) {
        Intrinsics.checkParameterIsNotNull(position, "<set-?>");
        this.viewPosition = position;
    }

    public final boolean getDivider() {
        return this.divider;
    }

    public final void setDivider(boolean z) {
        this.divider = z;
    }

    public int getType() {
        return R.id.material_drawer_item_container;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_container;
    }

    public final ContainerDrawerItem withHeight(DimenHolder height2) {
        this.height = height2;
        return this;
    }

    public final ContainerDrawerItem withView(View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
        return this;
    }

    public final ContainerDrawerItem withViewPosition(Position position) {
        Intrinsics.checkParameterIsNotNull(position, "position");
        this.viewPosition = position;
        return this;
    }

    public final ContainerDrawerItem withDivider(boolean _divider) {
        this.divider = _divider;
        return this;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        ViewParent it;
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        Context ctx = view2.getContext();
        View view3 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        view3.setId(hashCode());
        holder.getView$materialdrawer().setEnabled(false);
        View view4 = this.view;
        if (!(view4 == null || (it = view4.getParent()) == null)) {
            if (it != null) {
                ((ViewGroup) it).removeView(this.view);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        int height2 = -2;
        DimenHolder it2 = this.height;
        if (it2 != null) {
            ViewGroup.LayoutParams layoutParams = holder.getView$materialdrawer().getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) layoutParams;
                height2 = it2.asPixel(ctx);
                lp.height = height2;
                holder.getView$materialdrawer().setLayoutParams(lp);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
        View view$materialdrawer = holder.getView$materialdrawer();
        if (view$materialdrawer != null) {
            ((ViewGroup) view$materialdrawer).removeAllViews();
            int dividerHeight = 0;
            if (this.divider) {
                dividerHeight = 1;
            }
            View divider2 = new View(ctx);
            divider2.setMinimumHeight(dividerHeight);
            divider2.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, R.attr.material_drawer_divider, R.color.material_drawer_divider));
            LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(-1, (int) UIUtils.convertDpToPixel((float) dividerHeight, ctx));
            LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(-1, this.height != null ? height2 - ((int) UIUtils.convertDpToPixel((float) dividerHeight, ctx)) : height2);
            int i = WhenMappings.$EnumSwitchMapping$0[this.viewPosition.ordinal()];
            if (i == 1) {
                ((ViewGroup) holder.getView$materialdrawer()).addView(this.view, viewParams);
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                dividerParams.bottomMargin = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_padding);
                ((ViewGroup) holder.getView$materialdrawer()).addView(divider2, dividerParams);
            } else if (i != 2) {
                ((ViewGroup) holder.getView$materialdrawer()).addView(this.view, viewParams);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                dividerParams.topMargin = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_padding);
                ((ViewGroup) holder.getView$materialdrawer()).addView(divider2, dividerParams);
                ((ViewGroup) holder.getView$materialdrawer()).addView(this.view, viewParams);
            }
            View view5 = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            onPostBindView(this, view5);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ContainerDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView$materialdrawer", "()Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ContainerDrawerItem.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }
    }
}

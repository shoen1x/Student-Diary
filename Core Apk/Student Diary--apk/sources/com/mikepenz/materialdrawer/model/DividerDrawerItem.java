package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058WX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/mikepenz/materialdrawer/model/DividerDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/DividerDrawerItem$ViewHolder;", "()V", "layoutRes", "", "getLayoutRes", "()I", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DividerDrawerItem.kt */
public class DividerDrawerItem extends AbstractDrawerItem<DividerDrawerItem, ViewHolder> {
    public int getType() {
        return R.id.material_drawer_item_divider;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_divider;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context ctx = view.getContext();
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        view2.setId(hashCode());
        holder.getView$materialdrawer().setClickable(false);
        holder.getView$materialdrawer().setEnabled(false);
        holder.getView$materialdrawer().setMinimumHeight(1);
        ViewCompat.setImportantForAccessibility(holder.getView$materialdrawer(), 2);
        holder.getDivider$materialdrawer().setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, R.attr.material_drawer_divider, R.color.material_drawer_divider));
        View view3 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        onPostBindView(this, view3);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/model/DividerDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "getDivider$materialdrawer", "()Landroid/view/View;", "getView$materialdrawer", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DividerDrawerItem.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final View divider;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.material_drawer_divider);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.material_drawer_divider)");
            this.divider = findViewById;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }

        public final View getDivider$materialdrawer() {
            return this.divider;
        }
    }
}

package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u001aJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020 R\u0014\u0010\t\u001a\u00020\n8WX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\f¨\u0006;"}, d2 = {"Lcom/mikepenz/materialdrawer/model/MiniDrawerItem;", "Lcom/mikepenz/materialdrawer/model/BaseDrawerItem;", "Lcom/mikepenz/materialdrawer/model/MiniDrawerItem$ViewHolder;", "primaryDrawerItem", "Lcom/mikepenz/materialdrawer/model/PrimaryDrawerItem;", "(Lcom/mikepenz/materialdrawer/model/PrimaryDrawerItem;)V", "secondaryDrawerItem", "Lcom/mikepenz/materialdrawer/model/SecondaryDrawerItem;", "(Lcom/mikepenz/materialdrawer/model/SecondaryDrawerItem;)V", "layoutRes", "", "getLayoutRes", "()I", "mBadge", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getMBadge", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setMBadge", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "mBadgeStyle", "Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "getMBadgeStyle", "()Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "setMBadgeStyle", "(Lcom/mikepenz/materialdrawer/holder/BadgeStyle;)V", "mCustomHeight", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getMCustomHeight", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setMCustomHeight", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "mEnableSelectedBackground", "", "getMEnableSelectedBackground", "()Z", "setMEnableSelectedBackground", "(Z)V", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withCustomHeight", "customHeight", "withCustomHeightDp", "customHeightDp", "withCustomHeightPx", "customHeightPx", "withCustomHeightRes", "customHeightRes", "withEnableSelectedBackground", "enableSelectedBackground", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: MiniDrawerItem.kt */
public class MiniDrawerItem extends BaseDrawerItem<MiniDrawerItem, ViewHolder> {
    private StringHolder mBadge;
    private BadgeStyle mBadgeStyle = new BadgeStyle();
    private DimenHolder mCustomHeight;
    private boolean mEnableSelectedBackground;

    public final StringHolder getMBadge() {
        return this.mBadge;
    }

    public final void setMBadge(StringHolder stringHolder) {
        this.mBadge = stringHolder;
    }

    public final BadgeStyle getMBadgeStyle() {
        return this.mBadgeStyle;
    }

    public final void setMBadgeStyle(BadgeStyle badgeStyle) {
        this.mBadgeStyle = badgeStyle;
    }

    public final boolean getMEnableSelectedBackground() {
        return this.mEnableSelectedBackground;
    }

    public final void setMEnableSelectedBackground(boolean z) {
        this.mEnableSelectedBackground = z;
    }

    public final DimenHolder getMCustomHeight() {
        return this.mCustomHeight;
    }

    public final void setMCustomHeight(DimenHolder dimenHolder) {
        this.mCustomHeight = dimenHolder;
    }

    public int getType() {
        return R.id.material_drawer_item_mini;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_mini;
    }

    public MiniDrawerItem(PrimaryDrawerItem primaryDrawerItem) {
        Intrinsics.checkParameterIsNotNull(primaryDrawerItem, "primaryDrawerItem");
        setIdentifier(primaryDrawerItem.getIdentifier());
        setTag(primaryDrawerItem.getTag());
        this.mBadge = primaryDrawerItem.getBadge();
        this.mBadgeStyle = primaryDrawerItem.getBadgeStyle();
        setEnabled(primaryDrawerItem.isEnabled());
        setSelectable(primaryDrawerItem.isSelectable());
        setSelected(primaryDrawerItem.isSelected());
        setIcon(primaryDrawerItem.getIcon());
        setSelectedIcon(primaryDrawerItem.getSelectedIcon());
        setIconTinted(primaryDrawerItem.isIconTinted());
        setSelectedColor(primaryDrawerItem.getSelectedColor());
        setIconColor(primaryDrawerItem.getIconColor());
        setSelectedIconColor(primaryDrawerItem.getSelectedIconColor());
        setDisabledIconColor(primaryDrawerItem.getDisabledIconColor());
    }

    public MiniDrawerItem(SecondaryDrawerItem secondaryDrawerItem) {
        Intrinsics.checkParameterIsNotNull(secondaryDrawerItem, "secondaryDrawerItem");
        setIdentifier(secondaryDrawerItem.getIdentifier());
        setTag(secondaryDrawerItem.getTag());
        this.mBadge = secondaryDrawerItem.getBadge();
        this.mBadgeStyle = secondaryDrawerItem.getBadgeStyle();
        setEnabled(secondaryDrawerItem.isEnabled());
        setSelectable(secondaryDrawerItem.isSelectable());
        setSelected(secondaryDrawerItem.isSelected());
        setIcon(secondaryDrawerItem.getIcon());
        setSelectedIcon(secondaryDrawerItem.getSelectedIcon());
        setIconTinted(secondaryDrawerItem.isIconTinted());
        setSelectedColor(secondaryDrawerItem.getSelectedColor());
        setIconColor(secondaryDrawerItem.getIconColor());
        setSelectedIconColor(secondaryDrawerItem.getSelectedIconColor());
        setDisabledIconColor(secondaryDrawerItem.getDisabledIconColor());
    }

    public final MiniDrawerItem withCustomHeightRes(int customHeightRes) {
        this.mCustomHeight = DimenHolder.Companion.fromResource(customHeightRes);
        return this;
    }

    public final MiniDrawerItem withCustomHeightDp(int customHeightDp) {
        this.mCustomHeight = DimenHolder.Companion.fromDp(customHeightDp);
        return this;
    }

    public final MiniDrawerItem withCustomHeightPx(int customHeightPx) {
        this.mCustomHeight = DimenHolder.Companion.fromPixel(customHeightPx);
        return this;
    }

    public final MiniDrawerItem withCustomHeight(DimenHolder customHeight) {
        Intrinsics.checkParameterIsNotNull(customHeight, "customHeight");
        this.mCustomHeight = customHeight;
        return this;
    }

    public final MiniDrawerItem withEnableSelectedBackground(boolean enableSelectedBackground) {
        this.mEnableSelectedBackground = enableSelectedBackground;
        return this;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        BadgeStyle badgeStyle;
        ViewHolder viewHolder = holder;
        List<Object> list = payloads;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        super.bindView(viewHolder, list);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context ctx = view.getContext();
        DimenHolder it = this.mCustomHeight;
        if (it != null) {
            View view2 = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) layoutParams;
                lp.height = it.asPixel(ctx);
                View view3 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                view3.setLayoutParams(lp);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
        View view4 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
        view4.setId(hashCode());
        View view5 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
        view5.setEnabled(isEnabled());
        View view6 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
        view6.setSelected(isSelected());
        View view7 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
        view7.setTag(this);
        Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
        int iconColor = getIconColor(ctx);
        int selectedIconColor = getSelectedIconColor(ctx);
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel(ctx);
        if (this.mEnableSelectedBackground) {
            DrawerUIUtils.INSTANCE.themeDrawerItem(ctx, holder.getView$materialdrawer(), getSelectedColor(ctx), isSelectedBackgroundAnimated(), shapeAppearanceModel);
        }
        if (StringHolder.Companion.applyToOrHide(this.mBadge, holder.getBadge$materialdrawer()) && (badgeStyle = this.mBadgeStyle) != null) {
            BadgeStyle.style$default(badgeStyle, holder.getBadge$materialdrawer(), (ColorStateList) null, 2, (Object) null);
        }
        Context context = ctx;
        Drawable icon = ImageHolder.Companion.decideIcon(getIcon(), context, iconColor, isIconTinted(), 1);
        Drawable selectedIcon = ImageHolder.Companion.decideIcon(getSelectedIcon(), context, selectedIconColor, isIconTinted(), 1);
        ImageHolder.Companion.applyMultiIconTo(icon, iconColor, selectedIcon, selectedIconColor, isIconTinted(), holder.getIcon$materialdrawer());
        int verticalPadding = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_padding);
        int topBottomPadding = ctx.getResources().getDimensionPixelSize(R.dimen.material_mini_drawer_item_padding);
        viewHolder.itemView.setPadding(verticalPadding, topBottomPadding, verticalPadding, topBottomPadding);
        View view8 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view8, "holder.itemView");
        onPostBindView(this, view8);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/materialdrawer/model/MiniDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "badge", "Landroid/widget/TextView;", "getBadge$materialdrawer", "()Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "getIcon$materialdrawer", "()Landroid/widget/ImageView;", "getView$materialdrawer", "()Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MiniDrawerItem.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView badge;
        private final ImageView icon;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.material_drawer_icon);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<ImageV….id.material_drawer_icon)");
            this.icon = (ImageView) findViewById;
            View findViewById2 = this.view.findViewById(R.id.material_drawer_badge);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<TextVi…id.material_drawer_badge)");
            this.badge = (TextView) findViewById2;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }

        public final ImageView getIcon$materialdrawer() {
            return this.icon;
        }

        public final TextView getBadge$materialdrawer() {
            return this.badge;
        }
    }
}

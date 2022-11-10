package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001)B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0017\u0010!\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00028\u00002\b\b\u0001\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010$J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010(R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138WX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006*"}, d2 = {"Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem;", "Item", "Lcom/mikepenz/materialdrawer/model/BaseDescribeableDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/ColorfulBadgeable;", "()V", "badge", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getBadge", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setBadge", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "badgeStyle", "Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "getBadgeStyle", "()Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "setBadgeStyle", "(Lcom/mikepenz/materialdrawer/holder/BadgeStyle;)V", "layoutRes", "", "getLayoutRes", "()I", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withBadge", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem;", "badgeRes", "(I)Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem;", "", "(Ljava/lang/String;)Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem;", "withBadgeStyle", "(Lcom/mikepenz/materialdrawer/holder/BadgeStyle;)Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem;", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractBadgeableDrawerItem.kt */
public abstract class AbstractBadgeableDrawerItem<Item extends AbstractBadgeableDrawerItem<Item>> extends BaseDescribeableDrawerItem<Item, ViewHolder> implements ColorfulBadgeable<Item> {
    private StringHolder badge;
    private BadgeStyle badgeStyle = new BadgeStyle();

    public StringHolder getBadge() {
        return this.badge;
    }

    public void setBadge(StringHolder stringHolder) {
        this.badge = stringHolder;
    }

    public BadgeStyle getBadgeStyle() {
        return this.badgeStyle;
    }

    public void setBadgeStyle(BadgeStyle badgeStyle2) {
        this.badgeStyle = badgeStyle2;
    }

    public int getType() {
        return R.id.material_drawer_item_primary;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_primary;
    }

    public Item withBadge(StringHolder badge2) {
        setBadge(badge2);
        return this;
    }

    public Item withBadge(String badge2) {
        Intrinsics.checkParameterIsNotNull(badge2, "badge");
        setBadge(new StringHolder((CharSequence) badge2));
        return this;
    }

    public Item withBadge(int badgeRes) {
        setBadge(new StringHolder(badgeRes));
        return this;
    }

    public Item withBadgeStyle(BadgeStyle badgeStyle2) {
        setBadgeStyle(badgeStyle2);
        return this;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context ctx = view.getContext();
        bindViewHelper(holder);
        if (StringHolder.Companion.applyToOrHide(getBadge(), holder.getBadge$materialdrawer())) {
            BadgeStyle badgeStyle2 = getBadgeStyle();
            if (badgeStyle2 != null) {
                TextView badge$materialdrawer = holder.getBadge$materialdrawer();
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                badgeStyle2.style(badge$materialdrawer, getTextColorStateList(getColor(ctx), getSelectedTextColor(ctx)));
            }
            holder.getBadgeContainer$materialdrawer().setVisibility(0);
        } else {
            holder.getBadgeContainer$materialdrawer().setVisibility(8);
        }
        if (getTypeface() != null) {
            holder.getBadge$materialdrawer().setTypeface(getTypeface());
        }
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        onPostBindView(this, view2);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/mikepenz/materialdrawer/model/AbstractBadgeableDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "badge", "Landroid/widget/TextView;", "getBadge$materialdrawer", "()Landroid/widget/TextView;", "badgeContainer", "getBadgeContainer$materialdrawer", "()Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AbstractBadgeableDrawerItem.kt */
    public static class ViewHolder extends BaseViewHolder {
        private final TextView badge;
        private final View badgeContainer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.material_drawer_badge_container);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.m…l_drawer_badge_container)");
            this.badgeContainer = findViewById;
            View findViewById2 = view.findViewById(R.id.material_drawer_badge);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<TextVi…id.material_drawer_badge)");
            this.badge = (TextView) findViewById2;
        }

        public final View getBadgeContainer$materialdrawer() {
            return this.badgeContainer;
        }

        public final TextView getBadge$materialdrawer() {
            return this.badge;
        }
    }
}

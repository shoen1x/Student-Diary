package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003:\u00019B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\u0010\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00104\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u00108\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8WX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000e¨\u0006:"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ExpandableBadgeDrawerItem;", "Lcom/mikepenz/materialdrawer/model/BaseDescribeableDrawerItem;", "Lcom/mikepenz/materialdrawer/model/ExpandableBadgeDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/ColorfulBadgeable;", "()V", "arrowColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getArrowColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setArrowColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "arrowRotationAngleEnd", "", "getArrowRotationAngleEnd", "()I", "setArrowRotationAngleEnd", "(I)V", "arrowRotationAngleStart", "getArrowRotationAngleStart", "setArrowRotationAngleStart", "badge", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getBadge", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setBadge", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "badgeStyle", "Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "getBadgeStyle", "()Lcom/mikepenz/materialdrawer/holder/BadgeStyle;", "setBadgeStyle", "(Lcom/mikepenz/materialdrawer/holder/BadgeStyle;)V", "layoutRes", "getLayoutRes", "mOnDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "onDrawerItemClickListener", "getOnDrawerItemClickListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "setOnDrawerItemClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)V", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withBadge", "badgeRes", "", "withBadgeStyle", "withOnDrawerItemClickListener", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableBadgeDrawerItem.kt */
public class ExpandableBadgeDrawerItem extends BaseDescribeableDrawerItem<ExpandableBadgeDrawerItem, ViewHolder> implements ColorfulBadgeable<ExpandableBadgeDrawerItem> {
    private ColorHolder arrowColor;
    private int arrowRotationAngleEnd = 180;
    private int arrowRotationAngleStart;
    private StringHolder badge;
    private BadgeStyle badgeStyle = new BadgeStyle();
    /* access modifiers changed from: private */
    public Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener = new ExpandableBadgeDrawerItem$onDrawerItemClickListener$1(this);

    public final ColorHolder getArrowColor() {
        return this.arrowColor;
    }

    public final void setArrowColor(ColorHolder colorHolder) {
        this.arrowColor = colorHolder;
    }

    public final int getArrowRotationAngleStart() {
        return this.arrowRotationAngleStart;
    }

    public final void setArrowRotationAngleStart(int i) {
        this.arrowRotationAngleStart = i;
    }

    public final int getArrowRotationAngleEnd() {
        return this.arrowRotationAngleEnd;
    }

    public final void setArrowRotationAngleEnd(int i) {
        this.arrowRotationAngleEnd = i;
    }

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
        return R.id.material_drawer_item_expandable_badge;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_expandable_badge;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.onDrawerItemClickListener;
    }

    public void setOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        this.onDrawerItemClickListener = onDrawerItemClickListener2;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        int i;
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context ctx = view.getContext();
        bindViewHelper(holder);
        if (StringHolder.Companion.applyToOrHide(getBadge(), holder.getBadge())) {
            BadgeStyle badgeStyle2 = getBadgeStyle();
            if (badgeStyle2 != null) {
                TextView badge2 = holder.getBadge();
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                badgeStyle2.style(badge2, getTextColorStateList(getColor(ctx), getSelectedTextColor(ctx)));
            }
            holder.getBadgeContainer().setVisibility(0);
        } else {
            holder.getBadgeContainer().setVisibility(8);
        }
        if (getTypeface() != null) {
            holder.getBadge().setTypeface(getTypeface());
        }
        if (holder.getArrow().getDrawable() instanceof IconicsDrawable) {
            Drawable drawable = holder.getArrow().getDrawable();
            if (drawable != null) {
                IconicsDrawable iconicsDrawable = (IconicsDrawable) drawable;
                IconicsColor.Companion companion = IconicsColor.Companion;
                ColorHolder colorHolder = this.arrowColor;
                if (colorHolder != null) {
                    i = colorHolder.color(ctx);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                    i = getIconColor(ctx);
                }
                iconicsDrawable.color(companion.colorInt(i));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.iconics.IconicsDrawable");
            }
        }
        holder.getArrow().clearAnimation();
        if (!isExpanded()) {
            holder.getArrow().setRotation((float) this.arrowRotationAngleStart);
        } else {
            holder.getArrow().setRotation((float) this.arrowRotationAngleEnd);
        }
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        onPostBindView(this, view2);
    }

    public ExpandableBadgeDrawerItem withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListener2, "onDrawerItemClickListener");
        this.mOnDrawerItemClickListener = onDrawerItemClickListener2;
        return this;
    }

    public ExpandableBadgeDrawerItem withBadge(StringHolder badge2) {
        setBadge(badge2);
        return this;
    }

    public ExpandableBadgeDrawerItem withBadge(String badge2) {
        Intrinsics.checkParameterIsNotNull(badge2, "badge");
        setBadge(new StringHolder((CharSequence) badge2));
        return this;
    }

    public ExpandableBadgeDrawerItem withBadge(int badgeRes) {
        setBadge(new StringHolder(badgeRes));
        return this;
    }

    public ExpandableBadgeDrawerItem withBadgeStyle(BadgeStyle badgeStyle2) {
        setBadgeStyle(badgeStyle2);
        return this;
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ExpandableBadgeDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "setArrow", "(Landroid/widget/ImageView;)V", "badge", "Landroid/widget/TextView;", "getBadge", "()Landroid/widget/TextView;", "setBadge", "(Landroid/widget/TextView;)V", "badgeContainer", "getBadgeContainer", "()Landroid/view/View;", "setBadgeContainer", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ExpandableBadgeDrawerItem.kt */
    public static final class ViewHolder extends BaseViewHolder {
        private ImageView arrow;
        private TextView badge;
        private View badgeContainer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.material_drawer_arrow);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.material_drawer_arrow)");
            this.arrow = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.material_drawer_badge_container);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.m…l_drawer_badge_container)");
            this.badgeContainer = findViewById2;
            View findViewById3 = view.findViewById(R.id.material_drawer_badge);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.material_drawer_badge)");
            this.badge = (TextView) findViewById3;
            ImageView imageView = this.arrow;
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
            imageView.setImageDrawable(new IconicsDrawable(context, (IIcon) MaterialDrawerFont.Icon.mdf_expand_more).size(IconicsSize.Companion.dp((Number) 16)).padding(IconicsSize.Companion.dp((Number) 2)).color(IconicsColor.Companion.colorInt(ViewCompat.MEASURED_STATE_MASK)));
        }

        public final ImageView getArrow() {
            return this.arrow;
        }

        public final void setArrow(ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.arrow = imageView;
        }

        public final View getBadgeContainer() {
            return this.badgeContainer;
        }

        public final void setBadgeContainer(View view) {
            Intrinsics.checkParameterIsNotNull(view, "<set-?>");
            this.badgeContainer = view;
        }

        public final TextView getBadge() {
            return this.badge;
        }

        public final void setBadge(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.badge = textView;
        }
    }
}

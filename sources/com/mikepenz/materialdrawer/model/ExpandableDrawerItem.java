package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u000bJ\u0010\u0010*\u001a\u00020\u00002\b\b\u0001\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u000bJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000b8WX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\r¨\u00061"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ExpandableDrawerItem;", "Lcom/mikepenz/materialdrawer/model/BaseDescribeableDrawerItem;", "Lcom/mikepenz/materialdrawer/model/ExpandableDrawerItem$ViewHolder;", "()V", "arrowColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getArrowColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setArrowColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "arrowRotationAngleEnd", "", "getArrowRotationAngleEnd", "()I", "setArrowRotationAngleEnd", "(I)V", "arrowRotationAngleStart", "getArrowRotationAngleStart", "setArrowRotationAngleStart", "layoutRes", "getLayoutRes", "mOnDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "getMOnDrawerItemClickListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "setMOnDrawerItemClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)V", "onDrawerItemClickListener", "getOnDrawerItemClickListener", "setOnDrawerItemClickListener", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withArrowColor", "withArrowColorRes", "arrowColorRes", "withArrowRotationAngleEnd", "angle", "withArrowRotationAngleStart", "withOnDrawerItemClickListener", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableDrawerItem.kt */
public class ExpandableDrawerItem extends BaseDescribeableDrawerItem<ExpandableDrawerItem, ViewHolder> {
    private ColorHolder arrowColor;
    private int arrowRotationAngleEnd = 180;
    private int arrowRotationAngleStart;
    private Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener = new ExpandableDrawerItem$onDrawerItemClickListener$1(this);

    public final Drawer.OnDrawerItemClickListener getMOnDrawerItemClickListener() {
        return this.mOnDrawerItemClickListener;
    }

    public final void setMOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener2;
    }

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

    public int getType() {
        return R.id.material_drawer_item_expandable;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_expandable;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.onDrawerItemClickListener;
    }

    public void setOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        this.onDrawerItemClickListener = onDrawerItemClickListener2;
    }

    public final ExpandableDrawerItem withArrowColor(int arrowColor2) {
        this.arrowColor = ColorHolder.Companion.fromColor(arrowColor2);
        return this;
    }

    public final ExpandableDrawerItem withArrowColorRes(int arrowColorRes) {
        this.arrowColor = ColorHolder.Companion.fromColorRes(arrowColorRes);
        return this;
    }

    public final ExpandableDrawerItem withArrowRotationAngleStart(int angle) {
        this.arrowRotationAngleStart = angle;
        return this;
    }

    public final ExpandableDrawerItem withArrowRotationAngleEnd(int angle) {
        this.arrowRotationAngleEnd = angle;
        return this;
    }

    public ExpandableDrawerItem withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListener2, "onDrawerItemClickListener");
        this.mOnDrawerItemClickListener = onDrawerItemClickListener2;
        return this;
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

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ExpandableDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "setArrow", "(Landroid/widget/ImageView;)V", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ExpandableDrawerItem.kt */
    public static final class ViewHolder extends BaseViewHolder {
        private ImageView arrow;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.material_drawer_arrow);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.material_drawer_arrow)");
            ImageView imageView = (ImageView) findViewById;
            this.arrow = imageView;
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
    }
}

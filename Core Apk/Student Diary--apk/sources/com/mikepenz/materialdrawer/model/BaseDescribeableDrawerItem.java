package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.BaseViewHolder;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0004J\u0015\u0010\u0015\u001a\u00028\u00002\b\b\u0001\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00028\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001d\u001a\u00028\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/mikepenz/materialdrawer/model/BaseDescribeableDrawerItem;", "T", "VH", "Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "Lcom/mikepenz/materialdrawer/model/BaseDrawerItem;", "()V", "description", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getDescription", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setDescription", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "descriptionTextColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getDescriptionTextColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setDescriptionTextColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "bindViewHelper", "", "viewHolder", "withDescription", "descriptionRes", "", "(I)Ljava/lang/Object;", "", "(Ljava/lang/String;)Ljava/lang/Object;", "withDescriptionTextColor", "color", "withDescriptionTextColorRes", "colorRes", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseDescribeableDrawerItem.kt */
public abstract class BaseDescribeableDrawerItem<T, VH extends BaseViewHolder> extends BaseDrawerItem<T, VH> {
    private StringHolder description;
    private ColorHolder descriptionTextColor;

    public final StringHolder getDescription() {
        return this.description;
    }

    public final void setDescription(StringHolder stringHolder) {
        this.description = stringHolder;
    }

    public final ColorHolder getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    public final void setDescriptionTextColor(ColorHolder colorHolder) {
        this.descriptionTextColor = colorHolder;
    }

    public final T withDescription(String description2) {
        Intrinsics.checkParameterIsNotNull(description2, "description");
        this.description = new StringHolder((CharSequence) description2);
        return this;
    }

    public final T withDescription(int descriptionRes) {
        this.description = new StringHolder(descriptionRes);
        return this;
    }

    public final T withDescriptionTextColor(int color) {
        this.descriptionTextColor = ColorHolder.Companion.fromColor(color);
        return this;
    }

    public final T withDescriptionTextColorRes(int colorRes) {
        this.descriptionTextColor = ColorHolder.Companion.fromColorRes(colorRes);
        return this;
    }

    /* access modifiers changed from: protected */
    public final void bindViewHelper(BaseViewHolder viewHolder) {
        BaseViewHolder baseViewHolder = viewHolder;
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "viewHolder");
        View view = baseViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "viewHolder.itemView");
        Context ctx = view.getContext();
        View view2 = baseViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "viewHolder.itemView");
        view2.setId(hashCode());
        View view3 = baseViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "viewHolder.itemView");
        view3.setSelected(isSelected());
        View view4 = baseViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "viewHolder.itemView");
        view4.setEnabled(isEnabled());
        Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
        int selectedColor = getSelectedColor(ctx);
        ColorStateList selectedTextColor = getTextColorStateList(getColor(ctx), getSelectedTextColor(ctx));
        int iconColor = getIconColor(ctx);
        int selectedIconColor = getSelectedIconColor(ctx);
        Context context = ctx;
        int i = selectedColor;
        DrawerUIUtils.INSTANCE.themeDrawerItem(context, viewHolder.getView$materialdrawer(), i, isSelectedBackgroundAnimated(), getShapeAppearanceModel(ctx));
        StringHolder.Companion.applyTo(getName(), viewHolder.getName$materialdrawer());
        StringHolder.Companion.applyToOrHide(this.description, viewHolder.getDescription$materialdrawer());
        viewHolder.getName$materialdrawer().setTextColor(selectedTextColor);
        ColorHolder colorHolder = this.descriptionTextColor;
        if (colorHolder != null) {
            colorHolder.applyToOr(viewHolder.getDescription$materialdrawer(), selectedTextColor);
        }
        if (getTypeface() != null) {
            viewHolder.getName$materialdrawer().setTypeface(getTypeface());
            viewHolder.getDescription$materialdrawer().setTypeface(getTypeface());
        }
        Drawable icon = ImageHolder.Companion.decideIcon(getIcon(), ctx, iconColor, isIconTinted(), 1);
        if (icon != null) {
            ImageHolder.Companion.applyMultiIconTo(icon, iconColor, ImageHolder.Companion.decideIcon(getSelectedIcon(), ctx, selectedIconColor, isIconTinted(), 1), selectedIconColor, isIconTinted(), viewHolder.getIcon$materialdrawer());
        } else {
            ImageHolder.Companion.applyDecidedIconOrSetGone((ImageHolder) icon, viewHolder.getIcon$materialdrawer(), iconColor, isIconTinted(), 1);
        }
        DrawerUIUtils.INSTANCE.setDrawerVerticalPadding(viewHolder.getView$materialdrawer(), getLevel());
    }
}

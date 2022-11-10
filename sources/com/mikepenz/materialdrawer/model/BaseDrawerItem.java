package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.Iconable;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u0016\u001a\u00020\u001e2\u0006\u00100\u001a\u000201J\u0010\u0010.\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0004J\u0015\u00102\u001a\u00028\u00002\b\b\u0001\u0010\t\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00002\b\b\u0001\u00105\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0017\u00106\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0002\u00108J\u0015\u00106\u001a\u00028\u00002\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J\u0017\u00106\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010<J\u0015\u00106\u001a\u00028\u00002\b\b\u0001\u0010=\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010>\u001a\u00028\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010?\u001a\u00028\u00002\b\b\u0001\u0010@\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010B\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00028\u00002\u0006\u0010E\u001a\u00020\u0019¢\u0006\u0002\u0010CJ\u0013\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0017\u0010G\u001a\u00028\u00002\b\u0010$\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010HJ\u0017\u0010G\u001a\u00028\u00002\b\b\u0001\u0010I\u001a\u00020\u001eH\u0016¢\u0006\u0002\u00103J\u0015\u0010G\u001a\u00028\u00002\u0006\u0010$\u001a\u00020JH\u0016¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00028\u00002\u0006\u0010*\u001a\u000207¢\u0006\u0002\u00108J\u0015\u0010L\u001a\u00028\u00002\b\b\u0001\u0010M\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010N\u001a\u00028\u00002\b\b\u0001\u0010-\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010O\u001a\u00028\u00002\b\b\u0001\u0010P\u001a\u00020\u001e¢\u0006\u0002\u00103J\u0015\u0010Q\u001a\u00028\u00002\u0006\u0010B\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010CR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e¨\u0006R"}, d2 = {"Lcom/mikepenz/materialdrawer/model/BaseDrawerItem;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/interfaces/Nameable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Iconable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Tagable;", "()V", "disabledIconColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getDisabledIconColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setDisabledIconColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setIcon", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)V", "iconColor", "getIconColor", "setIconColor", "isIconTinted", "", "()Z", "setIconTinted", "(Z)V", "<set-?>", "", "level", "getLevel", "()I", "setLevel", "(I)V", "name", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getName", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setName", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "selectedIcon", "getSelectedIcon", "setSelectedIcon", "selectedIconColor", "getSelectedIconColor", "setSelectedIconColor", "ctx", "Landroid/content/Context;", "withDisabledIconColor", "(I)Ljava/lang/Object;", "withDisabledIconColorRes", "disabledIconColorRes", "withIcon", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Object;", "iicon", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Lcom/mikepenz/iconics/typeface/IIcon;)Ljava/lang/Object;", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)Ljava/lang/Object;", "iconRes", "withIconColor", "withIconColorRes", "iconColorRes", "withIconTinted", "iconTinted", "(Z)Ljava/lang/Object;", "withIconTintingEnabled", "iconTintingEnabled", "withLevel", "withName", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)Ljava/lang/Object;", "nameRes", "", "(Ljava/lang/String;)Ljava/lang/Object;", "withSelectedIcon", "selectedIconRes", "withSelectedIconColor", "withSelectedIconColorRes", "selectedColorRes", "withTintSelectedIcon", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseDrawerItem.kt */
public abstract class BaseDrawerItem<T, VH extends RecyclerView.ViewHolder> extends AbstractDrawerItem<T, VH> implements Nameable<T>, Iconable<T>, Tagable<T> {
    private ColorHolder disabledIconColor;
    private ImageHolder icon;
    private ColorHolder iconColor;
    private boolean isIconTinted;
    private int level = 1;
    private StringHolder name;
    private ImageHolder selectedIcon;
    private ColorHolder selectedIconColor;

    public ImageHolder getIcon() {
        return this.icon;
    }

    public void setIcon(ImageHolder imageHolder) {
        this.icon = imageHolder;
    }

    public final ImageHolder getSelectedIcon() {
        return this.selectedIcon;
    }

    public final void setSelectedIcon(ImageHolder imageHolder) {
        this.selectedIcon = imageHolder;
    }

    public StringHolder getName() {
        return this.name;
    }

    public void setName(StringHolder stringHolder) {
        this.name = stringHolder;
    }

    public final boolean isIconTinted() {
        return this.isIconTinted;
    }

    public final void setIconTinted(boolean z) {
        this.isIconTinted = z;
    }

    public final ColorHolder getIconColor() {
        return this.iconColor;
    }

    public final void setIconColor(ColorHolder colorHolder) {
        this.iconColor = colorHolder;
    }

    public final ColorHolder getSelectedIconColor() {
        return this.selectedIconColor;
    }

    public final void setSelectedIconColor(ColorHolder colorHolder) {
        this.selectedIconColor = colorHolder;
    }

    public final ColorHolder getDisabledIconColor() {
        return this.disabledIconColor;
    }

    public final void setDisabledIconColor(ColorHolder colorHolder) {
        this.disabledIconColor = colorHolder;
    }

    public final int getLevel() {
        return this.level;
    }

    /* access modifiers changed from: protected */
    public final void setLevel(int i) {
        this.level = i;
    }

    public T withIcon(ImageHolder icon2) {
        setIcon(icon2);
        return this;
    }

    public T withIcon(Drawable icon2) {
        if (icon2 != null) {
            setIcon(new ImageHolder(icon2));
        } else {
            setIcon((ImageHolder) null);
        }
        return this;
    }

    public final T withIcon(int iconRes) {
        setIcon(new ImageHolder(iconRes));
        return this;
    }

    public final T withSelectedIcon(Drawable selectedIcon2) {
        Intrinsics.checkParameterIsNotNull(selectedIcon2, "selectedIcon");
        this.selectedIcon = new ImageHolder(selectedIcon2);
        return this;
    }

    public final T withSelectedIcon(int selectedIconRes) {
        this.selectedIcon = new ImageHolder(selectedIconRes);
        return this;
    }

    public T withIcon(IIcon iicon) {
        Intrinsics.checkParameterIsNotNull(iicon, "iicon");
        setIcon(new ImageHolder(iicon));
        if (Build.VERSION.SDK_INT >= 21) {
            this.selectedIcon = new ImageHolder(iicon);
        } else {
            withIconTintingEnabled(true);
        }
        return this;
    }

    public T withName(StringHolder name2) {
        setName(name2);
        return this;
    }

    public T withName(String name2) {
        Intrinsics.checkParameterIsNotNull(name2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        setName(new StringHolder((CharSequence) name2));
        return this;
    }

    public T withName(int nameRes) {
        setName(new StringHolder(nameRes));
        return this;
    }

    public final T withIconColor(int iconColor2) {
        this.iconColor = ColorHolder.Companion.fromColor(iconColor2);
        return this;
    }

    public final T withIconColorRes(int iconColorRes) {
        this.iconColor = ColorHolder.Companion.fromColorRes(iconColorRes);
        return this;
    }

    public final T withSelectedIconColor(int selectedIconColor2) {
        this.selectedIconColor = ColorHolder.Companion.fromColor(selectedIconColor2);
        return this;
    }

    public final T withSelectedIconColorRes(int selectedColorRes) {
        this.selectedIconColor = ColorHolder.Companion.fromColorRes(selectedColorRes);
        return this;
    }

    public final T withDisabledIconColor(int disabledIconColor2) {
        this.disabledIconColor = ColorHolder.Companion.fromColor(disabledIconColor2);
        return this;
    }

    public final T withDisabledIconColorRes(int disabledIconColorRes) {
        this.disabledIconColor = ColorHolder.Companion.fromColorRes(disabledIconColorRes);
        return this;
    }

    public final T withIconTintingEnabled(boolean iconTintingEnabled) {
        this.isIconTinted = iconTintingEnabled;
        return this;
    }

    @Deprecated(message = "")
    public final T withIconTinted(boolean iconTinted) {
        this.isIconTinted = iconTinted;
        return this;
    }

    @Deprecated(message = "")
    public final T withTintSelectedIcon(boolean iconTinted) {
        return withIconTintingEnabled(iconTinted);
    }

    public final T withLevel(int level2) {
        this.level = level2;
        return this;
    }

    public final int getIconColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        if (isEnabled()) {
            return ColorHolderKt.applyColor(this.iconColor, ctx, R.attr.material_drawer_primary_icon, R.color.material_drawer_primary_icon);
        }
        return ColorHolderKt.applyColor(this.disabledIconColor, ctx, R.attr.material_drawer_hint_icon, R.color.material_drawer_hint_icon);
    }

    /* access modifiers changed from: protected */
    public final int getSelectedIconColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return ColorHolderKt.applyColor(this.selectedIconColor, ctx, R.attr.material_drawer_selected_text, R.color.material_drawer_selected_text);
    }
}

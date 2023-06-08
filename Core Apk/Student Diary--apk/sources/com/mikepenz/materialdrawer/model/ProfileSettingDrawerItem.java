package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ImagesContract;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005:\u0001SB\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u00102\u001a\u0004\u0018\u00010\u000eJ\u0010\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u000205H\u0016J\u000e\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00002\b\b\u0001\u0010:\u001a\u00020$J\u000e\u00109\u001a\u00020\u00002\u0006\u00107\u001a\u000208J\u0010\u0010;\u001a\u00020\u00002\b\b\u0001\u0010<\u001a\u00020$J\u0010\u0010=\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020$J\u0012\u0010?\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BH\u0016J\u0012\u0010@\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020FH\u0016J\u0012\u0010@\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020$H\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010H\u001a\u000208H\u0016J\u0010\u0010I\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020$J\u0010\u0010J\u001a\u00020\u00002\b\b\u0001\u0010K\u001a\u00020$J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001dJ\u0012\u0010N\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010N\u001a\u00020\u00002\b\b\u0001\u0010P\u001a\u00020$J\u0010\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u001dH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020$8WX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&¨\u0006T"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ProfileSettingDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/ProfileSettingDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "Lcom/mikepenz/materialdrawer/model/interfaces/Tagable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Typefaceable;", "()V", "descriptionTextColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getDescriptionTextColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setDescriptionTextColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "email", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getEmail", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setEmail", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setIcon", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)V", "iconColor", "getIconColor", "setIconColor", "isIconTinted", "", "()Z", "setIconTinted", "(Z)V", "isSelectable", "setSelectable", "layoutRes", "", "getLayoutRes", "()I", "name", "getName", "setName", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getDescription", "getViewHolder", "v", "Landroid/view/View;", "setDescription", "description", "", "withDescription", "descriptionRes", "withDescriptionTextColor", "descriptionColor", "withDescriptionTextColorRes", "descriptionColorRes", "withEmail", "withIcon", "bitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "Lcom/mikepenz/iconics/typeface/IIcon;", "iconRes", "url", "withIconColor", "withIconColorRes", "iconColorRes", "withIconTinted", "iconTinted", "withName", "", "nameRes", "withSelectable", "selectable", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProfileSettingDrawerItem.kt */
public class ProfileSettingDrawerItem extends AbstractDrawerItem<ProfileSettingDrawerItem, ViewHolder> implements IProfile<ProfileSettingDrawerItem>, Tagable<ProfileSettingDrawerItem>, Typefaceable<ProfileSettingDrawerItem> {
    private ColorHolder descriptionTextColor;
    private StringHolder email;
    private ImageHolder icon;
    private ColorHolder iconColor;
    private boolean isIconTinted;
    private boolean isSelectable;
    private StringHolder name;

    public ImageHolder getIcon() {
        return this.icon;
    }

    public void setIcon(ImageHolder imageHolder) {
        this.icon = imageHolder;
    }

    public StringHolder getName() {
        return this.name;
    }

    public void setName(StringHolder stringHolder) {
        this.name = stringHolder;
    }

    public StringHolder getEmail() {
        return this.email;
    }

    public void setEmail(StringHolder stringHolder) {
        this.email = stringHolder;
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

    public final ColorHolder getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    public final void setDescriptionTextColor(ColorHolder colorHolder) {
        this.descriptionTextColor = colorHolder;
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public void setSelectable(boolean z) {
        this.isSelectable = z;
    }

    public int getType() {
        return R.id.material_drawer_item_profile_setting;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_profile_setting;
    }

    public ProfileSettingDrawerItem withIcon(Drawable icon2) {
        setIcon(new ImageHolder(icon2));
        return this;
    }

    public ProfileSettingDrawerItem withIcon(int iconRes) {
        setIcon(new ImageHolder(iconRes));
        return this;
    }

    public ProfileSettingDrawerItem withIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        setIcon(new ImageHolder(bitmap));
        return this;
    }

    public ProfileSettingDrawerItem withIcon(IIcon icon2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        setIcon(new ImageHolder(icon2));
        return this;
    }

    public ProfileSettingDrawerItem withIcon(String url) {
        Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
        setIcon(new ImageHolder(url));
        return this;
    }

    public ProfileSettingDrawerItem withIcon(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        setIcon(new ImageHolder(uri));
        return this;
    }

    public ProfileSettingDrawerItem withName(CharSequence name2) {
        setName(new StringHolder(name2));
        return this;
    }

    public final ProfileSettingDrawerItem withName(int nameRes) {
        setName(new StringHolder(nameRes));
        return this;
    }

    public final ProfileSettingDrawerItem withDescription(String description) {
        Intrinsics.checkParameterIsNotNull(description, "description");
        setEmail(new StringHolder((CharSequence) description));
        return this;
    }

    public final ProfileSettingDrawerItem withDescription(int descriptionRes) {
        setEmail(new StringHolder(descriptionRes));
        return this;
    }

    public ProfileSettingDrawerItem withEmail(String email2) {
        setEmail(new StringHolder((CharSequence) email2));
        return this;
    }

    public final ProfileSettingDrawerItem withDescriptionTextColor(int descriptionColor) {
        this.descriptionTextColor = ColorHolder.Companion.fromColor(descriptionColor);
        return this;
    }

    public final ProfileSettingDrawerItem withDescriptionTextColorRes(int descriptionColorRes) {
        this.descriptionTextColor = ColorHolder.Companion.fromColorRes(descriptionColorRes);
        return this;
    }

    public final ProfileSettingDrawerItem withIconColor(int iconColor2) {
        this.iconColor = ColorHolder.Companion.fromColor(iconColor2);
        return this;
    }

    public final ProfileSettingDrawerItem withIconColorRes(int iconColorRes) {
        this.iconColor = ColorHolder.Companion.fromColorRes(iconColorRes);
        return this;
    }

    public final ProfileSettingDrawerItem withIconTinted(boolean iconTinted) {
        this.isIconTinted = iconTinted;
        return this;
    }

    public final StringHolder getDescription() {
        return getEmail();
    }

    public final void setDescription(String description) {
        Intrinsics.checkParameterIsNotNull(description, "description");
        setEmail(new StringHolder((CharSequence) description));
    }

    public ProfileSettingDrawerItem withSelectable(boolean selectable) {
        setSelectable(selectable);
        return this;
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
        View view3 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        view3.setEnabled(isEnabled());
        View view4 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
        view4.setSelected(isSelected());
        Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
        int selectedColor = getSelectedColor(ctx);
        int color = ColorHolderKt.applyColor(getTextColor(), ctx, R.attr.material_drawer_primary_text, R.color.material_drawer_primary_text);
        int iconColor2 = ColorHolderKt.applyColor(this.iconColor, ctx, R.attr.material_drawer_primary_icon, R.color.material_drawer_primary_icon);
        int descriptionColor = ColorHolderKt.applyColor(this.descriptionTextColor, ctx, R.attr.material_drawer_primary_text, R.color.material_drawer_primary_text);
        ViewCompat.setBackground(holder.getView$materialdrawer(), UIUtils.getSelectableBackground(ctx, selectedColor, isSelectedBackgroundAnimated()));
        StringHolder.Companion.applyTo(getName(), holder.getName$materialdrawer());
        holder.getName$materialdrawer().setTextColor(color);
        StringHolder.Companion.applyToOrHide(getDescription(), holder.getDescription$materialdrawer());
        holder.getDescription$materialdrawer().setTextColor(descriptionColor);
        if (getTypeface() != null) {
            holder.getName$materialdrawer().setTypeface(getTypeface());
            holder.getDescription$materialdrawer().setTypeface(getTypeface());
        }
        ImageHolder.Companion.applyDecidedIconOrSetGone(getIcon(), holder.getIcon$materialdrawer(), iconColor2, this.isIconTinted, 2);
        DrawerUIUtils.INSTANCE.setDrawerVerticalPadding(holder.getView$materialdrawer());
        View view5 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
        onPostBindView(this, view5);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ProfileSettingDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "getDescription$materialdrawer", "()Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "getIcon$materialdrawer", "()Landroid/widget/ImageView;", "name", "getName$materialdrawer", "getView$materialdrawer", "()Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProfileSettingDrawerItem.kt */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView description;
        private final ImageView icon;
        private final TextView name;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.material_drawer_icon);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<ImageV….id.material_drawer_icon)");
            this.icon = (ImageView) findViewById;
            View findViewById2 = this.view.findViewById(R.id.material_drawer_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<TextVi….id.material_drawer_name)");
            this.name = (TextView) findViewById2;
            View findViewById3 = this.view.findViewById(R.id.material_drawer_description);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById<TextVi…erial_drawer_description)");
            this.description = (TextView) findViewById3;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }

        public final ImageView getIcon$materialdrawer() {
            return this.icon;
        }

        public final TextView getName$materialdrawer() {
            return this.name;
        }

        public final TextView getDescription$materialdrawer() {
            return this.description;
        }
    }
}

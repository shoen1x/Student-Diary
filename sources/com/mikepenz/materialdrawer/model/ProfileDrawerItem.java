package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ImagesContract;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0001:B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00002\b\b\u0001\u0010*\u001a\u00020\u0018J\u0012\u0010)\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010,\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010,\u001a\u00020\u00002\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u000202H\u0016J\u0012\u0010,\u001a\u00020\u00002\b\b\u0001\u00103\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00002\u0006\u00104\u001a\u00020+H\u0016J\u0012\u00105\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u000106H\u0016J\u0010\u00105\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u0018J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188WX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a¨\u0006;"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ProfileDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/ProfileDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "Lcom/mikepenz/materialdrawer/model/interfaces/Tagable;", "()V", "email", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getEmail", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setEmail", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setIcon", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)V", "isNameShown", "", "()Z", "setNameShown", "(Z)V", "layoutRes", "", "getLayoutRes", "()I", "name", "getName", "setName", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withEmail", "emailRes", "", "withIcon", "bitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "Lcom/mikepenz/iconics/typeface/IIcon;", "iconRes", "url", "withName", "", "nameRes", "withNameShown", "nameShown", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProfileDrawerItem.kt */
public class ProfileDrawerItem extends AbstractDrawerItem<ProfileDrawerItem, ViewHolder> implements IProfile<ProfileDrawerItem>, Tagable<ProfileDrawerItem> {
    private StringHolder email;
    private ImageHolder icon;
    private boolean isNameShown;
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

    public final boolean isNameShown() {
        return this.isNameShown;
    }

    public final void setNameShown(boolean z) {
        this.isNameShown = z;
    }

    public int getType() {
        return R.id.material_drawer_item_profile;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_profile;
    }

    public ProfileDrawerItem withIcon(Drawable icon2) {
        setIcon(new ImageHolder(icon2));
        return this;
    }

    public ProfileDrawerItem withIcon(int iconRes) {
        setIcon(new ImageHolder(iconRes));
        return this;
    }

    public ProfileDrawerItem withIcon(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        setIcon(new ImageHolder(bitmap));
        return this;
    }

    public ProfileDrawerItem withIcon(IIcon icon2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        setIcon(new ImageHolder(icon2));
        return this;
    }

    public ProfileDrawerItem withIcon(String url) {
        Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
        setIcon(new ImageHolder(url));
        return this;
    }

    public ProfileDrawerItem withIcon(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        setIcon(new ImageHolder(uri));
        return this;
    }

    public ProfileDrawerItem withName(CharSequence name2) {
        setName(new StringHolder(name2));
        return this;
    }

    public final ProfileDrawerItem withName(int nameRes) {
        setName(new StringHolder(nameRes));
        return this;
    }

    public ProfileDrawerItem withEmail(String email2) {
        setEmail(new StringHolder((CharSequence) email2));
        return this;
    }

    public final ProfileDrawerItem withEmail(int emailRes) {
        setEmail(new StringHolder(emailRes));
        return this;
    }

    public final ProfileDrawerItem withNameShown(boolean nameShown) {
        this.isNameShown = nameShown;
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
        int color = getColor(ctx);
        int selectedTextColor = getSelectedTextColor(ctx);
        Context context = ctx;
        int i = selectedColor;
        DrawerUIUtils.INSTANCE.themeDrawerItem(context, holder.getView$materialdrawer(), i, isSelectedBackgroundAnimated(), getShapeAppearanceModel(ctx));
        if (this.isNameShown) {
            holder.getName$materialdrawer().setVisibility(0);
            StringHolder.Companion.applyTo(getName(), holder.getName$materialdrawer());
        } else {
            holder.getName$materialdrawer().setVisibility(8);
        }
        if (this.isNameShown || getEmail() != null || getName() == null) {
            StringHolder.Companion.applyTo(getEmail(), holder.getEmail$materialdrawer());
        } else {
            StringHolder.Companion.applyTo(getName(), holder.getEmail$materialdrawer());
        }
        if (getTypeface() != null) {
            holder.getName$materialdrawer().setTypeface(getTypeface());
            holder.getEmail$materialdrawer().setTypeface(getTypeface());
        }
        if (this.isNameShown) {
            holder.getName$materialdrawer().setTextColor(getTextColorStateList(color, selectedTextColor));
        }
        holder.getEmail$materialdrawer().setTextColor(getTextColorStateList(color, selectedTextColor));
        DrawerImageLoader.Companion.getInstance().cancelImage(holder.getProfileIcon$materialdrawer());
        ImageHolder.Companion.applyToOrSetInvisible(getIcon(), holder.getProfileIcon$materialdrawer(), DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name());
        DrawerUIUtils.INSTANCE.setDrawerVerticalPadding(holder.getView$materialdrawer());
        View view5 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
        onPostBindView(this, view5);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/mikepenz/materialdrawer/model/ProfileDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "email", "Landroid/widget/TextView;", "getEmail$materialdrawer", "()Landroid/widget/TextView;", "name", "getName$materialdrawer", "profileIcon", "Landroid/widget/ImageView;", "getProfileIcon$materialdrawer", "()Landroid/widget/ImageView;", "getView$materialdrawer", "()Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProfileDrawerItem.kt */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView email;
        private final TextView name;
        private final ImageView profileIcon;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.material_drawer_profileIcon);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.m…erial_drawer_profileIcon)");
            this.profileIcon = (ImageView) findViewById;
            View findViewById2 = this.view.findViewById(R.id.material_drawer_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.material_drawer_name)");
            this.name = (TextView) findViewById2;
            View findViewById3 = this.view.findViewById(R.id.material_drawer_email);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.material_drawer_email)");
            this.email = (TextView) findViewById3;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }

        public final ImageView getProfileIcon$materialdrawer() {
            return this.profileIcon;
        }

        public final TextView getName$materialdrawer() {
            return this.name;
        }

        public final TextView getEmail$materialdrawer() {
            return this.email;
        }
    }
}

package com.mikepenz.materialdrawer.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001@B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u001bJ\u0010\u00101\u001a\u00020\u00002\b\b\u0001\u00102\u001a\u00020\u001bJ\u0012\u00103\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u000207H\u0016J\u0012\u00105\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u000108H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00109\u001a\u00020:H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020;H\u0016J\u0012\u00105\u001a\u00020\u00002\b\b\u0001\u0010<\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u0010=\u001a\u000204H\u0016J\u0012\u0010>\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010?H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8WX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001d¨\u0006A"}, d2 = {"Lcom/mikepenz/materialdrawer/model/MiniProfileDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/MiniProfileDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "()V", "profile", "Lcom/mikepenz/materialdrawer/model/ProfileDrawerItem;", "(Lcom/mikepenz/materialdrawer/model/ProfileDrawerItem;)V", "customHeight", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getCustomHeight", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setCustomHeight", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "email", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getEmail", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setEmail", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setIcon", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)V", "layoutRes", "", "getLayoutRes", "()I", "name", "getName", "setName", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withCustomHeight", "withCustomHeightDp", "customHeightDp", "withCustomHeightPx", "customHeightPx", "withCustomHeightRes", "customHeightRes", "withEmail", "", "withIcon", "iconBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "Lcom/mikepenz/iconics/typeface/IIcon;", "iconRes", "url", "withName", "", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: MiniProfileDrawerItem.kt */
public class MiniProfileDrawerItem extends AbstractDrawerItem<MiniProfileDrawerItem, ViewHolder> implements IProfile<MiniProfileDrawerItem> {
    private DimenHolder customHeight;
    private StringHolder email;
    private ImageHolder icon;
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

    public final DimenHolder getCustomHeight() {
        return this.customHeight;
    }

    public final void setCustomHeight(DimenHolder dimenHolder) {
        this.customHeight = dimenHolder;
    }

    public int getType() {
        return R.id.material_drawer_item_mini_profile;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_mini_profile;
    }

    public MiniProfileDrawerItem() {
        withSelectable(false);
    }

    public MiniProfileDrawerItem(ProfileDrawerItem profile) {
        Intrinsics.checkParameterIsNotNull(profile, Scopes.PROFILE);
        setIcon(profile.getIcon());
        setEnabled(profile.isEnabled());
        withSelectable(false);
    }

    public MiniProfileDrawerItem withName(CharSequence name2) {
        StringHolder stringHolder;
        if (name2 != null) {
            CharSequence charSequence = name2;
            stringHolder = new StringHolder(name2);
        } else {
            stringHolder = null;
        }
        setName(stringHolder);
        return this;
    }

    public MiniProfileDrawerItem withEmail(String email2) {
        return this;
    }

    public MiniProfileDrawerItem withIcon(Drawable icon2) {
        ImageHolder imageHolder;
        if (icon2 != null) {
            Drawable drawable = icon2;
            imageHolder = new ImageHolder(icon2);
        } else {
            imageHolder = null;
        }
        setIcon(imageHolder);
        return this;
    }

    public MiniProfileDrawerItem withIcon(int iconRes) {
        setIcon(new ImageHolder(iconRes));
        return this;
    }

    public MiniProfileDrawerItem withIcon(Bitmap iconBitmap) {
        Intrinsics.checkParameterIsNotNull(iconBitmap, "iconBitmap");
        setIcon(new ImageHolder(iconBitmap));
        return this;
    }

    public MiniProfileDrawerItem withIcon(String url) {
        Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
        setIcon(new ImageHolder(url));
        return this;
    }

    public MiniProfileDrawerItem withIcon(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        setIcon(new ImageHolder(uri));
        return this;
    }

    public MiniProfileDrawerItem withIcon(IIcon icon2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        setIcon(new ImageHolder(icon2));
        return this;
    }

    public final MiniProfileDrawerItem withCustomHeightRes(int customHeightRes) {
        this.customHeight = DimenHolder.Companion.fromResource(customHeightRes);
        return this;
    }

    public final MiniProfileDrawerItem withCustomHeightDp(int customHeightDp) {
        this.customHeight = DimenHolder.Companion.fromDp(customHeightDp);
        return this;
    }

    public final MiniProfileDrawerItem withCustomHeightPx(int customHeightPx) {
        this.customHeight = DimenHolder.Companion.fromPixel(customHeightPx);
        return this;
    }

    public final MiniProfileDrawerItem withCustomHeight(DimenHolder customHeight2) {
        Intrinsics.checkParameterIsNotNull(customHeight2, "customHeight");
        this.customHeight = customHeight2;
        return this;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        DimenHolder it = this.customHeight;
        if (it != null) {
            View view = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) layoutParams;
                View view2 = holder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
                lp.height = it.asPixel(view2.getContext());
                View view3 = holder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                view3.setLayoutParams(lp);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
        View view4 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
        view4.setId(hashCode());
        View view5 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
        view5.setEnabled(isEnabled());
        ImageHolder.Companion.applyToOrSetInvisible$default(ImageHolder.Companion, getIcon(), holder.getIcon$materialdrawer(), (String) null, 4, (Object) null);
        View view6 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
        onPostBindView(this, view6);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/model/MiniProfileDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon$materialdrawer", "()Landroid/widget/ImageView;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MiniProfileDrawerItem.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.material_drawer_icon);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<ImageV….id.material_drawer_icon)");
            this.icon = (ImageView) findViewById;
        }

        public final ImageView getIcon$materialdrawer() {
            return this.icon;
        }
    }
}

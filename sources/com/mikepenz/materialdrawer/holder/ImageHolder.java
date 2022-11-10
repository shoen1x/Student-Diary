package com.mikepenz.materialdrawer.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.gms.common.internal.ImagesContract;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB\u0011\b\u0016\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0013¨\u0006$"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "Lcom/mikepenz/materialize/holder/ImageHolder;", "url", "", "(Ljava/lang/String;)V", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "icon", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "iconRes", "", "(I)V", "iicon", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Lcom/mikepenz/iconics/typeface/IIcon;)V", "iIcon", "getIIcon", "()Lcom/mikepenz/iconics/typeface/IIcon;", "setIIcon", "applyTo", "", "imageView", "Landroid/widget/ImageView;", "tag", "decideIcon", "ctx", "Landroid/content/Context;", "iconColor", "tint", "paddingDp", "Companion", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageHolder.kt */
public class ImageHolder extends com.mikepenz.materialize.holder.ImageHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private IIcon iIcon;

    public final IIcon getIIcon() {
        return this.iIcon;
    }

    public final void setIIcon(IIcon iIcon2) {
        this.iIcon = iIcon2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageHolder(String url) {
        super(url);
        Intrinsics.checkParameterIsNotNull(url, ImagesContract.URL);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageHolder(Uri uri) {
        super(uri);
        Intrinsics.checkParameterIsNotNull(uri, "uri");
    }

    public ImageHolder(Drawable icon) {
        super(icon);
    }

    public ImageHolder(Bitmap bitmap) {
        super(bitmap);
    }

    public ImageHolder(int iconRes) {
        super(iconRes);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageHolder(IIcon iicon) {
        super((Bitmap) null);
        Intrinsics.checkParameterIsNotNull(iicon, "iicon");
        this.iIcon = iicon;
    }

    public boolean applyTo(ImageView imageView, String tag) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        IIcon ii = this.iIcon;
        if (getUri() != null) {
            DrawerImageLoader instance = DrawerImageLoader.Companion.getInstance();
            Uri uri = getUri();
            Intrinsics.checkExpressionValueIsNotNull(uri, "uri");
            if (instance.setImage(imageView, uri, tag)) {
                return true;
            }
            imageView.setImageURI(getUri());
            return true;
        } else if (getIcon() != null) {
            imageView.setImageDrawable(getIcon());
            return true;
        } else if (getBitmap() != null) {
            imageView.setImageBitmap(getBitmap());
            return true;
        } else if (getIconRes() != -1) {
            imageView.setImageResource(getIconRes());
            return true;
        } else if (ii != null) {
            Context context = imageView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "imageView.context");
            imageView.setImageDrawable(new IconicsDrawable(context, ii).actionBar());
            return true;
        } else {
            imageView.setImageBitmap((Bitmap) null);
            return false;
        }
    }

    public final Drawable decideIcon(Context ctx, int iconColor, boolean tint, int paddingDp) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Drawable icon = getIcon();
        IIcon ii = this.iIcon;
        if (ii != null) {
            icon = new IconicsDrawable(ctx, ii).color(IconicsColor.Companion.colorInt(iconColor)).size(IconicsSize.Companion.dp((Number) 24)).padding(IconicsSize.Companion.dp(Integer.valueOf(paddingDp)));
        } else if (getIconRes() != -1) {
            icon = AppCompatResources.getDrawable(ctx, getIconRes());
        } else if (getUri() != null) {
            try {
                icon = Drawable.createFromStream(ctx.getContentResolver().openInputStream(getUri()), getUri().toString());
            } catch (FileNotFoundException e) {
            }
        }
        if (icon != null && tint && this.iIcon == null && (icon = icon.mutate()) != null) {
            icon.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
        }
        return icon;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ:\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J2\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n¨\u0006\u001a"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/ImageHolder$Companion;", "", "()V", "applyDecidedIconOrSetGone", "", "imageHolder", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "imageView", "Landroid/widget/ImageView;", "iconColor", "", "tint", "", "paddingDp", "applyMultiIconTo", "icon", "Landroid/graphics/drawable/Drawable;", "selectedIcon", "selectedIconColor", "tinted", "applyToOrSetInvisible", "tag", "", "decideIcon", "ctx", "Landroid/content/Context;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ImageHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Drawable decideIcon(ImageHolder imageHolder, Context ctx, int iconColor, boolean tint, int paddingDp) {
            Intrinsics.checkParameterIsNotNull(ctx, "ctx");
            if (imageHolder != null) {
                return imageHolder.decideIcon(ctx, iconColor, tint, paddingDp);
            }
            return null;
        }

        public final void applyDecidedIconOrSetGone(ImageHolder imageHolder, ImageView imageView, int iconColor, boolean tint, int paddingDp) {
            if (imageHolder != null && imageView != null) {
                Companion companion = ImageHolder.Companion;
                Context context = imageView.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "imageView.context");
                Drawable drawable = companion.decideIcon(imageHolder, context, iconColor, tint, paddingDp);
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                } else if (imageHolder.getBitmap() != null) {
                    imageView.setImageBitmap(imageHolder.getBitmap());
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        public final void applyMultiIconTo(Drawable icon, int iconColor, Drawable selectedIcon, int selectedIconColor, boolean tinted, ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "imageView");
            com.mikepenz.materialize.holder.ImageHolder.applyMultiIconTo(icon, iconColor, selectedIcon, selectedIconColor, tinted, imageView);
        }

        public static /* synthetic */ void applyToOrSetInvisible$default(Companion companion, ImageHolder imageHolder, ImageView imageView, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            companion.applyToOrSetInvisible(imageHolder, imageView, str);
        }

        public final void applyToOrSetInvisible(ImageHolder imageHolder, ImageView imageView, String tag) {
            com.mikepenz.materialize.holder.ImageHolder.applyToOrSetInvisible(imageHolder, imageView, tag);
        }
    }
}

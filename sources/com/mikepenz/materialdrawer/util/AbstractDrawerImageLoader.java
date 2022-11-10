package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J!\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J+\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/materialdrawer/util/AbstractDrawerImageLoader;", "Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;", "()V", "cancel", "", "imageView", "Landroid/widget/ImageView;", "placeholder", "Landroid/graphics/drawable/Drawable;", "ctx", "Landroid/content/Context;", "tag", "", "set", "uri", "Landroid/net/Uri;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractDrawerImageLoader.kt */
public abstract class AbstractDrawerImageLoader implements DrawerImageLoader.IDrawerImageLoader {
    public void set(ImageView imageView, Uri uri, Drawable placeholder) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(placeholder, "placeholder");
    }

    public void set(ImageView imageView, Uri uri, Drawable placeholder, String tag) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(placeholder, "placeholder");
        set(imageView, uri, placeholder);
        Log.i("MaterialDrawer", "You have not specified a ImageLoader implementation through the DrawerImageLoader.init() method, or you are still overriding the deprecated method set(ImageView iv, Uri u, Drawable d) instead of set(ImageView iv, Uri u, Drawable d, String tag)");
    }

    public void cancel(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
    }

    public Drawable placeholder(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return DrawerUIUtils.INSTANCE.getPlaceHolder(ctx);
    }

    public Drawable placeholder(Context ctx, String tag) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return placeholder(ctx);
    }
}

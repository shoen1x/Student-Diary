package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tJ\u001f\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0019\"\u00020\f¢\u0006\u0002\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerImageLoader;", "", "imageLoader", "Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;", "(Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;)V", "getImageLoader", "()Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;", "setImageLoader", "mHandleAllProtocols", "", "mHandledProtocols", "", "", "cancelImage", "", "imageView", "Landroid/widget/ImageView;", "setImage", "uri", "Landroid/net/Uri;", "tag", "withHandleAllProtocols", "handleAllProtocols", "withProtocols", "protocols", "", "([Ljava/lang/String;)Lcom/mikepenz/materialdrawer/util/DrawerImageLoader;", "Companion", "IDrawerImageLoader", "Tags", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerImageLoader.kt */
public class DrawerImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static DrawerImageLoader SINGLETON;
    private IDrawerImageLoader imageLoader;
    private boolean mHandleAllProtocols;
    private List<String> mHandledProtocols;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H§\u0002J+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦\u0002¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;", "", "cancel", "", "imageView", "Landroid/widget/ImageView;", "placeholder", "Landroid/graphics/drawable/Drawable;", "ctx", "Landroid/content/Context;", "tag", "", "set", "uri", "Landroid/net/Uri;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DrawerImageLoader.kt */
    public interface IDrawerImageLoader {
        void cancel(ImageView imageView);

        Drawable placeholder(Context context);

        Drawable placeholder(Context context, String str);

        @Deprecated(message = "")
        void set(ImageView imageView, Uri uri, Drawable drawable);

        void set(ImageView imageView, Uri uri, Drawable drawable, String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$Tags;", "", "(Ljava/lang/String;I)V", "PROFILE", "PROFILE_DRAWER_ITEM", "ACCOUNT_HEADER", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DrawerImageLoader.kt */
    public enum Tags {
        PROFILE,
        PROFILE_DRAWER_ITEM,
        ACCOUNT_HEADER
    }

    private DrawerImageLoader(IDrawerImageLoader imageLoader2) {
        this.imageLoader = imageLoader2;
        this.mHandledProtocols = CollectionsKt.listOf("http", "https");
    }

    public /* synthetic */ DrawerImageLoader(IDrawerImageLoader imageLoader2, DefaultConstructorMarker $constructor_marker) {
        this(imageLoader2);
    }

    public final IDrawerImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final void setImageLoader(IDrawerImageLoader iDrawerImageLoader) {
        this.imageLoader = iDrawerImageLoader;
    }

    public final DrawerImageLoader withHandleAllProtocols(boolean handleAllProtocols) {
        this.mHandleAllProtocols = handleAllProtocols;
        return this;
    }

    public final DrawerImageLoader withProtocols(String... protocols) {
        Intrinsics.checkParameterIsNotNull(protocols, "protocols");
        this.mHandledProtocols = ArraysKt.toList((T[]) protocols);
        return this;
    }

    public boolean setImage(ImageView imageView, Uri uri, String tag) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (!this.mHandleAllProtocols && !this.mHandledProtocols.contains(uri.getScheme())) {
            return false;
        }
        IDrawerImageLoader it = this.imageLoader;
        if (it != null) {
            Context context = imageView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "imageView.context");
            it.set(imageView, uri, it.placeholder(context, tag), tag);
        }
        return true;
    }

    public final void cancelImage(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        IDrawerImageLoader iDrawerImageLoader = this.imageLoader;
        if (iDrawerImageLoader != null) {
            iDrawerImageLoader.cancel(imageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$Companion;", "", "()V", "SINGLETON", "Lcom/mikepenz/materialdrawer/util/DrawerImageLoader;", "instance", "getInstance", "()Lcom/mikepenz/materialdrawer/util/DrawerImageLoader;", "init", "loaderImpl", "Lcom/mikepenz/materialdrawer/util/DrawerImageLoader$IDrawerImageLoader;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DrawerImageLoader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final DrawerImageLoader init(IDrawerImageLoader loaderImpl) {
            Intrinsics.checkParameterIsNotNull(loaderImpl, "loaderImpl");
            DrawerImageLoader.SINGLETON = new DrawerImageLoader(loaderImpl, (DefaultConstructorMarker) null);
            DrawerImageLoader access$getSINGLETON$cp = DrawerImageLoader.SINGLETON;
            if (access$getSINGLETON$cp != null) {
                return access$getSINGLETON$cp;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.util.DrawerImageLoader");
        }

        public final DrawerImageLoader getInstance() {
            if (DrawerImageLoader.SINGLETON == null) {
                DrawerImageLoader.SINGLETON = new DrawerImageLoader(new DrawerImageLoader$Companion$instance$1(), (DefaultConstructorMarker) null);
            }
            DrawerImageLoader access$getSINGLETON$cp = DrawerImageLoader.SINGLETON;
            if (access$getSINGLETON$cp != null) {
                return access$getSINGLETON$cp;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.util.DrawerImageLoader");
        }
    }
}

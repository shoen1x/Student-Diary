package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterCompat;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsArrayBuilder;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.mikepenz.iconics.context.IconicsLayoutInflater;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\b\u001a\u00020\t*\u00020\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a%\u0010\b\u001a\u00020\r*\u00020\u000f2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a%\u0010\b\u001a\u00020\r*\u00020\u00102\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a%\u0010\b\u001a\u00020\t*\u00020\u00012\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a)\u0010\b\u001a\u00020\t*\u00060\u0011j\u0002`\u00122\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e\u001a.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00152\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0018\u001a\u00020\r*\u00020\u0019\u001a.\u0010\u001a\u001a\u00020\r*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007\u001a(\u0010$\u001a\u00020\r*\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007\u001a\u0012\u0010%\u001a\u00020\r*\u00020&2\u0006\u0010'\u001a\u00020(\u001a\n\u0010)\u001a\u00020**\u00020\u001d\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006+"}, d2 = {"clearedIconName", "", "", "getClearedIconName", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "iconPrefix", "getIconPrefix", "buildIconics", "Landroid/text/Spanned;", "block", "Lkotlin/Function1;", "Lcom/mikepenz/iconics/Iconics$Builder;", "", "Lkotlin/ExtensionFunctionType;", "Landroid/widget/Button;", "Landroid/widget/TextView;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "createArray", "", "Lcom/mikepenz/iconics/IconicsDrawable;", "Lcom/mikepenz/iconics/IconicsArrayBuilder;", "(Lcom/mikepenz/iconics/IconicsDrawable;Lkotlin/jvm/functions/Function1;)[Lcom/mikepenz/iconics/IconicsDrawable;", "enableShadowSupport", "Landroid/view/View;", "inflateWithIconics", "Landroid/view/MenuInflater;", "context", "Landroid/content/Context;", "menuId", "", "menu", "Landroid/view/Menu;", "checkSubMenu", "", "parseXmlAndSetIconicsDrawables", "setIconicsFactory", "Landroid/view/LayoutInflater;", "appCompatDelegate", "Landroidx/appcompat/app/AppCompatDelegate;", "wrapByIconics", "Landroid/content/ContextWrapper;", "iconics-core"}, k = 2, mv = {1, 1, 15})
/* compiled from: IconicsExtensions.kt */
public final class IconicsExtensionsKt {
    public static final void inflateWithIconics(MenuInflater menuInflater, Context context, int i, Menu menu) {
        inflateWithIconics$default(menuInflater, context, i, menu, false, 8, (Object) null);
    }

    public static final void parseXmlAndSetIconicsDrawables(Menu menu, Context context, int i) {
        parseXmlAndSetIconicsDrawables$default(menu, context, i, false, 4, (Object) null);
    }

    public static final ContextWrapper wrapByIconics(Context $this$wrapByIconics) {
        Intrinsics.checkParameterIsNotNull($this$wrapByIconics, "$this$wrapByIconics");
        return IconicsContextWrapper.Companion.wrap($this$wrapByIconics);
    }

    public static final void setIconicsFactory(LayoutInflater $this$setIconicsFactory, AppCompatDelegate appCompatDelegate) {
        Intrinsics.checkParameterIsNotNull($this$setIconicsFactory, "$this$setIconicsFactory");
        Intrinsics.checkParameterIsNotNull(appCompatDelegate, "appCompatDelegate");
        if (Build.VERSION.SDK_INT >= 26) {
            LayoutInflaterCompat.setFactory2($this$setIconicsFactory, new IconicsLayoutInflater2(appCompatDelegate));
        } else {
            LayoutInflaterCompat.setFactory($this$setIconicsFactory, new IconicsLayoutInflater(appCompatDelegate));
        }
    }

    public static /* synthetic */ void inflateWithIconics$default(MenuInflater menuInflater, Context context, int i, Menu menu, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        inflateWithIconics(menuInflater, context, i, menu, z);
    }

    public static final void inflateWithIconics(MenuInflater $this$inflateWithIconics, Context context, int menuId, Menu menu, boolean checkSubMenu) {
        Intrinsics.checkParameterIsNotNull($this$inflateWithIconics, "$this$inflateWithIconics");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        IconicsMenuInflaterUtil.inflate($this$inflateWithIconics, context, menuId, menu, checkSubMenu);
    }

    public static /* synthetic */ Spanned buildIconics$default(Spanned spanned, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$1.INSTANCE;
        }
        return buildIconics(spanned, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final Spanned buildIconics(Spanned $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        return builder.on($this$buildIconics).build();
    }

    public static /* synthetic */ Spanned buildIconics$default(String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$2.INSTANCE;
        }
        return buildIconics(str, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final Spanned buildIconics(String $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        return builder.on($this$buildIconics).build();
    }

    public static /* synthetic */ Spanned buildIconics$default(CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$3.INSTANCE;
        }
        return buildIconics(charSequence, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final Spanned buildIconics(CharSequence $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        return builder.on($this$buildIconics).build();
    }

    public static /* synthetic */ Spanned buildIconics$default(StringBuilder sb, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$4.INSTANCE;
        }
        return buildIconics(sb, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final Spanned buildIconics(StringBuilder $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        return builder.on($this$buildIconics).build();
    }

    public static /* synthetic */ void buildIconics$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$5.INSTANCE;
        }
        buildIconics(textView, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final void buildIconics(TextView $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        builder.on($this$buildIconics).build();
    }

    public static /* synthetic */ void buildIconics$default(Button button, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IconicsExtensionsKt$buildIconics$6.INSTANCE;
        }
        buildIconics(button, (Function1<? super Iconics.Builder, Unit>) function1);
    }

    public static final void buildIconics(Button $this$buildIconics, Function1<? super Iconics.Builder, Unit> block) {
        Intrinsics.checkParameterIsNotNull($this$buildIconics, "$this$buildIconics");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Iconics.Builder builder = new Iconics.Builder();
        block.invoke(builder);
        builder.on($this$buildIconics).build();
    }

    public static final IconicsDrawable[] createArray(IconicsDrawable $this$createArray, Function1<? super IconicsArrayBuilder, IconicsArrayBuilder> block) {
        Intrinsics.checkParameterIsNotNull($this$createArray, "$this$createArray");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return block.invoke(new IconicsArrayBuilder($this$createArray)).build();
    }

    public static /* synthetic */ void parseXmlAndSetIconicsDrawables$default(Menu menu, Context context, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        parseXmlAndSetIconicsDrawables(menu, context, i, z);
    }

    public static final void parseXmlAndSetIconicsDrawables(Menu $this$parseXmlAndSetIconicsDrawables, Context context, int menuId, boolean checkSubMenu) {
        Intrinsics.checkParameterIsNotNull($this$parseXmlAndSetIconicsDrawables, "$this$parseXmlAndSetIconicsDrawables");
        Intrinsics.checkParameterIsNotNull(context, "context");
        IconicsMenuInflaterUtil.parseXmlAndSetIconicsDrawables(context, menuId, $this$parseXmlAndSetIconicsDrawables, checkSubMenu);
    }

    public static final String getIconPrefix(String $this$iconPrefix) {
        Intrinsics.checkParameterIsNotNull($this$iconPrefix, "$this$iconPrefix");
        String substring = $this$iconPrefix.substring(0, 3);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String getClearedIconName(String $this$clearedIconName) {
        Intrinsics.checkParameterIsNotNull($this$clearedIconName, "$this$clearedIconName");
        return getClearedIconName((CharSequence) $this$clearedIconName);
    }

    public static final String getClearedIconName(CharSequence $this$clearedIconName) {
        Intrinsics.checkParameterIsNotNull($this$clearedIconName, "$this$clearedIconName");
        return new Regex("-").replace($this$clearedIconName, "_");
    }

    public static final void enableShadowSupport(View $this$enableShadowSupport) {
        Intrinsics.checkParameterIsNotNull($this$enableShadowSupport, "$this$enableShadowSupport");
        IconicsUtils.enableShadowSupport($this$enableShadowSupport);
    }
}

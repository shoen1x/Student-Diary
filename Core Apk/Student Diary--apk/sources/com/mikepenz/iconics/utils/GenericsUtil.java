package com.mikepenz.iconics.utils;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0003¢\u0006\u0002\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J\u0016\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0003¨\u0006\u0012"}, d2 = {"Lcom/mikepenz/iconics/utils/GenericsUtil;", "", "()V", "getDefinedFonts", "", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/lang/String;", "fields", "Ljava/lang/reflect/Field;", "(Landroid/content/Context;[Ljava/lang/reflect/Field;)[Ljava/lang/String;", "getDefinedProcessors", "getStringResourceByName", "resourceName", "resolveRClass", "Ljava/lang/Class;", "packageName", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: GenericsUtil.kt */
public final class GenericsUtil {
    public static final GenericsUtil INSTANCE = new GenericsUtil();

    private GenericsUtil() {
    }

    @JvmStatic
    public static final String[] getDefinedFonts(Context ctx) {
        String[] strArr;
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        String packageName = ctx.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "ctx.packageName");
        Class it = resolveRClass(packageName);
        if (it != null) {
            Field[] fields = it.getFields();
            Intrinsics.checkExpressionValueIsNotNull(fields, "it.fields");
            strArr = getDefinedFonts(ctx, fields);
        } else {
            strArr = null;
        }
        return strArr != null ? strArr : new String[0];
    }

    @JvmStatic
    public static final String[] getDefinedProcessors(Context ctx) {
        String[] strArr;
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        String packageName = ctx.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "ctx.packageName");
        Class it = resolveRClass(packageName);
        if (it != null) {
            Field[] fields = it.getFields();
            Intrinsics.checkExpressionValueIsNotNull(fields, "it.fields");
            strArr = getDefinedProcessors(ctx, fields);
        } else {
            strArr = null;
        }
        return strArr != null ? strArr : new String[0];
    }

    @JvmStatic
    private static final Class<?> resolveRClass(String packageName) {
        String tempPackageName = packageName;
        do {
            try {
                return Class.forName(tempPackageName + ".R$string");
            } catch (ClassNotFoundException e) {
                tempPackageName = StringsKt.substringBeforeLast(tempPackageName, '.', "");
                if (!(!StringsKt.isBlank(tempPackageName))) {
                    return null;
                }
            }
        } while (!(!StringsKt.isBlank(tempPackageName)));
        return null;
    }

    @JvmStatic
    private static final String[] getDefinedFonts(Context ctx, Field[] fields) {
        Collection destination$iv$iv = new ArrayList();
        for (Field it : fields) {
            String name = it.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) "define_font_", false, 2, (Object) null)) {
                destination$iv$iv.add(it);
            }
        }
        Iterable<Field> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Field it2 : $this$map$iv) {
            String name2 = it2.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "it.name");
            Context context = ctx;
            destination$iv$iv2.add(getStringResourceByName(ctx, name2));
        }
        Context context2 = ctx;
        Object[] array = ((Collection) ((List) destination$iv$iv2)).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @JvmStatic
    private static final String[] getDefinedProcessors(Context ctx, Field[] fields) {
        Collection destination$iv$iv = new ArrayList();
        for (Field it : fields) {
            String name = it.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) "define_processor_", false, 2, (Object) null)) {
                destination$iv$iv.add(it);
            }
        }
        Iterable<Field> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Field it2 : $this$map$iv) {
            String name2 = it2.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "it.name");
            Context context = ctx;
            destination$iv$iv2.add(getStringResourceByName(ctx, name2));
        }
        Context context2 = ctx;
        Object[] array = ((Collection) ((List) destination$iv$iv2)).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @JvmStatic
    private static final String getStringResourceByName(Context ctx, String resourceName) {
        int resId = ctx.getResources().getIdentifier(resourceName, "string", ctx.getPackageName());
        if (resId == 0) {
            return "";
        }
        String string = ctx.getString(resId);
        Intrinsics.checkExpressionValueIsNotNull(string, "ctx.getString(resId)");
        return string;
    }
}

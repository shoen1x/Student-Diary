package com.mikepenz.iconics;

import android.graphics.Typeface;
import com.mikepenz.iconics.typeface.IIcon;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0007J\u001a\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0007J\u0011\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R:\u0010\u0005\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mikepenz/iconics/IconicsArrayBuilder;", "", "iconBase", "Lcom/mikepenz/iconics/IconicsDrawable;", "(Lcom/mikepenz/iconics/IconicsDrawable;)V", "icons", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/graphics/Typeface;", "Lkotlin/collections/ArrayList;", "add", "icon", "Lcom/mikepenz/iconics/typeface/IIcon;", "", "typeface", "", "build", "", "()[Lcom/mikepenz/iconics/IconicsDrawable;", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsArrayBuilder.kt */
public final class IconicsArrayBuilder {
    private final IconicsDrawable iconBase;
    private final ArrayList<Pair<Object, Typeface>> icons = new ArrayList<>();

    public final IconicsArrayBuilder add(char c) {
        return add$default(this, c, (Typeface) null, 2, (Object) null);
    }

    public final IconicsArrayBuilder add(String str) {
        return add$default(this, str, (Typeface) null, 2, (Object) null);
    }

    public IconicsArrayBuilder(IconicsDrawable iconBase2) {
        Intrinsics.checkParameterIsNotNull(iconBase2, "iconBase");
        this.iconBase = iconBase2;
    }

    public final IconicsArrayBuilder add(IIcon icon) {
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        this.icons.add(new Pair(icon, null));
        return this;
    }

    public static /* synthetic */ IconicsArrayBuilder add$default(IconicsArrayBuilder iconicsArrayBuilder, String str, Typeface typeface, int i, Object obj) {
        if ((i & 2) != 0) {
            typeface = Typeface.DEFAULT;
            Intrinsics.checkExpressionValueIsNotNull(typeface, "Typeface.DEFAULT");
        }
        return iconicsArrayBuilder.add(str, typeface);
    }

    public final IconicsArrayBuilder add(String icon, Typeface typeface) {
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        this.icons.add(new Pair(icon, typeface));
        return this;
    }

    public static /* synthetic */ IconicsArrayBuilder add$default(IconicsArrayBuilder iconicsArrayBuilder, char c, Typeface typeface, int i, Object obj) {
        if ((i & 2) != 0) {
            typeface = Typeface.DEFAULT;
            Intrinsics.checkExpressionValueIsNotNull(typeface, "Typeface.DEFAULT");
        }
        return iconicsArrayBuilder.add(c, typeface);
    }

    public final IconicsArrayBuilder add(char icon, Typeface typeface) {
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        this.icons.add(new Pair(Character.valueOf(icon), typeface));
        return this;
    }

    public final IconicsDrawable[] build() {
        ArrayList iconicsDrawables = new ArrayList(this.icons.size());
        int index$iv = 0;
        for (Object item$iv : this.icons) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair $dstr$icon$typeface = (Pair) item$iv;
            Object icon = $dstr$icon$typeface.component1();
            Typeface typeface = (Typeface) $dstr$icon$typeface.component2();
            if (icon instanceof IIcon) {
                iconicsDrawables.add(index$iv, this.iconBase.clone().icon((IIcon) icon));
            } else if (icon instanceof Character) {
                iconicsDrawables.add(index$iv, this.iconBase.clone().icon(((Character) icon).charValue(), typeface));
            } else if (icon instanceof String) {
                iconicsDrawables.add(index$iv, this.iconBase.clone().iconText((String) icon, typeface));
            }
            index$iv = index$iv2;
        }
        Object[] array = iconicsDrawables.toArray(new IconicsDrawable[0]);
        if (array != null) {
            return (IconicsDrawable[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}

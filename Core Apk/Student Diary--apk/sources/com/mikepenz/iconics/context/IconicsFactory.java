package com.mikepenz.iconics.context;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.animation.IconicsAnimationExtensionsKt;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.utils.IconicsExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsFactory;", "", "()V", "onViewCreated", "Landroid/view/View;", "view", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onViewCreatedInternal", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsFactory.kt */
public final class IconicsFactory {
    public static final IconicsFactory INSTANCE = new IconicsFactory();

    private IconicsFactory() {
    }

    @JvmStatic
    public static final View onViewCreated(View view, Context context, AttributeSet attrs) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        if (view != null && (!Intrinsics.areEqual(view.getTag(R.id.iconics_tag_id), (Object) true))) {
            onViewCreatedInternal(view, context, attrs);
            view.setTag(R.id.iconics_tag_id, true);
        }
        return view;
    }

    @JvmStatic
    private static final void onViewCreatedInternal(View view, Context context, AttributeSet attrs) {
        IconicsDrawable it;
        if (attrs != null) {
            if (view instanceof ActionMenuItemView) {
                IconicsDrawable it2 = IconicsAttrsApplier.getIconicsDrawable(context, attrs);
                if (it2 != null) {
                    ((ActionMenuItemView) view).setIcon(IconicsAnimationExtensionsKt.tryToEnableIconicsAnimation(view, it2));
                }
            } else if (view instanceof EditText) {
                IconicsExtensionsKt.buildIconics$default((TextView) view, (Function1) null, 1, (Object) null);
            } else if (view instanceof TextView) {
                IconicsExtensionsKt.buildIconics$default((TextView) view, (Function1) null, 1, (Object) null);
                ((TextView) view).addTextChangedListener(new IconicsFactory$onViewCreatedInternal$2());
            } else if ((view instanceof ImageView) && (it = IconicsAttrsApplier.getIconicsDrawable(context, attrs)) != null) {
                ((ImageView) view).setImageDrawable(IconicsAnimationExtensionsKt.tryToEnableIconicsAnimation(view, it));
            }
        }
    }
}

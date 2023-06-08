package com.mikepenz.iconics.context;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterFactory;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsLayoutInflater;", "Landroidx/core/view/LayoutInflaterFactory;", "appCompatDelegate", "Landroidx/appcompat/app/AppCompatDelegate;", "(Landroidx/appcompat/app/AppCompatDelegate;)V", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "iconics-core"}, k = 1, mv = {1, 1, 15})
@Deprecated(message = "Use the IconicsImageView or IconicsTextView instead")
/* compiled from: IconicsLayoutInflater.kt */
public final class IconicsLayoutInflater implements LayoutInflaterFactory {
    private final AppCompatDelegate appCompatDelegate;

    public IconicsLayoutInflater(AppCompatDelegate appCompatDelegate2) {
        Intrinsics.checkParameterIsNotNull(appCompatDelegate2, "appCompatDelegate");
        this.appCompatDelegate = appCompatDelegate2;
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        return IconicsFactory.onViewCreated(this.appCompatDelegate.createView(parent, name, context, attrs), context, attrs);
    }
}

package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.ContextWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "inflater", "Lcom/mikepenz/iconics/context/InternalLayoutInflater;", "getInflater", "()Lcom/mikepenz/iconics/context/InternalLayoutInflater;", "inflater$delegate", "Lkotlin/Lazy;", "getSystemService", "", "name", "", "Companion", "iconics-core"}, k = 1, mv = {1, 1, 15})
@Deprecated(message = "Use the IconicsImageView or IconicsTextView instead")
/* compiled from: IconicsContextWrapper.kt */
public final class IconicsContextWrapper extends ContextWrapper {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IconicsContextWrapper.class), "inflater", "getInflater()Lcom/mikepenz/iconics/context/InternalLayoutInflater;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy inflater$delegate;

    private final InternalLayoutInflater getInflater() {
        Lazy lazy = this.inflater$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (InternalLayoutInflater) lazy.getValue();
    }

    @JvmStatic
    public static final ContextWrapper wrap(Context context) {
        return Companion.wrap(context);
    }

    private IconicsContextWrapper(Context base) {
        super(base);
        this.inflater$delegate = LazyKt.lazy(new IconicsContextWrapper$inflater$2(this));
    }

    public /* synthetic */ IconicsContextWrapper(Context base, DefaultConstructorMarker $constructor_marker) {
        this(base);
    }

    public Object getSystemService(String name) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (Intrinsics.areEqual((Object) "layout_inflater", (Object) name)) {
            return getInflater();
        }
        return super.getSystemService(name);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsContextWrapper$Companion;", "", "()V", "wrap", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsContextWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmStatic
        public final ContextWrapper wrap(Context base) {
            Intrinsics.checkParameterIsNotNull(base, "base");
            return new IconicsContextWrapper(base, (DefaultConstructorMarker) null);
        }
    }
}

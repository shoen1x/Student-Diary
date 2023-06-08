package com.mikepenz.iconics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* compiled from: Iconics.kt */
final /* synthetic */ class Iconics$init$1 extends MutablePropertyReference0 {
    Iconics$init$1(Iconics iconics) {
        super(iconics);
    }

    public String getName() {
        return "applicationContext";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Iconics.class);
    }

    public String getSignature() {
        return "getApplicationContext()Landroid/content/Context;";
    }

    public Object get() {
        Iconics iconics = (Iconics) this.receiver;
        return Iconics.getApplicationContext();
    }

    public void set(Object value) {
        Iconics iconics = (Iconics) this.receiver;
        Iconics.setApplicationContext$iconics_core((Context) value);
    }
}

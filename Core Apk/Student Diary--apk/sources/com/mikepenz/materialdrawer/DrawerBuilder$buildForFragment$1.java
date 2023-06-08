package com.mikepenz.materialdrawer;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final /* synthetic */ class DrawerBuilder$buildForFragment$1 extends MutablePropertyReference0 {
    DrawerBuilder$buildForFragment$1(DrawerBuilder drawerBuilder) {
        super(drawerBuilder);
    }

    public String getName() {
        return "mRootView";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DrawerBuilder.class);
    }

    public String getSignature() {
        return "getMRootView$materialdrawer()Landroid/view/ViewGroup;";
    }

    public Object get() {
        return ((DrawerBuilder) this.receiver).getMRootView$materialdrawer();
    }

    public void set(Object value) {
        ((DrawerBuilder) this.receiver).setMRootView$materialdrawer((ViewGroup) value);
    }
}

package com.mikepenz.materialdrawer;

import com.mikepenz.fastadapter.FastAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final /* synthetic */ class DrawerBuilder$adapter$1 extends MutablePropertyReference0 {
    DrawerBuilder$adapter$1(DrawerBuilder drawerBuilder) {
        super(drawerBuilder);
    }

    public String getName() {
        return "_adapter";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DrawerBuilder.class);
    }

    public String getSignature() {
        return "get_adapter$materialdrawer()Lcom/mikepenz/fastadapter/FastAdapter;";
    }

    public Object get() {
        return ((DrawerBuilder) this.receiver).get_adapter$materialdrawer();
    }

    public void set(Object value) {
        ((DrawerBuilder) this.receiver).set_adapter$materialdrawer((FastAdapter) value);
    }
}

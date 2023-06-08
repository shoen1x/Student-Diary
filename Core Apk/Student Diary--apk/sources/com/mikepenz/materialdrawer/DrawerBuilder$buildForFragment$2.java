package com.mikepenz.materialdrawer;

import androidx.drawerlayout.widget.DrawerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final /* synthetic */ class DrawerBuilder$buildForFragment$2 extends MutablePropertyReference0 {
    DrawerBuilder$buildForFragment$2(DrawerBuilder drawerBuilder) {
        super(drawerBuilder);
    }

    public String getName() {
        return "mDrawerLayout";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DrawerBuilder.class);
    }

    public String getSignature() {
        return "getMDrawerLayout$materialdrawer()Landroidx/drawerlayout/widget/DrawerLayout;";
    }

    public Object get() {
        return ((DrawerBuilder) this.receiver).getMDrawerLayout$materialdrawer();
    }

    public void set(Object value) {
        ((DrawerBuilder) this.receiver).setMDrawerLayout$materialdrawer((DrawerLayout) value);
    }
}

package com.mikepenz.materialdrawer;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final /* synthetic */ class DrawerBuilder$createContent$1 extends MutablePropertyReference0 {
    DrawerBuilder$createContent$1(DrawerBuilder drawerBuilder) {
        super(drawerBuilder);
    }

    public String getName() {
        return "mRecyclerView";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DrawerBuilder.class);
    }

    public String getSignature() {
        return "getMRecyclerView$materialdrawer()Landroidx/recyclerview/widget/RecyclerView;";
    }

    public Object get() {
        return ((DrawerBuilder) this.receiver).getMRecyclerView$materialdrawer();
    }

    public void set(Object value) {
        ((DrawerBuilder) this.receiver).setMRecyclerView$materialdrawer((RecyclerView) value);
    }
}

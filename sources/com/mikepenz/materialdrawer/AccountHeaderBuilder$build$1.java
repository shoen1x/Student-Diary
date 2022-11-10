package com.mikepenz.materialdrawer;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
final /* synthetic */ class AccountHeaderBuilder$build$1 extends MutablePropertyReference0 {
    AccountHeaderBuilder$build$1(AccountHeaderBuilder accountHeaderBuilder) {
        super(accountHeaderBuilder);
    }

    public String getName() {
        return "accountHeaderContainer";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AccountHeaderBuilder.class);
    }

    public String getSignature() {
        return "getAccountHeaderContainer$materialdrawer()Landroid/view/View;";
    }

    public Object get() {
        return ((AccountHeaderBuilder) this.receiver).getAccountHeaderContainer$materialdrawer();
    }

    public void set(Object value) {
        ((AccountHeaderBuilder) this.receiver).setAccountHeaderContainer$materialdrawer((View) value);
    }
}

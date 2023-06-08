package com.mikepenz.materialdrawer;

import android.content.Context;
import android.view.View;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\n"}, d2 = {"com/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemClickListener$1", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
public final class AccountHeaderBuilder$onDrawerItemClickListener$1 implements Drawer.OnDrawerItemClickListener {
    final /* synthetic */ AccountHeaderBuilder this$0;

    AccountHeaderBuilder$onDrawerItemClickListener$1(AccountHeaderBuilder $outer) {
        this.this$0 = $outer;
    }

    public boolean onItemClick(View view, int position, IDrawerItem<?> drawerItem) {
        boolean isCurrentSelectedProfile;
        Drawer drawer$materialdrawer;
        DrawerBuilder drawerBuilder$materialdrawer;
        boolean z;
        DrawerBuilder it;
        MiniDrawer mMiniDrawer$materialdrawer;
        Drawer drawer$materialdrawer2;
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        boolean z2 = false;
        if (!(drawerItem instanceof IProfile) || !drawerItem.isSelectable()) {
            isCurrentSelectedProfile = false;
        } else {
            isCurrentSelectedProfile = this.this$0.switchProfiles$materialdrawer((IProfile) drawerItem);
        }
        if (this.this$0.getResetDrawerOnProfileListClick$materialdrawer() && (drawer$materialdrawer2 = this.this$0.getDrawer$materialdrawer()) != null) {
            drawer$materialdrawer2.setOnDrawerItemClickListener((Drawer.OnDrawerItemClickListener) null);
        }
        if (!(!this.this$0.getResetDrawerOnProfileListClick$materialdrawer() || this.this$0.getDrawer$materialdrawer() == null || view == null || view.getContext() == null)) {
            AccountHeaderBuilder accountHeaderBuilder = this.this$0;
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
            accountHeaderBuilder.resetDrawerContent(context);
        }
        Drawer drawer$materialdrawer3 = this.this$0.getDrawer$materialdrawer();
        if (!(drawer$materialdrawer3 == null || (it = drawer$materialdrawer3.getDrawerBuilder$materialdrawer()) == null || (mMiniDrawer$materialdrawer = it.getMMiniDrawer$materialdrawer()) == null)) {
            mMiniDrawer$materialdrawer.onProfileClick();
        }
        boolean consumed = false;
        if (drawerItem instanceof IProfile) {
            AccountHeader.OnAccountHeaderListener onAccountHeaderListener$materialdrawer = this.this$0.getOnAccountHeaderListener$materialdrawer();
            if (onAccountHeaderListener$materialdrawer != null) {
                z = onAccountHeaderListener$materialdrawer.onProfileChanged(view, (IProfile) drawerItem, isCurrentSelectedProfile);
            } else {
                z = false;
            }
            consumed = z;
        }
        Boolean closeDrawerOnProfileListClick$materialdrawer = this.this$0.getCloseDrawerOnProfileListClick$materialdrawer();
        if (closeDrawerOnProfileListClick$materialdrawer != null) {
            boolean it2 = closeDrawerOnProfileListClick$materialdrawer.booleanValue();
            if (consumed && !it2) {
                z2 = true;
            }
            consumed = z2;
        }
        if (!(consumed || (drawer$materialdrawer = this.this$0.getDrawer$materialdrawer()) == null || (drawerBuilder$materialdrawer = drawer$materialdrawer.getDrawerBuilder$materialdrawer()) == null)) {
            drawerBuilder$materialdrawer.closeDrawerDelayed$materialdrawer();
        }
        return true;
    }
}

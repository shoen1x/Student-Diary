package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\n"}, d2 = {"com/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemLongClickListener$1", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
public final class AccountHeaderBuilder$onDrawerItemLongClickListener$1 implements Drawer.OnDrawerItemLongClickListener {
    final /* synthetic */ AccountHeaderBuilder this$0;

    AccountHeaderBuilder$onDrawerItemLongClickListener$1(AccountHeaderBuilder $outer) {
        this.this$0 = $outer;
    }

    public boolean onItemLongClick(View view, int position, IDrawerItem<?> drawerItem) {
        AccountHeader.OnAccountHeaderItemLongClickListener onAccountHeaderItemLongClickListener$materialdrawer;
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (this.this$0.getOnAccountHeaderItemLongClickListener$materialdrawer() != null) {
            boolean isCurrentSelectedProfile = drawerItem.isSelected();
            if (!(drawerItem instanceof IProfile) || (onAccountHeaderItemLongClickListener$materialdrawer = this.this$0.getOnAccountHeaderItemLongClickListener$materialdrawer()) == null) {
                return false;
            }
            return onAccountHeaderItemLongClickListener$materialdrawer.onProfileLongClick(view, (IProfile) drawerItem, isCurrentSelectedProfile);
        }
        return false;
    }
}

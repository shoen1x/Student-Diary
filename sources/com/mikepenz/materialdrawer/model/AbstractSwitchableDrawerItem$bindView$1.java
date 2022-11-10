package com.mikepenz.materialdrawer.model;

import android.view.View;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\n"}, d2 = {"com/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$bindView$1", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractSwitchableDrawerItem.kt */
public final class AbstractSwitchableDrawerItem$bindView$1 implements Drawer.OnDrawerItemClickListener {
    final /* synthetic */ AbstractSwitchableDrawerItem.ViewHolder $holder;
    final /* synthetic */ AbstractSwitchableDrawerItem this$0;

    AbstractSwitchableDrawerItem$bindView$1(AbstractSwitchableDrawerItem $outer, AbstractSwitchableDrawerItem.ViewHolder $captured_local_variable$1) {
        this.this$0 = $outer;
        this.$holder = $captured_local_variable$1;
    }

    public boolean onItemClick(View view, int position, IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (this.this$0.isSelectable()) {
            return false;
        }
        AbstractSwitchableDrawerItem abstractSwitchableDrawerItem = this.this$0;
        abstractSwitchableDrawerItem.setChecked(!abstractSwitchableDrawerItem.isChecked());
        this.$holder.getSwitchView$materialdrawer().setChecked(this.this$0.isChecked());
        return false;
    }
}

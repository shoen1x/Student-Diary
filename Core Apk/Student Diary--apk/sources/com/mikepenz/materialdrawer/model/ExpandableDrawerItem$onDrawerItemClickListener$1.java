package com.mikepenz.materialdrawer.model;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¨\u0006\n"}, d2 = {"com/mikepenz/materialdrawer/model/ExpandableDrawerItem$onDrawerItemClickListener$1", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExpandableDrawerItem.kt */
public final class ExpandableDrawerItem$onDrawerItemClickListener$1 implements Drawer.OnDrawerItemClickListener {
    final /* synthetic */ ExpandableDrawerItem this$0;

    ExpandableDrawerItem$onDrawerItemClickListener$1(ExpandableDrawerItem $outer) {
        this.this$0 = $outer;
    }

    public boolean onItemClick(View view, int position, IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if ((drawerItem instanceof AbstractDrawerItem) && drawerItem.isEnabled() && view != null) {
            View view2 = view;
            if (drawerItem.getSubItems() != null) {
                if (drawerItem.isExpanded()) {
                    ViewCompat.animate(view.findViewById(R.id.material_drawer_arrow)).rotation((float) this.this$0.getArrowRotationAngleEnd()).start();
                } else {
                    ViewCompat.animate(view.findViewById(R.id.material_drawer_arrow)).rotation((float) this.this$0.getArrowRotationAngleStart()).start();
                }
            }
        }
        Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener = this.this$0.getMOnDrawerItemClickListener();
        if (mOnDrawerItemClickListener != null) {
            return mOnDrawerItemClickListener.onItemClick(view, position, drawerItem);
        }
        return false;
    }
}

package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "<anonymous parameter 1>", "Lcom/mikepenz/fastadapter/IAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "item", "position", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MiniDrawer.kt */
final class MiniDrawer$createItems$2 extends Lambda implements Function4<View, IAdapter<IDrawerItem<?>>, IDrawerItem<?>, Integer, Boolean> {
    final /* synthetic */ MiniDrawer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MiniDrawer$createItems$2(MiniDrawer miniDrawer) {
        super(4);
        this.this$0 = miniDrawer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(invoke((View) obj, (IAdapter<IDrawerItem<?>>) (IAdapter) obj2, (IDrawerItem<?>) (IDrawerItem) obj3, ((Number) obj4).intValue()));
    }

    /* JADX WARNING: type inference failed for: r1v19, types: [com.mikepenz.materialdrawer.model.interfaces.IDrawerItem] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(android.view.View r8, com.mikepenz.fastadapter.IAdapter<com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?>> r9, com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?> r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = "<anonymous parameter 1>"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            com.mikepenz.materialdrawer.MiniDrawer r0 = r7.this$0
            int r0 = r0.getMiniDrawerType(r10)
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.MiniDrawer$OnMiniDrawerItemClickListener r1 = r1.mOnMiniDrawerItemClickListener
            r2 = 1
            if (r1 == 0) goto L_0x0021
            boolean r1 = r1.onItemClick(r8, r11, r10, r0)
            if (r1 != r2) goto L_0x0021
            goto L_0x00dd
        L_0x0021:
            com.mikepenz.materialdrawer.MiniDrawer$Companion r1 = com.mikepenz.materialdrawer.MiniDrawer.Companion
            int r1 = r1.getITEM()
            java.lang.String r3 = "it.view.context"
            if (r0 != r1) goto L_0x00a9
            boolean r1 = r10.isSelectable()
            r4 = 0
            if (r1 == 0) goto L_0x0076
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.AccountHeader r1 = r1.getAccountHeader()
            if (r1 == 0) goto L_0x0051
            r5 = 0
            boolean r6 = r1.isSelectionListShown()
            if (r6 == 0) goto L_0x004f
            android.view.View r6 = r1.getView()
            android.content.Context r6 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            r1.toggleSelectionList(r6)
        L_0x004f:
        L_0x0051:
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.Drawer r1 = r1.getDrawer()
            if (r1 == 0) goto L_0x0061
            long r3 = r10.getIdentifier()
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r4 = r1.getDrawerItem((long) r3)
        L_0x0061:
            r1 = r4
            if (r1 == 0) goto L_0x00db
            boolean r3 = r1.isSelected()
            if (r3 != 0) goto L_0x00db
            com.mikepenz.materialdrawer.MiniDrawer r3 = r7.this$0
            com.mikepenz.materialdrawer.Drawer r3 = r3.getDrawer()
            if (r3 == 0) goto L_0x00db
            r3.setSelection((com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?>) r10, (boolean) r2)
            goto L_0x00db
        L_0x0076:
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.Drawer r1 = r1.getDrawer()
            if (r1 == 0) goto L_0x0082
            com.mikepenz.materialdrawer.Drawer$OnDrawerItemClickListener r4 = r1.getOnDrawerItemClickListener()
        L_0x0082:
            if (r4 == 0) goto L_0x00a8
            com.mikepenz.materialdrawer.DrawerUtils r1 = com.mikepenz.materialdrawer.DrawerUtils.INSTANCE
            com.mikepenz.materialdrawer.MiniDrawer r2 = r7.this$0
            java.util.List r2 = r2.getDrawerItems()
            long r3 = r10.getIdentifier()
            com.mikepenz.materialdrawer.model.interfaces.IDrawerItem r1 = r1.getDrawerItem((java.util.List<? extends com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<?>>) r2, (long) r3)
            if (r1 == 0) goto L_0x00a8
            r2 = 0
            com.mikepenz.materialdrawer.MiniDrawer r3 = r7.this$0
            com.mikepenz.materialdrawer.Drawer r3 = r3.getDrawer()
            if (r3 == 0) goto L_0x00a8
            com.mikepenz.materialdrawer.Drawer$OnDrawerItemClickListener r3 = r3.getOnDrawerItemClickListener()
            if (r3 == 0) goto L_0x00a8
            r3.onItemClick(r8, r11, r1)
        L_0x00a8:
            goto L_0x00db
        L_0x00a9:
            com.mikepenz.materialdrawer.MiniDrawer$Companion r1 = com.mikepenz.materialdrawer.MiniDrawer.Companion
            int r1 = r1.getPROFILE()
            if (r0 != r1) goto L_0x00db
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.AccountHeader r1 = r1.getAccountHeader()
            if (r1 == 0) goto L_0x00d0
            r2 = 0
            boolean r4 = r1.isSelectionListShown()
            if (r4 != 0) goto L_0x00ce
            android.view.View r4 = r1.getView()
            android.content.Context r4 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r3)
            r1.toggleSelectionList(r4)
        L_0x00ce:
        L_0x00d0:
            com.mikepenz.materialdrawer.MiniDrawer r1 = r7.this$0
            com.mikepenz.materialdrawer.interfaces.ICrossfader r1 = r1.getCrossFader()
            if (r1 == 0) goto L_0x00db
            r1.crossfade()
        L_0x00db:
        L_0x00dd:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.MiniDrawer$createItems$2.invoke(android.view.View, com.mikepenz.fastadapter.IAdapter, com.mikepenz.materialdrawer.model.interfaces.IDrawerItem, int):boolean");
    }
}

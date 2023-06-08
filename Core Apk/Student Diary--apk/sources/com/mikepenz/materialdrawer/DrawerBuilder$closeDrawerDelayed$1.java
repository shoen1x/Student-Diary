package com.mikepenz.materialdrawer;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
final class DrawerBuilder$closeDrawerDelayed$1 implements Runnable {
    final /* synthetic */ DrawerBuilder this$0;

    DrawerBuilder$closeDrawerDelayed$1(DrawerBuilder drawerBuilder) {
        this.this$0 = drawerBuilder;
    }

    public final void run() {
        this.this$0.getMDrawerLayout$materialdrawer().closeDrawers();
        if (this.this$0.getMScrollToTopAfterClick$materialdrawer()) {
            this.this$0.getMRecyclerView$materialdrawer().smoothScrollToPosition(0);
        }
    }
}

package com.mikepenz.materialdrawer;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
final class AccountHeaderBuilder$onProfileClick$2 implements Runnable {
    final /* synthetic */ AccountHeaderBuilder this$0;

    AccountHeaderBuilder$onProfileClick$2(AccountHeaderBuilder accountHeaderBuilder) {
        this.this$0 = accountHeaderBuilder;
    }

    public final void run() {
        Drawer drawer$materialdrawer = this.this$0.getDrawer$materialdrawer();
        if (drawer$materialdrawer != null) {
            drawer$materialdrawer.closeDrawer();
        }
    }
}

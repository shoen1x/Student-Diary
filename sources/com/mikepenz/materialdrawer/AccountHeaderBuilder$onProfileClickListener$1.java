package com.mikepenz.materialdrawer;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
final class AccountHeaderBuilder$onProfileClickListener$1 implements View.OnClickListener {
    final /* synthetic */ AccountHeaderBuilder this$0;

    AccountHeaderBuilder$onProfileClickListener$1(AccountHeaderBuilder accountHeaderBuilder) {
        this.this$0 = accountHeaderBuilder;
    }

    public final void onClick(View v) {
        AccountHeaderBuilder accountHeaderBuilder = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(v, "v");
        accountHeaderBuilder.onProfileImageClick(v, false);
    }
}

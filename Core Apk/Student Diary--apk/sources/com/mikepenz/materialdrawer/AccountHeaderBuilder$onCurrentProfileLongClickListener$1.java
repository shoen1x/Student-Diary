package com.mikepenz.materialdrawer;

import android.view.View;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
final class AccountHeaderBuilder$onCurrentProfileLongClickListener$1 implements View.OnLongClickListener {
    final /* synthetic */ AccountHeaderBuilder this$0;

    AccountHeaderBuilder$onCurrentProfileLongClickListener$1(AccountHeaderBuilder accountHeaderBuilder) {
        this.this$0 = accountHeaderBuilder;
    }

    public final boolean onLongClick(View v) {
        if (this.this$0.getOnAccountHeaderProfileImageListener$materialdrawer() == null) {
            return false;
        }
        Object tag = v.getTag(R.id.material_drawer_profile_header);
        if (tag != null) {
            IProfile profile = (IProfile) tag;
            AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener$materialdrawer = this.this$0.getOnAccountHeaderProfileImageListener$materialdrawer();
            if (onAccountHeaderProfileImageListener$materialdrawer == null) {
                return false;
            }
            Intrinsics.checkExpressionValueIsNotNull(v, "v");
            return onAccountHeaderProfileImageListener$materialdrawer.onProfileImageLongClick(v, profile, true);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IProfile<*>");
    }
}

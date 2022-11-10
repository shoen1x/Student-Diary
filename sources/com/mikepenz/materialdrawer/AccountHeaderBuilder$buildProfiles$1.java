package com.mikepenz.materialdrawer;

import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.view.BezelImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"applyProfile", "", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "imageView", "Lcom/mikepenz/materialdrawer/view/BezelImageView;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
final class AccountHeaderBuilder$buildProfiles$1 extends Lambda implements Function2<IProfile<?>, BezelImageView, Unit> {
    final /* synthetic */ AccountHeaderBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountHeaderBuilder$buildProfiles$1(AccountHeaderBuilder accountHeaderBuilder) {
        super(2);
        this.this$0 = accountHeaderBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IProfile<?>) (IProfile) obj, (BezelImageView) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(IProfile<?> $this$applyProfile, BezelImageView imageView) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        if ($this$applyProfile != null) {
            this.this$0.setImageOrPlaceholder(imageView, $this$applyProfile.getIcon());
            imageView.setTag(R.id.material_drawer_profile_header, $this$applyProfile);
            StringHolder email = $this$applyProfile.getEmail();
            if (email == null || (charSequence = email.getText()) == null) {
                StringHolder name = $this$applyProfile.getName();
                charSequence = name != null ? name.getText() : null;
            }
            if (charSequence == null) {
                charSequence = imageView.getContext().getString(R.string.material_drawer_profile_content_description);
            }
            imageView.setContentDescription(charSequence);
            if (this.this$0.getProfileImagesClickable$materialdrawer()) {
                imageView.setOnClickListener(this.this$0.onProfileClickListener);
                imageView.setOnLongClickListener(this.this$0.onProfileLongClickListener);
                imageView.disableTouchFeedback(false);
            } else {
                imageView.disableTouchFeedback(true);
            }
            imageView.setVisibility(0);
            imageView.invalidate();
        }
    }
}

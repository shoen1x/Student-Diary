package com.mikepenz.materialdrawer.model;

import android.widget.CompoundButton;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$checkedChangeListener$1", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "ic", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractSwitchableDrawerItem.kt */
public final class AbstractSwitchableDrawerItem$checkedChangeListener$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ AbstractSwitchableDrawerItem this$0;

    AbstractSwitchableDrawerItem$checkedChangeListener$1(AbstractSwitchableDrawerItem $outer) {
        this.this$0 = $outer;
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean ic) {
        Intrinsics.checkParameterIsNotNull(buttonView, "buttonView");
        if (this.this$0.isEnabled()) {
            this.this$0.setChecked(ic);
            OnCheckedChangeListener onCheckedChangeListener = this.this$0.getOnCheckedChangeListener();
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this.this$0, buttonView, ic);
                return;
            }
            return;
        }
        buttonView.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        buttonView.setChecked(!ic);
        buttonView.setOnCheckedChangeListener(this);
    }
}

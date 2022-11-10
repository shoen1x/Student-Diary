package com.mikepenz.materialdrawer.holder;

import android.widget.TextView;
import com.mikepenz.materialize.holder.StringHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0007"}, d2 = {"applyTo", "", "Lcom/mikepenz/materialize/holder/StringHolder;", "textView", "Landroid/widget/TextView;", "applyToOrHide", "", "materialdrawer"}, k = 2, mv = {1, 1, 16})
/* compiled from: StringHolder.kt */
public final class StringHolderKt {
    public static final void applyTo(StringHolder $this$applyTo, TextView textView) {
        if ($this$applyTo != null && textView != null) {
            $this$applyTo.applyTo(textView);
        }
    }

    public static final boolean applyToOrHide(StringHolder $this$applyToOrHide, TextView textView) {
        if ($this$applyToOrHide != null && textView != null) {
            return $this$applyToOrHide.applyToOrHide(textView);
        }
        if (textView == null) {
            return false;
        }
        textView.setVisibility(8);
        return false;
    }
}

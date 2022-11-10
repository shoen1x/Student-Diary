package com.mikepenz.materialdrawer.holder;

import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/StringHolder;", "Lcom/mikepenz/materialize/holder/StringHolder;", "text", "", "(Ljava/lang/CharSequence;)V", "textRes", "", "(I)V", "Companion", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: StringHolder.kt */
public class StringHolder extends com.mikepenz.materialize.holder.StringHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public StringHolder(CharSequence text) {
        super(text);
    }

    public StringHolder(int textRes) {
        super(textRes);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/StringHolder$Companion;", "", "()V", "applyTo", "", "text", "Lcom/mikepenz/materialize/holder/StringHolder;", "textView", "Landroid/widget/TextView;", "applyToOrHide", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StringHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void applyTo(com.mikepenz.materialize.holder.StringHolder text, TextView textView) {
            com.mikepenz.materialize.holder.StringHolder.applyTo(text, textView);
        }

        public final boolean applyToOrHide(com.mikepenz.materialize.holder.StringHolder text, TextView textView) {
            return com.mikepenz.materialize.holder.StringHolder.applyToOrHide(text, textView);
        }
    }
}

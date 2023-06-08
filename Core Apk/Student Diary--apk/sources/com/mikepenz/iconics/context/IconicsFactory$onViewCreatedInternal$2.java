package com.mikepenz.iconics.context;

import android.text.Editable;
import android.text.TextWatcher;
import com.mikepenz.iconics.Iconics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/mikepenz/iconics/context/IconicsFactory$onViewCreatedInternal$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "cs", "", "i", "", "i1", "i2", "onTextChanged", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsFactory.kt */
public final class IconicsFactory$onViewCreatedInternal$2 implements TextWatcher {
    IconicsFactory$onViewCreatedInternal$2() {
    }

    public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
        Intrinsics.checkParameterIsNotNull(cs, "cs");
    }

    public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
        Intrinsics.checkParameterIsNotNull(cs, "cs");
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, "editable");
        Iconics.styleEditable(editable);
    }
}

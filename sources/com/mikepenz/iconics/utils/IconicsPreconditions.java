package com.mikepenz.iconics.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsPreconditions;", "", "()V", "checkMappingPrefix", "", "s", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsPreconditions.kt */
public final class IconicsPreconditions {
    public static final IconicsPreconditions INSTANCE = new IconicsPreconditions();

    private IconicsPreconditions() {
    }

    @JvmStatic
    public static final void checkMappingPrefix(String s) {
        Intrinsics.checkParameterIsNotNull(s, "s");
        if (s.length() != 3) {
            throw new IllegalArgumentException("The mapping prefix of a font must be 3 characters long.");
        }
    }
}

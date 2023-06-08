package com.mikepenz.materialdrawer;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "item", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "invoke", "com/mikepenz/materialdrawer/Drawer$removeItem$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Drawer.kt */
final class Drawer$removeItem$$inlined$ifNotNull$lambda$1 extends Lambda implements Function1<IDrawerItem<?>, Boolean> {
    final /* synthetic */ long $identifier$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Drawer$removeItem$$inlined$ifNotNull$lambda$1(long j) {
        super(1);
        this.$identifier$inlined = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((IDrawerItem<?>) (IDrawerItem) obj));
    }

    public final boolean invoke(IDrawerItem<?> item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        return item.getIdentifier() == this.$identifier$inlined;
    }
}

package com.mikepenz.materialdrawer.model;

import android.content.Context;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048WX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/mikepenz/materialdrawer/model/SecondarySwitchDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem;", "()V", "layoutRes", "", "getLayoutRes", "()I", "type", "getType", "getColor", "ctx", "Landroid/content/Context;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: SecondarySwitchDrawerItem.kt */
public class SecondarySwitchDrawerItem extends AbstractSwitchableDrawerItem<SecondarySwitchDrawerItem> {
    public int getType() {
        return R.id.material_drawer_item_secondary_switch;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_secondary_switch;
    }

    /* access modifiers changed from: protected */
    public int getColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        if (isEnabled()) {
            return ColorHolderKt.applyColor(getTextColor(), ctx, R.attr.material_drawer_secondary_text, R.color.material_drawer_secondary_text);
        }
        return ColorHolderKt.applyColor(getDisabledTextColor(), ctx, R.attr.material_drawer_hint_text, R.color.material_drawer_hint_text);
    }
}

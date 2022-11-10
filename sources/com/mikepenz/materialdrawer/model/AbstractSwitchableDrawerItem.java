package com.mikepenz.materialdrawer.model;

import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0016J\u0013\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\t¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\t¢\u0006\u0002\u0010&J\u0013\u0010)\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\t¢\u0006\u0002\u0010&R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108WX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012¨\u0006."}, d2 = {"Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem;", "Item", "Lcom/mikepenz/materialdrawer/model/BaseDescribeableDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$ViewHolder;", "()V", "checkedChangeListener", "com/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$checkedChangeListener$1", "Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$checkedChangeListener$1;", "isChecked", "", "()Z", "setChecked", "(Z)V", "isSwitchEnabled", "setSwitchEnabled", "layoutRes", "", "getLayoutRes", "()I", "onCheckedChangeListener", "Lcom/mikepenz/materialdrawer/interfaces/OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/mikepenz/materialdrawer/interfaces/OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/mikepenz/materialdrawer/interfaces/OnCheckedChangeListener;)V", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "withCheckable", "checkable", "(Z)Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem;", "withChecked", "checked", "withOnCheckedChangeListener", "(Lcom/mikepenz/materialdrawer/interfaces/OnCheckedChangeListener;)Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem;", "withSwitchEnabled", "switchEnabled", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractSwitchableDrawerItem.kt */
public abstract class AbstractSwitchableDrawerItem<Item extends AbstractSwitchableDrawerItem<Item>> extends BaseDescribeableDrawerItem<Item, ViewHolder> {
    private final AbstractSwitchableDrawerItem$checkedChangeListener$1 checkedChangeListener = new AbstractSwitchableDrawerItem$checkedChangeListener$1(this);
    private boolean isChecked;
    private boolean isSwitchEnabled = true;
    private OnCheckedChangeListener onCheckedChangeListener;

    public final boolean isSwitchEnabled() {
        return this.isSwitchEnabled;
    }

    public final void setSwitchEnabled(boolean z) {
        this.isSwitchEnabled = z;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public int getType() {
        return R.id.material_drawer_item_primary_switch;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_switch;
    }

    public final Item withChecked(boolean checked) {
        this.isChecked = checked;
        return this;
    }

    public final Item withSwitchEnabled(boolean switchEnabled) {
        this.isSwitchEnabled = switchEnabled;
        return this;
    }

    public final Item withOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        Intrinsics.checkParameterIsNotNull(onCheckedChangeListener2, "onCheckedChangeListener");
        this.onCheckedChangeListener = onCheckedChangeListener2;
        return this;
    }

    public final Item withCheckable(boolean checkable) {
        return (AbstractSwitchableDrawerItem) withSelectable(checkable);
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        bindViewHelper(holder);
        holder.getSwitchView$materialdrawer().setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        holder.getSwitchView$materialdrawer().setChecked(this.isChecked);
        holder.getSwitchView$materialdrawer().setOnCheckedChangeListener(this.checkedChangeListener);
        holder.getSwitchView$materialdrawer().setEnabled(this.isSwitchEnabled);
        withOnDrawerItemClickListener(new AbstractSwitchableDrawerItem$bindView$1(this, holder));
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        onPostBindView(this, view);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/model/AbstractSwitchableDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "switchView", "Landroidx/appcompat/widget/SwitchCompat;", "getSwitchView$materialdrawer", "()Landroidx/appcompat/widget/SwitchCompat;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AbstractSwitchableDrawerItem.kt */
    public static class ViewHolder extends BaseViewHolder {
        private final SwitchCompat switchView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.material_drawer_switch);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<Switch…d.material_drawer_switch)");
            this.switchView = (SwitchCompat) findViewById;
        }

        public final SwitchCompat getSwitchView$materialdrawer() {
            return this.switchView;
        }
    }
}

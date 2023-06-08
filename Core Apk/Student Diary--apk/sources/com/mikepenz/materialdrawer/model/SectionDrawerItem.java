package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialize.util.UIUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0001*B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010'\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010'\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020)H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118WX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013¨\u0006+"}, d2 = {"Lcom/mikepenz/materialdrawer/model/SectionDrawerItem;", "Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "Lcom/mikepenz/materialdrawer/model/SectionDrawerItem$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/Nameable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Typefaceable;", "()V", "divider", "", "getDivider", "()Z", "setDivider", "(Z)V", "isEnabled", "setEnabled", "isSelected", "setSelected", "layoutRes", "", "getLayoutRes", "()I", "name", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getName", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "setName", "(Lcom/mikepenz/materialdrawer/holder/StringHolder;)V", "type", "getType", "bindView", "", "holder", "payloads", "", "", "getViewHolder", "v", "Landroid/view/View;", "hasDivider", "withDivider", "withName", "nameRes", "", "ViewHolder", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: SectionDrawerItem.kt */
public class SectionDrawerItem extends AbstractDrawerItem<SectionDrawerItem, ViewHolder> implements Nameable<SectionDrawerItem>, Typefaceable<SectionDrawerItem> {
    private boolean divider = true;
    private boolean isEnabled;
    private boolean isSelected;
    private StringHolder name;

    public final boolean getDivider() {
        return this.divider;
    }

    public final void setDivider(boolean z) {
        this.divider = z;
    }

    public StringHolder getName() {
        return this.name;
    }

    public void setName(StringHolder stringHolder) {
        this.name = stringHolder;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getType() {
        return R.id.material_drawer_item_section;
    }

    public int getLayoutRes() {
        return R.layout.material_drawer_item_section;
    }

    public SectionDrawerItem withName(StringHolder name2) {
        setName(name2);
        return this;
    }

    public SectionDrawerItem withName(String name2) {
        Intrinsics.checkParameterIsNotNull(name2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        setName(new StringHolder((CharSequence) name2));
        return this;
    }

    public SectionDrawerItem withName(int nameRes) {
        setName(new StringHolder(nameRes));
        return this;
    }

    public final SectionDrawerItem withDivider(boolean divider2) {
        this.divider = divider2;
        return this;
    }

    public final boolean hasDivider() {
        return this.divider;
    }

    public void bindView(ViewHolder holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        super.bindView(holder, payloads);
        View view = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        Context ctx = view.getContext();
        View view2 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        view2.setId(hashCode());
        holder.getView$materialdrawer().setClickable(false);
        holder.getView$materialdrawer().setEnabled(false);
        TextView name$materialdrawer = holder.getName$materialdrawer();
        ColorHolder textColor = getTextColor();
        Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
        name$materialdrawer.setTextColor(ColorHolderKt.applyColor(textColor, ctx, R.attr.material_drawer_secondary_text, R.color.material_drawer_secondary_text));
        StringHolder.Companion.applyTo(getName(), holder.getName$materialdrawer());
        if (getTypeface() != null) {
            holder.getName$materialdrawer().setTypeface(getTypeface());
        }
        if (hasDivider()) {
            holder.getDivider$materialdrawer().setVisibility(0);
        } else {
            holder.getDivider$materialdrawer().setVisibility(8);
        }
        holder.getDivider$materialdrawer().setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, R.attr.material_drawer_divider, R.color.material_drawer_divider));
        View view3 = holder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        onPostBindView(this, view3);
    }

    public ViewHolder getViewHolder(View v) {
        Intrinsics.checkParameterIsNotNull(v, "v");
        return new ViewHolder(v);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/mikepenz/materialdrawer/model/SectionDrawerItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "getDivider$materialdrawer", "()Landroid/view/View;", "name", "Landroid/widget/TextView;", "getName$materialdrawer", "()Landroid/widget/TextView;", "getView$materialdrawer", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SectionDrawerItem.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final View divider;
        private final TextView name;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkParameterIsNotNull(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.material_drawer_divider);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.material_drawer_divider)");
            this.divider = findViewById;
            View findViewById2 = this.view.findViewById(R.id.material_drawer_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<TextVi….id.material_drawer_name)");
            this.name = (TextView) findViewById2;
        }

        public final View getView$materialdrawer() {
            return this.view;
        }

        public final View getDivider$materialdrawer() {
            return this.divider;
        }

        public final TextView getName$materialdrawer() {
            return this.name;
        }
    }
}

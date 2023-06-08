package com.mikepenz.materialdrawer.interfaces;

import android.widget.CompoundButton;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/mikepenz/materialdrawer/interfaces/OnCheckedChangeListener;", "", "onCheckedChanged", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnCheckedChangeListener.kt */
public interface OnCheckedChangeListener {
    void onCheckedChanged(IDrawerItem<?> iDrawerItem, CompoundButton compoundButton, boolean z);
}

package com.mikepenz.materialdrawer.util;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialize.util.UIUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\u00002\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bJ'\u0010\u0010\u001a\u00020\u00002\u001a\u0010\u0011\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t0\u0012\"\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerItemViewHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDivider", "", "mDrawerItems", "Ljava/util/ArrayList;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "mOnDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/util/DrawerItemViewHelper$OnDrawerItemClickListener;", "build", "Landroid/view/View;", "withDivider", "divider", "withDrawerItems", "drawerItems", "", "([Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;)Lcom/mikepenz/materialdrawer/util/DrawerItemViewHelper;", "withOnDrawerItemClickListener", "onDrawerItemClickListener", "OnDrawerItemClickListener", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerItemViewHelper.kt */
public class DrawerItemViewHelper {
    private final Context mContext;
    private boolean mDivider = true;
    private ArrayList<IDrawerItem<?>> mDrawerItems = new ArrayList<>();
    /* access modifiers changed from: private */
    public OnDrawerItemClickListener mOnDrawerItemClickListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&¨\u0006\b"}, d2 = {"Lcom/mikepenz/materialdrawer/util/DrawerItemViewHelper$OnDrawerItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DrawerItemViewHelper.kt */
    public interface OnDrawerItemClickListener {
        void onItemClick(View view, IDrawerItem<?> iDrawerItem);
    }

    public DrawerItemViewHelper(Context mContext2) {
        Intrinsics.checkParameterIsNotNull(mContext2, "mContext");
        this.mContext = mContext2;
    }

    public final DrawerItemViewHelper withDrawerItems(ArrayList<IDrawerItem<?>> drawerItems) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        this.mDrawerItems = drawerItems;
        return this;
    }

    public final DrawerItemViewHelper withDrawerItems(IDrawerItem<?>... drawerItems) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        Collections.addAll(this.mDrawerItems, (IDrawerItem[]) Arrays.copyOf(drawerItems, drawerItems.length));
        return this;
    }

    public final DrawerItemViewHelper withDivider(boolean divider) {
        this.mDivider = divider;
        return this;
    }

    public final DrawerItemViewHelper withOnDrawerItemClickListener(OnDrawerItemClickListener onDrawerItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListener, "onDrawerItemClickListener");
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public final View build() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        if (this.mDivider) {
            LinearLayout divider = new LinearLayout(this.mContext);
            divider.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            divider.setMinimumHeight((int) UIUtils.convertDpToPixel(1.0f, this.mContext));
            divider.setOrientation(1);
            divider.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this.mContext, R.attr.material_drawer_divider, R.color.material_drawer_divider));
            linearLayout.addView(divider);
        }
        Iterator<IDrawerItem<?>> it = this.mDrawerItems.iterator();
        while (it.hasNext()) {
            IDrawerItem drawerItem = it.next();
            View view = drawerItem.generateView(this.mContext);
            view.setTag(drawerItem);
            if (drawerItem.isEnabled()) {
                view.setBackgroundResource(UIUtils.getSelectableBackgroundRes(this.mContext));
                view.setOnClickListener(new DrawerItemViewHelper$build$1(this));
            }
            linearLayout.addView(view);
        }
        return linearLayout;
    }
}

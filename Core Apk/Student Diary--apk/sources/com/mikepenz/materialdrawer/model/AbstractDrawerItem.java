package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mikepenz.fastadapter.IParentItem;
import com.mikepenz.fastadapter.ISubItem;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.OnPostBindViewListener;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b,\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u0015\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010dJ#\u0010e\u001a\u00020b2\u0006\u0010c\u001a\u00028\u00012\f\u0010f\u001a\b\u0012\u0004\u0012\u00020S02H\u0017¢\u0006\u0002\u0010gJ\u0015\u0010h\u001a\u00020b2\u0006\u0010c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010dJ\u0013\u0010i\u001a\u00020$2\b\u0010j\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010i\u001a\u00020$2\u0006\u0010k\u001a\u00020\u000bH\u0016J\u0010\u0010i\u001a\u00020$2\u0006\u0010k\u001a\u00020\u001eH\u0016J\u0015\u0010l\u001a\u00020$2\u0006\u0010c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0016J\u0018\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010A\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020qH\u0014J\u0010\u0010H\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020qH\u0004J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020qH\u0004J\u0010\u0010t\u001a\u00020u2\u0006\u0010p\u001a\u00020qH\u0004J\u001e\u0010v\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010w\u001a\u00020\u000b2\b\b\u0001\u0010J\u001a\u00020\u000bH\u0004J\u0015\u0010x\u001a\u00028\u00012\u0006\u0010y\u001a\u00020oH&¢\u0006\u0002\u0010zJ\u0015\u0010x\u001a\u00028\u00012\u0006\u0010A\u001a\u00020rH\u0016¢\u0006\u0002\u0010{J\b\u0010|\u001a\u00020\u000bH\u0016J\u001c\u0010}\u001a\u00020b2\n\u0010~\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u001a\u00020oH\u0004J2\u0010P\u001a\u00020b\"\r\b\u0002\u0010\u0001*\u0006\u0012\u0002\b\u0003032\u0015\u0010M\u001a\f\u0012\u0007\b\u0001\u0012\u0003H\u00010\u0001\"\u0003H\u0001¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00020b2\u0006\u0010c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010dJ\u0019\u0010\u0001\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00028\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0018\u0010\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0001\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020$¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00028\u00002\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0003\u0010\u0001J\u0019\u0010\u0001\u001a\u00028\u00002\n\u0010A\u001a\u0006\u0012\u0002\b\u00030B¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00028\u00002\u0006\u0010<\u001a\u00020;¢\u0006\u0003\u0010\u0001J\u0018\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020$H\u0016¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020$¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020$¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00028\u00002\b\b\u0001\u0010G\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0018\u0010\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0001\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00028\u00002\b\b\u0001\u0010J\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0018\u0010\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0001\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0016\u0010 \u0001\u001a\u00028\u00002\u0007\u0010¡\u0001\u001a\u00020$¢\u0006\u0003\u0010\u0001J*\u0010¢\u0001\u001a\u00028\u00002\u001b\u0010M\u001a\u000f\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003030\u0001\"\u0006\u0012\u0002\b\u000303¢\u0006\u0003\u0010£\u0001J\u001f\u0010¢\u0001\u001a\u00028\u00002\u0010\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302¢\u0006\u0003\u0010¤\u0001J\u0016\u0010¥\u0001\u001a\u00028\u00002\u0007\u0010¦\u0001\u001a\u00020S¢\u0006\u0003\u0010§\u0001J\u0017\u0010¨\u0001\u001a\u00028\u00002\b\b\u0001\u0010X\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0018\u0010©\u0001\u001a\u00028\u00002\t\b\u0001\u0010ª\u0001\u001a\u00020\u000b¢\u0006\u0003\u0010\u0001J\u0019\u0010«\u0001\u001a\u00028\u00002\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0003\u0010¬\u0001R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010%R\u001a\u0010&\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010%\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010(R\u001a\u0010+\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010%\"\u0004\b,\u0010(R\u001a\u0010-\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010%\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010(R\u0018\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302X\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001a\"\u0004\bI\u0010\u001cR\u001c\u0010J\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001a\"\u0004\bL\u0010\u001cR8\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000303022\u0010\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000303028V@VX\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u001a\"\u0004\bZ\u0010\u001cR\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006­\u0001"}, d2 = {"Lcom/mikepenz/materialdrawer/model/AbstractDrawerItem;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "Lcom/mikepenz/materialdrawer/model/interfaces/Selectable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Tagable;", "Lcom/mikepenz/materialdrawer/model/interfaces/Typefaceable;", "()V", "colorStateList", "Landroid/util/Pair;", "", "Landroid/content/res/ColorStateList;", "getColorStateList", "()Landroid/util/Pair;", "setColorStateList", "(Landroid/util/Pair;)V", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "(Ljava/lang/String;)V", "disabledTextColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getDisabledTextColor", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setDisabledTextColor", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "isAutoExpanding", "", "()Z", "isEnabled", "setEnabled", "(Z)V", "isExpanded", "setExpanded", "isSelectable", "setSelectable", "isSelected", "setSelected", "isSelectedBackgroundAnimated", "setSelectedBackgroundAnimated", "mSubItems", "", "Lcom/mikepenz/fastadapter/ISubItem;", "onDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "getOnDrawerItemClickListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "setOnDrawerItemClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)V", "<set-?>", "Lcom/mikepenz/materialdrawer/model/interfaces/OnPostBindViewListener;", "onPostBindViewListener", "getOnPostBindViewListener", "()Lcom/mikepenz/materialdrawer/model/interfaces/OnPostBindViewListener;", "setOnPostBindViewListener", "(Lcom/mikepenz/materialdrawer/model/interfaces/OnPostBindViewListener;)V", "parent", "Lcom/mikepenz/fastadapter/IParentItem;", "getParent", "()Lcom/mikepenz/fastadapter/IParentItem;", "setParent", "(Lcom/mikepenz/fastadapter/IParentItem;)V", "selectedColor", "getSelectedColor", "setSelectedColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "subItems", "getSubItems", "()Ljava/util/List;", "setSubItems", "(Ljava/util/List;)V", "tag", "", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "textColor", "getTextColor", "setTextColor", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "attachToWindow", "", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "bindView", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "detachFromWindow", "equals", "other", "id", "failedToRecycle", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "generateView", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "getColor", "getShapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "getTextColorStateList", "color", "getViewHolder", "v", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hashCode", "onPostBindView", "drawerItem", "view", "SubType", "", "([Lcom/mikepenz/fastadapter/ISubItem;)V", "unbindView", "withContentDescription", "(Ljava/lang/String;)Ljava/lang/Object;", "withDisabledTextColor", "(I)Ljava/lang/Object;", "withDisabledTextColorRes", "disabledTextColorRes", "withEnabled", "enabled", "(Z)Ljava/lang/Object;", "withIdentifier", "(J)Ljava/lang/Object;", "withOnDrawerItemClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)Ljava/lang/Object;", "withParent", "(Lcom/mikepenz/fastadapter/IParentItem;)Ljava/lang/Object;", "withPostOnBindViewListener", "(Lcom/mikepenz/materialdrawer/model/interfaces/OnPostBindViewListener;)Ljava/lang/Object;", "withSelectable", "selectable", "withSelected", "selected", "withSelectedBackgroundAnimated", "selectedBackgroundAnimated", "withSelectedColor", "withSelectedColorRes", "selectedColorRes", "withSelectedTextColor", "withSelectedTextColorRes", "withSetExpanded", "expanded", "withSubItems", "([Lcom/mikepenz/fastadapter/ISubItem;)Ljava/lang/Object;", "(Ljava/util/List;)Ljava/lang/Object;", "withTag", "object", "(Ljava/lang/Object;)Ljava/lang/Object;", "withTextColor", "withTextColorRes", "textColorRes", "withTypeface", "(Landroid/graphics/Typeface;)Ljava/lang/Object;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractDrawerItem.kt */
public abstract class AbstractDrawerItem<T, VH extends RecyclerView.ViewHolder> implements IDrawerItem<VH>, Selectable<T>, Tagable<T>, Typefaceable<T> {
    private Pair<Integer, ColorStateList> colorStateList;
    private String contentDescription;
    private ColorHolder disabledTextColor;
    private long identifier = -1;
    private boolean isEnabled = true;
    private boolean isExpanded;
    private boolean isSelectable = true;
    private boolean isSelected;
    private boolean isSelectedBackgroundAnimated = true;
    private List<ISubItem<?>> mSubItems = new ArrayList();
    private Drawer.OnDrawerItemClickListener onDrawerItemClickListener;
    private OnPostBindViewListener onPostBindViewListener;
    private IParentItem<?> parent;
    private ColorHolder selectedColor;
    private ColorHolder selectedTextColor;
    private Object tag;
    private ColorHolder textColor;
    private Typeface typeface;

    public abstract VH getViewHolder(View view);

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long j) {
        this.identifier = j;
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object obj) {
        this.tag = obj;
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

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public void setSelectable(boolean z) {
        this.isSelectable = z;
    }

    public final boolean isSelectedBackgroundAnimated() {
        return this.isSelectedBackgroundAnimated;
    }

    public final void setSelectedBackgroundAnimated(boolean z) {
        this.isSelectedBackgroundAnimated = z;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final void setContentDescription(String str) {
        this.contentDescription = str;
    }

    public final ColorHolder getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(ColorHolder colorHolder) {
        this.selectedColor = colorHolder;
    }

    public final ColorHolder getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(ColorHolder colorHolder) {
        this.textColor = colorHolder;
    }

    public final ColorHolder getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final void setSelectedTextColor(ColorHolder colorHolder) {
        this.selectedTextColor = colorHolder;
    }

    public final ColorHolder getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public final void setDisabledTextColor(ColorHolder colorHolder) {
        this.disabledTextColor = colorHolder;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public final Pair<Integer, ColorStateList> getColorStateList() {
        return this.colorStateList;
    }

    public final void setColorStateList(Pair<Integer, ColorStateList> pair) {
        this.colorStateList = pair;
    }

    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.onDrawerItemClickListener;
    }

    public void setOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        this.onDrawerItemClickListener = onDrawerItemClickListener2;
    }

    public final OnPostBindViewListener getOnPostBindViewListener() {
        return this.onPostBindViewListener;
    }

    /* access modifiers changed from: protected */
    public final void setOnPostBindViewListener(OnPostBindViewListener onPostBindViewListener2) {
        this.onPostBindViewListener = onPostBindViewListener2;
    }

    public IParentItem<?> getParent() {
        return this.parent;
    }

    public void setParent(IParentItem<?> iParentItem) {
        this.parent = iParentItem;
    }

    public List<ISubItem<?>> getSubItems() {
        return this.mSubItems;
    }

    public void setSubItems(List<ISubItem<?>> subItems) {
        Intrinsics.checkParameterIsNotNull(subItems, "subItems");
        this.mSubItems = subItems;
        for (ISubItem<?> subItem : subItems) {
            subItem.setParent(this);
        }
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    public boolean isAutoExpanding() {
        return true;
    }

    public final T withIdentifier(long identifier2) {
        setIdentifier(identifier2);
        return this;
    }

    public final T withTag(Object object) {
        Intrinsics.checkParameterIsNotNull(object, "object");
        setTag(object);
        return this;
    }

    public final T withEnabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    public final T withSelected(boolean selected) {
        setSelected(selected);
        return this;
    }

    public T withSelectable(boolean selectable) {
        setSelectable(selectable);
        return this;
    }

    public T withContentDescription(String contentDescription2) {
        this.contentDescription = contentDescription2;
        return this;
    }

    public final T withSelectedColor(int selectedColor2) {
        this.selectedColor = ColorHolder.Companion.fromColor(selectedColor2);
        return this;
    }

    public final T withSelectedColorRes(int selectedColorRes) {
        this.selectedColor = ColorHolder.Companion.fromColorRes(selectedColorRes);
        return this;
    }

    public final T withTextColor(int textColor2) {
        this.textColor = ColorHolder.Companion.fromColor(textColor2);
        return this;
    }

    public final T withTextColorRes(int textColorRes) {
        this.textColor = ColorHolder.Companion.fromColorRes(textColorRes);
        return this;
    }

    public final T withSelectedTextColor(int selectedTextColor2) {
        this.selectedTextColor = ColorHolder.Companion.fromColor(selectedTextColor2);
        return this;
    }

    public final T withSelectedTextColorRes(int selectedColorRes) {
        this.selectedTextColor = ColorHolder.Companion.fromColorRes(selectedColorRes);
        return this;
    }

    public final T withDisabledTextColor(int disabledTextColor2) {
        this.disabledTextColor = ColorHolder.Companion.fromColor(disabledTextColor2);
        return this;
    }

    public final T withDisabledTextColorRes(int disabledTextColorRes) {
        this.disabledTextColor = ColorHolder.Companion.fromColorRes(disabledTextColorRes);
        return this;
    }

    public T withTypeface(Typeface typeface2) {
        setTypeface(typeface2);
        return this;
    }

    public final T withSelectedBackgroundAnimated(boolean selectedBackgroundAnimated) {
        this.isSelectedBackgroundAnimated = selectedBackgroundAnimated;
        return this;
    }

    public T withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListener2, "onDrawerItemClickListener");
        setOnDrawerItemClickListener(onDrawerItemClickListener2);
        return this;
    }

    public final T withPostOnBindViewListener(OnPostBindViewListener onPostBindViewListener2) {
        Intrinsics.checkParameterIsNotNull(onPostBindViewListener2, "onPostBindViewListener");
        this.onPostBindViewListener = onPostBindViewListener2;
        return this;
    }

    /* access modifiers changed from: protected */
    public final void onPostBindView(IDrawerItem<?> drawerItem, View view) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        Intrinsics.checkParameterIsNotNull(view, "view");
        OnPostBindViewListener onPostBindViewListener2 = this.onPostBindViewListener;
        if (onPostBindViewListener2 != null) {
            onPostBindViewListener2.onBindView(drawerItem, view);
        }
    }

    public final T withParent(IParentItem<?> parent2) {
        Intrinsics.checkParameterIsNotNull(parent2, "parent");
        setParent(parent2);
        return this;
    }

    public final T withSubItems(List<ISubItem<?>> subItems) {
        Intrinsics.checkParameterIsNotNull(subItems, "subItems");
        this.mSubItems = subItems;
        return this;
    }

    public final <SubType extends ISubItem<?>> void setSubItems(SubType... subItems) {
        Intrinsics.checkParameterIsNotNull(subItems, "subItems");
        for (ISubItem subItem : subItems) {
            subItem.setParent(this);
        }
        this.mSubItems.clear();
        CollectionsKt.addAll(this.mSubItems, (T[]) subItems);
    }

    public final T withSubItems(ISubItem<?>... subItems) {
        Intrinsics.checkParameterIsNotNull(subItems, "subItems");
        setSubItems((SubType[]) (ISubItem[]) Arrays.copyOf(subItems, subItems.length));
        return this;
    }

    public final T withSetExpanded(boolean expanded) {
        setExpanded(expanded);
        return this;
    }

    public View generateView(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        View inflate = LayoutInflater.from(ctx).inflate(getLayoutRes(), (ViewGroup) null, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(ctx)…e(layoutRes, null, false)");
        RecyclerView.ViewHolder viewHolder = getViewHolder(inflate);
        bindView(viewHolder, new ArrayList());
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "viewHolder.itemView");
        return view;
    }

    public View generateView(Context ctx, ViewGroup parent2) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Intrinsics.checkParameterIsNotNull(parent2, "parent");
        View inflate = LayoutInflater.from(ctx).inflate(getLayoutRes(), parent2, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(ctx)…layoutRes, parent, false)");
        RecyclerView.ViewHolder viewHolder = getViewHolder(inflate);
        bindView(viewHolder, new ArrayList());
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "viewHolder.itemView");
        return view;
    }

    public void bindView(VH holder, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        String it = this.contentDescription;
        if (it != null) {
            View view = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            view.setContentDescription(it);
        }
        holder.itemView.setTag(R.id.material_drawer_item, this);
    }

    public void unbindView(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        holder.itemView.clearAnimation();
    }

    public void attachToWindow(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
    }

    public void detachFromWindow(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
    }

    public boolean failedToRecycle(VH holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        return false;
    }

    public VH getViewHolder(ViewGroup parent2) {
        Intrinsics.checkParameterIsNotNull(parent2, "parent");
        View inflate = LayoutInflater.from(parent2.getContext()).inflate(getLayoutRes(), parent2, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…layoutRes, parent, false)");
        return getViewHolder(inflate);
    }

    public boolean equals(long id) {
        return id == getIdentifier();
    }

    public boolean equals(int id) {
        return ((long) id) == getIdentifier();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || (!Intrinsics.areEqual((Object) getClass(), (Object) other.getClass()))) {
            return false;
        }
        if (getIdentifier() == ((AbstractDrawerItem) other).getIdentifier()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf(getIdentifier()).hashCode();
    }

    /* access modifiers changed from: protected */
    public final int getSelectedColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        if (DrawerUIUtils.INSTANCE.getBooleanStyleable(ctx, R.styleable.MaterialDrawer_material_drawer_legacy_style, false)) {
            return ColorHolderKt.applyColor(this.selectedColor, ctx, R.attr.material_drawer_selected_legacy, R.color.material_drawer_selected_legacy);
        }
        return ColorHolderKt.applyColor(this.selectedColor, ctx, R.attr.material_drawer_selected, R.color.material_drawer_selected);
    }

    /* access modifiers changed from: protected */
    public int getColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        if (isEnabled()) {
            return ColorHolderKt.applyColor(this.textColor, ctx, R.attr.material_drawer_primary_text, R.color.material_drawer_primary_text);
        }
        return ColorHolderKt.applyColor(this.disabledTextColor, ctx, R.attr.material_drawer_hint_text, R.color.material_drawer_hint_text);
    }

    /* access modifiers changed from: protected */
    public final int getSelectedTextColor(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        return ColorHolderKt.applyColor(this.selectedTextColor, ctx, R.attr.material_drawer_selected_text, R.color.material_drawer_selected_text);
    }

    /* access modifiers changed from: protected */
    public final ShapeAppearanceModel getShapeAppearanceModel(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        ShapeAppearanceModel withCornerSize = new ShapeAppearanceModel().withCornerSize((float) ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_item_corner_radius));
        Intrinsics.checkExpressionValueIsNotNull(withCornerSize, "ShapeAppearanceModel().w…e(cornerRadius.toFloat())");
        return withCornerSize;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r2 != r0.intValue()) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.res.ColorStateList getTextColorStateList(int r5, int r6) {
        /*
            r4 = this;
            android.util.Pair<java.lang.Integer, android.content.res.ColorStateList> r0 = r4.colorStateList
            r1 = 0
            if (r0 == 0) goto L_0x0018
            int r2 = r5 + r6
            if (r0 == 0) goto L_0x000e
            java.lang.Object r0 = r0.first
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            int r0 = r0.intValue()
            if (r2 == r0) goto L_0x002b
        L_0x0018:
            android.util.Pair r0 = new android.util.Pair
            int r2 = r5 + r6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.mikepenz.materialdrawer.util.DrawerUIUtils r3 = com.mikepenz.materialdrawer.util.DrawerUIUtils.INSTANCE
            android.content.res.ColorStateList r3 = r3.getTextColorStateList(r5, r6)
            r0.<init>(r2, r3)
            r4.colorStateList = r0
        L_0x002b:
            android.util.Pair<java.lang.Integer, android.content.res.ColorStateList> r0 = r4.colorStateList
            if (r0 == 0) goto L_0x0034
            java.lang.Object r0 = r0.second
            r1 = r0
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.materialdrawer.model.AbstractDrawerItem.getTextColorStateList(int, int):android.content.res.ColorStateList");
    }
}

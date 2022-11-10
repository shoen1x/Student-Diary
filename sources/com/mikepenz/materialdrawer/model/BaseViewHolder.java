package com.mikepenz.materialdrawer.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.materialdrawer.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/mikepenz/materialdrawer/model/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "getDescription$materialdrawer", "()Landroid/widget/TextView;", "setDescription$materialdrawer", "(Landroid/widget/TextView;)V", "icon", "Landroid/widget/ImageView;", "getIcon$materialdrawer", "()Landroid/widget/ImageView;", "setIcon$materialdrawer", "(Landroid/widget/ImageView;)V", "name", "getName$materialdrawer", "setName$materialdrawer", "getView$materialdrawer", "()Landroid/view/View;", "setView$materialdrawer", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseViewHolder.kt */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private TextView description;
    private ImageView icon;
    private TextView name;
    private View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view2) {
        super(view2);
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
        View findViewById = view2.findViewById(R.id.material_drawer_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.material_drawer_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = this.view.findViewById(R.id.material_drawer_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.material_drawer_name)");
        this.name = (TextView) findViewById2;
        View findViewById3 = this.view.findViewById(R.id.material_drawer_description);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.m…erial_drawer_description)");
        this.description = (TextView) findViewById3;
    }

    public final View getView$materialdrawer() {
        return this.view;
    }

    public final void setView$materialdrawer(View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "<set-?>");
        this.view = view2;
    }

    public final ImageView getIcon$materialdrawer() {
        return this.icon;
    }

    public final void setIcon$materialdrawer(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.icon = imageView;
    }

    public final TextView getName$materialdrawer() {
        return this.name;
    }

    public final void setName$materialdrawer(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.name = textView;
    }

    public final TextView getDescription$materialdrawer() {
        return this.description;
    }

    public final void setDescription$materialdrawer(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.description = textView;
    }
}

package com.mikepenz.materialdrawer.model.interfaces;

import android.graphics.drawable.Drawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u0017\u0010\u0007\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/Iconable;", "T", "", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "withIcon", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Object;", "iicon", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Lcom/mikepenz/iconics/typeface/IIcon;)Ljava/lang/Object;", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)Ljava/lang/Object;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: Iconable.kt */
public interface Iconable<T> {
    ImageHolder getIcon();

    T withIcon(Drawable drawable);

    T withIcon(IIcon iIcon);

    T withIcon(ImageHolder imageHolder);
}

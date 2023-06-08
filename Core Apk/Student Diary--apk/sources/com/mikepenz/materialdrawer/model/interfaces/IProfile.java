package com.mikepenz.materialdrawer.model.interfaces;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0012\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H&¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0015\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH&¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u001eH&¢\u0006\u0002\u0010\u001fJ\u0017\u0010\u0015\u001a\u00028\u00002\b\b\u0001\u0010 \u001a\u00020!H&¢\u0006\u0002\u0010\"J\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014J\u0017\u0010$\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010%H&¢\u0006\u0002\u0010&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006¨\u0006'"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "T", "Lcom/mikepenz/fastadapter/IIdentifyable;", "email", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "getEmail", "()Lcom/mikepenz/materialdrawer/holder/StringHolder;", "icon", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getIcon", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "isSelectable", "", "()Z", "setSelectable", "(Z)V", "name", "getName", "withEmail", "", "(Ljava/lang/String;)Ljava/lang/Object;", "withIcon", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Object;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)Ljava/lang/Object;", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Lcom/mikepenz/iconics/typeface/IIcon;)Ljava/lang/Object;", "iconRes", "", "(I)Ljava/lang/Object;", "url", "withName", "", "(Ljava/lang/CharSequence;)Ljava/lang/Object;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: IProfile.kt */
public interface IProfile<T> extends IIdentifyable {
    StringHolder getEmail();

    ImageHolder getIcon();

    StringHolder getName();

    boolean isSelectable();

    void setSelectable(boolean z);

    T withEmail(String str);

    T withIcon(int i);

    T withIcon(Bitmap bitmap);

    T withIcon(Drawable drawable);

    T withIcon(Uri uri);

    T withIcon(IIcon iIcon);

    T withIcon(String str);

    T withName(CharSequence charSequence);
}

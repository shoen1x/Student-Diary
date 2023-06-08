package com.mikepenz.materialdrawer.model.interfaces;

import android.graphics.Typeface;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/model/interfaces/Typefaceable;", "T", "", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "withTypeface", "(Landroid/graphics/Typeface;)Ljava/lang/Object;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: Typefaceable.kt */
public interface Typefaceable<T> {
    Typeface getTypeface();

    T withTypeface(Typeface typeface);
}

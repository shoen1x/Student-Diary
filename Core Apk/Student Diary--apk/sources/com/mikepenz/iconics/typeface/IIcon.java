package com.mikepenz.iconics.typeface;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/typeface/IIcon;", "", "character", "", "getCharacter", "()C", "formattedName", "", "getFormattedName", "()Ljava/lang/String;", "name", "getName", "typeface", "Lcom/mikepenz/iconics/typeface/ITypeface;", "getTypeface", "()Lcom/mikepenz/iconics/typeface/ITypeface;", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IIcon.kt */
public interface IIcon {
    char getCharacter();

    String getFormattedName();

    String getName();

    ITypeface getTypeface();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* compiled from: IIcon.kt */
    public static final class DefaultImpls {
        public static String getFormattedName(IIcon $this) {
            return '{' + $this.getName() + '}';
        }
    }
}

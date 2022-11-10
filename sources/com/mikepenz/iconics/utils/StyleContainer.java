package com.mikepenz.iconics.utils;

import android.text.ParcelableSpan;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.typeface.ITypeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/mikepenz/iconics/utils/StyleContainer;", "", "startIndex", "", "endIndex", "icon", "", "font", "Lcom/mikepenz/iconics/typeface/ITypeface;", "flags", "(IILjava/lang/String;Lcom/mikepenz/iconics/typeface/ITypeface;I)V", "(IILjava/lang/String;Lcom/mikepenz/iconics/typeface/ITypeface;)V", "span", "Landroid/text/ParcelableSpan;", "(IILandroid/text/ParcelableSpan;)V", "(IILandroid/text/ParcelableSpan;I)V", "style", "Landroid/text/style/CharacterStyle;", "(IILandroid/text/style/CharacterStyle;)V", "(IILandroid/text/style/CharacterStyle;I)V", "getEndIndex", "()I", "setEndIndex", "(I)V", "getFlags", "setFlags", "getFont", "()Lcom/mikepenz/iconics/typeface/ITypeface;", "setFont", "(Lcom/mikepenz/iconics/typeface/ITypeface;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getSpan", "()Landroid/text/ParcelableSpan;", "setSpan", "(Landroid/text/ParcelableSpan;)V", "getStartIndex", "setStartIndex", "getStyle", "()Landroid/text/style/CharacterStyle;", "setStyle", "(Landroid/text/style/CharacterStyle;)V", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: StyleContainer.kt */
public final class StyleContainer {
    private int endIndex;
    private int flags = 33;
    private ITypeface font;
    private String icon;
    private ParcelableSpan span;
    private int startIndex;
    private CharacterStyle style;

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final void setStartIndex(int i) {
        this.startIndex = i;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final void setEndIndex(int i) {
        this.endIndex = i;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final ITypeface getFont() {
        return this.font;
    }

    public final void setFont(ITypeface iTypeface) {
        this.font = iTypeface;
    }

    public final ParcelableSpan getSpan() {
        return this.span;
    }

    public final void setSpan(ParcelableSpan parcelableSpan) {
        this.span = parcelableSpan;
    }

    public final CharacterStyle getStyle() {
        return this.style;
    }

    public final void setStyle(CharacterStyle characterStyle) {
        this.style = characterStyle;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public StyleContainer(int startIndex2, int endIndex2, String icon2, ITypeface font2, int flags2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        Intrinsics.checkParameterIsNotNull(font2, "font");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.icon = icon2;
        this.font = font2;
        this.flags = flags2;
    }

    public StyleContainer(int startIndex2, int endIndex2, String icon2, ITypeface font2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        Intrinsics.checkParameterIsNotNull(font2, "font");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.icon = icon2;
        this.font = font2;
    }

    public StyleContainer(int startIndex2, int endIndex2, ParcelableSpan span2) {
        Intrinsics.checkParameterIsNotNull(span2, "span");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.span = span2;
    }

    public StyleContainer(int startIndex2, int endIndex2, ParcelableSpan span2, int flags2) {
        Intrinsics.checkParameterIsNotNull(span2, "span");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.span = span2;
        this.flags = flags2;
    }

    public StyleContainer(int startIndex2, int endIndex2, CharacterStyle style2) {
        Intrinsics.checkParameterIsNotNull(style2, "style");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.style = style2;
    }

    public StyleContainer(int startIndex2, int endIndex2, CharacterStyle style2, int flags2) {
        Intrinsics.checkParameterIsNotNull(style2, "style");
        this.startIndex = startIndex2;
        this.endIndex = endIndex2;
        this.style = style2;
        this.flags = flags2;
    }
}

package com.mikepenz.iconics.utils;

import android.text.Editable;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.IconicsLogger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0012\u0018\u00010\u0010H\u0007J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0010H\u0007J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0010H\u0007J6\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0010H\u0003J.\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0010H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/mikepenz/iconics/utils/InternalIconicsUtils;", "", "()V", "ICON_END", "", "ICON_START", "applyStyles", "", "text", "Landroid/text/Spannable;", "styleContainers", "", "Lcom/mikepenz/iconics/utils/StyleContainer;", "styles", "Landroid/text/style/CharacterStyle;", "stylesFor", "", "", "", "findIcons", "Lcom/mikepenz/iconics/utils/TextStyleContainer;", "spannable", "Landroid/text/Spanned;", "fonts", "Lcom/mikepenz/iconics/typeface/ITypeface;", "findIconsFromEditable", "Ljava/util/LinkedList;", "editable", "Landroid/text/Editable;", "placeFontIcon", "iconStart", "", "iconEnd", "spannedString", "Landroid/text/SpannableStringBuilder;", "tempIconString", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: InternalIconicsUtils.kt */
public final class InternalIconicsUtils {
    private static char ICON_END = '}';
    private static char ICON_START = '{';
    public static final InternalIconicsUtils INSTANCE = new InternalIconicsUtils();

    private InternalIconicsUtils() {
    }

    @JvmStatic
    public static final LinkedList<StyleContainer> findIconsFromEditable(Editable editable, Map<String, ? extends ITypeface> fonts) {
        StyleContainer styleContainer;
        Editable editable2 = editable;
        Map<String, ? extends ITypeface> map = fonts;
        Intrinsics.checkParameterIsNotNull(editable2, "editable");
        Intrinsics.checkParameterIsNotNull(map, "fonts");
        LinkedList styleContainers = new LinkedList();
        LinkedList<StyleContainer> existingSpans = new LinkedList<>();
        Object[] $this$mapTo$iv = editable2.getSpans(0, editable.length(), ParcelableSpan.class);
        Intrinsics.checkExpressionValueIsNotNull($this$mapTo$iv, "editable.getSpans<Parcel…rcelableSpan::class.java)");
        for (Object item$iv : $this$mapTo$iv) {
            ParcelableSpan it = (ParcelableSpan) item$iv;
            int spanStart = editable2.getSpanStart(it);
            int spanEnd = editable2.getSpanEnd(it);
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            existingSpans.add(new StyleContainer(spanStart, spanEnd, it, editable2.getSpanFlags(it)));
        }
        Collection collection = existingSpans;
        int i = 0;
        Object[] $this$mapTo$iv2 = editable2.getSpans(0, editable.length(), CharacterStyle.class);
        Intrinsics.checkExpressionValueIsNotNull($this$mapTo$iv2, "editable.getSpans<Charac…aracterStyle::class.java)");
        int length = $this$mapTo$iv2.length;
        while (i < length) {
            CharacterStyle it2 = (CharacterStyle) $this$mapTo$iv2[i];
            int spanStart2 = editable2.getSpanStart(it2);
            int spanEnd2 = editable2.getSpanEnd(it2);
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            existingSpans.add(new StyleContainer(spanStart2, spanEnd2, it2, editable2.getSpanFlags(it2)));
            i++;
            $this$mapTo$iv2 = $this$mapTo$iv2;
        }
        Collection collection2 = existingSpans;
        InternalIconicsUtils internalIconicsUtils = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            editable.clearSpans();
            Result.m65constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        int iconStart = -1;
        int i2 = 0;
        while (i2 < editable.length()) {
            char c = editable2.charAt(i2);
            if (c == ICON_START) {
                iconStart = i2;
            } else if (c == ICON_END) {
                if (iconStart > -1 && (styleContainer = placeFontIcon(editable2, iconStart, i2, map)) != null) {
                    styleContainers.add(styleContainer);
                    for (StyleContainer it3 : existingSpans) {
                        int newIconStart = i2 - iconStart;
                        if (it3.getStartIndex() > i2) {
                            it3.setStartIndex(it3.getStartIndex() - newIconStart);
                            it3.setEndIndex(it3.getEndIndex() - newIconStart);
                        } else if (it3.getEndIndex() > i2) {
                            it3.setEndIndex(it3.getEndIndex() - newIconStart);
                        }
                        Editable editable3 = editable;
                    }
                    i2 = iconStart;
                }
                iconStart = -1;
            }
            i2++;
            editable2 = editable;
        }
        styleContainers.addAll(existingSpans);
        return styleContainers;
    }

    @JvmStatic
    private static final StyleContainer placeFontIcon(Editable editable, int iconStart, int iconEnd, Map<String, ? extends ITypeface> fonts) {
        Object obj;
        Editable editable2 = editable;
        int i = iconStart;
        int i2 = iconEnd;
        if (i2 - i >= 6) {
            String iconString = IconicsExtensionsKt.getClearedIconName(editable2.subSequence(i + 1, i2).toString());
            try {
                ITypeface iTypeface = (ITypeface) fonts.get(editable2.subSequence(i + 1, i + 4).toString());
                if (iTypeface != null) {
                    ITypeface typeface = iTypeface;
                    InternalIconicsUtils internalIconicsUtils = INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.m65constructorimpl(typeface.getIcon(iconString));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.m65constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m71isFailureimpl(obj)) {
                        obj = null;
                    }
                    IIcon icon = (IIcon) obj;
                    if (icon != null) {
                        editable2.replace(i, i2 + 1, String.valueOf(icon.getCharacter()));
                        return new StyleContainer(i, i + 1, iconString, typeface);
                    }
                    IconicsLogger.DefaultImpls.log$default(Iconics.logger, 6, Iconics.TAG, "Wrong icon name: " + iconString, (Throwable) null, 8, (Object) null);
                }
                IconicsLogger.DefaultImpls.log$default(Iconics.logger, 6, Iconics.TAG, "Wrong fontId: " + iconString, (Throwable) null, 8, (Object) null);
            } catch (IllegalArgumentException e) {
                IconicsLogger.DefaultImpls.log$default(Iconics.logger, 6, Iconics.TAG, "Wrong icon name: " + iconString, (Throwable) null, 8, (Object) null);
            }
        } else {
            Map<String, ? extends ITypeface> map = fonts;
        }
        return null;
    }

    @JvmStatic
    public static final TextStyleContainer findIcons(Spanned spannable, Map<String, ? extends ITypeface> fonts) {
        CharSequence $this$forEachIndexed$iv;
        Spanned spanned = spannable;
        Map<String, ? extends ITypeface> map = fonts;
        Intrinsics.checkParameterIsNotNull(spanned, "spannable");
        Intrinsics.checkParameterIsNotNull(map, "fonts");
        LinkedList styleContainers = new LinkedList();
        LinkedList<StyleContainer> existingSpans = new LinkedList<>();
        Object[] $this$mapTo$iv = spanned.getSpans(0, spannable.length(), ParcelableSpan.class);
        Intrinsics.checkExpressionValueIsNotNull($this$mapTo$iv, "spannable.getSpans(0, sp…rcelableSpan::class.java)");
        for (Object item$iv : $this$mapTo$iv) {
            ParcelableSpan it = (ParcelableSpan) item$iv;
            int spanStart = spanned.getSpanStart(it);
            int spanEnd = spanned.getSpanEnd(it);
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            existingSpans.add(new StyleContainer(spanStart, spanEnd, it, spanned.getSpanFlags(it)));
        }
        Collection collection = existingSpans;
        Object[] $this$mapTo$iv2 = spanned.getSpans(0, spannable.length(), CharacterStyle.class);
        Intrinsics.checkExpressionValueIsNotNull($this$mapTo$iv2, "spannable.getSpans(0, sp…aracterStyle::class.java)");
        int length = $this$mapTo$iv2.length;
        int i = 0;
        while (i < length) {
            CharacterStyle it2 = (CharacterStyle) $this$mapTo$iv2[i];
            int spanStart2 = spanned.getSpanStart(it2);
            int spanEnd2 = spanned.getSpanEnd(it2);
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            existingSpans.add(new StyleContainer(spanStart2, spanEnd2, it2, spanned.getSpanFlags(it2)));
            i++;
            $this$mapTo$iv2 = $this$mapTo$iv2;
        }
        Collection collection2 = existingSpans;
        SpannableStringBuilder spannedString = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int removedChars = 0;
        CharSequence $this$forEachIndexed$iv2 = spanned;
        int index$iv = 0;
        int i2 = 0;
        while (i2 < $this$forEachIndexed$iv2.length()) {
            int index$iv2 = index$iv + 1;
            char c = $this$forEachIndexed$iv2.charAt(i2);
            if (c == ICON_START) {
                spannedString.append(spannableStringBuilder);
                spannableStringBuilder = new SpannableStringBuilder();
                Intrinsics.checkExpressionValueIsNotNull(spannableStringBuilder.append(c), "tempIconString.append(c)");
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
            } else if (c == ICON_END) {
                spannableStringBuilder.append(c);
                if (spannableStringBuilder.length() > 5) {
                    StyleContainer styleContainer = placeFontIcon(spannedString, spannableStringBuilder, map);
                    if (styleContainer != null) {
                        styleContainers.add(styleContainer);
                        for (StyleContainer it3 : existingSpans) {
                            StyleContainer styleContainer2 = styleContainer;
                            CharSequence $this$forEachIndexed$iv3 = $this$forEachIndexed$iv2;
                            if (it3.getStartIndex() > index$iv - removedChars) {
                                it3.setStartIndex((it3.getStartIndex() - spannableStringBuilder.length()) + 1);
                            }
                            if (it3.getEndIndex() > index$iv - removedChars) {
                                it3.setEndIndex((it3.getEndIndex() - spannableStringBuilder.length()) + 1);
                            }
                            Map<String, ? extends ITypeface> map2 = fonts;
                            styleContainer = styleContainer2;
                            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv3;
                        }
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        removedChars += spannableStringBuilder.length() - 1;
                    } else {
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    }
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    spannedString.append(spannableStringBuilder);
                }
                spannableStringBuilder = new SpannableStringBuilder();
            } else {
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                if (spannableStringBuilder.length() == 0) {
                    spannedString.append(c);
                } else {
                    spannableStringBuilder.append(c);
                }
            }
            i2++;
            Spanned spanned2 = spannable;
            map = fonts;
            index$iv = index$iv2;
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        }
        spannedString.append(spannableStringBuilder);
        styleContainers.addAll(existingSpans);
        return new TextStyleContainer(spannedString, styleContainers);
    }

    @JvmStatic
    private static final StyleContainer placeFontIcon(SpannableStringBuilder spannedString, SpannableStringBuilder tempIconString, Map<String, ? extends ITypeface> fonts) {
        Object obj;
        SpannableStringBuilder spannableStringBuilder = spannedString;
        if (tempIconString.length() >= 6) {
            String iconString = IconicsExtensionsKt.getClearedIconName(tempIconString.subSequence(1, tempIconString.length() - 1).toString());
            ITypeface iTypeface = (ITypeface) fonts.get(tempIconString.subSequence(1, 4).toString());
            if (iTypeface != null) {
                ITypeface typeface = iTypeface;
                InternalIconicsUtils internalIconicsUtils = INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m65constructorimpl(typeface.getIcon(iconString));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m65constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m71isFailureimpl(obj)) {
                    obj = null;
                }
                IIcon icon = (IIcon) obj;
                if (icon != null) {
                    spannableStringBuilder.append(icon.getCharacter());
                    return new StyleContainer(spannedString.length() - 1, spannedString.length(), iconString, typeface);
                }
                IconicsLogger.DefaultImpls.log$default(Iconics.logger, 6, Iconics.TAG, "Wrong icon name: " + iconString, (Throwable) null, 8, (Object) null);
            }
            IconicsLogger.DefaultImpls.log$default(Iconics.logger, 6, Iconics.TAG, "Wrong fontId: " + iconString, (Throwable) null, 8, (Object) null);
        } else {
            Map<String, ? extends ITypeface> map = fonts;
        }
        spannableStringBuilder.append(tempIconString);
        return null;
    }

    @JvmStatic
    public static final void applyStyles(Spannable text, List<StyleContainer> styleContainers, List<? extends CharacterStyle> styles, Map<String, ? extends List<CharacterStyle>> stylesFor) {
        int $i$f$forEach;
        Iterable $this$forEach$iv;
        Spannable spannable = text;
        List<StyleContainer> list = styleContainers;
        Map<String, ? extends List<CharacterStyle>> map = stylesFor;
        Intrinsics.checkParameterIsNotNull(spannable, "text");
        Intrinsics.checkParameterIsNotNull(list, "styleContainers");
        Iterable<StyleContainer> $this$forEach$iv2 = list;
        int $i$f$forEach2 = 0;
        for (StyleContainer it : $this$forEach$iv2) {
            Object styleOrSpan = it.getStyle();
            if (styleOrSpan == null) {
                styleOrSpan = it.getSpan();
            }
            if (styleOrSpan != null) {
                spannable.setSpan(styleOrSpan, it.getStartIndex(), it.getEndIndex(), it.getFlags());
            } else {
                ITypeface font = it.getFont();
                if (font != null) {
                    spannable.setSpan(new IconicsTypefaceSpan("sans-serif", font.getRawTypeface()), it.getStartIndex(), it.getEndIndex(), 33);
                }
            }
            if (map != null) {
                String icon = it.getIcon();
                if (map == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (map.containsKey(icon)) {
                    List<CharacterStyle> $this$forEach$iv3 = (List) map.get(it.getIcon());
                    if ($this$forEach$iv3 != null) {
                        for (CharacterStyle characterStyle : $this$forEach$iv3) {
                            spannable.setSpan(CharacterStyle.wrap(characterStyle), it.getStartIndex(), it.getEndIndex(), it.getFlags());
                            List<StyleContainer> list2 = styleContainers;
                            Map<String, ? extends List<CharacterStyle>> map2 = stylesFor;
                            $this$forEach$iv2 = $this$forEach$iv2;
                            $i$f$forEach2 = $i$f$forEach2;
                        }
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach2;
                    } else {
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach2;
                    }
                    List<StyleContainer> list3 = styleContainers;
                    map = stylesFor;
                    $this$forEach$iv2 = $this$forEach$iv;
                    $i$f$forEach2 = $i$f$forEach;
                }
            }
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            if (styles != null) {
                for (CharacterStyle characterStyle2 : styles) {
                    spannable.setSpan(CharacterStyle.wrap(characterStyle2), it.getStartIndex(), it.getEndIndex(), it.getFlags());
                }
            }
            List<StyleContainer> list32 = styleContainers;
            map = stylesFor;
            $this$forEach$iv2 = $this$forEach$iv;
            $i$f$forEach2 = $i$f$forEach;
        }
    }
}

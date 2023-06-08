package com.mikepenz.iconics.utils;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/utils/TextStyleContainer;", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "styleContainers", "Ljava/util/LinkedList;", "Lcom/mikepenz/iconics/utils/StyleContainer;", "(Landroid/text/SpannableStringBuilder;Ljava/util/LinkedList;)V", "getSpannableStringBuilder", "()Landroid/text/SpannableStringBuilder;", "setSpannableStringBuilder", "(Landroid/text/SpannableStringBuilder;)V", "getStyleContainers", "()Ljava/util/LinkedList;", "setStyleContainers", "(Ljava/util/LinkedList;)V", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: TextStyleContainer.kt */
public final class TextStyleContainer {
    private SpannableStringBuilder spannableStringBuilder;
    private LinkedList<StyleContainer> styleContainers;

    public TextStyleContainer(SpannableStringBuilder spannableStringBuilder2, LinkedList<StyleContainer> styleContainers2) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder2, "spannableStringBuilder");
        Intrinsics.checkParameterIsNotNull(styleContainers2, "styleContainers");
        this.spannableStringBuilder = spannableStringBuilder2;
        this.styleContainers = styleContainers2;
    }

    public final SpannableStringBuilder getSpannableStringBuilder() {
        return this.spannableStringBuilder;
    }

    public final void setSpannableStringBuilder(SpannableStringBuilder spannableStringBuilder2) {
        Intrinsics.checkParameterIsNotNull(spannableStringBuilder2, "<set-?>");
        this.spannableStringBuilder = spannableStringBuilder2;
    }

    public final LinkedList<StyleContainer> getStyleContainers() {
        return this.styleContainers;
    }

    public final void setStyleContainers(LinkedList<StyleContainer> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "<set-?>");
        this.styleContainers = linkedList;
    }
}

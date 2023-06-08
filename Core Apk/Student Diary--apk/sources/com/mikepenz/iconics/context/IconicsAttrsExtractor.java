package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.res.TypedArray;
import com.mikepenz.iconics.IconicsDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%BÉ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\t\u001a\u00020\u0007\u0012\b\b\u0003\u0010\n\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\f\u001a\u00020\u0007\u0012\b\b\u0003\u0010\r\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u0016\u0010!\u001a\u00020\u001b*\u0004\u0018\u00010\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001d\u0010\"\u001a\u0004\u0018\u00010\u0007*\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsAttrsExtractor;", "", "context", "Landroid/content/Context;", "typedArray", "Landroid/content/res/TypedArray;", "iconId", "", "sizeId", "colorsId", "paddingId", "offsetXId", "offsetYId", "contourColorId", "contourWidthId", "backgroundColorId", "cornerRadiusId", "backgroundContourColorId", "backgroundContourWidthId", "shadowRadiusId", "shadowDxId", "shadowDyId", "shadowColorId", "animationsId", "autoMirrorId", "(Landroid/content/Context;Landroid/content/res/TypedArray;IIIIIIIIIIIIIIIIII)V", "extract", "Lcom/mikepenz/iconics/IconicsDrawable;", "icon", "extractOffsets", "", "extractNonNull", "extractWithOffsets", "createIfNeeds", "getDimensionPixelSize", "index", "(Landroid/content/res/TypedArray;I)Ljava/lang/Integer;", "Companion", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsAttrsExtractor.kt */
public final class IconicsAttrsExtractor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEF_COLOR = Integer.MIN_VALUE;
    private static final int DEF_SIZE = -1;
    private int animationsId;
    private int autoMirrorId;
    private int backgroundColorId;
    private int backgroundContourColorId;
    private int backgroundContourWidthId;
    private int colorsId;
    private final Context context;
    private int contourColorId;
    private int contourWidthId;
    private int cornerRadiusId;
    private int iconId;
    private int offsetXId;
    private int offsetYId;
    private int paddingId;
    private int shadowColorId;
    private int shadowDxId;
    private int shadowDyId;
    private int shadowRadiusId;
    private int sizeId;
    private final TypedArray typedArray;

    public IconicsAttrsExtractor(Context context2, TypedArray typedArray2, int iconId2, int sizeId2, int colorsId2, int paddingId2, int offsetXId2, int offsetYId2, int contourColorId2, int contourWidthId2, int backgroundColorId2, int cornerRadiusId2, int backgroundContourColorId2, int backgroundContourWidthId2, int shadowRadiusId2, int shadowDxId2, int shadowDyId2, int shadowColorId2, int animationsId2, int autoMirrorId2) {
        Context context3 = context2;
        TypedArray typedArray3 = typedArray2;
        Intrinsics.checkParameterIsNotNull(context3, "context");
        Intrinsics.checkParameterIsNotNull(typedArray3, "typedArray");
        this.context = context3;
        this.typedArray = typedArray3;
        this.iconId = iconId2;
        this.sizeId = sizeId2;
        this.colorsId = colorsId2;
        this.paddingId = paddingId2;
        this.offsetXId = offsetXId2;
        this.offsetYId = offsetYId2;
        this.contourColorId = contourColorId2;
        this.contourWidthId = contourWidthId2;
        this.backgroundColorId = backgroundColorId2;
        this.cornerRadiusId = cornerRadiusId2;
        this.backgroundContourColorId = backgroundContourColorId2;
        this.backgroundContourWidthId = backgroundContourWidthId2;
        this.shadowRadiusId = shadowRadiusId2;
        this.shadowDxId = shadowDxId2;
        this.shadowDyId = shadowDyId2;
        this.shadowColorId = shadowColorId2;
        this.animationsId = animationsId2;
        this.autoMirrorId = autoMirrorId2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IconicsAttrsExtractor(android.content.Context r25, android.content.res.TypedArray r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, int r39, int r40, int r41, int r42, int r43, int r44, int r45, kotlin.jvm.internal.DefaultConstructorMarker r46) {
        /*
            r24 = this;
            r0 = r45
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r27
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r28
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r29
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r30
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r31
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r32
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r33
        L_0x003b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0041
            r13 = r2
            goto L_0x0043
        L_0x0041:
            r13 = r34
        L_0x0043:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0049
            r14 = r2
            goto L_0x004b
        L_0x0049:
            r14 = r35
        L_0x004b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0051
            r15 = r2
            goto L_0x0053
        L_0x0051:
            r15 = r36
        L_0x0053:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005a
            r16 = r2
            goto L_0x005c
        L_0x005a:
            r16 = r37
        L_0x005c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0063
            r17 = r2
            goto L_0x0065
        L_0x0063:
            r17 = r38
        L_0x0065:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x006c
            r18 = r2
            goto L_0x006e
        L_0x006c:
            r18 = r39
        L_0x006e:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0077
            r19 = r2
            goto L_0x0079
        L_0x0077:
            r19 = r40
        L_0x0079:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0081
            r20 = r2
            goto L_0x0083
        L_0x0081:
            r20 = r41
        L_0x0083:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008b
            r21 = r2
            goto L_0x008d
        L_0x008b:
            r21 = r42
        L_0x008d:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0095
            r22 = r2
            goto L_0x0097
        L_0x0095:
            r22 = r43
        L_0x0097:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009f
            r23 = r2
            goto L_0x00a1
        L_0x009f:
            r23 = r44
        L_0x00a1:
            r3 = r24
            r4 = r25
            r5 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.context.IconicsAttrsExtractor.<init>(android.content.Context, android.content.res.TypedArray, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/iconics/context/IconicsAttrsExtractor$Companion;", "", "()V", "DEF_COLOR", "", "DEF_SIZE", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IconicsAttrsExtractor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public final IconicsDrawable extractNonNull() {
        return createIfNeeds(extract((IconicsDrawable) null, false), this.context);
    }

    public final IconicsDrawable extract(IconicsDrawable icon) {
        return extract(icon, false);
    }

    public final IconicsDrawable extract() {
        return extract((IconicsDrawable) null, false);
    }

    public final IconicsDrawable extractWithOffsets() {
        return extract((IconicsDrawable) null, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x031b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.mikepenz.iconics.IconicsDrawable extract(com.mikepenz.iconics.IconicsDrawable r23, boolean r24) {
        /*
            r22 = this;
            r0 = r22
            if (r23 == 0) goto L_0x0009
            com.mikepenz.iconics.IconicsDrawable r1 = r23.clone()
            goto L_0x000a
        L_0x0009:
            r1 = 0
        L_0x000a:
            android.content.res.TypedArray r2 = r0.typedArray
            int r3 = r0.iconId
            java.lang.String r2 = r2.getString(r3)
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0022
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = r5
            goto L_0x0023
        L_0x0022:
            r3 = r4
        L_0x0023:
            if (r3 != 0) goto L_0x002f
            android.content.Context r3 = r0.context
            com.mikepenz.iconics.IconicsDrawable r3 = r0.createIfNeeds(r1, r3)
            com.mikepenz.iconics.IconicsDrawable r1 = r3.icon((java.lang.String) r2)
        L_0x002f:
            android.content.res.TypedArray r3 = r0.typedArray
            int r6 = r0.colorsId
            android.content.res.ColorStateList r3 = r3.getColorStateList(r6)
            java.lang.String r6 = "it"
            if (r3 == 0) goto L_0x0052
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsColor$Companion r9 = com.mikepenz.iconics.IconicsColor.Companion
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            com.mikepenz.iconics.IconicsColor r9 = r9.colorList(r3)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.color((com.mikepenz.iconics.IconicsColor) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0052:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.sizeId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x007c
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.size((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x007c:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.paddingId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x00a6
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.padding((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x00a6:
            if (r24 == 0) goto L_0x0100
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.offsetYId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x00d4
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.iconOffsetY((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x00d4:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.offsetXId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x0100
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.iconOffsetX((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0100:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.contourColorId
            android.content.res.ColorStateList r3 = r3.getColorStateList(r7)
            if (r3 == 0) goto L_0x0122
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsColor$Companion r9 = com.mikepenz.iconics.IconicsColor.Companion
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            com.mikepenz.iconics.IconicsColor r9 = r9.colorList(r3)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.contourColor((com.mikepenz.iconics.IconicsColor) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0122:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.contourWidthId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x014c
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.contourWidth((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x014c:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.backgroundColorId
            android.content.res.ColorStateList r3 = r3.getColorStateList(r7)
            if (r3 == 0) goto L_0x016f
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsColor$Companion r9 = com.mikepenz.iconics.IconicsColor.Companion
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            com.mikepenz.iconics.IconicsColor r9 = r9.colorList(r3)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.backgroundColor((com.mikepenz.iconics.IconicsColor) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x016f:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.cornerRadiusId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r7)
            if (r3 == 0) goto L_0x019b
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsSize$Companion r9 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            java.lang.Number r10 = (java.lang.Number) r10
            com.mikepenz.iconics.IconicsSize r9 = r9.px(r10)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.roundedCorners((com.mikepenz.iconics.IconicsSize) r9)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x019b:
            android.content.res.TypedArray r3 = r0.typedArray
            int r7 = r0.backgroundContourColorId
            android.content.res.ColorStateList r3 = r3.getColorStateList(r7)
            if (r3 == 0) goto L_0x01be
            r7 = 0
            android.content.Context r8 = r0.context
            com.mikepenz.iconics.IconicsDrawable r8 = r0.createIfNeeds(r1, r8)
            com.mikepenz.iconics.IconicsColor$Companion r9 = com.mikepenz.iconics.IconicsColor.Companion
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            com.mikepenz.iconics.IconicsColor r6 = r9.colorList(r3)
            com.mikepenz.iconics.IconicsDrawable r1 = r8.backgroundContourColor((com.mikepenz.iconics.IconicsColor) r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x01be:
            android.content.res.TypedArray r3 = r0.typedArray
            int r6 = r0.backgroundContourWidthId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r6)
            if (r3 == 0) goto L_0x01ea
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r6 = 0
            android.content.Context r7 = r0.context
            com.mikepenz.iconics.IconicsDrawable r7 = r0.createIfNeeds(r1, r7)
            com.mikepenz.iconics.IconicsSize$Companion r8 = com.mikepenz.iconics.IconicsSize.Companion
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.Number r9 = (java.lang.Number) r9
            com.mikepenz.iconics.IconicsSize r8 = r8.px(r9)
            com.mikepenz.iconics.IconicsDrawable r1 = r7.backgroundContourWidth((com.mikepenz.iconics.IconicsSize) r8)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x01ea:
            android.content.res.TypedArray r3 = r0.typedArray
            int r6 = r0.shadowRadiusId
            java.lang.Integer r3 = r0.getDimensionPixelSize(r3, r6)
            android.content.res.TypedArray r6 = r0.typedArray
            int r7 = r0.shadowDxId
            java.lang.Integer r6 = r0.getDimensionPixelSize(r6, r7)
            android.content.res.TypedArray r7 = r0.typedArray
            int r8 = r0.shadowDyId
            java.lang.Integer r7 = r0.getDimensionPixelSize(r7, r8)
            android.content.res.TypedArray r8 = r0.typedArray
            int r9 = r0.shadowColorId
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r8 = r8.getColor(r9, r10)
            if (r3 == 0) goto L_0x0244
            if (r6 == 0) goto L_0x0244
            if (r7 == 0) goto L_0x0244
            if (r8 == r10) goto L_0x0244
            android.content.Context r9 = r0.context
            com.mikepenz.iconics.IconicsDrawable r9 = r0.createIfNeeds(r1, r9)
            com.mikepenz.iconics.IconicsSize$Companion r10 = com.mikepenz.iconics.IconicsSize.Companion
            r11 = r3
            java.lang.Number r11 = (java.lang.Number) r11
            com.mikepenz.iconics.IconicsSize r10 = r10.px(r11)
            com.mikepenz.iconics.IconicsSize$Companion r11 = com.mikepenz.iconics.IconicsSize.Companion
            r12 = r6
            java.lang.Number r12 = (java.lang.Number) r12
            com.mikepenz.iconics.IconicsSize r11 = r11.px(r12)
            com.mikepenz.iconics.IconicsSize$Companion r12 = com.mikepenz.iconics.IconicsSize.Companion
            r13 = r7
            java.lang.Number r13 = (java.lang.Number) r13
            com.mikepenz.iconics.IconicsSize r12 = r12.px(r13)
            com.mikepenz.iconics.IconicsColor$Companion r13 = com.mikepenz.iconics.IconicsColor.Companion
            com.mikepenz.iconics.IconicsColor r13 = r13.colorInt(r8)
            com.mikepenz.iconics.IconicsDrawable r1 = r9.shadow((com.mikepenz.iconics.IconicsSize) r10, (com.mikepenz.iconics.IconicsSize) r11, (com.mikepenz.iconics.IconicsSize) r12, (com.mikepenz.iconics.IconicsColor) r13)
            goto L_0x0245
        L_0x0244:
        L_0x0245:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            android.content.res.TypedArray r9 = r0.typedArray
            int r10 = r0.animationsId
            java.lang.String r9 = r9.getString(r10)
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x025e
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)
            if (r10 == 0) goto L_0x025c
            goto L_0x025e
        L_0x025c:
            r10 = r5
            goto L_0x025f
        L_0x025e:
            r10 = r4
        L_0x025f:
            if (r10 != 0) goto L_0x0323
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            kotlin.text.Regex r11 = new kotlin.text.Regex
            java.lang.String r12 = "\\|"
            r11.<init>((java.lang.String) r12)
            java.util.List r10 = r11.split(r10, r5)
            r11 = 0
            boolean r12 = r10.isEmpty()
            if (r12 != 0) goto L_0x02ab
            int r12 = r10.size()
            java.util.ListIterator r12 = r10.listIterator(r12)
        L_0x0282:
            boolean r13 = r12.hasPrevious()
            if (r13 == 0) goto L_0x02ab
            java.lang.Object r13 = r12.previous()
            java.lang.String r13 = (java.lang.String) r13
            r14 = 0
            r15 = r13
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r15 = r15.length()
            if (r15 != 0) goto L_0x029a
            r13 = r4
            goto L_0x029b
        L_0x029a:
            r13 = r5
        L_0x029b:
            if (r13 != 0) goto L_0x02aa
            r13 = r10
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            int r14 = r12.nextIndex()
            int r14 = r14 + r4
            java.util.List r4 = kotlin.collections.CollectionsKt.take(r13, r14)
            goto L_0x02af
        L_0x02aa:
            goto L_0x0282
        L_0x02ab:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L_0x02af:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r10 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            r12 = r4
            r13 = 0
            r14 = r12
            r15 = 0
            java.util.Iterator r16 = r14.iterator()
        L_0x02c1:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x02e8
            java.lang.Object r17 = r16.next()
            r18 = r17
            r19 = 0
            r20 = r18
            java.lang.String r20 = (java.lang.String) r20
            r21 = 0
            com.mikepenz.iconics.animation.IconicsAnimationProcessor r20 = com.mikepenz.iconics.Iconics.findProcessor(r20)
            if (r20 == 0) goto L_0x02e5
            r21 = r20
            r20 = 0
            r5 = r21
            r11.add(r5)
            goto L_0x02e6
        L_0x02e5:
        L_0x02e6:
            r5 = 0
            goto L_0x02c1
        L_0x02e8:
            r4 = r11
            java.util.List r4 = (java.util.List) r4
            android.content.Context r5 = r0.context
            com.mikepenz.iconics.IconicsDrawable r5 = r0.createIfNeeds(r1, r5)
            com.mikepenz.iconics.animation.IconicsAnimatedDrawable r5 = r5.toAnimatedDrawable()
            r10 = r4
            java.util.Collection r10 = (java.util.Collection) r10
            r11 = 0
            r12 = r10
            r13 = 0
            com.mikepenz.iconics.animation.IconicsAnimationProcessor[] r14 = new com.mikepenz.iconics.animation.IconicsAnimationProcessor[r13]
            java.lang.Object[] r13 = r12.toArray(r14)
            if (r13 == 0) goto L_0x031b
            com.mikepenz.iconics.animation.IconicsAnimationProcessor[] r13 = (com.mikepenz.iconics.animation.IconicsAnimationProcessor[]) r13
            int r10 = r13.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r13, r10)
            com.mikepenz.iconics.animation.IconicsAnimationProcessor[] r10 = (com.mikepenz.iconics.animation.IconicsAnimationProcessor[]) r10
            com.mikepenz.iconics.animation.IconicsAnimatedDrawable r5 = r5.processors(r10)
            r1 = r5
            com.mikepenz.iconics.IconicsDrawable r1 = (com.mikepenz.iconics.IconicsDrawable) r1
            goto L_0x0323
        L_0x031b:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.Array<T>"
            r5.<init>(r13)
            throw r5
        L_0x0323:
            android.content.res.TypedArray r4 = r0.typedArray
            int r5 = r0.autoMirrorId
            r10 = 0
            boolean r4 = r4.getBoolean(r5, r10)
            android.content.Context r5 = r0.context
            com.mikepenz.iconics.IconicsDrawable r5 = r0.createIfNeeds(r1, r5)
            com.mikepenz.iconics.IconicsDrawable r1 = r5.autoMirror(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.context.IconicsAttrsExtractor.extract(com.mikepenz.iconics.IconicsDrawable, boolean):com.mikepenz.iconics.IconicsDrawable");
    }

    private final Integer getDimensionPixelSize(TypedArray $this$getDimensionPixelSize, int index) {
        Integer valueOf = Integer.valueOf($this$getDimensionPixelSize.getDimensionPixelSize(index, -1));
        if (valueOf.intValue() != -1) {
            return valueOf;
        }
        return null;
    }

    private final IconicsDrawable createIfNeeds(IconicsDrawable $this$createIfNeeds, Context context2) {
        return $this$createIfNeeds != null ? $this$createIfNeeds : new IconicsDrawable(context2);
    }
}

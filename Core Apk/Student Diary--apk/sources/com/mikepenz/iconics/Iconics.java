package com.mikepenz.iconics;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.widget.Button;
import android.widget.TextView;
import com.mikepenz.iconics.animation.IconicsAnimationProcessor;
import com.mikepenz.iconics.context.ReflectionUtils;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.IconicsExtensionsKt;
import com.mikepenz.iconics.utils.IconicsLogger;
import com.mikepenz.iconics.utils.IconicsPreconditions;
import com.mikepenz.iconics.utils.InternalIconicsUtils;
import com.mikepenz.iconics.utils.TextStyleContainer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003;<=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0007J\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0005H\u0007J\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000fH\u0007J\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000fH\u0007J\u0014\u0010&\u001a\u00020'2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000fH\u0007J*\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010(H\u0003J\u0010\u0010*\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0007J\b\u0010+\u001a\u00020'H\u0007J\u0010\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006H\u0007J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\fH\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0007JR\u00100\u001a\u0002012\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010(2\u0006\u00102\u001a\u0002012\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00192\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020406\u0018\u00010(H\u0007J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0007JR\u00107\u001a\u00020'2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010(2\u0006\u00102\u001a\u0002092\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00192\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020406\u0018\u00010(H\u0007J\f\u0010:\u001a\u00020\u0006*\u00020\u0006H\u0003R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R:\u0010\n\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u0004j\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0000X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8\u0006@@X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00198FX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001b¨\u0006>"}, d2 = {"Lcom/mikepenz/iconics/Iconics;", "", "()V", "FONTS", "Ljava/util/HashMap;", "", "Lcom/mikepenz/iconics/typeface/ITypeface;", "Lkotlin/collections/HashMap;", "INIT_DONE", "", "PROCESSORS", "Ljava/lang/Class;", "Lcom/mikepenz/iconics/animation/IconicsAnimationProcessor;", "TAG", "<set-?>", "Landroid/content/Context;", "applicationContext", "applicationContext$annotations", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext$iconics_core", "(Landroid/content/Context;)V", "logger", "Lcom/mikepenz/iconics/utils/IconicsLogger;", "registeredFonts", "", "getRegisteredFonts", "()Ljava/util/List;", "registeredProcessors", "registeredProcessors$annotations", "getRegisteredProcessors", "findFont", "icon", "Lcom/mikepenz/iconics/typeface/IIcon;", "key", "context", "findProcessor", "animationTag", "init", "", "", "fonts", "isIconExists", "markInitDone", "registerFont", "font", "registerProcessor", "processor", "style", "Landroid/text/Spanned;", "textSpanned", "styles", "Landroid/text/style/CharacterStyle;", "stylesFor", "", "styleEditable", "editable", "Landroid/text/Editable;", "validate", "Builder", "BuilderString", "BuilderView", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: Iconics.kt */
public final class Iconics {
    private static final HashMap<String, ITypeface> FONTS = new HashMap<>();
    private static boolean INIT_DONE;
    public static final Iconics INSTANCE = new Iconics();
    private static final HashMap<String, Class<? extends IconicsAnimationProcessor>> PROCESSORS = new HashMap<>();
    public static final String TAG;
    public static Context applicationContext;
    public static IconicsLogger logger = IconicsLogger.DEFAULT;

    @JvmStatic
    public static /* synthetic */ void applicationContext$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void registeredProcessors$annotations() {
    }

    static {
        String simpleName = Iconics.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "Iconics::class.java.simpleName");
        TAG = simpleName;
    }

    private Iconics() {
    }

    public static final Context getApplicationContext() {
        Context context = applicationContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        }
        return context;
    }

    public static final void setApplicationContext$iconics_core(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        applicationContext = context;
    }

    public static /* synthetic */ void init$default(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        init(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x011a A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136 A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0145 A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014e A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0157 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void init(android.content.Context r21) {
        /*
            if (r21 == 0) goto L_0x0011
            android.content.Context r0 = applicationContext
            if (r0 != 0) goto L_0x0011
            android.content.Context r0 = r21.getApplicationContext()
            java.lang.String r1 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            applicationContext = r0
        L_0x0011:
            boolean r0 = INIT_DONE
            if (r0 != 0) goto L_0x0198
            android.content.Context r0 = applicationContext
            if (r0 == 0) goto L_0x018e
            java.lang.String r1 = "applicationContext"
            if (r0 != 0) goto L_0x0020
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0020:
            java.lang.String[] r2 = com.mikepenz.iconics.utils.GenericsUtil.getDefinedFonts(r0)
            r3 = 0
            int r4 = r2.length
            r5 = 0
            r6 = r5
        L_0x0028:
            java.lang.String r7 = "null cannot be cast to non-null type T"
            java.lang.String r8 = "cls.newInstance()"
            java.lang.String r9 = "INSTANCE"
            java.lang.String r10 = "Class.forName(name)"
            r11 = 6
            r12 = 0
            if (r6 >= r4) goto L_0x00ce
            r13 = r2[r6]
            r14 = r13
            r15 = 0
            com.mikepenz.iconics.context.ReflectionUtils r0 = com.mikepenz.iconics.context.ReflectionUtils.INSTANCE     // Catch:{ Exception -> 0x00ac }
            r16 = r0
            r17 = 0
            java.lang.Class r0 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x00ac }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r10)     // Catch:{ Exception -> 0x00ac }
            r10 = r0
            r18 = r16
            r19 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005a }
            r0 = r18
            r20 = 0
            java.lang.reflect.Field r9 = r10.getField(r9)     // Catch:{ all -> 0x005a }
            java.lang.Object r0 = kotlin.Result.m65constructorimpl(r9)     // Catch:{ all -> 0x005a }
            goto L_0x0065
        L_0x005a:
            r0 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r0 = kotlin.Result.m65constructorimpl(r0)     // Catch:{ Exception -> 0x00ac }
        L_0x0065:
            boolean r9 = kotlin.Result.m71isFailureimpl(r0)     // Catch:{ Exception -> 0x00ac }
            if (r9 == 0) goto L_0x006c
            r0 = r12
        L_0x006c:
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch:{ Exception -> 0x00ac }
            if (r0 == 0) goto L_0x0094
            int r9 = r0.getModifiers()     // Catch:{ Exception -> 0x00ac }
            boolean r9 = java.lang.reflect.Modifier.isFinal(r9)     // Catch:{ Exception -> 0x00ac }
            if (r9 == 0) goto L_0x0094
            int r9 = r0.getModifiers()     // Catch:{ Exception -> 0x00ac }
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)     // Catch:{ Exception -> 0x00ac }
            if (r9 == 0) goto L_0x0094
            java.lang.Object r8 = r0.get(r12)     // Catch:{ Exception -> 0x00ac }
            if (r8 == 0) goto L_0x008e
            goto L_0x009c
        L_0x008e:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x00ac }
            r8.<init>(r7)     // Catch:{ Exception -> 0x00ac }
            throw r8     // Catch:{ Exception -> 0x00ac }
        L_0x0094:
            java.lang.Object r7 = r10.newInstance()     // Catch:{ Exception -> 0x00ac }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)     // Catch:{ Exception -> 0x00ac }
            r8 = r7
        L_0x009c:
            if (r8 == 0) goto L_0x00a4
            com.mikepenz.iconics.typeface.ITypeface r8 = (com.mikepenz.iconics.typeface.ITypeface) r8     // Catch:{ Exception -> 0x00ac }
            registerFont(r8)     // Catch:{ Exception -> 0x00ac }
            goto L_0x00c8
        L_0x00a4:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x00ac }
            java.lang.String r7 = "null cannot be cast to non-null type com.mikepenz.iconics.typeface.ITypeface"
            r0.<init>(r7)     // Catch:{ Exception -> 0x00ac }
            throw r0     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            r0 = move-exception
            com.mikepenz.iconics.utils.IconicsLogger r7 = logger
            java.lang.String r8 = TAG
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Can't init font: "
            r9.append(r10)
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            r10 = r0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            r7.log(r11, r8, r9, r10)
        L_0x00c8:
            int r6 = r6 + 1
            goto L_0x0028
        L_0x00ce:
            android.content.Context r0 = applicationContext
            if (r0 != 0) goto L_0x00d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00d6:
            java.lang.String[] r1 = com.mikepenz.iconics.utils.GenericsUtil.getDefinedProcessors(r0)
            r2 = 0
            int r3 = r1.length
        L_0x00dc:
            if (r5 >= r3) goto L_0x0188
            r4 = r1[r5]
            r6 = r4
            r13 = 0
            com.mikepenz.iconics.context.ReflectionUtils r0 = com.mikepenz.iconics.context.ReflectionUtils.INSTANCE     // Catch:{ Exception -> 0x015f }
            r14 = r0
            r15 = 0
            java.lang.Class r0 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x015f }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r10)     // Catch:{ Exception -> 0x015f }
            r16 = r0
            r17 = r14
            r18 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0107 }
            r0 = r17
            r19 = 0
            r11 = r16
            java.lang.reflect.Field r16 = r11.getField(r9)     // Catch:{ all -> 0x0105 }
            java.lang.Object r0 = kotlin.Result.m65constructorimpl(r16)     // Catch:{ all -> 0x0105 }
            goto L_0x0114
        L_0x0105:
            r0 = move-exception
            goto L_0x010a
        L_0x0107:
            r0 = move-exception
            r11 = r16
        L_0x010a:
            kotlin.Result$Companion r16 = kotlin.Result.Companion     // Catch:{ Exception -> 0x015f }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ Exception -> 0x015f }
            java.lang.Object r0 = kotlin.Result.m65constructorimpl(r0)     // Catch:{ Exception -> 0x015f }
        L_0x0114:
            boolean r16 = kotlin.Result.m71isFailureimpl(r0)     // Catch:{ Exception -> 0x015f }
            if (r16 == 0) goto L_0x011b
            r0 = r12
        L_0x011b:
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch:{ Exception -> 0x015f }
            if (r0 == 0) goto L_0x0145
            int r16 = r0.getModifiers()     // Catch:{ Exception -> 0x015f }
            boolean r16 = java.lang.reflect.Modifier.isFinal(r16)     // Catch:{ Exception -> 0x015f }
            if (r16 == 0) goto L_0x0145
            int r16 = r0.getModifiers()     // Catch:{ Exception -> 0x015f }
            boolean r16 = java.lang.reflect.Modifier.isStatic(r16)     // Catch:{ Exception -> 0x015f }
            if (r16 == 0) goto L_0x0145
            java.lang.Object r16 = r0.get(r12)     // Catch:{ Exception -> 0x015f }
            if (r16 == 0) goto L_0x013f
            r12 = r16
            goto L_0x014c
        L_0x013f:
            kotlin.TypeCastException r12 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x015f }
            r12.<init>(r7)     // Catch:{ Exception -> 0x015f }
            throw r12     // Catch:{ Exception -> 0x015f }
        L_0x0145:
            java.lang.Object r12 = r11.newInstance()     // Catch:{ Exception -> 0x015f }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r8)     // Catch:{ Exception -> 0x015f }
        L_0x014c:
            if (r12 == 0) goto L_0x0157
            com.mikepenz.iconics.animation.IconicsAnimationProcessor r12 = (com.mikepenz.iconics.animation.IconicsAnimationProcessor) r12     // Catch:{ Exception -> 0x015f }
            registerProcessor(r12)     // Catch:{ Exception -> 0x015f }
            r17 = r1
            r1 = 6
            goto L_0x017e
        L_0x0157:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x015f }
            java.lang.String r11 = "null cannot be cast to non-null type com.mikepenz.iconics.animation.IconicsAnimationProcessor"
            r0.<init>(r11)     // Catch:{ Exception -> 0x015f }
            throw r0     // Catch:{ Exception -> 0x015f }
        L_0x015f:
            r0 = move-exception
            com.mikepenz.iconics.utils.IconicsLogger r11 = logger
            java.lang.String r12 = TAG
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Can't init processor: "
            r14.append(r15)
            r14.append(r6)
            java.lang.String r14 = r14.toString()
            r15 = r0
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            r17 = r1
            r1 = 6
            r11.log(r1, r12, r14, r15)
        L_0x017e:
            int r5 = r5 + 1
            r11 = r1
            r1 = r17
            r12 = 0
            goto L_0x00dc
        L_0x0188:
            r17 = r1
            r0 = 1
            INIT_DONE = r0
            goto L_0x0198
        L_0x018e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A 'Iconics.init(context)' has to happen first. Call from your application. Usually this happens via an 'IconicsDrawable' usage."
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0198:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.iconics.Iconics.init(android.content.Context):void");
    }

    @JvmStatic
    private static final Map<String, ITypeface> init(Map<String, ? extends ITypeface> fonts) {
        boolean z = true;
        init$default((Context) null, 1, (Object) null);
        if (fonts != null && !fonts.isEmpty()) {
            z = false;
        }
        return z ? FONTS : fonts;
    }

    @JvmStatic
    public static final void markInitDone() {
        if (!FONTS.isEmpty()) {
            INIT_DONE = true;
            return;
        }
        throw new IllegalArgumentException("At least one font needs to be registered first\n" + "    via " + INSTANCE.getClass().getCanonicalName() + ".registerFont(Iconics.kt:117)");
    }

    @JvmStatic
    public static final boolean isIconExists(String icon) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        Iconics iconics = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            ITypeface findFont$default = findFont$default(IconicsExtensionsKt.getIconPrefix(icon), (Context) null, 2, (Object) null);
            if (findFont$default == null) {
                Intrinsics.throwNpe();
            }
            obj = Result.m65constructorimpl(findFont$default.getIcon(IconicsExtensionsKt.getClearedIconName(icon)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m72isSuccessimpl(obj);
    }

    @JvmStatic
    public static final boolean registerFont(ITypeface font) {
        Intrinsics.checkParameterIsNotNull(font, "font");
        FONTS.put(font.getMappingPrefix(), validate(font));
        return true;
    }

    @JvmStatic
    public static final void registerProcessor(IconicsAnimationProcessor processor) {
        Intrinsics.checkParameterIsNotNull(processor, "processor");
        PROCESSORS.put(processor.getAnimationTag(), processor.getClass());
    }

    @JvmStatic
    public static final IconicsAnimationProcessor findProcessor(String animationTag) {
        Object obj;
        Object obj2;
        Intrinsics.checkParameterIsNotNull(animationTag, "animationTag");
        init$default((Context) null, 1, (Object) null);
        Class it = PROCESSORS.get(animationTag);
        if (it != null) {
            try {
                ReflectionUtils this_$iv = ReflectionUtils.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                Class cls$iv = it;
                try {
                    Result.Companion companion = Result.Companion;
                    ReflectionUtils reflectionUtils = this_$iv;
                    obj = Result.m65constructorimpl(cls$iv.getField("INSTANCE"));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m65constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m71isFailureimpl(obj)) {
                    obj = null;
                }
                Field instanceField$iv = (Field) obj;
                if (instanceField$iv == null || !Modifier.isFinal(instanceField$iv.getModifiers()) || !Modifier.isStatic(instanceField$iv.getModifiers())) {
                    obj2 = cls$iv.newInstance();
                    Intrinsics.checkExpressionValueIsNotNull(obj2, "cls.newInstance()");
                } else {
                    obj2 = instanceField$iv.get((Object) null);
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type T");
                    }
                }
                return (IconicsAnimationProcessor) obj2;
            } catch (IllegalAccessException e) {
                logger.log(6, TAG, "Can't create processor for animation tag " + animationTag, e);
            } catch (InstantiationException e2) {
                logger.log(6, TAG, "Can't create processor for animation tag " + animationTag, e2);
            }
        }
        return null;
    }

    @JvmStatic
    private static final ITypeface validate(ITypeface $this$validate) {
        IconicsPreconditions.checkMappingPrefix($this$validate.getMappingPrefix());
        return $this$validate;
    }

    private final List<ITypeface> getRegisteredFonts() {
        Collection<ITypeface> values = FONTS.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "FONTS.values");
        return CollectionsKt.toList(values);
    }

    public static /* synthetic */ List getRegisteredFonts$default(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return getRegisteredFonts(context);
    }

    @JvmStatic
    public static final List<ITypeface> getRegisteredFonts(Context context) {
        init(context);
        return INSTANCE.getRegisteredFonts();
    }

    public static final List<Class<? extends IconicsAnimationProcessor>> getRegisteredProcessors() {
        init$default((Context) null, 1, (Object) null);
        Collection<Class<? extends IconicsAnimationProcessor>> values = PROCESSORS.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "PROCESSORS.values");
        return CollectionsKt.toList(values);
    }

    public static /* synthetic */ List getRegisteredProcessors$default(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return getRegisteredProcessors(context);
    }

    @JvmStatic
    public static final List<Class<? extends IconicsAnimationProcessor>> getRegisteredProcessors(Context context) {
        init(context);
        return getRegisteredProcessors();
    }

    public static /* synthetic */ ITypeface findFont$default(String str, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            context = null;
        }
        return findFont(str, context);
    }

    @JvmStatic
    public static final ITypeface findFont(String key, Context context) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        init(context);
        return FONTS.get(key);
    }

    @JvmStatic
    public static final ITypeface findFont(IIcon icon) {
        Intrinsics.checkParameterIsNotNull(icon, "icon");
        return icon.getTypeface();
    }

    @JvmStatic
    public static final Spanned style(Spanned textSpanned) {
        Intrinsics.checkParameterIsNotNull(textSpanned, "textSpanned");
        return style((Map<String, ? extends ITypeface>) null, textSpanned, (List<? extends CharacterStyle>) null, (Map<String, ? extends List<CharacterStyle>>) null);
    }

    @JvmStatic
    public static final Spanned style(Map<String, ? extends ITypeface> fonts, Spanned textSpanned, List<? extends CharacterStyle> styles, Map<String, ? extends List<CharacterStyle>> stylesFor) {
        Intrinsics.checkParameterIsNotNull(textSpanned, "textSpanned");
        TextStyleContainer textStyleContainer = InternalIconicsUtils.findIcons(textSpanned, init(fonts));
        SpannableString sb = SpannableString.valueOf(textStyleContainer.getSpannableStringBuilder());
        Intrinsics.checkExpressionValueIsNotNull(sb, "sb");
        InternalIconicsUtils.applyStyles(sb, textStyleContainer.getStyleContainers(), styles, stylesFor);
        return sb;
    }

    @JvmStatic
    public static final void styleEditable(Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, "editable");
        styleEditable((Map<String, ? extends ITypeface>) null, editable, (List<? extends CharacterStyle>) null, (Map<String, ? extends List<CharacterStyle>>) null);
    }

    @JvmStatic
    public static final void styleEditable(Map<String, ? extends ITypeface> fonts, Editable textSpanned, List<? extends CharacterStyle> styles, Map<String, ? extends List<CharacterStyle>> stylesFor) {
        Intrinsics.checkParameterIsNotNull(textSpanned, "textSpanned");
        InternalIconicsUtils.applyStyles(textSpanned, InternalIconicsUtils.findIconsFromEditable(textSpanned, init(fonts)), styles, stylesFor);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f`\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/Iconics$BuilderString;", "", "fonts", "", "Lcom/mikepenz/iconics/typeface/ITypeface;", "text", "Landroid/text/Spanned;", "withStyles", "Landroid/text/style/CharacterStyle;", "withStylesFor", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Ljava/util/List;Landroid/text/Spanned;Ljava/util/List;Ljava/util/HashMap;)V", "build", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: Iconics.kt */
    public static final class BuilderString {
        private final List<ITypeface> fonts;
        private final Spanned text;
        private final List<CharacterStyle> withStyles;
        private final HashMap<String, List<CharacterStyle>> withStylesFor;

        public BuilderString(List<? extends ITypeface> fonts2, Spanned text2, List<? extends CharacterStyle> withStyles2, HashMap<String, List<CharacterStyle>> withStylesFor2) {
            Intrinsics.checkParameterIsNotNull(fonts2, "fonts");
            Intrinsics.checkParameterIsNotNull(text2, "text");
            Intrinsics.checkParameterIsNotNull(withStyles2, "withStyles");
            Intrinsics.checkParameterIsNotNull(withStylesFor2, "withStylesFor");
            this.fonts = fonts2;
            this.text = text2;
            this.withStyles = withStyles2;
            this.withStylesFor = withStylesFor2;
        }

        public final Spanned build() {
            Iterable $this$associateBy$iv = this.fonts;
            Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16));
            for (Object element$iv$iv : $this$associateBy$iv) {
                destination$iv$iv.put(((ITypeface) element$iv$iv).getMappingPrefix(), element$iv$iv);
            }
            return Iconics.style(destination$iv$iv, this.text, this.withStyles, this.withStylesFor);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f`\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mikepenz/iconics/Iconics$BuilderView;", "", "fonts", "", "Lcom/mikepenz/iconics/typeface/ITypeface;", "view", "Landroid/widget/TextView;", "withStyles", "Landroid/text/style/CharacterStyle;", "withStylesFor", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Ljava/util/List;Landroid/widget/TextView;Ljava/util/List;Ljava/util/HashMap;)V", "build", "", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: Iconics.kt */
    public static final class BuilderView {
        private final List<ITypeface> fonts;
        private final TextView view;
        private final List<CharacterStyle> withStyles;
        private final HashMap<String, List<CharacterStyle>> withStylesFor;

        public BuilderView(List<? extends ITypeface> fonts2, TextView view2, List<? extends CharacterStyle> withStyles2, HashMap<String, List<CharacterStyle>> withStylesFor2) {
            Intrinsics.checkParameterIsNotNull(fonts2, "fonts");
            Intrinsics.checkParameterIsNotNull(view2, "view");
            Intrinsics.checkParameterIsNotNull(withStyles2, "withStyles");
            Intrinsics.checkParameterIsNotNull(withStylesFor2, "withStylesFor");
            this.fonts = fonts2;
            this.view = view2;
            this.withStyles = withStyles2;
            this.withStylesFor = withStylesFor2;
        }

        public final void build() {
            HashMap mappedFonts = new HashMap();
            for (ITypeface it : this.fonts) {
                Pair pair = TuplesKt.to(it.getMappingPrefix(), it);
                mappedFonts.put(pair.getFirst(), pair.getSecond());
            }
            Map map = mappedFonts;
            if (this.view.getText() instanceof Spanned) {
                TextView textView = this.view;
                Map map2 = mappedFonts;
                CharSequence text = textView.getText();
                if (text != null) {
                    textView.setText(Iconics.style(map2, (Spanned) text, this.withStyles, this.withStylesFor));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.text.Spanned");
                }
            } else {
                this.view.setText(Iconics.style(mappedFonts, new SpannableString(this.view.getText()), this.withStyles, this.withStylesFor));
            }
            TextView textView2 = this.view;
            if (textView2 instanceof Button) {
                textView2.setAllCaps(false);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0010J\u000e\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0012J\u000e\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0014J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0015j\u0002`\u0016J\u001f\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0018\"\u00020\u0007¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0018\"\u00020\u0007¢\u0006\u0002\u0010\u001cJ'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\n2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0018\"\u00020\u0007¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\tj\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/mikepenz/iconics/Iconics$Builder;", "", "()V", "fonts", "Ljava/util/LinkedList;", "Lcom/mikepenz/iconics/typeface/ITypeface;", "styles", "Landroid/text/style/CharacterStyle;", "stylesFor", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "font", "on", "Lcom/mikepenz/iconics/Iconics$BuilderString;", "Landroid/text/Spanned;", "Lcom/mikepenz/iconics/Iconics$BuilderView;", "Landroid/widget/Button;", "Landroid/widget/TextView;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "style", "", "([Landroid/text/style/CharacterStyle;)Lcom/mikepenz/iconics/Iconics$Builder;", "styleFor", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Lcom/mikepenz/iconics/typeface/IIcon;[Landroid/text/style/CharacterStyle;)Lcom/mikepenz/iconics/Iconics$Builder;", "(Ljava/lang/String;[Landroid/text/style/CharacterStyle;)Lcom/mikepenz/iconics/Iconics$Builder;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: Iconics.kt */
    public static final class Builder {
        private final LinkedList<ITypeface> fonts = new LinkedList<>();
        private final LinkedList<CharacterStyle> styles = new LinkedList<>();
        private final HashMap<String, List<CharacterStyle>> stylesFor = new HashMap<>();

        public final Builder style(CharacterStyle... styles2) {
            Intrinsics.checkParameterIsNotNull(styles2, "styles");
            CollectionsKt.addAll(this.styles, (T[]) styles2);
            return this;
        }

        public final Builder styleFor(IIcon styleFor, CharacterStyle... styles2) {
            Intrinsics.checkParameterIsNotNull(styleFor, "styleFor");
            Intrinsics.checkParameterIsNotNull(styles2, "styles");
            return styleFor(styleFor.getName(), (CharacterStyle[]) Arrays.copyOf(styles2, styles2.length));
        }

        public final Builder styleFor(String styleFor, CharacterStyle... styles2) {
            Intrinsics.checkParameterIsNotNull(styleFor, "styleFor");
            Intrinsics.checkParameterIsNotNull(styles2, "styles");
            Object clearedStyleFor = IconicsExtensionsKt.getClearedIconName(styleFor);
            for (CharacterStyle it : styles2) {
                Map $this$getOrPut$iv = this.stylesFor;
                Object key$iv = clearedStyleFor;
                Object value$iv = $this$getOrPut$iv.get(key$iv);
                if (value$iv == null) {
                    Object answer$iv = new LinkedList();
                    $this$getOrPut$iv.put(key$iv, answer$iv);
                    value$iv = answer$iv;
                }
                ((List) value$iv).add(it);
            }
            return this;
        }

        public final Builder font(ITypeface font) {
            Intrinsics.checkParameterIsNotNull(font, "font");
            this.fonts.add(font);
            return this;
        }

        public final BuilderString on(Spanned on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            return new BuilderString(this.fonts, on, this.styles, this.stylesFor);
        }

        public final BuilderString on(String on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            return on((Spanned) new SpannableString(on));
        }

        public final BuilderString on(CharSequence on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            return on(on.toString());
        }

        public final BuilderString on(StringBuilder on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            String sb = on.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb, "on.toString()");
            return on(sb);
        }

        public final BuilderView on(TextView on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            return new BuilderView(this.fonts, on, this.styles, this.stylesFor);
        }

        public final BuilderView on(Button on) {
            Intrinsics.checkParameterIsNotNull(on, "on");
            return new BuilderView(this.fonts, on, this.styles, this.stylesFor);
        }
    }
}

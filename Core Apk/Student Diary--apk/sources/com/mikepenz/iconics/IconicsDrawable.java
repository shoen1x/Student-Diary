package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.IconicsExtensionsKt;
import com.mikepenz.iconics.utils.IconicsLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\t¢\u0006\u0002\u0010\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u0006\u0010^\u001a\u00020\u0000J\u0016\u0010_\u001a\u00020\u00002\u000e\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150aJ\u0010\u0010_\u001a\u00020\u00002\b\b\u0001\u0010_\u001a\u00020\u0015J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020@J\u0016\u0010\u0014\u001a\u00020\u00002\u000e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0aJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010f\u001a\u00020eJ\u0016\u0010\u001e\u001a\u00020\u00002\u000e\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0aJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010f\u001a\u00020eJ\u0016\u0010\"\u001a\u00020\u00002\u000e\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\b\u0010k\u001a\u00020lH\u0016J\u0006\u0010m\u001a\u00020\u0000J\u0006\u0010n\u001a\u00020\u0000J\u0016\u0010#\u001a\u00020\u00002\u000e\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0aJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010f\u001a\u00020eJ\u0016\u0010p\u001a\u00020\u00002\u000e\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0aJ\u0010\u0010p\u001a\u00020\u00002\b\u0010r\u001a\u0004\u0018\u00010;J\u0016\u00100\u001a\u00020\u00002\u000e\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0aJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010f\u001a\u00020eJ\u0016\u00104\u001a\u00020\u00002\u000e\u0010t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u001f\u0010u\u001a\u0002Hv\"\b\b\u0000\u0010v*\u00020\u00002\u0006\u0010w\u001a\u0002HvH\u0002¢\u0006\u0002\u0010xJ\u0010\u0010y\u001a\u00020l2\u0006\u0010z\u001a\u00020{H\u0016J\u0016\u0010|\u001a\u00020\u00002\u000e\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0aJ\u000e\u0010|\u001a\u00020\u00002\u0006\u0010E\u001a\u00020@J\u0016\u0010~\u001a\u00020\u00002\u000e\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0aJ\u000e\u0010~\u001a\u00020\u00002\u0006\u0010~\u001a\u00020@J\t\u0010\u0001\u001a\u00020\u0015H\u0017J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\u0017\u0010\u0004\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0aJ\u001f\u0010\u0004\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050aH\u0007¢\u0006\u0003\b\u0001J\u001f\u0010\u0004\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070aH\u0007¢\u0006\u0003\b\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\tJ\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\tH\u0004J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0019\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\t\u0010\u000b\u001a\u0005\u0018\u00010\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0007J\u0017\u0010<\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0017\u0010=\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010=\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ \u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070aH\u0007¢\u0006\u0003\b\u0001J\u001e\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00072\u000b\b\u0002\u0010\u000b\u001a\u0005\u0018\u00010\u0001H\u0007J\t\u0010\u0001\u001a\u00020@H\u0016J\t\u0010\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020IH\u0002J\u0012\u0010\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020IH\u0014J\u0015\u0010\u0001\u001a\u00020@2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u0018\u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000f\u0010\u0001\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0018\u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0aJ\u000f\u0010\u0001\u001a\u00020\u00002\u0006\u0010G\u001a\u00020@J\u0018\u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000f\u0010\u0001\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0018\u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000f\u0010\u0001\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0018\u0010\u0001\u001a\u00020\u00002\u000f\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000f\u0010\u0001\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0013\u0010 \u0001\u001a\u00020l2\b\b\u0001\u0010_\u001a\u00020\u0015H\u0016J\u0013\u0010¡\u0001\u001a\u00020l2\b\u0010r\u001a\u0004\u0018\u00010;H\u0016J\u0013\u0010¢\u0001\u001a\u00020@2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010£\u0001\u001a\u00020l2\b\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0016J\u0013\u0010¤\u0001\u001a\u00020l2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016JR\u0010¥\u0001\u001a\u00020\u00002\u0011\b\u0002\u0010¦\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0a2\u0011\b\u0002\u0010§\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0a2\u0011\b\u0002\u0010¨\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0a2\u0010\b\u0002\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0aJ2\u0010¥\u0001\u001a\u00020\u00002\t\b\u0002\u0010©\u0001\u001a\u00020i2\t\b\u0002\u0010ª\u0001\u001a\u00020i2\t\b\u0002\u0010«\u0001\u001a\u00020i2\b\b\u0002\u0010#\u001a\u00020eJ\u0017\u0010j\u001a\u00020\u00002\u000f\u0010¬\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0017\u0010X\u001a\u00020\u00002\u000f\u0010­\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0017\u0010Y\u001a\u00020\u00002\u000f\u0010®\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010i0aJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010j\u001a\u00020iJ\u0019\u0010¯\u0001\u001a\u00020\u00002\u0010\u0010°\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010±\u00010aJ\u0011\u0010¯\u0001\u001a\u00020\u00002\b\u0010¯\u0001\u001a\u00030±\u0001J\b\u0010²\u0001\u001a\u00030³\u0001J\b\u0010´\u0001\u001a\u00030µ\u0001J\u0018\u0010\u000b\u001a\u00020\u00002\u0010\u0010¶\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u00010aJ\u0011\u0010\u000b\u001a\u00020\u00002\t\u0010\u000b\u001a\u0005\u0018\u00010\u0001J\u0012\u0010·\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020IH\u0002J\u0012\u0010¸\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020IH\u0002J\t\u0010¹\u0001\u001a\u00020lH\u0002R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010 \u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b$\u0010\u0017R\u0013\u0010%\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR&\u0010(\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00158\u0016@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R\u0011\u00100\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b1\u0010\u0017R\u0013\u00102\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR\u000e\u00104\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0013R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020@@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0004¢\u0006\u0002\n\u0000R\"\u0010N\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000¨\u0006º\u0001"}, d2 = {"Lcom/mikepenz/iconics/IconicsDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "icon", "", "(Landroid/content/Context;C)V", "", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/mikepenz/iconics/typeface/IIcon;", "(Landroid/content/Context;Lcom/mikepenz/iconics/typeface/IIcon;)V", "typeface", "Lcom/mikepenz/iconics/typeface/ITypeface;", "(Landroid/content/Context;Lcom/mikepenz/iconics/typeface/ITypeface;Lcom/mikepenz/iconics/typeface/IIcon;)V", "(Landroid/content/Context;)V", "backgroundBrush", "Lcom/mikepenz/iconics/IconicsBrush;", "Landroid/graphics/Paint;", "getBackgroundBrush", "()Lcom/mikepenz/iconics/IconicsBrush;", "backgroundColor", "", "getBackgroundColor", "()I", "backgroundColorList", "Landroid/content/res/ColorStateList;", "getBackgroundColorList", "()Landroid/content/res/ColorStateList;", "backgroundContourBrush", "getBackgroundContourBrush", "backgroundContourColor", "getBackgroundContourColor", "backgroundContourColorList", "getBackgroundContourColorList", "backgroundContourWidth", "color", "getColor", "colorList", "getColorList", "<set-?>", "compatAlpha", "getCompatAlpha", "setCompatAlpha", "(I)V", "getContext", "()Landroid/content/Context;", "contourBrush", "getContourBrush", "contourColor", "getContourColor", "contourColorList", "getContourColorList", "contourWidth", "getIcon", "()Lcom/mikepenz/iconics/typeface/IIcon;", "iconBrush", "Landroid/text/TextPaint;", "getIconBrush", "iconColorFilter", "Landroid/graphics/ColorFilter;", "iconOffsetX", "iconOffsetY", "iconPadding", "value", "", "isAutoMirroredCompat", "()Z", "setAutoMirroredCompat", "(Z)V", "isDrawBackgroundContour", "isDrawContour", "isRespectFontBounds", "paddingBounds", "Landroid/graphics/Rect;", "path", "Landroid/graphics/Path;", "pathBounds", "Landroid/graphics/RectF;", "plainIcon", "getPlainIcon", "()Ljava/lang/String;", "roundedCornerRx", "", "roundedCornerRy", "shadowColor", "shadowDx", "shadowDy", "shadowRadius", "sizeX", "sizeY", "tint", "tintFilter", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "actionBar", "alpha", "alphaProducer", "Lkotlin/Function0;", "autoMirror", "autoMirrored", "backgroundColorProducer", "Lcom/mikepenz/iconics/IconicsColor;", "colors", "backgroundContourColorProducer", "backgroundContourWidthProducer", "Lcom/mikepenz/iconics/IconicsSize;", "size", "clearColorFilter", "", "clearShadow", "clone", "colorProducer", "colorFilter", "colorFilterProducer", "cf", "contourColorProducer", "contourWidthProducer", "copyTo", "T", "other", "(Lcom/mikepenz/iconics/IconicsDrawable;)Lcom/mikepenz/iconics/IconicsDrawable;", "draw", "canvas", "Landroid/graphics/Canvas;", "drawBackgroundContour", "drawBackgroundContourProducer", "drawContour", "drawContourProducer", "getAlpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "iconProducer", "iconFromChar", "iconFromString", "Landroid/graphics/Typeface;", "iconOffsetXProducer", "iconOffsetYProducer", "iconText", "iconTextProducer", "iconTextFromString", "isStateful", "needMirroring", "offsetIcon", "viewBounds", "onBoundsChange", "bounds", "onStateChange", "stateSet", "", "padding", "paddingProducer", "respectFontBounds", "respectFontBoundsProducer", "roundedCorners", "roundedCornersProducer", "roundedCornersRx", "roundedCornersRxProducer", "roundedCornersRy", "roundedCornersRyProducer", "setAlpha", "setColorFilter", "setState", "setTintList", "setTintMode", "shadow", "radiusProducer", "dxProducer", "dyProducer", "radius", "dx", "dy", "sizeProducer", "sizeXProducer", "sizeYProducer", "style", "styleProducer", "Landroid/graphics/Paint$Style;", "toAnimatedDrawable", "Lcom/mikepenz/iconics/animation/IconicsAnimatedDrawable;", "toBitmap", "Landroid/graphics/Bitmap;", "typefaceProducer", "updatePaddingBounds", "updateTextSize", "updateTintFilter", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsDrawable.kt */
public class IconicsDrawable extends Drawable {
    private final IconicsBrush<Paint> backgroundBrush;
    private final IconicsBrush<Paint> backgroundContourBrush;
    private int backgroundContourWidth;
    private int compatAlpha;
    private final Context context;
    private final IconicsBrush<Paint> contourBrush;
    private int contourWidth;
    private IIcon icon;
    private final IconicsBrush<TextPaint> iconBrush;
    private ColorFilter iconColorFilter;
    private int iconOffsetX;
    private int iconOffsetY;
    private int iconPadding;
    private boolean isAutoMirroredCompat;
    private boolean isDrawBackgroundContour;
    private boolean isDrawContour;
    private boolean isRespectFontBounds;
    private final Rect paddingBounds;
    private final Path path;
    private final RectF pathBounds;
    private String plainIcon;
    private float roundedCornerRx;
    private float roundedCornerRy;
    /* access modifiers changed from: private */
    public int shadowColor;
    /* access modifiers changed from: private */
    public float shadowDx;
    /* access modifiers changed from: private */
    public float shadowDy;
    /* access modifiers changed from: private */
    public float shadowRadius;
    private int sizeX;
    private int sizeY;
    private ColorStateList tint;
    private ColorFilter tintFilter;
    private PorterDuff.Mode tintMode;

    public final IconicsDrawable iconText(String str) {
        return iconText$default(this, str, (Typeface) null, 2, (Object) null);
    }

    public IconicsDrawable(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.iconBrush = new IconicsBrush<>(new TextPaint(1));
        this.backgroundContourBrush = new IconicsBrush<>(new Paint(1));
        this.backgroundBrush = new IconicsBrush<>(new Paint(1));
        this.contourBrush = new IconicsBrush<>(new Paint(1));
        this.paddingBounds = new Rect();
        this.pathBounds = new RectF();
        this.path = new Path();
        this.sizeX = -1;
        this.sizeY = -1;
        this.roundedCornerRx = -1.0f;
        this.roundedCornerRy = -1.0f;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        Iconics.init(this.context);
        IconicsBrush it = this.iconBrush;
        it.setColorsList(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        TextPaint $this$apply = it.getPaint();
        $this$apply.setStyle(Paint.Style.FILL);
        $this$apply.setTextAlign(Paint.Align.CENTER);
        $this$apply.setUnderlineText(false);
        this.contourBrush.getPaint().setStyle(Paint.Style.STROKE);
        this.backgroundContourBrush.getPaint().setStyle(Paint.Style.STROKE);
        icon(' ');
        this.compatAlpha = 255;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final IconicsBrush<TextPaint> getIconBrush() {
        return this.iconBrush;
    }

    /* access modifiers changed from: protected */
    public final IconicsBrush<Paint> getBackgroundContourBrush() {
        return this.backgroundContourBrush;
    }

    /* access modifiers changed from: protected */
    public final IconicsBrush<Paint> getBackgroundBrush() {
        return this.backgroundBrush;
    }

    /* access modifiers changed from: protected */
    public final IconicsBrush<Paint> getContourBrush() {
        return this.contourBrush;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconicsDrawable(Context context2, char icon2) {
        this(context2);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        icon(icon2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconicsDrawable(Context context2, String icon2) {
        this(context2);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        icon(icon2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IconicsDrawable(Context context2, IIcon icon2) {
        this(context2);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        icon(icon2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected IconicsDrawable(Context context2, ITypeface typeface, IIcon icon2) {
        this(context2);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        icon(typeface, icon2);
    }

    public int getCompatAlpha() {
        return this.compatAlpha;
    }

    /* access modifiers changed from: protected */
    public void setCompatAlpha(int i) {
        this.compatAlpha = i;
    }

    public final IIcon getIcon() {
        return this.icon;
    }

    public final String getPlainIcon() {
        return this.plainIcon;
    }

    public final int getColor() {
        return this.iconBrush.getColorForCurrentState();
    }

    public final ColorStateList getColorList() {
        return this.iconBrush.getColorsList();
    }

    public final int getContourColor() {
        return this.contourBrush.getColorForCurrentState();
    }

    public final ColorStateList getContourColorList() {
        return this.contourBrush.getColorsList();
    }

    public final int getBackgroundColor() {
        return this.backgroundBrush.getColorForCurrentState();
    }

    public final ColorStateList getBackgroundColorList() {
        return this.backgroundBrush.getColorsList();
    }

    public final int getBackgroundContourColor() {
        return this.backgroundContourBrush.getColorForCurrentState();
    }

    public final ColorStateList getBackgroundContourColorList() {
        return this.backgroundContourBrush.getColorsList();
    }

    public final boolean isAutoMirroredCompat() {
        return this.isAutoMirroredCompat;
    }

    private final void setAutoMirroredCompat(boolean value) {
        this.isAutoMirroredCompat = value;
        if (Build.VERSION.SDK_INT >= 19) {
            setAutoMirrored(value);
        }
    }

    public final Bitmap toBitmap() {
        if (this.sizeX == -1 || this.sizeY == -1) {
            actionBar();
        }
        Bitmap bitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        style(Paint.Style.FILL);
        Canvas canvas = new Canvas(bitmap);
        setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        draw(canvas);
        Intrinsics.checkExpressionValueIsNotNull(bitmap, "bitmap");
        return bitmap;
    }

    public final IconicsDrawable clone() {
        return copyTo(new IconicsDrawable(this.context));
    }

    public final IconicsAnimatedDrawable toAnimatedDrawable() {
        return (IconicsAnimatedDrawable) copyTo(new IconicsAnimatedDrawable(this.context));
    }

    private final <T extends IconicsDrawable> T copyTo(T other) {
        String it;
        ColorStateList it2 = getColorList();
        if (it2 != null) {
            other.color(IconicsColor.Companion.colorList(it2));
        }
        ColorStateList it3 = getBackgroundColorList();
        if (it3 != null) {
            other.backgroundColor(IconicsColor.Companion.colorList(it3));
        }
        ColorStateList it4 = getContourColorList();
        if (it4 != null) {
            other.contourColor(IconicsColor.Companion.colorList(it4));
        }
        ColorStateList it5 = getBackgroundContourColorList();
        if (it5 != null) {
            other.backgroundContourColor(IconicsColor.Companion.colorList(it5));
        }
        other.sizeX(IconicsSize.Companion.px(Integer.valueOf(this.sizeX))).sizeY(IconicsSize.Companion.px(Integer.valueOf(this.sizeY))).iconOffsetX(IconicsSize.Companion.px(Integer.valueOf(this.iconOffsetX))).iconOffsetY(IconicsSize.Companion.px(Integer.valueOf(this.iconOffsetY))).padding(IconicsSize.Companion.px(Integer.valueOf(this.iconPadding))).typeface(this.iconBrush.getPaint().getTypeface()).respectFontBounds(this.isRespectFontBounds).roundedCornersRx(IconicsSize.Companion.px(Float.valueOf(this.roundedCornerRx))).roundedCornersRy(IconicsSize.Companion.px(Float.valueOf(this.roundedCornerRy))).contourWidth(IconicsSize.Companion.px(Integer.valueOf(this.contourWidth))).drawContour(this.isDrawContour).backgroundContourWidth(IconicsSize.Companion.px(Integer.valueOf(this.backgroundContourWidth))).drawBackgroundContour(this.isDrawBackgroundContour).shadow(IconicsSize.Companion.px(Float.valueOf(this.shadowRadius)), IconicsSize.Companion.px(Float.valueOf(this.shadowDx)), IconicsSize.Companion.px(Float.valueOf(this.shadowDy)), IconicsColor.Companion.colorInt(this.shadowColor)).alpha(getCompatAlpha());
        IIcon p1 = this.icon;
        if ((p1 == null || other.icon(p1) == null) && (it = this.plainIcon) != null) {
            iconText$default(other, it, (Typeface) null, 2, (Object) null);
        }
        return other;
    }

    public final IconicsDrawable iconFromString(Function0<String> iconProducer) {
        Intrinsics.checkParameterIsNotNull(iconProducer, "iconProducer");
        String it = iconProducer.invoke();
        if (it != null) {
            icon(it);
        }
        return this;
    }

    public final IconicsDrawable icon(String icon2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        try {
            ITypeface it = Iconics.findFont$default(IconicsExtensionsKt.getIconPrefix(icon2), (Context) null, 2, (Object) null);
            if (it != null) {
                icon(it.getIcon(IconicsExtensionsKt.getClearedIconName(icon2)));
            }
        } catch (Exception e) {
            IconicsLogger iconicsLogger = Iconics.logger;
            String str = Iconics.TAG;
            IconicsLogger.DefaultImpls.log$default(iconicsLogger, 6, str, "Wrong icon name: " + icon2, (Throwable) null, 8, (Object) null);
        }
        return this;
    }

    public final IconicsDrawable iconFromChar(Function0<Character> iconProducer) {
        Intrinsics.checkParameterIsNotNull(iconProducer, "iconProducer");
        Character invoke = iconProducer.invoke();
        if (invoke != null) {
            icon(invoke.charValue());
        }
        return this;
    }

    public final IconicsDrawable icon(char icon2) {
        return iconText(String.valueOf(icon2), (Typeface) null);
    }

    public final IconicsDrawable icon(char icon2, Typeface typeface) {
        return iconText(String.valueOf(icon2), typeface);
    }

    public final IconicsDrawable iconTextFromString(Function0<String> iconTextProducer) {
        Intrinsics.checkParameterIsNotNull(iconTextProducer, "iconTextProducer");
        String it = iconTextProducer.invoke();
        if (it != null) {
            iconText$default(this, it, (Typeface) null, 2, (Object) null);
        }
        return this;
    }

    public static /* synthetic */ IconicsDrawable iconText$default(IconicsDrawable iconicsDrawable, String str, Typeface typeface, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                typeface = null;
            }
            return iconicsDrawable.iconText(str, typeface);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iconText");
    }

    public final IconicsDrawable iconText(String icon2, Typeface typeface) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        this.plainIcon = icon2;
        this.icon = null;
        this.iconBrush.getPaint().setTypeface(typeface != null ? typeface : Typeface.DEFAULT);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable icon(Function0<? extends IIcon> iconProducer) {
        Intrinsics.checkParameterIsNotNull(iconProducer, "iconProducer");
        IIcon it = (IIcon) iconProducer.invoke();
        if (it != null) {
            icon(it);
        }
        return this;
    }

    public final IconicsDrawable icon(IIcon icon2) {
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        this.plainIcon = null;
        this.icon = icon2;
        this.iconBrush.getPaint().setTypeface(icon2.getTypeface().getRawTypeface());
        invalidateSelf();
        return this;
    }

    /* access modifiers changed from: protected */
    public final IconicsDrawable icon(ITypeface typeface, IIcon icon2) {
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        Intrinsics.checkParameterIsNotNull(icon2, "icon");
        this.icon = icon2;
        this.iconBrush.getPaint().setTypeface(typeface.getRawTypeface());
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable respectFontBounds(Function0<Boolean> respectFontBoundsProducer) {
        Intrinsics.checkParameterIsNotNull(respectFontBoundsProducer, "respectFontBoundsProducer");
        Boolean invoke = respectFontBoundsProducer.invoke();
        if (invoke != null) {
            respectFontBounds(invoke.booleanValue());
        }
        return this;
    }

    public final IconicsDrawable respectFontBounds(boolean isRespectFontBounds2) {
        this.isRespectFontBounds = isRespectFontBounds2;
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable color(Function0<? extends IconicsColor> colorProducer) {
        Intrinsics.checkParameterIsNotNull(colorProducer, "colorProducer");
        IconicsColor it = (IconicsColor) colorProducer.invoke();
        if (it != null) {
            color(it);
        }
        return this;
    }

    public final IconicsDrawable color(IconicsColor colors) {
        Intrinsics.checkParameterIsNotNull(colors, "colors");
        this.iconBrush.setColorsList(colors.extractList$iconics_core(this.context));
        if (this.iconBrush.applyState(getState())) {
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable iconOffsetX(Function0<? extends IconicsSize> iconOffsetXProducer) {
        Intrinsics.checkParameterIsNotNull(iconOffsetXProducer, "iconOffsetXProducer");
        IconicsSize it = (IconicsSize) iconOffsetXProducer.invoke();
        if (it != null) {
            iconOffsetX(it);
        }
        return this;
    }

    public final IconicsDrawable iconOffsetX(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.iconOffsetX = size.extract$iconics_core(this.context);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable iconOffsetY(Function0<? extends IconicsSize> iconOffsetYProducer) {
        Intrinsics.checkParameterIsNotNull(iconOffsetYProducer, "iconOffsetYProducer");
        IconicsSize it = (IconicsSize) iconOffsetYProducer.invoke();
        if (it != null) {
            iconOffsetY(it);
        }
        return this;
    }

    public final IconicsDrawable iconOffsetY(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.iconOffsetY = size.extract$iconics_core(this.context);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable padding(Function0<? extends IconicsSize> paddingProducer) {
        Intrinsics.checkParameterIsNotNull(paddingProducer, "paddingProducer");
        IconicsSize it = (IconicsSize) paddingProducer.invoke();
        if (it != null) {
            padding(it);
        }
        return this;
    }

    public final IconicsDrawable padding(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        int sizePx = size.extract$iconics_core(this.context);
        if (this.iconPadding != sizePx) {
            this.iconPadding = sizePx;
            if (this.isDrawContour) {
                this.iconPadding = this.contourWidth + sizePx;
            }
            if (this.isDrawBackgroundContour) {
                this.iconPadding += this.backgroundContourWidth;
            }
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable actionBar() {
        return size(IconicsSize.TOOLBAR_ICON_SIZE).padding(IconicsSize.TOOLBAR_ICON_PADDING);
    }

    public final IconicsDrawable size(Function0<? extends IconicsSize> sizeProducer) {
        Intrinsics.checkParameterIsNotNull(sizeProducer, "sizeProducer");
        IconicsSize it = (IconicsSize) sizeProducer.invoke();
        if (it != null) {
            size(it);
        }
        return this;
    }

    public final IconicsDrawable size(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        int extract$iconics_core = size.extract$iconics_core(this.context);
        this.sizeY = extract$iconics_core;
        this.sizeX = extract$iconics_core;
        setBounds(0, 0, extract$iconics_core, extract$iconics_core);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable sizeX(Function0<? extends IconicsSize> sizeXProducer) {
        Intrinsics.checkParameterIsNotNull(sizeXProducer, "sizeXProducer");
        IconicsSize it = (IconicsSize) sizeXProducer.invoke();
        if (it != null) {
            sizeX(it);
        }
        return this;
    }

    public final IconicsDrawable sizeX(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        int extract$iconics_core = size.extract$iconics_core(this.context);
        this.sizeX = extract$iconics_core;
        setBounds(0, 0, extract$iconics_core, this.sizeY);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable sizeY(Function0<? extends IconicsSize> sizeYProducer) {
        Intrinsics.checkParameterIsNotNull(sizeYProducer, "sizeYProducer");
        IconicsSize it = (IconicsSize) sizeYProducer.invoke();
        if (it != null) {
            sizeY(it);
        }
        return this;
    }

    public final IconicsDrawable sizeY(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        int extract$iconics_core = size.extract$iconics_core(this.context);
        this.sizeY = extract$iconics_core;
        setBounds(0, 0, this.sizeX, extract$iconics_core);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable backgroundContourColor(Function0<? extends IconicsColor> backgroundContourColorProducer) {
        Intrinsics.checkParameterIsNotNull(backgroundContourColorProducer, "backgroundContourColorProducer");
        IconicsColor it = (IconicsColor) backgroundContourColorProducer.invoke();
        if (it != null) {
            backgroundContourColor(it);
        }
        return this;
    }

    public final IconicsDrawable backgroundContourColor(IconicsColor colors) {
        Intrinsics.checkParameterIsNotNull(colors, "colors");
        this.backgroundContourBrush.setColorsList(colors.extractList$iconics_core(this.context));
        if (this.backgroundContourBrush.applyState(getState())) {
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable contourColor(Function0<? extends IconicsColor> contourColorProducer) {
        Intrinsics.checkParameterIsNotNull(contourColorProducer, "contourColorProducer");
        IconicsColor it = (IconicsColor) contourColorProducer.invoke();
        if (it != null) {
            contourColor(it);
        }
        return this;
    }

    public final IconicsDrawable contourColor(IconicsColor colors) {
        Intrinsics.checkParameterIsNotNull(colors, "colors");
        this.contourBrush.setColorsList(colors.extractList$iconics_core(this.context));
        if (this.contourBrush.applyState(getState())) {
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable backgroundColor(Function0<? extends IconicsColor> backgroundColorProducer) {
        Intrinsics.checkParameterIsNotNull(backgroundColorProducer, "backgroundColorProducer");
        IconicsColor it = (IconicsColor) backgroundColorProducer.invoke();
        if (it != null) {
            backgroundColor(it);
        }
        return this;
    }

    public final IconicsDrawable backgroundColor(IconicsColor colors) {
        Intrinsics.checkParameterIsNotNull(colors, "colors");
        boolean isInvalidate = false;
        if (this.roundedCornerRx == -1.0f) {
            this.roundedCornerRx = 0.0f;
            isInvalidate = true;
        }
        if (this.roundedCornerRy == -1.0f) {
            this.roundedCornerRy = 0.0f;
            isInvalidate = true;
        }
        this.backgroundBrush.setColorsList(colors.extractList$iconics_core(this.context));
        if (this.backgroundBrush.applyState(getState())) {
            isInvalidate = true;
        }
        if (isInvalidate) {
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable roundedCornersRx(Function0<? extends IconicsSize> roundedCornersRxProducer) {
        Intrinsics.checkParameterIsNotNull(roundedCornersRxProducer, "roundedCornersRxProducer");
        IconicsSize it = (IconicsSize) roundedCornersRxProducer.invoke();
        if (it != null) {
            roundedCornersRx(it);
        }
        return this;
    }

    public final IconicsDrawable roundedCornersRx(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.roundedCornerRx = size.extractFloat$iconics_core(this.context);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable roundedCornersRy(Function0<? extends IconicsSize> roundedCornersRyProducer) {
        Intrinsics.checkParameterIsNotNull(roundedCornersRyProducer, "roundedCornersRyProducer");
        IconicsSize it = (IconicsSize) roundedCornersRyProducer.invoke();
        if (it != null) {
            roundedCornersRy(it);
        }
        return this;
    }

    public final IconicsDrawable roundedCornersRy(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.roundedCornerRy = size.extractFloat$iconics_core(this.context);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable roundedCorners(Function0<? extends IconicsSize> roundedCornersProducer) {
        Intrinsics.checkParameterIsNotNull(roundedCornersProducer, "roundedCornersProducer");
        IconicsSize it = (IconicsSize) roundedCornersProducer.invoke();
        if (it != null) {
            roundedCorners(it);
        }
        return this;
    }

    public final IconicsDrawable roundedCorners(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        float extractFloat$iconics_core = size.extractFloat$iconics_core(this.context);
        this.roundedCornerRy = extractFloat$iconics_core;
        this.roundedCornerRx = extractFloat$iconics_core;
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable contourWidth(Function0<? extends IconicsSize> contourWidthProducer) {
        Intrinsics.checkParameterIsNotNull(contourWidthProducer, "contourWidthProducer");
        IconicsSize it = (IconicsSize) contourWidthProducer.invoke();
        if (it != null) {
            contourWidth(it);
        }
        return this;
    }

    public final IconicsDrawable contourWidth(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.contourWidth = size.extract$iconics_core(this.context);
        this.contourBrush.getPaint().setStrokeWidth((float) this.contourWidth);
        drawContour(true);
        invalidateSelf();
        return this;
    }

    public static /* synthetic */ IconicsDrawable shadow$default(IconicsDrawable iconicsDrawable, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = new IconicsDrawable$shadow$1(iconicsDrawable);
            }
            if ((i & 2) != 0) {
                function02 = new IconicsDrawable$shadow$2(iconicsDrawable);
            }
            if ((i & 4) != 0) {
                function03 = new IconicsDrawable$shadow$3(iconicsDrawable);
            }
            if ((i & 8) != 0) {
                function04 = new IconicsDrawable$shadow$4(iconicsDrawable);
            }
            return iconicsDrawable.shadow((Function0<? extends IconicsSize>) function0, (Function0<? extends IconicsSize>) function02, (Function0<? extends IconicsSize>) function03, (Function0<? extends IconicsColor>) function04);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shadow");
    }

    public final IconicsDrawable shadow(Function0<? extends IconicsSize> radiusProducer, Function0<? extends IconicsSize> dxProducer, Function0<? extends IconicsSize> dyProducer, Function0<? extends IconicsColor> colorProducer) {
        Intrinsics.checkParameterIsNotNull(radiusProducer, "radiusProducer");
        Intrinsics.checkParameterIsNotNull(dxProducer, "dxProducer");
        Intrinsics.checkParameterIsNotNull(dyProducer, "dyProducer");
        Intrinsics.checkParameterIsNotNull(colorProducer, "colorProducer");
        IconicsSize radius = (IconicsSize) radiusProducer.invoke();
        IconicsSize dx = (IconicsSize) dxProducer.invoke();
        IconicsSize dy = (IconicsSize) dyProducer.invoke();
        IconicsColor color = (IconicsColor) colorProducer.invoke();
        if (!(radius == null || dx == null || dy == null || color == null)) {
            shadow(radius, dx, dy, color);
        }
        return this;
    }

    public static /* synthetic */ IconicsDrawable shadow$default(IconicsDrawable iconicsDrawable, IconicsSize iconicsSize, IconicsSize iconicsSize2, IconicsSize iconicsSize3, IconicsColor iconicsColor, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                iconicsSize = IconicsSize.Companion.px(Float.valueOf(iconicsDrawable.shadowRadius));
            }
            if ((i & 2) != 0) {
                iconicsSize2 = IconicsSize.Companion.px(Float.valueOf(iconicsDrawable.shadowDx));
            }
            if ((i & 4) != 0) {
                iconicsSize3 = IconicsSize.Companion.px(Float.valueOf(iconicsDrawable.shadowDy));
            }
            if ((i & 8) != 0) {
                iconicsColor = IconicsColor.Companion.colorInt(iconicsDrawable.shadowColor);
            }
            return iconicsDrawable.shadow(iconicsSize, iconicsSize2, iconicsSize3, iconicsColor);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shadow");
    }

    public final IconicsDrawable shadow(IconicsSize radius, IconicsSize dx, IconicsSize dy, IconicsColor color) {
        Intrinsics.checkParameterIsNotNull(radius, "radius");
        Intrinsics.checkParameterIsNotNull(dx, "dx");
        Intrinsics.checkParameterIsNotNull(dy, "dy");
        Intrinsics.checkParameterIsNotNull(color, "color");
        this.shadowRadius = radius.extractFloat$iconics_core(this.context);
        this.shadowDx = dx.extractFloat$iconics_core(this.context);
        this.shadowDy = dy.extractFloat$iconics_core(this.context);
        this.shadowColor = color.extract$iconics_core(this.context);
        this.iconBrush.getPaint().setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable clearShadow() {
        this.iconBrush.getPaint().clearShadowLayer();
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable backgroundContourWidth(Function0<? extends IconicsSize> backgroundContourWidthProducer) {
        Intrinsics.checkParameterIsNotNull(backgroundContourWidthProducer, "backgroundContourWidthProducer");
        IconicsSize it = (IconicsSize) backgroundContourWidthProducer.invoke();
        if (it != null) {
            backgroundContourWidth(it);
        }
        return this;
    }

    public final IconicsDrawable backgroundContourWidth(IconicsSize size) {
        Intrinsics.checkParameterIsNotNull(size, "size");
        this.backgroundContourWidth = size.extract$iconics_core(this.context);
        this.backgroundContourBrush.getPaint().setStrokeWidth((float) this.backgroundContourWidth);
        drawBackgroundContour(true);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable drawContour(Function0<Boolean> drawContourProducer) {
        Intrinsics.checkParameterIsNotNull(drawContourProducer, "drawContourProducer");
        Boolean invoke = drawContourProducer.invoke();
        if (invoke != null) {
            drawContour(invoke.booleanValue());
        }
        return this;
    }

    public final IconicsDrawable drawContour(boolean drawContour) {
        if (this.isDrawContour != drawContour) {
            this.isDrawContour = drawContour;
            this.iconPadding += (drawContour ? 1 : -1) * this.contourWidth;
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable drawBackgroundContour(Function0<Boolean> drawBackgroundContourProducer) {
        Intrinsics.checkParameterIsNotNull(drawBackgroundContourProducer, "drawBackgroundContourProducer");
        Boolean invoke = drawBackgroundContourProducer.invoke();
        if (invoke != null) {
            drawBackgroundContour(invoke.booleanValue());
        }
        return this;
    }

    public final IconicsDrawable drawBackgroundContour(boolean isDrawBackgroundContour2) {
        if (this.isDrawBackgroundContour != isDrawBackgroundContour2) {
            this.isDrawBackgroundContour = isDrawBackgroundContour2;
            this.iconPadding += (isDrawBackgroundContour2 ? 1 : -1) * this.backgroundContourWidth * 2;
            invalidateSelf();
        }
        return this;
    }

    public final IconicsDrawable colorFilter(Function0<? extends ColorFilter> colorFilterProducer) {
        Intrinsics.checkParameterIsNotNull(colorFilterProducer, "colorFilterProducer");
        ColorFilter it = (ColorFilter) colorFilterProducer.invoke();
        if (it != null) {
            colorFilter(it);
        }
        return this;
    }

    public final IconicsDrawable colorFilter(ColorFilter cf) {
        setColorFilter(cf);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable alpha(Function0<Integer> alphaProducer) {
        Intrinsics.checkParameterIsNotNull(alphaProducer, "alphaProducer");
        Integer invoke = alphaProducer.invoke();
        if (invoke != null) {
            alpha(invoke.intValue());
        }
        return this;
    }

    public final IconicsDrawable alpha(int alpha) {
        setAlpha(alpha);
        return this;
    }

    public final IconicsDrawable style(Function0<? extends Paint.Style> styleProducer) {
        Intrinsics.checkParameterIsNotNull(styleProducer, "styleProducer");
        Paint.Style it = (Paint.Style) styleProducer.invoke();
        if (it != null) {
            style(it);
        }
        return this;
    }

    public final IconicsDrawable style(Paint.Style style) {
        Intrinsics.checkParameterIsNotNull(style, "style");
        this.iconBrush.getPaint().setStyle(style);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable typeface(Function0<? extends Typeface> typefaceProducer) {
        Intrinsics.checkParameterIsNotNull(typefaceProducer, "typefaceProducer");
        Typeface it = (Typeface) typefaceProducer.invoke();
        if (it != null) {
            typeface(it);
        }
        return this;
    }

    public final IconicsDrawable typeface(Typeface typeface) {
        this.iconBrush.getPaint().setTypeface(typeface);
        invalidateSelf();
        return this;
    }

    public final IconicsDrawable autoMirror(boolean autoMirrored) {
        setAutoMirroredCompat(autoMirrored);
        invalidateSelf();
        return this;
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        if (this.icon != null || this.plainIcon != null) {
            Rect viewBounds = getBounds();
            Intrinsics.checkExpressionValueIsNotNull(viewBounds, "bounds");
            updatePaddingBounds(viewBounds);
            updateTextSize(viewBounds);
            offsetIcon(viewBounds);
            if (needMirroring()) {
                canvas.translate((float) (getBounds().right - getBounds().left), 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            float f = (float) -1;
            if (this.roundedCornerRy > f && this.roundedCornerRx > f) {
                if (this.isDrawBackgroundContour) {
                    float halfContourSize = (float) (this.backgroundContourWidth / 2);
                    RectF rectF = new RectF(halfContourSize, halfContourSize, ((float) viewBounds.width()) - halfContourSize, ((float) viewBounds.height()) - halfContourSize);
                    canvas.drawRoundRect(rectF, this.roundedCornerRx, this.roundedCornerRy, this.backgroundBrush.getPaint());
                    canvas.drawRoundRect(rectF, this.roundedCornerRx, this.roundedCornerRy, this.backgroundContourBrush.getPaint());
                } else {
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) viewBounds.width(), (float) viewBounds.height()), this.roundedCornerRx, this.roundedCornerRy, this.backgroundBrush.getPaint());
                }
            }
            try {
                Result.Companion companion = Result.Companion;
                this.path.close();
                Result.m65constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m65constructorimpl(ResultKt.createFailure(th));
            }
            if (this.isDrawContour) {
                canvas.drawPath(this.path, this.contourBrush.getPaint());
            }
            TextPaint paint = this.iconBrush.getPaint();
            ColorFilter colorFilter = this.iconColorFilter;
            if (colorFilter == null) {
                colorFilter = this.tintFilter;
            }
            paint.setColorFilter(colorFilter);
            canvas.drawPath(this.path, this.iconBrush.getPaint());
        }
    }

    public void setTintList(ColorStateList tint2) {
        this.tint = tint2;
        updateTintFilter();
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode tintMode2) {
        this.tintMode = tintMode2 != null ? tintMode2 : PorterDuff.Mode.SRC_IN;
        updateTintFilter();
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        Intrinsics.checkParameterIsNotNull(bounds, "bounds");
        offsetIcon(bounds);
        try {
            Result.Companion companion = Result.Companion;
            this.path.close();
            Result.m65constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        super.onBoundsChange(bounds);
    }

    public boolean isStateful() {
        if (this.iconBrush.isStateful() || this.contourBrush.isStateful() || this.backgroundBrush.isStateful() || this.backgroundContourBrush.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.tint;
        return colorStateList != null && colorStateList.isStateful();
    }

    public boolean setState(int[] stateSet) {
        Intrinsics.checkParameterIsNotNull(stateSet, "stateSet");
        if (super.setState(stateSet) || this.iconBrush.isStateful() || this.contourBrush.isStateful() || this.backgroundBrush.isStateful() || this.backgroundContourBrush.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.tint;
        return colorStateList != null && colorStateList.isStateful();
    }

    public int getOpacity() {
        if (this.tintFilter != null || this.iconColorFilter != null) {
            return -3;
        }
        int alpha = getAlpha();
        if (alpha == 0) {
            return -2;
        }
        if (alpha != 255) {
            return -3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        boolean z = false;
        boolean isNeedsRedraw = this.backgroundBrush.applyState(stateSet) || (this.contourBrush.applyState(stateSet) || this.iconBrush.applyState(stateSet));
        if (this.backgroundContourBrush.applyState(stateSet) || isNeedsRedraw) {
            z = true;
        }
        boolean isNeedsRedraw2 = z;
        if (this.tint == null) {
            return isNeedsRedraw2;
        }
        updateTintFilter();
        return true;
    }

    public int getIntrinsicWidth() {
        return this.sizeX;
    }

    public int getIntrinsicHeight() {
        return this.sizeY;
    }

    public void setAlpha(int alpha) {
        this.iconBrush.setAlpha(alpha);
        this.contourBrush.setAlpha(alpha);
        this.backgroundBrush.setAlpha(alpha);
        this.backgroundContourBrush.setAlpha(alpha);
        setCompatAlpha(alpha);
        invalidateSelf();
    }

    public int getAlpha() {
        return getCompatAlpha();
    }

    public void setColorFilter(ColorFilter cf) {
        this.iconColorFilter = cf;
        invalidateSelf();
    }

    public void clearColorFilter() {
        this.iconColorFilter = null;
        invalidateSelf();
    }

    private final void updatePaddingBounds(Rect viewBounds) {
        int i = this.iconPadding;
        if (i >= 0 && i * 2 <= viewBounds.width() && this.iconPadding * 2 <= viewBounds.height()) {
            this.paddingBounds.set(viewBounds.left + this.iconPadding, viewBounds.top + this.iconPadding, viewBounds.right - this.iconPadding, viewBounds.bottom - this.iconPadding);
        }
    }

    private final void updateTextSize(Rect viewBounds) {
        String str;
        float textSize = ((float) viewBounds.height()) * ((float) (this.isRespectFontBounds ? 1 : 2));
        this.iconBrush.getPaint().setTextSize(textSize);
        IIcon iIcon = this.icon;
        if (iIcon == null || (str = String.valueOf(iIcon.getCharacter())) == null) {
            str = String.valueOf(this.plainIcon);
        }
        String textValue = str;
        this.iconBrush.getPaint().getTextPath(textValue, 0, textValue.length(), 0.0f, (float) viewBounds.height(), this.path);
        this.path.computeBounds(this.pathBounds, true);
        if (!this.isRespectFontBounds) {
            float deltaWidth = ((float) this.paddingBounds.width()) / this.pathBounds.width();
            float deltaHeight = ((float) this.paddingBounds.height()) / this.pathBounds.height();
            this.iconBrush.getPaint().setTextSize(textSize * (deltaWidth < deltaHeight ? deltaWidth : deltaHeight));
            this.iconBrush.getPaint().getTextPath(textValue, 0, textValue.length(), 0.0f, (float) viewBounds.height(), this.path);
            this.path.computeBounds(this.pathBounds, true);
        }
    }

    private final void offsetIcon(Rect viewBounds) {
        float f = (float) 2;
        this.path.offset(((float) this.iconOffsetX) + ((((float) viewBounds.centerX()) - (this.pathBounds.width() / f)) - this.pathBounds.left), ((float) this.iconOffsetY) + ((((float) viewBounds.centerY()) - (this.pathBounds.height() / f)) - this.pathBounds.top));
    }

    private final void updateTintFilter() {
        ColorStateList tint2 = this.tint;
        PorterDuff.Mode tintMode2 = this.tintMode;
        if (tint2 == null) {
            this.tintFilter = null;
        } else {
            this.tintFilter = new PorterDuffColorFilter(tint2.getColorForState(getState(), 0), tintMode2);
        }
    }

    private final boolean needMirroring() {
        return this.isAutoMirroredCompat && DrawableCompat.getLayoutDirection(this) == 1;
    }
}

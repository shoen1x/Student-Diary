package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* compiled from: Region.kt */
public final class RegionKt {
    public static final boolean contains(Region $receiver, Point p) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(p, "p");
        return $receiver.contains(p.x, p.y);
    }

    public static final Region plus(Region $receiver, Rect r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.union(r);
        return $receiver2;
    }

    public static final Region plus(Region $receiver, Region r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.UNION);
        return $receiver2;
    }

    public static final Region minus(Region $receiver, Rect r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.DIFFERENCE);
        return $receiver2;
    }

    public static final Region minus(Region $receiver, Region r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.DIFFERENCE);
        return $receiver2;
    }

    public static final Region unaryMinus(Region $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Region $receiver2 = new Region($receiver.getBounds());
        $receiver2.op($receiver, Region.Op.DIFFERENCE);
        return $receiver2;
    }

    public static final Region not(Region $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Region $receiver$iv = $receiver;
        Region $receiver$iv2 = new Region($receiver$iv.getBounds());
        $receiver$iv2.op($receiver$iv, Region.Op.DIFFERENCE);
        return $receiver$iv2;
    }

    public static final Region or(Region $receiver, Rect r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver$iv = new Region($receiver);
        $receiver$iv.union(r);
        return $receiver$iv;
    }

    public static final Region or(Region $receiver, Region r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver$iv = new Region($receiver);
        $receiver$iv.op(r, Region.Op.UNION);
        return $receiver$iv;
    }

    public static final Region and(Region $receiver, Rect r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.INTERSECT);
        return $receiver2;
    }

    public static final Region and(Region $receiver, Region r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.INTERSECT);
        return $receiver2;
    }

    public static final Region xor(Region $receiver, Rect r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.XOR);
        return $receiver2;
    }

    public static final Region xor(Region $receiver, Region r) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $receiver2 = new Region($receiver);
        $receiver2.op(r, Region.Op.XOR);
        return $receiver2;
    }

    public static final void forEach(Region $receiver, Function1<? super Rect, Unit> action) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(action, "action");
        RegionIterator iterator = new RegionIterator($receiver);
        while (true) {
            Rect r = new Rect();
            if (iterator.next(r)) {
                action.invoke(r);
            } else {
                return;
            }
        }
    }

    public static final Iterator<Rect> iterator(Region $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new RegionKt$iterator$1($receiver);
    }
}

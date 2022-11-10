package com.mikepenz.fastadapter;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.dsl.FastAdapterDsl;
import com.mikepenz.fastadapter.extensions.ExtensionsFactories;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.listeners.EventHook;
import com.mikepenz.fastadapter.listeners.LongClickEventHook;
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListener;
import com.mikepenz.fastadapter.listeners.OnBindViewHolderListenerImpl;
import com.mikepenz.fastadapter.listeners.OnCreateViewHolderListener;
import com.mikepenz.fastadapter.listeners.OnCreateViewHolderListenerImpl;
import com.mikepenz.fastadapter.listeners.TouchEventHook;
import com.mikepenz.fastadapter.utils.AdapterPredicate;
import com.mikepenz.fastadapter.utils.DefaultTypeInstanceCache;
import com.mikepenz.fastadapter.utils.EventHookUtilKt;
import com.mikepenz.fastadapter.utils.Triple;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@FastAdapterDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u0000 Ã\u0001*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\b\u0012\u0004\u0012\u00020\u00030\u0005:\u0006Ã\u0001Ä\u0001Å\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u0010k\u001a\u00020!H\u0016J3\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u000e\b\u0001\u0010m*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010n\u001a\u00020!2\u0006\u00103\u001a\u0002HmH\u0016¢\u0006\u0002\u0010oJ,\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u000e\b\u0001\u0010m*\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010q\u001a\b\u0012\u0004\u0012\u0002Hm0rH\u0016J\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\tJ\"\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t0\u0019J)\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u000e\b\u0001\u0010w*\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010x\u001a\u0002Hw¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020{H\u0004J\u0006\u0010|\u001a\u00020{J\u0018\u0010}\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u00105\u001a\u00020!H\u0016J#\u0010~\u001a\u0004\u0018\u0001H\"\u0010\b\u0001\u0010\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001aH\b¢\u0006\u0003\u0010\u0001J/\u0010~\u001a\u0004\u0018\u0001H\"\u000e\b\u0001\u0010*\b\u0012\u0004\u0012\u00028\u00000\u001a2\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0000\u0012\u0002H0\u001f¢\u0006\u0003\u0010\u0001J\u0012\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0019\u0010\u0001\u001a\u0004\u0018\u00018\u00002\u0006\u00105\u001a\u00020!H\u0016¢\u0006\u0003\u0010\u0001J$\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020!H\u0016J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u00105\u001a\u00020!H\u0016J\u0011\u0010\u0001\u001a\u00020!2\u0006\u00105\u001a\u00020!H\u0016J$\u0010\u0001\u001a\u0004\u0018\u0001H\"\u0010\b\u0001\u0010\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001aH\b¢\u0006\u0003\u0010\u0001J0\u0010\u0001\u001a\u0004\u0018\u0001H\"\u000e\b\u0001\u0010*\b\u0012\u0004\u0012\u00028\u00000\u001a2\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0000\u0012\u0002H0\u001f¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020!2\u0006\u00105\u001a\u00020!H\u0016J\u0011\u0010\u0001\u001a\u00020!2\u0006\u0010k\u001a\u00020!H\u0016J\u0018\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00105\u001a\u00020!H\u0016J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020!¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020{H\u0016J\u001f\u0010\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u0011\u0010\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!H\u0016J\u001b\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0016J(\u0010\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020!2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u001a\u0010¡\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020!H\u0016J\u001a\u0010¢\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020!H\u0016J\u0011\u0010£\u0001\u001a\u00020{2\u0006\u00105\u001a\u00020!H\u0016J\u0013\u0010¤\u0001\u001a\u00020{2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u001a\u0010§\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020!H\u0016J*\u0010§\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020!2\u000e\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\bH\u0016J\u001c\u0010©\u0001\u001a\u00020\u00032\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020!H\u0016J\u0013\u0010­\u0001\u001a\u00020{2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0012\u0010®\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0012\u0010¯\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0012\u0010°\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0012\u0010±\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0017\u0010²\u0001\u001a\u00020{2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002J3\u0010³\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0´\u00012\u000e\u0010µ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¶\u00012\u0007\u0010·\u0001\u001a\u00020\u0010J<\u0010³\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0´\u00012\u000e\u0010µ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¶\u00012\u0007\u0010¸\u0001\u001a\u00020!2\u0007\u0010·\u0001\u001a\u00020\u0010J\u0015\u0010¹\u0001\u001a\u00020{2\u0006\u00104\u001a\u00028\u0000¢\u0006\u0003\u0010º\u0001J\"\u0010»\u0001\u001a\u0002H\"\u0010\b\u0001\u0010\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001aH\b¢\u0006\u0003\u0010\u0001J\"\u0010¼\u0001\u001a\u0002H\"\u0010\b\u0001\u0010\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u001aH\b¢\u0006\u0003\u0010\u0001J \u0010½\u0001\u001a\u00030¾\u00012\b\u0010¿\u0001\u001a\u00030¾\u00012\n\b\u0002\u0010À\u0001\u001a\u00030Á\u0001H\u0017J'\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00012\n\b\u0002\u0010À\u0001\u001a\u00030Á\u0001H\u0007R\u001e\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t0\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0001\u0010-\u001ar\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010.j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`6X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0001\u0010A\u001ap\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010.j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R\u0001\u0010E\u001ar\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010.j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`6X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00108\"\u0004\bG\u0010:R\u0001\u0010H\u001ap\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010.j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00108\"\u0004\bJ\u0010:R\u0001\u0010K\u001a\u0001\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110M¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(N\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110!¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010Lj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\\\u0010\u0012\"\u0004\b]\u0010\u0014R \u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000_X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b`\u0010\u0006\u001a\u0004\ba\u0010bR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000dX\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000hX\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010j¨\u0006Æ\u0001"}, d2 = {"Lcom/mikepenz/fastadapter/FastAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "_eventHooks", "", "Lcom/mikepenz/fastadapter/listeners/EventHook;", "adapterSizes", "Landroid/util/SparseArray;", "Lcom/mikepenz/fastadapter/IAdapter;", "adapters", "Ljava/util/ArrayList;", "attachDefaultListeners", "", "getAttachDefaultListeners", "()Z", "setAttachDefaultListeners", "(Z)V", "eventHooks", "getEventHooks", "()Ljava/util/List;", "extensions", "", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "getExtensions", "()Ljava/util/Collection;", "extensionsCache", "Landroidx/collection/ArrayMap;", "Ljava/lang/Class;", "globalSize", "", "legacyBindViewMode", "getLegacyBindViewMode", "setLegacyBindViewMode", "logger", "Lcom/mikepenz/fastadapter/VerboseLogger;", "onBindViewHolderListener", "Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListener;", "getOnBindViewHolderListener", "()Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListener;", "setOnBindViewHolderListener", "(Lcom/mikepenz/fastadapter/listeners/OnBindViewHolderListener;)V", "onClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "adapter", "item", "position", "Lcom/mikepenz/fastadapter/ClickListener;", "getOnClickListener", "()Lkotlin/jvm/functions/Function4;", "setOnClickListener", "(Lkotlin/jvm/functions/Function4;)V", "onCreateViewHolderListener", "Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListener;", "getOnCreateViewHolderListener", "()Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListener;", "setOnCreateViewHolderListener", "(Lcom/mikepenz/fastadapter/listeners/OnCreateViewHolderListener;)V", "onLongClickListener", "Lcom/mikepenz/fastadapter/LongClickListener;", "getOnLongClickListener", "setOnLongClickListener", "onPreClickListener", "getOnPreClickListener", "setOnPreClickListener", "onPreLongClickListener", "getOnPreLongClickListener", "setOnPreLongClickListener", "onTouchListener", "Lkotlin/Function5;", "Landroid/view/MotionEvent;", "event", "Lcom/mikepenz/fastadapter/listeners/TouchListener;", "getOnTouchListener", "()Lkotlin/jvm/functions/Function5;", "setOnTouchListener", "(Lkotlin/jvm/functions/Function5;)V", "typeInstanceCache", "Lcom/mikepenz/fastadapter/ITypeInstanceCache;", "getTypeInstanceCache", "()Lcom/mikepenz/fastadapter/ITypeInstanceCache;", "setTypeInstanceCache", "(Lcom/mikepenz/fastadapter/ITypeInstanceCache;)V", "value", "verboseLoggingEnabled", "getVerboseLoggingEnabled", "setVerboseLoggingEnabled", "viewClickListener", "Lcom/mikepenz/fastadapter/listeners/ClickEventHook;", "viewClickListener$annotations", "getViewClickListener", "()Lcom/mikepenz/fastadapter/listeners/ClickEventHook;", "viewLongClickListener", "Lcom/mikepenz/fastadapter/listeners/LongClickEventHook;", "getViewLongClickListener", "()Lcom/mikepenz/fastadapter/listeners/LongClickEventHook;", "viewTouchListener", "Lcom/mikepenz/fastadapter/listeners/TouchEventHook;", "getViewTouchListener", "()Lcom/mikepenz/fastadapter/listeners/TouchEventHook;", "order", "addAdapter", "A", "index", "(ILcom/mikepenz/fastadapter/IAdapter;)Lcom/mikepenz/fastadapter/FastAdapter;", "addAdapters", "newAdapters", "", "addEventHook", "eventHook", "addEventHooks", "addExtension", "E", "extension", "(Lcom/mikepenz/fastadapter/IAdapterExtension;)Lcom/mikepenz/fastadapter/FastAdapter;", "cacheSizes", "", "clearTypeInstance", "getAdapter", "getExtension", "T", "()Lcom/mikepenz/fastadapter/IAdapterExtension;", "clazz", "(Ljava/lang/Class;)Lcom/mikepenz/fastadapter/IAdapterExtension;", "getHolderAdapterPosition", "holder", "getItem", "(I)Lcom/mikepenz/fastadapter/IItem;", "getItemById", "Lkotlin/Pair;", "identifier", "", "getItemCount", "getItemId", "getItemViewType", "getOrCreateExtension", "getPosition", "(Lcom/mikepenz/fastadapter/IItem;)I", "getPreItemCount", "getPreItemCountByOrder", "getRelativeInfo", "Lcom/mikepenz/fastadapter/FastAdapter$RelativeInfo;", "getTypeInstance", "type", "notifyAdapterDataSetChanged", "notifyAdapterItemChanged", "payload", "", "notifyAdapterItemInserted", "notifyAdapterItemMoved", "fromPosition", "toPosition", "notifyAdapterItemRangeChanged", "itemCount", "notifyAdapterItemRangeInserted", "notifyAdapterItemRangeRemoved", "notifyAdapterItemRemoved", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "payloads", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "prepareAdapters", "recursive", "Lcom/mikepenz/fastadapter/utils/Triple;", "predicate", "Lcom/mikepenz/fastadapter/utils/AdapterPredicate;", "stopOnMatch", "globalStartPosition", "registerTypeInstance", "(Lcom/mikepenz/fastadapter/IItem;)V", "requireExtension", "requireOrCreateExtension", "saveInstanceState", "Landroid/os/Bundle;", "savedInstanceState", "prefix", "", "withSavedInstanceState", "Companion", "RelativeInfo", "ViewHolder", "fastadapter"}, k = 1, mv = {1, 1, 16})
/* compiled from: FastAdapter.kt */
public class FastAdapter<Item extends IItem<? extends RecyclerView.ViewHolder>> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FastAdapter";
    private List<EventHook<? extends Item>> _eventHooks;
    private final SparseArray<IAdapter<Item>> adapterSizes = new SparseArray<>();
    /* access modifiers changed from: private */
    public final ArrayList<IAdapter<Item>> adapters = new ArrayList<>();
    private boolean attachDefaultListeners = true;
    /* access modifiers changed from: private */
    public final ArrayMap<Class<?>, IAdapterExtension<Item>> extensionsCache = new ArrayMap<>();
    private int globalSize;
    private boolean legacyBindViewMode;
    private final VerboseLogger logger = new VerboseLogger(TAG);
    private OnBindViewHolderListener onBindViewHolderListener = new OnBindViewHolderListenerImpl();
    private Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> onClickListener;
    private OnCreateViewHolderListener<Item> onCreateViewHolderListener = new OnCreateViewHolderListenerImpl();
    private Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> onLongClickListener;
    private Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> onPreClickListener;
    private Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> onPreLongClickListener;
    private Function5<? super View, ? super MotionEvent, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> onTouchListener;
    private ITypeInstanceCache<Item> typeInstanceCache = new DefaultTypeInstanceCache();
    private final ClickEventHook<Item> viewClickListener = new FastAdapter$viewClickListener$1();
    private final LongClickEventHook<Item> viewLongClickListener = new FastAdapter$viewLongClickListener$1();
    private final TouchEventHook<Item> viewTouchListener = new FastAdapter$viewTouchListener$1();

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> FastAdapter<Item> getFromHolderTag(RecyclerView.ViewHolder viewHolder) {
        return Companion.getFromHolderTag(viewHolder);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> Item getHolderAdapterItem(RecyclerView.ViewHolder viewHolder) {
        return Companion.getHolderAdapterItem(viewHolder);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> Item getHolderAdapterItem(RecyclerView.ViewHolder viewHolder, int i) {
        return Companion.getHolderAdapterItem(viewHolder, i);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> Item getHolderAdapterItemTag(RecyclerView.ViewHolder viewHolder) {
        return Companion.getHolderAdapterItemTag(viewHolder);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>> Triple<Boolean, Item, Integer> recursiveSub(IAdapter<Item> iAdapter, int i, IExpandable<?> iExpandable, AdapterPredicate<Item> adapterPredicate, boolean z) {
        return Companion.recursiveSub(iAdapter, i, iExpandable, adapterPredicate, z);
    }

    public static /* synthetic */ void viewClickListener$annotations() {
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<Item>> FastAdapter<Item> with(A a) {
        return Companion.with(a);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<?>> FastAdapter<Item> with(Collection<? extends A> collection) {
        return Companion.with(collection);
    }

    @JvmStatic
    public static final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<?>> FastAdapter<Item> with(Collection<? extends A> collection, Collection<? extends IAdapterExtension<Item>> collection2) {
        return Companion.with(collection, collection2);
    }

    public void notifyAdapterItemChanged(int i) {
        notifyAdapterItemChanged$default(this, i, (Object) null, 2, (Object) null);
    }

    public void notifyAdapterItemRangeChanged(int i, int i2) {
        notifyAdapterItemRangeChanged$default(this, i, i2, (Object) null, 4, (Object) null);
    }

    public Bundle saveInstanceState(Bundle bundle) {
        return saveInstanceState$default(this, bundle, (String) null, 2, (Object) null);
    }

    public final FastAdapter<Item> withSavedInstanceState(Bundle bundle) {
        return withSavedInstanceState$default(this, bundle, (String) null, 2, (Object) null);
    }

    public FastAdapter() {
        setHasStableIds(true);
    }

    public ITypeInstanceCache<Item> getTypeInstanceCache() {
        return this.typeInstanceCache;
    }

    public void setTypeInstanceCache(ITypeInstanceCache<Item> iTypeInstanceCache) {
        Intrinsics.checkParameterIsNotNull(iTypeInstanceCache, "<set-?>");
        this.typeInstanceCache = iTypeInstanceCache;
    }

    public final List<EventHook<? extends Item>> getEventHooks() {
        List<EventHook<? extends Item>> list = this._eventHooks;
        if (list != null) {
            return list;
        }
        LinkedList it = new LinkedList();
        this._eventHooks = it;
        return it;
    }

    public final boolean getLegacyBindViewMode() {
        return this.legacyBindViewMode;
    }

    public final void setLegacyBindViewMode(boolean z) {
        this.legacyBindViewMode = z;
    }

    public final boolean getAttachDefaultListeners() {
        return this.attachDefaultListeners;
    }

    public final void setAttachDefaultListeners(boolean z) {
        this.attachDefaultListeners = z;
    }

    public final boolean getVerboseLoggingEnabled() {
        return this.logger.isEnabled();
    }

    public final void setVerboseLoggingEnabled(boolean value) {
        this.logger.setEnabled(value);
    }

    public final Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnPreClickListener() {
        return this.onPreClickListener;
    }

    public final void setOnPreClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4) {
        this.onPreClickListener = function4;
    }

    public final Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnClickListener() {
        return this.onClickListener;
    }

    public final void setOnClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4) {
        this.onClickListener = function4;
    }

    public final Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnPreLongClickListener() {
        return this.onPreLongClickListener;
    }

    public final void setOnPreLongClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4) {
        this.onPreLongClickListener = function4;
    }

    public final Function4<View, IAdapter<Item>, Item, Integer, Boolean> getOnLongClickListener() {
        return this.onLongClickListener;
    }

    public final void setOnLongClickListener(Function4<? super View, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function4) {
        this.onLongClickListener = function4;
    }

    public final Function5<View, MotionEvent, IAdapter<Item>, Item, Integer, Boolean> getOnTouchListener() {
        return this.onTouchListener;
    }

    public final void setOnTouchListener(Function5<? super View, ? super MotionEvent, ? super IAdapter<Item>, ? super Item, ? super Integer, Boolean> function5) {
        this.onTouchListener = function5;
    }

    public final OnCreateViewHolderListener<Item> getOnCreateViewHolderListener() {
        return this.onCreateViewHolderListener;
    }

    public final void setOnCreateViewHolderListener(OnCreateViewHolderListener<Item> onCreateViewHolderListener2) {
        Intrinsics.checkParameterIsNotNull(onCreateViewHolderListener2, "<set-?>");
        this.onCreateViewHolderListener = onCreateViewHolderListener2;
    }

    public final OnBindViewHolderListener getOnBindViewHolderListener() {
        return this.onBindViewHolderListener;
    }

    public final void setOnBindViewHolderListener(OnBindViewHolderListener onBindViewHolderListener2) {
        Intrinsics.checkParameterIsNotNull(onBindViewHolderListener2, "<set-?>");
        this.onBindViewHolderListener = onBindViewHolderListener2;
    }

    public final Collection<IAdapterExtension<Item>> getExtensions() {
        Collection<IAdapterExtension<Item>> values = this.extensionsCache.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "extensionsCache.values");
        return values;
    }

    public ClickEventHook<Item> getViewClickListener() {
        return this.viewClickListener;
    }

    public LongClickEventHook<Item> getViewLongClickListener() {
        return this.viewLongClickListener;
    }

    public TouchEventHook<Item> getViewTouchListener() {
        return this.viewTouchListener;
    }

    public <A extends IAdapter<Item>> FastAdapter<Item> addAdapter(int index, A adapter) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        this.adapters.add(index, adapter);
        prepareAdapters(adapter);
        return this;
    }

    public <A extends IAdapter<Item>> FastAdapter<Item> addAdapters(List<? extends A> newAdapters) {
        Intrinsics.checkParameterIsNotNull(newAdapters, "newAdapters");
        this.adapters.addAll(newAdapters);
        Iterator it = newAdapters.iterator();
        while (it.hasNext()) {
            prepareAdapters((IAdapter) it.next());
        }
        return this;
    }

    private final void prepareAdapters(IAdapter<Item> adapter) {
        adapter.setFastAdapter(this);
        adapter.mapPossibleTypes(adapter.getAdapterItems());
        int i = 0;
        for (Object item$iv : this.adapters) {
            int index$iv = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((IAdapter) item$iv).setOrder(i);
            i = index$iv;
        }
        cacheSizes();
    }

    public IAdapter<Item> adapter(int order) {
        return (IAdapter) CollectionsKt.getOrNull(this.adapters, order);
    }

    public final <E extends IAdapterExtension<Item>> FastAdapter<Item> addExtension(E extension) {
        Intrinsics.checkParameterIsNotNull(extension, "extension");
        if (!this.extensionsCache.containsKey(extension.getClass())) {
            this.extensionsCache.put(extension.getClass(), extension);
            return this;
        }
        throw new IllegalStateException("The given extension was already registered with this FastAdapter instance");
    }

    public final <T extends IAdapterExtension<Item>> T getExtension(Class<? super T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return (IAdapterExtension) this.extensionsCache.get(clazz);
    }

    public final /* synthetic */ <T extends IAdapterExtension<Item>> T getExtension() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getExtension(IAdapterExtension.class);
    }

    public final /* synthetic */ <T extends IAdapterExtension<Item>> T requireExtension() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T extension = getExtension(IAdapterExtension.class);
        if (extension == null) {
            Intrinsics.throwNpe();
        }
        return extension;
    }

    public final <T extends IAdapterExtension<Item>> T getOrCreateExtension(Class<? super T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        if (this.extensionsCache.containsKey(clazz)) {
            T t = this.extensionsCache.get(clazz);
            if (t != null) {
                return (IAdapterExtension) t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        IAdapterExtension extension = ExtensionsFactories.INSTANCE.create(this, clazz);
        if (!(extension instanceof IAdapterExtension)) {
            extension = null;
        }
        if (extension == null) {
            return null;
        }
        this.extensionsCache.put(clazz, extension);
        return extension;
    }

    public final /* synthetic */ <T extends IAdapterExtension<Item>> T getOrCreateExtension() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getOrCreateExtension(IAdapterExtension.class);
    }

    public final /* synthetic */ <T extends IAdapterExtension<Item>> T requireOrCreateExtension() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T orCreateExtension = getOrCreateExtension(IAdapterExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        return orCreateExtension;
    }

    public final FastAdapter<Item> addEventHook(EventHook<? extends Item> eventHook) {
        Intrinsics.checkParameterIsNotNull(eventHook, "eventHook");
        getEventHooks().add(eventHook);
        return this;
    }

    public final FastAdapter<Item> addEventHooks(Collection<? extends EventHook<? extends Item>> eventHooks) {
        Intrinsics.checkParameterIsNotNull(eventHooks, "eventHooks");
        getEventHooks().addAll(eventHooks);
        return this;
    }

    public static /* synthetic */ FastAdapter withSavedInstanceState$default(FastAdapter fastAdapter, Bundle bundle, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = "";
            }
            return fastAdapter.withSavedInstanceState(bundle, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withSavedInstanceState");
    }

    public final FastAdapter<Item> withSavedInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.withSavedInstanceState(savedInstanceState, prefix);
        }
        return this;
    }

    public final void registerTypeInstance(Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        getTypeInstanceCache().register(item);
    }

    public final Item getTypeInstance(int type) {
        return getTypeInstanceCache().get(type);
    }

    public final void clearTypeInstance() {
        getTypeInstanceCache().clear();
    }

    public int getHolderAdapterPosition(RecyclerView.ViewHolder holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        return holder.getAdapterPosition();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        VerboseLogger verboseLogger = this.logger;
        verboseLogger.log("onCreateViewHolder: " + viewType);
        IItem typeInstance = getTypeInstance(viewType);
        RecyclerView.ViewHolder holder = this.onCreateViewHolderListener.onPreCreateViewHolder(this, parent, viewType, typeInstance);
        holder.itemView.setTag(R.id.fastadapter_item_adapter, this);
        if (this.attachDefaultListeners) {
            View view = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            EventHookUtilKt.attachToView(getViewClickListener(), holder, view);
            View view2 = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            EventHookUtilKt.attachToView(getViewLongClickListener(), holder, view2);
            View view3 = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            EventHookUtilKt.attachToView(getViewTouchListener(), holder, view3);
        }
        return this.onCreateViewHolderListener.onPostCreateViewHolder(this, holder, typeInstance);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        if (this.legacyBindViewMode) {
            if (getVerboseLoggingEnabled()) {
                Log.v(TAG, "onBindViewHolderLegacy: " + position + "/" + holder.getItemViewType() + " isLegacy: true");
            }
            holder.itemView.setTag(R.id.fastadapter_item_adapter, this);
            OnBindViewHolderListener onBindViewHolderListener2 = this.onBindViewHolderListener;
            List emptyList = Collections.emptyList();
            Intrinsics.checkExpressionValueIsNotNull(emptyList, "Collections.emptyList()");
            onBindViewHolderListener2.onBindViewHolder(holder, position, emptyList);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        if (!this.legacyBindViewMode) {
            if (getVerboseLoggingEnabled()) {
                Log.v(TAG, "onBindViewHolder: " + position + "/" + holder.getItemViewType() + " isLegacy: false");
            }
            holder.itemView.setTag(R.id.fastadapter_item_adapter, this);
            this.onBindViewHolderListener.onBindViewHolder(holder, position, payloads);
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        VerboseLogger verboseLogger = this.logger;
        verboseLogger.log("onViewRecycled: " + holder.getItemViewType());
        super.onViewRecycled(holder);
        this.onBindViewHolderListener.unBindViewHolder(holder, holder.getAdapterPosition());
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        VerboseLogger verboseLogger = this.logger;
        verboseLogger.log("onViewDetachedFromWindow: " + holder.getItemViewType());
        super.onViewDetachedFromWindow(holder);
        this.onBindViewHolderListener.onViewDetachedFromWindow(holder, holder.getAdapterPosition());
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        VerboseLogger verboseLogger = this.logger;
        verboseLogger.log("onViewAttachedToWindow: " + holder.getItemViewType());
        super.onViewAttachedToWindow(holder);
        this.onBindViewHolderListener.onViewAttachedToWindow(holder, holder.getAdapterPosition());
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder holder) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        VerboseLogger verboseLogger = this.logger;
        verboseLogger.log("onFailedToRecycleView: " + holder.getItemViewType());
        return this.onBindViewHolderListener.onFailedToRecycleView(holder, holder.getAdapterPosition()) || super.onFailedToRecycleView(holder);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.logger.log("onAttachedToRecyclerView");
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.logger.log("onDetachedFromRecyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public int getPosition(Item item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (item.getIdentifier() != -1) {
            return getPosition(item.getIdentifier());
        }
        Log.e(TAG, "You have to define an identifier for your item to retrieve the position via this method");
        return -1;
    }

    public int getPosition(long identifier) {
        int position = 0;
        Iterator<IAdapter<Item>> it = this.adapters.iterator();
        while (it.hasNext()) {
            IAdapter adapter = it.next();
            if (adapter.getOrder() >= 0) {
                int relativePosition = adapter.getAdapterPosition(identifier);
                if (relativePosition != -1) {
                    return position + relativePosition;
                }
                position = adapter.getAdapterItemCount();
            }
        }
        return -1;
    }

    public Item getItem(int position) {
        if (position < 0 || position >= this.globalSize) {
            return null;
        }
        int index = Companion.floorIndex(this.adapterSizes, position);
        return this.adapterSizes.valueAt(index).getAdapterItem(position - this.adapterSizes.keyAt(index));
    }

    public Pair<Item, Integer> getItemById(long identifier) {
        if (identifier == -1) {
            return null;
        }
        Triple recursive = recursive(new FastAdapter$getItemById$1(identifier), true);
        IItem second = (IItem) recursive.component2();
        Integer third = (Integer) recursive.component3();
        if (second == null) {
            return null;
        }
        return new Pair<>(second, third);
    }

    public RelativeInfo<Item> getRelativeInfo(int position) {
        if (position < 0 || position >= getItemCount()) {
            return new RelativeInfo<>();
        }
        RelativeInfo relativeInfo = new RelativeInfo();
        int index = Companion.floorIndex(this.adapterSizes, position);
        if (index != -1) {
            relativeInfo.setItem(this.adapterSizes.valueAt(index).getAdapterItem(position - this.adapterSizes.keyAt(index)));
            relativeInfo.setAdapter(this.adapterSizes.valueAt(index));
            relativeInfo.setPosition(position);
        }
        return relativeInfo;
    }

    public IAdapter<Item> getAdapter(int position) {
        if (position < 0 || position >= this.globalSize) {
            return null;
        }
        this.logger.log("getAdapter");
        SparseArray<IAdapter<Item>> sparseArray = this.adapterSizes;
        return sparseArray.valueAt(Companion.floorIndex(sparseArray, position));
    }

    public int getItemViewType(int position) {
        IItem item = getItem(position);
        return item != null ? item.getType() : super.getItemViewType(position);
    }

    public long getItemId(int position) {
        IItem item = getItem(position);
        return item != null ? item.getIdentifier() : super.getItemId(position);
    }

    public int getItemCount() {
        return this.globalSize;
    }

    public int getPreItemCountByOrder(int order) {
        if (this.globalSize == 0) {
            return 0;
        }
        int size = 0;
        int min = Math.min(order, this.adapters.size());
        for (int i = 0; i < min; i++) {
            size += this.adapters.get(i).getAdapterItemCount();
        }
        return size;
    }

    public int getPreItemCount(int position) {
        if (this.globalSize == 0) {
            return 0;
        }
        SparseArray<IAdapter<Item>> sparseArray = this.adapterSizes;
        return sparseArray.keyAt(Companion.floorIndex(sparseArray, position));
    }

    public static /* synthetic */ Bundle saveInstanceState$default(FastAdapter fastAdapter, Bundle bundle, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = "";
            }
            return fastAdapter.saveInstanceState(bundle, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveInstanceState");
    }

    public Bundle saveInstanceState(Bundle savedInstanceState, String prefix) {
        Intrinsics.checkParameterIsNotNull(savedInstanceState, "savedInstanceState");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.saveInstanceState(savedInstanceState, prefix);
        }
        return savedInstanceState;
    }

    /* access modifiers changed from: protected */
    public final void cacheSizes() {
        this.adapterSizes.clear();
        int size = 0;
        Iterator<IAdapter<Item>> it = this.adapters.iterator();
        while (it.hasNext()) {
            IAdapter adapter = it.next();
            if (adapter.getAdapterItemCount() > 0) {
                this.adapterSizes.append(size, adapter);
                size += adapter.getAdapterItemCount();
            }
        }
        if (size == 0 && this.adapters.size() > 0) {
            this.adapterSizes.append(0, this.adapters.get(0));
        }
        this.globalSize = size;
    }

    public void notifyAdapterDataSetChanged() {
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.notifyAdapterDataSetChanged();
        }
        cacheSizes();
        notifyDataSetChanged();
    }

    public void notifyAdapterItemInserted(int position) {
        notifyAdapterItemRangeInserted(position, 1);
    }

    public void notifyAdapterItemRangeInserted(int position, int itemCount) {
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.notifyAdapterItemRangeInserted(position, itemCount);
        }
        cacheSizes();
        notifyItemRangeInserted(position, itemCount);
    }

    public void notifyAdapterItemRemoved(int position) {
        notifyAdapterItemRangeRemoved(position, 1);
    }

    public void notifyAdapterItemRangeRemoved(int position, int itemCount) {
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.notifyAdapterItemRangeRemoved(position, itemCount);
        }
        cacheSizes();
        notifyItemRangeRemoved(position, itemCount);
    }

    public void notifyAdapterItemMoved(int fromPosition, int toPosition) {
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.notifyAdapterItemMoved(fromPosition, toPosition);
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public static /* synthetic */ void notifyAdapterItemChanged$default(FastAdapter fastAdapter, int i, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                obj = null;
            }
            fastAdapter.notifyAdapterItemChanged(i, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAdapterItemChanged");
    }

    public void notifyAdapterItemChanged(int position, Object payload) {
        notifyAdapterItemRangeChanged(position, 1, payload);
    }

    public static /* synthetic */ void notifyAdapterItemRangeChanged$default(FastAdapter fastAdapter, int i, int i2, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                obj = null;
            }
            fastAdapter.notifyAdapterItemRangeChanged(i, i2, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAdapterItemRangeChanged");
    }

    public void notifyAdapterItemRangeChanged(int position, int itemCount, Object payload) {
        for (IAdapterExtension<Item> ext : this.extensionsCache.values()) {
            ext.notifyAdapterItemRangeChanged(position, itemCount, payload);
        }
        if (payload == null) {
            notifyItemRangeChanged(position, itemCount);
        } else {
            notifyItemRangeChanged(position, itemCount, payload);
        }
    }

    public final Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> predicate, boolean stopOnMatch) {
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return recursive(predicate, 0, stopOnMatch);
    }

    public final Triple<Boolean, Item, Integer> recursive(AdapterPredicate<Item> predicate, int globalStartPosition, boolean stopOnMatch) {
        IAdapter adapter;
        AdapterPredicate<Item> adapterPredicate = predicate;
        Intrinsics.checkParameterIsNotNull(adapterPredicate, "predicate");
        int itemCount = getItemCount();
        int i = globalStartPosition;
        while (true) {
            IExpandable iExpandable = null;
            if (i < itemCount) {
                int i2 = i;
                RelativeInfo relativeInfo = getRelativeInfo(i2);
                IItem item = relativeInfo.getItem();
                if (!(item == null || (adapter = relativeInfo.getAdapter()) == null)) {
                    IAdapter adapter2 = adapter;
                    if (adapterPredicate.apply(adapter2, i2, item, i2) && stopOnMatch) {
                        return new Triple<>(true, item, Integer.valueOf(i2));
                    }
                    if (item instanceof IExpandable) {
                        iExpandable = item;
                    }
                    IExpandable expandableItem = iExpandable;
                    if (expandableItem != null) {
                        Triple res = Companion.recursiveSub(adapter2, i2, expandableItem, predicate, stopOnMatch);
                        if (res.getFirst().booleanValue() && stopOnMatch) {
                            return res;
                        }
                    } else {
                        continue;
                    }
                }
                i = i2 + 1;
            } else {
                return new Triple<>(false, null, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000*\u0014\b\u0001\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/mikepenz/fastadapter/FastAdapter$RelativeInfo;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "", "()V", "adapter", "Lcom/mikepenz/fastadapter/IAdapter;", "getAdapter", "()Lcom/mikepenz/fastadapter/IAdapter;", "setAdapter", "(Lcom/mikepenz/fastadapter/IAdapter;)V", "item", "getItem", "()Lcom/mikepenz/fastadapter/IItem;", "setItem", "(Lcom/mikepenz/fastadapter/IItem;)V", "Lcom/mikepenz/fastadapter/IItem;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FastAdapter.kt */
    public static final class RelativeInfo<Item extends IItem<? extends RecyclerView.ViewHolder>> {
        private IAdapter<Item> adapter;
        private Item item;
        private int position = -1;

        public final IAdapter<Item> getAdapter() {
            return this.adapter;
        }

        public final void setAdapter(IAdapter<Item> iAdapter) {
            this.adapter = iAdapter;
        }

        public final Item getItem() {
            return this.item;
        }

        public final void setItem(Item item2) {
            this.item = item2;
        }

        public final int getPosition() {
            return this.position;
        }

        public final void setPosition(int i) {
            this.position = i;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\u0014\b\u0001\u0010\u0001*\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00042\u00020\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/mikepenz/fastadapter/FastAdapter$ViewHolder;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "attachToWindow", "", "item", "(Lcom/mikepenz/fastadapter/IItem;)V", "bindView", "payloads", "", "", "(Lcom/mikepenz/fastadapter/IItem;Ljava/util/List;)V", "detachFromWindow", "failedToRecycle", "", "(Lcom/mikepenz/fastadapter/IItem;)Z", "unbindView", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FastAdapter.kt */
    public static abstract class ViewHolder<Item extends IItem<? extends RecyclerView.ViewHolder>> extends RecyclerView.ViewHolder {
        public abstract void bindView(Item item, List<Object> list);

        public abstract void unbindView(Item item);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkParameterIsNotNull(itemView, "itemView");
        }

        public final void attachToWindow(Item item) {
            Intrinsics.checkParameterIsNotNull(item, "item");
        }

        public final void detachFromWindow(Item item) {
            Intrinsics.checkParameterIsNotNull(item, "item");
        }

        public final boolean failedToRecycle(Item item) {
            Intrinsics.checkParameterIsNotNull(item, "item");
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J0\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000b\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007J/\u0010\u0011\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012J7\u0010\u0011\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012Jh\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00060\u0017\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\f0\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0007JA\u0010!\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f\"\u000e\b\u0002\u0010\"*\b\u0012\u0004\u0012\u0002H\f0\u001a2\u0006\u0010#\u001a\u0002H\"H\u0007¢\u0006\u0002\u0010$JB\u0010!\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f\"\f\b\u0002\u0010\"*\u0006\u0012\u0002\b\u00030\u001a2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H\"\u0018\u00010&H\u0007JX\u0010!\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0014\b\u0001\u0010\f*\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\u0002`\u000f\"\f\b\u0002\u0010\"*\u0006\u0012\u0002\b\u00030\u001a2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H\"\u0018\u00010&2\u0014\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0(\u0018\u00010&H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/mikepenz/fastadapter/FastAdapter$Companion;", "", "()V", "TAG", "", "floorIndex", "", "sparseArray", "Landroid/util/SparseArray;", "key", "getFromHolderTag", "Lcom/mikepenz/fastadapter/FastAdapter;", "Item", "Lcom/mikepenz/fastadapter/IItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/mikepenz/fastadapter/GenericItem;", "holder", "getHolderAdapterItem", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lcom/mikepenz/fastadapter/IItem;", "position", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)Lcom/mikepenz/fastadapter/IItem;", "getHolderAdapterItemTag", "recursiveSub", "Lcom/mikepenz/fastadapter/utils/Triple;", "", "lastParentAdapter", "Lcom/mikepenz/fastadapter/IAdapter;", "lastParentPosition", "parent", "Lcom/mikepenz/fastadapter/IExpandable;", "predicate", "Lcom/mikepenz/fastadapter/utils/AdapterPredicate;", "stopOnMatch", "with", "A", "adapter", "(Lcom/mikepenz/fastadapter/IAdapter;)Lcom/mikepenz/fastadapter/FastAdapter;", "adapters", "", "extensions", "Lcom/mikepenz/fastadapter/IAdapterExtension;", "fastadapter"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FastAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int floorIndex(SparseArray<?> sparseArray, int key) {
            int index = sparseArray.indexOfKey(key);
            if (index < 0) {
                return (~index) - 1;
            }
            return index;
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<Item>> FastAdapter<Item> with(A adapter) {
            Intrinsics.checkParameterIsNotNull(adapter, "adapter");
            FastAdapter fastAdapter = new FastAdapter();
            fastAdapter.addAdapter(0, adapter);
            return fastAdapter;
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<?>> FastAdapter<Item> with(Collection<? extends A> adapters) {
            return with(adapters, (Collection) null);
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>, A extends IAdapter<?>> FastAdapter<Item> with(Collection<? extends A> adapters, Collection<? extends IAdapterExtension<Item>> extensions) {
            FastAdapter fastAdapter = new FastAdapter();
            if (adapters == null) {
                ArrayList access$getAdapters$p = fastAdapter.adapters;
                ItemAdapter items = ItemAdapter.Companion.items();
                if (items != null) {
                    access$getAdapters$p.add(items);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.fastadapter.IAdapter<Item>");
                }
            } else {
                fastAdapter.adapters.addAll(adapters);
            }
            int size = fastAdapter.adapters.size();
            for (int i = 0; i < size; i++) {
                IAdapter $this$apply = (IAdapter) fastAdapter.adapters.get(i);
                $this$apply.setFastAdapter(fastAdapter);
                $this$apply.setOrder(i);
            }
            fastAdapter.cacheSizes();
            if (extensions != null) {
                for (IAdapterExtension it : extensions) {
                    fastAdapter.addExtension(it);
                }
            }
            return fastAdapter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r1 = r4.itemView;
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Item extends com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView.ViewHolder>> com.mikepenz.fastadapter.FastAdapter<Item> getFromHolderTag(androidx.recyclerview.widget.RecyclerView.ViewHolder r4) {
            /*
                r3 = this;
                r0 = 0
                if (r4 == 0) goto L_0x000e
                android.view.View r1 = r4.itemView
                if (r1 == 0) goto L_0x000e
                int r2 = com.mikepenz.fastadapter.R.id.fastadapter_item_adapter
                java.lang.Object r1 = r1.getTag(r2)
                goto L_0x000f
            L_0x000e:
                r1 = r0
            L_0x000f:
                boolean r2 = r1 instanceof com.mikepenz.fastadapter.FastAdapter
                if (r2 != 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r0 = r1
            L_0x0015:
                com.mikepenz.fastadapter.FastAdapter r0 = (com.mikepenz.fastadapter.FastAdapter) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.FastAdapter.Companion.getFromHolderTag(androidx.recyclerview.widget.RecyclerView$ViewHolder):com.mikepenz.fastadapter.FastAdapter");
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>> Item getHolderAdapterItem(RecyclerView.ViewHolder holder) {
            FastAdapter adapter;
            if (holder == null || (adapter = getFromHolderTag(holder)) == null) {
                return null;
            }
            Integer valueOf = Integer.valueOf(adapter.getHolderAdapterPosition(holder));
            if (!(valueOf.intValue() != -1)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return adapter.getItem(valueOf.intValue());
            }
            return null;
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>> Item getHolderAdapterItem(RecyclerView.ViewHolder holder, int position) {
            FastAdapter fromHolderTag = getFromHolderTag(holder);
            if (fromHolderTag != null) {
                return fromHolderTag.getItem(position);
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r1 = r4.itemView;
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Item extends com.mikepenz.fastadapter.IItem<? extends androidx.recyclerview.widget.RecyclerView.ViewHolder>> Item getHolderAdapterItemTag(androidx.recyclerview.widget.RecyclerView.ViewHolder r4) {
            /*
                r3 = this;
                r0 = 0
                if (r4 == 0) goto L_0x000e
                android.view.View r1 = r4.itemView
                if (r1 == 0) goto L_0x000e
                int r2 = com.mikepenz.fastadapter.R.id.fastadapter_item
                java.lang.Object r1 = r1.getTag(r2)
                goto L_0x000f
            L_0x000e:
                r1 = r0
            L_0x000f:
                boolean r2 = r1 instanceof com.mikepenz.fastadapter.IItem
                if (r2 != 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r0 = r1
            L_0x0015:
                com.mikepenz.fastadapter.IItem r0 = (com.mikepenz.fastadapter.IItem) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mikepenz.fastadapter.FastAdapter.Companion.getHolderAdapterItemTag(androidx.recyclerview.widget.RecyclerView$ViewHolder):com.mikepenz.fastadapter.IItem");
        }

        @JvmStatic
        public final <Item extends IItem<? extends RecyclerView.ViewHolder>> Triple<Boolean, Item, Integer> recursiveSub(IAdapter<Item> lastParentAdapter, int lastParentPosition, IExpandable<?> parent, AdapterPredicate<Item> predicate, boolean stopOnMatch) {
            IAdapter<Item> iAdapter = lastParentAdapter;
            AdapterPredicate<Item> adapterPredicate = predicate;
            Intrinsics.checkParameterIsNotNull(iAdapter, "lastParentAdapter");
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Intrinsics.checkParameterIsNotNull(adapterPredicate, "predicate");
            if (!parent.isExpanded()) {
                for (ISubItem sub : parent.getSubItems()) {
                    if (sub != null) {
                        if (adapterPredicate.apply(iAdapter, lastParentPosition, sub, -1) && stopOnMatch) {
                            return new Triple<>(true, sub, null);
                        }
                        if (sub instanceof IExpandable) {
                            Triple res = FastAdapter.Companion.recursiveSub(lastParentAdapter, lastParentPosition, (IExpandable) sub, predicate, stopOnMatch);
                            if (res.getFirst().booleanValue()) {
                                return res;
                            }
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type Item");
                    }
                }
            }
            return new Triple<>(false, null, null);
        }
    }
}

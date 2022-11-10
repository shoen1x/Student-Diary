package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.ViewCompat;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.utils.DefaultIdDistributor;
import com.mikepenz.iconics.IconicsColor;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.IconicsSize;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ColorHolderKt;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialdrawer.view.BezelImageView;
import com.mikepenz.materialize.util.UIUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b*\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b$*\u0004\u0001\u0001\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010ó\u0001\u001a\u00020\u00002\u001c\u0010·\u0001\u001a\u000f\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003040ô\u0001\"\u0006\u0012\u0002\b\u000304¢\u0006\u0003\u0010õ\u0001J\n\u0010ö\u0001\u001a\u00030÷\u0001H\u0016J\u0010\u0010ø\u0001\u001a\u00030ù\u0001H\u0000¢\u0006\u0003\bú\u0001J\u0010\u0010û\u0001\u001a\u00030ù\u0001H\u0000¢\u0006\u0003\bü\u0001J\u0010\u0010ý\u0001\u001a\u00030ù\u0001H\u0000¢\u0006\u0003\bþ\u0001J\"\u0010ÿ\u0001\u001a\u00030ù\u00012\r\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u0001042\u0007\u0010\u0002\u001a\u00020\"H\u0002J\"\u0010\u0002\u001a\u00030ù\u00012\u0007\u0010\u0002\u001a\u00020\u00042\u0007\u0010\u0002\u001a\u00020\"H\u0000¢\u0006\u0003\b\u0002J\u001c\u0010\u0002\u001a\u00030ù\u00012\u0007\u0010\u0002\u001a\u00020\u00042\u0007\u0010\u0002\u001a\u00020\"H\u0002J\u0014\u0010\u0002\u001a\u00030ù\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0002J\u0012\u0010\u0002\u001a\u00030ù\u00012\u0006\u0010e\u001a\u00020\u0013H\u0002J\u001e\u0010\u0002\u001a\u00030ù\u00012\u0007\u0010\u0002\u001a\u00020\n2\t\u0010\u0002\u001a\u0004\u0018\u00010ZH\u0002J\u001e\u0010\u0002\u001a\u00020\"2\r\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u000104H\u0000¢\u0006\u0003\b\u0002J\u001a\u0010\u0002\u001a\u00030ù\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030ù\u0001H\u0000¢\u0006\u0003\b\u0002J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0002\u001a\u00020\u00002\t\b\u0001\u0010\u0002\u001a\u00020\u0013J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\"J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\"J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\"J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\"J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NJ\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010ð\u0001\u001a\u00020TJ\u0010\u0010 \u0002\u001a\u00020\u00002\u0007\u0010Y\u001a\u00030¡\u0002J\u000f\u0010 \u0002\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020ZJ\u0012\u0010 \u0002\u001a\u00020\u00002\t\b\u0001\u0010¢\u0002\u001a\u00020\u0013J\u000f\u0010£\u0002\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`J\u0010\u0010¤\u0002\u001a\u00020\u00002\u0007\u0010¥\u0002\u001a\u00020\u0013J\u0010\u0010¦\u0002\u001a\u00020\u00002\u0007\u0010§\u0002\u001a\u00020\u0013J\u0012\u0010¨\u0002\u001a\u00020\u00002\t\b\u0001\u0010©\u0002\u001a\u00020\u0013J\u0010\u0010ª\u0002\u001a\u00020\u00002\u0007\u0010ð\u0001\u001a\u00020TJ\u000f\u0010«\u0002\u001a\u00020\u00002\u0006\u0010n\u001a\u00020oJ\u000f\u0010¬\u0002\u001a\u00020\u00002\u0006\u0010t\u001a\u00020uJ\u000f\u0010­\u0002\u001a\u00020\u00002\u0006\u0010z\u001a\u00020{J\u0011\u0010®\u0002\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010¯\u0002\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0013J\u0010\u0010°\u0002\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\"J\u0010\u0010±\u0002\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\"J\u0010\u0010²\u0002\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\"J\u0010\u0010³\u0002\u001a\u00020\u00002\u0007\u0010¥\u0001\u001a\u00020\"J\u0010\u0010´\u0002\u001a\u00020\u00002\u0007\u0010¨\u0001\u001a\u00020\"J\u001b\u0010µ\u0002\u001a\u00020\u00002\u0012\u0010·\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003040¸\u0001J\u0010\u0010¶\u0002\u001a\u00020\u00002\u0007\u0010½\u0001\u001a\u00020\"J\u0013\u0010·\u0002\u001a\u00020\u00002\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001J\u0011\u0010¸\u0002\u001a\u00020\u00002\b\u0010Æ\u0001\u001a\u00030Ç\u0001J\u0010\u0010¹\u0002\u001a\u00020\u00002\u0007\u0010Ì\u0001\u001a\u00020\"J\u0012\u0010º\u0002\u001a\u00020\u00002\u0007\u0010Ì\u0001\u001a\u00020\"H\u0007J\u0010\u0010»\u0002\u001a\u00020\u00002\u0007\u0010Ï\u0001\u001a\u00020\"J\u0010\u0010¼\u0002\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\"J\u0011\u0010½\u0002\u001a\u00020\u00002\b\u0010Ø\u0001\u001a\u00030Ç\u0001J\u0010\u0010¾\u0002\u001a\u00020\u00002\u0007\u0010Û\u0001\u001a\u00020\"J\u0012\u0010¿\u0002\u001a\u00020\u00002\t\b\u0001\u0010ä\u0001\u001a\u00020\u0013J\u0012\u0010À\u0002\u001a\u00020\u00002\t\b\u0001\u0010Á\u0002\u001a\u00020\u0013J\u0010\u0010Â\u0002\u001a\u00020\u00002\u0007\u0010ê\u0001\u001a\u00020\"J\u0010\u0010Ã\u0002\u001a\u00020\u00002\u0007\u0010í\u0001\u001a\u00020\"J\u0010\u0010Ä\u0002\u001a\u00020\u00002\u0007\u0010ð\u0001\u001a\u00020TR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001a\u00100\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R \u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001a\u0010B\u001a\u00020CX.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00138@X\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0015R\u001a\u0010J\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010V\"\u0004\bm\u0010XR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010{X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R#\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u000104X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u00106\"\u0005\b¡\u0001\u00108R\u001d\u0010¢\u0001\u001a\u00020CX.¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010E\"\u0005\b¤\u0001\u0010GR\u001d\u0010¥\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010$\"\u0005\b§\u0001\u0010&R\u001d\u0010¨\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010$\"\u0005\bª\u0001\u0010&R#\u0010«\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u000104X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u00106\"\u0005\b­\u0001\u00108R\u001d\u0010®\u0001\u001a\u00020CX.¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010E\"\u0005\b°\u0001\u0010GR#\u0010±\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u000104X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u00106\"\u0005\b³\u0001\u00108R\u001d\u0010´\u0001\u001a\u00020CX.¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010E\"\u0005\b¶\u0001\u0010GR,\u0010·\u0001\u001a\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u000304\u0018\u00010¸\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001d\u0010½\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010$\"\u0005\b¿\u0001\u0010&R\"\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\"\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001d\u0010Ì\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010$\"\u0005\bÎ\u0001\u0010&R\u001d\u0010Ï\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010$\"\u0005\bÑ\u0001\u0010&R\u001d\u0010Ò\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010$\"\u0005\bÔ\u0001\u0010&R\u001d\u0010Õ\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010$\"\u0005\b×\u0001\u0010&R\"\u0010Ø\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0001\u0010É\u0001\"\u0006\bÚ\u0001\u0010Ë\u0001R\u001d\u0010Û\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0001\u0010$\"\u0005\bÝ\u0001\u0010&R \u0010Þ\u0001\u001a\u00030ß\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R\"\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R\u001d\u0010ê\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bë\u0001\u0010$\"\u0005\bì\u0001\u0010&R\u001d\u0010í\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bî\u0001\u0010$\"\u0005\bï\u0001\u0010&R\u001f\u0010ð\u0001\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bñ\u0001\u0010V\"\u0005\bò\u0001\u0010X¨\u0006Å\u0002"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeaderBuilder;", "", "()V", "accountHeader", "Landroid/view/View;", "getAccountHeader$materialdrawer", "()Landroid/view/View;", "setAccountHeader$materialdrawer", "(Landroid/view/View;)V", "accountHeaderBackground", "Landroid/widget/ImageView;", "getAccountHeaderBackground$materialdrawer", "()Landroid/widget/ImageView;", "setAccountHeaderBackground$materialdrawer", "(Landroid/widget/ImageView;)V", "accountHeaderContainer", "getAccountHeaderContainer$materialdrawer", "setAccountHeaderContainer$materialdrawer", "accountHeaderTextSectionBackgroundResource", "", "getAccountHeaderTextSectionBackgroundResource$materialdrawer", "()I", "setAccountHeaderTextSectionBackgroundResource$materialdrawer", "(I)V", "accountSwitcherArrow", "getAccountSwitcherArrow$materialdrawer", "setAccountSwitcherArrow$materialdrawer", "activity", "Landroid/app/Activity;", "getActivity$materialdrawer", "()Landroid/app/Activity;", "setActivity$materialdrawer", "(Landroid/app/Activity;)V", "alternativeProfileHeaderSwitching", "", "getAlternativeProfileHeaderSwitching$materialdrawer", "()Z", "setAlternativeProfileHeaderSwitching$materialdrawer", "(Z)V", "closeDrawerOnProfileListClick", "getCloseDrawerOnProfileListClick$materialdrawer", "()Ljava/lang/Boolean;", "setCloseDrawerOnProfileListClick$materialdrawer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "compactStyle", "getCompactStyle$materialdrawer", "setCompactStyle$materialdrawer", "currentHiddenInList", "getCurrentHiddenInList$materialdrawer", "setCurrentHiddenInList$materialdrawer", "currentProfile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "getCurrentProfile$materialdrawer", "()Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "setCurrentProfile$materialdrawer", "(Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;)V", "currentProfileEmail", "Landroid/widget/TextView;", "getCurrentProfileEmail$materialdrawer", "()Landroid/widget/TextView;", "setCurrentProfileEmail$materialdrawer", "(Landroid/widget/TextView;)V", "currentProfileName", "getCurrentProfileName$materialdrawer", "setCurrentProfileName$materialdrawer", "currentProfileView", "Lcom/mikepenz/materialdrawer/view/BezelImageView;", "getCurrentProfileView$materialdrawer", "()Lcom/mikepenz/materialdrawer/view/BezelImageView;", "setCurrentProfileView$materialdrawer", "(Lcom/mikepenz/materialdrawer/view/BezelImageView;)V", "currentSelection", "getCurrentSelection$materialdrawer", "dividerBelowHeader", "getDividerBelowHeader", "setDividerBelowHeader", "drawer", "Lcom/mikepenz/materialdrawer/Drawer;", "getDrawer$materialdrawer", "()Lcom/mikepenz/materialdrawer/Drawer;", "setDrawer$materialdrawer", "(Lcom/mikepenz/materialdrawer/Drawer;)V", "emailTypeface", "Landroid/graphics/Typeface;", "getEmailTypeface$materialdrawer", "()Landroid/graphics/Typeface;", "setEmailTypeface$materialdrawer", "(Landroid/graphics/Typeface;)V", "headerBackground", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "getHeaderBackground$materialdrawer", "()Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setHeaderBackground$materialdrawer", "(Lcom/mikepenz/materialdrawer/holder/ImageHolder;)V", "headerBackgroundScaleType", "Landroid/widget/ImageView$ScaleType;", "getHeaderBackgroundScaleType$materialdrawer", "()Landroid/widget/ImageView$ScaleType;", "setHeaderBackgroundScaleType$materialdrawer", "(Landroid/widget/ImageView$ScaleType;)V", "height", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getHeight$materialdrawer", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setHeight$materialdrawer", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "nameTypeface", "getNameTypeface$materialdrawer", "setNameTypeface$materialdrawer", "onAccountHeaderItemLongClickListener", "Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderItemLongClickListener;", "getOnAccountHeaderItemLongClickListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderItemLongClickListener;", "setOnAccountHeaderItemLongClickListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderItemLongClickListener;)V", "onAccountHeaderListener", "Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderListener;", "getOnAccountHeaderListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderListener;", "setOnAccountHeaderListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderListener;)V", "onAccountHeaderProfileImageListener", "Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderProfileImageListener;", "getOnAccountHeaderProfileImageListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderProfileImageListener;", "setOnAccountHeaderProfileImageListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderProfileImageListener;)V", "onAccountHeaderSelectionViewClickListener", "Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderSelectionViewClickListener;", "getOnAccountHeaderSelectionViewClickListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderSelectionViewClickListener;", "setOnAccountHeaderSelectionViewClickListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderSelectionViewClickListener;)V", "onCurrentProfileClickListener", "Landroid/view/View$OnClickListener;", "onCurrentProfileLongClickListener", "Landroid/view/View$OnLongClickListener;", "onDrawerItemClickListener", "com/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemClickListener$1", "Lcom/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemClickListener$1;", "onDrawerItemLongClickListener", "com/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemLongClickListener$1", "Lcom/mikepenz/materialdrawer/AccountHeaderBuilder$onDrawerItemLongClickListener$1;", "onProfileClickDrawerCloseDelay", "getOnProfileClickDrawerCloseDelay$materialdrawer", "setOnProfileClickDrawerCloseDelay$materialdrawer", "onProfileClickListener", "onProfileLongClickListener", "onSelectionClickListener", "onlyMainProfileImageVisible", "getOnlyMainProfileImageVisible$materialdrawer", "setOnlyMainProfileImageVisible$materialdrawer", "onlySmallProfileImagesVisible", "getOnlySmallProfileImagesVisible$materialdrawer", "setOnlySmallProfileImagesVisible$materialdrawer", "paddingBelowHeader", "getPaddingBelowHeader", "setPaddingBelowHeader", "profileFirst", "getProfileFirst$materialdrawer", "setProfileFirst$materialdrawer", "profileFirstView", "getProfileFirstView$materialdrawer", "setProfileFirstView$materialdrawer", "profileImagesClickable", "getProfileImagesClickable$materialdrawer", "setProfileImagesClickable$materialdrawer", "profileImagesVisible", "getProfileImagesVisible", "setProfileImagesVisible", "profileSecond", "getProfileSecond$materialdrawer", "setProfileSecond$materialdrawer", "profileSecondView", "getProfileSecondView$materialdrawer", "setProfileSecondView$materialdrawer", "profileThird", "getProfileThird$materialdrawer", "setProfileThird$materialdrawer", "profileThirdView", "getProfileThirdView$materialdrawer", "setProfileThirdView$materialdrawer", "profiles", "", "getProfiles$materialdrawer", "()Ljava/util/List;", "setProfiles$materialdrawer", "(Ljava/util/List;)V", "resetDrawerOnProfileListClick", "getResetDrawerOnProfileListClick$materialdrawer", "setResetDrawerOnProfileListClick$materialdrawer", "savedInstance", "Landroid/os/Bundle;", "getSavedInstance$materialdrawer", "()Landroid/os/Bundle;", "setSavedInstance$materialdrawer", "(Landroid/os/Bundle;)V", "selectionFirstLine", "", "getSelectionFirstLine$materialdrawer", "()Ljava/lang/String;", "setSelectionFirstLine$materialdrawer", "(Ljava/lang/String;)V", "selectionFirstLineShown", "getSelectionFirstLineShown$materialdrawer", "setSelectionFirstLineShown$materialdrawer", "selectionListEnabled", "getSelectionListEnabled$materialdrawer", "setSelectionListEnabled$materialdrawer", "selectionListEnabledForSingleProfile", "getSelectionListEnabledForSingleProfile$materialdrawer", "setSelectionListEnabledForSingleProfile$materialdrawer", "selectionListShown", "getSelectionListShown$materialdrawer", "setSelectionListShown$materialdrawer", "selectionSecondLine", "getSelectionSecondLine$materialdrawer", "setSelectionSecondLine$materialdrawer", "selectionSecondLineShown", "getSelectionSecondLineShown$materialdrawer", "setSelectionSecondLineShown$materialdrawer", "statusBarGuideline", "Landroidx/constraintlayout/widget/Guideline;", "getStatusBarGuideline$materialdrawer", "()Landroidx/constraintlayout/widget/Guideline;", "setStatusBarGuideline$materialdrawer", "(Landroidx/constraintlayout/widget/Guideline;)V", "textColor", "Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "getTextColor$materialdrawer", "()Lcom/mikepenz/materialdrawer/holder/ColorHolder;", "setTextColor$materialdrawer", "(Lcom/mikepenz/materialdrawer/holder/ColorHolder;)V", "threeSmallProfileImages", "getThreeSmallProfileImages$materialdrawer", "setThreeSmallProfileImages$materialdrawer", "translucentStatusBar", "getTranslucentStatusBar$materialdrawer", "setTranslucentStatusBar$materialdrawer", "typeface", "getTypeface$materialdrawer", "setTypeface$materialdrawer", "addProfiles", "", "([Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;)Lcom/mikepenz/materialdrawer/AccountHeaderBuilder;", "build", "Lcom/mikepenz/materialdrawer/AccountHeader;", "buildDrawerSelectionList", "", "buildDrawerSelectionList$materialdrawer", "buildProfiles", "buildProfiles$materialdrawer", "calculateProfiles", "calculateProfiles$materialdrawer", "handleSelectionView", "profile", "on", "onProfileClick", "v", "current", "onProfileClick$materialdrawer", "onProfileImageClick", "resetDrawerContent", "ctx", "Landroid/content/Context;", "setHeaderHeight", "setImageOrPlaceholder", "iv", "imageHolder", "switchProfiles", "newSelection", "switchProfiles$materialdrawer", "toggleSelectionList", "toggleSelectionList$materialdrawer", "updateHeaderAndList", "updateHeaderAndList$materialdrawer", "withAccountHeader", "resLayout", "withActivity", "withAlternativeProfileHeaderSwitching", "withCloseDrawerOnProfileListClick", "withCompactStyle", "withCurrentProfileHiddenInList", "currentProfileHiddenInList", "withDividerBelowHeader", "withDrawer", "withEmailTypeface", "withHeaderBackground", "Landroid/graphics/drawable/Drawable;", "headerBackgroundRes", "withHeaderBackgroundScaleType", "withHeightDp", "heightDp", "withHeightPx", "heightPx", "withHeightRes", "heightRes", "withNameTypeface", "withOnAccountHeaderItemLongClickListener", "withOnAccountHeaderListener", "withOnAccountHeaderProfileImageListener", "withOnAccountHeaderSelectionViewClickListener", "withOnProfileClickDrawerCloseDelay", "withOnlyMainProfileImageVisible", "withOnlySmallProfileImagesVisible", "withPaddingBelowHeader", "withProfileImagesClickable", "withProfileImagesVisible", "withProfiles", "withResetDrawerOnProfileListClick", "withSavedInstance", "withSelectionFirstLine", "withSelectionFirstLineShown", "withSelectionFistLineShown", "withSelectionListEnabled", "withSelectionListEnabledForSingleProfile", "withSelectionSecondLine", "withSelectionSecondLineShown", "withTextColor", "withTextColorRes", "textColorRes", "withThreeSmallProfileImages", "withTranslucentStatusBar", "withTypeface", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AccountHeaderBuilder.kt */
public class AccountHeaderBuilder {
    public View accountHeader;
    public ImageView accountHeaderBackground;
    public View accountHeaderContainer;
    private int accountHeaderTextSectionBackgroundResource = -1;
    public ImageView accountSwitcherArrow;
    private Activity activity;
    private boolean alternativeProfileHeaderSwitching;
    private Boolean closeDrawerOnProfileListClick;
    private boolean compactStyle;
    private boolean currentHiddenInList;
    private IProfile<?> currentProfile;
    public TextView currentProfileEmail;
    public TextView currentProfileName;
    public BezelImageView currentProfileView;
    private boolean dividerBelowHeader = true;
    private Drawer drawer;
    private Typeface emailTypeface;
    private ImageHolder headerBackground;
    private ImageView.ScaleType headerBackgroundScaleType;
    private DimenHolder height;
    private Typeface nameTypeface;
    private AccountHeader.OnAccountHeaderItemLongClickListener onAccountHeaderItemLongClickListener;
    private AccountHeader.OnAccountHeaderListener onAccountHeaderListener;
    private AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener;
    private AccountHeader.OnAccountHeaderSelectionViewClickListener onAccountHeaderSelectionViewClickListener;
    private final View.OnClickListener onCurrentProfileClickListener = new AccountHeaderBuilder$onCurrentProfileClickListener$1(this);
    private final View.OnLongClickListener onCurrentProfileLongClickListener = new AccountHeaderBuilder$onCurrentProfileLongClickListener$1(this);
    private final AccountHeaderBuilder$onDrawerItemClickListener$1 onDrawerItemClickListener = new AccountHeaderBuilder$onDrawerItemClickListener$1(this);
    private final AccountHeaderBuilder$onDrawerItemLongClickListener$1 onDrawerItemLongClickListener = new AccountHeaderBuilder$onDrawerItemLongClickListener$1(this);
    private int onProfileClickDrawerCloseDelay = 100;
    /* access modifiers changed from: private */
    public final View.OnClickListener onProfileClickListener = new AccountHeaderBuilder$onProfileClickListener$1(this);
    /* access modifiers changed from: private */
    public final View.OnLongClickListener onProfileLongClickListener = new AccountHeaderBuilder$onProfileLongClickListener$1(this);
    private final View.OnClickListener onSelectionClickListener = new AccountHeaderBuilder$onSelectionClickListener$1(this);
    private boolean onlyMainProfileImageVisible;
    private boolean onlySmallProfileImagesVisible;
    private boolean paddingBelowHeader = true;
    private IProfile<?> profileFirst;
    public BezelImageView profileFirstView;
    private boolean profileImagesClickable = true;
    private boolean profileImagesVisible = true;
    private IProfile<?> profileSecond;
    public BezelImageView profileSecondView;
    private IProfile<?> profileThird;
    public BezelImageView profileThirdView;
    private List<IProfile<?>> profiles;
    private boolean resetDrawerOnProfileListClick = true;
    private Bundle savedInstance;
    private String selectionFirstLine;
    private boolean selectionFirstLineShown = true;
    private boolean selectionListEnabled = true;
    private boolean selectionListEnabledForSingleProfile = true;
    private boolean selectionListShown;
    private String selectionSecondLine;
    private boolean selectionSecondLineShown = true;
    public Guideline statusBarGuideline;
    private ColorHolder textColor;
    private boolean threeSmallProfileImages;
    private boolean translucentStatusBar = true;
    private Typeface typeface;

    public final Guideline getStatusBarGuideline$materialdrawer() {
        Guideline guideline = this.statusBarGuideline;
        if (guideline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarGuideline");
        }
        return guideline;
    }

    public final void setStatusBarGuideline$materialdrawer(Guideline guideline) {
        Intrinsics.checkParameterIsNotNull(guideline, "<set-?>");
        this.statusBarGuideline = guideline;
    }

    public final View getAccountHeader$materialdrawer() {
        View view = this.accountHeader;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
        }
        return view;
    }

    public final void setAccountHeader$materialdrawer(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.accountHeader = view;
    }

    public final ImageView getAccountHeaderBackground$materialdrawer() {
        ImageView imageView = this.accountHeaderBackground;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderBackground");
        }
        return imageView;
    }

    public final void setAccountHeaderBackground$materialdrawer(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.accountHeaderBackground = imageView;
    }

    public final BezelImageView getCurrentProfileView$materialdrawer() {
        BezelImageView bezelImageView = this.currentProfileView;
        if (bezelImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
        }
        return bezelImageView;
    }

    public final void setCurrentProfileView$materialdrawer(BezelImageView bezelImageView) {
        Intrinsics.checkParameterIsNotNull(bezelImageView, "<set-?>");
        this.currentProfileView = bezelImageView;
    }

    public final ImageView getAccountSwitcherArrow$materialdrawer() {
        ImageView imageView = this.accountSwitcherArrow;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
        }
        return imageView;
    }

    public final void setAccountSwitcherArrow$materialdrawer(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.accountSwitcherArrow = imageView;
    }

    public final TextView getCurrentProfileName$materialdrawer() {
        TextView textView = this.currentProfileName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
        }
        return textView;
    }

    public final void setCurrentProfileName$materialdrawer(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.currentProfileName = textView;
    }

    public final TextView getCurrentProfileEmail$materialdrawer() {
        TextView textView = this.currentProfileEmail;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
        }
        return textView;
    }

    public final void setCurrentProfileEmail$materialdrawer(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.currentProfileEmail = textView;
    }

    public final BezelImageView getProfileFirstView$materialdrawer() {
        BezelImageView bezelImageView = this.profileFirstView;
        if (bezelImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileFirstView");
        }
        return bezelImageView;
    }

    public final void setProfileFirstView$materialdrawer(BezelImageView bezelImageView) {
        Intrinsics.checkParameterIsNotNull(bezelImageView, "<set-?>");
        this.profileFirstView = bezelImageView;
    }

    public final BezelImageView getProfileSecondView$materialdrawer() {
        BezelImageView bezelImageView = this.profileSecondView;
        if (bezelImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileSecondView");
        }
        return bezelImageView;
    }

    public final void setProfileSecondView$materialdrawer(BezelImageView bezelImageView) {
        Intrinsics.checkParameterIsNotNull(bezelImageView, "<set-?>");
        this.profileSecondView = bezelImageView;
    }

    public final BezelImageView getProfileThirdView$materialdrawer() {
        BezelImageView bezelImageView = this.profileThirdView;
        if (bezelImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileThirdView");
        }
        return bezelImageView;
    }

    public final void setProfileThirdView$materialdrawer(BezelImageView bezelImageView) {
        Intrinsics.checkParameterIsNotNull(bezelImageView, "<set-?>");
        this.profileThirdView = bezelImageView;
    }

    public final IProfile<?> getCurrentProfile$materialdrawer() {
        return this.currentProfile;
    }

    public final void setCurrentProfile$materialdrawer(IProfile<?> iProfile) {
        this.currentProfile = iProfile;
    }

    public final IProfile<?> getProfileFirst$materialdrawer() {
        return this.profileFirst;
    }

    public final void setProfileFirst$materialdrawer(IProfile<?> iProfile) {
        this.profileFirst = iProfile;
    }

    public final IProfile<?> getProfileSecond$materialdrawer() {
        return this.profileSecond;
    }

    public final void setProfileSecond$materialdrawer(IProfile<?> iProfile) {
        this.profileSecond = iProfile;
    }

    public final IProfile<?> getProfileThird$materialdrawer() {
        return this.profileThird;
    }

    public final void setProfileThird$materialdrawer(IProfile<?> iProfile) {
        this.profileThird = iProfile;
    }

    public final boolean getSelectionListShown$materialdrawer() {
        return this.selectionListShown;
    }

    public final void setSelectionListShown$materialdrawer(boolean z) {
        this.selectionListShown = z;
    }

    public final int getAccountHeaderTextSectionBackgroundResource$materialdrawer() {
        return this.accountHeaderTextSectionBackgroundResource;
    }

    public final void setAccountHeaderTextSectionBackgroundResource$materialdrawer(int i) {
        this.accountHeaderTextSectionBackgroundResource = i;
    }

    public final Activity getActivity$materialdrawer() {
        return this.activity;
    }

    public final void setActivity$materialdrawer(Activity activity2) {
        this.activity = activity2;
    }

    public final boolean getCompactStyle$materialdrawer() {
        return this.compactStyle;
    }

    public final void setCompactStyle$materialdrawer(boolean z) {
        this.compactStyle = z;
    }

    public final Typeface getTypeface$materialdrawer() {
        return this.typeface;
    }

    public final void setTypeface$materialdrawer(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public final Typeface getNameTypeface$materialdrawer() {
        return this.nameTypeface;
    }

    public final void setNameTypeface$materialdrawer(Typeface typeface2) {
        this.nameTypeface = typeface2;
    }

    public final Typeface getEmailTypeface$materialdrawer() {
        return this.emailTypeface;
    }

    public final void setEmailTypeface$materialdrawer(Typeface typeface2) {
        this.emailTypeface = typeface2;
    }

    public final DimenHolder getHeight$materialdrawer() {
        return this.height;
    }

    public final void setHeight$materialdrawer(DimenHolder dimenHolder) {
        this.height = dimenHolder;
    }

    public final ColorHolder getTextColor$materialdrawer() {
        return this.textColor;
    }

    public final void setTextColor$materialdrawer(ColorHolder colorHolder) {
        this.textColor = colorHolder;
    }

    public final boolean getCurrentHiddenInList$materialdrawer() {
        return this.currentHiddenInList;
    }

    public final void setCurrentHiddenInList$materialdrawer(boolean z) {
        this.currentHiddenInList = z;
    }

    public final boolean getSelectionFirstLineShown$materialdrawer() {
        return this.selectionFirstLineShown;
    }

    public final void setSelectionFirstLineShown$materialdrawer(boolean z) {
        this.selectionFirstLineShown = z;
    }

    public final boolean getSelectionSecondLineShown$materialdrawer() {
        return this.selectionSecondLineShown;
    }

    public final void setSelectionSecondLineShown$materialdrawer(boolean z) {
        this.selectionSecondLineShown = z;
    }

    public final String getSelectionFirstLine$materialdrawer() {
        return this.selectionFirstLine;
    }

    public final void setSelectionFirstLine$materialdrawer(String str) {
        this.selectionFirstLine = str;
    }

    public final String getSelectionSecondLine$materialdrawer() {
        return this.selectionSecondLine;
    }

    public final void setSelectionSecondLine$materialdrawer(String str) {
        this.selectionSecondLine = str;
    }

    public final boolean getPaddingBelowHeader() {
        return this.paddingBelowHeader;
    }

    public final void setPaddingBelowHeader(boolean z) {
        this.paddingBelowHeader = z;
    }

    public final boolean getDividerBelowHeader() {
        return this.dividerBelowHeader;
    }

    public final void setDividerBelowHeader(boolean z) {
        this.dividerBelowHeader = z;
    }

    public final boolean getTranslucentStatusBar$materialdrawer() {
        return this.translucentStatusBar;
    }

    public final void setTranslucentStatusBar$materialdrawer(boolean z) {
        this.translucentStatusBar = z;
    }

    public final ImageHolder getHeaderBackground$materialdrawer() {
        return this.headerBackground;
    }

    public final void setHeaderBackground$materialdrawer(ImageHolder imageHolder) {
        this.headerBackground = imageHolder;
    }

    public final ImageView.ScaleType getHeaderBackgroundScaleType$materialdrawer() {
        return this.headerBackgroundScaleType;
    }

    public final void setHeaderBackgroundScaleType$materialdrawer(ImageView.ScaleType scaleType) {
        this.headerBackgroundScaleType = scaleType;
    }

    public final boolean getProfileImagesVisible() {
        return this.profileImagesVisible;
    }

    public final void setProfileImagesVisible(boolean z) {
        this.profileImagesVisible = z;
    }

    public final boolean getOnlyMainProfileImageVisible$materialdrawer() {
        return this.onlyMainProfileImageVisible;
    }

    public final void setOnlyMainProfileImageVisible$materialdrawer(boolean z) {
        this.onlyMainProfileImageVisible = z;
    }

    public final boolean getOnlySmallProfileImagesVisible$materialdrawer() {
        return this.onlySmallProfileImagesVisible;
    }

    public final void setOnlySmallProfileImagesVisible$materialdrawer(boolean z) {
        this.onlySmallProfileImagesVisible = z;
    }

    public final Boolean getCloseDrawerOnProfileListClick$materialdrawer() {
        return this.closeDrawerOnProfileListClick;
    }

    public final void setCloseDrawerOnProfileListClick$materialdrawer(Boolean bool) {
        this.closeDrawerOnProfileListClick = bool;
    }

    public final boolean getResetDrawerOnProfileListClick$materialdrawer() {
        return this.resetDrawerOnProfileListClick;
    }

    public final void setResetDrawerOnProfileListClick$materialdrawer(boolean z) {
        this.resetDrawerOnProfileListClick = z;
    }

    public final boolean getProfileImagesClickable$materialdrawer() {
        return this.profileImagesClickable;
    }

    public final void setProfileImagesClickable$materialdrawer(boolean z) {
        this.profileImagesClickable = z;
    }

    public final boolean getAlternativeProfileHeaderSwitching$materialdrawer() {
        return this.alternativeProfileHeaderSwitching;
    }

    public final void setAlternativeProfileHeaderSwitching$materialdrawer(boolean z) {
        this.alternativeProfileHeaderSwitching = z;
    }

    public final boolean getThreeSmallProfileImages$materialdrawer() {
        return this.threeSmallProfileImages;
    }

    public final void setThreeSmallProfileImages$materialdrawer(boolean z) {
        this.threeSmallProfileImages = z;
    }

    public final int getOnProfileClickDrawerCloseDelay$materialdrawer() {
        return this.onProfileClickDrawerCloseDelay;
    }

    public final void setOnProfileClickDrawerCloseDelay$materialdrawer(int i) {
        this.onProfileClickDrawerCloseDelay = i;
    }

    public final AccountHeader.OnAccountHeaderProfileImageListener getOnAccountHeaderProfileImageListener$materialdrawer() {
        return this.onAccountHeaderProfileImageListener;
    }

    public final void setOnAccountHeaderProfileImageListener$materialdrawer(AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener2) {
        this.onAccountHeaderProfileImageListener = onAccountHeaderProfileImageListener2;
    }

    public final AccountHeader.OnAccountHeaderSelectionViewClickListener getOnAccountHeaderSelectionViewClickListener$materialdrawer() {
        return this.onAccountHeaderSelectionViewClickListener;
    }

    public final void setOnAccountHeaderSelectionViewClickListener$materialdrawer(AccountHeader.OnAccountHeaderSelectionViewClickListener onAccountHeaderSelectionViewClickListener2) {
        this.onAccountHeaderSelectionViewClickListener = onAccountHeaderSelectionViewClickListener2;
    }

    public final boolean getSelectionListEnabledForSingleProfile$materialdrawer() {
        return this.selectionListEnabledForSingleProfile;
    }

    public final void setSelectionListEnabledForSingleProfile$materialdrawer(boolean z) {
        this.selectionListEnabledForSingleProfile = z;
    }

    public final boolean getSelectionListEnabled$materialdrawer() {
        return this.selectionListEnabled;
    }

    public final void setSelectionListEnabled$materialdrawer(boolean z) {
        this.selectionListEnabled = z;
    }

    public final View getAccountHeaderContainer$materialdrawer() {
        View view = this.accountHeaderContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
        }
        return view;
    }

    public final void setAccountHeaderContainer$materialdrawer(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.accountHeaderContainer = view;
    }

    public final List<IProfile<?>> getProfiles$materialdrawer() {
        return this.profiles;
    }

    public final void setProfiles$materialdrawer(List<IProfile<?>> list) {
        this.profiles = list;
    }

    public final AccountHeader.OnAccountHeaderListener getOnAccountHeaderListener$materialdrawer() {
        return this.onAccountHeaderListener;
    }

    public final void setOnAccountHeaderListener$materialdrawer(AccountHeader.OnAccountHeaderListener onAccountHeaderListener2) {
        this.onAccountHeaderListener = onAccountHeaderListener2;
    }

    public final AccountHeader.OnAccountHeaderItemLongClickListener getOnAccountHeaderItemLongClickListener$materialdrawer() {
        return this.onAccountHeaderItemLongClickListener;
    }

    public final void setOnAccountHeaderItemLongClickListener$materialdrawer(AccountHeader.OnAccountHeaderItemLongClickListener onAccountHeaderItemLongClickListener2) {
        this.onAccountHeaderItemLongClickListener = onAccountHeaderItemLongClickListener2;
    }

    public final Drawer getDrawer$materialdrawer() {
        return this.drawer;
    }

    public final void setDrawer$materialdrawer(Drawer drawer2) {
        this.drawer = drawer2;
    }

    public final Bundle getSavedInstance$materialdrawer() {
        return this.savedInstance;
    }

    public final void setSavedInstance$materialdrawer(Bundle bundle) {
        this.savedInstance = bundle;
    }

    public final int getCurrentSelection$materialdrawer() {
        IProfile mCurrentProfile;
        List<IProfile> mProfiles = this.profiles;
        if (mProfiles == null || (mCurrentProfile = this.currentProfile) == null) {
            return -1;
        }
        int i = 0;
        for (IProfile profile : mProfiles) {
            if (profile == mCurrentProfile) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final AccountHeaderBuilder withActivity(Activity activity2) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        this.activity = activity2;
        return this;
    }

    public final AccountHeaderBuilder withCompactStyle(boolean compactStyle2) {
        this.compactStyle = compactStyle2;
        return this;
    }

    public final AccountHeaderBuilder withTypeface(Typeface typeface2) {
        Intrinsics.checkParameterIsNotNull(typeface2, "typeface");
        this.typeface = typeface2;
        return this;
    }

    public final AccountHeaderBuilder withNameTypeface(Typeface typeface2) {
        Intrinsics.checkParameterIsNotNull(typeface2, "typeface");
        this.nameTypeface = typeface2;
        return this;
    }

    public final AccountHeaderBuilder withEmailTypeface(Typeface typeface2) {
        Intrinsics.checkParameterIsNotNull(typeface2, "typeface");
        this.emailTypeface = typeface2;
        return this;
    }

    public final AccountHeaderBuilder withHeightPx(int heightPx) {
        this.height = DimenHolder.Companion.fromPixel(heightPx);
        return this;
    }

    public final AccountHeaderBuilder withHeightDp(int heightDp) {
        this.height = DimenHolder.Companion.fromDp(heightDp);
        return this;
    }

    public final AccountHeaderBuilder withHeightRes(int heightRes) {
        this.height = DimenHolder.Companion.fromResource(heightRes);
        return this;
    }

    public final AccountHeaderBuilder withTextColor(int textColor2) {
        this.textColor = ColorHolder.Companion.fromColor(textColor2);
        return this;
    }

    public final AccountHeaderBuilder withTextColorRes(int textColorRes) {
        this.textColor = ColorHolder.Companion.fromColorRes(textColorRes);
        return this;
    }

    public final AccountHeaderBuilder withCurrentProfileHiddenInList(boolean currentProfileHiddenInList) {
        this.currentHiddenInList = currentProfileHiddenInList;
        return this;
    }

    @Deprecated(message = "replaced by {@link #withSelectionFirstLineShown}")
    public final AccountHeaderBuilder withSelectionFistLineShown(boolean selectionFirstLineShown2) {
        this.selectionFirstLineShown = selectionFirstLineShown2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionFirstLineShown(boolean selectionFirstLineShown2) {
        this.selectionFirstLineShown = selectionFirstLineShown2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionSecondLineShown(boolean selectionSecondLineShown2) {
        this.selectionSecondLineShown = selectionSecondLineShown2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionFirstLine(String selectionFirstLine2) {
        Intrinsics.checkParameterIsNotNull(selectionFirstLine2, "selectionFirstLine");
        this.selectionFirstLine = selectionFirstLine2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionSecondLine(String selectionSecondLine2) {
        Intrinsics.checkParameterIsNotNull(selectionSecondLine2, "selectionSecondLine");
        this.selectionSecondLine = selectionSecondLine2;
        return this;
    }

    public final AccountHeaderBuilder withPaddingBelowHeader(boolean paddingBelowHeader2) {
        this.paddingBelowHeader = paddingBelowHeader2;
        return this;
    }

    public final AccountHeaderBuilder withDividerBelowHeader(boolean dividerBelowHeader2) {
        this.dividerBelowHeader = dividerBelowHeader2;
        return this;
    }

    public final AccountHeaderBuilder withTranslucentStatusBar(boolean translucentStatusBar2) {
        this.translucentStatusBar = translucentStatusBar2;
        return this;
    }

    public final AccountHeaderBuilder withHeaderBackground(Drawable headerBackground2) {
        Intrinsics.checkParameterIsNotNull(headerBackground2, "headerBackground");
        this.headerBackground = new ImageHolder(headerBackground2);
        return this;
    }

    public final AccountHeaderBuilder withHeaderBackground(int headerBackgroundRes) {
        this.headerBackground = new ImageHolder(headerBackgroundRes);
        return this;
    }

    public final AccountHeaderBuilder withHeaderBackground(ImageHolder headerBackground2) {
        Intrinsics.checkParameterIsNotNull(headerBackground2, "headerBackground");
        this.headerBackground = headerBackground2;
        return this;
    }

    public final AccountHeaderBuilder withHeaderBackgroundScaleType(ImageView.ScaleType headerBackgroundScaleType2) {
        Intrinsics.checkParameterIsNotNull(headerBackgroundScaleType2, "headerBackgroundScaleType");
        this.headerBackgroundScaleType = headerBackgroundScaleType2;
        return this;
    }

    public final AccountHeaderBuilder withProfileImagesVisible(boolean profileImagesVisible2) {
        this.profileImagesVisible = profileImagesVisible2;
        return this;
    }

    public final AccountHeaderBuilder withOnlyMainProfileImageVisible(boolean onlyMainProfileImageVisible2) {
        this.onlyMainProfileImageVisible = onlyMainProfileImageVisible2;
        return this;
    }

    public final AccountHeaderBuilder withOnlySmallProfileImagesVisible(boolean onlySmallProfileImagesVisible2) {
        this.onlySmallProfileImagesVisible = onlySmallProfileImagesVisible2;
        return this;
    }

    public final AccountHeaderBuilder withCloseDrawerOnProfileListClick(boolean closeDrawerOnProfileListClick2) {
        this.closeDrawerOnProfileListClick = Boolean.valueOf(closeDrawerOnProfileListClick2);
        return this;
    }

    public final AccountHeaderBuilder withResetDrawerOnProfileListClick(boolean resetDrawerOnProfileListClick2) {
        this.resetDrawerOnProfileListClick = resetDrawerOnProfileListClick2;
        return this;
    }

    public final AccountHeaderBuilder withProfileImagesClickable(boolean profileImagesClickable2) {
        this.profileImagesClickable = profileImagesClickable2;
        return this;
    }

    public final AccountHeaderBuilder withAlternativeProfileHeaderSwitching(boolean alternativeProfileHeaderSwitching2) {
        this.alternativeProfileHeaderSwitching = alternativeProfileHeaderSwitching2;
        return this;
    }

    public final AccountHeaderBuilder withThreeSmallProfileImages(boolean threeSmallProfileImages2) {
        this.threeSmallProfileImages = threeSmallProfileImages2;
        return this;
    }

    public final AccountHeaderBuilder withOnProfileClickDrawerCloseDelay(int onProfileClickDrawerCloseDelay2) {
        this.onProfileClickDrawerCloseDelay = onProfileClickDrawerCloseDelay2;
        return this;
    }

    public final AccountHeaderBuilder withOnAccountHeaderProfileImageListener(AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener2) {
        Intrinsics.checkParameterIsNotNull(onAccountHeaderProfileImageListener2, "onAccountHeaderProfileImageListener");
        this.onAccountHeaderProfileImageListener = onAccountHeaderProfileImageListener2;
        return this;
    }

    public final AccountHeaderBuilder withOnAccountHeaderSelectionViewClickListener(AccountHeader.OnAccountHeaderSelectionViewClickListener onAccountHeaderSelectionViewClickListener2) {
        Intrinsics.checkParameterIsNotNull(onAccountHeaderSelectionViewClickListener2, "onAccountHeaderSelectionViewClickListener");
        this.onAccountHeaderSelectionViewClickListener = onAccountHeaderSelectionViewClickListener2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionListEnabledForSingleProfile(boolean selectionListEnabledForSingleProfile2) {
        this.selectionListEnabledForSingleProfile = selectionListEnabledForSingleProfile2;
        return this;
    }

    public final AccountHeaderBuilder withSelectionListEnabled(boolean selectionListEnabled2) {
        this.selectionListEnabled = selectionListEnabled2;
        return this;
    }

    public final AccountHeaderBuilder withAccountHeader(View accountHeader2) {
        Intrinsics.checkParameterIsNotNull(accountHeader2, "accountHeader");
        this.accountHeaderContainer = accountHeader2;
        return this;
    }

    public final AccountHeaderBuilder withAccountHeader(int resLayout) {
        Activity it = this.activity;
        if (it != null) {
            if (it != null) {
                if (resLayout != -1) {
                    View inflate = it.getLayoutInflater().inflate(resLayout, (ViewGroup) null, false);
                    Intrinsics.checkExpressionValueIsNotNull(inflate, "it.layoutInflater.inflate(resLayout, null, false)");
                    this.accountHeaderContainer = inflate;
                } else if (this.compactStyle) {
                    View inflate2 = it.getLayoutInflater().inflate(R.layout.material_drawer_compact_header, (ViewGroup) null, false);
                    Intrinsics.checkExpressionValueIsNotNull(inflate2, "it.layoutInflater.inflat…pact_header, null, false)");
                    this.accountHeaderContainer = inflate2;
                } else {
                    View inflate3 = it.getLayoutInflater().inflate(R.layout.material_drawer_header, (ViewGroup) null, false);
                    Intrinsics.checkExpressionValueIsNotNull(inflate3, "it.layoutInflater.inflat…awer_header, null, false)");
                    this.accountHeaderContainer = inflate3;
                }
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final AccountHeaderBuilder withProfiles(List<IProfile<?>> profiles2) {
        DrawerBuilder drawerBuilder$materialdrawer;
        DefaultIdDistributor<IIdentifyable> idDistributor;
        Intrinsics.checkParameterIsNotNull(profiles2, "profiles");
        Drawer drawer2 = this.drawer;
        if (!(drawer2 == null || (drawerBuilder$materialdrawer = drawer2.getDrawerBuilder$materialdrawer()) == null || (idDistributor = drawerBuilder$materialdrawer.getIdDistributor()) == null)) {
            idDistributor.checkIds((List<? extends IIdentifyable>) profiles2);
        }
        this.profiles = profiles2;
        return this;
    }

    public final AccountHeaderBuilder addProfiles(IProfile<?>... profiles2) {
        DrawerBuilder drawerBuilder$materialdrawer;
        DefaultIdDistributor<IIdentifyable> idDistributor;
        Intrinsics.checkParameterIsNotNull(profiles2, "profiles");
        if (this.profiles == null) {
            this.profiles = new ArrayList();
        }
        List it = this.profiles;
        if (it != null) {
            Drawer drawer2 = this.drawer;
            if (!(drawer2 == null || (drawerBuilder$materialdrawer = drawer2.getDrawerBuilder$materialdrawer()) == null || (idDistributor = drawerBuilder$materialdrawer.getIdDistributor()) == null)) {
                IIdentifyable[] iIdentifyableArr = (IIdentifyable[]) profiles2;
                idDistributor.checkIds((Identifiable[]) (IIdentifyable[]) Arrays.copyOf(iIdentifyableArr, iIdentifyableArr.length));
            }
            Collections.addAll(it, (IProfile[]) Arrays.copyOf(profiles2, profiles2.length));
        }
        return this;
    }

    public final AccountHeaderBuilder withOnAccountHeaderListener(AccountHeader.OnAccountHeaderListener onAccountHeaderListener2) {
        Intrinsics.checkParameterIsNotNull(onAccountHeaderListener2, "onAccountHeaderListener");
        this.onAccountHeaderListener = onAccountHeaderListener2;
        return this;
    }

    public final AccountHeaderBuilder withOnAccountHeaderItemLongClickListener(AccountHeader.OnAccountHeaderItemLongClickListener onAccountHeaderItemLongClickListener2) {
        Intrinsics.checkParameterIsNotNull(onAccountHeaderItemLongClickListener2, "onAccountHeaderItemLongClickListener");
        this.onAccountHeaderItemLongClickListener = onAccountHeaderItemLongClickListener2;
        return this;
    }

    public final AccountHeaderBuilder withDrawer(Drawer drawer2) {
        Intrinsics.checkParameterIsNotNull(drawer2, "drawer");
        this.drawer = drawer2;
        drawer2.getRecyclerView().setPadding(drawer2.getRecyclerView().getPaddingLeft(), 0, drawer2.getRecyclerView().getPaddingRight(), drawer2.getRecyclerView().getPaddingBottom());
        return this;
    }

    public final AccountHeaderBuilder withSavedInstance(Bundle savedInstance2) {
        this.savedInstance = savedInstance2;
        return this;
    }

    private final void setHeaderHeight(int height2) {
        ViewGroup.LayoutParams p;
        View view = this.accountHeaderContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
        }
        ViewGroup.LayoutParams it = view.getLayoutParams();
        if (it != null) {
            it.height = height2;
            View view2 = this.accountHeaderContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            view2.setLayoutParams(it);
        }
        View view3 = this.accountHeaderContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
        }
        View accountHeader2 = view3.findViewById(R.id.material_drawer_account_header);
        if (!(accountHeader2 == null || (p = accountHeader2.getLayoutParams()) == null)) {
            p.height = height2;
            accountHeader2.setLayoutParams(p);
        }
        View view4 = this.accountHeaderContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
        }
        View accountHeaderBackground2 = view4.findViewById(R.id.material_drawer_account_header_background);
        if (accountHeaderBackground2 != null) {
            ViewGroup.LayoutParams p2 = accountHeaderBackground2.getLayoutParams();
            p2.height = height2;
            accountHeaderBackground2.setLayoutParams(p2);
        }
    }

    private final void handleSelectionView(IProfile<?> profile, boolean on) {
        if (on) {
            if (Build.VERSION.SDK_INT >= 23) {
                View view = this.accountHeaderContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
                }
                View view2 = this.accountHeaderContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
                }
                view.setForeground(AppCompatResources.getDrawable(view2.getContext(), this.accountHeaderTextSectionBackgroundResource));
            }
            View view3 = this.accountHeaderContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            view3.setOnClickListener(this.onSelectionClickListener);
            View view4 = this.accountHeaderContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            view4.setTag(R.id.material_drawer_profile_header, profile);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            View view5 = this.accountHeaderContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            view5.setForeground((Drawable) null);
        }
        View view6 = this.accountHeaderContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
        }
        view6.setOnClickListener((View.OnClickListener) null);
    }

    public AccountHeader build() {
        int height2;
        int selection;
        List it;
        Activity activity2 = this.activity;
        if (activity2 != null) {
            if (this.accountHeaderContainer == null) {
                withAccountHeader(-1);
            }
            View view = this.accountHeaderContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            View findViewById = view.findViewById(R.id.material_drawer_account_header);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "accountHeaderContainer.f…al_drawer_account_header)");
            this.accountHeader = findViewById;
            View view2 = this.accountHeaderContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            View findViewById2 = view2.findViewById(R.id.material_drawer_statusbar_guideline);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "accountHeaderContainer.f…awer_statusbar_guideline)");
            this.statusBarGuideline = (Guideline) findViewById2;
            int defaultHeaderMinHeight = activity2.getResources().getDimensionPixelSize(R.dimen.material_drawer_account_header_height);
            int statusBarHeight = UIUtils.getStatusBarHeight(activity2, true);
            DimenHolder it2 = this.height;
            if (it2 != null) {
                height2 = it2.asPixel(activity2);
            } else if (this.compactStyle) {
                height2 = activity2.getResources().getDimensionPixelSize(R.dimen.material_drawer_account_header_height_compact);
            } else {
                height2 = (int) (((double) DrawerUIUtils.INSTANCE.getOptimalDrawerWidth(activity2)) * 0.5625d);
                if (Build.VERSION.SDK_INT < 19) {
                    int tempHeight = height2 - statusBarHeight;
                    if (((float) tempHeight) > ((float) defaultHeaderMinHeight) - UIUtils.convertDpToPixel(8.0f, activity2)) {
                        height2 = tempHeight;
                    }
                }
            }
            if (this.translucentStatusBar && Build.VERSION.SDK_INT >= 21) {
                Guideline guideline = this.statusBarGuideline;
                if (guideline == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusBarGuideline");
                }
                guideline.setGuidelineBegin(statusBarHeight);
                if (this.compactStyle) {
                    height2 += statusBarHeight;
                } else if (height2 - statusBarHeight <= defaultHeaderMinHeight) {
                    height2 = defaultHeaderMinHeight + statusBarHeight;
                }
            }
            setHeaderHeight(height2);
            View view3 = this.accountHeaderContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            View findViewById3 = view3.findViewById(R.id.material_drawer_account_header_background);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "accountHeaderContainer.f…ccount_header_background)");
            ImageView imageView = (ImageView) findViewById3;
            this.accountHeaderBackground = imageView;
            ImageHolder imageHolder = this.headerBackground;
            if (imageHolder != null) {
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountHeaderBackground");
                }
                imageHolder.applyTo(imageView, DrawerImageLoader.Tags.ACCOUNT_HEADER.name());
            }
            if (this.headerBackgroundScaleType != null) {
                ImageView imageView2 = this.accountHeaderBackground;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountHeaderBackground");
                }
                imageView2.setScaleType(this.headerBackgroundScaleType);
            }
            int textColor2 = ColorHolderKt.applyColor(this.textColor, activity2, R.attr.material_drawer_header_selection_text, R.color.material_drawer_header_selection_text);
            int subTextColor = ColorHolderKt.applyColor(this.textColor, activity2, R.attr.material_drawer_header_selection_subtext, R.color.material_drawer_header_selection_subtext);
            this.accountHeaderTextSectionBackgroundResource = UIUtils.getSelectableBackgroundRes(activity2);
            handleSelectionView(this.currentProfile, true);
            View view4 = this.accountHeaderContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
            }
            View findViewById4 = view4.findViewById(R.id.material_drawer_account_header_text_switcher);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "accountHeaderContainer.f…unt_header_text_switcher)");
            ImageView imageView3 = (ImageView) findViewById4;
            this.accountSwitcherArrow = imageView3;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
            }
            imageView3.setImageDrawable(new IconicsDrawable((Context) activity2, (IIcon) MaterialDrawerFont.Icon.mdf_arrow_drop_down).size(IconicsSize.Companion.res(R.dimen.material_drawer_account_header_dropdown)).padding(IconicsSize.Companion.res(R.dimen.material_drawer_account_header_dropdown_padding)).color(IconicsColor.Companion.colorInt(subTextColor)));
            View view5 = this.accountHeader;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById5 = view5.findViewById(R.id.material_drawer_account_header_current);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "accountHeader.findViewBy…r_account_header_current)");
            this.currentProfileView = (BezelImageView) findViewById5;
            View view6 = this.accountHeader;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById6 = view6.findViewById(R.id.material_drawer_account_header_name);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "accountHeader.findViewBy…awer_account_header_name)");
            this.currentProfileName = (TextView) findViewById6;
            View view7 = this.accountHeader;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById7 = view7.findViewById(R.id.material_drawer_account_header_email);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "accountHeader.findViewBy…wer_account_header_email)");
            this.currentProfileEmail = (TextView) findViewById7;
            if (this.nameTypeface != null) {
                TextView textView = this.currentProfileName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
                }
                textView.setTypeface(this.nameTypeface);
            } else if (this.typeface != null) {
                TextView textView2 = this.currentProfileName;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
                }
                textView2.setTypeface(this.typeface);
            }
            if (this.emailTypeface != null) {
                TextView textView3 = this.currentProfileEmail;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
                }
                textView3.setTypeface(this.emailTypeface);
            } else if (this.typeface != null) {
                TextView textView4 = this.currentProfileEmail;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
                }
                textView4.setTypeface(this.typeface);
            }
            TextView textView5 = this.currentProfileName;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
            }
            textView5.setTextColor(textColor2);
            TextView textView6 = this.currentProfileEmail;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
            }
            textView6.setTextColor(subTextColor);
            View view8 = this.accountHeader;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById8 = view8.findViewById(R.id.material_drawer_account_header_small_first);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "accountHeader.findViewBy…count_header_small_first)");
            this.profileFirstView = (BezelImageView) findViewById8;
            View view9 = this.accountHeader;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById9 = view9.findViewById(R.id.material_drawer_account_header_small_second);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "accountHeader.findViewBy…ount_header_small_second)");
            this.profileSecondView = (BezelImageView) findViewById9;
            View view10 = this.accountHeader;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            View findViewById10 = view10.findViewById(R.id.material_drawer_account_header_small_third);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "accountHeader.findViewBy…count_header_small_third)");
            this.profileThirdView = (BezelImageView) findViewById10;
            calculateProfiles$materialdrawer();
            buildProfiles$materialdrawer();
            Bundle savedInstance2 = this.savedInstance;
            if (!(savedInstance2 == null || (selection = savedInstance2.getInt(AccountHeader.BUNDLE_SELECTION_HEADER, -1)) == -1 || (it = this.profiles) == null || selection <= -1 || selection >= it.size())) {
                switchProfiles$materialdrawer(it.get(selection));
            }
            Drawer $this$apply = this.drawer;
            if ($this$apply != null) {
                View view11 = this.accountHeaderContainer;
                if (view11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountHeaderContainer");
                }
                Drawer.setHeader$default($this$apply, view11, this.paddingBelowHeader, this.dividerBelowHeader, (DimenHolder) null, 8, (Object) null);
            }
            this.activity = null;
            return new AccountHeader(this);
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final void calculateProfiles$materialdrawer() {
        if (this.profiles == null) {
            this.profiles = new ArrayList();
        }
        List mProfiles = this.profiles;
        if (mProfiles != null) {
            IProfile<?> iProfile = this.currentProfile;
            int i = 0;
            if (iProfile == null) {
                int setCount = 0;
                int size = mProfiles.size();
                while (i < size) {
                    if (mProfiles.size() > i && mProfiles.get(i).isSelectable()) {
                        if (setCount == 0 && this.currentProfile == null) {
                            this.currentProfile = mProfiles.get(i);
                        } else if (setCount == 1 && this.profileFirst == null) {
                            this.profileFirst = mProfiles.get(i);
                        } else if (setCount == 2 && this.profileSecond == null) {
                            this.profileSecond = mProfiles.get(i);
                        } else if (setCount == 3 && this.profileThird == null) {
                            this.profileThird = mProfiles.get(i);
                        }
                        setCount++;
                    }
                    i++;
                }
                return;
            }
            IProfile[] previousActiveProfiles = {iProfile, this.profileFirst, this.profileSecond, this.profileThird};
            IProfile[] newActiveProfiles = new IProfile[4];
            Stack unusedProfiles = new Stack();
            int size2 = mProfiles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                IProfile p = mProfiles.get(i2);
                if (p.isSelectable()) {
                    boolean used = false;
                    int j = 0;
                    while (true) {
                        if (j > 3) {
                            break;
                        } else if (previousActiveProfiles[j] == p) {
                            newActiveProfiles[j] = p;
                            used = true;
                            break;
                        } else {
                            j++;
                        }
                    }
                    if (!used) {
                        unusedProfiles.push(p);
                    }
                }
            }
            Stack activeProfiles = new Stack();
            while (i <= 3) {
                if (newActiveProfiles[i] != null) {
                    activeProfiles.push(newActiveProfiles[i]);
                } else if (!unusedProfiles.isEmpty()) {
                    activeProfiles.push(unusedProfiles.pop());
                }
                i++;
            }
            Stack reversedActiveProfiles = new Stack();
            while (!activeProfiles.empty()) {
                reversedActiveProfiles.push(activeProfiles.pop());
            }
            if (reversedActiveProfiles.isEmpty()) {
                this.currentProfile = null;
            } else {
                this.currentProfile = (IProfile) reversedActiveProfiles.pop();
            }
            if (reversedActiveProfiles.isEmpty()) {
                this.profileFirst = null;
            } else {
                this.profileFirst = (IProfile) reversedActiveProfiles.pop();
            }
            if (reversedActiveProfiles.isEmpty()) {
                this.profileSecond = null;
            } else {
                this.profileSecond = (IProfile) reversedActiveProfiles.pop();
            }
            if (reversedActiveProfiles.isEmpty()) {
                this.profileThird = null;
            } else {
                this.profileThird = (IProfile) reversedActiveProfiles.pop();
            }
        }
    }

    public final boolean switchProfiles$materialdrawer(IProfile<?> newSelection) {
        if (newSelection == null) {
            return false;
        }
        if (this.currentProfile == newSelection) {
            return true;
        }
        if (this.alternativeProfileHeaderSwitching) {
            int prevSelection = -1;
            if (this.profileFirst == newSelection) {
                prevSelection = 1;
            } else if (this.profileSecond == newSelection) {
                prevSelection = 2;
            } else if (this.profileThird == newSelection) {
                prevSelection = 3;
            }
            IProfile tmp = this.currentProfile;
            this.currentProfile = newSelection;
            if (prevSelection == 1) {
                this.profileFirst = tmp;
            } else if (prevSelection == 2) {
                this.profileSecond = tmp;
            } else if (prevSelection == 3) {
                this.profileThird = tmp;
            }
        } else if (this.profiles != null) {
            ArrayList previousActiveProfiles = new ArrayList(Arrays.asList(new IProfile[]{this.currentProfile, this.profileFirst, this.profileSecond, this.profileThird}));
            if (previousActiveProfiles.contains(newSelection)) {
                int position = -1;
                int i = 0;
                while (true) {
                    if (i > 3) {
                        break;
                    } else if (((IProfile) previousActiveProfiles.get(i)) == newSelection) {
                        position = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (position != -1) {
                    previousActiveProfiles.remove(position);
                    previousActiveProfiles.add(0, newSelection);
                    this.currentProfile = (IProfile) previousActiveProfiles.get(0);
                    this.profileFirst = (IProfile) previousActiveProfiles.get(1);
                    this.profileSecond = (IProfile) previousActiveProfiles.get(2);
                    this.profileThird = (IProfile) previousActiveProfiles.get(3);
                }
            } else {
                this.profileThird = this.profileSecond;
                this.profileSecond = this.profileFirst;
                this.profileFirst = this.currentProfile;
                this.currentProfile = newSelection;
            }
        }
        if (this.onlySmallProfileImagesVisible) {
            this.profileThird = this.profileSecond;
            this.profileSecond = this.profileFirst;
            this.profileFirst = this.currentProfile;
        }
        buildProfiles$materialdrawer();
        return false;
    }

    public final void buildProfiles$materialdrawer() {
        CharSequence charSequence;
        BezelImageView bezelImageView = this.currentProfileView;
        if (bezelImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
        }
        bezelImageView.setVisibility(8);
        ImageView imageView = this.accountSwitcherArrow;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
        }
        imageView.setVisibility(8);
        BezelImageView bezelImageView2 = this.profileFirstView;
        if (bezelImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileFirstView");
        }
        bezelImageView2.setVisibility(8);
        BezelImageView bezelImageView3 = this.profileFirstView;
        if (bezelImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileFirstView");
        }
        bezelImageView3.setOnClickListener((View.OnClickListener) null);
        BezelImageView bezelImageView4 = this.profileSecondView;
        if (bezelImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileSecondView");
        }
        bezelImageView4.setVisibility(8);
        BezelImageView bezelImageView5 = this.profileSecondView;
        if (bezelImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileSecondView");
        }
        bezelImageView5.setOnClickListener((View.OnClickListener) null);
        BezelImageView bezelImageView6 = this.profileThirdView;
        if (bezelImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileThirdView");
        }
        bezelImageView6.setVisibility(8);
        BezelImageView bezelImageView7 = this.profileThirdView;
        if (bezelImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileThirdView");
        }
        bezelImageView7.setOnClickListener((View.OnClickListener) null);
        TextView textView = this.currentProfileName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
        }
        textView.setText("");
        TextView textView2 = this.currentProfileEmail;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
        }
        textView2.setText("");
        handleSelectionView(this.currentProfile, true);
        IProfile mCurrentProfile = this.currentProfile;
        List mProfiles = this.profiles;
        if (mCurrentProfile != null) {
            if ((this.profileImagesVisible || this.onlyMainProfileImageVisible) && !this.onlySmallProfileImagesVisible) {
                BezelImageView bezelImageView8 = this.currentProfileView;
                if (bezelImageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                }
                StringHolder email = mCurrentProfile.getEmail();
                if (email == null || (charSequence = email.getText()) == null) {
                    StringHolder name = mCurrentProfile.getName();
                    charSequence = name != null ? name.getText() : null;
                }
                if (charSequence == null) {
                    BezelImageView bezelImageView9 = this.currentProfileView;
                    if (bezelImageView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                    }
                    charSequence = bezelImageView9.getContext().getString(R.string.material_drawer_profile_content_description);
                }
                bezelImageView8.setContentDescription(charSequence);
                BezelImageView bezelImageView10 = this.currentProfileView;
                if (bezelImageView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                }
                setImageOrPlaceholder(bezelImageView10, mCurrentProfile.getIcon());
                if (this.profileImagesClickable) {
                    BezelImageView bezelImageView11 = this.currentProfileView;
                    if (bezelImageView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                    }
                    bezelImageView11.setOnClickListener(this.onCurrentProfileClickListener);
                    BezelImageView bezelImageView12 = this.currentProfileView;
                    if (bezelImageView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                    }
                    bezelImageView12.setOnLongClickListener(this.onCurrentProfileLongClickListener);
                    BezelImageView bezelImageView13 = this.currentProfileView;
                    if (bezelImageView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                    }
                    bezelImageView13.disableTouchFeedback(false);
                } else {
                    BezelImageView bezelImageView14 = this.currentProfileView;
                    if (bezelImageView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                    }
                    bezelImageView14.disableTouchFeedback(true);
                }
                BezelImageView bezelImageView15 = this.currentProfileView;
                if (bezelImageView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                }
                bezelImageView15.setVisibility(0);
                BezelImageView bezelImageView16 = this.currentProfileView;
                if (bezelImageView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                }
                bezelImageView16.invalidate();
            } else if (this.compactStyle) {
                BezelImageView bezelImageView17 = this.currentProfileView;
                if (bezelImageView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
                }
                bezelImageView17.setVisibility(8);
            }
            handleSelectionView(mCurrentProfile, true);
            ImageView imageView2 = this.accountSwitcherArrow;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
            }
            imageView2.setVisibility(0);
            BezelImageView bezelImageView18 = this.currentProfileView;
            if (bezelImageView18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileView");
            }
            bezelImageView18.setTag(R.id.material_drawer_profile_header, mCurrentProfile);
            StringHolder.Companion companion = StringHolder.Companion;
            com.mikepenz.materialize.holder.StringHolder name2 = mCurrentProfile.getName();
            TextView textView3 = this.currentProfileName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
            }
            companion.applyTo(name2, textView3);
            StringHolder.Companion companion2 = StringHolder.Companion;
            com.mikepenz.materialize.holder.StringHolder email2 = mCurrentProfile.getEmail();
            TextView textView4 = this.currentProfileEmail;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
            }
            companion2.applyTo(email2, textView4);
            AccountHeaderBuilder$buildProfiles$1 $fun$applyProfile$1 = new AccountHeaderBuilder$buildProfiles$1(this);
            if (this.profileImagesVisible && !this.onlyMainProfileImageVisible) {
                IProfile<?> iProfile = this.profileFirst;
                BezelImageView bezelImageView19 = this.profileFirstView;
                if (bezelImageView19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("profileFirstView");
                }
                $fun$applyProfile$1.invoke(iProfile, bezelImageView19);
                IProfile<?> iProfile2 = this.profileSecond;
                BezelImageView bezelImageView20 = this.profileSecondView;
                if (bezelImageView20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("profileSecondView");
                }
                $fun$applyProfile$1.invoke(iProfile2, bezelImageView20);
                if (this.threeSmallProfileImages) {
                    IProfile<?> iProfile3 = this.profileThird;
                    BezelImageView bezelImageView21 = this.profileThirdView;
                    if (bezelImageView21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("profileThirdView");
                    }
                    $fun$applyProfile$1.invoke(iProfile3, bezelImageView21);
                }
            }
        } else if (mProfiles != null && mProfiles.size() > 0) {
            IProfile profile = mProfiles.get(0);
            View view = this.accountHeader;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountHeader");
            }
            view.setTag(R.id.material_drawer_profile_header, profile);
            handleSelectionView(mCurrentProfile, true);
            ImageView imageView3 = this.accountSwitcherArrow;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
            }
            imageView3.setVisibility(0);
        }
        if (!this.selectionFirstLineShown) {
            TextView textView5 = this.currentProfileName;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
            }
            textView5.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.selectionFirstLine)) {
            TextView textView6 = this.currentProfileName;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileName");
            }
            textView6.setText(this.selectionFirstLine);
        }
        if (!this.selectionSecondLineShown) {
            TextView textView7 = this.currentProfileEmail;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
            }
            textView7.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.selectionSecondLine)) {
            TextView textView8 = this.currentProfileEmail;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentProfileEmail");
            }
            textView8.setText(this.selectionSecondLine);
        }
        if (!this.selectionListEnabled || (!this.selectionListEnabledForSingleProfile && this.profileFirst == null && (mProfiles == null || mProfiles.size() == 1))) {
            ImageView imageView4 = this.accountSwitcherArrow;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
            }
            imageView4.setVisibility(8);
            handleSelectionView((IProfile<?>) null, false);
        }
        if (this.onAccountHeaderSelectionViewClickListener != null) {
            handleSelectionView(mCurrentProfile, true);
        }
    }

    /* access modifiers changed from: private */
    public final void setImageOrPlaceholder(ImageView iv, ImageHolder imageHolder) {
        Drawable drawable;
        DrawerImageLoader.Companion.getInstance().cancelImage(iv);
        DrawerImageLoader.IDrawerImageLoader imageLoader = DrawerImageLoader.Companion.getInstance().getImageLoader();
        if (imageLoader != null) {
            Context context = iv.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "iv.context");
            drawable = imageLoader.placeholder(context, DrawerImageLoader.Tags.PROFILE.name());
        } else {
            drawable = null;
        }
        iv.setImageDrawable(drawable);
        if (imageHolder != null) {
            imageHolder.applyTo(iv, DrawerImageLoader.Tags.PROFILE.name());
        }
    }

    /* access modifiers changed from: private */
    public final void onProfileImageClick(View v, boolean current) {
        boolean consumed;
        Object tag = v.getTag(R.id.material_drawer_profile_header);
        if (tag != null) {
            IProfile profile = (IProfile) tag;
            AccountHeader.OnAccountHeaderProfileImageListener onAccountHeaderProfileImageListener2 = this.onAccountHeaderProfileImageListener;
            if (onAccountHeaderProfileImageListener2 != null) {
                consumed = onAccountHeaderProfileImageListener2.onProfileImageClick(v, profile, current);
            } else {
                consumed = false;
            }
            if (!consumed) {
                onProfileClick$materialdrawer(v, current);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IProfile<*>");
    }

    public final void onProfileClick$materialdrawer(View v, boolean current) {
        MiniDrawer mMiniDrawer$materialdrawer;
        Intrinsics.checkParameterIsNotNull(v, "v");
        Object tag = v.getTag(R.id.material_drawer_profile_header);
        if (tag != null) {
            IProfile profile = (IProfile) tag;
            switchProfiles$materialdrawer(profile);
            Context context = v.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "v.context");
            resetDrawerContent(context);
            Drawer it = this.drawer;
            if (!(it == null || (mMiniDrawer$materialdrawer = it.getDrawerBuilder$materialdrawer().getMMiniDrawer$materialdrawer()) == null)) {
                mMiniDrawer$materialdrawer.onProfileClick();
            }
            AccountHeader.OnAccountHeaderListener onAccountHeaderListener2 = this.onAccountHeaderListener;
            if (onAccountHeaderListener2 != null ? onAccountHeaderListener2.onProfileChanged(v, profile, current) : false) {
                return;
            }
            if (this.onProfileClickDrawerCloseDelay > 0) {
                new Handler().postDelayed(new AccountHeaderBuilder$onProfileClick$2(this), (long) this.onProfileClickDrawerCloseDelay);
                return;
            }
            Drawer drawer2 = this.drawer;
            if (drawer2 != null) {
                drawer2.closeDrawer();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IProfile<*>");
    }

    public final void toggleSelectionList$materialdrawer(Context ctx) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Drawer mDrawer = this.drawer;
        if (mDrawer != null) {
            if (mDrawer.switchedDrawerContent()) {
                resetDrawerContent(ctx);
                z = false;
            } else {
                buildDrawerSelectionList$materialdrawer();
                ImageView imageView = this.accountSwitcherArrow;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
                }
                imageView.clearAnimation();
                ImageView imageView2 = this.accountSwitcherArrow;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
                }
                ViewCompat.animate(imageView2).rotation(180.0f).start();
                z = true;
            }
            this.selectionListShown = z;
        }
    }

    public final void buildDrawerSelectionList$materialdrawer() {
        int i;
        DrawerBuilder drawerBuilder$materialdrawer;
        IItemAdapter<IDrawerItem<?>, IDrawerItem<?>> itemAdapter$materialdrawer;
        int selectedPosition = -1;
        int position = 0;
        ArrayList profileDrawerItems = new ArrayList();
        List mProfiles = this.profiles;
        if (mProfiles != null) {
            for (IProfile profile : mProfiles) {
                if (profile == this.currentProfile) {
                    if (!this.currentHiddenInList) {
                        Drawer drawer2 = this.drawer;
                        if (drawer2 == null || (drawerBuilder$materialdrawer = drawer2.getDrawerBuilder$materialdrawer()) == null || (itemAdapter$materialdrawer = drawerBuilder$materialdrawer.getItemAdapter$materialdrawer()) == null) {
                            i = 0;
                        } else {
                            i = itemAdapter$materialdrawer.getGlobalPosition(position);
                        }
                        selectedPosition = i;
                    }
                }
                if (profile instanceof IDrawerItem) {
                    ((IDrawerItem) profile).setSelected(false);
                    profileDrawerItems.add((IDrawerItem) profile);
                }
                position++;
            }
        }
        Drawer drawer3 = this.drawer;
        if (drawer3 != null) {
            drawer3.switchDrawerContent(this.onDrawerItemClickListener, this.onDrawerItemLongClickListener, profileDrawerItems, selectedPosition);
        }
    }

    /* access modifiers changed from: private */
    public final void resetDrawerContent(Context ctx) {
        Drawer drawer2 = this.drawer;
        if (drawer2 != null) {
            drawer2.resetDrawerContent();
        }
        ImageView imageView = this.accountSwitcherArrow;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
        }
        imageView.clearAnimation();
        ImageView imageView2 = this.accountSwitcherArrow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountSwitcherArrow");
        }
        ViewCompat.animate(imageView2).rotation(0.0f).start();
    }

    public final void updateHeaderAndList$materialdrawer() {
        calculateProfiles$materialdrawer();
        buildProfiles$materialdrawer();
        if (this.selectionListShown) {
            buildDrawerSelectionList$materialdrawer();
        }
    }
}

package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import com.mikepenz.fastadapter.expandable.ExpandableExtension;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.fastadapter.select.SelectExtensionKt;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Iconable;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialize.Materialize;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0017\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 À\u00012\u00020\u0001:\fÀ\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010u\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u001a\u0010x\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015J'\u0010z\u001a\u00020v2\u001a\u0010 \u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0{\"\u0006\u0012\u0002\b\u00030\r¢\u0006\u0002\u0010|J/\u0010}\u001a\u00020v2\u0006\u0010y\u001a\u00020\u00152\u001a\u0010 \u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0{\"\u0006\u0012\u0002\b\u00030\r¢\u0006\u0002\u0010~J\u0012\u0010\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u001b\u0010\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015J\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\u0010\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u0019J\u0016\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0007\u0010\u0001\u001a\u00020\u0001J\u0016\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0007\u0010\u0001\u001a\u00020\u0019J\u0013\u0010\u0001\u001a\u00020\u00152\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u0010\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u0019J\u0013\u0010\u0001\u001a\u00020\u00152\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u0010\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u0019J\u001a\u0010\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020<H\u0002J\u0007\u0010\u0001\u001a\u00020<J\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\u0010\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u0019J\u000f\u0010\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020\u0015J\u0015\u0010\u0001\u001a\u00020v2\f\u0010\u0001\u001a\u00030\u0001\"\u00020\u0019J\u000f\u0010\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020\u0015J\u0007\u0010\u0001\u001a\u00020vJ\u0010\u0010\u0001\u001a\u00020`2\u0007\u0010\u0001\u001a\u00020`J\u0010\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020<J\u0010\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u0015J\u0017\u00107\u001a\u00020v2\u0006\u00104\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020<J2\u00107\u001a\u00020v2\b\u00104\u001a\u0004\u0018\u00010-2\u0007\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020<2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u001b\u0010 \u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015J\u0019\u0010¡\u0001\u001a\u00020v2\u0010\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0!J&\u0010¡\u0001\u001a\u00020v2\u0012\u0010 \u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010!2\u0007\u0010¢\u0001\u001a\u00020<H\u0002J\u0013\u0010£\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010£\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0007\u0010\u0001\u001a\u00020<J\u001d\u0010£\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u00192\t\b\u0002\u0010\u0001\u001a\u00020<H\u0007J\u001c\u0010¤\u0001\u001a\u00020<2\u0006\u0010y\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020<H\u0007J\u001b\u0010¥\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015J\u0019\u0010¦\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020<J\u001c\u0010§\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020<H\u0007J(\u0010¨\u0001\u001a\u00020v2\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030¬\u00012\t\b\u0002\u0010­\u0001\u001a\u00020<H\u0007J5\u0010®\u0001\u001a\u00020v2\u0007\u0010¯\u0001\u001a\u00020J2\u0007\u0010°\u0001\u001a\u00020P2\u0011\u0010±\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0!2\u0007\u0010²\u0001\u001a\u00020\u0015J\u0007\u0010³\u0001\u001a\u00020<J\u001a\u0010´\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u00192\b\u0010µ\u0001\u001a\u00030¶\u0001J\u001a\u0010·\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u00192\b\u0010¸\u0001\u001a\u00030¹\u0001J\u0013\u0010º\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u001b\u0010»\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015J\u001a\u0010¼\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020\u00192\b\u0010½\u0001\u001a\u00030¶\u0001J\u0013\u0010¾\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\rJ\u001b\u0010¿\u0001\u001a\u00020v2\n\u0010w\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010y\u001a\u00020\u0015R(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001b\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R%\u00100\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r018F¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00105\u001a\u0004\u0018\u00010-2\b\u00104\u001a\u0004\u0018\u00010-8F@FX\u000e¢\u0006\f\u001a\u0004\b6\u0010/\"\u0004\b7\u00108R%\u00109\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r018F¢\u0006\u0006\u001a\u0004\b:\u00103R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b;\u0010=R%\u0010>\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r018F¢\u0006\u0006\u001a\u0004\b?\u00103R\u0010\u0010@\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR(\u0010I\u001a\u0004\u0018\u00010J2\b\u0010I\u001a\u0004\u0018\u00010J8F@FX\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR(\u0010O\u001a\u0004\u0018\u00010P2\b\u0010O\u001a\u0004\u0018\u00010P8F@FX\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010U\u001a\u0004\u0018\u00010V2\b\u0010U\u001a\u0004\u0018\u00010V8F@FX\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR6\u0010]\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\\2\u0012\u0010[\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\\@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010#R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010c\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u001b\u0010g\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0h8F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0011\u0010k\u001a\u00020l8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0013\u0010o\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\bp\u0010/R\u0016\u0010q\u001a\u0004\u0018\u00010-8BX\u0004¢\u0006\u0006\u001a\u0004\br\u0010/R\u0013\u0010s\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\bt\u0010/¨\u0006Æ\u0001"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer;", "", "drawerBuilder", "Lcom/mikepenz/materialdrawer/DrawerBuilder;", "(Lcom/mikepenz/materialdrawer/DrawerBuilder;)V", "actionBarDrawerToggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getActionBarDrawerToggle", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setActionBarDrawerToggle", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "adapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "getAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "content", "Landroid/widget/FrameLayout;", "getContent", "()Landroid/widget/FrameLayout;", "currentSelectedPosition", "", "getCurrentSelectedPosition", "()I", "currentSelection", "", "getCurrentSelection", "()J", "currentStickyFooterSelectedPosition", "getCurrentStickyFooterSelectedPosition", "getDrawerBuilder$materialdrawer", "()Lcom/mikepenz/materialdrawer/DrawerBuilder;", "drawerItems", "", "getDrawerItems", "()Ljava/util/List;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "expandableExtension", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "getExpandableExtension", "()Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "footer", "Landroid/view/View;", "getFooter", "()Landroid/view/View;", "footerAdapter", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "getFooterAdapter", "()Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "view", "header", "getHeader", "setHeader", "(Landroid/view/View;)V", "headerAdapter", "getHeaderAdapter", "isDrawerOpen", "", "()Z", "itemAdapter", "getItemAdapter", "mContentView", "materialize", "Lcom/mikepenz/materialize/Materialize;", "getMaterialize", "()Lcom/mikepenz/materialize/Materialize;", "miniDrawer", "Lcom/mikepenz/materialdrawer/MiniDrawer;", "getMiniDrawer", "()Lcom/mikepenz/materialdrawer/MiniDrawer;", "onDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "getOnDrawerItemClickListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "setOnDrawerItemClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)V", "onDrawerItemLongClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "getOnDrawerItemLongClickListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "setOnDrawerItemLongClickListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;)V", "onDrawerNavigationListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;", "getOnDrawerNavigationListener", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;", "setOnDrawerNavigationListener", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;)V", "<set-?>", "", "originalDrawerItems", "getOriginalDrawerItems", "originalDrawerState", "Landroid/os/Bundle;", "originalOnDrawerItemClickListener", "originalOnDrawerItemLongClickListener", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "selectExtension", "Lcom/mikepenz/fastadapter/select/SelectExtension;", "getSelectExtension", "()Lcom/mikepenz/fastadapter/select/SelectExtension;", "slider", "Lcom/mikepenz/materialize/view/ScrimInsetsRelativeLayout;", "getSlider", "()Lcom/mikepenz/materialize/view/ScrimInsetsRelativeLayout;", "stickyFooter", "getStickyFooter", "stickyFooterShadow", "getStickyFooterShadow", "stickyHeader", "getStickyHeader", "addItem", "", "drawerItem", "addItemAtPosition", "position", "addItems", "", "([Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;)V", "addItemsAtPosition", "(I[Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;)V", "addStickyFooterItem", "addStickyFooterItemAtPosition", "closeDrawer", "deselect", "identifier", "getDrawerItem", "tag", "getPosition", "getStickyFooterPosition", "notifySelect", "fireOnClick", "onBackPressed", "openDrawer", "removeAllItems", "removeAllStickyFooterItems", "removeHeader", "removeItem", "removeItemByPosition", "removeItems", "identifiers", "", "removeStickyFooterItemAtPosition", "resetDrawerContent", "saveInstanceState", "_savedInstanceState", "setFullscreen", "fullscreen", "setGravity", "gravity", "divider", "padding", "height", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setItemAtPosition", "setItems", "switchedItems", "setSelection", "setSelectionAtPosition", "setStickyFooterItemAtPosition", "setStickyFooterSelection", "setStickyFooterSelectionAtPosition", "setToolbar", "activity", "Landroid/app/Activity;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "recreateActionBarDrawerToggle", "switchDrawerContent", "onDrawerItemClickListenerInner", "onDrawerItemLongClickListenerInner", "drawerItemsInner", "drawerSelection", "switchedDrawerContent", "updateBadge", "badge", "Lcom/mikepenz/materialdrawer/holder/StringHolder;", "updateIcon", "image", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "updateItem", "updateItemAtPosition", "updateName", "name", "updateStickyFooterItem", "updateStickyFooterItemAtPosition", "Companion", "OnDrawerItemClickListener", "OnDrawerItemLongClickListener", "OnDrawerItemSelectedListener", "OnDrawerListener", "OnDrawerNavigationListener", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: Drawer.kt */
public class Drawer {
    public static final String BUNDLE_DRAWER_CONTENT_SWITCHED = "bundle_drawer_content_switched";
    public static final String BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED = "bundle_drawer_content_switched_appended";
    public static final String BUNDLE_SELECTION = "_selection";
    public static final String BUNDLE_SELECTION_APPENDED = "_selection_appended";
    public static final String BUNDLE_STICKY_FOOTER_SELECTION = "bundle_sticky_footer_selection";
    public static final String BUNDLE_STICKY_FOOTER_SELECTION_APPENDED = "bundle_sticky_footer_selection_appended";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    public static final String PREF_USER_OPENED_DRAWER_BY_DRAGGING = "navigation_drawer_dragged_open";
    private final DrawerBuilder drawerBuilder;
    private FrameLayout mContentView;
    private List<IDrawerItem<?>> originalDrawerItems;
    private Bundle originalDrawerState;
    private OnDrawerItemClickListener originalOnDrawerItemClickListener;
    private OnDrawerItemLongClickListener originalOnDrawerItemLongClickListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH&¨\u0006\n"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public interface OnDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem<?> iDrawerItem);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH&¨\u0006\n"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public interface OnDrawerItemLongClickListener {
        boolean onItemLongClick(View view, int i, IDrawerItem<?> iDrawerItem);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH&J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemSelectedListener;", "", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "drawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "onNothingSelected", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public interface OnDrawerItemSelectedListener {
        void onItemSelected(AdapterView<?> adapterView, View view, int i, long j, IDrawerItem<?> iDrawerItem);

        void onNothingSelected(AdapterView<?> adapterView);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$OnDrawerListener;", "", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public interface OnDrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;", "", "onNavigationClickListener", "", "clickedView", "Landroid/view/View;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public interface OnDrawerNavigationListener {
        boolean onNavigationClickListener(View view);
    }

    public final void setHeader(View view, boolean z, boolean z2) {
        setHeader$default(this, view, z, z2, (DimenHolder) null, 8, (Object) null);
    }

    public final void setSelection(long j) {
        setSelection$default(this, j, false, 2, (Object) null);
    }

    public final boolean setSelectionAtPosition(int i) {
        return setSelectionAtPosition$default(this, i, false, 2, (Object) null);
    }

    public final void setStickyFooterSelectionAtPosition(int i) {
        setStickyFooterSelectionAtPosition$default(this, i, false, 2, (Object) null);
    }

    public final void setToolbar(Activity activity, Toolbar toolbar) {
        setToolbar$default(this, activity, toolbar, false, 4, (Object) null);
    }

    public Drawer(DrawerBuilder drawerBuilder2) {
        Intrinsics.checkParameterIsNotNull(drawerBuilder2, "drawerBuilder");
        this.drawerBuilder = drawerBuilder2;
    }

    public final DrawerBuilder getDrawerBuilder$materialdrawer() {
        return this.drawerBuilder;
    }

    public final DrawerLayout getDrawerLayout() {
        return this.drawerBuilder.getMDrawerLayout$materialdrawer();
    }

    public final boolean isDrawerOpen() {
        return this.drawerBuilder.getMDrawerLayout$materialdrawer().isDrawerOpen(this.drawerBuilder.getMDrawerGravity$materialdrawer());
    }

    public final Materialize getMaterialize() {
        return this.drawerBuilder.getMMaterialize$materialdrawer();
    }

    public final MiniDrawer getMiniDrawer() {
        if (this.drawerBuilder.getMMiniDrawer$materialdrawer() == null) {
            this.drawerBuilder.setMMiniDrawer$materialdrawer(new MiniDrawer().withDrawer(this).withAccountHeader(this.drawerBuilder.getMAccountHeader$materialdrawer()));
        }
        return this.drawerBuilder.getMMiniDrawer$materialdrawer();
    }

    public final ScrimInsetsRelativeLayout getSlider() {
        return this.drawerBuilder.getMSliderLayout$materialdrawer();
    }

    public final FrameLayout getContent() {
        if (this.mContentView == null) {
            this.mContentView = (FrameLayout) this.drawerBuilder.getMDrawerLayout$materialdrawer().findViewById(R.id.content_layout);
        }
        return this.mContentView;
    }

    public final RecyclerView getRecyclerView() {
        return this.drawerBuilder.getMRecyclerView$materialdrawer();
    }

    public final FastAdapter<IDrawerItem<?>> getAdapter() {
        return this.drawerBuilder.getAdapter$materialdrawer();
    }

    public final SelectExtension<IDrawerItem<?>> getSelectExtension() {
        return this.drawerBuilder.getSelectExtension$materialdrawer();
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getHeaderAdapter() {
        return this.drawerBuilder.getMHeaderAdapter$materialdrawer();
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getItemAdapter() {
        return this.drawerBuilder.getMItemAdapter$materialdrawer();
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getFooterAdapter() {
        return this.drawerBuilder.getMFooterAdapter$materialdrawer();
    }

    public final ExpandableExtension<IDrawerItem<?>> getExpandableExtension() {
        return this.drawerBuilder.getMExpandableExtension$materialdrawer();
    }

    public final List<IDrawerItem<?>> getDrawerItems() {
        return this.drawerBuilder.getItemAdapter$materialdrawer().getAdapterItems();
    }

    public final View getHeader() {
        return this.drawerBuilder.getMHeaderView$materialdrawer();
    }

    public final void setHeader(View view) {
        setHeader$default(this, view, true, true, (DimenHolder) null, 8, (Object) null);
    }

    public final View getStickyHeader() {
        return this.drawerBuilder.getMStickyHeaderView$materialdrawer();
    }

    public final View getFooter() {
        return this.drawerBuilder.getMFooterView$materialdrawer();
    }

    public final View getStickyFooter() {
        return this.drawerBuilder.getMStickyFooterView$materialdrawer();
    }

    private final View getStickyFooterShadow() {
        return this.drawerBuilder.getMStickyFooterShadowView$materialdrawer();
    }

    public final ActionBarDrawerToggle getActionBarDrawerToggle() {
        return this.drawerBuilder.getMActionBarDrawerToggle$materialdrawer();
    }

    public final void setActionBarDrawerToggle(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.drawerBuilder.setMActionBarDrawerToggleEnabled$materialdrawer(true);
        this.drawerBuilder.setMActionBarDrawerToggle$materialdrawer(actionBarDrawerToggle);
        this.drawerBuilder.handleDrawerNavigation$materialdrawer((Activity) null, false);
    }

    public final int getCurrentSelectedPosition() {
        if (this.drawerBuilder.getSelectExtension$materialdrawer().getSelections().isEmpty()) {
            return -1;
        }
        return this.drawerBuilder.getSelectExtension$materialdrawer().getSelections().iterator().next().intValue();
    }

    public final long getCurrentSelection() {
        IDrawerItem drawerItem = this.drawerBuilder.getDrawerItem$materialdrawer(getCurrentSelectedPosition());
        if (drawerItem != null) {
            return drawerItem.getIdentifier();
        }
        return -1;
    }

    public final int getCurrentStickyFooterSelectedPosition() {
        return this.drawerBuilder.getMCurrentStickyFooterSelection$materialdrawer();
    }

    public final OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return this.drawerBuilder.getMOnDrawerItemClickListener$materialdrawer();
    }

    public final void setOnDrawerItemClickListener(OnDrawerItemClickListener onDrawerItemClickListener) {
        this.drawerBuilder.setMOnDrawerItemClickListener$materialdrawer(onDrawerItemClickListener);
    }

    public final OnDrawerNavigationListener getOnDrawerNavigationListener() {
        return this.drawerBuilder.getMOnDrawerNavigationListener$materialdrawer();
    }

    public final void setOnDrawerNavigationListener(OnDrawerNavigationListener onDrawerNavigationListener) {
        this.drawerBuilder.setMOnDrawerNavigationListener$materialdrawer(onDrawerNavigationListener);
    }

    public final OnDrawerItemLongClickListener getOnDrawerItemLongClickListener() {
        return this.drawerBuilder.getMOnDrawerItemLongClickListener$materialdrawer();
    }

    public final void setOnDrawerItemLongClickListener(OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        this.drawerBuilder.setMOnDrawerItemLongClickListener$materialdrawer(onDrawerItemLongClickListener);
    }

    public final List<IDrawerItem<?>> getOriginalDrawerItems() {
        return this.originalDrawerItems;
    }

    public static /* synthetic */ void setToolbar$default(Drawer drawer, Activity activity, Toolbar toolbar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z = false;
            }
            drawer.setToolbar(activity, toolbar, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setToolbar");
    }

    public final void setToolbar(Activity activity, Toolbar toolbar, boolean recreateActionBarDrawerToggle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
        this.drawerBuilder.setMToolbar$materialdrawer(toolbar);
        this.drawerBuilder.handleDrawerNavigation$materialdrawer(activity, recreateActionBarDrawerToggle);
    }

    public final void openDrawer() {
        this.drawerBuilder.getMDrawerLayout$materialdrawer().openDrawer(this.drawerBuilder.getMDrawerGravity$materialdrawer());
    }

    public final void closeDrawer() {
        this.drawerBuilder.getMDrawerLayout$materialdrawer().closeDrawer(this.drawerBuilder.getMDrawerGravity$materialdrawer());
    }

    public final void setFullscreen(boolean fullscreen) {
        this.drawerBuilder.getMMaterialize$materialdrawer().setFullscreen(fullscreen);
    }

    public final void setHeader(View view, boolean divider) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        setHeader$default(this, view, true, divider, (DimenHolder) null, 8, (Object) null);
    }

    public static /* synthetic */ void setHeader$default(Drawer drawer, View view, boolean z, boolean z2, DimenHolder dimenHolder, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                dimenHolder = null;
            }
            drawer.setHeader(view, z, z2, dimenHolder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeader");
    }

    public final void setHeader(View view, boolean padding, boolean divider, DimenHolder height) {
        this.drawerBuilder.getHeaderAdapter$materialdrawer().clear();
        if (view != null) {
            View view2 = view;
            if (padding) {
                this.drawerBuilder.getHeaderAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(view).withDivider(divider).withHeight(height).withViewPosition(ContainerDrawerItem.Position.TOP)});
            } else {
                this.drawerBuilder.getHeaderAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(view).withDivider(divider).withHeight(height).withViewPosition(ContainerDrawerItem.Position.NONE)});
            }
        }
        this.drawerBuilder.getMRecyclerView$materialdrawer().setPadding(this.drawerBuilder.getMRecyclerView$materialdrawer().getPaddingLeft(), 0, this.drawerBuilder.getMRecyclerView$materialdrawer().getPaddingRight(), this.drawerBuilder.getMRecyclerView$materialdrawer().getPaddingBottom());
    }

    public final void removeHeader() {
        this.drawerBuilder.getHeaderAdapter$materialdrawer().clear();
    }

    public final void setGravity(int gravity) {
        ViewGroup.LayoutParams layoutParams = getSlider().getLayoutParams();
        if (layoutParams != null) {
            DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) layoutParams;
            params.gravity = gravity;
            getSlider().setLayoutParams(params);
            this.drawerBuilder.setMDrawerGravity$materialdrawer(gravity);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout.LayoutParams");
    }

    public final int getPosition(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        return getPosition(drawerItem.getIdentifier());
    }

    public final int getPosition(long identifier) {
        return DrawerUtils.INSTANCE.getPositionByIdentifier(this.drawerBuilder, identifier);
    }

    public final IDrawerItem<?> getDrawerItem(long identifier) {
        Pair res = getAdapter().getItemById(identifier);
        if (res != null) {
            return res.getFirst();
        }
        return null;
    }

    public final IDrawerItem<?> getDrawerItem(Object tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        return DrawerUtils.INSTANCE.getDrawerItem((List<? extends IDrawerItem<?>>) getDrawerItems(), tag);
    }

    public final int getStickyFooterPosition(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        return getStickyFooterPosition(drawerItem.getIdentifier());
    }

    public final int getStickyFooterPosition(long identifier) {
        return DrawerUtils.INSTANCE.getStickyFooterPositionByIdentifier(this.drawerBuilder, identifier);
    }

    public final void deselect() {
        getSelectExtension().deselect();
    }

    public final void deselect(long identifier) {
        SelectExtension.deselect$default(getSelectExtension(), getPosition(identifier), (Iterator) null, 2, (Object) null);
        this.drawerBuilder.resetStickyFooterSelection$materialdrawer();
    }

    public static /* synthetic */ void setSelection$default(Drawer drawer, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            drawer.setSelection(j, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSelection");
    }

    public final void setSelection(long identifier, boolean fireOnClick) {
        SelectExtension select = SelectExtensionKt.getSelectExtension(getAdapter());
        if (select != null) {
            select.deselect();
            select.selectByIdentifier(identifier, false, true);
            Pair res = getAdapter().getItemById(identifier);
            if (res != null) {
                Integer position = res.getSecond();
                notifySelect(position != null ? position.intValue() : -1, fireOnClick);
            }
        }
    }

    public final void setStickyFooterSelection(long identifier, boolean fireOnClick) {
        setStickyFooterSelectionAtPosition(getStickyFooterPosition(identifier), fireOnClick);
    }

    public final void setSelection(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        setSelection(drawerItem.getIdentifier(), true);
    }

    public final void setSelection(IDrawerItem<?> drawerItem, boolean fireOnClick) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        setSelection(drawerItem.getIdentifier(), fireOnClick);
    }

    public static /* synthetic */ boolean setSelectionAtPosition$default(Drawer drawer, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return drawer.setSelectionAtPosition(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSelectionAtPosition");
    }

    public final boolean setSelectionAtPosition(int position, boolean fireOnClick) {
        this.drawerBuilder.getSelectExtension$materialdrawer().deselect();
        SelectExtension.select$default(this.drawerBuilder.getSelectExtension$materialdrawer(), position, false, false, 4, (Object) null);
        notifySelect(position, fireOnClick);
        return false;
    }

    private final void notifySelect(int position, boolean fireOnClick) {
        IDrawerItem item;
        OnDrawerItemClickListener onDrawerItemClickListener;
        if (fireOnClick && position >= 0 && (item = this.drawerBuilder.getAdapter$materialdrawer().getItem(position)) != null) {
            if ((item instanceof AbstractDrawerItem) && (onDrawerItemClickListener = ((AbstractDrawerItem) item).getOnDrawerItemClickListener()) != null) {
                onDrawerItemClickListener.onItemClick((View) null, position, item);
            }
            OnDrawerItemClickListener mOnDrawerItemClickListener$materialdrawer = this.drawerBuilder.getMOnDrawerItemClickListener$materialdrawer();
            if (mOnDrawerItemClickListener$materialdrawer != null) {
                mOnDrawerItemClickListener$materialdrawer.onItemClick((View) null, position, item);
            }
        }
        this.drawerBuilder.resetStickyFooterSelection$materialdrawer();
    }

    public static /* synthetic */ void setStickyFooterSelectionAtPosition$default(Drawer drawer, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            drawer.setStickyFooterSelectionAtPosition(i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStickyFooterSelectionAtPosition");
    }

    public final void setStickyFooterSelectionAtPosition(int position, boolean fireOnClick) {
        DrawerUtils.INSTANCE.setStickyFooterSelection(this.drawerBuilder, position, Boolean.valueOf(fireOnClick));
    }

    public final void updateItem(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        updateItemAtPosition(drawerItem, getPosition(drawerItem));
    }

    public final void updateBadge(long identifier, StringHolder badge) {
        Intrinsics.checkParameterIsNotNull(badge, "badge");
        IDrawerItem<?> drawerItem = getDrawerItem(identifier);
        if (drawerItem instanceof Badgeable) {
            ((Badgeable) drawerItem).withBadge(badge);
            updateItem(drawerItem);
        }
    }

    public final void updateName(long identifier, StringHolder name) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        IDrawerItem<?> drawerItem = getDrawerItem(identifier);
        if (drawerItem instanceof Nameable) {
            ((Nameable) drawerItem).withName(name);
            updateItem(drawerItem);
        }
    }

    public final void updateIcon(long identifier, ImageHolder image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        IDrawerItem<?> drawerItem = getDrawerItem(identifier);
        if (drawerItem instanceof Iconable) {
            ((Iconable) drawerItem).withIcon(image);
            updateItem(drawerItem);
        }
    }

    public final void updateItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (this.drawerBuilder.checkDrawerItem$materialdrawer(position, false)) {
            List it = this.originalDrawerItems;
            if (it != null) {
                it.set(position, drawerItem);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object $this$ifNotNull$iv = unit;
            if (unit == null) {
                this.drawerBuilder.getItemAdapter$materialdrawer().set(position, drawerItem);
            }
        }
    }

    public final void addItem(IDrawerItem<?> drawerItem) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        List it = this.originalDrawerItems;
        if (it != null) {
            it.add(drawerItem);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{drawerItem});
        }
    }

    public final void addItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        List it = this.originalDrawerItems;
        if (it != null) {
            it.add(position, drawerItem);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().add(position, (Model[]) new IDrawerItem[]{drawerItem});
        }
    }

    public final void setItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        List it = this.originalDrawerItems;
        if (it != null) {
            it.set(position, drawerItem);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().set(position, drawerItem);
        }
    }

    public final void removeItemByPosition(int position) {
        Unit unit;
        List it = this.originalDrawerItems;
        if (it != null) {
            it.remove(position);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null && this.drawerBuilder.checkDrawerItem$materialdrawer(position, false)) {
            this.drawerBuilder.getItemAdapter$materialdrawer().remove(position);
        }
    }

    public final void removeItem(long identifier) {
        Unit unit;
        List it = this.originalDrawerItems;
        if (it != null) {
            CollectionsKt.removeAll(it, new Drawer$removeItem$$inlined$ifNotNull$lambda$1(identifier));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            getItemAdapter().removeByIdentifier(identifier);
        }
    }

    public final void removeItems(long... identifiers) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(identifiers, "identifiers");
        List it = this.originalDrawerItems;
        if (it != null) {
            CollectionsKt.removeAll(it, new Drawer$removeItems$$inlined$ifNotNull$lambda$1(identifiers));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            for (long identifier : identifiers) {
                removeItem(identifier);
            }
        }
    }

    public final void removeAllItems() {
        Unit unit;
        List it = this.originalDrawerItems;
        if (it != null) {
            it.clear();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().clear();
        }
    }

    public final void addItems(IDrawerItem<?>... drawerItems) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        List $this$ifNotNull$iv = this.originalDrawerItems;
        if ($this$ifNotNull$iv != null) {
            CollectionsKt.addAll($this$ifNotNull$iv, (T[]) drawerItems);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv2 = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().add(ArraysKt.asList((T[]) drawerItems));
        }
    }

    public final void addItemsAtPosition(int position, IDrawerItem<?>... drawerItems) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        List it = this.originalDrawerItems;
        if (it != null) {
            it.addAll(position, ArraysKt.asList((T[]) drawerItems));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        Object $this$ifNotNull$iv = unit;
        if (unit == null) {
            this.drawerBuilder.getItemAdapter$materialdrawer().add(position, ArraysKt.asList((T[]) drawerItems));
        }
    }

    public final void setItems(List<? extends IDrawerItem<?>> drawerItems) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        setItems(drawerItems, false);
    }

    private final void setItems(List<? extends IDrawerItem<?>> drawerItems, boolean switchedItems) {
        if (this.originalDrawerItems != null && !switchedItems) {
            this.originalDrawerItems = drawerItems != null ? CollectionsKt.toMutableList(drawerItems) : null;
        }
        IItemAdapter.DefaultImpls.setNewList$default(this.drawerBuilder.getItemAdapter$materialdrawer(), drawerItems != null ? drawerItems : new ArrayList<>(), false, 2, (Object) null);
    }

    public final void updateStickyFooterItem(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        updateStickyFooterItemAtPosition(drawerItem, getStickyFooterPosition(drawerItem));
    }

    public final void updateStickyFooterItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (this.drawerBuilder.getMStickyDrawerItems$materialdrawer().size() > position) {
            this.drawerBuilder.getMStickyDrawerItems$materialdrawer().set(position, drawerItem);
        }
        DrawerUtils.INSTANCE.rebuildStickyFooterView(this.drawerBuilder);
    }

    public final void addStickyFooterItem(IDrawerItem<?> drawerItem) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        this.drawerBuilder.getMStickyDrawerItems$materialdrawer().add(drawerItem);
        DrawerUtils.INSTANCE.rebuildStickyFooterView(this.drawerBuilder);
    }

    public final void addStickyFooterItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        this.drawerBuilder.getMStickyDrawerItems$materialdrawer().add(position, drawerItem);
        DrawerUtils.INSTANCE.rebuildStickyFooterView(this.drawerBuilder);
    }

    public final void setStickyFooterItemAtPosition(IDrawerItem<?> drawerItem, int position) {
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        if (this.drawerBuilder.getMStickyDrawerItems$materialdrawer().size() > position) {
            this.drawerBuilder.getMStickyDrawerItems$materialdrawer().set(position, drawerItem);
        }
        DrawerUtils.INSTANCE.rebuildStickyFooterView(this.drawerBuilder);
    }

    public final void removeStickyFooterItemAtPosition(int position) {
        if (this.drawerBuilder.getMStickyDrawerItems$materialdrawer().size() > position) {
            this.drawerBuilder.getMStickyDrawerItems$materialdrawer().remove(position);
        }
        DrawerUtils.INSTANCE.rebuildStickyFooterView(this.drawerBuilder);
    }

    public final void removeAllStickyFooterItems() {
        this.drawerBuilder.getMStickyDrawerItems$materialdrawer().clear();
        ViewGroup mStickyFooterView$materialdrawer = this.drawerBuilder.getMStickyFooterView$materialdrawer();
        if (mStickyFooterView$materialdrawer != null) {
            mStickyFooterView$materialdrawer.setVisibility(8);
        }
    }

    public final boolean switchedDrawerContent() {
        return (this.originalOnDrawerItemClickListener == null && this.originalDrawerItems == null && this.originalDrawerState == null) ? false : true;
    }

    public final void switchDrawerContent(OnDrawerItemClickListener onDrawerItemClickListenerInner, OnDrawerItemLongClickListener onDrawerItemLongClickListenerInner, List<? extends IDrawerItem<?>> drawerItemsInner, int drawerSelection) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListenerInner, "onDrawerItemClickListenerInner");
        Intrinsics.checkParameterIsNotNull(onDrawerItemLongClickListenerInner, "onDrawerItemLongClickListenerInner");
        Intrinsics.checkParameterIsNotNull(drawerItemsInner, "drawerItemsInner");
        if (!switchedDrawerContent()) {
            this.originalOnDrawerItemClickListener = getOnDrawerItemClickListener();
            this.originalOnDrawerItemLongClickListener = getOnDrawerItemLongClickListener();
            this.originalDrawerState = FastAdapter.saveInstanceState$default(getAdapter(), new Bundle(), (String) null, 2, (Object) null);
            this.drawerBuilder.getMExpandableExtension$materialdrawer().collapse(false);
            this.originalDrawerItems = CollectionsKt.toMutableList(getDrawerItems());
        }
        setOnDrawerItemClickListener(onDrawerItemClickListenerInner);
        setOnDrawerItemLongClickListener(onDrawerItemLongClickListenerInner);
        setItems(drawerItemsInner, true);
        setSelectionAtPosition(drawerSelection, false);
        if (!this.drawerBuilder.getMKeepStickyItemsVisible$materialdrawer()) {
            View stickyFooter = getStickyFooter();
            if (stickyFooter != null) {
                stickyFooter.setVisibility(8);
            }
            View stickyFooterShadow = getStickyFooterShadow();
            if (stickyFooterShadow != null) {
                stickyFooterShadow.setVisibility(8);
            }
        }
    }

    public final void resetDrawerContent() {
        AccountHeaderBuilder accountHeaderBuilder;
        if (switchedDrawerContent()) {
            setOnDrawerItemClickListener(this.originalOnDrawerItemClickListener);
            setOnDrawerItemLongClickListener(this.originalOnDrawerItemLongClickListener);
            setItems(this.originalDrawerItems, true);
            FastAdapter.withSavedInstanceState$default(getAdapter(), this.originalDrawerState, (String) null, 2, (Object) null);
            this.originalOnDrawerItemClickListener = null;
            this.originalOnDrawerItemLongClickListener = null;
            this.originalDrawerItems = null;
            this.originalDrawerState = null;
            this.drawerBuilder.getMRecyclerView$materialdrawer().smoothScrollToPosition(0);
            View stickyFooter = getStickyFooter();
            if (stickyFooter != null) {
                stickyFooter.setVisibility(0);
            }
            View stickyFooterShadow = getStickyFooterShadow();
            if (stickyFooterShadow != null) {
                stickyFooterShadow.setVisibility(0);
            }
            AccountHeader mAccountHeader$materialdrawer = this.drawerBuilder.getMAccountHeader$materialdrawer();
            if (mAccountHeader$materialdrawer != null && (accountHeaderBuilder = mAccountHeader$materialdrawer.getAccountHeaderBuilder()) != null) {
                accountHeaderBuilder.setSelectionListShown$materialdrawer(false);
            }
        }
    }

    public final Bundle saveInstanceState(Bundle _savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(_savedInstanceState, "_savedInstanceState");
        if (!this.drawerBuilder.getMAppended$materialdrawer()) {
            Bundle $this$apply = this.drawerBuilder.getAdapter$materialdrawer().saveInstanceState(_savedInstanceState, BUNDLE_SELECTION);
            if ($this$apply != null) {
                $this$apply.putInt(BUNDLE_STICKY_FOOTER_SELECTION, this.drawerBuilder.getMCurrentStickyFooterSelection$materialdrawer());
                $this$apply.putBoolean(BUNDLE_DRAWER_CONTENT_SWITCHED, switchedDrawerContent());
            }
        } else {
            Bundle $this$apply2 = this.drawerBuilder.getAdapter$materialdrawer().saveInstanceState(_savedInstanceState, BUNDLE_SELECTION_APPENDED);
            if ($this$apply2 != null) {
                $this$apply2.putInt(BUNDLE_STICKY_FOOTER_SELECTION_APPENDED, this.drawerBuilder.getMCurrentStickyFooterSelection$materialdrawer());
                $this$apply2.putBoolean(BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED, switchedDrawerContent());
            }
        }
        return _savedInstanceState;
    }

    public final boolean onBackPressed() {
        if (!isDrawerOpen()) {
            return false;
        }
        closeDrawer();
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mikepenz/materialdrawer/Drawer$Companion;", "", "()V", "BUNDLE_DRAWER_CONTENT_SWITCHED", "", "BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED", "BUNDLE_SELECTION", "BUNDLE_SELECTION_APPENDED", "BUNDLE_STICKY_FOOTER_SELECTION", "BUNDLE_STICKY_FOOTER_SELECTION_APPENDED", "PREF_USER_LEARNED_DRAWER", "PREF_USER_OPENED_DRAWER_BY_DRAGGING", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Drawer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

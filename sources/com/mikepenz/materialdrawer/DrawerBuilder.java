package com.mikepenz.materialdrawer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studente_portfolio.ScheduleActivity;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapterExtension;
import com.mikepenz.fastadapter.IIdentifyable;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import com.mikepenz.fastadapter.expandable.ExpandableExtension;
import com.mikepenz.fastadapter.expandable.ExpandableExtensionFactory;
import com.mikepenz.fastadapter.extensions.ExtensionsFactories;
import com.mikepenz.fastadapter.select.SelectExtension;
import com.mikepenz.fastadapter.select.SelectExtensionFactory;
import com.mikepenz.fastadapter.utils.DefaultIdDistributor;
import com.mikepenz.fastadapter.utils.DefaultIdDistributorImpl;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.Materialize;
import com.mikepenz.materialize.MaterializeBuilder;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010 \n\u0002\bd\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J+\u0010Ë\u0002\u001a\u00020\u00002\u001c\u0010Ì\u0002\u001a\u000f\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0Í\u0002\"\u0006\u0012\u0002\b\u00030\b¢\u0006\u0003\u0010Î\u0002J\u001d\u0010Ï\u0002\u001a\u00030Ð\u00022\b\u0010Ñ\u0002\u001a\u00030Ò\u00022\u0007\u0010Ó\u0002\u001a\u00020+H\u0002J+\u0010Ô\u0002\u001a\u00020\u00002\u001c\u0010Õ\u0002\u001a\u000f\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0Í\u0002\"\u0006\u0012\u0002\b\u00030\b¢\u0006\u0003\u0010Î\u0002J\u0014\u0010Ö\u0002\u001a\u00030×\u00022\b\u0010Ø\u0002\u001a\u00030×\u0002H\u0016J\n\u0010Ù\u0002\u001a\u00030×\u0002H\u0016J\n\u0010Ú\u0002\u001a\u00030×\u0002H\u0016J\n\u0010Û\u0002\u001a\u00030×\u0002H\u0016J!\u0010Ü\u0002\u001a\u00020+2\u0007\u0010Ý\u0002\u001a\u00020G2\u0007\u0010Þ\u0002\u001a\u00020+H\u0000¢\u0006\u0003\bß\u0002J\u0010\u0010à\u0002\u001a\u00030Ð\u0002H\u0000¢\u0006\u0003\bá\u0002J\n\u0010â\u0002\u001a\u00030Ð\u0002H\u0002J\u001e\u0010ã\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0007\u0010Ý\u0002\u001a\u00020GH\u0000¢\u0006\u0003\bä\u0002J#\u0010å\u0002\u001a\u00030Ð\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0007\u0010æ\u0002\u001a\u00020+H\u0000¢\u0006\u0003\bç\u0002J\n\u0010è\u0002\u001a\u00030Ð\u0002H\u0002J\u0014\u0010é\u0002\u001a\u00020\u00002\t\b\u0001\u0010ê\u0002\u001a\u00020GH\u0007J\n\u0010ë\u0002\u001a\u00030Ð\u0002H\u0002J\u0010\u0010ì\u0002\u001a\u00030Ð\u0002H\u0000¢\u0006\u0003\bí\u0002J\u001d\u0010î\u0002\u001a\u00020\u00002\u0007\u0010ï\u0002\u001a\u00020%2\t\b\u0002\u0010ð\u0002\u001a\u00020+H\u0007J\u0010\u0010ñ\u0002\u001a\u00020\u00002\u0007\u0010ò\u0002\u001a\u000201J\u0010\u0010ñ\u0002\u001a\u00020\u00002\u0007\u0010ó\u0002\u001a\u00020+J\u0010\u0010ô\u0002\u001a\u00020\u00002\u0007\u0010õ\u0002\u001a\u00020+J\u000f\u0010ö\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u0010÷\u0002\u001a\u00020\u00002\u0011\u0010ø\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007J\u0013\u0010ù\u0002\u001a\u00020\u00002\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\u0010\u0010ú\u0002\u001a\u00020\u00002\u0007\u0010û\u0002\u001a\u00020+J\u0010\u0010ü\u0002\u001a\u00020\u00002\u0007\u0010ý\u0002\u001a\u00020MJ\u0010\u0010þ\u0002\u001a\u00020\u00002\u0007\u0010ÿ\u0002\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020GJ\u001b\u0010\u0003\u001a\u00020\u00002\u0012\u0010Ì\u0002\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0003J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020bJ\u0012\u0010\u0003\u001a\u00020\u00002\t\b\u0001\u0010\u0003\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020GJ\u0012\u0010\u0003\u001a\u00020\u00002\t\b\u0001\u0010\u0003\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020MJ\u0012\u0010\u0003\u001a\u00020\u00002\t\b\u0001\u0010\u0003\u001a\u00020GJ\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010\u0003\u001a\u00020\u00002\u0007\u0010\u0003\u001a\u00020+J\u0010\u0010 \u0003\u001a\u00020\u00002\u0007\u0010¡\u0003\u001a\u00020MJ\u0012\u0010 \u0003\u001a\u00020\u00002\t\b\u0001\u0010¢\u0003\u001a\u00020GJ\u0010\u0010£\u0003\u001a\u00020\u00002\u0007\u0010¤\u0003\u001a\u00020+J\u0011\u0010¥\u0003\u001a\u00020\u00002\b\u0010¦\u0003\u001a\u00030\u0001J\u0010\u0010§\u0003\u001a\u00020\u00002\u0007\u0010¨\u0003\u001a\u00020+J\u0010\u0010©\u0003\u001a\u00020\u00002\u0007\u0010ª\u0003\u001a\u00020+J\u0011\u0010«\u0003\u001a\u00020\u00002\b\u0010¬\u0003\u001a\u00030¢\u0001J\u0010\u0010­\u0003\u001a\u00020\u00002\u0007\u0010®\u0003\u001a\u00020+J\u0010\u0010¯\u0003\u001a\u00020\u00002\u0007\u0010°\u0003\u001a\u00020+J\u0011\u0010±\u0003\u001a\u00020\u00002\b\u0010²\u0003\u001a\u00030À\u0001J\u0011\u0010³\u0003\u001a\u00020\u00002\b\u0010´\u0003\u001a\u00030Æ\u0001J\u0011\u0010µ\u0003\u001a\u00020\u00002\b\u0010¶\u0003\u001a\u00030Ì\u0001J\u0011\u0010·\u0003\u001a\u00020\u00002\b\u0010¸\u0003\u001a\u00030Ò\u0001J\u0011\u0010¹\u0003\u001a\u00020\u00002\b\u0010º\u0003\u001a\u00030Ø\u0001J\u0011\u0010»\u0003\u001a\u00020\u00002\b\u0010¼\u0003\u001a\u00030Þ\u0001J\u0012\u0010»\u0003\u001a\u00020\u00002\t\b\u0001\u0010½\u0003\u001a\u00020GJ\u0013\u0010¾\u0003\u001a\u00020\u00002\n\u0010¿\u0003\u001a\u0005\u0018\u00010ä\u0001J\u0010\u0010À\u0003\u001a\u00020\u00002\u0007\u0010Á\u0003\u001a\u00020+J\u0011\u0010Â\u0003\u001a\u00020\u00002\b\u0010Ã\u0003\u001a\u00030ó\u0001J\u0010\u0010Ä\u0003\u001a\u00020\u00002\u0007\u0010Å\u0003\u001a\u00020GJ\u0011\u0010Æ\u0003\u001a\u00020\u00002\b\u0010Ç\u0003\u001a\u00030ü\u0001J\u0010\u0010È\u0003\u001a\u00020\u00002\u0007\u0010É\u0003\u001a\u00020+J\u0010\u0010Ê\u0003\u001a\u00020\u00002\u0007\u0010Ë\u0003\u001a\u00020+J\u0012\u0010Ì\u0003\u001a\u00020\u00002\t\b\u0001\u0010Í\u0003\u001a\u00020GJ\u0012\u0010Î\u0003\u001a\u00020\u00002\t\b\u0001\u0010Ï\u0003\u001a\u00020GJ\u0011\u0010Ð\u0003\u001a\u00020\u00002\b\u0010Ñ\u0003\u001a\u00030\u0002J\u0012\u0010Ò\u0003\u001a\u00020\u00002\t\b\u0001\u0010Ó\u0003\u001a\u00020GJ\u001b\u0010Ô\u0003\u001a\u00020\u00002\u0012\u0010Õ\u0002\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0002J\u0011\u0010Õ\u0003\u001a\u00020\u00002\b\u0010Ö\u0003\u001a\u00030Þ\u0001J\u0012\u0010Õ\u0003\u001a\u00020\u00002\t\b\u0001\u0010×\u0003\u001a\u00020GJ\u0010\u0010Ø\u0003\u001a\u00020\u00002\u0007\u0010Ù\u0003\u001a\u00020+J\u0010\u0010Ú\u0003\u001a\u00020\u00002\u0007\u0010Û\u0003\u001a\u00020+J\u0010\u0010Ü\u0003\u001a\u00020\u00002\u0007\u0010Ý\u0003\u001a\u00020MJ\u0012\u0010Ü\u0003\u001a\u00020\u00002\t\b\u0001\u0010Þ\u0003\u001a\u00020GJ\u0010\u0010ß\u0003\u001a\u00020\u00002\u0007\u0010à\u0003\u001a\u00020+J\u0010\u0010á\u0003\u001a\u00020\u00002\u0007\u0010â\u0003\u001a\u00020+J\u0011\u0010ã\u0003\u001a\u00020\u00002\b\u0010ä\u0003\u001a\u00030¸\u0002J\u0010\u0010å\u0003\u001a\u00020\u00002\u0007\u0010æ\u0003\u001a\u00020+J\u0010\u0010ç\u0003\u001a\u00020\u00002\u0007\u0010è\u0003\u001a\u00020+J\u0010\u0010é\u0003\u001a\u00020\u00002\u0007\u0010ê\u0003\u001a\u00020+R$\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR8\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00072\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078@@@X\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R(\u0010\"\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0005R\u001a\u0010=\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\u001a\u0010@\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R\u001a\u0010C\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001a\u0010F\u001a\u00020GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010I\"\u0004\bT\u0010KR\u001a\u0010U\u001a\u00020GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR\u001e\u0010X\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010^\u001a\u00020GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010I\"\u0004\b`\u0010KR\u001a\u0010a\u001a\u00020bX.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010I\"\u0004\bi\u0010KR$\u0010j\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0kX.¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010-\"\u0004\br\u0010/R.\u0010s\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001a\u0010y\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010-\"\u0004\b{\u0010/R\u001a\u0010|\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010-\"\u0004\b~\u0010/R\u001e\u0010\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010O\"\u0005\b\u0001\u0010QR\u001d\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001d\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001d\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R1\u0010\u0001\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010v\"\u0005\b\u0001\u0010xR\u001d\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001d\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001f\u0010\u0001\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010O\"\u0005\b\u0001\u0010QR\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R1\u0010\u0001\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010v\"\u0005\b \u0001\u0010xR \u0010¡\u0001\u001a\u00030¢\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001d\u0010§\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010-\"\u0005\b©\u0001\u0010/R \u0010ª\u0001\u001a\u00030«\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001R \u0010°\u0001\u001a\u00030±\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\"\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u001d\u0010¼\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010-\"\u0005\b¾\u0001\u0010/R\"\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R\"\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\"\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\"\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R \u0010×\u0001\u001a\u00030Ø\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R \u0010Ý\u0001\u001a\u00030Þ\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R\"\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R\u001d\u0010é\u0001\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u0010-\"\u0005\bë\u0001\u0010/R*\u0010ì\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0í\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R \u0010ò\u0001\u001a\u00030ó\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R\u001d\u0010ø\u0001\u001a\u00020GX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010I\"\u0005\bú\u0001\u0010KR\"\u0010û\u0001\u001a\u0005\u0018\u00010ü\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bý\u0001\u0010þ\u0001\"\u0006\bÿ\u0001\u0010\u0002R\u001d\u0010\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010-\"\u0005\b\u0002\u0010/R\u001d\u0010\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010-\"\u0005\b\u0002\u0010/R\u001d\u0010\u0002\u001a\u00020GX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010I\"\u0005\b\u0002\u0010KR\u001d\u0010\u0002\u001a\u00020GX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010I\"\u0005\b\u0002\u0010KR\"\u0010\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001d\u0010\u0002\u001a\u00020GX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010I\"\u0005\b\u0002\u0010KR \u0010\u0002\u001a\u00030\u0002X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b \u0002\u0010¡\u0002R\u001d\u0010¢\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0002\u0010-\"\u0005\b¤\u0002\u0010/R\u001d\u0010¥\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0002\u0010-\"\u0005\b§\u0002\u0010/R\u001f\u0010¨\u0002\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0002\u0010O\"\u0005\bª\u0002\u0010QR\"\u0010«\u0002\u001a\u0005\u0018\u00010Þ\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0002\u0010à\u0001\"\u0006\b­\u0002\u0010â\u0001R\u001d\u0010®\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0002\u0010-\"\u0005\b°\u0002\u0010/R\u001f\u0010±\u0002\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0002\u0010O\"\u0005\b³\u0002\u0010QR\u001d\u0010´\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0002\u0010-\"\u0005\b¶\u0002\u0010/R\"\u0010·\u0002\u001a\u0005\u0018\u00010¸\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0002\u0010º\u0002\"\u0006\b»\u0002\u0010¼\u0002R\u001d\u0010½\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0002\u0010-\"\u0005\b¿\u0002\u0010/R\u001d\u0010À\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0002\u0010-\"\u0005\bÂ\u0002\u0010/R\u001d\u0010Ã\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0002\u0010-\"\u0005\bÅ\u0002\u0010/R\u001d\u0010Æ\u0002\u001a\u00020+X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0002\u0010-\"\u0005\bÈ\u0002\u0010/R\"\u0010É\u0002\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0í\u00018@X\u0004¢\u0006\b\u001a\u0006\bÊ\u0002\u0010ï\u0001¨\u0006ë\u0003"}, d2 = {"Lcom/mikepenz/materialdrawer/DrawerBuilder;", "", "()V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "_adapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "get_adapter$materialdrawer", "()Lcom/mikepenz/fastadapter/FastAdapter;", "set_adapter$materialdrawer", "(Lcom/mikepenz/fastadapter/FastAdapter;)V", "value", "adapter", "getAdapter$materialdrawer", "setAdapter$materialdrawer", "adapterWrapper", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapterWrapper$materialdrawer", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapterWrapper$materialdrawer", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "footerAdapter", "Lcom/mikepenz/fastadapter/IItemAdapter;", "getFooterAdapter$materialdrawer", "()Lcom/mikepenz/fastadapter/IItemAdapter;", "headerAdapter", "getHeaderAdapter$materialdrawer", "idDistributor", "Lcom/mikepenz/fastadapter/utils/DefaultIdDistributor;", "Lcom/mikepenz/fastadapter/IIdentifyable;", "getIdDistributor", "()Lcom/mikepenz/fastadapter/utils/DefaultIdDistributor;", "itemAdapter", "getItemAdapter$materialdrawer", "mAccountHeader", "Lcom/mikepenz/materialdrawer/AccountHeader;", "getMAccountHeader$materialdrawer", "()Lcom/mikepenz/materialdrawer/AccountHeader;", "setMAccountHeader$materialdrawer", "(Lcom/mikepenz/materialdrawer/AccountHeader;)V", "mAccountHeaderSticky", "", "getMAccountHeaderSticky$materialdrawer", "()Z", "setMAccountHeaderSticky$materialdrawer", "(Z)V", "mActionBarDrawerToggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getMActionBarDrawerToggle$materialdrawer", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setMActionBarDrawerToggle$materialdrawer", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "mActionBarDrawerToggleEnabled", "getMActionBarDrawerToggleEnabled$materialdrawer", "setMActionBarDrawerToggleEnabled$materialdrawer", "mActivity", "getMActivity$materialdrawer", "()Landroid/app/Activity;", "setMActivity$materialdrawer", "mAnimateActionBarDrawerToggle", "getMAnimateActionBarDrawerToggle$materialdrawer", "setMAnimateActionBarDrawerToggle$materialdrawer", "mAppended", "getMAppended$materialdrawer", "setMAppended$materialdrawer", "mCloseOnClick", "getMCloseOnClick$materialdrawer", "setMCloseOnClick$materialdrawer", "mCurrentStickyFooterSelection", "", "getMCurrentStickyFooterSelection$materialdrawer", "()I", "setMCurrentStickyFooterSelection$materialdrawer", "(I)V", "mCustomView", "Landroid/view/View;", "getMCustomView$materialdrawer", "()Landroid/view/View;", "setMCustomView$materialdrawer", "(Landroid/view/View;)V", "mDelayDrawerClickEvent", "getMDelayDrawerClickEvent$materialdrawer", "setMDelayDrawerClickEvent$materialdrawer", "mDelayOnDrawerClose", "getMDelayOnDrawerClose$materialdrawer", "setMDelayOnDrawerClose$materialdrawer", "mDisplayBelowStatusBar", "getMDisplayBelowStatusBar$materialdrawer", "()Ljava/lang/Boolean;", "setMDisplayBelowStatusBar$materialdrawer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mDrawerGravity", "getMDrawerGravity$materialdrawer", "setMDrawerGravity$materialdrawer", "mDrawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getMDrawerLayout$materialdrawer", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setMDrawerLayout$materialdrawer", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "mDrawerWidth", "getMDrawerWidth$materialdrawer", "setMDrawerWidth$materialdrawer", "mExpandableExtension", "Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "getMExpandableExtension$materialdrawer", "()Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;", "setMExpandableExtension$materialdrawer", "(Lcom/mikepenz/fastadapter/expandable/ExpandableExtension;)V", "mFireInitialOnClick", "getMFireInitialOnClick$materialdrawer", "setMFireInitialOnClick$materialdrawer", "mFooterAdapter", "Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "getMFooterAdapter$materialdrawer", "()Lcom/mikepenz/fastadapter/adapters/ModelAdapter;", "setMFooterAdapter$materialdrawer", "(Lcom/mikepenz/fastadapter/adapters/ModelAdapter;)V", "mFooterClickable", "getMFooterClickable$materialdrawer", "setMFooterClickable$materialdrawer", "mFooterDivider", "getMFooterDivider$materialdrawer", "setMFooterDivider$materialdrawer", "mFooterView", "getMFooterView$materialdrawer", "setMFooterView$materialdrawer", "mFullscreen", "getMFullscreen$materialdrawer", "setMFullscreen$materialdrawer", "mGenerateMiniDrawer", "getMGenerateMiniDrawer$materialdrawer", "setMGenerateMiniDrawer$materialdrawer", "mHasStableIds", "getMHasStableIds$materialdrawer", "setMHasStableIds$materialdrawer", "mHeaderAdapter", "getMHeaderAdapter$materialdrawer", "setMHeaderAdapter$materialdrawer", "mHeaderDivider", "getMHeaderDivider$materialdrawer", "setMHeaderDivider$materialdrawer", "mHeaderPadding", "getMHeaderPadding$materialdrawer", "setMHeaderPadding$materialdrawer", "mHeaderView", "getMHeaderView$materialdrawer", "setMHeaderView$materialdrawer", "mHeiderHeight", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "getMHeiderHeight$materialdrawer", "()Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "setMHeiderHeight$materialdrawer", "(Lcom/mikepenz/materialdrawer/holder/DimenHolder;)V", "mInnerShadow", "mItemAdapter", "getMItemAdapter$materialdrawer", "setMItemAdapter$materialdrawer", "mItemAnimator", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "getMItemAnimator$materialdrawer", "()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "setMItemAnimator$materialdrawer", "(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V", "mKeepStickyItemsVisible", "getMKeepStickyItemsVisible$materialdrawer", "setMKeepStickyItemsVisible$materialdrawer", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getMLayoutManager$materialdrawer", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setMLayoutManager$materialdrawer", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "mMaterialize", "Lcom/mikepenz/materialize/Materialize;", "getMMaterialize$materialdrawer", "()Lcom/mikepenz/materialize/Materialize;", "setMMaterialize$materialdrawer", "(Lcom/mikepenz/materialize/Materialize;)V", "mMiniDrawer", "Lcom/mikepenz/materialdrawer/MiniDrawer;", "getMMiniDrawer$materialdrawer", "()Lcom/mikepenz/materialdrawer/MiniDrawer;", "setMMiniDrawer$materialdrawer", "(Lcom/mikepenz/materialdrawer/MiniDrawer;)V", "mMultiSelect", "getMMultiSelect$materialdrawer", "setMMultiSelect$materialdrawer", "mOnDrawerItemClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "getMOnDrawerItemClickListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;", "setMOnDrawerItemClickListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemClickListener;)V", "mOnDrawerItemLongClickListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "getMOnDrawerItemLongClickListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;", "setMOnDrawerItemLongClickListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerItemLongClickListener;)V", "mOnDrawerListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerListener;", "getMOnDrawerListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerListener;", "setMOnDrawerListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerListener;)V", "mOnDrawerNavigationListener", "Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;", "getMOnDrawerNavigationListener$materialdrawer", "()Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;", "setMOnDrawerNavigationListener$materialdrawer", "(Lcom/mikepenz/materialdrawer/Drawer$OnDrawerNavigationListener;)V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView$materialdrawer", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView$materialdrawer", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView$materialdrawer", "()Landroid/view/ViewGroup;", "setMRootView$materialdrawer", "(Landroid/view/ViewGroup;)V", "mSavedInstance", "Landroid/os/Bundle;", "getMSavedInstance$materialdrawer", "()Landroid/os/Bundle;", "setMSavedInstance$materialdrawer", "(Landroid/os/Bundle;)V", "mScrollToTopAfterClick", "getMScrollToTopAfterClick$materialdrawer", "setMScrollToTopAfterClick$materialdrawer", "mSelectExtension", "Lcom/mikepenz/fastadapter/select/SelectExtension;", "getMSelectExtension$materialdrawer", "()Lcom/mikepenz/fastadapter/select/SelectExtension;", "setMSelectExtension$materialdrawer", "(Lcom/mikepenz/fastadapter/select/SelectExtension;)V", "mSelectedItemIdentifier", "", "getMSelectedItemIdentifier$materialdrawer", "()J", "setMSelectedItemIdentifier$materialdrawer", "(J)V", "mSelectedItemPosition", "getMSelectedItemPosition$materialdrawer", "setMSelectedItemPosition$materialdrawer", "mSharedPreferences", "Landroid/content/SharedPreferences;", "getMSharedPreferences$materialdrawer", "()Landroid/content/SharedPreferences;", "setMSharedPreferences$materialdrawer", "(Landroid/content/SharedPreferences;)V", "mShowDrawerOnFirstLaunch", "getMShowDrawerOnFirstLaunch$materialdrawer", "setMShowDrawerOnFirstLaunch$materialdrawer", "mShowDrawerUntilDraggedOpened", "getMShowDrawerUntilDraggedOpened$materialdrawer", "setMShowDrawerUntilDraggedOpened$materialdrawer", "mSliderBackgroundColor", "getMSliderBackgroundColor$materialdrawer", "setMSliderBackgroundColor$materialdrawer", "mSliderBackgroundColorRes", "getMSliderBackgroundColorRes$materialdrawer", "setMSliderBackgroundColorRes$materialdrawer", "mSliderBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getMSliderBackgroundDrawable$materialdrawer", "()Landroid/graphics/drawable/Drawable;", "setMSliderBackgroundDrawable$materialdrawer", "(Landroid/graphics/drawable/Drawable;)V", "mSliderBackgroundDrawableRes", "getMSliderBackgroundDrawableRes$materialdrawer", "setMSliderBackgroundDrawableRes$materialdrawer", "mSliderLayout", "Lcom/mikepenz/materialize/view/ScrimInsetsRelativeLayout;", "getMSliderLayout$materialdrawer", "()Lcom/mikepenz/materialize/view/ScrimInsetsRelativeLayout;", "setMSliderLayout$materialdrawer", "(Lcom/mikepenz/materialize/view/ScrimInsetsRelativeLayout;)V", "mStickyDrawerItems", "", "getMStickyDrawerItems$materialdrawer", "()Ljava/util/List;", "setMStickyDrawerItems$materialdrawer", "(Ljava/util/List;)V", "mStickyFooterDivider", "getMStickyFooterDivider$materialdrawer", "setMStickyFooterDivider$materialdrawer", "mStickyFooterShadow", "getMStickyFooterShadow$materialdrawer", "setMStickyFooterShadow$materialdrawer", "mStickyFooterShadowView", "getMStickyFooterShadowView$materialdrawer", "setMStickyFooterShadowView$materialdrawer", "mStickyFooterView", "getMStickyFooterView$materialdrawer", "setMStickyFooterView$materialdrawer", "mStickyHeaderShadow", "getMStickyHeaderShadow$materialdrawer", "setMStickyHeaderShadow$materialdrawer", "mStickyHeaderView", "getMStickyHeaderView$materialdrawer", "setMStickyHeaderView$materialdrawer", "mSystemUIHidden", "getMSystemUIHidden$materialdrawer", "setMSystemUIHidden$materialdrawer", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "getMToolbar$materialdrawer", "()Landroidx/appcompat/widget/Toolbar;", "setMToolbar$materialdrawer", "(Landroidx/appcompat/widget/Toolbar;)V", "mTranslucentNavigationBar", "getMTranslucentNavigationBar$materialdrawer", "setMTranslucentNavigationBar$materialdrawer", "mTranslucentNavigationBarProgrammatically", "getMTranslucentNavigationBarProgrammatically$materialdrawer", "setMTranslucentNavigationBarProgrammatically$materialdrawer", "mTranslucentStatusBar", "getMTranslucentStatusBar$materialdrawer", "setMTranslucentStatusBar$materialdrawer", "mUsed", "getMUsed$materialdrawer", "setMUsed$materialdrawer", "selectExtension", "getSelectExtension$materialdrawer", "addDrawerItems", "drawerItems", "", "([Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;)Lcom/mikepenz/materialdrawer/DrawerBuilder;", "addMenuItems", "", "mMenu", "Landroid/view/Menu;", "subMenu", "addStickyDrawerItems", "stickyDrawerItems", "append", "Lcom/mikepenz/materialdrawer/Drawer;", "result", "build", "buildForFragment", "buildView", "checkDrawerItem", "position", "includeOffset", "checkDrawerItem$materialdrawer", "closeDrawerDelayed", "closeDrawerDelayed$materialdrawer", "createContent", "getDrawerItem", "getDrawerItem$materialdrawer", "handleDrawerNavigation", "recreateActionBarDrawerToggle", "handleDrawerNavigation$materialdrawer", "handleShowOnLaunch", "inflateMenu", "menuRes", "initAdapter", "resetStickyFooterSelection", "resetStickyFooterSelection$materialdrawer", "withAccountHeader", "accountHeader", "accountHeaderSticky", "withActionBarDrawerToggle", "actionBarDrawerToggle", "actionBarDrawerToggleEnabled", "withActionBarDrawerToggleAnimated", "actionBarDrawerToggleAnimated", "withActivity", "withAdapter", "adaptr", "withAdapterWrapper", "withCloseOnClick", "closeOnClick", "withCustomView", "customView", "withDelayDrawerClickEvent", "delayDrawerClickEvent", "withDelayOnDrawerClose", "delayOnDrawerClose", "withDisplayBelowStatusBar", "displayBelowStatusBar", "withDrawerGravity", "gravity", "withDrawerItems", "", "withDrawerLayout", "drawerLayout", "resLayout", "withDrawerWidthDp", "drawerWidthDp", "withDrawerWidthPx", "drawerWidthPx", "withDrawerWidthRes", "drawerWidthRes", "withFireOnInitialOnClick", "fireOnInitialOnClick", "withFooter", "footerView", "footerViewRes", "withFooterClickable", "footerClickable", "withFooterDivider", "footerDivider", "withFullscreen", "fullscreen", "withGenerateMiniDrawer", "generateMiniDrawer", "withHasStableIds", "hasStableIds", "withHeader", "headerView", "headerViewRes", "withHeaderDivider", "headerDivider", "withHeaderHeight", "headerHeight", "withHeaderPadding", "headerPadding", "withInnerShadow", "innerShadow", "withItemAnimator", "itemAnimator", "withKeepStickyItemsVisible", "keepStickyItemsVisible", "withMultiSelect", "multiSelect", "withOnDrawerItemClickListener", "onDrawerItemClickListener", "withOnDrawerItemLongClickListener", "onDrawerItemLongClickListener", "withOnDrawerListener", "onDrawerListener", "withOnDrawerNavigationListener", "onDrawerNavigationListener", "withRecyclerView", "recyclerView", "withRootView", "rootView", "rootViewRes", "withSavedInstance", "savedInstance", "withScrollToTopAfterClick", "scrollToTopAfterClick", "withSelectedItem", "selectedItemIdentifier", "withSelectedItemByPosition", "selectedItemPosition", "withSharedPreferences", "sharedPreferences", "withShowDrawerOnFirstLaunch", "showDrawerOnFirstLaunch", "withShowDrawerUntilDraggedOpened", "showDrawerUntilDraggedOpened", "withSliderBackgroundColor", "sliderBackgroundColor", "withSliderBackgroundColorRes", "sliderBackgroundColorRes", "withSliderBackgroundDrawable", "sliderBackgroundDrawable", "withSliderBackgroundDrawableRes", "sliderBackgroundDrawableRes", "withStickyDrawerItems", "withStickyFooter", "stickyFooter", "stickyFooterRes", "withStickyFooterDivider", "stickyFooterDivider", "withStickyFooterShadow", "stickyFooterShadow", "withStickyHeader", "stickyHeader", "stickyHeaderRes", "withStickyHeaderShadow", "stickyHeaderShadow", "withSystemUIHidden", "systemUIHidden", "withToolbar", "toolbar", "withTranslucentNavigationBar", "translucentNavigationBar", "withTranslucentNavigationBarProgrammatically", "translucentNavigationBarProgrammatically", "withTranslucentStatusBar", "translucentStatusBar", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerBuilder.kt */
public class DrawerBuilder {
    public FastAdapter<IDrawerItem<?>> _adapter;
    private RecyclerView.Adapter<?> adapterWrapper;
    private final DefaultIdDistributor<IIdentifyable> idDistributor = new DefaultIdDistributorImpl();
    private AccountHeader mAccountHeader;
    private boolean mAccountHeaderSticky;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private boolean mActionBarDrawerToggleEnabled = true;
    private Activity mActivity;
    private boolean mAnimateActionBarDrawerToggle;
    private boolean mAppended;
    private boolean mCloseOnClick = true;
    private int mCurrentStickyFooterSelection = -1;
    private View mCustomView;
    private int mDelayDrawerClickEvent;
    private int mDelayOnDrawerClose = 50;
    private Boolean mDisplayBelowStatusBar;
    private int mDrawerGravity = 8388611;
    public DrawerLayout mDrawerLayout;
    private int mDrawerWidth = -1;
    public ExpandableExtension<IDrawerItem<?>> mExpandableExtension;
    private boolean mFireInitialOnClick;
    private ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> mFooterAdapter = new ItemAdapter();
    private boolean mFooterClickable;
    private boolean mFooterDivider = true;
    private View mFooterView;
    private boolean mFullscreen;
    private boolean mGenerateMiniDrawer;
    private boolean mHasStableIds;
    private ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> mHeaderAdapter = new ItemAdapter();
    private boolean mHeaderDivider = true;
    private boolean mHeaderPadding = true;
    private View mHeaderView;
    private DimenHolder mHeiderHeight;
    private boolean mInnerShadow;
    private ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> mItemAdapter = new ItemAdapter();
    private RecyclerView.ItemAnimator mItemAnimator = new DefaultItemAnimator();
    private boolean mKeepStickyItemsVisible;
    public RecyclerView.LayoutManager mLayoutManager;
    public Materialize mMaterialize;
    private MiniDrawer mMiniDrawer;
    private boolean mMultiSelect;
    private Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;
    private Drawer.OnDrawerItemLongClickListener mOnDrawerItemLongClickListener;
    private Drawer.OnDrawerListener mOnDrawerListener;
    private Drawer.OnDrawerNavigationListener mOnDrawerNavigationListener;
    public RecyclerView mRecyclerView;
    public ViewGroup mRootView;
    private Bundle mSavedInstance;
    private boolean mScrollToTopAfterClick;
    public SelectExtension<IDrawerItem<?>> mSelectExtension;
    private long mSelectedItemIdentifier;
    private int mSelectedItemPosition;
    private SharedPreferences mSharedPreferences;
    private boolean mShowDrawerOnFirstLaunch;
    private boolean mShowDrawerUntilDraggedOpened;
    private int mSliderBackgroundColor;
    private int mSliderBackgroundColorRes = -1;
    private Drawable mSliderBackgroundDrawable;
    private int mSliderBackgroundDrawableRes = -1;
    public ScrimInsetsRelativeLayout mSliderLayout;
    private List<IDrawerItem<?>> mStickyDrawerItems = new ArrayList();
    private boolean mStickyFooterDivider;
    private boolean mStickyFooterShadow = true;
    private View mStickyFooterShadowView;
    private ViewGroup mStickyFooterView;
    private boolean mStickyHeaderShadow = true;
    private View mStickyHeaderView;
    private boolean mSystemUIHidden;
    private Toolbar mToolbar;
    private boolean mTranslucentNavigationBar;
    private boolean mTranslucentNavigationBarProgrammatically;
    private boolean mTranslucentStatusBar = true;
    private boolean mUsed;

    public final DrawerBuilder withAccountHeader(AccountHeader accountHeader) {
        return withAccountHeader$default(this, accountHeader, false, 2, (Object) null);
    }

    public final boolean getMUsed$materialdrawer() {
        return this.mUsed;
    }

    public final void setMUsed$materialdrawer(boolean z) {
        this.mUsed = z;
    }

    public final int getMCurrentStickyFooterSelection$materialdrawer() {
        return this.mCurrentStickyFooterSelection;
    }

    public final void setMCurrentStickyFooterSelection$materialdrawer(int i) {
        this.mCurrentStickyFooterSelection = i;
    }

    public final boolean getMAppended$materialdrawer() {
        return this.mAppended;
    }

    public final void setMAppended$materialdrawer(boolean z) {
        this.mAppended = z;
    }

    public final Activity getMActivity$materialdrawer() {
        return this.mActivity;
    }

    public final void setMActivity$materialdrawer(Activity activity) {
        this.mActivity = activity;
    }

    public final RecyclerView.LayoutManager getMLayoutManager$materialdrawer() {
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
        }
        return layoutManager;
    }

    public final void setMLayoutManager$materialdrawer(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkParameterIsNotNull(layoutManager, "<set-?>");
        this.mLayoutManager = layoutManager;
    }

    public final ViewGroup getMRootView$materialdrawer() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        return viewGroup;
    }

    public final void setMRootView$materialdrawer(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "<set-?>");
        this.mRootView = viewGroup;
    }

    public final Materialize getMMaterialize$materialdrawer() {
        Materialize materialize = this.mMaterialize;
        if (materialize == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaterialize");
        }
        return materialize;
    }

    public final void setMMaterialize$materialdrawer(Materialize materialize) {
        Intrinsics.checkParameterIsNotNull(materialize, "<set-?>");
        this.mMaterialize = materialize;
    }

    public final DefaultIdDistributor<IIdentifyable> getIdDistributor() {
        return this.idDistributor;
    }

    public final boolean getMTranslucentStatusBar$materialdrawer() {
        return this.mTranslucentStatusBar;
    }

    public final void setMTranslucentStatusBar$materialdrawer(boolean z) {
        this.mTranslucentStatusBar = z;
    }

    public final Boolean getMDisplayBelowStatusBar$materialdrawer() {
        return this.mDisplayBelowStatusBar;
    }

    public final void setMDisplayBelowStatusBar$materialdrawer(Boolean bool) {
        this.mDisplayBelowStatusBar = bool;
    }

    public final Toolbar getMToolbar$materialdrawer() {
        return this.mToolbar;
    }

    public final void setMToolbar$materialdrawer(Toolbar toolbar) {
        this.mToolbar = toolbar;
    }

    public final boolean getMTranslucentNavigationBar$materialdrawer() {
        return this.mTranslucentNavigationBar;
    }

    public final void setMTranslucentNavigationBar$materialdrawer(boolean z) {
        this.mTranslucentNavigationBar = z;
    }

    public final boolean getMTranslucentNavigationBarProgrammatically$materialdrawer() {
        return this.mTranslucentNavigationBarProgrammatically;
    }

    public final void setMTranslucentNavigationBarProgrammatically$materialdrawer(boolean z) {
        this.mTranslucentNavigationBarProgrammatically = z;
    }

    public final boolean getMFullscreen$materialdrawer() {
        return this.mFullscreen;
    }

    public final void setMFullscreen$materialdrawer(boolean z) {
        this.mFullscreen = z;
    }

    public final boolean getMSystemUIHidden$materialdrawer() {
        return this.mSystemUIHidden;
    }

    public final void setMSystemUIHidden$materialdrawer(boolean z) {
        this.mSystemUIHidden = z;
    }

    public final View getMCustomView$materialdrawer() {
        return this.mCustomView;
    }

    public final void setMCustomView$materialdrawer(View view) {
        this.mCustomView = view;
    }

    public final DrawerLayout getMDrawerLayout$materialdrawer() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
        }
        return drawerLayout;
    }

    public final void setMDrawerLayout$materialdrawer(DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(drawerLayout, "<set-?>");
        this.mDrawerLayout = drawerLayout;
    }

    public final ScrimInsetsRelativeLayout getMSliderLayout$materialdrawer() {
        ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = this.mSliderLayout;
        if (scrimInsetsRelativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
        }
        return scrimInsetsRelativeLayout;
    }

    public final void setMSliderLayout$materialdrawer(ScrimInsetsRelativeLayout scrimInsetsRelativeLayout) {
        Intrinsics.checkParameterIsNotNull(scrimInsetsRelativeLayout, "<set-?>");
        this.mSliderLayout = scrimInsetsRelativeLayout;
    }

    public final int getMSliderBackgroundColor$materialdrawer() {
        return this.mSliderBackgroundColor;
    }

    public final void setMSliderBackgroundColor$materialdrawer(int i) {
        this.mSliderBackgroundColor = i;
    }

    public final int getMSliderBackgroundColorRes$materialdrawer() {
        return this.mSliderBackgroundColorRes;
    }

    public final void setMSliderBackgroundColorRes$materialdrawer(int i) {
        this.mSliderBackgroundColorRes = i;
    }

    public final Drawable getMSliderBackgroundDrawable$materialdrawer() {
        return this.mSliderBackgroundDrawable;
    }

    public final void setMSliderBackgroundDrawable$materialdrawer(Drawable drawable) {
        this.mSliderBackgroundDrawable = drawable;
    }

    public final int getMSliderBackgroundDrawableRes$materialdrawer() {
        return this.mSliderBackgroundDrawableRes;
    }

    public final void setMSliderBackgroundDrawableRes$materialdrawer(int i) {
        this.mSliderBackgroundDrawableRes = i;
    }

    public final int getMDrawerWidth$materialdrawer() {
        return this.mDrawerWidth;
    }

    public final void setMDrawerWidth$materialdrawer(int i) {
        this.mDrawerWidth = i;
    }

    public final int getMDrawerGravity$materialdrawer() {
        return this.mDrawerGravity;
    }

    public final void setMDrawerGravity$materialdrawer(int i) {
        this.mDrawerGravity = i;
    }

    public final AccountHeader getMAccountHeader$materialdrawer() {
        return this.mAccountHeader;
    }

    public final void setMAccountHeader$materialdrawer(AccountHeader accountHeader) {
        this.mAccountHeader = accountHeader;
    }

    public final boolean getMAccountHeaderSticky$materialdrawer() {
        return this.mAccountHeaderSticky;
    }

    public final void setMAccountHeaderSticky$materialdrawer(boolean z) {
        this.mAccountHeaderSticky = z;
    }

    public final boolean getMAnimateActionBarDrawerToggle$materialdrawer() {
        return this.mAnimateActionBarDrawerToggle;
    }

    public final void setMAnimateActionBarDrawerToggle$materialdrawer(boolean z) {
        this.mAnimateActionBarDrawerToggle = z;
    }

    public final boolean getMActionBarDrawerToggleEnabled$materialdrawer() {
        return this.mActionBarDrawerToggleEnabled;
    }

    public final void setMActionBarDrawerToggleEnabled$materialdrawer(boolean z) {
        this.mActionBarDrawerToggleEnabled = z;
    }

    public final ActionBarDrawerToggle getMActionBarDrawerToggle$materialdrawer() {
        return this.mActionBarDrawerToggle;
    }

    public final void setMActionBarDrawerToggle$materialdrawer(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.mActionBarDrawerToggle = actionBarDrawerToggle;
    }

    public final boolean getMScrollToTopAfterClick$materialdrawer() {
        return this.mScrollToTopAfterClick;
    }

    public final void setMScrollToTopAfterClick$materialdrawer(boolean z) {
        this.mScrollToTopAfterClick = z;
    }

    public final View getMHeaderView$materialdrawer() {
        return this.mHeaderView;
    }

    public final void setMHeaderView$materialdrawer(View view) {
        this.mHeaderView = view;
    }

    public final boolean getMHeaderDivider$materialdrawer() {
        return this.mHeaderDivider;
    }

    public final void setMHeaderDivider$materialdrawer(boolean z) {
        this.mHeaderDivider = z;
    }

    public final boolean getMHeaderPadding$materialdrawer() {
        return this.mHeaderPadding;
    }

    public final void setMHeaderPadding$materialdrawer(boolean z) {
        this.mHeaderPadding = z;
    }

    public final DimenHolder getMHeiderHeight$materialdrawer() {
        return this.mHeiderHeight;
    }

    public final void setMHeiderHeight$materialdrawer(DimenHolder dimenHolder) {
        this.mHeiderHeight = dimenHolder;
    }

    public final View getMStickyHeaderView$materialdrawer() {
        return this.mStickyHeaderView;
    }

    public final void setMStickyHeaderView$materialdrawer(View view) {
        this.mStickyHeaderView = view;
    }

    public final boolean getMStickyHeaderShadow$materialdrawer() {
        return this.mStickyHeaderShadow;
    }

    public final void setMStickyHeaderShadow$materialdrawer(boolean z) {
        this.mStickyHeaderShadow = z;
    }

    public final View getMFooterView$materialdrawer() {
        return this.mFooterView;
    }

    public final void setMFooterView$materialdrawer(View view) {
        this.mFooterView = view;
    }

    public final boolean getMFooterDivider$materialdrawer() {
        return this.mFooterDivider;
    }

    public final void setMFooterDivider$materialdrawer(boolean z) {
        this.mFooterDivider = z;
    }

    public final boolean getMFooterClickable$materialdrawer() {
        return this.mFooterClickable;
    }

    public final void setMFooterClickable$materialdrawer(boolean z) {
        this.mFooterClickable = z;
    }

    public final ViewGroup getMStickyFooterView$materialdrawer() {
        return this.mStickyFooterView;
    }

    public final void setMStickyFooterView$materialdrawer(ViewGroup viewGroup) {
        this.mStickyFooterView = viewGroup;
    }

    public final boolean getMStickyFooterDivider$materialdrawer() {
        return this.mStickyFooterDivider;
    }

    public final void setMStickyFooterDivider$materialdrawer(boolean z) {
        this.mStickyFooterDivider = z;
    }

    public final View getMStickyFooterShadowView$materialdrawer() {
        return this.mStickyFooterShadowView;
    }

    public final void setMStickyFooterShadowView$materialdrawer(View view) {
        this.mStickyFooterShadowView = view;
    }

    public final boolean getMStickyFooterShadow$materialdrawer() {
        return this.mStickyFooterShadow;
    }

    public final void setMStickyFooterShadow$materialdrawer(boolean z) {
        this.mStickyFooterShadow = z;
    }

    public final boolean getMFireInitialOnClick$materialdrawer() {
        return this.mFireInitialOnClick;
    }

    public final void setMFireInitialOnClick$materialdrawer(boolean z) {
        this.mFireInitialOnClick = z;
    }

    public final boolean getMMultiSelect$materialdrawer() {
        return this.mMultiSelect;
    }

    public final void setMMultiSelect$materialdrawer(boolean z) {
        this.mMultiSelect = z;
    }

    public final int getMSelectedItemPosition$materialdrawer() {
        return this.mSelectedItemPosition;
    }

    public final void setMSelectedItemPosition$materialdrawer(int i) {
        this.mSelectedItemPosition = i;
    }

    public final long getMSelectedItemIdentifier$materialdrawer() {
        return this.mSelectedItemIdentifier;
    }

    public final void setMSelectedItemIdentifier$materialdrawer(long j) {
        this.mSelectedItemIdentifier = j;
    }

    public final RecyclerView getMRecyclerView$materialdrawer() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        }
        return recyclerView;
    }

    public final void setMRecyclerView$materialdrawer(RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }

    public final boolean getMHasStableIds$materialdrawer() {
        return this.mHasStableIds;
    }

    public final void setMHasStableIds$materialdrawer(boolean z) {
        this.mHasStableIds = z;
    }

    public final FastAdapter<IDrawerItem<?>> get_adapter$materialdrawer() {
        FastAdapter<IDrawerItem<?>> fastAdapter = this._adapter;
        if (fastAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_adapter");
        }
        return fastAdapter;
    }

    public final void set_adapter$materialdrawer(FastAdapter<IDrawerItem<?>> fastAdapter) {
        Intrinsics.checkParameterIsNotNull(fastAdapter, "<set-?>");
        this._adapter = fastAdapter;
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getMHeaderAdapter$materialdrawer() {
        return this.mHeaderAdapter;
    }

    public final void setMHeaderAdapter$materialdrawer(ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> modelAdapter) {
        Intrinsics.checkParameterIsNotNull(modelAdapter, "<set-?>");
        this.mHeaderAdapter = modelAdapter;
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getMItemAdapter$materialdrawer() {
        return this.mItemAdapter;
    }

    public final void setMItemAdapter$materialdrawer(ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> modelAdapter) {
        Intrinsics.checkParameterIsNotNull(modelAdapter, "<set-?>");
        this.mItemAdapter = modelAdapter;
    }

    public final ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> getMFooterAdapter$materialdrawer() {
        return this.mFooterAdapter;
    }

    public final void setMFooterAdapter$materialdrawer(ModelAdapter<IDrawerItem<?>, IDrawerItem<?>> modelAdapter) {
        Intrinsics.checkParameterIsNotNull(modelAdapter, "<set-?>");
        this.mFooterAdapter = modelAdapter;
    }

    public final ExpandableExtension<IDrawerItem<?>> getMExpandableExtension$materialdrawer() {
        ExpandableExtension<IDrawerItem<?>> expandableExtension = this.mExpandableExtension;
        if (expandableExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandableExtension");
        }
        return expandableExtension;
    }

    public final void setMExpandableExtension$materialdrawer(ExpandableExtension<IDrawerItem<?>> expandableExtension) {
        Intrinsics.checkParameterIsNotNull(expandableExtension, "<set-?>");
        this.mExpandableExtension = expandableExtension;
    }

    public final SelectExtension<IDrawerItem<?>> getMSelectExtension$materialdrawer() {
        SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
        if (selectExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
        }
        return selectExtension;
    }

    public final void setMSelectExtension$materialdrawer(SelectExtension<IDrawerItem<?>> selectExtension) {
        Intrinsics.checkParameterIsNotNull(selectExtension, "<set-?>");
        this.mSelectExtension = selectExtension;
    }

    public final FastAdapter<IDrawerItem<?>> getAdapter$materialdrawer() {
        if (this._adapter == null) {
            FastAdapter<IDrawerItem<?>> with = FastAdapter.Companion.with(Arrays.asList(new ModelAdapter[]{this.mHeaderAdapter, this.mItemAdapter, this.mFooterAdapter}));
            this._adapter = with;
            if (with == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_adapter");
            }
            with.setHasStableIds(this.mHasStableIds);
            initAdapter();
            SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
            if (selectExtension == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension.setSelectable(true);
            SelectExtension<IDrawerItem<?>> selectExtension2 = this.mSelectExtension;
            if (selectExtension2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension2.setMultiSelect(false);
            SelectExtension<IDrawerItem<?>> selectExtension3 = this.mSelectExtension;
            if (selectExtension3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension3.setAllowDeselection(false);
        }
        FastAdapter<IDrawerItem<?>> fastAdapter = this._adapter;
        if (fastAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_adapter");
        }
        return fastAdapter;
    }

    public final void setAdapter$materialdrawer(FastAdapter<IDrawerItem<?>> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._adapter = value;
    }

    public final SelectExtension<IDrawerItem<?>> getSelectExtension$materialdrawer() {
        getAdapter$materialdrawer();
        SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
        if (selectExtension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
        }
        return selectExtension;
    }

    public final IItemAdapter<IDrawerItem<?>, IDrawerItem<?>> getItemAdapter$materialdrawer() {
        return this.mItemAdapter;
    }

    public final IItemAdapter<IDrawerItem<?>, IDrawerItem<?>> getHeaderAdapter$materialdrawer() {
        return this.mHeaderAdapter;
    }

    public final IItemAdapter<IDrawerItem<?>, IDrawerItem<?>> getFooterAdapter$materialdrawer() {
        return this.mFooterAdapter;
    }

    public final RecyclerView.Adapter<?> getAdapterWrapper$materialdrawer() {
        return this.adapterWrapper;
    }

    public final void setAdapterWrapper$materialdrawer(RecyclerView.Adapter<?> adapter) {
        this.adapterWrapper = adapter;
    }

    public final RecyclerView.ItemAnimator getMItemAnimator$materialdrawer() {
        return this.mItemAnimator;
    }

    public final void setMItemAnimator$materialdrawer(RecyclerView.ItemAnimator itemAnimator) {
        Intrinsics.checkParameterIsNotNull(itemAnimator, "<set-?>");
        this.mItemAnimator = itemAnimator;
    }

    public final boolean getMKeepStickyItemsVisible$materialdrawer() {
        return this.mKeepStickyItemsVisible;
    }

    public final void setMKeepStickyItemsVisible$materialdrawer(boolean z) {
        this.mKeepStickyItemsVisible = z;
    }

    public final List<IDrawerItem<?>> getMStickyDrawerItems$materialdrawer() {
        return this.mStickyDrawerItems;
    }

    public final void setMStickyDrawerItems$materialdrawer(List<IDrawerItem<?>> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.mStickyDrawerItems = list;
    }

    public final boolean getMCloseOnClick$materialdrawer() {
        return this.mCloseOnClick;
    }

    public final void setMCloseOnClick$materialdrawer(boolean z) {
        this.mCloseOnClick = z;
    }

    public final int getMDelayOnDrawerClose$materialdrawer() {
        return this.mDelayOnDrawerClose;
    }

    public final void setMDelayOnDrawerClose$materialdrawer(int i) {
        this.mDelayOnDrawerClose = i;
    }

    public final int getMDelayDrawerClickEvent$materialdrawer() {
        return this.mDelayDrawerClickEvent;
    }

    public final void setMDelayDrawerClickEvent$materialdrawer(int i) {
        this.mDelayDrawerClickEvent = i;
    }

    public final Drawer.OnDrawerListener getMOnDrawerListener$materialdrawer() {
        return this.mOnDrawerListener;
    }

    public final void setMOnDrawerListener$materialdrawer(Drawer.OnDrawerListener onDrawerListener) {
        this.mOnDrawerListener = onDrawerListener;
    }

    public final Drawer.OnDrawerItemClickListener getMOnDrawerItemClickListener$materialdrawer() {
        return this.mOnDrawerItemClickListener;
    }

    public final void setMOnDrawerItemClickListener$materialdrawer(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
    }

    public final Drawer.OnDrawerItemLongClickListener getMOnDrawerItemLongClickListener$materialdrawer() {
        return this.mOnDrawerItemLongClickListener;
    }

    public final void setMOnDrawerItemLongClickListener$materialdrawer(Drawer.OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        this.mOnDrawerItemLongClickListener = onDrawerItemLongClickListener;
    }

    public final Drawer.OnDrawerNavigationListener getMOnDrawerNavigationListener$materialdrawer() {
        return this.mOnDrawerNavigationListener;
    }

    public final void setMOnDrawerNavigationListener$materialdrawer(Drawer.OnDrawerNavigationListener onDrawerNavigationListener) {
        this.mOnDrawerNavigationListener = onDrawerNavigationListener;
    }

    public final boolean getMShowDrawerOnFirstLaunch$materialdrawer() {
        return this.mShowDrawerOnFirstLaunch;
    }

    public final void setMShowDrawerOnFirstLaunch$materialdrawer(boolean z) {
        this.mShowDrawerOnFirstLaunch = z;
    }

    public final boolean getMShowDrawerUntilDraggedOpened$materialdrawer() {
        return this.mShowDrawerUntilDraggedOpened;
    }

    public final void setMShowDrawerUntilDraggedOpened$materialdrawer(boolean z) {
        this.mShowDrawerUntilDraggedOpened = z;
    }

    public final boolean getMGenerateMiniDrawer$materialdrawer() {
        return this.mGenerateMiniDrawer;
    }

    public final void setMGenerateMiniDrawer$materialdrawer(boolean z) {
        this.mGenerateMiniDrawer = z;
    }

    public final MiniDrawer getMMiniDrawer$materialdrawer() {
        return this.mMiniDrawer;
    }

    public final void setMMiniDrawer$materialdrawer(MiniDrawer miniDrawer) {
        this.mMiniDrawer = miniDrawer;
    }

    public final Bundle getMSavedInstance$materialdrawer() {
        return this.mSavedInstance;
    }

    public final void setMSavedInstance$materialdrawer(Bundle bundle) {
        this.mSavedInstance = bundle;
    }

    public final SharedPreferences getMSharedPreferences$materialdrawer() {
        return this.mSharedPreferences;
    }

    public final void setMSharedPreferences$materialdrawer(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    public DrawerBuilder() {
        getAdapter$materialdrawer();
    }

    public DrawerBuilder(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "activity.findViewById<Vi…up>(android.R.id.content)");
        this.mRootView = (ViewGroup) findViewById;
        this.mActivity = activity;
        this.mLayoutManager = new LinearLayoutManager(this.mActivity);
        getAdapter$materialdrawer();
    }

    public final DrawerBuilder withActivity(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "activity.findViewById<Vi…up>(android.R.id.content)");
        this.mRootView = (ViewGroup) findViewById;
        this.mActivity = activity;
        this.mLayoutManager = new LinearLayoutManager(this.mActivity);
        return this;
    }

    public final DrawerBuilder withRootView(ViewGroup rootView) {
        Intrinsics.checkParameterIsNotNull(rootView, "rootView");
        this.mRootView = rootView;
        withTranslucentStatusBar(false);
        return this;
    }

    public final DrawerBuilder withRootView(int rootViewRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            View findViewById = mActivity2.findViewById(rootViewRes);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mActivity.findViewById<ViewGroup>(rootViewRes)");
            return withRootView((ViewGroup) findViewById);
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withTranslucentStatusBar(boolean translucentStatusBar) {
        this.mTranslucentStatusBar = translucentStatusBar;
        return this;
    }

    public final DrawerBuilder withDisplayBelowStatusBar(boolean displayBelowStatusBar) {
        this.mDisplayBelowStatusBar = Boolean.valueOf(displayBelowStatusBar);
        return this;
    }

    public final DrawerBuilder withInnerShadow(boolean innerShadow) {
        this.mInnerShadow = innerShadow;
        return this;
    }

    public final DrawerBuilder withToolbar(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
        this.mToolbar = toolbar;
        return this;
    }

    public final DrawerBuilder withTranslucentNavigationBar(boolean translucentNavigationBar) {
        this.mTranslucentNavigationBar = translucentNavigationBar;
        if (!translucentNavigationBar) {
            this.mTranslucentNavigationBarProgrammatically = false;
        }
        return this;
    }

    public final DrawerBuilder withTranslucentNavigationBarProgrammatically(boolean translucentNavigationBarProgrammatically) {
        this.mTranslucentNavigationBarProgrammatically = translucentNavigationBarProgrammatically;
        if (translucentNavigationBarProgrammatically) {
            this.mTranslucentNavigationBar = true;
        }
        return this;
    }

    public final DrawerBuilder withFullscreen(boolean fullscreen) {
        this.mFullscreen = fullscreen;
        if (fullscreen) {
            withTranslucentStatusBar(true);
            withTranslucentNavigationBar(false);
        }
        return this;
    }

    public final DrawerBuilder withSystemUIHidden(boolean systemUIHidden) {
        this.mSystemUIHidden = systemUIHidden;
        if (systemUIHidden) {
            withFullscreen(systemUIHidden);
        }
        return this;
    }

    public final DrawerBuilder withCustomView(View customView) {
        Intrinsics.checkParameterIsNotNull(customView, "customView");
        this.mCustomView = customView;
        return this;
    }

    public final DrawerBuilder withDrawerLayout(DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(drawerLayout, "drawerLayout");
        this.mDrawerLayout = drawerLayout;
        return this;
    }

    public final DrawerBuilder withDrawerLayout(int resLayout) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (resLayout != -1) {
                LayoutInflater layoutInflater = mActivity2.getLayoutInflater();
                ViewGroup viewGroup = this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                View inflate = layoutInflater.inflate(resLayout, viewGroup, false);
                if (inflate != null) {
                    this.mDrawerLayout = (DrawerLayout) inflate;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
                }
            } else if (Build.VERSION.SDK_INT < 21) {
                LayoutInflater layoutInflater2 = mActivity2.getLayoutInflater();
                int i = R.layout.material_drawer_fits_not;
                ViewGroup viewGroup2 = this.mRootView;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                View inflate2 = layoutInflater2.inflate(i, viewGroup2, false);
                if (inflate2 != null) {
                    this.mDrawerLayout = (DrawerLayout) inflate2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
                }
            } else {
                LayoutInflater layoutInflater3 = mActivity2.getLayoutInflater();
                int i2 = R.layout.material_drawer;
                ViewGroup viewGroup3 = this.mRootView;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                View inflate3 = layoutInflater3.inflate(i2, viewGroup3, false);
                if (inflate3 != null) {
                    this.mDrawerLayout = (DrawerLayout) inflate3;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
                }
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withSliderBackgroundColor(int sliderBackgroundColor) {
        this.mSliderBackgroundColor = sliderBackgroundColor;
        return this;
    }

    public final DrawerBuilder withSliderBackgroundColorRes(int sliderBackgroundColorRes) {
        this.mSliderBackgroundColorRes = sliderBackgroundColorRes;
        return this;
    }

    public final DrawerBuilder withSliderBackgroundDrawable(Drawable sliderBackgroundDrawable) {
        Intrinsics.checkParameterIsNotNull(sliderBackgroundDrawable, "sliderBackgroundDrawable");
        this.mSliderBackgroundDrawable = sliderBackgroundDrawable;
        return this;
    }

    public final DrawerBuilder withSliderBackgroundDrawableRes(int sliderBackgroundDrawableRes) {
        this.mSliderBackgroundDrawableRes = sliderBackgroundDrawableRes;
        return this;
    }

    public final DrawerBuilder withDrawerWidthPx(int drawerWidthPx) {
        this.mDrawerWidth = drawerWidthPx;
        return this;
    }

    public final DrawerBuilder withDrawerWidthDp(int drawerWidthDp) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            this.mDrawerWidth = (int) UIUtils.convertDpToPixel((float) drawerWidthDp, mActivity2);
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withDrawerWidthRes(int drawerWidthRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            this.mDrawerWidth = mActivity2.getResources().getDimensionPixelSize(drawerWidthRes);
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withDrawerGravity(int gravity) {
        this.mDrawerGravity = gravity;
        return this;
    }

    public static /* synthetic */ DrawerBuilder withAccountHeader$default(DrawerBuilder drawerBuilder, AccountHeader accountHeader, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return drawerBuilder.withAccountHeader(accountHeader, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withAccountHeader");
    }

    public final DrawerBuilder withAccountHeader(AccountHeader accountHeader, boolean accountHeaderSticky) {
        Intrinsics.checkParameterIsNotNull(accountHeader, "accountHeader");
        this.mAccountHeader = accountHeader;
        this.mAccountHeaderSticky = accountHeaderSticky;
        return this;
    }

    public final DrawerBuilder withActionBarDrawerToggleAnimated(boolean actionBarDrawerToggleAnimated) {
        this.mAnimateActionBarDrawerToggle = actionBarDrawerToggleAnimated;
        return this;
    }

    public final DrawerBuilder withActionBarDrawerToggle(boolean actionBarDrawerToggleEnabled) {
        this.mActionBarDrawerToggleEnabled = actionBarDrawerToggleEnabled;
        return this;
    }

    public final DrawerBuilder withActionBarDrawerToggle(ActionBarDrawerToggle actionBarDrawerToggle) {
        Intrinsics.checkParameterIsNotNull(actionBarDrawerToggle, "actionBarDrawerToggle");
        this.mActionBarDrawerToggleEnabled = true;
        this.mActionBarDrawerToggle = actionBarDrawerToggle;
        return this;
    }

    public final DrawerBuilder withScrollToTopAfterClick(boolean scrollToTopAfterClick) {
        this.mScrollToTopAfterClick = scrollToTopAfterClick;
        return this;
    }

    public final DrawerBuilder withHeader(View headerView) {
        Intrinsics.checkParameterIsNotNull(headerView, "headerView");
        this.mHeaderView = headerView;
        return this;
    }

    public final DrawerBuilder withHeader(int headerViewRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (headerViewRes != -1) {
                this.mHeaderView = mActivity2.getLayoutInflater().inflate(headerViewRes, (ViewGroup) null, false);
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withHeaderDivider(boolean headerDivider) {
        this.mHeaderDivider = headerDivider;
        return this;
    }

    public final DrawerBuilder withHeaderPadding(boolean headerPadding) {
        this.mHeaderPadding = headerPadding;
        return this;
    }

    public final DrawerBuilder withHeaderHeight(DimenHolder headerHeight) {
        Intrinsics.checkParameterIsNotNull(headerHeight, "headerHeight");
        this.mHeiderHeight = headerHeight;
        return this;
    }

    public final DrawerBuilder withStickyHeader(View stickyHeader) {
        Intrinsics.checkParameterIsNotNull(stickyHeader, "stickyHeader");
        this.mStickyHeaderView = stickyHeader;
        return this;
    }

    public final DrawerBuilder withStickyHeader(int stickyHeaderRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (stickyHeaderRes != -1) {
                this.mStickyHeaderView = mActivity2.getLayoutInflater().inflate(stickyHeaderRes, (ViewGroup) null, false);
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withStickyHeaderShadow(boolean stickyHeaderShadow) {
        this.mStickyHeaderShadow = stickyHeaderShadow;
        return this;
    }

    public final DrawerBuilder withFooter(View footerView) {
        Intrinsics.checkParameterIsNotNull(footerView, "footerView");
        this.mFooterView = footerView;
        return this;
    }

    public final DrawerBuilder withFooter(int footerViewRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (footerViewRes != -1) {
                this.mFooterView = mActivity2.getLayoutInflater().inflate(footerViewRes, (ViewGroup) null, false);
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withFooterClickable(boolean footerClickable) {
        this.mFooterClickable = footerClickable;
        return this;
    }

    public final DrawerBuilder withFooterDivider(boolean footerDivider) {
        this.mFooterDivider = footerDivider;
        return this;
    }

    public final DrawerBuilder withStickyFooter(ViewGroup stickyFooter) {
        Intrinsics.checkParameterIsNotNull(stickyFooter, "stickyFooter");
        this.mStickyFooterView = stickyFooter;
        return this;
    }

    public final DrawerBuilder withStickyFooter(int stickyFooterRes) {
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (stickyFooterRes != -1) {
                View inflate = mActivity2.getLayoutInflater().inflate(stickyFooterRes, (ViewGroup) null, false);
                if (inflate != null) {
                    this.mStickyFooterView = (ViewGroup) inflate;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final DrawerBuilder withStickyFooterDivider(boolean stickyFooterDivider) {
        this.mStickyFooterDivider = stickyFooterDivider;
        return this;
    }

    public final DrawerBuilder withStickyFooterShadow(boolean stickyFooterShadow) {
        this.mStickyFooterShadow = stickyFooterShadow;
        return this;
    }

    public final DrawerBuilder withFireOnInitialOnClick(boolean fireOnInitialOnClick) {
        this.mFireInitialOnClick = fireOnInitialOnClick;
        return this;
    }

    public final DrawerBuilder withMultiSelect(boolean multiSelect) {
        this.mMultiSelect = multiSelect;
        return this;
    }

    public final DrawerBuilder withSelectedItemByPosition(int selectedItemPosition) {
        this.mSelectedItemPosition = selectedItemPosition;
        return this;
    }

    public final DrawerBuilder withSelectedItem(long selectedItemIdentifier) {
        this.mSelectedItemIdentifier = selectedItemIdentifier;
        return this;
    }

    public final DrawerBuilder withRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.mRecyclerView = recyclerView;
        return this;
    }

    public final DrawerBuilder withHasStableIds(boolean hasStableIds) {
        this.mHasStableIds = hasStableIds;
        if (getAdapter$materialdrawer() != null) {
            getAdapter$materialdrawer().setHasStableIds(hasStableIds);
        }
        return this;
    }

    public final DrawerBuilder withAdapter(FastAdapter<IDrawerItem<?>> adaptr) {
        Intrinsics.checkParameterIsNotNull(adaptr, "adaptr");
        setAdapter$materialdrawer(adaptr);
        IAdapterExtension orCreateExtension = getAdapter$materialdrawer().getOrCreateExtension(SelectExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        this.mSelectExtension = (SelectExtension) orCreateExtension;
        getAdapter$materialdrawer().addAdapter(0, this.mHeaderAdapter);
        getAdapter$materialdrawer().addAdapter(1, this.mItemAdapter);
        getAdapter$materialdrawer().addAdapter(2, this.mFooterAdapter);
        initAdapter();
        return this;
    }

    private final void initAdapter() {
        ExtensionsFactories.INSTANCE.register(new SelectExtensionFactory());
        ExtensionsFactories.INSTANCE.register(new ExpandableExtensionFactory());
        IAdapterExtension orCreateExtension = getAdapter$materialdrawer().getOrCreateExtension(SelectExtension.class);
        if (orCreateExtension == null) {
            Intrinsics.throwNpe();
        }
        this.mSelectExtension = (SelectExtension) orCreateExtension;
        IAdapterExtension orCreateExtension2 = getAdapter$materialdrawer().getOrCreateExtension(ExpandableExtension.class);
        if (orCreateExtension2 == null) {
            Intrinsics.throwNpe();
        }
        this.mExpandableExtension = (ExpandableExtension) orCreateExtension2;
    }

    public final DrawerBuilder withAdapterWrapper(RecyclerView.Adapter<?> adapterWrapper2) {
        Intrinsics.checkParameterIsNotNull(adapterWrapper2, "adapterWrapper");
        if (this._adapter != null) {
            this.adapterWrapper = adapterWrapper2;
            return this;
        }
        throw new RuntimeException("this adapter has to be set in conjunction to a normal adapter which is used inside this wrapper adapter");
    }

    public final DrawerBuilder withItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        Intrinsics.checkParameterIsNotNull(itemAnimator, "itemAnimator");
        this.mItemAnimator = itemAnimator;
        return this;
    }

    public final DrawerBuilder withDrawerItems(List<? extends IDrawerItem<?>> drawerItems) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        getItemAdapter$materialdrawer().set(drawerItems);
        return this;
    }

    public final DrawerBuilder addDrawerItems(IDrawerItem<?>... drawerItems) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        getItemAdapter$materialdrawer().add((Model[]) (IDrawerItem[]) Arrays.copyOf(drawerItems, drawerItems.length));
        return this;
    }

    public final DrawerBuilder withKeepStickyItemsVisible(boolean keepStickyItemsVisible) {
        this.mKeepStickyItemsVisible = keepStickyItemsVisible;
        return this;
    }

    public final DrawerBuilder withStickyDrawerItems(List<IDrawerItem<?>> stickyDrawerItems) {
        Intrinsics.checkParameterIsNotNull(stickyDrawerItems, "stickyDrawerItems");
        this.mStickyDrawerItems = stickyDrawerItems;
        return this;
    }

    public final DrawerBuilder addStickyDrawerItems(IDrawerItem<?>... stickyDrawerItems) {
        Intrinsics.checkParameterIsNotNull(stickyDrawerItems, "stickyDrawerItems");
        Collections.addAll(this.mStickyDrawerItems, (IDrawerItem[]) Arrays.copyOf(stickyDrawerItems, stickyDrawerItems.length));
        return this;
    }

    public final DrawerBuilder inflateMenu(int menuRes) {
        SupportMenuInflater menuInflater = new SupportMenuInflater(this.mActivity);
        MenuBuilder mMenu = new MenuBuilder(this.mActivity);
        menuInflater.inflate(menuRes, mMenu);
        addMenuItems(mMenu, false);
        return this;
    }

    private final void addMenuItems(Menu mMenu, boolean subMenu) {
        int groupId = R.id.material_drawer_menu_default_group;
        int size = mMenu.size();
        for (int i = 0; i < size; i++) {
            MenuItem mMenuItem = mMenu.getItem(i);
            if (!subMenu) {
                Intrinsics.checkExpressionValueIsNotNull(mMenuItem, "mMenuItem");
                if (!(mMenuItem.getGroupId() == groupId || mMenuItem.getGroupId() == 0)) {
                    groupId = mMenuItem.getGroupId();
                    getItemAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new DividerDrawerItem()});
                }
            }
            if (mMenuItem.hasSubMenu()) {
                PrimaryDrawerItem primaryDrawerItem = new PrimaryDrawerItem();
                Intrinsics.checkExpressionValueIsNotNull(mMenuItem, "mMenuItem");
                getItemAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) primaryDrawerItem.withName(mMenuItem.getTitle().toString())).withIcon(mMenuItem.getIcon())).withIdentifier((long) mMenuItem.getItemId())).withEnabled(mMenuItem.isEnabled())).withSelectable(false)});
                SubMenu subMenu2 = mMenuItem.getSubMenu();
                Intrinsics.checkExpressionValueIsNotNull(subMenu2, "mMenuItem.subMenu");
                addMenuItems(subMenu2, true);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(mMenuItem, "mMenuItem");
                if (mMenuItem.getGroupId() != 0 || subMenu) {
                    getItemAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) ((SecondaryDrawerItem) new SecondaryDrawerItem().withName(mMenuItem.getTitle().toString())).withIcon(mMenuItem.getIcon())).withIdentifier((long) mMenuItem.getItemId())).withEnabled(mMenuItem.isEnabled())});
                } else {
                    getItemAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{(IDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) ((PrimaryDrawerItem) new PrimaryDrawerItem().withName(mMenuItem.getTitle().toString())).withIcon(mMenuItem.getIcon())).withIdentifier((long) mMenuItem.getItemId())).withEnabled(mMenuItem.isEnabled())});
                }
            }
        }
    }

    public final DrawerBuilder withCloseOnClick(boolean closeOnClick) {
        this.mCloseOnClick = closeOnClick;
        return this;
    }

    public final DrawerBuilder withDelayOnDrawerClose(int delayOnDrawerClose) {
        this.mDelayOnDrawerClose = delayOnDrawerClose;
        return this;
    }

    public final DrawerBuilder withDelayDrawerClickEvent(int delayDrawerClickEvent) {
        this.mDelayDrawerClickEvent = delayDrawerClickEvent;
        return this;
    }

    public final DrawerBuilder withOnDrawerListener(Drawer.OnDrawerListener onDrawerListener) {
        Intrinsics.checkParameterIsNotNull(onDrawerListener, "onDrawerListener");
        this.mOnDrawerListener = onDrawerListener;
        return this;
    }

    public final DrawerBuilder withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemClickListener, "onDrawerItemClickListener");
        this.mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    public final DrawerBuilder withOnDrawerItemLongClickListener(Drawer.OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        Intrinsics.checkParameterIsNotNull(onDrawerItemLongClickListener, "onDrawerItemLongClickListener");
        this.mOnDrawerItemLongClickListener = onDrawerItemLongClickListener;
        return this;
    }

    public final DrawerBuilder withOnDrawerNavigationListener(Drawer.OnDrawerNavigationListener onDrawerNavigationListener) {
        Intrinsics.checkParameterIsNotNull(onDrawerNavigationListener, "onDrawerNavigationListener");
        this.mOnDrawerNavigationListener = onDrawerNavigationListener;
        return this;
    }

    public final DrawerBuilder withShowDrawerOnFirstLaunch(boolean showDrawerOnFirstLaunch) {
        this.mShowDrawerOnFirstLaunch = showDrawerOnFirstLaunch;
        return this;
    }

    public final DrawerBuilder withShowDrawerUntilDraggedOpened(boolean showDrawerUntilDraggedOpened) {
        this.mShowDrawerUntilDraggedOpened = showDrawerUntilDraggedOpened;
        return this;
    }

    public final DrawerBuilder withGenerateMiniDrawer(boolean generateMiniDrawer) {
        this.mGenerateMiniDrawer = generateMiniDrawer;
        return this;
    }

    public final DrawerBuilder withSavedInstance(Bundle savedInstance) {
        this.mSavedInstance = savedInstance;
        return this;
    }

    public final DrawerBuilder withSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "sharedPreferences");
        this.mSharedPreferences = sharedPreferences;
        return this;
    }

    private final void handleShowOnLaunch() {
        if (this.mActivity == null) {
            return;
        }
        if (this.mShowDrawerOnFirstLaunch || this.mShowDrawerUntilDraggedOpened) {
            SharedPreferences preferences = this.mSharedPreferences;
            if (preferences == null) {
                preferences = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
            }
            if (preferences != null) {
                SharedPreferences preferences2 = preferences;
                if (this.mShowDrawerOnFirstLaunch && !preferences2.getBoolean(Drawer.PREF_USER_LEARNED_DRAWER, false)) {
                    DrawerLayout drawerLayout = this.mDrawerLayout;
                    if (drawerLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                    }
                    ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = this.mSliderLayout;
                    if (scrimInsetsRelativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                    }
                    drawerLayout.openDrawer((View) scrimInsetsRelativeLayout);
                    SharedPreferences.Editor editor = preferences2.edit();
                    editor.putBoolean(Drawer.PREF_USER_LEARNED_DRAWER, true);
                    editor.apply();
                } else if (this.mShowDrawerUntilDraggedOpened && !preferences2.getBoolean(Drawer.PREF_USER_OPENED_DRAWER_BY_DRAGGING, false)) {
                    DrawerLayout drawerLayout2 = this.mDrawerLayout;
                    if (drawerLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                    }
                    ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                    if (scrimInsetsRelativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                    }
                    drawerLayout2.openDrawer((View) scrimInsetsRelativeLayout2);
                    DrawerLayout drawerLayout3 = this.mDrawerLayout;
                    if (drawerLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                    }
                    drawerLayout3.addDrawerListener(new DrawerBuilder$handleShowOnLaunch$$inlined$let$lambda$1(preferences2, this));
                }
            }
        }
    }

    public Drawer build() {
        if (!this.mUsed) {
            Activity mActivity2 = this.mActivity;
            if (mActivity2 != null) {
                this.mUsed = true;
                if (this.mDrawerLayout == null) {
                    withDrawerLayout(-1);
                }
                MaterializeBuilder withActivity = new MaterializeBuilder().withActivity(mActivity2);
                ViewGroup viewGroup = this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                MaterializeBuilder withTranslucentNavigationBarProgrammatically = withActivity.withRootView(viewGroup).withFullscreen(this.mFullscreen).withSystemUIHidden(this.mSystemUIHidden).withUseScrimInsetsLayout(false).withTransparentStatusBar(this.mTranslucentStatusBar).withTranslucentNavigationBarProgrammatically(this.mTranslucentNavigationBarProgrammatically);
                DrawerLayout drawerLayout = this.mDrawerLayout;
                if (drawerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                Materialize build = withTranslucentNavigationBarProgrammatically.withContainer(drawerLayout).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "MaterializeBuilder()\n   …\n                .build()");
                this.mMaterialize = build;
                handleDrawerNavigation$materialdrawer(mActivity2, false);
                Drawer result = buildView();
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = this.mSliderLayout;
                if (scrimInsetsRelativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout.setId(R.id.material_drawer_slider_layout);
                DrawerLayout drawerLayout2 = this.mDrawerLayout;
                if (drawerLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                drawerLayout2.addView(scrimInsetsRelativeLayout2, 1);
                return result;
            }
            throw new RuntimeException("please pass an activity first to use this call");
        }
        throw new RuntimeException("you must not reuse a DrawerBuilder builder");
    }

    public Drawer buildForFragment() {
        if (this.mUsed) {
            throw new RuntimeException("you must not reuse a DrawerBuilder builder");
        } else if (this.mRootView != null) {
            Activity mActivity2 = this.mActivity;
            if (mActivity2 != null) {
                this.mUsed = true;
                if (this.mDrawerLayout == null) {
                    withDrawerLayout(-1);
                }
                ViewGroup viewGroup = this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                View originalContentView = viewGroup.getChildAt(0);
                Intrinsics.checkExpressionValueIsNotNull(originalContentView, "originalContentView");
                if (!(originalContentView.getId() == R.id.materialize_root)) {
                    ViewGroup viewGroup2 = this.mRootView;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    }
                    viewGroup2.removeView(originalContentView);
                } else {
                    ViewGroup viewGroup3 = this.mRootView;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    }
                    viewGroup3.removeAllViews();
                }
                FrameLayout.LayoutParams layoutParamsContentView = new FrameLayout.LayoutParams(-1, -1);
                ViewGroup viewGroup4 = this.mRootView;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                DrawerLayout drawerLayout = this.mDrawerLayout;
                if (drawerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                viewGroup4.addView(drawerLayout, layoutParamsContentView);
                DrawerLayout drawerLayout2 = this.mDrawerLayout;
                if (drawerLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                drawerLayout2.setId(R.id.materialize_root);
                handleDrawerNavigation$materialdrawer(mActivity2, false);
                Drawer result = buildView();
                DrawerLayout drawerLayout3 = this.mDrawerLayout;
                if (drawerLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                drawerLayout3.addView(originalContentView, 0);
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = this.mSliderLayout;
                if (scrimInsetsRelativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout.setId(R.id.material_drawer_slider_layout);
                DrawerLayout drawerLayout4 = this.mDrawerLayout;
                if (drawerLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                drawerLayout4.addView(scrimInsetsRelativeLayout2, 1);
                return result;
            }
            throw new RuntimeException("please pass an activity first to use this call");
        } else {
            throw new RuntimeException("please pass the view which should host the DrawerLayout");
        }
    }

    public final void handleDrawerNavigation$materialdrawer(Activity activity, boolean recreateActionBarDrawerToggle) {
        View.OnClickListener toolbarNavigationListener = new DrawerBuilder$handleDrawerNavigation$toolbarNavigationListener$1(this);
        if (recreateActionBarDrawerToggle) {
            this.mActionBarDrawerToggle = null;
        }
        if (this.mActionBarDrawerToggleEnabled && this.mActionBarDrawerToggle == null && this.mToolbar != null) {
            DrawerLayout drawerLayout = this.mDrawerLayout;
            if (drawerLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
            }
            ActionBarDrawerToggle drawerBuilder$handleDrawerNavigation$1 = new DrawerBuilder$handleDrawerNavigation$1(this, activity, activity, drawerLayout, this.mToolbar, R.string.material_drawer_open, R.string.material_drawer_close);
            this.mActionBarDrawerToggle = drawerBuilder$handleDrawerNavigation$1;
            if (drawerBuilder$handleDrawerNavigation$1 != null) {
                drawerBuilder$handleDrawerNavigation$1.syncState();
            }
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(toolbarNavigationListener);
        }
        ActionBarDrawerToggle it = this.mActionBarDrawerToggle;
        if (it != null) {
            it.setToolbarNavigationClickListener(toolbarNavigationListener);
            DrawerLayout drawerLayout2 = this.mDrawerLayout;
            if (drawerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
            }
            drawerLayout2.addDrawerListener(it);
            return;
        }
        DrawerBuilder $this$run = this;
        DrawerLayout drawerLayout3 = $this$run.mDrawerLayout;
        if (drawerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
        }
        drawerLayout3.addDrawerListener(new DrawerBuilder$handleDrawerNavigation$3$1($this$run));
    }

    public Drawer buildView() {
        AccountHeader accountHeader;
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            if (this.mDrawerLayout == null) {
                withDrawerLayout(-1);
            }
            LayoutInflater layoutInflater = mActivity2.getLayoutInflater();
            int i = R.layout.material_drawer_slider;
            DrawerLayout drawerLayout = this.mDrawerLayout;
            if (drawerLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
            }
            View inflate = layoutInflater.inflate(i, drawerLayout, false);
            if (inflate != null) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = (ScrimInsetsRelativeLayout) inflate;
                this.mSliderLayout = scrimInsetsRelativeLayout;
                if (scrimInsetsRelativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(mActivity2, R.attr.material_drawer_background, R.color.material_drawer_background));
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) scrimInsetsRelativeLayout2.getLayoutParams();
                if (params != null) {
                    params.gravity = this.mDrawerGravity;
                    DrawerLayout.LayoutParams params2 = DrawerUtils.INSTANCE.processDrawerLayoutParams(this, params);
                    ScrimInsetsRelativeLayout scrimInsetsRelativeLayout3 = this.mSliderLayout;
                    if (scrimInsetsRelativeLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                    }
                    scrimInsetsRelativeLayout3.setLayoutParams(params2);
                }
                createContent();
                Drawer result = new Drawer(this);
                AccountHeader accountHeader2 = this.mAccountHeader;
                if (accountHeader2 != null) {
                    accountHeader2.setDrawer(result);
                }
                Bundle bundle = this.mSavedInstance;
                if (!(bundle == null || !bundle.getBoolean(Drawer.BUNDLE_DRAWER_CONTENT_SWITCHED, false) || (accountHeader = this.mAccountHeader) == null)) {
                    accountHeader.toggleSelectionList(mActivity2);
                }
                handleShowOnLaunch();
                if (!this.mAppended && this.mGenerateMiniDrawer) {
                    this.mMiniDrawer = new MiniDrawer().withDrawer(result).withAccountHeader(this.mAccountHeader);
                }
                this.mActivity = null;
                return result;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialize.view.ScrimInsetsRelativeLayout");
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public Drawer append(Drawer result) {
        AccountHeader accountHeader;
        Intrinsics.checkParameterIsNotNull(result, ScheduleActivity.RESULT);
        if (!this.mUsed) {
            Activity mActivity2 = this.mActivity;
            if (mActivity2 != null) {
                this.mUsed = true;
                this.mAppended = true;
                this.mDrawerLayout = result.getDrawerLayout();
                LayoutInflater layoutInflater = mActivity2.getLayoutInflater();
                int i = R.layout.material_drawer_slider;
                DrawerLayout drawerLayout = this.mDrawerLayout;
                if (drawerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                }
                View inflate = layoutInflater.inflate(i, drawerLayout, false);
                if (inflate != null) {
                    ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = (ScrimInsetsRelativeLayout) inflate;
                    this.mSliderLayout = scrimInsetsRelativeLayout;
                    if (scrimInsetsRelativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                    }
                    scrimInsetsRelativeLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(mActivity2, R.attr.material_drawer_background, R.color.material_drawer_background));
                    ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                    if (scrimInsetsRelativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                    }
                    ViewGroup.LayoutParams layoutParams = scrimInsetsRelativeLayout2.getLayoutParams();
                    if (layoutParams != null) {
                        DrawerLayout.LayoutParams it = (DrawerLayout.LayoutParams) layoutParams;
                        it.gravity = this.mDrawerGravity;
                        ScrimInsetsRelativeLayout scrimInsetsRelativeLayout3 = this.mSliderLayout;
                        if (scrimInsetsRelativeLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                        }
                        scrimInsetsRelativeLayout3.setLayoutParams(DrawerUtils.INSTANCE.processDrawerLayoutParams(this, it));
                        ScrimInsetsRelativeLayout scrimInsetsRelativeLayout4 = this.mSliderLayout;
                        if (scrimInsetsRelativeLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                        }
                        scrimInsetsRelativeLayout4.setId(R.id.material_drawer_slider_layout);
                        DrawerLayout drawerLayout2 = this.mDrawerLayout;
                        if (drawerLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                        }
                        ScrimInsetsRelativeLayout scrimInsetsRelativeLayout5 = this.mSliderLayout;
                        if (scrimInsetsRelativeLayout5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                        }
                        drawerLayout2.addView(scrimInsetsRelativeLayout5, 1);
                        createContent();
                        Drawer appendedResult = new Drawer(this);
                        Bundle bundle = this.mSavedInstance;
                        if (!(bundle == null || !bundle.getBoolean(Drawer.BUNDLE_DRAWER_CONTENT_SWITCHED_APPENDED, false) || (accountHeader = this.mAccountHeader) == null)) {
                            accountHeader.toggleSelectionList(mActivity2);
                        }
                        this.mActivity = null;
                        return appendedResult;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialize.view.ScrimInsetsRelativeLayout");
            }
            throw new RuntimeException("please pass an activity first to use this call");
        }
        throw new RuntimeException("you must not reuse a DrawerBuilder builder");
    }

    private final void createContent() {
        View contentView;
        Drawer.OnDrawerItemClickListener onDrawerItemClickListener;
        Activity mActivity2 = this.mActivity;
        if (mActivity2 != null) {
            int i = -1;
            if (this.mCustomView != null) {
                LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(-1, -1);
                contentParams.weight = 1.0f;
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = this.mSliderLayout;
                if (scrimInsetsRelativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout.addView(this.mCustomView, contentParams);
                return;
            }
            if (Build.VERSION.SDK_INT < 21) {
                ViewGroup viewGroup = this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                if (ViewCompat.getLayoutDirection(viewGroup) == 0) {
                    DrawerLayout drawerLayout = this.mDrawerLayout;
                    if (drawerLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                    }
                    drawerLayout.setDrawerShadow(this.mDrawerGravity == 8388611 ? R.drawable.material_drawer_shadow_right : R.drawable.material_drawer_shadow_left, this.mDrawerGravity);
                } else {
                    DrawerLayout drawerLayout2 = this.mDrawerLayout;
                    if (drawerLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
                    }
                    drawerLayout2.setDrawerShadow(this.mDrawerGravity == 8388611 ? R.drawable.material_drawer_shadow_left : R.drawable.material_drawer_shadow_right, this.mDrawerGravity);
                }
            }
            if (this.mRecyclerView == null) {
                LayoutInflater from = LayoutInflater.from(mActivity2);
                int i2 = R.layout.material_drawer_recycler_view;
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout2 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                View inflate = from.inflate(i2, scrimInsetsRelativeLayout2, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(mAct…ew, mSliderLayout, false)");
                contentView = inflate;
                View findViewById = contentView.findViewById(R.id.material_drawer_recycler_view);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "contentView.findViewById…ial_drawer_recycler_view)");
                RecyclerView recyclerView = (RecyclerView) findViewById;
                this.mRecyclerView = recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView.setItemAnimator(this.mItemAnimator);
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView2.setFadingEdgeLength(0);
                RecyclerView recyclerView3 = this.mRecyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView3.setClipToPadding(false);
                RecyclerView recyclerView4 = this.mRecyclerView;
                if (recyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
                if (layoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                }
                recyclerView4.setLayoutManager(layoutManager);
                int paddingTop = 0;
                Boolean bool = this.mDisplayBelowStatusBar;
                if ((bool == null || Intrinsics.areEqual((Object) bool, (Object) true)) && !this.mSystemUIHidden) {
                    paddingTop = UIUtils.getStatusBarHeight(mActivity2);
                }
                int paddingBottom = 0;
                Resources resources = mActivity2.getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "mActivity.resources");
                int orientation = resources.getConfiguration().orientation;
                if ((this.mTranslucentNavigationBar || this.mFullscreen) && Build.VERSION.SDK_INT >= 21 && !this.mSystemUIHidden && (orientation == 1 || (orientation == 2 && DrawerUIUtils.INSTANCE.isSystemBarOnBottom(mActivity2)))) {
                    paddingBottom = UIUtils.getNavigationBarHeight(mActivity2);
                }
                RecyclerView recyclerView5 = this.mRecyclerView;
                if (recyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView5.setPadding(0, paddingTop, 0, paddingBottom);
            } else {
                View contentView2 = this.mRecyclerView;
                if (contentView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                contentView = contentView2;
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -1);
            params.weight = 1.0f;
            ScrimInsetsRelativeLayout scrimInsetsRelativeLayout3 = this.mSliderLayout;
            if (scrimInsetsRelativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
            }
            scrimInsetsRelativeLayout3.addView(contentView, params);
            if (this.mInnerShadow) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout4 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                View innerShadow = scrimInsetsRelativeLayout4.findViewById(R.id.material_drawer_inner_shadow);
                Intrinsics.checkExpressionValueIsNotNull(innerShadow, "innerShadow");
                innerShadow.setVisibility(0);
                innerShadow.bringToFront();
                if (this.mDrawerGravity == 8388611) {
                    innerShadow.setBackgroundResource(R.drawable.material_drawer_shadow_left);
                } else {
                    innerShadow.setBackgroundResource(R.drawable.material_drawer_shadow_right);
                }
            }
            if (this.mSliderBackgroundColor != 0) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout5 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout5.setBackgroundColor(this.mSliderBackgroundColor);
            } else if (this.mSliderBackgroundColorRes != -1) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout6 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                scrimInsetsRelativeLayout6.setBackgroundColor(ContextCompat.getColor(mActivity2, this.mSliderBackgroundColorRes));
            } else if (this.mSliderBackgroundDrawable != null) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout7 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                UIUtils.setBackground((View) scrimInsetsRelativeLayout7, this.mSliderBackgroundDrawable);
            } else if (this.mSliderBackgroundDrawableRes != -1) {
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout8 = this.mSliderLayout;
                if (scrimInsetsRelativeLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLayout");
                }
                UIUtils.setBackground((View) scrimInsetsRelativeLayout8, this.mSliderBackgroundDrawableRes);
            }
            DrawerUtils.INSTANCE.handleHeaderView(this);
            DrawerUtils.INSTANCE.handleFooterView(this, new DrawerBuilder$createContent$2(this));
            SelectExtension<IDrawerItem<?>> selectExtension = this.mSelectExtension;
            if (selectExtension == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension.setMultiSelect(this.mMultiSelect);
            if (this.mMultiSelect) {
                SelectExtension<IDrawerItem<?>> selectExtension2 = this.mSelectExtension;
                if (selectExtension2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                selectExtension2.setSelectOnLongClick(false);
                SelectExtension<IDrawerItem<?>> selectExtension3 = this.mSelectExtension;
                if (selectExtension3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                selectExtension3.setAllowDeselection(true);
            }
            if (this.adapterWrapper == null) {
                RecyclerView recyclerView6 = this.mRecyclerView;
                if (recyclerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView6.setAdapter(getAdapter$materialdrawer());
            } else {
                RecyclerView recyclerView7 = this.mRecyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView7.setAdapter(this.adapterWrapper);
            }
            if (this.mSelectedItemPosition == 0 && this.mSelectedItemIdentifier != 0) {
                this.mSelectedItemPosition = DrawerUtils.INSTANCE.getPositionByIdentifier(this, this.mSelectedItemIdentifier);
            }
            if (this.mHeaderView != null && this.mSelectedItemPosition == 0) {
                this.mSelectedItemPosition = 1;
            }
            SelectExtension<IDrawerItem<?>> selectExtension4 = this.mSelectExtension;
            if (selectExtension4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            selectExtension4.deselect();
            SelectExtension<IDrawerItem<?>> selectExtension5 = this.mSelectExtension;
            if (selectExtension5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
            }
            SelectExtension.select$default(selectExtension5, this.mSelectedItemPosition, false, false, 6, (Object) null);
            getAdapter$materialdrawer().setOnClickListener(new DrawerBuilder$createContent$3(this));
            getAdapter$materialdrawer().setOnLongClickListener(new DrawerBuilder$createContent$4(this));
            RecyclerView recyclerView8 = this.mRecyclerView;
            if (recyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            recyclerView8.scrollToPosition(0);
            Bundle mSavedInstance2 = this.mSavedInstance;
            if (mSavedInstance2 != null) {
                if (!this.mAppended) {
                    SelectExtension<IDrawerItem<?>> selectExtension6 = this.mSelectExtension;
                    if (selectExtension6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                    }
                    selectExtension6.deselect();
                    getAdapter$materialdrawer().withSavedInstanceState(mSavedInstance2, Drawer.BUNDLE_SELECTION);
                    DrawerUtils.INSTANCE.setStickyFooterSelection(this, mSavedInstance2.getInt(Drawer.BUNDLE_STICKY_FOOTER_SELECTION, -1), (Boolean) null);
                } else {
                    SelectExtension<IDrawerItem<?>> selectExtension7 = this.mSelectExtension;
                    if (selectExtension7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                    }
                    selectExtension7.deselect();
                    getAdapter$materialdrawer().withSavedInstanceState(mSavedInstance2, Drawer.BUNDLE_SELECTION_APPENDED);
                    DrawerUtils.INSTANCE.setStickyFooterSelection(this, mSavedInstance2.getInt(Drawer.BUNDLE_STICKY_FOOTER_SELECTION_APPENDED, -1), (Boolean) null);
                }
            }
            if (this.mFireInitialOnClick && this.mOnDrawerItemClickListener != null) {
                SelectExtension<IDrawerItem<?>> selectExtension8 = this.mSelectExtension;
                if (selectExtension8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                }
                if (!selectExtension8.getSelections().isEmpty()) {
                    SelectExtension<IDrawerItem<?>> selectExtension9 = this.mSelectExtension;
                    if (selectExtension9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSelectExtension");
                    }
                    i = selectExtension9.getSelections().iterator().next().intValue();
                }
                int selection = i;
                IDrawerItem it = getDrawerItem$materialdrawer(selection);
                if (it != null && (onDrawerItemClickListener = this.mOnDrawerItemClickListener) != null) {
                    onDrawerItemClickListener.onItemClick((View) null, selection, it);
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public final void closeDrawerDelayed$materialdrawer() {
        if (!this.mCloseOnClick) {
            return;
        }
        if (this.mDelayOnDrawerClose > -1) {
            new Handler().postDelayed(new DrawerBuilder$closeDrawerDelayed$1(this), (long) this.mDelayOnDrawerClose);
            return;
        }
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDrawerLayout");
        }
        drawerLayout.closeDrawers();
    }

    public final IDrawerItem<?> getDrawerItem$materialdrawer(int position) {
        return getAdapter$materialdrawer().getItem(position);
    }

    public final boolean checkDrawerItem$materialdrawer(int position, boolean includeOffset) {
        return getAdapter$materialdrawer().getItem(position) != null;
    }

    public final void resetStickyFooterSelection$materialdrawer() {
        ViewGroup it = this.mStickyFooterView;
        if (it != null && (it instanceof LinearLayout)) {
            int childCount = ((LinearLayout) it).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = it.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "it.getChildAt(i)");
                childAt.setActivated(false);
                View childAt2 = it.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt2, "it.getChildAt(i)");
                childAt2.setSelected(false);
            }
        }
    }
}

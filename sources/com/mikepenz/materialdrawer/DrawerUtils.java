package com.mikepenz.materialdrawer;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001J&\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ1\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0007J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ%\u0010'\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"Lcom/mikepenz/materialdrawer/DrawerUtils;", "", "()V", "addStickyFooterDivider", "", "ctx", "Landroid/content/Context;", "footerView", "Landroid/view/ViewGroup;", "buildStickyDrawerItemFooter", "drawer", "Lcom/mikepenz/materialdrawer/DrawerBuilder;", "onClickListener", "Landroid/view/View$OnClickListener;", "fillStickyDrawerItemFooter", "container", "getDrawerItem", "Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;", "drawerItems", "", "tag", "identifier", "", "getPositionByIdentifier", "", "getStickyFooterPositionByIdentifier", "handleFooterView", "handleHeaderView", "onFooterDrawerItemClick", "drawerItem", "v", "Landroid/view/View;", "fireOnClick", "", "(Lcom/mikepenz/materialdrawer/DrawerBuilder;Lcom/mikepenz/materialdrawer/model/interfaces/IDrawerItem;Landroid/view/View;Ljava/lang/Boolean;)V", "processDrawerLayoutParams", "Landroidx/drawerlayout/widget/DrawerLayout$LayoutParams;", "params", "rebuildStickyFooterView", "setStickyFooterSelection", "_position", "(Lcom/mikepenz/materialdrawer/DrawerBuilder;ILjava/lang/Boolean;)V", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawerUtils.kt */
public final class DrawerUtils {
    public static final DrawerUtils INSTANCE = new DrawerUtils();

    private DrawerUtils() {
    }

    public final void onFooterDrawerItemClick(DrawerBuilder drawer, IDrawerItem<?> drawerItem, View v, Boolean fireOnClick) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        Intrinsics.checkParameterIsNotNull(drawerItem, "drawerItem");
        Intrinsics.checkParameterIsNotNull(v, "v");
        boolean z2 = false;
        if (!(drawerItem instanceof Selectable) || drawerItem.isSelectable()) {
            drawer.resetStickyFooterSelection$materialdrawer();
            v.setActivated(true);
            v.setSelected(true);
            drawer.getSelectExtension$materialdrawer().deselect();
            if (drawer.getMStickyFooterView$materialdrawer() != null && (drawer.getMStickyFooterView$materialdrawer() instanceof LinearLayout)) {
                ViewGroup mStickyFooterView$materialdrawer = drawer.getMStickyFooterView$materialdrawer();
                if (mStickyFooterView$materialdrawer != null) {
                    LinearLayout footer = (LinearLayout) mStickyFooterView$materialdrawer;
                    int childCount = footer.getChildCount();
                    int i = 0;
                    while (true) {
                        if (i >= childCount) {
                            break;
                        } else if (footer.getChildAt(i) == v) {
                            drawer.setMCurrentStickyFooterSelection$materialdrawer(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
                }
            }
        }
        if (fireOnClick != null) {
            boolean consumed = false;
            if (fireOnClick.booleanValue()) {
                if ((drawerItem instanceof AbstractDrawerItem) && ((AbstractDrawerItem) drawerItem).getOnDrawerItemClickListener() != null) {
                    Drawer.OnDrawerItemClickListener onDrawerItemClickListener = ((AbstractDrawerItem) drawerItem).getOnDrawerItemClickListener();
                    if (onDrawerItemClickListener != null) {
                        z = onDrawerItemClickListener.onItemClick(v, -1, drawerItem);
                    } else {
                        z = false;
                    }
                    consumed = z;
                }
                if (drawer.getMOnDrawerItemClickListener$materialdrawer() != null) {
                    Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener$materialdrawer = drawer.getMOnDrawerItemClickListener$materialdrawer();
                    if (mOnDrawerItemClickListener$materialdrawer != null) {
                        z2 = mOnDrawerItemClickListener$materialdrawer.onItemClick(v, -1, drawerItem);
                    }
                    consumed = z2;
                }
            }
            if (!consumed) {
                drawer.closeDrawerDelayed$materialdrawer();
            }
        }
    }

    public final void setStickyFooterSelection(DrawerBuilder drawer, int _position, Boolean fireOnClick) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        int position = _position;
        if (position > -1 && drawer.getMStickyFooterView$materialdrawer() != null && (drawer.getMStickyFooterView$materialdrawer() instanceof LinearLayout)) {
            ViewGroup mStickyFooterView$materialdrawer = drawer.getMStickyFooterView$materialdrawer();
            if (mStickyFooterView$materialdrawer != null) {
                LinearLayout footer = (LinearLayout) mStickyFooterView$materialdrawer;
                if (drawer.getMStickyFooterDivider$materialdrawer()) {
                    position++;
                }
                if (footer.getChildCount() > position && position >= 0) {
                    Object tag = footer.getChildAt(position).getTag(R.id.material_drawer_item);
                    if (tag != null) {
                        View childAt = footer.getChildAt(position);
                        Intrinsics.checkExpressionValueIsNotNull(childAt, "footer.getChildAt(position)");
                        onFooterDrawerItemClick(drawer, (IDrawerItem) tag, childAt, fireOnClick);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.mikepenz.materialdrawer.model.interfaces.IDrawerItem<*>");
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
    }

    public final int getPositionByIdentifier(DrawerBuilder drawer, long identifier) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        if (identifier == -1) {
            return -1;
        }
        int itemCount = drawer.getAdapter$materialdrawer().getItemCount();
        for (int i = 0; i < itemCount; i++) {
            IDrawerItem item = drawer.getAdapter$materialdrawer().getItem(i);
            if (item != null && item.getIdentifier() == identifier) {
                return i;
            }
        }
        return -1;
    }

    public final IDrawerItem<?> getDrawerItem(List<? extends IDrawerItem<?>> drawerItems, long identifier) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        if (identifier == -1) {
            return null;
        }
        for (IDrawerItem drawerItem : drawerItems) {
            if (drawerItem.getIdentifier() == identifier) {
                return drawerItem;
            }
        }
        return null;
    }

    public final IDrawerItem<?> getDrawerItem(List<? extends IDrawerItem<?>> drawerItems, Object tag) {
        Intrinsics.checkParameterIsNotNull(drawerItems, "drawerItems");
        if (tag == null) {
            return null;
        }
        for (IDrawerItem drawerItem : drawerItems) {
            if (Intrinsics.areEqual(tag, drawerItem.getTag())) {
                return drawerItem;
            }
        }
        return null;
    }

    public final int getStickyFooterPositionByIdentifier(DrawerBuilder drawer, long identifier) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        if (identifier == -1 || drawer.getMStickyFooterView$materialdrawer() == null || !(drawer.getMStickyFooterView$materialdrawer() instanceof LinearLayout)) {
            return -1;
        }
        ViewGroup mStickyFooterView$materialdrawer = drawer.getMStickyFooterView$materialdrawer();
        if (mStickyFooterView$materialdrawer != null) {
            LinearLayout footer = (LinearLayout) mStickyFooterView$materialdrawer;
            int shadowOffset = 0;
            int childCount = footer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Object o = footer.getChildAt(i).getTag(R.id.material_drawer_item);
                if (o == null && drawer.getMStickyFooterDivider$materialdrawer()) {
                    shadowOffset++;
                }
                if (o != null && (o instanceof IDrawerItem) && ((IDrawerItem) o).getIdentifier() == identifier) {
                    return i - shadowOffset;
                }
            }
            return -1;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public final void handleHeaderView(DrawerBuilder drawer) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        AccountHeader it = drawer.getMAccountHeader$materialdrawer();
        if (it != null) {
            if (drawer.getMAccountHeaderSticky$materialdrawer()) {
                drawer.setMStickyHeaderView$materialdrawer(it.getView());
            } else {
                drawer.setMHeaderView$materialdrawer(it.getView());
                drawer.setMHeaderDivider$materialdrawer(it.getAccountHeaderBuilder().getDividerBelowHeader());
                drawer.setMHeaderPadding$materialdrawer(it.getAccountHeaderBuilder().getPaddingBelowHeader());
            }
        }
        View it2 = drawer.getMStickyHeaderView$materialdrawer();
        if (it2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, 1);
            it2.setId(R.id.material_drawer_sticky_header);
            drawer.getMSliderLayout$materialdrawer().addView(it2, 0, layoutParams);
            ViewGroup.LayoutParams layoutParams2 = drawer.getMRecyclerView$materialdrawer().getLayoutParams();
            if (layoutParams2 != null) {
                RelativeLayout.LayoutParams layoutParamsListView = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParamsListView.addRule(3, R.id.material_drawer_sticky_header);
                drawer.getMRecyclerView$materialdrawer().setLayoutParams(layoutParamsListView);
                it2.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(drawer.getMActivity$materialdrawer(), R.attr.material_drawer_background, R.color.material_drawer_background));
                if (drawer.getMStickyHeaderShadow$materialdrawer()) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        it2.setElevation(UIUtils.convertDpToPixel(4.0f, drawer.getMActivity$materialdrawer()));
                    } else {
                        View view = new View(drawer.getMActivity$materialdrawer());
                        view.setBackgroundResource(R.drawable.material_drawer_shadow_bottom);
                        drawer.getMSliderLayout$materialdrawer().addView(view, -1, (int) UIUtils.convertDpToPixel(4.0f, drawer.getMActivity$materialdrawer()));
                        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                        if (layoutParams3 != null) {
                            RelativeLayout.LayoutParams lps = (RelativeLayout.LayoutParams) layoutParams3;
                            lps.addRule(3, R.id.material_drawer_sticky_header);
                            view.setLayoutParams(lps);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                    }
                }
                drawer.getMRecyclerView$materialdrawer().setPadding(0, 0, 0, 0);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
        }
        View it3 = drawer.getMHeaderView$materialdrawer();
        if (it3 != null) {
            if (drawer.getMHeaderPadding$materialdrawer()) {
                drawer.getHeaderAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(it3).withHeight(drawer.getMHeiderHeight$materialdrawer()).withDivider(drawer.getMHeaderDivider$materialdrawer()).withViewPosition(ContainerDrawerItem.Position.TOP)});
            } else {
                drawer.getHeaderAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(it3).withHeight(drawer.getMHeiderHeight$materialdrawer()).withDivider(drawer.getMHeaderDivider$materialdrawer()).withViewPosition(ContainerDrawerItem.Position.NONE)});
            }
            drawer.getMRecyclerView$materialdrawer().setPadding(drawer.getMRecyclerView$materialdrawer().getPaddingLeft(), 0, drawer.getMRecyclerView$materialdrawer().getPaddingRight(), drawer.getMRecyclerView$materialdrawer().getPaddingBottom());
        }
    }

    public final void rebuildStickyFooterView(DrawerBuilder drawer) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        ViewGroup it = drawer.getMStickyFooterView$materialdrawer();
        if (it != null) {
            it.removeAllViews();
            if (drawer.getMStickyFooterDivider$materialdrawer()) {
                DrawerUtils drawerUtils = INSTANCE;
                Context context = it.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "it.context");
                drawerUtils.addStickyFooterDivider(context, it);
            }
            INSTANCE.fillStickyDrawerItemFooter(drawer, it, new DrawerUtils$rebuildStickyFooterView$$inlined$let$lambda$1(drawer));
            it.setVisibility(0);
        } else {
            DrawerUtils drawerUtils2 = this;
            INSTANCE.handleFooterView(drawer, new DrawerUtils$rebuildStickyFooterView$$inlined$run$lambda$1(drawer));
        }
        setStickyFooterSelection(drawer, drawer.getMCurrentStickyFooterSelection$materialdrawer(), false);
    }

    public final void handleFooterView(DrawerBuilder drawer, View.OnClickListener onClickListener) {
        DrawerBuilder drawerBuilder = drawer;
        View.OnClickListener onClickListener2 = onClickListener;
        Intrinsics.checkParameterIsNotNull(drawerBuilder, "drawer");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        Context ctx = drawer.getMSliderLayout$materialdrawer().getContext();
        if (drawer.getMStickyDrawerItems$materialdrawer().size() > 0) {
            DrawerUtils drawerUtils = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
            drawerBuilder.setMStickyFooterView$materialdrawer(drawerUtils.buildStickyDrawerItemFooter(ctx, drawerBuilder, onClickListener2));
        }
        ViewGroup it = drawer.getMStickyFooterView$materialdrawer();
        if (it != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, 1);
            it.setId(R.id.material_drawer_sticky_footer);
            drawer.getMSliderLayout$materialdrawer().addView(it, layoutParams);
            if ((drawer.getMTranslucentNavigationBar$materialdrawer() || drawer.getMFullscreen$materialdrawer()) && Build.VERSION.SDK_INT >= 19) {
                it.setPadding(0, 0, 0, UIUtils.getNavigationBarHeight(ctx));
            }
            ViewGroup.LayoutParams layoutParams2 = drawer.getMRecyclerView$materialdrawer().getLayoutParams();
            if (layoutParams2 != null) {
                RelativeLayout.LayoutParams layoutParamsListView = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParamsListView.addRule(2, R.id.material_drawer_sticky_footer);
                drawer.getMRecyclerView$materialdrawer().setLayoutParams(layoutParamsListView);
                if (drawer.getMStickyFooterShadow$materialdrawer()) {
                    View view = new View(ctx);
                    View stickyFooterShadowView = view;
                    stickyFooterShadowView.setBackgroundResource(R.drawable.material_drawer_shadow_top);
                    ScrimInsetsRelativeLayout mSliderLayout$materialdrawer = drawer.getMSliderLayout$materialdrawer();
                    Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                    mSliderLayout$materialdrawer.addView(stickyFooterShadowView, -1, ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_sticky_footer_elevation));
                    ViewGroup.LayoutParams layoutParams3 = stickyFooterShadowView.getLayoutParams();
                    if (layoutParams3 != null) {
                        RelativeLayout.LayoutParams lps = (RelativeLayout.LayoutParams) layoutParams3;
                        lps.addRule(2, R.id.material_drawer_sticky_footer);
                        stickyFooterShadowView.setLayoutParams(lps);
                        drawerBuilder.setMStickyFooterShadowView$materialdrawer(view);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                }
                RecyclerView mRecyclerView$materialdrawer = drawer.getMRecyclerView$materialdrawer();
                int paddingLeft = drawer.getMRecyclerView$materialdrawer().getPaddingLeft();
                int paddingTop = drawer.getMRecyclerView$materialdrawer().getPaddingTop();
                int paddingRight = drawer.getMRecyclerView$materialdrawer().getPaddingRight();
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                mRecyclerView$materialdrawer.setPadding(paddingLeft, paddingTop, paddingRight, ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_padding));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
        }
        View it2 = drawer.getMFooterView$materialdrawer();
        if (it2 == null) {
            return;
        }
        if (drawer.getMFooterDivider$materialdrawer()) {
            drawer.getFooterAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(it2).withViewPosition(ContainerDrawerItem.Position.BOTTOM)});
            return;
        }
        drawer.getFooterAdapter$materialdrawer().add((Model[]) new IDrawerItem[]{new ContainerDrawerItem().withView(it2).withViewPosition(ContainerDrawerItem.Position.NONE)});
    }

    public final ViewGroup buildStickyDrawerItemFooter(Context ctx, DrawerBuilder drawer, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        Intrinsics.checkParameterIsNotNull(onClickListener, "onClickListener");
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, R.attr.material_drawer_background, R.color.material_drawer_background));
        if (drawer.getMStickyFooterDivider$materialdrawer()) {
            addStickyFooterDivider(ctx, linearLayout);
        }
        fillStickyDrawerItemFooter(drawer, linearLayout, onClickListener);
        return linearLayout;
    }

    private final void addStickyFooterDivider(Context ctx, ViewGroup footerView) {
        LinearLayout divider = new LinearLayout(ctx);
        LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(-1, -2);
        divider.setMinimumHeight((int) UIUtils.convertDpToPixel(1.0f, ctx));
        divider.setOrientation(1);
        divider.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, R.attr.material_drawer_divider, R.color.material_drawer_divider));
        footerView.addView(divider, dividerParams);
    }

    public final void fillStickyDrawerItemFooter(DrawerBuilder drawer, ViewGroup container, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(onClickListener, "onClickListener");
        for (IDrawerItem drawerItem : drawer.getMStickyDrawerItems$materialdrawer()) {
            Context context = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
            View view = drawerItem.generateView(context, container);
            view.setTag(drawerItem);
            if (drawerItem.isEnabled()) {
                view.setOnClickListener(onClickListener);
            }
            container.addView(view);
            DrawerUIUtils.INSTANCE.setDrawerVerticalPadding(view);
        }
        container.setPadding(0, 0, 0, 0);
    }

    public final DrawerLayout.LayoutParams processDrawerLayoutParams(DrawerBuilder drawer, DrawerLayout.LayoutParams params) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        if (params != null) {
            Context ctx = drawer.getMDrawerLayout$materialdrawer().getContext();
            if (drawer.getMDrawerGravity$materialdrawer() == 5 || drawer.getMDrawerGravity$materialdrawer() == 8388613) {
                params.rightMargin = 0;
                if (Build.VERSION.SDK_INT >= 17) {
                    params.setMarginEnd(0);
                }
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                params.leftMargin = ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_margin);
                if (Build.VERSION.SDK_INT >= 17) {
                    params.setMarginEnd(ctx.getResources().getDimensionPixelSize(R.dimen.material_drawer_margin));
                }
            }
            if (drawer.getMDrawerWidth$materialdrawer() > -1) {
                params.width = drawer.getMDrawerWidth$materialdrawer();
            } else {
                DrawerUIUtils drawerUIUtils = DrawerUIUtils.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(ctx, "ctx");
                params.width = drawerUIUtils.getOptimalDrawerWidth(ctx);
            }
        }
        return params;
    }
}

package com.mikepenz.materialdrawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.Scopes;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 J2\u00020\u0001:\u0005JKLMNB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u001f\u001a\u00020 2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010!\u001a\u00020\"J'\u0010#\u001a\u00020 2\u001a\u0010\u0015\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0$\"\u0006\u0012\u0002\b\u00030\b¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020 J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020 2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bJ\u000e\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010+\u001a\u00020 2\u0006\u0010(\u001a\u00020)J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u001a\u0010\f\u001a\u00020 2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010/\u001a\u00020\u0013J\u001a\u0010\f\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010/\u001a\u00020\u0013H\u0007J\u000e\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020 2\b\b\u0001\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0013J\u000e\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020=J\u000e\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0013J\u000e\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020FJ\u0012\u0010G\u001a\u00020 2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\bJ\u0014\u0010I\u001a\u00020 2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R0\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R<\u0010\u0015\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u00162\u0012\u0010\u0015\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006O"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader;", "", "accountHeaderBuilder", "Lcom/mikepenz/materialdrawer/AccountHeaderBuilder;", "(Lcom/mikepenz/materialdrawer/AccountHeaderBuilder;)V", "getAccountHeaderBuilder", "()Lcom/mikepenz/materialdrawer/AccountHeaderBuilder;", "profile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "activeProfile", "getActiveProfile", "()Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "setActiveProfile", "(Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;)V", "headerBackgroundView", "Landroid/widget/ImageView;", "getHeaderBackgroundView", "()Landroid/widget/ImageView;", "isSelectionListShown", "", "()Z", "profiles", "", "getProfiles", "()Ljava/util/List;", "setProfiles", "(Ljava/util/List;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "addProfile", "", "position", "", "addProfiles", "", "([Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;)V", "clear", "getPositionByIdentifier", "identifier", "", "removeProfile", "removeProfileByIdentifier", "saveInstanceState", "Landroid/os/Bundle;", "savedInstanceState", "fireOnProfileChanged", "setBackground", "headerBackground", "Landroid/graphics/drawable/Drawable;", "setBackgroundRes", "headerBackgroundRes", "setDrawer", "drawer", "Lcom/mikepenz/materialdrawer/Drawer;", "setHeaderBackground", "imageHolder", "Lcom/mikepenz/materialdrawer/holder/ImageHolder;", "setSelectionFirstLine", "selectionFirstLine", "", "setSelectionFirstLineShown", "selectionFirstLineShown", "setSelectionSecondLine", "selectionSecondLine", "setSelectionSecondLineShown", "selectionSecondLineShown", "toggleSelectionList", "ctx", "Landroid/content/Context;", "updateProfile", "newProfile", "updateProfileByIdentifier", "Companion", "OnAccountHeaderItemLongClickListener", "OnAccountHeaderListener", "OnAccountHeaderProfileImageListener", "OnAccountHeaderSelectionViewClickListener", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: AccountHeader.kt */
public final class AccountHeader {
    public static final String BUNDLE_SELECTION_HEADER = "bundle_selection_header";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final double NAVIGATION_DRAWER_ACCOUNT_ASPECT_RATIO = 0.5625d;
    private final AccountHeaderBuilder accountHeaderBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderItemLongClickListener;", "", "onProfileLongClick", "", "view", "Landroid/view/View;", "profile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "current", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AccountHeader.kt */
    public interface OnAccountHeaderItemLongClickListener {
        boolean onProfileLongClick(View view, IProfile<?> iProfile, boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderListener;", "", "onProfileChanged", "", "view", "Landroid/view/View;", "profile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "current", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AccountHeader.kt */
    public interface OnAccountHeaderListener {
        boolean onProfileChanged(View view, IProfile<?> iProfile, boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u0003H&J$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderProfileImageListener;", "", "onProfileImageClick", "", "view", "Landroid/view/View;", "profile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "current", "onProfileImageLongClick", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AccountHeader.kt */
    public interface OnAccountHeaderProfileImageListener {
        boolean onProfileImageClick(View view, IProfile<?> iProfile, boolean z);

        boolean onProfileImageLongClick(View view, IProfile<?> iProfile, boolean z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&¨\u0006\b"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader$OnAccountHeaderSelectionViewClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "profile", "Lcom/mikepenz/materialdrawer/model/interfaces/IProfile;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AccountHeader.kt */
    public interface OnAccountHeaderSelectionViewClickListener {
        boolean onClick(View view, IProfile<?> iProfile);
    }

    public final void setActiveProfile(long j) {
        setActiveProfile$default(this, j, false, 2, (Object) null);
    }

    public AccountHeader(AccountHeaderBuilder accountHeaderBuilder2) {
        Intrinsics.checkParameterIsNotNull(accountHeaderBuilder2, "accountHeaderBuilder");
        this.accountHeaderBuilder = accountHeaderBuilder2;
    }

    public final AccountHeaderBuilder getAccountHeaderBuilder() {
        return this.accountHeaderBuilder;
    }

    public final View getView() {
        return this.accountHeaderBuilder.getAccountHeaderContainer$materialdrawer();
    }

    public final ImageView getHeaderBackgroundView() {
        return this.accountHeaderBuilder.getAccountHeaderBackground$materialdrawer();
    }

    public final boolean isSelectionListShown() {
        return this.accountHeaderBuilder.getSelectionListShown$materialdrawer();
    }

    public final List<IProfile<?>> getProfiles() {
        return this.accountHeaderBuilder.getProfiles$materialdrawer();
    }

    public final void setProfiles(List<IProfile<?>> profiles) {
        this.accountHeaderBuilder.setProfiles$materialdrawer(profiles);
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final IProfile<?> getActiveProfile() {
        return this.accountHeaderBuilder.getCurrentProfile$materialdrawer();
    }

    public final void setActiveProfile(IProfile<?> profile) {
        if (profile != null) {
            setActiveProfile(profile, false);
        }
    }

    public final void setDrawer(Drawer drawer) {
        Intrinsics.checkParameterIsNotNull(drawer, "drawer");
        this.accountHeaderBuilder.setDrawer$materialdrawer(drawer);
    }

    public final void setHeaderBackground(ImageHolder imageHolder) {
        Intrinsics.checkParameterIsNotNull(imageHolder, "imageHolder");
        imageHolder.applyTo(this.accountHeaderBuilder.getAccountHeaderBackground$materialdrawer());
    }

    public final void setBackground(Drawable headerBackground) {
        Intrinsics.checkParameterIsNotNull(headerBackground, "headerBackground");
        this.accountHeaderBuilder.getAccountHeaderBackground$materialdrawer().setImageDrawable(headerBackground);
    }

    public final void setBackgroundRes(int headerBackgroundRes) {
        this.accountHeaderBuilder.getAccountHeaderBackground$materialdrawer().setImageResource(headerBackgroundRes);
    }

    public final void toggleSelectionList(Context ctx) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        this.accountHeaderBuilder.toggleSelectionList$materialdrawer(ctx);
    }

    public final void setSelectionFirstLineShown(boolean selectionFirstLineShown) {
        this.accountHeaderBuilder.setSelectionFirstLineShown$materialdrawer(selectionFirstLineShown);
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void setSelectionSecondLineShown(boolean selectionSecondLineShown) {
        this.accountHeaderBuilder.setSelectionSecondLineShown$materialdrawer(selectionSecondLineShown);
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void setSelectionFirstLine(String selectionFirstLine) {
        Intrinsics.checkParameterIsNotNull(selectionFirstLine, "selectionFirstLine");
        this.accountHeaderBuilder.setSelectionFirstLine$materialdrawer(selectionFirstLine);
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void setSelectionSecondLine(String selectionSecondLine) {
        Intrinsics.checkParameterIsNotNull(selectionSecondLine, "selectionSecondLine");
        this.accountHeaderBuilder.setSelectionSecondLine$materialdrawer(selectionSecondLine);
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void setActiveProfile(IProfile<?> profile, boolean fireOnProfileChanged) {
        OnAccountHeaderListener onAccountHeaderListener$materialdrawer;
        Drawer drawer$materialdrawer;
        Intrinsics.checkParameterIsNotNull(profile, Scopes.PROFILE);
        boolean isCurrentSelectedProfile = this.accountHeaderBuilder.switchProfiles$materialdrawer(profile);
        if (!(this.accountHeaderBuilder.getDrawer$materialdrawer() == null || !isSelectionListShown() || (drawer$materialdrawer = this.accountHeaderBuilder.getDrawer$materialdrawer()) == null)) {
            drawer$materialdrawer.setSelection(profile.getIdentifier(), false);
        }
        if (fireOnProfileChanged && this.accountHeaderBuilder.getOnAccountHeaderListener$materialdrawer() != null && (onAccountHeaderListener$materialdrawer = this.accountHeaderBuilder.getOnAccountHeaderListener$materialdrawer()) != null) {
            onAccountHeaderListener$materialdrawer.onProfileChanged((View) null, profile, isCurrentSelectedProfile);
        }
    }

    public static /* synthetic */ void setActiveProfile$default(AccountHeader accountHeader, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        accountHeader.setActiveProfile(j, z);
    }

    public final void setActiveProfile(long identifier, boolean fireOnProfileChanged) {
        List<IProfile<?>> $this$forEach$iv = this.accountHeaderBuilder.getProfiles$materialdrawer();
        if ($this$forEach$iv != null) {
            for (IProfile profile : $this$forEach$iv) {
                if (profile.getIdentifier() == identifier) {
                    setActiveProfile((IProfile<?>) profile, fireOnProfileChanged);
                    return;
                }
            }
        }
    }

    public final void updateProfile(IProfile<?> newProfile) {
        Intrinsics.checkParameterIsNotNull(newProfile, "newProfile");
        updateProfileByIdentifier(newProfile);
    }

    @Deprecated(message = "")
    public final void updateProfileByIdentifier(IProfile<?> newProfile) {
        Intrinsics.checkParameterIsNotNull(newProfile, "newProfile");
        int found = getPositionByIdentifier(newProfile.getIdentifier());
        if (found > -1) {
            List<IProfile<?>> profiles$materialdrawer = this.accountHeaderBuilder.getProfiles$materialdrawer();
            if (profiles$materialdrawer != null) {
                IProfile iProfile = profiles$materialdrawer.set(found, newProfile);
            }
            this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
        }
    }

    public final void addProfiles(IProfile<?>... profiles) {
        Intrinsics.checkParameterIsNotNull(profiles, "profiles");
        if (this.accountHeaderBuilder.getProfiles$materialdrawer() == null) {
            this.accountHeaderBuilder.setProfiles$materialdrawer(new ArrayList());
        }
        Collections.addAll(this.accountHeaderBuilder.getProfiles$materialdrawer(), (IProfile[]) Arrays.copyOf(profiles, profiles.length));
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void addProfile(IProfile<?> profile, int position) {
        Intrinsics.checkParameterIsNotNull(profile, Scopes.PROFILE);
        if (this.accountHeaderBuilder.getProfiles$materialdrawer() == null) {
            this.accountHeaderBuilder.setProfiles$materialdrawer(new ArrayList());
        }
        List<IProfile<?>> profiles$materialdrawer = this.accountHeaderBuilder.getProfiles$materialdrawer();
        if (profiles$materialdrawer != null) {
            profiles$materialdrawer.add(position, profile);
        }
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void removeProfile(int position) {
        List<IProfile<?>> profiles$materialdrawer;
        if (this.accountHeaderBuilder.getProfiles$materialdrawer() != null) {
            List<IProfile<?>> profiles$materialdrawer2 = this.accountHeaderBuilder.getProfiles$materialdrawer();
            if ((profiles$materialdrawer2 != null ? profiles$materialdrawer2.size() : 0) > position && (profiles$materialdrawer = this.accountHeaderBuilder.getProfiles$materialdrawer()) != null) {
                IProfile remove = profiles$materialdrawer.remove(position);
            }
        }
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void removeProfileByIdentifier(long identifier) {
        List<IProfile<?>> profiles$materialdrawer;
        int found = getPositionByIdentifier(identifier);
        if (found > -1 && (profiles$materialdrawer = this.accountHeaderBuilder.getProfiles$materialdrawer()) != null) {
            IProfile remove = profiles$materialdrawer.remove(found);
        }
        this.accountHeaderBuilder.updateHeaderAndList$materialdrawer();
    }

    public final void removeProfile(IProfile<?> profile) {
        Intrinsics.checkParameterIsNotNull(profile, Scopes.PROFILE);
        removeProfileByIdentifier(profile.getIdentifier());
    }

    public final void clear() {
        this.accountHeaderBuilder.setProfiles$materialdrawer((List<IProfile<?>>) null);
        this.accountHeaderBuilder.calculateProfiles$materialdrawer();
        this.accountHeaderBuilder.buildProfiles$materialdrawer();
    }

    private final int getPositionByIdentifier(long identifier) {
        List<IProfile<?>> $this$forEachIndexed$iv;
        if (identifier == -1 || ($this$forEachIndexed$iv = this.accountHeaderBuilder.getProfiles$materialdrawer()) == null) {
            return -1;
        }
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((IProfile) item$iv).getIdentifier() == identifier) {
                return index;
            }
            index = index$iv;
        }
        return -1;
    }

    public final Bundle saveInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(savedInstanceState, "savedInstanceState");
        savedInstanceState.putInt(BUNDLE_SELECTION_HEADER, this.accountHeaderBuilder.getCurrentSelection$materialdrawer());
        return savedInstanceState;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/materialdrawer/AccountHeader$Companion;", "", "()V", "BUNDLE_SELECTION_HEADER", "", "NAVIGATION_DRAWER_ACCOUNT_ASPECT_RATIO", "", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AccountHeader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

package com.mikepenz.materialdrawer.icons;

import android.graphics.Typeface;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.materialdrawer.R;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8VX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0014\u0010\"\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0014\u0010$\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006¨\u0006*"}, d2 = {"Lcom/mikepenz/materialdrawer/icons/MaterialDrawerFont;", "Lcom/mikepenz/iconics/typeface/ITypeface;", "()V", "author", "", "getAuthor", "()Ljava/lang/String;", "characters", "", "", "getCharacters", "()Ljava/util/Map;", "characters$delegate", "Lkotlin/Lazy;", "description", "getDescription", "fontName", "getFontName", "fontRes", "", "getFontRes", "()I", "iconCount", "getIconCount", "icons", "", "getIcons", "()Ljava/util/List;", "license", "getLicense", "licenseUrl", "getLicenseUrl", "mappingPrefix", "getMappingPrefix", "url", "getUrl", "version", "getVersion", "getIcon", "Lcom/mikepenz/iconics/typeface/IIcon;", "key", "Icon", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: MaterialDrawerFont.kt */
public final class MaterialDrawerFont implements ITypeface {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MaterialDrawerFont.class), "characters", "getCharacters()Ljava/util/Map;"))};
    public static final MaterialDrawerFont INSTANCE = new MaterialDrawerFont();
    private static final Lazy characters$delegate = LazyKt.lazy(MaterialDrawerFont$characters$2.INSTANCE);

    public Map<String, Character> getCharacters() {
        Lazy lazy = characters$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Map) lazy.getValue();
    }

    private MaterialDrawerFont() {
    }

    public Typeface getRawTypeface() {
        return ITypeface.DefaultImpls.getRawTypeface(this);
    }

    public int getFontRes() {
        return R.font.materialdrawerfont_font_v5_0_0;
    }

    public String getMappingPrefix() {
        return "mdf";
    }

    public String getFontName() {
        return "MaterialDrawerFont";
    }

    public String getVersion() {
        return "5.0.0";
    }

    public int getIconCount() {
        return getCharacters().size();
    }

    public List<String> getIcons() {
        return (List) CollectionsKt.toCollection(getCharacters().keySet(), new LinkedList());
    }

    public String getAuthor() {
        return "";
    }

    public String getUrl() {
        return "";
    }

    public String getDescription() {
        return "";
    }

    public String getLicense() {
        return "";
    }

    public String getLicenseUrl() {
        return "";
    }

    public IIcon getIcon(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return Icon.valueOf(key);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/mikepenz/materialdrawer/icons/MaterialDrawerFont$Icon;", "", "Lcom/mikepenz/iconics/typeface/IIcon;", "character", "", "(Ljava/lang/String;IC)V", "getCharacter", "()C", "typeface", "Lcom/mikepenz/iconics/typeface/ITypeface;", "getTypeface", "()Lcom/mikepenz/iconics/typeface/ITypeface;", "typeface$delegate", "Lkotlin/Lazy;", "mdf_arrow_drop_down", "mdf_arrow_drop_up", "mdf_expand_less", "mdf_expand_more", "mdf_person", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MaterialDrawerFont.kt */
    public enum Icon implements IIcon {
        mdf_arrow_drop_down(58821),
        mdf_arrow_drop_up(58823),
        mdf_expand_less(58830),
        mdf_expand_more(58831),
        mdf_person(59389);
        
        private final char character;
        private final Lazy typeface$delegate;

        public ITypeface getTypeface() {
            Lazy lazy = this.typeface$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (ITypeface) lazy.getValue();
        }

        private Icon(char character2) {
            this.character = character2;
            this.typeface$delegate = LazyKt.lazy(MaterialDrawerFont$Icon$typeface$2.INSTANCE);
        }

        public char getCharacter() {
            return this.character;
        }

        public String getFormattedName() {
            return IIcon.DefaultImpls.getFormattedName(this);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Icon.class), "typeface", "getTypeface()Lcom/mikepenz/iconics/typeface/ITypeface;"))};
        }
    }
}

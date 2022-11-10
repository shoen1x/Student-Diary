package com.mikepenz.iconics.typeface;

import android.graphics.Typeface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.IconicsPreconditions;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0014¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\fB)\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004H\u0016J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0012R\u0014\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u000fR\u0014\u0010.\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000f¨\u00068"}, d2 = {"Lcom/mikepenz/iconics/typeface/GenericFont;", "Lcom/mikepenz/iconics/typeface/ITypeface;", "()V", "mappingPrefix", "", "fontFile", "(Ljava/lang/String;Ljava/lang/String;)V", "fontRes", "", "(Ljava/lang/String;I)V", "fontName", "author", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthor", "()Ljava/lang/String;", "characters", "", "", "getCharacters", "()Ljava/util/Map;", "chars", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "description", "getDescription", "getFontName", "getFontRes", "()I", "iconCount", "getIconCount", "icons", "", "getIcons", "()Ljava/util/List;", "license", "getLicense", "licenseUrl", "getLicenseUrl", "getMappingPrefix", "rawTypeface", "Landroid/graphics/Typeface;", "getRawTypeface", "()Landroid/graphics/Typeface;", "url", "getUrl", "version", "getVersion", "getIcon", "Lcom/mikepenz/iconics/typeface/IIcon;", "key", "registerIcon", "", "name", "char", "Icon", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: GenericFont.kt */
public class GenericFont implements ITypeface {
    private final String author;
    private final HashMap<String, Character> chars;
    private final String fontFile;
    private final String fontName;
    private final int fontRes;
    private final String mappingPrefix;

    public String getFontName() {
        return this.fontName;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getMappingPrefix() {
        return this.mappingPrefix;
    }

    public int getFontRes() {
        return this.fontRes;
    }

    public Typeface getRawTypeface() {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(Iconics.getApplicationContext().getAssets(), this.fontFile);
            Intrinsics.checkExpressionValueIsNotNull(createFromAsset, "Typeface.createFromAsset…Context.assets, fontFile)");
            return createFromAsset;
        } catch (Exception e) {
            return ITypeface.DefaultImpls.getRawTypeface(this);
        }
    }

    public Map<String, Character> getCharacters() {
        return this.chars;
    }

    public String getVersion() {
        return "1.0.0";
    }

    public int getIconCount() {
        return getCharacters().size();
    }

    public List<String> getIcons() {
        return (List) CollectionsKt.toCollection(getCharacters().keySet(), new LinkedList());
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

    protected GenericFont() {
        this("GenericFont", "GenericAuthor", "", "");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GenericFont(String mappingPrefix2, String fontFile2) {
        this("GenericFont", "GenericAuthor", mappingPrefix2, fontFile2);
        Intrinsics.checkParameterIsNotNull(mappingPrefix2, "mappingPrefix");
        Intrinsics.checkParameterIsNotNull(fontFile2, "fontFile");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GenericFont(String mappingPrefix2, int fontRes2) {
        this("GenericFont", "GenericAuthor", mappingPrefix2, fontRes2);
        Intrinsics.checkParameterIsNotNull(mappingPrefix2, "mappingPrefix");
    }

    public GenericFont(String fontName2, String author2, String mappingPrefix2, String fontFile2) {
        Intrinsics.checkParameterIsNotNull(fontName2, "fontName");
        Intrinsics.checkParameterIsNotNull(author2, "author");
        Intrinsics.checkParameterIsNotNull(mappingPrefix2, "mappingPrefix");
        Intrinsics.checkParameterIsNotNull(fontFile2, "fontFile");
        this.chars = new HashMap<>();
        IconicsPreconditions.checkMappingPrefix(mappingPrefix2);
        this.fontName = fontName2;
        this.author = author2;
        this.mappingPrefix = mappingPrefix2;
        this.fontFile = fontFile2;
        this.fontRes = -1;
    }

    public GenericFont(String fontName2, String author2, String mappingPrefix2, int fontRes2) {
        Intrinsics.checkParameterIsNotNull(fontName2, "fontName");
        Intrinsics.checkParameterIsNotNull(author2, "author");
        Intrinsics.checkParameterIsNotNull(mappingPrefix2, "mappingPrefix");
        this.chars = new HashMap<>();
        IconicsPreconditions.checkMappingPrefix(mappingPrefix2);
        this.fontName = fontName2;
        this.author = author2;
        this.mappingPrefix = mappingPrefix2;
        this.fontFile = "";
        this.fontRes = fontRes2;
    }

    public final void registerIcon(String name, char c) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.chars.put(getMappingPrefix() + "_" + name, Character.valueOf(c));
    }

    public IIcon getIcon(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new Icon(this, key, ((Character) MapsKt.getValue(this.chars, key)).charValue()).withTypeface(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0013\u001a\u00060\u0000R\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/mikepenz/iconics/typeface/GenericFont$Icon;", "Lcom/mikepenz/iconics/typeface/IIcon;", "c", "", "(Lcom/mikepenz/iconics/typeface/GenericFont;C)V", "name", "", "(Lcom/mikepenz/iconics/typeface/GenericFont;Ljava/lang/String;C)V", "character", "getCharacter", "()C", "customName", "customTypeface", "Lcom/mikepenz/iconics/typeface/ITypeface;", "getName", "()Ljava/lang/String;", "typeface", "getTypeface", "()Lcom/mikepenz/iconics/typeface/ITypeface;", "withTypeface", "Lcom/mikepenz/iconics/typeface/GenericFont;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GenericFont.kt */
    public final class Icon implements IIcon {
        private final char character;
        private final String customName;
        private ITypeface customTypeface;

        public String getFormattedName() {
            return IIcon.DefaultImpls.getFormattedName(this);
        }

        public Icon(char c) {
            this.customName = null;
            this.character = c;
        }

        public Icon(GenericFont $outer, String name, char c) {
            Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            GenericFont.this = $outer;
            this.customName = name;
            this.character = c;
        }

        public char getCharacter() {
            return this.character;
        }

        public String getName() {
            String str = this.customName;
            return str != null ? str : String.valueOf(getCharacter());
        }

        public ITypeface getTypeface() {
            ITypeface iTypeface = this.customTypeface;
            return iTypeface != null ? iTypeface : GenericFont.this;
        }

        public final Icon withTypeface(ITypeface typeface) {
            this.customTypeface = typeface;
            return this;
        }
    }
}

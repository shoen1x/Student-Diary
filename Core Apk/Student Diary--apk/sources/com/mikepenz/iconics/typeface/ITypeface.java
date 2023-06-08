package com.mikepenz.iconics.typeface;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.mikepenz.iconics.Iconics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00108gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0005R\u0012\u0010\u001d\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0005R\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005¨\u0006*"}, d2 = {"Lcom/mikepenz/iconics/typeface/ITypeface;", "", "author", "", "getAuthor", "()Ljava/lang/String;", "characters", "", "", "getCharacters", "()Ljava/util/Map;", "description", "getDescription", "fontName", "getFontName", "fontRes", "", "getFontRes", "()I", "iconCount", "getIconCount", "icons", "", "getIcons", "()Ljava/util/List;", "license", "getLicense", "licenseUrl", "getLicenseUrl", "mappingPrefix", "getMappingPrefix", "rawTypeface", "Landroid/graphics/Typeface;", "getRawTypeface", "()Landroid/graphics/Typeface;", "url", "getUrl", "version", "getVersion", "getIcon", "Lcom/mikepenz/iconics/typeface/IIcon;", "key", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: ITypeface.kt */
public interface ITypeface {
    String getAuthor();

    Map<String, Character> getCharacters();

    String getDescription();

    String getFontName();

    int getFontRes();

    IIcon getIcon(String str);

    int getIconCount();

    List<String> getIcons();

    String getLicense();

    String getLicenseUrl();

    String getMappingPrefix();

    Typeface getRawTypeface();

    String getUrl();

    String getVersion();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* compiled from: ITypeface.kt */
    public static final class DefaultImpls {
        public static Typeface getRawTypeface(ITypeface $this) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m65constructorimpl(ResourcesCompat.getFont(Iconics.getApplicationContext(), $this.getFontRes()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m65constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m71isFailureimpl(obj)) {
                obj = null;
            }
            Typeface typeface = (Typeface) obj;
            if (typeface != null) {
                return typeface;
            }
            Typeface typeface2 = Typeface.DEFAULT;
            Intrinsics.checkExpressionValueIsNotNull(typeface2, "Typeface.DEFAULT");
            return typeface2;
        }
    }
}

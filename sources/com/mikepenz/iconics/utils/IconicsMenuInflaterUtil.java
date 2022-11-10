package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsAttrsApplier;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J*\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J\f\u0010\u001e\u001a\u00020\u0012*\u00020\u001cH\u0003R\u0018\u0010\u0003\u001a\u00060\u0004j\u0002`\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/mikepenz/iconics/utils/IconicsMenuInflaterUtil;", "", "()V", "EOD", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getEOD", "()Ljava/lang/RuntimeException;", "XML_ITEM", "", "XML_MENU", "inflate", "", "inflater", "Landroid/view/MenuInflater;", "context", "Landroid/content/Context;", "menuId", "", "menu", "Landroid/view/Menu;", "checkSubMenus", "", "parseItem", "attrs", "Landroid/util/AttributeSet;", "parseMenu", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseXmlAndSetIconicsDrawables", "skipToStartMenu", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconicsMenuInflaterUtil.kt */
public final class IconicsMenuInflaterUtil {
    public static final IconicsMenuInflaterUtil INSTANCE = new IconicsMenuInflaterUtil();
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";

    @JvmStatic
    public static final void inflate(MenuInflater menuInflater, Context context, int i, Menu menu) {
        inflate$default(menuInflater, context, i, menu, false, 16, (Object) null);
    }

    @JvmStatic
    public static final void parseXmlAndSetIconicsDrawables(Context context, int i, Menu menu) {
        parseXmlAndSetIconicsDrawables$default(context, i, menu, false, 8, (Object) null);
    }

    private IconicsMenuInflaterUtil() {
    }

    private final RuntimeException getEOD() {
        return new RuntimeException("Unexpected end of document");
    }

    public static /* synthetic */ void inflate$default(MenuInflater menuInflater, Context context, int i, Menu menu, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        inflate(menuInflater, context, i, menu, z);
    }

    @JvmStatic
    public static final void inflate(MenuInflater inflater, Context context, int menuId, Menu menu, boolean checkSubMenus) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(menu, XML_MENU);
        inflater.inflate(menuId, menu);
        parseXmlAndSetIconicsDrawables(context, menuId, menu, checkSubMenus);
    }

    public static /* synthetic */ void parseXmlAndSetIconicsDrawables$default(Context context, int i, Menu menu, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        parseXmlAndSetIconicsDrawables(context, i, menu, z);
    }

    @JvmStatic
    public static final void parseXmlAndSetIconicsDrawables(Context context, int menuId, Menu menu, boolean checkSubMenus) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(menu, XML_MENU);
        XmlResourceParser parser = null;
        try {
            XmlResourceParser it = context.getResources().getLayout(menuId);
            parser = it;
            AttributeSet asAttributeSet = Xml.asAttributeSet(it);
            Intrinsics.checkExpressionValueIsNotNull(asAttributeSet, "Xml.asAttributeSet(it)");
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            parseMenu(context, asAttributeSet, it, menu, checkSubMenus);
            if (parser == null) {
                return;
            }
        } catch (XmlPullParserException e) {
            Iconics.logger.log(6, Iconics.TAG, "Error while parse menu", e);
            if (parser == null) {
                return;
            }
        } catch (IOException e2) {
            Iconics.logger.log(6, Iconics.TAG, "Error while parse menu", e2);
            if (parser == null) {
                return;
            }
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
        parser.close();
    }

    @JvmStatic
    private static final void parseMenu(Context context, AttributeSet attrs, XmlPullParser parser, Menu menu, boolean checkSubMenus) {
        int currentParserEvent = skipToStartMenu(parser);
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            if (currentParserEvent != 1) {
                if (currentParserEvent != 2) {
                    if (currentParserEvent == 3) {
                        String name = parser.getName();
                        Intrinsics.checkExpressionValueIsNotNull(name, "parser.name");
                        String tagName = name;
                        if (lookingForEndOfUnknownTag && Intrinsics.areEqual((Object) tagName, (Object) unknownTagName)) {
                            lookingForEndOfUnknownTag = false;
                            unknownTagName = null;
                        } else if (Intrinsics.areEqual((Object) XML_MENU, (Object) tagName)) {
                            reachedEndOfMenu = true;
                        }
                    }
                } else if (!lookingForEndOfUnknownTag) {
                    String name2 = parser.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name2, "parser.name");
                    String tagName2 = name2;
                    int hashCode = tagName2.hashCode();
                    if (hashCode != 3242771) {
                        if (hashCode == 3347807 && tagName2.equals(XML_MENU)) {
                            if (checkSubMenus) {
                                parseMenu(context, attrs, parser, menu, true);
                            }
                        }
                    } else if (tagName2.equals(XML_ITEM)) {
                        parseItem(context, attrs, menu);
                    }
                    lookingForEndOfUnknownTag = true;
                    unknownTagName = tagName2;
                }
                currentParserEvent = parser.next();
            } else {
                throw INSTANCE.getEOD();
            }
        }
    }

    @JvmStatic
    private static final int skipToStartMenu(XmlPullParser $this$skipToStartMenu) {
        while ($this$skipToStartMenu.getEventType() != 2) {
            if ($this$skipToStartMenu.next() == 1) {
                throw INSTANCE.getEOD();
            }
        }
        if (Intrinsics.areEqual((Object) XML_MENU, (Object) $this$skipToStartMenu.getName())) {
            return $this$skipToStartMenu.next();
        }
        throw new RuntimeException("Expected <menu> tag but got " + $this$skipToStartMenu.getName());
    }

    @JvmStatic
    private static final void parseItem(Context context, AttributeSet attrs, Menu menu) {
        String replace$default;
        String it;
        MenuItem menuItem;
        IconicsDrawable it2;
        Map attrsMap = new LinkedHashMap();
        int attributeCount = attrs.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            int it3 = i;
            String attributeName = attrs.getAttributeName(it3);
            Intrinsics.checkExpressionValueIsNotNull(attributeName, "attrs.getAttributeName(it)");
            String attributeValue = attrs.getAttributeValue(it3);
            Intrinsics.checkExpressionValueIsNotNull(attributeValue, "attrs.getAttributeValue(it)");
            attrsMap.put(attributeName, attributeValue);
        }
        String str = (String) attrsMap.get("id");
        if (str != null && (replace$default = StringsKt.replace$default(str, "@", "", false, 4, (Object) null)) != null && (it = StringsKt.removePrefix(replace$default, (CharSequence) "+id/")) != null && (menuItem = menu.findItem(context.getResources().getIdentifier(it, "id", context.getPackageName()))) != null && (it2 = IconicsAttrsApplier.getIconicsDrawable(context, attrs)) != null) {
            menuItem.setIcon(it2);
        }
    }
}

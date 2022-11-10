package com.mikepenz.materialdrawer.icons;

import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MaterialDrawerFont.kt */
final class MaterialDrawerFont$characters$2 extends Lambda implements Function0<Map<String, ? extends Character>> {
    public static final MaterialDrawerFont$characters$2 INSTANCE = new MaterialDrawerFont$characters$2();

    MaterialDrawerFont$characters$2() {
        super(0);
    }

    public final Map<String, Character> invoke() {
        MaterialDrawerFont.Icon[] values = MaterialDrawerFont.Icon.values();
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (MaterialDrawerFont.Icon it : values) {
            Pair pair = TuplesKt.to(it.name(), Character.valueOf(it.getCharacter()));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }
}

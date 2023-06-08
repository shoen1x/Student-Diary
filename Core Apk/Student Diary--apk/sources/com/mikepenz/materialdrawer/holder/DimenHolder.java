package com.mikepenz.materialdrawer.holder;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "Lcom/mikepenz/materialize/holder/DimenHolder;", "()V", "Companion", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: DimenHolder.kt */
public class DimenHolder extends com.mikepenz.materialize.holder.DimenHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/mikepenz/materialdrawer/holder/DimenHolder$Companion;", "", "()V", "fromDp", "Lcom/mikepenz/materialdrawer/holder/DimenHolder;", "dp", "", "fromPixel", "pixel", "fromResource", "resource", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DimenHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final DimenHolder fromPixel(int pixel) {
            DimenHolder dimenHolder = new DimenHolder();
            dimenHolder.setPixel(pixel);
            return dimenHolder;
        }

        public final DimenHolder fromDp(int dp) {
            DimenHolder dimenHolder = new DimenHolder();
            dimenHolder.setDp(dp);
            return dimenHolder;
        }

        public final DimenHolder fromResource(int resource) {
            DimenHolder dimenHolder = new DimenHolder();
            dimenHolder.setResource(resource);
            return dimenHolder;
        }
    }
}

package com.mikepenz.materialdrawer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001EB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020$H\u0014J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0014J(\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J(\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0010H\u0016J\u0012\u0010;\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u000e\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0007J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u001bH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/mikepenz/materialdrawer/view/BezelImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBlackPaint", "Landroid/graphics/Paint;", "mBounds", "Landroid/graphics/Rect;", "mBoundsF", "Landroid/graphics/RectF;", "mCacheBitmap", "Landroid/graphics/Bitmap;", "mCacheValid", "", "mCachedHeight", "mCachedWidth", "mDesaturateColorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "mDrawCircularShadow", "mIsPressed", "mIsSelected", "mMaskDrawable", "Landroid/graphics/drawable/Drawable;", "mMaskedPaint", "mSelectorAlpha", "mSelectorColor", "mSelectorFilter", "Landroid/graphics/ColorFilter;", "mTempDesaturateColorFilter", "mTempSelectorFilter", "disableTouchFeedback", "", "disable", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "drawableStateChanged", "invalidateDrawable", "who", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "old_w", "old_h", "setFrame", "l", "t", "r", "b", "setImageBitmap", "bm", "setImageDrawable", "drawable", "setImageResource", "resId", "setImageURI", "uri", "Landroid/net/Uri;", "setSelectorColor", "selectorColor", "verifyDrawable", "CustomOutline", "materialdrawer"}, k = 1, mv = {1, 1, 16})
/* compiled from: BezelImageView.kt */
public class BezelImageView extends AppCompatImageView {
    private HashMap _$_findViewCache;
    private final Paint mBlackPaint;
    private Rect mBounds;
    private RectF mBoundsF;
    private Bitmap mCacheBitmap;
    private boolean mCacheValid;
    private int mCachedHeight;
    private int mCachedWidth;
    private ColorMatrixColorFilter mDesaturateColorFilter;
    private boolean mDrawCircularShadow;
    private boolean mIsPressed;
    private boolean mIsSelected;
    private final Drawable mMaskDrawable;
    private final Paint mMaskedPaint;
    private final int mSelectorAlpha;
    private int mSelectorColor;
    private ColorFilter mSelectorFilter;
    private ColorMatrixColorFilter mTempDesaturateColorFilter;
    private ColorFilter mTempSelectorFilter;

    public BezelImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BezelImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mDrawCircularShadow = true;
        this.mSelectorAlpha = 150;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BezelImageView, defStyle, R.style.BezelImageView);
        Drawable drawable = a.getDrawable(R.styleable.BezelImageView_biv_maskDrawable);
        this.mMaskDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.mDrawCircularShadow = a.getBoolean(R.styleable.BezelImageView_biv_drawCircularShadow, true);
        this.mSelectorColor = a.getColor(R.styleable.BezelImageView_biv_selectorOnPress, 0);
        a.recycle();
        Paint paint = new Paint();
        this.mBlackPaint = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = new Paint();
        this.mMaskedPaint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.mCacheBitmap = createBitmap;
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0.0f);
        this.mDesaturateColorFilter = new ColorMatrixColorFilter(cm);
        if (this.mSelectorColor != 0) {
            this.mSelectorFilter = new PorterDuffColorFilter(Color.argb(this.mSelectorAlpha, Color.red(this.mSelectorColor), Color.green(this.mSelectorColor), Color.blue(this.mSelectorColor)), PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BezelImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int old_w, int old_h) {
        if (Build.VERSION.SDK_INT >= 21 && this.mDrawCircularShadow) {
            setOutlineProvider(new CustomOutline(w, h));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/mikepenz/materialdrawer/view/BezelImageView$CustomOutline;", "Landroid/view/ViewOutlineProvider;", "width", "", "height", "(Lcom/mikepenz/materialdrawer/view/BezelImageView;II)V", "getHeight$materialdrawer", "()I", "setHeight$materialdrawer", "(I)V", "getWidth$materialdrawer", "setWidth$materialdrawer", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "materialdrawer"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BezelImageView.kt */
    private final class CustomOutline extends ViewOutlineProvider {
        private int height;
        private int width;

        public CustomOutline(int width2, int height2) {
            this.width = width2;
            this.height = height2;
        }

        public final int getHeight$materialdrawer() {
            return this.height;
        }

        public final int getWidth$materialdrawer() {
            return this.width;
        }

        public final void setHeight$materialdrawer(int i) {
            this.height = i;
        }

        public final void setWidth$materialdrawer(int i) {
            this.width = i;
        }

        public void getOutline(View view, Outline outline) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(outline, "outline");
            outline.setOval(0, 0, this.width, this.height);
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        Rect rect = new Rect(0, 0, r - l, b - t);
        Rect it = rect;
        this.mBoundsF = new RectF(it);
        Drawable drawable = this.mMaskDrawable;
        if (drawable != null) {
            drawable.setBounds(it);
        }
        this.mBounds = rect;
        if (changed) {
            this.mCacheValid = false;
        }
        return changed;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Rect bounds = this.mBounds;
        if (bounds != null) {
            int width = bounds.width();
            int height = bounds.height();
            if (width != 0 && height != 0) {
                if (!(this.mCacheValid && width == this.mCachedWidth && height == this.mCachedHeight && this.mIsSelected == this.mIsPressed)) {
                    if (width == this.mCachedWidth && height == this.mCachedHeight) {
                        this.mCacheBitmap.eraseColor(0);
                    } else {
                        this.mCacheBitmap.recycle();
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
                        this.mCacheBitmap = createBitmap;
                        this.mCachedWidth = width;
                        this.mCachedHeight = height;
                    }
                    Canvas cacheCanvas = new Canvas(this.mCacheBitmap);
                    if (this.mMaskDrawable != null) {
                        int sc = cacheCanvas.save();
                        this.mMaskDrawable.draw(cacheCanvas);
                        if (this.mIsSelected) {
                            ColorFilter colorFilter = this.mSelectorFilter;
                            if (colorFilter != null) {
                                this.mMaskedPaint.setColorFilter(colorFilter);
                            } else {
                                this.mMaskedPaint.setColorFilter(this.mDesaturateColorFilter);
                            }
                        } else {
                            this.mMaskedPaint.setColorFilter((ColorFilter) null);
                        }
                        cacheCanvas.saveLayer(this.mBoundsF, this.mMaskedPaint, 31);
                        super.onDraw(cacheCanvas);
                        cacheCanvas.restoreToCount(sc);
                    } else if (this.mIsSelected) {
                        int sc2 = cacheCanvas.save();
                        cacheCanvas.drawRect(0.0f, 0.0f, (float) this.mCachedWidth, (float) this.mCachedHeight, this.mBlackPaint);
                        ColorFilter colorFilter2 = this.mSelectorFilter;
                        if (colorFilter2 != null) {
                            this.mMaskedPaint.setColorFilter(colorFilter2);
                        } else {
                            this.mMaskedPaint.setColorFilter(this.mDesaturateColorFilter);
                        }
                        cacheCanvas.saveLayer(this.mBoundsF, this.mMaskedPaint, 31);
                        super.onDraw(cacheCanvas);
                        cacheCanvas.restoreToCount(sc2);
                    } else {
                        super.onDraw(cacheCanvas);
                    }
                }
                canvas.drawBitmap(this.mCacheBitmap, (float) bounds.left, (float) bounds.top, (Paint) null);
                this.mIsPressed = isPressed();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
        if (!isClickable()) {
            this.mIsSelected = false;
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            this.mIsSelected = true;
        } else if (action == 1 || action == 3 || action == 4 || action == 8) {
            this.mIsSelected = false;
        }
        invalidate();
        return super.dispatchTouchEvent(event);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMaskDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mMaskDrawable.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkParameterIsNotNull(who, "who");
        if (who == this.mMaskDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(who);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        Intrinsics.checkParameterIsNotNull(who, "who");
        return who == this.mMaskDrawable || super.verifyDrawable(who);
    }

    public final void setSelectorColor(int selectorColor) {
        this.mSelectorColor = selectorColor;
        this.mSelectorFilter = new PorterDuffColorFilter(Color.argb(this.mSelectorAlpha, Color.red(this.mSelectorColor), Color.green(this.mSelectorColor), Color.blue(this.mSelectorColor)), PorterDuff.Mode.SRC_ATOP);
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
    }

    public void setImageBitmap(Bitmap bm) {
        Intrinsics.checkParameterIsNotNull(bm, "bm");
        super.setImageBitmap(bm);
    }

    public void setImageURI(Uri uri) {
        if (!Intrinsics.areEqual((Object) "http", (Object) uri != null ? uri.getScheme() : null)) {
            if (!Intrinsics.areEqual((Object) "https", (Object) uri != null ? uri.getScheme() : null)) {
                super.setImageURI(uri);
                return;
            }
        }
        DrawerImageLoader.Companion.getInstance().setImage(this, uri, (String) null);
    }

    public final void disableTouchFeedback(boolean disable) {
        if (disable) {
            this.mTempDesaturateColorFilter = this.mDesaturateColorFilter;
            this.mTempSelectorFilter = this.mSelectorFilter;
            this.mSelectorFilter = null;
            this.mDesaturateColorFilter = null;
            return;
        }
        ColorMatrixColorFilter colorMatrixColorFilter = this.mTempDesaturateColorFilter;
        if (colorMatrixColorFilter != null) {
            this.mDesaturateColorFilter = colorMatrixColorFilter;
        }
        ColorFilter colorFilter = this.mTempSelectorFilter;
        if (colorFilter != null) {
            this.mSelectorFilter = colorFilter;
        }
    }
}

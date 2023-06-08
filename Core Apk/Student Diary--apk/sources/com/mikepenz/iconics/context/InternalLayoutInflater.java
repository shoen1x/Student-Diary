package com.mikepenz.iconics.context;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 '2\u00020\u0001:\u0004'()*B\u000f\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J,\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J$\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0017J\b\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/mikepenz/iconics/context/InternalLayoutInflater;", "Landroid/view/LayoutInflater;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "original", "newContext", "cloned", "", "(Landroid/view/LayoutInflater;Landroid/content/Context;Z)V", "constructorArgs", "Ljava/lang/reflect/Field;", "isSetPrivateFactory", "cloneInContext", "createCustomViewInternal", "Landroid/view/View;", "view", "name", "", "viewContext", "attrs", "Landroid/util/AttributeSet;", "inflate", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "root", "Landroid/view/ViewGroup;", "attachToRoot", "onCreateView", "parent", "setFactory", "", "factory", "Landroid/view/LayoutInflater$Factory;", "setFactory2", "factory2", "Landroid/view/LayoutInflater$Factory2;", "setPrivateFactoryInternal", "setUpLayoutFactories", "Companion", "PrivateWrapperFactory2", "WrapperFactory", "WrapperFactory2", "iconics-core"}, k = 1, mv = {1, 1, 15})
@Deprecated(message = "Use the IconicsImageView or IconicsTextView instead")
/* compiled from: InternalLayoutInflater.kt */
public final class InternalLayoutInflater extends LayoutInflater {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String[] classPrefixList = {"android.widget.", "android.webkit."};
    private Field constructorArgs;
    private boolean isSetPrivateFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected InternalLayoutInflater(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setUpLayoutFactories(false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalLayoutInflater(LayoutInflater original, Context newContext, boolean cloned) {
        super(original, newContext);
        Intrinsics.checkParameterIsNotNull(original, "original");
        Intrinsics.checkParameterIsNotNull(newContext, "newContext");
        setUpLayoutFactories(cloned);
    }

    public LayoutInflater cloneInContext(Context newContext) {
        Intrinsics.checkParameterIsNotNull(newContext, "newContext");
        return new InternalLayoutInflater(this, newContext, true);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        View view = null;
        for (String it : classPrefixList) {
            try {
                Result.Companion companion = Result.Companion;
                view = createView(name, it, attrs);
                Result.m65constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m65constructorimpl(ResultKt.createFailure(th));
            }
        }
        if (view == null) {
            view = super.onCreateView(name, attrs);
        }
        if (view == null) {
            return null;
        }
        View it2 = view;
        Context context = it2.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "it.context");
        return IconicsFactory.onViewCreated(it2, context, attrs);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        View view = super.onCreateView(parent, name, attrs);
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return IconicsFactory.onViewCreated(view, context, attrs);
    }

    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        Intrinsics.checkParameterIsNotNull(parser, "parser");
        setPrivateFactoryInternal();
        View inflate = super.inflate(parser, root, attachToRoot);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "super.inflate(parser, root, attachToRoot)");
        return inflate;
    }

    private final void setUpLayoutFactories(boolean cloned) {
        if (!cloned && getFactory2() != null && !(getFactory2() instanceof WrapperFactory2)) {
            setFactory2(getFactory2());
        }
    }

    public void setFactory(LayoutInflater.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "factory");
        if (!(factory instanceof WrapperFactory)) {
            super.setFactory(new WrapperFactory(factory));
        } else {
            super.setFactory(factory);
        }
    }

    public void setFactory2(LayoutInflater.Factory2 factory2) {
        Intrinsics.checkParameterIsNotNull(factory2, "factory2");
        if (!(factory2 instanceof WrapperFactory2)) {
            super.setFactory2(new WrapperFactory2(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    private final void setPrivateFactoryInternal() {
        if (!this.isSetPrivateFactory) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.isSetPrivateFactory = true;
                return;
            }
            Method setPrivateFactoryMethod = ReflectionUtils.INSTANCE.getMethod(LayoutInflater.class, "setPrivateFactory");
            if (setPrivateFactoryMethod != null) {
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Object[] objArr = new Object[1];
                Context context = getContext();
                if (context != null) {
                    objArr[0] = new PrivateWrapperFactory2((LayoutInflater.Factory2) context, this);
                    reflectionUtils.invokeMethod(this, setPrivateFactoryMethod, objArr);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
                }
            }
            this.isSetPrivateFactory = true;
        }
    }

    /* access modifiers changed from: private */
    public final View createCustomViewInternal(View view, String name, Context viewContext, AttributeSet attrs) {
        View view2 = view;
        if (view2 == null && StringsKt.contains$default((CharSequence) name, '.', false, 2, (Object) null)) {
            if (this.constructorArgs == null) {
                this.constructorArgs = ReflectionUtils.INSTANCE.getField(LayoutInflater.class, "mConstructorArgs");
            }
            Field constructorArgs2 = this.constructorArgs;
            if (constructorArgs2 == null) {
                return null;
            }
            Object value = ReflectionUtils.INSTANCE.getValue(constructorArgs2, this);
            if (value != null) {
                Object[] constArgs = (Object[]) value;
                Object lastContext = constArgs[0];
                constArgs[0] = viewContext;
                ReflectionUtils.INSTANCE.setValue(constructorArgs2, this, constArgs);
                try {
                    Result.Companion companion = Result.Companion;
                    view2 = createView(name, (String) null, attrs);
                    Result.m65constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m65constructorimpl(ResultKt.createFailure(th));
                }
                constArgs[0] = lastContext;
                ReflectionUtils.INSTANCE.setValue(constructorArgs2, this, constArgs);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
            }
        }
        return view2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mikepenz/iconics/context/InternalLayoutInflater$WrapperFactory;", "Landroid/view/LayoutInflater$Factory;", "factory", "(Landroid/view/LayoutInflater$Factory;)V", "onCreateView", "Landroid/view/View;", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: InternalLayoutInflater.kt */
    private static final class WrapperFactory implements LayoutInflater.Factory {
        private final LayoutInflater.Factory factory;

        public WrapperFactory(LayoutInflater.Factory factory2) {
            Intrinsics.checkParameterIsNotNull(factory2, "factory");
            this.factory = factory2;
        }

        public View onCreateView(String name, Context context, AttributeSet attrs) {
            Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attrs, "attrs");
            return IconicsFactory.onViewCreated(this.factory.onCreateView(name, context, attrs), context, attrs);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J,\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mikepenz/iconics/context/InternalLayoutInflater$WrapperFactory2;", "Landroid/view/LayoutInflater$Factory2;", "factory2", "(Landroid/view/LayoutInflater$Factory2;)V", "getFactory2", "()Landroid/view/LayoutInflater$Factory2;", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: InternalLayoutInflater.kt */
    private static class WrapperFactory2 implements LayoutInflater.Factory2 {
        private final LayoutInflater.Factory2 factory2;

        public WrapperFactory2(LayoutInflater.Factory2 factory22) {
            Intrinsics.checkParameterIsNotNull(factory22, "factory2");
            this.factory2 = factory22;
        }

        /* access modifiers changed from: protected */
        public final LayoutInflater.Factory2 getFactory2() {
            return this.factory2;
        }

        public View onCreateView(String name, Context context, AttributeSet attrs) {
            Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attrs, "attrs");
            return IconicsFactory.onViewCreated(this.factory2.onCreateView(name, context, attrs), context, attrs);
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attrs, "attrs");
            return IconicsFactory.onViewCreated(this.factory2.onCreateView(parent, name, context, attrs), context, attrs);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mikepenz/iconics/context/InternalLayoutInflater$PrivateWrapperFactory2;", "Lcom/mikepenz/iconics/context/InternalLayoutInflater$WrapperFactory2;", "factory2", "Landroid/view/LayoutInflater$Factory2;", "inflater", "Lcom/mikepenz/iconics/context/InternalLayoutInflater;", "(Landroid/view/LayoutInflater$Factory2;Lcom/mikepenz/iconics/context/InternalLayoutInflater;)V", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: InternalLayoutInflater.kt */
    private static final class PrivateWrapperFactory2 extends WrapperFactory2 {
        private final InternalLayoutInflater inflater;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrivateWrapperFactory2(LayoutInflater.Factory2 factory2, InternalLayoutInflater inflater2) {
            super(factory2);
            Intrinsics.checkParameterIsNotNull(factory2, "factory2");
            Intrinsics.checkParameterIsNotNull(inflater2, "inflater");
            this.inflater = inflater2;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attrs, "attrs");
            return IconicsFactory.onViewCreated(this.inflater.createCustomViewInternal(getFactory2().onCreateView(parent, name, context, attrs), name, context, attrs), context, attrs);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mikepenz/iconics/context/InternalLayoutInflater$Companion;", "", "()V", "classPrefixList", "", "", "[Ljava/lang/String;", "iconics-core"}, k = 1, mv = {1, 1, 15})
    /* compiled from: InternalLayoutInflater.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

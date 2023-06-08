package com.mikepenz.iconics.context;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mikepenz.iconics.Iconics;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\bH\b¢\u0006\u0002\u0010\fJ&\u0010\r\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u0006H\b¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001¨\u0006\u001e"}, d2 = {"Lcom/mikepenz/iconics/context/ReflectionUtils;", "", "()V", "getField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "fieldName", "", "getInstanceForName", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getInstanceOf", "cls", "(Ljava/lang/Class;)Ljava/lang/Object;", "getMethod", "Ljava/lang/reflect/Method;", "methodName", "getValue", "field", "obj", "invokeMethod", "", "method", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "setValue", "value", "iconics-core"}, k = 1, mv = {1, 1, 15})
/* compiled from: ReflectionUtils.kt */
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    public final Field getField(Class<?> clazz, String fieldName) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
        try {
            Result.Companion companion = Result.Companion;
            ReflectionUtils reflectionUtils = this;
            obj = Result.m65constructorimpl(clazz.getDeclaredField(fieldName));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m71isFailureimpl(obj)) {
            obj = null;
        }
        Field field = (Field) obj;
        if (field == null) {
            return null;
        }
        Field it = field;
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        it.setAccessible(true);
        return field;
    }

    public final Object getValue(Field field, Object obj) {
        Object obj2;
        Intrinsics.checkParameterIsNotNull(field, "field");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        try {
            Result.Companion companion = Result.Companion;
            ReflectionUtils reflectionUtils = this;
            obj2 = Result.m65constructorimpl(field.get(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m71isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }

    public final void setValue(Field field, Object obj, Object value) {
        Intrinsics.checkParameterIsNotNull(field, "field");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        Intrinsics.checkParameterIsNotNull(value, "value");
        try {
            Result.Companion companion = Result.Companion;
            ReflectionUtils reflectionUtils = this;
            field.set(obj, value);
            Result.m65constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m65constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final Method getMethod(Class<?> clazz, String methodName) {
        Method it;
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        Method[] methods = clazz.getMethods();
        Intrinsics.checkExpressionValueIsNotNull(methods, "clazz.methods");
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                it = null;
                break;
            }
            it = methods[i];
            Method it2 = it;
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            if (Intrinsics.areEqual((Object) it2.getName(), (Object) methodName)) {
                break;
            }
            i++;
        }
        if (it == null) {
            return null;
        }
        it.setAccessible(true);
        return it;
    }

    public final void invokeMethod(Object obj, Method method, Object... args) {
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (method != null) {
            try {
                method.invoke(obj, Arrays.copyOf(args, args.length));
            } catch (IllegalAccessException e) {
                Iconics.logger.log(6, Iconics.TAG, "Can't invoke method using reflection", e);
            } catch (InvocationTargetException e2) {
                Iconics.logger.log(6, Iconics.TAG, "Can't invoke method using reflection", e2);
            }
        }
    }

    public final /* synthetic */ <T> T getInstanceForName(String name) {
        Object obj;
        T t;
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Class cls$iv = Class.forName(name);
        Intrinsics.checkExpressionValueIsNotNull(cls$iv, "Class.forName(name)");
        try {
            Result.Companion companion = Result.Companion;
            ReflectionUtils reflectionUtils = this;
            obj = Result.m65constructorimpl(cls$iv.getField("INSTANCE"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m71isFailureimpl(obj)) {
            obj = null;
        }
        Field instanceField$iv = (Field) obj;
        if (instanceField$iv == null || !Modifier.isFinal(instanceField$iv.getModifiers()) || !Modifier.isStatic(instanceField$iv.getModifiers())) {
            t = cls$iv.newInstance();
            Intrinsics.checkExpressionValueIsNotNull(t, "cls.newInstance()");
        } else {
            t = instanceField$iv.get((Object) null);
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
        }
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return (Object) t;
    }

    public final <T> T getInstanceOf(Class<T> cls) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(cls, "cls");
        try {
            Result.Companion companion = Result.Companion;
            ReflectionUtils reflectionUtils = this;
            obj = Result.m65constructorimpl(cls.getField("INSTANCE"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m65constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m71isFailureimpl(obj)) {
            obj = null;
        }
        Field instanceField = (Field) obj;
        if (instanceField == null || !Modifier.isFinal(instanceField.getModifiers()) || !Modifier.isStatic(instanceField.getModifiers())) {
            T newInstance = cls.newInstance();
            Intrinsics.checkExpressionValueIsNotNull(newInstance, "cls.newInstance()");
            return newInstance;
        }
        T t = instanceField.get((Object) null);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}

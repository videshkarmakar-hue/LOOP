package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class AnnotatedMethodCollector extends CollectorBase {
    private final boolean _collectAnnotations;
    private final ClassIntrospector.MixInResolver _mixInResolver;

    AnnotatedMethodCollector(AnnotationIntrospector intr, ClassIntrospector.MixInResolver mixins, boolean collectAnnotations) {
        super(intr);
        this._mixInResolver = intr == null ? null : mixins;
        this._collectAnnotations = collectAnnotations;
    }

    public static AnnotatedMethodMap collectMethods(AnnotationIntrospector intr, TypeResolutionContext tc, ClassIntrospector.MixInResolver mixins, TypeFactory types, JavaType type, List<JavaType> superTypes, Class<?> primaryMixIn, boolean collectAnnotations) {
        return new AnnotatedMethodCollector(intr, mixins, collectAnnotations).collect(types, tc, type, superTypes, primaryMixIn);
    }

    AnnotatedMethodMap collect(TypeFactory typeFactory, TypeResolutionContext tc, JavaType mainType, List<JavaType> superTypes, Class<?> primaryMixIn) {
        Class<?> mixin;
        Map<MemberKey, MethodBuilder> methods = new LinkedHashMap<>();
        _addMemberMethods(tc, mainType.getRawClass(), methods, primaryMixIn);
        for (JavaType type : superTypes) {
            Class<?> mixin2 = this._mixInResolver == null ? null : this._mixInResolver.findMixInClassFor(type.getRawClass());
            _addMemberMethods(new TypeResolutionContext.Basic(typeFactory, type.getBindings()), type.getRawClass(), methods, mixin2);
        }
        boolean checkJavaLangObject = false;
        if (this._mixInResolver != null && (mixin = this._mixInResolver.findMixInClassFor(Object.class)) != null) {
            _addMethodMixIns(tc, mainType.getRawClass(), methods, mixin);
            checkJavaLangObject = true;
        }
        if (checkJavaLangObject && this._intr != null && !methods.isEmpty()) {
            for (Map.Entry<MemberKey, MethodBuilder> entry : methods.entrySet()) {
                MemberKey k = entry.getKey();
                if ("hashCode".equals(k.getName()) && k.argCount() == 0) {
                    try {
                        Method m = Object.class.getDeclaredMethod(k.getName(), new Class[0]);
                        if (m != null) {
                            MethodBuilder b = entry.getValue();
                            b.annotations = collectDefaultAnnotations(b.annotations, m.getDeclaredAnnotations());
                            b.method = m;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (methods.isEmpty()) {
            return new AnnotatedMethodMap();
        }
        Map<MemberKey, AnnotatedMethod> actual = new LinkedHashMap<>(methods.size());
        for (Map.Entry<MemberKey, MethodBuilder> entry2 : methods.entrySet()) {
            AnnotatedMethod am = entry2.getValue().build();
            if (am != null) {
                actual.put(entry2.getKey(), am);
            }
        }
        return new AnnotatedMethodMap(actual);
    }

    private void _addMemberMethods(TypeResolutionContext tc, Class<?> cls, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        if (mixInCls != null) {
            _addMethodMixIns(tc, cls, methods, mixInCls);
        }
        if (cls == null) {
            return;
        }
        for (Method m : ClassUtil.getClassMethods(cls)) {
            if (_isIncludableMemberMethod(m)) {
                MemberKey key = new MemberKey(m);
                MethodBuilder b = methods.get(key);
                if (b == null) {
                    AnnotationCollector c = this._intr == null ? AnnotationCollector.emptyCollector() : collectAnnotations(m.getDeclaredAnnotations());
                    methods.put(key, new MethodBuilder(tc, m, c));
                } else {
                    if (this._collectAnnotations) {
                        b.annotations = collectDefaultAnnotations(b.annotations, m.getDeclaredAnnotations());
                    }
                    Method old = b.method;
                    if (old == null) {
                        b.method = m;
                    } else if (Modifier.isAbstract(old.getModifiers()) && !Modifier.isAbstract(m.getModifiers())) {
                        b.method = m;
                        b.typeContext = tc;
                    }
                }
            }
        }
    }

    protected void _addMethodMixIns(TypeResolutionContext tc, Class<?> targetClass, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        if (this._intr == null) {
            return;
        }
        Iterator<Class<?>> it = ClassUtil.findRawSuperTypes(mixInCls, targetClass, true).iterator();
        while (it.hasNext()) {
            Class<?> mixin = it.next();
            Method[] declaredMethods = mixin.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (i < length) {
                Method m = declaredMethods[i];
                if (_isIncludableMemberMethod(m)) {
                    MemberKey key = new MemberKey(m);
                    MethodBuilder b = methods.get(key);
                    Annotation[] anns = m.getDeclaredAnnotations();
                    if (b != null) {
                        b.annotations = collectDefaultAnnotations(b.annotations, anns);
                    } else {
                        methods.put(key, new MethodBuilder(tc, null, collectAnnotations(anns)));
                    }
                }
                i++;
                it = it;
            }
            it = it;
        }
    }

    private boolean _isIncludableMemberMethod(Method m) {
        if (Modifier.isStatic(m.getModifiers()) || m.isSynthetic() || m.isBridge()) {
            return false;
        }
        int pcount = m.getParameterTypes().length;
        return pcount <= 2;
    }

    private static final class MethodBuilder {
        public AnnotationCollector annotations;
        public Method method;
        public TypeResolutionContext typeContext;

        public MethodBuilder(TypeResolutionContext tc, Method m, AnnotationCollector ann) {
            this.typeContext = tc;
            this.method = m;
            this.annotations = ann;
        }

        public AnnotatedMethod build() {
            if (this.method == null) {
                return null;
            }
            return new AnnotatedMethod(this.typeContext, this.method, this.annotations.asAnnotationMap(), null);
        }
    }
}

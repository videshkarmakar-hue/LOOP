package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes18.dex */
public interface TypeResolutionContext {
    JavaType resolveType(Type type);

    public static class Basic implements TypeResolutionContext {
        private final TypeBindings _bindings;
        private final TypeFactory _typeFactory;

        public Basic(TypeFactory tf, TypeBindings b) {
            this._typeFactory = tf;
            this._bindings = b;
        }

        @Override // com.fasterxml.jackson.databind.introspect.TypeResolutionContext
        public JavaType resolveType(Type type) {
            return this._typeFactory.constructType(type, this._bindings);
        }
    }
}

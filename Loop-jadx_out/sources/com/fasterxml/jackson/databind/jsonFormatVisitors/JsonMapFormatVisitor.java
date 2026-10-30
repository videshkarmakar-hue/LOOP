package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

/* JADX INFO: loaded from: classes18.dex */
public interface JsonMapFormatVisitor extends JsonFormatVisitorWithSerializerProvider {
    void keyFormat(JsonFormatVisitable jsonFormatVisitable, JavaType javaType) throws JsonMappingException;

    void valueFormat(JsonFormatVisitable jsonFormatVisitable, JavaType javaType) throws JsonMappingException;

    public static class Base implements JsonMapFormatVisitor {
        protected SerializerProvider _provider;

        public Base() {
        }

        public Base(SerializerProvider p) {
            this._provider = p;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider
        public SerializerProvider getProvider() {
            return this._provider;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider
        public void setProvider(SerializerProvider p) {
            this._provider = p;
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor
        public void keyFormat(JsonFormatVisitable handler, JavaType keyType) throws JsonMappingException {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor
        public void valueFormat(JsonFormatVisitable handler, JavaType valueType) throws JsonMappingException {
        }
    }
}

package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.core.JsonParser;

/* JADX INFO: loaded from: classes18.dex */
public interface JsonIntegerFormatVisitor extends JsonValueFormatVisitor {
    void numberType(JsonParser.NumberType numberType);

    public static class Base extends JsonValueFormatVisitor.Base implements JsonIntegerFormatVisitor {
        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor
        public void numberType(JsonParser.NumberType type) {
        }
    }
}

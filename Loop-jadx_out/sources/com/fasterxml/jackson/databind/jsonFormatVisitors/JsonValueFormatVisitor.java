package com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public interface JsonValueFormatVisitor {
    void enumTypes(Set<String> set);

    void format(JsonValueFormat jsonValueFormat);

    public static class Base implements JsonValueFormatVisitor {
        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void format(JsonValueFormat format) {
        }

        @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void enumTypes(Set<String> enums) {
        }
    }
}

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class UnwrappedPropertyHandler {
    protected final List<SettableBeanProperty> _properties;

    public UnwrappedPropertyHandler() {
        this._properties = new ArrayList();
    }

    protected UnwrappedPropertyHandler(List<SettableBeanProperty> props) {
        this._properties = props;
    }

    public void addProperty(SettableBeanProperty property) {
        this._properties.add(property);
    }

    public UnwrappedPropertyHandler renameAll(NameTransformer transformer) {
        JsonDeserializer<?> jsonDeserializerUnwrappingDeserializer;
        ArrayList<SettableBeanProperty> newProps = new ArrayList<>(this._properties.size());
        for (SettableBeanProperty prop : this._properties) {
            String newName = transformer.transform(prop.getName());
            SettableBeanProperty prop2 = prop.withSimpleName(newName);
            JsonDeserializer<?> deser = prop2.getValueDeserializer();
            if (deser != null && (jsonDeserializerUnwrappingDeserializer = deser.unwrappingDeserializer(transformer)) != deser) {
                prop2 = prop2.withValueDeserializer(jsonDeserializerUnwrappingDeserializer);
            }
            newProps.add(prop2);
        }
        return new UnwrappedPropertyHandler(newProps);
    }

    public Object processUnwrapped(JsonParser originalParser, DeserializationContext ctxt, Object bean, TokenBuffer buffered) throws IOException {
        int len = this._properties.size();
        for (int i = 0; i < len; i++) {
            SettableBeanProperty prop = this._properties.get(i);
            JsonParser p = buffered.asParser();
            p.nextToken();
            prop.deserializeAndSet(p, ctxt, bean);
        }
        return bean;
    }
}

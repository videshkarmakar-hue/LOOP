package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public abstract class ReferenceTypeDeserializer<T> extends StdDeserializer<T> implements ContextualDeserializer {
    private static final long serialVersionUID = 2;
    protected final JavaType _fullType;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    @Override // com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
    public abstract T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException;

    public abstract Object getReferenced(T t);

    public abstract T referenceValue(Object obj);

    public abstract T updateReference(T t, Object obj);

    protected abstract ReferenceTypeDeserializer<T> withResolved(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    public ReferenceTypeDeserializer(JavaType fullType, ValueInstantiator vi, TypeDeserializer typeDeser, JsonDeserializer<?> deser) {
        super(fullType);
        this._valueInstantiator = vi;
        this._fullType = fullType;
        this._valueDeserializer = deser;
        this._valueTypeDeserializer = typeDeser;
    }

    @Deprecated
    public ReferenceTypeDeserializer(JavaType fullType, TypeDeserializer typeDeser, JsonDeserializer<?> deser) {
        this(fullType, null, typeDeser, deser);
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> deser;
        JsonDeserializer<?> deser2 = this._valueDeserializer;
        if (deser2 == null) {
            deser = ctxt.findContextualValueDeserializer(this._fullType.getReferencedType(), property);
        } else {
            deser = ctxt.handleSecondaryContextualization(deser2, property, this._fullType.getReferencedType());
        }
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (typeDeser != null) {
            typeDeser = typeDeser.forProperty(property);
        }
        if (deser == this._valueDeserializer && typeDeser == this._valueTypeDeserializer) {
            return this;
        }
        return withResolved(typeDeser, deser);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
    public AccessPattern getNullAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return getNullValue(ctxt);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._fullType;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig config) {
        if (this._valueDeserializer == null) {
            return null;
        }
        return this._valueDeserializer.supportsUpdate(config);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objDeserializeWithType;
        if (this._valueInstantiator != null) {
            return (T) deserialize(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
        }
        if (this._valueTypeDeserializer == null) {
            objDeserializeWithType = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
        } else {
            objDeserializeWithType = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, this._valueTypeDeserializer);
        }
        return (T) referenceValue(objDeserializeWithType);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public T deserialize(JsonParser p, DeserializationContext ctxt, T reference) throws IOException {
        Object contents;
        Object objDeserializeWithType;
        Boolean B = this._valueDeserializer.supportsUpdate(ctxt.getConfig());
        if (B.equals(Boolean.FALSE) || this._valueTypeDeserializer != null) {
            Object contents2 = this._valueTypeDeserializer;
            if (contents2 == null) {
                contents = this._valueDeserializer.deserialize(p, ctxt);
            } else {
                contents = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
            }
        } else {
            Object contents3 = getReferenced(reference);
            if (contents3 == null) {
                if (this._valueTypeDeserializer == null) {
                    objDeserializeWithType = this._valueDeserializer.deserialize(p, ctxt);
                } else {
                    objDeserializeWithType = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
                }
                Object contents4 = objDeserializeWithType;
                return referenceValue(contents4);
            }
            contents = this._valueDeserializer.deserialize(p, ctxt, contents3);
        }
        return updateReference(reference, contents);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return getNullValue(ctxt);
        }
        if (this._valueTypeDeserializer == null) {
            return deserialize(p, ctxt);
        }
        return referenceValue(this._valueTypeDeserializer.deserializeTypedFromAny(p, ctxt));
    }
}

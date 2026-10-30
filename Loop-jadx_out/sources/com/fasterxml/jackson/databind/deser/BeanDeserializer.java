package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    private volatile transient NameTransformer _currentlyTransforming;
    protected transient Exception _nullFromCreator;

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public /* bridge */ /* synthetic */ BeanDeserializerBase withIgnorableProperties(Set set) {
        return withIgnorableProperties((Set<String>) set);
    }

    public BeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews) {
        super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
    }

    protected BeanDeserializer(BeanDeserializerBase src) {
        super(src, src._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase src, boolean ignoreAllUnknown) {
        super(src, ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase src, NameTransformer unwrapper) {
        super(src, unwrapper);
    }

    public BeanDeserializer(BeanDeserializerBase src, ObjectIdReader oir) {
        super(src, oir);
    }

    public BeanDeserializer(BeanDeserializerBase src, Set<String> ignorableProps) {
        super(src, ignorableProps);
    }

    public BeanDeserializer(BeanDeserializerBase src, BeanPropertyMap props) {
        super(src, props);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer transformer) {
        if (getClass() != BeanDeserializer.class || this._currentlyTransforming == transformer) {
            return this;
        }
        this._currentlyTransforming = transformer;
        try {
            return new BeanDeserializer(this, transformer);
        } finally {
            this._currentlyTransforming = null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withObjectIdReader(ObjectIdReader oir) {
        return new BeanDeserializer(this, oir);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withIgnorableProperties(Set<String> ignorableProps) {
        return new BeanDeserializer(this, ignorableProps);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean ignoreUnknown) {
        return new BeanDeserializer(this, ignoreUnknown);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(BeanPropertyMap props) {
        return new BeanDeserializer(this, props);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected BeanDeserializerBase asArrayDeserializer() {
        SettableBeanProperty[] props = this._beanProperties.getPropertiesInInsertionOrder();
        return new BeanAsArrayDeserializer(this, props);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.isExpectedStartObjectToken()) {
            if (this._vanillaProcessing) {
                return vanillaDeserialize(p, ctxt, p.nextToken());
            }
            p.nextToken();
            if (this._objectIdReader != null) {
                return deserializeWithObjectId(p, ctxt);
            }
            return deserializeFromObject(p, ctxt);
        }
        return _deserializeOther(p, ctxt, p.getCurrentToken());
    }

    protected final Object _deserializeOther(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        if (t != null) {
            switch (t) {
                case VALUE_STRING:
                    return deserializeFromString(p, ctxt);
                case VALUE_NUMBER_INT:
                    return deserializeFromNumber(p, ctxt);
                case VALUE_NUMBER_FLOAT:
                    return deserializeFromDouble(p, ctxt);
                case VALUE_EMBEDDED_OBJECT:
                    return deserializeFromEmbedded(p, ctxt);
                case VALUE_TRUE:
                case VALUE_FALSE:
                    return deserializeFromBoolean(p, ctxt);
                case VALUE_NULL:
                    return deserializeFromNull(p, ctxt);
                case START_ARRAY:
                    return _deserializeFromArray(p, ctxt);
                case FIELD_NAME:
                case END_OBJECT:
                    if (this._vanillaProcessing) {
                        return vanillaDeserialize(p, ctxt, t);
                    }
                    if (this._objectIdReader != null) {
                        return deserializeWithObjectId(p, ctxt);
                    }
                    return deserializeFromObject(p, ctxt);
            }
        }
        return ctxt.handleUnexpectedToken(getValueType(ctxt), p);
    }

    @Deprecated
    protected Object _missingToken(JsonParser p, DeserializationContext ctxt) throws IOException {
        throw ctxt.endOfInputException(handledType());
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        String propName;
        String strNextFieldName;
        Class<?> view;
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(p, ctxt, bean);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(p, ctxt, bean);
        }
        if (p.isExpectedStartObjectToken()) {
            propName = p.nextFieldName();
            if (propName == null) {
                return bean;
            }
        } else if (p.hasTokenId(5)) {
            propName = p.getCurrentName();
        } else {
            return bean;
        }
        if (this._needViewProcesing && (view = ctxt.getActiveView()) != null) {
            return deserializeWithView(p, ctxt, bean, view);
        }
        do {
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                try {
                    prop.deserializeAndSet(p, ctxt, bean);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                }
            } else {
                handleUnknownVanilla(p, ctxt, bean, propName);
            }
            strNextFieldName = p.nextFieldName();
            propName = strNextFieldName;
        } while (strNextFieldName != null);
        return bean;
    }

    private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        String strNextFieldName;
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (p.hasTokenId(5)) {
            String propName = p.getCurrentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                strNextFieldName = p.nextFieldName();
                propName = strNextFieldName;
            } while (strNextFieldName != null);
        }
        return bean;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        String strNextFieldName;
        Class<?> view;
        Object id;
        if (this._objectIdReader != null && this._objectIdReader.maySerializeAsObject() && p.hasTokenId(5) && this._objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p)) {
            return deserializeFromObjectId(p, ctxt);
        }
        if (this._nonStandardCreation) {
            if (this._unwrappedPropertyHandler != null) {
                return deserializeWithUnwrapped(p, ctxt);
            }
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(p, ctxt);
            }
            return deserializeFromObjectUsingNonDefault(p, ctxt);
        }
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (p.canReadObjectId() && (id = p.getObjectId()) != null) {
            _handleTypedObjectId(p, ctxt, bean, id);
        }
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        if (this._needViewProcesing && (view = ctxt.getActiveView()) != null) {
            return deserializeWithView(p, ctxt, bean, view);
        }
        if (p.hasTokenId(5)) {
            String propName = p.getCurrentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                strNextFieldName = p.nextFieldName();
                propName = strNextFieldName;
            } while (strNextFieldName != null);
        }
        return bean;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        Object bean2;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer unknown = null;
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        JsonToken t = p.getCurrentToken();
        List<BeanReferring> referrings = null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
                if (creatorProp != null) {
                    if (activeView != null && !creatorProp.visibleInView(activeView)) {
                        p.skipChildren();
                    } else {
                        Object value = _deserializeWithErrorWrapping(p, ctxt, creatorProp);
                        if (buffer.assignParameter(creatorProp, value)) {
                            p.nextToken();
                            try {
                                bean2 = creator.build(ctxt, buffer);
                            } catch (Exception e) {
                                bean2 = wrapInstantiationProblem(e, ctxt);
                            }
                            if (bean2 == null) {
                                return ctxt.handleInstantiationProblem(handledType(), null, _creatorReturnedNullException());
                            }
                            p.setCurrentValue(bean2);
                            if (bean2.getClass() != this._beanType.getRawClass()) {
                                return handlePolymorphic(p, ctxt, bean2, unknown);
                            }
                            if (unknown != null) {
                                bean2 = handleUnknownProperties(ctxt, bean2, unknown);
                            }
                            return deserialize(p, ctxt, bean2);
                        }
                    }
                } else {
                    SettableBeanProperty prop = this._beanProperties.find(propName);
                    if (prop != null) {
                        try {
                            buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
                        } catch (UnresolvedForwardReference reference) {
                            BeanReferring referring = handleUnresolvedReference(ctxt, prop, buffer, reference);
                            if (referrings == null) {
                                referrings = new ArrayList<>();
                            }
                            referrings.add(referring);
                        }
                    } else if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                        handleIgnoredProperty(p, ctxt, handledType(), propName);
                    } else if (this._anySetter != null) {
                        try {
                            buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(p, ctxt));
                        } catch (Exception e2) {
                            wrapAndThrow(e2, this._beanType.getRawClass(), propName, ctxt);
                        }
                    } else {
                        if (unknown == null) {
                            unknown = new TokenBuffer(p, ctxt);
                        }
                        unknown.writeFieldName(propName);
                        unknown.copyCurrentStructure(p);
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            bean = creator.build(ctxt, buffer);
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, ctxt);
            bean = null;
        }
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        if (referrings != null) {
            for (BeanReferring referring2 : referrings) {
                referring2.setBean(bean);
            }
        }
        if (unknown != null) {
            if (bean.getClass() != this._beanType.getRawClass()) {
                return handlePolymorphic(null, ctxt, bean, unknown);
            }
            return handleUnknownProperties(ctxt, bean, unknown);
        }
        return bean;
    }

    private BeanReferring handleUnresolvedReference(DeserializationContext ctxt, SettableBeanProperty prop, PropertyValueBuffer buffer, UnresolvedForwardReference reference) throws JsonMappingException {
        BeanReferring referring = new BeanReferring(ctxt, reference, prop.getType(), buffer, prop);
        reference.getRoid().appendReferring(referring);
        return referring;
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser p, DeserializationContext ctxt, SettableBeanProperty prop) throws IOException {
        try {
            return prop.deserialize(p, ctxt);
        } catch (Exception e) {
            wrapAndThrow(e, this._beanType.getRawClass(), prop.getName(), ctxt);
            return null;
        }
    }

    protected Object deserializeFromNull(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.requiresCustomCodec()) {
            TokenBuffer tb = new TokenBuffer(p, ctxt);
            tb.writeEndObject();
            JsonParser p2 = tb.asParser(p);
            p2.nextToken();
            Object ob = this._vanillaProcessing ? vanillaDeserialize(p2, ctxt, JsonToken.END_OBJECT) : deserializeFromObject(p2, ctxt);
            p2.close();
            return ob;
        }
        return ctxt.handleUnexpectedToken(getValueType(ctxt), p);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    protected Object _deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonDeserializer<Object> delegateDeser = this._arrayDelegateDeserializer;
        if (delegateDeser == null) {
            JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
            delegateDeser = jsonDeserializer;
            if (jsonDeserializer == null) {
                if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY && ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                        return null;
                    }
                    Object value = deserialize(p, ctxt);
                    if (p.nextToken() != JsonToken.END_ARRAY) {
                        handleMissingEndArrayForSingle(p, ctxt);
                    }
                    return value;
                }
                if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                    JsonToken t2 = p.nextToken();
                    if (t2 == JsonToken.END_ARRAY) {
                        return null;
                    }
                    return ctxt.handleUnexpectedToken(getValueType(ctxt), JsonToken.START_ARRAY, p, (String) null, new Object[0]);
                }
                return ctxt.handleUnexpectedToken(getValueType(ctxt), p);
            }
        }
        Object bean = this._valueInstantiator.createUsingArrayDelegate(ctxt, delegateDeser.deserialize(p, ctxt));
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        return bean;
    }

    protected final Object deserializeWithView(JsonParser p, DeserializationContext ctxt, Object bean, Class<?> activeView) throws IOException {
        String strNextFieldName;
        if (p.hasTokenId(5)) {
            String propName = p.getCurrentName();
            do {
                p.nextToken();
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    if (!prop.visibleInView(activeView)) {
                        p.skipChildren();
                    } else {
                        try {
                            prop.deserializeAndSet(p, ctxt, bean);
                        } catch (Exception e) {
                            wrapAndThrow(e, bean, propName, ctxt);
                        }
                    }
                } else {
                    handleUnknownVanilla(p, ctxt, bean, propName);
                }
                strNextFieldName = p.nextFieldName();
                propName = strNextFieldName;
            } while (strNextFieldName != null);
        }
        return bean;
    }

    protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(p, ctxt);
        }
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        Object bean = this._valueInstantiator.createUsingDefault(ctxt);
        p.setCurrentValue(bean);
        if (this._injectables != null) {
            injectValues(ctxt, bean);
        }
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        String propName = p.hasTokenId(5) ? p.getCurrentName() : null;
        while (propName != null) {
            p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (this._anySetter == null) {
                tokens.writeFieldName(propName);
                tokens.copyCurrentStructure(p);
            } else {
                TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                tokens.writeFieldName(propName);
                tokens.append(b2);
                try {
                    this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                } catch (Exception e2) {
                    wrapAndThrow(e2, bean, propName, ctxt);
                }
            }
            propName = p.nextFieldName();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            p.nextToken();
            if (prop != null) {
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (this._anySetter == null) {
                tokens.writeFieldName(propName);
                tokens.copyCurrentStructure(p);
            } else {
                TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                tokens.writeFieldName(propName);
                tokens.append(b2);
                try {
                    this._anySetter.deserializeAndSet(b2.asParserOnFirstToken(), ctxt, bean, propName);
                } catch (Exception e2) {
                    wrapAndThrow(e2, bean, propName, ctxt);
                }
            }
            t = p.nextToken();
        }
        tokens.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        return bean;
    }

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object bean;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                    JsonToken t2 = p.nextToken();
                    try {
                        bean = creator.build(ctxt, buffer);
                    } catch (Exception e) {
                        bean = wrapInstantiationProblem(e, ctxt);
                    }
                    p.setCurrentValue(bean);
                    while (t2 == JsonToken.FIELD_NAME) {
                        tokens.copyCurrentStructure(p);
                        t2 = p.nextToken();
                    }
                    if (t2 != JsonToken.END_OBJECT) {
                        ctxt.reportWrongTokenException(this, JsonToken.END_OBJECT, "Attempted to unwrap '%s' value", handledType().getName());
                    }
                    tokens.writeEndObject();
                    if (bean.getClass() != this._beanType.getRawClass()) {
                        ctxt.reportInputMismatch(creatorProp, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                        return null;
                    }
                    return this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
                } else if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                    handleIgnoredProperty(p, ctxt, handledType(), propName);
                } else if (this._anySetter == null) {
                    tokens.writeFieldName(propName);
                    tokens.copyCurrentStructure(p);
                } else {
                    TokenBuffer b2 = TokenBuffer.asCopyOfValue(p);
                    tokens.writeFieldName(propName);
                    tokens.append(b2);
                    try {
                        buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(b2.asParserOnFirstToken(), ctxt));
                    } catch (Exception e2) {
                        wrapAndThrow(e2, this._beanType.getRawClass(), propName, ctxt);
                    }
                }
            }
            t = p.nextToken();
        }
        try {
            Object bean2 = creator.build(ctxt, buffer);
            return this._unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean2, tokens);
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, ctxt);
            return null;
        }
    }

    protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(p, ctxt);
        }
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        return deserializeWithExternalTypeId(p, ctxt, this._valueInstantiator.createUsingDefault(ctxt));
    }

    protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Class<?> activeView = this._needViewProcesing ? ctxt.getActiveView() : null;
        ExternalTypeHandler ext = this._externalTypeIdHandler.start();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            JsonToken t2 = p.nextToken();
            SettableBeanProperty prop = this._beanProperties.find(propName);
            if (prop != null) {
                if (t2.isScalarValue()) {
                    ext.handleTypePropertyValue(p, ctxt, propName, bean);
                }
                if (activeView != null && !prop.visibleInView(activeView)) {
                    p.skipChildren();
                } else {
                    try {
                        prop.deserializeAndSet(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, bean, propName, ctxt);
                    }
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                handleIgnoredProperty(p, ctxt, bean, propName);
            } else if (!ext.handlePropertyValue(p, ctxt, propName, bean)) {
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(p, ctxt, bean, propName);
                    } catch (Exception e2) {
                        wrapAndThrow(e2, bean, propName, ctxt);
                    }
                } else {
                    handleUnknownProperty(p, ctxt, bean, propName);
                }
            }
            t = p.nextToken();
        }
        return ext.complete(p, ctxt, bean);
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser p, DeserializationContext ctxt) throws IOException {
        ExternalTypeHandler ext = this._externalTypeIdHandler.start();
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, this._objectIdReader);
        TokenBuffer tokens = new TokenBuffer(p, ctxt);
        tokens.writeStartObject();
        JsonToken t = p.getCurrentToken();
        while (t == JsonToken.FIELD_NAME) {
            String propName = p.getCurrentName();
            p.nextToken();
            SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
            if (creatorProp != null) {
                if (!ext.handlePropertyValue(p, ctxt, propName, null) && buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp))) {
                    JsonToken t2 = p.nextToken();
                    try {
                        Object bean = creator.build(ctxt, buffer);
                        while (t2 == JsonToken.FIELD_NAME) {
                            p.nextToken();
                            tokens.copyCurrentStructure(p);
                            t2 = p.nextToken();
                        }
                        if (bean.getClass() != this._beanType.getRawClass()) {
                            return ctxt.reportBadDefinition(this._beanType, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", this._beanType, bean.getClass()));
                        }
                        return ext.complete(p, ctxt, bean);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), propName, ctxt);
                    }
                }
            } else if (!buffer.readIdProperty(propName)) {
                SettableBeanProperty prop = this._beanProperties.find(propName);
                if (prop != null) {
                    buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
                } else if (!ext.handlePropertyValue(p, ctxt, propName, null)) {
                    if (this._ignorableProps != null && this._ignorableProps.contains(propName)) {
                        handleIgnoredProperty(p, ctxt, handledType(), propName);
                    } else if (this._anySetter != null) {
                        buffer.bufferAnyProperty(this._anySetter, propName, this._anySetter.deserialize(p, ctxt));
                    } else {
                        handleUnknownProperty(p, ctxt, this._valueClass, propName);
                    }
                }
            }
            t = p.nextToken();
        }
        tokens.writeEndObject();
        try {
            return ext.complete(p, ctxt, buffer, creator);
        } catch (Exception e2) {
            return wrapInstantiationProblem(e2, ctxt);
        }
    }

    protected Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }

    static class BeanReferring extends ReadableObjectId.Referring {
        private Object _bean;
        private final DeserializationContext _context;
        private final SettableBeanProperty _prop;

        BeanReferring(DeserializationContext ctxt, UnresolvedForwardReference ref, JavaType valueType, PropertyValueBuffer buffer, SettableBeanProperty prop) {
            super(ref, valueType);
            this._context = ctxt;
            this._prop = prop;
        }

        public void setBean(Object bean) {
            this._bean = bean;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring
        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            if (this._bean == null) {
                this._context.reportInputMismatch(this._prop, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", this._prop.getName(), this._prop.getDeclaringClass().getName());
            }
            this._prop.set(this._bean, value);
        }
    }
}

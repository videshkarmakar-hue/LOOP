package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable, SchemaAware {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final AnyGetterWriter _anyGetterWriter;
    protected final JavaType _beanType;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final ObjectIdWriter _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final JsonFormat.Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    protected abstract BeanSerializerBase asArraySerializer();

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public abstract BeanSerializerBase withFilterId(Object obj);

    protected abstract BeanSerializerBase withIgnorals(Set<String> set);

    public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter);

    protected BeanSerializerBase(JavaType type, BeanSerializerBuilder builder, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        super(type);
        this._beanType = type;
        this._props = properties;
        this._filteredProps = filteredProperties;
        if (builder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = builder.getTypeId();
        this._anyGetterWriter = builder.getAnyGetter();
        this._propertyFilterId = builder.getFilterId();
        this._objectIdWriter = builder.getObjectIdWriter();
        JsonFormat.Value format = builder.getBeanDescription().findExpectedFormat(null);
        this._serializationShape = format != null ? format.getShape() : null;
    }

    protected BeanSerializerBase(BeanSerializerBase src, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        super(src._handledType);
        this._beanType = src._beanType;
        this._props = properties;
        this._filteredProps = filteredProperties;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = src._objectIdWriter;
        this._propertyFilterId = src._propertyFilterId;
        this._serializationShape = src._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter) {
        this(src, objectIdWriter, src._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter, Object filterId) {
        super(src._handledType);
        this._beanType = src._beanType;
        this._props = src._props;
        this._filteredProps = src._filteredProps;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = filterId;
        this._serializationShape = src._serializationShape;
    }

    @Deprecated
    protected BeanSerializerBase(BeanSerializerBase src, String[] toIgnore) {
        this(src, ArrayBuilders.arrayToSet(toIgnore));
    }

    protected BeanSerializerBase(BeanSerializerBase src, Set<String> toIgnore) {
        super(src._handledType);
        this._beanType = src._beanType;
        BeanPropertyWriter[] propsIn = src._props;
        BeanPropertyWriter[] fpropsIn = src._filteredProps;
        int len = propsIn.length;
        ArrayList<BeanPropertyWriter> propsOut = new ArrayList<>(len);
        ArrayList<BeanPropertyWriter> fpropsOut = fpropsIn == null ? null : new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter bpw = propsIn[i];
            if (toIgnore == null || !toIgnore.contains(bpw.getName())) {
                propsOut.add(bpw);
                if (fpropsIn != null) {
                    fpropsOut.add(fpropsIn[i]);
                }
            }
        }
        int i2 = propsOut.size();
        this._props = (BeanPropertyWriter[]) propsOut.toArray(new BeanPropertyWriter[i2]);
        this._filteredProps = fpropsOut != null ? (BeanPropertyWriter[]) fpropsOut.toArray(new BeanPropertyWriter[fpropsOut.size()]) : null;
        this._typeId = src._typeId;
        this._anyGetterWriter = src._anyGetterWriter;
        this._objectIdWriter = src._objectIdWriter;
        this._propertyFilterId = src._propertyFilterId;
        this._serializationShape = src._serializationShape;
    }

    @Deprecated
    protected BeanSerializerBase withIgnorals(String[] toIgnore) {
        return withIgnorals(ArrayBuilders.arrayToSet(toIgnore));
    }

    protected BeanSerializerBase withProperties(BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        return this;
    }

    protected BeanSerializerBase(BeanSerializerBase src) {
        this(src, src._props, src._filteredProps);
    }

    protected BeanSerializerBase(BeanSerializerBase src, NameTransformer unwrapper) {
        this(src, rename(src._props, unwrapper), rename(src._filteredProps, unwrapper));
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] props, NameTransformer transformer) {
        if (props == null || props.length == 0 || transformer == null || transformer == NameTransformer.NOP) {
            return props;
        }
        int len = props.length;
        BeanPropertyWriter[] result = new BeanPropertyWriter[len];
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter bpw = props[i];
            if (bpw != null) {
                result[i] = bpw.rename(transformer);
            }
        }
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008e  */
    @Override // com.fasterxml.jackson.databind.ser.ResolvableSerializer
    public void resolve(SerializerProvider provider) throws JsonMappingException {
        BeanPropertyWriter w2;
        TypeSerializer typeSer;
        JsonSerializer<Object> nullSer;
        BeanPropertyWriter w3;
        int filteredCount = this._filteredProps == null ? 0 : this._filteredProps.length;
        int len = this._props.length;
        for (int i = 0; i < len; i++) {
            BeanPropertyWriter prop = this._props[i];
            if (!prop.willSuppressNulls() && !prop.hasNullSerializer() && (nullSer = provider.findNullValueSerializer(prop)) != null) {
                prop.assignNullSerializer(nullSer);
                if (i < filteredCount && (w3 = this._filteredProps[i]) != null) {
                    w3.assignNullSerializer(nullSer);
                }
            }
            if (!prop.hasSerializer()) {
                JsonSerializer<Object> ser = findConvertingSerializer(provider, prop);
                if (ser == null) {
                    JavaType type = prop.getSerializationType();
                    if (type == null) {
                        type = prop.getType();
                        if (!type.isFinal()) {
                            if (type.isContainerType() || type.containedTypeCount() > 0) {
                                prop.setNonTrivialBaseType(type);
                            }
                        }
                    }
                    ser = provider.findValueSerializer(type, prop);
                    if (type.isContainerType() && (typeSer = (TypeSerializer) type.getContentType().getTypeHandler()) != null && (ser instanceof ContainerSerializer)) {
                        JsonSerializer<Object> ser2 = ((ContainerSerializer) ser).withValueTypeSerializer(typeSer);
                        ser = ser2;
                    }
                    if (i >= filteredCount) {
                        prop.assignSerializer(ser);
                    } else {
                        prop.assignSerializer(ser);
                    }
                } else if (i >= filteredCount && (w2 = this._filteredProps[i]) != null) {
                    w2.assignSerializer(ser);
                } else {
                    prop.assignSerializer(ser);
                }
            }
        }
        if (this._anyGetterWriter != null) {
            this._anyGetterWriter.resolve(provider);
        }
    }

    protected JsonSerializer<Object> findConvertingSerializer(SerializerProvider provider, BeanPropertyWriter prop) throws JsonMappingException {
        AnnotatedMember m;
        Object convDef;
        AnnotationIntrospector intr = provider.getAnnotationIntrospector();
        JsonSerializer<?> ser = null;
        if (intr == null || (m = prop.getMember()) == null || (convDef = intr.findSerializationConverter(m)) == null) {
            return null;
        }
        Converter<Object, Object> conv = provider.converterInstance(prop.getMember(), convDef);
        JavaType delegateType = conv.getOutputType(provider.getTypeFactory());
        if (!delegateType.isJavaLangObject()) {
            ser = provider.findValueSerializer(delegateType, prop);
        }
        return new StdDelegatingSerializer(conv, delegateType, ser);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        AnnotatedMember member;
        BeanSerializerBase beanSerializerBaseWithFilterId;
        BeanPropertyWriter[] beanPropertyWriterArr;
        ObjectIdInfo objectIdInfoFindObjectReferenceInfo;
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        if (beanProperty == null || annotationIntrospector == null) {
            member = null;
        } else {
            member = beanProperty.getMember();
        }
        AnnotatedMember annotatedMember = member;
        SerializationConfig config = serializerProvider.getConfig();
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, this._handledType);
        JsonFormat.Shape shape = null;
        if (valueFindFormatOverrides != null && valueFindFormatOverrides.hasShape()) {
            JsonFormat.Shape shape2 = valueFindFormatOverrides.getShape();
            if (shape2 != JsonFormat.Shape.ANY && shape2 != this._serializationShape) {
                if (this._beanType.isEnumType()) {
                    switch (shape2) {
                        case STRING:
                        case NUMBER:
                        case NUMBER_INT:
                            return serializerProvider.handlePrimaryContextualization(EnumSerializer.construct(this._beanType.getRawClass(), serializerProvider.getConfig(), config.introspectClassAnnotations(this._beanType), valueFindFormatOverrides), beanProperty);
                        default:
                            shape = shape2;
                            break;
                    }
                } else if (shape2 == JsonFormat.Shape.NATURAL) {
                    if ((!this._beanType.isMapLikeType() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType)) {
                        JavaType javaTypeFindSuperType = this._beanType.findSuperType(Map.Entry.class);
                        return serializerProvider.handlePrimaryContextualization(new MapEntrySerializer(this._beanType, javaTypeFindSuperType.containedTypeOrUnknown(0), javaTypeFindSuperType.containedTypeOrUnknown(1), false, null, beanProperty), beanProperty);
                    }
                    shape = shape2;
                } else {
                    shape = shape2;
                }
            } else {
                shape = shape2;
            }
        }
        ObjectIdWriter objectIdWriterConstruct = this._objectIdWriter;
        int i = 0;
        Set<String> setFindIgnoredForSerialization = null;
        Object obj = null;
        if (annotatedMember != null) {
            JsonIgnoreProperties.Value valueFindPropertyIgnorals = annotationIntrospector.findPropertyIgnorals(annotatedMember);
            if (valueFindPropertyIgnorals != null) {
                setFindIgnoredForSerialization = valueFindPropertyIgnorals.findIgnoredForSerialization();
            }
            ObjectIdInfo objectIdInfoFindObjectIdInfo = annotationIntrospector.findObjectIdInfo(annotatedMember);
            if (objectIdInfoFindObjectIdInfo == null) {
                if (objectIdWriterConstruct == null || (objectIdInfoFindObjectReferenceInfo = annotationIntrospector.findObjectReferenceInfo(annotatedMember, null)) == null) {
                    setFindIgnoredForSerialization = setFindIgnoredForSerialization;
                } else {
                    objectIdWriterConstruct = this._objectIdWriter.withAlwaysAsId(objectIdInfoFindObjectReferenceInfo.getAlwaysAsId());
                    setFindIgnoredForSerialization = setFindIgnoredForSerialization;
                }
            } else {
                ObjectIdInfo objectIdInfoFindObjectReferenceInfo2 = annotationIntrospector.findObjectReferenceInfo(annotatedMember, objectIdInfoFindObjectIdInfo);
                Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfoFindObjectReferenceInfo2.getGeneratorType();
                JavaType javaType = serializerProvider.getTypeFactory().findTypeParameters(serializerProvider.constructType(generatorType), ObjectIdGenerator.class)[0];
                if (generatorType == ObjectIdGenerators.PropertyGenerator.class) {
                    String simpleName = objectIdInfoFindObjectReferenceInfo2.getPropertyName().getSimpleName();
                    int length = this._props.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 == length) {
                            serializerProvider.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name '%s'", handledType().getName(), simpleName));
                        }
                        BeanPropertyWriter beanPropertyWriter = this._props[i2];
                        if (!simpleName.equals(beanPropertyWriter.getName())) {
                            i2++;
                            simpleName = simpleName;
                            length = length;
                            config = config;
                            setFindIgnoredForSerialization = setFindIgnoredForSerialization;
                        } else {
                            objectIdWriterConstruct = ObjectIdWriter.construct(beanPropertyWriter.getType(), null, new PropertyBasedObjectIdGenerator(objectIdInfoFindObjectReferenceInfo2, beanPropertyWriter), objectIdInfoFindObjectReferenceInfo2.getAlwaysAsId());
                            i = i2;
                        }
                    }
                } else {
                    setFindIgnoredForSerialization = setFindIgnoredForSerialization;
                    objectIdWriterConstruct = ObjectIdWriter.construct(javaType, objectIdInfoFindObjectReferenceInfo2.getPropertyName(), serializerProvider.objectIdGeneratorInstance(annotatedMember, objectIdInfoFindObjectReferenceInfo2), objectIdInfoFindObjectReferenceInfo2.getAlwaysAsId());
                    i = 0;
                }
            }
            Object objFindFilterId = annotationIntrospector.findFilterId(annotatedMember);
            if (objFindFilterId != null && (this._propertyFilterId == null || !objFindFilterId.equals(this._propertyFilterId))) {
                obj = objFindFilterId;
                setFindIgnoredForSerialization = setFindIgnoredForSerialization;
            } else {
                setFindIgnoredForSerialization = setFindIgnoredForSerialization;
            }
        }
        BeanSerializerBase beanSerializerBase = this;
        if (i > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr2 = (BeanPropertyWriter[]) Arrays.copyOf(this._props, this._props.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr2[i];
            System.arraycopy(beanPropertyWriterArr2, 0, beanPropertyWriterArr2, 1, i);
            beanPropertyWriterArr2[0] = beanPropertyWriter2;
            if (this._filteredProps != null) {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(this._filteredProps, this._filteredProps.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i];
                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i);
                beanPropertyWriterArr[0] = beanPropertyWriter3;
            } else {
                beanPropertyWriterArr = null;
            }
            beanSerializerBaseWithFilterId = beanSerializerBase.withProperties(beanPropertyWriterArr2, beanPropertyWriterArr);
        }
        if (objectIdWriterConstruct != null) {
            beanSerializerBaseWithFilterId = beanSerializerBase;
            ObjectIdWriter objectIdWriterWithSerializer = objectIdWriterConstruct.withSerializer(serializerProvider.findValueSerializer(objectIdWriterConstruct.idType, beanProperty));
            if (objectIdWriterWithSerializer != this._objectIdWriter) {
                beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withObjectIdWriter(objectIdWriterWithSerializer);
            }
        }
        if (setFindIgnoredForSerialization != null && !setFindIgnoredForSerialization.isEmpty()) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withIgnorals(setFindIgnoredForSerialization);
        }
        if (obj != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withFilterId(obj);
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape == JsonFormat.Shape.ARRAY) {
            return beanSerializerBaseWithFilterId.asArraySerializer();
        }
        return beanSerializerBaseWithFilterId;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public Iterator<PropertyWriter> properties() {
        return Arrays.asList(this._props).iterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        if (this._objectIdWriter != null) {
            gen.setCurrentValue(bean);
            _serializeWithObjectId(bean, gen, provider, typeSer);
            return;
        }
        gen.setCurrentValue(bean);
        WritableTypeId typeIdDef = _typeIdDef(typeSer, bean, JsonToken.START_OBJECT);
        typeSer.writeTypePrefix(gen, typeIdDef);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(bean, gen, provider);
        } else {
            serializeFields(bean, gen, provider);
        }
        typeSer.writeTypeSuffix(gen, typeIdDef);
    }

    protected final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, boolean startEndObject) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableObjectId objectId = provider.findObjectId(bean, w.generator);
        if (objectId.writeAsId(gen, provider, w)) {
            return;
        }
        Object id = objectId.generateId(bean);
        if (w.alwaysAsId) {
            w.serializer.serialize(id, gen, provider);
            return;
        }
        if (startEndObject) {
            gen.writeStartObject(bean);
        }
        objectId.writeAsField(gen, provider, w);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(bean, gen, provider);
        } else {
            serializeFields(bean, gen, provider);
        }
        if (startEndObject) {
            gen.writeEndObject();
        }
    }

    protected final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableObjectId objectId = provider.findObjectId(bean, w.generator);
        if (objectId.writeAsId(gen, provider, w)) {
            return;
        }
        Object id = objectId.generateId(bean);
        if (w.alwaysAsId) {
            w.serializer.serialize(id, gen, provider);
        } else {
            _serializeObjectId(bean, gen, provider, typeSer, objectId);
        }
    }

    protected void _serializeObjectId(Object bean, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer, WritableObjectId objectId) throws IOException {
        ObjectIdWriter w = this._objectIdWriter;
        WritableTypeId typeIdDef = _typeIdDef(typeSer, bean, JsonToken.START_OBJECT);
        typeSer.writeTypePrefix(g, typeIdDef);
        objectId.writeAsField(g, provider, w);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(bean, g, provider);
        } else {
            serializeFields(bean, g, provider);
        }
        typeSer.writeTypeSuffix(g, typeIdDef);
    }

    protected final WritableTypeId _typeIdDef(TypeSerializer typeSer, Object bean, JsonToken valueShape) {
        if (this._typeId == null) {
            return typeSer.typeId(bean, valueShape);
        }
        Object typeId = this._typeId.getValue(bean);
        if (typeId == null) {
            typeId = "";
        }
        return typeSer.typeId(bean, valueShape, typeId);
    }

    @Deprecated
    protected final String _customTypeId(Object bean) {
        Object typeId = this._typeId.getValue(bean);
        if (typeId == null) {
            return "";
        }
        return typeId instanceof String ? (String) typeId : typeId.toString();
    }

    protected void serializeFields(Object bean, JsonGenerator gen, SerializerProvider provider) throws IOException {
        BeanPropertyWriter[] props;
        String name;
        if (this._filteredProps != null && provider.getActiveView() != null) {
            props = this._filteredProps;
        } else {
            props = this._props;
        }
        int i = 0;
        try {
            int len = props.length;
            while (i < len) {
                BeanPropertyWriter prop = props[i];
                if (prop != null) {
                    prop.serializeAsField(bean, gen, provider);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndSerialize(bean, gen, provider);
            }
        } catch (Exception e) {
            name = i != props.length ? props[i].getName() : "[anySetter]";
            wrapAndThrow(provider, e, bean, name);
        } catch (StackOverflowError e2) {
            JsonMappingException mapE = new JsonMappingException(gen, "Infinite recursion (StackOverflowError)", e2);
            name = i != props.length ? props[i].getName() : "[anySetter]";
            mapE.prependPath(new JsonMappingException.Reference(bean, name));
            throw mapE;
        }
    }

    protected void serializeFieldsFiltered(Object bean, JsonGenerator gen, SerializerProvider provider) throws IOException {
        BeanPropertyWriter[] props;
        String name;
        if (this._filteredProps != null && provider.getActiveView() != null) {
            props = this._filteredProps;
        } else {
            props = this._props;
        }
        PropertyFilter filter = findPropertyFilter(provider, this._propertyFilterId, bean);
        if (filter == null) {
            serializeFields(bean, gen, provider);
            return;
        }
        int i = 0;
        try {
            int len = props.length;
            while (i < len) {
                BeanPropertyWriter prop = props[i];
                if (prop != null) {
                    filter.serializeAsField(bean, gen, provider, prop);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndFilter(bean, gen, provider, filter);
            }
        } catch (Exception e) {
            name = i != props.length ? props[i].getName() : "[anySetter]";
            wrapAndThrow(provider, e, bean, name);
        } catch (StackOverflowError e2) {
            JsonMappingException mapE = new JsonMappingException(gen, "Infinite recursion (StackOverflowError)", e2);
            name = i != props.length ? props[i].getName() : "[anySetter]";
            mapE.prependPath(new JsonMappingException.Reference(bean, name));
            throw mapE;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    @Deprecated
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
        PropertyFilter filter;
        String id;
        ObjectNode o = createSchemaNode("object", true);
        JsonSerializableSchema ann = (JsonSerializableSchema) this._handledType.getAnnotation(JsonSerializableSchema.class);
        if (ann != null && (id = ann.m88id()) != null && id.length() > 0) {
            o.put("id", id);
        }
        ObjectNode propertiesNode = o.objectNode();
        if (this._propertyFilterId != null) {
            filter = findPropertyFilter(provider, this._propertyFilterId, null);
        } else {
            filter = null;
        }
        for (int i = 0; i < this._props.length; i++) {
            BeanPropertyWriter prop = this._props[i];
            if (filter == null) {
                prop.depositSchemaProperty(propertiesNode, provider);
            } else {
                filter.depositSchemaProperty(prop, propertiesNode, provider);
            }
        }
        o.set("properties", propertiesNode);
        return o;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
        JsonObjectFormatVisitor objectVisitor;
        BeanPropertyWriter[] props;
        if (visitor == null || (objectVisitor = visitor.expectObjectFormat(typeHint)) == null) {
            return;
        }
        SerializerProvider provider = visitor.getProvider();
        Class<?> activeView = null;
        if (this._propertyFilterId != null) {
            PropertyFilter filter = findPropertyFilter(visitor.getProvider(), this._propertyFilterId, null);
            int end = this._props.length;
            for (int i = 0; i < end; i++) {
                filter.depositSchemaProperty(this._props[i], objectVisitor, provider);
            }
            return;
        }
        if (this._filteredProps != null && provider != null) {
            activeView = provider.getActiveView();
        }
        Class<?> view = activeView;
        if (view != null) {
            props = this._filteredProps;
        } else {
            props = this._props;
        }
        for (BeanPropertyWriter prop : props) {
            if (prop != null) {
                prop.depositSchemaProperty(objectVisitor, provider);
            }
        }
    }
}

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    protected final DeserializerFactoryConfig _factoryConfig;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_SEQUENCE = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Map.Entry.class;
    private static final Class<?> CLASS_SERIALIZABLE = Serializable.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");

    protected abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    protected BasicDeserializerFactory(DeserializerFactoryConfig config) {
        this._factoryConfig = config;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalDeserializers(Deserializers additional) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(additional));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers additional) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(additional));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier modifier) {
        return withConfig(this._factoryConfig.withDeserializerModifier(modifier));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver resolver) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(resolver));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withValueInstantiators(ValueInstantiators instantiators) {
        return withConfig(this._factoryConfig.withValueInstantiators(instantiators));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JavaType mapAbstractType(DeserializationConfig config, JavaType type) throws JsonMappingException {
        while (true) {
            JavaType next = _mapAbstractType2(config, type);
            if (next == null) {
                return type;
            }
            Class<?> prevCls = type.getRawClass();
            Class<?> nextCls = next.getRawClass();
            if (prevCls == nextCls || !prevCls.isAssignableFrom(nextCls)) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + type + " to " + next + ": latter is not a subtype of former");
            }
            type = next;
        }
    }

    private JavaType _mapAbstractType2(DeserializationConfig config, JavaType type) throws JsonMappingException {
        Class<?> currClass = type.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver resolver : this._factoryConfig.abstractTypeResolvers()) {
                JavaType concrete = resolver.findTypeMapping(config, type);
                if (concrete != null && !concrete.hasRawClass(currClass)) {
                    return concrete;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public ValueInstantiator findValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        ValueInstantiator instantiator = null;
        AnnotatedClass ac = beanDesc.getClassInfo();
        Object instDef = ctxt.getAnnotationIntrospector().findValueInstantiator(ac);
        if (instDef != null) {
            instantiator = _valueInstantiatorInstance(config, ac, instDef);
        }
        if (instantiator == null && (instantiator = JDKValueInstantiators.findStdValueInstantiator(config, beanDesc.getBeanClass())) == null) {
            instantiator = _constructDefaultValueInstantiator(ctxt, beanDesc);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators insts : this._factoryConfig.valueInstantiators()) {
                instantiator = insts.findValueInstantiator(config, beanDesc, instantiator);
                if (instantiator == null) {
                    ctxt.reportBadTypeDefinition(beanDesc, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", insts.getClass().getName());
                }
            }
        }
        if (instantiator.getIncompleteParameter() != null) {
            AnnotatedParameter nonAnnotatedParam = instantiator.getIncompleteParameter();
            AnnotatedWithParams ctor = nonAnnotatedParam.getOwner();
            throw new IllegalArgumentException("Argument #" + nonAnnotatedParam.getIndex() + " of constructor " + ctor + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
        }
        return instantiator;
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        CreatorCollector creators = new CreatorCollector(beanDesc, ctxt.getConfig());
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        DeserializationConfig config = ctxt.getConfig();
        VisibilityChecker<?> vchecker = config.getDefaultVisibilityChecker(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> creatorDefs = _findCreatorsFromProperties(ctxt, beanDesc);
        _addDeserializerFactoryMethods(ctxt, beanDesc, vchecker, intr, creators, creatorDefs);
        if (beanDesc.getType().isConcrete()) {
            _addDeserializerConstructors(ctxt, beanDesc, vchecker, intr, creators, creatorDefs);
        }
        return creators.constructValueInstantiator(ctxt);
    }

    protected Map<AnnotatedWithParams, BeanPropertyDefinition[]> _findCreatorsFromProperties(DeserializationContext ctxt, BeanDescription beanDesc) throws JsonMappingException {
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> result = Collections.emptyMap();
        for (BeanPropertyDefinition propDef : beanDesc.findProperties()) {
            Iterator<AnnotatedParameter> it = propDef.getConstructorParameters();
            while (it.hasNext()) {
                AnnotatedParameter param = it.next();
                AnnotatedWithParams owner = param.getOwner();
                BeanPropertyDefinition[] defs = result.get(owner);
                int index = param.getIndex();
                if (defs == null) {
                    if (result.isEmpty()) {
                        result = new LinkedHashMap();
                    }
                    defs = new BeanPropertyDefinition[owner.getParameterCount()];
                    result.put(owner, defs);
                } else if (defs[index] != null) {
                    ctxt.reportBadTypeDefinition(beanDesc, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(index), owner, defs[index], propDef);
                }
                defs[index] = propDef;
            }
        }
        return result;
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig config, Annotated annotated, Object instDef) throws JsonMappingException {
        ValueInstantiator inst;
        if (instDef == null) {
            return null;
        }
        if (instDef instanceof ValueInstantiator) {
            return (ValueInstantiator) instDef;
        }
        if (!(instDef instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + instDef.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class<?> instClass = (Class) instDef;
        if (ClassUtil.isBogusClass(instClass)) {
            return null;
        }
        if (!ValueInstantiator.class.isAssignableFrom(instClass)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + instClass.getName() + "; expected Class<ValueInstantiator>");
        }
        HandlerInstantiator hi = config.getHandlerInstantiator();
        if (hi != null && (inst = hi.valueInstantiatorInstance(config, annotated, instClass)) != null) {
            return inst;
        }
        return (ValueInstantiator) ClassUtil.createInstance(instClass, config.canOverrideAccessModifiers());
    }

    protected void _addDeserializerConstructors(DeserializationContext ctxt, BeanDescription beanDesc, VisibilityChecker<?> vchecker, AnnotationIntrospector intr, CreatorCollector creators, Map<AnnotatedWithParams, BeanPropertyDefinition[]> creatorParams) throws JsonMappingException {
        PropertyName propertyName;
        List<CreatorCandidate> nonAnnotated;
        AnnotatedConstructor defaultCtor;
        CreatorCollector creatorCollector;
        DeserializationContext deserializationContext;
        BeanDescription beanDescription;
        List<AnnotatedWithParams> implicitCtors;
        int i;
        SettableBeanProperty[] properties;
        CreatorCandidate candidate;
        List<CreatorCandidate> nonAnnotated2;
        AnnotatedConstructor defaultCtor2;
        CreatorCollector creatorCollector2;
        AnnotatedWithParams ctor;
        int argCount;
        DeserializationContext deserializationContext2 = ctxt;
        BeanDescription beanDescription2 = beanDesc;
        vchecker = vchecker;
        CreatorCollector creatorCollector3 = creators;
        boolean isNonStaticInnerClass = beanDesc.isNonStaticInnerClass();
        if (isNonStaticInnerClass) {
            return;
        }
        AnnotatedConstructor defaultCtor3 = beanDesc.findDefaultConstructor();
        if (defaultCtor3 != null && (!creators.hasDefaultCreator() || _hasCreatorAnnotation(deserializationContext2, defaultCtor3))) {
            creatorCollector3.setDefaultCreator(defaultCtor3);
        }
        List<CreatorCandidate> nonAnnotated3 = new LinkedList<>();
        Iterator<AnnotatedConstructor> it = beanDesc.getConstructors().iterator();
        int explCount = 0;
        while (true) {
            PropertyName propertyName2 = null;
            if (it.hasNext()) {
                AnnotatedConstructor ctor2 = it.next();
                JsonCreator.Mode creatorMode = intr.findCreatorAnnotation(ctxt.getConfig(), ctor2);
                if (JsonCreator.Mode.DISABLED != creatorMode) {
                    if (creatorMode == null) {
                        if (vchecker.isCreatorVisible(ctor2)) {
                            nonAnnotated3.add(CreatorCandidate.construct(intr, ctor2, creatorParams.get(ctor2)));
                        }
                    } else {
                        switch (creatorMode) {
                            case DELEGATING:
                                _addExplicitDelegatingCreator(deserializationContext2, beanDescription2, creatorCollector3, CreatorCandidate.construct(intr, ctor2, null));
                                break;
                            case PROPERTIES:
                                _addExplicitPropertyCreator(deserializationContext2, beanDescription2, creatorCollector3, CreatorCandidate.construct(intr, ctor2, creatorParams.get(ctor2)));
                                break;
                            default:
                                _addExplicitAnyCreator(deserializationContext2, beanDescription2, creatorCollector3, CreatorCandidate.construct(intr, ctor2, creatorParams.get(ctor2)));
                                break;
                        }
                        explCount++;
                    }
                }
            } else {
                if (explCount > 0) {
                    return;
                }
                List<AnnotatedWithParams> implicitCtors2 = null;
                for (CreatorCandidate candidate2 : nonAnnotated3) {
                    int argCount2 = candidate2.paramCount();
                    AnnotatedWithParams ctor3 = candidate2.creator();
                    if (argCount2 == 1) {
                        BeanPropertyDefinition propDef = candidate2.propertyDef(0);
                        boolean useProps = _checkIfCreatorPropertyBased(intr, ctor3, propDef);
                        if (useProps) {
                            propertyName = propertyName2;
                            SettableBeanProperty[] properties2 = {constructCreatorProperty(ctxt, beanDesc, candidate2.paramName(0), 0, candidate2.parameter(0), candidate2.injection(0))};
                            creatorCollector3.addPropertyCreator(ctor3, false, properties2);
                            nonAnnotated = nonAnnotated3;
                            defaultCtor = defaultCtor3;
                            creatorCollector = creatorCollector3;
                            deserializationContext = ctxt;
                            beanDescription = beanDesc;
                        } else {
                            propertyName = propertyName2;
                            _handleSingleArgumentCreator(creatorCollector3, ctor3, false, vchecker.isCreatorVisible(ctor3));
                            if (propDef == null) {
                                nonAnnotated = nonAnnotated3;
                                defaultCtor = defaultCtor3;
                                creatorCollector = creatorCollector3;
                                deserializationContext = ctxt;
                                beanDescription = beanDesc;
                            } else {
                                ((POJOPropertyBuilder) propDef).removeConstructors();
                                nonAnnotated = nonAnnotated3;
                                defaultCtor = defaultCtor3;
                                creatorCollector = creatorCollector3;
                                deserializationContext = ctxt;
                                beanDescription = beanDesc;
                            }
                        }
                    } else {
                        AnnotatedWithParams ctor4 = ctor3;
                        int argCount3 = argCount2;
                        CreatorCandidate candidate3 = candidate2;
                        propertyName = propertyName2;
                        SettableBeanProperty[] properties3 = new SettableBeanProperty[argCount3];
                        int explicitNameCount = 0;
                        int injectCount = 0;
                        int nonAnnotatedParamIndex = -1;
                        int nonAnnotatedParamIndex2 = 0;
                        while (nonAnnotatedParamIndex2 < argCount3) {
                            AnnotatedParameter param = ctor4.getParameter(nonAnnotatedParamIndex2);
                            AnnotatedWithParams ctor5 = ctor4;
                            CreatorCandidate candidate4 = candidate3;
                            BeanPropertyDefinition propDef2 = candidate4.propertyDef(nonAnnotatedParamIndex2);
                            JacksonInject.Value injectable = intr.findInjectableValue(param);
                            PropertyName name = propDef2 == null ? propertyName : propDef2.getFullName();
                            if (propDef2 == null || !propDef2.isExplicitlyNamed()) {
                                i = nonAnnotatedParamIndex2;
                                properties = properties3;
                                candidate = candidate4;
                                int argCount4 = argCount3;
                                int argCount5 = nonAnnotatedParamIndex;
                                if (injectable != null) {
                                    injectCount++;
                                    nonAnnotated2 = nonAnnotated3;
                                    defaultCtor2 = defaultCtor3;
                                    creatorCollector2 = creatorCollector3;
                                    properties[i] = constructCreatorProperty(ctxt, beanDesc, name, i, param, injectable);
                                    nonAnnotatedParamIndex = argCount5;
                                    ctor = ctor5;
                                    argCount = argCount4;
                                } else {
                                    nonAnnotated2 = nonAnnotated3;
                                    defaultCtor2 = defaultCtor3;
                                    creatorCollector2 = creatorCollector3;
                                    NameTransformer unwrapper = intr.findUnwrappingNameTransformer(param);
                                    if (unwrapper != null) {
                                        ctor = ctor5;
                                        argCount = argCount4;
                                        _reportUnwrappedCreatorProperty(ctxt, beanDesc, param);
                                    } else {
                                        ctor = ctor5;
                                        argCount = argCount4;
                                        if (argCount5 < 0) {
                                            nonAnnotatedParamIndex = i;
                                        }
                                    }
                                    nonAnnotatedParamIndex = argCount5;
                                }
                            } else {
                                i = nonAnnotatedParamIndex2;
                                properties = properties3;
                                candidate = candidate4;
                                properties[i] = constructCreatorProperty(ctxt, beanDesc, name, i, param, injectable);
                                defaultCtor2 = defaultCtor3;
                                creatorCollector2 = creatorCollector3;
                                nonAnnotatedParamIndex = nonAnnotatedParamIndex;
                                ctor = ctor5;
                                explicitNameCount++;
                                argCount = argCount3;
                                nonAnnotated2 = nonAnnotated3;
                            }
                            nonAnnotatedParamIndex2 = i + 1;
                            creatorCollector3 = creatorCollector2;
                            argCount3 = argCount;
                            ctor4 = ctor;
                            properties3 = properties;
                            nonAnnotated3 = nonAnnotated2;
                            candidate3 = candidate;
                            defaultCtor3 = defaultCtor2;
                        }
                        SettableBeanProperty[] properties4 = properties3;
                        nonAnnotated = nonAnnotated3;
                        defaultCtor = defaultCtor3;
                        creatorCollector = creatorCollector3;
                        AnnotatedWithParams ctor6 = ctor4;
                        int argCount6 = argCount3;
                        CreatorCandidate candidate5 = candidate3;
                        deserializationContext = ctxt;
                        beanDescription = beanDesc;
                        int argCount7 = nonAnnotatedParamIndex;
                        int i2 = explicitNameCount + 0;
                        if (explicitNameCount > 0 || injectCount > 0) {
                            if (i2 + injectCount == argCount6) {
                                creatorCollector.addPropertyCreator(ctor6, false, properties4);
                            } else if (explicitNameCount == 0 && injectCount + 1 == argCount6) {
                                creatorCollector.addDelegatingCreator(ctor6, false, properties4, 0);
                            } else {
                                PropertyName impl = candidate5.findImplicitParamName(argCount7);
                                if (impl == null || impl.isEmpty()) {
                                    deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(argCount7), ctor6);
                                }
                            }
                        }
                        if (!creators.hasDefaultCreator()) {
                            if (implicitCtors2 != null) {
                                implicitCtors = implicitCtors2;
                            } else {
                                implicitCtors = new LinkedList<>();
                            }
                            implicitCtors.add(ctor6);
                            implicitCtors2 = implicitCtors;
                        }
                        creatorCollector3 = creatorCollector;
                        deserializationContext2 = deserializationContext;
                        beanDescription2 = beanDescription;
                        propertyName2 = propertyName;
                        nonAnnotated3 = nonAnnotated;
                        defaultCtor3 = defaultCtor;
                    }
                    creatorCollector3 = creatorCollector;
                    deserializationContext2 = deserializationContext;
                    beanDescription2 = beanDescription;
                    propertyName2 = propertyName;
                    nonAnnotated3 = nonAnnotated;
                    defaultCtor3 = defaultCtor;
                }
                if (implicitCtors2 != null && !creators.hasDelegatingCreator() && !creators.hasPropertyBasedCreator()) {
                    _checkImplicitlyNamedConstructors(ctxt, beanDesc, vchecker, intr, creators, implicitCtors2);
                    return;
                }
                return;
            }
        }
    }

    protected void _addExplicitDelegatingCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        int argCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
        int ix = -1;
        for (int i = 0; i < argCount; i++) {
            AnnotatedParameter param = candidate.parameter(i);
            JacksonInject.Value injectId = candidate.injection(i);
            if (injectId != null) {
                properties[i] = constructCreatorProperty(ctxt, beanDesc, null, i, param, injectId);
            } else if (ix >= 0) {
                ctxt.reportBadTypeDefinition(beanDesc, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(ix), Integer.valueOf(i), candidate);
            } else {
                int ix2 = i;
                ix = ix2;
            }
        }
        if (ix < 0) {
            ctxt.reportBadTypeDefinition(beanDesc, "No argument left as delegating for Creator %s: exactly one required", candidate);
        }
        if (argCount == 1) {
            _handleSingleArgumentCreator(creators, candidate.creator(), true, true);
            BeanPropertyDefinition paramDef = candidate.propertyDef(0);
            if (paramDef != null) {
                ((POJOPropertyBuilder) paramDef).removeConstructors();
                return;
            }
            return;
        }
        creators.addDelegatingCreator(candidate.creator(), true, properties, ix);
    }

    protected void _addExplicitPropertyCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        int paramCount = candidate.paramCount();
        SettableBeanProperty[] properties = new SettableBeanProperty[paramCount];
        for (int i = 0; i < paramCount; i++) {
            JacksonInject.Value injectId = candidate.injection(i);
            AnnotatedParameter param = candidate.parameter(i);
            PropertyName name = candidate.paramName(i);
            if (name == null) {
                NameTransformer unwrapper = ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(param);
                if (unwrapper != null) {
                    _reportUnwrappedCreatorProperty(ctxt, beanDesc, param);
                }
                name = candidate.findImplicitParamName(i);
                if (name == null && injectId == null) {
                    ctxt.reportBadTypeDefinition(beanDesc, "Argument #%d has no property name, is not Injectable: can not use as Creator %s", Integer.valueOf(i), candidate);
                }
            }
            properties[i] = constructCreatorProperty(ctxt, beanDesc, name, i, param, injectId);
        }
        creators.addPropertyCreator(candidate.creator(), true, properties);
    }

    protected void _addExplicitAnyCreator(DeserializationContext ctxt, BeanDescription beanDesc, CreatorCollector creators, CreatorCandidate candidate) throws JsonMappingException {
        PropertyName paramName;
        boolean useProps;
        if (1 != candidate.paramCount()) {
            int oneNotInjected = candidate.findOnlyParamWithoutInjection();
            if (oneNotInjected >= 0 && candidate.paramName(oneNotInjected) == null) {
                _addExplicitDelegatingCreator(ctxt, beanDesc, creators, candidate);
                return;
            } else {
                _addExplicitPropertyCreator(ctxt, beanDesc, creators, candidate);
                return;
            }
        }
        AnnotatedParameter param = candidate.parameter(0);
        JacksonInject.Value injectId = candidate.injection(0);
        PropertyName paramName2 = candidate.explicitParamName(0);
        BeanPropertyDefinition paramDef = candidate.propertyDef(0);
        boolean useProps2 = (paramName2 == null && injectId == null) ? false : true;
        if (!useProps2 && paramDef != null) {
            PropertyName paramName3 = candidate.paramName(0);
            paramName = paramName3;
            useProps = paramName3 != null && paramDef.couldSerialize();
        } else {
            paramName = paramName2;
            useProps = useProps2;
        }
        if (!useProps) {
            _handleSingleArgumentCreator(creators, candidate.creator(), true, true);
            if (paramDef != null) {
                ((POJOPropertyBuilder) paramDef).removeConstructors();
                return;
            }
            return;
        }
        SettableBeanProperty[] properties = {constructCreatorProperty(ctxt, beanDesc, paramName, 0, param, injectId)};
        creators.addPropertyCreator(candidate.creator(), true, properties);
    }

    private boolean _checkIfCreatorPropertyBased(AnnotationIntrospector intr, AnnotatedWithParams creator, BeanPropertyDefinition propDef) {
        String implName;
        if ((propDef != null && propDef.isExplicitlyNamed()) || intr.findInjectableValue(creator.getParameter(0)) != null) {
            return true;
        }
        if (propDef != null && (implName = propDef.getName()) != null && !implName.isEmpty() && propDef.couldSerialize()) {
            return true;
        }
        return false;
    }

    private void _checkImplicitlyNamedConstructors(DeserializationContext ctxt, BeanDescription beanDesc, VisibilityChecker<?> vchecker, AnnotationIntrospector intr, CreatorCollector creators, List<AnnotatedWithParams> implicitCtors) throws JsonMappingException {
        AnnotatedWithParams found = null;
        SettableBeanProperty[] foundProps = null;
        for (AnnotatedWithParams ctor : implicitCtors) {
            if (vchecker.isCreatorVisible(ctor)) {
                int argCount = ctor.getParameterCount();
                SettableBeanProperty[] properties = new SettableBeanProperty[argCount];
                int i = 0;
                while (true) {
                    if (i < argCount) {
                        AnnotatedParameter param = ctor.getParameter(i);
                        PropertyName name = _findParamName(param, intr);
                        if (name == null || name.isEmpty()) {
                            break;
                        }
                        properties[i] = constructCreatorProperty(ctxt, beanDesc, name, param.getIndex(), param, null);
                        i++;
                    } else if (found != null) {
                        found = null;
                        break;
                    } else {
                        found = ctor;
                        foundProps = properties;
                        break;
                    }
                }
            }
        }
        if (found != null) {
            creators.addPropertyCreator(found, false, foundProps);
            BasicBeanDescription bbd = (BasicBeanDescription) beanDesc;
            for (SettableBeanProperty prop : foundProps) {
                PropertyName pn = prop.getFullName();
                if (!bbd.hasProperty(pn)) {
                    BeanPropertyDefinition newDef = SimpleBeanPropertyDefinition.construct(ctxt.getConfig(), prop.getMember(), pn);
                    bbd.addProperty(newDef);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v1, types: [com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition] */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    protected void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) throws JsonMappingException {
        BeanPropertyDefinition beanPropertyDefinition;
        AnnotatedWithParams annotatedWithParams;
        int i;
        CreatorCandidate creatorCandidate;
        PropertyName propertyName;
        LinkedList linkedList;
        CreatorCollector creatorCollector2;
        BasicDeserializerFactory basicDeserializerFactory;
        BasicDeserializerFactory basicDeserializerFactory2 = this;
        VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
        CreatorCollector creatorCollector3 = creatorCollector;
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> map2 = map;
        LinkedList<CreatorCandidate> linkedList2 = new LinkedList();
        Iterator<AnnotatedMethod> it = beanDescription.getFactoryMethods().iterator();
        int i2 = 0;
        while (true) {
            PropertyName propertyName2 = null;
            int i3 = 1;
            if (it.hasNext()) {
                AnnotatedMethod next = it.next();
                JsonCreator.Mode modeFindCreatorAnnotation = annotationIntrospector.findCreatorAnnotation(deserializationContext.getConfig(), next);
                int parameterCount = next.getParameterCount();
                if (modeFindCreatorAnnotation == null) {
                    if (parameterCount == 1 && visibilityChecker2.isCreatorVisible(next)) {
                        linkedList2.add(CreatorCandidate.construct(annotationIntrospector, next, null));
                    }
                } else if (modeFindCreatorAnnotation != JsonCreator.Mode.DISABLED) {
                    if (parameterCount == 0) {
                        creatorCollector3.setDefaultCreator(next);
                    } else {
                        switch (modeFindCreatorAnnotation) {
                            case DELEGATING:
                                basicDeserializerFactory2._addExplicitDelegatingCreator(deserializationContext, beanDescription, creatorCollector3, CreatorCandidate.construct(annotationIntrospector, next, null));
                                break;
                            case PROPERTIES:
                                basicDeserializerFactory2._addExplicitPropertyCreator(deserializationContext, beanDescription, creatorCollector3, CreatorCandidate.construct(annotationIntrospector, next, map2.get(next)));
                                break;
                            default:
                                basicDeserializerFactory2._addExplicitAnyCreator(deserializationContext, beanDescription, creatorCollector3, CreatorCandidate.construct(annotationIntrospector, next, map2.get(next)));
                                break;
                        }
                        i2++;
                    }
                }
            } else {
                if (i2 > 0) {
                    return;
                }
                for (CreatorCandidate creatorCandidate2 : linkedList2) {
                    int iParamCount = creatorCandidate2.paramCount();
                    AnnotatedWithParams annotatedWithParamsCreator = creatorCandidate2.creator();
                    BeanPropertyDefinition[] beanPropertyDefinitionArr = map2.get(annotatedWithParamsCreator);
                    if (iParamCount == i3) {
                        BeanPropertyDefinition beanPropertyDefinitionPropertyDef = creatorCandidate2.propertyDef(0);
                        if (!basicDeserializerFactory2._checkIfCreatorPropertyBased(annotationIntrospector, annotatedWithParamsCreator, beanPropertyDefinitionPropertyDef)) {
                            basicDeserializerFactory2._handleSingleArgumentCreator(creatorCollector3, annotatedWithParamsCreator, false, visibilityChecker2.isCreatorVisible(annotatedWithParamsCreator));
                            if (beanPropertyDefinitionPropertyDef != null) {
                                ((POJOPropertyBuilder) beanPropertyDefinitionPropertyDef).removeConstructors();
                            }
                        } else {
                            SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
                            AnnotatedParameter annotatedParameter = null;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            while (i4 < iParamCount) {
                                AnnotatedParameter parameter = annotatedWithParamsCreator.getParameter(i4);
                                ?? r24 = beanPropertyDefinitionArr == null ? propertyName2 : beanPropertyDefinitionArr[i4];
                                JacksonInject.Value valueFindInjectableValue = annotationIntrospector.findInjectableValue(parameter);
                                int i7 = i4;
                                PropertyName fullName = r24 == 0 ? propertyName2 : r24.getFullName();
                                if (r24 == 0 || !r24.isExplicitlyNamed()) {
                                    beanPropertyDefinition = beanPropertyDefinitionPropertyDef;
                                    annotatedWithParams = annotatedWithParamsCreator;
                                    i = iParamCount;
                                    creatorCandidate = creatorCandidate2;
                                    if (valueFindInjectableValue != null) {
                                        i5++;
                                        propertyName = propertyName2;
                                        linkedList = linkedList2;
                                        creatorCollector2 = creatorCollector3;
                                        settableBeanPropertyArr[i7] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i7, parameter, valueFindInjectableValue);
                                        basicDeserializerFactory = this;
                                    } else {
                                        propertyName = propertyName2;
                                        linkedList = linkedList2;
                                        creatorCollector2 = creatorCollector3;
                                        if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                                            basicDeserializerFactory = this;
                                            basicDeserializerFactory._reportUnwrappedCreatorProperty(deserializationContext, beanDescription, parameter);
                                        } else {
                                            basicDeserializerFactory = this;
                                            if (annotatedParameter == null) {
                                                annotatedParameter = parameter;
                                            }
                                        }
                                    }
                                } else {
                                    i6++;
                                    beanPropertyDefinition = beanPropertyDefinitionPropertyDef;
                                    annotatedWithParams = annotatedWithParamsCreator;
                                    i = iParamCount;
                                    creatorCandidate = creatorCandidate2;
                                    settableBeanPropertyArr[i7] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i7, parameter, valueFindInjectableValue);
                                    basicDeserializerFactory = this;
                                    propertyName = propertyName2;
                                    linkedList = linkedList2;
                                    creatorCollector2 = creatorCollector3;
                                }
                                i4 = i7 + 1;
                                propertyName2 = propertyName;
                                linkedList2 = linkedList;
                                creatorCollector3 = creatorCollector2;
                                basicDeserializerFactory2 = basicDeserializerFactory;
                                beanPropertyDefinitionPropertyDef = beanPropertyDefinition;
                                annotatedWithParamsCreator = annotatedWithParams;
                                iParamCount = i;
                                creatorCandidate2 = creatorCandidate;
                            }
                            AnnotatedWithParams annotatedWithParams2 = annotatedWithParamsCreator;
                            int i8 = iParamCount;
                            PropertyName propertyName3 = propertyName2;
                            LinkedList linkedList3 = linkedList2;
                            CreatorCollector creatorCollector4 = creatorCollector3;
                            BasicDeserializerFactory basicDeserializerFactory3 = basicDeserializerFactory2;
                            int i9 = i6 + 0;
                            if (i6 > 0 || i5 > 0) {
                                if (i9 + i5 == i8) {
                                    creatorCollector4.addPropertyCreator(annotatedWithParams2, false, settableBeanPropertyArr);
                                } else if (i6 == 0 && i5 + 1 == i8) {
                                    creatorCollector4.addDelegatingCreator(annotatedWithParams2, false, settableBeanPropertyArr, 0);
                                } else {
                                    deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(annotatedParameter.getIndex()), annotatedWithParams2);
                                }
                            }
                            visibilityChecker2 = visibilityChecker;
                            map2 = map;
                            propertyName2 = propertyName3;
                            linkedList2 = linkedList3;
                            creatorCollector3 = creatorCollector4;
                            basicDeserializerFactory2 = basicDeserializerFactory3;
                            i3 = 1;
                        }
                    }
                }
                return;
            }
        }
    }

    protected boolean _handleSingleArgumentCreator(CreatorCollector creators, AnnotatedWithParams ctor, boolean isCreator, boolean isVisible) {
        Class<?> type = ctor.getRawParameterType(0);
        if (type == String.class || type == CLASS_CHAR_SEQUENCE) {
            if (isCreator || isVisible) {
                creators.addStringCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Integer.TYPE || type == Integer.class) {
            if (isCreator || isVisible) {
                creators.addIntCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Long.TYPE || type == Long.class) {
            if (isCreator || isVisible) {
                creators.addLongCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Double.TYPE || type == Double.class) {
            if (isCreator || isVisible) {
                creators.addDoubleCreator(ctor, isCreator);
            }
            return true;
        }
        if (type == Boolean.TYPE || type == Boolean.class) {
            if (isCreator || isVisible) {
                creators.addBooleanCreator(ctor, isCreator);
            }
            return true;
        }
        if (isCreator) {
            creators.addDelegatingCreator(ctor, isCreator, null, 0);
            return true;
        }
        return false;
    }

    protected void _reportUnwrappedCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, AnnotatedParameter param) throws JsonMappingException {
        ctxt.reportBadDefinition(beanDesc.getType(), String.format("Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(param.getIndex())));
    }

    protected SettableBeanProperty constructCreatorProperty(DeserializationContext ctxt, BeanDescription beanDesc, PropertyName name, int index, AnnotatedParameter param, JacksonInject.Value injectable) throws JsonMappingException {
        PropertyMetadata metadata;
        TypeDeserializer typeDeser;
        DeserializationConfig config = ctxt.getConfig();
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            metadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        } else {
            Boolean b = intr.hasRequiredMarker(param);
            String desc = intr.findPropertyDescription(param);
            Integer idx = intr.findPropertyIndex(param);
            String def = intr.findPropertyDefaultValue(param);
            metadata = PropertyMetadata.construct(b, desc, idx, def);
        }
        JavaType type = resolveMemberAndTypeAnnotations(ctxt, param, param.getType());
        BeanProperty.Std property = new BeanProperty.Std(name, type, intr.findWrapperName(param), param, metadata);
        TypeDeserializer typeDeser2 = (TypeDeserializer) type.getTypeHandler();
        if (typeDeser2 != null) {
            typeDeser = typeDeser2;
        } else {
            typeDeser = findTypeDeserializer(config, type);
        }
        TypeDeserializer typeDeserializer = typeDeser;
        SettableBeanProperty prop = CreatorProperty.construct(name, type, property.getWrapperName(), typeDeserializer, beanDesc.getClassAnnotations(), param, index, injectable, _getSetterInfo(ctxt, property, metadata));
        JsonDeserializer<?> deser = findDeserializerFromAnnotation(ctxt, param);
        if (deser == null) {
            deser = (JsonDeserializer) type.getValueHandler();
        }
        if (deser != null) {
            return prop.withValueDeserializer(ctxt.handlePrimaryContextualization(deser, prop, type));
        }
        return prop;
    }

    private PropertyName _findParamName(AnnotatedParameter param, AnnotationIntrospector intr) {
        if (param != null && intr != null) {
            PropertyName name = intr.findNameForDeserialization(param);
            if (name != null) {
                return name;
            }
            String str = intr.findImplicitPropertyName(param);
            if (str != null && !str.isEmpty()) {
                return PropertyName.construct(str);
            }
            return null;
        }
        return null;
    }

    protected PropertyMetadata _getSetterInfo(DeserializationContext ctxt, BeanProperty prop, PropertyMetadata metadata) {
        JsonSetter.Value setterInfo;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        DeserializationConfig config = ctxt.getConfig();
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        AnnotatedMember prim = prop.getMember();
        if (prim != null) {
            if (intr != null && (setterInfo = intr.findSetterInfo(prim)) != null) {
                valueNulls = setterInfo.nonDefaultValueNulls();
                contentNulls = setterInfo.nonDefaultContentNulls();
            }
            if (1 != 0 || valueNulls == null || contentNulls == null) {
                ConfigOverride co = config.getConfigOverride(prop.getType().getRawClass());
                JsonSetter.Value setterInfo2 = co.getSetterInfo();
                if (setterInfo2 != null) {
                    if (valueNulls == null) {
                        valueNulls = setterInfo2.nonDefaultValueNulls();
                    }
                    if (contentNulls == null) {
                        contentNulls = setterInfo2.nonDefaultContentNulls();
                    }
                }
            }
        }
        if (1 != 0 || valueNulls == null || contentNulls == null) {
            JsonSetter.Value setterInfo3 = config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo3.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo3.nonDefaultContentNulls();
            }
        }
        if (valueNulls != null || contentNulls != null) {
            return metadata.withNulls(valueNulls, contentNulls);
        }
        return metadata;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext ctxt, ArrayType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer elemTypeDeser;
        DeserializationConfig config = ctxt.getConfig();
        JavaType elemType = type.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) elemType.getValueHandler();
        TypeDeserializer elemTypeDeser2 = (TypeDeserializer) elemType.getTypeHandler();
        if (elemTypeDeser2 != null) {
            elemTypeDeser = elemTypeDeser2;
        } else {
            elemTypeDeser = findTypeDeserializer(config, elemType);
        }
        JsonDeserializer<?> deser = _findCustomArrayDeserializer(type, config, beanDesc, elemTypeDeser, jsonDeserializer);
        if (deser == null) {
            if (jsonDeserializer == null) {
                Class<?> raw = elemType.getRawClass();
                if (elemType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(raw);
                }
                if (raw == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            deser = new ObjectArrayDeserializer(type, jsonDeserializer, elemTypeDeser);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyArrayDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext ctxt, CollectionType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType contentType = type.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 != null) {
            contentTypeDeser = contentTypeDeser2;
        } else {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> deser = _findCustomCollectionDeserializer(type, config, beanDesc, contentTypeDeser, jsonDeserializer);
        if (deser == null) {
            Class<?> collectionClass = type.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(collectionClass)) {
                deser = new EnumSetDeserializer(contentType, null);
            }
        }
        if (deser == null) {
            if (type.isInterface() || type.isAbstract()) {
                CollectionType implType = _mapAbstractCollectionType(type, config);
                if (implType == null) {
                    if (type.getTypeHandler() == null) {
                        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + type);
                    }
                    deser = AbstractDeserializer.constructForNonPOJO(beanDesc);
                } else {
                    type = implType;
                    beanDesc = config.introspectForCreation(type);
                }
            }
            if (deser == null) {
                ValueInstantiator inst = findValueInstantiator(ctxt, beanDesc);
                if (!inst.canCreateUsingDefault()) {
                    if (type.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(type, jsonDeserializer, contentTypeDeser, inst);
                    }
                    JsonDeserializer<?> deser2 = JavaUtilCollectionsDeserializers.findForCollection(ctxt, type);
                    if (deser2 != null) {
                        return deser2;
                    }
                }
                if (contentType.hasRawClass(String.class)) {
                    deser = new StringCollectionDeserializer(type, jsonDeserializer, inst);
                } else {
                    deser = new CollectionDeserializer(type, jsonDeserializer, contentTypeDeser, inst);
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyCollectionDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    protected CollectionType _mapAbstractCollectionType(JavaType type, DeserializationConfig config) {
        Class<?> collectionClass = ContainerDefaultMappings.findCollectionFallback(type);
        if (collectionClass != null) {
            return (CollectionType) config.getTypeFactory().constructSpecializedType(type, collectionClass, true);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext ctxt, CollectionLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType contentType = type.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 != null) {
            contentTypeDeser = contentTypeDeser2;
        } else {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> deser = _findCustomCollectionLikeDeserializer(type, config, beanDesc, contentTypeDeser, jsonDeserializer);
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyCollectionLikeDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapDeserializer(DeserializationContext ctxt, MapType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        BeanDescription beanDesc2;
        BeanDescription beanDesc3;
        MapType type2;
        Class<?> mapClass;
        ValueInstantiator inst;
        MapType type3 = type;
        DeserializationConfig config = ctxt.getConfig();
        JavaType keyType = type.getKeyType();
        JavaType contentType = type.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDes = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 != null) {
            contentTypeDeser = contentTypeDeser2;
        } else {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> deser = _findCustomMapDeserializer(type, config, beanDesc, keyDes, contentTypeDeser, jsonDeserializer);
        if (deser != null) {
            beanDesc2 = beanDesc;
        } else {
            Class<?> mapClass2 = type.getRawClass();
            if (EnumMap.class.isAssignableFrom(mapClass2)) {
                if (mapClass2 != EnumMap.class) {
                    inst = findValueInstantiator(ctxt, beanDesc);
                } else {
                    inst = null;
                }
                if (!keyType.isEnumImplType()) {
                    throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
                }
                deser = new EnumMapDeserializer(type, inst, null, jsonDeserializer, contentTypeDeser, null);
            }
            if (deser != null) {
                beanDesc2 = beanDesc;
            } else {
                if (type.isInterface() || type.isAbstract()) {
                    MapType fallback = _mapAbstractMapType(type3, config);
                    if (fallback != null) {
                        type2 = fallback;
                        mapClass = type2.getRawClass();
                        beanDesc3 = config.introspectForCreation(type2);
                    } else {
                        if (type.getTypeHandler() == null) {
                            throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + type3);
                        }
                        deser = AbstractDeserializer.constructForNonPOJO(beanDesc);
                        beanDesc3 = beanDesc;
                        type2 = type3;
                        mapClass = mapClass2;
                    }
                    type3 = type2;
                    beanDesc2 = beanDesc3;
                } else {
                    JsonDeserializer<?> deser2 = JavaUtilCollectionsDeserializers.findForMap(ctxt, type);
                    if (deser2 == null) {
                        deser = deser2;
                        beanDesc2 = beanDesc;
                    } else {
                        return deser2;
                    }
                }
                if (deser == null) {
                    ValueInstantiator inst2 = findValueInstantiator(ctxt, beanDesc2);
                    MapDeserializer md = new MapDeserializer(type3, inst2, keyDes, jsonDeserializer, contentTypeDeser);
                    JsonIgnoreProperties.Value ignorals = config.getDefaultPropertyIgnorals(Map.class, beanDesc2.getClassInfo());
                    Set<String> ignored = ignorals == null ? null : ignorals.findIgnoredForDeserialization();
                    md.setIgnorableProperties(ignored);
                    deser = md;
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            JsonDeserializer<?> deser3 = deser;
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser3 = mod.modifyMapDeserializer(config, type3, beanDesc2, deser3);
            }
            return deser3;
        }
        return deser;
    }

    protected MapType _mapAbstractMapType(JavaType type, DeserializationConfig config) {
        Class<?> mapClass = ContainerDefaultMappings.findMapFallback(type);
        if (mapClass != null) {
            return (MapType) config.getTypeFactory().constructSpecializedType(type, mapClass, true);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext ctxt, MapLikeType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        JavaType keyType = type.getKeyType();
        JavaType contentType = type.getContentType();
        DeserializationConfig config = ctxt.getConfig();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDes = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 != null) {
            contentTypeDeser = contentTypeDeser2;
        } else {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> deser = _findCustomMapLikeDeserializer(type, config, beanDesc, keyDes, contentTypeDeser, jsonDeserializer);
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyMapLikeDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        JsonDeserializer<?> deser = _findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (deser == null) {
            if (enumClass == Enum.class) {
                return AbstractDeserializer.constructForNonPOJO(beanDesc);
            }
            ValueInstantiator valueInstantiator = _constructDefaultValueInstantiator(ctxt, beanDesc);
            SettableBeanProperty[] creatorProps = valueInstantiator == null ? null : valueInstantiator.getFromObjectArguments(ctxt.getConfig());
            for (AnnotatedMethod factory : beanDesc.getFactoryMethods()) {
                if (_hasCreatorAnnotation(ctxt, factory)) {
                    if (factory.getParameterCount() == 0) {
                        deser = EnumDeserializer.deserializerForNoArgsCreator(config, enumClass, factory);
                        break;
                    }
                    Class<?> returnType = factory.getRawReturnType();
                    if (!returnType.isAssignableFrom(enumClass)) {
                        ctxt.reportBadDefinition(type, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", factory.toString()));
                    }
                    deser = EnumDeserializer.deserializerForCreator(config, enumClass, factory, valueInstantiator, creatorProps);
                    break;
                }
            }
            if (deser == null) {
                deser = new EnumDeserializer(constructEnumResolver(enumClass, config, beanDesc.findJsonValueAccessor()), Boolean.valueOf(config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyEnumDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig config, JavaType nodeType, BeanDescription beanDesc) throws JsonMappingException {
        Class<?> rawClass = nodeType.getRawClass();
        JsonDeserializer<?> custom = _findCustomTreeNodeDeserializer(rawClass, config, beanDesc);
        if (custom != null) {
            return custom;
        }
        return JsonNodeDeserializer.getDeserializer(rawClass);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext ctxt, ReferenceType type, BeanDescription beanDesc) throws JsonMappingException {
        TypeDeserializer contentTypeDeser;
        ValueInstantiator inst;
        JavaType contentType = type.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = ctxt.getConfig();
        TypeDeserializer contentTypeDeser2 = (TypeDeserializer) contentType.getTypeHandler();
        if (contentTypeDeser2 != null) {
            contentTypeDeser = contentTypeDeser2;
        } else {
            contentTypeDeser = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> deser = _findCustomReferenceDeserializer(type, config, beanDesc, contentTypeDeser, jsonDeserializer);
        if (deser == null && type.isTypeOrSubTypeOf(AtomicReference.class)) {
            Class<?> rawType = type.getRawClass();
            if (rawType == AtomicReference.class) {
                inst = null;
            } else {
                inst = findValueInstantiator(ctxt, beanDesc);
            }
            return new AtomicReferenceDeserializer(type, inst, contentTypeDeser, jsonDeserializer);
        }
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyReferenceDeserializer(config, type, beanDesc, deser);
            }
        }
        return deser;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public TypeDeserializer findTypeDeserializer(DeserializationConfig config, JavaType baseType) throws JsonMappingException {
        JavaType defaultType;
        BeanDescription bean = config.introspectClassAnnotations(baseType.getRawClass());
        AnnotatedClass ac = bean.getClassInfo();
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findTypeResolver(config, ac, baseType);
        Collection<NamedType> subtypes = null;
        if (b == null) {
            b = config.getDefaultTyper(baseType);
            if (b == null) {
                return null;
            }
        } else {
            subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, ac);
        }
        if (b.getDefaultImpl() == null && baseType.isAbstract() && (defaultType = mapAbstractType(config, baseType)) != null && !defaultType.hasRawClass(baseType.getRawClass())) {
            b = b.defaultImpl(defaultType.getRawClass());
        }
        try {
            return b.buildTypeDeserializer(config, baseType, subtypes);
        } catch (IllegalArgumentException e0) {
            InvalidDefinitionException e = InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e0), baseType);
            e.initCause(e0);
            throw e;
        }
    }

    protected JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(type, ctxt.getConfig(), beanDesc);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public KeyDeserializer createKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        BeanDescription beanDesc = null;
        KeyDeserializer deser = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            beanDesc = config.introspectClassAnnotations(type);
            for (KeyDeserializers d : this._factoryConfig.keyDeserializers()) {
                deser = d.findKeyDeserializer(type, config, beanDesc);
                if (deser != null) {
                    break;
                }
            }
        }
        if (deser == null) {
            if (beanDesc == null) {
                beanDesc = config.introspectClassAnnotations(type.getRawClass());
            }
            deser = findKeyDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
            if (deser == null) {
                if (type.isEnumType()) {
                    deser = _createEnumKeyDeserializer(ctxt, type);
                } else {
                    deser = StdKeyDeserializers.findStringBasedKeyDeserializer(config, type);
                }
            }
        }
        if (deser != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier mod : this._factoryConfig.deserializerModifiers()) {
                deser = mod.modifyKeyDeserializer(config, type, deser);
            }
        }
        return deser;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        Class<?> enumClass = type.getRawClass();
        BeanDescription beanDesc = config.introspect(type);
        KeyDeserializer des = findKeyDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (des != null) {
            return des;
        }
        JsonDeserializer<?> custom = _findCustomEnumDeserializer(enumClass, config, beanDesc);
        if (custom != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, custom);
        }
        JsonDeserializer<Object> valueDesForKey = findDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (valueDesForKey != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, type, valueDesForKey);
        }
        EnumResolver enumRes = constructEnumResolver(enumClass, config, beanDesc.findJsonValueAccessor());
        for (AnnotatedMethod factory : beanDesc.getFactoryMethods()) {
            if (_hasCreatorAnnotation(ctxt, factory)) {
                int argCount = factory.getParameterCount();
                if (argCount == 1) {
                    Class<?> returnType = factory.getRawReturnType();
                    if (returnType.isAssignableFrom(enumClass)) {
                        if (factory.getRawParameterType(0) == String.class) {
                            if (config.canOverrideAccessModifiers()) {
                                ClassUtil.checkAndFixAccess(factory.getMember(), ctxt.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes, factory);
                        }
                    }
                }
                throw new IllegalArgumentException("Unsuitable method (" + factory + ") decorated with @JsonCreator (for Enum type " + enumClass.getName() + ")");
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumRes);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public boolean hasExplicitDeserializerFor(DeserializationConfig config, Class<?> valueType) {
        while (valueType.isArray()) {
            valueType = valueType.getComponentType();
        }
        if (Enum.class.isAssignableFrom(valueType)) {
            return true;
        }
        String clsName = valueType.getName();
        if (clsName.startsWith("java.")) {
            if (Collection.class.isAssignableFrom(valueType) || Map.class.isAssignableFrom(valueType)) {
                return true;
            }
            if (Number.class.isAssignableFrom(valueType)) {
                return NumberDeserializers.find(valueType, clsName) != null;
            }
            return JdkDeserializers.hasDeserializerFor(valueType) || valueType == CLASS_STRING || valueType == Boolean.class || valueType == EnumMap.class || valueType == AtomicReference.class || DateDeserializers.hasDeserializerFor(valueType);
        }
        if (clsName.startsWith("com.fasterxml.")) {
            return JsonNode.class.isAssignableFrom(valueType) || valueType == TokenBuffer.class;
        }
        return OptionalHandlerFactory.instance.hasDeserializerFor(valueType);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig config, JavaType baseType, AnnotatedMember annotated) throws JsonMappingException {
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findPropertyTypeResolver(config, annotated, baseType);
        if (b == null) {
            return findTypeDeserializer(config, baseType);
        }
        Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, annotated, baseType);
        try {
            return b.buildTypeDeserializer(config, baseType, subtypes);
        } catch (IllegalArgumentException e0) {
            InvalidDefinitionException e = InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e0), baseType);
            e.initCause(e0);
            throw e;
        }
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig config, JavaType containerType, AnnotatedMember propertyEntity) throws JsonMappingException {
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        TypeResolverBuilder<?> b = ai.findPropertyContentTypeResolver(config, propertyEntity, containerType);
        JavaType contentType = containerType.getContentType();
        if (b == null) {
            return findTypeDeserializer(config, contentType);
        }
        Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByTypeId(config, propertyEntity, contentType);
        return b.buildTypeDeserializer(config, contentType, subtypes);
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JavaType lt;
        JavaType mt;
        Class<?> rawType = type.getRawClass();
        if (rawType == CLASS_OBJECT || rawType == CLASS_SERIALIZABLE) {
            DeserializationConfig config = ctxt.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                lt = _findRemappedType(config, List.class);
                mt = _findRemappedType(config, Map.class);
            } else {
                lt = null;
                mt = null;
            }
            return new UntypedObjectDeserializer(lt, mt);
        }
        if (rawType == CLASS_STRING || rawType == CLASS_CHAR_SEQUENCE) {
            return StringDeserializer.instance;
        }
        if (rawType == CLASS_ITERABLE) {
            TypeFactory tf = ctxt.getTypeFactory();
            JavaType[] tps = tf.findTypeParameters(type, CLASS_ITERABLE);
            JavaType elemType = (tps == null || tps.length != 1) ? TypeFactory.unknownType() : tps[0];
            CollectionType ct = tf.constructCollectionType(Collection.class, elemType);
            return createCollectionDeserializer(ctxt, ct, beanDesc);
        }
        if (rawType == CLASS_MAP_ENTRY) {
            JavaType kt = type.containedTypeOrUnknown(0);
            JavaType vt = type.containedTypeOrUnknown(1);
            TypeDeserializer vts = (TypeDeserializer) vt.getTypeHandler();
            if (vts == null) {
                vts = findTypeDeserializer(ctxt.getConfig(), vt);
            }
            JsonDeserializer<Object> valueDeser = (JsonDeserializer) vt.getValueHandler();
            KeyDeserializer keyDes = (KeyDeserializer) kt.getValueHandler();
            return new MapEntryDeserializer(type, keyDes, valueDeser, vts);
        }
        String clsName = rawType.getName();
        if (rawType.isPrimitive() || clsName.startsWith("java.")) {
            JsonDeserializer<?> deser = NumberDeserializers.find(rawType, clsName);
            if (deser == null) {
                deser = DateDeserializers.find(rawType, clsName);
            }
            if (deser != null) {
                return deser;
            }
        }
        if (rawType == TokenBuffer.class) {
            return new TokenBufferDeserializer();
        }
        JsonDeserializer<?> deser2 = findOptionalStdDeserializer(ctxt, type, beanDesc);
        if (deser2 != null) {
            return deser2;
        }
        return JdkDeserializers.find(rawType, clsName);
    }

    protected JavaType _findRemappedType(DeserializationConfig config, Class<?> rawType) throws JsonMappingException {
        JavaType type = mapAbstractType(config, config.constructType(rawType));
        if (type == null || type.hasRawClass(rawType)) {
            return null;
        }
        return type;
    }

    protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findTreeNodeDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findReferenceDeserializer(type, config, beanDesc, contentTypeDeserializer, contentDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findBeanDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findArrayDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findCollectionLikeDeserializer(type, config, beanDesc, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findEnumDeserializer(type, config, beanDesc);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
        for (Deserializers d : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> deser = d.findMapLikeDeserializer(type, config, beanDesc, keyDeserializer, elementTypeDeserializer, elementDeserializer);
            if (deser != null) {
                return deser;
            }
        }
        return null;
    }

    protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findDeserializer(ann)) != null) {
            return ctxt.deserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findKeyDeserializer(ann)) != null) {
            return ctxt.keyDeserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected JsonDeserializer<Object> findContentDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr != null && (deserDef = intr.findContentDeserializer(ann)) != null) {
            return ctxt.deserializerInstance(ann, deserDef);
        }
        return null;
    }

    protected JavaType resolveMemberAndTypeAnnotations(DeserializationContext ctxt, AnnotatedMember member, JavaType type) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        if (type.isMapLikeType()) {
            JavaType keyType = type.getKeyType();
            if (keyType != null) {
                Object kdDef = intr.findKeyDeserializer(member);
                KeyDeserializer kd = ctxt.keyDeserializerInstance(member, kdDef);
                if (kd != null) {
                    type = ((MapLikeType) type).withKeyValueHandler(kd);
                    type.getKeyType();
                }
            }
        }
        if (type.hasContentType()) {
            Object cdDef = intr.findContentDeserializer(member);
            JsonDeserializer<?> cd = ctxt.deserializerInstance(member, cdDef);
            if (cd != null) {
                type = type.withContentValueHandler(cd);
            }
            TypeDeserializer contentTypeDeser = findPropertyContentTypeDeserializer(ctxt.getConfig(), type, member);
            if (contentTypeDeser != null) {
                type = type.withContentTypeHandler(contentTypeDeser);
            }
        }
        TypeDeserializer valueTypeDeser = findPropertyTypeDeserializer(ctxt.getConfig(), type, member);
        if (valueTypeDeser != null) {
            type = type.withTypeHandler(valueTypeDeser);
        }
        return intr.refineDeserializationType(ctxt.getConfig(), member, type);
    }

    protected EnumResolver constructEnumResolver(Class<?> enumClass, DeserializationConfig config, AnnotatedMember jsonValueAccessor) {
        if (jsonValueAccessor != null) {
            if (config.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(jsonValueAccessor.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return EnumResolver.constructUnsafeUsingMethod(enumClass, jsonValueAccessor, config.getAnnotationIntrospector());
        }
        return EnumResolver.constructUnsafe(enumClass, config.getAnnotationIntrospector());
    }

    protected boolean _hasCreatorAnnotation(DeserializationContext ctxt, Annotated ann) {
        JsonCreator.Mode mode;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        return (intr == null || (mode = intr.findCreatorAnnotation(ctxt.getConfig(), ann)) == null || mode == JsonCreator.Mode.DISABLED) ? false : true;
    }

    @Deprecated
    protected JavaType modifyTypeByAnnotation(DeserializationContext ctxt, Annotated a, JavaType type) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        return intr.refineDeserializationType(ctxt.getConfig(), a, type);
    }

    @Deprecated
    protected JavaType resolveType(DeserializationContext ctxt, BeanDescription beanDesc, JavaType type, AnnotatedMember member) throws JsonMappingException {
        return resolveMemberAndTypeAnnotations(ctxt, member, type);
    }

    @Deprecated
    protected AnnotatedMethod _findJsonValueFor(DeserializationConfig config, JavaType enumType) {
        if (enumType == null) {
            return null;
        }
        BeanDescription beanDesc = config.introspect(enumType);
        return beanDesc.findJsonValueMethod();
    }

    protected static class ContainerDefaultMappings {
        static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
        static final HashMap<String, Class<? extends Map>> _mapFallbacks;

        protected ContainerDefaultMappings() {
        }

        static {
            HashMap<String, Class<? extends Collection>> fallbacks = new HashMap<>();
            fallbacks.put(Collection.class.getName(), ArrayList.class);
            fallbacks.put(List.class.getName(), ArrayList.class);
            fallbacks.put(Set.class.getName(), HashSet.class);
            fallbacks.put(SortedSet.class.getName(), TreeSet.class);
            fallbacks.put(Queue.class.getName(), LinkedList.class);
            fallbacks.put(AbstractList.class.getName(), ArrayList.class);
            fallbacks.put(AbstractSet.class.getName(), HashSet.class);
            fallbacks.put(Deque.class.getName(), LinkedList.class);
            fallbacks.put(NavigableSet.class.getName(), TreeSet.class);
            _collectionFallbacks = fallbacks;
            HashMap<String, Class<? extends Map>> fallbacks2 = new HashMap<>();
            fallbacks2.put(Map.class.getName(), LinkedHashMap.class);
            fallbacks2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            fallbacks2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            fallbacks2.put(SortedMap.class.getName(), TreeMap.class);
            fallbacks2.put(NavigableMap.class.getName(), TreeMap.class);
            fallbacks2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            _mapFallbacks = fallbacks2;
        }

        public static Class<?> findCollectionFallback(JavaType type) {
            return _collectionFallbacks.get(type.getRawClass().getName());
        }

        public static Class<?> findMapFallback(JavaType type) {
            return _mapFallbacks.get(type.getRawClass().getName());
        }
    }
}

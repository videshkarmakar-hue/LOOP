package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;

/* JADX INFO: loaded from: classes18.dex */
public class PropertyBuilder {
    private static final Object NO_DEFAULT_MARKER = Boolean.FALSE;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final BeanDescription _beanDesc;
    protected final SerializationConfig _config;
    protected Object _defaultBean;
    protected final JsonInclude.Value _defaultInclusion;
    protected final boolean _useRealPropertyDefaults;

    public PropertyBuilder(SerializationConfig config, BeanDescription beanDesc) {
        this._config = config;
        this._beanDesc = beanDesc;
        JsonInclude.Value inclPerType = JsonInclude.Value.merge(beanDesc.findPropertyInclusion(JsonInclude.Value.empty()), config.getDefaultPropertyInclusion(beanDesc.getBeanClass(), JsonInclude.Value.empty()));
        this._defaultInclusion = JsonInclude.Value.merge(config.getDefaultPropertyInclusion(), inclPerType);
        this._useRealPropertyDefaults = inclPerType.getValueInclusion() == JsonInclude.Include.NON_DEFAULT;
        this._annotationIntrospector = this._config.getAnnotationIntrospector();
    }

    public Annotations getClassAnnotations() {
        return this._beanDesc.getClassAnnotations();
    }

    protected BeanPropertyWriter buildWriter(SerializerProvider prov, BeanPropertyDefinition propDef, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, TypeSerializer contentTypeSer, AnnotatedMember am, boolean defaultUseStaticTyping) throws JsonMappingException {
        JavaType serializationType;
        JsonInclude.Include inclusion;
        Object valueToSuppress;
        boolean suppressNulls;
        Object defaultBean;
        Class<?>[] views;
        try {
            JavaType serializationType2 = findSerializationType(am, defaultUseStaticTyping, declaredType);
            if (contentTypeSer == null) {
                serializationType = serializationType2;
            } else {
                if (serializationType2 == null) {
                    serializationType2 = declaredType;
                }
                JavaType ct = serializationType2.getContentType();
                if (ct == null) {
                    prov.reportBadPropertyDefinition(this._beanDesc, propDef, "serialization type " + serializationType2 + " has no content", new Object[0]);
                }
                JavaType serializationType3 = serializationType2.withContentTypeHandler(contentTypeSer);
                serializationType3.getContentType();
                serializationType = serializationType3;
            }
            Object valueToSuppress2 = null;
            boolean suppressNulls2 = false;
            JavaType actualType = serializationType == null ? declaredType : serializationType;
            AnnotatedMember accessor = propDef.getAccessor();
            if (accessor == null) {
                return (BeanPropertyWriter) prov.reportBadPropertyDefinition(this._beanDesc, propDef, "could not determine property type", new Object[0]);
            }
            Class<?> rawPropertyType = accessor.getRawType();
            JsonInclude.Value inclV = this._config.getDefaultInclusion(actualType.getRawClass(), rawPropertyType, this._defaultInclusion).withOverrides(propDef.findInclusion());
            JsonInclude.Include inclusion2 = inclV.getValueInclusion();
            if (inclusion2 != JsonInclude.Include.USE_DEFAULTS) {
                inclusion = inclusion2;
            } else {
                inclusion = JsonInclude.Include.ALWAYS;
            }
            switch (inclusion) {
                case NON_DEFAULT:
                    if (this._useRealPropertyDefaults && (defaultBean = getDefaultBean()) != null) {
                        if (prov.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                            am.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        try {
                            Object valueToSuppress3 = am.getValue(defaultBean);
                            valueToSuppress2 = valueToSuppress3;
                        } catch (Exception e) {
                            _throwWrapped(e, propDef.getName(), defaultBean);
                        }
                    } else {
                        Object valueToSuppress4 = BeanUtil.getDefaultValue(actualType);
                        suppressNulls2 = true;
                        valueToSuppress2 = valueToSuppress4;
                    }
                    if (valueToSuppress2 == null) {
                        suppressNulls = true;
                        valueToSuppress = valueToSuppress2;
                    } else if (!valueToSuppress2.getClass().isArray()) {
                        valueToSuppress = valueToSuppress2;
                        suppressNulls = suppressNulls2;
                    } else {
                        valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress2);
                        suppressNulls = suppressNulls2;
                    }
                    break;
                case NON_ABSENT:
                    suppressNulls = true;
                    if (!actualType.isReferenceType()) {
                        valueToSuppress = null;
                    } else {
                        Object valueToSuppress5 = BeanPropertyWriter.MARKER_FOR_EMPTY;
                        valueToSuppress = valueToSuppress5;
                    }
                    break;
                case NON_EMPTY:
                    suppressNulls = true;
                    Object valueToSuppress6 = BeanPropertyWriter.MARKER_FOR_EMPTY;
                    valueToSuppress = valueToSuppress6;
                    break;
                case CUSTOM:
                    Object valueToSuppress7 = prov.includeFilterInstance(propDef, inclV.getValueFilter());
                    if (valueToSuppress7 == null) {
                        suppressNulls = true;
                        valueToSuppress = valueToSuppress7;
                    } else {
                        suppressNulls = prov.includeFilterSuppressNulls(valueToSuppress7);
                        valueToSuppress = valueToSuppress7;
                    }
                    break;
                case NON_NULL:
                    suppressNulls2 = true;
                default:
                    if (actualType.isContainerType() && !this._config.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS)) {
                        Object valueToSuppress8 = BeanPropertyWriter.MARKER_FOR_EMPTY;
                        valueToSuppress = valueToSuppress8;
                        suppressNulls = suppressNulls2;
                    } else {
                        valueToSuppress = null;
                        suppressNulls = suppressNulls2;
                    }
                    break;
            }
            Class<?>[] views2 = propDef.findViews();
            if (views2 != null) {
                views = views2;
            } else {
                views = this._beanDesc.findDefaultViews();
            }
            BeanPropertyWriter bpw = new BeanPropertyWriter(propDef, am, this._beanDesc.getClassAnnotations(), declaredType, ser, typeSer, serializationType, suppressNulls, valueToSuppress, views);
            Object serDef = this._annotationIntrospector.findNullSerializer(am);
            if (serDef != null) {
                bpw.assignNullSerializer(prov.serializerInstance(am, serDef));
            }
            NameTransformer unwrapper = this._annotationIntrospector.findUnwrappingNameTransformer(am);
            return unwrapper != null ? bpw.unwrappingWriter(unwrapper) : bpw;
        } catch (JsonMappingException e2) {
            if (propDef != null) {
                return (BeanPropertyWriter) prov.reportBadPropertyDefinition(this._beanDesc, propDef, ClassUtil.exceptionMessage(e2), new Object[0]);
            }
            return (BeanPropertyWriter) prov.reportBadDefinition(declaredType, ClassUtil.exceptionMessage(e2));
        }
    }

    protected JavaType findSerializationType(Annotated a, boolean useStaticTyping, JavaType declaredType) throws JsonMappingException {
        JavaType secondary = this._annotationIntrospector.refineSerializationType(this._config, a, declaredType);
        if (secondary != declaredType) {
            Class<?> serClass = secondary.getRawClass();
            Class<?> rawDeclared = declaredType.getRawClass();
            if (!serClass.isAssignableFrom(rawDeclared) && !rawDeclared.isAssignableFrom(serClass)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + a.getName() + "': class " + serClass.getName() + " not a super-type of (declared) class " + rawDeclared.getName());
            }
            useStaticTyping = true;
            declaredType = secondary;
        }
        JsonSerialize.Typing typing = this._annotationIntrospector.findSerializationTyping(a);
        if (typing != null && typing != JsonSerialize.Typing.DEFAULT_TYPING) {
            useStaticTyping = typing == JsonSerialize.Typing.STATIC;
        }
        if (useStaticTyping) {
            return declaredType.withStaticTyping();
        }
        return null;
    }

    protected Object getDefaultBean() {
        Object def = this._defaultBean;
        if (def == null) {
            def = this._beanDesc.instantiateBean(this._config.canOverrideAccessModifiers());
            if (def == null) {
                def = NO_DEFAULT_MARKER;
            }
            this._defaultBean = def;
        }
        if (def == NO_DEFAULT_MARKER) {
            return null;
        }
        return this._defaultBean;
    }

    @Deprecated
    protected Object getPropertyDefaultValue(String name, AnnotatedMember member, JavaType type) {
        Object defaultBean = getDefaultBean();
        if (defaultBean == null) {
            return getDefaultValue(type);
        }
        try {
            return member.getValue(defaultBean);
        } catch (Exception e) {
            return _throwWrapped(e, name, defaultBean);
        }
    }

    @Deprecated
    protected Object getDefaultValue(JavaType type) {
        return BeanUtil.getDefaultValue(type);
    }

    protected Object _throwWrapped(Exception e, String propName, Object defaultBean) {
        Throwable t = e;
        while (t.getCause() != null) {
            t = t.getCause();
        }
        ClassUtil.throwIfError(t);
        ClassUtil.throwIfRTE(t);
        throw new IllegalArgumentException("Failed to get property '" + propName + "' of default " + defaultBean.getClass().getName() + " instance");
    }
}

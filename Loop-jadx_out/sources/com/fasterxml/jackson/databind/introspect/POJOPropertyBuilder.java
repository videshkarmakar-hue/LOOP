package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    private static final AnnotationIntrospector.ReferenceProperty NOT_REFEFERENCE_PROP = AnnotationIntrospector.ReferenceProperty.managed("");
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final MapperConfig<?> _config;
    protected Linked<AnnotatedParameter> _ctorParameters;
    protected Linked<AnnotatedField> _fields;
    protected final boolean _forSerialization;
    protected Linked<AnnotatedMethod> _getters;
    protected final PropertyName _internalName;
    protected transient PropertyMetadata _metadata;
    protected final PropertyName _name;
    protected transient AnnotationIntrospector.ReferenceProperty _referenceInfo;
    protected Linked<AnnotatedMethod> _setters;

    private interface WithMember<T> {
        T withMember(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName) {
        this(config, ai, forSerialization, internalName, internalName);
    }

    protected POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName, PropertyName name) {
        this._config = config;
        this._annotationIntrospector = ai;
        this._internalName = internalName;
        this._name = name;
        this._forSerialization = forSerialization;
    }

    protected POJOPropertyBuilder(POJOPropertyBuilder src, PropertyName newName) {
        this._config = src._config;
        this._annotationIntrospector = src._annotationIntrospector;
        this._internalName = src._internalName;
        this._name = newName;
        this._fields = src._fields;
        this._ctorParameters = src._ctorParameters;
        this._getters = src._getters;
        this._setters = src._setters;
        this._forSerialization = src._forSerialization;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public POJOPropertyBuilder withName(PropertyName newName) {
        return new POJOPropertyBuilder(this, newName);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public POJOPropertyBuilder withSimpleName(String newSimpleName) {
        PropertyName newName = this._name.withSimpleName(newSimpleName);
        return newName == this._name ? this : new POJOPropertyBuilder(this, newName);
    }

    @Override // java.lang.Comparable
    public int compareTo(POJOPropertyBuilder other) {
        if (this._ctorParameters != null) {
            if (other._ctorParameters == null) {
                return -1;
            }
        } else if (other._ctorParameters != null) {
            return 1;
        }
        return getName().compareTo(other.getName());
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.util.Named
    public String getName() {
        if (this._name == null) {
            return null;
        }
        return this._name.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyName getFullName() {
        return this._name;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasName(PropertyName name) {
        return this._name.equals(name);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public String getInternalName() {
        return this._internalName.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyName getWrapperName() {
        AnnotatedMember member = getPrimaryMember();
        if (member == null || this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findWrapperName(member);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isExplicitlyIncluded() {
        return _anyExplicits(this._fields) || _anyExplicits(this._getters) || _anyExplicits(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isExplicitlyNamed() {
        return _anyExplicitNames(this._fields) || _anyExplicitNames(this._getters) || _anyExplicitNames(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyMetadata getMetadata() {
        if (this._metadata == null) {
            Boolean b = _findRequired();
            String desc = _findDescription();
            Integer idx = _findIndex();
            String def = _findDefaultValue();
            if (b == null && idx == null && def == null) {
                PropertyMetadata propertyMetadataWithDescription = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
                if (desc != null) {
                    propertyMetadataWithDescription = propertyMetadataWithDescription.withDescription(desc);
                }
                this._metadata = propertyMetadataWithDescription;
            } else {
                this._metadata = PropertyMetadata.construct(b, desc, idx, def);
            }
            if (!this._forSerialization) {
                this._metadata = _getSetterInfo(this._metadata);
            }
        }
        return this._metadata;
    }

    protected PropertyMetadata _getSetterInfo(PropertyMetadata metadata) {
        Boolean b;
        Boolean b2;
        boolean needMerge = true;
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        AnnotatedMember prim = getPrimaryMemberUnchecked();
        AnnotatedMember acc = getAccessor();
        if (prim != null) {
            if (this._annotationIntrospector != null) {
                if (acc != null && (b2 = this._annotationIntrospector.findMergeInfo(prim)) != null) {
                    needMerge = false;
                    if (b2.booleanValue()) {
                        metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForPropertyOverride(acc));
                    }
                }
                JsonSetter.Value setterInfo = this._annotationIntrospector.findSetterInfo(prim);
                if (setterInfo != null) {
                    valueNulls = setterInfo.nonDefaultValueNulls();
                    contentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
            if (needMerge || valueNulls == null || contentNulls == null) {
                Class<?> rawType = _rawTypeOf(prim);
                ConfigOverride co = this._config.getConfigOverride(rawType);
                JsonSetter.Value setterInfo2 = co.getSetterInfo();
                if (setterInfo2 != null) {
                    if (valueNulls == null) {
                        valueNulls = setterInfo2.nonDefaultValueNulls();
                    }
                    if (contentNulls == null) {
                        contentNulls = setterInfo2.nonDefaultContentNulls();
                    }
                }
                if (needMerge && acc != null && (b = co.getMergeable()) != null) {
                    needMerge = false;
                    if (b.booleanValue()) {
                        metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForTypeOverride(acc));
                    }
                }
            }
        }
        if (needMerge || valueNulls == null || contentNulls == null) {
            JsonSetter.Value setterInfo3 = this._config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo3.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo3.nonDefaultContentNulls();
            }
            if (needMerge) {
                Boolean b3 = this._config.getDefaultMergeable();
                if (Boolean.TRUE.equals(b3) && acc != null) {
                    metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForDefaults(acc));
                }
            }
        }
        if (valueNulls != null || contentNulls != null) {
            return metadata.withNulls(valueNulls, contentNulls);
        }
        return metadata;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public JavaType getPrimaryType() {
        if (this._forSerialization) {
            AnnotatedMember m = getGetter();
            if (m == null && (m = getField()) == null) {
                return TypeFactory.unknownType();
            }
            return m.getType();
        }
        AnnotatedMember m2 = getConstructorParameter();
        if (m2 == null) {
            AnnotatedMember m3 = getSetter();
            if (m3 != null) {
                return ((AnnotatedMethod) m3).getParameterType(0);
            }
            m2 = getField();
        }
        if (m2 == null && (m2 = getGetter()) == null) {
            return TypeFactory.unknownType();
        }
        return m2.getType();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Class<?> getRawPrimaryType() {
        return getPrimaryType().getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasGetter() {
        return this._getters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasSetter() {
        return this._setters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasField() {
        return this._fields != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasConstructorParameter() {
        return this._ctorParameters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean couldDeserialize() {
        return (this._ctorParameters == null && this._setters == null && this._fields == null) ? false : true;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean couldSerialize() {
        return (this._getters == null && this._fields == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMethod getGetter() {
        int priNext;
        int priCurr;
        Linked linked = this._getters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class<?> currClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class<?> nextClass = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (currClass != nextClass) {
                if (currClass.isAssignableFrom(nextClass)) {
                    linked = linked2;
                } else if (nextClass.isAssignableFrom(currClass)) {
                    continue;
                } else {
                    priNext = _getterPriority((AnnotatedMethod) linked2.value);
                    priCurr = _getterPriority((AnnotatedMethod) linked.value);
                    if (priNext != priCurr) {
                        if (priNext < priCurr) {
                            linked = linked2;
                        }
                    } else {
                        throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) linked.value).getFullName() + " vs " + ((AnnotatedMethod) linked2.value).getFullName());
                    }
                }
            } else {
                priNext = _getterPriority((AnnotatedMethod) linked2.value);
                priCurr = _getterPriority((AnnotatedMethod) linked.value);
                if (priNext != priCurr) {
                    if (priNext < priCurr) {
                        linked = linked2;
                    }
                } else {
                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) linked.value).getFullName() + " vs " + ((AnnotatedMethod) linked2.value).getFullName());
                }
            }
            linked2 = linked2.next;
        }
        this._getters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x005b A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMethod getSetter() {
        AnnotatedMethod nextM;
        AnnotatedMethod currM;
        int priNext;
        int priCurr;
        AnnotatedMethod pref;
        Linked linked = this._setters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class<?> currClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class<?> nextClass = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (currClass != nextClass) {
                if (currClass.isAssignableFrom(nextClass)) {
                    linked = linked2;
                } else if (nextClass.isAssignableFrom(currClass)) {
                    continue;
                } else {
                    nextM = (AnnotatedMethod) linked2.value;
                    currM = (AnnotatedMethod) linked.value;
                    priNext = _setterPriority(nextM);
                    priCurr = _setterPriority(currM);
                    if (priNext != priCurr) {
                        if (priNext < priCurr) {
                            linked = linked2;
                        }
                    } else {
                        if (this._annotationIntrospector == null) {
                            pref = this._annotationIntrospector.resolveSetterConflict(this._config, currM, nextM);
                            if (pref != currM) {
                                continue;
                            } else if (pref == nextM) {
                                linked = linked2;
                            }
                        }
                        throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", getName(), ((AnnotatedMethod) linked.value).getFullName(), ((AnnotatedMethod) linked2.value).getFullName()));
                    }
                }
            } else {
                nextM = (AnnotatedMethod) linked2.value;
                currM = (AnnotatedMethod) linked.value;
                priNext = _setterPriority(nextM);
                priCurr = _setterPriority(currM);
                if (priNext != priCurr) {
                    if (priNext < priCurr) {
                        linked = linked2;
                    }
                } else {
                    if (this._annotationIntrospector == null) {
                        pref = this._annotationIntrospector.resolveSetterConflict(this._config, currM, nextM);
                        if (pref != currM) {
                            continue;
                        } else if (pref == nextM) {
                            linked = linked2;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", getName(), ((AnnotatedMethod) linked.value).getFullName(), ((AnnotatedMethod) linked2.value).getFullName()));
                }
            }
            linked2 = linked2.next;
        }
        this._setters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedField getField() {
        if (this._fields == null) {
            return null;
        }
        AnnotatedField field = this._fields.value;
        for (Linked linked = this._fields.next; linked != null; linked = linked.next) {
            AnnotatedField nextField = (AnnotatedField) linked.value;
            Class<?> fieldClass = field.getDeclaringClass();
            Class<?> nextClass = nextField.getDeclaringClass();
            if (fieldClass != nextClass) {
                if (fieldClass.isAssignableFrom(nextClass)) {
                    field = nextField;
                } else if (nextClass.isAssignableFrom(fieldClass)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + field.getFullName() + " vs " + nextField.getFullName());
        }
        return field;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedParameter getConstructorParameter() {
        if (this._ctorParameters == null) {
            return null;
        }
        Linked linked = this._ctorParameters;
        while (!(((AnnotatedParameter) linked.value).getOwner() instanceof AnnotatedConstructor)) {
            linked = linked.next;
            if (linked == null) {
                return this._ctorParameters.value;
            }
        }
        return (AnnotatedParameter) linked.value;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Iterator<AnnotatedParameter> getConstructorParameters() {
        if (this._ctorParameters == null) {
            return ClassUtil.emptyIterator();
        }
        return new MemberIterator(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMember getPrimaryMember() {
        if (this._forSerialization) {
            return getAccessor();
        }
        AnnotatedMember m = getMutator();
        if (m == null) {
            return getAccessor();
        }
        return m;
    }

    protected AnnotatedMember getPrimaryMemberUnchecked() {
        if (this._forSerialization) {
            if (this._getters != null) {
                return this._getters.value;
            }
            if (this._fields != null) {
                return this._fields.value;
            }
            return null;
        }
        if (this._ctorParameters != null) {
            return this._ctorParameters.value;
        }
        if (this._setters != null) {
            return this._setters.value;
        }
        if (this._fields != null) {
            return this._fields.value;
        }
        if (this._getters != null) {
            return this._getters.value;
        }
        return null;
    }

    protected int _getterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            return (!name.startsWith("is") || name.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    protected int _setterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (name.startsWith("set") && name.length() > 3) {
            return 1;
        }
        return 2;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Class<?>[] findViews() {
        return (Class[]) fromMemberAnnotations(new WithMember<Class<?>[]>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.1
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Class<?>[] withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findViews(member);
            }
        });
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotationIntrospector.ReferenceProperty findReferenceType() {
        AnnotationIntrospector.ReferenceProperty result = this._referenceInfo;
        if (result != null) {
            if (result == NOT_REFEFERENCE_PROP) {
                return null;
            }
            return result;
        }
        AnnotationIntrospector.ReferenceProperty result2 = (AnnotationIntrospector.ReferenceProperty) fromMemberAnnotations(new WithMember<AnnotationIntrospector.ReferenceProperty>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findReferenceType(member);
            }
        });
        this._referenceInfo = result2 == null ? NOT_REFEFERENCE_PROP : result2;
        return result2;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isTypeId() {
        Boolean b = (Boolean) fromMemberAnnotations(new WithMember<Boolean>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Boolean withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.isTypeId(member);
            }
        });
        return b != null && b.booleanValue();
    }

    protected Boolean _findRequired() {
        return (Boolean) fromMemberAnnotations(new WithMember<Boolean>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Boolean withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.hasRequiredMarker(member);
            }
        });
    }

    protected String _findDescription() {
        return (String) fromMemberAnnotations(new WithMember<String>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.5
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public String withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDescription(member);
            }
        });
    }

    protected Integer _findIndex() {
        return (Integer) fromMemberAnnotations(new WithMember<Integer>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Integer withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyIndex(member);
            }
        });
    }

    protected String _findDefaultValue() {
        return (String) fromMemberAnnotations(new WithMember<String>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.7
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public String withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDefaultValue(member);
            }
        });
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public ObjectIdInfo findObjectIdInfo() {
        return (ObjectIdInfo) fromMemberAnnotations(new WithMember<ObjectIdInfo>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public ObjectIdInfo withMember(AnnotatedMember member) {
                ObjectIdInfo info = POJOPropertyBuilder.this._annotationIntrospector.findObjectIdInfo(member);
                if (info != null) {
                    return POJOPropertyBuilder.this._annotationIntrospector.findObjectReferenceInfo(member, info);
                }
                return info;
            }
        });
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public JsonInclude.Value findInclusion() {
        AnnotatedMember a = getAccessor();
        JsonInclude.Value v = this._annotationIntrospector == null ? null : this._annotationIntrospector.findPropertyInclusion(a);
        return v == null ? JsonInclude.Value.empty() : v;
    }

    public JsonProperty.Access findAccess() {
        return (JsonProperty.Access) fromMemberAnnotationsExcept(new WithMember<JsonProperty.Access>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public JsonProperty.Access withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyAccess(member);
            }
        }, JsonProperty.Access.AUTO);
    }

    public void addField(AnnotatedField a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._fields = new Linked<>(a, this._fields, name, explName, visible, ignored);
    }

    public void addCtor(AnnotatedParameter a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._ctorParameters = new Linked<>(a, this._ctorParameters, name, explName, visible, ignored);
    }

    public void addGetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._getters = new Linked<>(a, this._getters, name, explName, visible, ignored);
    }

    public void addSetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._setters = new Linked<>(a, this._setters, name, explName, visible, ignored);
    }

    public void addAll(POJOPropertyBuilder src) {
        this._fields = merge(this._fields, src._fields);
        this._ctorParameters = merge(this._ctorParameters, src._ctorParameters);
        this._getters = merge(this._getters, src._getters);
        this._setters = merge(this._setters, src._setters);
    }

    private static <T> Linked<T> merge(Linked<T> chain1, Linked<T> chain2) {
        if (chain1 == null) {
            return chain2;
        }
        if (chain2 == null) {
            return chain1;
        }
        return chain1.append(chain2);
    }

    public void removeIgnored() {
        this._fields = _removeIgnored(this._fields);
        this._getters = _removeIgnored(this._getters);
        this._setters = _removeIgnored(this._setters);
        this._ctorParameters = _removeIgnored(this._ctorParameters);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public JsonProperty.Access removeNonVisible(boolean inferMutators) {
        JsonProperty.Access acc = findAccess();
        if (acc == null) {
            acc = JsonProperty.Access.AUTO;
        }
        switch (acc) {
            case READ_ONLY:
                this._setters = null;
                this._ctorParameters = null;
                if (!this._forSerialization) {
                    this._fields = null;
                }
                return acc;
            case READ_WRITE:
                return acc;
            case WRITE_ONLY:
                this._getters = null;
                if (this._forSerialization) {
                    this._fields = null;
                }
                return acc;
            default:
                this._getters = _removeNonVisible(this._getters);
                this._ctorParameters = _removeNonVisible(this._ctorParameters);
                if (!inferMutators || this._getters == null) {
                    this._fields = _removeNonVisible(this._fields);
                    this._setters = _removeNonVisible(this._setters);
                }
                return acc;
        }
    }

    public void removeConstructors() {
        this._ctorParameters = null;
    }

    public void trimByVisibility() {
        this._fields = _trimByVisibility(this._fields);
        this._getters = _trimByVisibility(this._getters);
        this._setters = _trimByVisibility(this._setters);
        this._ctorParameters = _trimByVisibility(this._ctorParameters);
    }

    public void mergeAnnotations(boolean forSerialization) {
        if (forSerialization) {
            if (this._getters != null) {
                AnnotationMap ann = _mergeAnnotations(0, this._getters, this._fields, this._ctorParameters, this._setters);
                this._getters = _applyAnnotations(this._getters, ann);
                return;
            } else {
                if (this._fields != null) {
                    AnnotationMap ann2 = _mergeAnnotations(0, this._fields, this._ctorParameters, this._setters);
                    this._fields = _applyAnnotations(this._fields, ann2);
                    return;
                }
                return;
            }
        }
        if (this._ctorParameters != null) {
            AnnotationMap ann3 = _mergeAnnotations(0, this._ctorParameters, this._setters, this._fields, this._getters);
            this._ctorParameters = _applyAnnotations(this._ctorParameters, ann3);
        } else if (this._setters != null) {
            AnnotationMap ann4 = _mergeAnnotations(0, this._setters, this._fields, this._getters);
            this._setters = _applyAnnotations(this._setters, ann4);
        } else if (this._fields != null) {
            AnnotationMap ann5 = _mergeAnnotations(0, this._fields, this._getters);
            this._fields = _applyAnnotations(this._fields, ann5);
        }
    }

    private AnnotationMap _mergeAnnotations(int index, Linked<? extends AnnotatedMember>... nodes) {
        AnnotationMap ann = _getAllAnnotations(nodes[index]);
        do {
            index++;
            if (index >= nodes.length) {
                return ann;
            }
        } while (nodes[index] == null);
        return AnnotationMap.merge(ann, _mergeAnnotations(index, nodes));
    }

    private <T extends AnnotatedMember> AnnotationMap _getAllAnnotations(Linked<T> node) {
        AnnotationMap ann = node.value.getAllAnnotations();
        if (node.next != null) {
            return AnnotationMap.merge(ann, _getAllAnnotations(node.next));
        }
        return ann;
    }

    private <T extends AnnotatedMember> Linked<T> _applyAnnotations(Linked<T> linked, AnnotationMap annotationMap) {
        AnnotatedMember annotatedMember = (AnnotatedMember) linked.value.withAnnotations(annotationMap);
        Linked<T> linked2 = linked.next;
        Linked linkedWithNext = linked;
        if (linked2 != null) {
            linkedWithNext = linked.withNext(_applyAnnotations(linked.next, annotationMap));
        }
        return linkedWithNext.withValue(annotatedMember);
    }

    private <T> Linked<T> _removeIgnored(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutIgnored();
    }

    private <T> Linked<T> _removeNonVisible(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutNonVisible();
    }

    private <T> Linked<T> _trimByVisibility(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.trimByVisibility();
    }

    private <T> boolean _anyExplicits(Linked<T> n) {
        while (n != null) {
            if (n.name == null || !n.name.hasSimpleName()) {
                n = n.next;
            } else {
                return true;
            }
        }
        return false;
    }

    private <T> boolean _anyExplicitNames(Linked<T> n) {
        while (n != null) {
            if (n.name == null || !n.isNameExplicit) {
                n = n.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean anyVisible() {
        return _anyVisible(this._fields) || _anyVisible(this._getters) || _anyVisible(this._setters) || _anyVisible(this._ctorParameters);
    }

    private <T> boolean _anyVisible(Linked<T> n) {
        while (n != null) {
            if (!n.isVisible) {
                n = n.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean anyIgnorals() {
        return _anyIgnorals(this._fields) || _anyIgnorals(this._getters) || _anyIgnorals(this._setters) || _anyIgnorals(this._ctorParameters);
    }

    private <T> boolean _anyIgnorals(Linked<T> n) {
        while (n != null) {
            if (!n.isMarkedIgnored) {
                n = n.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public Set<PropertyName> findExplicitNames() {
        Set<PropertyName> renamed = _findExplicitNames(this._fields, null);
        Set<PropertyName> renamed2 = _findExplicitNames(this._ctorParameters, _findExplicitNames(this._setters, _findExplicitNames(this._getters, renamed)));
        if (renamed2 == null) {
            return Collections.emptySet();
        }
        return renamed2;
    }

    public Collection<POJOPropertyBuilder> explode(Collection<PropertyName> newNames) {
        HashMap<PropertyName, POJOPropertyBuilder> props = new HashMap<>();
        _explode(newNames, props, this._fields);
        _explode(newNames, props, this._getters);
        _explode(newNames, props, this._setters);
        _explode(newNames, props, this._ctorParameters);
        return props.values();
    }

    private void _explode(Collection<PropertyName> newNames, Map<PropertyName, POJOPropertyBuilder> props, Linked<?> accessors) {
        for (Linked linked = accessors; linked != null; linked = linked.next) {
            PropertyName name = linked.name;
            if (!linked.isNameExplicit || name == null) {
                if (linked.isVisible) {
                    throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name '" + this._name + "'): found multiple explicit names: " + newNames + ", but also implicit accessor: " + linked);
                }
            } else {
                POJOPropertyBuilder prop = props.get(name);
                if (prop == null) {
                    prop = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, this._internalName, name);
                    props.put(name, prop);
                }
                if (accessors != this._fields) {
                    if (accessors != this._getters) {
                        if (accessors != this._setters) {
                            if (accessors == this._ctorParameters) {
                                prop._ctorParameters = linked.withNext(prop._ctorParameters);
                            } else {
                                throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                            }
                        } else {
                            prop._setters = linked.withNext(prop._setters);
                        }
                    } else {
                        prop._getters = linked.withNext(prop._getters);
                    }
                } else {
                    prop._fields = linked.withNext(prop._fields);
                }
            }
        }
    }

    private Set<PropertyName> _findExplicitNames(Linked<? extends AnnotatedMember> linked, Set<PropertyName> set) {
        for (Linked linked2 = linked; linked2 != null; linked2 = linked2.next) {
            if (linked2.isNameExplicit && linked2.name != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(linked2.name);
            }
        }
        return set;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Property '").append(this._name).append("'; ctors: ").append(this._ctorParameters).append(", field(s): ").append(this._fields).append(", getter(s): ").append(this._getters).append(", setter(s): ").append(this._setters);
        sb.append("]");
        return sb.toString();
    }

    protected <T> T fromMemberAnnotations(WithMember<T> func) {
        T result = null;
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            if (this._getters != null) {
                result = func.withMember(this._getters.value);
            }
        } else {
            if (this._ctorParameters != null) {
                result = func.withMember(this._ctorParameters.value);
            }
            if (result == null && this._setters != null) {
                result = func.withMember(this._setters.value);
            }
        }
        if (result == null && this._fields != null) {
            return func.withMember(this._fields.value);
        }
        return result;
    }

    protected <T> T fromMemberAnnotationsExcept(WithMember<T> func, T defaultValue) {
        T result;
        T result2;
        T result3;
        T result4;
        T result5;
        T result6;
        T result7;
        T result8;
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            if (this._getters != null && (result8 = func.withMember(this._getters.value)) != null && result8 != defaultValue) {
                return result8;
            }
            if (this._fields != null && (result7 = func.withMember(this._fields.value)) != null && result7 != defaultValue) {
                return result7;
            }
            if (this._ctorParameters != null && (result6 = func.withMember(this._ctorParameters.value)) != null && result6 != defaultValue) {
                return result6;
            }
            if (this._setters == null || (result5 = func.withMember(this._setters.value)) == null || result5 == defaultValue) {
                return null;
            }
            return result5;
        }
        if (this._ctorParameters != null && (result4 = func.withMember(this._ctorParameters.value)) != null && result4 != defaultValue) {
            return result4;
        }
        if (this._setters != null && (result3 = func.withMember(this._setters.value)) != null && result3 != defaultValue) {
            return result3;
        }
        if (this._fields != null && (result2 = func.withMember(this._fields.value)) != null && result2 != defaultValue) {
            return result2;
        }
        if (this._getters == null || (result = func.withMember(this._getters.value)) == null || result == defaultValue) {
            return null;
        }
        return result;
    }

    protected Class<?> _rawTypeOf(AnnotatedMember m) {
        if (m instanceof AnnotatedMethod) {
            AnnotatedMethod meh = (AnnotatedMethod) m;
            if (meh.getParameterCount() > 0) {
                return meh.getParameterType(0).getRawClass();
            }
        }
        return m.getType().getRawClass();
    }

    protected static class MemberIterator<T extends AnnotatedMember> implements Iterator<T> {
        private Linked<T> next;

        public MemberIterator(Linked<T> first) {
            this.next = first;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            T result = this.next.value;
            this.next = this.next.next;
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected static final class Linked<T> {
        public final boolean isMarkedIgnored;
        public final boolean isNameExplicit;
        public final boolean isVisible;
        public final PropertyName name;
        public final Linked<T> next;
        public final T value;

        public Linked(T v, Linked<T> n, PropertyName name, boolean explName, boolean visible, boolean ignored) {
            this.value = v;
            this.next = n;
            this.name = (name == null || name.isEmpty()) ? null : name;
            if (explName) {
                if (this.name == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!name.hasSimpleName()) {
                    explName = false;
                }
            }
            this.isNameExplicit = explName;
            this.isVisible = visible;
            this.isMarkedIgnored = ignored;
        }

        public Linked<T> withoutNext() {
            if (this.next == null) {
                return this;
            }
            return new Linked<>(this.value, null, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withValue(T newValue) {
            if (newValue == this.value) {
                return this;
            }
            return new Linked<>(newValue, this.next, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withNext(Linked<T> newNext) {
            if (newNext == this.next) {
                return this;
            }
            return new Linked<>(this.value, newNext, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withoutIgnored() {
            Linked<T> newNext;
            if (this.isMarkedIgnored) {
                if (this.next == null) {
                    return null;
                }
                return this.next.withoutIgnored();
            }
            if (this.next != null && (newNext = this.next.withoutIgnored()) != this.next) {
                return withNext(newNext);
            }
            return this;
        }

        public Linked<T> withoutNonVisible() {
            Linked<T> newNext = this.next == null ? null : this.next.withoutNonVisible();
            return this.isVisible ? withNext(newNext) : newNext;
        }

        protected Linked<T> append(Linked<T> appendable) {
            if (this.next == null) {
                return withNext(appendable);
            }
            return withNext(this.next.append(appendable));
        }

        public Linked<T> trimByVisibility() {
            if (this.next == null) {
                return this;
            }
            Linked<T> newNext = this.next.trimByVisibility();
            if (this.name != null) {
                if (newNext.name == null) {
                    return withNext(null);
                }
                return withNext(newNext);
            }
            if (newNext.name != null) {
                return newNext;
            }
            if (this.isVisible == newNext.isVisible) {
                return withNext(newNext);
            }
            return this.isVisible ? withNext(null) : newNext;
        }

        public String toString() {
            String msg = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.value.toString(), Boolean.valueOf(this.isVisible), Boolean.valueOf(this.isMarkedIgnored), Boolean.valueOf(this.isNameExplicit));
            if (this.next != null) {
                return msg + ", " + this.next.toString();
            }
            return msg;
        }
    }
}

package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    /* JADX INFO: renamed from: com.fasterxml.jackson.annotation.JsonTypeInfo$As */
    public enum EnumC2614As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    @Deprecated
    public static abstract class None {
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    EnumC2614As include() default EnumC2614As.PROPERTY;

    String property() default "";

    EnumC2615Id use();

    boolean visible() default false;

    /* JADX INFO: renamed from: com.fasterxml.jackson.annotation.JsonTypeInfo$Id */
    public enum EnumC2615Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        CUSTOM(null);

        private final String _defaultPropertyName;

        EnumC2615Id(String defProp) {
            this._defaultPropertyName = defProp;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }
}

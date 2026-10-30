package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> generator;

    /* JADX INFO: renamed from: id */
    public Object f367id;
    protected boolean idWritten = false;

    public WritableObjectId(ObjectIdGenerator<?> generator) {
        this.generator = generator;
    }

    public boolean writeAsId(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        if (this.f367id == null) {
            return false;
        }
        if (this.idWritten || w.alwaysAsId) {
            if (gen.canWriteObjectId()) {
                gen.writeObjectRef(String.valueOf(this.f367id));
                return true;
            }
            w.serializer.serialize(this.f367id, gen, provider);
            return true;
        }
        return false;
    }

    public Object generateId(Object forPojo) {
        if (this.f367id == null) {
            this.f367id = this.generator.generateId(forPojo);
        }
        return this.f367id;
    }

    public void writeAsField(JsonGenerator gen, SerializerProvider provider, ObjectIdWriter w) throws IOException {
        this.idWritten = true;
        if (gen.canWriteObjectId()) {
            String idStr = this.f367id == null ? null : String.valueOf(this.f367id);
            gen.writeObjectId(idStr);
            return;
        }
        SerializableString name = w.propertyName;
        if (name != null) {
            gen.writeFieldName(name);
            w.serializer.serialize(this.f367id, gen, provider);
        }
    }
}

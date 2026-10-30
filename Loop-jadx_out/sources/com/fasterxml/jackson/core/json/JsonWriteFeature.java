package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonGenerator;

/* JADX INFO: loaded from: classes.dex */
public enum JsonWriteFeature implements FormatFeature {
    QUOTE_FIELD_NAMES(true, JsonGenerator.Feature.QUOTE_FIELD_NAMES),
    WRITE_NAN_AS_STRINGS(true, JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS),
    WRITE_NUMBERS_AS_STRINGS(false, JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS),
    ESCAPE_NON_ASCII(false, JsonGenerator.Feature.ESCAPE_NON_ASCII);

    private final boolean _defaultState;
    private final JsonGenerator.Feature _mappedFeature;
    private final int _mask = 1 << ordinal();

    public static int collectDefaults() {
        int flags = 0;
        for (JsonWriteFeature f : values()) {
            if (f.enabledByDefault()) {
                flags |= f.getMask();
            }
        }
        return flags;
    }

    JsonWriteFeature(boolean defaultState, JsonGenerator.Feature mapTo) {
        this._defaultState = defaultState;
        this._mappedFeature = mapTo;
    }

    @Override // com.fasterxml.jackson.core.FormatFeature
    public boolean enabledByDefault() {
        return this._defaultState;
    }

    @Override // com.fasterxml.jackson.core.FormatFeature
    public int getMask() {
        return this._mask;
    }

    @Override // com.fasterxml.jackson.core.FormatFeature
    public boolean enabledIn(int flags) {
        return (this._mask & flags) != 0;
    }

    public JsonGenerator.Feature mappedFeature() {
        return this._mappedFeature;
    }
}

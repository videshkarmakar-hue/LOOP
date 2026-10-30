package com.fasterxml.jackson.core;

import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public enum JsonEncoding {
    UTF8(CharsetNames.UTF_8, false, 8),
    UTF16_BE(CharsetNames.UTF_16BE, true, 16),
    UTF16_LE(CharsetNames.UTF_16LE, false, 16),
    UTF32_BE("UTF-32BE", true, 32),
    UTF32_LE("UTF-32LE", false, 32);

    private final boolean _bigEndian;
    private final int _bits;
    private final String _javaName;

    JsonEncoding(String javaName, boolean bigEndian, int bits) {
        this._javaName = javaName;
        this._bigEndian = bigEndian;
        this._bits = bits;
    }

    public String getJavaName() {
        return this._javaName;
    }

    public boolean isBigEndian() {
        return this._bigEndian;
    }

    public int bits() {
        return this._bits;
    }
}

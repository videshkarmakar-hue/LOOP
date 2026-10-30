package com.fasterxml.jackson.core;

import java.io.Serializable;
import java.nio.charset.Charset;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public class JsonLocation implements Serializable {
    public static final int MAX_CONTENT_SNIPPET = 500;

    /* JADX INFO: renamed from: NA */
    public static final JsonLocation f346NA = new JsonLocation(null, -1, -1, -1, -1);
    private static final long serialVersionUID = 1;
    protected final int _columnNr;
    protected final int _lineNr;
    final transient Object _sourceRef;
    protected final long _totalBytes;
    protected final long _totalChars;

    public JsonLocation(Object srcRef, long totalChars, int lineNr, int colNr) {
        this(srcRef, -1L, totalChars, lineNr, colNr);
    }

    public JsonLocation(Object sourceRef, long totalBytes, long totalChars, int lineNr, int columnNr) {
        this._sourceRef = sourceRef;
        this._totalBytes = totalBytes;
        this._totalChars = totalChars;
        this._lineNr = lineNr;
        this._columnNr = columnNr;
    }

    public Object getSourceRef() {
        return this._sourceRef;
    }

    public int getLineNr() {
        return this._lineNr;
    }

    public int getColumnNr() {
        return this._columnNr;
    }

    public long getCharOffset() {
        return this._totalChars;
    }

    public long getByteOffset() {
        return this._totalBytes;
    }

    public String sourceDescription() {
        return _appendSourceDesc(new StringBuilder(100)).toString();
    }

    public int hashCode() {
        int hash = this._sourceRef == null ? 1 : this._sourceRef.hashCode();
        return (((hash ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof JsonLocation)) {
            return false;
        }
        JsonLocation otherLoc = (JsonLocation) other;
        if (this._sourceRef == null) {
            if (otherLoc._sourceRef != null) {
                return false;
            }
        } else if (!this._sourceRef.equals(otherLoc._sourceRef)) {
            return false;
        }
        return this._lineNr == otherLoc._lineNr && this._columnNr == otherLoc._columnNr && this._totalChars == otherLoc._totalChars && getByteOffset() == otherLoc.getByteOffset();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        _appendSourceDesc(sb);
        sb.append("; line: ");
        sb.append(this._lineNr);
        sb.append(", column: ");
        sb.append(this._columnNr);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    protected StringBuilder _appendSourceDesc(StringBuilder sb) {
        int len;
        Object srcRef = this._sourceRef;
        if (srcRef == null) {
            sb.append("UNKNOWN");
            return sb;
        }
        Class<?> srcType = srcRef instanceof Class ? (Class) srcRef : srcRef.getClass();
        String tn = srcType.getName();
        if (tn.startsWith("java.")) {
            tn = srcType.getSimpleName();
        } else if (srcRef instanceof byte[]) {
            tn = "byte[]";
        } else if (srcRef instanceof char[]) {
            tn = "char[]";
        }
        sb.append('(').append(tn).append(')');
        String charStr = " chars";
        if (srcRef instanceof CharSequence) {
            CharSequence cs = (CharSequence) srcRef;
            int len2 = cs.length();
            len = len2 - _append(sb, cs.subSequence(0, Math.min(len2, 500)).toString());
        } else if (srcRef instanceof char[]) {
            char[] ch = (char[]) srcRef;
            int len3 = ch.length;
            len = len3 - _append(sb, new String(ch, 0, Math.min(len3, 500)));
        } else if (srcRef instanceof byte[]) {
            byte[] b = (byte[]) srcRef;
            int maxLen = Math.min(b.length, 500);
            _append(sb, new String(b, 0, maxLen, Charset.forName(CharsetNames.UTF_8)));
            len = b.length - maxLen;
            charStr = " bytes";
        } else {
            len = 0;
        }
        if (len > 0) {
            sb.append("[truncated ").append(len).append(charStr).append(AbstractJsonLexerKt.END_LIST);
        }
        return sb;
    }

    private int _append(StringBuilder sb, String content) {
        sb.append('\"').append(content).append('\"');
        return content.length();
    }
}

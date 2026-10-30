package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p005io.CharTypes;
import com.fasterxml.jackson.core.p005io.CharacterEscapes;
import com.fasterxml.jackson.core.p005io.IOContext;
import com.fasterxml.jackson.core.p005io.NumberOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte BYTE_0 = 48;
    private static final byte BYTE_BACKSLASH = 92;
    private static final byte BYTE_COLON = 58;
    private static final byte BYTE_COMMA = 44;
    private static final byte BYTE_LBRACKET = 91;
    private static final byte BYTE_LCURLY = 123;
    private static final byte BYTE_RBRACKET = 93;
    private static final byte BYTE_RCURLY = 125;
    private static final int MAX_BYTES_TO_BUFFER = 512;
    protected boolean _bufferRecyclable;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _entityBuffer;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail;
    protected byte _quoteChar;
    private static final byte[] HEX_CHARS = CharTypes.copyHexBytes();
    private static final byte BYTE_u = 117;
    private static final byte[] NULL_BYTES = {110, BYTE_u, 108, 108};
    private static final byte[] TRUE_BYTES = {116, 114, BYTE_u, 101};
    private static final byte[] FALSE_BYTES = {102, 97, 108, 115, 101};

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, char quoteChar) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._quoteChar = (byte) quoteChar;
        if (quoteChar != '\"') {
            this._outputEscapes = CharTypes.get7BitOutputEscapes(quoteChar);
        }
        this._bufferRecyclable = true;
        this._outputBuffer = ctxt.allocWriteEncodingBuffer();
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, char quoteChar, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._quoteChar = (byte) quoteChar;
        if (quoteChar != '\"') {
            this._outputEscapes = CharTypes.get7BitOutputEscapes(quoteChar);
        }
        this._bufferRecyclable = bufferRecyclable;
        this._outputTail = outputOffset;
        this._outputBuffer = outputBuffer;
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
    }

    @Deprecated
    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out) {
        this(ctxt, features, codec, out, '\"');
    }

    @Deprecated
    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable) {
        this(ctxt, features, codec, out, '\"', outputBuffer, outputOffset, bufferRecyclable);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._outputStream;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this._outputTail;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String name) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(name);
            return;
        }
        int status = this._writeContext.writeFieldName(name);
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(name, false);
            return;
        }
        int len = name.length();
        if (len > this._charBufferLength) {
            _writeStringSegments(name, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
        if (len <= this._outputMaxContiguous) {
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(name, 0, len);
        } else {
            _writeStringSegments(name, 0, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString name) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(name);
            return;
        }
        int status = this._writeContext.writeFieldName(name.getValue());
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        if (this._cfgUnqNames) {
            _writeUnq(name);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
        int len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(name.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr3[i3] = this._quoteChar;
    }

    private final void _writeUnq(SerializableString name) throws IOException {
        int len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(name.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(int size) throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RBRACKET;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object forValue) throws IOException {
        _verifyValueWrite("start an object");
        JsonWriteContext ctxt = this._writeContext.createChildObjectContext(forValue);
        this._writeContext = ctxt;
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RCURLY;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    protected final void _writePPFieldName(String name) throws IOException {
        int status = this._writeContext.writeFieldName(name);
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (status == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(name, false);
            return;
        }
        int len = name.length();
        if (len > this._charBufferLength) {
            _writeStringSegments(name, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        name.getChars(0, len, this._charBuffer, 0);
        if (len <= this._outputMaxContiguous) {
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(this._charBuffer, 0, len);
        } else {
            _writeStringSegments(this._charBuffer, 0, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    protected final void _writePPFieldName(SerializableString name) throws IOException {
        int status = this._writeContext.writeFieldName(name.getValue());
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (status == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        boolean addQuotes = true ^ this._cfgUnqNames;
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = this._quoteChar;
        }
        int len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(name.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = this._quoteChar;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String text) throws IOException {
        _verifyValueWrite("write a string");
        if (text == null) {
            _writeNull();
            return;
        }
        int len = text.length();
        if (len > this._outputMaxContiguous) {
            _writeStringSegments(text, true);
            return;
        }
        if (this._outputTail + len >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        _writeStringSegment(text, 0, len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int len) throws IOException {
        _verifyValueWrite("write a string");
        if (reader == null) {
            _reportError("null reader");
        }
        int toRead = len >= 0 ? len : Integer.MAX_VALUE;
        char[] buf = this._charBuffer;
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        while (toRead > 0) {
            int toReadNow = Math.min(toRead, buf.length);
            int numRead = reader.read(buf, 0, toReadNow);
            if (numRead <= 0) {
                break;
            }
            if (this._outputTail + len >= this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegments(buf, 0, numRead);
            toRead -= numRead;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
        if (toRead > 0 && len >= 0) {
            _reportError("Didn't read enough from reader");
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] text, int offset, int len) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        if (len <= this._outputMaxContiguous) {
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(text, offset, len);
        } else {
            _writeStringSegments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString text) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        int len = text.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(text.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] text, int offset, int length) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        _writeBytes(text, offset, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] text, int offset, int len) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        if (len <= this._outputMaxContiguous) {
            _writeUTF8Segment(text, offset, len);
        } else {
            _writeUTF8Segments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String text) throws IOException {
        int len = text.length();
        char[] buf = this._charBuffer;
        if (len <= buf.length) {
            text.getChars(0, len, buf, 0);
            writeRaw(buf, 0, len);
        } else {
            writeRaw(text, 0, len);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String text, int offset, int len) throws IOException {
        char ch;
        char[] buf = this._charBuffer;
        int cbufLen = buf.length;
        if (len <= cbufLen) {
            text.getChars(offset, offset + len, buf, 0);
            writeRaw(buf, 0, len);
            return;
        }
        int maxChunk = Math.min(cbufLen, (this._outputEnd >> 2) + (this._outputEnd >> 4));
        int maxBytes = maxChunk * 3;
        while (len > 0) {
            int len2 = Math.min(maxChunk, len);
            text.getChars(offset, offset + len2, buf, 0);
            if (this._outputTail + maxBytes > this._outputEnd) {
                _flushBuffer();
            }
            if (len2 > 1 && (ch = buf[len2 - 1]) >= 55296 && ch <= 56319) {
                len2--;
            }
            _writeRawSegment(buf, 0, len2);
            offset += len2;
            len -= len2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString text) throws IOException {
        int len = text.appendUnquotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(text.asUnquotedUTF8());
        } else {
            this._outputTail += len;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(SerializableString text) throws IOException {
        _verifyValueWrite("write a raw (unencoded) value");
        int len = text.appendUnquotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(text.asUnquotedUTF8());
        } else {
            this._outputTail += len;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeRaw(char[] cbuf, int offset, int len) throws IOException {
        int len3 = len + len + len;
        if (this._outputTail + len3 > this._outputEnd) {
            if (this._outputEnd < len3) {
                _writeSegmentedRaw(cbuf, offset, len);
                return;
            }
            _flushBuffer();
        }
        int len2 = len + offset;
        while (offset < len2) {
            do {
                char c = cbuf[offset];
                if (c <= 127) {
                    byte[] bArr = this._outputBuffer;
                    int i = this._outputTail;
                    this._outputTail = i + 1;
                    bArr[i] = (byte) c;
                    offset++;
                } else {
                    int ch = offset + 1;
                    char ch2 = cbuf[offset];
                    if (ch2 < 2048) {
                        byte[] bArr2 = this._outputBuffer;
                        int i2 = this._outputTail;
                        this._outputTail = i2 + 1;
                        bArr2[i2] = (byte) ((ch2 >> 6) | 192);
                        byte[] bArr3 = this._outputBuffer;
                        int i3 = this._outputTail;
                        this._outputTail = i3 + 1;
                        bArr3[i3] = (byte) ((ch2 & '?') | 128);
                        offset = ch;
                    } else {
                        offset = _outputRawMultiByteChar(ch2, cbuf, ch, len2);
                    }
                }
            } while (offset < len2);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char ch) throws IOException {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        if (ch <= 127) {
            int i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ch;
        } else {
            if (ch < 2048) {
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bbuf[i2] = (byte) ((ch >> 6) | 192);
                int i3 = this._outputTail;
                this._outputTail = i3 + 1;
                bbuf[i3] = (byte) ((ch & '?') | 128);
                return;
            }
            _outputRawMultiByteChar(ch, null, 0, 0);
        }
    }

    private final void _writeSegmentedRaw(char[] cbuf, int offset, int len) throws IOException {
        int end = this._outputEnd;
        byte[] bbuf = this._outputBuffer;
        int inputEnd = offset + len;
        while (offset < inputEnd) {
            do {
                char c = cbuf[offset];
                if (c < 128) {
                    if (this._outputTail >= end) {
                        _flushBuffer();
                    }
                    int i = this._outputTail;
                    this._outputTail = i + 1;
                    bbuf[i] = (byte) c;
                    offset++;
                } else {
                    if (this._outputTail + 3 >= this._outputEnd) {
                        _flushBuffer();
                    }
                    int offset2 = offset + 1;
                    char ch = cbuf[offset];
                    if (ch < 2048) {
                        int i2 = this._outputTail;
                        this._outputTail = i2 + 1;
                        bbuf[i2] = (byte) ((ch >> 6) | 192);
                        int i3 = this._outputTail;
                        this._outputTail = i3 + 1;
                        bbuf[i3] = (byte) (128 | (ch & '?'));
                        offset = offset2;
                    } else {
                        offset = _outputRawMultiByteChar(ch, cbuf, offset2, inputEnd);
                    }
                }
            } while (offset < inputEnd);
            return;
        }
    }

    private void _writeRawSegment(char[] cbuf, int offset, int end) throws IOException {
        while (offset < end) {
            do {
                char c = cbuf[offset];
                if (c <= 127) {
                    byte[] bArr = this._outputBuffer;
                    int i = this._outputTail;
                    this._outputTail = i + 1;
                    bArr[i] = (byte) c;
                    offset++;
                } else {
                    int ch = offset + 1;
                    char ch2 = cbuf[offset];
                    if (ch2 < 2048) {
                        byte[] bArr2 = this._outputBuffer;
                        int i2 = this._outputTail;
                        this._outputTail = i2 + 1;
                        bArr2[i2] = (byte) ((ch2 >> 6) | 192);
                        byte[] bArr3 = this._outputBuffer;
                        int i3 = this._outputTail;
                        this._outputTail = i3 + 1;
                        bArr3[i3] = (byte) ((ch2 & '?') | 128);
                        offset = ch;
                    } else {
                        int offset2 = _outputRawMultiByteChar(ch2, cbuf, ch, end);
                        offset = offset2;
                    }
                }
            } while (offset < end);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len) throws IOException {
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        _writeBinary(b64variant, data, offset, offset + len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength) throws IOException {
        int missing;
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        byte[] encodingBuffer = this._ioContext.allocBase64Buffer();
        try {
            if (dataLength < 0) {
                missing = _writeBinary(b64variant, data, encodingBuffer);
            } else {
                int missing2 = _writeBinary(b64variant, data, encodingBuffer, dataLength);
                if (missing2 > 0) {
                    _reportError("Too few bytes available: missing " + missing2 + " bytes (out of " + dataLength + ")");
                }
                missing = dataLength;
            }
            this._ioContext.releaseBase64Buffer(encodingBuffer);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = this._quoteChar;
            return missing;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(encodingBuffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s) throws IOException {
        _verifyValueWrite("write a number");
        if (this._outputTail + 6 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedShort(s);
        } else {
            this._outputTail = NumberOutput.outputInt(s, this._outputBuffer, this._outputTail);
        }
    }

    private final void _writeQuotedShort(short s) throws IOException {
        if (this._outputTail + 8 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        this._outputTail = NumberOutput.outputInt(s, this._outputBuffer, this._outputTail);
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write a number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    private final void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = this._quoteChar;
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        byte[] bArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr2[i3] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long l) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(l);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
    }

    private final void _writeQuotedLong(long l) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger value) throws IOException {
        _verifyValueWrite("write a number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(value.toString());
        } else {
            writeRaw(value.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        if (this._cfgNumbersAsStrings || (NumberOutput.notFinite(d) && JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            writeString(String.valueOf(d));
        } else {
            _verifyValueWrite("write a number");
            writeRaw(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        if (this._cfgNumbersAsStrings || (NumberOutput.notFinite(f) && JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            writeString(String.valueOf(f));
        } else {
            _verifyValueWrite("write a number");
            writeRaw(String.valueOf(f));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal value) throws IOException {
        _verifyValueWrite("write a number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(_asString(value));
        } else {
            writeRaw(_asString(value));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String encodedValue) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(encodedValue);
        } else {
            writeRaw(encodedValue);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(char[] encodedValueBuffer, int offset, int length) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(encodedValueBuffer, offset, length);
        } else {
            writeRaw(encodedValueBuffer, offset, length);
        }
    }

    private final void _writeQuotedRaw(String value) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        writeRaw(value);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    private void _writeQuotedRaw(char[] text, int offset, int length) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = this._quoteChar;
        writeRaw(text, offset, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean state) throws IOException {
        _verifyValueWrite("write a boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] keyword = state ? TRUE_BYTES : FALSE_BYTES;
        int len = keyword.length;
        System.arraycopy(keyword, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write a null");
        _writeNull();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected final void _verifyValueWrite(String typeMsg) throws IOException {
        byte b;
        int status = this._writeContext.writeValue();
        if (this._cfgPrettyPrinter != null) {
            _verifyPrettyValueWrite(typeMsg, status);
            return;
        }
        switch (status) {
            case 1:
                b = BYTE_COMMA;
                break;
            case 2:
                b = BYTE_COLON;
                break;
            case 3:
                if (this._rootValueSeparator != null) {
                    byte[] raw = this._rootValueSeparator.asUnquotedUTF8();
                    if (raw.length > 0) {
                        _writeBytes(raw);
                        return;
                    }
                    return;
                }
                return;
            case 4:
            default:
                return;
            case 5:
                _reportCantWriteValueExpectName(typeMsg);
                return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        _flushBuffer();
        if (this._outputStream != null && isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._outputStream.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext ctxt = getOutputContext();
                if (ctxt.inArray()) {
                    writeEndArray();
                } else if (!ctxt.inObject()) {
                    break;
                } else {
                    writeEndObject();
                }
            }
        }
        _flushBuffer();
        this._outputTail = 0;
        if (this._outputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._outputStream.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._outputStream.flush();
            }
        }
        _releaseBuffers();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected void _releaseBuffers() {
        byte[] buf = this._outputBuffer;
        if (buf != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(buf);
        }
        char[] cbuf = this._charBuffer;
        if (cbuf != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cbuf);
        }
    }

    private final void _writeBytes(byte[] bytes) throws IOException {
        int len = bytes.length;
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, 0, len);
                return;
            }
        }
        System.arraycopy(bytes, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeBytes(byte[] bytes, int offset, int len) throws IOException {
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, offset, len);
                return;
            }
        }
        System.arraycopy(bytes, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeStringSegments(String text, boolean addQuotes) throws IOException {
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = this._quoteChar;
        }
        int left = text.length();
        int offset = 0;
        while (left > 0) {
            int len = Math.min(this._outputMaxContiguous, left);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(text, offset, len);
            offset += len;
            left -= len;
        }
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = this._quoteChar;
        }
    }

    private final void _writeStringSegments(char[] cbuf, int offset, int totalLen) throws IOException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cbuf, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private final void _writeStringSegments(String text, int offset, int totalLen) throws IOException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(text, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private final void _writeStringSegment(char[] cbuf, int offset, int len) throws IOException {
        int len2 = len + offset;
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        while (offset < len2) {
            char c = cbuf[offset];
            if (c > 127 || escCodes[c] != 0) {
                break;
            }
            outputBuffer[outputPtr] = (byte) c;
            offset++;
            outputPtr++;
        }
        this._outputTail = outputPtr;
        if (offset < len2) {
            if (this._characterEscapes != null) {
                _writeCustomStringSegment2(cbuf, offset, len2);
            } else if (this._maximumNonEscapedChar == 0) {
                _writeStringSegment2(cbuf, offset, len2);
            } else {
                _writeStringSegmentASCII2(cbuf, offset, len2);
            }
        }
    }

    private final void _writeStringSegment(String text, int offset, int len) throws IOException {
        int len2 = len + offset;
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        while (offset < len2) {
            int ch = text.charAt(offset);
            if (ch > 127 || escCodes[ch] != 0) {
                break;
            }
            outputBuffer[outputPtr] = (byte) ch;
            offset++;
            outputPtr++;
        }
        this._outputTail = outputPtr;
        if (offset < len2) {
            if (this._characterEscapes != null) {
                _writeCustomStringSegment2(text, offset, len2);
            } else if (this._maximumNonEscapedChar == 0) {
                _writeStringSegment2(text, offset, len2);
            } else {
                _writeStringSegmentASCII2(text, offset, len2);
            }
        }
    }

    private final void _writeStringSegment2(char[] cbuf, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        while (offset < end) {
            offset++;
            char c = cbuf[offset];
            if (c <= 127) {
                if (escCodes[c] == 0) {
                    outputBuffer[outputPtr] = (byte) c;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[c];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else {
                        outputPtr = _writeGenericEscape(c, outputPtr);
                    }
                }
            } else if (c <= 2047) {
                int outputPtr4 = outputPtr + 1;
                outputBuffer[outputPtr] = (byte) ((c >> 6) | 192);
                outputPtr = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) ((c & '?') | 128);
            } else {
                outputPtr = _outputMultiByteChar(c, outputPtr);
            }
        }
        this._outputTail = outputPtr;
    }

    private final void _writeStringSegment2(String text, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        while (offset < end) {
            offset++;
            int ch = text.charAt(offset);
            if (ch <= 127) {
                if (escCodes[ch] == 0) {
                    outputBuffer[outputPtr] = (byte) ch;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[ch];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else {
                        outputPtr = _writeGenericEscape(ch, outputPtr);
                    }
                }
            } else if (ch <= 2047) {
                int outputPtr4 = outputPtr + 1;
                outputBuffer[outputPtr] = (byte) ((ch >> 6) | 192);
                outputPtr = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) ((ch & 63) | 128);
            } else {
                outputPtr = _outputMultiByteChar(ch, outputPtr);
            }
        }
        this._outputTail = outputPtr;
    }

    private final void _writeStringSegmentASCII2(char[] cbuf, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar;
        while (offset < end) {
            offset++;
            char c = cbuf[offset];
            if (c <= 127) {
                if (escCodes[c] == 0) {
                    outputBuffer[outputPtr] = (byte) c;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[c];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else {
                        outputPtr = _writeGenericEscape(c, outputPtr);
                    }
                }
            } else if (c > maxUnescaped) {
                outputPtr = _writeGenericEscape(c, outputPtr);
            } else if (c <= 2047) {
                int outputPtr4 = outputPtr + 1;
                outputBuffer[outputPtr] = (byte) ((c >> 6) | 192);
                outputPtr = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) ((c & '?') | 128);
            } else {
                outputPtr = _outputMultiByteChar(c, outputPtr);
            }
        }
        this._outputTail = outputPtr;
    }

    private final void _writeStringSegmentASCII2(String text, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar;
        while (offset < end) {
            offset++;
            int ch = text.charAt(offset);
            if (ch <= 127) {
                if (escCodes[ch] == 0) {
                    outputBuffer[outputPtr] = (byte) ch;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[ch];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else {
                        outputPtr = _writeGenericEscape(ch, outputPtr);
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr = _writeGenericEscape(ch, outputPtr);
            } else if (ch <= 2047) {
                int outputPtr4 = outputPtr + 1;
                outputBuffer[outputPtr] = (byte) ((ch >> 6) | 192);
                outputPtr = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) ((ch & 63) | 128);
            } else {
                outputPtr = _outputMultiByteChar(ch, outputPtr);
            }
        }
        this._outputTail = outputPtr;
    }

    private final void _writeCustomStringSegment2(char[] cbuf, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar <= 0 ? 65535 : this._maximumNonEscapedChar;
        CharacterEscapes customEscapes = this._characterEscapes;
        while (offset < end) {
            offset++;
            char c = cbuf[offset];
            if (c <= 127) {
                if (escCodes[c] == 0) {
                    outputBuffer[outputPtr] = (byte) c;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[c];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else if (outputPtr2 == -2) {
                        SerializableString esc = customEscapes.getEscapeSequence(c);
                        if (esc == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c) + ", although was supposed to have one");
                        }
                        outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
                    } else {
                        outputPtr = _writeGenericEscape(c, outputPtr);
                    }
                }
            } else if (c > maxUnescaped) {
                outputPtr = _writeGenericEscape(c, outputPtr);
            } else {
                SerializableString esc2 = customEscapes.getEscapeSequence(c);
                if (esc2 != null) {
                    outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc2, end - offset);
                } else if (c <= 2047) {
                    int outputPtr4 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) ((c >> 6) | 192);
                    outputPtr = outputPtr4 + 1;
                    outputBuffer[outputPtr4] = (byte) ((c & '?') | 128);
                } else {
                    outputPtr = _outputMultiByteChar(c, outputPtr);
                }
            }
        }
        this._outputTail = outputPtr;
    }

    private final void _writeCustomStringSegment2(String text, int offset, int end) throws IOException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar <= 0 ? 65535 : this._maximumNonEscapedChar;
        CharacterEscapes customEscapes = this._characterEscapes;
        while (offset < end) {
            offset++;
            int ch = text.charAt(offset);
            if (ch <= 127) {
                if (escCodes[ch] == 0) {
                    outputBuffer[outputPtr] = (byte) ch;
                    outputPtr++;
                } else {
                    int outputPtr2 = escCodes[ch];
                    if (outputPtr2 > 0) {
                        int outputPtr3 = outputPtr + 1;
                        outputBuffer[outputPtr] = BYTE_BACKSLASH;
                        outputPtr = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) outputPtr2;
                    } else if (outputPtr2 == -2) {
                        SerializableString esc = customEscapes.getEscapeSequence(ch);
                        if (esc == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(ch) + ", although was supposed to have one");
                        }
                        outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
                    } else {
                        outputPtr = _writeGenericEscape(ch, outputPtr);
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr = _writeGenericEscape(ch, outputPtr);
            } else {
                SerializableString esc2 = customEscapes.getEscapeSequence(ch);
                if (esc2 != null) {
                    outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc2, end - offset);
                } else if (ch <= 2047) {
                    int outputPtr4 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) ((ch >> 6) | 192);
                    outputPtr = outputPtr4 + 1;
                    outputBuffer[outputPtr4] = (byte) ((ch & 63) | 128);
                } else {
                    outputPtr = _outputMultiByteChar(ch, outputPtr);
                }
            }
        }
        this._outputTail = outputPtr;
    }

    private final int _writeCustomEscape(byte[] outputBuffer, int outputPtr, SerializableString esc, int remainingChars) throws IOException {
        byte[] raw = esc.asUnquotedUTF8();
        int len = raw.length;
        if (len > 6) {
            return _handleLongCustomEscape(outputBuffer, outputPtr, this._outputEnd, raw, remainingChars);
        }
        System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
        return outputPtr + len;
    }

    private final int _handleLongCustomEscape(byte[] outputBuffer, int outputPtr, int outputEnd, byte[] raw, int remainingChars) throws IOException {
        int len = raw.length;
        if (outputPtr + len > outputEnd) {
            this._outputTail = outputPtr;
            _flushBuffer();
            outputPtr = this._outputTail;
            if (len > outputBuffer.length) {
                this._outputStream.write(raw, 0, len);
                return outputPtr;
            }
        }
        System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
        int outputPtr2 = outputPtr + len;
        if ((remainingChars * 6) + outputPtr2 > outputEnd) {
            this._outputTail = outputPtr2;
            _flushBuffer();
            return this._outputTail;
        }
        return outputPtr2;
    }

    private final void _writeUTF8Segments(byte[] utf8, int offset, int totalLen) throws IOException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            _writeUTF8Segment(utf8, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private final void _writeUTF8Segment(byte[] utf8, int offset, int len) throws IOException {
        int[] escCodes = this._outputEscapes;
        int ch = offset;
        int end = offset + len;
        while (ch < end) {
            int ptr = ch + 1;
            int ch2 = utf8[ch];
            if (ch2 >= 0 && escCodes[ch2] != 0) {
                _writeUTF8Segment2(utf8, offset, len);
                return;
            }
            ch = ptr;
        }
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(utf8, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeUTF8Segment2(byte[] utf8, int offset, int len) throws IOException {
        int outputPtr = this._outputTail;
        if ((len * 6) + outputPtr > this._outputEnd) {
            _flushBuffer();
            outputPtr = this._outputTail;
        }
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int len2 = len + offset;
        while (offset < len2) {
            offset++;
            byte b = utf8[offset];
            if (b < 0 || escCodes[b] == 0) {
                outputBuffer[outputPtr] = b;
                outputPtr++;
            } else {
                int escape = escCodes[b];
                if (escape > 0) {
                    int outputPtr2 = outputPtr + 1;
                    outputBuffer[outputPtr] = BYTE_BACKSLASH;
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) escape;
                } else {
                    outputPtr = _writeGenericEscape(b, outputPtr);
                }
            }
        }
        this._outputTail = outputPtr;
    }

    protected final void _writeBinary(Base64Variant b64variant, byte[] input, int b24, int inputEnd) throws IOException {
        int inputPtr;
        int safeInputEnd = inputEnd - 3;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (b24 <= safeInputEnd) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = b24 + 1;
            int inputPtr3 = inputPtr2 + 1;
            int inputPtr4 = inputPtr3 + 1;
            this._outputTail = b64variant.encodeBase64Chunk((((input[b24] << 8) | (input[inputPtr2] & 255)) << 8) | (input[inputPtr3] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            b24 = inputPtr4;
        }
        int inputLeft = inputEnd - b24;
        if (inputLeft > 0) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr5 = b24 + 1;
            int b25 = input[b24] << 16;
            if (inputLeft != 2) {
                inputPtr = inputPtr5;
            } else {
                inputPtr = inputPtr5 + 1;
                b25 |= (input[inputPtr5] & 255) << 8;
            }
            this._outputTail = b64variant.encodeBase64Partial(b25, inputLeft, this._outputBuffer, this._outputTail);
        }
    }

    protected final int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft) throws IOException {
        int inputEnd;
        int amount;
        int safeOutputEnd = this._outputEnd - 6;
        int bytesLeft2 = bytesLeft;
        int inputPtr = 0;
        int inputEnd2 = 0;
        int lastFullOffset = -3;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (bytesLeft2 > 2) {
            if (inputPtr > lastFullOffset) {
                inputEnd2 = _readMore(data, readBuffer, inputPtr, inputEnd2, bytesLeft2);
                inputPtr = 0;
                if (inputEnd2 < 3) {
                    break;
                }
                lastFullOffset = inputEnd2 - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            int b24 = readBuffer[inputPtr] << 8;
            int inputPtr3 = inputPtr2 + 1;
            inputPtr = inputPtr3 + 1;
            bytesLeft2 -= 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr2] & 255) | b24) << 8) | (readBuffer[inputPtr3] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
        }
        if (bytesLeft2 > 0 && (inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd2, bytesLeft2)) > 0) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr4 = 0 + 1;
            int b25 = readBuffer[0] << 16;
            if (inputPtr4 < inputEnd) {
                b25 |= (readBuffer[inputPtr4] & UByte.MAX_VALUE) << 8;
                amount = 2;
            } else {
                amount = 1;
            }
            this._outputTail = b64variant.encodeBase64Partial(b25, amount, this._outputBuffer, this._outputTail);
            return bytesLeft2 - amount;
        }
        return bytesLeft2;
    }

    protected final int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer) throws IOException {
        int inputPtr = 0;
        int inputEnd = 0;
        int lastFullOffset = -3;
        int bytesDone = 0;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (true) {
            if (inputPtr > lastFullOffset) {
                inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, readBuffer.length);
                inputPtr = 0;
                if (inputEnd < 3) {
                    break;
                }
                lastFullOffset = inputEnd - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            int inputPtr3 = inputPtr2 + 1;
            int inputPtr4 = inputPtr3 + 1;
            bytesDone += 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr] << 8) | (readBuffer[inputPtr2] & 255)) << 8) | (readBuffer[inputPtr3] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr = inputPtr4;
        }
        if (0 < inputEnd) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr5 = 0 + 1;
            int inputPtr6 = readBuffer[0];
            int b24 = inputPtr6 << 16;
            int amount = 1;
            if (inputPtr5 < inputEnd) {
                b24 |= (readBuffer[inputPtr5] & UByte.MAX_VALUE) << 8;
                amount = 2;
            }
            int bytesDone2 = bytesDone + amount;
            this._outputTail = b64variant.encodeBase64Partial(b24, amount, this._outputBuffer, this._outputTail);
            return bytesDone2;
        }
        return bytesDone;
    }

    private final int _readMore(InputStream in, byte[] readBuffer, int inputPtr, int inputEnd, int maxRead) throws IOException {
        int i = 0;
        while (inputPtr < inputEnd) {
            readBuffer[i] = readBuffer[inputPtr];
            i++;
            inputPtr++;
        }
        int inputEnd2 = i;
        int maxRead2 = Math.min(maxRead, readBuffer.length);
        do {
            int length = maxRead2 - inputEnd2;
            if (length == 0) {
                break;
            }
            int count = in.read(readBuffer, inputEnd2, length);
            if (count < 0) {
                return inputEnd2;
            }
            inputEnd2 += count;
        } while (inputEnd2 < 3);
        return inputEnd2;
    }

    private final int _outputRawMultiByteChar(int ch, char[] cbuf, int inputOffset, int inputEnd) throws IOException {
        if (ch >= 55296 && ch <= 57343) {
            if (inputOffset >= inputEnd || cbuf == null) {
                _reportError(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(ch)));
            }
            _outputSurrogates(ch, cbuf[inputOffset]);
            return inputOffset + 1;
        }
        byte[] bbuf = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) ((ch >> 12) | 224);
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bbuf[i2] = (byte) (((ch >> 6) & 63) | 128);
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bbuf[i3] = (byte) ((ch & 63) | 128);
        return inputOffset;
    }

    protected final void _outputSurrogates(int surr1, int surr2) throws IOException {
        int c = _decodeSurrogate(surr1, surr2);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) ((c >> 18) | 240);
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bbuf[i2] = (byte) (((c >> 12) & 63) | 128);
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bbuf[i3] = (byte) (((c >> 6) & 63) | 128);
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bbuf[i4] = (byte) ((c & 63) | 128);
    }

    private final int _outputMultiByteChar(int ch, int outputPtr) throws IOException {
        byte[] bbuf = this._outputBuffer;
        if (ch >= 55296 && ch <= 57343) {
            int outputPtr2 = outputPtr + 1;
            bbuf[outputPtr] = BYTE_BACKSLASH;
            int outputPtr3 = outputPtr2 + 1;
            bbuf[outputPtr2] = BYTE_u;
            int outputPtr4 = outputPtr3 + 1;
            bbuf[outputPtr3] = HEX_CHARS[(ch >> 12) & 15];
            int outputPtr5 = outputPtr4 + 1;
            bbuf[outputPtr4] = HEX_CHARS[(ch >> 8) & 15];
            int outputPtr6 = outputPtr5 + 1;
            bbuf[outputPtr5] = HEX_CHARS[(ch >> 4) & 15];
            int outputPtr7 = outputPtr6 + 1;
            bbuf[outputPtr6] = HEX_CHARS[ch & 15];
            return outputPtr7;
        }
        int outputPtr8 = outputPtr + 1;
        bbuf[outputPtr] = (byte) ((ch >> 12) | 224);
        int outputPtr9 = outputPtr8 + 1;
        bbuf[outputPtr8] = (byte) (((ch >> 6) & 63) | 128);
        int outputPtr10 = outputPtr9 + 1;
        bbuf[outputPtr9] = (byte) ((ch & 63) | 128);
        return outputPtr10;
    }

    private final void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private int _writeGenericEscape(int charToEscape, int outputPtr) throws IOException {
        int outputPtr2;
        byte[] bbuf = this._outputBuffer;
        int outputPtr3 = outputPtr + 1;
        bbuf[outputPtr] = BYTE_BACKSLASH;
        int outputPtr4 = outputPtr3 + 1;
        bbuf[outputPtr3] = BYTE_u;
        if (charToEscape > 255) {
            int hi = 255 & (charToEscape >> 8);
            int outputPtr5 = outputPtr4 + 1;
            bbuf[outputPtr4] = HEX_CHARS[hi >> 4];
            outputPtr2 = outputPtr5 + 1;
            bbuf[outputPtr5] = HEX_CHARS[hi & 15];
            charToEscape &= 255;
        } else {
            int outputPtr6 = outputPtr4 + 1;
            bbuf[outputPtr4] = 48;
            outputPtr2 = outputPtr6 + 1;
            bbuf[outputPtr6] = 48;
        }
        int outputPtr7 = outputPtr2 + 1;
        bbuf[outputPtr2] = HEX_CHARS[charToEscape >> 4];
        int outputPtr8 = outputPtr7 + 1;
        bbuf[outputPtr7] = HEX_CHARS[charToEscape & 15];
        return outputPtr8;
    }

    protected final void _flushBuffer() throws IOException {
        int len = this._outputTail;
        if (len > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, len);
        }
    }
}

package com.fasterxml.jackson.core.p005io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    private final IOContext _context;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd;
    private int _outPtr = 0;
    private int _surrogate;

    public UTF8Writer(IOContext ctxt, OutputStream out) {
        this._context = ctxt;
        this._out = out;
        this._outBuffer = ctxt.allocWriteEncodingBuffer();
        this._outBufferEnd = this._outBuffer.length - 4;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            OutputStream out = this._out;
            this._out = null;
            byte[] buf = this._outBuffer;
            if (buf != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(buf);
            }
            out.close();
            int code = this._surrogate;
            this._surrogate = 0;
            if (code > 0) {
                illegalSurrogate(code);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int outPtr, int len) throws IOException {
        if (len < 2) {
            if (len == 1) {
                write(cbuf[outPtr]);
                return;
            }
            return;
        }
        if (this._surrogate > 0) {
            int off = outPtr + 1;
            char second = cbuf[outPtr];
            len--;
            write(convertSurrogate(second));
            outPtr = off;
        }
        int outPtr2 = this._outPtr;
        byte[] outBuf = this._outBuffer;
        int outBufLast = this._outBufferEnd;
        int len2 = len + outPtr;
        while (outPtr < len2) {
            if (outPtr2 >= outBufLast) {
                this._out.write(outBuf, 0, outPtr2);
                outPtr2 = 0;
            }
            int off2 = outPtr + 1;
            char c = cbuf[outPtr];
            if (c < 128) {
                int outPtr3 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) c;
                int maxInCount = len2 - off2;
                int maxOutCount = outBufLast - outPtr3;
                if (maxInCount > maxOutCount) {
                    maxInCount = maxOutCount;
                }
                int maxInCount2 = maxInCount + off2;
                outPtr = off2;
                while (true) {
                    if (outPtr >= maxInCount2) {
                        outPtr2 = outPtr3;
                    } else {
                        off2 = outPtr + 1;
                        char c2 = cbuf[outPtr];
                        if (c2 >= 128) {
                            c = c2;
                            outPtr2 = outPtr3;
                        } else {
                            outBuf[outPtr3] = (byte) c2;
                            outPtr3++;
                            outPtr = off2;
                        }
                    }
                }
            }
            if (c < 2048) {
                int outPtr4 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((c >> 6) | 192);
                outPtr2 = outPtr4 + 1;
                outBuf[outPtr4] = (byte) (128 | (c & '?'));
                outPtr = off2;
            } else if (c < 55296 || c > 57343) {
                int outPtr5 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((c >> '\f') | 224);
                int outPtr6 = outPtr5 + 1;
                outBuf[outPtr5] = (byte) (((c >> 6) & 63) | 128);
                outBuf[outPtr6] = (byte) (128 | (c & '?'));
                outPtr = off2;
                outPtr2 = outPtr6 + 1;
            } else {
                if (c > 56319) {
                    this._outPtr = outPtr2;
                    illegalSurrogate(c);
                }
                this._surrogate = c;
                if (off2 >= len2) {
                    break;
                }
                int off3 = off2 + 1;
                int c3 = convertSurrogate(cbuf[off2]);
                if (c3 > 1114111) {
                    this._outPtr = outPtr2;
                    illegalSurrogate(c3);
                }
                int outPtr7 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((c3 >> 18) | 240);
                int outPtr8 = outPtr7 + 1;
                outBuf[outPtr7] = (byte) (((c3 >> 12) & 63) | 128);
                int outPtr9 = outPtr8 + 1;
                outBuf[outPtr8] = (byte) (((c3 >> 6) & 63) | 128);
                outPtr2 = outPtr9 + 1;
                outBuf[outPtr9] = (byte) (128 | (c3 & 63));
                outPtr = off3;
            }
        }
        this._outPtr = outPtr2;
    }

    @Override // java.io.Writer
    public void write(int c) throws IOException {
        int ptr;
        if (this._surrogate > 0) {
            c = convertSurrogate(c);
        } else if (c >= 55296 && c <= 57343) {
            if (c > 56319) {
                illegalSurrogate(c);
            }
            this._surrogate = c;
            return;
        }
        if (this._outPtr >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, this._outPtr);
            this._outPtr = 0;
        }
        if (c < 128) {
            byte[] bArr = this._outBuffer;
            int i = this._outPtr;
            this._outPtr = i + 1;
            bArr[i] = (byte) c;
            return;
        }
        int ptr2 = this._outPtr;
        if (c < 2048) {
            int ptr3 = ptr2 + 1;
            this._outBuffer[ptr2] = (byte) ((c >> 6) | 192);
            ptr = ptr3 + 1;
            this._outBuffer[ptr3] = (byte) (128 | (c & 63));
        } else if (c <= 65535) {
            int ptr4 = ptr2 + 1;
            this._outBuffer[ptr2] = (byte) ((c >> 12) | 224);
            int ptr5 = ptr4 + 1;
            this._outBuffer[ptr4] = (byte) (((c >> 6) & 63) | 128);
            this._outBuffer[ptr5] = (byte) (128 | (c & 63));
            ptr = ptr5 + 1;
        } else {
            if (c > 1114111) {
                illegalSurrogate(c);
            }
            int ptr6 = ptr2 + 1;
            this._outBuffer[ptr2] = (byte) ((c >> 18) | 240);
            int ptr7 = ptr6 + 1;
            this._outBuffer[ptr6] = (byte) (((c >> 12) & 63) | 128);
            int ptr8 = ptr7 + 1;
            this._outBuffer[ptr7] = (byte) (((c >> 6) & 63) | 128);
            ptr = ptr8 + 1;
            this._outBuffer[ptr8] = (byte) (128 | (c & 63));
        }
        this._outPtr = ptr;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int outPtr, int len) throws IOException {
        if (len < 2) {
            if (len == 1) {
                write(str.charAt(outPtr));
                return;
            }
            return;
        }
        if (this._surrogate > 0) {
            int off = outPtr + 1;
            char second = str.charAt(outPtr);
            len--;
            write(convertSurrogate(second));
            outPtr = off;
        }
        int outPtr2 = this._outPtr;
        byte[] outBuf = this._outBuffer;
        int outBufLast = this._outBufferEnd;
        int len2 = len + outPtr;
        while (outPtr < len2) {
            if (outPtr2 >= outBufLast) {
                this._out.write(outBuf, 0, outPtr2);
                outPtr2 = 0;
            }
            int off2 = outPtr + 1;
            int outPtr3 = str.charAt(outPtr);
            if (outPtr3 < 128) {
                int outPtr4 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) outPtr3;
                int maxInCount = len2 - off2;
                int maxOutCount = outBufLast - outPtr4;
                if (maxInCount > maxOutCount) {
                    maxInCount = maxOutCount;
                }
                int maxInCount2 = maxInCount + off2;
                outPtr = off2;
                while (true) {
                    if (outPtr >= maxInCount2) {
                        outPtr2 = outPtr4;
                    } else {
                        off2 = outPtr + 1;
                        int c = str.charAt(outPtr);
                        if (c >= 128) {
                            outPtr3 = c;
                            outPtr2 = outPtr4;
                        } else {
                            outBuf[outPtr4] = (byte) c;
                            outPtr4++;
                            outPtr = off2;
                        }
                    }
                }
            }
            if (outPtr3 < 2048) {
                int outPtr5 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((outPtr3 >> 6) | 192);
                outPtr2 = outPtr5 + 1;
                outBuf[outPtr5] = (byte) (128 | (outPtr3 & 63));
                outPtr = off2;
            } else if (outPtr3 < 55296 || outPtr3 > 57343) {
                int outPtr6 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((outPtr3 >> 12) | 224);
                int outPtr7 = outPtr6 + 1;
                outBuf[outPtr6] = (byte) (((outPtr3 >> 6) & 63) | 128);
                outBuf[outPtr7] = (byte) (128 | (outPtr3 & 63));
                outPtr = off2;
                outPtr2 = outPtr7 + 1;
            } else {
                if (outPtr3 > 56319) {
                    this._outPtr = outPtr2;
                    illegalSurrogate(outPtr3);
                }
                this._surrogate = outPtr3;
                if (off2 >= len2) {
                    break;
                }
                int off3 = off2 + 1;
                int c2 = convertSurrogate(str.charAt(off2));
                if (c2 > 1114111) {
                    this._outPtr = outPtr2;
                    illegalSurrogate(c2);
                }
                int outPtr8 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((c2 >> 18) | 240);
                int outPtr9 = outPtr8 + 1;
                outBuf[outPtr8] = (byte) (((c2 >> 12) & 63) | 128);
                int outPtr10 = outPtr9 + 1;
                outBuf[outPtr9] = (byte) (((c2 >> 6) & 63) | 128);
                outPtr2 = outPtr10 + 1;
                outBuf[outPtr10] = (byte) (128 | (c2 & 63));
                outPtr = off3;
            }
        }
        this._outPtr = outPtr2;
    }

    protected int convertSurrogate(int secondPart) throws IOException {
        int firstPart = this._surrogate;
        this._surrogate = 0;
        if (secondPart >= 56320 && secondPart <= 57343) {
            return ((firstPart - 55296) << 10) + 65536 + (secondPart - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(firstPart) + ", second 0x" + Integer.toHexString(secondPart) + "; illegal combination");
    }

    protected static void illegalSurrogate(int code) throws IOException {
        throw new IOException(illegalSurrogateDesc(code));
    }

    protected static String illegalSurrogateDesc(int code) {
        if (code > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(code) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (code >= 55296) {
            if (code <= 56319) {
                return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(code) + ")";
            }
            return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(code) + ")";
        }
        return "Illegal character point (0x" + Integer.toHexString(code) + ") to output";
    }
}

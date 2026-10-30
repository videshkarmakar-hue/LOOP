package com.fasterxml.jackson.core.p005io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class JsonStringEncoder {
    private static final int INITIAL_BYTE_BUFFER_SIZE = 200;
    private static final int INITIAL_CHAR_BUFFER_SIZE = 120;
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;

    /* JADX INFO: renamed from: HC */
    private static final char[] f350HC = CharTypes.copyHexChars();

    /* JADX INFO: renamed from: HB */
    private static final byte[] f349HB = CharTypes.copyHexBytes();
    private static final JsonStringEncoder instance = new JsonStringEncoder();

    public static JsonStringEncoder getInstance() {
        return instance;
    }

    public char[] quoteAsString(String input) {
        int length;
        char[] outputBuffer = new char[120];
        int[] escCodes = CharTypes.get7BitOutputEscapes();
        int escCodeCount = escCodes.length;
        int inPtr = 0;
        int inputLen = input.length();
        TextBuffer textBuffer = null;
        int outPtr = 0;
        char[] qbuf = null;
        loop0: while (inPtr < inputLen) {
            while (true) {
                char c = input.charAt(inPtr);
                if (c >= escCodeCount || escCodes[c] == 0) {
                    if (outPtr >= outputBuffer.length) {
                        if (textBuffer == null) {
                            textBuffer = TextBuffer.fromInitial(outputBuffer);
                        }
                        outputBuffer = textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    int outPtr2 = outPtr + 1;
                    outputBuffer[outPtr] = c;
                    inPtr++;
                    if (inPtr >= inputLen) {
                        outPtr = outPtr2;
                        break loop0;
                    }
                    outPtr = outPtr2;
                }
            }
            if (qbuf == null) {
                qbuf = _qbuf();
            }
            int inPtr2 = inPtr + 1;
            char d = input.charAt(inPtr);
            int escCode = escCodes[d];
            if (escCode < 0) {
                length = _appendNumeric(d, qbuf);
            } else {
                length = _appendNamed(escCode, qbuf);
            }
            if (outPtr + length > outputBuffer.length) {
                int first = outputBuffer.length - outPtr;
                if (first > 0) {
                    System.arraycopy(qbuf, 0, outputBuffer, outPtr, first);
                }
                if (textBuffer == null) {
                    textBuffer = TextBuffer.fromInitial(outputBuffer);
                }
                outputBuffer = textBuffer.finishCurrentSegment();
                int second = length - first;
                System.arraycopy(qbuf, first, outputBuffer, 0, second);
                outPtr = second;
            } else {
                System.arraycopy(qbuf, 0, outputBuffer, outPtr, length);
                outPtr += length;
            }
            inPtr = inPtr2;
        }
        if (textBuffer == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outPtr);
        }
        textBuffer.setCurrentLength(outPtr);
        return textBuffer.contentsAsArray();
    }

    public char[] quoteAsString(CharSequence input) {
        int length;
        if (input instanceof String) {
            return quoteAsString((String) input);
        }
        TextBuffer textBuffer = null;
        char[] outputBuffer = new char[120];
        int[] escCodes = CharTypes.get7BitOutputEscapes();
        int escCodeCount = escCodes.length;
        int inPtr = 0;
        int inputLen = input.length();
        int outPtr = 0;
        char[] qbuf = null;
        loop0: while (inPtr < inputLen) {
            while (true) {
                char c = input.charAt(inPtr);
                if (c >= escCodeCount || escCodes[c] == 0) {
                    if (outPtr >= outputBuffer.length) {
                        if (textBuffer == null) {
                            textBuffer = TextBuffer.fromInitial(outputBuffer);
                        }
                        outputBuffer = textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    int outPtr2 = outPtr + 1;
                    outputBuffer[outPtr] = c;
                    inPtr++;
                    if (inPtr >= inputLen) {
                        outPtr = outPtr2;
                        break loop0;
                    }
                    outPtr = outPtr2;
                }
            }
            if (qbuf == null) {
                qbuf = _qbuf();
            }
            int inPtr2 = inPtr + 1;
            char d = input.charAt(inPtr);
            int escCode = escCodes[d];
            if (escCode < 0) {
                length = _appendNumeric(d, qbuf);
            } else {
                length = _appendNamed(escCode, qbuf);
            }
            if (outPtr + length > outputBuffer.length) {
                int first = outputBuffer.length - outPtr;
                if (first > 0) {
                    System.arraycopy(qbuf, 0, outputBuffer, outPtr, first);
                }
                if (textBuffer == null) {
                    textBuffer = TextBuffer.fromInitial(outputBuffer);
                }
                outputBuffer = textBuffer.finishCurrentSegment();
                int second = length - first;
                System.arraycopy(qbuf, first, outputBuffer, 0, second);
                outPtr = second;
            } else {
                System.arraycopy(qbuf, 0, outputBuffer, outPtr, length);
                outPtr += length;
            }
            inPtr = inPtr2;
        }
        if (textBuffer == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outPtr);
        }
        textBuffer.setCurrentLength(outPtr);
        return textBuffer.contentsAsArray();
    }

    public void quoteAsString(CharSequence input, StringBuilder output) {
        int length;
        int[] escCodes = CharTypes.get7BitOutputEscapes();
        int escCodeCount = escCodes.length;
        int inPtr = 0;
        int inputLen = input.length();
        char[] qbuf = null;
        while (inPtr < inputLen) {
            do {
                char c = input.charAt(inPtr);
                if (c >= escCodeCount || escCodes[c] == 0) {
                    output.append(c);
                    inPtr++;
                } else {
                    if (qbuf == null) {
                        qbuf = _qbuf();
                    }
                    int inPtr2 = inPtr + 1;
                    char d = input.charAt(inPtr);
                    int escCode = escCodes[d];
                    if (escCode < 0) {
                        length = _appendNumeric(d, qbuf);
                    } else {
                        length = _appendNamed(escCode, qbuf);
                    }
                    output.append(qbuf, 0, length);
                    inPtr = inPtr2;
                }
            } while (inPtr < inputLen);
            return;
        }
    }

    public byte[] quoteAsUTF8(String text) {
        int outputPtr;
        int outputPtr2;
        int inputPtr = 0;
        int inputEnd = text.length();
        int outputPtr3 = 0;
        byte[] outputBuffer = new byte[200];
        ByteArrayBuilder bb = null;
        loop0: while (inputPtr < inputEnd) {
            int[] escCodes = CharTypes.get7BitOutputEscapes();
            while (true) {
                int ch = text.charAt(inputPtr);
                if (ch > 127 || escCodes[ch] != 0) {
                    break;
                }
                if (outputPtr3 >= outputBuffer.length) {
                    if (bb == null) {
                        bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
                    }
                    outputBuffer = bb.finishCurrentSegment();
                    outputPtr3 = 0;
                }
                int outputPtr4 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ch;
                inputPtr++;
                if (inputPtr >= inputEnd) {
                    outputPtr3 = outputPtr4;
                    break loop0;
                }
                outputPtr3 = outputPtr4;
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
            }
            if (outputPtr3 >= outputBuffer.length) {
                outputBuffer = bb.finishCurrentSegment();
                outputPtr3 = 0;
            }
            int inputPtr2 = inputPtr + 1;
            int ch2 = text.charAt(inputPtr);
            if (ch2 <= 127) {
                int escape = escCodes[ch2];
                outputPtr3 = _appendByte(ch2, escape, bb, outputPtr3);
                outputBuffer = bb.getCurrentSegment();
                inputPtr = inputPtr2;
            } else {
                if (ch2 <= 2047) {
                    outputPtr = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) ((ch2 >> 6) | 192);
                    outputPtr2 = (ch2 & 63) | 128;
                    inputPtr = inputPtr2;
                } else if (ch2 < 55296 || ch2 > 57343) {
                    int outputPtr5 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) ((ch2 >> 12) | 224);
                    if (outputPtr5 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr5 = 0;
                    }
                    outputBuffer[outputPtr5] = (byte) (((ch2 >> 6) & 63) | 128);
                    outputPtr = outputPtr5 + 1;
                    outputPtr2 = (ch2 & 63) | 128;
                    inputPtr = inputPtr2;
                } else {
                    if (ch2 > 56319) {
                        _illegal(ch2);
                    }
                    if (inputPtr2 >= inputEnd) {
                        _illegal(ch2);
                    }
                    int inputPtr3 = inputPtr2 + 1;
                    int ch3 = _convert(ch2, text.charAt(inputPtr2));
                    if (ch3 > 1114111) {
                        _illegal(ch3);
                    }
                    int outputPtr6 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) ((ch3 >> 18) | 240);
                    if (outputPtr6 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr6 = 0;
                    }
                    int outputPtr7 = outputPtr6 + 1;
                    outputBuffer[outputPtr6] = (byte) (((ch3 >> 12) & 63) | 128);
                    if (outputPtr7 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr7 = 0;
                    }
                    int outputPtr8 = outputPtr7 + 1;
                    outputBuffer[outputPtr7] = (byte) (((ch3 >> 6) & 63) | 128);
                    outputPtr2 = (ch3 & 63) | 128;
                    inputPtr = inputPtr3;
                    outputPtr = outputPtr8;
                }
                int inputPtr4 = outputBuffer.length;
                if (outputPtr >= inputPtr4) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputPtr = 0;
                }
                outputBuffer[outputPtr] = (byte) outputPtr2;
                outputPtr3 = outputPtr + 1;
            }
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr3);
        }
        return bb.completeAndCoalesce(outputPtr3);
    }

    public byte[] encodeAsUTF8(String text) {
        int outputPtr;
        int outputPtr2;
        int c = 0;
        int inputEnd = text.length();
        int outputPtr3 = 0;
        byte[] outputBuffer = new byte[200];
        int outputEnd = outputBuffer.length;
        ByteArrayBuilder bb = null;
        loop0: while (c < inputEnd) {
            int inputPtr = c + 1;
            int c2 = text.charAt(c);
            while (c2 <= 127) {
                if (outputPtr3 >= outputEnd) {
                    if (bb == null) {
                        bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
                    }
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr3 = 0;
                }
                int outputPtr4 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) c2;
                if (inputPtr >= inputEnd) {
                    outputPtr3 = outputPtr4;
                    break loop0;
                }
                c2 = text.charAt(inputPtr);
                inputPtr++;
                outputPtr3 = outputPtr4;
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
            }
            if (outputPtr3 >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr3 = 0;
            }
            if (c2 < 2048) {
                outputPtr = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c2 >> 6) | 192);
                outputPtr2 = c2;
                c = inputPtr;
            } else if (c2 < 55296 || c2 > 57343) {
                int outputPtr5 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c2 >> 12) | 224);
                if (outputPtr5 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr5 = 0;
                }
                outputBuffer[outputPtr5] = (byte) (((c2 >> 6) & 63) | 128);
                outputPtr = outputPtr5 + 1;
                outputPtr2 = c2;
                c = inputPtr;
            } else {
                if (c2 > 56319) {
                    _illegal(c2);
                }
                if (inputPtr >= inputEnd) {
                    _illegal(c2);
                }
                int inputPtr2 = inputPtr + 1;
                int c3 = _convert(c2, text.charAt(inputPtr));
                if (c3 > 1114111) {
                    _illegal(c3);
                }
                int outputPtr6 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c3 >> 18) | 240);
                if (outputPtr6 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr6 = 0;
                }
                int outputPtr7 = outputPtr6 + 1;
                outputBuffer[outputPtr6] = (byte) (((c3 >> 12) & 63) | 128);
                if (outputPtr7 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr7 = 0;
                }
                int outputPtr8 = outputPtr7 + 1;
                outputBuffer[outputPtr7] = (byte) (((c3 >> 6) & 63) | 128);
                outputPtr2 = c3;
                c = inputPtr2;
                outputPtr = outputPtr8;
            }
            if (outputPtr >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr = 0;
            }
            outputBuffer[outputPtr] = (byte) ((outputPtr2 & 63) | 128);
            outputPtr3 = outputPtr + 1;
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr3);
        }
        return bb.completeAndCoalesce(outputPtr3);
    }

    public byte[] encodeAsUTF8(CharSequence text) {
        int outputPtr;
        int outputPtr2;
        int c = 0;
        int inputEnd = text.length();
        int outputPtr3 = 0;
        byte[] outputBuffer = new byte[200];
        int outputEnd = outputBuffer.length;
        ByteArrayBuilder bb = null;
        loop0: while (c < inputEnd) {
            int inputPtr = c + 1;
            int c2 = text.charAt(c);
            while (c2 <= 127) {
                if (outputPtr3 >= outputEnd) {
                    if (bb == null) {
                        bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
                    }
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr3 = 0;
                }
                int outputPtr4 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) c2;
                if (inputPtr >= inputEnd) {
                    outputPtr3 = outputPtr4;
                    break loop0;
                }
                c2 = text.charAt(inputPtr);
                inputPtr++;
                outputPtr3 = outputPtr4;
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr3);
            }
            if (outputPtr3 >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr3 = 0;
            }
            if (c2 < 2048) {
                outputPtr = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c2 >> 6) | 192);
                outputPtr2 = c2;
                c = inputPtr;
            } else if (c2 < 55296 || c2 > 57343) {
                int outputPtr5 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c2 >> 12) | 224);
                if (outputPtr5 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr5 = 0;
                }
                outputBuffer[outputPtr5] = (byte) (((c2 >> 6) & 63) | 128);
                outputPtr = outputPtr5 + 1;
                outputPtr2 = c2;
                c = inputPtr;
            } else {
                if (c2 > 56319) {
                    _illegal(c2);
                }
                if (inputPtr >= inputEnd) {
                    _illegal(c2);
                }
                int inputPtr2 = inputPtr + 1;
                int c3 = _convert(c2, text.charAt(inputPtr));
                if (c3 > 1114111) {
                    _illegal(c3);
                }
                int outputPtr6 = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) ((c3 >> 18) | 240);
                if (outputPtr6 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr6 = 0;
                }
                int outputPtr7 = outputPtr6 + 1;
                outputBuffer[outputPtr6] = (byte) (((c3 >> 12) & 63) | 128);
                if (outputPtr7 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr7 = 0;
                }
                int outputPtr8 = outputPtr7 + 1;
                outputBuffer[outputPtr7] = (byte) (((c3 >> 6) & 63) | 128);
                outputPtr2 = c3;
                c = inputPtr2;
                outputPtr = outputPtr8;
            }
            if (outputPtr >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr = 0;
            }
            outputBuffer[outputPtr] = (byte) ((outputPtr2 & 63) | 128);
            outputPtr3 = outputPtr + 1;
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr3);
        }
        return bb.completeAndCoalesce(outputPtr3);
    }

    private char[] _qbuf() {
        char[] qbuf = {'\\', 0, '0', '0', 0, 0};
        return qbuf;
    }

    private int _appendNumeric(int value, char[] qbuf) {
        qbuf[1] = AbstractJsonLexerKt.UNICODE_ESC;
        qbuf[4] = f350HC[value >> 4];
        qbuf[5] = f350HC[value & 15];
        return 6;
    }

    private int _appendNamed(int esc, char[] qbuf) {
        qbuf[1] = (char) esc;
        return 2;
    }

    private int _appendByte(int ch, int esc, ByteArrayBuilder bb, int ptr) {
        bb.setCurrentSegmentLength(ptr);
        bb.append(92);
        if (esc < 0) {
            bb.append(117);
            if (ch > 255) {
                int hi = ch >> 8;
                bb.append(f349HB[hi >> 4]);
                bb.append(f349HB[hi & 15]);
                ch &= 255;
            } else {
                bb.append(48);
                bb.append(48);
            }
            bb.append(f349HB[ch >> 4]);
            bb.append(f349HB[ch & 15]);
        } else {
            bb.append((byte) esc);
        }
        return bb.getCurrentSegmentLength();
    }

    private static int _convert(int p1, int p2) {
        if (p2 >= 56320 && p2 <= 57343) {
            return ((p1 - 55296) << 10) + 65536 + (p2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(p1) + ", second 0x" + Integer.toHexString(p2) + "; illegal combination");
    }

    private static void _illegal(int c) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(c));
    }
}

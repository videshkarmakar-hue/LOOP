package com.fasterxml.jackson.core.p005io;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class CharTypes {

    /* JADX INFO: renamed from: HB */
    private static final byte[] f347HB;

    /* JADX INFO: renamed from: HC */
    private static final char[] f348HC = "0123456789ABCDEF".toCharArray();
    private static final int[] sHexValues;
    private static final int[] sInputCodes;
    private static final int[] sInputCodesComment;
    private static final int[] sInputCodesJsNames;
    private static final int[] sInputCodesUTF8;
    private static final int[] sInputCodesUtf8JsNames;
    private static final int[] sInputCodesWS;
    private static final int[] sOutputEscapes128;

    static {
        int code;
        int len = f348HC.length;
        f347HB = new byte[len];
        for (int i = 0; i < len; i++) {
            f347HB[i] = (byte) f348HC[i];
        }
        int[] table = new int[256];
        for (int i2 = 0; i2 < 32; i2++) {
            table[i2] = -1;
        }
        table[34] = 1;
        table[92] = 1;
        sInputCodes = table;
        int[] table2 = new int[sInputCodes.length];
        System.arraycopy(sInputCodes, 0, table2, 0, table2.length);
        for (int c = 128; c < 256; c++) {
            if ((c & 224) == 192) {
                code = 2;
            } else {
                int code2 = c & 240;
                if (code2 == 224) {
                    code = 3;
                } else {
                    int code3 = c & 248;
                    if (code3 == 240) {
                        code = 4;
                    } else {
                        code = -1;
                    }
                }
            }
            table2[c] = code;
        }
        sInputCodesUTF8 = table2;
        int[] table3 = new int[256];
        Arrays.fill(table3, -1);
        for (int i3 = 33; i3 < 256; i3++) {
            if (Character.isJavaIdentifierPart((char) i3)) {
                table3[i3] = 0;
            }
        }
        table3[64] = 0;
        table3[35] = 0;
        table3[42] = 0;
        table3[45] = 0;
        table3[43] = 0;
        sInputCodesJsNames = table3;
        int[] table4 = new int[256];
        System.arraycopy(sInputCodesJsNames, 0, table4, 0, table4.length);
        Arrays.fill(table4, 128, 128, 0);
        sInputCodesUtf8JsNames = table4;
        int[] table5 = new int[256];
        System.arraycopy(sInputCodesUTF8, 128, table5, 128, 128);
        Arrays.fill(table5, 0, 32, -1);
        table5[9] = 0;
        table5[10] = 10;
        table5[13] = 13;
        table5[42] = 42;
        sInputCodesComment = table5;
        int[] buf = new int[256];
        System.arraycopy(sInputCodesUTF8, 128, buf, 128, 128);
        Arrays.fill(buf, 0, 32, -1);
        buf[32] = 1;
        buf[9] = 1;
        buf[10] = 10;
        buf[13] = 13;
        buf[47] = 47;
        buf[35] = 35;
        sInputCodesWS = buf;
        int[] buf2 = new int[128];
        for (int i4 = 0; i4 < 32; i4++) {
            buf2[i4] = -1;
        }
        buf2[34] = 34;
        buf2[92] = 92;
        buf2[8] = 98;
        buf2[9] = 116;
        buf2[12] = 102;
        buf2[10] = 110;
        buf2[13] = 114;
        sOutputEscapes128 = buf2;
        sHexValues = new int[256];
        Arrays.fill(sHexValues, -1);
        for (int i5 = 0; i5 < 10; i5++) {
            sHexValues[i5 + 48] = i5;
        }
        for (int i6 = 0; i6 < 6; i6++) {
            sHexValues[i6 + 97] = i6 + 10;
            sHexValues[i6 + 65] = i6 + 10;
        }
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeWS() {
        return sInputCodesWS;
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int[] get7BitOutputEscapes(int quoteChar) {
        if (quoteChar == 34) {
            return sOutputEscapes128;
        }
        return AltEscapes.instance.escapesFor(quoteChar);
    }

    public static int charToHex(int ch) {
        return sHexValues[ch & 255];
    }

    public static void appendQuoted(StringBuilder sb, String content) {
        int[] escCodes = sOutputEscapes128;
        int escLen = escCodes.length;
        int len = content.length();
        for (int i = 0; i < len; i++) {
            char c = content.charAt(i);
            if (c >= escLen || escCodes[c] == 0) {
                sb.append(c);
            } else {
                sb.append('\\');
                int escCode = escCodes[c];
                if (escCode < 0) {
                    sb.append(AbstractJsonLexerKt.UNICODE_ESC);
                    sb.append('0');
                    sb.append('0');
                    sb.append(f348HC[c >> 4]);
                    sb.append(f348HC[c & 15]);
                } else {
                    sb.append((char) escCode);
                }
            }
        }
    }

    public static char[] copyHexChars() {
        return (char[]) f348HC.clone();
    }

    public static byte[] copyHexBytes() {
        return (byte[]) f347HB.clone();
    }

    private static class AltEscapes {
        public static final AltEscapes instance = new AltEscapes();
        private int[][] _altEscapes = new int[128][];

        private AltEscapes() {
        }

        public int[] escapesFor(int quoteChar) {
            int[] esc = this._altEscapes[quoteChar];
            if (esc == null) {
                esc = Arrays.copyOf(CharTypes.sOutputEscapes128, 128);
                if (esc[quoteChar] == 0) {
                    esc[quoteChar] = -1;
                }
                this._altEscapes[quoteChar] = esc;
            }
            return esc;
        }
    }
}

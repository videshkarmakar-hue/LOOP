package com.caverock.androidsvg;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;

/* JADX INFO: loaded from: classes.dex */
class IntegerParser {
    private int pos;
    private long value;

    IntegerParser(long value, int pos) {
        this.value = value;
        this.pos = pos;
    }

    int getEndPos() {
        return this.pos;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x004d  */
    static IntegerParser parseInt(String input, int startpos, int len, boolean includeSign) {
        long value;
        int pos = startpos;
        boolean isNegative = false;
        long value2 = 0;
        if (pos >= len) {
            return null;
        }
        if (includeSign) {
            switch (input.charAt(pos)) {
                case '+':
                    pos++;
                    break;
                case '-':
                    isNegative = true;
                    pos++;
                    break;
            }
        }
        int sigStart = pos;
        while (pos < len) {
            char ch = input.charAt(pos);
            if (ch >= '0' && ch <= '9') {
                if (isNegative) {
                    value = (10 * value2) - ((long) (ch - '0'));
                    if (value < -2147483648L) {
                        return null;
                    }
                } else {
                    value = (10 * value2) + ((long) (ch - '0'));
                    if (value > InlineClassHelperKt.FloatNonFiniteMask) {
                        return null;
                    }
                }
                value2 = value;
                pos++;
            } else {
                if (pos == sigStart) {
                    return null;
                }
                return new IntegerParser(value2, pos);
            }
        }
        if (pos == sigStart) {
            return null;
        }
        return new IntegerParser(value2, pos);
    }

    public int value() {
        return (int) this.value;
    }

    static IntegerParser parseHex(String input, int startpos, int len) {
        int pos = startpos;
        long value = 0;
        if (pos >= len) {
            return null;
        }
        while (pos < len) {
            char ch = input.charAt(pos);
            if (ch >= '0' && ch <= '9') {
                value = (16 * value) + ((long) (ch - '0'));
            } else if (ch >= 'A' && ch <= 'F') {
                value = (16 * value) + ((long) (ch - 'A')) + 10;
            } else {
                if (ch < 'a' || ch > 'f') {
                    break;
                }
                value = (16 * value) + ((long) (ch - 'a')) + 10;
            }
            if (value > 4294967295L) {
                return null;
            }
            pos++;
        }
        if (pos == startpos) {
            return null;
        }
        return new IntegerParser(value, pos);
    }
}

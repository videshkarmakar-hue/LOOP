package com.caverock.androidsvg;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
class NumberParser {
    private int pos;
    private static final float[] positivePowersOf10 = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
    private static final float[] negativePowersOf10 = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    NumberParser() {
    }

    int getEndPos() {
        return this.pos;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    float parseNumber(String input, int startpos, int len) {
        char ch;
        int exponent;
        char ch2;
        boolean expIsNegative;
        boolean expIsNegative2;
        char ch3;
        String str = input;
        int i = len;
        boolean isNegative = false;
        long significand = 0;
        int numDigits = 0;
        int numLeadingZeroes = 0;
        int numTrailingZeroes = 0;
        boolean decimalSeen = false;
        int decimalPos = 0;
        this.pos = startpos;
        if (this.pos >= i) {
            return Float.NaN;
        }
        char ch4 = str.charAt(this.pos);
        switch (ch4) {
            case '+':
                this.pos++;
                break;
            case '-':
                isNegative = true;
                this.pos++;
                break;
        }
        int sigStart = this.pos;
        while (true) {
            char ch5 = ch4;
            if (this.pos >= i) {
                ch = ch5;
            } else {
                char ch6 = str.charAt(this.pos);
                if (ch6 == '0') {
                    if (numDigits == 0) {
                        numLeadingZeroes++;
                    } else {
                        numTrailingZeroes++;
                    }
                } else if (ch6 >= '1' && ch6 <= '9') {
                    int numDigits2 = numDigits + numTrailingZeroes;
                    while (numTrailingZeroes > 0) {
                        if (significand <= 922337203685477580L) {
                            significand *= 10;
                            numTrailingZeroes--;
                        } else {
                            return Float.NaN;
                        }
                    }
                    if (significand > 922337203685477580L) {
                        return Float.NaN;
                    }
                    long j = 10 * significand;
                    long significand2 = ch6 - '0';
                    long significand3 = j + significand2;
                    numDigits = numDigits2 + 1;
                    if (significand3 >= 0) {
                        significand = significand3;
                    } else {
                        return Float.NaN;
                    }
                } else if (ch6 == '.' && !decimalSeen) {
                    int decimalPos2 = this.pos - sigStart;
                    decimalSeen = true;
                    decimalPos = decimalPos2;
                } else {
                    ch = ch6;
                }
                int decimalPos3 = this.pos;
                this.pos = decimalPos3 + 1;
                ch4 = ch6;
            }
        }
        if (!decimalSeen || this.pos != decimalPos + 1) {
            float f = Float.NaN;
            if (numDigits == 0) {
                if (numLeadingZeroes == 0) {
                    return f;
                }
                numDigits = 1;
            }
            if (decimalSeen) {
                exponent = (decimalPos - numLeadingZeroes) - numDigits;
            } else {
                exponent = numTrailingZeroes;
            }
            if (this.pos < i && ((ch2 = str.charAt(this.pos)) == 'E' || ch2 == 'e')) {
                boolean abortExponent = false;
                this.pos++;
                if (this.pos == i) {
                    return Float.NaN;
                }
                switch (str.charAt(this.pos)) {
                    case '+':
                        expIsNegative = false;
                        this.pos++;
                        expIsNegative2 = expIsNegative;
                        break;
                    case ',':
                    case '.':
                    case '/':
                    default:
                        abortExponent = true;
                        this.pos--;
                        expIsNegative2 = false;
                        break;
                    case '-':
                        expIsNegative = true;
                        this.pos++;
                        expIsNegative2 = expIsNegative;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    case '2':
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        expIsNegative2 = false;
                        break;
                }
                if (!abortExponent) {
                    int numTrailingZeroes2 = this.pos;
                    int expVal = 0;
                    while (true) {
                        int decimalPos4 = decimalPos;
                        int decimalPos5 = this.pos;
                        if (decimalPos5 < i && (ch3 = str.charAt(this.pos)) >= '0' && ch3 <= '9') {
                            if (expVal > 922337203685477580L) {
                                return Float.NaN;
                            }
                            expVal = (expVal * 10) + (ch3 - '0');
                            this.pos++;
                            str = input;
                            i = len;
                            decimalPos = decimalPos4;
                        }
                    }
                    if (this.pos == numTrailingZeroes2) {
                        return Float.NaN;
                    }
                    if (expIsNegative2) {
                        exponent -= expVal;
                    } else {
                        exponent += expVal;
                    }
                }
            }
            if (exponent + numDigits > 39 || exponent + numDigits < -44) {
                return Float.NaN;
            }
            float f2 = significand;
            if (significand != 0) {
                if (exponent > 0) {
                    f2 *= positivePowersOf10[exponent];
                } else if (exponent < 0) {
                    if (exponent < -38) {
                        f2 = (float) (((double) f2) * 1.0E-20d);
                        exponent += 20;
                    }
                    f2 *= negativePowersOf10[-exponent];
                }
            }
            return isNegative ? -f2 : f2;
        }
        return Float.NaN;
    }
}

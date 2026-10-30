package com.fasterxml.jackson.core.p005io;

import java.math.BigDecimal;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    public static int parseInt(char[] ch, int off, int len) {
        int num = ch[(off + len) - 1] - '0';
        switch (len) {
            case 9:
                num += (ch[off] - '0') * 100000000;
                off++;
            case 8:
                num += (ch[off] - '0') * 10000000;
                off++;
            case 7:
                num += (ch[off] - '0') * DurationKt.NANOS_IN_MILLIS;
                off++;
            case 6:
                num += (ch[off] - '0') * 100000;
                off++;
            case 5:
                num += (ch[off] - '0') * 10000;
                off++;
            case 4:
                num += (ch[off] - '0') * 1000;
                off++;
            case 3:
                num += (ch[off] - '0') * 100;
                off++;
            case 2:
                return num + ((ch[off] - '0') * 10);
            default:
                return num;
        }
    }

    public static int parseInt(String s) {
        int offset;
        char c = s.charAt(0);
        int len = s.length();
        boolean neg = c == '-';
        int offset2 = 1;
        if (neg) {
            if (len == 1 || len > 10) {
                int offset3 = Integer.parseInt(s);
                return offset3;
            }
            int offset4 = 1 + 1;
            c = s.charAt(1);
            offset2 = offset4;
        } else if (len > 9) {
            return Integer.parseInt(s);
        }
        if (c > '9' || c < '0') {
            return Integer.parseInt(s);
        }
        int num = c - '0';
        if (offset2 < len) {
            int offset5 = offset2 + 1;
            char c2 = s.charAt(offset2);
            if (c2 > '9' || c2 < '0') {
                return Integer.parseInt(s);
            }
            num = (num * 10) + (c2 - '0');
            if (offset5 < len) {
                int offset6 = offset5 + 1;
                char c3 = s.charAt(offset5);
                if (c3 > '9' || c3 < '0') {
                    return Integer.parseInt(s);
                }
                num = (num * 10) + (c3 - '0');
                if (offset6 < len) {
                    do {
                        offset = offset6 + 1;
                        char c4 = s.charAt(offset6);
                        if (c4 > '9' || c4 < '0') {
                            return Integer.parseInt(s);
                        }
                        num = (num * 10) + (c4 - '0');
                        offset6 = offset;
                    } while (offset < len);
                }
            }
        }
        return neg ? -num : num;
    }

    public static long parseLong(char[] ch, int off, int len) {
        int len1 = len - 9;
        long val = ((long) parseInt(ch, off, len1)) * L_BILLION;
        return ((long) parseInt(ch, off + len1, 9)) + val;
    }

    public static long parseLong(String s) {
        int length = s.length();
        if (length <= 9) {
            return parseInt(s);
        }
        return Long.parseLong(s);
    }

    public static boolean inLongRange(char[] ch, int off, int len, boolean negative) {
        String cmpStr = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmpStr.length();
        if (len < cmpLen) {
            return true;
        }
        if (len > cmpLen) {
            return false;
        }
        for (int i = 0; i < cmpLen; i++) {
            int diff = ch[off + i] - cmpStr.charAt(i);
            if (diff != 0) {
                return diff < 0;
            }
        }
        return true;
    }

    public static boolean inLongRange(String s, boolean negative) {
        String cmp = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmp.length();
        int alen = s.length();
        if (alen < cmpLen) {
            return true;
        }
        if (alen > cmpLen) {
            return false;
        }
        for (int i = 0; i < cmpLen; i++) {
            int diff = s.charAt(i) - cmp.charAt(i);
            if (diff != 0) {
                return diff < 0;
            }
        }
        return true;
    }

    public static int parseAsInt(String s, int def) {
        String s2;
        int len;
        if (s == null || (len = (s2 = s.trim()).length()) == 0) {
            return def;
        }
        int i = 0;
        if (0 < len) {
            char c = s2.charAt(0);
            if (c == '+') {
                s2 = s2.substring(1);
                len = s2.length();
            } else if (c == '-') {
                i = 0 + 1;
            }
        }
        while (i < len) {
            char c2 = s2.charAt(i);
            if (c2 <= '9' && c2 >= '0') {
                i++;
            } else {
                try {
                    return (int) parseDouble(s2);
                } catch (NumberFormatException e) {
                    return def;
                }
            }
        }
        try {
            return Integer.parseInt(s2);
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    public static long parseAsLong(String s, long def) {
        String s2;
        int len;
        if (s == null || (len = (s2 = s.trim()).length()) == 0) {
            return def;
        }
        int i = 0;
        if (0 < len) {
            char c = s2.charAt(0);
            if (c == '+') {
                s2 = s2.substring(1);
                len = s2.length();
            } else if (c == '-') {
                i = 0 + 1;
            }
        }
        while (i < len) {
            char c2 = s2.charAt(i);
            if (c2 <= '9' && c2 >= '0') {
                i++;
            } else {
                try {
                    return (long) parseDouble(s2);
                } catch (NumberFormatException e) {
                    return def;
                }
            }
        }
        try {
            return Long.parseLong(s2);
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    public static double parseAsDouble(String s, double def) {
        if (s == null) {
            return def;
        }
        String s2 = s.trim();
        int len = s2.length();
        if (len == 0) {
            return def;
        }
        try {
            return parseDouble(s2);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    public static double parseDouble(String s) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(s)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(s);
    }

    public static BigDecimal parseBigDecimal(String s) throws NumberFormatException {
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            throw _badBD(s);
        }
    }

    public static BigDecimal parseBigDecimal(char[] b) throws NumberFormatException {
        return parseBigDecimal(b, 0, b.length);
    }

    public static BigDecimal parseBigDecimal(char[] b, int off, int len) throws NumberFormatException {
        try {
            return new BigDecimal(b, off, len);
        } catch (NumberFormatException e) {
            throw _badBD(new String(b, off, len));
        }
    }

    private static NumberFormatException _badBD(String s) {
        return new NumberFormatException("Value \"" + s + "\" can not be represented as BigDecimal");
    }
}

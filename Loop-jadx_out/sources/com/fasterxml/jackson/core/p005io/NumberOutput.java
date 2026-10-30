package com.fasterxml.jackson.core.p005io;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import coil.disk.DiskLruCache;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes.dex */
public final class NumberOutput {
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;
    private static int MILLION = DurationKt.NANOS_IN_MILLIS;
    private static int BILLION = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    private static long BILLION_L = 1000000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    private static long MAX_INT_AS_LONG = InlineClassHelperKt.FloatNonFiniteMask;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];

    static {
        int fullIx = 0;
        for (int i1 = 0; i1 < 10; i1++) {
            for (int i2 = 0; i2 < 10; i2++) {
                int i3 = 0;
                while (i3 < 10) {
                    int enc = ((i1 + 48) << 16) | ((i2 + 48) << 8) | (i3 + 48);
                    TRIPLET_TO_CHARS[fullIx] = enc;
                    i3++;
                    fullIx++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", DiskLruCache.VERSION, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int outputInt(int v, char[] b, int off) {
        int off2;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            b[off] = '-';
            v = -v;
            off++;
        }
        if (v < MILLION) {
            if (v < 1000) {
                if (v < 10) {
                    b[off] = (char) (v + 48);
                    return off + 1;
                }
                return _leading3(v, b, off);
            }
            int thousands = v / 1000;
            return _full3(v - (thousands * 1000), b, _leading3(thousands, b, off));
        }
        int thousands2 = BILLION;
        if (v >= thousands2) {
            int v2 = v - BILLION;
            if (v2 >= BILLION) {
                v2 -= BILLION;
                off2 = off + 1;
                b[off] = '2';
            } else {
                off2 = off + 1;
                b[off] = '1';
            }
            return _outputFullBillion(v2, b, off2);
        }
        int off3 = v / 1000;
        int ones = v - (off3 * 1000);
        int newValue = off3 / 1000;
        int thousands3 = off3 - (newValue * 1000);
        return _full3(ones, b, _full3(thousands3, b, _leading3(newValue, b, off)));
    }

    public static int outputInt(int v, byte[] b, int off) {
        int off2;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            b[off] = 45;
            v = -v;
            off++;
        }
        if (v < MILLION) {
            if (v < 1000) {
                if (v < 10) {
                    int off3 = off + 1;
                    b[off] = (byte) (v + 48);
                    return off3;
                }
                return _leading3(v, b, off);
            }
            int off4 = v / 1000;
            return _full3(v - (off4 * 1000), b, _leading3(off4, b, off));
        }
        if (v >= BILLION) {
            int v2 = v - BILLION;
            if (v2 >= BILLION) {
                v2 -= BILLION;
                off2 = off + 1;
                b[off] = TarConstants.LF_SYMLINK;
            } else {
                off2 = off + 1;
                b[off] = TarConstants.LF_LINK;
            }
            return _outputFullBillion(v2, b, off2);
        }
        int off5 = v / 1000;
        int ones = v - (off5 * 1000);
        int newValue = off5 / 1000;
        int thousands = off5 - (newValue * 1000);
        return _full3(ones, b, _full3(thousands, b, _leading3(newValue, b, off)));
    }

    public static int outputLong(long v, char[] b, int off) {
        int off2;
        if (v < 0) {
            if (v > MIN_INT_AS_LONG) {
                return outputInt((int) v, b, off);
            }
            if (v == Long.MIN_VALUE) {
                return _outputSmallestL(b, off);
            }
            b[off] = '-';
            v = -v;
            off++;
        } else if (v <= MAX_INT_AS_LONG) {
            return outputInt((int) v, b, off);
        }
        long upper = v / BILLION_L;
        long v2 = v - (BILLION_L * upper);
        if (upper < BILLION_L) {
            off2 = _outputUptoBillion((int) upper, b, off);
        } else {
            long hi = upper / BILLION_L;
            long upper2 = upper - (BILLION_L * hi);
            off2 = _outputFullBillion((int) upper2, b, _leading3((int) hi, b, off));
        }
        return _outputFullBillion((int) v2, b, off2);
    }

    public static int outputLong(long v, byte[] b, int off) {
        int off2;
        if (v < 0) {
            if (v > MIN_INT_AS_LONG) {
                return outputInt((int) v, b, off);
            }
            if (v == Long.MIN_VALUE) {
                return _outputSmallestL(b, off);
            }
            b[off] = 45;
            v = -v;
            off++;
        } else if (v <= MAX_INT_AS_LONG) {
            return outputInt((int) v, b, off);
        }
        long upper = v / BILLION_L;
        long v2 = v - (BILLION_L * upper);
        if (upper < BILLION_L) {
            off2 = _outputUptoBillion((int) upper, b, off);
        } else {
            long hi = upper / BILLION_L;
            long upper2 = upper - (BILLION_L * hi);
            off2 = _outputFullBillion((int) upper2, b, _leading3((int) hi, b, off));
        }
        return _outputFullBillion((int) v2, b, off2);
    }

    public static String toString(int v) {
        if (v < sSmallIntStrs.length) {
            if (v >= 0) {
                return sSmallIntStrs[v];
            }
            int v2 = (-v) - 1;
            if (v2 < sSmallIntStrs2.length) {
                return sSmallIntStrs2[v2];
            }
        }
        return Integer.toString(v);
    }

    public static String toString(long v) {
        if (v <= InlineClassHelperKt.FloatNonFiniteMask && v >= -2147483648L) {
            return toString((int) v);
        }
        return Long.toString(v);
    }

    public static String toString(double v) {
        return Double.toString(v);
    }

    public static String toString(float v) {
        return Float.toString(v);
    }

    public static boolean notFinite(double value) {
        return Double.isNaN(value) || Double.isInfinite(value);
    }

    public static boolean notFinite(float value) {
        return Float.isNaN(value) || Float.isInfinite(value);
    }

    private static int _outputUptoBillion(int v, char[] b, int off) {
        if (v < MILLION) {
            if (v < 1000) {
                return _leading3(v, b, off);
            }
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            return _outputUptoMillion(b, off, thousands, ones);
        }
        int thousands2 = v / 1000;
        int ones2 = v - (thousands2 * 1000);
        int millions = thousands2 / 1000;
        int off2 = _leading3(millions, b, off);
        int enc = TRIPLET_TO_CHARS[thousands2 - (millions * 1000)];
        int off3 = off2 + 1;
        b[off2] = (char) (enc >> 16);
        int off4 = off3 + 1;
        b[off3] = (char) ((enc >> 8) & 127);
        int off5 = off4 + 1;
        b[off4] = (char) (enc & 127);
        int enc2 = TRIPLET_TO_CHARS[ones2];
        int enc3 = off5 + 1;
        b[off5] = (char) (enc2 >> 16);
        int off6 = enc3 + 1;
        b[enc3] = (char) ((enc2 >> 8) & 127);
        int off7 = off6 + 1;
        b[off6] = (char) (enc2 & 127);
        return off7;
    }

    private static int _outputFullBillion(int v, char[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int enc = TRIPLET_TO_CHARS[millions];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & 127);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & 127);
        int enc2 = TRIPLET_TO_CHARS[thousands - (millions * 1000)];
        int enc3 = off4 + 1;
        b[off4] = (char) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (char) ((enc2 >> 8) & 127);
        int off6 = off5 + 1;
        b[off5] = (char) (enc2 & 127);
        int enc4 = TRIPLET_TO_CHARS[ones];
        int off7 = off6 + 1;
        b[off6] = (char) (enc4 >> 16);
        int off8 = off7 + 1;
        b[off7] = (char) ((enc4 >> 8) & 127);
        int off9 = off8 + 1;
        b[off8] = (char) (enc4 & 127);
        return off9;
    }

    private static int _outputUptoBillion(int v, byte[] b, int off) {
        if (v < MILLION) {
            if (v < 1000) {
                return _leading3(v, b, off);
            }
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            return _outputUptoMillion(b, off, thousands, ones);
        }
        int thousands2 = v / 1000;
        int ones2 = v - (thousands2 * 1000);
        int millions = thousands2 / 1000;
        int off2 = _leading3(millions, b, off);
        int enc = TRIPLET_TO_CHARS[thousands2 - (millions * 1000)];
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 16);
        int off4 = off3 + 1;
        b[off3] = (byte) (enc >> 8);
        int off5 = off4 + 1;
        b[off4] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[ones2];
        int enc3 = off5 + 1;
        b[off5] = (byte) (enc2 >> 16);
        int off6 = enc3 + 1;
        b[enc3] = (byte) (enc2 >> 8);
        int off7 = off6 + 1;
        b[off6] = (byte) enc2;
        return off7;
    }

    private static int _outputFullBillion(int v, byte[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int enc = TRIPLET_TO_CHARS[millions];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[thousands - (millions * 1000)];
        int enc3 = off4 + 1;
        b[off4] = (byte) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (byte) (enc2 >> 8);
        int off6 = off5 + 1;
        b[off5] = (byte) enc2;
        int enc4 = TRIPLET_TO_CHARS[ones];
        int off7 = off6 + 1;
        b[off6] = (byte) (enc4 >> 16);
        int off8 = off7 + 1;
        b[off7] = (byte) (enc4 >> 8);
        int off9 = off8 + 1;
        b[off8] = (byte) enc4;
        return off9;
    }

    private static int _outputUptoMillion(char[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                b[off] = (char) (enc >> 16);
                off++;
            }
            b[off] = (char) ((enc >> 8) & 127);
            off++;
        }
        int off2 = off + 1;
        b[off] = (char) (enc & 127);
        int enc2 = TRIPLET_TO_CHARS[ones];
        int enc3 = off2 + 1;
        b[off2] = (char) (enc2 >> 16);
        int off3 = enc3 + 1;
        b[enc3] = (char) ((enc2 >> 8) & 127);
        int off4 = off3 + 1;
        b[off3] = (char) (enc2 & 127);
        return off4;
    }

    private static int _outputUptoMillion(byte[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                b[off] = (byte) (enc >> 16);
                off++;
            }
            b[off] = (byte) (enc >> 8);
            off++;
        }
        int off2 = off + 1;
        b[off] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[ones];
        int enc3 = off2 + 1;
        b[off2] = (byte) (enc2 >> 16);
        int off3 = enc3 + 1;
        b[enc3] = (byte) (enc2 >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc2;
        return off4;
    }

    private static int _leading3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                b[off] = (char) (enc >> 16);
                off++;
            }
            b[off] = (char) ((enc >> 8) & 127);
            off++;
        }
        int off2 = off + 1;
        b[off] = (char) (enc & 127);
        return off2;
    }

    private static int _leading3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                b[off] = (byte) (enc >> 16);
                off++;
            }
            b[off] = (byte) (enc >> 8);
            off++;
        }
        int off2 = off + 1;
        b[off] = (byte) enc;
        return off2;
    }

    private static int _full3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & 127);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & 127);
        return off4;
    }

    private static int _full3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        return off4;
    }

    private static int _outputSmallestL(char[] b, int off) {
        int len = SMALLEST_LONG.length();
        SMALLEST_LONG.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestL(byte[] b, int off) {
        int len = SMALLEST_LONG.length();
        int i = 0;
        while (i < len) {
            b[off] = (byte) SMALLEST_LONG.charAt(i);
            i++;
            off++;
        }
        return off;
    }

    private static int _outputSmallestI(char[] b, int off) {
        int len = SMALLEST_INT.length();
        SMALLEST_INT.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestI(byte[] b, int off) {
        int len = SMALLEST_INT.length();
        int i = 0;
        while (i < len) {
            b[off] = (byte) SMALLEST_INT.charAt(i);
            i++;
            off++;
        }
        return off;
    }
}

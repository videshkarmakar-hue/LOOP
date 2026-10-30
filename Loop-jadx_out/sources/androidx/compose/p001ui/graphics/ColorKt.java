package androidx.compose.p001ui.graphics;

import androidx.compose.p001ui.graphics.colorspace.ColorModel;
import androidx.compose.p001ui.graphics.colorspace.ColorSpace;
import androidx.compose.p001ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p001ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p001ui.graphics.colorspace.Rgb;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0017\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00192\b\b\u0001\u0010\u0012\u001a\u00020\u00192\b\b\u0001\u0010\u0013\u001a\u00020\u00192\b\b\u0003\u0010\u0014\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a1\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0082\b\u001a,\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001e\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u000200*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0016\u00103\u001a\u00020\u0011*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a%\u00106\u001a\u00020\u0007*\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000708H\u0086\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0016\u0010;\u001a\u00020\u0019*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001f\u0010\f\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, m195d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "UncheckedColor", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4339isSpecified8_81llA$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4341isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01db  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:111:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:113:0x0203  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:76:0x017b  */
    /* JADX WARN: Code duplicated, block: B:78:0x017f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0182  */
    /* JADX WARN: Code duplicated, block: B:81:0x0187  */
    /* JADX WARN: Code duplicated, block: B:83:0x018d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0192 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0194  */
    /* JADX WARN: Code duplicated, block: B:88:0x019e  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:92:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d8  */
    public static final long Color(float red, float green, float blue, float alpha, ColorSpace colorSpace) {
        boolean value$iv;
        short s;
        int s$iv;
        int e$iv;
        int m$iv;
        int outE$iv;
        int outM$iv;
        int e$iv2;
        int i;
        int m$iv2;
        int s$iv2;
        int e$iv3;
        int m$iv3;
        int outE$iv2;
        int outM$iv2;
        int e$iv4;
        short b;
        int m$iv4;
        int i2;
        int i3;
        if (red <= colorSpace.getMaxValue(0) && colorSpace.getMinValue(0) <= red) {
            if (green <= colorSpace.getMaxValue(1) && colorSpace.getMinValue(1) <= green) {
                if (blue <= colorSpace.getMaxValue(2) && colorSpace.getMinValue(2) <= blue) {
                    if (0.0f <= alpha && alpha <= 1.0f) {
                        value$iv = true;
                    } else {
                        value$iv = false;
                    }
                } else {
                    value$iv = false;
                }
            } else {
                value$iv = false;
            }
        } else {
            value$iv = false;
        }
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("red = " + red + ", green = " + green + ", blue = " + blue + ", alpha = " + alpha + " outside the range for " + colorSpace);
        }
        boolean value$iv2 = colorSpace.getIsSrgb();
        if (value$iv2) {
            int argb = ((int) ((255.0f * blue) + 0.5f)) | (((int) ((alpha * 255.0f) + 0.5f)) << 24) | (((int) ((red * 255.0f) + 0.5f)) << 16) | (((int) ((green * 255.0f) + 0.5f)) << 8);
            return Color.m4287constructorimpl(ULong.m7867constructorimpl(ULong.m7867constructorimpl(argb) << 32));
        }
        boolean value$iv3 = colorSpace.getComponentCount() == 3;
        if (!value$iv3) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id = colorSpace.getId();
        boolean value$iv4 = id != -1;
        if (!value$iv4) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        int bits$iv = Float.floatToRawIntBits(red);
        int s$iv3 = bits$iv >>> 31;
        int e$iv5 = (bits$iv >>> 23) & 255;
        int m$iv5 = bits$iv & 8388607;
        int outE$iv3 = 0;
        int outM$iv3 = 0;
        if (e$iv5 == 255) {
            outE$iv3 = 31;
            outM$iv3 = m$iv5 != 0 ? 512 : 0;
        } else {
            int e$iv6 = (e$iv5 - 127) + 15;
            if (e$iv6 >= 31) {
                outE$iv3 = 49;
            } else {
                if (e$iv6 > 0) {
                    outE$iv3 = e$iv6;
                    outM$iv3 = m$iv5 >> 13;
                    if ((m$iv5 & 4096) != 0) {
                        int out$iv = (outE$iv3 << 10) | outM$iv3;
                        s = (short) ((out$iv + 1) | (s$iv3 << 15));
                    }
                    short r = s;
                    int bits$iv2 = Float.floatToRawIntBits(green);
                    s$iv = bits$iv2 >>> 31;
                    e$iv = (bits$iv2 >>> 23) & 255;
                    m$iv = bits$iv2 & 8388607;
                    outE$iv = 0;
                    outM$iv = 0;
                    if (e$iv == 255) {
                        outE$iv = 31;
                        if (m$iv != 0) {
                            i3 = 512;
                        } else {
                            i3 = 0;
                        }
                        outM$iv = i3;
                    } else {
                        e$iv2 = (e$iv - 127) + 15;
                        if (e$iv2 >= 31) {
                            outE$iv = 49;
                        } else {
                            if (e$iv2 <= 0) {
                                outE$iv = e$iv2;
                                outM$iv = m$iv >> 13;
                                if ((m$iv & 4096) != 0) {
                                    int out$iv2 = (outE$iv << 10) | outM$iv;
                                    i = (short) ((out$iv2 + 1) | (s$iv << 15));
                                }
                                int $i$f$floatToHalf = i;
                                int bits$iv3 = Float.floatToRawIntBits(blue);
                                s$iv2 = bits$iv3 >>> 31;
                                e$iv3 = (bits$iv3 >>> 23) & 255;
                                m$iv3 = bits$iv3 & 8388607;
                                outE$iv2 = 0;
                                outM$iv2 = 0;
                                if (e$iv3 == 255) {
                                    outE$iv2 = 31;
                                    if (m$iv3 != 0) {
                                        i2 = 512;
                                    } else {
                                        i2 = 0;
                                    }
                                    outM$iv2 = i2;
                                } else {
                                    e$iv4 = (e$iv3 - 127) + 15;
                                    if (e$iv4 >= 31) {
                                        outE$iv2 = 49;
                                    } else {
                                        if (e$iv4 <= 0) {
                                            outE$iv2 = e$iv4;
                                            outM$iv2 = m$iv3 >> 13;
                                            if ((m$iv3 & 4096) != 0) {
                                                int out$iv3 = (outE$iv2 << 10) | outM$iv2;
                                                b = (short) ((out$iv3 + 1) | (s$iv2 << 15));
                                            }
                                            int a = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                            return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a) & 1023) << 6) | (((long) id) & 63)));
                                        }
                                        if (e$iv4 >= -10) {
                                            m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                            if ((m$iv4 & 4096) != 0) {
                                                m$iv4 += 8192;
                                            }
                                            outM$iv2 = m$iv4 >> 13;
                                        }
                                    }
                                }
                                b = (short) ((s$iv2 << 15) | (outE$iv2 << 10) | outM$iv2);
                                int a2 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a2) & 1023) << 6) | (((long) id) & 63)));
                            }
                            if (e$iv2 >= -10) {
                                m$iv2 = (m$iv | 8388608) >> (1 - e$iv2);
                                if ((m$iv2 & 4096) != 0) {
                                    m$iv2 += 8192;
                                }
                                outM$iv = m$iv2 >> 13;
                            }
                        }
                    }
                    int out$iv4 = s$iv << 15;
                    i = (short) (out$iv4 | (outE$iv << 10) | outM$iv);
                    int $i$f$floatToHalf2 = i;
                    int bits$iv4 = Float.floatToRawIntBits(blue);
                    s$iv2 = bits$iv4 >>> 31;
                    e$iv3 = (bits$iv4 >>> 23) & 255;
                    m$iv3 = bits$iv4 & 8388607;
                    outE$iv2 = 0;
                    outM$iv2 = 0;
                    if (e$iv3 == 255) {
                        outE$iv2 = 31;
                        if (m$iv3 != 0) {
                            i2 = 512;
                        } else {
                            i2 = 0;
                        }
                        outM$iv2 = i2;
                    } else {
                        e$iv4 = (e$iv3 - 127) + 15;
                        if (e$iv4 >= 31) {
                            outE$iv2 = 49;
                        } else {
                            if (e$iv4 <= 0) {
                                outE$iv2 = e$iv4;
                                outM$iv2 = m$iv3 >> 13;
                                if ((m$iv3 & 4096) != 0) {
                                    int out$iv5 = (outE$iv2 << 10) | outM$iv2;
                                    b = (short) ((out$iv5 + 1) | (s$iv2 << 15));
                                }
                                int a3 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a3) & 1023) << 6) | (((long) id) & 63)));
                            }
                            if (e$iv4 >= -10) {
                                m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                if ((m$iv4 & 4096) != 0) {
                                    m$iv4 += 8192;
                                }
                                outM$iv2 = m$iv4 >> 13;
                            }
                        }
                    }
                    b = (short) ((s$iv2 << 15) | (outE$iv2 << 10) | outM$iv2);
                    int a4 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a4) & 1023) << 6) | (((long) id) & 63)));
                }
                if (e$iv6 >= -10) {
                    int m$iv6 = (m$iv5 | 8388608) >> (1 - e$iv6);
                    if ((m$iv6 & 4096) != 0) {
                        m$iv6 += 8192;
                    }
                    outM$iv3 = m$iv6 >> 13;
                }
            }
        }
        int out$iv6 = s$iv3 << 15;
        s = (short) (out$iv6 | (outE$iv3 << 10) | outM$iv3);
        short r2 = s;
        int bits$iv5 = Float.floatToRawIntBits(green);
        s$iv = bits$iv5 >>> 31;
        e$iv = (bits$iv5 >>> 23) & 255;
        m$iv = bits$iv5 & 8388607;
        outE$iv = 0;
        outM$iv = 0;
        if (e$iv == 255) {
            outE$iv = 31;
            if (m$iv != 0) {
                i3 = 512;
            } else {
                i3 = 0;
            }
            outM$iv = i3;
        } else {
            e$iv2 = (e$iv - 127) + 15;
            if (e$iv2 >= 31) {
                outE$iv = 49;
            } else {
                if (e$iv2 <= 0) {
                    outE$iv = e$iv2;
                    outM$iv = m$iv >> 13;
                    if ((m$iv & 4096) != 0) {
                        int out$iv7 = (outE$iv << 10) | outM$iv;
                        i = (short) ((out$iv7 + 1) | (s$iv << 15));
                    }
                    int $i$f$floatToHalf3 = i;
                    int bits$iv6 = Float.floatToRawIntBits(blue);
                    s$iv2 = bits$iv6 >>> 31;
                    e$iv3 = (bits$iv6 >>> 23) & 255;
                    m$iv3 = bits$iv6 & 8388607;
                    outE$iv2 = 0;
                    outM$iv2 = 0;
                    if (e$iv3 == 255) {
                        outE$iv2 = 31;
                        if (m$iv3 != 0) {
                            i2 = 512;
                        } else {
                            i2 = 0;
                        }
                        outM$iv2 = i2;
                    } else {
                        e$iv4 = (e$iv3 - 127) + 15;
                        if (e$iv4 >= 31) {
                            outE$iv2 = 49;
                        } else {
                            if (e$iv4 <= 0) {
                                outE$iv2 = e$iv4;
                                outM$iv2 = m$iv3 >> 13;
                                if ((m$iv3 & 4096) != 0) {
                                    int out$iv8 = (outE$iv2 << 10) | outM$iv2;
                                    b = (short) ((out$iv8 + 1) | (s$iv2 << 15));
                                }
                                int a5 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a5) & 1023) << 6) | (((long) id) & 63)));
                            }
                            if (e$iv4 >= -10) {
                                m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                if ((m$iv4 & 4096) != 0) {
                                    m$iv4 += 8192;
                                }
                                outM$iv2 = m$iv4 >> 13;
                            }
                        }
                    }
                    b = (short) ((s$iv2 << 15) | (outE$iv2 << 10) | outM$iv2);
                    int a6 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a6) & 1023) << 6) | (((long) id) & 63)));
                }
                if (e$iv2 >= -10) {
                    m$iv2 = (m$iv | 8388608) >> (1 - e$iv2);
                    if ((m$iv2 & 4096) != 0) {
                        m$iv2 += 8192;
                    }
                    outM$iv = m$iv2 >> 13;
                }
            }
        }
        int out$iv9 = s$iv << 15;
        i = (short) (out$iv9 | (outE$iv << 10) | outM$iv);
        int $i$f$floatToHalf4 = i;
        int bits$iv7 = Float.floatToRawIntBits(blue);
        s$iv2 = bits$iv7 >>> 31;
        e$iv3 = (bits$iv7 >>> 23) & 255;
        m$iv3 = bits$iv7 & 8388607;
        outE$iv2 = 0;
        outM$iv2 = 0;
        if (e$iv3 == 255) {
            outE$iv2 = 31;
            if (m$iv3 != 0) {
                i2 = 512;
            } else {
                i2 = 0;
            }
            outM$iv2 = i2;
        } else {
            e$iv4 = (e$iv3 - 127) + 15;
            if (e$iv4 >= 31) {
                outE$iv2 = 49;
            } else {
                if (e$iv4 <= 0) {
                    outE$iv2 = e$iv4;
                    outM$iv2 = m$iv3 >> 13;
                    if ((m$iv3 & 4096) != 0) {
                        int out$iv10 = (outE$iv2 << 10) | outM$iv2;
                        b = (short) ((out$iv10 + 1) | (s$iv2 << 15));
                    }
                    int a7 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a7) & 1023) << 6) | (((long) id) & 63)));
                }
                if (e$iv4 >= -10) {
                    m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                    if ((m$iv4 & 4096) != 0) {
                        m$iv4 += 8192;
                    }
                    outM$iv2 = m$iv4 >> 13;
                }
            }
        }
        b = (short) ((s$iv2 << 15) | (outE$iv2 << 10) | outM$iv2);
        int a8 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
        return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) r2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) b)) << 16) | ((((long) a8) & 1023) << 6) | (((long) id) & 63)));
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:51:0x0100  */
    /* JADX WARN: Code duplicated, block: B:53:0x0103  */
    /* JADX WARN: Code duplicated, block: B:55:0x0109  */
    /* JADX WARN: Code duplicated, block: B:56:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:60:0x011a  */
    /* JADX WARN: Code duplicated, block: B:62:0x011f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0126  */
    public static final long UncheckedColor(float red, float green, float blue, float alpha, ColorSpace colorSpace) {
        int i;
        int s$iv;
        int e$iv;
        int m$iv;
        int outE$iv;
        int outM$iv;
        int e$iv2;
        int i2;
        int m$iv2;
        int s$iv2;
        int e$iv3;
        int m$iv3;
        int outE$iv2;
        int outM$iv2;
        int e$iv4;
        int i3;
        int m$iv4;
        int i4;
        int i5;
        if (colorSpace.getIsSrgb()) {
            int argb = ((int) ((255.0f * blue) + 0.5f)) | (((int) ((red * 255.0f) + 0.5f)) << 16) | (((int) ((alpha * 255.0f) + 0.5f)) << 24) | (((int) ((green * 255.0f) + 0.5f)) << 8);
            return Color.m4287constructorimpl(ULong.m7867constructorimpl(ULong.m7867constructorimpl(argb) << 32));
        }
        int bits$iv = Float.floatToRawIntBits(red);
        int s$iv3 = bits$iv >>> 31;
        int e$iv5 = (bits$iv >>> 23) & 255;
        int m$iv5 = bits$iv & 8388607;
        int outE$iv3 = 0;
        int outM$iv3 = 0;
        if (e$iv5 == 255) {
            outE$iv3 = 31;
            outM$iv3 = m$iv5 != 0 ? 512 : 0;
        } else {
            int e$iv6 = (e$iv5 - 127) + 15;
            if (e$iv6 >= 31) {
                outE$iv3 = 49;
            } else {
                if (e$iv6 > 0) {
                    outE$iv3 = e$iv6;
                    outM$iv3 = m$iv5 >> 13;
                    if ((m$iv5 & 4096) != 0) {
                        int out$iv = (outE$iv3 << 10) | outM$iv3;
                        i = (short) ((out$iv + 1) | (s$iv3 << 15));
                    }
                    int $i$f$floatToHalf = i;
                    int bits$iv2 = Float.floatToRawIntBits(green);
                    s$iv = bits$iv2 >>> 31;
                    e$iv = (bits$iv2 >>> 23) & 255;
                    m$iv = bits$iv2 & 8388607;
                    outE$iv = 0;
                    outM$iv = 0;
                    if (e$iv == 255) {
                        outE$iv = 31;
                        if (m$iv != 0) {
                            i5 = 512;
                        } else {
                            i5 = 0;
                        }
                        outM$iv = i5;
                    } else {
                        e$iv2 = (e$iv - 127) + 15;
                        if (e$iv2 >= 31) {
                            outE$iv = 49;
                        } else {
                            if (e$iv2 <= 0) {
                                outE$iv = e$iv2;
                                outM$iv = m$iv >> 13;
                                if ((m$iv & 4096) != 0) {
                                    int out$iv2 = (outE$iv << 10) | outM$iv;
                                    i2 = (short) ((out$iv2 + 1) | (s$iv << 15));
                                }
                                int $i$f$floatToHalf2 = i2;
                                int bits$iv3 = Float.floatToRawIntBits(blue);
                                s$iv2 = bits$iv3 >>> 31;
                                e$iv3 = (bits$iv3 >>> 23) & 255;
                                m$iv3 = bits$iv3 & 8388607;
                                outE$iv2 = 0;
                                outM$iv2 = 0;
                                if (e$iv3 == 255) {
                                    outE$iv2 = 31;
                                    if (m$iv3 != 0) {
                                        i4 = 512;
                                    } else {
                                        i4 = 0;
                                    }
                                    outM$iv2 = i4;
                                } else {
                                    e$iv4 = (e$iv3 - 127) + 15;
                                    if (e$iv4 >= 31) {
                                        outE$iv2 = 49;
                                    } else {
                                        if (e$iv4 <= 0) {
                                            outE$iv2 = e$iv4;
                                            outM$iv2 = m$iv3 >> 13;
                                            if ((m$iv3 & 4096) != 0) {
                                                int out$iv3 = (outE$iv2 << 10) | outM$iv2;
                                                i3 = (short) ((s$iv2 << 15) | (out$iv3 + 1));
                                            }
                                            int $i$f$floatToHalf3 = i3;
                                            int a = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                            int id = colorSpace.getId();
                                            return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf3)) << 16) | ((((long) a) & 1023) << 6) | (((long) id) & 63)));
                                        }
                                        if (e$iv4 >= -10) {
                                            m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                            if ((m$iv4 & 4096) != 0) {
                                                m$iv4 += 8192;
                                            }
                                            outM$iv2 = m$iv4 >> 13;
                                        }
                                    }
                                }
                                int out$iv4 = s$iv2 << 15;
                                i3 = (short) (out$iv4 | (outE$iv2 << 10) | outM$iv2);
                                int $i$f$floatToHalf4 = i3;
                                int a2 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                int id2 = colorSpace.getId();
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf4)) << 16) | ((((long) a2) & 1023) << 6) | (((long) id2) & 63)));
                            }
                            if (e$iv2 >= -10) {
                                m$iv2 = (m$iv | 8388608) >> (1 - e$iv2);
                                if ((m$iv2 & 4096) != 0) {
                                    m$iv2 += 8192;
                                }
                                outM$iv = m$iv2 >> 13;
                            }
                        }
                    }
                    i2 = (short) ((s$iv << 15) | (outE$iv << 10) | outM$iv);
                    int $i$f$floatToHalf5 = i2;
                    int bits$iv4 = Float.floatToRawIntBits(blue);
                    s$iv2 = bits$iv4 >>> 31;
                    e$iv3 = (bits$iv4 >>> 23) & 255;
                    m$iv3 = bits$iv4 & 8388607;
                    outE$iv2 = 0;
                    outM$iv2 = 0;
                    if (e$iv3 == 255) {
                        outE$iv2 = 31;
                        if (m$iv3 != 0) {
                            i4 = 512;
                        } else {
                            i4 = 0;
                        }
                        outM$iv2 = i4;
                    } else {
                        e$iv4 = (e$iv3 - 127) + 15;
                        if (e$iv4 >= 31) {
                            outE$iv2 = 49;
                        } else {
                            if (e$iv4 <= 0) {
                                outE$iv2 = e$iv4;
                                outM$iv2 = m$iv3 >> 13;
                                if ((m$iv3 & 4096) != 0) {
                                    int out$iv5 = (outE$iv2 << 10) | outM$iv2;
                                    i3 = (short) ((s$iv2 << 15) | (out$iv5 + 1));
                                }
                                int $i$f$floatToHalf6 = i3;
                                int a3 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                int id3 = colorSpace.getId();
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf6)) << 16) | ((((long) a3) & 1023) << 6) | (((long) id3) & 63)));
                            }
                            if (e$iv4 >= -10) {
                                m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                if ((m$iv4 & 4096) != 0) {
                                    m$iv4 += 8192;
                                }
                                outM$iv2 = m$iv4 >> 13;
                            }
                        }
                    }
                    int out$iv6 = s$iv2 << 15;
                    i3 = (short) (out$iv6 | (outE$iv2 << 10) | outM$iv2);
                    int $i$f$floatToHalf7 = i3;
                    int a4 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    int id4 = colorSpace.getId();
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf7)) << 16) | ((((long) a4) & 1023) << 6) | (((long) id4) & 63)));
                }
                if (e$iv6 >= -10) {
                    int m$iv6 = (m$iv5 | 8388608) >> (1 - e$iv6);
                    if ((m$iv6 & 4096) != 0) {
                        m$iv6 += 8192;
                    }
                    outM$iv3 = m$iv6 >> 13;
                }
            }
        }
        i = (short) ((s$iv3 << 15) | (outE$iv3 << 10) | outM$iv3);
        int $i$f$floatToHalf8 = i;
        int bits$iv5 = Float.floatToRawIntBits(green);
        s$iv = bits$iv5 >>> 31;
        e$iv = (bits$iv5 >>> 23) & 255;
        m$iv = bits$iv5 & 8388607;
        outE$iv = 0;
        outM$iv = 0;
        if (e$iv == 255) {
            outE$iv = 31;
            if (m$iv != 0) {
                i5 = 512;
            } else {
                i5 = 0;
            }
            outM$iv = i5;
        } else {
            e$iv2 = (e$iv - 127) + 15;
            if (e$iv2 >= 31) {
                outE$iv = 49;
            } else {
                if (e$iv2 <= 0) {
                    outE$iv = e$iv2;
                    outM$iv = m$iv >> 13;
                    if ((m$iv & 4096) != 0) {
                        int out$iv7 = (outE$iv << 10) | outM$iv;
                        i2 = (short) ((out$iv7 + 1) | (s$iv << 15));
                    }
                    int $i$f$floatToHalf9 = i2;
                    int bits$iv6 = Float.floatToRawIntBits(blue);
                    s$iv2 = bits$iv6 >>> 31;
                    e$iv3 = (bits$iv6 >>> 23) & 255;
                    m$iv3 = bits$iv6 & 8388607;
                    outE$iv2 = 0;
                    outM$iv2 = 0;
                    if (e$iv3 == 255) {
                        outE$iv2 = 31;
                        if (m$iv3 != 0) {
                            i4 = 512;
                        } else {
                            i4 = 0;
                        }
                        outM$iv2 = i4;
                    } else {
                        e$iv4 = (e$iv3 - 127) + 15;
                        if (e$iv4 >= 31) {
                            outE$iv2 = 49;
                        } else {
                            if (e$iv4 <= 0) {
                                outE$iv2 = e$iv4;
                                outM$iv2 = m$iv3 >> 13;
                                if ((m$iv3 & 4096) != 0) {
                                    int out$iv8 = (outE$iv2 << 10) | outM$iv2;
                                    i3 = (short) ((s$iv2 << 15) | (out$iv8 + 1));
                                }
                                int $i$f$floatToHalf10 = i3;
                                int a5 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                                int id5 = colorSpace.getId();
                                return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf10)) << 16) | ((((long) a5) & 1023) << 6) | (((long) id5) & 63)));
                            }
                            if (e$iv4 >= -10) {
                                m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                                if ((m$iv4 & 4096) != 0) {
                                    m$iv4 += 8192;
                                }
                                outM$iv2 = m$iv4 >> 13;
                            }
                        }
                    }
                    int out$iv9 = s$iv2 << 15;
                    i3 = (short) (out$iv9 | (outE$iv2 << 10) | outM$iv2);
                    int $i$f$floatToHalf11 = i3;
                    int a6 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    int id6 = colorSpace.getId();
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf11)) << 16) | ((((long) a6) & 1023) << 6) | (((long) id6) & 63)));
                }
                if (e$iv2 >= -10) {
                    m$iv2 = (m$iv | 8388608) >> (1 - e$iv2);
                    if ((m$iv2 & 4096) != 0) {
                        m$iv2 += 8192;
                    }
                    outM$iv = m$iv2 >> 13;
                }
            }
        }
        i2 = (short) ((s$iv << 15) | (outE$iv << 10) | outM$iv);
        int $i$f$floatToHalf12 = i2;
        int bits$iv7 = Float.floatToRawIntBits(blue);
        s$iv2 = bits$iv7 >>> 31;
        e$iv3 = (bits$iv7 >>> 23) & 255;
        m$iv3 = bits$iv7 & 8388607;
        outE$iv2 = 0;
        outM$iv2 = 0;
        if (e$iv3 == 255) {
            outE$iv2 = 31;
            if (m$iv3 != 0) {
                i4 = 512;
            } else {
                i4 = 0;
            }
            outM$iv2 = i4;
        } else {
            e$iv4 = (e$iv3 - 127) + 15;
            if (e$iv4 >= 31) {
                outE$iv2 = 49;
            } else {
                if (e$iv4 <= 0) {
                    outE$iv2 = e$iv4;
                    outM$iv2 = m$iv3 >> 13;
                    if ((m$iv3 & 4096) != 0) {
                        int out$iv10 = (outE$iv2 << 10) | outM$iv2;
                        i3 = (short) ((s$iv2 << 15) | (out$iv10 + 1));
                    }
                    int $i$f$floatToHalf13 = i3;
                    int a7 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
                    int id7 = colorSpace.getId();
                    return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf13)) << 16) | ((((long) a7) & 1023) << 6) | (((long) id7) & 63)));
                }
                if (e$iv4 >= -10) {
                    m$iv4 = (m$iv3 | 8388608) >> (1 - e$iv4);
                    if ((m$iv4 & 4096) != 0) {
                        m$iv4 += 8192;
                    }
                    outM$iv2 = m$iv4 >> 13;
                }
            }
        }
        int out$iv11 = s$iv2 << 15;
        i3 = (short) (out$iv11 | (outE$iv2 << 10) | outM$iv2);
        int $i$f$floatToHalf14 = i3;
        int a8 = (int) ((Math.max(0.0f, Math.min(alpha, 1.0f)) * 1023.0f) + 0.5f);
        int id8 = colorSpace.getId();
        return Color.m4287constructorimpl(ULong.m7867constructorimpl(((((long) $i$f$floatToHalf8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) $i$f$floatToHalf12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) $i$f$floatToHalf14)) << 16) | ((((long) a8) & 1023) << 6) | (((long) id8) & 63)));
    }

    public static final long Color(int color) {
        return Color.m4287constructorimpl(ULong.m7867constructorimpl(ULong.m7867constructorimpl(color) << 32));
    }

    public static final long Color(long color) {
        return Color.m4287constructorimpl(ULong.m7867constructorimpl(color << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int red, int green, int blue, int alpha) {
        int color = ((alpha & 255) << 24) | ((red & 255) << 16) | ((green & 255) << 8) | (blue & 255);
        return Color(color);
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m4342lerpjxsXWHM(long start, long stop, float fraction) {
        ColorSpace colorSpace = ColorSpaces.INSTANCE.getOklab();
        long startColor = Color.m4288convertvNxB06k(start, colorSpace);
        long endColor = Color.m4288convertvNxB06k(stop, colorSpace);
        float startAlpha = Color.m4293getAlphaimpl(startColor);
        float startL = Color.m4297getRedimpl(startColor);
        float startA = Color.m4296getGreenimpl(startColor);
        float startB = Color.m4294getBlueimpl(startColor);
        float endAlpha = Color.m4293getAlphaimpl(endColor);
        float endL = Color.m4297getRedimpl(endColor);
        float endA = Color.m4296getGreenimpl(endColor);
        float endB = Color.m4294getBlueimpl(endColor);
        float fLerp = MathHelpersKt.lerp(startL, endL, fraction);
        float fLerp2 = MathHelpersKt.lerp(startA, endA, fraction);
        float endA2 = MathHelpersKt.lerp(startB, endB, fraction);
        float endB2 = MathHelpersKt.lerp(startAlpha, endAlpha, fraction);
        long interpolated = UncheckedColor(fLerp, fLerp2, endA2, endB2, colorSpace);
        return Color.m4288convertvNxB06k(interpolated, Color.m4295getColorSpaceimpl(stop));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m4336compositeOverOWjLjI(long $this$compositeOver_u2d_u2dOWjLjI, long background) {
        long fg = Color.m4288convertvNxB06k($this$compositeOver_u2d_u2dOWjLjI, Color.m4295getColorSpaceimpl(background));
        float bgA = Color.m4293getAlphaimpl(background);
        float fgA = Color.m4293getAlphaimpl(fg);
        float a = ((1.0f - fgA) * bgA) + fgA;
        float fgC$iv = Color.m4297getRedimpl(fg);
        float bgC$iv = Color.m4297getRedimpl(background);
        float fgC$iv2 = (a > 0.0f ? 1 : (a == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((fgC$iv * fgA) + ((bgC$iv * bgA) * (1.0f - fgA))) / a;
        float fgC$iv3 = Color.m4296getGreenimpl(fg);
        float bgC$iv2 = Color.m4296getGreenimpl(background);
        float fgC$iv4 = (a > 0.0f ? 1 : (a == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((fgC$iv3 * fgA) + ((bgC$iv2 * bgA) * (1.0f - fgA))) / a;
        float fgC$iv5 = Color.m4294getBlueimpl(fg);
        float bgC$iv3 = Color.m4294getBlueimpl(background);
        float b = a == 0.0f ? 0.0f : ((fgC$iv5 * fgA) + ((bgC$iv3 * bgA) * (1.0f - fgA))) / a;
        return UncheckedColor(fgC$iv2, fgC$iv4, b, a, Color.m4295getColorSpaceimpl(background));
    }

    private static final float compositeComponent(float fgC, float bgC, float fgA, float bgA, float a) {
        if (a == 0.0f) {
            return 0.0f;
        }
        return ((fgC * fgA) + ((bgC * bgA) * (1.0f - fgA))) / a;
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m4337getComponents8_81llA(long $this$getComponents_u2d8_81llA) {
        return new float[]{Color.m4297getRedimpl($this$getComponents_u2d8_81llA), Color.m4296getGreenimpl($this$getComponents_u2d8_81llA), Color.m4294getBlueimpl($this$getComponents_u2d8_81llA), Color.m4293getAlphaimpl($this$getComponents_u2d8_81llA)};
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m4343luminance8_81llA(long $this$luminance_u2d8_81llA) {
        ColorSpace colorSpace = Color.m4295getColorSpaceimpl($this$luminance_u2d8_81llA);
        boolean value$iv = ColorModel.m4706equalsimpl0(colorSpace.getModel(), ColorModel.INSTANCE.m4713getRgbxdoWZVw());
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m4709toStringimpl(colorSpace.getModel())));
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotf = ((Rgb) colorSpace).getEotfFunc();
        double r = eotf.invoke(Color.m4297getRedimpl($this$luminance_u2d8_81llA));
        double g = eotf.invoke(Color.m4296getGreenimpl($this$luminance_u2d8_81llA));
        double b = eotf.invoke(Color.m4294getBlueimpl($this$luminance_u2d8_81llA));
        float $this$fastCoerceIn$iv = (float) ((0.2126d * r) + (0.7152d * g) + (0.0722d * b));
        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
            return 1.0f;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m4345toArgb8_81llA(long $this$toArgb_u2d8_81llA) {
        return (int) ULong.m7867constructorimpl(Color.m4288convertvNxB06k($this$toArgb_u2d8_81llA, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m4338isSpecified8_81llA(long $this$isSpecified) {
        return $this$isSpecified != 16;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m4340isUnspecified8_81llA(long $this$isUnspecified) {
        return $this$isUnspecified == 16;
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m4344takeOrElseDxMtmZc(long $this$takeOrElse_u2dDxMtmZc, Function0<Color> function0) {
        return ($this$takeOrElse_u2dDxMtmZc > 16L ? 1 : ($this$takeOrElse_u2dDxMtmZc == 16L ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc : function0.invoke().m4301unboximpl();
    }
}

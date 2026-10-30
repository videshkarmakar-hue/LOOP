package com.kyant.monet;

import androidx.compose.material3.ColorScheme;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.material.hct.Hct;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TonalPalettes.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\t\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\t\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\t¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m195d2 = {"Lcom/kyant/monet/TonalPalettes;", "", "keyColor", "Landroidx/compose/ui/graphics/Color;", "style", "Lcom/kyant/monet/PaletteStyle;", "accent1", "", "", "Lcom/kyant/monet/TonalPalette;", "accent2", "accent3", "neutral1", "neutral2", "(JLcom/kyant/monet/PaletteStyle;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKeyColor-0d7_KjU", "()J", "J", "getStyle", "()Lcom/kyant/monet/PaletteStyle;", "tone", "accent1-vNxB06k", "(D)J", "accent2-vNxB06k", "accent3-vNxB06k", "neutral1-vNxB06k", "neutral2-vNxB06k", "Companion", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TonalPalettes {
    private final Map<Double, Color> accent1;
    private final Map<Double, Color> accent2;
    private final Map<Double, Color> accent3;
    private final long keyColor;
    private final Map<Double, Color> neutral1;
    private final Map<Double, Color> neutral2;
    private final PaletteStyle style;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final double[] M3TonalValues = {0.0d, 10.0d, 20.0d, 30.0d, 40.0d, 50.0d, 60.0d, 70.0d, 80.0d, 85.0d, 90.0d, 95.0d, 99.0d, 100.0d};
    private static final double[] M3SurfaceTonalValues = {0.0d, 4.0d, 6.0d, 10.0d, 12.0d, 17.0d, 20.0d, 22.0d, 24.0d, 30.0d, 40.0d, 50.0d, 60.0d, 70.0d, 80.0d, 85.0d, 87.0d, 90.0d, 92.0d, 94.0d, 95.0d, 96.0d, 98.0d, 99.0d, 100.0d};

    public /* synthetic */ TonalPalettes(long j, PaletteStyle paletteStyle, Map map, Map map2, Map map3, Map map4, Map map5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, paletteStyle, map, map2, map3, map4, map5);
    }

    private TonalPalettes(long keyColor, PaletteStyle style, Map<Double, Color> accent1, Map<Double, Color> accent2, Map<Double, Color> accent3, Map<Double, Color> neutral1, Map<Double, Color> neutral2) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(accent1, "accent1");
        Intrinsics.checkNotNullParameter(accent2, "accent2");
        Intrinsics.checkNotNullParameter(accent3, "accent3");
        Intrinsics.checkNotNullParameter(neutral1, "neutral1");
        Intrinsics.checkNotNullParameter(neutral2, "neutral2");
        this.keyColor = keyColor;
        this.style = style;
        this.accent1 = accent1;
        this.accent2 = accent2;
        this.accent3 = accent3;
        this.neutral1 = neutral1;
        this.neutral2 = neutral2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TonalPalettes(long j, PaletteStyle paletteStyle, Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        PaletteStyle tonalSpot;
        if ((i & 2) == 0) {
            tonalSpot = paletteStyle;
        } else {
            tonalSpot = PaletteStyle.INSTANCE.getTonalSpot();
        }
        this(j, tonalSpot, map, map2, map3, map4, map5, null);
    }

    /* JADX INFO: renamed from: getKeyColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getKeyColor() {
        return this.keyColor;
    }

    public final PaletteStyle getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: accent1-vNxB06k, reason: not valid java name */
    public final long m7202accent1vNxB06k(double tone) {
        Color colorM4281boximpl = this.accent1.get(Double.valueOf(tone));
        if (colorM4281boximpl == null) {
            colorM4281boximpl = Color.m4281boximpl(INSTANCE.m7212transformswEIR5s(this.keyColor, tone, this.style.getAccent1Spec()));
        }
        return colorM4281boximpl.m4301unboximpl();
    }

    /* JADX INFO: renamed from: accent2-vNxB06k, reason: not valid java name */
    public final long m7203accent2vNxB06k(double tone) {
        Color colorM4281boximpl = this.accent2.get(Double.valueOf(tone));
        if (colorM4281boximpl == null) {
            colorM4281boximpl = Color.m4281boximpl(INSTANCE.m7212transformswEIR5s(this.keyColor, tone, this.style.getAccent2Spec()));
        }
        return colorM4281boximpl.m4301unboximpl();
    }

    /* JADX INFO: renamed from: accent3-vNxB06k, reason: not valid java name */
    public final long m7204accent3vNxB06k(double tone) {
        Color colorM4281boximpl = this.accent3.get(Double.valueOf(tone));
        if (colorM4281boximpl == null) {
            colorM4281boximpl = Color.m4281boximpl(INSTANCE.m7212transformswEIR5s(this.keyColor, tone, this.style.getAccent3Spec()));
        }
        return colorM4281boximpl.m4301unboximpl();
    }

    /* JADX INFO: renamed from: neutral1-vNxB06k, reason: not valid java name */
    public final long m7206neutral1vNxB06k(double tone) {
        Color colorM4281boximpl = this.neutral1.get(Double.valueOf(tone));
        if (colorM4281boximpl == null) {
            colorM4281boximpl = Color.m4281boximpl(INSTANCE.m7212transformswEIR5s(this.keyColor, tone, this.style.getNeutral1Spec()));
        }
        return colorM4281boximpl.m4301unboximpl();
    }

    /* JADX INFO: renamed from: neutral2-vNxB06k, reason: not valid java name */
    public final long m7207neutral2vNxB06k(double tone) {
        Color colorM4281boximpl = this.neutral2.get(Double.valueOf(tone));
        if (colorM4281boximpl == null) {
            colorM4281boximpl = Color.m4281boximpl(INSTANCE.m7212transformswEIR5s(this.keyColor, tone, this.style.getNeutral2Spec()));
        }
        return colorM4281boximpl.m4301unboximpl();
    }

    /* JADX INFO: compiled from: TonalPalettes.kt */
    @Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0004J(\u0010\u000e\u001a\u00020\u000f*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\t*\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"Lcom/kyant/monet/TonalPalettes$Companion;", "", "()V", "M3SurfaceTonalValues", "", "M3TonalValues", "toTonalPalette", "", "", "Landroidx/compose/ui/graphics/Color;", "Lcom/kyant/monet/TonalPalette;", "tonalValues", "toTonalPalette-DxMtmZc", "(J[D)Ljava/util/Map;", "toTonalPalettes", "Lcom/kyant/monet/TonalPalettes;", "Landroidx/compose/material3/ColorScheme;", "style", "Lcom/kyant/monet/PaletteStyle;", "toTonalPalettes-ek8zF_U", "(JLcom/kyant/monet/PaletteStyle;[D)Lcom/kyant/monet/TonalPalettes;", "transform", "tone", "spec", "Lcom/kyant/monet/ColorSpec;", "transform-swEIR5s", "(JDLcom/kyant/monet/ColorSpec;)J", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: toTonalPalettes-ek8zF_U$default, reason: not valid java name */
        public static /* synthetic */ TonalPalettes m7211toTonalPalettesek8zF_U$default(Companion companion, long j, PaletteStyle paletteStyle, double[] dArr, int i, Object obj) {
            if ((i & 1) != 0) {
                paletteStyle = PaletteStyle.INSTANCE.getTonalSpot();
            }
            if ((i & 2) != 0) {
                dArr = TonalPalettes.M3TonalValues;
            }
            return companion.m7213toTonalPalettesek8zF_U(j, paletteStyle, dArr);
        }

        /* JADX INFO: renamed from: toTonalPalettes-ek8zF_U, reason: not valid java name */
        public final TonalPalettes m7213toTonalPalettesek8zF_U(long $this$toTonalPalettes_u2dek8zF_U, PaletteStyle style, double[] tonalValues) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(tonalValues, "tonalValues");
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tonalValues.length), 16));
            for (double it : tonalValues) {
                linkedHashMap.put(Double.valueOf(it), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalettes_u2dek8zF_U, it, style.getAccent1Spec())));
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tonalValues.length), 16));
            for (double it2 : tonalValues) {
                linkedHashMap3.put(Double.valueOf(it2), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalettes_u2dek8zF_U, it2, style.getAccent2Spec())));
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap3;
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tonalValues.length), 16));
            for (double it3 : tonalValues) {
                linkedHashMap5.put(Double.valueOf(it3), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalettes_u2dek8zF_U, it3, style.getAccent3Spec())));
            }
            LinkedHashMap linkedHashMap6 = linkedHashMap5;
            double[] dArr = TonalPalettes.M3SurfaceTonalValues;
            LinkedHashMap linkedHashMap7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(dArr.length), 16));
            for (double it4 : dArr) {
                linkedHashMap7.put(Double.valueOf(it4), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalettes_u2dek8zF_U, it4, style.getNeutral1Spec())));
            }
            LinkedHashMap linkedHashMap8 = linkedHashMap7;
            LinkedHashMap linkedHashMap9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tonalValues.length), 16));
            for (double it5 : tonalValues) {
                linkedHashMap9.put(Double.valueOf(it5), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalettes_u2dek8zF_U, it5, style.getNeutral2Spec())));
            }
            return new TonalPalettes($this$toTonalPalettes_u2dek8zF_U, style, linkedHashMap2, linkedHashMap4, linkedHashMap6, linkedHashMap8, linkedHashMap9, null);
        }

        /* JADX INFO: renamed from: toTonalPalette-DxMtmZc$default, reason: not valid java name */
        static /* synthetic */ Map m7210toTonalPaletteDxMtmZc$default(Companion companion, long j, double[] dArr, int i, Object obj) {
            if ((i & 1) != 0) {
                dArr = TonalPalettes.M3TonalValues;
            }
            return companion.m7209toTonalPaletteDxMtmZc(j, dArr);
        }

        /* JADX INFO: renamed from: toTonalPalette-DxMtmZc, reason: not valid java name */
        private final Map<Double, Color> m7209toTonalPaletteDxMtmZc(long $this$toTonalPalette_u2dDxMtmZc, double[] tonalValues) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tonalValues.length), 16));
            for (double it : tonalValues) {
                linkedHashMap.put(Double.valueOf(it), Color.m4281boximpl(TonalPalettes.INSTANCE.m7212transformswEIR5s($this$toTonalPalette_u2dDxMtmZc, it, new ColorSpec(null, null, 3, null))));
            }
            return linkedHashMap;
        }

        public static /* synthetic */ TonalPalettes toTonalPalettes$default(Companion companion, ColorScheme colorScheme, double[] dArr, int i, Object obj) {
            if ((i & 1) != 0) {
                dArr = TonalPalettes.M3TonalValues;
            }
            return companion.toTonalPalettes(colorScheme, dArr);
        }

        public final TonalPalettes toTonalPalettes(ColorScheme $this$toTonalPalettes, double[] tonalValues) {
            Intrinsics.checkNotNullParameter($this$toTonalPalettes, "<this>");
            Intrinsics.checkNotNullParameter(tonalValues, "tonalValues");
            return new TonalPalettes($this$toTonalPalettes.getPrimary(), null, m7209toTonalPaletteDxMtmZc($this$toTonalPalettes.getPrimary(), tonalValues), m7209toTonalPaletteDxMtmZc($this$toTonalPalettes.getSecondary(), tonalValues), m7209toTonalPaletteDxMtmZc($this$toTonalPalettes.getTertiary(), tonalValues), m7209toTonalPaletteDxMtmZc($this$toTonalPalettes.getSurface(), TonalPalettes.M3SurfaceTonalValues), m7209toTonalPaletteDxMtmZc($this$toTonalPalettes.getSurfaceVariant(), tonalValues), 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: transform-swEIR5s, reason: not valid java name */
        public final long m7212transformswEIR5s(long $this$transform_u2dswEIR5s, double tone, ColorSpec spec) {
            Hct $this$transform_swEIR5s_u24lambda_u246 = Hct.INSTANCE.fromInt(ColorKt.m4345toArgb8_81llA($this$transform_u2dswEIR5s));
            $this$transform_swEIR5s_u24lambda_u246.setTone(tone);
            $this$transform_swEIR5s_u24lambda_u246.setChroma(spec.getChroma().invoke(Double.valueOf($this$transform_swEIR5s_u24lambda_u246.getChroma())).doubleValue());
            $this$transform_swEIR5s_u24lambda_u246.setHue(spec.getHueShift().invoke(Double.valueOf($this$transform_swEIR5s_u24lambda_u246.getHue())).doubleValue() + $this$transform_swEIR5s_u24lambda_u246.getHue());
            return ColorKt.Color($this$transform_swEIR5s_u24lambda_u246.toInt());
        }
    }
}

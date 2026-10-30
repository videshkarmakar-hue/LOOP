package com.kyant.monet;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: PaletteStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, m195d2 = {"Lcom/kyant/monet/PaletteStyle;", "", "accent1Spec", "Lcom/kyant/monet/ColorSpec;", "accent2Spec", "accent3Spec", "neutral1Spec", "neutral2Spec", "(Lcom/kyant/monet/ColorSpec;Lcom/kyant/monet/ColorSpec;Lcom/kyant/monet/ColorSpec;Lcom/kyant/monet/ColorSpec;Lcom/kyant/monet/ColorSpec;)V", "getAccent1Spec", "()Lcom/kyant/monet/ColorSpec;", "getAccent2Spec", "getAccent3Spec", "getNeutral1Spec", "getNeutral2Spec", "Companion", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PaletteStyle {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PaletteStyle Content;
    private static final PaletteStyle Expressive;
    private static final Pair<Integer, Integer>[] ExpressiveSecondaryHueRotation;
    private static final Pair<Integer, Integer>[] ExpressiveTertiaryHueRotation;
    private static final PaletteStyle FruitSalad;
    private static final PaletteStyle Monochrome;
    private static final PaletteStyle Rainbow;
    private static final PaletteStyle Spritz;
    private static final PaletteStyle TonalSpot;
    private static final PaletteStyle Vibrant;
    private static final Pair<Integer, Integer>[] VibrantSecondaryHueRotation;
    private static final Pair<Integer, Integer>[] VibrantTertiaryHueRotation;
    private final ColorSpec accent1Spec;
    private final ColorSpec accent2Spec;
    private final ColorSpec accent3Spec;
    private final ColorSpec neutral1Spec;
    private final ColorSpec neutral2Spec;

    public PaletteStyle(ColorSpec accent1Spec, ColorSpec accent2Spec, ColorSpec accent3Spec, ColorSpec neutral1Spec, ColorSpec neutral2Spec) {
        Intrinsics.checkNotNullParameter(accent1Spec, "accent1Spec");
        Intrinsics.checkNotNullParameter(accent2Spec, "accent2Spec");
        Intrinsics.checkNotNullParameter(accent3Spec, "accent3Spec");
        Intrinsics.checkNotNullParameter(neutral1Spec, "neutral1Spec");
        Intrinsics.checkNotNullParameter(neutral2Spec, "neutral2Spec");
        this.accent1Spec = accent1Spec;
        this.accent2Spec = accent2Spec;
        this.accent3Spec = accent3Spec;
        this.neutral1Spec = neutral1Spec;
        this.neutral2Spec = neutral2Spec;
    }

    public final ColorSpec getAccent1Spec() {
        return this.accent1Spec;
    }

    public final ColorSpec getAccent2Spec() {
        return this.accent2Spec;
    }

    public final ColorSpec getAccent3Spec() {
        return this.accent3Spec;
    }

    public final ColorSpec getNeutral1Spec() {
        return this.neutral1Spec;
    }

    public final ColorSpec getNeutral2Spec() {
        return this.neutral2Spec;
    }

    /* JADX INFO: compiled from: PaletteStyle.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002¢\u0006\u0002\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\"\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006!"}, m195d2 = {"Lcom/kyant/monet/PaletteStyle$Companion;", "", "()V", "Content", "Lcom/kyant/monet/PaletteStyle;", "getContent", "()Lcom/kyant/monet/PaletteStyle;", "Expressive", "getExpressive", "ExpressiveSecondaryHueRotation", "", "Lkotlin/Pair;", "", "[Lkotlin/Pair;", "ExpressiveTertiaryHueRotation", "FruitSalad", "getFruitSalad", "Monochrome", "getMonochrome", "Rainbow", "getRainbow", "Spritz", "getSpritz", "TonalSpot", "getTonalSpot", "Vibrant", "getVibrant", "VibrantSecondaryHueRotation", "VibrantTertiaryHueRotation", "hueRotation", "", "list", "(D[Lkotlin/Pair;)D", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaletteStyle getTonalSpot() {
            return PaletteStyle.TonalSpot;
        }

        public final PaletteStyle getSpritz() {
            return PaletteStyle.Spritz;
        }

        public final PaletteStyle getVibrant() {
            return PaletteStyle.Vibrant;
        }

        public final PaletteStyle getExpressive() {
            return PaletteStyle.Expressive;
        }

        public final PaletteStyle getRainbow() {
            return PaletteStyle.Rainbow;
        }

        public final PaletteStyle getFruitSalad() {
            return PaletteStyle.FruitSalad;
        }

        public final PaletteStyle getContent() {
            return PaletteStyle.Content;
        }

        public final PaletteStyle getMonochrome() {
            return PaletteStyle.Monochrome;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double hueRotation(double $this$hueRotation, Pair<Integer, Integer>[] pairArr) {
            int i = 0;
            int size = pairArr.length - 2;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    float intValue = pairArr[i2].getFirst().intValue();
                    if (pairArr[i].getFirst().intValue() <= $this$hueRotation && $this$hueRotation < intValue) {
                        double dIntValue = ($this$hueRotation + ((double) pairArr[i].getSecond().intValue())) % 360.0d;
                        if (dIntValue == 0.0d) {
                            return dIntValue;
                        }
                        return !(Math.signum(dIntValue) == Math.signum(360.0d)) ? dIntValue + 360.0d : dIntValue;
                    }
                    if (i == size) {
                        break;
                    }
                    i = i2;
                }
            }
            return $this$hueRotation;
        }
    }

    static {
        Integer numValueOf = Integer.valueOf(HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS);
        VibrantSecondaryHueRotation = new Pair[]{TuplesKt.m202to(0, 18), TuplesKt.m202to(41, 15), TuplesKt.m202to(61, 10), TuplesKt.m202to(numValueOf, 12), TuplesKt.m202to(Integer.valueOf(TarConstants.PREFIXLEN_XSTAR), 15), TuplesKt.m202to(181, 18), TuplesKt.m202to(251, 15), TuplesKt.m202to(Integer.valueOf(HttpStatusCodesKt.HTTP_MOVED_PERM), 12), TuplesKt.m202to(360, 12)};
        VibrantTertiaryHueRotation = new Pair[]{TuplesKt.m202to(0, 35), TuplesKt.m202to(41, 30), TuplesKt.m202to(61, 20), TuplesKt.m202to(numValueOf, 25), TuplesKt.m202to(Integer.valueOf(TarConstants.PREFIXLEN_XSTAR), 30), TuplesKt.m202to(181, 35), TuplesKt.m202to(251, 30), TuplesKt.m202to(Integer.valueOf(HttpStatusCodesKt.HTTP_MOVED_PERM), 25), TuplesKt.m202to(360, 25)};
        ExpressiveSecondaryHueRotation = new Pair[]{TuplesKt.m202to(0, 45), TuplesKt.m202to(21, 95), TuplesKt.m202to(51, 45), TuplesKt.m202to(121, 20), TuplesKt.m202to(151, 45), TuplesKt.m202to(191, 90), TuplesKt.m202to(271, 45), TuplesKt.m202to(321, 45), TuplesKt.m202to(360, 45)};
        ExpressiveTertiaryHueRotation = new Pair[]{TuplesKt.m202to(0, 120), TuplesKt.m202to(21, 120), TuplesKt.m202to(51, 120), TuplesKt.m202to(121, 45), TuplesKt.m202to(151, 20), TuplesKt.m202to(191, 15), TuplesKt.m202to(271, 20), TuplesKt.m202to(321, 120), TuplesKt.m202to(360, 120)};
        TonalSpot = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$1
            public final Double invoke(double it) {
                return Double.valueOf(36.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$3
            public final Double invoke(double it) {
                return Double.valueOf(16.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$4
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$5
            public final Double invoke(double it) {
                return Double.valueOf(24.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$6
            public final Double invoke(double it) {
                return Double.valueOf(60.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$7
            public final Double invoke(double it) {
                return Double.valueOf(6.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$9
            public final Double invoke(double it) {
                return Double.valueOf(8.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$TonalSpot$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Spritz = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$1
            public final Double invoke(double it) {
                return Double.valueOf(12.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$3
            public final Double invoke(double it) {
                return Double.valueOf(8.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$4
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$5
            public final Double invoke(double it) {
                return Double.valueOf(16.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$6
            public final Double invoke(double it) {
                return Double.valueOf(30.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$7
            public final Double invoke(double it) {
                return Double.valueOf(2.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$9
            public final Double invoke(double it) {
                return Double.valueOf(2.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Spritz$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Vibrant = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$1
            public final Double invoke(double it) {
                return Double.valueOf(48.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$3
            public final Double invoke(double it) {
                return Double.valueOf(24.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$4
            public final Double invoke(double it) {
                return Double.valueOf(PaletteStyle.INSTANCE.hueRotation(it, PaletteStyle.VibrantSecondaryHueRotation));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$5
            public final Double invoke(double it) {
                return Double.valueOf(32.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$6
            public final Double invoke(double it) {
                return Double.valueOf(PaletteStyle.INSTANCE.hueRotation(it, PaletteStyle.VibrantTertiaryHueRotation));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$7
            public final Double invoke(double it) {
                return Double.valueOf(10.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$9
            public final Double invoke(double it) {
                return Double.valueOf(12.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Vibrant$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Expressive = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$1
            public final Double invoke(double it) {
                return Double.valueOf(40.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$2
            public final Double invoke(double it) {
                return Double.valueOf(240.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$3
            public final Double invoke(double it) {
                return Double.valueOf(24.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$4
            public final Double invoke(double it) {
                return Double.valueOf(PaletteStyle.INSTANCE.hueRotation(it, PaletteStyle.ExpressiveSecondaryHueRotation));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$5
            public final Double invoke(double it) {
                return Double.valueOf(32.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$6
            public final Double invoke(double it) {
                return Double.valueOf(PaletteStyle.INSTANCE.hueRotation(it, PaletteStyle.ExpressiveTertiaryHueRotation));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$7
            public final Double invoke(double it) {
                return Double.valueOf(15.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$8
            public final Double invoke(double it) {
                return Double.valueOf(15.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$9
            public final Double invoke(double it) {
                return Double.valueOf(12.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Expressive$10
            public final Double invoke(double it) {
                return Double.valueOf(15.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Rainbow = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$1
            public final Double invoke(double it) {
                return Double.valueOf(48.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$3
            public final Double invoke(double it) {
                return Double.valueOf(16.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$4
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$5
            public final Double invoke(double it) {
                return Double.valueOf(24.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$6
            public final Double invoke(double it) {
                return Double.valueOf(-60.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$7
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$9
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Rainbow$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        FruitSalad = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$1
            public final Double invoke(double it) {
                return Double.valueOf(48.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$2
            public final Double invoke(double it) {
                return Double.valueOf(-50.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$3
            public final Double invoke(double it) {
                return Double.valueOf(36.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$4
            public final Double invoke(double it) {
                return Double.valueOf(-30.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$5
            public final Double invoke(double it) {
                return Double.valueOf(36.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$6
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$7
            public final Double invoke(double it) {
                return Double.valueOf(10.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$9
            public final Double invoke(double it) {
                return Double.valueOf(16.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$FruitSalad$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Content = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$1
            public final Double invoke(double it) {
                return Double.valueOf(((double) 1) * it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$3
            public final Double invoke(double it) {
                return Double.valueOf(it / ((double) 3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$4
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$5
            public final Double invoke(double it) {
                return Double.valueOf((((double) 2) * it) / ((double) 3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$6
            public final Double invoke(double it) {
                return Double.valueOf(60.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$7
            public final Double invoke(double it) {
                return Double.valueOf(it / ((double) 12));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$9
            public final Double invoke(double it) {
                return Double.valueOf(it / ((double) 6));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Content$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
        Monochrome = new PaletteStyle(new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$1
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$3
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$4
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$5
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$6
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$7
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$8
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }), new ColorSpec(new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$9
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }, new Function1<Double, Double>() { // from class: com.kyant.monet.PaletteStyle$Companion$Monochrome$10
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        }));
    }
}

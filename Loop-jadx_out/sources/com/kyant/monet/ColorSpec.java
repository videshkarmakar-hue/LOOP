package com.kyant.monet;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorSpec.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m195d2 = {"Lcom/kyant/monet/ColorSpec;", "", "chroma", "Lkotlin/Function1;", "", "hueShift", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getChroma", "()Lkotlin/jvm/functions/Function1;", "getHueShift", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ColorSpec {
    public static final int $stable = 0;
    private final Function1<Double, Double> chroma;
    private final Function1<Double, Double> hueShift;

    /* JADX WARN: Multi-variable type inference failed */
    public ColorSpec() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColorSpec copy$default(ColorSpec colorSpec, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = colorSpec.chroma;
        }
        if ((i & 2) != 0) {
            function2 = colorSpec.hueShift;
        }
        return colorSpec.copy(function1, function2);
    }

    public final Function1<Double, Double> component1() {
        return this.chroma;
    }

    public final Function1<Double, Double> component2() {
        return this.hueShift;
    }

    public final ColorSpec copy(Function1<? super Double, Double> chroma, Function1<? super Double, Double> hueShift) {
        Intrinsics.checkNotNullParameter(chroma, "chroma");
        Intrinsics.checkNotNullParameter(hueShift, "hueShift");
        return new ColorSpec(chroma, hueShift);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorSpec)) {
            return false;
        }
        ColorSpec colorSpec = (ColorSpec) other;
        return Intrinsics.areEqual(this.chroma, colorSpec.chroma) && Intrinsics.areEqual(this.hueShift, colorSpec.hueShift);
    }

    public int hashCode() {
        return (this.chroma.hashCode() * 31) + this.hueShift.hashCode();
    }

    public String toString() {
        return "ColorSpec(chroma=" + this.chroma + ", hueShift=" + this.hueShift + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ColorSpec(Function1<? super Double, Double> chroma, Function1<? super Double, Double> hueShift) {
        Intrinsics.checkNotNullParameter(chroma, "chroma");
        Intrinsics.checkNotNullParameter(hueShift, "hueShift");
        this.chroma = chroma;
        this.hueShift = hueShift;
    }

    public /* synthetic */ ColorSpec(C30441 c30441, C30452 c30452, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<Double, Double>() { // from class: com.kyant.monet.ColorSpec.1
            public final Double invoke(double it) {
                return Double.valueOf(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        } : c30441, (i & 2) != 0 ? new Function1<Double, Double>() { // from class: com.kyant.monet.ColorSpec.2
            public final Double invoke(double it) {
                return Double.valueOf(0.0d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        } : c30452);
    }

    public final Function1<Double, Double> getChroma() {
        return this.chroma;
    }

    public final Function1<Double, Double> getHueShift() {
        return this.hueShift;
    }
}

package androidx.compose.material3;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007J\u0016\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, m195d2 = {"Landroidx/compose/material3/CaretProperties;", "", "caretHeight", "Landroidx/compose/ui/unit/Dp;", "caretWidth", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCaretHeight-D9Ej5fM", "()F", "F", "getCaretWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Landroidx/compose/material3/CaretProperties;", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class CaretProperties {
    public static final int $stable = 0;
    private final float caretHeight;
    private final float caretWidth;

    public /* synthetic */ CaretProperties(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: renamed from: copy-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ CaretProperties m1985copyYgX7TsA$default(CaretProperties caretProperties, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = caretProperties.caretHeight;
        }
        if ((i & 2) != 0) {
            f2 = caretProperties.caretWidth;
        }
        return caretProperties.m1988copyYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCaretHeight() {
        return this.caretHeight;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCaretWidth() {
        return this.caretWidth;
    }

    /* JADX INFO: renamed from: copy-YgX7TsA, reason: not valid java name */
    public final CaretProperties m1988copyYgX7TsA(float caretHeight, float caretWidth) {
        return new CaretProperties(caretHeight, caretWidth, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaretProperties)) {
            return false;
        }
        CaretProperties caretProperties = (CaretProperties) other;
        return C1979Dp.m6806equalsimpl0(this.caretHeight, caretProperties.caretHeight) && C1979Dp.m6806equalsimpl0(this.caretWidth, caretProperties.caretWidth);
    }

    public int hashCode() {
        return (C1979Dp.m6807hashCodeimpl(this.caretHeight) * 31) + C1979Dp.m6807hashCodeimpl(this.caretWidth);
    }

    public String toString() {
        return "CaretProperties(caretHeight=" + ((Object) C1979Dp.m6812toStringimpl(this.caretHeight)) + ", caretWidth=" + ((Object) C1979Dp.m6812toStringimpl(this.caretWidth)) + ')';
    }

    private CaretProperties(float caretHeight, float caretWidth) {
        this.caretHeight = caretHeight;
        this.caretWidth = caretWidth;
    }

    /* JADX INFO: renamed from: getCaretHeight-D9Ej5fM, reason: not valid java name */
    public final float m1989getCaretHeightD9Ej5fM() {
        return this.caretHeight;
    }

    /* JADX INFO: renamed from: getCaretWidth-D9Ej5fM, reason: not valid java name */
    public final float m1990getCaretWidthD9Ej5fM() {
        return this.caretWidth;
    }
}

package androidx.compose.p001ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0018\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0016\u0010\u001a\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0010J\u0016\u0010\u001c\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0010J\u0016\u0010\u001e\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0010J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R$\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R$\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R$\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m195d2 = {"Landroidx/compose/ui/unit/DpRect;", "", "origin", "Landroidx/compose/ui/unit/DpOffset;", "size", "Landroidx/compose/ui/unit/DpSize;", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getLeft-D9Ej5fM$annotations", "getLeft-D9Ej5fM", "getRight-D9Ej5fM$annotations", "getRight-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-a9UjIt4", "(FFFF)Landroidx/compose/ui/unit/DpRect;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class DpRect {
    public static final int $stable = 0;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public /* synthetic */ DpRect(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    public /* synthetic */ DpRect(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* JADX INFO: renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpRect m6873copya9UjIt4$default(DpRect dpRect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpRect.left;
        }
        if ((i & 2) != 0) {
            f2 = dpRect.top;
        }
        if ((i & 4) != 0) {
            f3 = dpRect.right;
        }
        if ((i & 8) != 0) {
            f4 = dpRect.bottom;
        }
        return dpRect.m6882copya9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6874getBottomD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6875getLeftD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6876getRightD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6877getTopD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: copy-a9UjIt4, reason: not valid java name */
    public final DpRect m6882copya9UjIt4(float left, float top, float right, float bottom) {
        return new DpRect(left, top, right, bottom, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) other;
        return C1979Dp.m6806equalsimpl0(this.left, dpRect.left) && C1979Dp.m6806equalsimpl0(this.top, dpRect.top) && C1979Dp.m6806equalsimpl0(this.right, dpRect.right) && C1979Dp.m6806equalsimpl0(this.bottom, dpRect.bottom);
    }

    public int hashCode() {
        return (((((C1979Dp.m6807hashCodeimpl(this.left) * 31) + C1979Dp.m6807hashCodeimpl(this.top)) * 31) + C1979Dp.m6807hashCodeimpl(this.right)) * 31) + C1979Dp.m6807hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "DpRect(left=" + ((Object) C1979Dp.m6812toStringimpl(this.left)) + ", top=" + ((Object) C1979Dp.m6812toStringimpl(this.top)) + ", right=" + ((Object) C1979Dp.m6812toStringimpl(this.right)) + ", bottom=" + ((Object) C1979Dp.m6812toStringimpl(this.bottom)) + ')';
    }

    private DpRect(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m6884getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m6886getTopD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m6885getRightD9Ej5fM() {
        return this.right;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m6883getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private DpRect(long origin, long size) {
        float fM6862getXD9Ej5fM = DpOffset.m6862getXD9Ej5fM(origin);
        float fM6864getYD9Ej5fM = DpOffset.m6864getYD9Ej5fM(origin);
        float arg0$iv = DpOffset.m6862getXD9Ej5fM(origin);
        float other$iv = DpSize.m6899getWidthD9Ej5fM(size);
        float other$iv2 = C1979Dp.m6801constructorimpl(arg0$iv + other$iv);
        float arg0$iv2 = DpOffset.m6864getYD9Ej5fM(origin);
        float other$iv3 = DpSize.m6897getHeightD9Ej5fM(size);
        this(fM6862getXD9Ej5fM, fM6864getYD9Ej5fM, other$iv2, C1979Dp.m6801constructorimpl(arg0$iv2 + other$iv3), null);
    }
}

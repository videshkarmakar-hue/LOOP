package androidx.compose.material3;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentWidth-D9Ej5fM", "()F", "F", "getLeft-D9Ej5fM", "right", "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3);
    }

    private TabPosition(float left, float width, float contentWidth) {
        this.left = left;
        this.width = width;
        this.contentWidth = contentWidth;
    }

    /* JADX INFO: renamed from: getContentWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getContentWidth() {
        return this.contentWidth;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name and from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m2710getRightD9Ej5fM() {
        float arg0$iv = this.left;
        float other$iv = this.width;
        return C1979Dp.m6801constructorimpl(arg0$iv + other$iv);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TabPosition) && C1979Dp.m6806equalsimpl0(this.left, ((TabPosition) other).left) && C1979Dp.m6806equalsimpl0(this.width, ((TabPosition) other).width) && C1979Dp.m6806equalsimpl0(this.contentWidth, ((TabPosition) other).contentWidth);
    }

    public int hashCode() {
        int result = C1979Dp.m6807hashCodeimpl(this.left);
        return (((result * 31) + C1979Dp.m6807hashCodeimpl(this.width)) * 31) + C1979Dp.m6807hashCodeimpl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C1979Dp.m6812toStringimpl(this.left)) + ", right=" + ((Object) C1979Dp.m6812toStringimpl(m2710getRightD9Ej5fM())) + ", width=" + ((Object) C1979Dp.m6812toStringimpl(this.width)) + ", contentWidth=" + ((Object) C1979Dp.m6812toStringimpl(this.contentWidth)) + ')';
    }
}

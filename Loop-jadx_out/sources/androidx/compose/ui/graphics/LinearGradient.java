package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        List list3;
        int iM4424getClamp3opZhB0;
        if ((i2 & 2) == 0) {
            list3 = list2;
        } else {
            list3 = null;
        }
        if ((i2 & 16) == 0) {
            iM4424getClamp3opZhB0 = i;
        } else {
            iM4424getClamp3opZhB0 = TileMode.INSTANCE.m4424getClamp3opZhB0();
        }
        this(list, list3, j, j2, iM4424getClamp3opZhB0, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long start, long end, int tileMode) {
        this.colors = list;
        this.stops = list2;
        this.start = start;
        this.end = end;
        this.tileMode = tileMode;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        float fAbs;
        float fM3801getXimpl = Offset.m3801getXimpl(this.start);
        float fAbs2 = Float.NaN;
        if ((Float.isInfinite(fM3801getXimpl) || Float.isNaN(fM3801getXimpl)) ? false : true) {
            float fM3801getXimpl2 = Offset.m3801getXimpl(this.end);
            if ((Float.isInfinite(fM3801getXimpl2) || Float.isNaN(fM3801getXimpl2)) ? false : true) {
                fAbs = Math.abs(Offset.m3801getXimpl(this.start) - Offset.m3801getXimpl(this.end));
            } else {
                fAbs = Float.NaN;
            }
        } else {
            fAbs = Float.NaN;
        }
        float fM3802getYimpl = Offset.m3802getYimpl(this.start);
        if ((Float.isInfinite(fM3802getYimpl) || Float.isNaN(fM3802getYimpl)) ? false : true) {
            float fM3802getYimpl2 = Offset.m3802getYimpl(this.end);
            if ((Float.isInfinite(fM3802getYimpl2) || Float.isNaN(fM3802getYimpl2)) ? false : true) {
                fAbs2 = Math.abs(Offset.m3802getYimpl(this.start) - Offset.m3802getYimpl(this.end));
            }
        }
        return SizeKt.Size(fAbs, fAbs2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo4012createShaderuvyYCjk(long size) {
        float startX = (Offset.m3801getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m3801getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m3870getWidthimpl(size) : Offset.m3801getXimpl(this.start);
        float startY = (Offset.m3802getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m3802getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m3867getHeightimpl(size) : Offset.m3802getYimpl(this.start);
        float endX = (Offset.m3801getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m3801getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m3870getWidthimpl(size) : Offset.m3801getXimpl(this.end);
        float endY = Offset.m3802getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m3867getHeightimpl(size) : Offset.m3802getYimpl(this.end);
        return ShaderKt.m4366LinearGradientShaderVjE6UOU(OffsetKt.Offset(startX, startY), OffsetKt.Offset(endX, endY), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LinearGradient) && Intrinsics.areEqual(this.colors, ((LinearGradient) other).colors) && Intrinsics.areEqual(this.stops, ((LinearGradient) other).stops) && Offset.m3798equalsimpl0(this.start, ((LinearGradient) other).start) && Offset.m3798equalsimpl0(this.end, ((LinearGradient) other).end) && TileMode.m4420equalsimpl0(this.tileMode, ((LinearGradient) other).tileMode);
    }

    public int hashCode() {
        int result = this.colors.hashCode();
        int i = result * 31;
        List<Float> list = this.stops;
        int result2 = i + (list != null ? list.hashCode() : 0);
        return (((((result2 * 31) + Offset.m3803hashCodeimpl(this.start)) * 31) + Offset.m3803hashCodeimpl(this.end)) * 31) + TileMode.m4421hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String startValue = OffsetKt.m3818isFinitek4lQ0M(this.start) ? "start=" + ((Object) Offset.m3809toStringimpl(this.start)) + ", " : "";
        String endValue = OffsetKt.m3818isFinitek4lQ0M(this.end) ? "end=" + ((Object) Offset.m3809toStringimpl(this.end)) + ", " : "";
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + startValue + endValue + "tileMode=" + ((Object) TileMode.m4422toStringimpl(this.tileMode)) + ')';
    }
}

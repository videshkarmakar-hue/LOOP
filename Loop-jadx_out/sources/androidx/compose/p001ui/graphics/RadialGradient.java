package androidx.compose.p001ui.graphics;

import android.graphics.Shader;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m195d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RadialGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        List list3;
        int iM4672getClamp3opZhB0;
        if ((i2 & 2) == 0) {
            list3 = list2;
        } else {
            list3 = null;
        }
        if ((i2 & 16) == 0) {
            iM4672getClamp3opZhB0 = i;
        } else {
            iM4672getClamp3opZhB0 = TileMode.INSTANCE.m4672getClamp3opZhB0();
        }
        this(list, list3, j, f, iM4672getClamp3opZhB0, null);
    }

    private RadialGradient(List<Color> list, List<Float> list2, long center, float radius, int tileMode) {
        this.colors = list;
        this.stops = list2;
        this.center = center;
        this.radius = radius;
        this.tileMode = tileMode;
    }

    @Override // androidx.compose.p001ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        float f = this.radius;
        if (!((Float.isInfinite(f) || Float.isNaN(f)) ? false : true)) {
            return Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        }
        float f2 = 2;
        return SizeKt.Size(this.radius * f2, this.radius * f2);
    }

    @Override // androidx.compose.p001ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo4260createShaderuvyYCjk(long size) {
        float centerX;
        float centerY;
        if (OffsetKt.m4070isUnspecifiedk4lQ0M(this.center)) {
            long drawCenter = SizeKt.m4128getCenteruvyYCjk(size);
            centerX = Offset.m4049getXimpl(drawCenter);
            centerY = Offset.m4050getYimpl(drawCenter);
        } else {
            centerX = (Offset.m4049getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m4049getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m4118getWidthimpl(size) : Offset.m4049getXimpl(this.center);
            centerY = (Offset.m4050getYimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m4050getYimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m4115getHeightimpl(size) : Offset.m4050getYimpl(this.center);
        }
        return ShaderKt.m4616RadialGradientShader8uybcMk(OffsetKt.Offset(centerX, centerY), this.radius == Float.POSITIVE_INFINITY ? Size.m4117getMinDimensionimpl(size) / 2 : this.radius, this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RadialGradient) && Intrinsics.areEqual(this.colors, ((RadialGradient) other).colors) && Intrinsics.areEqual(this.stops, ((RadialGradient) other).stops) && Offset.m4046equalsimpl0(this.center, ((RadialGradient) other).center)) {
            return ((this.radius > ((RadialGradient) other).radius ? 1 : (this.radius == ((RadialGradient) other).radius ? 0 : -1)) == 0) && TileMode.m4668equalsimpl0(this.tileMode, ((RadialGradient) other).tileMode);
        }
        return false;
    }

    public int hashCode() {
        int result = this.colors.hashCode();
        int i = result * 31;
        List<Float> list = this.stops;
        int result2 = i + (list != null ? list.hashCode() : 0);
        return (((((result2 * 31) + Offset.m4051hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m4669hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String centerValue = OffsetKt.m4068isSpecifiedk4lQ0M(this.center) ? "center=" + ((Object) Offset.m4057toStringimpl(this.center)) + ", " : "";
        float f = this.radius;
        String radiusValue = !Float.isInfinite(f) && !Float.isNaN(f) ? "radius=" + this.radius + ", " : "";
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + centerValue + radiusValue + "tileMode=" + ((Object) TileMode.m4670toStringimpl(this.tileMode)) + ')';
    }
}

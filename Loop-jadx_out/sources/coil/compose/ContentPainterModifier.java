package coil.compose;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.DrawModifier;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutModifier;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.ScaleFactor;
import androidx.compose.p001ui.layout.ScaleFactorKt;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.platform.InspectorValueInfo;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ContentPainterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0013J\t\u0010$\u001a\u00020%HÖ\u0001J\f\u0010&\u001a\u00020'*\u00020(H\u0016J\u001c\u0010)\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u0010.\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016J)\u00100\u001a\u000201*\u0002022\u0006\u0010+\u001a\u0002032\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u00107\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, m195d2 = {"Lcoil/compose/ContentPainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Painter getPainter() {
        return this.painter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public static /* synthetic */ ContentPainterModifier copy$default(ContentPainterModifier contentPainterModifier, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = contentPainterModifier.painter;
        }
        if ((i & 2) != 0) {
            alignment = contentPainterModifier.alignment;
        }
        Alignment alignment2 = alignment;
        if ((i & 4) != 0) {
            contentScale = contentPainterModifier.contentScale;
        }
        ContentScale contentScale2 = contentScale;
        if ((i & 8) != 0) {
            f = contentPainterModifier.alpha;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            colorFilter = contentPainterModifier.colorFilter;
        }
        return contentPainterModifier.copy(painter, alignment2, contentScale2, f2, colorFilter);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public final ContentPainterModifier copy(Painter painter, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        return new ContentPainterModifier(painter, alignment, contentScale, alpha, colorFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) other;
        return Intrinsics.areEqual(this.painter, contentPainterModifier.painter) && Intrinsics.areEqual(this.alignment, contentPainterModifier.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterModifier.contentScale) && Float.compare(this.alpha, contentPainterModifier.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, contentPainterModifier.colorFilter);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    public int hashCode() {
        return (((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31) + (this.colorFilter == null ? 0 : this.colorFilter.hashCode());
    }

    @Override // androidx.compose.p001ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public ContentPainterModifier(final Painter painter, final Alignment alignment, final ContentScale contentScale, final float alpha, final ColorFilter colorFilter) {
        super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: coil.compose.ContentPainterModifier$special$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("content");
                $this$null.getProperties().set("painter", painter);
                $this$null.getProperties().set("alignment", alignment);
                $this$null.getProperties().set("contentScale", contentScale);
                $this$null.getProperties().set("alpha", Float.valueOf(alpha));
                $this$null.getProperties().set("colorFilter", colorFilter);
            }
        } : InspectableValueKt.getNoInspectorInfo());
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.p001ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo311measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable placeable = measurable.mo5644measureBRTryo0(m7139modifyConstraintsZezNO4M(constraints));
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterModifier$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p001ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        if ($this$isSpecified$iv != Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
            int layoutWidth = measurable.minIntrinsicWidth(Constraints.m6743getMaxHeightimpl(m7139modifyConstraintsZezNO4M(constraints)));
            long scaledSize = m7138calculateScaledSizeE7KxVPU(SizeKt.Size(layoutWidth, height));
            return Math.max(MathKt.roundToInt(Size.m4118getWidthimpl(scaledSize)), layoutWidth);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.p001ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        if ($this$isSpecified$iv != Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            long constraints = ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null);
            int layoutWidth = measurable.maxIntrinsicWidth(Constraints.m6743getMaxHeightimpl(m7139modifyConstraintsZezNO4M(constraints)));
            long scaledSize = m7138calculateScaledSizeE7KxVPU(SizeKt.Size(layoutWidth, height));
            return Math.max(MathKt.roundToInt(Size.m4118getWidthimpl(scaledSize)), layoutWidth);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.p001ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        if ($this$isSpecified$iv != Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
            int layoutHeight = measurable.minIntrinsicHeight(Constraints.m6744getMaxWidthimpl(m7139modifyConstraintsZezNO4M(constraints)));
            long scaledSize = m7138calculateScaledSizeE7KxVPU(SizeKt.Size(width, layoutHeight));
            return Math.max(MathKt.roundToInt(Size.m4115getHeightimpl(scaledSize)), layoutHeight);
        }
        return measurable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.p001ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        if ($this$isSpecified$iv != Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            long constraints = ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null);
            int layoutHeight = measurable.maxIntrinsicHeight(Constraints.m6744getMaxWidthimpl(m7139modifyConstraintsZezNO4M(constraints)));
            long scaledSize = m7138calculateScaledSizeE7KxVPU(SizeKt.Size(width, layoutHeight));
            return Math.max(MathKt.roundToInt(Size.m4115getHeightimpl(scaledSize)), layoutHeight);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m7138calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m4120isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m4127getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m4126getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float $this$takeOrElse$iv = Size.m4118getWidthimpl(intrinsicSize);
        if (!((Float.isInfinite($this$takeOrElse$iv) || Float.isNaN($this$takeOrElse$iv)) ? false : true)) {
            $this$takeOrElse$iv = Size.m4118getWidthimpl(dstSize);
        }
        float $this$takeOrElse$iv2 = Size.m4115getHeightimpl(intrinsicSize);
        if (!((Float.isInfinite($this$takeOrElse$iv2) || Float.isNaN($this$takeOrElse$iv2)) ? false : true)) {
            $this$takeOrElse$iv2 = Size.m4115getHeightimpl(dstSize);
        }
        long srcSize = SizeKt.Size($this$takeOrElse$iv, $this$takeOrElse$iv2);
        long scaleFactor = this.contentScale.mo5635computeScaleFactorH7hwNQA(srcSize, dstSize);
        float fM5731getScaleXimpl = ScaleFactor.m5731getScaleXimpl(scaleFactor);
        if ((Float.isInfinite(fM5731getScaleXimpl) || Float.isNaN(fM5731getScaleXimpl)) ? false : true) {
            float fM5732getScaleYimpl = ScaleFactor.m5732getScaleYimpl(scaleFactor);
            if ((Float.isInfinite(fM5732getScaleYimpl) || Float.isNaN(fM5732getScaleYimpl)) ? false : true) {
                return ScaleFactorKt.m5747timesmw2e94(scaleFactor, srcSize);
            }
        }
        return dstSize;
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m7139modifyConstraintsZezNO4M(long constraints) {
        float dstWidth;
        float dstHeight;
        boolean hasFixedWidth = Constraints.m6742getHasFixedWidthimpl(constraints);
        boolean hasFixedHeight = Constraints.m6741getHasFixedHeightimpl(constraints);
        if (hasFixedWidth && hasFixedHeight) {
            return constraints;
        }
        boolean hasBoundedSize = Constraints.m6740getHasBoundedWidthimpl(constraints) && Constraints.m6739getHasBoundedHeightimpl(constraints);
        long intrinsicSize = this.painter.getIntrinsicSize();
        if ((intrinsicSize == Size.INSTANCE.m4126getUnspecifiedNHjbRc() ? 1 : 0) != 0) {
            if (hasBoundedSize) {
                return Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : Constraints.m6744getMaxWidthimpl(constraints), (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : Constraints.m6743getMaxHeightimpl(constraints), (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
            }
            return constraints;
        }
        if (hasBoundedSize && (hasFixedWidth || hasFixedHeight)) {
            float dstWidth2 = Constraints.m6744getMaxWidthimpl(constraints);
            dstWidth = dstWidth2;
            dstHeight = Constraints.m6743getMaxHeightimpl(constraints);
        } else {
            float intrinsicWidth = Size.m4118getWidthimpl(intrinsicSize);
            float intrinsicHeight = Size.m4115getHeightimpl(intrinsicSize);
            float dstWidth3 = !Float.isInfinite(intrinsicWidth) && !Float.isNaN(intrinsicWidth) ? UtilsKt.m7160constrainWidthK40F9xA(constraints, intrinsicWidth) : Constraints.m6746getMinWidthimpl(constraints);
            dstWidth = dstWidth3;
            dstHeight = (Float.isInfinite(intrinsicHeight) || Float.isNaN(intrinsicHeight)) ? false : true ? UtilsKt.m7159constrainHeightK40F9xA(constraints, intrinsicHeight) : Constraints.m6745getMinHeightimpl(constraints);
        }
        long jM7138calculateScaledSizeE7KxVPU = m7138calculateScaledSizeE7KxVPU(SizeKt.Size(dstWidth, dstHeight));
        float fM4118getWidthimpl = Size.m4118getWidthimpl(jM7138calculateScaledSizeE7KxVPU);
        float scaledHeight = Size.m4115getHeightimpl(jM7138calculateScaledSizeE7KxVPU);
        return Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : ConstraintsKt.m6761constrainWidthK40F9xA(constraints, MathKt.roundToInt(fM4118getWidthimpl)), (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : ConstraintsKt.m6760constrainHeightK40F9xA(constraints, MathKt.roundToInt(scaledHeight)), (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
    }

    @Override // androidx.compose.p001ui.draw.DrawModifier
    public void draw(ContentDrawScope $this$draw) {
        long scaledSize = m7138calculateScaledSizeE7KxVPU($this$draw.mo4773getSizeNHjbRc());
        long jMo3908alignKFBX0sM = this.alignment.mo3908alignKFBX0sM(UtilsKt.m7161toIntSizeuvyYCjk(scaledSize), UtilsKt.m7161toIntSizeuvyYCjk($this$draw.mo4773getSizeNHjbRc()), $this$draw.getLayoutDirection());
        int dx = IntOffset.m6925component1impl(jMo3908alignKFBX0sM);
        int dy = IntOffset.m6926component2impl(jMo3908alignKFBX0sM);
        ContentDrawScope $this$translate$iv = $this$draw;
        float left$iv = dx;
        float top$iv = dy;
        $this$translate$iv.getDrawContext().getTransform().translate(left$iv, top$iv);
        Painter $this$draw_u24lambda_u244_u24lambda_u243 = this.painter;
        $this$draw_u24lambda_u244_u24lambda_u243.m4987drawx_KDEd0($this$translate$iv, scaledSize, this.alpha, this.colorFilter);
        $this$translate$iv.getDrawContext().getTransform().translate(-left$iv, -top$iv);
        $this$draw.drawContent();
    }
}

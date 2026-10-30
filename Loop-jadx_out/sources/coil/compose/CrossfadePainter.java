package coil.compose;

import android.os.SystemClock;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.ScaleFactorKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CrossfadePainter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020!H\u0014J\u0012\u0010-\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J%\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020\u0016H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001e\u00105\u001a\u000206*\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020!H\u0002J\f\u00109\u001a\u000206*\u000207H\u0014R/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020!8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, m195d2 = {"Lcoil/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;IZZ)V", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "isDone", "", "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "startTimeMillis", "", "applyAlpha", "alpha", "applyColorFilter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "painter", "onDraw", "coil-compose-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CrossfadePainter extends Painter {
    private final ContentScale contentScale;
    private final int durationMillis;
    private final Painter end;
    private final boolean fadeStart;
    private boolean isDone;
    private final boolean preferExactIntrinsicSize;
    private Painter start;

    /* JADX INFO: renamed from: invalidateTick$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateTick = SnapshotIntStateKt.mutableIntStateOf(0);
    private long startTimeMillis = -1;

    /* JADX INFO: renamed from: maxAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState maxAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);

    /* JADX INFO: renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public CrossfadePainter(Painter start, Painter end, ContentScale contentScale, int durationMillis, boolean fadeStart, boolean preferExactIntrinsicSize) {
        this.start = start;
        this.end = end;
        this.contentScale = contentScale;
        this.durationMillis = durationMillis;
        this.fadeStart = fadeStart;
        this.preferExactIntrinsicSize = preferExactIntrinsicSize;
    }

    private final int getInvalidateTick() {
        IntState $this$getValue$iv = this.invalidateTick;
        return $this$getValue$iv.getIntValue();
    }

    private final void setInvalidateTick(int i) {
        MutableIntState $this$setValue$iv = this.invalidateTick;
        $this$setValue$iv.setIntValue(i);
    }

    private final float getMaxAlpha() {
        FloatState $this$getValue$iv = this.maxAlpha;
        return $this$getValue$iv.getFloatValue();
    }

    private final void setMaxAlpha(float f) {
        MutableFloatState $this$setValue$iv = this.maxAlpha;
        $this$setValue$iv.setFloatValue(f);
    }

    private final ColorFilter getColorFilter() {
        State $this$getValue$iv = this.colorFilter;
        return (ColorFilter) $this$getValue$iv.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        MutableState $this$setValue$iv = this.colorFilter;
        $this$setValue$iv.setValue(colorFilter);
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return m7141computeIntrinsicSizeNHjbRc();
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected void onDraw(DrawScope $this$onDraw) {
        if (this.isDone) {
            drawPainter($this$onDraw, this.end, getMaxAlpha());
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = uptimeMillis;
        }
        float percent = (uptimeMillis - this.startTimeMillis) / this.durationMillis;
        float endAlpha = RangesKt.coerceIn(percent, 0.0f, 1.0f) * getMaxAlpha();
        float startAlpha = this.fadeStart ? getMaxAlpha() - endAlpha : getMaxAlpha();
        this.isDone = percent >= 1.0f;
        drawPainter($this$onDraw, this.start, startAlpha);
        drawPainter($this$onDraw, this.end, endAlpha);
        if (!this.isDone) {
            setInvalidateTick(getInvalidateTick() + 1);
        } else {
            this.start = null;
        }
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        setMaxAlpha(alpha);
        return true;
    }

    @Override // androidx.compose.p001ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    /* JADX INFO: renamed from: computeIntrinsicSize-NH-jbRc, reason: not valid java name */
    private final long m7141computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long startSize = painter != null ? painter.getIntrinsicSize() : Size.INSTANCE.m4127getZeroNHjbRc();
        Painter painter2 = this.end;
        long endSize = painter2 != null ? painter2.getIntrinsicSize() : Size.INSTANCE.m4127getZeroNHjbRc();
        long $this$isSpecified$iv = startSize;
        boolean isStartSpecified = $this$isSpecified$iv != Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        long $this$isSpecified$iv2 = endSize;
        boolean isEndSpecified = $this$isSpecified$iv2 != Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        if (isStartSpecified && isEndSpecified) {
            return SizeKt.Size(Math.max(Size.m4118getWidthimpl(startSize), Size.m4118getWidthimpl(endSize)), Math.max(Size.m4115getHeightimpl(startSize), Size.m4115getHeightimpl(endSize)));
        }
        if (this.preferExactIntrinsicSize) {
            if (isStartSpecified) {
                return startSize;
            }
            if (isEndSpecified) {
                return endSize;
            }
        }
        return Size.INSTANCE.m4126getUnspecifiedNHjbRc();
    }

    private final void drawPainter(DrawScope $this$drawPainter, Painter painter, float alpha) {
        if (painter != null && alpha > 0.0f) {
            long size = $this$drawPainter.mo4773getSizeNHjbRc();
            long drawSize = m7140computeDrawSizex8L_9b0(painter.getIntrinsicSize(), size);
            if ((size == Size.INSTANCE.m4126getUnspecifiedNHjbRc()) || Size.m4120isEmptyimpl(size)) {
                painter.m4987drawx_KDEd0($this$drawPainter, drawSize, alpha, getColorFilter());
                return;
            }
            float f = 2;
            float horizontal$iv = (Size.m4118getWidthimpl(size) - Size.m4118getWidthimpl(drawSize)) / f;
            float vertical$iv = (Size.m4115getHeightimpl(size) - Size.m4115getHeightimpl(drawSize)) / f;
            $this$drawPainter.getDrawContext().getTransform().inset(horizontal$iv, vertical$iv, horizontal$iv, vertical$iv);
            painter.m4987drawx_KDEd0($this$drawPainter, drawSize, alpha, getColorFilter());
            $this$drawPainter.getDrawContext().getTransform().inset(-horizontal$iv, -vertical$iv, -horizontal$iv, -vertical$iv);
        }
    }

    /* JADX INFO: renamed from: computeDrawSize-x8L_9b0, reason: not valid java name */
    private final long m7140computeDrawSizex8L_9b0(long srcSize, long dstSize) {
        if ((srcSize == Size.INSTANCE.m4126getUnspecifiedNHjbRc()) || Size.m4120isEmptyimpl(srcSize)) {
            return dstSize;
        }
        if ((dstSize == Size.INSTANCE.m4126getUnspecifiedNHjbRc()) || Size.m4120isEmptyimpl(dstSize)) {
            return dstSize;
        }
        return ScaleFactorKt.m5746timesUQTWf7w(srcSize, this.contentScale.mo5635computeScaleFactorH7hwNQA(srcSize, dstSize));
    }
}

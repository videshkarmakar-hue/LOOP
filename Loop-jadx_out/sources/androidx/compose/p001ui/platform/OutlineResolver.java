package androidx.compose.p001ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.p001ui.geometry.CornerRadius;
import androidx.compose.p001ui.geometry.CornerRadiusKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RoundRect;
import androidx.compose.p001ui.geometry.RoundRectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.AndroidPath;
import androidx.compose.p001ui.graphics.AndroidPath_androidKt;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutlineResolver.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0018\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u00020.2\u0006\u0010&\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\b6\u00107J6\u00105\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00062\u0006\u00109\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010:\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\rH\u0002J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020*H\u0002J0\u0010B\u001a\u00020\u0006*\u0004\u0018\u00010*2\u0006\u0010C\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020#H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\tR\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u00020\u001eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0016\u0010 \u001a\u00020!X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u001eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010'\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m195d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "<set-?>", "", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "update-uvyYCjk", "(J)V", "alpha", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.p001ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline = true;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(Density density) {
        this.density = density;
        Outline $this$cachedOutline_u24lambda_u240 = new Outline();
        $this$cachedOutline_u24lambda_u240.setAlpha(1.0f);
        this.cachedOutline = $this$cachedOutline_u24lambda_u240;
        this.size = Size.INSTANCE.m4127getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.INSTANCE.m4065getZeroF1C5BW0();
        this.rectSize = Size.INSTANCE.m4127getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* JADX INFO: renamed from: getCacheIsDirty$ui_release, reason: from getter */
    public final boolean getCacheIsDirty() {
        return this.cacheIsDirty;
    }

    public final Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean update(Shape shape, float alpha, boolean clipToOutline, float elevation, LayoutDirection layoutDirection, Density density) {
        this.cachedOutline.setAlpha(alpha);
        boolean shapeChanged = !Intrinsics.areEqual(this.shape, shape);
        if (shapeChanged) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        boolean outlineNeeded = clipToOutline || elevation > 0.0f;
        if (this.outlineNeeded != outlineNeeded) {
            this.outlineNeeded = outlineNeeded;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return shapeChanged;
    }

    /* JADX INFO: renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m6031isInOutlinek4lQ0M(long position) {
        androidx.compose.p001ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m4049getXimpl(position), Offset.m4050getYimpl(position), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final void clipToOutline(Canvas canvas) {
        Path targetPath = getClipPath();
        if (targetPath != null) {
            Canvas.CC.m4263clipPathmtrdDE$default(canvas, targetPath, 0, 2, null);
            return;
        }
        if (this.roundedCornerRadius > 0.0f) {
            Path roundRectClipPath = this.tmpPath;
            RoundRect roundRect = this.tmpRoundRect;
            if (roundRectClipPath == null || !m6030isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, this.roundedCornerRadius)) {
                RoundRect roundRect2 = RoundRectKt.m4103RoundRectgG7oq9Y(Offset.m4049getXimpl(this.rectTopLeft), Offset.m4050getYimpl(this.rectTopLeft), Offset.m4049getXimpl(this.rectTopLeft) + Size.m4118getWidthimpl(this.rectSize), Offset.m4050getYimpl(this.rectTopLeft) + Size.m4115getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
                if (roundRectClipPath == null) {
                    roundRectClipPath = AndroidPath_androidKt.Path();
                } else {
                    roundRectClipPath.reset();
                }
                Path.CC.addRoundRect$default(roundRectClipPath, roundRect2, null, 2, null);
                this.tmpRoundRect = roundRect2;
                this.tmpPath = roundRectClipPath;
            }
            Canvas.CC.m4263clipPathmtrdDE$default(canvas, roundRectClipPath, 0, 2, null);
            return;
        }
        Canvas.CC.m4264clipRectN_I0leg$default(canvas, Offset.m4049getXimpl(this.rectTopLeft), Offset.m4050getYimpl(this.rectTopLeft), Offset.m4049getXimpl(this.rectTopLeft) + Size.m4118getWidthimpl(this.rectSize), Offset.m4050getYimpl(this.rectTopLeft) + Size.m4115getHeightimpl(this.rectSize), 0, 16, null);
    }

    /* JADX INFO: renamed from: update-uvyYCjk, reason: not valid java name */
    public final void m6032updateuvyYCjk(long size) {
        if (!Size.m4114equalsimpl0(this.size, size)) {
            this.size = size;
            this.cacheIsDirty = true;
        }
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.INSTANCE.m4065getZeroF1C5BW0();
            this.rectSize = this.size;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (this.outlineNeeded && Size.m4118getWidthimpl(this.size) > 0.0f && Size.m4115getHeightimpl(this.size) > 0.0f) {
                this.isSupportedOutline = true;
                androidx.compose.p001ui.graphics.Outline outline = this.shape.mo502createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
                this.calculatedOutline = outline;
                if (!(outline instanceof androidx.compose.ui.graphics.Outline.Rectangle)) {
                    if (!(outline instanceof androidx.compose.ui.graphics.Outline.Rounded)) {
                        if (outline instanceof androidx.compose.ui.graphics.Outline.Generic) {
                            updateCacheWithPath(((androidx.compose.ui.graphics.Outline.Generic) outline).getPath());
                            return;
                        }
                        return;
                    }
                    updateCacheWithRoundRect(((androidx.compose.ui.graphics.Outline.Rounded) outline).getRoundRect());
                    return;
                }
                updateCacheWithRect(((androidx.compose.ui.graphics.Outline.Rectangle) outline).getRect());
                return;
            }
            this.cachedOutline.setEmpty();
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        Outline outline = this.cachedOutline;
        float $this$fastRoundToInt$iv = rect.getLeft();
        int iRound = Math.round($this$fastRoundToInt$iv);
        float $this$fastRoundToInt$iv2 = rect.getTop();
        int iRound2 = Math.round($this$fastRoundToInt$iv2);
        float $this$fastRoundToInt$iv3 = rect.getRight();
        int iRound3 = Math.round($this$fastRoundToInt$iv3);
        float $this$fastRoundToInt$iv4 = rect.getBottom();
        outline.setRect(iRound, iRound2, iRound3, Math.round($this$fastRoundToInt$iv4));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float radius = CornerRadius.m4024getXimpl(roundRect.m4099getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            Outline outline = this.cachedOutline;
            float $this$fastRoundToInt$iv = roundRect.getLeft();
            int $i$f$fastRoundToInt = Math.round($this$fastRoundToInt$iv);
            float $this$fastRoundToInt$iv2 = roundRect.getTop();
            int $i$f$fastRoundToInt2 = Math.round($this$fastRoundToInt$iv2);
            float $this$fastRoundToInt$iv3 = roundRect.getRight();
            int $i$f$fastRoundToInt3 = Math.round($this$fastRoundToInt$iv3);
            float $this$fastRoundToInt$iv4 = roundRect.getBottom();
            int $i$f$fastRoundToInt4 = Math.round($this$fastRoundToInt$iv4);
            outline.setRoundRect($i$f$fastRoundToInt, $i$f$fastRoundToInt2, $i$f$fastRoundToInt3, $i$f$fastRoundToInt4, radius);
            this.roundedCornerRadius = radius;
            return;
        }
        Path it = this.cachedRrectPath;
        if (it == null) {
            it = AndroidPath_androidKt.Path();
            this.cachedRrectPath = it;
        }
        it.reset();
        Path.CC.addRoundRect$default(it, roundRect, null, 2, null);
        updateCacheWithPath(it);
    }

    private final void updateCacheWithPath(Path composePath) {
        if (Build.VERSION.SDK_INT > 28 || composePath.isConvex()) {
            Outline outline = this.cachedOutline;
            if (composePath instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) composePath).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = composePath;
    }

    /* JADX INFO: renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m6030isSameBounds4L21HEs(RoundRect $this$isSameBounds_u2d4L21HEs, long offset, long size, float radius) {
        if ($this$isSameBounds_u2d4L21HEs == null || !RoundRectKt.isSimple($this$isSameBounds_u2d4L21HEs)) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getLeft() == Offset.m4049getXimpl(offset))) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getTop() == Offset.m4050getYimpl(offset))) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getRight() == Offset.m4049getXimpl(offset) + Size.m4118getWidthimpl(size))) {
            return false;
        }
        if ($this$isSameBounds_u2d4L21HEs.getBottom() == Offset.m4050getYimpl(offset) + Size.m4115getHeightimpl(size)) {
            return (CornerRadius.m4024getXimpl($this$isSameBounds_u2d4L21HEs.m4099getTopLeftCornerRadiuskKHJgLs()) > radius ? 1 : (CornerRadius.m4024getXimpl($this$isSameBounds_u2d4L21HEs.m4099getTopLeftCornerRadiuskKHJgLs()) == radius ? 0 : -1)) == 0;
        }
        return false;
    }
}

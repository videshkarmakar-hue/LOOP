package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Outline.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u009f\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!H\u0082\b\u001a\f\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0011\u0010)\u001a\u00020**\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010)\u001a\u00020**\u00020#H\u0002¢\u0006\u0002\u0010,\u001a\u0011\u0010-\u001a\u00020.*\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010-\u001a\u00020.*\u00020#H\u0002¢\u0006\u0002\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", DownloadUtil.CookieScheme.PATH, "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OutlineKt {
    public static final void addOutline(Path $this$addOutline, Outline outline) {
        if (!(outline instanceof Outline.Rectangle)) {
            if (!(outline instanceof Outline.Rounded)) {
                if (!(outline instanceof Outline.Generic)) {
                    throw new NoWhenBranchMatchedException();
                }
                Path.CC.m4321addPathUv8p0NA$default($this$addOutline, ((Outline.Generic) outline).getPath(), 0L, 2, null);
                return;
            }
            Path.CC.addRoundRect$default($this$addOutline, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
            return;
        }
        Path.CC.addRect$default($this$addOutline, ((Outline.Rectangle) outline).getRect(), null, 2, null);
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m4308drawOutlinewDX37Ww(DrawScope $this$drawOutline_u2dwDX37Ww, Outline outline, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            $this$drawOutline_u2dwDX37Ww.mo4521drawRectnJ9OG0(color, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline).getRoundRectPath();
            if (path$iv != null) {
                $this$drawOutline_u2dwDX37Ww.mo4517drawPathLG529CI(path$iv, color, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline).getRoundRect();
            float radius = CornerRadius.m3776getXimpl(rrect.m3849getBottomLeftCornerRadiuskKHJgLs());
            $this$drawOutline_u2dwDX37Ww.mo4523drawRoundRectuAw5IA(color, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), style, alpha, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Generic) {
            Path path = ((Outline.Generic) outline).getPath();
            $this$drawOutline_u2dwDX37Ww.mo4517drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m4306drawOutlinehn5TExg(DrawScope $this$drawOutline_u2dhn5TExg, Outline outline, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            $this$drawOutline_u2dhn5TExg.mo4520drawRectAsUm42w(brush, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline).getRoundRectPath();
            if (path$iv != null) {
                $this$drawOutline_u2dhn5TExg.mo4516drawPathGBMwjPU(path$iv, brush, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline).getRoundRect();
            float radius = CornerRadius.m3776getXimpl(rrect.m3849getBottomLeftCornerRadiuskKHJgLs());
            $this$drawOutline_u2dhn5TExg.mo4522drawRoundRectZuiqVtQ(brush, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), alpha, style, colorFilter, blendMode);
            return;
        }
        if (outline instanceof Outline.Generic) {
            Path path = ((Outline.Generic) outline).getPath();
            $this$drawOutline_u2dhn5TExg.mo4516drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final long topLeft(Rect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(Rect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final long topLeft(RoundRect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(RoundRect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final void drawOutlineHelper(DrawScope $this$drawOutlineHelper, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function3, Function2<? super DrawScope, ? super Path, Unit> function4) {
        if (!(outline instanceof Outline.Rectangle)) {
            if (outline instanceof Outline.Rounded) {
                Path path = ((Outline.Rounded) outline).getRoundRectPath();
                if (path != null) {
                    function4.invoke($this$drawOutlineHelper, path);
                    return;
                } else {
                    function3.invoke($this$drawOutlineHelper, ((Outline.Rounded) outline).getRoundRect());
                    return;
                }
            }
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            function4.invoke($this$drawOutlineHelper, ((Outline.Generic) outline).getPath());
            return;
        }
        function2.invoke($this$drawOutlineHelper, ((Outline.Rectangle) outline).getRect());
    }

    public static final void drawOutline(Canvas $this$drawOutline, Outline outline, Paint paint) {
        if (!(outline instanceof Outline.Rectangle)) {
            if (outline instanceof Outline.Rounded) {
                Path path = ((Outline.Rounded) outline).getRoundRectPath();
                if (path != null) {
                    $this$drawOutline.drawPath(path, paint);
                    return;
                } else {
                    $this$drawOutline.drawRoundRect(((Outline.Rounded) outline).getRoundRect().getLeft(), ((Outline.Rounded) outline).getRoundRect().getTop(), ((Outline.Rounded) outline).getRoundRect().getRight(), ((Outline.Rounded) outline).getRoundRect().getBottom(), CornerRadius.m3776getXimpl(((Outline.Rounded) outline).getRoundRect().m3849getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m3777getYimpl(((Outline.Rounded) outline).getRoundRect().m3849getBottomLeftCornerRadiuskKHJgLs()), paint);
                    return;
                }
            }
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            $this$drawOutline.drawPath(((Outline.Generic) outline).getPath(), paint);
            return;
        }
        $this$drawOutline.drawRect(((Outline.Rectangle) outline).getRect(), paint);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004f  */
    /* JADX WARN: Code duplicated, block: B:35:0x009e  */
    private static final boolean hasSameCornerRadius(RoundRect $this$hasSameCornerRadius) {
        boolean sameRadiusX;
        boolean sameRadiusY;
        if (CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3849getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3850getBottomRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3850getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3852getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3852getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$hasSameCornerRadius.m3851getTopLeftCornerRadiuskKHJgLs())) {
                    sameRadiusX = true;
                } else {
                    sameRadiusX = false;
                }
            } else {
                sameRadiusX = false;
            }
        } else {
            sameRadiusX = false;
        }
        if (CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3849getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3850getBottomRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3850getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3852getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3852getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$hasSameCornerRadius.m3851getTopLeftCornerRadiuskKHJgLs())) {
                    sameRadiusY = true;
                } else {
                    sameRadiusY = false;
                }
            } else {
                sameRadiusY = false;
            }
        } else {
            sameRadiusY = false;
        }
        return sameRadiusX && sameRadiusY;
    }
}

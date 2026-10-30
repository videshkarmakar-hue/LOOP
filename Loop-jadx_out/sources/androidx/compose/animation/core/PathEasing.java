package androidx.compose.animation.core;

import androidx.compose.p001ui.graphics.BezierKt;
import androidx.compose.p001ui.graphics.Interval;
import androidx.compose.p001ui.graphics.IntervalTree;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.PathIterator;
import androidx.compose.p001ui.graphics.PathSegment;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathEasing.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", DownloadUtil.CookieScheme.PATH, "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "transform", "", "fraction", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PathEasing implements Easing {
    public static final int $stable = 0;
    private IntervalTree<PathSegment> intervals;
    private final Path path;

    public PathEasing(Path path) {
        this.path = path;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        boolean value$iv;
        if (fraction <= 0.0f) {
            return 0.0f;
        }
        if (fraction >= 1.0f) {
            return 1.0f;
        }
        Object obj = null;
        if (this.intervals == null) {
            float[] roots = new float[5];
            IntervalTree<PathSegment> intervalTree = new IntervalTree<>();
            PathIterator iterator = this.path.iterator(PathIterator.ConicEvaluation.AsQuadratics, 2.0E-4f);
            while (true) {
                value$iv = false;
                if (!iterator.hasNext()) {
                    break;
                }
                PathSegment segment = iterator.next();
                if (!(segment.getType() != PathSegment.Type.Close)) {
                    PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
                }
                if (segment.getType() == PathSegment.Type.Move) {
                    obj = null;
                } else if (segment.getType() == PathSegment.Type.Done) {
                    obj = null;
                } else {
                    long bounds = BezierKt.computeHorizontalBounds$default(segment, roots, 0, 4, obj);
                    int bits$iv$iv = (int) (bounds >> 32);
                    int bits$iv$iv2 = (int) (4294967295L & bounds);
                    intervalTree.addInterval(Float.intBitsToFloat(bits$iv$iv), Float.intBitsToFloat(bits$iv$iv2), segment);
                    obj = null;
                }
            }
            if (intervalTree.contains(0.0f) && intervalTree.contains(1.0f)) {
                value$iv = true;
            }
            if (!value$iv) {
                PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
            }
            this.intervals = intervalTree;
        }
        IntervalTree<PathSegment> intervalTree2 = this.intervals;
        if (intervalTree2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intervals");
            intervalTree2 = null;
        }
        Interval result = IntervalTree.findFirstOverlap$default(intervalTree2, fraction, 0.0f, 2, null);
        Object value$iv2 = result.getData();
        if (value$iv2 != null) {
            PathSegment segment2 = (PathSegment) value$iv2;
            float t = BezierKt.findFirstRoot(segment2, fraction);
            if (!(!Float.isNaN(t))) {
                PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
            }
            float $this$fastCoerceIn$iv = BezierKt.evaluateY(segment2, t);
            float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
            if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                $this$fastCoerceAtLeast$iv$iv = 0.0f;
            }
            if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                return 1.0f;
            }
            return $this$fastCoerceAtLeast$iv$iv;
        }
        PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
        throw new KotlinNothingValueException();
    }
}

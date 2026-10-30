package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContentDrawScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ContentDrawScope.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: buildLayer-JVtK1S4, reason: not valid java name */
        public static GraphicsLayer m4556buildLayerJVtK1S4(ContentDrawScope $this, GraphicsLayer $receiver, long size, Function1<? super DrawScope, Unit> function1) {
            return DrawScope.CC.m4572$default$buildLayerJVtK1S4($this, $receiver, size, function1);
        }

        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m4557drawImageAZ2fEMs(ContentDrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            DrawScope.CC.m4599drawImageAZ2fEMs$default($this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, null);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m4558getCenterF1C5BW0(ContentDrawScope $this) {
            return DrawScope.CC.m4574$default$getCenterF1C5BW0($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4559getSizeNHjbRc(ContentDrawScope $this) {
            return DrawScope.CC.m4575$default$getSizeNHjbRc($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4560roundToPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6517$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4561roundToPx0680j_4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6518$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4562toDpGaN1DYA(ContentDrawScope $this, long $receiver) {
            return FontScaling.CC.m6662$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4563toDpu2uoSUM(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6519$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4564toDpu2uoSUM(ContentDrawScope $this, int $receiver) {
            return Density.CC.m6520$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4565toDpSizekrfVVM(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6521$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4566toPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6522$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4567toPx0680j_4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6523$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4568toSizeXkaWNTQ(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6524$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4569toSp0xMU5do(ContentDrawScope $this, float $receiver) {
            return FontScaling.CC.m6663$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4570toSpkPz2Gy4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6525$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4571toSpkPz2Gy4(ContentDrawScope $this, int $receiver) {
            return Density.CC.m6526$default$toSpkPz2Gy4((Density) $this, $receiver);
        }
    }
}

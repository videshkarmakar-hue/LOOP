package androidx.compose.p001ui.node;

import androidx.compose.p001ui.geometry.MutableRect;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OwnedLayer.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001eH&ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&ø\u0001\u0000¢\u0006\u0004\b$\u0010 J*\u0010%\u001a\u00020\u00032\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)H&J\u001a\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000¢\u0006\u0004\b+\u0010\u000eJ\b\u0010,\u001a\u00020\u0003H&J \u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H&ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u00064À\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/node/OwnedLayer;", "", "destroy", "", "drawLayer", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "drawBlock", "Lkotlin/Function1;", "invalidateParentLayer", "Lkotlin/Function0;", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface OwnedLayer {
    void destroy();

    void drawLayer(Canvas canvas, GraphicsLayer parentLayer);

    void invalidate();

    /* JADX INFO: renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    void mo5923inverseTransform58bKbWc(float[] matrix);

    /* JADX INFO: renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean mo5924isInLayerk4lQ0M(long position);

    void mapBounds(MutableRect rect, boolean inverse);

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long mo5925mapOffset8S9VItk(long point, boolean inverse);

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    void mo5926movegyyYBs(long position);

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    void mo5927resizeozmzZPI(long size);

    void reuseLayer(Function1<? super Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer);

    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    void mo5928transform58bKbWc(float[] matrix);

    void updateDisplayList();

    void updateLayerProperties(ReusableGraphicsLayerScope scope, LayoutDirection layoutDirection, Density density);
}

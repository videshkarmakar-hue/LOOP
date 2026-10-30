package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH¦\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0003H&J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010\"J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b&\u0010\"J\u001a\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010\"J\"\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-H\u0016ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001a\u00100\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH&ø\u0001\u0000¢\u0006\u0004\b5\u0010\"R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u00066À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "isAttached", "", "()Z", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface LayoutCoordinates {
    int get(AlignmentLine alignmentLine);

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set<AlignmentLine> getProvidedAlignmentLines();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo5398getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds);

    /* JADX INFO: renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo5399localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource);

    /* JADX INFO: renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo5400localToRootMKHz9U(long relativeToLocal);

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    long mo5401localToScreenMKHz9U(long relativeToLocal);

    /* JADX INFO: renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo5402localToWindowMKHz9U(long relativeToLocal);

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo5403screenToLocalMKHz9U(long relativeToScreen);

    /* JADX INFO: renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo5404transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix);

    /* JADX INFO: renamed from: transformToScreen-58bKbWc, reason: not valid java name */
    void mo5405transformToScreen58bKbWc(float[] matrix);

    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo5406windowToLocalMKHz9U(long relativeToWindow);

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutCoordinates$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutCoordinates.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m5408$default$screenToLocalMKHz9U(LayoutCoordinates _this, long relativeToScreen) {
            return Offset.INSTANCE.m3816getUnspecifiedF1C5BW0();
        }

        /* JADX INFO: renamed from: $default$localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m5407$default$localToScreenMKHz9U(LayoutCoordinates _this, long relativeToLocal) {
            return Offset.INSTANCE.m3816getUnspecifiedF1C5BW0();
        }

        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z);
        }

        /* JADX INFO: renamed from: $default$transformFrom-EL8BTi8, reason: not valid java name */
        public static void m5409$default$transformFromEL8BTi8(LayoutCoordinates _this, LayoutCoordinates sourceCoordinates, float[] matrix) {
            throw new UnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
        }

        /* JADX INFO: renamed from: $default$transformToScreen-58bKbWc, reason: not valid java name */
        public static void m5410$default$transformToScreen58bKbWc(LayoutCoordinates _this, float[] matrix) {
            throw new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
        }
    }

    /* JADX INFO: compiled from: LayoutCoordinates.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m5416screenToLocalMKHz9U(LayoutCoordinates $this, long relativeToScreen) {
            return CC.m5408$default$screenToLocalMKHz9U($this, relativeToScreen);
        }

        @Deprecated
        /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m5415localToScreenMKHz9U(LayoutCoordinates $this, long relativeToLocal) {
            return CC.m5407$default$localToScreenMKHz9U($this, relativeToLocal);
        }

        @Deprecated
        /* JADX INFO: renamed from: transformFrom-EL8BTi8, reason: not valid java name */
        public static void m5417transformFromEL8BTi8(LayoutCoordinates $this, LayoutCoordinates sourceCoordinates, float[] matrix) {
            CC.m5409$default$transformFromEL8BTi8($this, sourceCoordinates, matrix);
        }

        @Deprecated
        /* JADX INFO: renamed from: transformToScreen-58bKbWc, reason: not valid java name */
        public static void m5418transformToScreen58bKbWc(LayoutCoordinates $this, float[] matrix) {
            CC.m5410$default$transformToScreen58bKbWc($this, matrix);
        }
    }
}

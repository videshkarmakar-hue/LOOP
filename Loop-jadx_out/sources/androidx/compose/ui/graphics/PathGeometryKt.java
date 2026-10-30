package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathGeometry.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"floatCountForType", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/ui/graphics/PathSegment$Type;", "computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", "destination", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PathGeometryKt {

    /* JADX INFO: compiled from: PathGeometry.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x013a  */
    /* JADX WARN: Code duplicated, block: B:35:0x013d  */
    public static final Path.Direction computeDirection(Path $this$computeDirection) {
        boolean first = true;
        PathIterator iterator = $this$computeDirection.iterator();
        float[] points = new float[8];
        float area = 0.0f;
        float startX = 0.0f;
        float startY = 0.0f;
        float endX = 0.0f;
        float endY = 0.0f;
        PathSegment.Type type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
        while (type != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    if (first) {
                        first = false;
                        startX = points[0];
                        startY = points[1];
                        type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    }
                    break;
                case 2:
                    float x0 = points[0];
                    float y0 = points[1];
                    float x1 = points[2];
                    float y1 = points[3];
                    area += BezierKt.cubicArea(x0, y0, x0, y0, x1, y1, x1, y1);
                    endX = x1;
                    endY = y1;
                    type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    break;
                case 3:
                    float x2 = points[0];
                    float y2 = points[1];
                    float x3 = points[2];
                    float y3 = points[3];
                    float x4 = points[4];
                    float y4 = points[5];
                    float c1x = x2 + ((x3 - x2) * 0.6666667f);
                    float c1y = y2 + ((y3 - y2) * 0.6666667f);
                    float c2x = x4 + ((x3 - x4) * 0.6666667f);
                    float c2y = y4 + ((y3 - y4) * 0.6666667f);
                    area += BezierKt.cubicArea(x2, y2, c1x, c1y, c2x, c2y, x4, y4);
                    endX = x4;
                    endY = y4;
                    type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    break;
                case 4:
                    break;
                case 5:
                    area += BezierKt.cubicArea(points[0], points[1], points[2], points[3], points[4], points[5], points[6], points[7]);
                    endX = points[6];
                    endY = points[7];
                    type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    break;
                case 6:
                    float $this$closeTo$iv = endX;
                    if (Math.abs($this$closeTo$iv - startX) < 8.34465E-7f) {
                        float $this$closeTo$iv2 = endY;
                        if (!(Math.abs($this$closeTo$iv2 - startY) < 8.34465E-7f)) {
                            area += BezierKt.cubicArea(endX, endY, endX, endY, startX, startY, startX, startY);
                            endX = startX;
                            endY = startY;
                        }
                    } else {
                        area += BezierKt.cubicArea(endX, endY, endX, endY, startX, startY, startX, startY);
                        endX = startX;
                        endY = startY;
                    }
                    type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    break;
                case 7:
                    break;
                default:
                    type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
                    break;
            }
            if (area >= 0.0f) {
                return Path.Direction.Clockwise;
            }
            return Path.Direction.CounterClockwise;
        }
        if (area >= 0.0f) {
            return Path.Direction.Clockwise;
        }
        return Path.Direction.CounterClockwise;
    }

    public static /* synthetic */ List divide$default(Path path, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return divide(path, list);
    }

    public static final List<Path> divide(Path $this$divide, List<Path> list) {
        Path path = AndroidPath_androidKt.Path();
        boolean first = true;
        boolean isEmpty = true;
        PathIterator iterator = $this$divide.iterator();
        float[] points = new float[8];
        PathSegment.Type type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
        while (type != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    if (!first && !isEmpty) {
                        list.add(path);
                        path = AndroidPath_androidKt.Path();
                    }
                    first = false;
                    isEmpty = true;
                    path.moveTo(points[0], points[1]);
                    break;
                case 2:
                    path.lineTo(points[2], points[3]);
                    isEmpty = false;
                    break;
                case 3:
                    path.quadraticTo(points[2], points[3], points[4], points[5]);
                    isEmpty = false;
                    break;
                case 4:
                case 7:
                    continue;
                case 5:
                    path.cubicTo(points[2], points[3], points[4], points[5], points[6], points[7]);
                    isEmpty = false;
                    break;
                case 6:
                    path.close();
                    break;
            }
            type = PathIterator.CC.next$default(iterator, points, 0, 2, null);
        }
        if (!first && !isEmpty) {
            list.add(path);
        }
        return list;
    }

    public static /* synthetic */ Path reverse$default(Path path, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            path2 = AndroidPath_androidKt.Path();
        }
        return reverse(path, path2);
    }

    public static final Path reverse(Path $this$reverse, Path destination) {
        float[] points;
        boolean insertMove;
        int dataIndex;
        PathIterator iterator = $this$reverse.iterator();
        int count = iterator.calculateSize(false);
        ArrayList segments = new ArrayList(count);
        ArrayList data = new ArrayList(count);
        float[] points2 = new float[8];
        for (PathSegment.Type type = PathIterator.CC.next$default(iterator, points2, 0, 2, null); type != PathSegment.Type.Done; type = PathIterator.CC.next$default(iterator, points2, 0, 2, null)) {
            segments.add(type);
            if (type != PathSegment.Type.Close) {
                float[] fArrCopyOf = Arrays.copyOf(points2, floatCountForType(type));
                Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(this, newSize)");
                data.add(fArrCopyOf);
            }
        }
        boolean insertMove2 = true;
        int dataIndex2 = data.size();
        boolean insertClose = false;
        int i = segments.size() - 1;
        while (-1 < i) {
            if (insertMove2) {
                int dataIndex3 = dataIndex2 - 1;
                float[] points3 = (float[]) data.get(dataIndex3);
                int offset = ArraysKt.getLastIndex(points3);
                destination.moveTo(points3[offset - 1], points3[offset]);
                points = points3;
                insertMove = false;
                dataIndex = dataIndex3;
            } else {
                points = (float[]) data.get(dataIndex2);
                insertMove = insertMove2;
                dataIndex = dataIndex2;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[((PathSegment.Type) segments.get(i)).ordinal()]) {
                case 1:
                    i = i;
                    if (insertClose) {
                        destination.close();
                        insertClose = false;
                    }
                    insertMove2 = true;
                    continue;
                    dataIndex2 = dataIndex;
                    i--;
                    break;
                case 2:
                    i = i;
                    destination.lineTo(points[0], points[1]);
                    dataIndex--;
                    insertMove2 = insertMove;
                    continue;
                    dataIndex2 = dataIndex;
                    i--;
                    break;
                case 3:
                    i = i;
                    destination.quadraticTo(points[2], points[3], points[0], points[1]);
                    dataIndex--;
                    insertMove2 = insertMove;
                    continue;
                    dataIndex2 = dataIndex;
                    i--;
                    break;
                case 5:
                    i = i;
                    destination.cubicTo(points[4], points[5], points[2], points[3], points[0], points[1]);
                    dataIndex--;
                    insertMove2 = insertMove;
                    continue;
                    dataIndex2 = dataIndex;
                    i--;
                    break;
                case 6:
                    insertClose = true;
                    i = i;
                    insertMove2 = insertMove;
                    continue;
                    dataIndex2 = dataIndex;
                    i--;
                    break;
            }
            insertMove2 = insertMove;
            dataIndex2 = dataIndex;
            i--;
        }
        if (insertClose) {
            destination.close();
        }
        return destination;
    }

    private static final int floatCountForType(PathSegment.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
                return 8;
            case 5:
                return 8;
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

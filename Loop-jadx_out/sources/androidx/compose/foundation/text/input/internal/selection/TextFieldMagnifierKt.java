package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m195d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldMagnifierKt {

    /* JADX INFO: compiled from: TextFieldMagnifier.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c9  */
    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    public static final long m1380calculateSelectionMagnifierCenterAndroidhUlJWOE(TransformedTextFieldState textFieldState, TextFieldSelectionState selectionState, TextLayoutState textLayoutState, long magnifierSize) {
        int textOffset;
        long localDragPosition = selectionState.m1404getHandleDragPositionF1C5BW0();
        if (!OffsetKt.m4070isUnspecifiedk4lQ0M(localDragPosition)) {
            if (!(textFieldState.getVisualText().length() == 0)) {
                long selection = textFieldState.getVisualText().getSelection();
                Handle draggingHandle = selectionState.getDraggingHandle();
                switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
                    case -1:
                        return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                    case 2:
                        textOffset = TextRange.m6251getStartimpl(selection);
                        break;
                    case 3:
                        textOffset = TextRange.m6246getEndimpl(selection);
                        break;
                }
                TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
                if (layoutResult == null) {
                    return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                }
                float dragX = Offset.m4049getXimpl(localDragPosition);
                int line = layoutResult.getLineForOffset(textOffset);
                float lineStart = layoutResult.getLineLeft(line);
                float lineEnd = layoutResult.getLineRight(line);
                float lineMin = Math.min(lineStart, lineEnd);
                float lineMax = Math.max(lineStart, lineEnd);
                float centerX = RangesKt.coerceIn(dragX, lineMin, lineMax);
                if (Math.abs(dragX - centerX) > IntSize.m6975getWidthimpl(magnifierSize) / 2) {
                    return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                }
                float top = layoutResult.getLineTop(line);
                float bottom = layoutResult.getLineBottom(line);
                float centerY = ((bottom - top) / 2) + top;
                long offset = OffsetKt.Offset(centerX, centerY);
                LayoutCoordinates innerCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
                if (innerCoordinates != null) {
                    if (!innerCoordinates.isAttached()) {
                        innerCoordinates = null;
                    }
                    if (innerCoordinates != null) {
                        offset = TextLayoutStateKt.m1356coerceIn3MmeM6k(offset, SelectionManagerKt.visibleBounds(innerCoordinates));
                    }
                }
                return TextLayoutStateKt.m1358fromTextLayoutToCoreUv8p0NA(textLayoutState, offset);
            }
        }
        return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
    }
}

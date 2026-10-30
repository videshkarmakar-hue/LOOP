package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m195d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldSelectionManagerKt {

    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
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

    public static final void TextFieldSelectionHandle(final boolean isStartHandle, final ResolvedTextDirection direction, final TextFieldSelectionManager manager, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1 value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation($composer2, "C(TextFieldSelectionHandle)P(1)958@37176L90,963@37314L44,967@37540L71,962@37272L346:TextFieldSelectionManager.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isStartHandle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(direction) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(manager) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344558920, $dirty2, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:957)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1630610296, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changed(manager);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = manager.handleDragObserver$foundation_release(isStartHandle);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            TextDragObserver observer = (TextDragObserver) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1630610158, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(manager) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* JADX INFO: renamed from: provide-F1C5BW0 */
                    public final long mo1150provideF1C5BW0() {
                        return manager.m1538getHandlePositiontuRUvjQ$foundation_release(isStartHandle);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            OffsetProvider offsetProvider = (OffsetProvider) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean zM6250getReversedimpl = TextRange.m6250getReversedimpl(manager.getValue$foundation_release().getSelection());
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1630609932, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(observer);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1(observer, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidSelectionHandles_androidKt.m1458SelectionHandlepzduO1o(offsetProvider, isStartHandle, direction, zM6250getReversedimpl, 0L, SuspendingPointerInputFilterKt.pointerInput(companion, observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3), $composer2, (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.TextFieldSelectionHandle.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TextFieldSelectionManagerKt.TextFieldSelectionHandle(isStartHandle, direction, manager, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager $this$isSelectionHandleInVisibleBound, boolean isStartHandle) {
        LayoutCoordinates layoutCoordinates;
        Rect rectVisibleBounds;
        LegacyTextFieldState state = $this$isSelectionHandleInVisibleBound.getState();
        if (state != null && (layoutCoordinates = state.getLayoutCoordinates()) != null && (rectVisibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) != null) {
            return SelectionManagerKt.m1516containsInclusiveUv8p0NA(rectVisibleBounds, $this$isSelectionHandleInVisibleBound.m1538getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1539calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager manager, long magnifierSize) {
        boolean z;
        int rawTextOffset;
        TextLayoutResultProxy textLayoutResultProxy;
        TextDelegate textDelegate;
        AnnotatedString transformedText;
        Offset offsetM1536getCurrentDragPosition_m7T9E = manager.m1536getCurrentDragPosition_m7T9E();
        if (offsetM1536getCurrentDragPosition_m7T9E == null) {
            return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        long localDragPosition = offsetM1536getCurrentDragPosition_m7T9E.getPackedValue();
        AnnotatedString transformedText$foundation_release = manager.getTransformedText$foundation_release();
        if (transformedText$foundation_release != null) {
            z = transformedText$foundation_release.length() == 0 ? false : true;
        }
        if (!z) {
            return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
            case -1:
                return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
                rawTextOffset = TextRange.m6251getStartimpl(manager.getValue$foundation_release().getSelection());
                break;
            case 3:
                rawTextOffset = TextRange.m6246getEndimpl(manager.getValue$foundation_release().getSelection());
                break;
        }
        LegacyTextFieldState state = manager.getState();
        if (state == null || (textLayoutResultProxy = state.getLayoutResult()) == null) {
            return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        LegacyTextFieldState state2 = manager.getState();
        if (state2 == null || (textDelegate = state2.getTextDelegate()) == null || (transformedText = textDelegate.getText()) == null) {
            return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        int textOffset = RangesKt.coerceIn(manager.getOffsetMapping().originalToTransformed(rawTextOffset), 0, transformedText.length());
        float dragX = Offset.m4049getXimpl(textLayoutResultProxy.m1267translateDecorationToInnerCoordinatesMKHz9U$foundation_release(localDragPosition));
        TextLayoutResult layoutResult = textLayoutResultProxy.getValue();
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
        return OffsetKt.Offset(centerX, centerY);
    }
}

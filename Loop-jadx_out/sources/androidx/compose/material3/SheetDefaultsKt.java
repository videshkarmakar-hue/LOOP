package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0000\u001aA\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0019\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001a"}, m195d2 = {"BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "DragHandleVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = C1979Dp.m6801constructorimpl(22);
    private static final AnimationSpec<Float> BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final Function1<? super Float, Unit> function1) {
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1
            @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
            public long mo670onPreScrollOzD1aCk(long available, int source) {
                float delta = offsetToFloat(available);
                if (delta < 0.0f && NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5403getDragWNlRxjI())) {
                    return toOffset(sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(delta));
                }
                return Offset.INSTANCE.m4065getZeroF1C5BW0();
            }

            @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
            public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
                if (NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5403getDragWNlRxjI())) {
                    return toOffset(sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat(available)));
                }
                return Offset.INSTANCE.m4065getZeroF1C5BW0();
            }

            @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreFling-QWom1Mo */
            public Object mo669onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
                long jM7053getZero9UxMQ8M;
                float toFling = velocityToFloat(available);
                float currentOffset = sheetState.requireOffset();
                float minAnchor = sheetState.getAnchoredDraggableState$material3_release().getAnchors().minAnchor();
                if (toFling < 0.0f && currentOffset > minAnchor) {
                    function1.invoke(Boxing.boxFloat(toFling));
                    jM7053getZero9UxMQ8M = available;
                } else {
                    jM7053getZero9UxMQ8M = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                }
                return Velocity.m7033boximpl(jM7053getZero9UxMQ8M);
            }

            @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
            public Object mo667onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
                function1.invoke(Boxing.boxFloat(velocityToFloat(available)));
                return Velocity.m7033boximpl(available);
            }

            private final long toOffset(float $this$toOffset) {
                return OffsetKt.Offset(orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
            }

            private final float velocityToFloat(long $this$toFloat) {
                return orientation == Orientation.Horizontal ? Velocity.m7042getXimpl($this$toFloat) : Velocity.m7043getYimpl($this$toFloat);
            }

            private final float offsetToFloat(long $this$toFloat) {
                return orientation == Orientation.Horizontal ? Offset.m4049getXimpl($this$toFloat) : Offset.m4050getYimpl($this$toFloat);
            }
        };
    }

    public static final SheetState rememberSheetState(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> function1, SheetValue initialValue, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1032784200, "C(rememberSheetState)P(3)435@15937L7,444@16282L180,436@15956L506:SheetDefaults.kt#uh7d8r");
        boolean skipPartiallyExpanded2 = (i & 1) != 0 ? false : skipPartiallyExpanded;
        Function1<? super SheetValue, Boolean> function2 = (i & 2) != 0 ? new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.SheetDefaultsKt.rememberSheetState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SheetValue it) {
                return true;
            }
        } : function1;
        SheetValue initialValue2 = (i & 4) != 0 ? SheetValue.Hidden : initialValue;
        boolean skipHiddenState2 = (i & 8) != 0 ? false : skipHiddenState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1032784200, $changed, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:434)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {Boolean.valueOf(skipPartiallyExpanded2), function2, Boolean.valueOf(skipHiddenState2)};
        Saver<SheetState, SheetValue> Saver = SheetState.INSTANCE.Saver(skipPartiallyExpanded2, function2, density, skipHiddenState2);
        ComposerKt.sourceInformationMarkerStart($composer, 1097106424, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(skipPartiallyExpanded2)) || ($changed & 6) == 4) | $composer.changed(density) | (((($changed & 896) ^ 384) > 256 && $composer.changed(initialValue2)) || ($changed & 384) == 256) | (((($changed & 112) ^ 48) > 32 && $composer.changed(function2)) || ($changed & 48) == 32) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(skipHiddenState2)) || ($changed & 3072) == 2048);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            final boolean z = skipPartiallyExpanded2;
            final SheetValue sheetValue = initialValue2;
            final Function1<? super SheetValue, Boolean> function3 = function2;
            final boolean z2 = skipHiddenState2;
            value$iv = new Function0<SheetState>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SheetState invoke() {
                    return new SheetState(z, density, sheetValue, function3, z2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SheetState sheetState = (SheetState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return sheetState;
    }
}

package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ar\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0002\u0010\u001b\u001a\u00020\u00062\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u009b\u0001\u0010+\u001a\u00020\u00062\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010 ¢\u0006\u0002\b\u00172\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\b\u00172\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0 2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001c\u00103\u001a\u0002042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u000207H\u0002\u001a!\u00108\u001a\u00020\u001e2\b\b\u0002\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\"H\u0007¢\u0006\u0002\u0010;\u001a;\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020/0@2\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010B\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, m195d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = C1979Dp.m6801constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = C1979Dp.m6801constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = C1979Dp.m6801constructorimpl(125);

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1808153344, "C(rememberBottomSheetState)P(2)236@8776L7,244@9018L210,237@8795L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:235)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        boolean z = true;
        Object[] objArr = {animationSpec};
        Saver<BottomSheetState, ?> Saver = BottomSheetState.INSTANCE.Saver(animationSpec, function1, density);
        ComposerKt.sourceInformationMarkerStart($composer, 1877849034, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean zChanged = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density) | $composer.changedInstance(animationSpec);
        if (((($changed & 896) ^ 384) <= 256 || !$composer.changed(function1)) && ($changed & 384) != 256) {
            z = false;
        }
        boolean invalid$iv = z | zChanged;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomSheetState invoke() {
                    return new BottomSheetState(initialValue, density, animationSpec, function1);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -1022285988, "C(rememberBottomSheetScaffoldState)274@9912L35,275@9992L32,277@10066L196:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer, 6, 6);
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, 1807569454, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:276)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1807569528, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(bottomSheetState)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(snackbarHostState)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomSheetScaffoldState;
    }

    /* JADX INFO: renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    public static final void m1588BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        BottomSheetScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int floatingActionButtonPosition2;
        boolean z;
        boolean sheetGesturesEnabled2;
        CornerBasedShape sheetShape2;
        float sheetElevation2;
        int $dirty1;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        float sheetPeekHeight2;
        long sheetBackgroundColor3;
        long backgroundColor2;
        int $dirty;
        long contentColor2;
        long backgroundColor3;
        int $dirty2;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function8;
        float sheetPeekHeight3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11;
        float sheetPeekHeight4;
        float sheetElevation3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        int floatingActionButtonPosition3;
        BottomSheetScaffoldState scaffoldState3;
        boolean sheetGesturesEnabled3;
        Shape sheetShape3;
        long sheetContentColor3;
        long sheetBackgroundColor4;
        long backgroundColor4;
        long contentColor3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-423121424);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffold)P(8,5,6,15,14,3,4:c#material.FabPosition,11,13,10:c#ui.unit.Dp,7:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp,0:c#ui.graphics.Color,2:c#ui.graphics.Color)333@13308L34,339@13677L6,341@13808L6,342@13855L37,344@14008L6,345@14053L32,353@14273L1864,348@14144L1993:BottomSheetScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scaffoldState2 = scaffoldState;
                int i3 = $composer2.changed(scaffoldState2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty3 |= i3;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function7 = function5;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            function7 = function5;
            $dirty3 |= $composer2.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function5;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 1572864) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty3 |= $composer2.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
            z = sheetGesturesEnabled;
        } else if (($changed & 12582912) == 0) {
            z = sheetGesturesEnabled;
            $dirty3 |= $composer2.changed(z) ? 8388608 : 4194304;
        } else {
            z = sheetGesturesEnabled;
        }
        if (($changed & 100663296) == 0) {
            $dirty3 |= ((i & 256) == 0 && $composer2.changed(sheetShape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty3 |= ((i & 512) == 0 && $composer2.changed(sheetElevation)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty4 |= ((i & 1024) == 0 && $composer2.changed(sheetBackgroundColor)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty4 |= ((i & 2048) == 0 && $composer2.changed(sheetContentColor)) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty4 |= ((i & 4096) == 0 && $composer2.changed(sheetPeekHeight)) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty4 |= ((i & 8192) == 0 && $composer2.changed(backgroundColor)) ? 2048 : 1024;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= ((i & 16384) == 0 && $composer2.changed(contentColor)) ? 16384 : 8192;
        }
        if ((i & 32768) != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= $composer2.changedInstance(function6) ? 131072 : 65536;
        }
        if (($dirty3 & 306783379) == 306783378 && (74899 & $dirty4) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function10 = function2;
            function11 = function4;
            sheetShape3 = sheetShape;
            sheetElevation3 = sheetElevation;
            sheetBackgroundColor4 = sheetBackgroundColor;
            sheetContentColor3 = sheetContentColor;
            sheetPeekHeight4 = sheetPeekHeight;
            backgroundColor4 = backgroundColor;
            contentColor3 = contentColor;
            function12 = function7;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            sheetGesturesEnabled3 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, $composer2, 0, 3);
                }
                Function2<? super Composer, ? super Integer, Unit> function13 = i4 != 0 ? null : function2;
                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1654getLambda1$material_release = i5 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1654getLambda1$material_release() : function4;
                if (i6 != 0) {
                    function7 = null;
                }
                if (i7 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1707getEnd5ygKITE();
                }
                sheetGesturesEnabled2 = i8 != 0 ? true : z;
                if ((i & 256) != 0) {
                    sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty3 &= -234881025;
                } else {
                    sheetShape2 = sheetShape;
                }
                if ((i & 512) != 0) {
                    sheetElevation2 = BottomSheetScaffoldDefaults.INSTANCE.m1585getSheetElevationD9Ej5fM();
                    $dirty3 &= -1879048193;
                } else {
                    sheetElevation2 = sheetElevation;
                }
                int $dirty5 = $dirty3;
                if ((i & 1024) != 0) {
                    $dirty1 = $dirty4 & (-15);
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                } else {
                    $dirty1 = $dirty4;
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                Function2<? super Composer, ? super Integer, Unit> function14 = function13;
                if ((i & 2048) != 0) {
                    sheetContentColor2 = ColorsKt.m1645contentColorForek8zF_U(sheetBackgroundColor2, $composer2, $dirty1 & 14);
                    $dirty1 &= -113;
                } else {
                    sheetContentColor2 = sheetContentColor;
                }
                if ((i & 4096) != 0) {
                    sheetPeekHeight2 = BottomSheetScaffoldDefaults.INSTANCE.m1586getSheetPeekHeightD9Ej5fM();
                    $dirty1 &= -897;
                } else {
                    sheetPeekHeight2 = sheetPeekHeight;
                }
                sheetBackgroundColor3 = sheetBackgroundColor2;
                if ((i & 8192) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1620getBackground0d7_KjU();
                    $dirty1 &= -7169;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                float sheetPeekHeight5 = sheetPeekHeight2;
                if ((i & 16384) != 0) {
                    $dirty = $dirty5;
                    $dirty2 = $dirty1 & (-57345);
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty1 >> 9) & 14);
                    sheetPeekHeight3 = sheetPeekHeight5;
                    backgroundColor3 = backgroundColor2;
                    function8 = function3M1654getLambda1$material_release;
                    modifier2 = modifier4;
                    function9 = function14;
                } else {
                    $dirty = $dirty5;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty1;
                    function8 = function3M1654getLambda1$material_release;
                    modifier2 = modifier4;
                    sheetPeekHeight3 = sheetPeekHeight5;
                    function9 = function14;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty3 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty4 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty4 &= -113;
                }
                if ((i & 4096) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty4 &= -57345;
                }
                sheetElevation2 = sheetElevation;
                sheetBackgroundColor3 = sheetBackgroundColor;
                sheetContentColor2 = sheetContentColor;
                sheetPeekHeight3 = sheetPeekHeight;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                $dirty = $dirty3;
                $dirty2 = $dirty4;
                sheetGesturesEnabled2 = z;
                function9 = function2;
                function8 = function4;
                sheetShape2 = sheetShape;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-423121424, $dirty, $dirty2, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:347)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
            final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState2;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function7;
            final float f = sheetPeekHeight3;
            final int i9 = floatingActionButtonPosition2;
            final boolean z2 = sheetGesturesEnabled2;
            final Shape shape = sheetShape2;
            final float f2 = sheetElevation2;
            final long j = sheetBackgroundColor3;
            final long j2 = sheetContentColor2;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function17 = function8;
            Function2<Composer, Integer, Unit> function18 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C356@14358L52,357@14438L1265,384@15789L77,389@15998L50,354@14283L1848:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-131096268, $changed2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:354)");
                        }
                        BottomSheetState bottomSheetState = bottomSheetScaffoldState.getBottomSheetState();
                        Function2<Composer, Integer, Unit> function19 = function15;
                        final Function3<PaddingValues, Composer, Integer, Unit> function20 = function6;
                        final float f3 = f;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1143451324, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C356@14360L48:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1143451324, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:356)");
                                }
                                function20.invoke(PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f3, 7, null), $composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54);
                        final boolean z3 = z2;
                        final BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                        final float f4 = f;
                        final Shape shape2 = shape;
                        final float f5 = f2;
                        final long j3 = j;
                        final long j4 = j2;
                        final Function3<ColumnScope, Composer, Integer, Unit> function21 = function3;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1856649243, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Modifier.Companion companionNestedScroll$default;
                                Object value$iv2;
                                ComposerKt.sourceInformation($composer4, "C369@15064L625:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1856649243, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:358)");
                                    }
                                    $composer4.startReplaceGroup(-816855191);
                                    ComposerKt.sourceInformation($composer4, "361@14599L390");
                                    if (z3) {
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState2.getBottomSheetState().getAnchoredDraggableState$material_release();
                                        ComposerKt.sourceInformationMarkerStart($composer4, -816855067, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                        boolean invalid$iv = $composer4.changed(anchoredDraggableState$material_release);
                                        BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                        Object it$iv = $composer4.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState3.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                            $composer4.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) value$iv2, null, 2, null);
                                    } else {
                                        companionNestedScroll$default = Modifier.INSTANCE;
                                    }
                                    $composer4.endReplaceGroup();
                                    Modifier nestedScroll = companionNestedScroll$default;
                                    BottomSheetScaffoldKt.m1587BottomSheetdAqlCkY(bottomSheetScaffoldState2.getBottomSheetState(), z3, shape2, f5, j3, j4, f4, SizeKt.m904requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(nestedScroll, 0.0f, 1, null), f4, 0.0f, 2, null), function21, $composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54);
                        Function2<Composer, Integer, Unit> function22 = function16;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function23 = function17;
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState;
                        ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C385@15807L45:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1011922215, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:385)");
                                }
                                function23.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), $composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54);
                        float f6 = f;
                        ComposerKt.sourceInformationMarkerStart($composer3, -249545029, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(bottomSheetScaffoldState);
                        final BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$4$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(bottomSheetScaffoldState4.getBottomSheetState().requireOffset());
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        BottomSheetScaffoldKt.m1589BottomSheetScaffoldLayoutHJHHjMs(function19, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, function22, composableLambdaRememberComposableLambda3, f6, (Function0) value$iv, i9, bottomSheetState, $composer3, 25008);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            };
            Function2<? super Composer, ? super Integer, Unit> function19 = function9;
            Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function20 = function8;
            SurfaceKt.m1809SurfaceFjzlyU(modifierFillMaxSize$default, null, backgroundColor3, contentColor2, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-131096268, true, function18, $composer2, 54), $composer2, (($dirty2 >> 3) & 896) | 1572864 | (($dirty2 >> 3) & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function10 = function19;
            function11 = function20;
            sheetPeekHeight4 = sheetPeekHeight3;
            sheetElevation3 = sheetElevation2;
            function12 = function7;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            scaffoldState3 = scaffoldState2;
            sheetGesturesEnabled3 = sheetGesturesEnabled2;
            sheetShape3 = sheetShape2;
            sheetContentColor3 = sheetContentColor2;
            sheetBackgroundColor4 = sheetBackgroundColor3;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState3;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function10;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function22 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function12;
            final int i10 = floatingActionButtonPosition3;
            final boolean z3 = sheetGesturesEnabled3;
            final Shape shape2 = sheetShape3;
            final float f3 = sheetElevation3;
            final long j3 = sheetBackgroundColor4;
            final long j4 = sheetContentColor3;
            final float f4 = sheetPeekHeight4;
            final long j5 = backgroundColor4;
            final long j6 = contentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i11) {
                    BottomSheetScaffoldKt.m1588BottomSheetScaffoldHnlDQGw(function3, modifier5, bottomSheetScaffoldState2, function21, function22, function23, i10, z3, shape2, f3, j3, j4, f4, j5, j6, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:140:0x02b7  */
    /* JADX INFO: renamed from: BottomSheet-dAqlCkY, reason: not valid java name */
    public static final void m1587BottomSheetdAqlCkY(final BottomSheetState state, final boolean sheetGesturesEnabled, final Shape sheetShape, final float sheetElevation, final long sheetBackgroundColor, final long sheetContentColor, final float sheetPeekHeight, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Object value$iv$iv;
        Object value$iv;
        Modifier modifier2;
        Object value$iv2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-412323066);
        ComposerKt.sourceInformation($composer2, "C(BottomSheet)P(8,5,7,4:c#ui.unit.Dp,2:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.unit.Dp,1)408@16519L24,*409@16585L7,415@16779L792,436@17795L893,461@18852L29,410@16625L2262:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(sheetGesturesEnabled) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(sheetShape) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sheetElevation) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(sheetBackgroundColor) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(sheetContentColor) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(modifier) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412323066, $dirty, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:407)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BottomSheet_dAqlCkY_u24lambda_u243 = (Density) objConsume;
            final float peekHeightPx = $this$BottomSheet_dAqlCkY_u24lambda_u243.mo567toPx0680j_4(sheetPeekHeight);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = state.getAnchoredDraggableState$material_release();
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart($composer2, 1755417853, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(peekHeightPx) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<BottomSheetValue>, ? extends BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BottomSheetValue.values().length];
                            try {
                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<BottomSheetValue>, ? extends BottomSheetValue> invoke(IntSize intSize, Constraints constraints) {
                        return m1592invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                    public final Pair<DraggableAnchors<BottomSheetValue>, BottomSheetValue> m1592invokeGpV2Q24(long sheetSize, long constraints) {
                        BottomSheetValue newTarget;
                        final int layoutHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        final float sheetHeight = IntSize.m6974getHeightimpl(sheetSize);
                        final float f = peekHeightPx;
                        DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1$newAnchors$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                invoke2(draggableAnchorsConfig);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                draggableAnchorsConfig.m15at(BottomSheetValue.Collapsed, layoutHeight - f);
                                if (sheetHeight > 0.0f) {
                                    if (!(sheetHeight == f)) {
                                        draggableAnchorsConfig.m15at(BottomSheetValue.Expanded, layoutHeight - sheetHeight);
                                    }
                                }
                            }
                        });
                        switch (WhenMappings.$EnumSwitchMapping$0[state.getAnchoredDraggableState$material_release().getTargetValue().ordinal()]) {
                            case 1:
                                newTarget = BottomSheetValue.Collapsed;
                                break;
                            case 2:
                                newTarget = !newAnchors.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Collapsed : BottomSheetValue.Expanded;
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        return TuplesKt.m202to(newAnchors, newTarget);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(modifier4, anchoredDraggableState$material_release, orientation, (Function2) value$iv);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release2 = state.getAnchoredDraggableState$material_release();
            Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(modifierDraggableAnchors, anchoredDraggableState$material_release2, Orientation.Vertical, (56 & 4) != 0 ? true : sheetGesturesEnabled, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release2.isAnimationRunning() : false);
            ComposerKt.sourceInformationMarkerStart($composer2, 1755418869, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | $composer2.changedInstance(scope);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
                modifier2 = modifier4;
            } else {
                modifier2 = modifier4;
                if (it$iv2 != Composer.INSTANCE.getEmpty()) {
                    value$iv2 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SurfaceKt.m1809SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable, false, (Function1) value$iv2, 1, null), sheetShape, sheetBackgroundColor, sheetContentColor, null, sheetElevation, ComposableLambdaKt.rememberComposableLambda(2055704138, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C461@18854L25:BottomSheetScaffold.kt#jmzs0o");
                        if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2055704138, $changed2, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:461)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function4 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        function4.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf(((0 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, (($dirty >> 3) & 112) | 1572864 | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (458752 & ($dirty << 6)), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    if (state.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                        if (state.isCollapsed()) {
                            final BottomSheetState bottomSheetState = state;
                            final CoroutineScope coroutineScope = scope;
                            SemanticsPropertiesKt.expand$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {444}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetState $state;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$state = bottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$state, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$state.expand(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (bottomSheetState.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(bottomSheetState, null), 3, null);
                                    }
                                    return true;
                                }
                            }, 1, null);
                        } else {
                            final BottomSheetState bottomSheetState2 = state;
                            final CoroutineScope coroutineScope2 = scope;
                            SemanticsPropertiesKt.collapse$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$2$1, reason: invalid class name */
                                /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$2$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_UNAVAILABLE_FOR_LEGAL_REASONS}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetState $state;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$state = bottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$state, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$state.collapse(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (bottomSheetState2.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomSheetState2, null), 3, null);
                                    }
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.m1809SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable, false, (Function1) value$iv2, 1, null), sheetShape, sheetBackgroundColor, sheetContentColor, null, sheetElevation, ComposableLambdaKt.rememberComposableLambda(2055704138, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C461@18854L25:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2055704138, $changed2, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:461)");
                    }
                    Function3<ColumnScope, Composer, Integer, Unit> function4 = function3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(constructor);
                    } else {
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    function4.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf(((0 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 112) | 1572864 | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (458752 & ($dirty << 6)), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    BottomSheetScaffoldKt.m1587BottomSheetdAqlCkY(state, sheetGesturesEnabled, sheetShape, sheetElevation, sheetBackgroundColor, sheetContentColor, sheetPeekHeight, modifier5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    public static final void m1589BottomSheetScaffoldLayoutHJHHjMs(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final float sheetPeekHeight, final Function0<Float> function0, final int floatingActionButtonPosition, final BottomSheetState sheetState, Composer $composer, final int $changed) {
        MultiContentMeasurePolicy value$iv;
        Object value$iv$iv;
        Function0<ComposeUiNode> function1;
        Composer $composer2 = $composer.startRestartGroup(1411837005);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,4,3:c#material.FabPosition)509@20078L2668,501@19867L2879:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1411837005, $dirty2, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:500)");
            }
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1655getLambda2$material_release() : function2;
            function2Arr[1] = function3;
            function2Arr[2] = function4;
            function2Arr[3] = function5 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1656getLambda3$material_release() : function5;
            function2Arr[4] = function6;
            List contents$iv = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart($composer2, 848696192, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = ((3670016 & $dirty2) == 1048576) | ((29360128 & $dirty2) == 8388608) | ((458752 & $dirty2) == 131072) | ((234881024 & $dirty2) == 67108864);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MultiContentMeasurePolicy() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo816measure3p2s80s(final MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        Object maxElem$iv3;
                        Object maxElem$iv4;
                        Object maxElem$iv5;
                        List<? extends Measurable> list2 = list.get(0);
                        List<? extends Measurable> list3 = list.get(1);
                        List<? extends Measurable> list4 = list.get(2);
                        List<? extends Measurable> list5 = list.get(3);
                        List<? extends Measurable> list6 = list.get(4);
                        final int layoutWidth = Constraints.m6744getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                        List target$iv = new ArrayList(list4.size());
                        int index$iv$iv = 0;
                        int size = list4.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = list4.get(index$iv$iv);
                            List<? extends Measurable> list7 = list4;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            list4 = list7;
                        }
                        final List sheetPlaceables = target$iv;
                        List<? extends Measurable> list8 = list2;
                        List target$iv2 = new ArrayList(list8.size());
                        int index$iv$iv2 = 0;
                        int size2 = list8.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = list8.get(index$iv$iv2);
                            List<? extends Measurable> list9 = list2;
                            Measurable it2 = (Measurable) item$iv$iv2;
                            target$iv2.add(it2.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv2++;
                            list8 = list8;
                            list2 = list9;
                        }
                        final List topBarPlaceables = target$iv2;
                        if (!topBarPlaceables.isEmpty()) {
                            maxElem$iv = topBarPlaceables.get(0);
                            Placeable it3 = (Placeable) maxElem$iv;
                            int maxValue$iv = it3.getHeight();
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object e$iv = topBarPlaceables.get(i$iv);
                                    Placeable it4 = (Placeable) e$iv;
                                    int v$iv = it4.getHeight();
                                    if (maxValue$iv < v$iv) {
                                        maxElem$iv = e$iv;
                                        maxValue$iv = v$iv;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        } else {
                            maxElem$iv = null;
                        }
                        Placeable placeable = (Placeable) maxElem$iv;
                        int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                        long bodyConstraints = Constraints.m6734copyZbe2FdA(looseConstraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(looseConstraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(looseConstraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(looseConstraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(looseConstraints) : layoutHeight - topBarHeight);
                        List<? extends Measurable> list10 = list3;
                        List target$iv3 = new ArrayList(list10.size());
                        int index$iv$iv3 = 0;
                        int size3 = list10.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = list10.get(index$iv$iv3);
                            List<? extends Measurable> list11 = list3;
                            Measurable it5 = (Measurable) item$iv$iv3;
                            target$iv3.add(it5.mo5644measureBRTryo0(bodyConstraints));
                            index$iv$iv3++;
                            list10 = list10;
                            list3 = list11;
                        }
                        final List bodyPlaceables = target$iv3;
                        List<? extends Measurable> list12 = list5;
                        int $i$f$fastMap = 0;
                        List target$iv4 = new ArrayList(list12.size());
                        int index$iv$iv4 = 0;
                        int size4 = list12.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = list12.get(index$iv$iv4);
                            int $i$f$fastMap2 = $i$f$fastMap;
                            Measurable it6 = (Measurable) item$iv$iv4;
                            target$iv4.add(it6.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            list12 = list12;
                            $i$f$fastMap = $i$f$fastMap2;
                        }
                        final List fabPlaceable = target$iv4;
                        if (!fabPlaceable.isEmpty()) {
                            maxElem$iv2 = fabPlaceable.get(0);
                            Placeable it7 = (Placeable) maxElem$iv2;
                            int maxValue$iv2 = it7.getWidth();
                            int i$iv2 = 1;
                            int lastIndex2 = CollectionsKt.getLastIndex(fabPlaceable);
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object e$iv2 = fabPlaceable.get(i$iv2);
                                    Placeable it8 = (Placeable) e$iv2;
                                    int v$iv2 = it8.getWidth();
                                    if (maxValue$iv2 < v$iv2) {
                                        maxElem$iv2 = e$iv2;
                                        maxValue$iv2 = v$iv2;
                                    }
                                    if (i$iv2 == lastIndex2) {
                                        break;
                                    }
                                    i$iv2++;
                                }
                            }
                        } else {
                            maxElem$iv2 = null;
                        }
                        Placeable placeable2 = (Placeable) maxElem$iv2;
                        final int fabWidth = placeable2 != null ? placeable2.getWidth() : 0;
                        List $this$fastMaxBy$iv = fabPlaceable;
                        if ($this$fastMaxBy$iv.isEmpty()) {
                            maxElem$iv3 = null;
                        } else {
                            maxElem$iv3 = $this$fastMaxBy$iv.get(0);
                            Placeable it9 = (Placeable) maxElem$iv3;
                            int maxValue$iv3 = it9.getHeight();
                            int i$iv3 = 1;
                            int lastIndex3 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                            if (1 <= lastIndex3) {
                                while (true) {
                                    Object e$iv3 = $this$fastMaxBy$iv.get(i$iv3);
                                    Placeable it10 = (Placeable) e$iv3;
                                    int height = it10.getHeight();
                                    List $this$fastMaxBy$iv2 = $this$fastMaxBy$iv;
                                    if (maxValue$iv3 < height) {
                                        maxElem$iv3 = e$iv3;
                                        maxValue$iv3 = height;
                                    }
                                    if (i$iv3 == lastIndex3) {
                                        break;
                                    }
                                    i$iv3++;
                                    $this$fastMaxBy$iv = $this$fastMaxBy$iv2;
                                }
                            }
                        }
                        Placeable placeable3 = (Placeable) maxElem$iv3;
                        final int fabHeight = placeable3 != null ? placeable3.getHeight() : 0;
                        List<? extends Measurable> list13 = list6;
                        List target$iv5 = new ArrayList(list13.size());
                        int index$iv$iv5 = 0;
                        int size5 = list13.size();
                        while (index$iv$iv5 < size5) {
                            Object item$iv$iv5 = list13.get(index$iv$iv5);
                            List<? extends Measurable> list14 = list13;
                            Measurable it11 = (Measurable) item$iv$iv5;
                            target$iv5.add(it11.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv5++;
                            size5 = size5;
                            list13 = list14;
                        }
                        final List snackbarPlaceables = target$iv5;
                        List $this$fastMaxBy$iv3 = snackbarPlaceables;
                        if ($this$fastMaxBy$iv3.isEmpty()) {
                            maxElem$iv4 = null;
                        } else {
                            maxElem$iv4 = $this$fastMaxBy$iv3.get(0);
                            Placeable it12 = (Placeable) maxElem$iv4;
                            int maxValue$iv4 = it12.getWidth();
                            int i$iv4 = 1;
                            int lastIndex4 = CollectionsKt.getLastIndex($this$fastMaxBy$iv3);
                            if (1 <= lastIndex4) {
                                while (true) {
                                    Object e$iv4 = $this$fastMaxBy$iv3.get(i$iv4);
                                    Placeable it13 = (Placeable) e$iv4;
                                    int width = it13.getWidth();
                                    List $this$fastMaxBy$iv4 = $this$fastMaxBy$iv3;
                                    if (maxValue$iv4 < width) {
                                        maxElem$iv4 = e$iv4;
                                        maxValue$iv4 = width;
                                    }
                                    if (i$iv4 == lastIndex4) {
                                        break;
                                    }
                                    i$iv4++;
                                    $this$fastMaxBy$iv3 = $this$fastMaxBy$iv4;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) maxElem$iv4;
                        final int snackbarWidth = placeable4 != null ? placeable4.getWidth() : 0;
                        List $this$fastMaxBy$iv5 = snackbarPlaceables;
                        if ($this$fastMaxBy$iv5.isEmpty()) {
                            maxElem$iv5 = null;
                        } else {
                            Object maxElem$iv6 = $this$fastMaxBy$iv5.get(0);
                            Placeable it14 = (Placeable) maxElem$iv6;
                            int maxValue$iv5 = it14.getHeight();
                            int i$iv5 = 1;
                            int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv5);
                            if (1 <= lastIndex5) {
                                while (true) {
                                    Object e$iv5 = $this$fastMaxBy$iv5.get(i$iv5);
                                    Placeable it15 = (Placeable) e$iv5;
                                    int height2 = it15.getHeight();
                                    List $this$fastMaxBy$iv6 = $this$fastMaxBy$iv5;
                                    if (maxValue$iv5 < height2) {
                                        maxElem$iv6 = e$iv5;
                                        maxValue$iv5 = height2;
                                    }
                                    if (i$iv5 == lastIndex5) {
                                        break;
                                    }
                                    i$iv5++;
                                    $this$fastMaxBy$iv5 = $this$fastMaxBy$iv6;
                                }
                            }
                            maxElem$iv5 = maxElem$iv6;
                        }
                        Placeable placeable5 = (Placeable) maxElem$iv5;
                        final int snackbarHeight = placeable5 != null ? placeable5.getHeight() : 0;
                        final Function0<Float> function7 = function0;
                        final int i = floatingActionButtonPosition;
                        final float f = sheetPeekHeight;
                        final BottomSheetState bottomSheetState = sheetState;
                        final int i2 = topBarHeight;
                        return MeasureScope.CC.layout$default($this$Layout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                            /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                            /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[BottomSheetValue.values().length];
                                    try {
                                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                int fabOffsetX;
                                int fabOffsetY;
                                int snackbarOffsetY;
                                int sheetOffsetY = MathKt.roundToInt(function7.invoke().floatValue());
                                int i3 = i;
                                if (FabPosition.m1702equalsimpl0(i3, FabPosition.INSTANCE.m1708getStart5ygKITE())) {
                                    fabOffsetX = $this$Layout.mo561roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
                                } else {
                                    fabOffsetX = FabPosition.m1702equalsimpl0(i3, FabPosition.INSTANCE.m1706getCenter5ygKITE()) ? (layoutWidth - fabWidth) / 2 : (layoutWidth - fabWidth) - $this$Layout.mo561roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
                                }
                                if ($this$Layout.mo567toPx0680j_4(f) < fabHeight / 2) {
                                    fabOffsetY = (sheetOffsetY - fabHeight) - $this$Layout.mo561roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
                                } else {
                                    fabOffsetY = sheetOffsetY - (fabHeight / 2);
                                }
                                int snackbarOffsetX = (layoutWidth - snackbarWidth) / 2;
                                switch (WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getCurrentValue().ordinal()]) {
                                    case 1:
                                        snackbarOffsetY = fabOffsetY - snackbarHeight;
                                        break;
                                    case 2:
                                        snackbarOffsetY = layoutHeight - snackbarHeight;
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                List<Placeable> list15 = bodyPlaceables;
                                int i4 = i2;
                                int size6 = list15.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = list15.get(index$iv);
                                    Placeable it16 = (Placeable) item$iv;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it16, 0, i4, 0.0f, 4, null);
                                }
                                List<Placeable> list16 = topBarPlaceables;
                                int size7 = list16.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = list16.get(index$iv2);
                                    Placeable it17 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it17, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list17 = sheetPlaceables;
                                int size8 = list17.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = list17.get(index$iv3);
                                    Placeable it18 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it18, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list18 = fabPlaceable;
                                int size9 = list18.size();
                                for (int index$iv4 = 0; index$iv4 < size9; index$iv4++) {
                                    Object item$iv4 = list18.get(index$iv4);
                                    Placeable it19 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it19, fabOffsetX, fabOffsetY, 0.0f, 4, null);
                                }
                                List<Placeable> list19 = snackbarPlaceables;
                                int size10 = list19.size();
                                for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                    Object item$iv5 = list19.get(index$iv5);
                                    Placeable it20 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it20, snackbarOffsetX, snackbarOffsetY, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MultiContentMeasurePolicy measurePolicy$iv = (MultiContentMeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(contents$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, 1376093675, "CC(remember):Layout.kt#9igjgp");
            boolean invalid$iv$iv = (((0 & 896) ^ 384) > 256 && $composer2.changed(measurePolicy$iv)) || (0 & 384) == 256;
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy$iv);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = 0 & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor;
                $composer2.createNode(function1);
            } else {
                function1 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke($composer2, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    BottomSheetScaffoldKt.m1589BottomSheetScaffoldLayoutHJHHjMs(function2, function3, function4, function5, function6, sheetPeekHeight, function0, floatingActionButtonPosition, sheetState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(m194d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m195d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class C09781 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C09781(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
        }

        @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo670onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5403getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }

        @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5403getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public Object mo669onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
            C0980xe2eca24b c0980xe2eca24b;
            if (continuation instanceof C0980xe2eca24b) {
                c0980xe2eca24b = (C0980xe2eca24b) continuation;
                if ((c0980xe2eca24b.label & Integer.MIN_VALUE) != 0) {
                    c0980xe2eca24b.label -= Integer.MIN_VALUE;
                } else {
                    c0980xe2eca24b = new C0980xe2eca24b(this, continuation);
                }
            } else {
                c0980xe2eca24b = new C0980xe2eca24b(this, continuation);
            }
            C0980xe2eca24b c0980xe2eca24b2 = c0980xe2eca24b;
            Object $result = c0980xe2eca24b2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c0980xe2eca24b2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float toFling = velocityToFloat(available);
                    float currentOffset = this.$state.requireOffset();
                    if (toFling < 0.0f && currentOffset > this.$state.getAnchors().minAnchor()) {
                        AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                        c0980xe2eca24b2.J$0 = available;
                        c0980xe2eca24b2.label = 1;
                        if (anchoredDraggableState.settle(toFling, c0980xe2eca24b2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        available = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                    }
                    break;
                case 1:
                    available = c0980xe2eca24b2.J$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Velocity.m7033boximpl(available);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo667onPostFlingRZ2iAVY(long j, long available, Continuation<? super Velocity> continuation) {
            C0979x8eaee744 c0979x8eaee744;
            if (continuation instanceof C0979x8eaee744) {
                c0979x8eaee744 = (C0979x8eaee744) continuation;
                if ((c0979x8eaee744.label & Integer.MIN_VALUE) != 0) {
                    c0979x8eaee744.label -= Integer.MIN_VALUE;
                } else {
                    c0979x8eaee744 = new C0979x8eaee744(this, continuation);
                }
            } else {
                c0979x8eaee744 = new C0979x8eaee744(this, continuation);
            }
            Object $result = c0979x8eaee744.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c0979x8eaee744.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    float fVelocityToFloat = velocityToFloat(available);
                    c0979x8eaee744.J$0 = available;
                    c0979x8eaee744.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, c0979x8eaee744) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    available = c0979x8eaee744.J$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Velocity.m7033boximpl(available);
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m7042getXimpl($this$toFloat) : Velocity.m7043getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m4049getXimpl($this$toFloat) : Offset.m4050getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C09781(anchoredDraggableState, orientation);
    }
}

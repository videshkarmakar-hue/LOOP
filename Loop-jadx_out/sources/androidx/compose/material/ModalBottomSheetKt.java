package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0093\u0001\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a0\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u0010&\u001a\u00020\u0017H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aE\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u00100\u001a\u00020\u0017H\u0007¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063²\u0006\n\u00104\u001a\u00020.X\u008a\u0084\u0002"}, m195d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "modalBottomSheetAnchors", "material_release", "alpha"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = C1979Dp.m6801constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = C1979Dp.m6801constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = C1979Dp.m6801constructorimpl(640);

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean skipHalfExpanded, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -126412120, "C(rememberModalBottomSheetState)P(2)291@11506L7:ModalBottomSheet.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = (i & 2) != 0 ? ModalBottomSheetDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        Function1<? super ModalBottomSheetValue, Boolean> function2 = (i & 4) != 0 ? new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ModalBottomSheetValue it) {
                return true;
            }
        } : function1;
        boolean skipHalfExpanded2 = (i & 8) != 0 ? false : skipHalfExpanded;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:290)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        $composer.startMovableGroup(170045316, initialValue);
        ComposerKt.sourceInformation($composer, "304@12115L298,296@11767L646");
        Object[] objArr = {initialValue, animationSpec2, Boolean.valueOf(skipHalfExpanded2), function2, density};
        Saver<ModalBottomSheetState, ?> Saver = ModalBottomSheetState.INSTANCE.Saver(animationSpec2, function2, skipHalfExpanded2, density);
        ComposerKt.sourceInformationMarkerStart($composer, 170045692, "CC(remember):ModalBottomSheet.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density) | (((($changed & 896) ^ 384) > 256 && $composer.changed(function2)) || ($changed & 384) == 256) | $composer.changedInstance(animationSpec2) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(skipHalfExpanded2)) || ($changed & 3072) == 2048);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            final Function1<? super ModalBottomSheetValue, Boolean> function3 = function2;
            final AnimationSpec<Float> animationSpec3 = animationSpec2;
            final boolean z = skipHalfExpanded2;
            value$iv = new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ModalBottomSheetState invoke() {
                    return new ModalBottomSheetState(initialValue, density, function3, animationSpec3, z);
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modalBottomSheetState;
    }

    /* JADX INFO: renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    public static final void m1730ModalBottomSheetLayoutGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, ModalBottomSheetState sheetState, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape sheetShape2;
        float f;
        long j;
        final ModalBottomSheetState sheetState2;
        boolean sheetGesturesEnabled2;
        CornerBasedShape sheetShape3;
        float sheetElevation2;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        long scrimColor2;
        int $dirty;
        long sheetContentColor3;
        long sheetContentColor4;
        Object value$iv$iv;
        long sheetBackgroundColor3;
        Modifier modifier3;
        Shape sheetShape4;
        Function0<ComposeUiNode> function0;
        Object value$iv;
        Modifier.Companion companionNestedScroll$default;
        boolean sheetGesturesEnabled3;
        Modifier.Companion companionSemantics$default;
        boolean sheetGesturesEnabled4;
        float sheetElevation3;
        long sheetContentColor5;
        ModalBottomSheetState sheetState3;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-92970288);
        ComposerKt.sourceInformation($composer2, "C(ModalBottomSheetLayout)P(4,1,9,7,8,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)352@14482L37,354@14601L6,356@14724L6,357@14771L37,358@14859L10,361@14927L24,363@14999L3822:ModalBottomSheet.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer2.changedInstance(sheetState)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(sheetGesturesEnabled) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                sheetShape2 = sheetShape;
                int i4 = $composer2.changed(sheetShape2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                sheetShape2 = sheetShape;
            }
            $dirty2 |= i4;
        } else {
            sheetShape2 = sheetShape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                f = sheetElevation;
                int i5 = $composer2.changed(f) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                f = sheetElevation;
            }
            $dirty2 |= i5;
        } else {
            f = sheetElevation;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(sheetBackgroundColor)) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(sheetContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            if ((i & 256) == 0) {
                j = scrimColor;
                int i6 = $composer2.changed(j) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty2 |= i6;
            } else {
                j = scrimColor;
            }
            $dirty2 |= i6;
        } else {
            j = scrimColor;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if ((306783379 & $dirty3) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            sheetState3 = sheetState;
            sheetGesturesEnabled4 = sheetGesturesEnabled;
            sheetBackgroundColor3 = sheetBackgroundColor;
            sheetContentColor5 = sheetContentColor;
            modifier3 = modifier2;
            sheetElevation3 = f;
            sheetShape4 = sheetShape2;
            scrimColor2 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    sheetState2 = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, $composer2, 6, 14);
                    $dirty3 &= -897;
                } else {
                    sheetState2 = sheetState;
                }
                sheetGesturesEnabled2 = i3 != 0 ? true : sheetGesturesEnabled;
                if ((i & 16) != 0) {
                    sheetShape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty3 &= -57345;
                } else {
                    sheetShape3 = sheetShape;
                }
                if ((i & 32) != 0) {
                    sheetElevation2 = ModalBottomSheetDefaults.INSTANCE.m1729getElevationD9Ej5fM();
                    $dirty3 &= -458753;
                } else {
                    sheetElevation2 = sheetElevation;
                }
                if ((i & 64) != 0) {
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty3 &= -3670017;
                } else {
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                if ((i & 128) != 0) {
                    sheetContentColor2 = ColorsKt.m1645contentColorForek8zF_U(sheetBackgroundColor2, $composer2, ($dirty3 >> 18) & 14);
                    $dirty3 &= -29360129;
                } else {
                    sheetContentColor2 = sheetContentColor;
                }
                if ((i & 256) != 0) {
                    scrimColor2 = ModalBottomSheetDefaults.INSTANCE.getScrimColor($composer2, 0);
                    long j2 = sheetBackgroundColor2;
                    sheetShape2 = sheetShape3;
                    $dirty = $dirty3 & (-234881025);
                    modifier2 = modifier4;
                    sheetContentColor3 = sheetContentColor2;
                    sheetContentColor4 = j2;
                } else {
                    scrimColor2 = scrimColor;
                    long j3 = sheetBackgroundColor2;
                    sheetShape2 = sheetShape3;
                    $dirty = $dirty3;
                    modifier2 = modifier4;
                    sheetContentColor3 = sheetContentColor2;
                    sheetContentColor4 = j3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i7 = (-234881025) & $dirty3;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetContentColor3 = sheetContentColor;
                    sheetElevation2 = f;
                    scrimColor2 = j;
                    sheetContentColor4 = sheetBackgroundColor;
                    $dirty = i7;
                    sheetState2 = sheetState;
                } else {
                    sheetState2 = sheetState;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetElevation2 = f;
                    scrimColor2 = j;
                    $dirty = $dirty3;
                    sheetContentColor4 = sheetBackgroundColor;
                    sheetContentColor3 = sheetContentColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92970288, $dirty, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:360)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            float sheetElevation4 = sheetElevation2;
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
            Orientation orientation = Orientation.Vertical;
            int $changed$iv = ($dirty >> 3) & 14;
            long sheetContentColor6 = sheetContentColor3;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            sheetBackgroundColor3 = sheetContentColor4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier2);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            modifier3 = modifier2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            sheetShape4 = sheetShape2;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i9 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$ModalBottomSheetLayout_Gs3lGvM_u24lambda_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1241526201, "C364@15023L430,443@18761L54,376@15462L3353:ModalBottomSheet.kt#jmzs0o");
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor2;
                $composer2.createNode(function0);
            } else {
                function0 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i11 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1295125756, "C365@15065L9,368@15158L188,366@15087L356:ModalBottomSheet.kt#jmzs0o");
            function2.invoke($composer2, Integer.valueOf(($dirty >> 27) & 14));
            ComposerKt.sourceInformationMarkerStart($composer2, -1295125663, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(sheetState2) | $composer2.changedInstance(scope);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1 */
                    /* JADX INFO: compiled from: ModalBottomSheet.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1", m210f = "ModalBottomSheet.kt", m211i = {}, m212l = {371}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C10531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ModalBottomSheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C10531(ModalBottomSheetState modalBottomSheetState, Continuation<? super C10531> continuation) {
                            super(2, continuation);
                            this.$sheetState = modalBottomSheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C10531(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C10531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (sheetState2.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C10531(sheetState2, null), 3, null);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Function0 function1 = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m1731Scrim3JVO9M(scrimColor2, function1, sheetState2.getAnchoredDraggableState$material_release().getTargetValue() != ModalBottomSheetValue.Hidden, $composer2, ($dirty >> 24) & 14);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m920widthInVpY3zN4$default($this$ModalBottomSheetLayout_Gs3lGvM_u24lambda_u245.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0.0f, MaxModalBottomSheetWidth, 1, null), 0.0f, 1, null);
            $composer2.startReplaceGroup(1241526899);
            ComposerKt.sourceInformation($composer2, "384@15824L354");
            if (sheetGesturesEnabled2) {
                Modifier.Companion companion = Modifier.INSTANCE;
                Object anchoredDraggableState$material_release = sheetState2.getAnchoredDraggableState$material_release();
                ComposerKt.sourceInformationMarkerStart($composer2, 1241527002, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(anchoredDraggableState$material_release);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState2.getAnchoredDraggableState$material_release(), orientation);
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) value$iv3, null, 2, null);
            } else {
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Modifier modifierModalBottomSheetAnchors = modalBottomSheetAnchors(modifierFillMaxWidth$default.then(companionNestedScroll$default), sheetState2);
            AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState$material_release2 = sheetState2.getAnchoredDraggableState$material_release();
            Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(modifierModalBottomSheetAnchors, anchoredDraggableState$material_release2, orientation, (56 & 4) != 0 ? true : sheetGesturesEnabled2 && sheetState2.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release2.isAnimationRunning() : false);
            $composer2.startReplaceGroup(1241527833);
            ComposerKt.sourceInformation($composer2, "402@16726L1810");
            if (sheetGesturesEnabled2) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1241527904, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(sheetState2) | $composer2.changedInstance(scope);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3) {
                    sheetGesturesEnabled3 = sheetGesturesEnabled2;
                } else {
                    sheetGesturesEnabled3 = sheetGesturesEnabled2;
                    if (it$iv3 != Composer.INSTANCE.getEmpty()) {
                        value$iv2 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv2, 1, null);
                }
                value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
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
                        if (sheetState2.isVisible()) {
                            final ModalBottomSheetState modalBottomSheetState = sheetState2;
                            final CoroutineScope coroutineScope = scope;
                            SemanticsPropertiesKt.dismiss$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (modalBottomSheetState.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(modalBottomSheetState, null), 3, null);
                                    }
                                    return true;
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: ModalBottomSheet.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1", m210f = "ModalBottomSheet.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_CONFLICT}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$sheetState = modalBottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$sheetState, continuation);
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
                                                if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                            }, 1, null);
                            if (sheetState2.getAnchoredDraggableState$material_release().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                final ModalBottomSheetState modalBottomSheetState2 = sheetState2;
                                final CoroutineScope coroutineScope2 = scope;
                                SemanticsPropertiesKt.expand$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (modalBottomSheetState2.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(modalBottomSheetState2, null), 3, null);
                                        }
                                        return true;
                                    }

                                    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: ModalBottomSheet.kt */
                                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(m209c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1", m210f = "ModalBottomSheet.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_MISDIRECTED_REQUEST}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ ModalBottomSheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = modalBottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, continuation);
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
                                                    if (this.$sheetState.expand$material_release(this) == coroutine_suspended) {
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
                                }, 1, null);
                            } else if (sheetState2.getHasHalfExpandedState$material_release()) {
                                final ModalBottomSheetState modalBottomSheetState3 = sheetState2;
                                final CoroutineScope coroutineScope3 = scope;
                                SemanticsPropertiesKt.collapse$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (modalBottomSheetState3.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(modalBottomSheetState3, null), 3, null);
                                        }
                                        return true;
                                    }

                                    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: ModalBottomSheet.kt */
                                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(m209c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1", m210f = "ModalBottomSheet.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_REQUEST_HEADER_FIELDS_TOO_LARGE}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ ModalBottomSheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = modalBottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, continuation);
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
                                                    if (this.$sheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                }, 1, null);
                            }
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv2, 1, null);
            } else {
                sheetGesturesEnabled3 = sheetGesturesEnabled2;
                companionSemantics$default = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            SurfaceKt.m1809SurfaceFjzlyU(modifierAnchoredDraggable.then(companionSemantics$default), sheetShape4, sheetBackgroundColor3, sheetContentColor6, null, sheetElevation4, ComposableLambdaKt.rememberComposableLambda(17396558, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4
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
                    ComposerKt.sourceInformation($composer3, "C444@18775L30:ModalBottomSheet.kt#jmzs0o");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(17396558, $changed2, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:444)");
                    }
                    Function3<ColumnScope, Composer, Integer, Unit> function4 = function3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv2 = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(constructor3);
                    } else {
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
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
            }, $composer2, 54), $composer2, (($dirty >> 9) & 112) | 1572864 | (($dirty >> 12) & 896) | (($dirty >> 12) & 7168) | (458752 & $dirty), 16);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sheetGesturesEnabled4 = sheetGesturesEnabled3;
            sheetElevation3 = sheetElevation4;
            sheetContentColor5 = sheetContentColor6;
            sheetState3 = sheetState2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ModalBottomSheetState modalBottomSheetState = sheetState3;
            final boolean z = sheetGesturesEnabled4;
            final Shape shape = sheetShape4;
            final float f2 = sheetElevation3;
            final long j4 = sheetBackgroundColor3;
            final long j5 = sheetContentColor5;
            final long j6 = scrimColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
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

                public final void invoke(Composer composer, int i12) {
                    ModalBottomSheetKt.m1730ModalBottomSheetLayoutGs3lGvM(function3, modifier5, modalBottomSheetState, z, shape, f2, j4, j5, j6, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Modifier modalBottomSheetAnchors(Modifier $this$modalBottomSheetAnchors, final ModalBottomSheetState sheetState) {
        return AnchoredDraggableKt.draggableAnchors($this$modalBottomSheetAnchors, sheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue>>() { // from class: androidx.compose.material.ModalBottomSheetKt.modalBottomSheetAnchors.1

            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$WhenMappings */
            /* JADX INFO: compiled from: ModalBottomSheet.kt */
            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue> invoke(IntSize intSize, Constraints constraints) {
                return m1734invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
            public final Pair<DraggableAnchors<ModalBottomSheetValue>, ModalBottomSheetValue> m1734invokeGpV2Q24(final long sheetSize, long constraints) {
                ModalBottomSheetValue modalBottomSheetValue;
                final float fullHeight = Constraints.m6743getMaxHeightimpl(constraints);
                final ModalBottomSheetState modalBottomSheetState = sheetState;
                DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<ModalBottomSheetValue>, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.m15at(ModalBottomSheetValue.Hidden, fullHeight);
                        float halfHeight = fullHeight / 2.0f;
                        if (!modalBottomSheetState.getIsSkipHalfExpanded() && IntSize.m6974getHeightimpl(sheetSize) > halfHeight) {
                            draggableAnchorsConfig.m15at(ModalBottomSheetValue.HalfExpanded, halfHeight);
                        }
                        if (IntSize.m6974getHeightimpl(sheetSize) != 0) {
                            draggableAnchorsConfig.m15at(ModalBottomSheetValue.Expanded, Math.max(0.0f, fullHeight - IntSize.m6974getHeightimpl(sheetSize)));
                        }
                    }
                });
                boolean isInitialized = sheetState.getAnchoredDraggableState$material_release().getAnchors().getSize() > 0;
                ModalBottomSheetValue previousValue = sheetState.getCurrentValue();
                if (!isInitialized && newAnchors.hasAnchorFor(previousValue)) {
                    modalBottomSheetValue = previousValue;
                } else {
                    switch (WhenMappings.$EnumSwitchMapping$0[sheetState.getTargetValue().ordinal()]) {
                        case 1:
                            modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                            break;
                        case 2:
                        case 3:
                            boolean hasHalfExpandedState = newAnchors.hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
                            if (hasHalfExpandedState) {
                                modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                            } else if (newAnchors.hasAnchorFor(ModalBottomSheetValue.Expanded)) {
                                modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                            } else {
                                modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                            }
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                ModalBottomSheetValue newTarget = modalBottomSheetValue;
                return TuplesKt.m202to(newAnchors, newTarget);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1731Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)497@20564L121,501@20711L29,517@21226L62,513@21117L171:ModalBottomSheet.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, $dirty, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:495)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeSheet = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1802getCloseSheetUdPEhr4(), $composer2, 6);
                $composer2.startReplaceGroup(1010550915);
                ComposerKt.sourceInformation($composer2, "504@20848L37,505@20938L121");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1010550992, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean invalid$iv = ($dirty & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1010551082, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changed(closeSheet) | (($dirty & 112) == 32);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.setContentDescription($this$semantics, closeSheet);
                                final Function0<Unit> function1 = function0;
                                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function1.invoke();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissModifier = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, 1010551370, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(stateAnimateFloatAsState) | (($dirty & 14) == 4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$Canvas) {
                            DrawScope.CC.m4858drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, ModalBottomSheetKt.Scrim_3J_VO9M$lambda$6(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
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
                    ModalBottomSheetKt.m1731Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(m194d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m195d2 = {"androidx/compose/material/ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class C10501 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C10501(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
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
            C1052x8819a6ee c1052x8819a6ee;
            if (continuation instanceof C1052x8819a6ee) {
                c1052x8819a6ee = (C1052x8819a6ee) continuation;
                if ((c1052x8819a6ee.label & Integer.MIN_VALUE) != 0) {
                    c1052x8819a6ee.label -= Integer.MIN_VALUE;
                } else {
                    c1052x8819a6ee = new C1052x8819a6ee(this, continuation);
                }
            } else {
                c1052x8819a6ee = new C1052x8819a6ee(this, continuation);
            }
            C1052x8819a6ee c1052x8819a6ee2 = c1052x8819a6ee;
            Object $result = c1052x8819a6ee2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c1052x8819a6ee2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float toFling = velocityToFloat(available);
                    float currentOffset = this.$state.requireOffset();
                    if (toFling < 0.0f && currentOffset > this.$state.getAnchors().minAnchor()) {
                        AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                        c1052x8819a6ee2.J$0 = available;
                        c1052x8819a6ee2.label = 1;
                        if (anchoredDraggableState.settle(toFling, c1052x8819a6ee2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        available = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                    }
                    break;
                case 1:
                    available = c1052x8819a6ee2.J$0;
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
            C1051x8f227701 c1051x8f227701;
            if (continuation instanceof C1051x8f227701) {
                c1051x8f227701 = (C1051x8f227701) continuation;
                if ((c1051x8f227701.label & Integer.MIN_VALUE) != 0) {
                    c1051x8f227701.label -= Integer.MIN_VALUE;
                } else {
                    c1051x8f227701 = new C1051x8f227701(this, continuation);
                }
            } else {
                c1051x8f227701 = new C1051x8f227701(this, continuation);
            }
            Object $result = c1051x8f227701.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c1051x8f227701.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    float fVelocityToFloat = velocityToFloat(available);
                    c1051x8f227701.J$0 = available;
                    c1051x8f227701.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, c1051x8f227701) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    available = c1051x8f227701.J$0;
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

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C10501(anchoredDraggableState, orientation);
    }
}

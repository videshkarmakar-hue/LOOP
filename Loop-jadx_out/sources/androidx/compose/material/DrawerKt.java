package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
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
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
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
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a0\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020(2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002\u001a\u0093\u0001\u0010+\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020,2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a>\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a \u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0002\u001a;\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00150\f2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020>H\u0007¢\u0006\u0002\u0010?\u001a+\u0010@\u001a\u00020,2\u0006\u0010:\u001a\u00020A2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010B\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C²\u0006\n\u0010D\u001a\u00020\u0002X\u008a\u0084\u0002"}, m195d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = C1979Dp.m6801constructorimpl(56);
    private static final float DrawerPositionalThreshold = C1979Dp.m6801constructorimpl(56);
    private static final float DrawerVelocityThreshold = C1979Dp.m6801constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1435874229, "C(rememberDrawerState)P(1)429@15122L61,429@15058L125:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:428)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart($composer, -1540944667, "CC(remember):Drawer.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(function1)) || ($changed & 48) == 32) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(initialValue, function1);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue initialValue, final Function1<? super BottomDrawerValue, Boolean> function1, final AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1477366969, "C(rememberBottomDrawerState)P(2,1)448@15797L7,452@15941L91,449@15816L216:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberBottomDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if ((i & 4) != 0) {
            AnimationSpec animationSpec2 = DrawerDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1477366969, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:447)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        boolean z = true;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, function1, animationSpec);
        ComposerKt.sourceInformationMarkerStart($composer, -1588063325, "CC(remember):Drawer.kt#9igjgp");
        boolean zChanged = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density);
        if (((($changed & 112) ^ 48) <= 32 || !$composer.changed(function1)) && ($changed & 48) != 32) {
            z = false;
        }
        boolean invalid$iv = z | zChanged | $composer.changedInstance(animationSpec);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return new BottomDrawerState(initialValue, density, function1, animationSpec);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomDrawerState;
    }

    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1679ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        DrawerState drawerState2;
        boolean z;
        Shape shape;
        float f;
        int $dirty;
        DrawerState drawerState3;
        boolean gesturesEnabled2;
        Shape drawerShape2;
        float drawerElevation2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long scrimColor2;
        int $dirty2;
        Modifier modifier2;
        Object value$iv$iv;
        Modifier modifier3;
        DrawerState drawerState4;
        boolean gesturesEnabled3;
        long scrimColor3;
        Shape drawerShape3;
        float drawerElevation3;
        long drawerBackgroundColor3;
        long drawerContentColor3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(1305806945);
        ComposerKt.sourceInformation($composer2, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)491@17842L39,493@17960L5,495@18069L15,496@18118L38,497@18197L10,500@18265L24,501@18337L3449,501@18294L3492:Drawer.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                int i3 = $composer2.changed(drawerState2) ? 256 : 128;
                $dirty4 |= i3;
            } else {
                drawerState2 = drawerState;
            }
            $dirty4 |= i3;
        } else {
            drawerState2 = drawerState;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 3072) == 0) {
            z = gesturesEnabled;
            $dirty4 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                int i5 = $composer2.changed(shape) ? 16384 : 8192;
                $dirty4 |= i5;
            } else {
                shape = drawerShape;
            }
            $dirty4 |= i5;
        } else {
            shape = drawerShape;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = drawerElevation;
        } else if ((196608 & $changed) == 0) {
            f = drawerElevation;
            $dirty4 |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = drawerElevation;
        }
        if ((1572864 & $changed) == 0) {
            $dirty4 |= ((i & 64) == 0 && $composer2.changed(drawerBackgroundColor)) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i7 = $composer2.changed(drawerContentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i7;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i7;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(scrimColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int $dirty5 = $dirty;
        if ((306783379 & $dirty5) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            drawerBackgroundColor3 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
            scrimColor3 = scrimColor;
            drawerState4 = drawerState2;
            gesturesEnabled3 = z;
            drawerShape3 = shape;
            drawerElevation3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    drawerState3 = rememberDrawerState(DrawerValue.Closed, null, $composer2, 6, 2);
                    $dirty5 &= -897;
                } else {
                    drawerState3 = drawerState2;
                }
                gesturesEnabled2 = i4 != 0 ? true : z;
                if ((i & 16) != 0) {
                    drawerShape2 = DrawerDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty5 &= -57345;
                } else {
                    drawerShape2 = shape;
                }
                drawerElevation2 = i6 != 0 ? DrawerDefaults.INSTANCE.m1676getElevationD9Ej5fM() : f;
                if ((i & 64) != 0) {
                    drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty5 &= -3670017;
                } else {
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 128) != 0) {
                    drawerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty5 >> 18) & 14);
                    $dirty5 &= -29360129;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 256) != 0) {
                    scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty2 = $dirty5 & (-234881025);
                    modifier2 = modifier4;
                } else {
                    scrimColor2 = scrimColor;
                    $dirty2 = $dirty5;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty5 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty5 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty5 &= -234881025;
                }
                scrimColor2 = scrimColor;
                $dirty2 = $dirty5;
                drawerState3 = drawerState2;
                gesturesEnabled2 = z;
                drawerShape2 = shape;
                drawerElevation2 = f;
                modifier2 = modifier;
                drawerBackgroundColor2 = drawerBackgroundColor;
                drawerContentColor2 = drawerContentColor;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305806945, $dirty2, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:499)");
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
            final DrawerState drawerState5 = drawerState3;
            final boolean z2 = gesturesEnabled2;
            final long j = scrimColor2;
            final Shape shape2 = drawerShape2;
            final long j2 = drawerBackgroundColor2;
            final long j3 = drawerContentColor2;
            final float f2 = drawerElevation2;
            modifier3 = modifier2;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer3, int $changed2) {
                    Object value$iv;
                    Function0<ComposeUiNode> function0;
                    Object value$iv2;
                    Object value$iv3;
                    Object value$iv4;
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer3, "C510@18716L7,511@18743L274,511@18732L285,520@19060L7,521@19099L2681:Drawer.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty6 |= $composer3.changed($this$BoxWithConstraints) ? 4 : 2;
                    }
                    if (($dirty6 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(816674999, $dirty6, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:502)");
                        }
                        long modalDrawerConstraints = $this$BoxWithConstraints.mo774getConstraintsmsEJaDk();
                        if (!Constraints.m6740getHasBoundedWidthimpl(modalDrawerConstraints)) {
                            throw new IllegalStateException("Drawer shouldn't have infinite width");
                        }
                        final float minValue = -Constraints.m6744getMaxWidthimpl(modalDrawerConstraints);
                        final float maxValue = 0.0f;
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        final Density density = (Density) objConsume;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1477470208, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(drawerState5) | $composer3.changed(density) | $composer3.changed(minValue);
                        final DrawerState drawerState6 = drawerState5;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    drawerState6.setDensity$material_release(density);
                                    final float f3 = minValue;
                                    final float f4 = maxValue;
                                    DraggableAnchors anchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.m15at(DrawerValue.Closed, f3);
                                            draggableAnchorsConfig.m15at(DrawerValue.Open, f4);
                                        }
                                    });
                                    AnchoredDraggableState.updateAnchors$default(drawerState6.getAnchoredDraggableState$material_release(), anchors, null, 2, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        boolean isRtl = objConsume2 == LayoutDirection.Rtl;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        AnchoredDraggableState<DrawerValue> anchoredDraggableState$material_release = drawerState5.getAnchoredDraggableState$material_release();
                        Modifier modifier$iv = AnchoredDraggableKt.anchoredDraggable(companion, anchoredDraggableState$material_release, Orientation.Horizontal, (56 & 4) != 0 ? true : z2, (56 & 8) != 0 ? false : isRtl, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release.isAnimationRunning() : false);
                        final DrawerState drawerState7 = drawerState5;
                        final boolean z3 = z2;
                        final CoroutineScope coroutineScope = scope;
                        long j4 = j;
                        Shape shape3 = shape2;
                        long j5 = j2;
                        long j6 = j3;
                        float f3 = f2;
                        Function2<Composer, Integer, Unit> function4 = function2;
                        final Function3<ColumnScope, Composer, Integer, Unit> function5 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i9 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 413828931, "C530@19417L45,535@19551L292,543@19872L106,533@19475L553,548@20062L33,*550@20162L7,559@20626L222,567@20933L555,584@21683L87,549@20108L1662:Drawer.kt#jmzs0o");
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor2;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i11 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 392280698, "C531@19439L9:Drawer.kt#jmzs0o");
                        function4.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        boolean propagateMinConstraints$iv = drawerState7.isOpen();
                        ComposerKt.sourceInformationMarkerStart($composer3, 413829065, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(z3) | $composer3.changed(drawerState7) | $composer3.changedInstance(coroutineScope);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (z3 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C10091(drawerState7, null), 3, null);
                                    }
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1 */
                                /* JADX INFO: compiled from: Drawer.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", m210f = "Drawer.kt", m211i = {}, m212l = {541}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class C10091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C10091(DrawerState drawerState, Continuation<? super C10091> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C10091(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C10091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        Function0 function1 = (Function0) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 413829386, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv3 = $composer3.changed(minValue) | $composer3.changed(drawerState7);
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(DrawerKt.calculateFraction(minValue, maxValue, drawerState7.requireOffset$material_release()));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        DrawerKt.m1680ScrimBx497Mc(propagateMinConstraints$iv, function1, (Function0) value$iv3, j4, $composer3, 0);
                        final String navigationMenu = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1805getNavigationMenuUdPEhr4(), $composer3, 6);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = $composer3.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density $this$invoke_u24lambda_u247_u24lambda_u244 = (Density) objConsume3;
                        Modifier modifierM916sizeInqDBjuR0 = SizeKt.m916sizeInqDBjuR0(Modifier.INSTANCE, $this$invoke_u24lambda_u247_u24lambda_u244.mo564toDpu2uoSUM(Constraints.m6746getMinWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo564toDpu2uoSUM(Constraints.m6745getMinHeightimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo564toDpu2uoSUM(Constraints.m6744getMaxWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u247_u24lambda_u244.mo564toDpu2uoSUM(Constraints.m6743getMaxHeightimpl(modalDrawerConstraints)));
                        ComposerKt.sourceInformationMarkerStart($composer3, 413830140, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv4 = $composer3.changed(drawerState7);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                    return IntOffset.m6924boximpl(m1686invokeBjo55l4(density2));
                                }

                                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1686invokeBjo55l4(Density $this$offset) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(drawerState7.requireOffset$material_release()), 0);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(OffsetKt.offset(modifierM916sizeInqDBjuR0, (Function1) value$iv4), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 413830447, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv5 = $composer3.changed(navigationMenu) | $composer3.changed(drawerState7) | $composer3.changedInstance(coroutineScope);
                        Object it$iv5 = $composer3.rememberedValue();
                        if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
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
                                    SemanticsPropertiesKt.setPaneTitle($this$semantics, navigationMenu);
                                    if (drawerState7.isOpen()) {
                                        final DrawerState drawerState8 = drawerState7;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        SemanticsPropertiesKt.dismiss$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (drawerState8.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState8, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: Drawer.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", m210f = "Drawer.kt", m211i = {}, m212l = {576}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            $composer3.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SurfaceKt.m1809SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierM872paddingqDBjuR0$default, false, (Function1) value$iv5, 1, null), shape3, j5, j6, null, f3, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                ComposerKt.sourceInformation($composer4, "C585@21701L55:Drawer.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941234439, $changed3, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:585)");
                                }
                                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function3<ColumnScope, Composer, Integer, Unit> function6 = function5;
                                ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv3 = (6 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    $composer4.createNode(constructor3);
                                } else {
                                    $composer4.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer4);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                function6.invoke(ColumnScopeInstance.INSTANCE, $composer4, Integer.valueOf(((6 >> 6) & 112) | 6));
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 1572864, 16);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerState4 = drawerState3;
            gesturesEnabled3 = gesturesEnabled2;
            scrimColor3 = scrimColor2;
            drawerShape3 = drawerShape2;
            drawerElevation3 = drawerElevation2;
            drawerBackgroundColor3 = drawerBackgroundColor2;
            drawerContentColor3 = drawerContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final DrawerState drawerState6 = drawerState4;
            final boolean z3 = gesturesEnabled3;
            final Shape shape3 = drawerShape3;
            final float f3 = drawerElevation3;
            final long j4 = drawerBackgroundColor3;
            final long j5 = drawerContentColor3;
            final long j6 = scrimColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
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

                public final void invoke(Composer composer, int i8) {
                    DrawerKt.m1679ModalDrawerGs3lGvM(function3, modifier5, drawerState6, z3, shape3, f3, j4, j5, j6, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1677BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomDrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        boolean z;
        Shape shape;
        long j;
        long j2;
        Modifier.Companion modifier2;
        int $dirty;
        BottomDrawerState drawerState2;
        boolean gesturesEnabled2;
        Shape drawerShape2;
        float drawerElevation2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long scrimColor2;
        Object value$iv$iv;
        Modifier modifier3;
        BottomDrawerState drawerState3;
        boolean gesturesEnabled3;
        Shape drawerShape3;
        float drawerElevation3;
        long drawerBackgroundColor3;
        long drawerContentColor3;
        Composer $composer2 = $composer.startRestartGroup(625649286);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)624@23676L33,626@23788L5,628@23897L15,629@23946L38,630@24025L10,633@24093L24,634@24165L4601,634@24122L4644:Drawer.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer2.changedInstance(drawerState)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 3072) == 0) {
            z = gesturesEnabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                int i4 = $composer2.changed(shape) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                shape = drawerShape;
            }
            $dirty2 |= i4;
        } else {
            shape = drawerShape;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changed(drawerElevation) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = drawerBackgroundColor;
                int i6 = $composer2.changed(j) ? 1048576 : 524288;
                $dirty2 |= i6;
            } else {
                j = drawerBackgroundColor;
            }
            $dirty2 |= i6;
        } else {
            j = drawerBackgroundColor;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(drawerContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            if ((i & 256) == 0) {
                j2 = scrimColor;
                int i7 = $composer2.changed(j2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty2 |= i7;
            } else {
                j2 = scrimColor;
            }
            $dirty2 |= i7;
        } else {
            j2 = scrimColor;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            drawerState3 = drawerState;
            drawerElevation3 = drawerElevation;
            drawerContentColor3 = drawerContentColor;
            drawerBackgroundColor3 = j;
            scrimColor2 = j2;
            gesturesEnabled3 = z;
            drawerShape3 = shape;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    int $dirty3 = $dirty2;
                    drawerState2 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, null, $composer2, 6, 6);
                    $dirty = $dirty3 & (-897);
                } else {
                    $dirty = $dirty2;
                    drawerState2 = drawerState;
                }
                gesturesEnabled2 = i3 != 0 ? true : z;
                if ((i & 16) != 0) {
                    drawerShape2 = DrawerDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty &= -57345;
                } else {
                    drawerShape2 = shape;
                }
                drawerElevation2 = i5 != 0 ? DrawerDefaults.INSTANCE.m1676getElevationD9Ej5fM() : drawerElevation;
                if ((i & 64) != 0) {
                    drawerBackgroundColor2 = DrawerDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 128) != 0) {
                    drawerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                    scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                } else {
                    scrimColor2 = scrimColor;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i8 = $dirty2 & (-234881025);
                    drawerState2 = drawerState;
                    $dirty = i8;
                    scrimColor2 = j2;
                    gesturesEnabled2 = z;
                    modifier2 = modifier;
                    drawerElevation2 = drawerElevation;
                    drawerBackgroundColor2 = j;
                    drawerShape2 = shape;
                    drawerContentColor2 = drawerContentColor;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    scrimColor2 = j2;
                    gesturesEnabled2 = z;
                    drawerState2 = drawerState;
                    drawerElevation2 = drawerElevation;
                    drawerBackgroundColor2 = j;
                    drawerShape2 = shape;
                    drawerContentColor2 = drawerContentColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625649286, $dirty, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:632)");
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
            final boolean z2 = gesturesEnabled2;
            final BottomDrawerState bottomDrawerState = drawerState2;
            final long j3 = scrimColor2;
            final Shape shape2 = drawerShape2;
            final long j4 = drawerBackgroundColor2;
            final long j5 = drawerContentColor2;
            final float f = drawerElevation2;
            modifier3 = modifier2;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                    invoke(boxWithConstraintsScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer3, int $changed2) {
                    Modifier.Companion nestedScroll;
                    Function0<ComposeUiNode> function0;
                    Object value$iv;
                    Object value$iv2;
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C*637@24345L7,649@24760L7,660@25108L3652:Drawer.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty4 |= $composer3.changed($this$BoxWithConstraints) ? 4 : 2;
                    }
                    if (($dirty4 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1220102512, $dirty4, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:635)");
                        }
                        final float fullHeight = Constraints.m6743getMaxHeightimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk());
                        final boolean isLandscape = Constraints.m6744getMaxWidthimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk()) > Constraints.m6743getMaxHeightimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk());
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density $this$invoke_u24lambda_u240 = (Density) objConsume;
                        Modifier drawerConstraints = SizeKt.m917sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, $this$invoke_u24lambda_u240.mo564toDpu2uoSUM(Constraints.m6744getMaxWidthimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk())), $this$invoke_u24lambda_u240.mo564toDpu2uoSUM(Constraints.m6743getMaxHeightimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk())), 3, null);
                        if (z2) {
                            nestedScroll = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState.getNestedScrollConnection$material_release(), null, 2, null);
                        } else {
                            nestedScroll = Modifier.INSTANCE;
                        }
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        boolean isRtl = objConsume2 == LayoutDirection.Rtl;
                        Modifier modifierThen = Modifier.INSTANCE.then(nestedScroll);
                        AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState$material_release = bottomDrawerState.getAnchoredDraggableState$material_release();
                        Modifier swipeable = AnchoredDraggableKt.anchoredDraggable(modifierThen, anchoredDraggableState$material_release, Orientation.Vertical, (56 & 4) != 0 ? true : z2, (56 & 8) != 0 ? false : isRtl, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState$material_release.isAnimationRunning() : false);
                        Function2<Composer, Integer, Unit> function4 = function2;
                        long j6 = j3;
                        final boolean z3 = z2;
                        final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                        final CoroutineScope coroutineScope = scope;
                        Shape shape3 = shape2;
                        long j7 = j4;
                        long j8 = j5;
                        float f2 = f;
                        final Function3<ColumnScope, Composer, Integer, Unit> function5 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, swipeable);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i10 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1720994129, "C661@25137L9,664@25242L233,662@25159L391,673@25584L33,676@25708L1951,711@27688L258,719@27978L514,734@28687L63,674@25630L3120:Drawer.kt#jmzs0o");
                        function4.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1720994234, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(z3) | $composer3.changedInstance(bottomDrawerState2) | $composer3.changedInstance(coroutineScope);
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (z3 && bottomDrawerState2.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C10021(bottomDrawerState2, null), 3, null);
                                    }
                                }

                                /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1$1 */
                                /* JADX INFO: compiled from: Drawer.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1$1", m210f = "Drawer.kt", m211i = {}, m212l = {669}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class C10021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomDrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C10021(BottomDrawerState bottomDrawerState, Continuation<? super C10021> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = bottomDrawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C10021(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C10021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        Function0 function1 = (Function0) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        DrawerKt.m1678BottomDrawerScrim3JVO9M(j6, function1, bottomDrawerState2.getTargetValue() != BottomDrawerValue.Closed, $composer3, 0);
                        final String navigationMenu = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1805getNavigationMenuUdPEhr4(), $composer3, 6);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1720994700, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(fullHeight) | $composer3.changed(isLandscape) | $composer3.changedInstance(bottomDrawerState2);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1

                                /* JADX INFO: compiled from: Drawer.kt */
                                @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                public /* synthetic */ class WhenMappings {
                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] iArr = new int[BottomDrawerValue.values().length];
                                        try {
                                            iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                        } catch (NoSuchFieldError e) {
                                        }
                                        try {
                                            iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                        } catch (NoSuchFieldError e2) {
                                        }
                                        try {
                                            iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
                                        } catch (NoSuchFieldError e3) {
                                        }
                                        $EnumSwitchMapping$0 = iArr;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m1683invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m1683invokeozmzZPI(long drawerSize) {
                                    BottomDrawerValue newTarget;
                                    BottomDrawerValue newTarget2;
                                    final float drawerHeight = IntSize.m6974getHeightimpl(drawerSize);
                                    final float f3 = fullHeight;
                                    final boolean z4 = isLandscape;
                                    DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1$newAnchors$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.m15at(BottomDrawerValue.Closed, f3);
                                            float peekHeight = f3 * 0.5f;
                                            if (drawerHeight > peekHeight || z4) {
                                                draggableAnchorsConfig.m15at(BottomDrawerValue.Open, peekHeight);
                                            }
                                            if (drawerHeight > 0.0f) {
                                                draggableAnchorsConfig.m15at(BottomDrawerValue.Expanded, Math.max(0.0f, f3 - drawerHeight));
                                            }
                                        }
                                    });
                                    boolean hasAnchors = bottomDrawerState2.getAnchoredDraggableState$material_release().getAnchors().getSize() > 0;
                                    if (!hasAnchors && DraggableAnchors.hasAnchorFor(bottomDrawerState2.getCurrentValue())) {
                                        newTarget = bottomDrawerState2.getCurrentValue();
                                    } else {
                                        switch (WhenMappings.$EnumSwitchMapping$0[bottomDrawerState2.getTargetValue().ordinal()]) {
                                            case 1:
                                                newTarget = BottomDrawerValue.Closed;
                                                break;
                                            case 2:
                                            case 3:
                                                boolean hasHalfExpandedState = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open);
                                                if (hasHalfExpandedState) {
                                                    newTarget2 = BottomDrawerValue.Open;
                                                } else {
                                                    newTarget2 = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                                }
                                                newTarget = newTarget2;
                                                break;
                                            default:
                                                throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    bottomDrawerState2.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, newTarget);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(drawerConstraints, (Function1) value$iv2);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1720996680, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv3 = $composer3.changedInstance(bottomDrawerState2);
                        Object value$iv4 = $composer3.rememberedValue();
                        if (invalid$iv3 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                    return IntOffset.m6924boximpl(m1684invokeBjo55l4(density));
                                }

                                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1684invokeBjo55l4(Density $this$offset) {
                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(bottomDrawerState2.requireOffset$material_release()));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierOffset = OffsetKt.offset(modifierOnSizeChanged, (Function1) value$iv4);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1720996970, "CC(remember):Drawer.kt#9igjgp");
                        boolean invalid$iv4 = $composer3.changed(navigationMenu) | $composer3.changedInstance(bottomDrawerState2) | $composer3.changedInstance(coroutineScope);
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1
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
                                    SemanticsPropertiesKt.setPaneTitle($this$semantics, navigationMenu);
                                    if (bottomDrawerState2.isOpen()) {
                                        final BottomDrawerState bottomDrawerState3 = bottomDrawerState2;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        SemanticsPropertiesKt.dismiss$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: Drawer.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1$1", m210f = "Drawer.kt", m211i = {}, m212l = {726}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ BottomDrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = bottomDrawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                                if (bottomDrawerState3.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomDrawerState3, null), 3, null);
                                                }
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SurfaceKt.m1809SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierOffset, false, (Function1) value$iv3, 1, null), shape3, j7, j8, null, f2, ComposableLambdaKt.rememberComposableLambda(457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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
                                ComposerKt.sourceInformation($composer4, "C735@28705L31:Drawer.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:735)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function6 = function5;
                                ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Modifier modifier$iv = Modifier.INSTANCE;
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv2 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    $composer4.createNode(constructor2);
                                } else {
                                    $composer4.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                function6.invoke(ColumnScopeInstance.INSTANCE, $composer4, Integer.valueOf(((0 >> 6) & 112) | 6));
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 1572864, 16);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerState3 = drawerState2;
            gesturesEnabled3 = gesturesEnabled2;
            drawerShape3 = drawerShape2;
            drawerElevation3 = drawerElevation2;
            drawerBackgroundColor3 = drawerBackgroundColor2;
            drawerContentColor3 = drawerContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final BottomDrawerState bottomDrawerState2 = drawerState3;
            final boolean z3 = gesturesEnabled3;
            final Shape shape3 = drawerShape3;
            final float f2 = drawerElevation3;
            final long j6 = drawerBackgroundColor3;
            final long j7 = drawerContentColor3;
            final long j8 = scrimColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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

                public final void invoke(Composer composer, int i9) {
                    DrawerKt.m1677BottomDrawerGs3lGvM(function3, modifier4, bottomDrawerState2, z3, shape3, f2, j6, j7, j8, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        float $this$fastCoerceIn$iv = (pos - a) / (b - a);
        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
            $this$fastCoerceAtLeast$iv$iv = 0.0f;
        }
        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
            return 1.0f;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1678BottomDrawerScrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)794@30102L121,798@30250L30,816@30803L62,812@30694L171:Drawer.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-513067266, $dirty, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:792)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeDrawer = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1801getCloseDrawerUdPEhr4(), $composer2, 6);
                $composer2.startReplaceGroup(-1298942237);
                ComposerKt.sourceInformation($composer2, "801@30388L73,804@30514L122");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1298942160, "CC(remember):Drawer.kt#9igjgp");
                    boolean invalid$iv = ($dirty & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1298942034, "CC(remember):Drawer.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changed(closeDrawer) | (($dirty & 112) == 32);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.setContentDescription($this$semantics, closeDrawer);
                                final Function0<Unit> function1 = function0;
                                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
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
                ComposerKt.sourceInformationMarkerStart($composer2, -1298941745, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(stateAnimateFloatAsState) | (($dirty & 14) == 4);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
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
                            DrawScope.CC.m4858drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$2(stateAnimateFloatAsState), null, null, 0, 118, null);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
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
                    DrawerKt.m1678BottomDrawerScrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1680ScrimBx497Mc(final boolean open, final Function0<Unit> function0, final Function0<Float> function1, final long color, Composer $composer, final int $changed) {
        Modifier.Companion dismissDrawer;
        Object value$iv;
        DrawerKt$Scrim$dismissDrawer$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)829@31020L30,845@31464L51,841@31373L142:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(open) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(color) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, $dirty2, -1, "androidx.compose.material.Scrim (Drawer.kt:828)");
            }
            final String closeDrawer = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1801getCloseDrawerUdPEhr4(), $composer2, 6);
            $composer2.startReplaceGroup(1010561219);
            ComposerKt.sourceInformation($composer2, "832@31139L35,833@31223L108");
            if (open) {
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1010561283, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1010561367, "CC(remember):Drawer.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(closeDrawer) | (($dirty2 & 112) == 32);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
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
                            SemanticsPropertiesKt.setContentDescription($this$semantics, closeDrawer);
                            final Function0<Unit> function2 = function0;
                            SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function2.invoke();
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
                dismissDrawer = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
            } else {
                dismissDrawer = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissDrawer);
            ComposerKt.sourceInformationMarkerStart($composer2, 1010561608, "CC(remember):Drawer.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & 7168) == 2048) | (($dirty2 & 896) == 256);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
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
                        DrawScope.CC.m4858drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, function1.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
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
                    DrawerKt.m1680ScrimBx497Mc(open, function0, function1, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 */
    /* JADX INFO: compiled from: Drawer.kt */
    @Metadata(m194d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\rH\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\r*\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m195d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class C10061 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation = Orientation.Vertical;

        C10061(AnchoredDraggableState<?> anchoredDraggableState) {
            this.$state = anchoredDraggableState;
        }

        public final Orientation getOrientation() {
            return this.orientation;
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
            C1008x425444c4 c1008x425444c4;
            if (continuation instanceof C1008x425444c4) {
                c1008x425444c4 = (C1008x425444c4) continuation;
                if ((c1008x425444c4.label & Integer.MIN_VALUE) != 0) {
                    c1008x425444c4.label -= Integer.MIN_VALUE;
                } else {
                    c1008x425444c4 = new C1008x425444c4(this, continuation);
                }
            } else {
                c1008x425444c4 = new C1008x425444c4(this, continuation);
            }
            C1008x425444c4 c1008x425444c5 = c1008x425444c4;
            Object $result = c1008x425444c5.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c1008x425444c5.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float toFling = velocityToFloat(available);
                    float currentOffset = this.$state.requireOffset();
                    if (toFling < 0.0f && currentOffset > this.$state.getAnchors().minAnchor()) {
                        AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                        c1008x425444c5.J$0 = available;
                        c1008x425444c5.label = 1;
                        if (anchoredDraggableState.settle(toFling, c1008x425444c5) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        available = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                    }
                    break;
                case 1:
                    available = c1008x425444c5.J$0;
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
            C1007x1c3b93eb c1007x1c3b93eb;
            if (continuation instanceof C1007x1c3b93eb) {
                c1007x1c3b93eb = (C1007x1c3b93eb) continuation;
                if ((c1007x1c3b93eb.label & Integer.MIN_VALUE) != 0) {
                    c1007x1c3b93eb.label -= Integer.MIN_VALUE;
                } else {
                    c1007x1c3b93eb = new C1007x1c3b93eb(this, continuation);
                }
            } else {
                c1007x1c3b93eb = new C1007x1c3b93eb(this, continuation);
            }
            Object $result = c1007x1c3b93eb.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c1007x1c3b93eb.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    float fVelocityToFloat = velocityToFloat(available);
                    c1007x1c3b93eb.J$0 = available;
                    c1007x1c3b93eb.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, c1007x1c3b93eb) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    available = c1007x1c3b93eb.J$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Velocity.m7033boximpl(available);
        }

        private final long toOffset(float $this$toOffset) {
            return androidx.compose.p001ui.geometry.OffsetKt.Offset(this.orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.orientation == Orientation.Horizontal ? Velocity.m7042getXimpl($this$toFloat) : Velocity.m7043getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.orientation == Orientation.Horizontal ? Offset.m4049getXimpl($this$toFloat) : Offset.m4050getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new C10061(anchoredDraggableState);
    }
}

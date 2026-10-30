package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.SubcomposeLayoutKt;
import androidx.compose.p001ui.layout.SubcomposeMeasureScope;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u0010\r\u001aò\u0001\u0010\u000e\u001a\u00020\u00062\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aH\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u00162\b\b\u0002\u00101\u001a\u00020\u0017H\u0007\u001a[\u00102\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u000b2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002050\u00162\u001d\u00106\u001a\u0019\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000607¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u00108\u001a\u001c\u00109\u001a\u00020:2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0000\u001a0\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u001f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010B\u001a\u00020\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aE\u0010E\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\b2\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u00162\b\b\u0002\u00101\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010G\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020/X\u008a\u0084\u0002"}, m195d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "PositionalThreshold", "VelocityThreshold", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "BackdropScaffold-0hNv9B8", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;Lkotlin/jvm/functions/Function3;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLandroidx/compose/runtime/Composer;III)V", "BackdropScaffoldState", "initialValue", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "snackbarHostState", "BackdropStack", "backLayer", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "confirmStateChange", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = C1979Dp.m6801constructorimpl(20);
    private static final float VelocityThreshold = C1979Dp.m6801constructorimpl(125);
    private static final float PositionalThreshold = C1979Dp.m6801constructorimpl(56);

    public static /* synthetic */ BackdropScaffoldState BackdropScaffoldState$default(BackdropValue backdropValue, Density density, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue it) {
                    return true;
                }
            };
        }
        if ((i & 16) != 0) {
            snackbarHostState = new SnackbarHostState();
        }
        return BackdropScaffoldState(backdropValue, density, animationSpec, function1, snackbarHostState);
    }

    public static final BackdropScaffoldState BackdropScaffoldState(BackdropValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        BackdropScaffoldState it = new BackdropScaffoldState(initialValue, animationSpec, function1, snackbarHostState);
        it.setDensity$material_release(density);
        return it;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b8  */
    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        SnackbarHostState snackbarHostState2;
        boolean z;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -862178912, "C(rememberBackdropScaffoldState)P(2)279@10496L32,281@10588L7,292@10941L266,282@10607L600:BackdropScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = (i & 2) != 0 ? BackdropScaffoldDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        Function1<? super BackdropValue, Boolean> function2 = (i & 4) != 0 ? new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BackdropValue it) {
                return true;
            }
        } : function1;
        if ((i & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, 380718158, "CC(remember):BackdropScaffold.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnackbarHostState snackbarHostState3 = (SnackbarHostState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            snackbarHostState2 = snackbarHostState3;
        } else {
            snackbarHostState2 = snackbarHostState;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:280)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {animationSpec2, function2, snackbarHostState2};
        Saver<BackdropScaffoldState, ?> Saver = BackdropScaffoldState.INSTANCE.Saver(animationSpec2, function2, snackbarHostState2, density);
        ComposerKt.sourceInformationMarkerStart($composer, 380718603, "CC(remember):BackdropScaffold.kt#9igjgp");
        if ((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) {
            z = true;
        } else if (($changed & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        boolean invalid$iv = (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(snackbarHostState2)) || ($changed & 3072) == 2048) | z | $composer.changed(density) | $composer.changedInstance(animationSpec2) | (((($changed & 896) ^ 384) > 256 && $composer.changed(function2)) || ($changed & 384) == 256);
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
            final AnimationSpec<Float> animationSpec3 = animationSpec2;
            final Function1<? super BackdropValue, Boolean> function3 = function2;
            final SnackbarHostState snackbarHostState4 = snackbarHostState2;
            value$iv2 = new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BackdropScaffoldState invoke() {
                    return BackdropScaffoldKt.BackdropScaffoldState(initialValue, density, animationSpec3, function3, snackbarHostState4);
                }
            };
            $composer.updateRememberedValue(value$iv2);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv2, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return backdropScaffoldState;
    }

    /* JADX INFO: renamed from: BackdropScaffold-0hNv9B8, reason: not valid java name */
    public static final void m1564BackdropScaffold0hNv9B8(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, Modifier modifier, BackdropScaffoldState scaffoldState, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function5, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        final BackdropScaffoldState scaffoldState2;
        float peekHeight2;
        float headerHeight2;
        long j;
        BackdropScaffoldState scaffoldState3;
        boolean gesturesEnabled2;
        float peekHeight3;
        float headerHeight3;
        boolean stickyFrontLayer2;
        int $dirty1;
        long backLayerBackgroundColor2;
        long backLayerContentColor2;
        Shape frontLayerShape2;
        float frontLayerElevation2;
        long frontLayerBackgroundColor2;
        long frontLayerContentColor2;
        int $dirty;
        float frontLayerElevation3;
        long frontLayerScrimColor2;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function6;
        final boolean persistentAppBar2;
        int $dirty2;
        Modifier modifier2;
        long backLayerContentColor3;
        long frontLayerBackgroundColor3;
        long backLayerBackgroundColor3;
        long frontLayerContentColor3;
        Shape frontLayerShape3;
        boolean persistentAppBar3;
        Object value$iv;
        Modifier modifier3;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function7;
        boolean gesturesEnabled3;
        BackdropScaffoldState scaffoldState4;
        float peekHeight4;
        float headerHeight4;
        boolean stickyFrontLayer3;
        Shape frontLayerShape4;
        Composer $composer2 = $composer.startRestartGroup(113877443);
        ComposerKt.sourceInformation($composer2, "C(BackdropScaffold)P(!1,2,5,12,15,16,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)371@15931L40,378@16340L6,379@16391L41,380@16488L15,382@16634L6,383@16686L42,384@16789L20,387@16929L7,388@16952L47,388@16941L58,*392@17042L7,393@17116L7,395@17182L315,408@17568L100,418@17848L3899,415@17746L4001:BackdropScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 256 : 128;
        }
        int i2 = i & 8;
        int i3 = 1024;
        if (i2 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 2048 : 1024;
        }
        int i4 = 8192;
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                scaffoldState2 = scaffoldState;
                int i5 = $composer2.changed(scaffoldState2) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty3 |= i5;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(gesturesEnabled) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                peekHeight2 = peekHeight;
                int i8 = $composer2.changed(peekHeight2) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                peekHeight2 = peekHeight;
            }
            $dirty3 |= i8;
        } else {
            peekHeight2 = peekHeight;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0) {
                headerHeight2 = headerHeight;
                int i9 = $composer2.changed(headerHeight2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty3 |= i9;
            } else {
                headerHeight2 = headerHeight;
            }
            $dirty3 |= i9;
        } else {
            headerHeight2 = headerHeight;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer2.changed(persistentAppBar) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty4 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty4 |= $composer2.changed(stickyFrontLayer) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty4 |= ((i & 2048) == 0 && $composer2.changed(backLayerBackgroundColor)) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty4 |= ((i & 4096) == 0 && $composer2.changed(backLayerContentColor)) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0 && $composer2.changed(frontLayerShape)) {
                i3 = 2048;
            }
            $dirty4 |= i3;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(frontLayerElevation)) {
                i4 = 16384;
            }
            $dirty4 |= i4;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= ((i & 32768) == 0 && $composer2.changed(frontLayerBackgroundColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty4 |= ((i & 65536) == 0 && $composer2.changed(frontLayerContentColor)) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            if ((i & 131072) == 0) {
                j = frontLayerScrimColor;
                int i12 = $composer2.changed(j) ? 8388608 : 4194304;
                $dirty4 |= i12;
            } else {
                j = frontLayerScrimColor;
            }
            $dirty4 |= i12;
        } else {
            j = frontLayerScrimColor;
        }
        int $dirty5 = $dirty4;
        if ((306783379 & $dirty3) == 306783378 && ($dirty5 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function7 = function5;
            gesturesEnabled3 = gesturesEnabled;
            persistentAppBar3 = persistentAppBar;
            stickyFrontLayer3 = stickyFrontLayer;
            backLayerBackgroundColor3 = backLayerBackgroundColor;
            backLayerContentColor3 = backLayerContentColor;
            frontLayerShape4 = frontLayerShape;
            frontLayerElevation3 = frontLayerElevation;
            frontLayerBackgroundColor3 = frontLayerBackgroundColor;
            frontLayerContentColor3 = frontLayerContentColor;
            scaffoldState4 = scaffoldState2;
            peekHeight4 = peekHeight2;
            headerHeight4 = headerHeight2;
            frontLayerScrimColor2 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 16) != 0) {
                    scaffoldState3 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, $composer2, 6, 14);
                    $dirty3 &= -57345;
                } else {
                    scaffoldState3 = scaffoldState;
                }
                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1653getLambda1$material_release = i6 != 0 ? ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1653getLambda1$material_release() : function5;
                gesturesEnabled2 = i7 != 0 ? true : gesturesEnabled;
                if ((i & 128) != 0) {
                    peekHeight3 = BackdropScaffoldDefaults.INSTANCE.m1563getPeekHeightD9Ej5fM();
                    $dirty3 &= -29360129;
                } else {
                    peekHeight3 = peekHeight;
                }
                if ((i & 256) != 0) {
                    headerHeight3 = BackdropScaffoldDefaults.INSTANCE.m1562getHeaderHeightD9Ej5fM();
                    $dirty3 &= -234881025;
                } else {
                    headerHeight3 = headerHeight;
                }
                boolean persistentAppBar4 = i10 != 0 ? true : persistentAppBar;
                stickyFrontLayer2 = i11 != 0 ? true : stickyFrontLayer;
                int $dirty6 = $dirty3;
                if ((i & 2048) != 0) {
                    $dirty1 = $dirty5 & (-113);
                    backLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1627getPrimary0d7_KjU();
                } else {
                    $dirty1 = $dirty5;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function8 = function3M1653getLambda1$material_release;
                if ((i & 4096) != 0) {
                    backLayerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(backLayerBackgroundColor2, $composer2, ($dirty1 >> 3) & 14);
                    $dirty1 &= -897;
                } else {
                    backLayerContentColor2 = backLayerContentColor;
                }
                if ((i & 8192) != 0) {
                    frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape($composer2, 0);
                    $dirty1 &= -7169;
                } else {
                    frontLayerShape2 = frontLayerShape;
                }
                if ((i & 16384) != 0) {
                    frontLayerElevation2 = BackdropScaffoldDefaults.INSTANCE.m1561getFrontLayerElevationD9Ej5fM();
                    $dirty1 &= -57345;
                } else {
                    frontLayerElevation2 = frontLayerElevation;
                }
                if ((i & 32768) != 0) {
                    frontLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty1 &= -458753;
                } else {
                    frontLayerBackgroundColor2 = frontLayerBackgroundColor;
                }
                if ((i & 65536) != 0) {
                    frontLayerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(frontLayerBackgroundColor2, $composer2, ($dirty1 >> 15) & 14);
                    $dirty1 &= -3670017;
                } else {
                    frontLayerContentColor2 = frontLayerContentColor;
                }
                if ((i & 131072) != 0) {
                    long frontLayerBackgroundColor4 = frontLayerBackgroundColor2;
                    int i13 = $dirty1 & (-29360129);
                    $dirty = $dirty6;
                    frontLayerElevation3 = frontLayerElevation2;
                    frontLayerShape3 = frontLayerShape2;
                    $dirty2 = i13;
                    frontLayerScrimColor2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor($composer2, 0);
                    persistentAppBar2 = persistentAppBar4;
                    modifier2 = modifier4;
                    backLayerContentColor3 = backLayerContentColor2;
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor4;
                    backLayerBackgroundColor3 = backLayerBackgroundColor2;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    function6 = function8;
                    headerHeight2 = headerHeight3;
                    peekHeight2 = peekHeight3;
                    scaffoldState2 = scaffoldState3;
                } else {
                    long frontLayerBackgroundColor5 = frontLayerBackgroundColor2;
                    $dirty = $dirty6;
                    frontLayerElevation3 = frontLayerElevation2;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    function6 = function8;
                    persistentAppBar2 = persistentAppBar4;
                    $dirty2 = $dirty1;
                    modifier2 = modifier4;
                    backLayerContentColor3 = backLayerContentColor2;
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor5;
                    backLayerBackgroundColor3 = backLayerBackgroundColor2;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    frontLayerShape3 = frontLayerShape2;
                    headerHeight2 = headerHeight3;
                    peekHeight2 = peekHeight3;
                    scaffoldState2 = scaffoldState3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 2048) != 0) {
                    $dirty5 &= -113;
                }
                int $dirty7 = $dirty5;
                if ((i & 4096) != 0) {
                    $dirty7 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty7 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty7 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty7 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty7 &= -3670017;
                }
                if ((i & 131072) != 0) {
                    $dirty7 &= -29360129;
                }
                gesturesEnabled2 = gesturesEnabled;
                persistentAppBar2 = persistentAppBar;
                backLayerBackgroundColor3 = backLayerBackgroundColor;
                backLayerContentColor3 = backLayerContentColor;
                frontLayerElevation3 = frontLayerElevation;
                frontLayerBackgroundColor3 = frontLayerBackgroundColor;
                frontLayerContentColor3 = frontLayerContentColor;
                $dirty = $dirty3;
                $dirty2 = $dirty7;
                frontLayerScrimColor2 = j;
                modifier2 = modifier;
                function6 = function5;
                stickyFrontLayer2 = stickyFrontLayer;
                frontLayerShape3 = frontLayerShape;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113877443, $dirty, $dirty2, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:385)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            int $dirty8 = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer2, -1341962714, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed(scaffoldState2)) || ($dirty & CpioConstants.C_ISBLK) == 16384) | $composer2.changed(density);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1
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
                        scaffoldState2.setDensity$material_release(density);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv2, $composer2, 0);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_0hNv9B8_u24lambda_u244 = (Density) objConsume2;
            final float peekHeightPx = $this$BackdropScaffold_0hNv9B8_u24lambda_u244.mo567toPx0680j_4(peekHeight2);
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_0hNv9B8_u24lambda_u245 = (Density) objConsume3;
            final float headerHeightPx = $this$BackdropScaffold_0hNv9B8_u24lambda_u245.mo567toPx0680j_4(headerHeight2);
            persistentAppBar3 = persistentAppBar2;
            final Function2 backLayer = ComposableLambdaKt.rememberComposableLambda(461235665, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461235665, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:396)");
                        }
                        if (persistentAppBar2) {
                            $composer3.startReplaceGroup(-1017260965);
                            ComposerKt.sourceInformation($composer3, "397@17228L82");
                            Function2<Composer, Integer, Unit> function9 = function2;
                            Function2<Composer, Integer, Unit> function10 = function3;
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
                            int i14 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i15 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1993295851, "C398@17253L8,399@17278L18:BackdropScaffold.kt#jmzs0o");
                            function9.invoke($composer3, 0);
                            function10.invoke($composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-1017260853);
                            ComposerKt.sourceInformation($composer3, "402@17340L141");
                            BackdropScaffoldKt.BackLayerTransition(scaffoldState2.getAnchoredDraggableState$material_release().getTargetValue(), function2, function3, $composer3, 0);
                            $composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, -1341962098, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(headerHeightPx);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                        return Constraints.m6732boximpl(m1571invokeZezNO4M(constraints.getValue()));
                    }

                    /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
                    public final long m1571invokeZezNO4M(long it) {
                        return ConstraintsKt.m6764offsetNN6EwU$default(Constraints.m6734copyZbe2FdA(it, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(it) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(it) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(it) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(it) : 0), 0, -MathKt.roundToInt(headerHeightPx), 1, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function1 calculateBackLayerConstraints = (Function1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final AnchoredDraggableState<BackdropValue> anchoredDraggableState$material_release = scaffoldState2.getAnchoredDraggableState$material_release();
            final Modifier modifier5 = modifier2;
            final boolean z = stickyFrontLayer2;
            final boolean z2 = gesturesEnabled2;
            final BackdropScaffoldState backdropScaffoldState = scaffoldState2;
            final Shape shape = frontLayerShape3;
            final long j2 = frontLayerBackgroundColor3;
            final long j3 = frontLayerContentColor3;
            final float f = frontLayerElevation3;
            final float f2 = headerHeight2;
            final float f3 = peekHeight2;
            final long j4 = frontLayerScrimColor2;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function9 = function6;
            Modifier modifier6 = modifier2;
            Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function10 = function6;
            SurfaceKt.m1809SurfaceFjzlyU(null, null, backLayerBackgroundColor3, backLayerContentColor3, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1961515015, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
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
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C419@17870L24,424@18029L3712,420@17903L3838:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1961515015, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:419)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function11 = backLayer;
                        Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints;
                        final float f4 = headerHeightPx;
                        final boolean z3 = z;
                        final boolean z4 = z2;
                        final BackdropScaffoldState backdropScaffoldState2 = backdropScaffoldState;
                        final AnchoredDraggableState<BackdropValue> anchoredDraggableState = anchoredDraggableState$material_release;
                        final Shape shape2 = shape;
                        final long j5 = j2;
                        final long j6 = j3;
                        final float f5 = f;
                        final float f6 = f2;
                        final float f7 = peekHeightPx;
                        final float f8 = f3;
                        final Function2<Composer, Integer, Unit> function12 = function4;
                        final long j7 = j4;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function13 = function9;
                        BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function11, function1, ComposableLambdaKt.rememberComposableLambda(516504859, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f9, Composer composer, Integer num) {
                                m1569invokejYbf7pk(constraints.getValue(), f9.floatValue(), composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Code duplicated, block: B:47:0x0173  */
                            /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
                            public final void m1569invokejYbf7pk(long constraints, float backLayerHeight, Composer $composer4, int $changed3) {
                                Modifier.Companion companionNestedScroll$default;
                                Object value$iv3;
                                float fM6801constructorimpl;
                                Function0<ComposeUiNode> function0;
                                ComposerKt.sourceInformation($composer4, "CP(1:c#ui.unit.Constraints)462@19798L673,481@20682L575,437@18486L2771,497@21300L431:BackdropScaffold.kt#jmzs0o");
                                int $dirty9 = $changed3;
                                if (($changed3 & 6) == 0) {
                                    $dirty9 |= $composer4.changed(constraints) ? 4 : 2;
                                }
                                if (($changed3 & 48) == 0) {
                                    $dirty9 |= $composer4.changed(backLayerHeight) ? 32 : 16;
                                }
                                int $dirty10 = $dirty9;
                                if (($dirty10 & 147) != 146 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(516504859, $dirty10, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:425)");
                                    }
                                    final Ref.FloatRef revealedHeight = new Ref.FloatRef();
                                    revealedHeight.element = Constraints.m6743getMaxHeightimpl(constraints) - f4;
                                    if (z3) {
                                        revealedHeight.element = Math.min(revealedHeight.element, backLayerHeight);
                                    }
                                    if (z4) {
                                        companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState2.getNestedScrollConnection(), null, 2, null);
                                    } else {
                                        companionNestedScroll$default = Modifier.INSTANCE;
                                    }
                                    Modifier nestedScroll = companionNestedScroll$default;
                                    AnchoredDraggableState<BackdropValue> anchoredDraggableState2 = anchoredDraggableState;
                                    Orientation orientation = Orientation.Vertical;
                                    final float f9 = f7;
                                    final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldState2;
                                    Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(nestedScroll, anchoredDraggableState2, orientation, new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<BackdropValue>, ? extends BackdropValue>>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.2.1.1

                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$1$WhenMappings */
                                        /* JADX INFO: compiled from: BackdropScaffold.kt */
                                        @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                        public /* synthetic */ class WhenMappings {
                                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                            static {
                                                int[] iArr = new int[BackdropValue.values().length];
                                                try {
                                                    iArr[BackdropValue.Concealed.ordinal()] = 1;
                                                } catch (NoSuchFieldError e) {
                                                }
                                                try {
                                                    iArr[BackdropValue.Revealed.ordinal()] = 2;
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
                                        public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<BackdropValue>, ? extends BackdropValue> invoke(IntSize intSize, Constraints constraints2) {
                                            return m1570invokeGpV2Q24(intSize.getPackedValue(), constraints2.getValue());
                                        }

                                        /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                                        public final Pair<DraggableAnchors<BackdropValue>, BackdropValue> m1570invokeGpV2Q24(long layoutSize, long j8) {
                                            BackdropValue newTarget;
                                            final float sheetHeight = IntSize.m6974getHeightimpl(layoutSize);
                                            final float collapsedHeight = IntSize.m6974getHeightimpl(layoutSize) - f9;
                                            final float f10 = f9;
                                            final Ref.FloatRef floatRef = revealedHeight;
                                            DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BackdropValue>, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$1$newAnchors$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BackdropValue> draggableAnchorsConfig) {
                                                    invoke2(draggableAnchorsConfig);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DraggableAnchorsConfig<BackdropValue> draggableAnchorsConfig) {
                                                    if (!(sheetHeight == 0.0f)) {
                                                        if (!(sheetHeight == f10)) {
                                                            draggableAnchorsConfig.m15at(BackdropValue.Concealed, f10);
                                                            draggableAnchorsConfig.m15at(BackdropValue.Revealed, floatRef.element);
                                                            return;
                                                        }
                                                    }
                                                    draggableAnchorsConfig.m15at(BackdropValue.Concealed, collapsedHeight);
                                                }
                                            });
                                            switch (WhenMappings.$EnumSwitchMapping$0[backdropScaffoldState3.getTargetValue().ordinal()]) {
                                                case 1:
                                                    newTarget = BackdropValue.Concealed;
                                                    break;
                                                case 2:
                                                    newTarget = !newAnchors.hasAnchorFor(BackdropValue.Revealed) ? BackdropValue.Concealed : BackdropValue.Revealed;
                                                    break;
                                                default:
                                                    throw new NoWhenBranchMatchedException();
                                            }
                                            return TuplesKt.m202to(newAnchors, newTarget);
                                        }
                                    });
                                    AnchoredDraggableState<BackdropValue> anchoredDraggableState3 = anchoredDraggableState;
                                    Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(modifierDraggableAnchors, anchoredDraggableState3, Orientation.Vertical, (56 & 4) != 0 ? true : z4, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? null : null, (56 & 32) != 0 ? anchoredDraggableState3.isAnimationRunning() : false);
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1993293306, "CC(remember):BackdropScaffold.kt#9igjgp");
                                    boolean invalid$iv3 = $composer4.changed(backdropScaffoldState2) | $composer4.changedInstance(scope);
                                    final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldState2;
                                    final CoroutineScope coroutineScope = scope;
                                    Object it$iv2 = $composer4.rememberedValue();
                                    if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1
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
                                                if (backdropScaffoldState4.isConcealed()) {
                                                    final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState4;
                                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                                    SemanticsPropertiesKt.collapse$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1$1$1, reason: invalid class name */
                                                        /* JADX INFO: compiled from: BackdropScaffold.kt */
                                                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                        @DebugMetadata(m209c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1$1$1", m210f = "BackdropScaffold.kt", m211i = {}, m212l = {467}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                        if (this.$scaffoldState.reveal(this) == coroutine_suspended) {
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
                                                            if (backdropScaffoldState5.getConfirmValueChange().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(backdropScaffoldState5, null), 3, null);
                                                            }
                                                            return true;
                                                        }
                                                    }, 1, null);
                                                } else {
                                                    final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState4;
                                                    final CoroutineScope coroutineScope3 = coroutineScope;
                                                    SemanticsPropertiesKt.expand$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1$2$1, reason: invalid class name */
                                                        /* JADX INFO: compiled from: BackdropScaffold.kt */
                                                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                        @DebugMetadata(m209c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$2$1$2$1", m210f = "BackdropScaffold.kt", m211i = {}, m212l = {473}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                        if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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
                                                            if (backdropScaffoldState6.getConfirmValueChange().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(backdropScaffoldState6, null), 3, null);
                                                            }
                                                            return true;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv2;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAnchoredDraggable, false, (Function1) value$iv3, 1, null);
                                    Shape shape3 = shape2;
                                    long j8 = j5;
                                    long j9 = j6;
                                    float f10 = f5;
                                    final float f11 = f8;
                                    final Function2<Composer, Integer, Unit> function14 = function12;
                                    final long j10 = j7;
                                    final boolean z5 = z4;
                                    final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState2;
                                    final CoroutineScope coroutineScope2 = scope;
                                    SurfaceKt.m1809SurfaceFjzlyU(modifierSemantics$default, shape3, j8, j9, null, f10, ComposableLambdaKt.rememberComposableLambda(1946125143, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.2.1.3
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

                                        /* JADX WARN: Code duplicated, block: B:36:0x0199  */
                                        /* JADX WARN: Code duplicated, block: B:37:0x019c  */
                                        /* JADX WARN: Code duplicated, block: B:40:0x01c3  */
                                        /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
                                        public final void invoke(Composer $composer5, int $changed4) {
                                            Function0<ComposeUiNode> function15;
                                            CompositionLocalMap localMap$iv$iv;
                                            boolean invalid$iv4;
                                            Object value$iv4;
                                            boolean z6;
                                            ComposerKt.sourceInformation($composer5, "C482@20700L543:BackdropScaffold.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1946125143, $changed4, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:482)");
                                                }
                                                Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f11, 7, null);
                                                Function2<Composer, Integer, Unit> function16 = function14;
                                                long j11 = j10;
                                                final boolean z7 = z5;
                                                final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState5;
                                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function15 = constructor;
                                                    $composer5.createNode(function15);
                                                } else {
                                                    function15 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                                                    localMap$iv$iv = localMap$iv$iv2;
                                                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    }
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i14 = ($changed$iv$iv$iv >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i15 = ((0 >> 6) & 112) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 967348367, "C483@20765L19,486@20902L228,484@20805L420:BackdropScaffold.kt#jmzs0o");
                                                    function16.invoke($composer5, 0);
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 967348504, "CC(remember):BackdropScaffold.kt#9igjgp");
                                                    invalid$iv4 = $composer5.changed(z7) | $composer5.changed(backdropScaffoldState6) | $composer5.changedInstance(coroutineScope3);
                                                    value$iv4 = $composer5.rememberedValue();
                                                    if (!invalid$iv4 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                                                        value$iv4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                                invoke2();
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1$1 */
                                                            /* JADX INFO: compiled from: BackdropScaffold.kt */
                                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                            @DebugMetadata(m209c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1$1", m210f = "BackdropScaffold.kt", m211i = {}, m212l = {489}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                            static final class C09561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                C09561(BackdropScaffoldState backdropScaffoldState, Continuation<? super C09561> continuation) {
                                                                    super(2, continuation);
                                                                    this.$scaffoldState = backdropScaffoldState;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new C09561(this.$scaffoldState, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object $result) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    switch (this.label) {
                                                                        case 0:
                                                                            ResultKt.throwOnFailure($result);
                                                                            this.label = 1;
                                                                            if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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
                                                                if (z7 && backdropScaffoldState6.getConfirmValueChange().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C09561(backdropScaffoldState6, null), 3, null);
                                                                }
                                                            }
                                                        };
                                                        $composer5.updateRememberedValue(value$iv4);
                                                    }
                                                    Function0 function17 = (Function0) value$iv4;
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    if (backdropScaffoldState6.getTargetValue() == BackdropValue.Revealed) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    BackdropScaffoldKt.m1565Scrim3JVO9M(j11, function17, z6, $composer5, 0);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    $composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                localMap$iv$iv = localMap$iv$iv2;
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i16 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                int i17 = ((0 >> 6) & 112) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 967348367, "C483@20765L19,486@20902L228,484@20805L420:BackdropScaffold.kt#jmzs0o");
                                                function16.invoke($composer5, 0);
                                                ComposerKt.sourceInformationMarkerStart($composer5, 967348504, "CC(remember):BackdropScaffold.kt#9igjgp");
                                                invalid$iv4 = $composer5.changed(z7) | $composer5.changed(backdropScaffoldState6) | $composer5.changedInstance(coroutineScope3);
                                                value$iv4 = $composer5.rememberedValue();
                                                if (!invalid$iv4) {
                                                }
                                                value$iv4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1$1 */
                                                    /* JADX INFO: compiled from: BackdropScaffold.kt */
                                                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                    @DebugMetadata(m209c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1$1", m210f = "BackdropScaffold.kt", m211i = {}, m212l = {489}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                    static final class C09561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        C09561(BackdropScaffoldState backdropScaffoldState, Continuation<? super C09561> continuation) {
                                                            super(2, continuation);
                                                            this.$scaffoldState = backdropScaffoldState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C09561(this.$scaffoldState, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object $result) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            switch (this.label) {
                                                                case 0:
                                                                    ResultKt.throwOnFailure($result);
                                                                    this.label = 1;
                                                                    if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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
                                                        if (z7 && backdropScaffoldState6.getConfirmValueChange().invoke(BackdropValue.Concealed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C09561(backdropScaffoldState6, null), 3, null);
                                                        }
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv4);
                                                Function0 function18 = (Function0) value$iv4;
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (backdropScaffoldState6.getTargetValue() == BackdropValue.Revealed) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                BackdropScaffoldKt.m1565Scrim3JVO9M(j11, function18, z6, $composer5, 0);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }, $composer4, 54), $composer4, 1572864, 16);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    if (backdropScaffoldState2.isRevealed()) {
                                        if (revealedHeight.element == ((float) Constraints.m6743getMaxHeightimpl(constraints)) - f4) {
                                            fM6801constructorimpl = f6;
                                        } else {
                                            fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                                        }
                                    } else {
                                        fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                                    }
                                    Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, fM6801constructorimpl, 7, null);
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getBottomCenter();
                                    Function3<SnackbarHostState, Composer, Integer, Unit> function15 = function13;
                                    BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState2;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv = (48 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function0 = constructor;
                                        $composer4.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i14 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i15 = ((48 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1395540857, "C506@21672L45:BackdropScaffold.kt#jmzs0o");
                                    function15.invoke(backdropScaffoldState6.getSnackbarHostState(), $composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 3120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty8 << 3) & 896) | 1572864 | (($dirty8 << 3) & 7168), 51);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            function7 = function10;
            gesturesEnabled3 = gesturesEnabled2;
            scaffoldState4 = scaffoldState2;
            peekHeight4 = peekHeight2;
            headerHeight4 = headerHeight2;
            stickyFrontLayer3 = stickyFrontLayer2;
            frontLayerShape4 = frontLayerShape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final BackdropScaffoldState backdropScaffoldState2 = scaffoldState4;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11 = function7;
            final boolean z3 = gesturesEnabled3;
            final float f4 = peekHeight4;
            final float f5 = headerHeight4;
            final boolean z4 = persistentAppBar3;
            final boolean z5 = stickyFrontLayer3;
            final long j5 = backLayerBackgroundColor3;
            final long j6 = backLayerContentColor3;
            final Shape shape2 = frontLayerShape4;
            final float f6 = frontLayerElevation3;
            final long j7 = frontLayerBackgroundColor3;
            final long j8 = frontLayerContentColor3;
            final long j9 = frontLayerScrimColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$3
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

                public final void invoke(Composer composer, int i14) {
                    BackdropScaffoldKt.m1564BackdropScaffold0hNv9B8(function2, function3, function4, modifier7, backdropScaffoldState2, function11, z3, f4, f5, z4, z5, j5, j6, shape2, f6, j7, j8, j9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1565Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)519@21902L121,532@22312L62,528@22203L171:BackdropScaffold.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-92141505, $dirty, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:517)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                $composer2.startReplaceGroup(1010552198);
                ComposerKt.sourceInformation($composer2, "524@22109L37");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1010552253, "CC(remember):BackdropScaffold.kt#9igjgp");
                    boolean invalid$iv = ($dirty & 112) == 32;
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 value$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                ComposerKt.sourceInformationMarkerStart($composer2, 1010552456, "CC(remember):BackdropScaffold.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(stateAnimateFloatAsState) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
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
                            DrawScope.CC.m4858drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, BackdropScaffoldKt.Scrim_3J_VO9M$lambda$7(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
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
                    BackdropScaffoldKt.m1565Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$7(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue target, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Object value$iv;
        Function0<ComposeUiNode> function1;
        Object value$iv2;
        Object value$iv3;
        Function0<ComposeUiNode> function4;
        final Function2<? super Composer, ? super Integer, Unit> function5 = function3;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)551@22995L112,*554@23157L7,556@23203L1485:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(target) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:548)");
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(target == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer3, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackLayerTransition_u24lambda_u2411 = (Density) objConsume;
            final float animationSlideOffset = $this$BackLayerTransition_u24lambda_u2411.mo567toPx0680j_4(AnimationSlideOffset);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1538624135, "C559@23267L351,566@23650L218,557@23217L694,577@24032L353,584@24417L221,574@23920L762:BackdropScaffold.kt#jmzs0o");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1538624085, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(stateAnimateFloatAsState);
            Object value$iv4 = $composer3.rememberedValue();
            if (invalid$iv || value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1567invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1567invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        float $this$fastCoerceIn$iv = BackdropScaffoldKt.BackLayerTransition$lambda$10(stateAnimateFloatAsState) - 1;
                        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        final float $this$fastCoerceIn$iv2 = $this$fastCoerceAtLeast$iv$iv;
                        final Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                        return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                $this$layout2.place(placeable, 0, 0, $this$fastCoerceIn$iv2);
                            }
                        }, 4, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) value$iv4);
            ComposerKt.sourceInformationMarkerStart($composer3, -1538623702, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(stateAnimateFloatAsState) | $composer3.changed(animationSlideOffset);
            $composer2 = $composer3;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                        float f = 1;
                        float $this$fastCoerceAtLeast$iv$iv = BackdropScaffoldKt.BackLayerTransition$lambda$10(stateAnimateFloatAsState) - f;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        float $this$fastCoerceIn$iv = $this$fastCoerceAtLeast$iv$iv;
                        $this$graphicsLayer.setAlpha($this$fastCoerceIn$iv);
                        $this$graphicsLayer.setTranslationY((f - $this$fastCoerceIn$iv) * animationSlideOffset);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = GraphicsLayerModifierKt.graphicsLayer(modifierLayout, (Function1) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
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
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481849794, "C572@23893L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1538623320, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(stateAnimateFloatAsState);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1568invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1568invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        float $this$fastCoerceIn$iv = 1 - BackdropScaffoldKt.BackLayerTransition$lambda$10(stateAnimateFloatAsState);
                        float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        final float $this$fastCoerceIn$iv2 = $this$fastCoerceAtLeast$iv$iv;
                        final Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                        return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$4$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                $this$layout2.place(placeable, 0, 0, $this$fastCoerceIn$iv2);
                            }
                        }, 4, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierLayout2 = LayoutModifierKt.layout(companion2, (Function3) value$iv2);
            ComposerKt.sourceInformationMarkerStart($composer3, -1538622935, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(stateAnimateFloatAsState) | $composer3.changed(animationSlideOffset);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$1$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                        float f = 1;
                        float $this$fastCoerceAtLeast$iv$iv = f - BackdropScaffoldKt.BackLayerTransition$lambda$10(stateAnimateFloatAsState);
                        if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 0.0f;
                        }
                        if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                            $this$fastCoerceAtLeast$iv$iv = 1.0f;
                        }
                        float $this$fastCoerceIn$iv = $this$fastCoerceAtLeast$iv$iv;
                        $this$graphicsLayer.setAlpha($this$fastCoerceIn$iv);
                        $this$graphicsLayer.setTranslationY((f - $this$fastCoerceIn$iv) * animationSlideOffset);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = GraphicsLayerModifierKt.graphicsLayer(modifierLayout2, (Function1) value$iv3);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function4 = constructor3;
                $composer3.createNode(function4);
            } else {
                function4 = constructor3;
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
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481849024, "C590@24663L9:BackdropScaffold.kt#jmzs0o");
            function5 = function3;
            function5.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
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

                public final void invoke(Composer composer, int i7) {
                    BackdropScaffoldKt.BackLayerTransition(target, function2, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BackLayerTransition$lambda$10(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)602@24951L890,602@24924L917:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:601)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1200753995, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 896) == 256) | (($dirty & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1572invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1572invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first((List) $this$SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo5644measureBRTryo0(function1.invoke(Constraints.m6732boximpl(constraints)).getValue());
                        final float backLayerHeight = backLayerPlaceable.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function5 = function4;
                        List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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
                                ComposerKt.sourceInformation($composer3, "C611@25289L40:BackdropScaffold.kt#jmzs0o");
                                if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, $changed2, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:611)");
                                }
                                function5.invoke(Constraints.m6732boximpl(constraints), Float.valueOf(backLayerHeight), $composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        List target$iv = new ArrayList(listSubcompose.size());
                        int index$iv$iv = 0;
                        int size = listSubcompose.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = listSubcompose.get(index$iv$iv);
                            target$iv.add(((Measurable) item$iv$iv).mo5644measureBRTryo0(constraints));
                            index$iv$iv++;
                            backLayerHeight = backLayerHeight;
                        }
                        final List placeables = target$iv;
                        int maxWidth = Math.max(Constraints.m6746getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
                        int maxHeight = Math.max(Constraints.m6745getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
                        int size2 = placeables.size();
                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                            Object item$iv = placeables.get(index$iv);
                            Placeable it = (Placeable) item$iv;
                            maxWidth = Math.max(maxWidth, it.getWidth());
                            maxHeight = Math.max(maxHeight, it.getHeight());
                        }
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, maxWidth, maxHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
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
                                Placeable.PlacementScope.placeRelative$default($this$layout, backLayerPlaceable, 0, 0, 0.0f, 4, null);
                                List<Placeable> list = placeables;
                                int size3 = list.size();
                                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                    Object item$iv2 = list.get(index$iv2);
                                    Placeable it2 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it2, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
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
                    BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1 */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    @Metadata(m194d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m195d2 = {"androidx/compose/material/BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class C09611 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C09611(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
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
            C0963x677cf7ed c0963x677cf7ed;
            if (continuation instanceof C0963x677cf7ed) {
                c0963x677cf7ed = (C0963x677cf7ed) continuation;
                if ((c0963x677cf7ed.label & Integer.MIN_VALUE) != 0) {
                    c0963x677cf7ed.label -= Integer.MIN_VALUE;
                } else {
                    c0963x677cf7ed = new C0963x677cf7ed(this, continuation);
                }
            } else {
                c0963x677cf7ed = new C0963x677cf7ed(this, continuation);
            }
            C0963x677cf7ed c0963x677cf7ed2 = c0963x677cf7ed;
            Object $result = c0963x677cf7ed2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c0963x677cf7ed2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float toFling = velocityToFloat(available);
                    float currentOffset = this.$state.requireOffset();
                    if (toFling < 0.0f && currentOffset > this.$state.getAnchors().minAnchor()) {
                        AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                        c0963x677cf7ed2.J$0 = available;
                        c0963x677cf7ed2.label = 1;
                        if (anchoredDraggableState.settle(toFling, c0963x677cf7ed2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        available = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                    }
                    break;
                case 1:
                    available = c0963x677cf7ed2.J$0;
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
            C0962x9c2945e2 c0962x9c2945e2;
            if (continuation instanceof C0962x9c2945e2) {
                c0962x9c2945e2 = (C0962x9c2945e2) continuation;
                if ((c0962x9c2945e2.label & Integer.MIN_VALUE) != 0) {
                    c0962x9c2945e2.label -= Integer.MIN_VALUE;
                } else {
                    c0962x9c2945e2 = new C0962x9c2945e2(this, continuation);
                }
            } else {
                c0962x9c2945e2 = new C0962x9c2945e2(this, continuation);
            }
            Object $result = c0962x9c2945e2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c0962x9c2945e2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    float fVelocityToFloat = velocityToFloat(available);
                    c0962x9c2945e2.J$0 = available;
                    c0962x9c2945e2.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, c0962x9c2945e2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    available = c0962x9c2945e2.J$0;
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

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C09611(anchoredDraggableState, orientation);
    }
}

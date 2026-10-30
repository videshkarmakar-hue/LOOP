package androidx.compose.material3;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.TransformOriginKt;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.p001ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¹\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00132\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0002\b\u0018¢\u0006\u0002\b H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aR\u0010#\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0006\u0010\u0019\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u0018H\u0001¢\u0006\u0002\u0010(\u001a0\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00132\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a-\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020,2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020,0\u001eH\u0007¢\u0006\u0002\u00103\u001aÞ\u0001\u00104\u001a\u00020\b*\u0002052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0006\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\n2!\u00109\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\b0\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\b\u00182\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0002\b\u0018¢\u0006\u0002\b H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u0014\u0010?\u001a\u00020&*\u00020@2\u0006\u0010A\u001a\u00020&H\u0002\u001a\u0014\u0010B\u001a\u00020&*\u00020@2\u0006\u0010A\u001a\u00020&H\u0002\u001a\f\u0010C\u001a\u00020,*\u00020DH\u0002\u001a\u0014\u0010E\u001a\u00020,*\u00020F2\u0006\u0010G\u001a\u00020,H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020&X\u008a\u0084\u0002²\u0006\u0015\u0010J\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u0018X\u008a\u0084\u0002"}, m195d2 = {"PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "PredictiveBackMaxScaleXDistance", "Landroidx/compose/ui/unit/Dp;", "F", "PredictiveBackMaxScaleYDistance", "ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetPopup", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/Animatable;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-NYQaCzI", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", NotificationCompat.CATEGORY_PROGRESS, "calculatePredictiveBackScaleY", "isFlagSecureEnabled", "Landroid/view/View;", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "alpha", "currentContent"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ModalBottomSheet_androidKt {
    private static final float PredictiveBackMaxScaleXDistance = C1979Dp.m6801constructorimpl(48);
    private static final float PredictiveBackMaxScaleYDistance = C1979Dp.m6801constructorimpl(24);
    private static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);

    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    public static final void m2374ModalBottomSheetdYc4hso(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, long scrimColor, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, ModalBottomSheetProperties properties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        SheetState sheetState2;
        Shape shape2;
        Modifier.Companion modifier3;
        final SheetState sheetState3;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        long scrimColor2;
        Function2<? super Composer, ? super Integer, Unit> function2M2122getLambda1$material3_release;
        WindowInsets windowInsets2;
        ModalBottomSheetProperties properties2;
        int $dirty1;
        long scrimColor3;
        int $dirty2;
        float tonalElevation2;
        float tonalElevation3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        WindowInsets windowInsets3;
        ModalBottomSheetProperties properties3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        float tonalElevation4;
        Modifier modifier4;
        SheetState sheetState4;
        Shape shape4;
        long contentColor3;
        float sheetMaxWidth2;
        ModalBottomSheet_androidKt$ModalBottomSheet$3$1 value$iv5;
        Composer $composer2 = $composer.startRestartGroup(944867294);
        ComposerKt.sourceInformation($composer2, "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)152@7457L31,154@7588L13,155@7651L14,156@7693L31,158@7801L10,160@7948L12,164@8115L24,165@8179L277,174@8510L143,180@8688L42,184@8819L708,197@9629L704,182@8736L1597,222@10408L41,222@10381L68:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty3 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetState2 = sheetState;
                int i3 = $composer2.changed(sheetState2) ? 256 : 128;
                $dirty |= i3;
            } else {
                sheetState2 = sheetState;
            }
            $dirty |= i3;
        } else {
            sheetState2 = sheetState;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sheetMaxWidth) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i5 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                shape2 = shape;
            }
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= ((i & 32) == 0 && $composer2.changed(containerColor)) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= ((i & 64) == 0 && $composer2.changed(contentColor)) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(scrimColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty |= 805306368;
        } else if ((805306368 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= ((i & 1024) == 0 && $composer2.changed(windowInsets)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty3 |= ((i & 2048) == 0 && $composer2.changed(properties)) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty3 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            sheetMaxWidth2 = sheetMaxWidth;
            containerColor2 = containerColor;
            contentColor3 = contentColor;
            tonalElevation4 = tonalElevation;
            scrimColor3 = scrimColor;
            function4 = function2;
            windowInsets3 = windowInsets;
            properties3 = properties;
            modifier4 = modifier2;
            sheetState4 = sheetState2;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    sheetState3 = rememberModalBottomSheetState(false, null, $composer2, 0, 3);
                    $dirty &= -897;
                } else {
                    sheetState3 = sheetState2;
                }
                float sheetMaxWidth3 = i4 != 0 ? BottomSheetDefaults.INSTANCE.m1943getSheetMaxWidthD9Ej5fM() : sheetMaxWidth;
                if ((i & 16) != 0) {
                    shape3 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer2, 6);
                    $dirty &= -57345;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer2, 6);
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                float tonalElevation5 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : tonalElevation;
                if ((i & 256) != 0) {
                    scrimColor2 = BottomSheetDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty &= -234881025;
                } else {
                    scrimColor2 = scrimColor;
                }
                function2M2122getLambda1$material3_release = i7 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m2122getLambda1$material3_release() : function2;
                if ((i & 1024) != 0) {
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty3 &= -15;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 2048) != 0) {
                    properties2 = ModalBottomSheetDefaults.properties$default(ModalBottomSheetDefaults.INSTANCE, null, false, false, 7, null);
                    $dirty1 = $dirty3 & (-113);
                    scrimColor3 = scrimColor2;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation5;
                    tonalElevation3 = sheetMaxWidth3;
                } else {
                    properties2 = properties;
                    $dirty1 = $dirty3;
                    scrimColor3 = scrimColor2;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation5;
                    tonalElevation3 = sheetMaxWidth3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 1024) != 0) {
                    $dirty3 &= -15;
                }
                if ((i & 2048) != 0) {
                    contentColor2 = contentColor;
                    scrimColor3 = scrimColor;
                    function2M2122getLambda1$material3_release = function2;
                    windowInsets2 = windowInsets;
                    $dirty1 = $dirty3 & (-113);
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    sheetState3 = sheetState2;
                    shape3 = shape2;
                    tonalElevation3 = sheetMaxWidth;
                    containerColor2 = containerColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                } else {
                    tonalElevation3 = sheetMaxWidth;
                    contentColor2 = contentColor;
                    scrimColor3 = scrimColor;
                    function2M2122getLambda1$material3_release = function2;
                    windowInsets2 = windowInsets;
                    $dirty1 = $dirty3;
                    modifier3 = modifier2;
                    sheetState3 = sheetState2;
                    shape3 = shape2;
                    containerColor2 = containerColor;
                    properties2 = properties;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(944867294, $dirty2, $dirty1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:163)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            WindowInsets windowInsets4 = windowInsets2;
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            ModalBottomSheetProperties properties4 = properties2;
            if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -203429815, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            int $dirty4 = $dirty1;
            boolean invalid$iv = (((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(sheetState3)) || ($dirty2 & 384) == 256) | $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1 */
                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {168}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C14051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14051(SheetState sheetState, Continuation<? super C14051> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14051(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        if (sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14051(sheetState3, null), 3, null);
                            final SheetState sheetState5 = sheetState3;
                            final Function0<Unit> function1 = function0;
                            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    if (!sheetState5.isVisible()) {
                                        function1.invoke();
                                    }
                                }
                            });
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function0 animateToDismiss = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -203429484, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            final Function2<? super Composer, ? super Integer, Unit> function5 = function2M2122getLambda1$material3_release;
            boolean invalid$iv2 = (((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(sheetState3)) || ($dirty2 & 384) == 256) | $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1 */
                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {176}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C14071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14071(SheetState sheetState, float f, Continuation<? super C14071> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14071(this.$sheetState, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
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

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float it) {
                        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14071(sheetState3, it, null), 3, null);
                        final SheetState sheetState5 = sheetState3;
                        final Function0<Unit> function1 = function0;
                        jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it2) {
                                if (!sheetState5.isVisible()) {
                                    function1.invoke();
                                }
                            }
                        });
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final Function1 settleToDismiss = (Function1) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -203429306, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            final float tonalElevation6 = tonalElevation2;
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final Animatable predictiveBackProgress = (Animatable) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -203429175, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv3 = (((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(sheetState3)) || ($dirty2 & 384) == 256) | $composer2.changedInstance(scope) | $composer2.changedInstance(predictiveBackProgress) | (($dirty2 & 14) == 4);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
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
                        if (sheetState3.getCurrentValue() != SheetValue.Expanded || !sheetState3.getHasPartiallyExpandedState()) {
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14033(sheetState3, null), 3, null);
                            final Function0<Unit> function1 = function0;
                            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    function1.invoke();
                                }
                            });
                        } else {
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14011(predictiveBackProgress, null), 3, null);
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14022(sheetState3, null), 3, null);
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$1 */
                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$1", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {190}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C14011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14011(Animatable<Float, AnimationVector1D> animatable, Continuation<? super C14011> continuation) {
                            super(2, continuation);
                            this.$predictiveBackProgress = animatable;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14011(this.$predictiveBackProgress, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    Animatable<Float, AnimationVector1D> animatable = this.$predictiveBackProgress;
                                    this.label = 1;
                                    if (animatable.animateTo(Boxing.boxFloat(0.0f), (4 & 2) != 0 ? animatable.defaultSpringSpec : null, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$2 */
                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$2", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {191}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C14022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14022(SheetState sheetState, Continuation<? super C14022> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14022(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$3 */
                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1$3", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {193}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C14033 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14033(SheetState sheetState, Continuation<? super C14033> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14033(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14033) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final long j = scrimColor3;
            final SheetState sheetState5 = sheetState3;
            final Modifier modifier5 = modifier3;
            final float f = tonalElevation3;
            final Shape shape5 = shape3;
            final long j2 = containerColor2;
            final long j3 = contentColor2;
            float sheetMaxWidth4 = tonalElevation3;
            ModalBottomSheetPopup(properties4, (Function0) value$iv4, predictiveBackProgress, windowInsets4, ComposableLambdaKt.rememberComposableLambda(1603656084, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C198@9639L688:ModalBottomSheet.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1603656084, $changed2, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:198)");
                        }
                        Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        long j4 = j;
                        Function0<Unit> function6 = animateToDismiss;
                        SheetState sheetState6 = sheetState5;
                        Animatable<Float, AnimationVector1D> animatable = predictiveBackProgress;
                        CoroutineScope coroutineScope = scope;
                        Function1<Float, Unit> function7 = settleToDismiss;
                        Modifier modifier6 = modifier5;
                        float f2 = f;
                        Shape shape6 = shape5;
                        long j5 = j2;
                        long j6 = j3;
                        float f3 = tonalElevation6;
                        Function2<Composer, Integer, Unit> function8 = function5;
                        Function3<ColumnScope, Composer, Integer, Unit> function9 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (390 << 3) & 112;
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
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
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
                        int $changed3 = ((390 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1482643702, "C199@9714L168,204@9895L422:ModalBottomSheet.android.kt#uh7d8r");
                        ModalBottomSheet_androidKt.m2376Scrim3JVO9M(j4, function6, sheetState6.getTargetValue() != SheetValue.Hidden, $composer3, 0);
                        ModalBottomSheet_androidKt.m2375ModalBottomSheetContentNYQaCzI($this$invoke_u24lambda_u240, animatable, coroutineScope, function6, function7, modifier6, sheetState6, f2, shape6, j5, j6, f3, function8, function9, $composer3, ($changed3 & 14) | (Animatable.$stable << 3), 0, 0);
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
            }, $composer2, 54), $composer2, (($dirty4 >> 3) & 14) | CpioConstants.C_ISBLK | (Animatable.$stable << 6) | (($dirty4 << 9) & 7168));
            if (sheetState3.getHasExpandedState()) {
                ComposerKt.sourceInformationMarkerStart($composer2, -203427586, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean invalid$iv4 = ((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(sheetState3)) || ($dirty2 & 384) == 256;
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState3, null);
                    $composer2.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv5, $composer2, ($dirty2 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets4;
            properties3 = properties4;
            function4 = function5;
            tonalElevation4 = tonalElevation6;
            modifier4 = modifier3;
            sheetState4 = sheetState3;
            shape4 = shape3;
            contentColor3 = contentColor2;
            sheetMaxWidth2 = sheetMaxWidth4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final SheetState sheetState6 = sheetState4;
            final float f2 = sheetMaxWidth2;
            final Shape shape6 = shape4;
            final long j4 = containerColor2;
            final long j5 = contentColor3;
            final float f3 = tonalElevation4;
            final long j6 = scrimColor3;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function4;
            final WindowInsets windowInsets5 = windowInsets3;
            final ModalBottomSheetProperties modalBottomSheetProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$4
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
                    ModalBottomSheet_androidKt.m2374ModalBottomSheetdYc4hso(function0, modifier6, sheetState6, f2, shape6, j4, j5, f3, j6, function6, windowInsets5, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ModalBottomSheetContent-NYQaCzI, reason: not valid java name */
    public static final void m2375ModalBottomSheetContentNYQaCzI(final BoxScope $this$ModalBottomSheetContent_u2dNYQaCzI, final Animatable<Float, AnimationVector1D> animatable, final CoroutineScope scope, final Function0<Unit> function0, final Function1<? super Float, Unit> function1, Modifier modifier, SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Shape shape2;
        SheetState sheetState2;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        Function2<? super Composer, ? super Integer, Unit> function2M2123getLambda2$material3_release;
        int $dirty;
        int $dirty1;
        float tonalElevation2;
        float sheetMaxWidth2;
        long contentColor3;
        final SheetState sheetState3;
        float sheetMaxWidth3;
        Modifier modifier3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        float tonalElevation3;
        long contentColor4;
        SheetState sheetState4;
        long containerColor3;
        Shape shape4;
        Composer $composer2 = $composer.startRestartGroup(-235635112);
        ComposerKt.sourceInformation($composer2, "C(ModalBottomSheetContent)P(6,7!1,8,5,11,10:c#ui.unit.Dp,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,12:c#ui.unit.Dp,4)236@10783L31,238@10914L13,239@10977L14,240@11019L31,245@11273L48,251@11461L572,263@12097L36,265@12177L300,276@12625L1212,306@14161L23,312@14339L2962,247@11327L5974:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed($this$ModalBottomSheetContent_u2dNYQaCzI) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= ($changed & 64) == 0 ? $composer2.changed(animatable) : $composer2.changedInstance(animatable) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(scope) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 8) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            modifier2 = modifier;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(sheetState)) ? 1048576 : 524288;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(sheetMaxWidth) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(containerColor)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= ((i & 512) == 0 && $composer2.changed(contentColor)) ? 4 : 2;
        }
        int i5 = i & 1024;
        if (i5 != 0) {
            $dirty3 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty3 |= $composer2.changed(tonalElevation) ? 32 : 16;
        }
        int i6 = i & 2048;
        if (i6 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 4096) != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($dirty2 & 306783379) == 306783378 && ($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            sheetState4 = sheetState;
            sheetMaxWidth3 = sheetMaxWidth;
            containerColor3 = containerColor;
            contentColor4 = contentColor;
            tonalElevation3 = tonalElevation;
            function2M2123getLambda2$material3_release = function2;
            modifier3 = modifier2;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 32) != 0) {
                    sheetState2 = rememberModalBottomSheetState(false, null, $composer2, 0, 3);
                    $dirty2 &= -3670017;
                } else {
                    sheetState2 = sheetState;
                }
                float sheetMaxWidth4 = i3 != 0 ? BottomSheetDefaults.INSTANCE.m1943getSheetMaxWidthD9Ej5fM() : sheetMaxWidth;
                Modifier modifier5 = modifier4;
                if ((i & 128) != 0) {
                    shape3 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer2, 6);
                    $dirty2 &= -234881025;
                } else {
                    shape3 = shape2;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -1879048193;
                    containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer2, 6);
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 512) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 27) & 14);
                    $dirty3 &= -15;
                } else {
                    contentColor2 = contentColor;
                }
                float tonalElevation4 = i5 != 0 ? BottomSheetDefaults.INSTANCE.m1942getElevationD9Ej5fM() : tonalElevation;
                if (i6 != 0) {
                    $dirty = $dirty2;
                    $dirty1 = $dirty3;
                    tonalElevation2 = tonalElevation4;
                    function2M2123getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m2123getLambda2$material3_release();
                    sheetMaxWidth2 = sheetMaxWidth4;
                    contentColor3 = contentColor2;
                    modifier2 = modifier5;
                    sheetState3 = sheetState2;
                } else {
                    function2M2123getLambda2$material3_release = function2;
                    $dirty = $dirty2;
                    $dirty1 = $dirty3;
                    tonalElevation2 = tonalElevation4;
                    sheetMaxWidth2 = sheetMaxWidth4;
                    contentColor3 = contentColor2;
                    modifier2 = modifier5;
                    sheetState3 = sheetState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i & 512) != 0) {
                    $dirty3 &= -15;
                }
                containerColor2 = containerColor;
                contentColor3 = contentColor;
                function2M2123getLambda2$material3_release = function2;
                $dirty = $dirty2;
                $dirty1 = $dirty3;
                shape3 = shape2;
                sheetState3 = sheetState;
                sheetMaxWidth2 = sheetMaxWidth;
                tonalElevation2 = tonalElevation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235635112, $dirty, $dirty1, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.android.kt:244)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String bottomSheetPaneTitle = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_pane_title), $composer2, 0);
            long contentColor5 = contentColor3;
            sheetMaxWidth3 = sheetMaxWidth2;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m920widthInVpY3zN4$default(modifier2, 0.0f, sheetMaxWidth2, 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1979594358, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            modifier3 = modifier2;
            boolean invalid$iv = (((($dirty & 3670016) ^ 1572864) > 1048576 && $composer2.changed(sheetState3)) || ($dirty & 1572864) == 1048576) | (($dirty & 112) == 32 || (($dirty & 64) != 0 && $composer2.changedInstance(animatable)));
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$1$1
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
                        float sheetOffset = sheetState3.getAnchoredDraggableState$material3_release().getOffset();
                        float sheetHeight = Size.m4115getHeightimpl($this$graphicsLayer.getSize());
                        if (Float.isNaN(sheetOffset) || Float.isNaN(sheetHeight)) {
                            return;
                        }
                        if (!(sheetHeight == 0.0f)) {
                            float progress = animatable.getValue().floatValue();
                            $this$graphicsLayer.setScaleX(ModalBottomSheet_androidKt.calculatePredictiveBackScaleX($this$graphicsLayer, progress));
                            $this$graphicsLayer.setScaleY(ModalBottomSheet_androidKt.calculatePredictiveBackScaleY($this$graphicsLayer, progress));
                            $this$graphicsLayer.mo4465setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (sheetOffset + sheetHeight) / sheetHeight));
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierAlign = $this$ModalBottomSheetContent_u2dNYQaCzI.align(GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxWidth$default, (Function1) value$iv), Alignment.INSTANCE.getTopCenter());
            ComposerKt.sourceInformationMarkerStart($composer2, 1979594994, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(bottomSheetPaneTitle);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$2$1
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
                        SemanticsPropertiesKt.setPaneTitle($this$semantics, bottomSheetPaneTitle);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAlign, false, (Function1) value$iv2, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1979595074, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv3 = ((($dirty & 3670016) ^ 1572864) > 1048576 && $composer2.changed(sheetState3)) || ($dirty & 1572864) == 1048576;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState3, Orientation.Vertical, function1);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierSemantics$default, (NestedScrollConnection) value$iv3, null, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState3.getAnchoredDraggableState$material3_release();
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart($composer2, 1979595522, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv4 = (((3670016 & $dirty) ^ 1572864) > 1048576 && $composer2.changed(sheetState3)) || ($dirty & 1572864) == 1048576;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue>>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$4$1

                    /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue> invoke(IntSize intSize, Constraints constraints) {
                        return m2378invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                    public final Pair<DraggableAnchors<SheetValue>, SheetValue> m2378invokeGpV2Q24(final long sheetSize, long constraints) {
                        SheetValue sheetValue;
                        final float fullHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        final SheetState sheetState5 = sheetState3;
                        DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$4$1$newAnchors$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                invoke2(draggableAnchorsConfig);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                draggableAnchorsConfig.m24at(SheetValue.Hidden, fullHeight);
                                if (IntSize.m6974getHeightimpl(sheetSize) > fullHeight / 2 && !sheetState5.getSkipPartiallyExpanded()) {
                                    draggableAnchorsConfig.m24at(SheetValue.PartiallyExpanded, fullHeight / 2.0f);
                                }
                                if (IntSize.m6974getHeightimpl(sheetSize) != 0) {
                                    draggableAnchorsConfig.m24at(SheetValue.Expanded, Math.max(0.0f, fullHeight - IntSize.m6974getHeightimpl(sheetSize)));
                                }
                            }
                        });
                        switch (WhenMappings.$EnumSwitchMapping$0[sheetState3.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()]) {
                            case 1:
                                sheetValue = SheetValue.Hidden;
                                break;
                            case 2:
                            case 3:
                                boolean hasPartiallyExpandedState = newAnchors.hasAnchorFor(SheetValue.PartiallyExpanded);
                                if (!hasPartiallyExpandedState) {
                                    sheetValue = !newAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Hidden : SheetValue.Expanded;
                                } else {
                                    sheetValue = SheetValue.PartiallyExpanded;
                                }
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        SheetValue newTarget = sheetValue;
                        return TuplesKt.m202to(newAnchors, newTarget);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(modifierNestedScroll$default, anchoredDraggableState$material3_release, orientation, (Function2) value$iv4);
            DraggableState draggableState = sheetState3.getAnchoredDraggableState$material3_release().getDraggableState();
            Orientation orientation2 = Orientation.Vertical;
            boolean zIsVisible = sheetState3.isVisible();
            boolean zIsAnimationRunning = sheetState3.getAnchoredDraggableState$material3_release().isAnimationRunning();
            ComposerKt.sourceInformationMarkerStart($composer2, 1979597058, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv5 = (57344 & $dirty) == 16384;
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new ModalBottomSheet_androidKt$ModalBottomSheetContent$5$1(function1, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function2<? super Composer, ? super Integer, Unit> function4 = function2M2123getLambda2$material3_release;
            final SheetState sheetState5 = sheetState3;
            SurfaceKt.m2666SurfaceT9BRK9s(DraggableKt.draggable(modifierDraggableAnchors, draggableState, orientation2, (188 & 4) != 0 ? true : zIsVisible, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : zIsAnimationRunning, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv5, (188 & 128) != 0 ? false : false), shape3, containerColor2, contentColor5, tonalElevation2, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1798906419, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6
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
                    Object obj;
                    Function0<ComposeUiNode> function5;
                    Composer composer2;
                    int i8;
                    Object obj2;
                    Function0<ComposeUiNode> function6;
                    ComposerKt.sourceInformation(composer, "C316@14441L586,313@14349L2946:ModalBottomSheet.android.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1798906419, i7, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.android.kt:313)");
                        }
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composer, -1513667909, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                        boolean zChangedInstance = composer.changedInstance(animatable);
                        final Animatable<Float, AnimationVector1D> animatable2 = animatable;
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            obj = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$1$1
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
                                    float progress = animatable2.getValue().floatValue();
                                    float predictiveBackScaleX = ModalBottomSheet_androidKt.calculatePredictiveBackScaleX($this$graphicsLayer, progress);
                                    float predictiveBackScaleY = ModalBottomSheet_androidKt.calculatePredictiveBackScaleY($this$graphicsLayer, progress);
                                    $this$graphicsLayer.setScaleY(!((predictiveBackScaleY > 0.0f ? 1 : (predictiveBackScaleY == 0.0f ? 0 : -1)) == 0) ? predictiveBackScaleX / predictiveBackScaleY : 1.0f);
                                    $this$graphicsLayer.mo4465setTransformOrigin__ExYCQ(ModalBottomSheet_androidKt.PredictiveBackChildTransformOrigin);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxWidth$default2, (Function1) obj);
                        Function2<Composer, Integer, Unit> function7 = function4;
                        final SheetState sheetState6 = sheetState5;
                        final Function0<Unit> function8 = function0;
                        final CoroutineScope coroutineScope = scope;
                        Function3<ColumnScope, Composer, Integer, Unit> function9 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i9 = ((((0 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            function5 = constructor;
                            composer.createNode(function5);
                        } else {
                            function5 = constructor;
                            composer.useNode();
                        }
                        Composer composerM3795constructorimpl = Updater.m3795constructorimpl(composer);
                        Updater.m3802setimpl(composerM3795constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl(composerM3795constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM3795constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3795constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM3795constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM3795constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl(composerM3795constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = (i9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        int i11 = ((0 >> 6) & 112) | 6;
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, 1886870591, "C371@17276L9:ModalBottomSheet.android.kt#uh7d8r");
                        composer.startReplaceGroup(1886870591);
                        ComposerKt.sourceInformation(composer, "330@15140L54,331@15236L48,332@15325L47,336@15544L1634,333@15389L1860");
                        if (function7 != null) {
                            Strings.Companion companion2 = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_collapse_description), composer, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo2 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_dismiss_description), composer, 0);
                            Strings.Companion companion4 = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo3 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_expand_description), composer, 0);
                            Modifier modifierAlign2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                            ComposerKt.sourceInformationMarkerStart(composer, 1886871083, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                            boolean zChanged = composer.changed(sheetState6) | composer.changed(strM3086getString2EP1pXo2) | composer.changed(function8) | composer.changed(strM3086getString2EP1pXo3) | composer.changedInstance(coroutineScope) | composer.changed(strM3086getString2EP1pXo);
                            Object objRememberedValue2 = composer.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                i8 = -1323940314;
                                obj2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1
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
                                        final SheetState $this$invoke_u24lambda_u240 = sheetState6;
                                        String str = strM3086getString2EP1pXo2;
                                        String str2 = strM3086getString2EP1pXo3;
                                        String str3 = strM3086getString2EP1pXo;
                                        final Function0<Unit> function10 = function8;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final SheetState sheetState7 = sheetState6;
                                        SemanticsPropertiesKt.dismiss($this$semantics, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                function10.invoke();
                                                return true;
                                            }
                                        });
                                        if ($this$invoke_u24lambda_u240.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                            SemanticsPropertiesKt.expand($this$semantics, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if ($this$invoke_u24lambda_u240.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C14101(sheetState7, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$2$1 */
                                                /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$2$1", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {351}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C14101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C14101(SheetState sheetState, Continuation<? super C14101> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C14101(this.$sheetState, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C14101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                this.label = 1;
                                                                if (this.$sheetState.expand(this) == coroutine_suspended) {
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
                                            });
                                        } else if ($this$invoke_u24lambda_u240.getHasPartiallyExpandedState()) {
                                            SemanticsPropertiesKt.collapse($this$semantics, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if ($this$invoke_u24lambda_u240.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C14111($this$invoke_u24lambda_u240, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$3$1 */
                                                /* JADX INFO: compiled from: ModalBottomSheet.android.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$6$2$1$1$1$3$1", m210f = "ModalBottomSheet.android.kt", m211i = {}, m212l = {361}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C14111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C14111(SheetState sheetState, Continuation<? super C14111> continuation) {
                                                        super(2, continuation);
                                                        this.$this_with = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C14111(this.$this_with, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C14111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                this.label = 1;
                                                                if (this.$this_with.partialExpand(this) == coroutine_suspended) {
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
                                            });
                                        }
                                    }
                                };
                                composer.updateRememberedValue(obj2);
                            } else {
                                obj2 = objRememberedValue2;
                                i8 = -1323940314;
                            }
                            ComposerKt.sourceInformationMarkerEnd(r7);
                            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierAlign2, true, (Function1) obj2);
                            composer2 = composer;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer2, i8, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierSemantics);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int i12 = ((((0 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                function6 = constructor2;
                                composer2.createNode(function6);
                            } else {
                                function6 = constructor2;
                                composer2.useNode();
                            }
                            Composer composerM3795constructorimpl2 = Updater.m3795constructorimpl(composer2);
                            Updater.m3802setimpl(composerM3795constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl(composerM3795constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM3795constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3795constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM3795constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM3795constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m3802setimpl(composerM3795constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i13 = (i12 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i14 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer2, 933286487, "C368@17219L12:ModalBottomSheet.android.kt#uh7d8r");
                            function7.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                        } else {
                            columnScopeInstance = columnScopeInstance;
                            composer2 = composer;
                        }
                        composer2.endReplaceGroup();
                        function9.invoke(columnScopeInstance, composer2, Integer.valueOf(i11 & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 21) & 112) | 12582912 | (($dirty >> 21) & 896) | (($dirty1 << 9) & 7168) | (($dirty1 << 9) & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation3 = tonalElevation2;
            contentColor4 = contentColor5;
            sheetState4 = sheetState3;
            containerColor3 = containerColor2;
            shape4 = shape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final SheetState sheetState6 = sheetState4;
            final float f = sheetMaxWidth3;
            final Shape shape5 = shape4;
            final long j = containerColor3;
            final long j2 = contentColor4;
            final float f2 = tonalElevation3;
            final Function2<? super Composer, ? super Integer, Unit> function5 = function2M2123getLambda2$material3_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetContent$7
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
                    ModalBottomSheet_androidKt.m2375ModalBottomSheetContentNYQaCzI($this$ModalBottomSheetContent_u2dNYQaCzI, animatable, scope, function0, function1, modifier6, sheetState6, f, shape5, j, j2, f2, function5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope $this$calculatePredictiveBackScaleX, float progress) {
        float width = Size.m4118getWidthimpl($this$calculatePredictiveBackScaleX.getSize());
        if (Float.isNaN(width)) {
            return 1.0f;
        }
        if (width == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min($this$calculatePredictiveBackScaleX.mo567toPx0680j_4(PredictiveBackMaxScaleXDistance), width), progress) / width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope $this$calculatePredictiveBackScaleY, float progress) {
        float height = Size.m4115getHeightimpl($this$calculatePredictiveBackScaleY.getSize());
        if (Float.isNaN(height)) {
            return 1.0f;
        }
        if (height == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min($this$calculatePredictiveBackScaleY.mo567toPx0680j_4(PredictiveBackMaxScaleYDistance), height), progress) / height);
    }

    public static final SheetState rememberModalBottomSheetState(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1261794383, "C(rememberModalBottomSheetState)P(1)471@21246L144:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 1) != 0) {
            skipPartiallyExpanded = false;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.rememberModalBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, $changed, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:471)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(skipPartiallyExpanded, function1, SheetValue.Hidden, false, $composer, ($changed & 14) | 384 | ($changed & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m2376Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissSheet;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)484@21550L121,503@22111L62,499@22005L168:ModalBottomSheet.android.kt#uh7d8r");
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
                ComposerKt.traceEventStart(1053897700, $dirty, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:482)");
            }
            if ((color != 16 ? 1 : 0) != 0) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                $composer2.startReplaceGroup(-1858714528);
                ComposerKt.sourceInformation($composer2, "490@21783L124");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1858714444, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    boolean invalid$iv = ($dirty & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    dismissSheet = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$dismissSheet$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        }
                    });
                } else {
                    dismissSheet = Modifier.INSTANCE;
                }
                $composer2.endReplaceGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissSheet);
                ComposerKt.sourceInformationMarkerStart($composer2, -1858714116, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(stateAnimateFloatAsState) | (($dirty & 14) == 4);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$1$1
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
                            DrawScope.CC.m4858drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$10(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$2
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
                    ModalBottomSheet_androidKt.m2376Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$10(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final void ModalBottomSheetPopup(final ModalBottomSheetProperties properties, final Function0<Unit> function0, final Animatable<Float, AnimationVector1D> animatable, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(-1749958412);
        ComposerKt.sourceInformation($composer3, "C(ModalBottomSheetPopup)P(3,1,2,4)521@22563L7,522@22584L38,523@22651L28,524@22706L29,525@22752L24,526@22824L7,527@22865L1029,557@23941L248,557@23900L289:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(properties) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(animatable) : $composer3.changedInstance(animatable) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(windowInsets) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) != 9362 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749958412, $dirty2, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:520)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            View view = (View) objConsume;
            UUID id = (UUID) RememberSaveableKt.m3889rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, $composer3, 3072, 6);
            CompositionContext parentComposition = ComposablesKt.rememberCompositionContext($composer3, 0);
            final State currentContent$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer3, ($dirty2 >> 12) & 14);
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
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 173205423, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object value$iv2 = $composer3.rememberedValue();
            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                ModalBottomSheetWindow $this$ModalBottomSheetPopup_u24lambda_u2415_u24lambda_u2414 = new ModalBottomSheetWindow(properties, function0, view, animatable, scope, id);
                $this$ModalBottomSheetPopup_u24lambda_u2415_u24lambda_u2414.setCustomContent(parentComposition, ComposableLambdaKt.composableLambdaInstance(340361321, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        Modifier.Companion companionImePadding;
                        Function0<ComposeUiNode> function1;
                        ComposerKt.sourceInformation($composer4, "C539@23278L568:ModalBottomSheet.android.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(340361321, $changed2, -1, "androidx.compose.material3.ModalBottomSheetPopup.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:539)");
                            }
                            Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                    SemanticsPropertiesKt.popup($this$semantics);
                                }
                            }, 1, null), windowInsets);
                            if (Build.VERSION.SDK_INT >= 33) {
                                companionImePadding = WindowInsetsPadding_androidKt.imePadding(Modifier.INSTANCE);
                            } else {
                                companionImePadding = Modifier.INSTANCE;
                            }
                            Modifier modifier$iv = modifierWindowInsetsPadding.then(companionImePadding);
                            State<Function2<Composer, Integer, Unit>> state = currentContent$delegate;
                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv = (0 << 3) & 112;
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
                                function1 = constructor;
                                $composer4.createNode(function1);
                            } else {
                                function1 = constructor;
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
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i2 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 321881826, "C550@23808L16:ModalBottomSheet.android.kt#uh7d8r");
                            ModalBottomSheet_androidKt.ModalBottomSheetPopup$lambda$13(state).invoke($composer4, 0);
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
                }));
                value$iv2 = $this$ModalBottomSheetPopup_u24lambda_u2415_u24lambda_u2414;
                $composer3.updateRememberedValue(value$iv2);
            }
            final ModalBottomSheetWindow modalBottomSheetWindow = (ModalBottomSheetWindow) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer2, 173206499, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(modalBottomSheetWindow) | $composer2.changed(layoutDirection);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        modalBottomSheetWindow.show();
                        modalBottomSheetWindow.superSetLayoutDirection(layoutDirection);
                        final ModalBottomSheetWindow modalBottomSheetWindow2 = modalBottomSheetWindow;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                modalBottomSheetWindow2.disposeComposition();
                                modalBottomSheetWindow2.dismiss();
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(modalBottomSheetWindow, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetPopup.2
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
                    ModalBottomSheet_androidKt.ModalBottomSheetPopup(properties, function0, animatable, windowInsets, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$13(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        ViewGroup.LayoutParams layoutParams = $this$isFlagSecureEnabled.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowParams = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (windowParams == null || (windowParams.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy $this$shouldApplySecureFlag, boolean isSecureFlagSetOnParent) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shouldApplySecureFlag.ordinal()]) {
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return isSecureFlagSetOnParent;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

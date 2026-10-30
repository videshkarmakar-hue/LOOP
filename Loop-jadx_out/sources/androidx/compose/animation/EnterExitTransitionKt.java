package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.TransformOrigin;
import androidx.compose.p001ui.graphics.TransformOriginKt;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0000\u001aQ\u0010\u0014\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001aQ\u0010!\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001cH\u0007\u001aQ\u0010%\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u0010\u0017\u001a\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a\"\u0010)\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u0002H\u0007\u001a\"\u0010+\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u0002H\u0007\u001a6\u0010-\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a6\u00102\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aQ\u00106\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001aQ\u00109\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001cH\u0007\u001aQ\u0010;\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\b\b\u0002\u00107\u001a\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2#\b\u0002\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a;\u0010=\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\u001cH\u0007\u001a=\u0010?\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a=\u0010A\u001a\u00020\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a;\u0010C\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\u001cH\u0007\u001a=\u0010E\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010F\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a=\u0010G\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162#\b\u0002\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u001a/\u0010I\u001a\u00020J*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020PH\u0003¢\u0006\u0002\u0010Q\u001a/\u0010R\u001a\u00020S*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\u0010T\u001a\u001f\u0010U\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0002\u001a\u001f\u0010U\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010*\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0002\u001a\f\u0010V\u001a\u00020\"*\u00020\u0018H\u0002\u001a\f\u0010V\u001a\u00020\"*\u00020&H\u0002\u001a\u001f\u0010W\u001a\u00020\f*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\fH\u0001¢\u0006\u0002\u0010X\u001a\u001f\u0010Y\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010N\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010Z\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006[²\u0006\n\u0010\\\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010]\u001a\u00020\u0013X\u008a\u008e\u0002"}, m195d2 = {"DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "EnterTransition", "Landroidx/compose/animation/EnterTransition;", "key", "", "node", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/Modifier$Node;", "ExitTransition", "Landroidx/compose/animation/ExitTransition;", "expandHorizontally", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createModifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "get", "toAlignment", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "animation_release", "activeEnter", "activeExit"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m323invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* JADX INFO: renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m323invoke__ExYCQ(long it) {
            return new AnimationVector2D(TransformOrigin.m4685getPivotFractionXimpl(it), TransformOrigin.m4686getPivotFractionYimpl(it));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m4677boximpl(m324invokeLIALnN8(animationVector2D));
        }

        /* JADX INFO: renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m324invokeLIALnN8(AnimationVector2D it) {
            return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float initialAlpha) {
        return new EnterTransitionImpl(new TransitionData(new Fade(initialAlpha, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float targetAlpha) {
        return new ExitTransitionImpl(new TransitionData(new Fade(targetAlpha, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m320scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
        }
        return m319scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m319scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float initialScale, long transformOrigin) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(initialScale, transformOrigin, finiteAnimationSpec, null), false, null, 55, null));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m322scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
        }
        return m321scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m321scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float targetScale, long transformOrigin) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(targetScale, transformOrigin, finiteAnimationSpec, null), false, null, 55, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandIn.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m6967boximpl(m327invokemzRDjE0(intSize.getPackedValue()));
                }

                /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m327invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment expandFrom, boolean clip, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, function1, finiteAnimationSpec, clip), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkOut.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m6967boximpl(m330invokemzRDjE0(intSize.getPackedValue()));
                }

                /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m330invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment shrinkTowards, boolean clip, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, function1, finiteAnimationSpec, clip), null, false, null, 59, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal expandFrom, boolean clip, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m6967boximpl(m326invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m326invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(function1.invoke(Integer.valueOf(IntSize.m6975getWidthimpl(it))).intValue(), IntSize.m6974getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical expandFrom, boolean clip, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m6967boximpl(m328invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m328invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m6975getWidthimpl(it), function1.invoke(Integer.valueOf(IntSize.m6974getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal shrinkTowards, boolean clip, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m6967boximpl(m329invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m329invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(function1.invoke(Integer.valueOf(IntSize.m6975getWidthimpl(it))).intValue(), IntSize.m6974getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical shrinkTowards, boolean clip, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m6967boximpl(m331invokemzRDjE0(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m331invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m6975getWidthimpl(it), function1.invoke(Integer.valueOf(IntSize.m6974getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m6924boximpl(m332invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m332invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m6975getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m6924boximpl(m333invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m333invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, function1.invoke(Integer.valueOf(IntSize.m6974getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m6924boximpl(m334invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m334invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m6975getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m6924boximpl(m335invokemHKZG7I(intSize.getPackedValue()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m335invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, function1.invoke(Integer.valueOf(IntSize.m6974getHeightimpl(it))).intValue());
            }
        });
    }

    public static final EnterTransition EnterTransition(Object key, ModifierNodeElement<? extends Modifier.Node> modifierNodeElement) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.m202to(key, modifierNodeElement)), 31, null));
    }

    public static final ExitTransition ExitTransition(Object key, ModifierNodeElement<? extends Modifier.Node> modifierNodeElement) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.m202to(key, modifierNodeElement)), 31, null));
    }

    private static final Alignment toAlignment(Alignment.Horizontal $this$toAlignment) {
        if (Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getStart())) {
            return Alignment.INSTANCE.getCenterStart();
        }
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getEnd()) ? Alignment.INSTANCE.getCenterEnd() : Alignment.INSTANCE.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical $this$toAlignment) {
        if (Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getTop())) {
            return Alignment.INSTANCE.getTopCenter();
        }
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getBottom()) ? Alignment.INSTANCE.getBottomCenter() : Alignment.INSTANCE.getCenter();
    }

    public static final ModifierNodeElement<? extends Modifier.Node> get(EnterTransition $this$get, Object key) {
        return $this$get.getData().getEffectsMap().get(key);
    }

    public static final ModifierNodeElement<? extends Modifier.Node> get(ExitTransition $this$get, Object key) {
        return $this$get.getData().getEffectsMap().get(key);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x01ca  */
    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enter, ExitTransition exit, String label, Composer $composer, int $changed) {
        Transition.DeferredAnimation slideAnimation;
        Transition.DeferredAnimation sizeAnimation;
        Transition.DeferredAnimation offsetAnimation;
        boolean z;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        ComposerKt.sourceInformationMarkerStart($composer, 914000546, "C(createModifier)858@37862L31,859@37915L28,884@38887L56:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(914000546, $changed, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:857)");
        }
        EnterTransition activeEnter = trackActiveEnter(transition, enter, $composer, ($changed & 14) | ($changed & 112));
        ExitTransition activeExit = trackActiveExit(transition, exit, $composer, ($changed & 14) | (($changed >> 3) & 112));
        boolean shouldAnimateSlide = (activeEnter.getData().getSlide() == null && activeExit.getData().getSlide() == null) ? false : true;
        boolean shouldAnimateSizeChange = (activeEnter.getData().getChangeSize() == null && activeExit.getData().getChangeSize() == null) ? false : true;
        $composer.startReplaceGroup(1657242374);
        ComposerKt.sourceInformation($composer, "866@38265L27,866@38214L79");
        if (shouldAnimateSlide) {
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            ComposerKt.sourceInformationMarkerStart($composer, 1657242459, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv3 = label + " slide";
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            slideAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) value$iv3, $composer, ($changed & 14) | 384, 0);
        } else {
            slideAnimation = null;
        }
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(1657242544);
        ComposerKt.sourceInformation($composer, "871@38438L35,871@38389L85");
        if (shouldAnimateSizeChange) {
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
            ComposerKt.sourceInformationMarkerStart($composer, 1657242632, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = label + " shrink/expand";
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            sizeAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) value$iv2, $composer, ($changed & 14) | 384, 0);
        } else {
            sizeAnimation = null;
        }
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(1657242712);
        ComposerKt.sourceInformation($composer, "877@38633L48,875@38557L134");
        if (shouldAnimateSizeChange) {
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            ComposerKt.sourceInformationMarkerStart($composer, 1657242827, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = label + " InterruptionHandlingOffset";
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            offsetAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) value$iv, $composer, ($changed & 14) | 384, 0);
        } else {
            offsetAnimation = null;
        }
        $composer.endReplaceGroup();
        ChangeSize changeSize = activeEnter.getData().getChangeSize();
        if ((changeSize == null || changeSize.getClip()) ? false : true) {
            z = true;
        } else {
            ChangeSize changeSize2 = activeExit.getData().getChangeSize();
            if (((changeSize2 == null || changeSize2.getClip()) ? false : true) || !shouldAnimateSizeChange) {
                z = true;
            } else {
                z = false;
            }
        }
        boolean disableClip = z;
        GraphicsLayerBlockForEnterExit graphicsLayerBlock = createGraphicsLayerBlock(transition, activeEnter, activeExit, label, $composer, ($changed & 14) | ($changed & 7168));
        Modifier modifierThen = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, !disableClip, null, 0L, 0L, 0, 126975, null).then(new EnterExitTransitionElement(transition, sizeAnimation, offsetAnimation, slideAnimation, activeEnter, activeExit, graphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifierThen;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enter, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 21614502, "C(trackActiveEnter)901@39738L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, $changed, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:896)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1472945448, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enter, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState activeEnter$delegate = (MutableState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                activeEnter$delegate.setValue(enter);
            } else {
                activeEnter$delegate.setValue(EnterTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            activeEnter$delegate.setValue(trackActiveEnter$lambda$4(activeEnter$delegate).plus(enter));
        }
        EnterTransition enterTransitionTrackActiveEnter$lambda$4 = trackActiveEnter$lambda$4(activeEnter$delegate);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return enterTransitionTrackActiveEnter$lambda$4;
    }

    private static final EnterTransition trackActiveEnter$lambda$4(MutableState<EnterTransition> mutableState) {
        MutableState<EnterTransition> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exit, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1363864804, "C(trackActiveExit)921@40719L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, $changed, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:916)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1476179157, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exit, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState activeExit$delegate = (MutableState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                activeExit$delegate.setValue(exit);
            } else {
                activeExit$delegate.setValue(ExitTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            activeExit$delegate.setValue(trackActiveExit$lambda$7(activeExit$delegate).plus(exit));
        }
        ExitTransition exitTransitionTrackActiveExit$lambda$7 = trackActiveExit$lambda$7(activeExit$delegate);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return exitTransitionTrackActiveExit$lambda$7;
    }

    private static final ExitTransition trackActiveExit$lambda$7(MutableState<ExitTransition> mutableState) {
        MutableState<ExitTransition> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0156  */
    /* JADX WARN: Code duplicated, block: B:57:0x0171  */
    /* JADX WARN: Code duplicated, block: B:67:0x0190  */
    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(final Transition<EnterExitState> transition, final EnterTransition enter, final ExitTransition exit, String label, Composer $composer, int $changed) {
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation;
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2;
        boolean z;
        boolean z2;
        boolean z3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        ComposerKt.sourceInformationMarkerStart($composer, 642253525, "C(createGraphicsLayerBlock)971@42535L2853:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642253525, $changed, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:944)");
        }
        boolean shouldAnimateAlpha = (enter.getData().getFade() == null && exit.getData().getFade() == null) ? false : true;
        boolean shouldAnimateScale = (enter.getData().getScale() == null && exit.getData().getScale() == null) ? false : true;
        $composer.startReplaceGroup(-1158245218);
        ComposerKt.sourceInformation($composer, "954@42049L27,953@41966L120");
        if (shouldAnimateAlpha) {
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart($composer, -1158245101, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv3 = label + " alpha";
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) value$iv3, $composer, ($changed & 14) | 384, 0);
        } else {
            deferredAnimationCreateDeferredAnimation = null;
        }
        $composer.endReplaceGroup();
        final Transition.DeferredAnimation alphaAnimation = deferredAnimationCreateDeferredAnimation;
        $composer.startReplaceGroup(-1158245021);
        ComposerKt.sourceInformation($composer, "960@42246L27,959@42163L120");
        if (shouldAnimateScale) {
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart($composer, -1158244904, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = label + " scale";
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            deferredAnimationCreateDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) value$iv2, $composer, ($changed & 14) | 384, 0);
        } else {
            deferredAnimationCreateDeferredAnimation2 = null;
        }
        $composer.endReplaceGroup();
        final Transition.DeferredAnimation scaleAnimation = deferredAnimationCreateDeferredAnimation2;
        $composer.startReplaceGroup(-1158244814);
        ComposerKt.sourceInformation($composer, "965@42370L136");
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation3 = shouldAnimateScale ? androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, TransformOriginVectorConverter, "TransformOriginInterruptionHandling", $composer, ($changed & 14) | 384, 0) : null;
        $composer.endReplaceGroup();
        final Transition.DeferredAnimation transformOriginAnimation = deferredAnimationCreateDeferredAnimation3;
        ComposerKt.sourceInformationMarkerStart($composer, -1158244615, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean zChangedInstance = $composer.changedInstance(alphaAnimation);
        if ((($changed & 112) ^ 48) > 32 && $composer.changed(enter)) {
            z = true;
        } else if (($changed & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        boolean z4 = zChangedInstance | z;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(exit)) {
            z2 = true;
        } else if (($changed & 384) == 256) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean zChangedInstance2 = z4 | z2 | $composer.changedInstance(scaleAnimation);
        if ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) {
            z3 = true;
        } else if (($changed & 6) == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean invalid$iv = zChangedInstance2 | z3 | $composer.changedInstance(transformOriginAnimation);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv = new GraphicsLayerBlockForEnterExit() { // from class: androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0
                @Override // androidx.compose.animation.GraphicsLayerBlockForEnterExit
                public final Function1 init() {
                    return EnterExitTransitionKt.createGraphicsLayerBlock$lambda$12$lambda$11(alphaAnimation, scaleAnimation, transition, enter, exit, transformOriginAnimation);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv3;
        }
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit = (GraphicsLayerBlockForEnterExit) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return graphicsLayerBlockForEnterExit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 createGraphicsLayerBlock$lambda$12$lambda$11(Transition.DeferredAnimation $alphaAnimation, Transition.DeferredAnimation $scaleAnimation, Transition $this_createGraphicsLayerBlock, final EnterTransition $enter, final ExitTransition $exit, Transition.DeferredAnimation $transformOriginAnimation) {
        final TransformOrigin transformOriginWhenVisible;
        final State alpha = $alphaAnimation != null ? $alphaAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                FiniteAnimationSpec<Float> animationSpec;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Fade fade = $enter.getData().getFade();
                    if (fade == null || (animationSpec2 = fade.getAnimationSpec()) == null) {
                        return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    }
                    return animationSpec2;
                }
                if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                }
                Fade fade2 = $exit.getData().getFade();
                if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                    return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                }
                return animationSpec;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2

            /* JADX INFO: compiled from: EnterExitTransition.kt */
            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
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
            public final Float invoke(EnterExitState it) {
                float alpha2 = 1.0f;
                switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        Fade fade = $enter.getData().getFade();
                        if (fade != null) {
                            alpha2 = fade.getAlpha();
                        }
                        break;
                    case 3:
                        Fade fade2 = $exit.getData().getFade();
                        if (fade2 != null) {
                            alpha2 = fade2.getAlpha();
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return Float.valueOf(alpha2);
            }
        }) : null;
        final State scale = $scaleAnimation != null ? $scaleAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                FiniteAnimationSpec<Float> animationSpec;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Scale scale2 = $enter.getData().getScale();
                    if (scale2 == null || (animationSpec2 = scale2.getAnimationSpec()) == null) {
                        return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    }
                    return animationSpec2;
                }
                if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                }
                Scale scale3 = $exit.getData().getScale();
                if (scale3 == null || (animationSpec = scale3.getAnimationSpec()) == null) {
                    return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                }
                return animationSpec;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2

            /* JADX INFO: compiled from: EnterExitTransition.kt */
            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
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
            public final Float invoke(EnterExitState it) {
                float scale2 = 1.0f;
                switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        Scale scale3 = $enter.getData().getScale();
                        if (scale3 != null) {
                            scale2 = scale3.getScale();
                        }
                        break;
                    case 3:
                        Scale scale4 = $exit.getData().getScale();
                        if (scale4 != null) {
                            scale2 = scale4.getScale();
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return Float.valueOf(scale2);
            }
        }) : null;
        if ($this_createGraphicsLayerBlock.getCurrentState() == EnterExitState.PreEnter) {
            Scale scale2 = $enter.getData().getScale();
            transformOriginWhenVisible = (scale2 == null && (scale2 = $exit.getData().getScale()) == null) ? null : TransformOrigin.m4677boximpl(scale2.m348getTransformOriginSzJe1aQ());
        } else {
            Scale scale3 = $exit.getData().getScale();
            transformOriginWhenVisible = (scale3 == null && (scale3 = $enter.getData().getScale()) == null) ? null : TransformOrigin.m4677boximpl(scale3.m348getTransformOriginSzJe1aQ());
        }
        final State transformOrigin = $transformOriginAnimation != null ? $transformOriginAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment) {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        }, new Function1<EnterExitState, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2

            /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2$WhenMappings */
            /* JADX INFO: compiled from: EnterExitTransition.kt */
            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
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
            public /* bridge */ /* synthetic */ TransformOrigin invoke(EnterExitState enterExitState) {
                return TransformOrigin.m4677boximpl(m325invokeLIALnN8(enterExitState));
            }

            /* JADX INFO: renamed from: invoke-LIALnN8, reason: not valid java name */
            public final long m325invokeLIALnN8(EnterExitState it) {
                TransformOrigin transformOriginM4677boximpl = null;
                switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                        transformOriginM4677boximpl = transformOriginWhenVisible;
                        break;
                    case 2:
                        Scale scale4 = $enter.getData().getScale();
                        if (scale4 != null || (scale4 = $exit.getData().getScale()) != null) {
                            transformOriginM4677boximpl = TransformOrigin.m4677boximpl(scale4.m348getTransformOriginSzJe1aQ());
                        }
                        break;
                    case 3:
                        Scale scale5 = $exit.getData().getScale();
                        if (scale5 != null || (scale5 = $enter.getData().getScale()) != null) {
                            transformOriginM4677boximpl = TransformOrigin.m4677boximpl(scale5.m348getTransformOriginSzJe1aQ());
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return transformOriginM4677boximpl != null ? transformOriginM4677boximpl.getPackedValue() : TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ();
            }
        }) : null;
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
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
            public final void invoke2(GraphicsLayerScope $this$null) {
                State<Float> state = alpha;
                $this$null.setAlpha(state != null ? state.getValue().floatValue() : 1.0f);
                State<Float> state2 = scale;
                $this$null.setScaleX(state2 != null ? state2.getValue().floatValue() : 1.0f);
                State<Float> state3 = scale;
                $this$null.setScaleY(state3 != null ? state3.getValue().floatValue() : 1.0f);
                State<TransformOrigin> state4 = transformOrigin;
                $this$null.mo4465setTransformOrigin__ExYCQ(state4 != null ? state4.getValue().getPackedValue() : TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ());
            }
        };
    }
}

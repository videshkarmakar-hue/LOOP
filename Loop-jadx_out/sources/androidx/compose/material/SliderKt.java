package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ShadowKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.PointMode;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventKt;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0003\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001ak\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a\u007f\u00104\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0003\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u00010/2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00106\u001aK\u00107\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u00105\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00109\u001aS\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0003¢\u0006\u0002\u0010=\u001a.\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010D\u001a \u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a0\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a<\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a.\u0010P\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010!\u001a\u00020\"H\u0002\u001aF\u0010T\u001a\u00020\u0012*\u00020U2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00032\u0006\u00105\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a5\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\b\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\u0098\u0001\u0010d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010R\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140f2\u001e\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120k0fH\u0002\u001a\\\u0010l\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001aj\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u00105\u001a\u00020/2\u0006\u0010R\u001a\u00020\b2\u0006\u0010h\u001a\u00020 2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140f2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p"}, m195d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", DownloadUtil.CookieScheme.VALUE, "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SliderKt {
    private static final float ThumbRadius = C1979Dp.m6801constructorimpl(10);
    private static final float ThumbRippleRadius = C1979Dp.m6801constructorimpl(24);
    private static final float ThumbDefaultElevation = C1979Dp.m6801constructorimpl(1);
    private static final float ThumbPressedElevation = C1979Dp.m6801constructorimpl(6);
    private static final float TrackHeight = C1979Dp.m6801constructorimpl(4);
    private static final float SliderHeight = C1979Dp.m6801constructorimpl(48);
    private static final float SliderMinWidth = C1979Dp.m6801constructorimpl(144);
    private static final Modifier DefaultSliderConstraints = SizeKt.m901heightInVpY3zN4$default(SizeKt.m920widthInVpY3zN4$default(Modifier.INSTANCE, SliderMinWidth, 0.0f, 2, null), 0.0f, SliderHeight, 1, null);
    private static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);

    public static final void Slider(final float value, final Function1<? super Float, Unit> function1, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, MutableInteractionSource interactionSource, SliderColors colors, Composer $composer, final int $changed, final int i) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i2;
        Function0<Unit> function2;
        Modifier.Companion modifier2;
        boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int steps2;
        Function0<Unit> function3;
        MutableInteractionSource interactionSource2;
        SliderColors colors2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        Object value$iv;
        Modifier modifier3;
        boolean enabled3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int steps3;
        Function0<Unit> function4;
        SliderColors colors3;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1962335196);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(7,4,3,1,8,6,5,2)158@7585L8,163@7799L35,164@7859L59,180@8361L3006,167@7923L3444:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                int i5 = $composer2.changed(closedFloatingPointRange2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            $dirty |= i5;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            i2 = steps;
        } else if ((196608 & $changed) == 0) {
            i2 = steps;
            $dirty |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
            function2 = function0;
        } else if (($changed & 1572864) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = function0;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            interactionSource3 = interactionSource;
            colors3 = colors;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            function4 = function2;
            steps3 = i2;
            enabled3 = enabled;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i3 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i4 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                steps2 = i6 != 0 ? 0 : i2;
                function3 = i7 != 0 ? null : function2;
                interactionSource2 = i8 != 0 ? null : interactionSource;
                if ((i & 256) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1785colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                    $dirty &= -234881025;
                } else {
                    colors2 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    $dirty &= -234881025;
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    function3 = function2;
                    steps2 = i2;
                    interactionSource2 = interactionSource;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    colors2 = colors;
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    function3 = function2;
                    steps2 = i2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962335196, $dirty, -1, "androidx.compose.material.Slider (Slider.kt:159)");
            }
            $composer2.startReplaceGroup(1510868611);
            ComposerKt.sourceInformation($composer2, "161@7679L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1510868632, "CC(remember):Slider.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource4 = mutableInteractionSource;
            if (!(steps2 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State onValueChangeState = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1510868812, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty) == 131072;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv = stepsToTickFractions(steps2);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            List tickFractions = (List) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
            float arg0$iv = ThumbRadius;
            modifier3 = modifier2;
            float fM6801constructorimpl = C1979Dp.m6801constructorimpl(2 * arg0$iv);
            float arg0$iv2 = ThumbRadius;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m909requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, fM6801constructorimpl, C1979Dp.m6801constructorimpl(2 * arg0$iv2), 0.0f, 0.0f, 12, null), value, enabled2, function1, function3, closedFloatingPointRangeRangeTo, steps2), enabled2, interactionSource4), null, false, ComposableLambdaKt.rememberComposableLambda(2085116814, true, new C10902(closedFloatingPointRangeRangeTo, value, tickFractions, function3, interactionSource4, enabled2, colors2, onValueChangeState), $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enabled3 = enabled2;
            closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
            steps3 = steps2;
            function4 = function3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z = enabled3;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
            final int i9 = steps3;
            final Function0<Unit> function5 = function4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            final SliderColors sliderColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Slider.3
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

                public final void invoke(Composer composer, int i10) {
                    SliderKt.Slider(value, function1, modifier4, z, closedFloatingPointRange4, i9, function5, mutableInteractionSource2, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$2 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C10902 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10902(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, List<Float> list, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, boolean z, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$value = f;
            this.$tickFractions = list;
            this.$onValueChangeFinished = function0;
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z;
            this.$colors = sliderColors;
            this.$onValueChangeState = state;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
            Object value$iv$iv;
            Object value$iv;
            Object value$iv2;
            Object value$iv3;
            SliderKt$Slider$2$2$1 value$iv4;
            Object value$iv5;
            SliderKt$Slider$2$drag$1$1 value$iv6;
            ComposerKt.sourceInformation($composer, "C181@8404L7,*186@8565L7,197@8979L24,198@9028L54,199@9109L36,201@9176L392,210@9601L15,210@9578L83,212@9732L585,212@9694L623,241@10811L55,248@11152L209:Slider.kt#jmzs0o");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085116814, $dirty2, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:181)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean isRtl = objConsume == LayoutDirection.Rtl;
            float widthPx = Constraints.m6744getMaxWidthimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk());
            final Ref.FloatRef maxPx = new Ref.FloatRef();
            final Ref.FloatRef minPx = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
            maxPx.element = Math.max(widthPx - $this$invoke_u24lambda_u240.mo567toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
            minPx.element = Math.min($this$invoke_u24lambda_u240.mo567toPx0680j_4(SliderKt.getThumbRadius()), maxPx.element);
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1313345410, "CC(remember):Slider.kt#9igjgp");
            float f = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange, minPx, maxPx, f));
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableFloatState rawOffset = (MutableFloatState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1313345329, "CC(remember):Slider.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableFloatState pressOffset = (MutableFloatState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1313345262, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = $composer.changed(minPx.element) | $composer.changed(maxPx.element) | $composer.changed(this.$valueRange);
            final State<Function1<Float, Unit>> state = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$2$draggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                        invoke(f2.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float it) {
                        rawOffset.setFloatValue(rawOffset.getFloatValue() + it + pressOffset.getFloatValue());
                        pressOffset.setFloatValue(0.0f);
                        float offsetInTrack = RangesKt.coerceIn(rawOffset.getFloatValue(), minPx.element, maxPx.element);
                        state.getValue().invoke(Float.valueOf(SliderKt.C10902.invoke$scaleToUserValue(minPx, maxPx, closedFloatingPointRange2, offsetInTrack)));
                    }
                });
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final SliderDraggableState draggableState = (SliderDraggableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1313344837, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(this.$valueRange) | $composer.changed(minPx.element) | $composer.changed(maxPx.element);
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$valueRange;
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new SliderKt$Slider$2$2$1(closedFloatingPointRange3, minPx, maxPx);
                $composer.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SliderKt.CorrectValueSideEffect((Function1) ((KFunction) value$iv4), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffset, this.$value, $composer, 3072);
            ComposerKt.sourceInformationMarkerStart($composer, -1313344706, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(this.$tickFractions) | $composer.changed(minPx.element) | $composer.changed(maxPx.element) | $composer.changedInstance(scope) | $composer.changedInstance(draggableState) | $composer.changed(this.$onValueChangeFinished);
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                        invoke(f2.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float velocity) {
                        Function0<Unit> function1;
                        float current = rawOffset.getFloatValue();
                        float target = SliderKt.snapValueToTick(current, list, minPx.element, maxPx.element);
                        if (!(current == target)) {
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C10911(draggableState, current, target, velocity, function0, null), 3, null);
                        } else {
                            if (draggableState.isDragging() || (function1 = function0) == null) {
                                return;
                            }
                            function1.invoke();
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1$1 */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1$1", m210f = "Slider.kt", m211i = {}, m212l = {218}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C10911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $current;
                        final /* synthetic */ SliderDraggableState $draggableState;
                        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                        final /* synthetic */ float $target;
                        final /* synthetic */ float $velocity;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C10911(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super C10911> continuation) {
                            super(2, continuation);
                            this.$draggableState = sliderDraggableState;
                            this.$current = f;
                            this.$target = f2;
                            this.$velocity = f3;
                            this.$onValueChangeFinished = function0;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C10911(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C10911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            C10911 c10911;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (SliderKt.animateToTarget(this.$draggableState, this.$current, this.$target, this.$velocity, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    c10911 = this;
                                    break;
                                    break;
                                case 1:
                                    c10911 = this;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Function0<Unit> function0 = c10911.$onValueChangeFinished;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }
                };
                $composer.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            State gestureEndAction = SnapshotStateKt.rememberUpdatedState((Function1) value$iv5, $composer, 0);
            Modifier press = SliderKt.sliderTapModifier(Modifier.INSTANCE, draggableState, this.$interactionSource, widthPx, isRtl, rawOffset, gestureEndAction, pressOffset, this.$enabled);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = draggableState.isDragging();
            Modifier.Companion companion2 = companion;
            SliderDraggableState sliderDraggableState = draggableState;
            boolean z = this.$enabled;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            ComposerKt.sourceInformationMarkerStart($composer, -1313343627, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed(gestureEndAction);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = new SliderKt$Slider$2$drag$1$1(gestureEndAction, null);
                $composer.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier drag = DraggableKt.draggable(companion2, sliderDraggableState, orientation, (188 & 4) != 0 ? true : z, (188 & 8) != 0 ? null : mutableInteractionSource, (188 & 16) != 0 ? false : zIsDragging, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv6, (188 & 128) != 0 ? false : isRtl);
            float coerced = RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            float fraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerced);
            SliderKt.SliderImpl(this.$enabled, fraction, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$interactionSource, press.then(drag), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, float offset) {
            return SliderKt.scale(minPx.element, maxPx.element, offset, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
        }
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int steps, Function0<Unit> function0, SliderColors colors, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i2;
        Function0<Unit> function2;
        Modifier.Companion modifier2;
        int steps2;
        Function0<Unit> function3;
        int $dirty;
        SliderColors colors2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Modifier modifier3;
        SliderColors colors3;
        int steps3;
        Function0<Unit> function4;
        boolean enabled3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Composer $composer2 = $composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation($composer2, "C(RangeSlider)P(6,3,2,1,7,5,4)304@13704L8,306@13776L39,307@13873L39,310@13994L35,311@14054L59,319@14305L4956,315@14119L5142:Slider.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(closedFloatingPointRange) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                int i5 = $composer2.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
            }
            $dirty2 |= i5;
        } else {
            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            i2 = steps;
        } else if ((196608 & $changed) == 0) {
            i2 = steps;
            $dirty2 |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            function2 = function0;
        } else if (($changed & 1572864) == 0) {
            function2 = function0;
            $dirty2 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = function0;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            colors3 = colors;
            enabled3 = enabled2;
            function4 = function2;
            steps3 = i2;
            closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i3 != 0 ? Modifier.INSTANCE : modifier;
                if (i4 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                steps2 = i6 != 0 ? 0 : i2;
                function3 = i7 != 0 ? null : function2;
                if ((i & 128) != 0) {
                    $dirty = $dirty2 & (-29360129);
                    colors2 = SliderDefaults.INSTANCE.m1785colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                } else {
                    $dirty = $dirty2;
                    colors2 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    int i8 = $dirty2 & (-29360129);
                    colors2 = colors;
                    $dirty = i8;
                    steps2 = i2;
                    function3 = function2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    steps2 = i2;
                    function3 = function2;
                    colors2 = colors;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, $dirty, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 982567928, "CC(remember):Slider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 982568025, "CC(remember):Slider.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (!(steps2 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State onValueChangeState = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 982568206, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty) == 131072;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = stepsToTickFractions(steps2);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            List tickFractions = (List) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
            float arg0$iv = ThumbRadius;
            modifier3 = modifier2;
            float fM6801constructorimpl = C1979Dp.m6801constructorimpl(4 * arg0$iv);
            float arg0$iv2 = ThumbRadius;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m909requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, fM6801constructorimpl, C1979Dp.m6801constructorimpl(2 * arg0$iv2), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.rememberComposableLambda(652589923, true, new C10862(closedFloatingPointRangeRangeTo, closedFloatingPointRange, tickFractions, function3, onValueChangeState, startInteractionSource, endInteractionSource, enabled2, steps2, colors2), $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            steps3 = steps2;
            function4 = function3;
            enabled3 = enabled2;
            closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z = enabled3;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
            final int i9 = steps3;
            final Function0<Unit> function5 = function4;
            final SliderColors sliderColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.3
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

                public final void invoke(Composer composer, int i10) {
                    SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier4, z, closedFloatingPointRange4, i9, function5, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C10862 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ ClosedFloatingPointRange<Float> $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10862(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, List<Float> list, Function0<Unit> function0, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i, SliderColors sliderColors) {
            super(3);
            this.$valueRange = closedFloatingPointRange;
            this.$value = closedFloatingPointRange2;
            this.$tickFractions = list;
            this.$onValueChangeFinished = function0;
            this.$onValueChangeState = state;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z;
            this.$steps = i;
            this.$colors = sliderColors;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
            Object value$iv;
            Object value$iv2;
            Object value$iv3;
            Object value$iv4;
            Object value$iv$iv;
            Object value$iv5;
            Object value$iv6;
            Object value$iv7;
            Object value$iv8;
            ComposerKt.sourceInformation($composer, "C320@14348L7,*325@14509L7,336@14937L60,337@15025L67,340@15138L15,339@15102L164,347@15311L15,346@15275L169,354@15466L24,355@15562L924,355@15522L964,379@16556L857,379@16509L904,421@18432L63,429@18722L65,435@18915L340:Slider.kt#jmzs0o");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(652589923, $dirty2, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:320)");
                }
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                boolean isRtl = objConsume == LayoutDirection.Rtl;
                float widthPx = Constraints.m6744getMaxWidthimpl($this$BoxWithConstraints.mo774getConstraintsmsEJaDk());
                final Ref.FloatRef maxPx = new Ref.FloatRef();
                final Ref.FloatRef minPx = new Ref.FloatRef();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                maxPx.element = widthPx - $this$invoke_u24lambda_u240.mo567toPx0680j_4(SliderKt.getThumbRadius());
                minPx.element = $this$invoke_u24lambda_u240.mo567toPx0680j_4(SliderKt.getThumbRadius());
                ComposerKt.sourceInformationMarkerStart($composer, -1513105758, "CC(remember):Slider.kt#9igjgp");
                ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
                ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange2, minPx, maxPx, closedFloatingPointRange.getStart().floatValue()));
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableFloatState rawOffsetStart = (MutableFloatState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1513105670, "CC(remember):Slider.kt#9igjgp");
                ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
                ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(closedFloatingPointRange4, minPx, maxPx, closedFloatingPointRange3.getEndInclusive().floatValue()));
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                final MutableFloatState rawOffsetEnd = (MutableFloatState) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1513105557, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv = $composer.changed(this.$valueRange) | $composer.changed(minPx.element) | $composer.changed(maxPx.element);
                ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange5, minPx, maxPx);
                    $composer.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SliderKt.CorrectValueSideEffect((Function1) ((KFunction) value$iv3), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffsetStart, this.$value.getStart().floatValue(), $composer, 3072);
                ComposerKt.sourceInformationMarkerStart($composer, -1513105384, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(this.$valueRange) | $composer.changed(minPx.element) | $composer.changed(maxPx.element);
                ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange6, minPx, maxPx);
                    $composer.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SliderKt.CorrectValueSideEffect((Function1) ((KFunction) value$iv4), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffsetEnd, this.$value.getEndInclusive().floatValue(), $composer, 3072);
                ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1513105133, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance(this.$tickFractions) | $composer.changed(minPx.element) | $composer.changed(maxPx.element) | $composer.changed(this.$onValueChangeFinished) | $composer.changedInstance(scope) | $composer.changed(this.$onValueChangeState) | $composer.changed(this.$valueRange);
                final List<Float> list = this.$tickFractions;
                final Function0<Unit> function0 = this.$onValueChangeFinished;
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$valueRange;
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean isStart) {
                            float current = (isStart ? rawOffsetStart : rawOffsetEnd).getFloatValue();
                            float target = SliderKt.snapValueToTick(current, list, minPx.element, maxPx.element);
                            if (!(current == target)) {
                                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C10871(current, target, function0, isStart, rawOffsetStart, rawOffsetEnd, state, minPx, maxPx, closedFloatingPointRange7, null), 3, null);
                                return;
                            }
                            Function0<Unit> function1 = function0;
                            if (function1 != null) {
                                function1.invoke();
                            }
                        }

                        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1 */
                        /* JADX INFO: compiled from: Slider.kt */
                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(m209c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1", m210f = "Slider.kt", m211i = {}, m212l = {366}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                        static final class C10871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ float $current;
                            final /* synthetic */ boolean $isStart;
                            final /* synthetic */ Ref.FloatRef $maxPx;
                            final /* synthetic */ Ref.FloatRef $minPx;
                            final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                            final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                            final /* synthetic */ MutableFloatState $rawOffsetEnd;
                            final /* synthetic */ MutableFloatState $rawOffsetStart;
                            final /* synthetic */ float $target;
                            final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            C10871(float f, float f2, Function0<Unit> function0, boolean z, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super C10871> continuation) {
                                super(2, continuation);
                                this.$current = f;
                                this.$target = f2;
                                this.$onValueChangeFinished = function0;
                                this.$isStart = z;
                                this.$rawOffsetStart = mutableFloatState;
                                this.$rawOffsetEnd = mutableFloatState2;
                                this.$onValueChangeState = state;
                                this.$minPx = floatRef;
                                this.$maxPx = floatRef2;
                                this.$valueRange = closedFloatingPointRange;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C10871(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C10871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                C10871 c10871;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                                        Float fBoxFloat = Boxing.boxFloat(this.$target);
                                        TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                                        Float fBoxFloat2 = Boxing.boxFloat(0.0f);
                                        final boolean z = this.$isStart;
                                        final MutableFloatState mutableFloatState = this.$rawOffsetStart;
                                        final MutableFloatState mutableFloatState2 = this.$rawOffsetEnd;
                                        final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                                        final Ref.FloatRef floatRef = this.$minPx;
                                        final Ref.FloatRef floatRef2 = this.$maxPx;
                                        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                                        this.label = 1;
                                        if (animatableAnimatable$default.animateTo(fBoxFloat, tweenSpec, fBoxFloat2, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                                                invoke2(animatable);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                                                (z ? mutableFloatState : mutableFloatState2).setFloatValue(animatable.getValue().floatValue());
                                                state.getValue().invoke(SliderKt.C10862.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.rangeTo(mutableFloatState.getFloatValue(), mutableFloatState2.getFloatValue())));
                                            }
                                        }, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c10871 = this;
                                        break;
                                        break;
                                    case 1:
                                        c10871 = this;
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Function0<Unit> function0 = c10871.$onValueChangeFinished;
                                if (function0 != null) {
                                    function0.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                State gestureEndAction = SnapshotStateKt.rememberUpdatedState((Function1) value$iv5, $composer, 0);
                ComposerKt.sourceInformationMarkerStart($composer, -1513104139, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv4 = $composer.changed(this.$valueRange) | $composer.changed(minPx.element) | $composer.changed(maxPx.element) | $composer.changed(this.$value) | $composer.changed(this.$onValueChangeState);
                final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = this.$value;
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
                final ClosedFloatingPointRange<Float> closedFloatingPointRange9 = this.$valueRange;
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f) {
                            invoke(bool.booleanValue(), f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean isStart, float offset) {
                            ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
                            if (isStart) {
                                rawOffsetStart.setFloatValue(rawOffsetStart.getFloatValue() + offset);
                                rawOffsetEnd.setFloatValue(SliderKt.C10862.invoke$scaleToOffset(closedFloatingPointRange9, minPx, maxPx, closedFloatingPointRange8.getEndInclusive().floatValue()));
                                float offsetEnd = rawOffsetEnd.getFloatValue();
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(RangesKt.coerceIn(rawOffsetStart.getFloatValue(), minPx.element, offsetEnd), offsetEnd);
                            } else {
                                rawOffsetEnd.setFloatValue(rawOffsetEnd.getFloatValue() + offset);
                                rawOffsetStart.setFloatValue(SliderKt.C10862.invoke$scaleToOffset(closedFloatingPointRange9, minPx, maxPx, closedFloatingPointRange8.getStart().floatValue()));
                                float offsetStart = rawOffsetStart.getFloatValue();
                                closedFloatingPointRangeRangeTo = RangesKt.rangeTo(offsetStart, RangesKt.coerceIn(rawOffsetEnd.getFloatValue(), offsetStart, maxPx.element));
                            }
                            state2.getValue().invoke(SliderKt.C10862.invoke$scaleToUserValue(minPx, maxPx, closedFloatingPointRange9, closedFloatingPointRangeRangeTo));
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                State onDrag = SnapshotStateKt.rememberUpdatedState((Function2) value$iv6, $composer, 0);
                Modifier pressDrag = SliderKt.rangeSliderPressDragModifier(Modifier.INSTANCE, this.$startInteractionSource, this.$endInteractionSource, rawOffsetStart, rawOffsetEnd, this.$enabled, isRtl, widthPx, this.$valueRange, gestureEndAction, onDrag);
                final float coercedStart = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
                final float coercedEnd = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                float fractionStart = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedStart);
                float fractionEnd = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedEnd);
                int startSteps = (int) Math.floor(this.$steps * fractionEnd);
                int endSteps = (int) Math.floor(this.$steps * (1.0f - fractionStart));
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean z = this.$enabled;
                ComposerKt.sourceInformationMarkerStart($composer, -1513102263, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv5 = $composer.changed(this.$onValueChangeState) | $composer.changed(coercedEnd);
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv5 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value) {
                            state3.getValue().invoke(RangesKt.rangeTo(value, coercedEnd));
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier startThumbSemantics = SliderKt.sliderSemantics(companion, coercedStart, z, (Function1) value$iv7, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), coercedEnd), startSteps);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean z2 = this.$enabled;
                ComposerKt.sourceInformationMarkerStart($composer, -1513101973, "CC(remember):Slider.kt#9igjgp");
                boolean invalid$iv6 = $composer.changed(this.$onValueChangeState) | $composer.changed(coercedStart);
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state4 = this.$onValueChangeState;
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv6 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value) {
                            state4.getValue().invoke(RangesKt.rangeTo(coercedStart, value));
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier endThumbSemantics = SliderKt.sliderSemantics(companion2, coercedEnd, z2, (Function1) value$iv8, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart, this.$valueRange.getEndInclusive().floatValue()), endSteps);
                SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, 14155776, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
            return SliderKt.scale(minPx.element, maxPx.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
            return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:81:0x02aa  */
    public static final void SliderImpl(final boolean enabled, final float positionFraction, final List<Float> list, final SliderColors colors, final float width, final MutableInteractionSource interactionSource, final Modifier modifier, Composer $composer, final int $changed) {
        CompositionLocalMap localMap$iv$iv;
        MeasurePolicy measurePolicy$iv;
        Composer $composer2 = $composer.startRestartGroup(1679682785);
        ComposerKt.sourceInformation($composer2, "C(SliderImpl)P(1,4,5!1,6)593@25080L712:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(positionFraction) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(width) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(modifier) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599187 & $dirty2) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1679682785, $dirty2, -1, "androidx.compose.material.SliderImpl (Slider.kt:592)");
            }
            Modifier modifier$iv = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv = localMap$iv$iv2;
                measurePolicy$iv = measurePolicy$iv2;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                measurePolicy$iv = measurePolicy$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope $this$SliderImpl_u24lambda_u248 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 618024105, "C*597@25240L7,606@25485L216,616@25710L76:Slider.kt#jmzs0o");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$SliderImpl_u24lambda_u248_u24lambda_u247 = (Density) objConsume;
                float trackStrokeWidth = $this$SliderImpl_u24lambda_u248_u24lambda_u247.mo567toPx0680j_4(TrackHeight);
                float thumbPx = $this$SliderImpl_u24lambda_u248_u24lambda_u247.mo567toPx0680j_4(ThumbRadius);
                float widthDp = $this$SliderImpl_u24lambda_u248_u24lambda_u247.mo563toDpu2uoSUM(width);
                float arg0$iv = ThumbRadius;
                float thumbSize = C1979Dp.m6801constructorimpl(2 * arg0$iv);
                float offset = C1979Dp.m6801constructorimpl(widthDp * positionFraction);
                Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colors, enabled, 0.0f, positionFraction, list, thumbPx, trackStrokeWidth, $composer2, (($dirty2 >> 6) & 112) | 3078 | (($dirty2 << 6) & 896) | (($dirty2 << 9) & 57344) | (($dirty2 << 9) & 458752));
                m1786SliderThumbPcYyNuk($this$SliderImpl_u24lambda_u248, Modifier.INSTANCE, offset, interactionSource, colors, enabled, thumbSize, $composer2, ((((0 >> 6) & 112) | 6) & 14) | 1572912 | (($dirty2 >> 6) & 7168) | (($dirty2 << 3) & 57344) | (($dirty2 << 15) & 458752));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope $this$SliderImpl_u24lambda_u249 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 618024105, "C*597@25240L7,606@25485L216,616@25710L76:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$SliderImpl_u24lambda_u248_u24lambda_u248 = (Density) objConsume2;
            float trackStrokeWidth2 = $this$SliderImpl_u24lambda_u248_u24lambda_u248.mo567toPx0680j_4(TrackHeight);
            float thumbPx2 = $this$SliderImpl_u24lambda_u248_u24lambda_u248.mo567toPx0680j_4(ThumbRadius);
            float widthDp2 = $this$SliderImpl_u24lambda_u248_u24lambda_u248.mo563toDpu2uoSUM(width);
            float arg0$iv2 = ThumbRadius;
            float thumbSize2 = C1979Dp.m6801constructorimpl(2 * arg0$iv2);
            float offset2 = C1979Dp.m6801constructorimpl(widthDp2 * positionFraction);
            Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colors, enabled, 0.0f, positionFraction, list, thumbPx2, trackStrokeWidth2, $composer2, (($dirty2 >> 6) & 112) | 3078 | (($dirty2 << 6) & 896) | (($dirty2 << 9) & 57344) | (($dirty2 << 9) & 458752));
            m1786SliderThumbPcYyNuk($this$SliderImpl_u24lambda_u249, Modifier.INSTANCE, offset2, interactionSource, colors, enabled, thumbSize2, $composer2, ((((0 >> 6) & 112) | 6) & 14) | 1572912 | (($dirty2 >> 6) & 7168) | (($dirty2 << 3) & 57344) | (($dirty2 << 15) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.SliderImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    SliderKt.SliderImpl(enabled, positionFraction, list, colors, width, interactionSource, modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:114:0x033d  */
    /* JADX WARN: Code duplicated, block: B:121:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:124:0x040b  */
    public static final void RangeSliderImpl(final boolean enabled, final float positionFractionStart, final float positionFractionEnd, final List<Float> list, final SliderColors colors, final float width, final MutableInteractionSource startInteractionSource, final MutableInteractionSource endInteractionSource, final Modifier modifier, final Modifier startThumbSemantics, final Modifier endThumbSemantics, Composer $composer, final int $changed, final int $changed1) {
        Function0<ComposeUiNode> function0;
        CompositionLocalMap localMap$iv$iv;
        Modifier modifier$iv;
        Composer $composer2;
        boolean invalid$iv;
        Object value$iv;
        boolean invalid$iv2;
        Object value$iv2;
        Composer $composer3 = $composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation($composer3, "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)635@26237L35,636@26305L33,637@26343L1522:Slider.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(positionFractionStart) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(positionFractionEnd) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(colors) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(width) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(startInteractionSource) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(endInteractionSource) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(modifier) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(startThumbSemantics) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(endThumbSemantics) ? 4 : 2;
        }
        if (($dirty & 306783379) != 306783378 || ($dirty1 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278895713, $dirty, $dirty1, "androidx.compose.material.RangeSliderImpl (Slider.kt:633)");
            }
            final String startContentDescription = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1807getSliderRangeStartUdPEhr4(), $composer3, 6);
            final String endContentDescription = Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1806getSliderRangeEndUdPEhr4(), $composer3, 6);
            Modifier modifier$iv2 = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv = localMap$iv$iv2;
                modifier$iv = modifier$iv2;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                modifier$iv = modifier$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int $changed2 = ((0 >> 6) & 112) | 6;
                BoxScope $this$RangeSliderImpl_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1690173145, "C*641@26503L7,650@26811L301,665@27208L48,663@27122L369,676@27586L46,674@27500L359:Slider.kt#jmzs0o");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u249 = (Density) objConsume;
                float trackStrokeWidth = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u249.mo567toPx0680j_4(TrackHeight);
                float thumbPx = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u249.mo567toPx0680j_4(ThumbRadius);
                float widthDp = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u249.mo563toDpu2uoSUM(width);
                float arg0$iv = ThumbRadius;
                float thumbSize = C1979Dp.m6801constructorimpl(2 * arg0$iv);
                float offsetStart = C1979Dp.m6801constructorimpl(widthDp * positionFractionStart);
                float offsetEnd = C1979Dp.m6801constructorimpl(widthDp * positionFractionEnd);
                int $dirty2 = $dirty;
                $composer2 = $composer3;
                Track(SizeKt.fillMaxSize$default($this$RangeSliderImpl_u24lambda_u2412.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null), colors, enabled, positionFractionStart, positionFractionEnd, list, thumbPx, trackStrokeWidth, $composer3, (($dirty >> 9) & 112) | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752));
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1690172335, "CC(remember):Slider.kt#9igjgp");
                invalid$iv = $composer3.changed(startContentDescription);
                Object it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
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
                            SemanticsPropertiesKt.setContentDescription($this$semantics, startContentDescription);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                m1786SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2412, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) value$iv), true, startInteractionSource).then(startThumbSemantics), offsetStart, startInteractionSource, colors, enabled, thumbSize, $composer3, ($changed2 & 14) | 1572864 | (($dirty2 >> 9) & 7168) | ($dirty2 & 57344) | (($dirty2 << 15) & 458752));
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1690171957, "CC(remember):Slider.kt#9igjgp");
                invalid$iv2 = $composer3.changed(endContentDescription);
                Object it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
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
                            SemanticsPropertiesKt.setContentDescription($this$semantics, endContentDescription);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                m1786SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2412, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) value$iv2), true, endInteractionSource).then(endThumbSemantics), offsetEnd, endInteractionSource, colors, enabled, thumbSize, $composer3, ($changed2 & 14) | 1572864 | (($dirty2 >> 12) & 7168) | ($dirty2 & 57344) | (($dirty2 << 15) & 458752));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int $changed3 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RangeSliderImpl_u24lambda_u2413 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1690173145, "C*641@26503L7,650@26811L301,665@27208L48,663@27122L369,676@27586L46,674@27500L359:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u2410 = (Density) objConsume2;
            float trackStrokeWidth2 = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u2410.mo567toPx0680j_4(TrackHeight);
            float thumbPx2 = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u2410.mo567toPx0680j_4(ThumbRadius);
            float widthDp2 = $this$RangeSliderImpl_u24lambda_u2412_u24lambda_u2410.mo563toDpu2uoSUM(width);
            float arg0$iv2 = ThumbRadius;
            float thumbSize2 = C1979Dp.m6801constructorimpl(2 * arg0$iv2);
            float offsetStart2 = C1979Dp.m6801constructorimpl(widthDp2 * positionFractionStart);
            float offsetEnd2 = C1979Dp.m6801constructorimpl(widthDp2 * positionFractionEnd);
            int $dirty3 = $dirty;
            $composer2 = $composer3;
            Track(SizeKt.fillMaxSize$default($this$RangeSliderImpl_u24lambda_u2413.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null), colors, enabled, positionFractionStart, positionFractionEnd, list, thumbPx2, trackStrokeWidth2, $composer3, (($dirty >> 9) & 112) | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752));
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1690172335, "CC(remember):Slider.kt#9igjgp");
            invalid$iv = $composer3.changed(startContentDescription);
            Object it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv) {
                value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, startContentDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, startContentDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            m1786SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2413, FocusableKt.focusable(SemanticsModifierKt.semantics(companion3, true, (Function1) value$iv), true, startInteractionSource).then(startThumbSemantics), offsetStart2, startInteractionSource, colors, enabled, thumbSize2, $composer3, ($changed3 & 14) | 1572864 | (($dirty3 >> 9) & 7168) | ($dirty3 & 57344) | (($dirty3 << 15) & 458752));
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1690171957, "CC(remember):Slider.kt#9igjgp");
            invalid$iv2 = $composer3.changed(endContentDescription);
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv2) {
                value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, endContentDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, endContentDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            m1786SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2413, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (Function1) value$iv2), true, endInteractionSource).then(endThumbSemantics), offsetEnd2, endInteractionSource, colors, enabled, thumbSize2, $composer3, ($changed3 & 14) | 1572864 | (($dirty3 >> 12) & 7168) | ($dirty3 & 57344) | (($dirty3 << 15) & 458752));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSliderImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    SliderKt.RangeSliderImpl(enabled, positionFractionStart, positionFractionEnd, list, colors, width, startInteractionSource, endInteractionSource, modifier, startThumbSemantics, endThumbSemantics, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m1786SliderThumbPcYyNuk(final BoxScope $this$SliderThumb_u2dPcYyNuk, final Modifier modifier, final float offset, final MutableInteractionSource interactionSource, final SliderColors colors, final boolean enabled, final float thumbSize, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Object value$iv;
        SliderKt$SliderThumb$1$1$1 value$iv2;
        Composer $composer2 = $composer.startRestartGroup(428907178);
        ComposerKt.sourceInformation($composer2, "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)697@28078L1639:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$SliderThumb_u2dPcYyNuk) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(offset) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(colors) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(thumbSize) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, $dirty2, -1, "androidx.compose.material.SliderThumb (Slider.kt:696)");
            }
            Modifier modifier$iv = $this$SliderThumb_u2dPcYyNuk.align(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, offset, 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -528162096, "C701@28209L46,702@28298L658,702@28264L692,725@29312L145,732@29662L19,720@29118L593:Slider.kt#jmzs0o");
            ComposerKt.sourceInformationMarkerStart($composer2, -528162077, "CC(remember):Slider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList interactions = (SnapshotStateList) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -528161988, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SliderKt$SliderThumb$1$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, ($dirty2 >> 9) & 14);
            float elevation = interactions.isEmpty() ^ true ? ThumbPressedElevation : ThumbDefaultElevation;
            SpacerKt.Spacer(BackgroundKt.m453backgroundbw27NRU(ShadowKt.m3954shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m915sizeVpY3zN4(modifier, thumbSize, thumbSize), interactionSource, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), interactionSource, false, 2, null), enabled ? elevation : C1979Dp.m6801constructorimpl(0), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), colors.thumbColor(enabled, $composer2, (($dirty2 >> 15) & 14) | (($dirty2 >> 9) & 112)).getValue().m4301unboximpl(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    SliderKt.m1786SliderThumbPcYyNuk($this$SliderThumb_u2dPcYyNuk, modifier, offset, interactionSource, colors, enabled, thumbSize, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Track(final Modifier modifier, final SliderColors colors, final boolean enabled, final float positionFractionStart, final float positionFractionEnd, final List<Float> list, final float thumbPx, final float trackStrokeWidth, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation($composer2, "C(Track)P(2!2,4!1,6)748@30010L35,749@30080L34,750@30150L34,751@30218L33,752@30273L1535,752@30256L1552:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(positionFractionStart) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(positionFractionEnd) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(thumbPx) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changed(trackStrokeWidth) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833126050, $dirty, -1, "androidx.compose.material.Track (Slider.kt:747)");
            }
            final State<Color> stateTrackColor = colors.trackColor(enabled, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896));
            final State<Color> stateTrackColor2 = colors.trackColor(enabled, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896));
            final State<Color> stateTickColor = colors.tickColor(enabled, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896));
            final State<Color> stateTickColor2 = colors.tickColor(enabled, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896));
            ComposerKt.sourceInformationMarkerStart($composer2, 1052530108, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = ((3670016 & $dirty) == 1048576) | $composer2.changed(stateTrackColor) | ((29360128 & $dirty) == 8388608) | ((57344 & $dirty) == 16384) | (($dirty & 7168) == 2048) | $composer2.changed(stateTrackColor2) | $composer2.changedInstance(list) | $composer2.changed(stateTickColor) | $composer2.changed(stateTickColor2);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1$1
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
                        Object answer$iv$iv$iv;
                        boolean isRtl = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                        long sliderLeft = OffsetKt.Offset(thumbPx, Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderRight = OffsetKt.Offset(Size.m4118getWidthimpl($this$Canvas.mo4773getSizeNHjbRc()) - thumbPx, Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderStart = isRtl ? sliderRight : sliderLeft;
                        long sliderEnd = isRtl ? sliderLeft : sliderRight;
                        DrawScope.CC.m4850drawLineNGM6Ib0$default($this$Canvas, stateTrackColor.getValue().m4301unboximpl(), sliderStart, sliderEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        long sliderValueEnd = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart) + ((Offset.m4049getXimpl(sliderEnd) - Offset.m4049getXimpl(sliderStart)) * positionFractionEnd), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        long sliderValueStart = OffsetKt.Offset(Offset.m4049getXimpl(sliderStart) + ((Offset.m4049getXimpl(sliderEnd) - Offset.m4049getXimpl(sliderStart)) * positionFractionStart), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()));
                        DrawScope.CC.m4850drawLineNGM6Ib0$default($this$Canvas, stateTrackColor2.getValue().m4301unboximpl(), sliderValueStart, sliderValueEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        Iterable $this$groupBy$iv = list;
                        float f = positionFractionEnd;
                        float f2 = positionFractionStart;
                        Map destination$iv$iv = new LinkedHashMap();
                        for (Object element$iv$iv : $this$groupBy$iv) {
                            float it = ((Number) element$iv$iv).floatValue();
                            Boolean boolValueOf = Boolean.valueOf(it > f || it < f2);
                            boolean isRtl2 = isRtl;
                            Iterable $this$groupBy$iv2 = $this$groupBy$iv;
                            Object value$iv$iv$iv = destination$iv$iv.get(boolValueOf);
                            if (value$iv$iv$iv == null) {
                                answer$iv$iv$iv = new ArrayList();
                                destination$iv$iv.put(boolValueOf, answer$iv$iv$iv);
                            } else {
                                answer$iv$iv$iv = value$iv$iv$iv;
                            }
                            List list$iv$iv = (List) answer$iv$iv$iv;
                            list$iv$iv.add(element$iv$iv);
                            $this$groupBy$iv = $this$groupBy$iv2;
                            isRtl = isRtl2;
                            f2 = f2;
                        }
                        State<Color> state = stateTickColor;
                        State<Color> state2 = stateTickColor2;
                        float f3 = trackStrokeWidth;
                        Map $this$forEach$iv = destination$iv$iv;
                        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
                            List list2 = (List) element$iv.getValue();
                            State<Color> state3 = state;
                            ArrayList target$iv = new ArrayList(list2.size());
                            List $this$fastForEach$iv$iv = list2;
                            State<Color> state4 = state2;
                            int size = $this$fastForEach$iv$iv.size();
                            Map $this$forEach$iv2 = $this$forEach$iv;
                            int index$iv$iv = 0;
                            while (index$iv$iv < size) {
                                Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                                int i = size;
                                long sliderLeft2 = sliderLeft;
                                long sliderLeft3 = sliderEnd;
                                target$iv.add(Offset.m4038boximpl(OffsetKt.Offset(Offset.m4049getXimpl(OffsetKt.m4072lerpWko1d7g(sliderStart, sliderLeft3, ((Number) item$iv$iv).floatValue())), Offset.m4050getYimpl($this$Canvas.mo4772getCenterF1C5BW0()))));
                                index$iv$iv++;
                                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                size = i;
                                sliderLeft = sliderLeft2;
                                sliderEnd = sliderLeft3;
                            }
                            long sliderLeft4 = sliderLeft;
                            long sliderEnd2 = sliderEnd;
                            DrawScope.CC.m4855drawPointsF8ZwMP8$default($this$Canvas, target$iv, PointMode.INSTANCE.m4605getPointsr_lszbg(), (outsideFraction ? state3 : state4).getValue().m4301unboximpl(), f3, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            state = state3;
                            state2 = state4;
                            $this$forEach$iv = $this$forEach$iv2;
                            sliderLeft = sliderLeft4;
                            sliderEnd = sliderEnd2;
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier, (Function1) value$iv, $composer2, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.Track.2
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
                    SliderKt.Track(modifier, colors, enabled, positionFractionStart, positionFractionEnd, list, thumbPx, trackStrokeWidth, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float current, List<Float> list, float minPx, float maxPx) {
        Object minElem$iv;
        if (!list.isEmpty()) {
            minElem$iv = list.get(0);
            float it = ((Number) minElem$iv).floatValue();
            float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, it) - current);
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                while (true) {
                    Object e$iv = list.get(i$iv);
                    float it2 = ((Number) e$iv).floatValue();
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, it2) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        } else {
            minElem$iv = null;
        }
        Object minElem$iv2 = (Float) minElem$iv;
        if (minElem$iv2 == null) {
            return current;
        }
        float $this$snapValueToTick_u24lambda_u2418 = ((Number) minElem$iv2).floatValue();
        return MathHelpersKt.lerp(minPx, maxPx, $this$snapValueToTick_u24lambda_u2418);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    public static final Object m1789awaitSlop8vUncbI(AwaitPointerEventScope $this$awaitSlop_u2d8vUncbI, long id, int type, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        final Ref.FloatRef initialDelta;
        Object objM1672awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        } else {
            sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$2 = sliderKt$awaitSlop$1;
        Object $result = sliderKt$awaitSlop$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (sliderKt$awaitSlop$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                initialDelta = new Ref.FloatRef();
                Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                        invoke(pointerInputChange, f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PointerInputChange pointerInput, float offset) {
                        pointerInput.consume();
                        initialDelta.element = offset;
                    }
                };
                sliderKt$awaitSlop$2.L$0 = initialDelta;
                sliderKt$awaitSlop$2.label = 1;
                objM1672awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m1672awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitSlop_u2d8vUncbI, id, type, function2, sliderKt$awaitSlop$2);
                if (objM1672awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                initialDelta = (Ref.FloatRef) sliderKt$awaitSlop$2.L$0;
                ResultKt.throwOnFailure($result);
                objM1672awaitHorizontalPointerSlopOrCancellationgDDlDlE = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerInputChange afterSlopResult = (PointerInputChange) objM1672awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        if (afterSlopResult != null) {
            return TuplesKt.m202to(afterSlopResult, Boxing.boxFloat(initialDelta.element));
        }
        return null;
    }

    private static final List<Float> stepsToTickFractions(int steps) {
        if (steps == 0) {
            return CollectionsKt.emptyList();
        }
        int i = steps + 2;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int it = i2;
            arrayList.add(Float.valueOf(it / (steps + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> closedFloatingPointRange, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, closedFloatingPointRange.getStart().floatValue(), a2, b2), scale(a1, b1, closedFloatingPointRange.getEndInclusive().floatValue(), a2, b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float a, float b, float pos) {
        float $this$fastCoerceIn$iv = ((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a);
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
    public static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float value, Composer $composer, final int $changed) {
        int i;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation($composer2, "C(CorrectValueSideEffect)P(!1,3!1,4)848@33670L300,848@33659L311:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(mutableState) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(value) ? 16384 : 8192;
        }
        if (($dirty & 9363) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, $dirty, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:847)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1481635441, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 14) == 4) | ((57344 & $dirty) == 16384) | (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                value$iv = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        float error = (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue()) / 1000;
                        float newOffset = function1.invoke(Float.valueOf(value)).floatValue();
                        if (Math.abs(newOffset - mutableState.getValue().floatValue()) > error && closedFloatingPointRange2.contains(mutableState.getValue())) {
                            mutableState.setValue(Float.valueOf(newOffset));
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
                i = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv, $composer2, i);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt.CorrectValueSideEffect.2
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

                public final void invoke(Composer composer, int i2) {
                    SliderKt.CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, value, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, final boolean enabled, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int steps) {
        final float coerced = RangesKt.coerceIn(value, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                if (!enabled) {
                    SemanticsPropertiesKt.disabled($this$semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i = steps;
                final float f = coerced;
                final Function1<Float, Unit> function2 = function1;
                final Function0<Unit> function3 = function0;
                SemanticsPropertiesKt.setProgress$default($this$semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt.sliderSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f2) {
                        return invoke(f2.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        boolean z = true;
                        if (i > 0) {
                            float distance = newValue;
                            int i2 = 0;
                            int i3 = i + 1;
                            if (0 <= i3) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue(), i2 / (i + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == f) {
                            z = false;
                        } else {
                            function2.invoke(Float.valueOf(resolvedValue));
                            Function0<Unit> function4 = function3;
                            if (function4 != null) {
                                function4.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), value, closedFloatingPointRange, steps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, final DraggableState draggableState, final MutableInteractionSource interactionSource, final float maxPx, final boolean isRtl, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean enabled) {
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("sliderTapModifier");
                $this$null.getProperties().set("draggableState", draggableState);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("maxPx", Float.valueOf(maxPx));
                $this$null.getProperties().set("isRtl", Boolean.valueOf(isRtl));
                $this$null.getProperties().set("rawOffset", state);
                $this$null.getProperties().set("gestureEndAction", state2);
                $this$null.getProperties().set("pressOffset", mutableState);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Modifier modifierPointerInput;
                Object value$iv$iv;
                $composer.startReplaceGroup(1945228890);
                ComposerKt.sourceInformation($composer, "C916@36069L24,917@36168L898:Slider.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945228890, $changed, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:915)");
                }
                if (enabled) {
                    ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
                    Object it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    CoroutineScope scope = wrapper$iv.getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Object[] objArr = {draggableState, interactionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl)};
                    ComposerKt.sourceInformationMarkerStart($composer, 75561302, "CC(remember):Slider.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(isRtl) | $composer.changed(maxPx) | $composer.changed(mutableState) | $composer.changed(state) | $composer.changedInstance(scope) | $composer.changedInstance(draggableState) | $composer.changed(state2);
                    boolean z = isRtl;
                    float f = maxPx;
                    MutableState<Float> mutableState2 = mutableState;
                    State<Float> state3 = state;
                    DraggableState draggableState2 = draggableState;
                    State<Function1<Float, Unit>> state4 = state2;
                    Object value$iv = $composer.rememberedValue();
                    if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new SliderKt$sliderTapModifier$2$1$1(z, f, mutableState2, state3, scope, draggableState2, state4, null);
                        $composer.updateRememberedValue(value$iv);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput($this$composed, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv);
                } else {
                    modifierPointerInput = $this$composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierPointerInput;
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.SliderKt$animateToTarget$2", m210f = "Slider.kt", m211i = {}, m212l = {964}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C10962 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10962(float f, float f2, float f3, Continuation<? super C10962> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10962 c10962 = new C10962(this.$current, this.$target, this.$velocity, continuation);
            c10962.L$0 = obj;
            return c10962;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((C10962) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final DragScope $this$drag = (DragScope) this.L$0;
                    final Ref.FloatRef latestValue = new Ref.FloatRef();
                    latestValue.element = this.$current;
                    this.label = 1;
                    if (AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null).animateTo(Boxing.boxFloat(this.$target), SliderKt.SliderToTickAnimation, Boxing.boxFloat(this.$velocity), new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.animateToTarget.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                            invoke2(animatable);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                            $this$drag.dragBy(animatable.getValue().floatValue() - latestValue.element);
                            latestValue.element = animatable.getValue().floatValue();
                        }
                    }, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.CC.drag$default(draggableState, null, new C10962(current, target, velocity, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", m210f = "Slider.kt", m211i = {}, m212l = {992}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C10971 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10971(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, float f, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super C10971> continuation) {
            super(2, continuation);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z;
            this.$maxPx = f;
            this.$gestureEndAction = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10971 c10971 = new C10971(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
            c10971.L$0 = obj;
            return c10971;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C10971) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$pointerInput, this.$isRtl, this.$maxPx, rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", m210f = "Slider.kt", m211i = {}, m212l = {993}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z;
                this.$maxPx = f;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", m210f = "Slider.kt", m211i = {0, 1, 1, 1, 1, 1, 2, 2}, m212l = {994, PointerIconCompat.TYPE_WAIT, 1023}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, Route.INTERACTION, "posX", "draggingStart", Route.INTERACTION, "draggingStart"}, m215s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
            static final class C45631 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C45631(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C45631> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = coroutineScope;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C45631 c45631 = new C45631(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c45631.L$0 = obj;
                    return c45631;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C45631) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:19:0x008a  */
                /* JADX WARN: Code duplicated, block: B:20:0x0096  */
                /* JADX WARN: Code duplicated, block: B:23:0x00af A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:24:0x00b1  */
                /* JADX WARN: Code duplicated, block: B:25:0x00b3  */
                /* JADX WARN: Code duplicated, block: B:26:0x00b5  */
                /* JADX WARN: Code duplicated, block: B:28:0x00c7  */
                /* JADX WARN: Code duplicated, block: B:29:0x00c9  */
                /* JADX WARN: Code duplicated, block: B:32:0x00ea A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:33:0x00eb  */
                /* JADX WARN: Code duplicated, block: B:36:0x00f3  */
                /* JADX WARN: Code duplicated, block: B:38:0x011b  */
                /* JADX WARN: Code duplicated, block: B:41:0x0132  */
                /* JADX WARN: Code duplicated, block: B:44:0x0136  */
                /* JADX WARN: Code duplicated, block: B:46:0x0143  */
                /* JADX WARN: Code duplicated, block: B:49:0x0148  */
                /* JADX WARN: Code duplicated, block: B:58:0x019b A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:59:0x019c  */
                /* JADX WARN: Code duplicated, block: B:62:0x01ac A[Catch: CancellationException -> 0x01bd, TryCatch #1 {CancellationException -> 0x01bd, blocks: (B:60:0x01a3, B:62:0x01ac, B:63:0x01b4), top: B:75:0x01a3 }] */
                /* JADX WARN: Code duplicated, block: B:63:0x01b4 A[Catch: CancellationException -> 0x01bd, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x01bd, blocks: (B:60:0x01a3, B:62:0x01ac, B:63:0x01b4), top: B:75:0x01a3 }] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    C45631 c45631;
                    AwaitPointerEventScope $this$awaitEachGesture;
                    Object $result2;
                    Object $result3;
                    PointerInputChange event;
                    DragInteraction.Start interaction;
                    Ref.FloatRef posX;
                    float fM4049getXimpl;
                    int compare;
                    Ref.BooleanRef draggingStart;
                    boolean z;
                    Object objM1789awaitSlop8vUncbI;
                    DragInteraction.Start interaction2;
                    Object $result4;
                    Object $result5;
                    final Ref.BooleanRef draggingStart2;
                    Pair it;
                    Ref.BooleanRef draggingStart3;
                    DragInteraction.Start interaction3;
                    Object objM614horizontalDragjO51t88;
                    Object $result6;
                    State<Float> state;
                    boolean z2;
                    float slop;
                    boolean shouldUpdateCapturedThumb;
                    DragInteraction.Cancel finishInteraction;
                    boolean success;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            c45631 = this;
                            AwaitPointerEventScope $this$awaitEachGesture2 = (AwaitPointerEventScope) c45631.L$0;
                            c45631.L$0 = $this$awaitEachGesture2;
                            c45631.label = 1;
                            Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture2, false, null, c45631, 2, null);
                            if (objAwaitFirstDown$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$awaitEachGesture = $this$awaitEachGesture2;
                            $result2 = $result;
                            $result3 = objAwaitFirstDown$default;
                            event = (PointerInputChange) $result3;
                            interaction = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            if (c45631.$isRtl) {
                                fM4049getXimpl = c45631.$maxPx - Offset.m4049getXimpl(event.getPosition());
                            } else {
                                fM4049getXimpl = Offset.m4049getXimpl(event.getPosition());
                            }
                            posX.element = fM4049getXimpl;
                            compare = c45631.$rangeSliderLogic.compareOffsets(posX.element);
                            draggingStart = new Ref.BooleanRef();
                            if (compare != 0) {
                                if (compare < 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if (c45631.$rawOffsetStart.getValue().floatValue() > posX.element) {
                                z = true;
                            } else {
                                z = false;
                            }
                            draggingStart.element = z;
                            c45631.L$0 = $this$awaitEachGesture;
                            c45631.L$1 = event;
                            c45631.L$2 = interaction;
                            c45631.L$3 = posX;
                            c45631.L$4 = draggingStart;
                            c45631.label = 2;
                            objM1789awaitSlop8vUncbI = SliderKt.m1789awaitSlop8vUncbI($this$awaitEachGesture, event.getId(), event.getType(), c45631);
                            if (objM1789awaitSlop8vUncbI == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction2 = interaction;
                            $result4 = objM1789awaitSlop8vUncbI;
                            $result5 = $result2;
                            draggingStart2 = draggingStart;
                            it = (Pair) $result4;
                            if (it != null) {
                                state = c45631.$rawOffsetEnd;
                                State<Float> state2 = c45631.$rawOffsetStart;
                                z2 = c45631.$isRtl;
                                slop = DragGestureDetectorCopyKt.m1675pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(state.getValue().floatValue() - posX.element) < slop || Math.abs(state2.getValue().floatValue() - posX.element) >= slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = true;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = z2 ? dir < 0.0f : dir >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45631.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45631.$$this$coroutineScope);
                            try {
                                long id = event.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = c45631.$onDrag;
                                final boolean z3 = c45631.$isRtl;
                                c45631.L$0 = interaction2;
                                c45631.L$1 = draggingStart2;
                                c45631.L$2 = null;
                                c45631.L$3 = null;
                                c45631.L$4 = null;
                                c45631.label = 3;
                                objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                        invoke2(pointerInputChange);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(PointerInputChange it2) {
                                        float deltaX = Offset.m4049getXimpl(PointerEventKt.positionChange(it2));
                                        state3.getValue().invoke(Boolean.valueOf(draggingStart2.element), Float.valueOf(z3 ? -deltaX : deltaX));
                                    }
                                }, c45631);
                                if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                draggingStart3 = draggingStart2;
                                interaction3 = interaction2;
                                Object obj = $result5;
                                $result5 = objM614horizontalDragjO51t88;
                                $result6 = obj;
                                try {
                                    success = ((Boolean) $result5).booleanValue();
                                    if (success) {
                                        finishInteraction = new DragInteraction.Stop(interaction3);
                                    } else {
                                        finishInteraction = new DragInteraction.Cancel(interaction3);
                                    }
                                    break;
                                } catch (CancellationException e) {
                                    $result5 = $result6;
                                    finishInteraction = new DragInteraction.Cancel(interaction3);
                                }
                                c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                                BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            } catch (CancellationException e2) {
                                draggingStart3 = draggingStart2;
                                interaction3 = interaction2;
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                                c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                                BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                        case 1:
                            c45631 = this;
                            $result3 = $result;
                            AwaitPointerEventScope $this$awaitEachGesture3 = (AwaitPointerEventScope) c45631.L$0;
                            ResultKt.throwOnFailure($result3);
                            $this$awaitEachGesture = $this$awaitEachGesture3;
                            $result2 = $result3;
                            event = (PointerInputChange) $result3;
                            interaction = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            if (c45631.$isRtl) {
                                fM4049getXimpl = c45631.$maxPx - Offset.m4049getXimpl(event.getPosition());
                            } else {
                                fM4049getXimpl = Offset.m4049getXimpl(event.getPosition());
                            }
                            posX.element = fM4049getXimpl;
                            compare = c45631.$rangeSliderLogic.compareOffsets(posX.element);
                            draggingStart = new Ref.BooleanRef();
                            if (compare != 0) {
                                if (compare < 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if (c45631.$rawOffsetStart.getValue().floatValue() > posX.element) {
                                z = true;
                            } else {
                                z = false;
                            }
                            draggingStart.element = z;
                            c45631.L$0 = $this$awaitEachGesture;
                            c45631.L$1 = event;
                            c45631.L$2 = interaction;
                            c45631.L$3 = posX;
                            c45631.L$4 = draggingStart;
                            c45631.label = 2;
                            objM1789awaitSlop8vUncbI = SliderKt.m1789awaitSlop8vUncbI($this$awaitEachGesture, event.getId(), event.getType(), c45631);
                            if (objM1789awaitSlop8vUncbI == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction2 = interaction;
                            $result4 = objM1789awaitSlop8vUncbI;
                            $result5 = $result2;
                            draggingStart2 = draggingStart;
                            it = (Pair) $result4;
                            if (it != null) {
                                state = c45631.$rawOffsetEnd;
                                State<Float> state4 = c45631.$rawOffsetStart;
                                z2 = c45631.$isRtl;
                                slop = DragGestureDetectorCopyKt.m1675pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(state.getValue().floatValue() - posX.element) < slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = false;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir2 = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = z2 ? dir2 < 0.0f : dir2 >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45631.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45631.$$this$coroutineScope);
                            long id2 = event.getId();
                            final State<? extends Function2<? super Boolean, ? super Float, Unit>> state5 = c45631.$onDrag;
                            final boolean z4 = c45631.$isRtl;
                            c45631.L$0 = interaction2;
                            c45631.L$1 = draggingStart2;
                            c45631.L$2 = null;
                            c45631.L$3 = null;
                            c45631.L$4 = null;
                            c45631.label = 3;
                            objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                    invoke2(pointerInputChange);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it2) {
                                    float deltaX = Offset.m4049getXimpl(PointerEventKt.positionChange(it2));
                                    state5.getValue().invoke(Boolean.valueOf(draggingStart2.element), Float.valueOf(z4 ? -deltaX : deltaX));
                                }
                            }, c45631);
                            if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            draggingStart3 = draggingStart2;
                            interaction3 = interaction2;
                            Object obj2 = $result5;
                            $result5 = objM614horizontalDragjO51t88;
                            $result6 = obj2;
                            success = ((Boolean) $result5).booleanValue();
                            if (success) {
                                finishInteraction = new DragInteraction.Stop(interaction3);
                            } else {
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                            }
                            c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                            BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        case 2:
                            c45631 = this;
                            $result4 = $result;
                            draggingStart2 = (Ref.BooleanRef) c45631.L$4;
                            posX = (Ref.FloatRef) c45631.L$3;
                            interaction2 = (DragInteraction.Start) c45631.L$2;
                            event = (PointerInputChange) c45631.L$1;
                            $this$awaitEachGesture = (AwaitPointerEventScope) c45631.L$0;
                            ResultKt.throwOnFailure($result4);
                            $result5 = $result4;
                            it = (Pair) $result4;
                            if (it != null) {
                                state = c45631.$rawOffsetEnd;
                                State<Float> state6 = c45631.$rawOffsetStart;
                                z2 = c45631.$isRtl;
                                slop = DragGestureDetectorCopyKt.m1675pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(state.getValue().floatValue() - posX.element) < slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = false;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir3 = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = z2 ? dir3 < 0.0f : dir3 >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45631.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45631.$$this$coroutineScope);
                            long id3 = event.getId();
                            final State<? extends Function2<? super Boolean, ? super Float, Unit>> state7 = c45631.$onDrag;
                            final boolean z5 = c45631.$isRtl;
                            c45631.L$0 = interaction2;
                            c45631.L$1 = draggingStart2;
                            c45631.L$2 = null;
                            c45631.L$3 = null;
                            c45631.L$4 = null;
                            c45631.label = 3;
                            objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id3, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                    invoke2(pointerInputChange);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it2) {
                                    float deltaX = Offset.m4049getXimpl(PointerEventKt.positionChange(it2));
                                    state7.getValue().invoke(Boolean.valueOf(draggingStart2.element), Float.valueOf(z5 ? -deltaX : deltaX));
                                }
                            }, c45631);
                            if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            draggingStart3 = draggingStart2;
                            interaction3 = interaction2;
                            Object obj3 = $result5;
                            $result5 = objM614horizontalDragjO51t88;
                            $result6 = obj3;
                            success = ((Boolean) $result5).booleanValue();
                            if (success) {
                                finishInteraction = new DragInteraction.Stop(interaction3);
                            } else {
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                            }
                            c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                            BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        case 3:
                            c45631 = this;
                            $result5 = $result;
                            draggingStart3 = (Ref.BooleanRef) c45631.L$1;
                            interaction3 = (DragInteraction.Start) c45631.L$0;
                            try {
                                ResultKt.throwOnFailure($result5);
                                $result6 = $result5;
                                success = ((Boolean) $result5).booleanValue();
                                if (success) {
                                    finishInteraction = new DragInteraction.Stop(interaction3);
                                } else {
                                    finishInteraction = new DragInteraction.Cancel(interaction3);
                                }
                                break;
                            } catch (CancellationException e3) {
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                                c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                                BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            c45631.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart3.element));
                            BuildersKt__Builders_commonKt.launch$default(c45631.$$this$coroutineScope, null, null, new AnonymousClass2(c45631.$rangeSliderLogic, draggingStart3, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", m210f = "Slider.kt", m211i = {}, m212l = {1040}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Ref.BooleanRef $draggingStart;
                    final /* synthetic */ DragInteraction $finishInteraction;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$draggingStart = booleanRef;
                        this.$finishInteraction = dragInteraction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
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
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C45631(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, $this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> state, State<Float> state2, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return enabled ? SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C10971(startInteractionSource, endInteractionSource, state, state2, state4, isRtl, maxPx, state3, null)) : $this$rangeSliderPressDragModifier;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}

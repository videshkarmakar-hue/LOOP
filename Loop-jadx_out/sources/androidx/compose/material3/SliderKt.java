package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.C1733R;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventKt;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
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
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0098\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&H\u0007¢\u0006\u0002\u0010)\u001aä\u0001\u0010\u0018\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0004\u0012\u00020\u00190%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001002\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\b\b\u0003\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00103\u001a\u007f\u0010\u0018\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0004\u0012\u00020\u00190%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+2\b\b\u0003\u00101\u001a\u0002022\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001002\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u00104\u001a\u0080\u0001\u00105\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&H\u0003¢\u0006\u0002\u00106\u001as\u00107\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u0002082\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00109\u001a\u00020\"2\u0019\b\u0002\u0010:\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&H\u0007¢\u0006\u0002\u0010;\u001a³\u0001\u00107\u001a\u00020\u00192\u0006\u0010*\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001002\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00109\u001a\u00020\"2\b\b\u0003\u00101\u001a\u0002022\u0019\b\u0002\u0010:\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+H\u0007¢\u0006\u0002\u0010<\u001a}\u00107\u001a\u00020\u00192\u0006\u0010*\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+2\b\b\u0003\u00101\u001a\u0002022\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001002\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00109\u001a\u00020\"H\u0007¢\u0006\u0002\u0010=\u001a_\u0010>\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u00109\u001a\u00020\"2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&H\u0003¢\u0006\u0002\u0010?\u001a\u001d\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020,H\u0001¢\u0006\u0002\u0010C\u001a\u001b\u0010@\u001a\u00020\u00132\f\u0010D\u001a\b\u0012\u0004\u0012\u00020,0+H\u0001¢\u0006\u0002\u0010E\u001a \u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020,H\u0002\u001a:\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a0\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020,2\u0006\u0010R\u001a\u00020,2\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,H\u0002\u001a(\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020,H\u0002\u001a\u0010\u0010Y\u001a\u00020V2\u0006\u00101\u001a\u000202H\u0002\u001a5\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020,\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010d\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002\u001a,\u0010e\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0012H\u0003\u001a\u001c\u0010f\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002\u001a\u001c\u0010g\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001a\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u0012H\u0002\u001a$\u0010h\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001a\u001a\u0002082\u0006\u00109\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0012H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000b\"\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u001e\u0010\u0011\u001a\u00020\u0012*\u00020\u00138@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006i"}, m195d2 = {"SliderRangeTolerance", "", "ThumbHeight", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbTrackGapSize", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "TrackInsideCornerSize", "TrackStopIndicatorSize", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", DownloadUtil.CookieScheme.VALUE, "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x", "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SliderKt {
    private static final double SliderRangeTolerance = 1.0E-4d;
    private static final float TrackHeight = SliderTokens.INSTANCE.m3597getInactiveTrackHeightD9Ej5fM();
    private static final float ThumbWidth = SliderTokens.INSTANCE.m3595getHandleWidthD9Ej5fM();
    private static final float ThumbHeight = SliderTokens.INSTANCE.m3594getHandleHeightD9Ej5fM();
    private static final long ThumbSize = DpKt.m6823DpSizeYgX7TsA(ThumbWidth, ThumbHeight);
    private static final float TickSize = C1979Dp.m6801constructorimpl(2);
    private static final float ThumbTrackGapSize = SliderTokens.INSTANCE.m3587getActiveHandleLeadingSpaceD9Ej5fM();
    private static final float TrackInsideCornerSize = C1979Dp.m6801constructorimpl(2);
    private static final float TrackStopIndicatorSize = SliderTokens.INSTANCE.m3599getStopIndicatorSizeD9Ej5fM();

    /* JADX INFO: renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2632isSpecifiedIf1S1O4$annotations(long j) {
    }

    public static final void Slider(final float value, final Function1<? super Float, Unit> function1, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i2;
        Function0<Unit> function2;
        Modifier.Companion modifier2;
        final boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int steps2;
        Function0<Unit> function3;
        final SliderColors colors2;
        final MutableInteractionSource interactionSource2;
        Object value$iv;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        boolean enabled3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int steps3;
        Function0<Unit> function4;
        SliderColors colors3;
        Composer $composer2 = $composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(7,4,3,1,8,6,5)163@7812L8,164@7872L39,175@8212L181,182@8411L184,166@7920L714:Slider.kt#uh7d8r");
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
        } else if ((1572864 & $changed) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = function0;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled3 = enabled;
            colors3 = colors;
            interactionSource3 = interactionSource;
            steps3 = i2;
            function4 = function2;
            modifier3 = modifier;
            closedFloatingPointRange3 = closedFloatingPointRange2;
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
                if ((i & 128) != 0) {
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1537042756, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    interactionSource2 = interactionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    $dirty &= -29360129;
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    steps2 = i2;
                    function3 = function2;
                    interactionSource2 = interactionSource;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    interactionSource2 = interactionSource;
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                    steps2 = i2;
                    function3 = function2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202044027, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:165)");
            }
            Slider(value, function1, modifier2, enabled2, function3, colors2, interactionSource2, steps2, ComposableLambdaKt.rememberComposableLambda(308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                    invoke(sliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState it, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C176@8241L142:Slider.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(308249025, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:176)");
                    }
                    SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(interactionSource2, null, colors2, enabled2, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                    invoke(sliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState sliderState, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C183@8455L130:Slider.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1843234110, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:183)");
                    }
                    SliderDefaults.INSTANCE.m2624TracknbWgWpA(sliderState, (Modifier) null, enabled2, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), closedFloatingPointRangeRangeTo, $composer2, ($dirty & 14) | 905969664 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016) | (($dirty << 6) & 29360128), ($dirty >> 12) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
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
            final SliderColors sliderColors = colors3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.4
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
                    SliderKt.Slider(value, function1, modifier4, z, closedFloatingPointRange4, i9, function5, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void Slider(final float value, final Function1<? super Float, Unit> function1, Modifier modifier, boolean enabled, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, int steps, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function4, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function0<Unit> function2;
        Modifier.Companion modifier2;
        final boolean enabled2;
        Function0<Unit> function5;
        final SliderColors colors2;
        final MutableInteractionSource interactionSource2;
        int steps2;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int $dirty1;
        int $dirty2;
        Object value$iv;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function6;
        MutableInteractionSource interactionSource3;
        int steps3;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function7;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        Function0<Unit> function8;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(1191170377);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(9,4,3,1,5)254@11930L8,255@11990L39,258@12122L157,265@12328L160,274@12567L184,290@12878L184:Slider.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty3 = $changed1;
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
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function2 = function0;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = function0;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= ((i & 32) == 0 && $composer2.changed(colors)) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(steps) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= ((i & 1024) == 0 && $composer2.changed(closedFloatingPointRange)) ? 4 : 2;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty3 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled3 = enabled;
            colors2 = colors;
            interactionSource3 = interactionSource;
            steps3 = steps;
            function6 = function3;
            function7 = function4;
            closedFloatingPointRange2 = closedFloatingPointRange;
            function8 = function2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                function5 = i4 != 0 ? null : function2;
                if ((i & 32) != 0) {
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -458753;
                } else {
                    colors2 = colors;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1537038638, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    interactionSource2 = interactionSource;
                }
                steps2 = i6 != 0 ? 0 : steps;
                composableLambdaRememberComposableLambda = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(-1756326375, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                        invoke(sliderState, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState it, Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C259@12147L126:Slider.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1756326375, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:259)");
                        }
                        SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(interactionSource2, null, colors2, enabled2, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54) : function3;
                composableLambdaRememberComposableLambda2 = i8 != 0 ? ComposableLambdaKt.rememberComposableLambda(2083675534, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                        invoke(sliderState, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState sliderState, Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C266@12368L114:Slider.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2083675534, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:266)");
                        }
                        SliderDefaults.INSTANCE.m2624TracknbWgWpA(sliderState, (Modifier) null, enabled2, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54) : function4;
                if ((i & 1024) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty1 = $dirty3 & (-15);
                    $dirty2 = $dirty;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 1024) != 0) {
                    $dirty3 &= -15;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                colors2 = colors;
                steps2 = steps;
                composableLambdaRememberComposableLambda = function3;
                composableLambdaRememberComposableLambda2 = function4;
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                $dirty1 = $dirty3;
                function5 = function2;
                $dirty2 = $dirty;
                interactionSource2 = interactionSource;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1191170377, $dirty2, $dirty1, "androidx.compose.material3.Slider (Slider.kt:273)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1537038061, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = (((($dirty1 & 14) ^ 6) > 4 && $composer2.changed(closedFloatingPointRangeRangeTo)) || ($dirty1 & 6) == 4) | ((29360128 & $dirty2) == 8388608);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SliderState(value, steps2, function5, closedFloatingPointRangeRangeTo);
                $composer2.updateRememberedValue(value$iv2);
            }
            SliderState state = (SliderState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            state.setOnValueChangeFinished(function5);
            state.setOnValueChange$material3_release(function1);
            state.setValue(value);
            Slider(state, modifier2, enabled2, null, interactionSource2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, $composer2, (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 9) & 458752) | (($dirty2 >> 9) & 3670016), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = composableLambdaRememberComposableLambda;
            interactionSource3 = interactionSource2;
            steps3 = steps2;
            function7 = composableLambdaRememberComposableLambda2;
            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
            function8 = function5;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z = enabled3;
            final Function0<Unit> function9 = function8;
            final SliderColors sliderColors = colors2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final int i9 = steps3;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function10 = function6;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function11 = function7;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRange2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.8
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
                    SliderKt.Slider(value, function1, modifier3, z, function9, sliderColors, mutableInteractionSource, i9, function10, function11, closedFloatingPointRange3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void Slider(final SliderState state, Modifier modifier, boolean enabled, SliderColors colors, MutableInteractionSource interactionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        boolean z;
        final SliderColors colors2;
        final MutableInteractionSource interactionSource2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function5;
        boolean z2;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda2;
        int $dirty;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function6;
        SliderColors colors3;
        Object value$iv;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function7;
        SliderColors colors4;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function8;
        Modifier modifier3;
        MutableInteractionSource interactionSource4;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(-1303883986);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(4,3,1)349@15542L8,350@15602L39,351@15690L157,358@15896L160,368@16123L188:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else if (($changed & 384) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                colors2 = colors;
                int i4 = $composer2.changed(colors2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i4;
        } else {
            colors2 = colors;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            interactionSource2 = interactionSource;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function3RememberComposableLambda = function3;
        } else if ((196608 & $changed) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 131072 : 65536;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            function5 = function4;
        } else if ((1572864 & $changed) == 0) {
            function5 = function4;
            $dirty2 |= $composer2.changedInstance(function5) ? 1048576 : 524288;
        } else {
            function5 = function4;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled3 = z;
            interactionSource4 = interactionSource2;
            function7 = function3RememberComposableLambda;
            function8 = function5;
            modifier3 = modifier;
            colors4 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled4 = i3 != 0 ? true : z;
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1537035026, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    interactionSource2 = (MutableInteractionSource) value$iv;
                }
                if (i6 != 0) {
                    z2 = true;
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1426271326, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                            invoke(sliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState it, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C352@15715L126:Slider.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1426271326, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:352)");
                            }
                            SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(interactionSource2, null, colors2, enabled4, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                } else {
                    z2 = true;
                }
                if (i7 != 0) {
                    function3RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(577038345, z2, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.11
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                            invoke(sliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState sliderState, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C359@15936L114:Slider.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(577038345, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:359)");
                            }
                            SliderDefaults.INSTANCE.m2624TracknbWgWpA(sliderState, (Modifier) null, enabled4, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                    enabled2 = enabled4;
                    interactionSource3 = interactionSource2;
                    function6 = function3RememberComposableLambda;
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    colors3 = colors2;
                } else {
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    interactionSource3 = interactionSource2;
                    function3RememberComposableLambda2 = function5;
                    $dirty = $dirty2;
                    function6 = function3RememberComposableLambda;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier2 = modifier;
                enabled2 = z;
                interactionSource3 = interactionSource2;
                function3RememberComposableLambda2 = function5;
                $dirty = $dirty2;
                function6 = function3RememberComposableLambda;
                colors3 = colors2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1303883986, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:365)");
            }
            if (!(state.getSteps() >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            SliderImpl(modifier2, state, enabled2, interactionSource3, function6, function3RememberComposableLambda2, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & 112) | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function6;
            colors4 = colors3;
            function8 = function3RememberComposableLambda2;
            modifier3 = modifier2;
            interactionSource4 = interactionSource3;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = enabled3;
            final SliderColors sliderColors = colors4;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function9 = function7;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function10 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.Slider.13
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
                    SliderKt.Slider(state, modifier5, z3, sliderColors, mutableInteractionSource, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int steps, Function0<Unit> function0, SliderColors colors, Composer $composer, final int $changed, final int i) {
        final boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int steps2;
        Function0<Unit> function2;
        Modifier.Companion modifier2;
        final SliderColors colors2;
        int $dirty;
        int $dirty2;
        Function0<Unit> function3;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        int steps3;
        Function0<Unit> function4;
        SliderColors colors3;
        boolean enabled3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Composer $composer2 = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation($composer2, "C(RangeSlider)P(6,3,2,1,7,5,4)422@18682L8,424@18754L39,425@18851L39,437@19269L186,444@19476L184,451@19678L199,427@18896L987:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(closedFloatingPointRange) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                int i4 = $composer2.changed(closedFloatingPointRangeRangeTo) ? 16384 : 8192;
                $dirty3 |= i4;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
            }
            $dirty3 |= i4;
        } else {
            closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            steps2 = steps;
        } else if ((196608 & $changed) == 0) {
            steps2 = steps;
            $dirty3 |= $composer2.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
            function2 = function0;
        } else if ((1572864 & $changed) == 0) {
            function2 = function0;
            $dirty3 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = function0;
        }
        if (($changed & 12582912) == 0) {
            $dirty3 |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        if (($dirty3 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            colors3 = colors;
            closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
            function4 = function2;
            steps3 = steps2;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i5 != 0) {
                    steps2 = 0;
                }
                if (i6 != 0) {
                    function2 = null;
                }
                if ((i & 128) != 0) {
                    $dirty = $dirty3 & (-29360129);
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 = steps2;
                    function3 = function2;
                } else {
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty2 = steps2;
                    function3 = function2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 128) != 0) {
                    colors2 = colors;
                    $dirty = $dirty3 & (-29360129);
                    $dirty2 = steps2;
                    function3 = function2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty2 = steps2;
                    function3 = function2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743091416, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:423)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -223513113, "CC(remember):Slider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -223513016, "CC(remember):Slider.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            RangeSlider(closedFloatingPointRange, function1, modifier2, enabled2, closedFloatingPointRangeRangeTo, function3, null, startInteractionSource, endInteractionSource, ComposableLambdaKt.rememberComposableLambda(-811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C438@19298L147:Slider.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-811582901, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                    }
                    SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(startInteractionSource, null, colors2, enabled2, 0L, $composer3, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C445@19505L145:Slider.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1832060001, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                    }
                    SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(endInteractionSource, null, colors2, enabled2, 0L, $composer3, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C452@19727L140:Slider.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(377064480, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:452)");
                    }
                    SliderDefaults.INSTANCE.m2623TracknbWgWpA(rangeSliderState, (Modifier) null, enabled2, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $dirty2, $composer2, ($dirty & 14) | 918552576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (($dirty >> 3) & 458752), (($dirty >> 9) & 896) | 54, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            steps3 = $dirty2;
            function4 = function3;
            colors3 = colors2;
            enabled3 = enabled2;
            closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z = enabled3;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
            final int i7 = steps3;
            final Function0<Unit> function5 = function4;
            final SliderColors sliderColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.4
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
                    SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier4, z, closedFloatingPointRange4, i7, function5, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function4, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function5, int steps, Composer $composer, final int $changed, final int $changed1, final int i) {
        final boolean enabled2;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        Function0<Unit> function2;
        final SliderColors colors2;
        final MutableInteractionSource startInteractionSource2;
        final MutableInteractionSource endInteractionSource2;
        boolean z;
        ComposableLambda composableLambdaRememberComposableLambda;
        int steps2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function7;
        MutableInteractionSource endInteractionSource3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function8;
        Modifier modifier2;
        SliderColors sliderColors;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        MutableInteractionSource endInteractionSource4;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function9;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function10;
        int steps3;
        Function0<Unit> function11;
        MutableInteractionSource startInteractionSource3;
        SliderColors colors3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function12;
        Modifier modifier3;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation($composer2, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)524@23566L8,525@23631L39,526@23725L39,527@23823L162,534@24042L160,541@24256L175,551@24496L227,565@24807L44,569@24944L291:Slider.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= ((i & 16) == 0 && $composer2.changed(closedFloatingPointRange2)) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= ((i & 64) == 0 && $composer2.changed(colors)) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(startInteractionSource) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(endInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 536870912 : 268435456;
        }
        int i8 = i & 1024;
        if (i8 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function4) ? 4 : 2;
        }
        int i9 = i & 2048;
        if (i9 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(function5) ? 32 : 16;
        }
        int i10 = i & 4096;
        if (i10 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(steps) ? 256 : 128;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            closedFloatingPointRange4 = closedFloatingPointRange2;
            function11 = function0;
            colors3 = colors;
            startInteractionSource3 = startInteractionSource;
            endInteractionSource4 = endInteractionSource;
            function9 = function3;
            function10 = function4;
            function12 = function5;
            steps3 = steps;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange2;
                }
                function2 = i4 != 0 ? null : function0;
                if ((i & 64) != 0) {
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    colors2 = colors;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -223508236, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    startInteractionSource2 = (MutableInteractionSource) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    startInteractionSource2 = startInteractionSource;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -223508142, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    endInteractionSource2 = (MutableInteractionSource) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    endInteractionSource2 = endInteractionSource;
                }
                if (i7 != 0) {
                    Function3<RangeSliderState, Composer, Integer, Unit> function13 = new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                            invoke(rangeSliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C528@23848L131:Slider.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1963073082, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:528)");
                            }
                            SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(startInteractionSource2, null, colors2, enabled2, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    z = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1963073082, true, function13, $composer2, 54);
                } else {
                    z = true;
                    composableLambdaRememberComposableLambda = function3;
                }
                ComposableLambda composableLambdaRememberComposableLambda2 = i8 != 0 ? ComposableLambdaKt.rememberComposableLambda(1908709951, z, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                        invoke(rangeSliderState, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C535@24067L129:Slider.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1908709951, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:535)");
                        }
                        SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(endInteractionSource2, null, colors2, enabled2, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54) : function4;
                ComposableLambda composableLambdaRememberComposableLambda3 = i9 != 0 ? ComposableLambdaKt.rememberComposableLambda(-429193201, z, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                        invoke(rangeSliderState, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C542@24301L124:Slider.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-429193201, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:542)");
                        }
                        SliderDefaults.INSTANCE.m2623TracknbWgWpA(rangeSliderState, (Modifier) null, enabled2, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54) : function5;
                if (i10 != 0) {
                    $dirty = $dirty;
                    function7 = composableLambdaRememberComposableLambda3;
                    steps2 = 0;
                    function8 = composableLambdaRememberComposableLambda;
                    function6 = composableLambdaRememberComposableLambda2;
                    endInteractionSource3 = endInteractionSource2;
                    sliderColors = colors2;
                    modifier2 = modifier4;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                } else {
                    $dirty = $dirty;
                    steps2 = steps;
                    function6 = composableLambdaRememberComposableLambda2;
                    function7 = composableLambdaRememberComposableLambda3;
                    endInteractionSource3 = endInteractionSource2;
                    function8 = composableLambdaRememberComposableLambda;
                    modifier2 = modifier4;
                    sliderColors = colors2;
                    closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 64) != 0) {
                    enabled2 = enabled;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function2 = function0;
                    sliderColors = colors;
                    startInteractionSource2 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    function8 = function3;
                    function6 = function4;
                    function7 = function5;
                    steps2 = steps;
                    $dirty = (-3670017) & $dirty;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function2 = function0;
                    sliderColors = colors;
                    startInteractionSource2 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    function8 = function3;
                    function6 = function4;
                    function7 = function5;
                    steps2 = steps;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048796133, $dirty, $dirty1, "androidx.compose.material3.RangeSlider (Slider.kt:550)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -223507371, "CC(remember):Slider.kt#9igjgp");
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function14 = function7;
            boolean invalid$iv = (($dirty1 & 896) == 256) | ((((57344 & $dirty) ^ CpioConstants.C_ISBLK) > 16384 && $composer2.changed(closedFloatingPointRange3)) || ($dirty & CpioConstants.C_ISBLK) == 16384);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), steps2, function2, closedFloatingPointRange3);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            RangeSliderState state = (RangeSliderState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            state.setOnValueChangeFinished(function2);
            ComposerKt.sourceInformationMarkerStart($composer2, -223507060, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 112) == 32;
            closedFloatingPointRange4 = closedFloatingPointRange3;
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                        m2634invokeIf1S1O4(sliderRange.m2645unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-If1S1O4, reason: not valid java name */
                    public final void m2634invokeIf1S1O4(long it) {
                        function1.invoke(RangesKt.rangeTo(SliderRange.m2642getStartimpl(it), SliderRange.m2641getEndInclusiveimpl(it)));
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            state.setOnValueChange$material3_release((Function1) value$iv4);
            state.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
            state.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
            RangeSlider(state, modifier2, enabled2, null, startInteractionSource2, endInteractionSource3, function8, function6, function14, $composer2, (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (3670016 & ($dirty >> 9)) | (($dirty1 << 21) & 29360128) | (($dirty1 << 21) & 234881024), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            endInteractionSource4 = endInteractionSource3;
            function9 = function8;
            function10 = function6;
            steps3 = steps2;
            function11 = function2;
            startInteractionSource3 = startInteractionSource2;
            colors3 = sliderColors;
            function12 = function14;
            modifier3 = modifier2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled3;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRange4;
            final Function0<Unit> function15 = function11;
            final SliderColors sliderColors2 = colors3;
            final MutableInteractionSource mutableInteractionSource = startInteractionSource3;
            final MutableInteractionSource mutableInteractionSource2 = endInteractionSource4;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function16 = function9;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function17 = function10;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function18 = function12;
            final int i11 = steps3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.11
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
                    SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier5, z2, closedFloatingPointRange5, function15, sliderColors2, mutableInteractionSource, mutableInteractionSource2, function16, function17, function18, i11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void RangeSlider(final RangeSliderState state, Modifier modifier, boolean enabled, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function4, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function5, Composer $composer, final int $changed, final int i) {
        final MutableInteractionSource startInteractionSource2;
        final MutableInteractionSource endInteractionSource2;
        Modifier.Companion modifier2;
        final SliderColors colors2;
        boolean z;
        ComposableLambda composableLambdaRememberComposableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function7;
        boolean enabled2;
        SliderColors colors3;
        MutableInteractionSource startInteractionSource3;
        MutableInteractionSource endInteractionSource3;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        SliderColors colors4;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(511405654);
        ComposerKt.sourceInformation($composer2, "C(RangeSlider)P(7,4,1!1,5!1,6)631@27940L8,632@28005L39,633@28099L39,634@28197L162,641@28416L160,648@28630L175,658@28872L295:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= ((i & 8) == 0 && $composer2.changed(colors)) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            startInteractionSource2 = startInteractionSource;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            startInteractionSource2 = startInteractionSource;
            $dirty2 |= $composer2.changed(startInteractionSource2) ? 16384 : 8192;
        } else {
            startInteractionSource2 = startInteractionSource;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            endInteractionSource2 = endInteractionSource;
        } else if ((196608 & $changed) == 0) {
            endInteractionSource2 = endInteractionSource;
            $dirty2 |= $composer2.changed(endInteractionSource2) ? 131072 : 65536;
        } else {
            endInteractionSource2 = endInteractionSource;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled3 = enabled;
            colors4 = colors;
            function7 = function3;
            function6 = function4;
            function3RememberComposableLambda = function5;
            startInteractionSource3 = startInteractionSource2;
            endInteractionSource3 = endInteractionSource2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled4 = i3 != 0 ? true : enabled;
                if ((i & 8) != 0) {
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -7169;
                } else {
                    colors2 = colors;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -223503862, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    startInteractionSource2 = (MutableInteractionSource) value$iv2;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -223503768, "CC(remember):Slider.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    endInteractionSource2 = (MutableInteractionSource) value$iv;
                }
                if (i6 != 0) {
                    z = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1884205643, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.14
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                            invoke(rangeSliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C635@28222L131:Slider.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1884205643, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:635)");
                            }
                            SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(startInteractionSource2, null, colors2, enabled4, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                } else {
                    z = true;
                    composableLambdaRememberComposableLambda = function3;
                }
                ComposableLambda composableLambdaRememberComposableLambda2 = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(1016457138, z, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                        invoke(rangeSliderState, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C642@28441L129:Slider.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1016457138, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:642)");
                        }
                        SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(endInteractionSource2, null, colors2, enabled4, 0L, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54) : function4;
                if (i8 != 0) {
                    function6 = composableLambdaRememberComposableLambda2;
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1617375262, z, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.16
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                            invoke(rangeSliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C649@28675L124:Slider.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1617375262, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:649)");
                            }
                            SliderDefaults.INSTANCE.m2623TracknbWgWpA(rangeSliderState, (Modifier) null, enabled4, colors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, ($changed2 & 14) | 12582912, 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                    function7 = composableLambdaRememberComposableLambda;
                    enabled2 = enabled4;
                    colors3 = colors2;
                    startInteractionSource3 = startInteractionSource2;
                    endInteractionSource3 = endInteractionSource2;
                    $dirty = $dirty2;
                } else {
                    function3RememberComposableLambda = function5;
                    function6 = composableLambdaRememberComposableLambda2;
                    function7 = composableLambdaRememberComposableLambda;
                    enabled2 = enabled4;
                    colors3 = colors2;
                    startInteractionSource3 = startInteractionSource2;
                    endInteractionSource3 = endInteractionSource2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    modifier2 = modifier;
                    colors3 = colors;
                    function7 = function3;
                    function6 = function4;
                    function3RememberComposableLambda = function5;
                    startInteractionSource3 = startInteractionSource2;
                    endInteractionSource3 = endInteractionSource2;
                    $dirty = $dirty2 & (-7169);
                    enabled2 = enabled;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors3 = colors;
                    function7 = function3;
                    function6 = function4;
                    function3RememberComposableLambda = function5;
                    startInteractionSource3 = startInteractionSource2;
                    endInteractionSource3 = endInteractionSource2;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(511405654, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:655)");
            }
            if (!(state.getSteps() >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            RangeSliderImpl(modifier2, state, enabled2, startInteractionSource3, endInteractionSource3, function7, function6, function3RememberComposableLambda, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & 112) | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z2 = enabled3;
            final SliderColors sliderColors = colors4;
            final MutableInteractionSource mutableInteractionSource = startInteractionSource3;
            final MutableInteractionSource mutableInteractionSource2 = endInteractionSource3;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function8 = function7;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function9 = function6;
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function10 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSlider.18
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
                    SliderKt.RangeSlider(state, modifier3, z2, sliderColors, mutableInteractionSource, mutableInteractionSource2, function8, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderImpl(final Modifier modifier, final SliderState state, final boolean enabled, final MutableInteractionSource interactionSource, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        SliderKt$SliderImpl$drag$1$1 value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function2;
        Composer $composer2 = $composer.startRestartGroup(1390990089);
        ComposerKt.sourceInformation($composer2, "C(SliderImpl)P(2,3)680@29500L7,691@29858L28,718@30623L1298,696@29970L1951:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390990089, $dirty, -1, "androidx.compose.material3.SliderImpl (Slider.kt:679)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            state.setRtl$material3_release(objConsume == LayoutDirection.Rtl);
            Modifier press = sliderTapModifier(Modifier.INSTANCE, state, interactionSource, enabled);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsRtl$material3_release = state.getIsRtl();
            boolean zIsDragging$material3_release = state.isDragging$material3_release();
            Modifier.Companion companion2 = companion;
            SliderState sliderState = state;
            ComposerKt.sourceInformationMarkerStart($composer2, 1114013790, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(state);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SliderKt$SliderImpl$drag$1$1(state, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier drag = DraggableKt.draggable(companion2, sliderState, orientation, (188 & 4) != 0 ? true : enabled, (188 & 8) != 0 ? null : interactionSource, (188 & 16) != 0 ? false : zIsDragging$material3_release, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv, (188 & 128) != 0 ? false : zIsRtl$material3_release);
            Modifier modifier$iv = FocusableKt.focusable(sliderSemantics(SizeKt.m909requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null), state, enabled), enabled, interactionSource).then(press).then(drag);
            ComposerKt.sourceInformationMarkerStart($composer2, 1114014555, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(state);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (LayoutIdKt.getLayoutId(it) == SliderComponents.THUMB) {
                                final Placeable thumbPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(constraints);
                                List<? extends Measurable> list2 = list;
                                int index$iv$iv2 = 0;
                                int size2 = list2.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list2.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    List<? extends Measurable> list3 = list2;
                                    if (LayoutIdKt.getLayoutId(it2) == SliderComponents.TRACK) {
                                        long jM6764offsetNN6EwU$default = ConstraintsKt.m6764offsetNN6EwU$default(constraints, -thumbPlaceable.getWidth(), 0, 2, null);
                                        final Placeable trackPlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(jM6764offsetNN6EwU$default, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(jM6764offsetNN6EwU$default) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(jM6764offsetNN6EwU$default) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(jM6764offsetNN6EwU$default) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(jM6764offsetNN6EwU$default) : 0));
                                        int sliderWidth = thumbPlaceable.getWidth() + trackPlaceable.getWidth();
                                        int sliderHeight = Math.max(trackPlaceable.getHeight(), thumbPlaceable.getHeight());
                                        state.updateDimensions$material3_release(trackPlaceable.getHeight(), thumbPlaceable.getWidth(), sliderWidth);
                                        final int trackOffsetX = thumbPlaceable.getWidth() / 2;
                                        final int thumbOffsetX = MathKt.roundToInt(trackPlaceable.getWidth() * state.getCoercedValueAsFraction$material3_release());
                                        final int trackOffsetY = (sliderHeight - trackPlaceable.getHeight()) / 2;
                                        final int thumbOffsetY = (sliderHeight - thumbPlaceable.getHeight()) / 2;
                                        return MeasureScope.CC.layout$default($this$Layout, sliderWidth, sliderHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1.1
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
                                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                Placeable.PlacementScope.placeRelative$default($this$layout, trackPlaceable, trackOffsetX, trackOffsetY, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default($this$layout, thumbPlaceable, thumbOffsetX, thumbOffsetY, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                    index$iv$iv2++;
                                    list2 = list3;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1541261581, "C698@30000L102,701@30115L102:Slider.kt#uh7d8r");
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor2;
                $composer2.createNode(function1);
            } else {
                function1 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1819482118, "C699@30076L12:Slider.kt#uh7d8r");
            function3.invoke(state, $composer2, Integer.valueOf((($dirty >> 3) & 14) | (($dirty >> 9) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor3;
                $composer2.createNode(function2);
            } else {
                function2 = constructor3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1819482003, "C702@30191L12:Slider.kt#uh7d8r");
            function4.invoke(state, $composer2, Integer.valueOf((($dirty >> 3) & 14) | (($dirty >> 12) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.SliderImpl.3
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

                public final void invoke(Composer composer, int i6) {
                    SliderKt.SliderImpl(modifier, state, enabled, interactionSource, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState state, final boolean enabled, final MutableInteractionSource startInteractionSource, final MutableInteractionSource endInteractionSource, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function4, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function5, Composer $composer, final int $changed) {
        MeasurePolicy value$iv;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Object value$iv2;
        Function0<ComposeUiNode> function2;
        Function0<ComposeUiNode> function6;
        Composer $composer2 = $composer.startRestartGroup(-1411725677);
        ComposerKt.sourceInformation($composer2, "C(RangeSliderImpl)P(3,6!1,4!1,5)771@32396L7,783@32790L35,784@32858L33,815@34012L2445,786@32897L3560:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(startInteractionSource) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(endInteractionSource) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ((4793491 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, $dirty2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:770)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            state.setRtl$material3_release(objConsume == LayoutDirection.Rtl);
            Modifier pressDrag = rangeSliderPressDragModifier(Modifier.INSTANCE, state, startInteractionSource, endInteractionSource, enabled);
            Modifier startThumbSemantics = rangeSliderStartThumbSemantics(Modifier.INSTANCE, state, enabled);
            Modifier endThumbSemantics = rangeSliderEndThumbSemantics(Modifier.INSTANCE, state, enabled);
            Strings.Companion companion = Strings.INSTANCE;
            final String startContentDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1733R.string.range_start), $composer2, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String endContentDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1733R.string.range_end), $composer2, 0);
            Modifier modifier$iv = SizeKt.m909requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null).then(pressDrag);
            ComposerKt.sourceInformationMarkerStart($composer2, 1300547777, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(state);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        List<? extends Measurable> list2 = list;
                        int index$iv$iv = 0;
                        int size = list2.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = list2.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            List<? extends Measurable> list3 = list2;
                            if (LayoutIdKt.getLayoutId(it) == RangeSliderComponents.STARTTHUMB) {
                                final Placeable startThumbPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(constraints);
                                List<? extends Measurable> list4 = list;
                                int index$iv$iv2 = 0;
                                int size2 = list4.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list4.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    List<? extends Measurable> list5 = list4;
                                    if (LayoutIdKt.getLayoutId(it2) == RangeSliderComponents.ENDTHUMB) {
                                        final Placeable endThumbPlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(constraints);
                                        List<? extends Measurable> list6 = list;
                                        int index$iv$iv3 = 0;
                                        int size3 = list6.size();
                                        while (index$iv$iv3 < size3) {
                                            Object item$iv$iv3 = list6.get(index$iv$iv3);
                                            Measurable it3 = (Measurable) item$iv$iv3;
                                            List<? extends Measurable> list7 = list6;
                                            if (!(LayoutIdKt.getLayoutId(it3) == RangeSliderComponents.TRACK)) {
                                                index$iv$iv3++;
                                                list6 = list7;
                                            } else {
                                                Measurable measurable = (Measurable) item$iv$iv3;
                                                long jM6764offsetNN6EwU$default = ConstraintsKt.m6764offsetNN6EwU$default(constraints, (-(startThumbPlaceable.getWidth() + endThumbPlaceable.getWidth())) / 2, 0, 2, null);
                                                final Placeable trackPlaceable = measurable.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(jM6764offsetNN6EwU$default, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(jM6764offsetNN6EwU$default) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(jM6764offsetNN6EwU$default) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(jM6764offsetNN6EwU$default) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(jM6764offsetNN6EwU$default) : 0));
                                                int sliderWidth = trackPlaceable.getWidth() + ((startThumbPlaceable.getWidth() + endThumbPlaceable.getWidth()) / 2);
                                                int sliderHeight = Math.max(trackPlaceable.getHeight(), Math.max(startThumbPlaceable.getHeight(), endThumbPlaceable.getHeight()));
                                                state.setTrackHeight$material3_release(trackPlaceable.getHeight());
                                                state.setStartThumbWidth$material3_release(startThumbPlaceable.getWidth());
                                                state.setEndThumbWidth$material3_release(endThumbPlaceable.getWidth());
                                                state.setTotalWidth$material3_release(sliderWidth);
                                                state.updateMinMaxPx$material3_release();
                                                final int trackOffsetX = startThumbPlaceable.getWidth() / 2;
                                                final int startThumbOffsetX = MathKt.roundToInt(trackPlaceable.getWidth() * state.getCoercedActiveRangeStartAsFraction$material3_release());
                                                int endCorrection = (startThumbPlaceable.getWidth() - endThumbPlaceable.getWidth()) / 2;
                                                final int endThumbOffsetX = MathKt.roundToInt((trackPlaceable.getWidth() * state.getCoercedActiveRangeEndAsFraction$material3_release()) + endCorrection);
                                                final int trackOffsetY = (sliderHeight - trackPlaceable.getHeight()) / 2;
                                                final int startThumbOffsetY = (sliderHeight - startThumbPlaceable.getHeight()) / 2;
                                                final int endThumbOffsetY = (sliderHeight - endThumbPlaceable.getHeight()) / 2;
                                                return MeasureScope.CC.layout$default($this$Layout, sliderWidth, sliderHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1.1
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
                                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, trackPlaceable, trackOffsetX, trackOffsetY, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, startThumbPlaceable, startThumbOffsetX, startThumbOffsetY, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, endThumbPlaceable, endThumbOffsetX, endThumbOffsetY, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    index$iv$iv2++;
                                    list4 = list5;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            index$iv$iv++;
                            list2 = list3;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2040260827, "C790@33063L84,788@32927L359,798@33433L82,796@33299L349,804@33661L107:Slider.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.STARTTHUMB);
            ComposerKt.sourceInformationMarkerStart($composer2, -2040260691, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(startContentDescription);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
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
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierLayoutId, true, (Function1) value$iv3), enabled, startInteractionSource).then(startThumbSemantics);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor2;
                $composer2.createNode(function1);
            } else {
                function1 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1631551898, "C795@33267L17:Slider.kt#uh7d8r");
            function3.invoke(state, $composer2, Integer.valueOf((($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.ENDTHUMB);
            ComposerKt.sourceInformationMarkerStart($composer2, -2040260321, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(endContentDescription);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1
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
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv3 = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierLayoutId2, true, (Function1) value$iv2), enabled, endInteractionSource).then(endThumbSemantics);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor3;
                $composer2.createNode(function2);
            } else {
                function2 = constructor3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1631552262, "C803@33631L15:Slider.kt#uh7d8r");
            function4.invoke(state, $composer2, Integer.valueOf((($dirty2 >> 3) & 14) | (($dirty2 >> 15) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function6 = constructor4;
                $composer2.createNode(function6);
            } else {
                function6 = constructor4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i7 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1631552373, "C805@33742L12:Slider.kt#uh7d8r");
            function5.invoke(state, $composer2, Integer.valueOf((($dirty2 >> 3) & 14) | (($dirty2 >> 18) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt.RangeSliderImpl.3
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
                    SliderKt.RangeSliderImpl(modifier, state, enabled, startInteractionSource, endInteractionSource, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.collections.IntIterator] */
    public static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        Float fValueOf;
        if (tickFractions.length == 0) {
            fValueOf = null;
        } else {
            float minElem$iv = tickFractions[0];
            int lastIndex$iv = ArraysKt.getLastIndex(tickFractions);
            if (lastIndex$iv == 0) {
                fValueOf = Float.valueOf(minElem$iv);
            } else {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, minElem$iv) - current);
                ?? it = new IntRange(1, lastIndex$iv).iterator();
                while (it.hasNext()) {
                    int i$iv = it.nextInt();
                    float e$iv = tickFractions[i$iv];
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, e$iv) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                }
                fValueOf = Float.valueOf(minElem$iv);
            }
        }
        if (fValueOf == null) {
            return current;
        }
        float $this$snapValueToTick_u24lambda_u2427 = fValueOf.floatValue();
        return MathHelpersKt.lerp(minPx, maxPx, $this$snapValueToTick_u24lambda_u2427);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    public static final Object m2630awaitSlop8vUncbI(AwaitPointerEventScope $this$awaitSlop_u2d8vUncbI, long id, int type, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        final Ref.FloatRef initialDelta;
        Object objM3005awaitHorizontalPointerSlopOrCancellationgDDlDlE;
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
                Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
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
                objM3005awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m3005awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitSlop_u2d8vUncbI, id, type, function2, sliderKt$awaitSlop$2);
                if (objM3005awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                initialDelta = (Ref.FloatRef) sliderKt$awaitSlop$2.L$0;
                ResultKt.throwOnFailure($result);
                objM3005awaitHorizontalPointerSlopOrCancellationgDDlDlE = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerInputChange afterSlopResult = (PointerInputChange) objM3005awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        if (afterSlopResult != null) {
            return TuplesKt.m202to(afterSlopResult, Boxing.boxFloat(initialDelta.element));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int steps) {
        if (steps == 0) {
            return new float[0];
        }
        int i = steps + 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = i2 / (steps + 1);
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: scale-ziovWd0, reason: not valid java name */
    public static final long m2633scaleziovWd0(float a1, float b1, long x, float a2, float b2) {
        return SliderRange(scale(a1, b1, SliderRange.m2642getStartimpl(x), a2, b2), scale(a1, b1, SliderRange.m2641getEndInclusiveimpl(x), a2, b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier $this$sliderSemantics, final SliderState state, final boolean enabled) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1
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
                if (!enabled) {
                    SemanticsPropertiesKt.disabled($this$semantics);
                }
                final SliderState sliderState = state;
                SemanticsPropertiesKt.setProgress$default($this$semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue());
                        boolean z = true;
                        if (sliderState.getSteps() > 0) {
                            float distance = newValue;
                            int i = 0;
                            int steps = sliderState.getSteps() + 1;
                            if (0 <= steps) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue(), i / (sliderState.getSteps() + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i == steps) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == sliderState.getValue()) {
                            z = false;
                        } else {
                            if (!(resolvedValue == sliderState.getValue())) {
                                if (sliderState.getOnValueChange$material3_release() != null) {
                                    Function1<Float, Unit> onValueChange$material3_release = sliderState.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(Float.valueOf(resolvedValue));
                                    }
                                } else {
                                    sliderState.setValue(resolvedValue);
                                }
                            }
                            Function0<Unit> onValueChangeFinished = sliderState.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), state.getValue(), RangesKt.rangeTo(state.getValueRange().getStart().floatValue(), state.getValueRange().getEndInclusive().floatValue()), state.getSteps());
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier $this$rangeSliderStartThumbSemantics, final RangeSliderState state, final boolean enabled) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(state.getValueRange().getStart().floatValue(), state.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$rangeSliderStartThumbSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt.rangeSliderStartThumbSemantics.1
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
                if (!enabled) {
                    SemanticsPropertiesKt.disabled($this$semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = closedFloatingPointRangeRangeTo;
                final RangeSliderState rangeSliderState = state;
                SemanticsPropertiesKt.setProgress$default($this$semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt.rangeSliderStartThumbSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                        boolean z = true;
                        if (rangeSliderState.getStartSteps$material3_release() > 0) {
                            float distance = newValue;
                            int i = 0;
                            int startSteps$material3_release = rangeSliderState.getStartSteps$material3_release() + 1;
                            if (0 <= startSteps$material3_release) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i / (rangeSliderState.getStartSteps$material3_release() + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i == startSteps$material3_release) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == rangeSliderState.getActiveRangeStart()) {
                            z = false;
                        } else {
                            long resolvedRange = SliderKt.SliderRange(resolvedValue, rangeSliderState.getActiveRangeEnd());
                            long activeRange = SliderKt.SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd());
                            if (!SliderRange.m2640equalsimpl0(resolvedRange, activeRange)) {
                                if (rangeSliderState.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2637boximpl(resolvedRange));
                                    }
                                } else {
                                    rangeSliderState.setActiveRangeStart(SliderRange.m2642getStartimpl(resolvedRange));
                                    rangeSliderState.setActiveRangeEnd(SliderRange.m2641getEndInclusiveimpl(resolvedRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), state.getActiveRangeStart(), closedFloatingPointRangeRangeTo, state.getStartSteps$material3_release());
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier $this$rangeSliderEndThumbSemantics, final RangeSliderState state, final boolean enabled) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(state.getActiveRangeStart(), state.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$rangeSliderEndThumbSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt.rangeSliderEndThumbSemantics.1
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
                if (!enabled) {
                    SemanticsPropertiesKt.disabled($this$semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = closedFloatingPointRangeRangeTo;
                final RangeSliderState rangeSliderState = state;
                SemanticsPropertiesKt.setProgress$default($this$semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt.rangeSliderEndThumbSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                        boolean z = true;
                        if (rangeSliderState.getEndSteps$material3_release() > 0) {
                            float distance = newValue;
                            int i = 0;
                            int endSteps$material3_release = rangeSliderState.getEndSteps$material3_release() + 1;
                            if (0 <= endSteps$material3_release) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i / (rangeSliderState.getEndSteps$material3_release() + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i == endSteps$material3_release) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == rangeSliderState.getActiveRangeEnd()) {
                            z = false;
                        } else {
                            long resolvedRange = SliderKt.SliderRange(rangeSliderState.getActiveRangeStart(), resolvedValue);
                            long activeRange = SliderKt.SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd());
                            if (!SliderRange.m2640equalsimpl0(resolvedRange, activeRange)) {
                                if (rangeSliderState.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2637boximpl(resolvedRange));
                                    }
                                } else {
                                    rangeSliderState.setActiveRangeStart(SliderRange.m2642getStartimpl(resolvedRange));
                                    rangeSliderState.setActiveRangeEnd(SliderRange.m2641getEndInclusiveimpl(resolvedRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), state.getActiveRangeEnd(), closedFloatingPointRangeRangeTo, state.getEndSteps$material3_release());
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$sliderTapModifier$1", m210f = "Slider.kt", m211i = {}, m212l = {1698}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C15231 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SliderState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15231(SliderState sliderState, Continuation<? super C15231> continuation) {
            super(2, continuation);
            this.$state = sliderState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15231 c15231 = new C15231(this.$state, continuation);
            c15231.L$0 = obj;
            return c15231;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C15231) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, null);
                    final SliderState sliderState = this.$state;
                    Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m2636invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m2636invokek4lQ0M(long it) {
                            sliderState.dispatchRawDelta(0.0f);
                            sliderState.getGestureEndAction$material3_release().invoke();
                        }
                    };
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures($this$pointerInput, (7 & 1) != 0 ? null : null, (7 & 2) != 0 ? null : null, (7 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : anonymousClass1, (7 & 8) != 0 ? null : function1, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", m210f = "Slider.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ SliderState $state;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SliderState sliderState, Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
                this.$state = sliderState;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                return m2635invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m2635invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, continuation);
                anonymousClass1.J$0 = j;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        long it = this.J$0;
                        this.$state.m2648onPressk4lQ0M$material3_release(it);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, SliderState state, MutableInteractionSource interactionSource, boolean enabled) {
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput($this$sliderTapModifier, state, interactionSource, new C15231(state, null));
        }
        return $this$sliderTapModifier;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1 */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", m210f = "Slider.kt", m211i = {}, m212l = {1725}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C15191 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ RangeSliderState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15191(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Continuation<? super C15191> continuation) {
            super(2, continuation);
            this.$state = rangeSliderState;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15191 c15191 = new C15191(this.$state, this.$startInteractionSource, this.$endInteractionSource, continuation);
            c15191.L$0 = obj;
            return c15191;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C15191) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$state, this.$startInteractionSource, this.$endInteractionSource);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$pointerInput, this.$state, rangeSliderLogic, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", m210f = "Slider.kt", m211i = {}, m212l = {1726}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ RangeSliderState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = rangeSliderState;
                this.$rangeSliderLogic = rangeSliderLogic;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, this.$rangeSliderLogic, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", m210f = "Slider.kt", m211i = {0, 1, 1, 1, 1, 1, 2, 2}, m212l = {1727, 1738, 1757}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, Route.INTERACTION, "posX", "draggingStart", Route.INTERACTION, "draggingStart"}, m215s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
            static final class C45751 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ RangeSliderState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C45751(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation<? super C45751> continuation) {
                    super(2, continuation);
                    this.$state = rangeSliderState;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C45751 c45751 = new C45751(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, continuation);
                    c45751.L$0 = obj;
                    return c45751;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C45751) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:19:0x008f  */
                /* JADX WARN: Code duplicated, block: B:20:0x00a0  */
                /* JADX WARN: Code duplicated, block: B:23:0x00b9 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:24:0x00bb  */
                /* JADX WARN: Code duplicated, block: B:25:0x00bd  */
                /* JADX WARN: Code duplicated, block: B:26:0x00bf  */
                /* JADX WARN: Code duplicated, block: B:28:0x00cb  */
                /* JADX WARN: Code duplicated, block: B:29:0x00cd  */
                /* JADX WARN: Code duplicated, block: B:32:0x00ee A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:33:0x00ef  */
                /* JADX WARN: Code duplicated, block: B:36:0x00f7  */
                /* JADX WARN: Code duplicated, block: B:38:0x0115  */
                /* JADX WARN: Code duplicated, block: B:41:0x0126  */
                /* JADX WARN: Code duplicated, block: B:44:0x012a  */
                /* JADX WARN: Code duplicated, block: B:46:0x013b  */
                /* JADX WARN: Code duplicated, block: B:49:0x0140  */
                /* JADX WARN: Code duplicated, block: B:58:0x0190 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:59:0x0191  */
                /* JADX WARN: Code duplicated, block: B:62:0x01a0 A[Catch: CancellationException -> 0x01b1, TryCatch #0 {CancellationException -> 0x01b1, blocks: (B:60:0x0197, B:62:0x01a0, B:63:0x01a8), top: B:73:0x0197 }] */
                /* JADX WARN: Code duplicated, block: B:63:0x01a8 A[Catch: CancellationException -> 0x01b1, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x01b1, blocks: (B:60:0x0197, B:62:0x01a0, B:63:0x01a8), top: B:73:0x0197 }] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    C45751 c45751;
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
                    Object objM2630awaitSlop8vUncbI;
                    DragInteraction.Start interaction2;
                    Object $result4;
                    Object $result5;
                    final Ref.BooleanRef draggingStart2;
                    Pair it;
                    Ref.BooleanRef draggingStart3;
                    DragInteraction.Start interaction3;
                    Object objM614horizontalDragjO51t88;
                    Object $result6;
                    RangeSliderState rangeSliderState;
                    float slop;
                    boolean shouldUpdateCapturedThumb;
                    DragInteraction.Cancel finishInteraction;
                    boolean success;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            c45751 = this;
                            AwaitPointerEventScope $this$awaitEachGesture2 = (AwaitPointerEventScope) c45751.L$0;
                            c45751.L$0 = $this$awaitEachGesture2;
                            c45751.label = 1;
                            Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture2, false, null, c45751, 2, null);
                            if (objAwaitFirstDown$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$awaitEachGesture = $this$awaitEachGesture2;
                            $result2 = $result;
                            $result3 = objAwaitFirstDown$default;
                            event = (PointerInputChange) $result3;
                            interaction = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            if (c45751.$state.isRtl$material3_release()) {
                                fM4049getXimpl = c45751.$state.getTotalWidth$material3_release() - Offset.m4049getXimpl(event.getPosition());
                            } else {
                                fM4049getXimpl = Offset.m4049getXimpl(event.getPosition());
                            }
                            posX.element = fM4049getXimpl;
                            compare = c45751.$rangeSliderLogic.compareOffsets(posX.element);
                            draggingStart = new Ref.BooleanRef();
                            if (compare != 0) {
                                if (compare < 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if (c45751.$state.getRawOffsetStart$material3_release() > posX.element) {
                                z = true;
                            } else {
                                z = false;
                            }
                            draggingStart.element = z;
                            c45751.L$0 = $this$awaitEachGesture;
                            c45751.L$1 = event;
                            c45751.L$2 = interaction;
                            c45751.L$3 = posX;
                            c45751.L$4 = draggingStart;
                            c45751.label = 2;
                            objM2630awaitSlop8vUncbI = SliderKt.m2630awaitSlop8vUncbI($this$awaitEachGesture, event.getId(), event.getType(), c45751);
                            if (objM2630awaitSlop8vUncbI == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction2 = interaction;
                            $result4 = objM2630awaitSlop8vUncbI;
                            $result5 = $result2;
                            draggingStart2 = draggingStart;
                            it = (Pair) $result4;
                            if (it != null) {
                                rangeSliderState = c45751.$state;
                                slop = DragGestureDetectorCopyKt.m3008pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(rangeSliderState.getRawOffsetEnd$material3_release() - posX.element) < slop || Math.abs(rangeSliderState.getRawOffsetStart$material3_release() - posX.element) >= slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = true;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = rangeSliderState.isRtl$material3_release() ? dir < 0.0f : dir >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45751.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45751.$$this$coroutineScope);
                            try {
                                long id = event.getId();
                                final RangeSliderState rangeSliderState2 = c45751.$state;
                                c45751.L$0 = interaction2;
                                c45751.L$1 = draggingStart2;
                                c45751.L$2 = null;
                                c45751.L$3 = null;
                                c45751.L$4 = null;
                                c45751.label = 3;
                                objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        rangeSliderState2.onDrag$material3_release(draggingStart2.element, rangeSliderState2.isRtl$material3_release() ? -deltaX : deltaX);
                                    }
                                }, c45751);
                                if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                interaction3 = interaction2;
                                $result6 = $result5;
                                $result5 = objM614horizontalDragjO51t88;
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
                                    draggingStart3 = draggingStart2;
                                    finishInteraction = new DragInteraction.Cancel(interaction3);
                                    draggingStart2 = draggingStart3;
                                }
                                c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            } catch (CancellationException e2) {
                                draggingStart3 = draggingStart2;
                                interaction3 = interaction2;
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                                draggingStart2 = draggingStart3;
                                c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                        case 1:
                            c45751 = this;
                            $result3 = $result;
                            AwaitPointerEventScope $this$awaitEachGesture3 = (AwaitPointerEventScope) c45751.L$0;
                            ResultKt.throwOnFailure($result3);
                            $this$awaitEachGesture = $this$awaitEachGesture3;
                            $result2 = $result3;
                            event = (PointerInputChange) $result3;
                            interaction = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            if (c45751.$state.isRtl$material3_release()) {
                                fM4049getXimpl = c45751.$state.getTotalWidth$material3_release() - Offset.m4049getXimpl(event.getPosition());
                            } else {
                                fM4049getXimpl = Offset.m4049getXimpl(event.getPosition());
                            }
                            posX.element = fM4049getXimpl;
                            compare = c45751.$rangeSliderLogic.compareOffsets(posX.element);
                            draggingStart = new Ref.BooleanRef();
                            if (compare != 0) {
                                if (compare < 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if (c45751.$state.getRawOffsetStart$material3_release() > posX.element) {
                                z = true;
                            } else {
                                z = false;
                            }
                            draggingStart.element = z;
                            c45751.L$0 = $this$awaitEachGesture;
                            c45751.L$1 = event;
                            c45751.L$2 = interaction;
                            c45751.L$3 = posX;
                            c45751.L$4 = draggingStart;
                            c45751.label = 2;
                            objM2630awaitSlop8vUncbI = SliderKt.m2630awaitSlop8vUncbI($this$awaitEachGesture, event.getId(), event.getType(), c45751);
                            if (objM2630awaitSlop8vUncbI == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction2 = interaction;
                            $result4 = objM2630awaitSlop8vUncbI;
                            $result5 = $result2;
                            draggingStart2 = draggingStart;
                            it = (Pair) $result4;
                            if (it != null) {
                                rangeSliderState = c45751.$state;
                                slop = DragGestureDetectorCopyKt.m3008pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(rangeSliderState.getRawOffsetEnd$material3_release() - posX.element) < slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = false;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir2 = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = rangeSliderState.isRtl$material3_release() ? dir2 < 0.0f : dir2 >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45751.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45751.$$this$coroutineScope);
                            long id2 = event.getId();
                            final RangeSliderState rangeSliderState3 = c45751.$state;
                            c45751.L$0 = interaction2;
                            c45751.L$1 = draggingStart2;
                            c45751.L$2 = null;
                            c45751.L$3 = null;
                            c45751.L$4 = null;
                            c45751.label = 3;
                            objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    rangeSliderState3.onDrag$material3_release(draggingStart2.element, rangeSliderState3.isRtl$material3_release() ? -deltaX : deltaX);
                                }
                            }, c45751);
                            if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction3 = interaction2;
                            $result6 = $result5;
                            $result5 = objM614horizontalDragjO51t88;
                            success = ((Boolean) $result5).booleanValue();
                            if (success) {
                                finishInteraction = new DragInteraction.Stop(interaction3);
                            } else {
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                            }
                            c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                            BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        case 2:
                            c45751 = this;
                            $result4 = $result;
                            draggingStart2 = (Ref.BooleanRef) c45751.L$4;
                            posX = (Ref.FloatRef) c45751.L$3;
                            interaction2 = (DragInteraction.Start) c45751.L$2;
                            event = (PointerInputChange) c45751.L$1;
                            $this$awaitEachGesture = (AwaitPointerEventScope) c45751.L$0;
                            ResultKt.throwOnFailure($result4);
                            $result5 = $result4;
                            it = (Pair) $result4;
                            if (it != null) {
                                rangeSliderState = c45751.$state;
                                slop = DragGestureDetectorCopyKt.m3008pointerSlopE8SPZFQ($this$awaitEachGesture.getViewConfiguration(), event.getType());
                                if (Math.abs(rangeSliderState.getRawOffsetEnd$material3_release() - posX.element) < slop) {
                                    shouldUpdateCapturedThumb = false;
                                } else {
                                    shouldUpdateCapturedThumb = false;
                                }
                                if (shouldUpdateCapturedThumb) {
                                    float dir3 = ((Number) it.getSecond()).floatValue();
                                    draggingStart2.element = rangeSliderState.isRtl$material3_release() ? dir3 < 0.0f : dir3 >= 0.0f;
                                    posX.element += Offset.m4049getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c45751.$rangeSliderLogic.captureThumb(draggingStart2.element, posX.element, interaction2, c45751.$$this$coroutineScope);
                            long id3 = event.getId();
                            final RangeSliderState rangeSliderState4 = c45751.$state;
                            c45751.L$0 = interaction2;
                            c45751.L$1 = draggingStart2;
                            c45751.L$2 = null;
                            c45751.L$3 = null;
                            c45751.L$4 = null;
                            c45751.label = 3;
                            objM614horizontalDragjO51t88 = DragGestureDetectorKt.m614horizontalDragjO51t88($this$awaitEachGesture, id3, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    rangeSliderState4.onDrag$material3_release(draggingStart2.element, rangeSliderState4.isRtl$material3_release() ? -deltaX : deltaX);
                                }
                            }, c45751);
                            if (objM614horizontalDragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction3 = interaction2;
                            $result6 = $result5;
                            $result5 = objM614horizontalDragjO51t88;
                            success = ((Boolean) $result5).booleanValue();
                            if (success) {
                                finishInteraction = new DragInteraction.Stop(interaction3);
                            } else {
                                finishInteraction = new DragInteraction.Cancel(interaction3);
                            }
                            c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                            BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        case 3:
                            c45751 = this;
                            $result5 = $result;
                            draggingStart3 = (Ref.BooleanRef) c45751.L$1;
                            interaction3 = (DragInteraction.Start) c45751.L$0;
                            try {
                                ResultKt.throwOnFailure($result5);
                                draggingStart2 = draggingStart3;
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
                                draggingStart2 = draggingStart3;
                                c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            c45751.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(draggingStart2.element));
                            BuildersKt__Builders_commonKt.launch$default(c45751.$$this$coroutineScope, null, null, new AnonymousClass2(c45751.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", m210f = "Slider.kt", m211i = {}, m212l = {1774}, m213m = "invokeSuspend", m214n = {}, m215s = {})
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
                        if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C45751(this.$state, this.$rangeSliderLogic, $this$coroutineScope, null), this) == coroutine_suspended) {
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

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, RangeSliderState state, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, boolean enabled) {
        return enabled ? SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, state}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C15191(state, startInteractionSource, endInteractionSource, null)) : $this$rangeSliderPressDragModifier;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final long SliderRange(float start, float endInclusive) {
        boolean z = true;
        boolean isUnspecified = Float.isNaN(start) && Float.isNaN(endInclusive);
        if (!isUnspecified && start > ((double) endInclusive) + SliderRangeTolerance) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("start(" + start + ") must be <= endInclusive(" + endInclusive + ')').toString());
        }
        long v1$iv = Float.floatToRawIntBits(start);
        long v2$iv = Float.floatToRawIntBits(endInclusive);
        return SliderRange.m2638constructorimpl((v1$iv << 32) | (4294967295L & v2$iv));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float start = closedFloatingPointRange.getStart().floatValue();
        float endInclusive = closedFloatingPointRange.getEndInclusive().floatValue();
        boolean z = true;
        boolean isUnspecified = Float.isNaN(start) && Float.isNaN(endInclusive);
        if (!isUnspecified && start > ((double) endInclusive) + SliderRangeTolerance) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + start + ") must be <= ClosedFloatingPoint.endInclusive(" + endInclusive + ')').toString());
        }
        long v1$iv = Float.floatToRawIntBits(start);
        long v2$iv = Float.floatToRawIntBits(endInclusive);
        return SliderRange.m2638constructorimpl((v1$iv << 32) | (4294967295L & v2$iv));
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m2631isSpecifiedIf1S1O4(long $this$isSpecified) {
        return $this$isSpecified != SliderRange.INSTANCE.m2647getUnspecifiedFYbKRX4();
    }
}
